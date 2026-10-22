package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.chatroom.event.KtvRoomLyricsStateEventType;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.utils.c0;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.base.sei.q;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.util.r;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.k;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.y;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import mb0.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Ö\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002×\u0001B'\u0012\b\u0010Á\u0001\u001a\u00030À\u0001\u0012\b\u0010Æ\u0001\u001a\u00030Å\u0001\u0012\b\u0010Ë\u0001\u001a\u00030Ê\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u0014\u001a\u00020\u00072\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J&\u0010\u001f\u001a\u00020\u00072\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u001cj\u0002`\u001dH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0007H\u0014J0\u0010+\u001a\u00020\u00072\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\t0'j\b\u0012\u0004\u0012\u00020\t`(2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0005H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u00100\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u00020/H\u0004J\b\u00104\u001a\u000203H\u0014J\b\u00106\u001a\u0004\u0018\u000105J\"\u00108\u001a\u00020\u00072\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000eH\u0014J\b\u00109\u001a\u0004\u0018\u00010\u000fJ \u0010:\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012J\u0014\u0010>\u001a\u00020\u00072\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;J\u0012\u0010A\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010?\u001a\u00020\u0005J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020/H\u0004J\u0018\u0010G\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\tH\u0016J<\u0010M\u001a\u00020\u00072\u0006\u0010I\u001a\u00020H2\"\u0010K\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u00120J2\u0006\u0010L\u001a\u00020\u0005H\u0016J*\u0010N\u001a\u00020\u00072\"\u0010K\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u00120JJ$\u0010R\u001a\u00020\u00072\u0006\u0010O\u001a\u00020H2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070PH\u0016J$\u0010T\u001a\u00020\u00072\u0006\u0010O\u001a\u00020H2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00070PH\u0016J\b\u0010U\u001a\u00020\u0007H\u0014J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010X\u001a\u00020WH\u0004J\b\u0010Z\u001a\u00020\u000fH\u0016J\b\u0010[\u001a\u00020\u0005H\u0016J\b\u0010\\\u001a\u00020\u0005H\u0016J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010^\u001a\u00020\u0007H\u0016J\u0016\u0010b\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\t2\u0006\u0010a\u001a\u00020`J\b\u0010c\u001a\u00020\u0007H\u0016R\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR2\u0010n\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000ej\u0002`\u00120m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR8\u0010r\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110pj\u0002`q8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR*\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010y0x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001Rc\u0010\u0098\u0001\u001a<\u0012\u0015\u0012\u00130\t¢\u0006\u000e\b\u0095\u0001\u0012\t\b\u0096\u0001\u0012\u0004\b\b(\n\u0012\u0018\u0012\u0016\u0018\u00010<¢\u0006\u000f\b\u0095\u0001\u0012\n\b\u0096\u0001\u0012\u0005\b\b(\u0097\u0001\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0094\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R+\u0010\u009e\u0001\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R&\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00010y8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R+\u0010©\u0001\u001a\u0004\u0018\u00010#8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u001e\u0010¯\u0001\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\u000f\n\u0005\b¯\u0001\u0010l\u001a\u0006\b°\u0001\u0010±\u0001RC\u0010²\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cj\u0004\u0018\u0001`\u001d8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001RC\u0010¸\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000ej\u0004\u0018\u0001`\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R \u0010Á\u0001\u001a\u00030À\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R \u0010Æ\u0001\u001a\u00030Å\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u001d\u0010Ë\u0001\u001a\u00030Ê\u00018\u0006¢\u0006\u0010\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ñ\u0001\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u0017\u0010Ò\u0001\u001a\u00020\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "", "isSinger", "", "handleCurrentUserSingerRoleChange", "", LocationMonitorConst.TAG, "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/e;", "coreListener", "notifyByTag", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "transition", "notifyStateChange", "event", "sendKtvRoomLyricsStateEvent", BaseCoreViewModel.CORE_TAG_EFFECT, "notifyEffectChange", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "dataModel", "notifyDataModelChange", "Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/LyricsStateTransition;", "it", "listener", "doClearOnCloseKtv", BaseCoreViewModel.CORE_TAG_STATE, "onStateEnter", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "filterMySei", "useSeiDataOfFeedForwardLoadLyric", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "tags", "notifyWhenRegister", "registerKtvCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/k;", "initAnchorController", "unregisterKtvCoreListener", "", "obtainCurMusicProgress", "progress", "notifyProgressChange", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/c;", "getListenerController", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "getCurrentMusicFromState", "valid", "tryNotifyProgress", "getFromSate", "getCurrentTransition", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "list", "updateKtvOrderedSongList", "isKtvMode", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "getOrderedSongDataContext", "", "action", "musicId", "updateSingerState", "source", "sendEvent", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "observer", "isNotifyWhenObserve", "observeState", "removeStateObserver", "lifecycleOwner", "Lkotlin/Function1;", "handler", "observerOnProgress", "Lub0/a;", "observerOnLyricsChange", "onCleared", "onSeiResult", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "sei", "setRoomInfoForVote", "getState", "inOnSing", "isPaused", "accept", "reset", "key", "Lorg/json/JSONObject;", "data", "sendSei", "clearData", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/a;", "seiHandleInterceptor", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/a;", "getSeiHandleInterceptor", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/a;", "setSeiHandleInterceptor", "(Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/a;)V", "currentUid", "Ljava/lang/String;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "mValid", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/live/core/utils/StateMachine;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/LyricsStateMachine;", "stateMachine", "Lcom/bytedance/android/live/core/utils/StateMachine;", "getStateMachine", "()Lcom/bytedance/android/live/core/utils/StateMachine;", "setStateMachine", "(Lcom/bytedance/android/live/core/utils/StateMachine;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerListMap", "Ljava/util/concurrent/ConcurrentHashMap;", "mDataModel", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "mLastEffect", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/r;", "singPathMonitor", "Lcom/bytedance/android/livesdk/ktvimpl/base/util/r;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "listenerLyricsHelper", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "getListenerLyricsHelper", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "setListenerLyricsHelper", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/live/liveinteract/plantform/utils/d0;", "liveStreamInfoSenderManager", "Lcom/bytedance/android/live/liveinteract/plantform/utils/d0;", "getLiveStreamInfoSenderManager", "()Lcom/bytedance/android/live/liveinteract/plantform/utils/d0;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "musicPanel", "stateMachineFinishCB", "Lkotlin/jvm/functions/Function2;", "getStateMachineFinishCB", "()Lkotlin/jvm/functions/Function2;", "setStateMachineFinishCB", "(Lkotlin/jvm/functions/Function2;)V", "anchorController", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/k;", "getAnchorController", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/k;", "setAnchorController", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/k;)V", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/a;", "ktvRoomSeiModelHandlers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getKtvRoomSeiModelHandlers", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "seiParseResult", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "getSeiParseResult", "()Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "setSeiParseResult", "(Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;)V", "currentUserId", "getCurrentUserId", "()Ljava/lang/String;", "lastInvalidTransition", "Lcom/bytedance/android/live/core/utils/StateMachine$c;", "getLastInvalidTransition", "()Lcom/bytedance/android/live/core/utils/StateMachine$c;", "setLastInvalidTransition", "(Lcom/bytedance/android/live/core/utils/StateMachine$c;)V", "lastvalidTransition", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "getLastvalidTransition", "()Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "setLastvalidTransition", "(Lcom/bytedance/android/live/core/utils/StateMachine$c$b;)V", "lastIsSinger", "Ljava/lang/Boolean;", "Loe2/b;", "ktvRoomProvider", "Loe2/b;", "getKtvRoomProvider", "()Loe2/b;", "Lsb0/b;", "dataEntity", "Lsb0/b;", "getDataEntity", "()Lsb0/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getCurState", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "curState", "isAnchor", "()Z", "<init>", "(Loe2/b;Lsb0/b;Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", "Companion", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseCoreViewModel extends ViewModel implements com.bytedance.android.livesdk.ktvimpl.base.sei.b, com.bytedance.android.livesdk.ktvimpl.base.sei.c, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c {
    public static final String CORE_TAG_DATA_MODEL = "core_data_model";
    public static final String CORE_TAG_EFFECT = "effect";
    public static final String CORE_TAG_PROGRESS = "sing_progress";
    public static final String CORE_TAG_STATE = "state";
    public static final b Companion = null;
    private static final double EPSILON = 1.0E-6d;
    public static final String TAG = "KtvCoreViewModel";
    private k anchorController;
    private final CompositeDisposable compositeDisposable;
    private String currentUid;
    private final String currentUserId;
    private final sb0.b dataEntity;
    private final KtvContext ktvContext;
    private final oe2.b ktvRoomProvider;
    private final CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> ktvRoomSeiModelHandlers;
    private StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> lastInvalidTransition;
    private Boolean lastIsSinger;
    private StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> lastvalidTransition;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e>> listenerListMap;
    private h listenerLyricsHelper;
    private final d0 liveStreamInfoSenderManager;
    private com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d mDataModel;
    private KtvRoomLyricsStateMachineConfig.b mLastEffect;
    private NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> mValid;
    private com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a seiHandleInterceptor;
    private w seiParseResult;
    private final r singPathMonitor;
    private StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> stateMachine;
    private Function2<? super String, ? super MusicPanel, Unit> stateMachineFinishCB;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BaseCoreViewModel a;

        public a(BaseCoreViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BaseCoreViewModel.access$handleCurrentUserSingerRoleChange(this.a, ((Boolean) r2).booleanValue());
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a {
        public final /* synthetic */ BaseCoreViewModel a;

        public c(BaseCoreViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a
        public final boolean a(w r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            com.bytedance.android.livesdk.ktvimpl.base.sei.a r4 = r3.b;
            if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
            r4 = null;
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r4;
            if (r5 != null) goto L9;
            return false;
        L9:
            if ((!Intrinsics.areEqual(r5.a(), this.a.getDataEntity().f())) == false) goto L12;
            this.a.getDataEntity().b().a();
            return true;
        L12:
            return false;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public d(long r1, long r3, int r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiUpdateSingerState, System.currentTimeMillis() - this.a, ((ExtraResponse) r8).logId);
            int r0 = f.a;
            f.s(this.b, ((ExtraResponse) r8).logId, this.c);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public e(long r1, long r3, int r5) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiUpdateSingerState, System.currentTimeMillis() - this.a, r8);
            int r0 = f.a;
            f.r(this.b, r8, this.c);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel$handleCurrentUserSingerRoleChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/LyricsStateTransition;", "p1", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C02341 extends FunctionReferenceImpl implements Function1<StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b>, Unit> {
        public C02341(BaseCoreViewModel r8) {
            super(1, r8, BaseCoreViewModel.class, "listener", "listener(Lcom/bytedance/android/live/core/utils/StateMachine$Transition;)V", 0);
        }

        public final void invoke(StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            BaseCoreViewModel.access$listener((BaseCoreViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((StateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel$handleCurrentUserSingerRoleChange$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<KtvRoomLyricsStateMachineConfig.d, Unit> {
        public AnonymousClass2(BaseCoreViewModel r8) {
            super(1, r8, BaseCoreViewModel.class, "onStateEnter", "onStateEnter(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$State;)V", 0);
        }

        public final void invoke(KtvRoomLyricsStateMachineConfig.d r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            BaseCoreViewModel.access$onStateEnter((BaseCoreViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((KtvRoomLyricsStateMachineConfig.d) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel$handleCurrentUserSingerRoleChange$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/LyricsStateTransition;", "p1", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b>, Unit> {
        public AnonymousClass3(BaseCoreViewModel r8) {
            super(1, r8, BaseCoreViewModel.class, "listener", "listener(Lcom/bytedance/android/live/core/utils/StateMachine$Transition;)V", 0);
        }

        public final void invoke(StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            BaseCoreViewModel.access$listener((BaseCoreViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((StateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel$handleCurrentUserSingerRoleChange$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<KtvRoomLyricsStateMachineConfig.d, Unit> {
        public AnonymousClass4(BaseCoreViewModel r8) {
            super(1, r8, BaseCoreViewModel.class, "onStateEnter", "onStateEnter(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$State;)V", 0);
        }

        public final void invoke(KtvRoomLyricsStateMachineConfig.d r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            BaseCoreViewModel.access$onStateEnter((BaseCoreViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((KtvRoomLyricsStateMachineConfig.d) r1);
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new b();
    }

    private final void onStateEnter(KtvRoomLyricsStateMachineConfig.d r1) {
    }

    public void onCleared() {
        this.stateMachineFinishCB = null;
        xs2.b r1 = xs2.b.a();
        w r3 = this.seiParseResult;
        if (r3 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r4 = r3.b;
    L7:
        if ((r4 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L9;
        r4 = null;
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r4;
        if (r5 == null) goto L12;
        Long r6 = Long.valueOf(r5.j());
    L13:
        r1.post(new com.bytedance.android.livesdk.ktvimpl.base.sei.e(r6, this.seiParseResult, TAG));
        h r2 = this.listenerLyricsHelper;
        r2.h.dispose();
        h.a(r2);
        r2.p.clear();
        Iterator<T> r7 = this.ktvRoomSeiModelHandlers.iterator();
    L15:
        if (r7.hasNext() == false) goto L17;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a) r7.next()).i();
        goto L15
    L17:
        this.ktvRoomSeiModelHandlers.clear();
        this.compositeDisposable.clear();
        ((m) this.ktvContext.getSeiProcessor().getValue()).g(this);
        xs2.b.a().post(new id2.b(null, TAG));
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        r4 = null;
        goto L7
    }

    public void reset() {
    }

    private final void doClearOnCloseKtv() {
        Iterator<T> r0 = this.ktvRoomSeiModelHandlers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a) r0.next()).i();
        goto L4
    L6:
        updateKtvOrderedSongList(new ArrayList());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public KtvRoomLyricsStateMachineConfig.d getCurState() {
        return (KtvRoomLyricsStateMachineConfig.d) this.stateMachine.b();
    }

    public final KtvMusic getCurrentMusicFromState() {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r0 = this.mDataModel;
        if (r0 == null) goto L8;
        MusicPanel r1 = r0.a;
        if (r1 == null) goto L8;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L8;
        return r2;
    L8:
        MusicPanel r3 = ((KtvRoomLyricsStateMachineConfig.d) this.stateMachine.b()).b();
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.a;
    }

    public final StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> getCurrentTransition() {
        return (StateMachine.c.b) this.mValid.getValue();
    }

    public final KtvRoomLyricsStateMachineConfig.d getFromSate() {
        StateMachine.c.b r0 = (StateMachine.c.b) this.mValid.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (KtvRoomLyricsStateMachineConfig.d) r0.a;
    }

    public com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.c getListenerController() {
        return new com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.c(this.ktvContext, this, getDataEntity(), new C02331(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public KtvRoomLyricsStateMachineConfig.d getState() {
        return (KtvRoomLyricsStateMachineConfig.d) this.stateMachine.b();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public boolean isPaused() {
        return this.stateMachine.b() instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public long obtainCurMusicProgress() {
        Long r0 = (Long) this.listenerLyricsHelper.e.getValue();
        if (r0 != null) goto L6;
        r0 = 0L;
    L6:
        return r0.longValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public boolean inOnSing() {
        return getCurState() instanceof KtvRoomLyricsStateMachineConfig.d.f;
    }

    public k initAnchorController() {
        c0 r1 = null;
        if (isAnchor() == false) goto L14;
        k r0 = new k(getKtvRoomProvider(), getDataEntity(), this.stateMachine, new BaseCoreViewModel$initAnchorController$anchorController$1(this));
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r2 = this.stateMachine;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.w = r2;
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.live.pushstream.d r4 = getKtvRoomProvider().g();
        if (r4 == null) goto L13;
        d0 r5 = this.liveStreamInfoSenderManager;
        if (r5 == null) goto L12;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L11;
        AtomicInteger r6 = c0.c;
        r1 = c0.a.b(r5);
        goto L12
    L11:
        AtomicInteger r7 = c0.c;
        r1 = c0.a.a(r5);
    L12:
        r0.a = new com.bytedance.android.livesdk.ktvimpl.base.sei.f(r4, r1);
    L13:
        return r0;
    L14:
        return null;
    }

    public boolean isAnchor() {
        return getDataEntity().b().isAnchor();
    }

    public void useSeiDataOfFeedForwardLoadLyric() {
        DataCenter r0 = getDataEntity().getDataCenter();
        if (r0 == null) goto L5;
        Object r1 = r0.get("audio_ktv_sei_parse_result_data", null);
    L7:
        if ((r1 instanceof w) == true) goto L9;
        r1 = null;
    L9:
        w r2 = (w) r1;
        if (r2 == null) goto L15;
        j r3 = j.l;
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r4 = r2.b;
        r3.getClass();
        j.k(r4);
        onSeiResult(r2);
        ALogger.i("alog_ktv_smooth_enter_room", "useSeiDataOfFeedForwardLoadLyric ;; result == " + r2);
        DataCenter r5 = getDataEntity().getDataCenter();
        if (r5 == null) goto L16;
        r5.put("audio_ktv_sei_parse_result_data", null);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void clearData() {
        onCleared();
    }

    public k getAnchorController() {
        return this.anchorController;
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final String getCurrentUserId() {
        return this.currentUserId;
    }

    public sb0.b getDataEntity() {
        return this.dataEntity;
    }

    public final KtvContext getKtvContext() {
        return this.ktvContext;
    }

    public oe2.b getKtvRoomProvider() {
        return this.ktvRoomProvider;
    }

    public final CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> getKtvRoomSeiModelHandlers() {
        return this.ktvRoomSeiModelHandlers;
    }

    public final StateMachine.c<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> getLastInvalidTransition() {
        return this.lastInvalidTransition;
    }

    public final StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> getLastvalidTransition() {
        return this.lastvalidTransition;
    }

    public final h getListenerLyricsHelper() {
        return this.listenerLyricsHelper;
    }

    public final d0 getLiveStreamInfoSenderManager() {
        return this.liveStreamInfoSenderManager;
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a getSeiHandleInterceptor() {
        return this.seiHandleInterceptor;
    }

    public final w getSeiParseResult() {
        return this.seiParseResult;
    }

    public final StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> getStateMachine() {
        return this.stateMachine;
    }

    public final Function2<String, MusicPanel, Unit> getStateMachineFinishCB() {
        return this.stateMachineFinishCB;
    }

    private final boolean filterMySei(w r4) {
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r2 = null;
        if (((Boolean) vm2.h.r6.getValue(null, vm2.h.a[380(0x17c, float:5.32E-43)])).booleanValue() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r5 = r4.b;
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L9;
        r2 = r5;
    L9:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r3 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r2;
        if (r3 != null) goto L12;
    L15:
        return false;
    L12:
        if (Intrinsics.areEqual(r3.A(), this.currentUid) == false) goto L15;
        return true;
    }

    private final void handleCurrentUserSingerRoleChange(boolean r10) {
        if (KtvSettingHelper.w() == true) goto L5;
    L8:
        this.lastIsSinger = Boolean.valueOf(r10);
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) this.stateMachine.b();
        StringBuilder r3 = new StringBuilder("preState tag: ");
        r3.append(r0.a);
        r3.append("  music: ");
        MusicPanel r5 = r0.b();
        if (r5 == null) goto L13;
        KtvMusic r6 = r5.a;
        if (r6 == null) goto L13;
        String r7 = r6.getMTitle();
    L14:
        r3.append(r7);
        r3.append(" stateMachineFinishCB: ");
        r3.append(this.stateMachineFinishCB);
        String r4 = r3.toString();
        ALogger.i(bb0.b.b(), r4 + ", invoke class :BaseCoreViewModel");
        StringBuilder r8 = new StringBuilder("isSinger：");
        r8.append(r10);
        r8.append(",preState tag: ");
        r8.append(r0.a);
        r8.append("  music: ");
        MusicPanel r9 = r0.b();
        if (r9 == null) goto L19;
        KtvMusic r11 = r9.a;
        if (r11 == null) goto L19;
        String r12 = r11.getMTitle();
    L20:
        r8.append(r12);
        r8.append(" stateMachineFinishCB: ");
        r8.append(this.stateMachineFinishCB);
        ALogger.i("logKtvMainPath", r8.toString() + ", invoke class :BaseCoreViewModel");
        Function2<? super String, ? super MusicPanel, Unit> r1 = this.stateMachineFinishCB;
        if (r1 == null) goto L23;
        Unit r2 = (Unit) r1.invoke(r0.a, r0.b());
    L23:
        if (r10 == false) goto L25;
        KtvRoomLyricsStateMachineConfig r13 = KtvRoomLyricsStateMachineConfig.a;
        C02341 r14 = new C02341(this);
        AnonymousClass2 r15 = new AnonymousClass2(this);
        r13.getClass();
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r16 = KtvRoomLyricsStateMachineConfig.b(r14, r0, r15);
    L26:
        this.stateMachine = r16;
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> r17 = this.ktvRoomSeiModelHandlers.iterator();
    L28:
        if (r17.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a r18 = r17.next();
        if ((r18 instanceof k) == true) goto L28;
        r18.i();
        goto L28
    L32:
        this.ktvRoomSeiModelHandlers.clear();
        this.stateMachine.d(KtvRoomLyricsStateMachineConfig.a.g.c, null);
        if (r10 == true) goto L36;
        this.ktvRoomSeiModelHandlers.add(getListenerController());
    L36:
        if (isAnchor() == false) goto L46;
        k r19 = getAnchorController();
        if (r19 == null) goto L47;
        this.ktvRoomSeiModelHandlers.add(r19);
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r20 = this.stateMachine;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r19.w = r20;
        return;
    L47:
        return;
    L46:
        return;
    L25:
        KtvRoomLyricsStateMachineConfig r21 = KtvRoomLyricsStateMachineConfig.a;
        AnonymousClass3 r22 = new AnonymousClass3(this);
        AnonymousClass4 r23 = new AnonymousClass4(this);
        r21.getClass();
        r16 = KtvRoomLyricsStateMachineConfig.a(r22, r23);
    L19:
        r12 = null;
    L13:
        r7 = null;
        goto L14
    L5:
        if (Intrinsics.areEqual(this.lastIsSinger, Boolean.valueOf(r10)) == false) goto L8;
        ALogger.i("logKtvMainPath", ("handleCurrentUserSingerRoleChange ;; is same state ;; isSinger == " + r10) + ", invoke class :BaseCoreViewModel");
    }

    private final void listener(StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r12) {
        StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1 = null;
        if ((r12 instanceof StateMachine.c.b) == true) goto L5;
        StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r0 = null;
    L6:
        StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2 = (StateMachine.c.b) r0;
        if (r2 == null) goto L86;
        boolean r5 = true;
        if ((!Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r2.a).getClass().getName(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).getClass().getName())) == false) goto L14;
        ALogger.i("logKtvMainPath", ("listener state change:" + ((KtvRoomLyricsStateMachineConfig.d) r2.a) + ",to:" + ((KtvRoomLyricsStateMachineConfig.d) r2.c) + ",event:" + ((KtvRoomLyricsStateMachineConfig.a) r2.b)) + ", invoke class :BaseCoreViewModel");
        if (this.ktvContext.isCurrentUserIsSinger() == false) goto L18;
        this.singPathMonitor.getClass();
        r.a(r2);
    L18:
        Iterator<T> r3 = this.ktvRoomSeiModelHandlers.iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a) r3.next()).h(r2);
        goto L20
    L22:
        this.listenerLyricsHelper.getClass();
        Intrinsics.checkNotNullParameter(r2, "valid");
        KtvRoomLyricsStateMachineConfig.d r4 = (KtvRoomLyricsStateMachineConfig.d) r2.c;
        this.lastvalidTransition = r2;
        KtvRoomLyricsStateMachineConfig.b r6 = (KtvRoomLyricsStateMachineConfig.b) r2.d;
        if ((r6 instanceof KtvRoomLyricsStateMachineConfig.b.a) == false) goto L26;
        doClearOnCloseKtv();
    L28:
        Iterator<T> r7 = this.ktvRoomSeiModelHandlers.iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        ((com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a) r7.next()).c(r2);
        goto L30
    L32:
        this.lastInvalidTransition = null;
        if ((!Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r2.a).getClass(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).getClass())) == false) goto L35;
        notifyStateChange(r2);
    L35:
        StateMachine.c.b r8 = (StateMachine.c.b) this.mValid.getValue();
        if (r8 == null) goto L39;
        Object r9 = (KtvRoomLyricsStateMachineConfig.d) r8.c;
        if (r9 == null) goto L39;
    L40:
        KtvRoomLyricsStateMachineConfig.b r10 = (KtvRoomLyricsStateMachineConfig.b) r2.d;
        if (r10 == null) goto L50;
        KtvRoomLyricsStateMachineConfig.b r11 = this.mLastEffect;
        if (r11 == null) goto L48;
        Intrinsics.checkNotNull(r11);
        if ((!Intrinsics.areEqual(r11.getClass().getName(), r10.getClass().getName())) == true) goto L48;
        if ((!Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r2.c).getClass().getName(), r9.getClass().getName())) == false) goto L50;
    L48:
        this.mLastEffect = r10;
        notifyEffectChange(r10);
    L50:
        if (((KtvRoomLyricsStateMachineConfig.d) r2.a).getClass().isAssignableFrom(((KtvRoomLyricsStateMachineConfig.d) r2.c).getClass()) == true) goto L52;
        notifyDataModelChange(new com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d(((KtvRoomLyricsStateMachineConfig.d) r2.c).b(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).c(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).a()));
    L77:
        tryNotifyProgress(r2);
        Object r13 = r2.c;
        if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L83;
        if (r13 == null) goto L82;
        notifyProgressChange(((KtvRoomLyricsStateMachineConfig.d.C0041d) r13).c.a);
        goto L83
    L82:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Paused");
    L83:
        this.mValid.setValue(r12);
        return;
    L52:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r14 = this.mDataModel;
        MusicPanel r15 = ((KtvRoomLyricsStateMachineConfig.d) r2.c).b();
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r16 = ((KtvRoomLyricsStateMachineConfig.d) r2.c).c();
        Intrinsics.checkNotNullParameter(new com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d(r15, r16, ((KtvRoomLyricsStateMachineConfig.d) r2.c).a()), "dataModel");
        boolean r17 = false;
        if (r14 == null) goto L75;
        MusicPanel r18 = r14.a;
        if (r18 == null) goto L73;
        KtvMusic r19 = r18.a;
        if (r19 == null) goto L73;
        if (r15 == null) goto L61;
        r1 = r15.a;
    L61:
        if (r1 != null) goto L64;
    L66:
        boolean r20 = false;
    L67:
        if (r20 != true) goto L73;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r21 = r14.b;
        if (r21 == null) goto L73;
        if (r21.equals(r16) != true) goto L73;
    L74:
        r17 = r5;
        goto L75
    L64:
        if (r19.getMId() != r1.getMId()) goto L66;
        r20 = true;
    L73:
        r5 = false;
    L75:
        if (r17 == true) goto L77;
        notifyDataModelChange(new com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d(((KtvRoomLyricsStateMachineConfig.d) r2.c).b(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).c(), ((KtvRoomLyricsStateMachineConfig.d) r2.c).a()));
    L39:
        r9 = KtvRoomLyricsStateMachineConfig.d.b.b;
        goto L40
    L26:
        if ((r6 instanceof KtvRoomLyricsStateMachineConfig.b.f) == false) goto L28;
        this.seiParseResult = null;
        goto L28
    L14:
        if ((r2.b instanceof KtvRoomLyricsStateMachineConfig.a.i) == false) goto L18;
        if (this.ktvContext.isCurrentUserIsSinger() == false) goto L18;
        this.singPathMonitor.getClass();
        r.a(r2);
        goto L18
    L86:
        if ((r12 instanceof StateMachine.c.a) == false) goto L89;
        r1 = r12;
    L89:
        StateMachine.c.a r22 = (StateMachine.c.a) r1;
        if (r22 == null) goto L102;
        StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r23 = this.lastInvalidTransition;
        if (r23 != null) goto L94;
        return;
    L94:
        if (r22.b.getClass().isInstance((KtvRoomLyricsStateMachineConfig.a) r23.a()) == true) goto L104;
        String r24 = "invalid transition:state " + ((KtvRoomLyricsStateMachineConfig.d) r22.a) + ", event:" + ((KtvRoomLyricsStateMachineConfig.a) r22.b);
        ALogger.i(bb0.b.b(), r24 + ", invoke class :BaseCoreViewModel");
        ALogger.i("logKtvMainPath", ("invalid transition:state " + ((KtvRoomLyricsStateMachineConfig.d) r22.a) + ", event:" + ((KtvRoomLyricsStateMachineConfig.a) r22.b)) + ", invoke class :BaseCoreViewModel");
        this.lastInvalidTransition = r22;
        HashMap r25 = new HashMap();
        r25.put("currentState", ((KtvRoomLyricsStateMachineConfig.d) r12.b()).toString());
        String r26 = ((KtvRoomLyricsStateMachineConfig.a) r12.a()).b;
        if (r26 != null) goto L98;
        r26 = "";
    L98:
        r25.put("source", r26);
        r25.put("event", ((KtvRoomLyricsStateMachineConfig.a) r12.a()).toString());
        pd2.d.v(LinkMonitorData.BusinessInvalidStateTransition, r25);
        return;
    L104:
        return;
    L102:
        return;
    L5:
        r0 = r12;
        goto L6
    }

    private final void notifyDataModelChange(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r4) {
        this.mDataModel = r4;
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r0 = this.listenerListMap.get(CORE_TAG_DATA_MODEL);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().d(getCurState(), r4);
        goto L7
    }

    private final void notifyEffectChange(KtvRoomLyricsStateMachineConfig.b r3) {
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r0 = this.listenerListMap.get(CORE_TAG_EFFECT);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().b(r3);
        goto L7
    }

    private final void notifyStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4) {
        Object r0 = r4.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L9;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L9;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L9;
    L11:
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r1 = this.listenerListMap.get(CORE_TAG_STATE);
        if (r1 != null) goto L14;
        return;
    L14:
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L20;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e r3 = r2.next();
        if (r3.c() == false) goto L16;
        r3.a(r4);
        goto L16
    L20:
        sendKtvRoomLyricsStateEvent((KtvRoomLyricsStateMachineConfig.a) r4.b);
        return;
    L9:
        if (this.ktvContext.isCurrentUserIsSinger() == true) goto L11;
        this.listenerLyricsHelper.e.setValue(0L);
        goto L11
    }

    private final void sendKtvRoomLyricsStateEvent(KtvRoomLyricsStateMachineConfig.a r3) {
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.g) == false) goto L6;
        KtvRoomLyricsStateEventType r4 = KtvRoomLyricsStateEventType.START_KTV_ROOM;
    L29:
        xs2.b.a().post(new jd0.d(r4));
        return;
    L6:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.i) == false) goto L9;
        r4 = KtvRoomLyricsStateEventType.TURNING_NEXT;
        goto L29
    L9:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.f) == false) goto L12;
        r4 = KtvRoomLyricsStateEventType.SINGER_BEGIN_SING;
        goto L29
    L12:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.e) == false) goto L15;
        r4 = KtvRoomLyricsStateEventType.SING;
        goto L29
    L15:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.b) == false) goto L18;
        r4 = KtvRoomLyricsStateEventType.PAUSE_SING;
        goto L29
    L18:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.d) == false) goto L21;
        r4 = KtvRoomLyricsStateEventType.RESUME_SING;
        goto L29
    L21:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.h) == false) goto L24;
        r4 = KtvRoomLyricsStateEventType.STOP_SING;
        goto L29
    L24:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.C0031a) == false) goto L27;
        r4 = KtvRoomLyricsStateEventType.CLOSE_KTV_ROOM;
        goto L29
    L27:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.a.c) == false) goto L32;
        r4 = KtvRoomLyricsStateEventType.PREPARE;
        goto L29
    L32:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (filterMySei(r2) == false) goto L7;
        return false;
    L7:
        return this.seiHandleInterceptor.a(r2);
    }

    public final OrderedSongDataContext getOrderedSongDataContext(boolean r1) {
        if (r1 == false) goto L5;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L5:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    public final void notifyProgressChange(long r4) {
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r0 = this.listenerListMap.get(CORE_TAG_PROGRESS);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e r2 = r1.next();
        if (r2.c() == false) goto L7;
        r2.e(r4);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(w r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r10.b;
        ALogger.i("logKtvMainPath", "core onSeiResult, invoke class :BaseCoreViewModel");
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L51;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r3 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r0;
        this.listenerLyricsHelper.d(r3);
        r r2 = this.singPathMonitor;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "model");
        q r4 = r3.w();
        if (r4 == null) goto L20;
        String r5 = r4.h();
        if (r5 == null) goto L20;
        long r6 = r3.j();
        if (Intrinsics.areEqual(r2.b, r5) == true) goto L11;
    L18:
        r2.a = 0L;
        goto L20
    L11:
        if (r6 <= 0) goto L18;
        Long r7 = r2.a;
        if (r7 != null) goto L16;
    L17:
        pd2.d.L(pd2.d.n, r6, "be_singer");
        r2.a = Long.valueOf(r6);
        goto L20
    L16:
        if (r7.longValue() != r6) goto L17;
    L20:
        if (r3.G() == false) goto L42;
        if (r3.d() == 1) goto L42;
        if (Lists.isEmpty(r3.l()) == true) goto L27;
        this.seiParseResult = r10;
    L37:
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> r8 = this.ktvRoomSeiModelHandlers.iterator();
    L39:
        if (r8.hasNext() == false) goto L42;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a r9 = r8.next();
        ALogger.i("logKtvMainPath", ("onLyricsSeiModel:" + r0) + ", invoke class :BaseCoreViewModel");
        r9.g(r3, new JSONObject(r10.a));
        goto L39
    L27:
        if (Lists.isEmpty(r3.l()) == false) goto L37;
        String r11 = r3.p();
        if (r11 != null) goto L31;
    L34:
        boolean r12 = true;
    L35:
        if (r12 == false) goto L37;
        this.seiParseResult = null;
        goto L37
    L31:
        if (r11.length() == 0) goto L34;
        r12 = false;
    L42:
        if (r3.d() != 1) goto L47;
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> r13 = this.ktvRoomSeiModelHandlers.iterator();
    L45:
        if (r13.hasNext() == false) goto L47;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a r1 = r13.next();
        ALogger.i("logKtvMainPath", "onKtvRoomSeiModel, invoke class :BaseCoreViewModel");
        r1.f(r3);
    L47:
        setRoomInfoForVote(r3);
        return;
    }

    public final void removeStateObserver(Observer<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.mValid.removeObserver(r2);
    }

    public void setAnchorController(k r1) {
        this.anchorController = r1;
    }

    public final void setLastInvalidTransition(StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1) {
        this.lastInvalidTransition = r1;
    }

    public final void setLastvalidTransition(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r1) {
        this.lastvalidTransition = r1;
    }

    public final void setListenerLyricsHelper(h r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.listenerLyricsHelper = r2;
    }

    public final void setRoomInfoForVote(com.bytedance.android.livesdk.ktvimpl.base.sei.k r9) {
        Intrinsics.checkNotNullParameter(r9, "sei");
        if (r9.y() > EPSILON) goto L5;
        return;
    L5:
        if (r9.d() != 0) goto L7;
    L8:
        KtvRoomLyricsStateMachineConfig.d r10 = (KtvRoomLyricsStateMachineConfig.d) this.stateMachine.b();
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L12;
        com.bytedance.live.datacontext.m<y> r0 = this.ktvContext.getKtvRoomInfo();
        KtvRoomLyricsStateMachineConfig.d.C0041d r11 = (KtvRoomLyricsStateMachineConfig.d.C0041d) r10;
        KtvMusic r3 = r11.b.a;
        KtvMusic.Companion.getClass();
        r0.setValue(new y.c(r3, (KtvMusic.a.a(r3) * ((long) 1000)) - KtvMusic.a.b(r11.b.a, r11.c.a)));
        return;
    L12:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L18;
        com.bytedance.live.datacontext.m<y> r1 = this.ktvContext.getKtvRoomInfo();
        KtvRoomLyricsStateMachineConfig.d.f r12 = (KtvRoomLyricsStateMachineConfig.d.f) r10;
        KtvMusic r4 = r12.b.a;
        KtvMusic.Companion.getClass();
        r1.setValue(new y.d(r4, (KtvMusic.a.a(r4) * ((long) 1000)) - KtvMusic.a.b(r12.b.a, r12.d.a)));
        return;
    L18:
        return;
    L7:
        if (r9.d() == 3) goto L8;
    }

    public final void setSeiHandleInterceptor(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.seiHandleInterceptor = r2;
    }

    public final void setSeiParseResult(w r1) {
        this.seiParseResult = r1;
    }

    public final void setStateMachine(StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.stateMachine = r2;
    }

    public final void setStateMachineFinishCB(Function2<? super String, ? super MusicPanel, Unit> r1) {
        this.stateMachineFinishCB = r1;
    }

    public void tryNotifyProgress(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "valid");
        Object r0 = r4.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L5;
        return;
    L5:
        if (r0 == null) goto L18;
        if (((KtvRoomLyricsStateMachineConfig.d.f) r0).b.a.isSinger(this.currentUserId) == true) goto L12;
        ChorusContext.a r1 = ChorusContext.Companion;
        if (r1.c() == true) goto L11;
        return;
    L11:
        if (r1.d() == true) goto L12;
        return;
    L12:
        Object r5 = r4.c;
        if (r5 == null) goto L16;
        notifyProgressChange(((KtvRoomLyricsStateMachineConfig.d.f) r5).d.a);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void unregisterKtvCoreListener(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e r5) {
        Intrinsics.checkNotNullParameter(r5, "coreListener");
        Iterator<CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e>> r0 = this.listenerListMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r1 = r0.next();
        if (r1 == null) goto L4;
        if (r1.contains(r5) != true) goto L4;
        r1.remove(r5);
        goto L4
    }

    public final void updateKtvOrderedSongList(List<MusicPanel> r6) {
        Intrinsics.checkNotNullParameter(r6, "list");
        if (r6.isEmpty() == false) goto L7;
        OrderedSongDataContext r0 = getOrderedSongDataContext$default(this, false, 1, null);
        if (r0 == null) goto L7;
        r0.updateKtvSongUniqueInfoList(new ArrayList());
    L7:
        OrderedSongDataContext r1 = getOrderedSongDataContext$default(this, false, 1, null);
        if (r1 == null) goto L11;
        r1.updateKtvOrderedSongList(r6);
        return;
    }

    public static final /* synthetic */ void access$handleCurrentUserSingerRoleChange(BaseCoreViewModel r0, boolean r1) {
        r0.handleCurrentUserSingerRoleChange(r1);
    }

    public static final /* synthetic */ void access$listener(BaseCoreViewModel r0, StateMachine.c r1) {
        r0.listener(r1);
    }

    public static final /* synthetic */ void access$onStateEnter(BaseCoreViewModel r0, KtvRoomLyricsStateMachineConfig.d r1) {
        r0.onStateEnter(r1);
    }

    private final void notifyByTag(String r2, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e r3) {
        switch(r2.hashCode()) {
            case -1887083788: goto L13;
            case -1306084975: goto L11;
            case 109757585: goto L7;
            case 1514407389: goto L5;
            default: goto L25;
        };
    L5:
        r2.equals(CORE_TAG_PROGRESS);
        return;
    L11:
        r2.equals(CORE_TAG_EFFECT);
        return;
    L25:
        return;
    L7:
        if (r2.equals(CORE_TAG_STATE) == false) goto L19;
        StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4 = this.lastvalidTransition;
        if (r4 == null) goto L20;
        r3.a(r4);
        return;
    L20:
        return;
    L19:
        return;
    L13:
        if (r2.equals(CORE_TAG_DATA_MODEL) == false) goto L23;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r5 = this.mDataModel;
        if (r5 == null) goto L24;
        r3.d((KtvRoomLyricsStateMachineConfig.d) this.stateMachine.b(), r5);
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void observerOnLyricsChange(LifecycleOwner r4, Function1<? super ub0.a, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "handler");
        h r2 = this.listenerLyricsHelper;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "handler");
        r2.f.observe(r4, new i(r5));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void observerOnProgress(LifecycleOwner r4, Function1<? super Long, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "handler");
        h r2 = this.listenerLyricsHelper;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "handler");
        r2.e.observe(r4, new com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.j(r5));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void sendEvent(KtvRoomLyricsStateMachineConfig.a r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "source");
        String r0 = "event " + r5.a + " source: " + r6;
        ALogger.i(bb0.b.b(), "KtvCoreViewModel :" + r0 + ", invoke class :BaseCoreViewModel");
        r5.b = r6;
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r7 = this.stateMachine;
        StateMachine.a r1 = StateMachine.c;
        r7.d(r5, null);
    }

    public final void sendSei(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "data");
        k r2 = getAnchorController();
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "data");
        com.bytedance.android.livesdk.ktvimpl.base.sei.f r0 = r2.a;
        if (r0 == null) goto L9;
        r0.a(r4, r5);
        return;
    L9:
        return;
    }

    public final void updateSingerState(int r17, long r18) {
        long r6 = System.currentTimeMillis();
        long r11 = getDataEntity().b().getRoomId();
        this.compositeDisposable.add(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).updateSingerState(r11, r11, r18, r17).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r6, r18, r17), new e(r6, r18, r17)));
    }

    public BaseCoreViewModel(oe2.b r7, sb0.b r8, KtvContext r9) {
        Intrinsics.checkNotNullParameter(r7, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r8, "dataEntity");
        Intrinsics.checkNotNullParameter(r9, "ktvContext");
        this.ktvRoomProvider = r7;
        this.dataEntity = r8;
        this.ktvContext = r9;
        this.seiHandleInterceptor = new c(this);
        IMiddlewareUserService r10 = jc1.k.f(IMiddlewareUserService.class);
        if (r10 == null) goto L9;
        com.bytedance.android.livesdk.user.e r11 = r10.user();
        if (r11 == null) goto L9;
        String r12 = r11.n();
        if (r12 == null) goto L9;
    L10:
        this.currentUid = r12;
        this.mValid = new NextLiveData();
        KtvRoomLyricsStateMachineConfig r13 = KtvRoomLyricsStateMachineConfig.a;
        BaseCoreViewModel$stateMachine$1 r14 = new BaseCoreViewModel$stateMachine$1(this);
        BaseCoreViewModel$stateMachine$2 r0 = new BaseCoreViewModel$stateMachine$2(this);
        r13.getClass();
        this.stateMachine = KtvRoomLyricsStateMachineConfig.a(r14, r0);
        this.listenerListMap = new ConcurrentHashMap();
        this.singPathMonitor = new r(getDataEntity().f());
        this.listenerLyricsHelper = r9.getLyricResourceManager();
        CompositeDisposable r15 = new CompositeDisposable();
        this.compositeDisposable = r15;
        this.liveStreamInfoSenderManager = (d0) r9.getStreamInfoSender().getValue();
        this.anchorController = initAnchorController();
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> r16 = new CopyOnWriteArrayList();
        if (isAnchor() == false) goto L15;
        k r1 = getAnchorController();
        if (r1 == null) goto L15;
        r16.add(r1);
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r2 = this.stateMachine;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.w = r2;
    L15:
        r16.add(getListenerController());
        Unit r3 = Unit.INSTANCE;
        this.ktvRoomSeiModelHandlers = r16;
        this.currentUserId = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        Lazy r17 = KtvCommonSettingHelper.a;
        Function0<Unit> r18 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r18, "cb");
        r18.invoke();
        handleCurrentUserSingerRoleChange(r9.isCurrentUserIsSinger());
        Disposable r19 = KtvContext.observerCurrentUserIsSinger$default(r9, null, false, new a(this), 3, null);
        if (r19 == null) goto L18;
        RxUtilKt.c(r19, r15);
    L18:
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) r9.getSeiProcessor().getValue(), this);
        useSeiDataOfFeedForwardLoadLyric();
        return;
    L9:
        r12 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void observeState(LifecycleOwner r2, Observer<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.mValid.observe(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c
    public void registerKtvCoreListener(ArrayList<String> r4, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "tags");
        Intrinsics.checkNotNullParameter(r5, "coreListener");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<String> r7 = r4.iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        String r0 = r7.next();
        CopyOnWriteArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e> r1 = this.listenerListMap.get(r0);
        if (r1 != null) goto L12;
        r1 = new CopyOnWriteArrayList();
    L12:
        if (r1.contains(r5) == true) goto L16;
        r1.add(r5);
        if (r6 == false) goto L16;
        notifyByTag(r0, r5);
    L16:
        this.listenerListMap.put(r0, r1);
        goto L7
    }

    public static /* synthetic */ OrderedSongDataContext getOrderedSongDataContext$default(BaseCoreViewModel r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.ktvContext.isKtvMode();
    L7:
        return r0.getOrderedSongDataContext(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrderedSongDataContext");
    }
}
