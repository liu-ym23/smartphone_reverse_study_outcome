package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.model.api.SingingHotResultRankType;
import com.bytedance.android.live.ktv.common.model.api.d0;
import com.bytedance.android.live.ktv.common.model.api.e0;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.config.e9;
import com.bytedance.android.livesdk.config.f9;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.KtvDressRoomDataSyncModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.KtvSingerViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.qd;
import com.bytedance.android.livesdk.message.model.td;
import com.bytedance.android.livesdk.message.model.ud;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.Action;
import com.bytedance.android.livesdkapi.depend.message.KtvDressSyncData;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import fd2.y;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000¬\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 ñ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ò\u0001B\u001d\u0012\b\u0010Ô\u0001\u001a\u00030Ó\u0001\u0012\b\u0010Ù\u0001\u001a\u00030Ø\u0001¢\u0006\u0006\bï\u0001\u0010ð\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J3\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00102!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0018H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\"\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010!\u001a\u00020\nH\u0002J\f\u0010#\u001a\u00020\u0004*\u00020\u0010H\u0002J\f\u0010$\u001a\u00020\u0004*\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u001c\u0010+\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\n\u0010*\u001a\u00060(j\u0002`)H\u0014J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u00101\u001a\u00020\u00042\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010/H\u0014J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0014J\b\u00104\u001a\u00020\u0004H\u0016J\u0014\u00107\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000405J\b\u00109\u001a\u0004\u0018\u000108J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0014J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<J\u000e\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020<J\u0010\u0010C\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010AJ\u0010\u0010F\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00010DJ\u000e\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0019J\b\u0010I\u001a\u00020\u0004H\u0014J\u0018\u0010K\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010*\u001a\u00020JH\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\u0006\u0010*\u001a\u00020LH\u0014J\u001f\u0010P\u001a\u00020\u00042\u0017\u0010O\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020M0\u0018¢\u0006\u0002\bNJ\u000e\u0010Q\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010J\u0012\u0010T\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010RH\u0016J\b\u0010U\u001a\u0004\u0018\u00010&J\b\u0010V\u001a\u00020\u0004H\u0014J\u0012\u0010Y\u001a\f\u0012\u0006\b\u0001\u0012\u00020X\u0018\u00010WH\u0014J\u0016\u0010\\\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\nJ\u0010\u0010]\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020<J\u0006\u0010^\u001a\u00020<J\u0006\u0010_\u001a\u00020\nJ\u0006\u0010`\u001a\u00020<J\u0012\u0010a\u001a\u00020<2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010<J\b\u0010b\u001a\u0004\u0018\u00010\rJ\u000e\u0010e\u001a\u00020\n2\u0006\u0010d\u001a\u00020cJ\u0006\u0010f\u001a\u00020\nJ\u001a\u0010j\u001a\u00020\u00042\u0006\u0010g\u001a\u00020<2\b\u0010i\u001a\u0004\u0018\u00010hH\u0016R\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020o0n8\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0016\u0010t\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00190v8\u0006¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020{0v8\u0006¢\u0006\f\n\u0004\b|\u0010x\u001a\u0004\b}\u0010zR8\u0010\u0082\u0001\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~j\u0003`\u0081\u00010v8\u0006¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010x\u001a\u0005\b\u0083\u0001\u0010zR\u001f\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\n0v8\u0006¢\u0006\r\n\u0005\b\u0084\u0001\u0010x\u001a\u0004\b>\u0010zR.\u0010\u0087\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0005\u0012\u00030\u0086\u00010\u0085\u00010v8\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010x\u001a\u0005\b\u0088\u0001\u0010zR\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R!\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010v8\u0006¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010x\u001a\u0005\b\u008e\u0001\u0010zR,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R!\u0010\u0096\u0001\u001a\u00020<8B@\u0002X\u0082\u000e¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R,\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010uR\u0018\u0010¥\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0001\u0010uR\u001a\u0010§\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R,\u0010ª\u0001\u001a\u0005\u0018\u00010©\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R,\u0010°\u0001\u001a\u0005\u0018\u00010©\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0001\u0010«\u0001\u001a\u0006\b±\u0001\u0010\u00ad\u0001\"\u0006\b²\u0001\u0010¯\u0001R \u0010´\u0001\u001a\u00030³\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R*\u0010¸\u0001\u001a\u00030³\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010µ\u0001\u001a\u0006\b¹\u0001\u0010·\u0001\"\u0006\bº\u0001\u0010»\u0001R\u0018\u0010½\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0018\u0010À\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u0016\u0010Â\u0001\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÂ\u0001\u0010uR\u001a\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R \u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020M0n8\u0006¢\u0006\u000e\n\u0005\bÆ\u0001\u0010q\u001a\u0005\bÇ\u0001\u0010sR\u001b\u0010È\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001a\u0010Ë\u0001\u001a\u00030Ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R \u0010Î\u0001\u001a\u00030Í\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÎ\u0001\u0010Ï\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010\u008b\u0001R \u0010Ô\u0001\u001a\u00030Ó\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001R \u0010Ù\u0001\u001a\u00030Ø\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001R\u001a\u0010à\u0001\u001a\u0005\u0018\u00010Ý\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u001a\u0010ä\u0001\u001a\u0005\u0018\u00010á\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u001a\u0010è\u0001\u001a\u0005\u0018\u00010å\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0015\u0010ì\u0001\u001a\u00030é\u00018F¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0014\u0010í\u0001\u001a\u00020\n8F¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001¨\u0006ó\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "Ltb0/a;", "Lvlc/l;", "", "startListenerCountDownTimer", "observeSingEndedFeedbackSei", "fastKtvEnterRoomStage", "showPreviewCardWhenEnterRoom", "Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "", "needCheck", "tryUpdateSingerAvatar", "Lcom/bytedance/android/livesdk/message/model/InteractiveSongUserInfo;", "recordSingerModel", "initKtvDressSyncData", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "sendSingerBeginSing", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/d;", "ktvCoreDataModel", "onSinging", "onPreparing", "currentMusic", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "time", "countDownCb", "startCountDown", "checkUserInfoBounce", "user", "isPreparing", "notifyKtvStageLabelShow", "updateSingerName", "updateSingerAvatar", "getKtvUserWeeklyHotRank", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "from", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$e;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/PrepareState;", "to", "onEnterPrepareState", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "init", "", "list", "onMusicListChange", "onBizEnterRoom", "initImMessage", "onBizLeaveRoom", "Lkotlin/Function0;", "cb", "onlyRunInRoom", "Lcom/bytedance/android/livesdkapi/depend/message/KtvDressSyncData;", "getKtvMidiSkinDress", "observeCoreViewModel", "beginSing", "", "toUserId", "getSingerFollowState", "userId", "followSinger", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/n;", "feedbackData", "openSingleContributionRank", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "toUser", "getToUserType", "rankType", "openKtvSingingRank", "onIdle", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$d;", "onPause", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$f;", "Loe2/f;", "Lkotlin/ExtensionFunctionType;", "reducer", "updateStage", "getUserContributorHotRank", "Ltlc/d;", "message", "onMessage", "getCurState", "onCleared", "Ljava/lang/Class;", "Lcom/bytedance/live/datacontext/DataContext;", "provideDataService", "hotrank", "isFever", "onSingHotClick", "showSingerUserProfiler", "getCurrentSingerUserId", "inOnSing", "getUserType", "getCurSingerName", "currentSongUser", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "music", "isSinger", "isPureCleanMode", "syncKey", "", "value", "consumeWrdsData", "Lcom/bytedance/android/live/ktv/common/util/e;", "bizLifeCycle", "Lcom/bytedance/android/live/ktv/common/util/e;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/message/model/qd;", "ktvMicLabelEvent", "Landroidx/lifecycle/MutableLiveData;", "getKtvMicLabelEvent", "()Landroidx/lifecycle/MutableLiveData;", "hasProcessFeedWrds", "Z", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "singHotRank", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getSingHotRank", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/x;", "ktvsingHotInfo", "getKtvsingHotInfo", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "stateChangeEvent", "getStateChangeEvent", "singerFollowState", "Lkotlin/Pair;", "Lcom/bytedance/android/live/ktv/common/model/bean/a;", "countDownEvent", "getCountDownEvent", "Lio/reactivex/disposables/Disposable;", "prepareCountDownDisposable", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/k;", "feedSeiModel", "getFeedSeiModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "coreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "getCoreViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "setCoreViewModel", "(Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;)V", "currentUserId", "Ljava/lang/String;", "getCurrentUserId", "()Ljava/lang/String;", "Lvlc/d;", "messageManager", "Lvlc/d;", "getMessageManager", "()Lvlc/d;", "setMessageManager", "(Lvlc/d;)V", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "lyricsResourceManager", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/h;", "userInfoViewShownReported", "userInfoShowFromOrderSongList", "Loe2/j;", "singerImageModelRecord", "Loe2/j;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/b;", "lyricStateReceiver", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/b;", "getLyricStateReceiver", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/b;", "setLyricStateReceiver", "(Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/b;)V", "mvDataReceiver", "getMvDataReceiver", "setMvDataReceiver", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "liveRoomCompositeDisposable", "getLiveRoomCompositeDisposable", "setLiveRoomCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "Lle2/a;", "mFeedBackSeiHandler", "Lle2/a;", "Lle2/b;", "mSinghotSeiHandler", "Lle2/b;", "enableFixMemLeak", "Lcom/bytedance/android/livesdk/a;", "seriousDegradeStrategy", "Lcom/bytedance/android/livesdk/a;", "stageUiState", "getStageUiState", "midiSkinSyncData", "Lcom/bytedance/android/livesdkapi/depend/message/KtvDressSyncData;", "", "repeatDuration", "J", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/b;", "mCoreListener", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/b;", "getMCoreListener", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/b;", "timerDisposable", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "Lsb0/b;", "dataEntity", "Lsb0/b;", "getDataEntity", "()Lsb0/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/KtvSingerViewModel;", "getSingerViewModel", "()Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/KtvSingerViewModel;", "singerViewModel", "Loe2/d;", "getRoomModel", "()Loe2/d;", "roomModel", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lsb0/e;", "getRoomEntity", "()Lsb0/e;", "roomEntity", "isAnchor", "()Z", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;Lsb0/b;)V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class KtvRoomViewModel extends AbsKWidgetViewModel implements tb0.a, vlc.l {
    public static final int COUNT_DOWN_TIME_INIT_VALUE = 5;
    public static final a Companion = null;
    public static final String TAG = "KtvRoomViewModel";
    private final com.bytedance.android.live.ktv.common.util.e bizLifeCycle;
    private final CompositeDisposable compositeDisposable;
    private BaseCoreViewModel coreViewModel;
    private final NextLiveData<Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a>> countDownEvent;
    private String currentUserId;
    private final sb0.b dataEntity;
    private final boolean enableFixMemLeak;
    private final NextLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> feedSeiModel;
    private boolean hasProcessFeedWrds;
    private final KtvContext ktvContext;
    private final MutableLiveData<qd> ktvMicLabelEvent;
    private final NextLiveData<x> ktvsingHotInfo;
    private CompositeDisposable liveRoomCompositeDisposable;
    private com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b lyricStateReceiver;
    private final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h lyricsResourceManager;
    private final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b mCoreListener;
    private final le2.a mFeedBackSeiHandler;
    private final le2.b mSinghotSeiHandler;
    private vlc.d messageManager;
    private KtvDressSyncData midiSkinSyncData;
    private com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b mvDataReceiver;
    private Disposable prepareCountDownDisposable;
    private long repeatDuration;
    private final com.bytedance.android.livesdk.a seriousDegradeStrategy;
    private final NextLiveData<Integer> singHotRank;
    private final NextLiveData<Boolean> singerFollowState;
    private oe2.j singerImageModelRecord;
    private final MutableLiveData<oe2.f> stageUiState;
    private final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> stateChangeEvent;
    private Disposable timerDisposable;
    private boolean userInfoShowFromOrderSongList;
    private boolean userInfoViewShownReported;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.android.live.ktv.common.music.download.p.a {
        public final /* synthetic */ KtvRoomViewModel a;
        public final /* synthetic */ MusicPanel b;

        public final void c(MusicPanel r1, int r2) {
        }

        public b(KtvRoomViewModel r1, MusicPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(MusicPanel r1, String r2, String r3) {
            ALogger.d(KtvRoomViewModel.TAG, "onPreparingSinging download onSuccessed.");
            KtvRoomViewModel.access$sendSingerBeginSing(this.a, this.b);
        }

        public final void b(MusicPanel r1, int r2, String r3) {
            ALogger.d(KtvRoomViewModel.TAG, "onPreparingSinging download onFailed.");
            KtvRoomViewModel.access$sendSingerBeginSing(this.a, this.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;

        public c(KtvRoomViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            KtvRoomViewModel.access$showPreviewCardWhenEnterRoom(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;

        public d(KtvRoomViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            NextLiveData<Boolean> r0 = this.a.getSingerFollowState();
            if (((IFollowPair) r2).getFollowStatus() == 0) goto L5;
            boolean r3 = true;
        L6:
            r0.setValue(Boolean.valueOf(r3));
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public e(KtvRoomViewModel r1) {
        }

        public final void accept(Object r3) {
            CustomApiServerException r4 = (Throwable) r3;
            ALogger.i(bb0.b.b(), "followSinger exception., invoke class :KtvRoomViewModel");
            if ((r4 instanceof CustomApiServerException) == false) goto L8;
            CustomApiServerException r5 = r4;
            if (TextUtils.isEmpty(r5.getPrompt()) == true) goto L9;
            f2.c(r5.getPrompt(), 0);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;
        public final /* synthetic */ long b;

        public f(KtvRoomViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetUserWeeklyHotRankPos, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
            e0 r9 = (e0) ((ExtraResponse) r8).data;
            if (r9 == null) goto L5;
            Integer r10 = Integer.valueOf(r9.a());
        L6:
            final int r11 = r10.intValue();
            this.a.getSingHotRank().postValue(Integer.valueOf(r11));
            com.bytedance.android.livesdk.ktvapi.util.d.b(this.a.getKtvMicLabelEvent(), new KtvRoomViewModel$getKtvUserWeeklyHotRank$1$1$1(r11));
            return;
        L5:
            r10 = null;
            goto L6
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ long a;

        public g(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            ALogger.i("ttlive_ktv", String.valueOf(r8.getMessage()));
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiGetUserWeeklyHotRankPos, System.currentTimeMillis() - this.a, r8);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;
        public final /* synthetic */ long b;

        public h(KtvRoomViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            StringBuilder r0 = new StringBuilder("getSingerFollowState, isFollow: ");
            if (r8 == null) goto L7;
            com.bytedance.android.live.ktv.common.model.api.n r1 = (com.bytedance.android.live.ktv.common.model.api.n) ((ExtraResponse) r8).data;
            if (r1 == null) goto L7;
            Boolean r2 = Boolean.valueOf(r1.a());
        L8:
            r0.append(r2);
            String r3 = r0.toString();
            ALogger.i(bb0.b.b(), r3 + ", invoke class :KtvRoomViewModel");
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetUserFollowRelation, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
            this.a.getSingerFollowState().setValue(Boolean.valueOf(((com.bytedance.android.live.ktv.common.model.api.n) ((ExtraResponse) r8).data).a()));
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ long a;

        public i(KtvRoomViewModel r1, long r2) {
            this.a = r2;
        }

        public final void accept(Object r7) {
            ALogger.i(bb0.b.b(), "getSingerFollowState exception, invoke class :KtvRoomViewModel");
            pd2.d r0 = pd2.d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetUserFollowRelation;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;
        public final /* synthetic */ long b;

        public j(KtvRoomViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiGetUserSongContributorRank, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
            td r0 = new td();
            d0 r1 = (d0) ((ExtraResponse) r8).data;
            Long r2 = null;
            if (r1 == null) goto L5;
            Long r3 = Long.valueOf(r1.a());
        L6:
            r0.hot = r3.longValue();
            d0 r9 = (d0) ((ExtraResponse) r8).data;
            if (r9 == null) goto L9;
            r2 = Long.valueOf(r9.b());
        L9:
            r0.hotLevel = (int) r2.longValue();
            r0.hotStatus = td.FIRST_ENTER_FLAG;
            NextLiveData<x> r10 = this.a.getKtvsingHotInfo();
            int r4 = x.d;
            Intrinsics.checkNotNullParameter(r0, "$this$transferToInfo");
            r10.postValue(new x(r0.hotStatus, r0.hotLevel, r0.hot));
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ long a;

        public k(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiGetUserSongContributorRank, System.currentTimeMillis() - this.a, r8);
            ALogger.i("ttlive_ktv", String.valueOf(r8.getMessage()));
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;

        public l(KtvRoomViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.ktv.common.model.bean.a r6 = (com.bytedance.android.live.ktv.common.model.bean.a) r5;
            if (r6 == null) goto L35;
            BaseCoreViewModel r0 = this.a.getCoreViewModel();
            if (r0 == null) goto L33;
            KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
            if (r1 == null) goto L36;
            boolean r2 = false;
            if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L21;
            MusicPanel r3 = ((KtvRoomLyricsStateMachineConfig.d.f) r1).b;
            Lazy r4 = KtvUtilsKt.a;
            Intrinsics.checkNotNullParameter(r3, "musicPanel");
            String r7 = jc1.k.n(IMiddlewareUserService.class).user().n();
            OrderInfo r8 = r3.a.getOrderInfo();
            if (r8 == null) goto L17;
            InteractiveSongUserInfo r9 = r8.getTopUser();
            if (r9 == null) goto L17;
            String r10 = r9.getIdString();
        L19:
            if ((!Intrinsics.areEqual(r7, r10)) == false) goto L21;
            boolean r11 = true;
        L23:
            if (KtvRoomViewModel.access$getEnableFixMemLeak$p(this.a) == false) goto L25;
        L29:
            this.a.getCountDownEvent().setValue(new Pair(Boolean.valueOf(r11), r6));
            if (r11 == false) goto L34;
            KtvRoomViewModel.access$startListenerCountDownTimer(this.a);
            return;
        L34:
            return;
        L25:
            if (this.a.isAnchor() == false) goto L27;
            if (r11 == true) goto L27;
        L28:
            r11 = r2;
        L27:
            r2 = true;
        L17:
            r10 = null;
        L21:
            r11 = false;
            goto L23
        L36:
            return;
        L33:
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;

        public m(KtvRoomViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List<MusicPanel> r3 = (List) r2;
            KtvRoomViewModel.access$getLyricsResourceManager$p(this.a).f(r3);
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r0 = this.a.getMvDataReceiver();
            if (r0 == null) goto L5;
            r0.onMusicListChange(r3);
        L5:
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r1 = this.a.getLyricStateReceiver();
            if (r1 == null) goto L8;
            r1.onMusicListChange(r3);
        L8:
            this.a.onMusicListChange(r3);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;

        public n(KtvRoomViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            KtvDressSyncData r8 = (KtvDressSyncData) r7;
            StringBuilder r0 = new StringBuilder("ktvDressMidiSkinData change, singerId: ");
            r0.append(r8.getSingerIdString());
            r0.append(", songId: ");
            r0.append(r8.getSongId());
            r0.append(", dressId: ");
            MidiSkinDressInfo r1 = r8.getDressInfo();
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getDressId();
        L6:
            r0.append(r3);
            ALogger.i(KtvRoomViewModel.TAG, r0.toString());
            MidiSkinDressInfo r4 = r8.getDressInfo();
            if (r4 == null) goto L9;
            String r5 = r4.getDressId();
        L11:
            if (TextUtils.isEmpty(r5) == true) goto L37;
            Long r6 = r8.getSongId();
            KtvDressSyncData r9 = KtvRoomViewModel.access$getMidiSkinSyncData$p(this.a);
            if (r9 == null) goto L15;
            Long r10 = r9.getSongId();
        L17:
            if ((!Intrinsics.areEqual(r6, r10)) == true) goto L30;
            MidiSkinDressInfo r11 = r8.getDressInfo();
            if (r11 == null) goto L21;
            String r12 = r11.getDressId();
        L22:
            KtvDressSyncData r13 = KtvRoomViewModel.access$getMidiSkinSyncData$p(this.a);
            if (r13 == null) goto L27;
            MidiSkinDressInfo r14 = r13.getDressInfo();
            if (r14 == null) goto L27;
            String r15 = r14.getDressId();
        L29:
            if ((!Intrinsics.areEqual(r12, r15)) == false) goto L37;
        L27:
            r15 = null;
            goto L29
        L21:
            r12 = null;
        L30:
            Long r16 = KtvLoggerHelper.a;
            MidiSkinDressInfo r17 = r8.getDressInfo();
            if (r17 == null) goto L33;
            r2 = r17.getDressId();
        L33:
            LinkedHashMap r18 = new LinkedHashMap();
            r18.put("user_type", KtvLoggerHelper.I());
            r18.put("show_page_name", "");
            r18.put("tag_type", "");
            r18.put("resource_name", "");
            r18.put("resource_type", "midi");
            if (r2 != null) goto L36;
            r2 = "";
        L36:
            r18.put("midi_id", r2);
            KtvLoggerHelper.A(r18);
            j0.l().sendLog("livesdk_connection_audience_tag_show", r18, new Object[]{IRoom.class});
            goto L37
        L15:
            r10 = null;
        L37:
            KtvRoomViewModel.access$setMidiSkinSyncData$p(this.a, r8);
            return;
        L9:
            r5 = null;
            goto L11
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class o extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvRoomViewModel a;

        public o(KtvRoomViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r13) {
            Intrinsics.checkNotNullParameter(r13, "valid");
            long r0 = System.nanoTime();
            KtvRoomLyricsStateMachineConfig.d r2 = (KtvRoomLyricsStateMachineConfig.d) r13.a;
            String r3 = "onRoomStateChange:" + ((KtvRoomLyricsStateMachineConfig.d) r13.c);
            ALogger.i(bb0.b.b(), "KtvRoomViewModel :" + r3 + ", invoke class :" + o.class.getSimpleName());
            this.a.getStateChangeEvent().setValue(r13);
            if (vm2.d.q0().isFeedInfoTransport() == false) goto L11;
            KtvContext.Companion.getClass();
            if (KtvContext.access$getEnableRoomStateSync$cp() == true) goto L7;
        L16:
            Disposable r4 = KtvRoomViewModel.access$getTimerDisposable$p(this.a);
            if (r4 == null) goto L19;
            r4.dispose();
        L19:
            KtvRoomLyricsStateMachineConfig.d r5 = (KtvRoomLyricsStateMachineConfig.d) r13.c;
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L26;
            if ((((KtvRoomLyricsStateMachineConfig.d) r13.a) instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L24;
            this.a.getKtvContext().getKtvStageIdleEvent().post(new Object());
        L24:
            this.a.onIdle();
        L67:
            long r6 = System.nanoTime();
            if (Intrinsics.areEqual(r13.a.getClass(), r13.c.getClass()) == false) goto L70;
            KtvRoomViewModel r14 = this.a;
            KtvRoomViewModel.access$setRepeatDuration$p(r14, KtvRoomViewModel.access$getRepeatDuration$p(r14) + (r6 - r0));
            ALogger.d("ttlive_ktv", "ktvRoomViewModel repeatState duration : " + KtvRoomViewModel.access$getRepeatDuration$p(this.a));
            return;
        L70:
            KtvRoomViewModel.access$setRepeatDuration$p(this.a, 0);
            return;
        L26:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L29;
            this.a.onPause(r2, (KtvRoomLyricsStateMachineConfig.d.C0041d) r5);
            goto L67
        L29:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L32;
            this.a.onEnterPrepareState(r2, (KtvRoomLyricsStateMachineConfig.d.e) r5);
            goto L67
        L32:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L67;
            KtvRoomLyricsStateMachineConfig.d.f r7 = (KtvRoomLyricsStateMachineConfig.d.f) r5;
            KtvMusic r8 = r7.b.a;
            String r9 = "start sing:" + r8.getMTitle() + "--id:" + r8.getMId();
            ALogger.i(bb0.b.b(), r9 + ", invoke class :" + o.class.getSimpleName());
            if (this.a.getKtvsingHotInfo().getValue() == null) goto L36;
        L40:
            Object r10 = r13.a;
            if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L59;
            if (r10 == null) goto L58;
            OrderInfo r11 = ((KtvRoomLyricsStateMachineConfig.d.f) r10).b.a.getOrderInfo();
            String r12 = null;
            if (r11 == null) goto L48;
            InteractiveSongUserInfo r15 = r11.getTopUser();
            if (r15 == null) goto L48;
            String r16 = r15.getIdString();
        L49:
            OrderInfo r17 = r7.b.a.getOrderInfo();
            if (r17 == null) goto L55;
            InteractiveSongUserInfo r18 = r17.getTopUser();
            if (r18 == null) goto L55;
            r12 = r18.getIdString();
        L55:
            if ((!Intrinsics.areEqual(r16, r12)) == false) goto L67;
        L48:
            r16 = null;
            goto L49
        L58:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
        L59:
            com.bytedance.live.datacontext.m<y> r19 = this.a.getKtvContext().getKtvRoomInfo();
            if (r19 == null) goto L62;
            KtvMusic r20 = r7.b.a;
            KtvMusic.Companion.getClass();
            r19.setValue(new y.d(r20, (KtvMusic.a.a(r20) * ((long) 1000)) - KtvMusic.a.b(r7.b.a, r7.d.a)));
        L62:
            KtvRoomViewModel r21 = this.a;
            KtvRoomLyricsStateMachineConfig.d r22 = (KtvRoomLyricsStateMachineConfig.d) r13.a;
            Object r23 = r13.c;
            if (r23 == null) goto L66;
            r21.onSinging(r22, (KtvRoomLyricsStateMachineConfig.d.f) r23);
            goto L67
        L66:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig.State.Singing");
        L36:
            if ((r13.a instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L40;
            if (this.a.getRoomEntity().b() == false) goto L40;
            this.a.getUserContributorHotRank(r7.b);
            goto L40
        L7:
            if (this.a.getKtvContext().isCurrentUserIsSinger() == false) goto L16;
            oe2.d r24 = KtvRoomViewModel.access$getRoomModel$p(this.a);
            if (r24 == null) goto L16;
            r24.a((KtvRoomLyricsStateMachineConfig.d) r13.c);
            goto L16
        L11:
            KtvContext.Companion.getClass();
            if (KtvContext.access$getEnableRoomStateSync$cp() == false) goto L16;
            oe2.d r25 = KtvRoomViewModel.access$getRoomModel$p(this.a);
            if (r25 == null) goto L16;
            r25.a((KtvRoomLyricsStateMachineConfig.d) r13.c);
            goto L16
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void e(long r9) {
            BaseCoreViewModel r0 = this.a.getCoreViewModel();
            if (r0 == null) goto L6;
            KtvMusic r1 = r0.getCurrentMusicFromState();
            if (r1 == null) goto L6;
        L7:
            if (r1 != null) goto L9;
            return;
        L9:
            y.d r2 = (y) this.a.getKtvContext().getKtvRoomInfo().getValue();
            if ((r2 instanceof y.d) == false) goto L12;
            y.d r3 = r2;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r3.a = r1;
            KtvMusic.Companion.getClass();
            r3.b = (KtvMusic.a.a(r1) * ((long) 1000)) - KtvMusic.a.b(r1, r9);
            return;
        L12:
            com.bytedance.live.datacontext.m<y> r4 = this.a.getKtvContext().getKtvRoomInfo();
            KtvMusic.Companion.getClass();
            r4.setValue(new y.d(r1, (KtvMusic.a.a(r1) * ((long) 1000)) - KtvMusic.a.b(r1, r9)));
            return;
        L6:
            r1 = ((y) this.a.getKtvContext().getKtvRoomInfo().getValue()).b();
            goto L7
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void d(KtvRoomLyricsStateMachineConfig.d r5, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r6) {
            Intrinsics.checkNotNullParameter(r5, "curstate");
            Intrinsics.checkNotNullParameter(r6, "ktvCoreDataModel");
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L10;
            KtvRoomViewModel.access$onPreparing(this.a, r6);
            MusicPanel r7 = r6.a;
            if (r7 == null) goto L24;
            OrderInfo r8 = r7.d();
            if (r8 == null) goto L25;
            KtvRoomViewModel.tryUpdateSingerAvatar$default(this.a, r8, false, 1, null);
            return;
        L25:
            return;
        L24:
            return;
        L10:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L17;
            KtvRoomViewModel.access$onSinging(this.a, r6);
            MusicPanel r9 = r6.a;
            if (r9 == null) goto L27;
            OrderInfo r10 = r9.d();
            if (r10 == null) goto L28;
            KtvRoomViewModel.tryUpdateSingerAvatar$default(this.a, r10, false, 1, null);
            return;
        L28:
            return;
        L27:
            return;
        L17:
            if ((r5 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L30;
            MusicPanel r11 = r6.a;
            if (r11 == null) goto L31;
            OrderInfo r12 = r11.d();
            if (r12 == null) goto L32;
            KtvRoomViewModel.tryUpdateSingerAvatar$default(this.a, r12, false, 1, null);
            return;
        L32:
            return;
        L31:
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r6 = KtvRoomContext.a.a();
            if (r6 == null) goto L11;
            com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r7 = r6.getPreviewViewModel();
            if (r7 == null) goto L11;
            KtvPreviewSongsViewModel r8 = (KtvPreviewSongsViewModel) r7.getValue();
            if (r8 == null) goto L11;
            com.bytedance.live.datacontext.m<Boolean> r9 = r8.getNeedDelayToShow();
            if (r9 == null) goto L11;
            r9.setValue(Boolean.TRUE);
        L11:
            i0.c().postDelayed(w.a, 4000);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ MusicPanel c;
        public final /* synthetic */ Function1 d;

        public q(KtvRoomViewModel r1, Ref.IntRef r2, MusicPanel r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            Ref.IntRef r4 = this.b;
            int r0 = r4.element;
            if (r0 > 0) goto L8;
            Disposable r5 = KtvRoomViewModel.access$getPrepareCountDownDisposable$p(this.a);
            if (r5 == null) goto L7;
            r5.dispose();
        L7:
            this.a.beginSing(this.c);
            return;
        L8:
            int r1 = r0 - 1;
            r4.element = r1;
            this.d.invoke(Integer.valueOf(r1));
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewModel a;

        public r(KtvRoomViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            Pair r11 = (Pair) this.a.getCountDownEvent().getValue();
            if (r11 == null) goto L22;
            com.bytedance.android.live.ktv.common.model.bean.a r0 = (com.bytedance.android.live.ktv.common.model.bean.a) r11.getSecond();
            if (r0 == null) goto L23;
            long r1 = r0.b - ((long) 1000);
            if (r1 >= 0) goto L9;
            r1 = 0;
        L9:
            BaseCoreViewModel r2 = this.a.getCoreViewModel();
            Long r3 = null;
            if (r2 == null) goto L12;
            KtvRoomLyricsStateMachineConfig.d r4 = r2.getCurState();
        L14:
            if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L24;
            this.a.getCountDownEvent().setValue(new Pair(r11.getFirst(), new com.bytedance.android.live.ktv.common.model.bean.a(((com.bytedance.android.live.ktv.common.model.bean.a) r11.getSecond()).a, r1)));
            StringBuilder r12 = new StringBuilder("计时");
            Pair r5 = (Pair) this.a.getCountDownEvent().getValue();
            if (r5 == null) goto L20;
            com.bytedance.android.live.ktv.common.model.bean.a r6 = (com.bytedance.android.live.ktv.common.model.bean.a) r5.getSecond();
            if (r6 == null) goto L20;
            r3 = Long.valueOf(r6.b);
        L20:
            r12.append(r3);
            ALogger.i("倒计时刷新", r12.toString());
            return;
        L24:
            return;
        L12:
            r4 = null;
            goto L14
        L23:
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final void checkUserInfoBounce(MusicPanel r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public void onBizDestory() {
    }

    public void onBizHide() {
    }

    public void onBizShow() {
    }

    public void onMusicListChange(List<MusicPanel> r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public Class<? extends DataContext> provideDataService() {
        return null;
    }

    private final void fastKtvEnterRoomStage() {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isKtvRoomEnterGetOrderSongSuccess() == false) goto L7;
        showPreviewCardWhenEnterRoom();
    L7:
        RxUtilKt.c(r0.observeKtvRoomEnterGetOrderSongSuccess(new c(this)), this.compositeDisposable);
    }

    private final String getCurrentUserId() {
        return jc1.k.n(IMiddlewareUserService.class).user().n().toString();
    }

    private final oe2.d getRoomModel() {
        return (oe2.d) this.ktvContext.getKtvRoomModel().getValue();
    }

    private final KtvSingerViewModel getSingerViewModel() {
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r0 = this.ktvContext.getKtvSingerViewModel();
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r1 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r0.getValue();
    L7:
        return (KtvSingerViewModel) r1;
    L5:
        r1 = null;
        goto L7
    }

    private final void observeSingEndedFeedbackSei() {
        RxUtilKt.c(this.ktvContext.observeSingEndedFeedbackSei(p.a), this.liveRoomCompositeDisposable);
    }

    private final void showPreviewCardWhenEnterRoom() {
        MusicPanel r0 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(this.ktvContext);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) this.ktvContext.getKtvCoreViewModel().getValue();
        if (r1 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r2 = r1.getCurState();
    L6:
        StringBuilder r3 = new StringBuilder("KtvRoomViewModel: KtvRoomEnterGetOrderSongSuccess, cur sing music name=");
        if (r0 == null) goto L11;
        KtvMusic r4 = r0.a;
        if (r4 == null) goto L11;
        String r5 = r4.getMTitle();
    L12:
        r3.append(r5);
        r3.append(", curState=");
        r3.append(r2);
        ALogger.w(TAG, r3.toString());
        if (r0 != null) goto L15;
        return;
    L15:
        if ((r2 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L22;
        updateStage(KtvRoomViewModel$showPreviewCardWhenEnterRoom$1$1.INSTANCE);
        OrderInfo r6 = r0.d();
        if (r6 == null) goto L19;
        tryUpdateSingerAvatar$default(this, r6, false, 1, null);
    L19:
        updateSingerName(r0);
        this.userInfoShowFromOrderSongList = true;
        return;
    L22:
        return;
    L11:
        r5 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    private final void startListenerCountDownTimer() {
        Disposable r0 = this.timerDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        StringBuilder r1 = new StringBuilder("开始");
        Pair r2 = (Pair) this.countDownEvent.getValue();
        if (r2 == null) goto L10;
        com.bytedance.android.live.ktv.common.model.bean.a r3 = (com.bytedance.android.live.ktv.common.model.bean.a) r2.getSecond();
        if (r3 == null) goto L10;
        Long r4 = Long.valueOf(r3.b);
    L11:
        r1.append(r4);
        ALogger.i("倒计时刷新", r1.toString());
        this.timerDisposable = du2.a.b(1, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this));
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final InteractiveSongUserInfo currentSongUser() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L13;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L13;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L13;
        OrderInfo r4 = r3.getOrderInfo();
        if (r4 == null) goto L13;
        return r4.getTopUser();
    L13:
        return null;
    }

    public final KtvRoomLyricsStateMachineConfig.d getCurState() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurState();
    }

    public final String getCurrentSingerUserId() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L16;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L16;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L16;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L16;
        OrderInfo r4 = r3.getOrderInfo();
        if (r4 == null) goto L16;
        InteractiveSongUserInfo r5 = r4.getTopUser();
        if (r5 == null) goto L16;
        String r6 = r5.getIdString();
        if (r6 == null) goto L16;
        return r6;
    L16:
        return "";
    }

    public final DataCenter getDataCenter() {
        return this.dataEntity.getDataCenter();
    }

    public final sb0.e getRoomEntity() {
        return this.dataEntity.b();
    }

    public final boolean inOnSing() {
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
    L7:
        return r1 instanceof KtvRoomLyricsStateMachineConfig.d.f;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isAnchor() {
        return this.dataEntity.b().isAnchor();
    }

    public final boolean isPureCleanMode() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L17;
        qd0.a r1 = r0.getAudioTalkService();
        if (r1 == null) goto L17;
        if (r1.isEngineOn() == true) goto L17;
        com.bytedance.android.livesdk.chatroom.o r2 = o3.f();
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.m r3 = r2.getCleanMode();
        if (r3 == null) goto L17;
        if (((Number) r3.getValue()).intValue() != 2) goto L17;
        if (vm2.e.h() == false) goto L17;
        return true;
    L17:
        return false;
    }

    public void onBizEnterRoom() {
        CompositeDisposable r0 = this.liveRoomCompositeDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.liveRoomCompositeDisposable = new CompositeDisposable();
        initImMessage();
        initKtvDressSyncData();
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.ktvContext.getSeiProcessor().getValue()).g(this.mSinghotSeiHandler);
        fastKtvEnterRoomStage();
        observeSingEndedFeedbackSei();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public void onCleared() {
        vlc.d r0 = this.messageManager;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.compositeDisposable.clear();
        this.liveRoomCompositeDisposable.clear();
        Disposable r1 = this.prepareCountDownDisposable;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        BaseCoreViewModel r2 = this.coreViewModel;
        if (r2 == null) goto L11;
        r2.reset();
    L11:
        Disposable r3 = this.timerDisposable;
        if (r3 == null) goto L14;
        r3.dispose();
    L14:
        this.ktvContext.getLyricStateRecordMap().clear();
        this.mvDataReceiver = null;
        this.lyricStateReceiver = null;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.ktvContext.getSeiProcessor().getValue()).g(this.mFeedBackSeiHandler);
        if (this.mSinghotSeiHandler == null) goto L17;
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) this.ktvContext.getSeiProcessor().getValue()).g(this.mSinghotSeiHandler);
    L17:
        this.ktvContext.getBizLcMager().c(this);
    }

    public void onIdle() {
        updateStage(new C02481(this));
        Disposable r0 = this.prepareCountDownDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        String r1 = "onIdle ui state " + ((oe2.f) this.stageUiState.getValue());
        ALogger.i(bb0.b.b(), r1 + ", invoke class :KtvRoomViewModel");
        this.lyricsResourceManager.g = -1;
    }

    private final void initKtvDressSyncData() {
        com.bytedance.live.datacontext.j r0 = o3.f().w1();
        if (r0 == null) goto L7;
        ylc.e r1 = (ylc.e) r0.getValue();
        if (r1 == null) goto L7;
        KtvDressRoomDataSyncModel r2 = (KtvDressRoomDataSyncModel) dc2.b.a(r1, KtvRoomViewModel$initKtvDressSyncData$ktvMidiSkinSyncModel$1.INSTANCE);
    L8:
        if (r2 == null) goto L17;
        dc2.c<KtvDressSyncData> r3 = r2.getKtvDressMidiSkinData();
        if (r3 == null) goto L18;
        Observable r4 = r3.d;
        if (r4 == null) goto L19;
        Disposable r5 = r4.subscribe(new n(this));
        if (r5 == null) goto L20;
        this.liveRoomCompositeDisposable.add(r5);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final String getUserType() {
        if (getRoomEntity().isAnchor() == false) goto L5;
        return "anchor";
    L5:
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L9;
    L10:
        return "guest";
    L9:
        if (r0.intValue() != 0) goto L10;
        return "user";
    }

    public void initImMessage() {
        DataCenter r0 = getDataCenter();
        vlc.d r1 = null;
        if (r0 == null) goto L5;
        r1 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.messageManager = r1;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.KTV_USER_SINGING_HOT_MESSAGE.getIntType(), this);
    L8:
        vlc.d r2 = this.messageManager;
        if (r2 == null) goto L12;
        r2.addMessageListener(MessageType.KTV_WEEKLY_SINGING_HOT_RANK_POS_MESSAGE.getIntType(), this);
        return;
    }

    public void onBizLeaveRoom() {
        DataCenter r0 = getDataCenter();
        vlc.d r1 = null;
        if (r0 == null) goto L5;
        r1 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.messageManager = r1;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        CompositeDisposable r2 = this.liveRoomCompositeDisposable;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) this.ktvContext.getSeiProcessor().getValue(), this.mSinghotSeiHandler);
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final BaseCoreViewModel getCoreViewModel() {
        return this.coreViewModel;
    }

    public final NextLiveData<Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a>> getCountDownEvent() {
        return this.countDownEvent;
    }

    public final sb0.b getDataEntity() {
        return this.dataEntity;
    }

    public final NextLiveData<com.bytedance.android.livesdk.ktvimpl.base.sei.k> getFeedSeiModel() {
        return this.feedSeiModel;
    }

    public final KtvContext getKtvContext() {
        return this.ktvContext;
    }

    public final MutableLiveData<qd> getKtvMicLabelEvent() {
        return this.ktvMicLabelEvent;
    }

    public final KtvDressSyncData getKtvMidiSkinDress() {
        return this.midiSkinSyncData;
    }

    public final NextLiveData<x> getKtvsingHotInfo() {
        return this.ktvsingHotInfo;
    }

    public final CompositeDisposable getLiveRoomCompositeDisposable() {
        return this.liveRoomCompositeDisposable;
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b getLyricStateReceiver() {
        return this.lyricStateReceiver;
    }

    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b getMCoreListener() {
        return this.mCoreListener;
    }

    public final vlc.d getMessageManager() {
        return this.messageManager;
    }

    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b getMvDataReceiver() {
        return this.mvDataReceiver;
    }

    public final NextLiveData<Integer> getSingHotRank() {
        return this.singHotRank;
    }

    public final NextLiveData<Boolean> getSingerFollowState() {
        return this.singerFollowState;
    }

    public final MutableLiveData<oe2.f> getStageUiState() {
        return this.stageUiState;
    }

    public final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> getStateChangeEvent() {
        return this.stateChangeEvent;
    }

    public static final /* synthetic */ void access$fastKtvEnterRoomStage(KtvRoomViewModel r0) {
        r0.fastKtvEnterRoomStage();
    }

    public static final /* synthetic */ boolean access$getEnableFixMemLeak$p(KtvRoomViewModel r0) {
        return r0.enableFixMemLeak;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h access$getLyricsResourceManager$p(KtvRoomViewModel r0) {
        return r0.lyricsResourceManager;
    }

    public static final /* synthetic */ KtvDressSyncData access$getMidiSkinSyncData$p(KtvRoomViewModel r0) {
        return r0.midiSkinSyncData;
    }

    public static final /* synthetic */ Disposable access$getPrepareCountDownDisposable$p(KtvRoomViewModel r0) {
        return r0.prepareCountDownDisposable;
    }

    public static final /* synthetic */ long access$getRepeatDuration$p(KtvRoomViewModel r2) {
        return r2.repeatDuration;
    }

    public static final /* synthetic */ oe2.d access$getRoomModel$p(KtvRoomViewModel r0) {
        return r0.getRoomModel();
    }

    public static final /* synthetic */ oe2.j access$getSingerImageModelRecord$p(KtvRoomViewModel r0) {
        return r0.singerImageModelRecord;
    }

    public static final /* synthetic */ Disposable access$getTimerDisposable$p(KtvRoomViewModel r0) {
        return r0.timerDisposable;
    }

    public static final /* synthetic */ void access$initKtvDressSyncData(KtvRoomViewModel r0) {
        r0.initKtvDressSyncData();
    }

    public static final /* synthetic */ void access$observeSingEndedFeedbackSei(KtvRoomViewModel r0) {
        r0.observeSingEndedFeedbackSei();
    }

    public static final /* synthetic */ void access$showPreviewCardWhenEnterRoom(KtvRoomViewModel r0) {
        r0.showPreviewCardWhenEnterRoom();
    }

    public static final /* synthetic */ void access$startListenerCountDownTimer(KtvRoomViewModel r0) {
        r0.startListenerCountDownTimer();
    }

    private final void getKtvUserWeeklyHotRank(MusicPanel r13) {
        long r0 = System.currentTimeMillis();
        this.compositeDisposable.add(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getKtvUserWeeklyHotRank(r13.a.getMId(), getRoomEntity().getRoomId(), d5.c(r13.a.getOrderUserIdString()), r13.a.getOrderUserIdString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r0), new g(r0)));
    }

    private final void onPreparing(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r4) {
        MusicPanel r0 = r4.a;
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        updateSingerName(r0);
        checkUserInfoBounce(r0);
        this.userInfoShowFromOrderSongList = false;
        this.lyricsResourceManager.g = -1;
        OrderInfo r1 = r4.a.a.getOrderInfo();
        if (r1 == null) goto L8;
        InteractiveSongUserInfo r2 = r1.getTopUser();
    L9:
        notifyKtvStageLabelShow(r2, true);
        updateStage(AnonymousClass2.INSTANCE);
        if (isSinger(r4.a.a) == false) goto L14;
        startCountDown(r4.a, AnonymousClass3.INSTANCE);
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r3 = KtvModeOrderSongDataContext.Companion.e();
        if (r3 == null) goto L14;
        r3.wearMidiSkin();
    L14:
        com.bytedance.live.datacontext.m<y> r5 = this.ktvContext.getKtvRoomInfo();
        if (r5 == null) goto L17;
        r5.setValue(new y.a(r4.a.a));
    L17:
        com.bytedance.live.datacontext.k<Object> r6 = this.ktvContext.getKtvStagePreparedEvent();
        if (r6 == null) goto L20;
        r6.post(new Object());
    L20:
        com.bytedance.live.datacontext.k<Object> r7 = this.ktvContext.getKtvRoomLabelChangeEvent();
        if (r7 == null) goto L24;
        r7.post(new Object());
        return;
    L24:
        return;
    L8:
        r2 = null;
        goto L9
    }

    private final void onSinging(com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r2) {
        if (this.ktvContext.isCurrentUserIsSinger() == true) goto L8;
        MusicPanel r3 = r2.a;
        if (r3 == null) goto L9;
        updateSingerName(r3);
        checkUserInfoBounce(r3);
        this.userInfoShowFromOrderSongList = false;
        return;
    L9:
        return;
    }

    private final void recordSingerModel(InteractiveSongUserInfo r3) {
        oe2.j r0 = this.singerImageModelRecord;
        r0.a = r3.getIdString();
        oe2.j r1 = this.singerImageModelRecord;
        py.k r4 = r3.getAvatarThumbFlex();
        if ((r4 instanceof py.k) == true) goto L5;
        r4 = null;
    L5:
        r1.b = r4;
    }

    private final void sendSingerBeginSing(MusicPanel r5) {
        com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.h r0 = this.lyricsResourceManager;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "musicPanel");
        com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.a.getClass();
        ub0.d r1 = com.bytedance.android.livesdk.ktvimpl.base.lyrics.utils.b.b(r5);
        r0.j.put(r1.a, r1);
        r5.a.correctLyricsType(r1.getType());
        r1.toString();
        String r2 = "lyrics line count = " + r1.c.size();
        ALogger.i(bb0.b.b(), r2 + ", invoke class :" + ub0.d.class.getSimpleName());
        int r3 = mb0.f.a;
        mb0.f.q(Long.valueOf(r5.c()), r5.e());
        BaseCoreViewModel r6 = this.coreViewModel;
        if (r6 == null) goto L6;
        r6.sendEvent(new KtvRoomLyricsStateMachineConfig.a.f(r1.c), TAG);
        return;
    }

    private final void updateSingerAvatar(final MusicPanel r5) {
        OrderInfo r0 = r5.a.getOrderInfoFlex();
        final py.k r1 = null;
        if (r0 == null) goto L7;
        InteractiveSongUserInfo r2 = r0.getTopUser();
        if (r2 == null) goto L7;
        py.k r3 = r2.getAvatarThumbFlex();
    L8:
        if (r3 == null) goto L28;
        oe2.f r4 = (oe2.f) this.stageUiState.getValue();
        if (r4 == null) goto L14;
        py.k r6 = r4.c;
        if (r6 == null) goto L14;
        String r7 = KtvUtilsKt.g(r6);
    L16:
        if ((!Intrinsics.areEqual(r7, KtvUtilsKt.g(r3))) == true) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L23;
        r1 = r3;
    L23:
        if (r1 == null) goto L29;
        updateStage(new KtvRoomViewModel$updateSingerAvatar$$inlined$let$lambda$1(r1, this, r5));
        if (this.userInfoViewShownReported == true) goto L30;
        this.userInfoViewShownReported = true;
        return;
    L30:
        return;
    L29:
        return;
    L18:
        if (TextUtils.isEmpty(KtvUtilsKt.g(r3)) == true) goto L20;
        r8 = true;
    L14:
        r7 = null;
        goto L16
    L28:
        return;
    L7:
        r3 = null;
        goto L8
    }

    private final void updateSingerName(MusicPanel r4) {
        final String r5 = null;
        boolean r0 = true;
        String r1 = getCurSingerName$default(this, null, 1, null);
        if (TextUtils.isEmpty(r1) == true) goto L11;
        oe2.f r2 = (oe2.f) this.stageUiState.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.a;
    L9:
        if ((!Intrinsics.areEqual(r1, r3)) == false) goto L11;
    L12:
        if (r0 == false) goto L14;
        r5 = r1;
    L14:
        if (r5 == null) goto L17;
        updateStage(new KtvRoomViewModel$updateSingerName$2$1(r5));
        return;
    L17:
        return;
    L7:
        r3 = null;
    L11:
        r0 = false;
        goto L12
    }

    public final void beginSing(MusicPanel r10) {
        Intrinsics.checkNotNullParameter(r10, "currentMusic");
        if (isSinger(r10.a) == false) goto L11;
        pd2.d.n.N(r10);
        String r0 = "start parse lyric,lyrics file path = " + r10.l;
        ALogger.i(bb0.b.b(), r0 + ", invoke class :KtvRoomViewModel");
        KtvSingerViewModel r1 = getSingerViewModel();
        if (r1 != null) goto L7;
    L9:
        sendSingerBeginSing(r10);
        return;
    L7:
        if (r1.isNeedMusicDownload(r10) != true) goto L9;
        ALogger.w(TAG, "onPreparingSinging but find no music res download so try download now. " + r10.a.getMTitle());
        KtvMusicManager.e(KtvMusicManager.m, r10, new b(this, r10), false, null, false, 28);
        return;
    }

    public final void followSinger(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        com.bytedance.android.livesdk.user.b.c r4 = new com.bytedance.android.livesdk.user.b.c().c(r3).b("").g("").h(0).f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.KTV_HOT_PAGE));
        r4.getClass();
        com.bytedance.android.livesdk.user.b r0 = new com.bytedance.android.livesdk.user.b(r4);
        RxUtilKt.c(jc1.k.n(IMiddlewareUserService.class).user().h(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this)), this.compositeDisposable);
    }

    public final String getCurSingerName(String r6) {
        if (r6 != null) goto L8;
        InteractiveSongUserInfo r7 = currentSongUser();
        if (r7 == null) goto L7;
        r6 = r7.getIdString();
        goto L8
    L7:
        r6 = null;
    L8:
        List r1 = this.dataEntity.c().getOnlineUserList();
        if (r1 == null) goto L26;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L26;
        LinkPlayerInfo r3 = (LinkPlayerInfo) r2.next();
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L16;
        String r5 = r4.getIdString();
    L18:
        if (Intrinsics.areEqual(r5, r6) == false) goto L12;
        IBaseUser r8 = r3.getUser();
        if (r8 == null) goto L36;
        String r9 = r8.getNickName();
        if (r9 != null) goto L25;
        return "";
    L25:
        return r9;
    L36:
        return "";
    L16:
        r5 = null;
    L26:
        InteractiveSongUserInfo r10 = currentSongUser();
        if (r10 == null) goto L38;
        String r11 = r10.getNickNameFlex();
        if (r11 != null) goto L32;
        return "";
    L32:
        return r11;
    L38:
        return "";
    }

    public final void getSingerFollowState(String r10) {
        Intrinsics.checkNotNullParameter(r10, "toUserId");
        if (Intrinsics.areEqual(r10, getCurrentUserId()) == false) goto L6;
        return;
    L6:
        if (r10.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        long r1 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getUserFollowRelation(getRoomEntity().getRoomId(), d5.c(r10), r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r1), new i(this, r1)), this.compositeDisposable);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final String getToUserType(IBaseUser r2) {
        String r0 = getRoomEntity().a();
        if (r2 == null) goto L5;
        String r3 = r2.getIdString();
    L7:
        if (Intrinsics.areEqual(r0, r3) == false) goto L9;
        return "anchor";
    L9:
        return "guest";
    L5:
        r3 = null;
        goto L7
    }

    public final void getUserContributorHotRank(MusicPanel r13) {
        Intrinsics.checkNotNullParameter(r13, "currentMusic");
        if (r13.a.getMId() != 0) goto L5;
        return;
    L5:
        long r5 = r13.a.getMId();
        String r11 = r13.a.getOrderUserIdString();
        if (r5 != 0) goto L8;
        return;
    L8:
        if (getRoomEntity().getRoomId() == 0) goto L20;
        if (r11 != null) goto L11;
    L14:
        boolean r14 = true;
    L15:
        if (r14 == true) goto L21;
        long r0 = System.currentTimeMillis();
        this.compositeDisposable.add(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getKtvUserContributorHotRank(r5, getRoomEntity().getRoomId(), d5.c(r11), r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this, r0), new k(r0)));
        return;
    L21:
        return;
    L11:
        if (r11.length() == 0) goto L14;
        r14 = false;
        goto L15
    }

    public void init(final LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        observeCoreViewModel(r4);
        Lazy r0 = KtvCommonSettingHelper.a;
        Intrinsics.checkNotNullParameter(new C02451(this, r4), "cb");
        ((ObservableSubscribeProxy) this.ktvContext.getCountDownEvent().onEvent().as(AutoDispose.bind(r4))).subscribe(new l(this));
        KtvModeOrderedSongDataContext r5 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r5 == null) goto L7;
        Disposable r6 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b.a.a(r5, true, new m(this), 1);
        if (r6 == null) goto L7;
        RxUtilKt.c(r6, this.compositeDisposable);
    L7:
        Intrinsics.checkNotNullParameter(new AnonymousClass4(this), "cb");
        jc1.k.n(IInteractService.class).addBusinessDegradeStrategy(this.seriousDegradeStrategy);
    }

    public final boolean isSinger(KtvMusic r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        String r0 = getCurrentUserId();
        OrderInfo r3 = r2.getOrderInfo();
        if (r3 == null) goto L8;
        InteractiveSongUserInfo r4 = r3.getTopUser();
        if (r4 == null) goto L8;
        String r5 = r4.getIdString();
        if (r5 == null) goto L8;
    L10:
        return Intrinsics.areEqual(r0, r5);
    L8:
        r5 = "";
        goto L10
    }

    public void observeCoreViewModel(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        BaseCoreViewModel r5 = this.coreViewModel;
        if (r5 == null) goto L6;
        r5.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_DATA_MODEL, BaseCoreViewModel.CORE_TAG_PROGRESS}), this.mCoreListener, false);
        return;
    }

    public void onMessage(final tlc.d r7) {
        if ((r7 instanceof ud) == false) goto L10;
        if (getRoomEntity().b() == true) goto L7;
        return;
    L7:
        if (inOnSing() == true) goto L31;
        this.singHotRank.postValue(Integer.valueOf((int) ((ud) r7).getRank()));
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.ktvMicLabelEvent, new C02491(r7));
        return;
    L31:
        return;
    L10:
        if ((r7 instanceof td) == true) goto L12;
        return;
    L12:
        if (getRoomEntity().b() == false) goto L34;
        td r8 = (td) r7;
        if (Intrinsics.areEqual(getCurrentSingerUserId(), r8.getUserIdString()) == true) goto L25;
        BaseCoreViewModel r0 = this.coreViewModel;
        if (r0 == null) goto L26;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L26;
        MusicPanel r2 = r1.b();
        if (r2 == null) goto L26;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L26;
        if (r3.getMId() == r8.songId) goto L25;
    L26:
        KtvSingerViewModel r4 = getSingerViewModel();
        if (r4 == null) goto L35;
        r4.updateSingHot(r8);
        return;
    L35:
        return;
    L25:
        NextLiveData<x> r5 = this.ktvsingHotInfo;
        int r6 = x.d;
        Intrinsics.checkNotNullParameter(r8, "$this$transferToInfo");
        r5.postValue(new x(r8.hotStatus, r8.hotLevel, r8.hot));
        goto L26
    }

    public final void onlyRunInRoom(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.bizLifeCycle.b(r2);
    }

    public final void openKtvSingingRank(int r6) {
        Lazy r0 = KtvSettingHelper.o0;
        if (((f9) r0.getValue()).b() != 0) goto L6;
        int r7 = 0;
    L9:
        String r8 = y0.b(((f9) r0.getValue()).d(), MapsKt.mapOf(new Pair[]{TuplesKt.to("ktv_rank_tab", String.valueOf(r7)), TuplesKt.to("enter_from", "result")}));
        String r1 = bb0.b.b();
        ALogger.i(r1, ("schemaUrl:" + r8) + ", invoke class :KtvRoomViewModel");
        jc1.k.n(IBaseLiveActionHandler.class).handle(jc1.a.b(), r8);
        return;
    L6:
        if (r6 != SingingHotResultRankType.DAILY_RANK.ordinal()) goto L8;
        r7 = 1;
        goto L9
    L8:
        r7 = 2;
        goto L9
    }

    public final void openSingleContributionRank(com.bytedance.android.livesdk.ktvimpl.base.sei.n r6) {
        if (r6 == null) goto L11;
        ALogger.i(bb0.b.b(), "openSingleContributionRank, invoke class :".concat(com.bytedance.android.livesdk.ktvimpl.base.sei.n.class.getSimpleName()));
        IBaseUser r0 = r6.i();
        if (r0 == null) goto L8;
        String r1 = r0.getIdString();
        if (r1 == null) goto L8;
    L9:
        String r7 = y0.b(((e9) KtvSettingHelper.b0.getValue()).a(), MapsKt.mapOf(new Pair[]{TuplesKt.to("song_id", String.valueOf(r6.f())), TuplesKt.to("singer_id", r1), TuplesKt.to("singing_start_time", String.valueOf(r6.h())), TuplesKt.to("enter_from", "result")}));
        String r2 = bb0.b.b();
        ALogger.i(r2, ("schemaUrl:" + r7) + ", invoke class :" + com.bytedance.android.livesdk.ktvimpl.base.sei.n.class.getSimpleName());
        jc1.k.n(IBaseLiveActionHandler.class).handle(jc1.a.b(), r7);
        return;
    L8:
        r1 = BDLocationException.ERROR_TIMEOUT;
        goto L9
    }

    public final void setCoreViewModel(BaseCoreViewModel r1) {
        this.coreViewModel = r1;
    }

    public final void setLiveRoomCompositeDisposable(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveRoomCompositeDisposable = r2;
    }

    public final void setLyricStateReceiver(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r1) {
        this.lyricStateReceiver = r1;
    }

    public final void setMessageManager(vlc.d r1) {
        this.messageManager = r1;
    }

    public final void setMvDataReceiver(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r1) {
        this.mvDataReceiver = r1;
    }

    public final void showSingerUserProfiler(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (isPureCleanMode() == false) goto L6;
        ALogger.e(TAG, "rejected ktv_room_avatar click for pure clear mode");
        return;
    L6:
        UserProfileEvent r0 = new UserProfileEvent(r3);
        r0.setSkipPrivacyCheck(true);
        DataCenter r4 = getDataCenter();
        if (r4 == null) goto L10;
        r4.put("cmd_show_user_profile", r0);
        return;
    }

    public final void updateStage(Function1<? super oe2.f, oe2.f> r2) {
        Intrinsics.checkNotNullParameter(r2, "reducer");
        com.bytedance.android.livesdk.ktvapi.util.d.b(this.stageUiState, r2);
    }

    public KtvRoomViewModel(KtvContext r6, sb0.b r7) {
        Intrinsics.checkNotNullParameter(r6, "ktvContext");
        Intrinsics.checkNotNullParameter(r7, "dataEntity");
        this.ktvContext = r6;
        this.dataEntity = r7;
        this.bizLifeCycle = r6.getBizLcMager();
        MutableLiveData<qd> r8 = new MutableLiveData();
        r8.setValue(new qd(0));
        Unit r0 = Unit.INSTANCE;
        this.ktvMicLabelEvent = r8;
        this.singHotRank = new NextLiveData();
        NextLiveData<x> r9 = new NextLiveData();
        this.ktvsingHotInfo = r9;
        this.stateChangeEvent = new NextLiveData();
        this.singerFollowState = new NextLiveData();
        this.countDownEvent = new NextLiveData();
        this.feedSeiModel = new NextLiveData();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r1 = r6.getKtvCoreViewModel();
        com.bytedance.android.livesdk.a r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r1.getValue();
    L6:
        this.coreViewModel = (BaseCoreViewModel) r3;
        this.currentUserId = "";
        this.lyricsResourceManager = r6.getLyricResourceManager();
        this.singerImageModelRecord = new oe2.j();
        this.compositeDisposable = new CompositeDisposable();
        this.liveRoomCompositeDisposable = new CompositeDisposable();
        le2.a r4 = new le2.a(r6);
        this.mFeedBackSeiHandler = r4;
        le2.b r5 = new le2.b(r6, r9);
        this.mSinghotSeiHandler = r5;
        this.enableFixMemLeak = vm2.h.q();
        com.bytedance.android.livesdk.a.h.getClass();
        com.bytedance.android.livesdk.a r10 = com.bytedance.android.livesdk.a.a.b("ktv_singing_warning");
        if (r10 == null) goto L9;
        Function2<Integer, Boolean, Unit> r11 = new KtvRoomViewModel$$special$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r11, "cb");
        r10.a = r11;
        r2 = r10;
    L9:
        this.seriousDegradeStrategy = r2;
        MutableLiveData<oe2.f> r12 = new MutableLiveData();
        r12.setValue(new oe2.f(0));
        this.stageUiState = r12;
        this.mCoreListener = new o(this);
        r6.getBizLcMager().a(this);
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) r6.getSeiProcessor().getValue(), r4);
        Lazy r13 = KtvCommonSettingHelper.a;
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) r6.getSeiProcessor().getValue(), r5);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final /* synthetic */ void access$getKtvUserWeeklyHotRank(KtvRoomViewModel r0, MusicPanel r1) {
        r0.getKtvUserWeeklyHotRank(r1);
    }

    public static final /* synthetic */ void access$onPreparing(KtvRoomViewModel r0, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r1) {
        r0.onPreparing(r1);
    }

    public static final /* synthetic */ void access$onSinging(KtvRoomViewModel r0, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.d r1) {
        r0.onSinging(r1);
    }

    public static final /* synthetic */ void access$recordSingerModel(KtvRoomViewModel r0, InteractiveSongUserInfo r1) {
        r0.recordSingerModel(r1);
    }

    public static final /* synthetic */ void access$sendSingerBeginSing(KtvRoomViewModel r0, MusicPanel r1) {
        r0.sendSingerBeginSing(r1);
    }

    public static final /* synthetic */ void access$setMidiSkinSyncData$p(KtvRoomViewModel r0, KtvDressSyncData r1) {
        r0.midiSkinSyncData = r1;
    }

    public static final /* synthetic */ void access$setPrepareCountDownDisposable$p(KtvRoomViewModel r0, Disposable r1) {
        r0.prepareCountDownDisposable = r1;
    }

    public static final /* synthetic */ void access$setRepeatDuration$p(KtvRoomViewModel r0, long r1) {
        r0.repeatDuration = r1;
    }

    public static final /* synthetic */ void access$setSingerImageModelRecord$p(KtvRoomViewModel r0, oe2.j r1) {
        r0.singerImageModelRecord = r1;
    }

    public static final /* synthetic */ void access$setTimerDisposable$p(KtvRoomViewModel r0, Disposable r1) {
        r0.timerDisposable = r1;
    }

    private final void notifyKtvStageLabelShow(final InteractiveSongUserInfo r3, final boolean r4) {
        this.bizLifeCycle.b(new C02461(this, r4, r3));
    }

    private final void startCountDown(MusicPanel r10, Function1<? super Integer, Unit> r11) {
        int r0 = mb0.f.a;
        Long r1 = Long.valueOf(r10.c());
        String r2 = r10.e();
        JSONObject r7 = new JSONObject();
        if (r1 == null) goto L5;
        r1.longValue();
        r7.put("songId", r1.longValue());
    L5:
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        r7.put("musicName", r2);
    L13:
        int r4 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.KTV, MultiTraceData.TraceEvent.MusicPlayFlow, "startCountDown", 0, null, r7, 88);
        Disposable r5 = this.prepareCountDownDisposable;
        if (r5 == null) goto L16;
        r5.dispose();
    L16:
        Ref.IntRef r6 = new Ref.IntRef();
        r6.element = 5;
        this.prepareCountDownDisposable = RxUtilKt.h(du2.a.d(1, TimeUnit.SECONDS)).subscribe(new q(this, r6, r10, r11));
        return;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    private final void tryUpdateSingerAvatar(OrderInfo r5, boolean r6) {
        String r0 = this.singerImageModelRecord.a;
        InteractiveSongUserInfo r1 = r5.getTopUser();
        Object r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getIdString();
    L7:
        if (Intrinsics.areEqual(r0, r3) == true) goto L9;
    L12:
        final InteractiveSongUserInfo r7 = r5.getTopUser();
        if (r7 != null) goto L15;
        return;
    L15:
        py.k r8 = r7.getAvatarThumbFlex();
        if ((r8 instanceof py.k) == true) goto L18;
        r8 = null;
    L18:
        if (r8 == null) goto L23;
        final py.k r9 = KtvUtilsKt.k(r8);
        if (r9 == null) goto L23;
        updateStage(new KtvRoomViewModel$tryUpdateSingerAvatar$$inlined$let$lambda$1(r9, this, r7));
        return;
    L23:
        List r10 = this.dataEntity.c().getOnlineUserList();
        if (r10 != null) goto L26;
        return;
    L26:
        if ((!Lists.isEmpty(r10)) == true) goto L29;
        r10 = null;
    L29:
        if (r10 == null) goto L54;
        Iterator r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L40;
        Object r4 = r11.next();
        IBaseUser r12 = ((LinkPlayerInfo) r4).getUser();
        if (r12 == null) goto L36;
        String r13 = r12.getIdString();
    L38:
        if (Intrinsics.areEqual(r13, r7.getIdString()) == false) goto L32;
        r2 = r4;
        goto L40
    L36:
        r13 = null;
    L40:
        LinkPlayerInfo r14 = (LinkPlayerInfo) r2;
        if (r14 == null) goto L55;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L56;
        py.k r16 = r15.getAvatarThumbKt();
        if (r16 == null) goto L57;
        final py.k r17 = KtvUtilsKt.k(r16);
        if (r17 == null) goto L58;
        updateStage(new KtvRoomViewModel$tryUpdateSingerAvatar$$inlined$let$lambda$2(r17, this, r7));
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L9:
        if (this.singerImageModelRecord.b == null) goto L12;
        if (r6 == false) goto L12;
        return;
    L5:
        r3 = null;
        goto L7
    }

    public void consumeWrdsData(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "syncKey");
        if (Intrinsics.areEqual(r3, "KtvDressSyncData") == false) goto L13;
        if ((r4 instanceof KtvDressSyncData) == true) goto L7;
        Object r0 = null;
    L8:
        KtvDressSyncData r1 = (KtvDressSyncData) r0;
        if (r1 != null) goto L11;
        return;
    L11:
        this.midiSkinSyncData = r1;
        goto L13
    L7:
        r0 = r4;
    L13:
        if (Intrinsics.areEqual(r3, "KtvStreamSingSyncData") == true) goto L15;
        return;
    L15:
        if ((r4 instanceof KtvStreamSingSyncData) == true) goto L17;
        r4 = null;
    L17:
        KtvStreamSingSyncData r5 = (KtvStreamSingSyncData) r4;
        if (r5 != null) goto L21;
        return;
    L21:
        if (this.hasProcessFeedWrds == true) goto L36;
        Integer r6 = r5.action;
        int r2 = Action.ACTION_FINISH.getValue();
        if (r6 != null) goto L26;
    L27:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r7 = this.mvDataReceiver;
        if (r7 == null) goto L30;
        r7.playPreviewMv(r5);
    L30:
        final KtvMusic r8 = r5.songInfo;
        if (r8 != null) goto L33;
        return;
    L33:
        updateStage(new AnonymousClass1(r8));
        this.hasProcessFeedWrds = true;
        return;
    L26:
        if (r6.intValue() != r2) goto L27;
        return;
    }

    public void onEnterPrepareState(KtvRoomLyricsStateMachineConfig.d r2, final KtvRoomLyricsStateMachineConfig.d.e r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        onlyRunInRoom(new C02471(this, r3));
        MusicPanel r4 = r2.b();
        if (r4 == null) goto L6;
        updateSingerName(r4);
        return;
    }

    public void onPause(KtvRoomLyricsStateMachineConfig.d r8, KtvRoomLyricsStateMachineConfig.d.C0041d r9) {
        Intrinsics.checkNotNullParameter(r8, "from");
        Intrinsics.checkNotNullParameter(r9, "to");
        if ((r8 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L5;
        return;
    L5:
        oe2.f r0 = (oe2.f) this.stageUiState.getValue();
        if (r0 == null) goto L8;
        oe2.f r10 = oe2.f.a(r0, null, null, null, false, null, 23);
    L9:
        this.stageUiState.setValue(r10);
        return;
    L8:
        r10 = null;
        goto L9
    }

    public final void onSingHotClick(int r16, boolean r17) {
        pd2.d.n.getClass();
        pd2.d.w(LinkMonitorData.BusinessClickHotRank, new JSONObject());
        com.bytedance.android.livesdk.chatroom.o r1 = o3.f();
        String r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L7;
        IRoom r4 = (IRoom) r3.getValue();
    L8:
        String r5 = getUserType();
        Lazy r6 = KtvSettingHelper.o0;
        if (((f9) r6.getValue()).b() != 2) goto L11;
        boolean r7 = true;
    L12:
        Long r9 = KtvLoggerHelper.a;
        if (r4 == null) goto L15;
        String r10 = r4.getOwnerUserIdString();
    L16:
        if (r4 == null) goto L18;
        Long r8 = Long.valueOf(r4.getRoomId());
    L19:
        BaseCoreViewModel r11 = this.coreViewModel;
        if (r11 == null) goto L22;
        KtvRoomLyricsStateMachineConfig.d r12 = r11.getCurState();
    L23:
        boolean r13 = r12 instanceof KtvRoomLyricsStateMachineConfig.d.f;
        Intrinsics.checkNotNullParameter(r5, "userType");
        Pair[] r14 = new Pair[7];
        String r15 = "";
        if (r10 != null) goto L26;
        r10 = "";
    L26:
        r14[0] = TuplesKt.to("anchor_id", r10);
        r14[1] = TuplesKt.to("live_type", "voice_live");
        r14[2] = TuplesKt.to("function_type", "ktv");
        if (r8 == null) goto L30;
        String r18 = String.valueOf(r8.longValue());
        if (r18 == null) goto L30;
    L31:
        r14[3] = TuplesKt.to("room_id", r18);
        if (r13 == false) goto L34;
        r15 = String.valueOf(r16);
    L34:
        r14[4] = TuplesKt.to("hotscore", r15);
        if (r17 == false) goto L37;
        String r19 = "1";
    L38:
        r14[5] = TuplesKt.to("if_special_effect", r19);
        r14[6] = TuplesKt.to("user_type", r5);
        j0.l().sendLog("ktv_hotscore_icon_click", MapsKt.hashMapOf(r14), new Object[]{IRoom.class, am2.x.class});
        BaseCoreViewModel r20 = this.coreViewModel;
        if (r20 == null) goto L45;
        KtvRoomLyricsStateMachineConfig.d r21 = r20.getCurState();
        if (r21 == null) goto L45;
        MusicPanel r22 = r21.b();
        if (r22 == null) goto L45;
        KtvMusic r23 = r22.a;
    L46:
        if (r7 == false) goto L48;
        String r24 = ((f9) r6.getValue()).c();
    L49:
        Pair[] r25 = new Pair[3];
        if (r23 == null) goto L52;
        Long r26 = Long.valueOf(r23.getMId());
    L53:
        r25[0] = TuplesKt.to("song_id", String.valueOf(r26));
        if (r23 == null) goto L56;
        r2 = r23.getOrderUserIdString();
    L56:
        r25[1] = TuplesKt.to("singer_id", String.valueOf(r2));
        r25[2] = TuplesKt.to("enter_from", "icon");
        String r27 = y0.b(r24, MapsKt.mapOf(r25));
        String r28 = bb0.b.b();
        ALogger.i(r28, ("schemaUrl:" + r27) + ", invoke class :KtvRoomViewModel");
        jc1.k.n(IBaseLiveActionHandler.class).handle(jc1.a.b(), r27);
        return;
    L52:
        r26 = null;
        goto L53
    L48:
        r24 = ((e9) KtvSettingHelper.b0.getValue()).a();
    L45:
        r23 = null;
        goto L46
    L37:
        r19 = BDLocationException.ERROR_TIMEOUT;
    L30:
        r18 = "";
        goto L31
    L22:
        r12 = null;
        goto L23
    L18:
        r8 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L11:
        r7 = false;
    L7:
        r4 = null;
        goto L8
    }

    public void onSinging(KtvRoomLyricsStateMachineConfig.d r4, KtvRoomLyricsStateMachineConfig.d.f r5) {
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        onlyRunInRoom(C02502.INSTANCE);
        OrderInfo r6 = r5.b.a.getOrderInfo();
        if (r6 == null) goto L5;
        InteractiveSongUserInfo r7 = r6.getTopUser();
    L6:
        notifyKtvStageLabelShow$default(this, r7, false, 2, null);
        updateStage(C02513.INSTANCE);
        MusicPanel r8 = r5.b;
        updateSingerAvatar(r8);
        updateSingerName(r8);
        checkUserInfoBounce(r8);
        this.userInfoShowFromOrderSongList = false;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static /* synthetic */ String getCurSingerName$default(KtvRoomViewModel r0, String r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.getCurSingerName(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurSingerName");
    }

    public static /* synthetic */ void showSingerUserProfiler$default(KtvRoomViewModel r0, String r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.getCurrentSingerUserId();
    L6:
        r0.showSingerUserProfiler(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSingerUserProfiler");
    }

    public static /* synthetic */ void notifyKtvStageLabelShow$default(KtvRoomViewModel r0, InteractiveSongUserInfo r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.notifyKtvStageLabelShow(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyKtvStageLabelShow");
    }

    public static /* synthetic */ void tryUpdateSingerAvatar$default(KtvRoomViewModel r0, OrderInfo r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        r0.tryUpdateSingerAvatar(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryUpdateSingerAvatar");
    }
}
