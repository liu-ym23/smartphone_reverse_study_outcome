package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.view.ContinuousSurfaceAdapterView;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.mv.KtvMvPlayer;
import com.bytedance.android.livesdk.ktvimpl.mv.SmoothEnterSurfaceView;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusMvManager;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusPreviewDialog;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusServiceImpl;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.model.KtvOpusDataSyncModel;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.dd;
import com.bytedance.android.livesdk.message.model.fd;
import com.bytedance.android.livesdk.message.model.gd;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001pB\u0017\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bn\u0010oJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u001aH\u0014J\u001c\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0018\u001a\u00060\u001cj\u0002`\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0014J\b\u0010 \u001a\u00020\u0004H\u0016J\u0018\u0010$\u001a\u00020\u00042\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0014J\b\u0010%\u001a\u00020\u0004H\u0014J\b\u0010&\u001a\u00020\u0004H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0006\u0010)\u001a\u00020\u0004J\b\u0010*\u001a\u00020\u0004H\u0014J\u0012\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0016\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200J\u001a\u00106\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\tH\u0004J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0016J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016R$\u0010@\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER(\u0010J\u001a\b\u0012\u0004\u0012\u0002030I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bJ\u0010L\"\u0004\bM\u0010NR\u0016\u0010O\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR&\u0010T\u001a\u0012\u0012\u0004\u0012\u00020R0Qj\b\u0012\u0004\u0012\u00020R`S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010d\u001a\u0004\u0018\u00010:8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i¨\u0006q"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomInteractViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/c;", "", "", "initKtvVideoData", "Lcom/bytedance/android/livesdkapi/depend/message/KtvStreamSingSyncData;", "data", "playWrdsMvInfo", "", "vid", "", "songId", "singerId", "recordVid", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "observeCoreViewModel", "syncKey", "value", "consumeWrdsData", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d;", "from", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$d;", "to", "onPause", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$f;", "onSinging", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomLyricsStateMachineConfig$d$e;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/PrepareState;", "onEnterPrepareState", "onCleared", "onBizLeaveRoom", "", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "list", "onMusicListChange", "onIdle", "onBizShow", "onBizEnterRoom", "onBizHide", "onResume", "initImMessage", "Ltlc/d;", "message", "onMessage", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "container", "initOpusManager", "", "it", "source", "initMidiViewAndSendMidiStatusSei", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "onSeiResult", "", "videoTop", "mode", "onVideoRegionStartShow", "onVideoRegionStartHide", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "opusMvPlayService", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "getOpusMvPlayService", "()Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "setOpusMvPlayService", "(Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;)V", "opusMvPreviewService", "getOpusMvPreviewService", "setOpusMvPreviewService", "Landroidx/lifecycle/MutableLiveData;", "isMidiVisible", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "setMidiVisible", "(Landroidx/lifecycle/MutableLiveData;)V", "isVideoSing", "Z", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/viewmodel/KtvRoomInteractViewModel$b;", "Lkotlin/collections/ArrayList;", "oldStageVidStore", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", "opusMvManager", "Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", "getOpusMvManager", "()Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", "setOpusMvManager", "(Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;)V", "Lcom/bytedance/android/livesdk/message/model/od;", "wrdsMvInfo", "Lcom/bytedance/android/livesdk/message/model/od;", "getWrdsMvInfo", "()Lcom/bytedance/android/livesdk/message/model/od;", "setWrdsMvInfo", "(Lcom/bytedance/android/livesdk/message/model/od;)V", "mCurrentGuestMidiStatus", "Ljava/lang/Integer;", "getMCurrentGuestMidiStatus", "()Ljava/lang/Integer;", "setMCurrentGuestMidiStatus", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "Lsb0/b;", "dataEntity", "<init>", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;Lsb0/b;)V", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomInteractViewModel extends KtvRoomViewModel implements com.bytedance.android.livesdk.ktvimpl.base.sei.c {
    private MutableLiveData<Boolean> isMidiVisible;
    private boolean isVideoSing;
    private Integer mCurrentGuestMidiStatus;
    private ArrayList<b> oldStageVidStore;
    public OpusMvManager opusMvManager;
    private com.bytedance.android.livesdk.ktvapi.model.mv.g opusMvPlayService;
    private com.bytedance.android.livesdk.ktvapi.model.mv.g opusMvPreviewService;
    private od wrdsMvInfo;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvRoomInteractViewModel a;

        public a(KtvRoomInteractViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.initMidiViewAndSendMidiStatusSei(((Boolean) r3).booleanValue(), "onValueChanged");
        }
    }

    public static final class b {
        public String a;
        public final String b;
        public final long c;

        public b(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "vid");
            Intrinsics.checkNotNullParameter(r3, "singerId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ KtvRoomInteractViewModel a;

        public c(KtvRoomInteractViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            KtvRoomInteractViewModel r0 = this.a;
            r0.consumeWrdsData("KtvStreamSingSyncData", (KtvStreamSingSyncData) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ KtvRoomInteractViewModel a;

        public d(KtvRoomInteractViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a r8 = (com.bytedance.android.livesdk.ktvimpl.mv.opus.model.a) r7;
            com.bytedance.android.livesdk.ktvapi.model.mv.g r0 = this.a.getOpusMvPreviewService();
            if (r0 != null) goto L6;
            return;
        L6:
            if (KtvRoomInteractViewModel.access$isVideoSing$p(this.a) == true) goto L8;
        L10:
            final OpusPreviewDialog r1 = new OpusPreviewDialog(r0, new com.bytedance.android.livesdk.ktvapi.model.mv.k(r8.b, r8.c));
            r1.u = new KtvRoomInteractViewModel$onBizEnterRoom$2$$special$$inlined$apply$lambda$1(this);
            r1.U90(com.bytedance.android.live.core.utils.a.d());
            final MusicPanel r2 = r8.a;
            final String r9 = r8.e;
            if ((!TextUtils.isEmpty(r9)) == true) goto L14;
            r9 = null;
        L14:
            if (r9 == null) goto L18;
            KtvLoggerHelper.d.Q(r9, "select_mv", this.a.getDataEntity().getDataCenter(), r2);
            r1.i = new KtvRoomInteractViewModel$onBizEnterRoom$2$$special$$inlined$let$lambda$1(r9, this, r2, r1);
            r1.j = new KtvRoomInteractViewModel$onBizEnterRoom$2$$special$$inlined$let$lambda$2(r9, this, r2, r1);
            r1.k = new KtvRoomInteractViewModel$onBizEnterRoom$2$$special$$inlined$let$lambda$3(r9, this, r2, r1);
            return;
        L18:
            return;
        L8:
            if (this.a.getKtvContext().isCurrentUserIsSinger() == false) goto L10;
            f2.c("请关闭摄像头后再试", 0);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvRoomInteractViewModel a;

        public e(KtvRoomInteractViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<Boolean> r0 = this.a.isMidiVisible();
            r0.setValue((Boolean) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel$onBizEnterRoom$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(KtvRoomInteractViewModel r7) {
            super(r7, KtvRoomInteractViewModel.class, "opusMvManager", "getOpusMvManager()Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", 0);
        }

        public Object get() {
            return ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).getOpusMvManager();
        }

        public void set(Object r2) {
            ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).setOpusMvManager((OpusMvManager) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel$onBizHide$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02411 extends MutablePropertyReference0Impl {
        public C02411(KtvRoomInteractViewModel r7) {
            super(r7, KtvRoomInteractViewModel.class, "opusMvManager", "getOpusMvManager()Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", 0);
        }

        public Object get() {
            return ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).getOpusMvManager();
        }

        public void set(Object r2) {
            ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).setOpusMvManager((OpusMvManager) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel$onBizShow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02421 extends MutablePropertyReference0Impl {
        public C02421(KtvRoomInteractViewModel r7) {
            super(r7, KtvRoomInteractViewModel.class, "opusMvManager", "getOpusMvManager()Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", 0);
        }

        public Object get() {
            return ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).getOpusMvManager();
        }

        public void set(Object r2) {
            ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).setOpusMvManager((OpusMvManager) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class C02441 extends MutablePropertyReference0Impl {
        public C02441(KtvRoomInteractViewModel r7) {
            super(r7, KtvRoomInteractViewModel.class, "opusMvManager", "getOpusMvManager()Lcom/bytedance/android/livesdk/ktvimpl/mv/opus/OpusMvManager;", 0);
        }

        public Object get() {
            return ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).getOpusMvManager();
        }

        public void set(Object r2) {
            ((KtvRoomInteractViewModel) ((CallableReference) this).receiver).setOpusMvManager((OpusMvManager) r2);
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel, com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public void onVideoRegionHide() {
    }

    public void onVideoRegionStartHide() {
        this.isVideoSing = false;
        OpusMvManager r1 = this.opusMvManager;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L5:
        r1.b(false);
    }

    public final OpusMvManager getOpusMvManager() {
        OpusMvManager r0 = this.opusMvManager;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L5:
        return r0;
    }

    private final void initKtvVideoData() {
        com.bytedance.android.livesdk.chatroom.o r0 = o3.f();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.w1();
        if (r1 == null) goto L9;
        ylc.e r2 = (ylc.e) r1.getValue();
        if (r2 == null) goto L9;
        KtvOpusDataSyncModel r3 = (KtvOpusDataSyncModel) dc2.b.a(r2, KtvRoomInteractViewModel$initKtvVideoData$ktvOpusDataSyncModel$1.INSTANCE);
    L10:
        if (r3 == null) goto L19;
        dc2.c<KtvStreamSingSyncData> r4 = r3.getKtvOpusSyncData();
        if (r4 == null) goto L20;
        Observable r5 = r4.d;
        if (r5 == null) goto L21;
        Disposable r6 = r5.subscribe(new c(this));
        if (r6 == null) goto L22;
        getLiveRoomCompositeDisposable().add(r6);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void initImMessage() {
        super.initImMessage();
        DataCenter r0 = getDataEntity().getDataCenter();
        if (r0 == null) goto L14;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L15;
        OpusMvManager r2 = this.opusMvManager;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L9:
        r2.h.j(r1, true);
        com.bytedance.android.livesdk.ktvapi.model.mv.g r3 = this.opusMvPreviewService;
        if (r3 == null) goto L12;
        r3.j(r1, false);
    L12:
        r1.addMessageListener(MessageType.KTV_MV_VIDEO_MESSAGE.getIntType(), this);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onBizEnterRoom() {
        super.onBizEnterRoom();
        initKtvVideoData();
        if (KtvSettingHelper.z() == false) goto L23;
        OpusMvManager r0 = this.opusMvManager;
        if (r0 == null) goto L23;
        if (r0.g == false) goto L23;
        SmoothEnterSurfaceView r1 = r0.b;
        boolean r2 = r1 instanceof SmoothEnterSurfaceView;
        if (r2 == true) goto L11;
        SmoothEnterSurfaceView r3 = null;
    L12:
        if (r3 == null) goto L14;
        ((ContinuousSurfaceAdapterView) r3).a = true;
    L14:
        if (r2 == true) goto L16;
        SmoothEnterSurfaceView r4 = null;
    L17:
        if (r4 == null) goto L19;
        ((ContinuousSurfaceAdapterView) r4).b = false;
    L19:
        if (r2 == true) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L23;
        r1.attachFromWindow("onBizEnterKtvRoom");
        goto L23
    L16:
        r4 = r1;
        goto L17
    L11:
        r3 = r1;
    L23:
        KtvContext.Companion.getClass();
        RxUtilKt.c(KtvContext.a.g().getOpenOpusPreViewDialog().onEvent().subscribe(new d(this)), getLiveRoomCompositeDisposable());
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r5 = KtvRoomContext.a.a();
        if (r5 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.isMidiOpened();
        if (r6 == null) goto L38;
        Observable r7 = r6.a();
        if (r7 == null) goto L39;
        Observable r8 = r7.subscribeOn(Schedulers.io());
        if (r8 == null) goto L40;
        Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L41;
        Disposable r10 = r9.subscribe(new e(this));
        if (r10 == null) goto L42;
        RxUtilKt.c(r10, getLiveRoomCompositeDisposable());
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onBizHide() {
        super.onBizHide();
        if (KtvSettingHelper.z() == false) goto L19;
        OpusMvManager r0 = this.opusMvManager;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.g == false) goto L21;
        SmoothEnterSurfaceView r1 = r0.b;
        boolean r2 = r1 instanceof SmoothEnterSurfaceView;
        if (r2 == true) goto L11;
        SmoothEnterSurfaceView r3 = null;
    L12:
        if (r3 == null) goto L14;
        ((ContinuousSurfaceAdapterView) r3).a = false;
    L14:
        if (r2 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L22;
        r1.detachFromWindow("onBizHide");
        return;
    L22:
        return;
    L11:
        r3 = r1;
        goto L12
    L21:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onBizLeaveRoom() {
        super.onBizLeaveRoom();
        if (isAnchor() == true) goto L8;
        com.bytedance.android.livesdk.ktvapi.model.mv.g r0 = this.opusMvPlayService;
        if (r0 == null) goto L9;
        int r1 = r0.n();
        Long r2 = KtvLoggerHelper.a;
        DataCenter r3 = getDataEntity().getDataCenter();
        HashMap r4 = new HashMap();
        KtvLoggerHelper.z(r3, r4);
        r4.put("duration", String.valueOf(r1 / 1000));
        j0.l().sendLog("livesdk_audience_mv_watch_duration", r4, new Object[]{IRoom.class, am2.x.class});
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onBizShow() {
        super.onBizShow();
        if (KtvSettingHelper.z() == false) goto L19;
        OpusMvManager r0 = this.opusMvManager;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.g == false) goto L21;
        SmoothEnterSurfaceView r1 = r0.b;
        boolean r2 = r1 instanceof SmoothEnterSurfaceView;
        if (r2 == true) goto L11;
        SmoothEnterSurfaceView r3 = null;
    L12:
        if (r3 == null) goto L14;
        ((ContinuousSurfaceAdapterView) r3).a = true;
    L14:
        if (r2 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L22;
        r1.attachFromWindow("onBizShow");
        return;
    L22:
        return;
    L11:
        r3 = r1;
        goto L12
    L21:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel, com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel
    public void onCleared() {
        super.onCleared();
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.m) getKtvContext().getSeiProcessor().getValue()).g(this);
        BaseCoreViewModel r0 = getCoreViewModel();
        if (r0 == null) goto L5;
        r0.unregisterKtvCoreListener(getMCoreListener());
    L5:
        getVmComposible().dispose();
        OpusMvManager r1 = this.opusMvManager;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L8:
        r1.h.release();
        r1.o.setOpusMvService(null);
        if (r1.k == false) goto L27;
    L23:
        Intrinsics.checkNotNullParameter("release surfaceTexutre fail", "str");
        ALogger.e("ktv-opus", "release surfaceTexutre fail");
        return;
    L11:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        SurfaceTexture r2 = r1.j;     // Catch: Throwable -> L23
        if (r2 == null) goto L17;
        if (r2.isReleased() == true) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L28;
        com.bytedance.android.live.ktv.common.util.g.f("release surfaceTexutre");     // Catch: Throwable -> L23
        SurfaceTexture r4 = r1.j;     // Catch: Throwable -> L23
        if (r4 == null) goto L29;
        r4.release();     // Catch: Throwable -> L23
        return;
    L29:
        return;
    L28:
        return;
    L17:
        r3 = false;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onIdle() {
        super.onIdle();
        com.bytedance.android.livesdk.ktvimpl.base.util.j r0 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        KtvContext r1 = getKtvContext();
        r0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.j(r1) == false) goto L11;
        OpusMvManager r2 = this.opusMvManager;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L8:
        if (r2.e == false) goto L12;
        r2.h.s();
        return;
    L12:
        return;
    }

    public final void onResume() {
        if (KtvSettingHelper.z() == false) goto L20;
        OpusMvManager r0 = this.opusMvManager;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.g == false) goto L22;
        SmoothEnterSurfaceView r1 = r0.b;
        if ((r1 instanceof SmoothEnterSurfaceView) == true) goto L11;
        r1 = null;
    L11:
        if (r1 != null) goto L13;
        return;
    L13:
        if (((ContinuousSurfaceAdapterView) r1).a == true) goto L15;
        return;
    L15:
        if (((Boolean) KtvSettingHelper.E0.getValue()).booleanValue() == true) goto L17;
    L18:
        r1.attachFromWindow("widget resume");
        return;
    L17:
        if (((ContinuousSurfaceAdapterView) r1).b == false) goto L18;
        return;
    L22:
        return;
    }

    public final Integer getMCurrentGuestMidiStatus() {
        return this.mCurrentGuestMidiStatus;
    }

    public final com.bytedance.android.livesdk.ktvapi.model.mv.g getOpusMvPlayService() {
        return this.opusMvPlayService;
    }

    public final com.bytedance.android.livesdk.ktvapi.model.mv.g getOpusMvPreviewService() {
        return this.opusMvPreviewService;
    }

    public final od getWrdsMvInfo() {
        return this.wrdsMvInfo;
    }

    public final MutableLiveData<Boolean> isMidiVisible() {
        return this.isMidiVisible;
    }

    public static final /* synthetic */ boolean access$isVideoSing$p(KtvRoomInteractViewModel r0) {
        return r0.isVideoSing;
    }

    private final void playWrdsMvInfo(final KtvStreamSingSyncData r9) {
        od r0 = r9.getMvInfo();
        if (r0 == null) goto L47;
        KtvMusic r1 = r9.songInfo;
        if (r1 == null) goto L7;
        long r2 = r1.getMId();
    L8:
        KtvMusic r3 = r9.songInfo;
        if (r3 == null) goto L12;
        String r4 = r3.getOrderUserIdString();
        if (r4 == null) goto L12;
    L13:
        this.wrdsMvInfo = r0;
        com.bytedance.android.livesdk.ktvapi.model.mv.k r5 = new com.bytedance.android.livesdk.ktvapi.model.mv.k(r2, r4);
        fd r6 = r9.videoInfo;
        if (r6 == null) goto L18;
        String r7 = r6.d();
        if (r7 == null) goto L18;
        recordVid(r7, r2, r4);
    L18:
        com.bytedance.android.livesdk.ktvapi.model.mv.g r8 = this.opusMvPlayService;
        if (r8 == null) goto L21;
        r8.d(r0, r5, true);
    L21:
        com.bytedance.android.livesdk.ktvapi.model.mv.g r10 = this.opusMvPreviewService;
        if (r10 == null) goto L25;
        r10.d(r0, r5, false);
    L25:
        if (MultiLinkSettingHelper.a() == false) goto L48;
        BaseCoreViewModel r11 = getCoreViewModel();
        com.bytedance.android.livesdk.ktvapi.model.mv.h r12 = null;
        if (r11 == null) goto L31;
        StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r13 = r11.getCurrentTransition();
        if (r13 == null) goto L31;
        KtvRoomLyricsStateMachineConfig.d r14 = (KtvRoomLyricsStateMachineConfig.d) r13.c;
    L33:
        if ((r14 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L35;
        UtilityKotlinExtentionsKt.s(1000, false, false, new KtvRoomInteractViewModel$playWrdsMvInfo$$inlined$let$lambda$1(this, r9), 6);
        return;
    L35:
        com.bytedance.android.livesdk.ktvapi.model.mv.g r15 = this.opusMvPlayService;
        if (r15 == null) goto L38;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r16 = r15.a();
    L40:
        if ((r16 instanceof KtvMvPlayer) == false) goto L43;
        r12 = r16;
    L43:
        KtvMvPlayer r17 = (KtvMvPlayer) r12;
        if (r17 == null) goto L50;
        r17.r();
        return;
    L50:
        return;
    L38:
        r16 = null;
    L31:
        r14 = null;
        goto L33
    L48:
        return;
    L12:
        r4 = "";
        goto L13
    L7:
        r2 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public boolean accept(com.bytedance.android.livesdk.ktvimpl.base.sei.w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r2, "result");
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void observeCoreViewModel(LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        BaseCoreViewModel r5 = getCoreViewModel();
        if (r5 == null) goto L6;
        r5.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE, BaseCoreViewModel.CORE_TAG_DATA_MODEL, BaseCoreViewModel.CORE_TAG_PROGRESS}), getMCoreListener(), true);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onMessage(tlc.d r4) {
        super.onMessage(r4);
        if ((r4 instanceof gd) == true) goto L5;
        r4 = null;
    L5:
        gd r5 = (gd) r4;
        if (r5 == null) goto L19;
        dd r6 = r5.videoContent;
        if (r6 == null) goto L20;
        fd r0 = r6.d();
        if (r0 == null) goto L21;
        String r1 = r0.d();
        if (r1 == null) goto L22;
        Long r2 = r6.c();
        if (r2 == null) goto L16;
        long r3 = r2.longValue();
    L17:
        recordVid(r1, r3, r6.a());
        return;
    L16:
        r3 = 0;
        goto L17
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onMusicListChange(List<MusicPanel> r15) {
        KtvRoomLyricsStateMachineConfig.d r0 = getCurState();
        ArrayList r1 = null;
        if (r0 == null) goto L9;
        MusicPanel r2 = r0.b();
        if (r2 == null) goto L9;
        KtvMusic r3 = r2.a;
        if (r3 == null) goto L9;
        final Long r4 = Long.valueOf(r3.getMId());
    L10:
        com.bytedance.android.livesdk.ktvapi.model.mv.g r5 = this.opusMvPlayService;
        if (r5 == null) goto L13;
        r5.g(r15, new C02431(r4));
    L13:
        OpusMvManager r6 = this.opusMvManager;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L16:
        r6.getClass();
        if (r15 != null) goto L19;
    L36:
        ArrayList<b> r7 = this.oldStageVidStore;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L38:
        if (r9.hasNext() == false) goto L66;
        Object r10 = r9.next();
        b r11 = (b) r10;
        boolean r12 = false;
        if (r15 == null) goto L60;
        Iterator<T> r13 = r15.iterator();
    L43:
        if (r13.hasNext() == false) goto L58;
        Object r14 = r13.next();
        MusicPanel r16 = (MusicPanel) r14;
        KtvMusic r17 = r16.a;
        if (r17 == null) goto L47;
        String r18 = r17.getOrderUserIdString();
    L49:
        if (Intrinsics.areEqual(r18, r11.b) == false) goto L55;
        KtvMusic r19 = r16.a;
        if (r19 == null) goto L55;
        if (r19.getMId() != r11.c) goto L55;
        boolean r20 = true;
    L56:
        if (r20 == false) goto L43;
    L59:
        MusicPanel r21 = (MusicPanel) r14;
    L61:
        if (r21 != null) goto L63;
        r12 = true;
    L63:
        if (r12 == false) goto L38;
        r8.add(r10);
    L55:
        r20 = false;
        goto L56
    L47:
        r18 = null;
        goto L49
    L58:
        r14 = null;
        goto L59
    L60:
        r21 = null;
        goto L61
    L66:
        if ((!r8.isEmpty()) == false) goto L68;
        r1 = r8;
    L68:
        if (r1 == null) goto L81;
        this.oldStageVidStore.removeAll(r1);
        return;
    L81:
        return;
    L19:
        if (r15.isEmpty() != true) goto L36;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r22 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r6.o.getKtvCoreViewModel().getValue();
        if (r22 == null) goto L23;
        KtvRoomLyricsStateMachineConfig.d r23 = r22.getCurState();
    L25:
        if ((r23 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L36;
        if (r6.e == false) goto L30;
        r6.h.s();
    L30:
        if (MultiLinkSettingHelper.a() == false) goto L36;
        KtvMvPlayer r24 = r6.h.a;
        if ((r24 instanceof KtvMvPlayer) == true) goto L34;
        r24 = null;
    L34:
        if (r24 == null) goto L36;
        r24.r();
        goto L36
    L23:
        r23 = null;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(com.bytedance.android.livesdk.ktvimpl.base.sei.w r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        if (ne2.a.a() == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r6 = r5.b;
        boolean r1 = false;
        if ((r6 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.k) == false) goto L29;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r7 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r6;
        if (r7.s() == null) goto L25;
        String r0 = r7.A();
        Integer r2 = r7.s();
        Object r3 = getCurrentSingerUserId();
        if (r3 != null) goto L13;
        r3 = 0;
    L13:
        if (Intrinsics.areEqual(r0, r3) == true) goto L15;
    L23:
        this.mCurrentGuestMidiStatus = r7.s();
        return;
    L15:
        if (ne2.a.d() == true) goto L23;
        MutableLiveData<Boolean> r4 = this.isMidiVisible;
        if (r2 != null) goto L20;
    L22:
        r4.setValue(Boolean.valueOf(r1));
        goto L23
    L20:
        if (r2.intValue() != 1) goto L22;
        r1 = true;
        goto L22
    L25:
        if (ne2.a.d() == false) goto L27;
        this.isMidiVisible.setValue(Boolean.FALSE);
    L27:
        this.mCurrentGuestMidiStatus = r7.s();
        return;
    L29:
        if ((r6 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.i) == true) goto L31;
        return;
    L31:
        if (this.mCurrentGuestMidiStatus == null) goto L33;
        return;
    L33:
        String r8 = ((com.bytedance.android.livesdk.ktvimpl.base.sei.i) r6).h();
        Object r9 = getCurrentSingerUserId();
        if (r9 != null) goto L37;
        r9 = 0;
    L37:
        if (Intrinsics.areEqual(r8, r9) == false) goto L43;
        this.isMidiVisible.setValue(Boolean.TRUE);
        return;
    }

    public final void setMCurrentGuestMidiStatus(Integer r1) {
        this.mCurrentGuestMidiStatus = r1;
    }

    public final void setMidiVisible(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isMidiVisible = r2;
    }

    public final void setOpusMvManager(OpusMvManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.opusMvManager = r2;
    }

    public final void setOpusMvPlayService(com.bytedance.android.livesdk.ktvapi.model.mv.g r1) {
        this.opusMvPlayService = r1;
    }

    public final void setOpusMvPreviewService(com.bytedance.android.livesdk.ktvapi.model.mv.g r1) {
        this.opusMvPreviewService = r1;
    }

    public final void setWrdsMvInfo(od r1) {
        this.wrdsMvInfo = r1;
    }

    public KtvRoomInteractViewModel(KtvContext r7, sb0.b r8) {
        Intrinsics.checkNotNullParameter(r7, "ktvContext");
        Intrinsics.checkNotNullParameter(r8, "dataEntity");
        super(r7, r8);
        this.isMidiVisible = new MutableLiveData();
        this.oldStageVidStore = new ArrayList();
        KtvContext.observerCurrentUserIsSinger$default(r7, this, false, new a(this), 2, null);
        com.bytedance.android.livesdk.ktvimpl.base.sei.d.a.a((com.bytedance.android.livesdk.ktvimpl.base.sei.d) r7.getSeiProcessor().getValue(), this);
    }

    public static final /* synthetic */ void access$setVideoSing$p(KtvRoomInteractViewModel r0, boolean r1) {
        r0.isVideoSing = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void consumeWrdsData(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "syncKey");
        super.consumeWrdsData(r3, r4);
        com.bytedance.android.live.ktv.common.util.g.f("consumeWrdsData:" + r3 + "--" + r4);
        if (Intrinsics.areEqual(r3, "KtvStreamSingSyncData") == true) goto L5;
        return;
    L5:
        if ((r4 instanceof KtvStreamSingSyncData) == true) goto L7;
        r4 = null;
    L7:
        KtvStreamSingSyncData r5 = (KtvStreamSingSyncData) r4;
        if (r5 == null) goto L12;
        playWrdsMvInfo(r5);
        return;
    }

    public final void initMidiViewAndSendMidiStatusSei(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if (r6 == false) goto L36;
        KtvContext r8 = getKtvContext();
        String r0 = null;
        if (r8 == null) goto L9;
        MutableLiveData<Boolean> r9 = r8.getRealOpenStateData();
        if (r9 == null) goto L9;
        Boolean r10 = (Boolean) r9.getValue();
    L10:
        boolean r1 = false;
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L13;
    L16:
        boolean r11 = true;
    L17:
        KtvRoomLyricsStateMachineConfig.d r3 = getCurState();
        if (r3 == null) goto L22;
        MusicPanel r4 = r3.b();
        if (r4 == null) goto L22;
        r0 = r4.q;
    L22:
        boolean r2 = !TextUtils.isEmpty(r0);
        MutableLiveData<Boolean> r5 = this.isMidiVisible;
        if (r2 == false) goto L34;
        if (r11 == true) goto L34;
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r12 = KtvRoomContext.a.a();
        if (r12 == null) goto L32;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.isMidiOpened();
        if (r13 == null) goto L32;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L32;
    L33:
        r1 = true;
    L32:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.M.getValue()).booleanValue() == true) goto L33;
    L34:
        r5.setValue(Boolean.valueOf(r1));
        ALogger.i("ttlive_ktv", "KtvMvStageWidget, initMidiViewAndSendMidiStatusSei: isChallenging = " + r11 + ", supportScore = " + r2 + ", source = " + r7);
        return;
    L13:
        if (ne2.a.d() == true) goto L16;
        r11 = false;
    L9:
        r10 = null;
        goto L10
    }

    public final void initOpusManager(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "container");
        OpusMvManager r1 = new OpusMvManager(getDataEntity(), r6, r5, getKtvContext());
        this.opusMvManager = r1;
        this.opusMvPlayService = r1.h;
        Long r7 = Long.valueOf(getDataEntity().b().getRoomId());
        Intrinsics.checkNotNullParameter(r5, "context");
        OpusServiceImpl r0 = new OpusServiceImpl(r7, r5, null, null);
        r0.j = null;
        r0.k = null;
        this.opusMvPreviewService = r0;
        DataCenter r8 = getDataEntity().getDataCenter();
        if (r8 == null) goto L10;
        vlc.d r9 = (vlc.d) r8.get("data_message_manager", null);
        if (r9 == null) goto L11;
        com.bytedance.android.livesdk.ktvapi.model.mv.g r10 = this.opusMvPreviewService;
        if (r10 == null) goto L12;
        r10.j(r9, false);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onEnterPrepareState(KtvRoomLyricsStateMachineConfig.d r7, KtvRoomLyricsStateMachineConfig.d.e r8) {
        Intrinsics.checkNotNullParameter(r7, "from");
        Intrinsics.checkNotNullParameter(r8, "to");
        super.onEnterPrepareState(r7, r8);
        if (getKtvContext().isCurrentUserIsSinger() == false) goto L5;
    L8:
        boolean r9 = true;
    L9:
        KtvMusic r0 = r8.b.a;
        com.bytedance.android.livesdk.ktvapi.model.mv.g r1 = this.opusMvPlayService;
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.ktvapi.model.mv.k r2 = new com.bytedance.android.livesdk.ktvapi.model.mv.k(r0.getMId(), r0.getOrderUserIdString());
        r2.a = r0.getTitle();
        r2.b = r8.b;
        Unit r10 = Unit.INSTANCE;
        r1.o(r2, r9);
    L13:
        if (getKtvContext().isCurrentUserIsSinger() == true) goto L16;
        this.isMidiVisible.setValue(Boolean.FALSE);
        return;
    L16:
        return;
    L5:
        if (KtvUtilsKt.x(r8.b.a) == true) goto L8;
        r9 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onPause(KtvRoomLyricsStateMachineConfig.d r2, KtvRoomLyricsStateMachineConfig.d.C0041d r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "to");
        super.onPause(r2, r3);
        com.bytedance.android.livesdk.ktvapi.model.mv.g r4 = this.opusMvPlayService;
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r5 = r4.a();
        if (r5 == null) goto L9;
        r5.pause();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel
    public void onSinging(KtvRoomLyricsStateMachineConfig.d r11, KtvRoomLyricsStateMachineConfig.d.f r12) {
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "to");
        super.onSinging(r11, r12);
        if ((r11 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L9;
        com.bytedance.android.livesdk.ktvapi.model.mv.g r13 = this.opusMvPlayService;
        if (r13 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r14 = r13.a();
        if (r14 == null) goto L9;
        r14.start();
    L9:
        com.bytedance.android.live.ktv.common.util.g.f("onSinging:wrdsMvInfo" + this.wrdsMvInfo);
        od r15 = this.wrdsMvInfo;
        if (r15 == null) goto L17;
        KtvMusic r2 = r12.b.a;
        com.bytedance.android.livesdk.ktvapi.model.mv.k r3 = new com.bytedance.android.livesdk.ktvapi.model.mv.k(r2.getMId(), r2.getOrderUserIdString());
        r3.a = r2.getTitle();
        r3.b = r12.b;
        com.bytedance.android.livesdk.ktvapi.model.mv.g r4 = this.opusMvPlayService;
        if (r4 == null) goto L14;
        r4.d(r15, r3, true);
    L14:
        com.bytedance.android.livesdk.ktvapi.model.mv.g r5 = this.opusMvPreviewService;
        if (r5 == null) goto L17;
        r5.d(r15, r3, false);
    L17:
        KtvMusic r16 = r12.b.a;
        Iterator<T> r17 = this.oldStageVidStore.iterator();
    L18:
        String r6 = null;
        if (r17.hasNext() == false) goto L28;
        Object r7 = r17.next();
        b r8 = (b) r7;
        if (r8.c == r16.getMId()) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L18;
    L29:
        b r10 = (b) r7;
        if (r10 == null) goto L44;
        String r18 = r10.a;
        if (r18 != null) goto L34;
        return;
    L34:
        if ((!TextUtils.isEmpty(r18)) == false) goto L36;
        r6 = r18;
    L36:
        if (r6 == null) goto L46;
        getKtvContext().getCurrentMvVid().setValue(r6);
        return;
    L46:
        return;
    L44:
        return;
    L23:
        if (Intrinsics.areEqual(r8.b, r16.getOrderUserIdString()) == false) goto L25;
        r9 = true;
        goto L26
    L28:
        r7 = null;
        goto L29
    }

    public void onVideoRegionStartShow(int r2, int r3) {
        this.isVideoSing = true;
        OpusMvManager r4 = this.opusMvManager;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("opusMvManager");
    L5:
        r4.b(true);
    }

    private final void recordVid(String r7, long r8, String r10) {
        if ((getCurState() instanceof KtvRoomLyricsStateMachineConfig.d.c) == false) goto L5;
        getKtvContext().getCurrentMvVid().setValue(r7);
    L5:
        Iterator<T> r0 = this.oldStageVidStore.iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        Object r1 = r0.next();
        b r2 = (b) r1;
        if (r2.c == r8) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L7;
    L17:
        b r4 = (b) r1;
        if (r4 == null) goto L20;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r4.a = r7;
        return;
    L20:
        this.oldStageVidStore.add(new b(r7, r10, r8));
        return;
    L11:
        if (Intrinsics.areEqual(r2.b, r10) == false) goto L13;
        r3 = true;
        goto L14
    L16:
        r1 = null;
        goto L17
    }

    public static /* synthetic */ void initMidiViewAndSendMidiStatusSei$default(KtvRoomInteractViewModel r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.initMidiViewAndSendMidiStatusSei(r1, r2);
    }
}
