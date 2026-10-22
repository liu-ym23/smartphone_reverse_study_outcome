package com.bytedance.android.livesdk.ktvimpl.multichorus;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.i0;
import com.bytedance.android.live.ktv.common.model.api.j0;
import com.bytedance.android.live.ktv.common.model.api.l0;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.api.MultiChorusApi;
import com.bytedance.android.livesdk.ktvimpl.multichorus.model.KtvMultiChorusSyncData;
import com.bytedance.android.livesdk.ktvimpl.multichorus.model.MultiChorusDataSyncModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002Hi\u0018\u0000 \u0095\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0096\u0001B\u001d\u0012\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001\u0012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J$\u0010$\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0\u0002J\u0006\u0010%\u001a\u00020\u0017J6\u0010,\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00112\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040'2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00040'J\u0006\u0010-\u001a\u00020\u0004J<\u0010/\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00112\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0.\u0012\u0004\u0012\u00020\u00040'2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00040'J\u0006\u00101\u001a\u000200J&\u00107\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0006042\b\b\u0002\u00106\u001a\u00020\nJ\u0018\u00108\u001a\u00020\u00042\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000104J\b\u00109\u001a\u00020\u0004H\u0014J\u001e\u0010<\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00152\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0\u0002J\u001c\u0010>\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020=0\u0002J\b\u0010?\u001a\u0004\u0018\u00010=J\b\u0010@\u001a\u0004\u0018\u00010;J\b\u0010B\u001a\u0004\u0018\u00010AJ\u0012\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\f8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00130O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR \u0010S\u001a\b\u0012\u0004\u0012\u00020\u00170R8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010j\u001a\u00020i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\"\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR \u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010sR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020A0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010sR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00170q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010sR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020=0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\"\u0010z\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR)\u0010\u0080\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010{R\u001d\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0006¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R*\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001¨\u0006\u0097\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "updateMultiChorusInfo", "", "isSelfSilence", "isSelfSilenceByOther", "isEngineOn", "", "singerId", "", "songId", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;", "multiChorusCommonContent", "isChorusInfoMatch", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "Lio/reactivex/disposables/Disposable;", "createLinkWaitingStateObserver", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "observer", "observerCurUserMultiChorusRole", "role", "updateRole", "updateSongInfo", "clearDataByClose", "size", "onSongListChanged", "clearDataByCloseTalkRoom", "", "Ljd2/e;", "obtainMultiChorusUserList", "observeMultiChorusUserList", "getCurrentUserChorusRole", "music", "Lkotlin/Function1;", "", "successCallback", "", "failCallback", "joinMultiChorus", "showStartMultiChorusToast", "Lcom/bytedance/android/live/network/response/e;", "leaveMultiChorus", "Lve2/a;", "getCurrentKtvStrategy", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lh80/a;", "consumer", "requestPage", "permit", "cancelApply", "onCleared", "owner", "Lcom/bytedance/android/live/ktv/common/model/api/i0;", "observeChorusInfo", "Lcom/bytedance/android/livesdk/ktvapi/util/e;", "observeMusicJoinStatus", "obtainMusicJoinStatus", "obtainChorusInfo", "Ljd2/d;", "obtainMultiChorusData", "t", "onChanged", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "com/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusViewModel$f", "handler", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusViewModel$f;", "linkPlayerWaitingObserverTime", "J", "getLinkPlayerWaitingObserverTime", "()J", "", "linkPlayerWaitingObserverList", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkPlayStateObserver", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "getLinkPlayStateObserver", "()Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "Lve2/d;", "singleAudienceStrategy", "Lve2/d;", "Lve2/e;", "singleBroadcastStrategy", "Lve2/e;", "Lve2/j;", "voiceTalkRoomStrategy", "Lve2/j;", "Lve2/i;", "videoTalkRoomStrategy", "Lve2/i;", "Lve2/b;", "pkStrategy", "Lve2/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "coreViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/c;", "com/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusViewModel$d", "coreListener", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/MultiChorusViewModel$d;", "lastMultiChorusContent", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;", "Lkotlin/Pair;", "lastSongInfo", "Lkotlin/Pair;", "Landroidx/lifecycle/MutableLiveData;", "chorusInfo", "Landroidx/lifecycle/MutableLiveData;", "multiChorusUserInfo", "multiChorusData", "curUserMultiChorusRole", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "musicJoinStatus", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "lastRole", "I", "getLastRole", "()I", "setLastRole", "(I)V", "applied", "Z", "getApplied", "()Z", "setApplied", "(Z)V", "lastSize", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "<init>", "(Landroid/content/Context;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "c", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiChorusViewModel extends ViewModel implements Observer<KVData> {
    public static final c Companion = null;
    public static final long DELAY_DURATION = 500;
    public static final int MSG_SONG_END_TOAST = 2;
    public static final int MSG_UPDATE_MULTI_CHORUS_INFO_LIST = 1;
    public static final String TAG = "MultiChorusViewModel";
    private boolean applied;
    private final MutableLiveData<i0> chorusInfo;
    private final CompositeDisposable compositeDisposable;
    private final Context context;
    private d coreListener;
    private com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c coreViewModel;
    private final MutableLiveData<Integer> curUserMultiChorusRole;
    private DataCenter dataCenter;
    private f handler;
    private com.bytedance.android.livesdk.ktvimpl.multichorus.model.e lastMultiChorusContent;
    private int lastRole;
    private int lastSize;
    private Pair<String, Long> lastSongInfo;
    private final com.bytedance.android.livesdk.app.dataholder.Observer<Integer> linkPlayStateObserver;
    private final List<Disposable> linkPlayerWaitingObserverList;
    private final long linkPlayerWaitingObserverTime;
    private final MutableLiveData<jd2.d> multiChorusData;
    private final MutableLiveData<List<jd2.e>> multiChorusUserInfo;
    private final NextLiveData<com.bytedance.android.livesdk.ktvapi.util.e> musicJoinStatus;
    private ve2.b pkStrategy;
    private ve2.d singleAudienceStrategy;
    private ve2.e singleBroadcastStrategy;
    private ve2.i videoTalkRoomStrategy;
    private ve2.j voiceTalkRoomStrategy;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiChorusViewModel a;

        public a(MultiChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.f r9 = ((KtvMultiChorusSyncData) r8).getMultiChorusUpdateMessage();
            if (r9 == null) goto L44;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "multiChorusUpdateMessage type : " + r9.e());
            int r0 = r9.e();
            boolean r4 = true;
            if (r0 != 1) goto L7;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.g r10 = r9.d();
            if (r10 == null) goto L52;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r11 = r10.a();
            if (r11 == null) goto L53;
            MultiChorusViewModel.access$setLastMultiChorusContent$p(this.a, r11);
            MultiChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            MultiChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 500);
            return;
        L53:
            return;
        L52:
            return;
        L7:
            if (r0 != 2) goto L9;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.c r12 = r9.b();
            if (r12 == null) goto L49;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r13 = r12.a();
            if (r13 == null) goto L50;
            MultiChorusViewModel.access$setLastMultiChorusContent$p(this.a, r13);
            MultiChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            MultiChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 500);
            return;
        L50:
            return;
        L49:
            return;
        L9:
            if (r0 != 3) goto L11;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.d r14 = r9.c();
            if (r14 == null) goto L46;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r15 = r14.a();
            if (r15 == null) goto L47;
            MultiChorusViewModel.access$setLastMultiChorusContent$p(this.a, r15);
            MultiChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            MultiChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 500);
            return;
        L47:
            return;
        L46:
            return;
        L11:
            if (r0 != 4) goto L54;
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.b r1 = r9.a();
            if (r1 == null) goto L23;
            MultiChorusViewModel.access$setLastMultiChorusContent$p(this.a, r1.a());
            MultiChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            MultiChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 500);
            String r2 = r1.c();
            if (r2 != null) goto L18;
        L21:
            if (r4 == true) goto L23;
            String r3 = r1.c();
            Intrinsics.checkNotNull(r3);
            f2.c(r3, 0);
            goto L23
        L18:
            if (r2.length() == 0) goto L21;
            r4 = false;
        L23:
            StringBuilder r5 = new StringBuilder("multiChorusUpdateMessage MultiChorusMsgType_START_SING reason : ");
            com.bytedance.android.livesdk.ktvimpl.multichorus.model.b r16 = r9.a();
            if (r16 == null) goto L26;
            Integer r17 = Integer.valueOf(r16.b());
        L27:
            r5.append(r17);
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, r5.toString());
            return;
        L26:
            r17 = null;
            goto L27
        L54:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiChorusViewModel a;

        public b(MultiChorusViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            MultiChorusViewModel.access$setCoreViewModel$p(this.a, (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) sh6.c.b((sh6.b) r4));
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r5 = MultiChorusViewModel.access$getCoreViewModel$p(this.a);
            if (r5 == null) goto L6;
            r5.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE}), MultiChorusViewModel.access$getCoreListener$p(this.a), false);
            return;
        }
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ MultiChorusViewModel a;

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final boolean c() {
            return MultiChorusContext.Companion.c();
        }

        public d(MultiChorusViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r12) {
            Intrinsics.checkNotNullParameter(r12, "transition");
            Object r0 = r12.c;
            KtvRoomLyricsStateMachineConfig.d r1 = (KtvRoomLyricsStateMachineConfig.d) r0;
            String r5 = "";
            long r6 = 0;
            if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L5;
        L13:
            MusicPanel r2 = ((KtvRoomLyricsStateMachineConfig.d) r0).b();
            if (r2 == null) goto L18;
            KtvMusic r3 = r2.a;
            if (r3 == null) goto L18;
            r6 = r3.getMId();
        L18:
            if (r2 == null) goto L24;
            String r4 = r2.g();
            if (r4 == null) goto L24;
            r5 = r4;
        L24:
            if ((!Intrinsics.areEqual((String) MultiChorusViewModel.access$getLastSongInfo$p(this.a).getFirst(), r5)) == false) goto L26;
        L29:
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, " onKtvStateChange " + ((KtvRoomLyricsStateMachineConfig.d) r12.c).a + " songId : " + r6 + " singerId : " + r5);
            MultiChorusViewModel.access$setLastSongInfo$p(this.a, new Pair(r5, Long.valueOf(r6)));
            MultiChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            MultiChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 500);
            return;
        L26:
            if (((Number) MultiChorusViewModel.access$getLastSongInfo$p(this.a).getSecond()).longValue() != r6) goto L29;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, " onKtvStateChange " + ((KtvRoomLyricsStateMachineConfig.d) r12.c).a + " but songInfo same ");
            return;
        L5:
            if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L13;
            if ((r1 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L13;
            if ((r12.a instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L12;
            return;
        L12:
            MultiChorusViewModel.access$setLastSongInfo$p(this.a, new Pair("", 0L));
            MultiChorusViewModel.access$getHandler$p(this.a).removeMessages(1);
            MultiChorusViewModel.access$getHandler$p(this.a).sendEmptyMessageDelayed(1, 500);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiChorusViewModel a;
        public final /* synthetic */ MusicPanel b;

        public e(MultiChorusViewModel r1, MusicPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            if (hd0.c.f().g() == false) goto L6;
            this.a.leaveMultiChorus(this.b, MultiChorusViewModel$createLinkWaitingStateObserver$1$1.INSTANCE, MultiChorusViewModel$createLinkWaitingStateObserver$1$2.INSTANCE);
            return;
        }
    }

    public static final class f extends Handler {
        public final /* synthetic */ MultiChorusViewModel a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super.handleMessage(r2);
            int r3 = r2.what;
            if (r3 != 1) goto L5;
            MultiChorusViewModel.access$updateMultiChorusInfo(this.a);
            return;
        L5:
            if (r3 != 2) goto L11;
            f2.b(2131918428, 0);
            return;
        }

        public f(MultiChorusViewModel r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ MultiChorusViewModel a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Function1 d;

        public g(MultiChorusViewModel r1, MusicPanel r2, Function1 r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "joinMultiChorus success LinkPlayerState.inst().data : " + ((Integer) ((ge1.a) hd0.c.f()).b) + " isAnchor : " + com.bytedance.android.live.ktv.common.util.j.i() + " isInWaitingList: " + ((com.bytedance.android.livesdk.ktvimpl.multichorus.api.b) ((ExtraResponse) r8).data).a());
            Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r0 == null) goto L8;
            if (r0.intValue() != 2) goto L8;
        L16:
            long r2 = this.b.a.getMId();
            if (Intrinsics.areEqual((String) MultiChorusViewModel.access$getLastSongInfo$p(this.a).getFirst(), this.b.g()) == true) goto L19;
        L20:
            f2.b(2131918425, 0);
        L21:
            this.a.setApplied(true);
            NextLiveData r1 = MultiChorusViewModel.access$getMusicJoinStatus$p(this.a);
            com.bytedance.android.livesdk.ktvapi.util.e r3 = new com.bytedance.android.livesdk.ktvapi.util.e();
            r3.a = this.b;
            r3.b = true;
            Unit r4 = Unit.INSTANCE;
            r1.setValue(r3);
            this.d.invoke(r8);
            if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L38;
            KtvContext.Companion.getClass();
            n<oe2.b> r9 = KtvContext.a.g().getKtvRoomProvider();
            if (r9 == null) goto L39;
            oe2.b r10 = (oe2.b) r9.getValue();
            if (r10 != null) goto L28;
            return;
        L28:
            if (r10.m() != true) goto L41;
            Integer r11 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r11 != null) goto L33;
            return;
        L33:
            if (r11.intValue() != 0) goto L42;
            Disposable r12 = MultiChorusViewModel.access$createLinkWaitingStateObserver(this.a, this.b);
            if (r12 == null) goto L43;
            MultiChorusViewModel.access$getLinkPlayerWaitingObserverList$p(this.a).add(r12);
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L39:
            return;
        L38:
            return;
        L19:
            if (r2 == ((Number) MultiChorusViewModel.access$getLastSongInfo$p(this.a).getSecond()).longValue()) goto L21;
        L8:
            if (((com.bytedance.android.livesdk.ktvimpl.multichorus.api.b) ((ExtraResponse) r8).data).a() == true) goto L16;
            f2.b(2131918424, 0);
            o r5 = m.i();
            if (r5 == null) goto L21;
            com.bytedance.live.datacontext.m r6 = r5.getRoom();
            if (r6 == null) goto L21;
            IRoom r13 = (IRoom) r6.getValue();
            if (r13 == null) goto L21;
            this.a.getCurrentKtvStrategy().b(this.a.getContext(), r13, new com.bytedance.android.livesdk.ktvimpl.multichorus.d(this));
            goto L21
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public h(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "joinMultiChorus failed " + r4.getMessage());
            ExceptionUtils.handleException(s1.getContext(), r4);
            this.a.invoke(r4);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MultiChorusViewModel a;
        public final /* synthetic */ MusicPanel b;
        public final /* synthetic */ Function1 c;

        public i(MultiChorusViewModel r1, MusicPanel r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "leaveMultiChorus success");
            NextLiveData r0 = MultiChorusViewModel.access$getMusicJoinStatus$p(this.a);
            com.bytedance.android.livesdk.ktvapi.util.e r1 = new com.bytedance.android.livesdk.ktvapi.util.e();
            r1.a = this.b;
            r1.b = false;
            Unit r3 = Unit.INSTANCE;
            r0.setValue(r1);
            f2.b(2131918427, 0);
            Function1 r2 = this.c;
            r2.invoke((com.bytedance.android.live.network.response.e) r5);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public j(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(MultiChorusViewModel.TAG, "leaveMultiChorus failed " + r4.getMessage());
            ExceptionUtils.handleException(s1.getContext(), r4);
            this.a.invoke(r4);
        }
    }

    public static final class k<T> implements com.bytedance.android.livesdk.app.dataholder.Observer {
        public final /* synthetic */ MultiChorusViewModel a;

        public k(MultiChorusViewModel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 != null) goto L6;
        L7:
            if (r4 != null) goto L10;
            return;
        L10:
            if (r4.intValue() != 2) goto L15;
        L11:
            Iterator<T> r5 = MultiChorusViewModel.access$getLinkPlayerWaitingObserverList$p(this.a).iterator();
        L13:
            if (r5.hasNext() == false) goto L18;
            ((Disposable) r5.next()).dispose();
            goto L13
        L18:
            return;
        L15:
            return;
        L6:
            if (r4.intValue() == 1) goto L11;
            goto L7
        }
    }

    static {
        Companion = new c();
    }

    public final void clearDataByCloseTalkRoom() {
        this.lastMultiChorusContent = null;
        this.chorusInfo.setValue(null);
        this.multiChorusData.setValue(new jd2.d(null));
        this.multiChorusUserInfo.setValue(new ArrayList());
        this.musicJoinStatus.setValue(null);
    }

    private final boolean isEngineOn() {
        if (jc1.k.n(IInteractService.class).isAudienceLinkEngineOn() == false) goto L5;
    L8:
        return true;
    L5:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L8;
        return false;
    }

    private final boolean isSelfSilence() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        ILinkPlayerInfoBridge r1 = null;
        Object r2 = null;
        r1 = null;
        r1 = null;
        if (r0 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.base.i r3 = r0.getLinkUserInfoCenter();
        if (r3 == null) goto L25;
        List r4 = r3.getOnlineUserList();
        if (r4 == null) goto L25;
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L24;
        Object r6 = r5.next();
        IBaseUser r7 = ((ILinkPlayerInfoBridge) r6).getUser();
        if (r7 == null) goto L14;
        String r8 = r7.getIdString();
    L15:
        IMiddlewareUserService r9 = jc1.k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L20;
        com.bytedance.android.livesdk.user.e r10 = r9.user();
        if (r10 == null) goto L20;
        String r11 = r10.n();
    L22:
        if (Intrinsics.areEqual(r8, r11) == false) goto L10;
        r2 = r6;
    L20:
        r11 = null;
        goto L22
    L14:
        r8 = null;
    L24:
        r1 = (ILinkPlayerInfoBridge) r2;
    L25:
        if (r1 != null) goto L27;
    L30:
        return true;
    L27:
        if (r1.getSilenceStatus() != 0) goto L30;
        return false;
    }

    private final boolean isSelfSilenceByOther() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        ILinkPlayerInfoBridge r1 = null;
        Object r2 = null;
        r1 = null;
        r1 = null;
        if (r0 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.base.i r3 = r0.getLinkUserInfoCenter();
        if (r3 == null) goto L25;
        List r4 = r3.getOnlineUserList();
        if (r4 == null) goto L25;
        Iterator r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L24;
        Object r6 = r5.next();
        IBaseUser r7 = ((ILinkPlayerInfoBridge) r6).getUser();
        if (r7 == null) goto L14;
        String r8 = r7.getIdString();
    L15:
        IMiddlewareUserService r9 = jc1.k.f(IMiddlewareUserService.class);
        if (r9 == null) goto L20;
        com.bytedance.android.livesdk.user.e r10 = r9.user();
        if (r10 == null) goto L20;
        String r11 = r10.n();
    L22:
        if (Intrinsics.areEqual(r8, r11) == false) goto L10;
        r2 = r6;
    L20:
        r11 = null;
        goto L22
    L14:
        r8 = null;
    L24:
        r1 = (ILinkPlayerInfoBridge) r2;
    L25:
        if (r1 != null) goto L27;
    L29:
        return false;
    L27:
        if (r1.getSilenceStatus() != 2) goto L29;
        return true;
    }

    private final void updateMultiChorusInfo() {
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "updateMultiChorusInfo");
        if (MultiChorusContext.Companion.c() == true) goto L7;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "updateMultiChorusInfo but not in multi chorus");
        return;
    L7:
        if (this.lastMultiChorusContent != null) goto L10;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "updateMultiChorusInfo lastMultiChorusContent is null");
        return;
    L10:
        String r1 = (String) this.lastSongInfo.getFirst();
        long r2 = ((Number) this.lastSongInfo.getSecond()).longValue();
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r4 = this.lastMultiChorusContent;
        Intrinsics.checkNotNull(r4);
        boolean r3 = isChorusInfoMatch(r1, r2, r4);
        ArrayList r5 = null;
        if (r3 == false) goto L41;
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r6 = this.lastMultiChorusContent;
        if (r6 == null) goto L64;
        i0 r7 = r6.a();
        if (r7 == null) goto L65;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "updateMultiChorusInfo LeadUserId : " + r7.c() + " ChorusSinger list : " + String.valueOf(r7.b()));
        this.chorusInfo.setValue(r7);
        MutableLiveData<jd2.d> r0 = this.multiChorusData;
        jd2.d r8 = new jd2.d(null);
        List r9 = r7.b();
        if (r9 == null) goto L22;
        Iterator r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        r8.a.add((String) r10.next());
    L22:
        String r11 = r7.c();
        Intrinsics.checkNotNullParameter(r11, "value");
        r8.b = Long.valueOf(d5.c(r11));
        r8.e = r11;
        r8.d = r7.a();
        r8.c = Long.valueOf(r7.d());
        Unit r12 = Unit.INSTANCE;
        r0.setValue(r8);
        MutableLiveData<List<jd2.e>> r13 = this.multiChorusUserInfo;
        List r14 = r7.b();
        if (r14 == null) goto L35;
        List r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L26:
        if (r17.hasNext() == false) goto L34;
        String r18 = (String) r17.next();
        Map r19 = r7.e();
        if (r19 == null) goto L32;
        l0 r20 = (l0) r19.get(r18);
        if (r20 == null) goto L32;
        py.k r21 = r20.a();
    L33:
        r16.add(new jd2.e(r18, r21));
    L32:
        r21 = null;
        goto L33
    L34:
        r5 = r16;
    L35:
        r13.setValue(r5);
        int r22 = getCurrentUserChorusRole();
        Integer r23 = (Integer) this.curUserMultiChorusRole.getValue();
        if (r23 != null) goto L39;
    L40:
        this.curUserMultiChorusRole.setValue(Integer.valueOf(r22));
        return;
    L39:
        if (r22 != r23.intValue()) goto L40;
        return;
    L65:
        return;
    L64:
        return;
    L41:
        StringBuilder r24 = new StringBuilder("clear multi chorus info ;; songId ==  ");
        r24.append(((Number) this.lastSongInfo.getSecond()).longValue());
        r24.append(" ;;  multi_chorus_songId == ");
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r25 = this.lastMultiChorusContent;
        if (r25 == null) goto L46;
        i0 r26 = r25.a();
        if (r26 == null) goto L46;
        Long r27 = Long.valueOf(r26.d());
    L47:
        r24.append(r27);
        r24.append(" ;;  singerId ==  ");
        r24.append((String) this.lastSongInfo.getFirst());
        r24.append(" ;; multi_chorus_leadUserId == ");
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r28 = this.lastMultiChorusContent;
        if (r28 == null) goto L52;
        i0 r29 = r28.a();
        if (r29 == null) goto L52;
        String r30 = r29.c();
    L53:
        r24.append(r30);
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, r24.toString());
        this.chorusInfo.setValue(null);
        this.multiChorusData.setValue(new jd2.d(null));
        this.multiChorusUserInfo.setValue(new ArrayList());
        int r31 = getCurrentUserChorusRole();
        Integer r32 = (Integer) this.curUserMultiChorusRole.getValue();
        if (r32 != null) goto L57;
    L58:
        this.curUserMultiChorusRole.setValue(Integer.valueOf(r31));
        return;
    L57:
        if (r31 != r32.intValue()) goto L58;
        return;
    L52:
        r30 = null;
    L46:
        r27 = null;
        goto L47
    }

    public final void clearDataByClose() {
        this.lastSongInfo = new Pair("", 0L);
        clearDataByCloseTalkRoom();
    }

    public final ve2.a getCurrentKtvStrategy() {
        int r0 = jc1.k.n(IInteractService.class).getCurrentScene();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "getCurrentKtvStrategy, currentScene=" + r0 + ' ');
        if (r0 == 4) goto L30;
        if (r0 == 5) goto L36;
        if (r0 == 8) goto L35;
        if (r0 == 12) goto L35;
        if (r0 == 16) goto L16;
        ArrayList<Integer> r1 = ke2.a.a;
        if (ke2.a.d(this.dataCenter) == false) goto L32;
        return this.pkStrategy;
    L32:
        return this.singleBroadcastStrategy;
    L16:
        o r2 = m.i();
        if (r2 == null) goto L23;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L23;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L23;
        boolean r5 = r4.isLiveTypeAudio();
    L24:
        if (r5 == false) goto L34;
        return this.voiceTalkRoomStrategy;
    L34:
        return this.videoTalkRoomStrategy;
    L23:
        r5 = false;
    L35:
        return this.videoTalkRoomStrategy;
    L36:
        return this.voiceTalkRoomStrategy;
    L30:
        return this.singleAudienceStrategy;
    }

    public final int getCurrentUserChorusRole() {
        boolean r1 = false;
        if (this.lastMultiChorusContent != null) goto L6;
        return 0;
    L6:
        if (isEngineOn() == true) goto L9;
        return 5;
    L9:
        String r0 = (String) this.lastSongInfo.getFirst();
        long r2 = ((Number) this.lastSongInfo.getSecond()).longValue();
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r4 = this.lastMultiChorusContent;
        Intrinsics.checkNotNull(r4);
        if (isChorusInfoMatch(r0, r2, r4) == true) goto L12;
        return 4;
    L12:
        Lazy r3 = KtvSettingHelper.a;
        List r5 = null;
        if (((Boolean) KtvSettingHelper.v1.getValue()).booleanValue() == true) goto L27;
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r6 = this.lastMultiChorusContent;
        Intrinsics.checkNotNull(r6);
        i0 r7 = r6.a();
        if (r7 == null) goto L17;
        List r8 = j0.a(r7);
    L18:
        List r9 = r8;
        if (r9 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == false) goto L27;
        return 4;
    L21:
        if (r9.isEmpty() == true) goto L24;
        r10 = false;
        goto L25
    L17:
        r8 = null;
    L27:
        String r11 = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r12 = this.lastMultiChorusContent;
        Intrinsics.checkNotNull(r12);
        i0 r13 = r12.a();
        if (r13 == null) goto L30;
        String r14 = r13.c();
    L32:
        if (Intrinsics.areEqual(r11, r14) == false) goto L34;
        return 1;
    L34:
        if (r13 == null) goto L41;
        List r15 = r13.b();
        if (r15 == null) goto L41;
        if (r15.contains(r11) != true) goto L41;
        return 2;
    L41:
        com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r16 = this.lastMultiChorusContent;
        Intrinsics.checkNotNull(r16);
        i0 r17 = r16.a();
        if (r17 == null) goto L44;
        r5 = j0.a(r17);
    L44:
        List r18 = r5;
        if (r18 != null) goto L47;
    L48:
        r1 = true;
    L49:
        if (r1 == true) goto L52;
        return 3;
    L52:
        return 4;
    L47:
        if (r18.isEmpty() == false) goto L49;
    L30:
        r14 = null;
        goto L32
    }

    public final i0 obtainChorusInfo() {
        return (i0) this.chorusInfo.getValue();
    }

    public final jd2.d obtainMultiChorusData() {
        return (jd2.d) this.multiChorusData.getValue();
    }

    public final List<jd2.e> obtainMultiChorusUserList() {
        return (List) this.multiChorusUserInfo.getValue();
    }

    public final com.bytedance.android.livesdk.ktvapi.util.e obtainMusicJoinStatus() {
        return (com.bytedance.android.livesdk.ktvapi.util.e) this.musicJoinStatus.getValue();
    }

    public final void showStartMultiChorusToast() {
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "showStartMultiChorusToastIfNeed ;; uniqueInfo == " + ((String) this.lastSongInfo.getFirst()) + '_' + ((Number) this.lastSongInfo.getSecond()).longValue() + " ;; curUserMultiChorusRole ==  " + ((Integer) this.curUserMultiChorusRole.getValue()));
        if (isSelfSilence() == true) goto L5;
        f2.b(2131918417, 0);
        return;
    L5:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L8;
        f2.b(2131918419, 0);
        return;
    L8:
        if (isSelfSilenceByOther() == true) goto L13;
        f2.b(2131918418, 0);
        return;
    }

    public final void updateSongInfo() {
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.coreViewModel;
        if (r0 == null) goto L7;
        KtvRoomLyricsStateMachineConfig.d r1 = r0.getCurState();
        if (r1 == null) goto L7;
        MusicPanel r2 = r1.b();
    L8:
        if (r2 == null) goto L12;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L12;
        long r4 = r3.getMId();
    L13:
        if (r2 == null) goto L16;
        String r5 = r2.g();
        if (r5 == null) goto L16;
    L17:
        this.lastSongInfo = new Pair(r5, Long.valueOf(r4));
        return;
    L16:
        r5 = "";
    L12:
        r4 = 0;
    L7:
        r2 = null;
        goto L8
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
        this.handler.removeMessages(1);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = this.coreViewModel;
        if (r0 == null) goto L5;
        r0.unregisterKtvCoreListener(this.coreListener);
    L5:
        this.dataCenter.removeObserver(this);
        hd0.c.f().e(this.linkPlayStateObserver);
        this.linkPlayerWaitingObserverList.clear();
    }

    public final boolean getApplied() {
        return this.applied;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final int getLastRole() {
        return this.lastRole;
    }

    public final com.bytedance.android.livesdk.app.dataholder.Observer<Integer> getLinkPlayStateObserver() {
        return this.linkPlayStateObserver;
    }

    public final long getLinkPlayerWaitingObserverTime() {
        return this.linkPlayerWaitingObserverTime;
    }

    public static final /* synthetic */ d access$getCoreListener$p(MultiChorusViewModel r0) {
        return r0.coreListener;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c access$getCoreViewModel$p(MultiChorusViewModel r0) {
        return r0.coreViewModel;
    }

    public static final /* synthetic */ f access$getHandler$p(MultiChorusViewModel r0) {
        return r0.handler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.ktvimpl.multichorus.model.e access$getLastMultiChorusContent$p(MultiChorusViewModel r0) {
        return r0.lastMultiChorusContent;
    }

    public static final /* synthetic */ Pair access$getLastSongInfo$p(MultiChorusViewModel r0) {
        return r0.lastSongInfo;
    }

    public static final /* synthetic */ List access$getLinkPlayerWaitingObserverList$p(MultiChorusViewModel r0) {
        return r0.linkPlayerWaitingObserverList;
    }

    public static final /* synthetic */ NextLiveData access$getMusicJoinStatus$p(MultiChorusViewModel r0) {
        return r0.musicJoinStatus;
    }

    public static final /* synthetic */ void access$updateMultiChorusInfo(MultiChorusViewModel r0) {
        r0.updateMultiChorusInfo();
    }

    private final Disposable createLinkWaitingStateObserver(MusicPanel r4) {
        Disposable r5 = Observable.timer(this.linkPlayerWaitingObserverTime, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r4));
        RxUtilKt.c(r5, this.compositeDisposable);
        return r5;
    }

    public final void cancelApply(h80.a<Boolean> r2) {
        getCurrentKtvStrategy().cancelApply(r2);
    }

    public void onChanged(KVData r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getKey();
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.hashCode() == (-1093702240)) goto L11;
        return;
    L11:
        if (r5.equals("data_online_changed_list") == false) goto L14;
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "DATA_ONLINE_CHANGED_LIST");
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 500);
        return;
    L14:
        return;
    L4:
        r5 = null;
        goto L5
    }

    public final void onSongListChanged(int r5) {
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "onSongListChanged");
        if (MultiChorusContext.Companion.c() == true) goto L5;
    L14:
        this.lastSize = r5;
        if (r5 > 0) goto L18;
        this.lastSongInfo = new Pair("", 0L);
        clearDataByCloseTalkRoom();
        return;
    L18:
        return;
    L5:
        if (isEngineOn() == false) goto L14;
        Integer r0 = (Integer) this.curUserMultiChorusRole.getValue();
        if (r0 == null) goto L14;
        if (r0.intValue() != 2) goto L14;
        if (this.lastSize <= r5) goto L14;
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageDelayed(2, 500);
        goto L14
    }

    public final void setApplied(boolean r1) {
        this.applied = r1;
    }

    public final void setDataCenter(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dataCenter = r2;
    }

    public final void setLastRole(int r1) {
        this.lastRole = r1;
    }

    public final void updateRole(int r2) {
        this.curUserMultiChorusRole.setValue(Integer.valueOf(r2));
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }

    public MultiChorusViewModel(Context r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.context = r4;
        this.dataCenter = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.compositeDisposable = r6;
        this.handler = new f(this, Looper.getMainLooper());
        MultiChorusDataSyncModel r2 = null;
        this.linkPlayerWaitingObserverTime = ((Number) vm2.h.H0.getValue(null, vm2.h.a[84])).longValue();
        this.linkPlayerWaitingObserverList = new ArrayList();
        this.linkPlayStateObserver = new k(this);
        this.singleAudienceStrategy = new ve2.d();
        this.singleBroadcastStrategy = new ve2.e(r4, this.dataCenter);
        this.voiceTalkRoomStrategy = new ve2.j();
        this.videoTalkRoomStrategy = new ve2.i();
        this.pkStrategy = new ve2.b();
        this.coreListener = new d(this);
        this.lastSongInfo = new Pair("", 0L);
        this.chorusInfo = new MutableLiveData();
        this.multiChorusUserInfo = new MutableLiveData(new ArrayList());
        this.multiChorusData = new MutableLiveData(new jd2.d(null));
        this.curUserMultiChorusRole = new MutableLiveData(0);
        this.musicJoinStatus = new NextLiveData();
        if (m.i() == null) goto L17;
        com.bytedance.live.datacontext.j r7 = m.i().w1();
        if (r7 == null) goto L9;
        ylc.e r8 = (ylc.e) r7.getValue();
        if (r8 == null) goto L9;
        r2 = (MultiChorusDataSyncModel) dc2.b.a(r8, MultiChorusViewModel$1$multiChorusDataSyncModel$1.INSTANCE);
    L9:
        if (r2 == null) goto L17;
        dc2.c<KtvMultiChorusSyncData> r9 = r2.getKtvMultiChorusSyncData();
        if (r9 == null) goto L17;
        Observable r10 = r9.d;
        if (r10 == null) goto L17;
        Disposable r11 = r10.subscribe(new a(this));
        if (r11 == null) goto L17;
        RxUtilKt.c(r11, r6);
    L17:
        KtvContext.Companion.getClass();
        this.coreViewModel = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        RxUtilKt.c(KtvContext.a.g().getKtvCoreViewModel().a().subscribe(new b(this)), r6);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r12 = this.coreViewModel;
        if (r12 == null) goto L20;
        r12.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE}), this.coreListener, false);
    L20:
        this.dataCenter.observe("data_online_changed_list", this);
        hd0.c.f().c(this.linkPlayStateObserver);
    }

    public static final /* synthetic */ Disposable access$createLinkWaitingStateObserver(MultiChorusViewModel r0, MusicPanel r1) {
        return r0.createLinkWaitingStateObserver(r1);
    }

    public static final /* synthetic */ void access$setCoreListener$p(MultiChorusViewModel r0, d r1) {
        r0.coreListener = r1;
    }

    public static final /* synthetic */ void access$setCoreViewModel$p(MultiChorusViewModel r0, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1) {
        r0.coreViewModel = r1;
    }

    public static final /* synthetic */ void access$setHandler$p(MultiChorusViewModel r0, f r1) {
        r0.handler = r1;
    }

    public static final /* synthetic */ void access$setLastMultiChorusContent$p(MultiChorusViewModel r0, com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r1) {
        r0.lastMultiChorusContent = r1;
    }

    public static final /* synthetic */ void access$setLastSongInfo$p(MultiChorusViewModel r0, Pair r1) {
        r0.lastSongInfo = r1;
    }

    public final void observeChorusInfo(LifecycleOwner r2, Observer<i0> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.chorusInfo.observe(r2, r3);
    }

    public final void observeMultiChorusUserList(LifecycleOwner r2, Observer<List<jd2.e>> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.multiChorusUserInfo.observe(r2, r3);
    }

    public final void observeMusicJoinStatus(LifecycleOwner r2, Observer<com.bytedance.android.livesdk.ktvapi.util.e> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.musicJoinStatus.observe(r2, r3);
    }

    public final void observerCurUserMultiChorusRole(LifecycleOwner r2, Observer<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.curUserMultiChorusRole.observe(r2, r3);
    }

    private final boolean isChorusInfoMatch(String r4, long r5, com.bytedance.android.livesdk.ktvimpl.multichorus.model.e r7) {
        i0 r0 = r7.a();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.d() != r5) goto L13;
        i0 r6 = r7.a();
        if (r6 == null) goto L9;
        String r8 = r6.c();
    L11:
        if (Intrinsics.areEqual(r8, r4) == false) goto L13;
        return true;
    L9:
        r8 = null;
        goto L11
    }

    public final void joinMultiChorus(MusicPanel r11, Function1<Object, Unit> r12, Function1<? super Throwable, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "music");
        Intrinsics.checkNotNullParameter(r12, "successCallback");
        Intrinsics.checkNotNullParameter(r13, "failCallback");
        o r0 = m.i();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L14;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L15;
        long r3 = r2.getRoomId();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "joinMultiChorus -----------");
        MultiChorusApi r4 = (MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class);
        long r5 = r11.a.getMId();
        long r6 = d5.c(r11.g());
        String r7 = r11.g();
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        RxUtilKt.c(r4.joinMultiChorus(r3, r5, r6, r7, r11.a.getMusicType()).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r11, r13, r12), new h(r13)), this.compositeDisposable);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void leaveMultiChorus(MusicPanel r11, Function1<? super com.bytedance.android.live.network.response.e<Object>, Unit> r12, Function1<? super Throwable, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "music");
        Intrinsics.checkNotNullParameter(r12, "successCallback");
        Intrinsics.checkNotNullParameter(r13, "failCallback");
        o r0 = m.i();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L14;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L15;
        long r3 = r2.getRoomId();
        com.bytedance.android.livesdk.ktvimpl.multichorus.a.a(TAG, "leaveMultiChorus -----------");
        MultiChorusApi r4 = (MultiChorusApi) com.bytedance.android.live.network.c.b().e(MultiChorusApi.class);
        long r5 = r11.a.getMId();
        long r6 = d5.c(r11.g());
        String r7 = r11.g();
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        RxUtilKt.c(r4.leaveMultiChorus(r3, r5, r6, r7, r11.a.getSongType()).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, r11, r12), new j(r13)), this.compositeDisposable);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void permit(IBaseUser r2, h80.a<Boolean> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        getCurrentKtvStrategy().i5(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void cancelApply$default(MultiChorusViewModel r0, h80.a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.cancelApply(r1);
    }

    public static /* synthetic */ void permit$default(MultiChorusViewModel r0, IBaseUser r1, h80.a r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "user_chorus_accept_button";
    L5:
        r0.permit(r1, r2, r3);
    }
}
