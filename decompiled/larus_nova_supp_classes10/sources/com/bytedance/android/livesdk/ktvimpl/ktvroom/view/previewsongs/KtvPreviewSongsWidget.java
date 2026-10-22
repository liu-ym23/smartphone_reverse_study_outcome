package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/previewsongs/KtvPreviewSongsWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Ltb0/a;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvPreviewSongsWidget extends LiveWidget implements tb0.a {
    public static final /* synthetic */ int k = 0;
    public final CompositeDisposable a;
    public RecyclerView b;
    public KtvPreviewSongsAdapter c;
    public final int d;
    public List<MusicPanel> e;
    public boolean f;
    public final KtvPreviewSongsViewModel g;
    public final KtvContext h;
    public final boolean i;
    public final boolean j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvPreviewSongsWidget a;

        public b(KtvPreviewSongsWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            KtvPreviewSongsWidget r4 = this.a;
            int r0 = KtvPreviewSongsWidget.k;
            r4.wq();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsWidget$onBizEnterRoom$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/b;", "p1", "", "invoke", "(Lcom/bytedance/android/live/ktv/common/model/bean/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.ktv.common.model.bean.b, Unit> {
        public AnonymousClass1(KtvPreviewSongsWidget r8) {
            super(1, r8, KtvPreviewSongsWidget.class, "onDownloadProgressUpdated", "onDownloadProgressUpdated(Lcom/bytedance/android/live/ktv/common/model/bean/DownloadProgressEvent;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.ktv.common.model.bean.b r11) {
            Intrinsics.checkNotNullParameter(r11, "p1");
            KtvPreviewSongsWidget r0 = (KtvPreviewSongsWidget) ((CallableReference) this).receiver;
            int r1 = KtvPreviewSongsWidget.k;
            r0.getClass();
            MusicPanel r2 = r11.a;
            if (r2 == null) goto L40;
            KtvMusic r3 = r2.a;
            if (r3 == null) goto L41;
            long r4 = r3.getMId();
            KtvPreviewSongsAdapter r5 = r0.c;
            if (r5 == null) goto L20;
            List<MusicPanel> r6 = r5.a;
            if (r6 == null) goto L20;
            Iterator r7 = ((ArrayList) r6).iterator();
            int r8 = 0;
        L12:
            if (r7.hasNext() == false) goto L20;
            if (((MusicPanel) r7.next()).a.getMId() != r4) goto L16;
            boolean r9 = true;
        L17:
            if (r9 == true) goto L21;
            r8 = r8 + 1;
        L21:
            RecyclerView r10 = r0.b;
            RecyclerView.ViewHolder r12 = null;
            if (r10 == null) goto L24;
            RecyclerView.ViewHolder r13 = r10.findViewHolderForAdapterPosition(r8);
        L26:
            if ((r13 instanceof KtvPreviewSongsViewHolder) == false) goto L29;
            r12 = r13;
        L29:
            KtvPreviewSongsViewHolder r14 = (KtvPreviewSongsViewHolder) r12;
            if ((r11 instanceof com.bytedance.android.live.ktv.common.model.bean.b.b) == false) goto L34;
            if (r14 == null) goto L42;
            com.bytedance.android.live.ktv.common.model.bean.b.b r15 = (com.bytedance.android.live.ktv.common.model.bean.b.b) r11;
            r14.c.setText(s1.C(2131918371, new Object[]{0}));
            r14.c.setClickable(false);
            return;
        L42:
            return;
        L34:
            if ((r11 instanceof com.bytedance.android.live.ktv.common.model.bean.b.a) == false) goto L44;
            if (r14 == null) goto L45;
            r14.T3();
            return;
        L45:
            return;
        L44:
            return;
        L24:
            r13 = null;
            goto L26
        L16:
            r9 = false;
        L20:
            r8 = -1;
            goto L21
        L41:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.ktv.common.model.bean.b) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566524;
    }

    public final void onBizDestory() {
        this.g.onBizDestory();
        this.h.getBizLcMager().c(this);
        this.a.clear();
        KtvPreviewSongsAdapter r0 = this.c;
        if (r0 == null) goto L6;
        r0.b.cancel();
        return;
    }

    public final void onBizEnterRoom() {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L7;
        n<KtvPreviewSongsViewModel> r1 = r0.getPreviewViewModel();
        if (r1 == null) goto L7;
        r1.setValue(this.g);
    L7:
        KtvRoomContext r2 = KtvRoomContext.a.a();
        if (r2 == null) goto L16;
        k<com.bytedance.android.live.ktv.common.model.bean.b> r3 = r2.getDownloadProcess();
        if (r3 == null) goto L16;
        PublishSubject r4 = r3.onEvent();
        if (r4 == null) goto L16;
        Disposable r5 = r4.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.b(new AnonymousClass1(this)));
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.a);
    L16:
        KtvRoomContext r6 = KtvRoomContext.a.a();
        if (r6 != null) goto L19;
    L22:
        this.g.onBizEnterRoom();
        return;
    L19:
        if (r6.isKtvRoomEnterGetOrderSongSuccess() == false) goto L21;
        wq();
    L21:
        RxUtilKt.c(r6.observeKtvRoomEnterGetOrderSongSuccess(new b(this)), this.a);
        goto L22
    }

    public final void onBizHide() {
        this.g.onBizHide();
    }

    public final void onBizLeaveRoom() {
        this.g.onBizLeaveRoom();
    }

    public final void onBizShow() {
        this.g.onBizShow();
    }

    public final void wq() {
        this.g.updateOrderSongListGetedState(true);
        int r0 = d.e(this.h);
        StringBuilder r2 = new StringBuilder("KtvPreviewSongsWidget: KtvRoomEnterGetOrderSongSuccess, selectedCount=");
        r2.append(r0);
        r2.append(", curState=");
        c r1 = (c) this.h.getKtvCoreViewModel().getValue();
        if (r1 == null) goto L5;
        KtvRoomLyricsStateMachineConfig.d r3 = r1.getCurState();
    L6:
        r2.append(r3);
        ALogger.w("KtvPreviewSongsWidget", r2.toString());
        j r4 = j.l;
        KtvContext r5 = this.h;
        r4.getClass();
        if (j.j(r5) == true) goto L9;
        return;
    L9:
        if (KtvPreviewSongsViewModel.isMusicStopped$default(this.g, null, 1, null) == false) goto L13;
        this.g.setShowPreviewCard(true, "getOrderSongList");
        return;
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onCreate() {
        super.onCreate();
        this.h.getBizLcMager().a(this);
        ((Widget) this).contentView.setVisibility(8);
        RecyclerView r0 = findViewById(2131382960);
        this.b = r0;
        if (r0 == null) goto L5;
        final Context r3 = ((Widget) this).context;
        r0.setLayoutManager(new KtvPreviewSongsWidget$initViews$1(this, r3));
    L5:
        ((Widget) this).contentView.setBackground(null);
        KtvPreviewSongsAdapter r1 = new KtvPreviewSongsAdapter(this.j, this.i);
        this.c = r1;
        RecyclerView r2 = this.b;
        if (r2 == null) goto L8;
        r2.setAdapter(r1);
    L8:
        UtilityKotlinExtentionsKt.s(0, false, true, new KtvPreviewSongsWidget$initViews$2(this), 3);
        Disposable r4 = this.g.getRefreshView().onEvent().subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.b(new KtvPreviewSongsWidget$initData$1(this)));
        if (r4 == null) goto L11;
        RxUtilKt.c(r4, this.a);
    L11:
        Disposable r5 = this.g.getShowPreviewCard().a().subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.b(new KtvPreviewSongsWidget$initData$2(this)));
        if (r5 == null) goto L15;
        RxUtilKt.c(r5, this.a);
    L15:
        if (((Boolean) this.g.getNeedDelayToShow().getValue()).booleanValue() == false) goto L17;
    L18:
        ((Widget) this).contentView.setVisibility(8);
    L19:
        this.g.onInit();
        return;
    L17:
        if (this.g.isShowPreviewCard() == true) goto L19;
        goto L18
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public KtvPreviewSongsWidget(KtvPreviewSongsViewModel r2, KtvContext r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "ktvContext");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = new CompositeDisposable();
        this.d = r2.getSongCountInEachPage();
    }
}
