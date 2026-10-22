package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.viewmodel;

import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.model.api.a1;
import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.config.rw0;
import com.bytedance.android.livesdk.config.sw0;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.viewmodel.KtvModeOrderSongViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentRoomStrategy;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.api.MultiChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.PermissionType;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdk.message.model.RealTimeChorusInfo;
import com.bytedance.android.livesdk.message.model.ej;
import com.bytedance.android.livesdk.message.model.jd;
import com.bytedance.android.livesdk.message.model.ld;
import com.bytedance.android.livesdk.message.model.o2;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.w;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0087\u00012\u00020\u0001:\n\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B,\u0012\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f\u0012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001\u0012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u0017\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\u0010\u0016\u001a\u00060\u0015R\u00020\u0000H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014J\u0012\u0010\"\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004J\b\u0010&\u001a\u00020\u0007H\u0014J(\u0010,\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0*H\u0016J\u001e\u0010.\u001a\u00020\f2\u0006\u0010(\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0-H\u0016J@\u00104\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00105\u001a\u00020\fH\u0014J\u0010\u00108\u001a\u00020\f2\u0006\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u00020\fH\u0016J,\u0010@\u001a\u00020\f2\u0006\u0010;\u001a\u00020:2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\b\u0010B\u001a\u00020AH\u0016J\b\u0010C\u001a\u00020\nH\u0016J5\u0010J\u001a\u00020\f2\u0006\u0010D\u001a\u00020\n2#\u0010I\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\f\u0018\u00010EH\u0016J\u0012\u0010K\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J5\u0010L\u001a\u00020\f2\u0006\u0010D\u001a\u00020\n2#\u0010I\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\f\u0018\u00010EH\u0016J5\u0010M\u001a\u00020\f2\u0006\u0010D\u001a\u00020\n2#\u0010I\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\f\u0018\u00010EH\u0016J\u0018\u0010R\u001a\u00020\f2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020PH\u0016J\u0018\u0010S\u001a\u00020\f2\u0006\u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020PH\u0016J5\u0010T\u001a\u00020\f2\u0006\u0010D\u001a\u00020\n2#\u0010I\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\f\u0018\u00010EH\u0016J \u0010U\u001a\u00020\f2\u0006\u0010;\u001a\u00020:2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020<H\u0016R\u0018\u0010V\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R0\u0010`\u001a\u001e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]j\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^`_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010YR\u0018\u0010c\u001a\u00060\u0015R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u00060\u0015R\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010dR\u0018\u0010g\u001a\u00060fR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001a\u00060iR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR!\u0010q\u001a\b\u0012\u0004\u0012\u00020l0-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR!\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00070r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010n\u001a\u0004\bt\u0010uR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020^0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR \u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0y0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010xR \u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0y0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010xR \u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020|0y0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010xR \u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0y0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010x¨\u0006\u008d\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/BaseOrderSongViewModel;", "Lcom/bytedance/android/livesdk/message/model/RTChorusOperateType;", LocationMonitorConst.TYPE, "", "getRequestPage", "getLimitType", "", "permissionType", "getPopupType", "", "isFirstLoad", "", "resetWantListenCursorIfNeed", "resetWantSingCursorIfNeed", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "music", "updateWantSingSongList", "resetMultiChorusWaitingListCursorIfNeed", "resetSingleSingWaitingListCursorIfNeed", "waitingUserId", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$b;", "waitingData", "updateWaitingUserList", "shouldInterceptPermit", "isLinkMicSeatFull", "isReOpen", "updateCurrentKSongElementMethod", "initData", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "shouldFillLocalPath", "Ltlc/d;", "message", "onMessage", "businessId", "chorusId", "joinChorusAgainSendToLynx", "getAddSongLimitNum", "Landroidx/lifecycle/LifecycleOwner;", "owner", "needObserveOnUi", "Lio/reactivex/functions/Consumer;", "observer", "observeSingUserChange", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "observeMusicPlayerState", "", "throwable", "errorCode", "musicId", "orderUserId", "checkRTChorusPermissionInfoIfNeed", "onCleared", "", "tmpArray", "onDialogShow", "onDialogDismiss", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "Lcom/bytedance/android/live/ktv/common/music/control/b;", "addNode", "addSong", "Lcom/bytedance/android/livesdkapi/model/ModeType;", "getModeType", "isOnlyAcceptFollowerApply", "isLoadMore", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "requestCallback", "syncMineWantSingSongList", "removeWantSingSong", "syncMultiChorusWaitingList", "syncSongWaitingList", "Lcom/bytedance/android/live/ktv/common/model/bean/d;", "waitingUser", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/y;", "secondLevelTabData", "removeWaitingSongUser", "permitWaitingSongUser", "syncWantListenSongList", "applyWantListen", "lastMusicPanel", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "isEnterRoom", "Z", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/viewmodel/KtvModeOrderSongViewModel$b;", "ktvChorusPermissionData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/viewmodel/KtvModeOrderSongViewModel$b;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "songStartTimeMap", "Ljava/util/HashMap;", "alreadyToastWantListen", "multiChorusSongWaitingData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$b;", "singleSingSongWaitingData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$c;", "wantListenData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$c;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$d;", "wantSingData", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$d;", "Lvb0/a;", "orderSongUiStateObserver$delegate", "Lkotlin/Lazy;", "getOrderSongUiStateObserver", "()Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "orderSongUiStateObserver", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkPlayerStateObserver$delegate", "getLinkPlayerStateObserver", "()Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkPlayerStateObserver", "applyTotalCountObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "multiChorusWaitUserListObserver", "singleSingWaitUserListObserver", "Lcom/bytedance/android/live/ktv/common/model/api/z0;", "wantSingSongListObserver", "wantListenSongListObserver", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "commonOrderSongViewModel", "Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;", "commonSearchViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "orderedSongDataContext", "<init>", "(Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;Lcom/bytedance/android/live/ktv/common/search/viewmodel/a;Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;)V", "Companion", "a", "KtvComponentOrderSongViewModelFactory", "b", "c", "d", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentOrderSongViewModel extends BaseOrderSongViewModel {
    public static final a Companion = null;
    public static final int RT_CHORUS_BUSSINESS_PERMISSION_ERROR_CODE = 4004521;
    private boolean alreadyToastWantListen;
    private final Observer<Long> applyTotalCountObserver;
    private boolean isEnterRoom;
    private KtvModeOrderSongViewModel.b ktvChorusPermissionData;
    private MusicPanel lastMusicPanel;
    private final Lazy linkPlayerStateObserver$delegate;
    private final b multiChorusSongWaitingData;
    private final Observer<List<com.bytedance.android.live.ktv.common.model.bean.d>> multiChorusWaitUserListObserver;
    private final Lazy orderSongUiStateObserver$delegate;
    private final b singleSingSongWaitingData;
    private final Observer<List<com.bytedance.android.live.ktv.common.model.bean.d>> singleSingWaitUserListObserver;
    private final HashMap<Long, Long> songStartTimeMap;
    private final c wantListenData;
    private final Observer<List<MusicPanel>> wantListenSongListObserver;
    private final d wantSingData;
    private final Observer<List<z0>> wantSingSongListObserver;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/viewmodel/KtvComponentOrderSongViewModel$KtvComponentOrderSongViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class KtvComponentOrderSongViewModelFactory implements ViewModelProvider.Factory {
        public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a;
        public final com.bytedance.android.live.ktv.common.search.viewmodel.a b;
        public final OrderedSongDataContext c;

        public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
            return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
        }

        public final <T extends ViewModel> T create(Class<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "modelClass");
            if (r4.isAssignableFrom(KtvComponentOrderSongViewModel.class) == false) goto L7;
            return new KtvComponentOrderSongViewModel(this.a, this.b, this.c);
        L7:
            throw new IllegalArgumentException("Unknow ViewModel class: ".concat(r4.getName()));
        }

        public KtvComponentOrderSongViewModelFactory(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d a(ViewModelStoreOwner r2, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.live.ktv.common.search.viewmodel.a r4, OrderedSongDataContext r5) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            return new ViewModelProvider(r2, new KtvComponentOrderSongViewModelFactory(r3, r4, r5)).get(KtvComponentOrderSongViewModel.class);
        }
    }

    public final class b {
        public boolean a;
        public boolean b;
        public String c;
        public final MutableLiveData<List<com.bytedance.android.live.ktv.common.model.bean.d>> d;
        public final MutableLiveData<com.bytedance.android.live.ktv.common.model.bean.d> e;
        public boolean f;

        public b() {
            this.c = "";
            this.d = new MutableLiveData(new ArrayList());
            this.e = new MutableLiveData(null);
        }
    }

    public final class c {
        public boolean a;
        public String b;
        public long c;
        public String d;
        public boolean e;
        public final MutableLiveData<List<MusicPanel>> f;

        public c() {
            this.b = "";
            this.d = "";
            this.f = new MutableLiveData(new ArrayList());
        }
    }

    public final class d {
        public boolean a;
        public String b;
        public final MutableLiveData<List<z0>> c;
        public final long d;
        public boolean e;
        public boolean f;

        public d() {
            this.b = "";
            this.c = new MutableLiveData(new ArrayList());
            this.d = 10;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public e(KtvComponentOrderSongViewModel r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            Long r0 = (Long) KtvComponentOrderSongViewModel.access$getSongStartTimeMap$p(this.a).remove(Long.valueOf(this.b));
            if (r0 != null) goto L5;
            r0 = Long.valueOf(this.c);
        L5:
            long r1 = r0.longValue();
            mb0.c.a.b(pd2.d.n, LinkMonitorData.ApiChorusPreAddSong, System.currentTimeMillis() - r1, ((ExtraResponse) r8).logId);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public f(KtvComponentOrderSongViewModel r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            Long r0 = (Long) KtvComponentOrderSongViewModel.access$getSongStartTimeMap$p(this.a).remove(Long.valueOf(this.b));
            if (r0 != null) goto L5;
            r0 = Long.valueOf(this.c);
        L5:
            long r1 = r0.longValue();
            mb0.c.a.a(pd2.d.n, LinkMonitorData.ApiChorusPreAddSong, System.currentTimeMillis() - r1, r8);
            ExceptionUtils.handleException(s1.getContext(), r8);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public g(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Long r7 = (Long) r6;
            KtvComponentContext r8 = KtvComponentContext.Companion.getContext();
            Long r0 = null;
            if (r8 == null) goto L7;
            com.bytedance.live.datacontext.n<KtvComponentUIContext> r9 = r8.getKtvComponentUIContext();
            if (r9 == null) goto L7;
            KtvComponentUIContext r10 = (KtvComponentUIContext) r9.getValue();
        L9:
            if (r10 == null) goto L14;
            NextLiveData<Long> r3 = r10.getMultiChorusApplyTotalCount();
            if (r3 == null) goto L14;
            Long r4 = (Long) r3.getValue();
            if (r4 == null) goto L14;
        L15:
            long r5 = r4.longValue();
            if (r10 == null) goto L21;
            NextLiveData<Long> r11 = r10.getSingleSingApplyTotalCount();
            if (r11 == null) goto L21;
            Long r12 = (Long) r11.getValue();
            if (r12 == null) goto L21;
        L22:
            final long r1 = r12.longValue();
            if (MultiChorusContext.Companion.c() == false) goto L25;
            r1 = r1 + r5;
        L25:
            MutableLiveData<vb0.a> r13 = this.a.getOrderSongUiState();
            if (r13 == null) goto L30;
            vb0.a r14 = (vb0.a) r13.getValue();
            if (r14 == null) goto L30;
            r0 = r14.f;
        L30:
            if (r0 != null) goto L33;
        L34:
            MutableLiveData<vb0.a> r15 = this.a.getOrderSongUiState();
            if (r15 == null) goto L39;
            com.bytedance.android.livesdk.ktvapi.util.d.b(r15, new KtvComponentOrderSongViewModel$applyTotalCountObserver$1$1(r1));
            return;
        L39:
            return;
        L33:
            if (r1 != r0.longValue()) goto L34;
            return;
        L21:
            r12 = 0L;
        L14:
            r4 = 0L;
        L7:
            r10 = null;
            goto L9
        }
    }

    public static final class h implements tf0.q {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ boolean b;

        public final void a() {
        }

        public final void b() {
            String r2 = null;
            if (this.b == false) goto L10;
            f2.b(2131918532, 0);
            MusicPanel r0 = KtvComponentOrderSongViewModel.access$getLastMusicPanel$p(this.a);
            if (r0 == null) goto L20;
            KtvComponentOrderSongViewModel r1 = this.a;
            RealTimeChorusInfo r3 = r0.C;
            if (r3 == null) goto L9;
            r2 = r3.getChorusIDStr();
        L9:
            r1.joinChorusAgainSendToLynx("realtime_chorus", r2);
            return;
        L20:
            return;
        L10:
            f2.b(2131918531, 0);
            WeakReference r4 = KtvComponentOrderSongViewModel.access$getContextForCheckPermission$p(this.a);
            if (r4 == null) goto L13;
            Context r5 = (Context) r4.get();
        L14:
            MusicPanel r6 = KtvComponentOrderSongViewModel.access$getLastMusicPanel$p(this.a);
            if (r5 == null) goto L18;
            if (r6 == null) goto L18;
            this.a.addSong(r5, r6, null, null);
        L18:
            KtvComponentOrderSongViewModel.access$setLastMusicPanel$p(this.a, null);
            return;
        L13:
            r5 = null;
            goto L14
        }

        public h(KtvComponentOrderSongViewModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public i(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            KtvComponentOrderSongViewModel r0 = this.a;
            KtvComponentOrderSongViewModel.access$updateWaitingUserList(r0, r4, KtvComponentOrderSongViewModel.access$getMultiChorusSongWaitingData$p(r0));
            KtvComponentOrderSongViewModel r1 = this.a;
            KtvComponentOrderSongViewModel.access$updateWaitingUserList(r1, r4, KtvComponentOrderSongViewModel.access$getSingleSingSongWaitingData$p(r1));
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public j(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            if (Intrinsics.areEqual((Boolean) sh6.c.b((sh6.b) r5), Boolean.FALSE) == false) goto L24;
            KtvComponentContext.a r6 = KtvComponentContext.Companion;
            KtvComponentContext r0 = r6.getContext();
            if (r0 == null) goto L13;
            com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
            if (r1 == null) goto L13;
            KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
            if (r2 == null) goto L13;
            NextLiveData<Long> r3 = r2.getMultiChorusApplyTotalCount();
            if (r3 == null) goto L13;
            r3.setValue(0L);
        L13:
            KtvComponentContext r7 = r6.getContext();
            if (r7 == null) goto L22;
            com.bytedance.live.datacontext.n<KtvComponentUIContext> r8 = r7.getKtvComponentUIContext();
            if (r8 == null) goto L22;
            KtvComponentUIContext r9 = (KtvComponentUIContext) r8.getValue();
            if (r9 == null) goto L22;
            NextLiveData<Long> r10 = r9.getSingleSingApplyTotalCount();
            if (r10 == null) goto L22;
            r10.setValue(0L);
        L22:
            b r11 = KtvComponentOrderSongViewModel.access$getMultiChorusSongWaitingData$p(this.a);
            r11.d.setValue(new ArrayList());
            r11.e.setValue(null);
            r11.b = false;
            r11.f = false;
            b r12 = KtvComponentOrderSongViewModel.access$getSingleSingSongWaitingData$p(this.a);
            r12.d.setValue(new ArrayList());
            r12.e.setValue(null);
            r12.b = false;
            r12.f = false;
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public k(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            List r11 = (List) r10;
            b r12 = KtvComponentOrderSongViewModel.access$getMultiChorusSongWaitingData$p(this.a);
            KtvComponentOrderSongViewModel r0 = this.a;
            boolean r1 = r12.b;
            boolean r2 = r12.f;
            FirstLevelTab r3 = FirstLevelTab.AudienceSingTab;
            List r13 = (List) r12.d.getValue();
            if (r13 != null) goto L5;
            r13 = new ArrayList();
        L5:
            BaseOrderSongViewModel.updateSecondLevelTabDataList$default(r0, r1, r2, r3, "multi_chorus", r13, null, 32, null);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ Consumer b;

        public l(Ref.ObjectRef r1, Consumer r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            MusicPanel r4 = (MusicPanel) CollectionsKt.firstOrNull((List) r3);
            if (r4 == null) goto L5;
            String r0 = r4.g();
        L7:
            if ((!Intrinsics.areEqual(r0, (String) this.a.element)) == false) goto L16;
            this.a.element = r0;
            if (r4 == null) goto L13;
            KtvMusic r5 = r4.a;
            if (r5 == null) goto L13;
            boolean r6 = KtvUtilsKt.w(r5);
        L14:
            this.b.accept(Boolean.valueOf(r6));
            return;
        L13:
            r6 = false;
            goto L14
        L16:
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    public static final class m implements Runnable {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            KtvComponentContext.a r0 = KtvComponentContext.Companion;     // Catch: Throwable -> L16
            KtvComponentContext r1 = r0.getContext();     // Catch: Throwable -> L16
            if (r1 == null) goto L9;
            com.bytedance.live.datacontext.m<Integer> r2 = r1.getPanelState();     // Catch: Throwable -> L16
            if (r2 == null) goto L9;
            Integer r3 = (Integer) r2.getValue();     // Catch: Throwable -> L16
            if (r3 == null) goto L9;
            int r4 = r3.intValue();     // Catch: Throwable -> L16
        L10:
            int r5 = v.b(r4, 2);     // Catch: Throwable -> L16
            KtvComponentContext r6 = r0.getContext();     // Catch: Throwable -> L16
            if (r6 == null) goto L19;
            com.bytedance.live.datacontext.m<Integer> r7 = r6.getPanelState();     // Catch: Throwable -> L16
            if (r7 == null) goto L23;
            r7.setValue(Integer.valueOf(r5));     // Catch: Throwable -> L16
            return;
        L23:
            return;
        L19:
            return;
        L9:
            r4 = 0;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }
    }

    public static final class n<T> implements h80.a {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.d b;

        public n(KtvComponentOrderSongViewModel r1, com.bytedance.android.live.ktv.common.model.bean.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            KtvComponentOrderSongViewModel r4 = this.a;
            IBaseUser r0 = this.b.f();
            if (r0 == null) goto L7;
            String r1 = r0.getIdString();
        L8:
            KtvComponentOrderSongViewModel.access$updateWaitingUserList(r4, r1, KtvComponentOrderSongViewModel.access$getMultiChorusSongWaitingData$p(this.a));
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class o<T> implements h80.a {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.d b;

        public o(KtvComponentOrderSongViewModel r1, com.bytedance.android.live.ktv.common.model.bean.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            KtvComponentOrderSongViewModel r4 = this.a;
            IBaseUser r0 = this.b.f();
            if (r0 == null) goto L7;
            String r1 = r0.getIdString();
        L8:
            KtvComponentOrderSongViewModel.access$updateWaitingUserList(r4, r1, KtvComponentOrderSongViewModel.access$getSingleSingSongWaitingData$p(this.a));
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class p<T> implements h80.a {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.d b;

        public p(KtvComponentOrderSongViewModel r1, com.bytedance.android.live.ktv.common.model.bean.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            KtvComponentOrderSongViewModel r4 = this.a;
            IBaseUser r0 = this.b.f();
            if (r0 == null) goto L7;
            String r1 = r0.getIdString();
        L8:
            KtvComponentOrderSongViewModel.access$updateWaitingUserList(r4, r1, KtvComponentOrderSongViewModel.access$getMultiChorusSongWaitingData$p(this.a));
            f2.b(2131918302, 0);
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class q<T> implements h80.a {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;
        public final /* synthetic */ com.bytedance.android.live.ktv.common.model.bean.d b;

        public q(KtvComponentOrderSongViewModel r1, com.bytedance.android.live.ktv.common.model.bean.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            KtvComponentOrderSongViewModel r4 = this.a;
            IBaseUser r0 = this.b.f();
            if (r0 == null) goto L7;
            String r1 = r0.getIdString();
        L8:
            KtvComponentOrderSongViewModel.access$updateWaitingUserList(r4, r1, KtvComponentOrderSongViewModel.access$getSingleSingSongWaitingData$p(this.a));
            f2.b(2131918302, 0);
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class r<T> implements Observer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public r(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            List r11 = (List) r10;
            b r12 = KtvComponentOrderSongViewModel.access$getSingleSingSongWaitingData$p(this.a);
            KtvComponentOrderSongViewModel r0 = this.a;
            boolean r1 = r12.b;
            boolean r2 = r12.f;
            FirstLevelTab r3 = FirstLevelTab.AudienceSingTab;
            List r13 = (List) r12.d.getValue();
            if (r13 != null) goto L5;
            r13 = new ArrayList();
        L5:
            BaseOrderSongViewModel.updateSecondLevelTabDataList$default(r0, r1, r2, r3, "single_sing", r13, null, 32, null);
        }
    }

    public static final class s<T> implements Observer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public s(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            List r11 = (List) r10;
            c r12 = KtvComponentOrderSongViewModel.access$getWantListenData$p(this.a);
            KtvComponentOrderSongViewModel r0 = this.a;
            if (r12.c == 0) goto L5;
        L8:
            boolean r1 = true;
        L9:
            boolean r2 = r12.e;
            FirstLevelTab r3 = FirstLevelTab.WantListenTab;
            List r13 = (List) r12.f.getValue();
            if (r13 != null) goto L12;
            r13 = new ArrayList();
        L12:
            BaseOrderSongViewModel.updateSecondLevelTabDataList$default(r0, r1, r2, r3, "want_listen", null, r13, 16, null);
            return;
        L5:
            if ((!Intrinsics.areEqual(r12.d, "")) == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class t<T> implements Observer {
        public final /* synthetic */ KtvComponentOrderSongViewModel a;

        public t(KtvComponentOrderSongViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            List r11 = (List) r10;
            d r12 = KtvComponentOrderSongViewModel.access$getWantSingData$p(this.a);
            KtvComponentOrderSongViewModel r0 = this.a;
            boolean r1 = r12.f;
            boolean r2 = r12.e;
            FirstLevelTab r3 = FirstLevelTab.OrderedSongTab;
            List r13 = (List) r12.c.getValue();
            if (r13 != null) goto L5;
            r13 = new ArrayList();
        L5:
            BaseOrderSongViewModel.updateSecondLevelTabDataList$default(r0, r1, r2, r3, "mine_want_sing", r13, null, 32, null);
        }
    }

    static {
        Companion = new a();
    }

    private final com.bytedance.android.livesdk.app.dataholder.Observer<Integer> getLinkPlayerStateObserver() {
        return (com.bytedance.android.livesdk.app.dataholder.Observer) this.linkPlayerStateObserver$delegate.getValue();
    }

    private final Observer<vb0.a> getOrderSongUiStateObserver() {
        return (Observer) this.orderSongUiStateObserver$delegate.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d newInstance(ViewModelStoreOwner r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.live.ktv.common.search.viewmodel.a r3, OrderedSongDataContext r4) {
        Companion.getClass();
        return a.a(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final boolean isLinkMicSeatFull() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.i r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L9;
        List r2 = r1.getOnlineUserList();
        if (r2 == null) goto L9;
        int r3 = r2.size();
    L10:
        KtvContext.Companion.getClass();
        Integer r5 = null;
        if (KtvContext.a.m() == false) goto L44;
        u r4 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r4 == null) goto L21;
        com.bytedance.live.datacontext.j r6 = r4.getVideoTalkRoomSubScene();
        if (r6 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r7.t();
        if (r8 == null) goto L21;
        r5 = Integer.valueOf(r8.a);
    L21:
        if (r5 != null) goto L24;
    L29:
        if (r5 != null) goto L32;
    L37:
        if (r5 != null) goto L40;
        return false;
    L40:
        if (12 != r5.intValue()) goto L74;
        if (r3 < 9) goto L71;
        return true;
    L71:
        return false;
    L74:
        return false;
    L32:
        if (8 != r5.intValue()) goto L37;
        if (r3 < 7) goto L70;
        return true;
    L70:
        return false;
    L24:
        if (4 != r5.intValue()) goto L29;
        if (r3 < 2) goto L69;
        return true;
    L69:
        return false;
    L44:
        u r9 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r9 == null) goto L51;
        com.bytedance.live.datacontext.j r10 = r9.s();
        if (r10 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r10.getValue();
        if (r11 == null) goto L51;
        r5 = r11.t();
    L51:
        if (r5 != null) goto L53;
        return false;
    L53:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.i) r5).a != 5) goto L76;
        int r12 = ((com.bytedance.android.livesdk.chatroom.viewmodel.i) r5).b;
        if (r12 != 22) goto L60;
        if (r3 < 10) goto L72;
        return true;
    L72:
        return false;
    L60:
        if (e0.b(r12) == false) goto L65;
        if (r3 < 9) goto L73;
        return true;
    L73:
        return false;
    L65:
        if (r12 != 26) goto L77;
        if (r3 < 10) goto L78;
        return true;
    L78:
        return false;
    L77:
        return false;
    L76:
        return false;
    L9:
        r3 = 0;
        goto L10
    }

    private final boolean shouldInterceptPermit() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.revenue.fight.b r1 = r0.teamFightService();
        if (r1 == null) goto L7;
        boolean r2 = r1.isTeamFightShowing();
    L8:
        int r3 = jc1.k.n(IInteractService.class).getLinkMode();
        boolean r4 = v.a(r3, 4);
        boolean r5 = v.a(r3, 64);
        int r6 = ge2.a.a;
        if (vm2.d.C0() == true) goto L11;
        ALogger.i("VideoKtv", "roomSupportVideoKtv,live_video_ktv_enable is false");
    L16:
        boolean r7 = false;
    L18:
        boolean r8 = !r7;
        if (r2 == true) goto L25;
        if (r4 == true) goto L25;
        if (r5 == true) goto L25;
        if (r8 == true) goto L25;
        return false;
    L25:
        if (r2 == false) goto L27;
        f2.c(s1.B(2131918630), 0);
    L33:
        return true;
    L27:
        if (r4 == false) goto L29;
        f2.c(s1.B(2131918489), 0);
        goto L33
    L29:
        if (r5 == false) goto L31;
        f2.c(s1.B(2131918406), 0);
        goto L33
    L31:
        if (r8 == false) goto L33;
        f2.c(s1.B(2131918407), 0);
        goto L33
    L11:
        float r9 = com.bytedance.android.livesdk.utils.z0.b(true);
        ALogger.i("VideoKtv", "roomSupportVideoKtv,score:" + r9);
        if (r9 > 0) goto L14;
    L17:
        r7 = true;
        goto L18
    L14:
        if (r9 < vm2.d.D0()) goto L16;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public boolean isOnlyAcceptFollowerApply() {
        int r0 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (r0 != 5) goto L5;
    L25:
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.M0.getValue();
    L27:
        return r1.booleanValue();
    L5:
        if (r0 != 12) goto L7;
    L24:
        r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue();
        goto L27
    L7:
        if (r0 != 16) goto L9;
        com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r2 == null) goto L22;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L22;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L22;
        if (r4.isLiveTypeAudio() != true) goto L22;
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.c.M0;
    L23:
        r1 = (Boolean) r5.getValue();
    L22:
        r5 = com.bytedance.android.livesdk.sharedpref.c.p1;
        goto L23
    L9:
        if (r0 == 8) goto L24;
        if (r0 == 9) goto L25;
        r1 = Boolean.FALSE;
        goto L27
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public int getAddSongLimitNum() {
        if (jc0.a.c() == false) goto L11;
        if (isAnchor() == false) goto L9;
        return ((Integer) rw0.a.getValue()).intValue();
    L9:
        return ((Integer) sw0.a.getValue()).intValue();
    L11:
        return super.getAddSongLimitNum();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public ModeType getModeType() {
        if (jc0.a.c() == false) goto L7;
        return ModeType.VIDEO_CHORUS;
    L7:
        return ModeType.KTV_COMPONENT;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void initData() {
        super.initData();
        if (jc0.a.c() == false) goto L23;
        vlc.d r0 = getMsgManager();
        if (r0 == null) goto L7;
        r0.addMessageListener(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this);
    L7:
        vlc.d r1 = getMsgManager();
        xlc.a r2 = null;
        if ((r1 instanceof xlc.a) == true) goto L10;
        r1 = null;
    L10:
        xlc.a r3 = (xlc.a) r1;
        if (r3 == null) goto L13;
        r3.y(MessageType.KTV_CHORUS_ACTION_MESSAGE.getIntType(), this);
    L13:
        vlc.d r4 = getMsgManager();
        if (r4 == null) goto L16;
        r4.addMessageListener(MessageType.KTV_CHORUS_PERMISSION_MESSAGE.getIntType(), this);
    L16:
        xlc.a r5 = getMsgManager();
        if ((r5 instanceof xlc.a) == false) goto L20;
        r2 = r5;
    L20:
        xlc.a r6 = r2;
        if (r6 == null) goto L23;
        r6.y(MessageType.KTV_CHORUS_PERMISSION_MESSAGE.getIntType(), this);
    L23:
        KtvComponentContext.a r7 = KtvComponentContext.Companion;
        KtvComponentContext r8 = r7.getContext();
        if (r8 == null) goto L36;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r9 = r8.getKtvComponentUIContext();
        if (r9 == null) goto L36;
        KtvComponentUIContext r10 = (KtvComponentUIContext) r9.getValue();
        if (r10 == null) goto L36;
        com.bytedance.live.datacontext.k<String> r11 = r10.getPermitUser();
        if (r11 == null) goto L36;
        PublishSubject r12 = r11.onEvent();
        if (r12 == null) goto L36;
        Disposable r13 = r12.subscribe(new i(this));
        if (r13 == null) goto L36;
        RxUtilKt.c(r13, getCompositeDisposable());
    L36:
        KtvComponentContext r14 = r7.getContext();
        if (r14 == null) goto L45;
        com.bytedance.live.datacontext.n<Boolean> r15 = r14.isAudienceEnableSing();
        if (r15 == null) goto L45;
        Observable r16 = r15.a();
        if (r16 == null) goto L45;
        Disposable r17 = r16.subscribe(new j(this));
        if (r17 == null) goto L45;
        RxUtilKt.c(r17, getCompositeDisposable());
    L45:
        hd0.c.f().c(getLinkPlayerStateObserver());
        this.multiChorusSongWaitingData.d.observeForever(this.multiChorusWaitUserListObserver);
        this.singleSingSongWaitingData.d.observeForever(this.singleSingWaitUserListObserver);
        this.wantSingData.c.observeForever(this.wantSingSongListObserver);
        this.wantListenData.f.observeForever(this.wantListenSongListObserver);
        getMOrderSongUiState().observeForever(getOrderSongUiStateObserver());
        KtvComponentContext r18 = r7.getContext();
        if (r18 == null) goto L54;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r19 = r18.getKtvComponentUIContext();
        if (r19 == null) goto L54;
        KtvComponentUIContext r20 = (KtvComponentUIContext) r19.getValue();
        if (r20 == null) goto L54;
        NextLiveData<Long> r21 = r20.getMultiChorusApplyTotalCount();
        if (r21 == null) goto L54;
        r21.observeForever(this.applyTotalCountObserver);
    L54:
        KtvComponentContext r22 = r7.getContext();
        if (r22 == null) goto L64;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r23 = r22.getKtvComponentUIContext();
        if (r23 == null) goto L65;
        KtvComponentUIContext r24 = (KtvComponentUIContext) r23.getValue();
        if (r24 == null) goto L66;
        NextLiveData<Long> r25 = r24.getSingleSingApplyTotalCount();
        if (r25 == null) goto L67;
        r25.observeForever(this.applyTotalCountObserver);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public void onCleared() {
        super.onCleared();
        this.multiChorusSongWaitingData.d.removeObserver(this.multiChorusWaitUserListObserver);
        this.singleSingSongWaitingData.d.removeObserver(this.singleSingWaitUserListObserver);
        this.wantSingData.c.removeObserver(this.wantSingSongListObserver);
        this.wantListenData.f.removeObserver(this.wantListenSongListObserver);
        getMOrderSongUiState().removeObserver(getOrderSongUiStateObserver());
        hd0.c.f().e(getLinkPlayerStateObserver());
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        KtvComponentContext r1 = r0.getContext();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r2 = r1.getKtvComponentUIContext();
        if (r2 == null) goto L11;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r2.getValue();
        if (r3 == null) goto L11;
        NextLiveData<Long> r4 = r3.getMultiChorusApplyTotalCount();
        if (r4 == null) goto L11;
        r4.removeObserver(this.applyTotalCountObserver);
    L11:
        KtvComponentContext r5 = r0.getContext();
        if (r5 == null) goto L21;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r6 = r5.getKtvComponentUIContext();
        if (r6 == null) goto L22;
        KtvComponentUIContext r7 = (KtvComponentUIContext) r6.getValue();
        if (r7 == null) goto L23;
        NextLiveData<Long> r8 = r7.getSingleSingApplyTotalCount();
        if (r8 == null) goto L24;
        r8.removeObserver(this.applyTotalCountObserver);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onDialogDismiss() {
        Handler r0 = i0.c();
        if (r0 == null) goto L6;
        r0.postDelayed(m.a, 200);
        return;
    }

    public static final /* synthetic */ boolean access$getAlreadyToastWantListen$p(KtvComponentOrderSongViewModel r0) {
        return r0.alreadyToastWantListen;
    }

    public static final /* synthetic */ WeakReference access$getContextForCheckPermission$p(KtvComponentOrderSongViewModel r0) {
        return r0.getContextForCheckPermission();
    }

    public static final /* synthetic */ MusicPanel access$getLastMusicPanel$p(KtvComponentOrderSongViewModel r0) {
        return r0.lastMusicPanel;
    }

    public static final /* synthetic */ b access$getMultiChorusSongWaitingData$p(KtvComponentOrderSongViewModel r0) {
        return r0.multiChorusSongWaitingData;
    }

    public static final /* synthetic */ b access$getSingleSingSongWaitingData$p(KtvComponentOrderSongViewModel r0) {
        return r0.singleSingSongWaitingData;
    }

    public static final /* synthetic */ HashMap access$getSongStartTimeMap$p(KtvComponentOrderSongViewModel r0) {
        return r0.songStartTimeMap;
    }

    public static final /* synthetic */ c access$getWantListenData$p(KtvComponentOrderSongViewModel r0) {
        return r0.wantListenData;
    }

    public static final /* synthetic */ d access$getWantSingData$p(KtvComponentOrderSongViewModel r0) {
        return r0.wantSingData;
    }

    private final String getLimitType(RTChorusOperateType r2) {
        if (r2 != RTChorusOperateType.ORDER_SONG) goto L5;
        return "order_limit";
    L5:
        return "join_limit";
    }

    private final String getPopupType(int r2) {
        if (r2 != PermissionType.FansClub.getValue()) goto L6;
        return "fans_club";
    L6:
        if (r2 != PermissionType.Subscribe.getValue()) goto L9;
        return "vip";
    L9:
        if (r2 != PermissionType.SendAssignGift.getValue()) goto L11;
        return "gift";
    L11:
        return "";
    }

    private final String getRequestPage(RTChorusOperateType r2) {
        if (r2 != RTChorusOperateType.ORDER_SONG) goto L5;
        return "chorus_order";
    L5:
        return "chorus_join";
    }

    private final void resetMultiChorusWaitingListCursorIfNeed(boolean r3) {
        if (r3 == false) goto L5;
        b r4 = this.multiChorusSongWaitingData;
        r4.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r4.c = "";
        return;
    }

    private final void resetSingleSingWaitingListCursorIfNeed(boolean r3) {
        if (r3 == false) goto L5;
        b r4 = this.singleSingSongWaitingData;
        r4.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r4.c = "";
        return;
    }

    private final void resetWantListenCursorIfNeed(boolean r3) {
        if (r3 == false) goto L5;
        c r4 = this.wantListenData;
        r4.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r4.b = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r4.d = "";
        r4.c = 0;
        return;
    }

    private final void resetWantSingCursorIfNeed(boolean r3) {
        if (r3 == false) goto L5;
        d r4 = this.wantSingData;
        r4.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r4.b = "";
        return;
    }

    private final void updateWantSingSongList(KtvMusic r5) {
        List r0 = (List) this.wantSingData.c.getValue();
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        KtvMusic r2 = ((z0) r1.next()).b();
        if (r2 == null) goto L7;
        if (r2.isSameKtvMusic(r5) != true) goto L7;
        r1.remove();
    L14:
        if (r0.isEmpty() == false) goto L25;
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 == null) goto L21;
        if (r6.intValue() != 1) goto L21;
    L22:
        setApplying(false);
        com.bytedance.android.livesdk.ktvimpl.base.util.e r7 = getKtvRoomStrategy();
        if (r7 == null) goto L25;
        r7.cancelApply(null);
    L21:
        if (qe2.d.a() == 0) goto L22;
    L25:
        this.wantSingData.c.setValue(r0);
        KtvComponentContext r8 = KtvComponentContext.Companion.getContext();
        if (r8 == null) goto L41;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r9 = r8.getKtvComponentUIContext();
        if (r9 == null) goto L42;
        KtvComponentUIContext r10 = (KtvComponentUIContext) r9.getValue();
        if (r10 == null) goto L43;
        MutableLiveData<Long> r11 = r10.getMyWantSingSongTotalNum();
        if (r11 == null) goto L44;
        r11.setValue(Long.valueOf(r0.size()));
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void onDialogShow(int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "tmpArray");
        KtvComponentContext.a r0 = KtvComponentContext.Companion;
        KtvComponentContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r2 = r1.getPanelTop();
        if (r2 == null) goto L7;
        r2.setValue(Integer.valueOf(r4[1]));
    L7:
        KtvComponentContext r5 = r0.getContext();
        if (r5 == null) goto L14;
        com.bytedance.live.datacontext.m<Integer> r6 = r5.getPanelState();
        if (r6 == null) goto L14;
        Integer r7 = (Integer) r6.getValue();
        if (r7 == null) goto L14;
        int r8 = r7.intValue();
    L15:
        int r9 = r8 | 2;
        KtvComponentContext r3 = r0.getContext();
        if (r3 == null) goto L21;
        com.bytedance.live.datacontext.m<Integer> r10 = r3.getPanelState();
        if (r10 == null) goto L22;
        r10.setValue(Integer.valueOf(r9));
        return;
    L22:
        return;
    L21:
        return;
    L14:
        r8 = 0;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public void onMessage(tlc.d r8) {
        super.onMessage(r8);
        if ((r8 instanceof jd) == false) goto L37;
        jd r0 = (jd) r8;
        Integer r2 = r0.getMsgType();
        if (r2 == null) goto L37;
        if (r2.intValue() != 1) goto L37;
        o2 r3 = r0.getGiftSentContent();
        String r4 = null;
        if (r3 == null) goto L12;
        Boolean r5 = r3.b();
    L13:
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r6) == false) goto L24;
        WeakReference<Context> r7 = getContextForCheckPermission();
        if (r7 == null) goto L18;
        Context r9 = r7.get();
    L19:
        MusicPanel r10 = this.lastMusicPanel;
        if (r9 == null) goto L23;
        if (r10 == null) goto L23;
        addSong(r9, r10, null, null);
    L23:
        this.lastMusicPanel = null;
        goto L24
    L18:
        r9 = null;
    L24:
        o2 r1 = r0.getGiftSentContent();
        if (r1 == null) goto L27;
        Boolean r11 = r1.a();
    L29:
        if (Intrinsics.areEqual(r11, r6) == false) goto L37;
        MusicPanel r12 = this.lastMusicPanel;
        if (r12 == null) goto L37;
        RealTimeChorusInfo r13 = r12.C;
        if (r13 == null) goto L35;
        r4 = r13.getChorusIDStr();
    L35:
        joinChorusAgainSendToLynx("realtime_chorus", r4);
        goto L37
    L27:
        r11 = null;
        goto L29
    L12:
        r5 = null;
    L37:
        if ((r8 instanceof ld) == true) goto L39;
        return;
    L39:
        if (this.isEnterRoom == true) goto L42;
        this.isEnterRoom = true;
    L65:
        KtvModeOrderSongViewModel.b r14 = this.ktvChorusPermissionData;
        ld r15 = (ld) r8;
        r14.a = r15.getOrderPermissionType();
        r14.b = r15.getJoinPermissionType();
        r14.c = r15.getOrderSongGift();
        r14.d = r15.getJoinChorusGift();
        return;
    L42:
        if (isAnchor() == false) goto L44;
    L45:
        int r16 = this.ktvChorusPermissionData.a;
        PermissionType r17 = PermissionType.SendAssignGift;
        if (r16 != r17.getValue()) goto L56;
        ld r18 = (ld) r8;
        if (this.ktvChorusPermissionData.a == r18.getOrderPermissionType()) goto L50;
        f2.c(s1.B(2131922304), 0);
        goto L56
    L50:
        ej r19 = this.ktvChorusPermissionData.c;
        if (r19 == null) goto L56;
        if ((!Intrinsics.areEqual(r19, r18.getOrderSongGift())) == false) goto L56;
        f2.c(s1.B(2131922304), 0);
    L56:
        if (this.ktvChorusPermissionData.b != r17.getValue()) goto L65;
        ld r20 = (ld) r8;
        if (this.ktvChorusPermissionData.b == r20.getJoinPermissionType()) goto L60;
        f2.c(s1.B(2131922303), 0);
        goto L65
    L60:
        ej r21 = this.ktvChorusPermissionData.d;
        if (r21 == null) goto L65;
        if ((!Intrinsics.areEqual(r21, r20.getJoinChorusGift())) == false) goto L65;
        f2.c(s1.B(2131922303), 0);
        goto L65
    L44:
        if (KtvUtilsKt.j() == false) goto L65;
        goto L45
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void removeWantSingSong(final KtvMusic r20) {
        if (r20 != null) goto L5;
        return;
    L5:
        long r11 = r20.getMId();
        final MusicPanel r13 = new MusicPanel(r20, 0, null, false, null, null, null, 1073741822);
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L11;
        String r3 = r2.n();
        if (r3 == null) goto L11;
    L13:
        if (r20.isOrderedBy(r3) == false) goto L24;
        long r4 = System.currentTimeMillis();
        long r6 = com.bytedance.android.live.ktv.common.util.a.c().getRoomId();
        int r5 = com.bytedance.android.live.ktv.common.karaokestation.model.g.a;
        com.bytedance.android.live.ktv.common.karaokestation.model.g r7 = com.bytedance.android.live.ktv.common.karaokestation.model.g.b.a;
        OrderInfo r8 = r13.a.getOrderInfo();
        if (r8 == null) goto L22;
        InteractiveSongUserInfo r9 = r8.getTopUser();
        if (r9 == null) goto L22;
        String r10 = r9.getIdString();
        if (r10 == null) goto L22;
        String r14 = r10;
    L23:
        String r12 = r14;
        r7.e(r4, r6, r6, r11, r12, false, r13.a.getSongType(), KtvUtilsKt.i(r13), new C02161(this, r20), C02172.INSTANCE);
        return;
    L22:
        r14 = "";
        goto L23
    L24:
        MultiChorusContext.Companion.f(r13, new C02183(this, r20, r13), AnonymousClass4.INSTANCE);
        we2.a.e(r13, "my_order", "leave_chorus");
        return;
    L11:
        r3 = "";
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel
    public boolean shouldFillLocalPath(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        if (jc0.a.c() == false) goto L7;
        return true;
    L7:
        return super.shouldFillLocalPath(r2);
    }

    public final void updateCurrentKSongElementMethod(boolean r3) {
        KtvContext.Companion.getClass();
        oe2.b r0 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a) == false) goto L8;
        if (r3 == false) goto L6;
        ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a) r0).b = "re_open";
        return;
    L6:
        ((com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.a) r0).b = "new_open";
        return;
    }

    public static final /* synthetic */ String access$getRequestPage(KtvComponentOrderSongViewModel r0, RTChorusOperateType r1) {
        return r0.getRequestPage(r1);
    }

    public static final /* synthetic */ void access$setAlreadyToastWantListen$p(KtvComponentOrderSongViewModel r0, boolean r1) {
        r0.alreadyToastWantListen = r1;
    }

    public static final /* synthetic */ void access$setContextForCheckPermission$p(KtvComponentOrderSongViewModel r0, WeakReference r1) {
        r0.setContextForCheckPermission(r1);
    }

    public static final /* synthetic */ void access$setLastMusicPanel$p(KtvComponentOrderSongViewModel r0, MusicPanel r1) {
        r0.lastMusicPanel = r1;
    }

    public static final /* synthetic */ void access$updateWantSingSongList(KtvComponentOrderSongViewModel r0, KtvMusic r1) {
        r0.updateWantSingSongList(r1);
    }

    private final void updateWaitingUserList(String r9, b r10) {
        List r0 = (List) r10.d.getValue();
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L39;
        IBaseUser r2 = ((com.bytedance.android.live.ktv.common.model.bean.d) r1.next()).f();
        if (r2 == null) goto L11;
        String r3 = r2.getIdString();
    L13:
        if (Intrinsics.areEqual(r3, String.valueOf(r9)) == false) goto L7;
        r1.remove();
        if (Intrinsics.areEqual(this.multiChorusSongWaitingData, r10) == false) goto L38;
        KtvComponentContext.a r11 = KtvComponentContext.Companion;
        KtvComponentContext r4 = r11.getContext();
        if (r4 == null) goto L26;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r5 = r4.getKtvComponentUIContext();
        if (r5 == null) goto L26;
        KtvComponentUIContext r6 = (KtvComponentUIContext) r5.getValue();
        if (r6 == null) goto L26;
        NextLiveData<Long> r7 = r6.getMultiChorusApplyTotalCount();
        if (r7 == null) goto L26;
        Long r8 = (Long) r7.getValue();
        if (r8 == null) goto L26;
    L27:
        long r12 = r8.longValue() - 1;
        if (r12 < 0) goto L38;
        KtvComponentContext r13 = r11.getContext();
        if (r13 == null) goto L38;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r14 = r13.getKtvComponentUIContext();
        if (r14 == null) goto L38;
        KtvComponentUIContext r15 = (KtvComponentUIContext) r14.getValue();
        if (r15 == null) goto L38;
        NextLiveData<Long> r16 = r15.getMultiChorusApplyTotalCount();
        if (r16 == null) goto L38;
        r16.setValue(Long.valueOf(r12));
    L26:
        r8 = 0L;
    L38:
        boolean r17 = true;
    L40:
        if (r17 == false) goto L65;
        r10.d.setValue(r0);
        KtvComponentContext.a r18 = KtvComponentContext.Companion;
        KtvComponentContext r19 = r18.getContext();
        if (r19 == null) goto L51;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r110 = r19.getKtvComponentUIContext();
        if (r110 == null) goto L51;
        KtvComponentUIContext r111 = (KtvComponentUIContext) r110.getValue();
        if (r111 == null) goto L51;
        NextLiveData<Long> r112 = r111.getSingleSingApplyTotalCount();
        if (r112 == null) goto L51;
        Long r113 = (Long) r112.getValue();
        if (r113 == null) goto L51;
    L52:
        long r20 = r113.longValue();
        KtvComponentContext r21 = r18.getContext();
        if (r21 == null) goto L66;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r22 = r21.getKtvComponentUIContext();
        if (r22 == null) goto L67;
        KtvComponentUIContext r23 = (KtvComponentUIContext) r22.getValue();
        if (r23 == null) goto L68;
        NextLiveData<Long> r24 = r23.getSingleSingApplyTotalCount();
        if (r24 == null) goto L69;
        r24.setValue(Long.valueOf(RangesKt.coerceAtLeast(r20 - 1, 0)));
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L51:
        r113 = 0L;
        goto L52
    L65:
        return;
    L11:
        r3 = null;
        goto L13
    L39:
        r17 = false;
        goto L40
    }

    public final void joinChorusAgainSendToLynx(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "businessId");
        ALogger.i(BaseOrderSongViewModel.TAG, "onJoinChorusAgain, result: " + r6);
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L16;
        JsonObject r2 = new JsonObject();
        r2.addProperty("sub_type", "chorus");
        r2.addProperty("chorus_id", r6);
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 == null) goto L17;
        ih0.b r8 = r7.dynamicService(getDataCenter());
        if (r8 == null) goto L18;
        r8.Dk(r5, "onJoinChorusAgain", r2, false);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeMusicPlayerState(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r0 = VideoChorusDataContext.Companion.a();
        if (r0 == null) goto L6;
        r0.observeMusicPlayerState(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void permitWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r14, y r15) {
        Intrinsics.checkNotNullParameter(r14, "waitingUser");
        Intrinsics.checkNotNullParameter(r15, "secondLevelTabData");
        IBaseUser r0 = r14.f();
        if (r0 == null) goto L6;
        String r1 = r0.getIdString();
        if (r1 == null) goto L6;
    L7:
        long r2 = r14.e();
        String r3 = r14.c();
        String r4 = r14.b();
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L10;
        int r6 = r5.getCurrentScene();
    L12:
        if (r6 > 0) goto L14;
    L16:
        boolean r8 = false;
    L17:
        int r9 = ke2.b.a;
        String r10 = r15.d;
        String r11 = com.bytedance.android.live.ktv.common.karaokestation.model.f.b(com.bytedance.android.live.ktv.common.karaokestation.model.f.a(r15.k));
        Intrinsics.checkNotNullParameter(r1, "uid");
        Intrinsics.checkNotNullParameter(r3, "songName");
        Intrinsics.checkNotNullParameter(r4, "songId");
        LinkedHashMap r12 = new LinkedHashMap();
        ke2.b.j(r12);
        ke2.b.m(r12);
        ke2.b.l(r12);
        ke2.b.k(r12);
        r12.put("applicant_id", r1);
        r12.put("applicant_song_cnt", String.valueOf(r2));
        r12.put("song_name", r3);
        r12.put("song_id", r4);
        if (r8 == false) goto L20;
        String r7 = "1";
    L21:
        r12.put("is_full", r7);
        if (r10 == null) goto L25;
        r12.put("sub_tab", r10);
    L25:
        if (r11.length() <= 0) goto L27;
        boolean r13 = true;
    L28:
        if (r13 != true) goto L30;
        r12.put("main_tab", r11);
    L30:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r12);
        j0.l().sendLog("livesdk_anchor_ksong_accept_button_click", r12, new Object[]{IRoom.class});
        if (shouldInterceptPermit() == false) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(r15.c, "multi_chorus") == false) goto L39;
        IBaseUser r16 = r14.f();
        if (r16 == null) goto L48;
        MultiChorusContext.Companion.l(r16, new n(this, r14), "user_chorus_accept_button");
    L48:
        if (r6 != 0) goto L51;
        KSongOrderSongUtilKt.i(com.bytedance.android.live.core.utils.a.d(), CloseOrderSongDialogSource.AUTO);
        return;
    L51:
        return;
    L39:
        if (Intrinsics.areEqual(r15.c, "single_sing") == false) goto L48;
        IBaseUser r17 = r14.f();
        if (r17 == null) goto L48;
        KtvContext.Companion.getClass();
        Object r18 = KtvContext.a.g().getKtvRoomStrategy().getValue();
        if ((r18 instanceof KtvComponentRoomStrategy) == true) goto L45;
        r18 = null;
    L45:
        KtvComponentRoomStrategy r19 = (KtvComponentRoomStrategy) r18;
        if (r19 == null) goto L48;
        KtvComponentRoomStrategy.permit$default(r19, r17, new o(this, r14), null, 4, null);
        goto L48
    L27:
        r13 = false;
        goto L28
    L20:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L21
    L14:
        if (isLinkMicSeatFull() == false) goto L16;
        r8 = true;
        goto L17
    L10:
        r6 = 0;
    L6:
        r1 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void removeWaitingSongUser(com.bytedance.android.live.ktv.common.model.bean.d r3, y r4) {
        Intrinsics.checkNotNullParameter(r3, "waitingUser");
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        if (Intrinsics.areEqual(r4.c, "multi_chorus") == false) goto L12;
        MultiChorusContext.a r5 = MultiChorusContext.Companion;
        p r0 = new p(this, r3);
        MultiChorusContext r6 = r5.getContext();
        if (r6 == null) goto L20;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvapi.util.a> r7 = r6.m441getService();
        if (r7 == null) goto L21;
        com.bytedance.android.livesdk.ktvapi.util.a r8 = (com.bytedance.android.livesdk.ktvapi.util.a) r7.getValue();
        if (r8 == null) goto L22;
        r8.cancelApply(r0);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L12:
        if (Intrinsics.areEqual(r4.c, "single_sing") == false) goto L24;
        KtvContext.Companion.getClass();
        Object r9 = KtvContext.a.g().getKtvRoomStrategy().getValue();
        if ((r9 instanceof KtvComponentRoomStrategy) == true) goto L16;
        r9 = null;
    L16:
        KtvComponentRoomStrategy r10 = (KtvComponentRoomStrategy) r9;
        if (r10 == null) goto L25;
        r10.cancelApply(new q(this, r3));
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncMineWantSingSongList(final boolean r10, Function1<? super Boolean, Unit> r11) {
        d r12 = this.wantSingData;
        if (r12.a == false) goto L5;
        return;
    L5:
        r12.a = true;
        resetWantSingCursorIfNeed(!r10);
        long r0 = System.currentTimeMillis();
        long r3 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        int r13 = rd2.a.a;
        rd2.a r14 = rd2.a.b.a;
        d r2 = this.wantSingData;
        long r5 = r2.d;
        String r7 = r2.b;
        Function1<com.bytedance.android.live.network.response.e<a1>, Unit> r8 = new C02191(this, r10);
        Function1<Throwable, Unit> r15 = new C02202(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r7, "wantSingCursor");
        Intrinsics.checkNotNullParameter(r8, "successCallBack");
        Intrinsics.checkNotNullParameter(r15, "failCallBack");
        KtvComponentApi r4 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r4 == null) goto L12;
        Observable<com.bytedance.android.live.network.response.e<a1>> r16 = r4.getWantSingSongList(r3, r5, r7);
        if (r16 == null) goto L12;
        Observable r17 = r16.compose(RxUtil.rxSchedulerHelper());
        if (r17 == null) goto L12;
        Disposable r18 = r17.subscribe(new rd2.l(r0, r8), new rd2.m(r0, r15));
    L13:
        if (r18 == null) goto L16;
        RxUtilKt.c(r18, getCompositeDisposable());
        return;
    L16:
        return;
    L12:
        r18 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncMultiChorusWaitingList(final boolean r10, final Function1<? super Boolean, Unit> r11) {
        b r0 = this.multiChorusSongWaitingData;
        if (r0.a == false) goto L5;
        return;
    L5:
        r0.a = true;
        resetMultiChorusWaitingListCursorIfNeed(!r10);
        long r1 = System.currentTimeMillis();
        long r2 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        int r4 = rd2.a.a;
        rd2.a r5 = rd2.a.b.a;
        String r6 = this.multiChorusSongWaitingData.c;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.ktvimpl.multichorus.api.a>, Unit> r7 = new C02211(this, r10, r11);
        Function1<Throwable, Unit> r12 = new C02222(this, r11);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "waitingUserListCursor");
        Intrinsics.checkNotNullParameter(r7, "successCallBack");
        Intrinsics.checkNotNullParameter(r12, "failCallBack");
        MultiChorusApi r13 = (MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class);
        if (r13 == null) goto L12;
        Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.ktvimpl.multichorus.api.a>> r14 = r13.getMultiChorusWaitingList(r2, (int) 50, r6);
        if (r14 == null) goto L12;
        Observable r15 = r14.compose(RxUtil.rxSchedulerHelper());
        if (r15 == null) goto L12;
        Disposable r16 = r15.subscribe(new rd2.h(r1, r7), new rd2.i(r1, r12));
    L13:
        if (r16 == null) goto L16;
        RxUtilKt.c(r16, getCompositeDisposable());
        return;
    L16:
        return;
    L12:
        r16 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncSongWaitingList(final boolean r8, final Function1<? super Boolean, Unit> r9) {
        b r0 = this.singleSingSongWaitingData;
        if (r0.a == false) goto L5;
        return;
    L5:
        r0.a = true;
        resetSingleSingWaitingListCursorIfNeed(!r8);
        long r1 = System.currentTimeMillis();
        long r2 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        int r4 = rd2.a.a;
        rd2.a r5 = rd2.a.b.a;
        String r6 = this.singleSingSongWaitingData.c;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.i>, Unit> r7 = new C02231(this, r8, r9);
        Function1<Throwable, Unit> r10 = new C02242(this, r9);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "waitingUserListCursor");
        Intrinsics.checkNotNullParameter(r7, "successCallBack");
        Intrinsics.checkNotNullParameter(r10, "failCallBack");
        KtvComponentApi r11 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r11 == null) goto L12;
        Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.i>> r12 = r11.getSongWaitingList(r2, r6);
        if (r12 == null) goto L12;
        Observable r13 = r12.compose(RxUtil.rxSchedulerHelper());
        if (r13 == null) goto L12;
        Disposable r14 = r13.subscribe(new rd2.j(r1, r7), new rd2.k(r1, r10));
    L13:
        if (r14 == null) goto L16;
        RxUtilKt.c(r14, getCompositeDisposable());
        return;
    L16:
        return;
    L12:
        r14 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void syncWantListenSongList(final boolean r13, final Function1<? super Boolean, Unit> r14) {
        c r0 = this.wantListenData;
        if (r0.a == false) goto L5;
        return;
    L5:
        r0.a = true;
        boolean r9 = !r13;
        resetWantListenCursorIfNeed(r9);
        long r1 = System.currentTimeMillis();
        long r3 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        int r2 = rd2.a.a;
        rd2.a r4 = rd2.a.b.a;
        c r5 = this.wantListenData;
        String r6 = r5.d;
        long r7 = r5.c;
        String r10 = r5.b;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.a>, Unit> r11 = new C02251(this, r13, r14);
        Function1<Throwable, Unit> r15 = new C02262(this, r14);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "wantListenCursor");
        Intrinsics.checkNotNullParameter(r10, "queryId");
        Intrinsics.checkNotNullParameter(r11, "successCallBack");
        Intrinsics.checkNotNullParameter(r15, "failCallBack");
        KtvComponentApi r8 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r8 == null) goto L12;
        Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.a>> r16 = r8.getListenSongList(r3, r6, r7, r10, r9);
        if (r16 == null) goto L12;
        Observable r17 = r16.compose(RxUtil.rxSchedulerHelper());
        if (r17 == null) goto L12;
        Disposable r18 = r17.subscribe(new rd2.f(r1, r11), new rd2.g(r1, r15));
    L13:
        if (r18 == null) goto L16;
        RxUtilKt.c(r18, getCompositeDisposable());
        return;
    L16:
        return;
    L12:
        r18 = null;
        goto L13
    }

    public KtvComponentOrderSongViewModel(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r1, com.bytedance.android.live.ktv.common.search.viewmodel.a r2, OrderedSongDataContext r3) {
        super(r1, r2, r3);
        this.ktvChorusPermissionData = new KtvModeOrderSongViewModel.b(0);
        this.songStartTimeMap = new HashMap();
        this.multiChorusSongWaitingData = new b();
        this.singleSingSongWaitingData = new b();
        this.wantListenData = new c();
        this.wantSingData = new d();
        this.orderSongUiStateObserver$delegate = LazyKt.lazy(new KtvComponentOrderSongViewModel$orderSongUiStateObserver$2(this));
        this.linkPlayerStateObserver$delegate = LazyKt.lazy(new KtvComponentOrderSongViewModel$linkPlayerStateObserver$2(this));
        this.applyTotalCountObserver = new g(this);
        this.multiChorusWaitUserListObserver = new k(this);
        this.singleSingWaitUserListObserver = new r(this);
        this.wantSingSongListObserver = new t(this);
        this.wantListenSongListObserver = new s(this);
    }

    public static final /* synthetic */ List access$trans2MusicPanel(KtvComponentOrderSongViewModel r0, List r1, String r2) {
        return r0.trans2MusicPanel(r1, r2);
    }

    public static final /* synthetic */ void access$updateWaitingUserList(KtvComponentOrderSongViewModel r0, String r1, b r2) {
        r0.updateWaitingUserList(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void applyWantListen(Context r17, final MusicPanel r18, final RecyclerView.ViewHolder r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "musicPanel");
        Intrinsics.checkNotNullParameter(r19, "viewHolder");
        c r0 = this.wantListenData;
        if (r0.a == false) goto L5;
        return;
    L5:
        r0.a = true;
        final long r7 = r18.a.getMId();
        int r1 = ke2.b.a;
        String r2 = KSongOrderSongUtilKt.d(r18);
        String r3 = r18.a.getMTitle();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        Intrinsics.checkNotNullParameter(r2, "fromRequestType");
        Intrinsics.checkNotNullParameter(r3, "songName");
        LinkedHashMap r4 = new LinkedHashMap();
        ke2.b.j(r4);
        KtvComponentContext r5 = KtvComponentContext.Companion.getContext();
        Disposable r9 = null;
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.n<Integer> r6 = r5.getOpenSource();
        if (r6 == null) goto L13;
        Integer r8 = (Integer) r6.getValue();
    L14:
        if (r8 != null) goto L17;
    L19:
        ke2.b.m(r4);
        ke2.b.l(r4);
        ke2.b.k(r4);
        ke2.b.p(r4);
        r4.put("function_type", jc1.k.n(IInteractService.class).getFunctionTypeForLog());
        r4.put("from_request_type", r2);
        r4.put("song_name", r3);
        ke2.d.a(r18, r4, false);
        r4.put("song_id", String.valueOf(r7));
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r4);
        j0.l().sendLog("livesdk_audience_ksong_want_listen_button_click", r4, new Object[0]);
        long r10 = System.currentTimeMillis();
        long r12 = com.bytedance.android.live.ktv.common.util.a.c().getId();
        int r11 = rd2.a.a;
        rd2.a r14 = rd2.a.b.a;
        Function1<com.bytedance.android.live.network.response.e<Object>, Unit> r15 = new AnonymousClass1(this, r7, r19, r18);
        Function1<Throwable, Unit> r13 = new AnonymousClass2(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "successCallBack");
        Intrinsics.checkNotNullParameter(r13, "failCallBack");
        KtvComponentApi r16 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r16 == null) goto L26;
        Observable<com.bytedance.android.live.network.response.e<Object>> r20 = r16.applyWantListenSong(r12, r7);
        if (r20 == null) goto L26;
        Observable r21 = r20.compose(RxUtil.rxSchedulerHelper());
        if (r21 == null) goto L26;
        r9 = r21.subscribe(new rd2.b(r10, r15), new rd2.c(r10, r13));
    L26:
        if (r9 == null) goto L29;
        RxUtilKt.c(r9, getCompositeDisposable());
        return;
    L29:
        return;
    L17:
        if (r8.intValue() != 3) goto L19;
        r4.put("ksong_element_source", "pk_chorus");
    L13:
        r8 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void observeSingUserChange(LifecycleOwner r3, boolean r4, Consumer<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "observer");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        l r1 = new l(r0, r5);
        KtvComponentOrderedSongDataContext r6 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r6 == null) goto L6;
        r6.observerKtvSingSongListChange(r3, r4, r1);
        return;
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d newInstance(Fragment r1, com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, com.bytedance.android.live.ktv.common.search.viewmodel.a r3, OrderedSongDataContext r4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "fragment");
        return ViewModelProviders.of(r1, new KtvComponentOrderSongViewModelFactory(r2, r3, r4)).get(KtvComponentOrderSongViewModel.class);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void addSong(Context r17, MusicPanel r18, RecyclerView.ViewHolder r19, com.bytedance.android.live.ktv.common.music.control.b r20) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "musicPanel");
        if (jc0.a.c() == false) goto L14;
        long r9 = r18.c();
        long r11 = System.currentTimeMillis();
        this.songStartTimeMap.put(Long.valueOf(r9), Long.valueOf(r11));
        KtvComponentApi r3 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r3 == null) goto L14;
        Observable<com.bytedance.android.live.network.response.e<Object>> r4 = r3.chorusPreAddSong(getRoom().getId(), r18.c());
        if (r4 == null) goto L14;
        Observable r13 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r13 == null) goto L14;
        Disposable r5 = r13.subscribe(new e(this, r9, r11), new f(this, r9, r11));
        if (r5 == null) goto L14;
        RxUtilKt.c(r5, getCompositeDisposable());
    L14:
        super.addSong(r17, r18, r19, r20);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d
    public void checkRTChorusPermissionInfoIfNeed(Throwable r10, int r11, final RTChorusOperateType r12, MusicPanel r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, LocationMonitorConst.TYPE);
        if (jc0.a.c() == true) goto L5;
    L55:
        ExceptionUtils.handleException(s1.getContext(), r10);
        return;
    L5:
        if (r11 != 4004521) goto L55;
        w r16 = null;
        boolean r0 = false;
        if (r13 != null) goto L26;
        KtvComponentOrderedSongDataContext r17 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r17 == null) goto L25;
        List<MusicPanel> r18 = r17.m200getKtvSingSongList();
        if (r18 == null) goto L25;
        Iterator<T> r19 = r18.iterator();
    L14:
        if (r19.hasNext() == false) goto L23;
        Object r2 = r19.next();
        MusicPanel r3 = (MusicPanel) r2;
        if (Intrinsics.areEqual(r3.a.getMIdStr(), r14) == true) goto L18;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == false) goto L14;
    L24:
        r13 = (MusicPanel) r2;
        goto L26
    L18:
        if (Intrinsics.areEqual(r3.g(), r15) == false) goto L20;
        r4 = true;
        goto L21
    L23:
        r2 = null;
    L25:
        r13 = null;
    L26:
        this.lastMusicPanel = r13;
        RTChorusOperateType r110 = RTChorusOperateType.ORDER_SONG;
        if (r12 != r110) goto L29;
        int r111 = this.ktvChorusPermissionData.a;
    L30:
        final int r5 = r111;
        if (r12 != r110) goto L33;
        ej r112 = this.ktvChorusPermissionData.c;
    L35:
        if (r5 != PermissionType.FansClub.getValue()) goto L37;
    L54:
        final String r8 = getPopupType(r5);
        final String r7 = getLimitType(r12);
        xe2.h.m(MapsKt.mapOf(new Pair[]{TuplesKt.to("limit_type", r7), TuplesKt.to("popup_type", r8)}));
        final ej r6 = r112;
        com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.k(r12, Integer.valueOf(r5), r112, new C02152(r7, r8, r12, r5), new AnonymousClass3(this, r5, r12, r6, r7, r8));
        return;
    L37:
        if (r5 == PermissionType.Subscribe.getValue()) goto L54;
        if (r5 == PermissionType.SendAssignGift.getValue()) goto L54;
        if (r5 == PermissionType.Fans.getValue()) goto L44;
        ExceptionUtils.handleException(s1.getContext(), r10);
        return;
    L44:
        if (r12 != RTChorusOperateType.JOIN_CHORUS) goto L46;
        r0 = true;
    L46:
        VideoChorusDataContext r113 = VideoChorusDataContext.Companion.getContext();
        if (r113 == null) goto L51;
        com.bytedance.live.datacontext.j<w> r114 = r113.getService();
        if (r114 == null) goto L51;
        r16 = (w) r114.getValue();
    L51:
        if (r16 == null) goto L62;
        r16.K2(r0, !r0, new h(this, r0));
        return;
    L62:
        return;
    L33:
        r112 = this.ktvChorusPermissionData.d;
        goto L35
    L29:
        r111 = this.ktvChorusPermissionData.b;
        goto L30
    }
}
