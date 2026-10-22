package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Surface;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0002:\u0001qB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\bo\u0010nJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0007H\u0014J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00072\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!j\u0002`$H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\u00072\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0016J\u000e\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u000200J\u0017\u00104\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b4\u00105J\u0012\u00108\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000106H\u0016R\u0018\u00109\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002000;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bB\u0010D\"\u0004\bE\u0010FR$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00120N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020A0N8\u0006¢\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bS\u0010RR\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00120N8\u0006¢\u0006\f\n\u0004\bT\u0010P\u001a\u0004\bU\u0010RR2\u0010V\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010?R\"\u0010f\u001a\u00020A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010C\u001a\u0004\bf\u0010D\"\u0004\bg\u0010FR\u0018\u0010h\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n¨\u0006r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "toState", "fromState", "", "handleStateChange", "", "mvInfoVId", "reportMvLoad", "onShowDefaultImg", "playDefaultMvByWrdsCheck", "Lcom/bytedance/android/livesdk/ktvimpl/mv/c;", "mvRunContext", "onUpdateRunContext", "Lkotlin/Function1;", "", "cb", "setThemeColorUpdateListener", "Landroid/view/Surface;", "surface", "setMvSurface", "Ljava/lang/Class;", "Lcom/bytedance/live/datacontext/DataContext;", "provideDataService", "onCleared", "videoTop", "mode", "onVideoRegionStartShow", "onVideoRegionStartHide", "onVideoRegionHide", "Lcom/bytedance/android/live/core/utils/StateMachine$c$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$a;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/ValidLyricsStateTransition;", "transition", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "onSeiResult", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicList", "onMusicListChange", "Lcom/bytedance/android/livesdkapi/depend/message/KtvStreamSingSyncData;", "syncData", "playPreviewMv", "", "roomId", "updateRoomId", "lastScene", "onReload", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "multiScenePreviewStatistics", "bindMultiScenePreviewStatistics", "wrdsData", "Lcom/bytedance/android/livesdkapi/depend/message/KtvStreamSingSyncData;", "", "durationMap", "Ljava/util/Map;", "seiVId", "Ljava/lang/String;", "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "", "isCleared", "Z", "()Z", "setCleared", "(Z)V", "Lcom/bytedance/android/livesdk/ktvimpl/mv/m;", "currentReportEvent", "Lcom/bytedance/android/livesdk/ktvimpl/mv/m;", "getCurrentReportEvent", "()Lcom/bytedance/android/livesdk/ktvimpl/mv/m;", "setCurrentReportEvent", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/m;)V", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "mvRegionShowState", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getMvRegionShowState", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "isShowDefaultMv", "mvThemeColor", "getMvThemeColor", "renderStartListener", "Lkotlin/jvm/functions/Function1;", "getRenderStartListener", "()Lkotlin/jvm/functions/Function1;", "setRenderStartListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvPlayer;", "player", "Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvPlayer;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvModel;", "mvModel", "Lcom/bytedance/android/livesdk/ktvimpl/mv/KtvMvModel;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/MvPlayController;", "mMvPlayController", "Lcom/bytedance/android/livesdk/ktvimpl/mv/MvPlayController;", "lastPreLoadVid", "isCameraVideoShow", "setCameraVideoShow", "curState", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/c;", "getMvRunContext", "()Lcom/bytedance/android/livesdk/ktvimpl/mv/c;", "setMvRunContext", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/c;)V", "<init>", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvViewModel extends AbsKWidgetViewModel implements com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b {
    public static final a Companion = null;
    public static final int DEFAULT_IMG_REGION = 0;
    public static final int MV_REGION = 2;
    private KtvRoomLyricsStateMachineConfig.d curState;
    private m currentReportEvent;
    private final Map<String, Long> durationMap;
    private boolean isCameraVideoShow;
    private boolean isCleared;
    private final NextLiveData<Boolean> isShowDefaultMv;
    private String lastPreLoadVid;
    private final MvPlayController mMvPlayController;
    private IMultiScenePreviewStatistics multiScenePreviewStatistics;
    private final KtvMvModel mvModel;
    private final NextLiveData<Integer> mvRegionShowState;
    private c mvRunContext;
    private final NextLiveData<Integer> mvThemeColor;
    private final KtvMvPlayer player;
    private Function1<? super String, Unit> renderStartListener;
    private String seiVId;
    private KtvStreamSingSyncData wrdsData;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final void reportMvLoad(String r1) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public void onVideoRegionHide() {
    }

    public void onVideoRegionStartHide() {
        this.isCameraVideoShow = false;
        boolean r0 = Intrinsics.areEqual(this.player.n(), this.mvModel.e);
        if ((!Intrinsics.areEqual(Boolean.valueOf(r0), (Boolean) this.isShowDefaultMv.getValue())) == false) goto L6;
        this.isShowDefaultMv.setValue(Boolean.valueOf(r0));
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public Class<? extends DataContext> provideDataService() {
        return null;
    }

    private final void onShowDefaultImg() {
        this.mvRegionShowState.postValue(0);
    }

    private final void playDefaultMvByWrdsCheck() {
        if (this.wrdsData != null) goto L6;
        this.mMvPlayController.d();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public void onCleared() {
        super.onCleared();
        this.mMvPlayController.c();
        MvPlayController r0 = this.mMvPlayController;
        r0.l.release();
        r0.b = 0;
        b r1 = r0.n;
        ValueAnimator r2 = r1.c;
        if (r2 == null) goto L5;
        r2.end();
    L5:
        ValueAnimator r3 = r1.d;
        if (r3 == null) goto L8;
        r3.end();
    L8:
        this.mvModel.e();
        this.isCleared = true;
    }

    public final m getCurrentReportEvent() {
        return this.currentReportEvent;
    }

    public final NextLiveData<Integer> getMvRegionShowState() {
        return this.mvRegionShowState;
    }

    public final c getMvRunContext() {
        return this.mvRunContext;
    }

    public final NextLiveData<Integer> getMvThemeColor() {
        return this.mvThemeColor;
    }

    public final Function1<String, Unit> getRenderStartListener() {
        return this.renderStartListener;
    }

    public final boolean isCameraVideoShow() {
        return this.isCameraVideoShow;
    }

    public final boolean isCleared() {
        return this.isCleared;
    }

    public final NextLiveData<Boolean> isShowDefaultMv() {
        return this.isShowDefaultMv;
    }

    public KtvMvViewModel(c r9) {
        Intrinsics.checkNotNullParameter(r9, "mvRunContext");
        this.mvRunContext = r9;
        this.durationMap = new LinkedHashMap();
        this.seiVId = BDLocationException.ERROR_TIMEOUT;
        this.mvRegionShowState = new NextLiveData();
        this.isShowDefaultMv = new NextLiveData();
        this.mvThemeColor = new NextLiveData();
        Context r10 = getGlobalContextRef().get();
        if (r10 != null) goto L5;
        r10 = jc1.a.b().getApplicationContext();
    L5:
        KtvMvPlayer r1 = new KtvMvPlayer(r10, null);
        this.player = r1;
        KtvMvModel r11 = new KtvMvModel(Long.valueOf(this.mvRunContext.getRoomId()), this.mvRunContext.getDataCenter());
        this.mvModel = r11;
        MvPlayController r7 = new MvPlayController(r1, r11, new b(this.mvRunContext.k()), 0, new KtvMvViewModel$mMvPlayController$1(this));
        this.mMvPlayController = r7;
        s r0 = new s(null, new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r0, "watcher");
        r11.d.add(r0);
        r7.d = new AnonymousClass2(this);
        r7.e = new AnonymousClass3(this);
        r7.h = new AnonymousClass4(this);
        r7.g = new AnonymousClass5(this);
    }

    public static final /* synthetic */ KtvRoomLyricsStateMachineConfig.d access$getCurState$p(KtvMvViewModel r0) {
        return r0.curState;
    }

    public static final /* synthetic */ String access$getLastPreLoadVid$p(KtvMvViewModel r0) {
        return r0.lastPreLoadVid;
    }

    public static final /* synthetic */ MvPlayController access$getMMvPlayController$p(KtvMvViewModel r0) {
        return r0.mMvPlayController;
    }

    public static final /* synthetic */ KtvMvModel access$getMvModel$p(KtvMvViewModel r0) {
        return r0.mvModel;
    }

    public static final /* synthetic */ KtvMvPlayer access$getPlayer$p(KtvMvViewModel r0) {
        return r0.player;
    }

    public static final /* synthetic */ void access$onShowDefaultImg(KtvMvViewModel r0) {
        r0.onShowDefaultImg();
    }

    public void bindMultiScenePreviewStatistics(IMultiScenePreviewStatistics r1) {
        this.multiScenePreviewStatistics = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void handleStateChange(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "transition");
        this.curState = (KtvRoomLyricsStateMachineConfig.d) r3.c;
        KtvRoomLyricsStateMachineConfig.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "transition");
        if (Intrinsics.areEqual(((KtvRoomLyricsStateMachineConfig.d) r3.a).getClass(), ((KtvRoomLyricsStateMachineConfig.d) r3.c).getClass()) == true) goto L6;
        handleStateChange((KtvRoomLyricsStateMachineConfig.d) r3.c, (KtvRoomLyricsStateMachineConfig.d) r3.a);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void notifyClear(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clearListener");
        Intrinsics.checkNotNullParameter(r2, "clearListener");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void onMusicListChange(List<MusicPanel> r2) {
        this.mvModel.onMusicListChange(r2);
        List<MusicPanel> r3 = this.mvRunContext.f();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() != true) goto L13;
        KtvRoomLyricsStateMachineConfig.d r4 = this.curState;
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L9;
    L10:
        playDefaultMvByWrdsCheck();
        return;
    L9:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.a) == true) goto L10;
        return;
    }

    public final void onReload(Integer r3) {
        if (r3 == null) goto L8;
        if (r3.intValue() != 2) goto L8;
        this.mMvPlayController.d();
    L12:
        MvPlayController r4 = this.mMvPlayController;
        lb0.b r0 = this.mvRunContext.k();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "d");
        b r5 = r4.n;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "newDrawable");
        int r1 = r5.a;
        if (r1 <= 0) goto L16;
        r0.c = Integer.valueOf(r1);
    L16:
        if (r5.a <= 0) goto L18;
        r0.d = Integer.valueOf(r5.b);
    L18:
        r5.g = r0;
        return;
    L8:
        if (this.mMvPlayController.a == false) goto L12;
        MvPlayController r6 = this.mMvPlayController;
        if (r6.a == false) goto L12;
        r6.l.r();
        r6.b = 1;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.mvModel.onSeiResult(r2);
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r2.b;
        if ((r3 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == true) goto L5;
        r3 = null;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r4 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r3;
        if (r4 == null) goto L9;
        this.seiVId = r4.D();
        return;
    }

    public final void onUpdateRunContext(final c r3) {
        Intrinsics.checkNotNullParameter(r3, "mvRunContext");
        this.mvRunContext = r3;
        r3.n(this);
        MvPlayController r0 = this.mMvPlayController;
        r0.k = new C02571(this);
        MvPlayController r1 = this.mMvPlayController;
        r1.f = new C02582(this);
        MvPlayController r2 = this.mMvPlayController;
        r2.i = new C02593(this, r3);
        this.mvModel.h(this.mvRunContext.getDataCenter());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b
    public void playPreviewMv(KtvStreamSingSyncData r15) {
        Intrinsics.checkNotNullParameter(r15, "syncData");
        this.wrdsData = r15;
        fd r1 = r15.videoInfo;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.d();
    L6:
        this.seiVId = r3;
        MvPlayController r4 = this.mMvPlayController;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r15, "syncData");
        fd r16 = r15.videoInfo;
        if (r16 == null) goto L11;
        String r5 = r16.d();
        if (r5 == null) goto L11;
        MvPlayController.e(r4, new l(new y(-1, null, "", null, null, 24), r5, r16.a(), r16.b(), r16.e()), false, null, 3);
    L11:
        StringBuilder r0 = new StringBuilder("playPreviewMv, vid: ");
        if (r16 == null) goto L14;
        r2 = r16.d();
    L14:
        r0.append(r2);
        com.bytedance.android.live.ktv.common.util.g.g(r0.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setCameraVideoShow(boolean r1) {
        this.isCameraVideoShow = r1;
    }

    public final void setCleared(boolean r1) {
        this.isCleared = r1;
    }

    public final void setCurrentReportEvent(m r1) {
        this.currentReportEvent = r1;
    }

    public final void setMvRunContext(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mvRunContext = r2;
    }

    public final void setMvSurface(Surface r3) {
        Intrinsics.checkNotNullParameter(r3, "surface");
        MvPlayController r1 = this.mMvPlayController;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "surface");
        r1.l.setSurface(r3);
    }

    public final void setRenderStartListener(Function1<? super String, Unit> r1) {
        this.renderStartListener = r1;
    }

    public final void setThemeColorUpdateListener(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.mMvPlayController.d = r2;
    }

    public final void updateRoomId(long r4) {
        KtvMvModel r0 = this.mvModel;
        r0.getClass();
        com.bytedance.android.live.ktv.common.util.g.d("updateRoomId:" + r4);
        r0.k = Long.valueOf(r4);
        boolean r5 = this.curState instanceof KtvRoomLyricsStateMachineConfig.d.b;
    }

    public static final /* synthetic */ void access$reportMvLoad(KtvMvViewModel r0, String r1) {
        r0.reportMvLoad(r1);
    }

    public static final /* synthetic */ void access$setCurState$p(KtvMvViewModel r0, KtvRoomLyricsStateMachineConfig.d r1) {
        r0.curState = r1;
    }

    public static final /* synthetic */ void access$setLastPreLoadVid$p(KtvMvViewModel r0, String r1) {
        r0.lastPreLoadVid = r1;
    }

    private final void handleStateChange(KtvRoomLyricsStateMachineConfig.d r9, KtvRoomLyricsStateMachineConfig.d r10) {
        Integer r2 = null;
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.c) == false) goto L37;
        KtvMusic r0 = ((KtvRoomLyricsStateMachineConfig.d.c) r9).b.a;
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.e) == true) goto L9;
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L9;
    L35:
        this.wrdsData = null;
    L9:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L14;
        MvPlayController r11 = this.mMvPlayController;
        if (r11.a == false) goto L14;
        r11.l.r();
        r11.b = 1;
    L14:
        if (this.mvRunContext.a() == false) goto L20;
        MvPlayController r12 = this.mMvPlayController;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "music");
        y r3 = new y(r0, r12.o);
        Intrinsics.checkNotNullParameter(r3, "songMvParam");
        if (r3.f != null) goto L18;
        r3.f = r12.o;
    L18:
        r12.m.c(r3, new MvPlayController$fetchAndPlay$1(r12));
        goto L35
    L20:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L22;
        final long r4 = ((KtvRoomLyricsStateMachineConfig.d.f) r9).d.a;
    L23:
        final MvPlayController r13 = this.mMvPlayController;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r6 = r9.c();
        if (r6 == null) goto L26;
        String r7 = r6.D();
    L27:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "music");
        final y r5 = new y(r0, null);
        KtvMvModel r1 = r13.m;
        final Function1<l, Unit> r8 = new MvPlayController$getPlayByNotify$1(r13, r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "songParam");
        Intrinsics.checkNotNullParameter(r8, "listener");
        com.bytedance.android.live.ktv.common.util.g.d("getMvInfoByVid songParam: " + r5);
        l r14 = r1.b(r5);
        if (r14 != null) goto L30;
    L34:
        s r15 = new s(r5, new KtvMvModel$getMvInfoByCache$2(r5, r8));
        Intrinsics.checkNotNullParameter(r15, "watcher");
        r1.d.add(r15);
        goto L35
    L30:
        if (Intrinsics.areEqual(r7, r14.d) == false) goto L32;
        r8.invoke(r14);
        goto L35
    L32:
        if (r7 != null) goto L34;
        r8.invoke(r14);
        goto L35
    L26:
        r7 = null;
        goto L27
    L22:
        r4 = 0;
    L37:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L40;
        this.mMvPlayController.c();
    L40:
        if ((r9 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L50;
        StringBuilder r16 = new StringBuilder("in idle state, size:");
        List<MusicPanel> r17 = this.mvRunContext.f();
        if (r17 == null) goto L44;
        r2 = Integer.valueOf(r17.size());
    L44:
        r16.append(r2);
        com.bytedance.android.live.ktv.common.util.g.d(r16.toString());
        List<MusicPanel> r18 = this.mvRunContext.f();
        if (r18 != null) goto L47;
    L48:
        playDefaultMvByWrdsCheck();
        return;
    L47:
        if ((!r18.isEmpty()) != true) goto L48;
        return;
    }

    public void onVideoRegionStartShow(int r1, int r2) {
        this.isCameraVideoShow = true;
        this.isShowDefaultMv.setValue(Boolean.FALSE);
    }
}
