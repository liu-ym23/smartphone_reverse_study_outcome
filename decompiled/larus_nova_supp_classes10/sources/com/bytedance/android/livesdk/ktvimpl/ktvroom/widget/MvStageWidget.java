package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.ktv.common.midi.AbsKtvMidiView;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvReuseRoomViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/MvStageWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvStageWidget;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvStageWidget extends KtvStageWidget {
    public static final /* synthetic */ int B = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ MvStageWidget a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.MvStageWidget$a$a, reason: collision with other inner class name */
        public static final class C0043a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0043a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                Boolean r5 = (Boolean) r4;
                this.a.a.Cq(r5.booleanValue(), false);
                com.bytedance.live.datacontext.n<MidiSkinDressInfo> r0 = this.a.a.y.getMidiSkinContext();
                if (r0 == null) goto L5;
                MidiSkinDressInfo r1 = (MidiSkinDressInfo) r0.getValue();
            L7:
                if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L15;
                if (r1 == null) goto L16;
                KtvMvMidiWidget r6 = this.a.a.h;
                if (r6 == null) goto L17;
                AbsKtvMidiView r7 = r6.c;
                if (r7 == null) goto L18;
                r7.y(r1);
                return;
            L18:
                return;
            L17:
                return;
            L16:
                return;
            L15:
                return;
            L5:
                r1 = null;
                goto L7
            }
        }

        public a(MvStageWidget r1) {
            this.a = r1;
        }

        public final void a() {
            MvStageWidget r0 = this.a;
            if (((Widget) r0).widgetCallback != null) goto L60;
        L7:
            MvStageWidget r1 = this.a;
            r1.o = Boolean.TRUE;
            WidgetManager r2 = ((Widget) r1).subWidgetManager;
            if (r2 == null) goto L10;
            r2.dataCenter = r1.z.getDataCenter();
        L10:
            MutableLiveData<Boolean> r3 = this.a.y.getRealOpenStateData();
            MvStageWidget r4 = this.a;
            r3.observe(r4, r4.t);
            this.a.y.getKtvCardViewSizeChanged().setValue(Integer.valueOf(com.bytedance.android.live.core.utils.s1.j(2131168834)));
            Long r5 = KtvLoggerHelper.a;
            KtvLoggerHelper.f0();
            KtvLoggerHelper.c0();
            MvStageWidget r6 = this.a;
            int r7 = MvStageWidget.B;
            KtvRoomViewModel r8 = (KtvRoomViewModel) r6.d;
            if (r8 == null) goto L15;
            NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r9 = r8.getStateChangeEvent();
            if (r9 == null) goto L15;
            MvStageWidget r10 = this.a;
            r9.observe(r10, r10.x);
        L15:
            KtvMvControlAreaWidget r11 = this.a.g;
            if (r11 == null) goto L47;
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r12 = KtvRoomContext.a.a();
            if (r12 == null) goto L30;
            com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r13 = r12.getPreviewViewModel();
            if (r13 == null) goto L30;
            KtvPreviewSongsViewModel r14 = (KtvPreviewSongsViewModel) r13.getValue();
            if (r14 == null) goto L30;
            com.bytedance.live.datacontext.m<Boolean> r15 = r14.getShowPreviewCard();
            if (r15 == null) goto L30;
            Observable r16 = r15.a();
            if (r16 == null) goto L30;
            ObservableSubscribeProxy r17 = (ObservableSubscribeProxy) r16.as(r11.autoDispose());
            if (r17 == null) goto L30;
            final KtvMvControlAreaWidget$onRoomContextInit$1 r18 = new KtvMvControlAreaWidget$onRoomContextInit$1(r11);
            r17.subscribe(new c0(r18));
        L30:
            KtvModeOrderedSongDataContext r19 = KtvModeOrderedSongDataContext.Companion.getContext();
            if (r19 == null) goto L35;
            Disposable r20 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r19, null, new a0(r11), 3);
            if (r20 == null) goto L35;
            RxUtilKt.c(r20, r11.n);
        L35:
            KtvRoomContext r21 = KtvRoomContext.a.a();
            if (r21 == null) goto L44;
            com.bytedance.live.datacontext.k<Boolean> r22 = r21.getOriginSwitch();
            if (r22 == null) goto L44;
            PublishSubject r23 = r22.onEvent();
            if (r23 == null) goto L44;
            Disposable r24 = r23.subscribe(new b0(r11));
            if (r24 == null) goto L44;
            RxUtilKt.c(r24, r11.n);
        L44:
            r11.Eq(com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(r11.q));
            com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r25 = r11.r;
            if (r25 == null) goto L47;
            r25.e(((Widget) r11).containerView, new KtvMvControlAreaWidget$onRoomContextInit$4(r11));
        L47:
            KtvMvControlAreaWidget r26 = this.a.g;
            if (r26 == null) goto L50;
            r26.Aq(true);
        L50:
            KtvRoomContext.Companion.getClass();
            KtvRoomContext r27 = KtvRoomContext.a.a();
            if (r27 == null) goto L62;
            com.bytedance.live.datacontext.m<Boolean> r28 = r27.isMidiOpened();
            if (r28 == null) goto L63;
            Observable r29 = r28.a();
            if (r29 == null) goto L64;
            ObservableSubscribeProxy r30 = (ObservableSubscribeProxy) r29.as(this.a.autoDispose());
            if (r30 == null) goto L65;
            r30.subscribe(new C0043a(this));
            return;
        L65:
            return;
        L64:
            return;
        L63:
            return;
        L62:
            return;
        L60:
            r0.enableSubWidgetManager();     // Catch: Exception -> L6
        L6:
            ALogger.e("KtvStageWidget", "enableSubWidgetManager fail");
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget
    public final void onBizEnterRoom() {
        ALogger.i("logKtvMainPath", "MvStageWidget onBizEnterKtvRoom, invoke class :MvStageWidget");
        ((Widget) this).contentView.post(new a(this));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget
    public final void onBizLeaveRoom() {
        KtvRoomViewModel r0 = (KtvRoomViewModel) this.d;
        if (r0 == null) goto L7;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r1 = r0.getStateChangeEvent();
        if (r1 == null) goto L7;
        r1.observe(this, this.x);
    L7:
        this.o = Boolean.FALSE;
        if (vm2.h.p() == false) goto L12;
        KtvMvControlAreaWidget r2 = this.g;
        if (r2 == null) goto L12;
        r2.Aq(false);
    L12:
        WidgetManager r3 = ((Widget) this).subWidgetManager;
        if (r3 == null) goto L15;
        r3.dataCenter = null;
    L15:
        this.y.getRealOpenStateData().removeObserver(this.t);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidget
    public final AbsKWidgetViewModel xq() {
        return new KtvReuseRoomViewModel(this.y, this.z);
    }

    public MvStageWidget(KtvContext r2, sb0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        super(r2, r3);
        this.o = Boolean.FALSE;
    }
}
