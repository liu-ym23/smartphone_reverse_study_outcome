package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.midi.MidiContext;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.model.api.r0;
import com.bytedance.android.live.ktv.common.model.api.s0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.yb1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import fd2.y;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0004µ\u0001¸\u0001\u0018\u0000 Á\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Â\u0001B\t¢\u0006\u0006\b¿\u0001\u0010À\u0001J*\u0010\u000b\u001a\u00020\n2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004j\u0004\u0018\u0001`\bH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J>\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u0016H\u0002J\u0012\u0010!\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J \u0010,\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\u0006\u0010+\u001a\u00020*H\u0002J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020%2\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020\nH\u0002J\b\u00100\u001a\u00020\u0016H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0019H\u0002Jz\u0010A\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u00192\b\u00104\u001a\u0004\u0018\u00010\u00192\b\u00105\u001a\u0004\u0018\u00010\u00192\b\u00106\u001a\u0004\u0018\u00010\u00192\u0006\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u00192\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00192\u0006\u0010@\u001a\u00020?H\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010C\u001a\u00020BH\u0002J\u0010\u0010F\u001a\u00020\n2\u0006\u0010C\u001a\u00020EH\u0002J\u0010\u0010G\u001a\u00020\n2\u0006\u0010C\u001a\u00020EH\u0002J(\u0010H\u001a\u00020\n2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004j\u0004\u0018\u0001`\bJ(\u0010I\u001a\u00020\n2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004j\u0004\u0018\u0001`\bJ\u000e\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\rJ\u000e\u0010K\u001a\u00020\n2\u0006\u0010J\u001a\u00020\rJ\u0006\u0010L\u001a\u00020\nJ\u000e\u0010O\u001a\u00020\n2\u0006\u0010N\u001a\u00020MJ\u0016\u0010S\u001a\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010P\u001a\u00020\u0010H\u0016J \u0010W\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010V2\u0006\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u0010H\u0016J&\u0010Y\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0V\u0018\u00010X2\u0006\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010[\u001a\u00020ZH\u0016J\u0017\u0010\\\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\\\u0010\u0013J\u0018\u0010_\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010^\u001a\u0004\u0018\u00010]J\u0010\u0010a\u001a\u00020\n2\b\b\u0002\u0010`\u001a\u00020\u0016J\u0017\u0010b\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bb\u0010\u0013J\u0018\u0010d\u001a\u00020\n2\u0006\u0010^\u001a\u00020]2\b\b\u0002\u0010c\u001a\u00020\u0019J\u000e\u0010e\u001a\u00020\n2\u0006\u00101\u001a\u00020\u0019J\u0006\u0010f\u001a\u00020\nJ\b\u0010g\u001a\u00020\nH\u0014J\u0010\u0010j\u001a\u00020\n2\u0006\u0010i\u001a\u00020hH\u0016J\u0010\u0010k\u001a\u00020\u00162\u0006\u0010i\u001a\u00020hH\u0016J\u000e\u0010l\u001a\u00020\n2\u0006\u0010C\u001a\u00020ER\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00100m8\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR)\u0010s\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0r0m8\u0006¢\u0006\f\n\u0004\bs\u0010o\u001a\u0004\bt\u0010qR3\u0010u\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0m8\u0006¢\u0006\f\n\u0004\bu\u0010o\u001a\u0004\bv\u0010qR\"\u0010w\u001a\u00020*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\"\u0010(\u001a\u00020*8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010x\u001a\u0004\b}\u0010z\"\u0004\b~\u0010|R'\u0010\u007f\u001a\u00020\u00168V@\u0016X\u0096\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0089\u0001R\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0080\u0001R\u0019\u0010\u008d\u0001\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0093\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0080\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0092\u0001R\u0018\u0010\u0095\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010xR\u0019\u0010\u0096\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0080\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0080\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R)\u0010\u009f\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0V0\u009e\u00018\u0006¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R1\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010\u009e\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010 \u0001\u001a\u0006\b¥\u0001\u0010¢\u0001\"\u0006\b¦\u0001\u0010§\u0001R0\u0010¨\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u009e\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010 \u0001\u001a\u0006\b©\u0001\u0010¢\u0001\"\u0006\bª\u0001\u0010§\u0001R.\u0010[\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020#0r0\u009e\u00018\u0006¢\u0006\u000e\n\u0005\b[\u0010 \u0001\u001a\u0005\b$\u0010¢\u0001R#\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u009e\u00018\u0006¢\u0006\u0010\n\u0006\b«\u0001\u0010 \u0001\u001a\u0006\b¬\u0001\u0010¢\u0001R#\u0010®\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u00ad\u00018\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u0017\u0010²\u0001\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b²\u0001\u0010\u0090\u0001R\u0017\u0010³\u0001\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010\u0092\u0001R\u0016\u0010´\u0001\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b´\u0001\u0010xR\u0018\u0010¶\u0001\u001a\u00030µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¹\u0001\u001a\u00030¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¾\u0001\u001a\u0005\u0018\u00010»\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010½\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentMidiViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldb0/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "valid", "", "handleState", "curstate", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "data", "handleStateCoreData", "", "progress", "handleSingProgress", "(Ljava/lang/Long;)V", "observeCoreViewModel", "fetchMidiConfig", "", "isSinger", "id", "", "midiPath", "lyricsPath", "vocalFilePath", "isLrcLyric", "initMidiRes", "Lio/reactivex/disposables/Disposable;", "disposable", "isDisposed", "seekMidiScoreProgress", "Lcom/bytedance/android/live/ktv/common/midi/k;", "getScoreInfo", "", "calTotalScore", "calSentenceScore", "totalScore", "sentenceScore", "", "index", "calScore", "tone", "isNeedSendMidiSei", "resetMidiData", "canReportScore", "from", "clearScore", "avatarThumb", "userId", "secUid", "nickName", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "songTitle", "score", "isHighScoreSong", "tips", "hitMidiRecordABTest", "songId", "anchorId", "", "threshold", "sendMidiFeedbackSei", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/i;", "sei", "onMidiSeiModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "onKtvSeiModelCompat", "tryLoadMidiRes", "onIdle", "onPreparing", "ktvCoreDataModel", "onSinging", "onPaused", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "attach", "curPlayTime", "Lio/reactivex/Observable;", "Lcb0/c;", "findMidiSegment", "startTime", "endTime", "", "findMidiSegmentsNew", "Lio/reactivex/Single;", "findMidiSegments", "", "scoreInfo", "tryStartGetScoreInfoTimer", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "onSingFinish", "inNextSong", "tryHideFeedback", "startFeedBackShowTimer", "isFrom", "reportScore", "resetMidiRecord", "onDetach", "onCleared", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "onSeiResult", "accept", "initAudienceMidi", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "lyricProgress", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getLyricProgress", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lkotlin/Pair;", "coreData", "getCoreData", "curState", "getCurState", "curTotalScore", "I", "getCurTotalScore", "()I", "setCurTotalScore", "(I)V", "getTotalScore", "setTotalScore", "userOpenScore", "Z", "getUserOpenScore", "()Z", "setUserOpenScore", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "midiDisposable", "Lio/reactivex/disposables/Disposable;", "scoreDisposable", "feedbackDisposable", "feedbackTiming", "scoreInfoArr", "[D", "curScore", "F", "curMusicId", "J", "isReported", "curMidiProgress", "lastMidiIndex", "lastMidiHitFlag", "needHideFeedback", "Lcom/bytedance/android/live/ktv/common/midi/b;", "mHitComboCalculator", "Lcom/bytedance/android/live/ktv/common/midi/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "coreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "Landroidx/lifecycle/MutableLiveData;", "midiData", "Landroidx/lifecycle/MutableLiveData;", "getMidiData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "midiConfig", "getMidiConfig", "setMidiConfig", "(Landroidx/lifecycle/MutableLiveData;)V", "showNoMidiHint", "getShowNoMidiHint", "setShowNoMidiHint", "hideFeedback", "getHideFeedback", "", "midiDownloadingTask", "Ljava/util/Set;", "getMidiDownloadingTask", "()Ljava/util/Set;", "calFactorSetting", "scoreTimeSetting", "scoreRangeSetting", "com/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentMidiViewModel$p", "midiDownloadCallback", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentMidiViewModel$p;", "com/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentMidiViewModel$o", "mCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentMidiViewModel$o;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentUIContext;", "getKtvComponentUIContext", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentUIContext;", "ktvComponentUIContext", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentMidiViewModel extends ViewModel implements db0.a, com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    public static final a Companion = null;
    public static final float DEFAULT_SCORE_REPORT_PERCENT = 0.3f;
    public static final String FLAG_ON_DETACH = "onDetach";
    public static final String FLAG_ON_SING_FINISH = "onSingFinish";
    public static final String FLAG_REPORT_SCORE = "reportScore";
    public static final String TAG = "KtvComponentMidiViewModel";
    private final float calFactorSetting;
    private final CompositeDisposable compositeDispose;
    private final NextLiveData<Pair<KtvRoomLyricsStateMachineConfig.d, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d>> coreData;
    private BaseCoreViewModel coreViewModel;
    private long curMidiProgress;
    private long curMusicId;
    private float curScore;
    private final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> curState;
    private int curTotalScore;
    private Disposable feedbackDisposable;
    private boolean feedbackTiming;
    private final MutableLiveData<Boolean> hideFeedback;
    private boolean isReported;
    private boolean lastMidiHitFlag;
    private int lastMidiIndex;
    private final NextLiveData<Long> lyricProgress;
    private final o mCoreListener;
    private com.bytedance.android.live.ktv.common.midi.b mHitComboCalculator;
    private MutableLiveData<g0> midiConfig;
    private final MutableLiveData<List<cb0.c>> midiData;
    private Disposable midiDisposable;
    private final p midiDownloadCallback;
    private final Set<Integer> midiDownloadingTask;
    private boolean needHideFeedback;
    private Disposable scoreDisposable;
    private final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> scoreInfo;
    private double[] scoreInfoArr;
    private final int scoreRangeSetting;
    private final long scoreTimeSetting;
    private MutableLiveData<Boolean> showNoMidiHint;
    private int totalScore;
    private boolean userOpenScore;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;
        public final /* synthetic */ LifecycleOwner b;

        public b(KtvComponentMidiViewModel r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            KtvComponentMidiViewModel.access$setCoreViewModel$p(this.a, (BaseCoreViewModel) sh6.c.b((sh6.b) r2));
            KtvComponentMidiViewModel.access$observeCoreViewModel(this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;

        public c(KtvComponentMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<g0> r0 = this.a.getMidiConfig();
            com.bytedance.android.live.ktv.common.model.api.g r3 = (com.bytedance.android.live.ktv.common.model.api.g) ((BaseResponse) ((Response) r2)).data;
            if (r3 == null) goto L5;
            g0 r4 = r3.a();
        L6:
            r0.setValue(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "fetchMidiConfig fail");
        }
    }

    public static final class e<T> implements Predicate {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class f<T, R> implements Function {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class g<T> implements Predicate {
        public final /* synthetic */ long a;

        public g(long r1) {
            this.a = r1;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            long r0 = r8.a;
            long r2 = this.a;
            if (r0 < r2) goto L5;
        L7:
            return false;
        L5:
            if (r8.b < r2) goto L7;
            return true;
        }
    }

    public static final class h<T> implements Predicate {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isEmpty();
        }
    }

    public static final class i<T, R> implements Function {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.fromIterable(r3);
        }
    }

    public static final class j<T> implements Predicate {
        public final /* synthetic */ long a;
        public final /* synthetic */ long b;

        public j(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }

        public final boolean test(Object r6) {
            cb0.c r7 = (cb0.c) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            cb0.a r8 = r7.a;
            if (r8.a < this.a) goto L5;
        L7:
            return false;
        L5:
            if (r8.b <= this.b) goto L7;
            return true;
        }
    }

    public static final class k<T> implements SingleOnSubscribe {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(boolean r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(SingleEmitter<Integer> r5) {
            Intrinsics.checkNotNullParameter(r5, "it");
            if (this.a == true) goto L5;
        L10:
            Integer r0 = 0;
        L12:
            if (r5.isDisposed() == false) goto L14;
            return;
        L14:
            if (r0 != null) goto L17;
        L18:
            r5.onError(new Exception("init midi error"));
            return;
        L17:
            if (r0.intValue() != 0) goto L18;
            r5.onSuccess(r0);
            return;
        L5:
            if (this.b == null) goto L10;
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            if (r1 == null) goto L9;
            String r2 = this.c;
            String r3 = this.b;
            Intrinsics.checkNotNullParameter(r2, "midiFilePath");
            Intrinsics.checkNotNullParameter(r3, "lyricFilesPath");
            r1.d();
        L9:
            r0 = null;
            goto L12
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ boolean a;

        public l(boolean r1, String r2) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Integer) r2, "it");
            if (vm2.h.d() == true) goto L5;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r3 = ILiveWrappedLivePusher.a.b();
            if (r3 == null) goto L21;
            r3.getLiveCoreKaraokFilter();
            return null;
        L21:
            return null;
        L5:
            if (this.a == false) goto L9;
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.i r4 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
            if (r4 == null) goto L17;
            r4.d();
            return null;
        L17:
            return null;
        L9:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
            if (r5 == null) goto L19;
            r5.getLiveCoreKaraokFilter();
            return null;
        L19:
            return null;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;

        public m(KtvComponentMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "initMidiRes success");
            MutableLiveData<List<cb0.c>> r0 = this.a.getMidiData();
            r0.setValue((List) r3);
            this.a.getShowNoMidiHint().setValue(Boolean.FALSE);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;
        public final /* synthetic */ long b;

        public n(KtvComponentMidiViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "initMidiRes fail");
            ((Throwable) r3).printStackTrace();
            pd2.d.n.F(this.b);
            this.a.getShowNoMidiHint().setValue(Boolean.TRUE);
        }
    }

    public static final class o extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvComponentMidiViewModel a;

        public o(KtvComponentMidiViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "valid");
            KtvComponentMidiViewModel.access$handleState(this.a, r2);
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void e(long r2) {
            BaseCoreViewModel r0 = KtvComponentMidiViewModel.access$getCoreViewModel$p(this.a);
            if (r0 == null) goto L6;
            KtvMusic r1 = r0.getCurrentMusicFromState();
            if (r1 == null) goto L6;
        L7:
            if (r1 != null) goto L9;
            return;
        L9:
            KtvComponentMidiViewModel.access$handleSingProgress(this.a, Long.valueOf(r2));
            return;
        L6:
            KtvContext.Companion.getClass();
            r1 = ((y) KtvContext.a.g().getKtvRoomInfo().getValue()).b();
            goto L7
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void d(KtvRoomLyricsStateMachineConfig.d r2, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r3) {
            Intrinsics.checkNotNullParameter(r2, "curstate");
            Intrinsics.checkNotNullParameter(r3, "ktvCoreDataModel");
            KtvComponentMidiViewModel.access$handleStateCoreData(this.a, r2, r3);
        }
    }

    public static final class p implements com.bytedance.android.live.ktv.common.music.download.k.b {
        public final /* synthetic */ KtvComponentMidiViewModel a;

        public p(KtvComponentMidiViewModel r1) {
            this.a = r1;
        }

        public final void onFailed(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "errorMsg");
            if (r3 == (-1)) goto L5;
            this.a.getMidiDownloadingTask().remove(Integer.valueOf(r3));
        L5:
            com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "midiDownloadCallback onFailed");
        }

        public final void a(long r11, String r13, int r14) {
            Intrinsics.checkNotNullParameter(r13, "midiSavePath");
            if (r14 == (-1)) goto L5;
            this.a.getMidiDownloadingTask().remove(Integer.valueOf(r14));
        L5:
            com.bytedance.android.live.ktv.common.midi.e.b(KtvComponentMidiViewModel.TAG, "midiDownloadCallback onSuccess");
            if (KtvComponentMidiViewModel.access$getCurMusicId$p(this.a) != r11) goto L9;
            KtvComponentMidiViewModel.initMidiRes$default(this.a, false, r11, r13, null, null, false, 32, null);
            return;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ float c;

        public q(KtvComponentMidiViewModel r1, MusicPanel r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r30) {
            com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r30;
            int r2 = mb0.f.a;
            MusicPanel r3 = this.b;
            Boolean r4 = ((r0) ((ExtraResponse) r1).data).d();
            Boolean r5 = Boolean.TRUE;
            mb0.f.n(r3, Intrinsics.areEqual(r4, r5), Intrinsics.areEqual(((r0) ((ExtraResponse) r1).data).h(), r5), ((r0) ((ExtraResponse) r1).data).f(), this.c);
            pd2.d r6 = pd2.d.n;
            r6.getClass();
            pd2.d.I(this.b, "KSong reportScore: api back success.  result: " + r1);
            boolean r7 = true;
            if ((!Intrinsics.areEqual(((r0) ((ExtraResponse) r1).data).d(), r5)) == true) goto L57;
            Long r8 = ((r0) ((ExtraResponse) r1).data).f();
            s0 r9 = ((r0) ((ExtraResponse) r1).data).g();
            com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentUIWidget", "reportScore success " + r1 + ".data");
            if (r8 == null) goto L55;
            if (r9 == null) goto L56;
            boolean r10 = Intrinsics.areEqual(((r0) ((ExtraResponse) r1).data).h(), r5);
            r0 r11 = (r0) ((ExtraResponse) r1).data;
            if (r10 == false) goto L11;
            String r12 = r11.b();
        L13:
            if (r12 != null) goto L15;
            r12 = "";
        L15:
            OrderInfo r13 = this.b.a.getOrderInfo();
            if (r13 == null) goto L22;
            InteractiveSongUserInfo r14 = r13.getTopUser();
            if (r14 == null) goto L22;
            if (r14.getHitMidiRecordABTest() != 1) goto L22;
        L23:
            com.bytedance.android.livesdk.chatroom.o r15 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r15 == null) goto L33;
            com.bytedance.live.datacontext.m r16 = r15.getRoom();
            if (r16 == null) goto L33;
            IRoom r17 = (IRoom) r16.getValue();
            if (r17 == null) goto L33;
            String r18 = r17.getOwnerUserIdString();
            if (r18 == null) goto L33;
            String r25 = r18;
        L34:
            py.k r19 = r9.a();
            if (r19 == null) goto L37;
            String r20 = r19.getUri();
        L38:
            Long r21 = Long.valueOf(com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(r9.d()));
            String r110 = r9.c();
            String r111 = r9.b();
            long r112 = r8.longValue();
            String r113 = this.b.a.getMTitle();
            float r22 = this.c;
            Long r114 = Long.valueOf(this.b.a.getMId());
            long r23 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(r25);
            Double r24 = ((r0) ((ExtraResponse) r1).data).c();
            if (r24 == null) goto L41;
            double r26 = r24.doubleValue();
        L42:
            com.bytedance.android.livesdk.ktvimpl.base.sei.h r115 = new com.bytedance.android.livesdk.ktvimpl.base.sei.h(r20, r21, r110, r111, r112, r113, r22, r10, r12, r7, r114, r23, r26, 4096);
            KtvContext.Companion.getClass();
            KtvContext r27 = KtvContext.a.g();
            if (r27 == null) goto L45;
            r27.updateSingEndedFeedback(r115);
        L45:
            KtvComponentMidiViewModel r28 = this.a;
            py.k r29 = r9.a();
            if (r29 == null) goto L48;
            String r31 = r29.getUri();
        L49:
            String r32 = r9.d();
            String r116 = r9.c();
            String r117 = r9.b();
            long r118 = r8.longValue();
            String r119 = this.b.a.getMTitle();
            float r120 = this.c;
            long r121 = this.b.a.getMId();
            Double r33 = ((r0) ((ExtraResponse) r1).data).c();
            if (r33 == null) goto L52;
            double r210 = r33.doubleValue();
        L53:
            KtvComponentMidiViewModel.access$sendMidiFeedbackSei(r28, r31, r32, r116, r117, r118, r119, r120, r10, r12, r7, r121, r25, r210);
            return;
        L52:
            r210 = 0.0d;
            goto L53
        L48:
            r31 = null;
            goto L49
        L41:
            r26 = 0.0d;
            goto L42
        L37:
            r20 = null;
        L33:
            r25 = "";
        L22:
            r7 = false;
            goto L23
        L11:
            r12 = r11.a();
            goto L13
        L56:
            return;
        L55:
            return;
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ MusicPanel a;
        public final /* synthetic */ float b;

        public r(KtvComponentMidiViewModel r1, MusicPanel r2, float r3) {
            this.a = r2;
            this.b = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            int r0 = mb0.f.a;
            mb0.f.m(this.a, this.b, r6);
            pd2.d r1 = pd2.d.n;
            MusicPanel r2 = this.a;
            String r3 = "KSong reportScore: api back error, message: " + r6.getMessage();
            r1.getClass();
            pd2.d.I(r2, r3);
            String r7 = "reportScore: api back error, message: " + r6.getMessage();
            ALogger.i(bb0.b.b(), "KtvComponentMidiViewModel :" + r7 + ", invoke class :KtvComponentMidiViewModel");
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;
        public final /* synthetic */ Long b;

        public s(KtvComponentMidiViewModel r1, Long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            BaseCoreViewModel r9 = KtvComponentMidiViewModel.access$getCoreViewModel$p(this.a);
            if (r9 == null) goto L11;
            KtvRoomLyricsStateMachineConfig.d r10 = r9.getCurState();
            if (r10 == null) goto L11;
            MusicPanel r11 = r10.b();
            if (r11 == null) goto L11;
            KtvMusic r12 = r11.a;
            if (r12 == null) goto L11;
            long r2 = r12.getMId();
        L12:
            BaseCoreViewModel r13 = KtvComponentMidiViewModel.access$getCoreViewModel$p(this.a);
            if (r13 == null) goto L15;
            KtvRoomLyricsStateMachineConfig.d r14 = r13.getCurState();
        L17:
            if ((r14 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L27;
            Long r15 = this.b;
            if (r15 == null) goto L24;
            if (r2 != r15.longValue()) goto L24;
        L26:
            KtvComponentMidiViewModel.access$setNeedHideFeedback$p(this.a, true);
        L28:
            KtvComponentMidiViewModel.access$setFeedbackTiming$p(this.a, false);
            return;
        L24:
            if (r2 == 0) goto L26;
        L27:
            this.a.getHideFeedback().setValue(Boolean.TRUE);
            goto L28
        L15:
            r14 = null;
        L11:
            r2 = 0;
            goto L12
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ KtvComponentMidiViewModel a;

        public t(KtvComponentMidiViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            this.a.m333getScoreInfo().setValue(new Pair(Long.valueOf(KtvComponentMidiViewModel.access$getCurMidiProgress$p(this.a)), KtvComponentMidiViewModel.access$getScoreInfo(this.a)));
            KtvComponentMidiViewModel r7 = this.a;
            KtvComponentMidiViewModel.access$setCurMidiProgress$p(r7, KtvComponentMidiViewModel.access$getCurMidiProgress$p(r7) + KtvComponentMidiViewModel.access$getScoreTimeSetting$p(this.a));
        }
    }

    static {
        Companion = new a();
    }

    public cb0.c findMidiSegmentOpt(long r1) {
        return null;
    }

    public List<cb0.c> findMidiSegmentsOpt(long r1, long r3) {
        return null;
    }

    private final boolean canReportScore() {
        KtvContext.Companion.getClass();
        NextLiveData<ub0.a> r0 = KtvContext.a.g().getLyricsChangeLiveData();
        if (r0 == null) goto L9;
        ub0.a r1 = (ub0.a) r0.getValue();
        if (r1 == null) goto L9;
        List r2 = r1.a();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r4 = KtvRoomContext.a.a();
        Integer r5 = null;
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m<Integer> r6 = r4.getMidiSingLyricsLineCount();
        if (r6 == null) goto L15;
        Integer r7 = (Integer) r6.getValue();
    L16:
        g0 r8 = (g0) this.midiConfig.getValue();
        if (r8 == null) goto L19;
        Integer r9 = r8.a();
    L20:
        if (r9 == null) goto L25;
        g0 r10 = (g0) this.midiConfig.getValue();
        if (r10 == null) goto L24;
        r5 = r10.a();
    L24:
        Intrinsics.checkNotNull(r5);
        float r11 = r5.intValue() / 100.0f;
    L26:
        if (r7 != null) goto L28;
        return false;
    L28:
        if (r7.intValue() < (r3 * r11)) goto L32;
        return true;
    L32:
        return false;
    L25:
        r11 = 0.3f;
        goto L26
    L19:
        r9 = null;
    L15:
        r7 = null;
    L9:
        r3 = 0;
        goto L10
    }

    private final KtvComponentUIContext getKtvComponentUIContext() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L7;
        return (KtvComponentUIContext) r1.getValue();
    L7:
        return null;
    }

    private final com.bytedance.android.live.ktv.common.midi.k getScoreInfo() {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r1 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r1 == null) goto L5;
        r1.g(this.scoreInfoArr);
    L5:
        double[] r2 = this.scoreInfoArr;
        float r3 = (float) r2[3];
        float r4 = (float) r2[7];
        int r5 = (int) r2[11];
        float r6 = calSentenceScore() * this.calFactorSetting;
        if (r6 <= 100.0f) goto L9;
        r6 = 100.0f;
    L9:
        if (vm2.h.y() == false) goto L11;
        r3 = r4;
        r6 = 90.0f;
    L11:
        this.curScore = calScore(calTotalScore(), r6, r5);
        setTotalScore((int) calTotalScore());
        if (canReportScore() == false) goto L18;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r7 = KtvRoomContext.a.a();
        if (r7 == null) goto L18;
        com.bytedance.live.datacontext.n<Float> r8 = r7.getReportMidiScore();
        if (r8 == null) goto L18;
        r8.setValue(Float.valueOf(this.curScore));
    L18:
        com.bytedance.android.livesdk.chatroom.o r9 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r9 == null) goto L26;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L26;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L26;
        String r12 = r11.getOwnerUserIdString();
        if (r12 == null) goto L26;
    L27:
        String r13 = r12;
        if (r5 <= this.lastMidiIndex) goto L30;
        boolean r14 = true;
    L31:
        Map r15 = null;
        if (r14 == false) goto L34;
        com.bytedance.android.live.ktv.common.midi.b r16 = this.mHitComboCalculator;
        int r17 = com.bytedance.android.live.ktv.common.midi.b.e;
        int r18 = r16.b(r6, r5, null);
    L35:
        int r19 = -1;
        if (r14 == false) goto L65;
        g0 r20 = (g0) this.midiConfig.getValue();
        if (r20 == null) goto L40;
        Map r21 = r20.b();
    L41:
        int r22 = com.bytedance.android.live.ktv.common.util.p.a(r21, r6);
        if (r22 != 1) goto L44;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.b++;
        goto L65
    L44:
        if (r22 == 2) goto L62;
        if (r22 != 3) goto L65;
        if (r18 != 1) goto L49;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(1);
        goto L65
    L49:
        if (2 > r18) goto L57;
        if (9 < r18) goto L57;
        if (r18 != 2) goto L55;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.b(-1);
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L55:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a();
    L57:
        if (10 > r18) goto L65;
        if (Integer.MAX_VALUE < r18) goto L65;
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.d++;
        goto L65
    L62:
        com.bytedance.android.livesdk.ktvimpl.base.logger.a.a.c++;
        goto L65
    L40:
        r21 = null;
    L65:
        if (isNeedSendMidiSei(Math.abs(r3 - r4), r5) == false) goto L93;
        KtvComponentUIContext r23 = getKtvComponentUIContext();
        if (r23 == null) goto L71;
        MutableLiveData<Boolean> r24 = r23.getScoreOpen();
        if (r24 == null) goto L71;
        Boolean r25 = (Boolean) r24.getValue();
    L73:
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L93;
        KtvContext r26 = KtvContext.a.g();
        if (r26 == null) goto L79;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r27 = r26.getKtvSingerViewModel();
        if (r27 == null) goto L79;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r28 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r27.getValue();
    L80:
        KtvSingerViewModel r29 = (KtvSingerViewModel) r28;
        if (r29 == null) goto L93;
        float r30 = this.curScore;
        if (r5 < 0) goto L90;
        if (r14 == false) goto L90;
        g0 r31 = (g0) this.midiConfig.getValue();
        if (r31 == null) goto L88;
        Map r32 = r31.b();
    L89:
        int r110 = com.bytedance.android.live.ktv.common.util.p.a(r32, r6);
    L91:
        r29.sendMidiSei(r3, r4, r30, r5, r110, r13, r18);
        goto L93
    L88:
        r32 = null;
    L90:
        r110 = -1;
    L79:
        r28 = null;
    L71:
        r25 = null;
    L93:
        float r111 = this.curScore;
        if (r5 < 0) goto L101;
        if (r14 == false) goto L101;
        g0 r33 = (g0) this.midiConfig.getValue();
        if (r33 == null) goto L99;
        r15 = r33.b();
    L99:
        r19 = com.bytedance.android.live.ktv.common.util.p.a(r15, r6);
    L101:
        return new com.bytedance.android.live.ktv.common.midi.k(r3, r4, r6, r111, r5, Integer.valueOf(r19), r18, false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE);
    L34:
        r18 = 0;
        goto L35
    L30:
        r14 = false;
    L26:
        r12 = "";
        goto L27
    }

    private final void observeCoreViewModel() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L6;
        r0.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_DATA_MODEL, BaseCoreViewModel.CORE_TAG_PROGRESS}), this.mCoreListener, false);
        return;
    }

    private final void resetMidiData() {
        Disposable r0 = this.midiDisposable;
        if (r0 != null) goto L5;
    L8:
        this.midiData.setValue(null);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
    L7:
        this.midiDisposable = null;
        goto L8
    }

    public final void onDetach() {
        Disposable r0 = this.scoreDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.feedbackDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.midiDisposable;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        this.curMusicId = 0;
        this.curMidiProgress = 0;
        this.lastMidiIndex = -1;
        this.mHitComboCalculator.a();
        this.lastMidiHitFlag = false;
        this.needHideFeedback = false;
        this.midiData.setValue(null);
        resetMidiRecord("onDetach");
        clearScore("onDetach");
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L19;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r4 = r3.getSeiProcessor();
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) r4.getValue();
        if (r5 == null) goto L19;
        r5.g(this);
    L19:
        if (yb1.a() == false) goto L27;
        Iterator<T> r6 = this.midiDownloadingTask.iterator();
    L22:
        if (r6.hasNext() == false) goto L24;
        int r7 = ((Number) r6.next()).intValue();
        com.bytedance.android.live.ktv.common.music.download.k.a.getClass();
        Downloader.getInstance(s1.getContext()).cancel(r7);
        goto L22
    L24:
        this.midiDownloadingTask.clear();
        return;
    }

    public final void onPaused() {
        Disposable r0 = this.scoreDisposable;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public KtvComponentMidiViewModel() {
        this.lyricProgress = new NextLiveData();
        this.coreData = new NextLiveData();
        this.curState = new NextLiveData();
        this.compositeDispose = new CompositeDisposable();
        this.scoreInfoArr = new double[21];
        this.lastMidiIndex = -1;
        this.mHitComboCalculator = new com.bytedance.android.live.ktv.common.midi.b();
        this.midiData = new MutableLiveData();
        this.midiConfig = new MutableLiveData();
        this.showNoMidiHint = new MutableLiveData();
        this.scoreInfo = new MutableLiveData();
        this.hideFeedback = new MutableLiveData();
        this.midiDownloadingTask = new LinkedHashSet();
        this.calFactorSetting = vm2.h.C();
        this.scoreTimeSetting = vm2.h.D();
        this.scoreRangeSetting = vm2.h.I();
        ke2.c.b(null);
        fetchMidiConfig();
        this.midiDownloadCallback = new p(this);
        this.mCoreListener = new o(this);
    }

    private final float calSentenceScore() {
        Double r0 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
        if (r0 == null) goto L5;
        float r1 = (float) r0.doubleValue();
    L6:
        Double r2 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
        float r3 = 0.1f;
        if (r2 == null) goto L9;
        float r4 = (float) r2.doubleValue();
    L10:
        Double r5 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
        if (r5 == null) goto L13;
        r3 = (float) r5.doubleValue();
    L13:
        double[] r6 = this.scoreInfoArr;
        return ((((float) r6[0]) * r1) + (((float) r6[13]) * r4)) + (((float) r6[15]) * r3);
    L9:
        r4 = 0.1f;
        goto L10
    L5:
        r1 = 0.8f;
        goto L6
    }

    private final float calTotalScore() {
        Double r0 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 0);
        if (r0 == null) goto L5;
        float r1 = (float) r0.doubleValue();
    L6:
        Double r2 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 1);
        float r3 = 0.1f;
        if (r2 == null) goto L9;
        float r4 = (float) r2.doubleValue();
    L10:
        Double r5 = (Double) ArraysKt.getOrNull(vm2.h.Z(), 2);
        if (r5 == null) goto L13;
        r3 = (float) r5.doubleValue();
    L13:
        double[] r6 = this.scoreInfoArr;
        return ((((float) r6[1]) * r1) + (((float) r6[14]) * r4)) + (((float) r6[16]) * r3);
    L9:
        r4 = 0.1f;
        goto L10
    L5:
        r1 = 0.8f;
        goto L6
    }

    private final void fetchMidiConfig() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.getRoomId();
    L10:
        Disposable r4 = ((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getMidiConfig(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a);
        if (r4 == null) goto L14;
        RxUtilKt.c(r4, this.compositeDispose);
        return;
    L14:
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public boolean getUserOpenScore() {
        KtvComponentUIContext r0 = getKtvComponentUIContext();
        if (r0 == null) goto L9;
        MutableLiveData<Boolean> r1 = r0.getScoreOpen();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return true;
    }

    public void onCleared() {
        super.onCleared();
        onDetach();
        this.compositeDispose.dispose();
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L6;
        r0.unregisterKtvCoreListener(this.mCoreListener);
        return;
    }

    public final NextLiveData<Pair<KtvRoomLyricsStateMachineConfig.d, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d>> getCoreData() {
        return this.coreData;
    }

    public final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> getCurState() {
        return this.curState;
    }

    public int getCurTotalScore() {
        return this.curTotalScore;
    }

    public final MutableLiveData<Boolean> getHideFeedback() {
        return this.hideFeedback;
    }

    public final NextLiveData<Long> getLyricProgress() {
        return this.lyricProgress;
    }

    public final MutableLiveData<g0> getMidiConfig() {
        return this.midiConfig;
    }

    public final MutableLiveData<List<cb0.c>> getMidiData() {
        return this.midiData;
    }

    public final Set<Integer> getMidiDownloadingTask() {
        return this.midiDownloadingTask;
    }

    public final MutableLiveData<Boolean> getShowNoMidiHint() {
        return this.showNoMidiHint;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    /* JADX INFO: renamed from: getScoreInfo, reason: collision with other method in class */
    public final MutableLiveData<Pair<Long, com.bytedance.android.live.ktv.common.midi.k>> m333getScoreInfo() {
        return this.scoreInfo;
    }

    public static final /* synthetic */ BaseCoreViewModel access$getCoreViewModel$p(KtvComponentMidiViewModel r0) {
        return r0.coreViewModel;
    }

    public static final /* synthetic */ long access$getCurMidiProgress$p(KtvComponentMidiViewModel r2) {
        return r2.curMidiProgress;
    }

    public static final /* synthetic */ long access$getCurMusicId$p(KtvComponentMidiViewModel r2) {
        return r2.curMusicId;
    }

    public static final /* synthetic */ boolean access$getFeedbackTiming$p(KtvComponentMidiViewModel r0) {
        return r0.feedbackTiming;
    }

    public static final /* synthetic */ boolean access$getNeedHideFeedback$p(KtvComponentMidiViewModel r0) {
        return r0.needHideFeedback;
    }

    public static final /* synthetic */ com.bytedance.android.live.ktv.common.midi.k access$getScoreInfo(KtvComponentMidiViewModel r0) {
        return r0.getScoreInfo();
    }

    public static final /* synthetic */ long access$getScoreTimeSetting$p(KtvComponentMidiViewModel r2) {
        return r2.scoreTimeSetting;
    }

    public static final /* synthetic */ void access$observeCoreViewModel(KtvComponentMidiViewModel r0) {
        r0.observeCoreViewModel();
    }

    private final void clearScore(String r5) {
        Integer r1 = null;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L5;
    L13:
        this.curScore = 0.0f;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r6 = KtvRoomContext.a.a();
        if (r6 == null) goto L18;
        com.bytedance.live.datacontext.m<Integer> r7 = r6.getMidiSingLyricsLineCount();
        if (r7 == null) goto L18;
        r7.setValue(0);
    L18:
        StringBuilder r8 = new StringBuilder("KSong clearScore, real lyric count: ");
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L23;
        com.bytedance.live.datacontext.m<Integer> r2 = r0.getMidiSingLyricsLineCount();
        if (r2 == null) goto L23;
        r1 = (Integer) r2.getValue();
    L23:
        r8.append(r1);
        r8.append(' ');
        String r9 = r8.toString();
        ALogger.i(bb0.b.b(), r9 + ", invoke class :KtvComponentMidiViewModel");
        return;
    L5:
        if (this.isReported == true) goto L13;
        pd2.d r3 = pd2.d.n;
        StringBuilder r4 = new StringBuilder("KSong clearScore, is from: ");
        r4.append(r5);
        r4.append("; curScore: ");
        r4.append(this.curScore);
        r4.append(", real lyric count: ");
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r10 = KtvRoomContext.a.a();
        if (r10 == null) goto L11;
        com.bytedance.live.datacontext.m<Integer> r11 = r10.getMidiSingLyricsLineCount();
        if (r11 == null) goto L11;
        Integer r12 = (Integer) r11.getValue();
    L12:
        r4.append(r12);
        String r13 = r4.toString();
        r3.getClass();
        pd2.d.I(null, r13);
    L11:
        r12 = null;
        goto L12
    }

    private final void handleSingProgress(Long r2) {
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == false) goto L6;
        this.lyricProgress.setValue(r2);
        return;
    }

    private final void handleState(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r4.c;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L8;
        this.curState.setValue(r4);
        onIdle(r4);
        return;
    L8:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L11;
        this.curState.setValue(r4);
        onPreparing(r4);
        return;
    L11:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L14;
        this.curState.setValue(r4);
        onPaused();
        return;
    L14:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L36;
        Object r1 = r4.a;
        if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L34;
        if (r1 == null) goto L33;
        OrderInfo r2 = ((KtvRoomLyricsStateMachineConfig.d.f) r1).b.a.getOrderInfo();
        String r3 = null;
        if (r2 == null) goto L23;
        InteractiveSongUserInfo r5 = r2.getTopUser();
        if (r5 == null) goto L23;
        String r6 = r5.getIdString();
    L24:
        OrderInfo r7 = ((KtvRoomLyricsStateMachineConfig.d.f) r0).b.a.getOrderInfo();
        if (r7 == null) goto L30;
        InteractiveSongUserInfo r8 = r7.getTopUser();
        if (r8 == null) goto L30;
        r3 = r8.getIdString();
    L30:
        if ((!Intrinsics.areEqual(r6, r3)) == true) goto L34;
        return;
    L23:
        r6 = null;
        goto L24
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
    L34:
        this.curState.setValue(r4);
        return;
    L36:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L44;
        this.curState.setValue(r4);
        return;
    }

    private final boolean isDisposed(Disposable r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (r1.isDisposed() == true) goto L7;
        return false;
    }

    private final void onKtvSeiModelCompat(com.bytedance.android.livesdk.ktvimpl.base.sei.k r6) {
        int r0 = r6.d();
        if (r0 != 0) goto L5;
        initAudienceMidi(r6);
        return;
    L5:
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L9;
    L11:
        tryLoadMidiRes(r6);
        return;
    L9:
        if (r0 == 5) goto L11;
        return;
    L13:
        if (r6.j() <= 0) goto L32;
        List<v> r1 = r6.l();
        boolean r2 = false;
        if (r1 != null) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L33;
        String r7 = r6.t();
        if (r7 != null) goto L25;
    L26:
        r2 = true;
    L27:
        if (r2 == false) goto L34;
        this.showNoMidiHint.setValue(Boolean.TRUE);
        return;
    L34:
        return;
    L25:
        if (r7.length() != 0) goto L27;
    L33:
        return;
    L17:
        if (r1.isEmpty() == true) goto L20;
        r3 = false;
        goto L21
    }

    private final void onMidiSeiModel(com.bytedance.android.livesdk.ktvimpl.base.sei.i r18) {
        Collection r1 = (Collection) this.midiData.getValue();
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        KtvContext.Companion.getClass();
        boolean r4 = KtvContext.a.g().isCurrentUserIsSinger();
        boolean r5 = jc1.k.n(IInteractService.class).isAudienceLinkEngineOn();
        if (r4 == false) goto L14;
        return;
    L14:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L20;
        if (r18.d() != 0) goto L18;
        if (r5 == true) goto L20;
    L18:
        if (r5 == false) goto L20;
        return;
    L20:
        if (this.lastMidiIndex == (-1)) goto L22;
    L26:
        this.curScore = r18.g();
        if (this.lastMidiIndex >= r18.f()) goto L47;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r6 = KtvRoomContext.a.a();
        if (r6 == null) goto L35;
        com.bytedance.live.datacontext.m<Integer> r7 = r6.getMidiSingLyricsLineCount();
        if (r7 == null) goto L35;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L35;
        r2 = r8.intValue();
    L35:
        KtvRoomContext r9 = KtvRoomContext.a.a();
        if (r9 == null) goto L40;
        com.bytedance.live.datacontext.m<Integer> r10 = r9.getMidiSingLyricsLineCount();
        if (r10 == null) goto L40;
        r10.setValue(Integer.valueOf(r2 + 1));
    L40:
        StringBuilder r11 = new StringBuilder("KSong onMidiSeiModel, real lyric count: ");
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L45;
        com.bytedance.live.datacontext.m<Integer> r13 = r12.getMidiSingLyricsLineCount();
        if (r13 == null) goto L45;
        Integer r14 = (Integer) r13.getValue();
    L46:
        r11.append(r14);
        r11.append(' ');
        String r15 = r11.toString();
        ALogger.i(bb0.b.b(), r15 + ", invoke class :KtvComponentMidiViewModel");
        this.lastMidiIndex = r18.f();
    L45:
        r14 = null;
    L47:
        int r16 = r18.c();
        if (r18.c() == (-1)) goto L50;
    L58:
        this.scoreInfo.setValue(new Pair(null, new com.bytedance.android.live.ktv.common.midi.k(r18.j(), r18.i(), 0.0f, r18.g(), r18.f(), Integer.valueOf(r18.e()), r16, false, DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE)));
        return;
    L50:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L58;
        MidiContext.Companion.getClass();
        if (MidiContext.a.e(null) == false) goto L58;
        com.bytedance.android.live.ktv.common.midi.b r17 = this.mHitComboCalculator;
        float r19 = r18.g();
        int r20 = r18.f();
        g0 r21 = (g0) this.midiConfig.getValue();
        if (r21 == null) goto L56;
        Map r22 = r21.b();
    L57:
        r16 = r17.b(r19, r20, r22);
        goto L58
    L56:
        r22 = null;
        goto L57
    L22:
        if (r18.f() != (-1)) goto L26;
        if (r18.g() == 0.0f) goto L26;
        clearScore("onMidiSeiModel sei.index: " + r18.f());
        goto L26
    L5:
        if (r1.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    private final void seekMidiScoreProgress(long r2) {
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    private final void tryLoadMidiRes(com.bytedance.android.livesdk.ktvimpl.base.sei.k r14) {
        if (KtvSettingHelper.f() == true) goto L5;
        return;
    L5:
        boolean r4 = false;
        if (r14.j() > 0) goto L8;
    L17:
        boolean r0 = false;
    L18:
        KtvContext.Companion.getClass();
        boolean r1 = KtvContext.a.g().isCurrentUserIsSinger();
        if (r0 == false) goto L37;
        if (r1 == false) goto L22;
        return;
    L22:
        if (r14.j() != this.curMusicId) goto L29;
        Collection r2 = (Collection) this.midiData.getValue();
        if (r2 != null) goto L26;
    L27:
        r4 = true;
    L28:
        if (r4 == true) goto L29;
        return;
    L26:
        if (r2.isEmpty() == false) goto L28;
    L29:
        this.curMusicId = r14.j();
        com.bytedance.android.live.ktv.common.music.download.h r3 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r7 = com.bytedance.android.live.ktv.common.music.download.h.e(r14.t(), this.curMusicId);
        if (new PolarisFileWrapper(r7).exists() == false) goto L32;
        initMidiRes$default(this, false, this.curMusicId, r7, null, null, false, 32, null);
        return;
    L32:
        com.bytedance.android.live.ktv.common.music.download.k.a r5 = com.bytedance.android.live.ktv.common.music.download.k.a;
        long r6 = this.curMusicId;
        String r15 = r14.t();
        if (r15 != null) goto L35;
        r15 = "";
    L35:
        com.bytedance.android.live.ktv.common.music.download.k.c r8 = new com.bytedance.android.live.ktv.common.music.download.k.c(r6, r15, r7);
        WeakReference r16 = new WeakReference(this.midiDownloadCallback);
        r5.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r8, r16);
        return;
    L37:
        return;
    L8:
        if (r14.n() == 2) goto L17;
        String r9 = r14.t();
        if (r9 == null) goto L17;
        if (r9.length() <= 0) goto L14;
        boolean r10 = true;
    L15:
        if (r10 != true) goto L17;
        r0 = true;
        goto L18
    L14:
        r10 = false;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public boolean accept(w r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r4.b;
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L5;
    L6:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r5 = r4.b;
        if ((r5 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L9;
    L11:
        return false;
    L9:
        if ((!Intrinsics.areEqual(r5.a(), jc1.k.n(IMiddlewareUserService.class).user().n().toString().toString())) == false) goto L11;
        return true;
    L5:
        if ((!Intrinsics.areEqual(r0.a(), jc1.k.n(IMiddlewareUserService.class).user().n().toString().toString())) == false) goto L6;
        return true;
    }

    public final void attach(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        KtvContext.Companion.getClass();
        KtvContext r0 = KtvContext.a.g();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r0.getKtvCoreViewModel();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r2 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
    L8:
        this.coreViewModel = (BaseCoreViewModel) r2;
        ((ObservableSubscribeProxy) KtvContext.a.g().getKtvCoreViewModel().a().as(AutoDispose.bind(r3))).subscribe(new b(this, r3));
        observeCoreViewModel();
        KtvContext r4 = KtvContext.a.g();
        if (r4 == null) goto L16;
        com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.ktvimpl.base.sei.m> r5 = r4.getSeiProcessor();
        if (r5 == null) goto L17;
        com.bytedance.android.livesdk.ktvimpl.base.sei.m r6 = (com.bytedance.android.livesdk.ktvimpl.base.sei.m) r5.getValue();
        if (r6 == null) goto L18;
        r6.c(this, 5.0f);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public Observable<cb0.c> findMidiSegment(long r3) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "findMidiSegment midiData is null");
        return Observable.empty();
    L13:
        return Observable.just(this.midiData.getValue()).filter(e.a).flatMap(f.a).filter(new g(r3));
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public void getScoreInfo(double[] r2) {
        Intrinsics.checkNotNullParameter(r2, "scoreInfo");
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r0 = (com.bytedance.android.livesdk.ktvimpl.base.i) KtvContext.a.g().getKtvCoreController().getValue();
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    public final void initAudienceMidi(com.bytedance.android.livesdk.ktvimpl.base.sei.k r14) {
        Intrinsics.checkNotNullParameter(r14, "sei");
        if (KtvSettingHelper.f() == false) goto L6;
        tryLoadMidiRes(r14);
        return;
    L6:
        if (r14.j() <= 0) goto L28;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L10;
        return;
    L10:
        if (r14.j() != this.curMusicId) goto L12;
        return;
    L12:
        if (r14.n() == 2) goto L31;
        String r0 = r14.t();
        if (r0 != null) goto L16;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == true) goto L25;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "onKtvSeiModelCompat sei.midiUrl is not null");
        this.curMusicId = r14.j();
        com.bytedance.android.live.ktv.common.music.download.h r2 = com.bytedance.android.live.ktv.common.music.download.h.a;
        String r7 = com.bytedance.android.live.ktv.common.music.download.h.e(r14.t(), this.curMusicId);
        if (new PolarisFileWrapper(r7).exists() == false) goto L24;
        initMidiRes$default(this, false, this.curMusicId, r7, null, null, false, 32, null);
        return;
    L24:
        com.bytedance.android.live.ktv.common.music.download.k.a r3 = com.bytedance.android.live.ktv.common.music.download.k.a;
        long r4 = this.curMusicId;
        String r15 = r14.t();
        Intrinsics.checkNotNull(r15);
        com.bytedance.android.live.ktv.common.music.download.k.c r5 = new com.bytedance.android.live.ktv.common.music.download.k.c(r4, r15, r7);
        WeakReference r16 = new WeakReference(this.midiDownloadCallback);
        r3.getClass();
        com.bytedance.android.live.ktv.common.music.download.k.a.b(r5, r16);
        return;
    L25:
        this.showNoMidiHint.setValue(Boolean.TRUE);
        return;
    L16:
        if (r0.length() == 0) goto L19;
        r1 = false;
        goto L20
    L31:
        return;
    }

    public final void onIdle(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r7 = (KtvRoomLyricsStateMachineConfig.d) r6.a;
    L7:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L14;
        pd2.d r1 = pd2.d.n;
        if (r7 == null) goto L11;
        MusicPanel r2 = r7.b();
    L12:
        r1.getClass();
        pd2.d.I(r2, "KSong onIdle: from is singing? : " + (r7 instanceof KtvRoomLyricsStateMachineConfig.d.f));
        goto L14
    L11:
        r2 = null;
    L14:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L36;
        MusicPanel r3 = com.bytedance.android.livesdk.ktvimpl.base.util.o.c((KtvRoomLyricsStateMachineConfig.d.f) r7);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L35;
        pd2.d r4 = pd2.d.n;
        StringBuilder r5 = new StringBuilder("KSong onIdle: cur musicPanel singerId: ");
        MusicPanel r8 = r7.b();
        if (r8 == null) goto L24;
        OrderInfo r9 = r8.d();
        if (r9 == null) goto L24;
        InteractiveSongUserInfo r10 = r9.getTopUser();
        if (r10 == null) goto L24;
        String r11 = r10.getIdString();
    L25:
        r5.append(r11);
        r5.append("   sei senderId: ");
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r12 = ((KtvRoomLyricsStateMachineConfig.d.f) r7).c;
        if (r12 == null) goto L28;
        String r13 = r12.A();
    L29:
        r5.append(r13);
        r5.append("    getMidiScoreSeiRealMusicPanel musicSingerId: ");
        OrderInfo r14 = r3.d();
        if (r14 == null) goto L34;
        InteractiveSongUserInfo r15 = r14.getTopUser();
        if (r15 == null) goto L34;
        r0 = r15.getIdString();
    L34:
        r5.append(r0);
        String r16 = r5.toString();
        r4.getClass();
        pd2.d.I(r3, r16);
        goto L35
    L28:
        r13 = null;
    L24:
        r11 = null;
    L35:
        onSingFinish(KtvUtilsKt.w(r3.a), r3);
    L36:
        tryHideFeedback(false);
        return;
    L5:
        r7 = null;
        goto L7
    }

    public final void onPreparing(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r7 = (KtvRoomLyricsStateMachineConfig.d) r6.a;
    L7:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L14;
        pd2.d r1 = pd2.d.n;
        if (r7 == null) goto L11;
        MusicPanel r2 = r7.b();
    L12:
        r1.getClass();
        pd2.d.I(r2, "KSong onPreparing: from is singing? : " + (r7 instanceof KtvRoomLyricsStateMachineConfig.d.f));
        goto L14
    L11:
        r2 = null;
    L14:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L37;
        MusicPanel r3 = com.bytedance.android.livesdk.ktvimpl.base.util.o.c((KtvRoomLyricsStateMachineConfig.d.f) r7);
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L35;
        pd2.d r4 = pd2.d.n;
        StringBuilder r5 = new StringBuilder("KSong onPreparing: cur musicPancel singerId: ");
        MusicPanel r8 = r7.b();
        if (r8 == null) goto L24;
        OrderInfo r9 = r8.d();
        if (r9 == null) goto L24;
        InteractiveSongUserInfo r10 = r9.getTopUser();
        if (r10 == null) goto L24;
        String r11 = r10.getIdString();
    L25:
        r5.append(r11);
        r5.append("   sei senderId: ");
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r12 = ((KtvRoomLyricsStateMachineConfig.d.f) r7).c;
        if (r12 == null) goto L28;
        String r13 = r12.A();
    L29:
        r5.append(r13);
        r5.append("   getMidiScoreSeiRealMusicPanel musicSingerId: ");
        OrderInfo r14 = r3.d();
        if (r14 == null) goto L34;
        InteractiveSongUserInfo r15 = r14.getTopUser();
        if (r15 == null) goto L34;
        r0 = r15.getIdString();
    L34:
        r5.append(r0);
        String r16 = r5.toString();
        r4.getClass();
        pd2.d.I(r3, r16);
        goto L35
    L28:
        r13 = null;
    L24:
        r11 = null;
    L35:
        onSingFinish(KtvUtilsKt.w(r3.a), r3);
        tryHideFeedback(true);
        return;
    L37:
        return;
    L5:
        r7 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r2.b;
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L6;
        onKtvSeiModelCompat((com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3);
        return;
    L6:
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == false) goto L10;
        onMidiSeiModel((com.bytedance.android.livesdk.ktvimpl.base.sei.i) r3);
        return;
    }

    public final void onSinging(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r12) {
        Intrinsics.checkNotNullParameter(r12, "ktvCoreDataModel");
        MusicPanel r0 = r12.a;
        if (r0 != null) goto L5;
        return;
    L5:
        KtvContext.Companion.getClass();
        boolean r1 = KtvContext.a.g().isCurrentUserIsSinger();
        if (this.midiData.getValue() == null) goto L8;
        return;
    L8:
        if (KtvUtilsKt.w(r0.a) == false) goto L15;
        if (r1 == false) goto L15;
        long r5 = r0.a.getMId();
        String r7 = r0.q;
        String r8 = r0.l;
        String r9 = r0.p;
        if (r0.a.getMLyricType() != 2) goto L13;
        boolean r10 = true;
    L14:
        initMidiRes(true, r5, r7, r8, r9, r10);
        return;
    L13:
        r10 = false;
    L15:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r13 = r12.b;
        if (r13 == null) goto L21;
        initAudienceMidi(r13);
        return;
    }

    public final void resetMidiRecord(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L5;
    L7:
        this.isReported = false;
        return;
    L5:
        if (this.isReported == true) goto L7;
        pd2.d.n.getClass();
        pd2.d.I(null, "KSong resetMidiRecord, is from: " + r4);
        goto L7
    }

    public void setCurTotalScore(int r1) {
        this.curTotalScore = r1;
    }

    public final void setMidiConfig(MutableLiveData<g0> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.midiConfig = r2;
    }

    public final void setShowNoMidiHint(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.showNoMidiHint = r2;
    }

    public void setTotalScore(int r1) {
        this.totalScore = r1;
    }

    public void setUserOpenScore(boolean r1) {
        this.userOpenScore = r1;
    }

    public final void startFeedBackShowTimer(Long r4) {
        Disposable r0 = this.feedbackDisposable;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isDisposed() == true) goto L7;
        return;
    L7:
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "startFeedBackShowTimer");
        this.feedbackTiming = true;
        this.feedbackDisposable = Observable.timer(vm2.d.Y(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this, r4));
    }

    public final void tryHideFeedback(boolean r3) {
        if (this.needHideFeedback == true) goto L7;
        if (r3 == true) goto L6;
        return;
    L6:
        if (this.feedbackTiming == true) goto L7;
        return;
    L7:
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "tryHideFeedback needHideFeedback :" + this.needHideFeedback + " inNextSong: " + r3);
        this.hideFeedback.setValue(Boolean.TRUE);
        this.needHideFeedback = false;
        Disposable r0 = this.feedbackDisposable;
        if (r0 == null) goto L10;
        r0.dispose();
    L10:
        this.feedbackTiming = false;
    }

    public final void tryStartGetScoreInfoTimer(Long r6) {
        if (isDisposed(this.scoreDisposable) == true) goto L9;
        if (r6 != null) goto L6;
        return;
    L6:
        if (Math.abs(this.curMidiProgress - r6.longValue()) <= 1000) goto L47;
        this.curMidiProgress = r6.longValue();
        seekMidiScoreProgress(r6.longValue());
        return;
    L47:
        return;
    L9:
        boolean r1 = true;
        if (KtvSettingHelper.g().b() == 1) goto L12;
        return;
    L12:
        KtvComponentUIContext r0 = getKtvComponentUIContext();
        if (r0 == null) goto L18;
        MutableLiveData<Boolean> r2 = r0.getScoreOpen();
        if (r2 == null) goto L18;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L18;
    L20:
        if (r3.booleanValue() == true) goto L22;
        return;
    L22:
        Collection r4 = (Collection) this.midiData.getValue();
        if (r4 == null) goto L29;
        if (r4.isEmpty() == true) goto L29;
        r1 = false;
    L29:
        if (r1 == false) goto L33;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "tryStartGetScoreInfoTimer midiData is null");
        return;
    L33:
        if (isDisposed(this.scoreDisposable) == false) goto L48;
        if (r6 == null) goto L49;
        BaseCoreViewModel r5 = this.coreViewModel;
        if (r5 == null) goto L38;
        KtvRoomLyricsStateMachineConfig.d r7 = r5.getCurState();
    L40:
        if ((r7 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L50;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "tryStartGetScoreInfoTimer, progress = " + r6);
        this.curMidiProgress = r6.longValue();
        if (r6.longValue() <= 1000) goto L44;
        seekMidiScoreProgress(r6.longValue());
    L44:
        this.scoreDisposable = du2.a.d(this.scoreTimeSetting, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this));
        return;
    L50:
        return;
    L38:
        r7 = null;
        goto L40
    L49:
        return;
    L48:
        return;
    L18:
        r3 = Boolean.FALSE;
        goto L20
    }

    public final void onPreparing(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r12) {
        Intrinsics.checkNotNullParameter(r12, "ktvCoreDataModel");
        MusicPanel r0 = r12.a;
        if (r0 != null) goto L5;
        return;
    L5:
        resetMidiData();
        this.curMusicId = 0;
        if (KtvUtilsKt.w(r0.a) == false) goto L12;
        long r5 = r0.a.getMId();
        String r7 = r0.q;
        String r8 = r0.l;
        String r9 = r0.p;
        if (r0.a.getMLyricType() != 2) goto L10;
        boolean r10 = true;
    L11:
        initMidiRes(true, r5, r7, r8, r9, r10);
    L18:
        tryHideFeedback(true);
        return;
    L10:
        r10 = false;
        goto L11
    L12:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r13 = r12.b;
        if (r13 == null) goto L15;
        initAudienceMidi(r13);
    L15:
        Disposable r14 = this.scoreDisposable;
        if (r14 == null) goto L18;
        r14.dispose();
        goto L18
    }

    public static final /* synthetic */ void access$handleSingProgress(KtvComponentMidiViewModel r0, Long r1) {
        r0.handleSingProgress(r1);
    }

    public static final /* synthetic */ void access$handleState(KtvComponentMidiViewModel r0, StateMachine.c.b r1) {
        r0.handleState(r1);
    }

    public static final /* synthetic */ void access$setCoreViewModel$p(KtvComponentMidiViewModel r0, BaseCoreViewModel r1) {
        r0.coreViewModel = r1;
    }

    public static final /* synthetic */ void access$setCurMidiProgress$p(KtvComponentMidiViewModel r0, long r1) {
        r0.curMidiProgress = r1;
    }

    public static final /* synthetic */ void access$setCurMusicId$p(KtvComponentMidiViewModel r0, long r1) {
        r0.curMusicId = r1;
    }

    public static final /* synthetic */ void access$setFeedbackTiming$p(KtvComponentMidiViewModel r0, boolean r1) {
        r0.feedbackTiming = r1;
    }

    public static final /* synthetic */ void access$setNeedHideFeedback$p(KtvComponentMidiViewModel r0, boolean r1) {
        r0.needHideFeedback = r1;
    }

    private final void handleStateCoreData(KtvRoomLyricsStateMachineConfig.d r3, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r4) {
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L6;
        onPreparing(r4);
    L8:
        this.coreData.setValue(new Pair(r3, r4));
        return;
    L6:
        if ((r3 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L8;
        onSinging(r4);
        goto L8
    }

    private final boolean isNeedSendMidiSei(float r6, int r7) {
        if (r6 >= this.scoreRangeSetting) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == this.lastMidiHitFlag) goto L9;
        this.lastMidiHitFlag = r8;
        boolean r9 = true;
    L11:
        if (r7 <= this.lastMidiIndex) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L29;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r3 = KtvRoomContext.a.a();
        if (r3 == null) goto L22;
        com.bytedance.live.datacontext.m<Integer> r4 = r3.getMidiSingLyricsLineCount();
        if (r4 == null) goto L22;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L22;
        int r10 = r5.intValue();
    L23:
        KtvRoomContext r11 = KtvRoomContext.a.a();
        if (r11 == null) goto L28;
        com.bytedance.live.datacontext.m<Integer> r12 = r11.getMidiSingLyricsLineCount();
        if (r12 == null) goto L28;
        r12.setValue(Integer.valueOf(r10 + 1));
    L28:
        this.lastMidiIndex = r7;
    L22:
        r10 = 0;
    L29:
        if (r9 == true) goto L31;
        if (r0 == true) goto L31;
        return false;
    L31:
        return true;
    L13:
        r0 = false;
        goto L14
    L9:
        r9 = false;
        goto L11
    L5:
        r8 = false;
        goto L7
    }

    public Single<List<cb0.c>> findMidiSegments(long r3, long r5) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "findMidiSegments midiData is null");
        return null;
    L13:
        return Observable.just(this.midiData.getValue()).filter(h.a).flatMap(i.a).filter(new j(r5, r3)).toList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public List<cb0.c> findMidiSegmentsNew(long r10, long r12) {
        Collection r0 = (Collection) this.midiData.getValue();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        ArrayList r3 = null;
        if (r1 == false) goto L13;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "findMidiSegmentsNew midiData is null");
        return null;
    L13:
        List r2 = (List) this.midiData.getValue();
        if (r2 == null) goto L26;
        r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L26;
        Object r5 = r4.next();
        cb0.a r6 = ((cb0.c) r5).a;
        if (r6.a < r12) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L17;
        r3.add(r5);
        goto L17
    L21:
        if (r6.b <= r10) goto L23;
        r7 = true;
    L26:
        return r3;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void onSingFinish(boolean r4, MusicPanel r5) {
        if (r5 == null) goto L19;
        if (r4 == false) goto L13;
        Disposable r6 = this.scoreDisposable;
        if (r6 == null) goto L8;
        r6.dispose();
    L8:
        Disposable r7 = this.midiDisposable;
        if (r7 == null) goto L11;
        r7.dispose();
    L11:
        this.curMidiProgress = 0;
    L13:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L15;
    L18:
        clearScore("onSingFinish");
        goto L19
    L15:
        if (this.isReported == true) goto L17;
        reportScore(r5, "onSingFinish");
    L17:
        resetMidiRecord("onSingFinish");
    L19:
        this.midiData.setValue(null);
        this.lastMidiHitFlag = false;
        this.lastMidiIndex = -1;
        this.mHitComboCalculator.a();
        this.curMusicId = 0;
    }

    public final void reportScore(MusicPanel r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "musicPanel");
        Intrinsics.checkNotNullParameter(r26, "isFrom");
        if (this.isReported == true) goto L69;
        InteractiveSongUserInfo r3 = r25.f();
        String r4 = null;
        if (r3 == null) goto L7;
        String r5 = r3.getIdString();
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L70;
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "reportScore");
        float r6 = this.curScore;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r7 = KtvRoomContext.a.a();
        if (r7 == null) goto L17;
        com.bytedance.live.datacontext.m<Integer> r8 = r7.getMidiTotalLyricsLineCount();
        if (r8 == null) goto L17;
        Integer r9 = (Integer) r8.getValue();
        if (r9 == null) goto L17;
    L23:
        int r10 = 0;
        if (r9 == null) goto L26;
        int r11 = r9.intValue();
    L27:
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L34;
        com.bytedance.live.datacontext.m<Integer> r13 = r12.getMidiSingLyricsLineCount();
        if (r13 == null) goto L34;
        Integer r14 = (Integer) r13.getValue();
        if (r14 == null) goto L34;
        r10 = r14.intValue();
    L34:
        com.bytedance.android.livesdk.chatroom.o r15 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r15 == null) goto L41;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L41;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L41;
        long r18 = r17.getRoomId();
    L42:
        long r19 = r18;
        if (this.isReported == true) goto L57;
        pd2.d r20 = pd2.d.n;
        StringBuilder r21 = new StringBuilder("KSong reportScore api start. isFrom: ");
        r21.append(r26);
        r21.append(", score: ");
        r21.append(r6);
        r21.append("  realLyricsCount: ");
        r21.append(r10);
        r21.append("  totalLyricCount: ");
        r21.append(r11);
        r21.append(" (lyricsChangeLiveData#LyricsSize: ");
        KtvContext.Companion.getClass();
        ub0.a r2 = (ub0.a) KtvContext.a.g().getLyricsChangeLiveData().getValue();
        if (r2 == null) goto L49;
        List r22 = r2.a();
        if (r22 == null) goto L49;
        Integer r23 = Integer.valueOf(r22.size());
    L50:
        r21.append(r23);
        r21.append("  midiTotalLyricsSize: ");
        KtvRoomContext r24 = KtvRoomContext.a.a();
        if (r24 == null) goto L55;
        com.bytedance.live.datacontext.m<Integer> r27 = r24.getMidiTotalLyricsLineCount();
        if (r27 == null) goto L55;
        Integer r28 = (Integer) r27.getValue();
    L56:
        r21.append(r28);
        r21.append("  ");
        String r29 = r21.toString();
        r20.getClass();
        pd2.d.I(r25, r29);
    L55:
        r28 = null;
    L49:
        r23 = null;
    L57:
        this.isReported = true;
        KtvRoomApi r110 = (KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class);
        long r111 = r25.a.getMId();
        double r30 = r6;
        InteractiveSongUserInfo r31 = r25.f();
        if (r31 == null) goto L60;
        String r32 = r31.getIdString();
    L61:
        long r112 = d5.c(r32);
        InteractiveSongUserInfo r33 = r25.f();
        if (r33 == null) goto L64;
        r4 = r33.getIdString();
    L64:
        Disposable r1 = r110.reportMidiScore(r111, r19, r30, r112, r4, r11, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(this, r25, r6), new r(this, r25, r6));
        if (r1 == null) goto L67;
        RxUtilKt.c(r1, this.compositeDispose);
    L67:
        clearScore("reportScore");
        return;
    L60:
        r32 = null;
    L41:
        r18 = 0;
        goto L42
    L26:
        r11 = 0;
    L17:
        KtvContext.Companion.getClass();
        ub0.a r34 = (ub0.a) KtvContext.a.g().getLyricsChangeLiveData().getValue();
        if (r34 == null) goto L22;
        List r35 = r34.a();
        if (r35 == null) goto L22;
        r9 = Integer.valueOf(r35.size());
    L22:
        r9 = null;
        goto L23
    L70:
        return;
    L7:
        r5 = null;
        goto L9
    }

    public static final /* synthetic */ void access$handleStateCoreData(KtvComponentMidiViewModel r0, KtvRoomLyricsStateMachineConfig.d r1, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r2) {
        r0.handleStateCoreData(r1, r2);
    }

    private final float calScore(float r3, float r4, int r5) {
        if (r5 >= 0) goto L4;
        return r4;
    L4:
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Map<Integer, Float>> r1 = r0.getScoreMap();
        if (r1 == null) goto L9;
        Map r2 = (Map) r1.getValue();
    L10:
        int r6 = 1;
        if (r2 == null) goto L21;
        r2.put(Integer.valueOf(r5), Float.valueOf(r4));
        Iterator r7 = r2.values().iterator();
        float r8 = 0.0f;
    L14:
        if (r7.hasNext() == false) goto L17;
        r8 = r8 + ((Number) r7.next()).floatValue();
        goto L14
    L17:
        if (r2.isEmpty() == true) goto L20;
        r6 = r2.size();
    L20:
        float r9 = r8 / r6;
    L23:
        if (r9 <= 100.0f) goto L25;
        r9 = 100.0f;
    L25:
        this.curScore = r9;
        return r9;
    L21:
        r9 = r3 / (r5 + 1);
    L9:
        r2 = null;
        goto L10
    }

    public static /* synthetic */ void tryHideFeedback$default(KtvComponentMidiViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.tryHideFeedback(r1);
    }

    public static /* synthetic */ void reportScore$default(KtvComponentMidiViewModel r0, MusicPanel r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.reportScore(r1, r2);
    }

    private final void initMidiRes(boolean r3, long r4, String r6, String r7, String r8, boolean r9) {
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "initMidiRes isSinger :" + r3);
        if (TextUtils.isEmpty(r6) == true) goto L18;
        if (r9 == true) goto L18;
        if (isDisposed(this.midiDisposable) == false) goto L20;
        Collection r10 = (Collection) this.midiData.getValue();
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == false) goto L21;
        this.midiDisposable = Single.create(new k(r3, r7, r6, r8)).map(new l(r3, r6)).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(this), new n(this, r4));
        return;
    L21:
        return;
    L11:
        if (r10.isEmpty() == true) goto L14;
        r11 = false;
        goto L15
    L20:
        return;
    L18:
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "initMidiRes fail, midiPath == null || isLrcLyric");
        this.showNoMidiHint.setValue(Boolean.TRUE);
    }

    public static /* synthetic */ void initMidiRes$default(KtvComponentMidiViewModel r9, boolean r10, long r11, String r13, String r14, String r15, boolean r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L5;
        boolean r8 = false;
    L6:
        r9.initMidiRes(r10, r11, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    private final void sendMidiFeedbackSei(String r5, String r6, String r7, String r8, long r9, String r11, float r12, boolean r13, String r14, boolean r15, long r16, String r18, double r19) {
        com.bytedance.android.live.ktv.common.midi.e.b(TAG, "sendMidiFeedbackSei");
        JSONObject r0 = com.bytedance.android.livesdk.ktvimpl.base.sei.t.b(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r18, r19);
        BaseCoreViewModel r2 = this.coreViewModel;
        if (r2 == null) goto L6;
        r2.sendSei("ktv_midi_feedback_sei", r0);
        return;
    }

    public static final /* synthetic */ void access$sendMidiFeedbackSei(KtvComponentMidiViewModel r0, String r1, String r2, String r3, String r4, long r5, String r7, float r8, boolean r9, String r10, boolean r11, long r12, String r14, double r15) {
        r0.sendMidiFeedbackSei(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r14, r15);
    }
}
