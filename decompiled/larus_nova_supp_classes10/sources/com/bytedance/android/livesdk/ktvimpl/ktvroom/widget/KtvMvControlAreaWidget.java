package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.ordersong.feedback.KtvMusicFeedbackDialog;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.KtvRoomChallengeViewWrapper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.KtvMvSingerInfoView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.KtvRoomFeedbackGuideDialog;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvMvControlAreaWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Landroid/view/View$OnClickListener;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvControlAreaWidget extends MiddlewareRoomWidget implements View.OnClickListener {
    public static final /* synthetic */ int s = 0;
    public View a;
    public TextView b;
    public KtvMvSingerInfoView c;
    public TextView d;
    public TextView e;
    public View f;
    public View g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public View l;
    public ImageView m;
    public final CompositeDisposable n;
    public final sb0.b o;
    public final KtvRoomViewModel p;
    public final KtvContext q;
    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ KtvMvControlAreaWidget a;
        public final /* synthetic */ boolean b;

        public c(KtvMvControlAreaWidget r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            r7.dismiss();
            if (this.b == false) goto L45;
            KtvContext r9 = this.a.q;
            if (r9 == null) goto L11;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r10 = r9.getKtvSingerViewModel();
            if (r10 == null) goto L11;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r11 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r10.getValue();
            if (r11 == null) goto L11;
            r11.cutMusic();
        L11:
            KtvMvControlAreaWidget r12 = this.a;
            KtvContext r0 = r12.q;
            if (r0 == null) goto L18;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.i> r1 = r0.getKtvCoreController();
            if (r1 == null) goto L18;
            com.bytedance.android.livesdk.ktvimpl.base.i r2 = (com.bytedance.android.livesdk.ktvimpl.base.i) r1.getValue();
            if (r2 == null) goto L18;
            Long r3 = Long.valueOf(r2.b());
        L19:
            LongRange r4 = new LongRange(0, 30000);
            if (r3 != null) goto L22;
        L24:
            boolean r5 = false;
        L25:
            if (r5 == false) goto L56;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r6 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r12.q.getKtvCoreViewModel().getValue();
            if (r6 == null) goto L31;
            KtvRoomLyricsStateMachineConfig.d r13 = r6.getCurState();
            if (r13 == null) goto L31;
            MusicPanel r14 = r13.b();
        L32:
            if (r14 == null) goto L57;
            int r15 = KtvRoomFeedbackGuideDialog.k;
            String r16 = r14.a.getMTitle();
            String r17 = "";
            if (r16 != null) goto L36;
            r16 = "";
        L36:
            String r18 = r14.a.getMAuthor();
            if (r18 == null) goto L40;
            r17 = r18;
        L40:
            KtvRoomFeedbackGuideDialog r19 = KtvRoomFeedbackGuideDialog.a.a(new com.bytedance.android.live.ktv.common.ordersong.feedback.a(r16, r17), KtvMusicFeedbackDialog.FeedbackType.KSONG_SONG_INFO);
            Context r20 = (Activity) com.bytedance.android.livesdk.utils.d.a.get();
            if (r20 != null) goto L44;
            r20 = ((Widget) r12).context;
        L44:
            r19.W90(r20, null, true);
            return;
        L57:
            return;
        L31:
            r14 = null;
            goto L32
        L56:
            return;
        L22:
            if (r4.contains(r3.longValue()) == false) goto L24;
            r5 = true;
        L18:
            r3 = null;
            goto L19
        L45:
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r21 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) this.a.q.getKtvCoreViewModel().getValue();
            if (r21 == null) goto L50;
            KtvRoomLyricsStateMachineConfig.d r22 = r21.getCurState();
            if (r22 == null) goto L50;
            MusicPanel r23 = r22.b();
        L51:
            if (r23 == null) goto L59;
            KtvModeOrderSongDataContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r24 = KtvModeOrderSongDataContext.Companion.a();
            if (r24 == null) goto L60;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d.a.b(r24, r23, null, 6);
            return;
        L60:
            return;
        L59:
            return;
        L50:
            r23 = null;
            goto L51
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvMvControlAreaWidget a;

        public d(KtvMvControlAreaWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KtvMvControlAreaWidget r0 = this.a;
            int r1 = KtvMvControlAreaWidget.s;
            r0.yq((StateMachine.c.b) r3);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ KtvMvControlAreaWidget a;

        public e(KtvMvControlAreaWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            UserAttr r4 = (UserAttr) r3;
            KtvMvControlAreaWidget r0 = this.a;
            KtvRoomViewModel r1 = r0.p;
            if (r1 == null) goto L7;
            NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r2 = r1.getStateChangeEvent();
            if (r2 == null) goto L7;
            StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r5 = (StateMachine.c.b) r2.getValue();
        L8:
            r0.yq(r5);
            com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r6 = r0.r;
            if (r6 == null) goto L12;
            r6.h(r4);
            return;
        L12:
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ KtvMvControlAreaWidget a;

        public f(KtvMvControlAreaWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            KtvMvControlAreaWidget r4 = this.a;
            int r0 = KtvMvControlAreaWidget.s;
            r4.xq();
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566510;
    }

    public final boolean isAnchor() {
        sb0.b r0 = this.o;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isAnchor() != true) goto L7;
        return true;
    }

    public final void onDestroy() {
        if (this.n.isDisposed() == true) goto L5;
        this.n.dispose();
    L5:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r0 = this.r;
        if (r0 == null) goto L8;
        r0.onDestroy();
    L8:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
    }

    public final boolean zq() {
        KtvModeOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r0 = KtvModeOrderSongDataContext.Companion.e();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasNewKtvDress() != true) goto L7;
        return true;
    }

    public final void onCreate() {
        super.onCreate();
        this.a = ((Widget) this).containerView.findViewById(2131377000);
        TextView r0 = (TextView) ((Widget) this).containerView.findViewById(2131376998);
        this.b = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L5:
        r0.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AnonymousClass1(this)));
        KtvMvSingerInfoView r1 = (KtvMvSingerInfoView) ((Widget) this).containerView.findViewById(2131377003);
        this.c = r1;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L8:
        r1.setKtvContext(this.q);
        KtvMvSingerInfoView r2 = this.c;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L11:
        r2.S5(this, this.p, this.n);
        this.d = (TextView) ((Widget) this).containerView.findViewById(2131377015);
        this.e = (TextView) ((Widget) this).containerView.findViewById(2131377011);
        this.f = ((Widget) this).containerView.findViewById(2131376929);
        Lazy r3 = KtvCommonSettingHelper.a;
        this.l = ((Widget) this).containerView.findViewById(2131376861);
        ImageView r4 = (ImageView) ((Widget) this).containerView.findViewById(2131376989);
        this.m = r4;
        if (r4 == null) goto L14;
        r4.setOnClickListener(this);
    L14:
        ImageView r5 = (ImageView) ((Widget) this).containerView.findViewById(2131376988);
        if (r5 == null) goto L17;
        r5.setOnClickListener(this);
    L17:
        this.g = ((Widget) this).containerView.findViewById(2131377076);
        ImageView r6 = (ImageView) ((Widget) this).containerView.findViewById(2131377006);
        this.h = r6;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L20:
        r6.setOnClickListener(this);
        ImageView r7 = (ImageView) ((Widget) this).containerView.findViewById(2131377008);
        this.i = r7;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L23:
        r7.setOnClickListener(this);
        ImageView r8 = (ImageView) ((Widget) this).containerView.findViewById(2131377004);
        this.j = r8;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerNextBtn");
    L26:
        r8.setOnClickListener(this);
        ImageView r9 = (ImageView) ((Widget) this).containerView.findViewById(2131377009);
        this.k = r9;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L29:
        r9.setOnClickListener(this);
        RxUtilKt.c(this.q.getHasBgm().a().subscribe(new z(this)), this.n);
        if (isAnchor() == false) goto L32;
    L33:
        ImageView r10 = this.h;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L36:
        r10.setVisibility(8);
    L37:
        KtvRoomViewModel r11 = this.p;
        if (r11 == null) goto L42;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r12 = r11.getStateChangeEvent();
        if (r12 == null) goto L42;
        r12.observe(this, new d(this));
    L42:
        KtvRoomViewModel r13 = this.p;
        if (r13 == null) goto L47;
        NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> r14 = r13.getStateChangeEvent();
        if (r14 == null) goto L47;
        StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r15 = (StateMachine.c.b) r14.getValue();
    L48:
        yq(r15);
        if (isAnchor() == true) goto L59;
        IMiddlewareUserService r16 = jc1.k.f(IMiddlewareUserService.class);
        if (r16 == null) goto L59;
        com.bytedance.android.livesdk.user.e r17 = r16.user();
        if (r17 == null) goto L59;
        Observable r18 = r17.u();
        if (r18 == null) goto L59;
        Disposable r19 = r18.subscribe(new e(this));
        if (r19 == null) goto L59;
        RxUtilKt.c(r19, this.n);
    L59:
        Observable r20 = this.q.getKtvAddDressVersion().a();
        if (r20 == null) goto L64;
        Disposable r21 = r20.subscribe(new f(this));
        if (r21 == null) goto L64;
        RxUtilKt.c(r21, this.n);
    L64:
        xq();
        if (vm2.h.p() == true) goto L67;
        return;
    L67:
        if ((this.q.getBizLcMager().a instanceof tb0.c.b) == true) goto L71;
        Aq(false);
        return;
    L71:
        return;
    L47:
        r15 = null;
        goto L48
    L32:
        if (KtvUtilsKt.d() == false) goto L37;
        goto L33
    }

    public final void xq() {
        if (zq() == false) goto L9;
        View r0 = this.f;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L7:
        if (r0 == null) goto L14;
        r0.setVisibility(0);
    L14:
        Eq(com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(this.q));
        return;
    L9:
        View r1 = this.f;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L12:
        if (r1 == null) goto L14;
        r1.setVisibility(8);
        goto L14
    }

    public final void Aq(boolean r3) {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOrderSongBtn");
    L5:
        if (r0 == null) goto L11;
        if (r3 == false) goto L8;
        int r1 = 0;
    L9:
        r0.setVisibility(r1);
        goto L11
    L8:
        r1 = 8;
    L11:
        if (r3 == false) goto L23;
        View r4 = this.f;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L16:
        if (r4 == null) goto L18;
        r4.setAlpha(1.0f);
    L18:
        TextView r5 = this.e;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L21:
        if (r5 == null) goto L35;
        r5.setAlpha(1.0f);
        return;
    L35:
        return;
    L23:
        View r6 = this.f;
        if (r6 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mKtvDressYellowDot");
    L27:
        if (r6 == null) goto L29;
        r6.setAlpha(0.0f);
    L29:
        TextView r7 = this.e;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L32:
        if (r7 == null) goto L37;
        r7.setAlpha(0.0f);
        return;
    }

    public final void Bq(boolean r6) {
        KtvContext.Companion.getClass();
        boolean r0 = KtvContext.a.g().isCurrentUserIsSinger();
        if (r6 == false) goto L8;
        KtvMvSingerInfoView r3 = this.c;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L7:
        r3.setSingingInfoVisibility(false);
    L13:
        if (r0 == false) goto L54;
        if (r6 == false) goto L30;
        ImageView r7 = this.i;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L19:
        if (r7 == null) goto L21;
        r7.setVisibility(8);
    L21:
        ImageView r8 = this.j;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerNextBtn");
    L24:
        if (r8 == null) goto L26;
        r8.setVisibility(8);
    L26:
        ImageView r9 = this.h;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L29:
        r9.setVisibility(8);
        return;
    L30:
        ImageView r10 = this.i;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L33:
        if (r10 == null) goto L35;
        r10.setVisibility(0);
    L35:
        ImageView r11 = this.j;
        if (r11 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerNextBtn");
    L38:
        if (r11 == null) goto L41;
        r11.setVisibility(0);
    L41:
        if (isAnchor() == false) goto L43;
    L49:
        ImageView r12 = this.h;
        if (r12 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L52:
        r12.setVisibility(8);
        return;
    L43:
        if (KtvUtilsKt.d() == true) goto L49;
        ImageView r13 = this.h;
        if (r13 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L48:
        r13.setVisibility(0);
        return;
    L54:
        if (isAnchor() == false) goto L56;
    L57:
        if (r6 == false) goto L61;
        ImageView r14 = this.m;
        if (r14 == null) goto L64;
        r14.setVisibility(8);
    L64:
        ImageView r15 = this.h;
        if (r15 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L67:
        r15.setVisibility(8);
        return;
    L61:
        ImageView r16 = this.m;
        if (r16 == null) goto L64;
        r16.setVisibility(0);
        goto L64
    L56:
        if (KtvUtilsKt.d() == true) goto L57;
        return;
    L8:
        KtvMvSingerInfoView r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L11:
        r4.setSingingInfoVisibility(true);
        goto L13
    }

    public final void Cq(boolean r4) {
        if (r4 == false) goto L4;
        int r0 = 2131252108;
    L5:
        ImageView r1 = this.h;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L8:
        r1.setImageResource(r0);
        KtvRoomViewModel r2 = this.p;
        if (r2 == null) goto L13;
        KtvRoomLyricsStateMachineConfig.d r3 = r2.getCurState();
        if (r3 == null) goto L13;
        MusicPanel r5 = r3.b();
    L14:
        if (r4 == true) goto L22;
        if (r5 == null) goto L22;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r5) == true) goto L22;
        ImageView r6 = this.h;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L21:
        r6.setAlpha(0.5f);
        return;
    L22:
        ImageView r7 = this.h;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerOriginBtn");
    L25:
        r7.setAlpha(1.0f);
        return;
    L13:
        r5 = null;
        goto L14
    L4:
        r0 = 2131252107;
        goto L5
    }

    public final void Eq(int r4) {
        if (zq() == false) goto L9;
        TextView r5 = this.e;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L7:
        r5.setVisibility(8);
        return;
    L9:
        if (r4 <= 0) goto L20;
        String r0 = String.valueOf(r4);
        if (r4 <= 99) goto L13;
        r0 = "99+";
    L13:
        TextView r6 = this.e;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L16:
        r6.setVisibility(0);
        TextView r7 = this.e;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L19:
        r7.setText(r0);
        return;
    L20:
        TextView r8 = this.e;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L23:
        r8.setText(BDLocationException.ERROR_TIMEOUT);
        TextView r9 = this.e;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountTextView");
    L26:
        r9.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        MusicPanel r0 = null;
        if (r6 == null) goto L5;
        Integer r7 = Integer.valueOf(r6.getId());
    L6:
        boolean r2 = false;
        if (r7 != null) goto L10;
    L50:
        if (r7 != null) goto L53;
    L68:
        if (r7 != null) goto L71;
    L73:
        if (r7 != null) goto L76;
    L78:
        if (r7 != null) goto L81;
    L96:
        if (r7 != null) goto L99;
        return;
    L99:
        if (r7.intValue() != 2131376988) goto L115;
        wq(false);
        return;
    L115:
        return;
    L81:
        if (r7.intValue() != 2131376989) goto L96;
        KtvContext r8 = this.q;
        if (r8 == null) goto L89;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r9 = r8.getKtvCoreViewModel();
        if (r9 == null) goto L89;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r10 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r9.getValue();
        if (r10 == null) goto L89;
        r0 = r10.getCurState();
    L89:
        boolean r11 = r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        KtvContext r1 = this.q;
        if (r1 == null) goto L111;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r3 = r1.getKtvSingerViewModel();
        if (r3 == null) goto L112;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r4 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r3.getValue();
        if (r4 == null) goto L113;
        r4.togglePause(!r11);
        return;
    L113:
        return;
    L112:
        return;
    L111:
        return;
    L76:
        if (r7.intValue() != 2131377009) goto L78;
        this.q.getOpenKtvRoomDialogEvent().post(new od2.b("control", true, null));
        pd2.d.n.getClass();
        pd2.d.u("half_mv");
        return;
    L71:
        if (r7.intValue() != 2131377004) goto L73;
        wq(true);
        return;
    L53:
        if (r7.intValue() != 2131377008) goto L68;
        KtvContext r12 = this.q;
        if (r12 == null) goto L61;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r13 = r12.getKtvCoreViewModel();
        if (r13 == null) goto L61;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r14 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r13.getValue();
        if (r14 == null) goto L61;
        r0 = r14.getCurState();
    L61:
        boolean r15 = r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        KtvContext r5 = this.q;
        if (r5 == null) goto L105;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r16 = r5.getKtvSingerViewModel();
        if (r16 == null) goto L106;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r17 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r16.getValue();
        if (r17 == null) goto L107;
        r17.togglePause(!r15);
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L10:
        if (r7.intValue() != 2131377006) goto L50;
        KtvRoomViewModel r18 = this.p;
        if (r18 == null) goto L16;
        KtvRoomLyricsStateMachineConfig.d r19 = r18.getCurState();
        if (r19 == null) goto L16;
        r0 = r19.b();
    L16:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r20 = KSongTuningPanelHelperKt.d();
        if (r20 != null) goto L19;
    L21:
        boolean r21 = false;
    L23:
        if (KtvUtilsKt.h(r0) == false) goto L25;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131897379), 0);
        return;
    L25:
        if (r0 != null) goto L27;
    L32:
        KtvContext r22 = this.q;
        if (r22 == null) goto L39;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d> r23 = r22.getKtvSingerViewModel();
        if (r23 == null) goto L39;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r24 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) r23.getValue();
        if (r24 == null) goto L39;
        r24.toggleOrigin(!r21);
    L39:
        oe2.b r25 = (oe2.b) this.q.getKtvRoomProvider().getValue();
        if (r25 == null) goto L46;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r26 = KSongTuningPanelHelperKt.d();
        if (r26 == null) goto L44;
        boolean r27 = r26.R();
    L45:
        r25.f(r27);
        goto L46
    L44:
        r27 = false;
    L46:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r28 = KSongTuningPanelHelperKt.d();
        if (r28 == null) goto L49;
        r2 = r28.R();
    L49:
        Cq(r2);
        return;
    L27:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r0) == true) goto L32;
        if (r21 == false) goto L30;
        int r29 = 2131918458;
    L31:
        f2.b(r29, 0);
        return;
    L30:
        r29 = 2131918460;
        goto L31
    L19:
        if (r20.R() != true) goto L21;
        r21 = true;
        goto L23
    L5:
        r7 = null;
        goto L6
    }

    public final void wq(boolean r6) {
        Context r1 = (Activity) com.bytedance.android.livesdk.utils.d.a.get();
        if (r1 != null) goto L6;
        r1 = ((Widget) this).context;
    L6:
        com.bytedance.android.livesdk.widget.x0.b r0 = new com.bytedance.android.livesdk.widget.x0.b(r1, 0);
        r0.a.a = 7;
        r0.m(2131918451);
        r0.i(1, 2131918493, b.a);
        r0.i(0, 2131918494, new c(this, r6));
        com.bytedance.android.livesdk.widget.x0.d r7 = r0.a;
        r7.k = false;
        r7.l = false;
        r0.n();
    }

    public final void yq(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r15.c;
        boolean r2 = false;
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L7;
    L162:
        View r1 = this.g;
        if (r1 != null) goto L165;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L165:
        r1.setVisibility(8);
        View r3 = this.l;
        if (r3 == null) goto L168;
        r3.setVisibility(8);
    L168:
        ConstraintLayout r4 = this.c;
        if (r4 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L171:
        r4.setVisibility(8);
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L177;
        TextView r5 = this.d;
        if (r5 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTextView");
    L176:
        r5.setVisibility(0);
    L177:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r6 = this.r;
        if (r6 == null) goto L181;
        r6.c(r15);
        return;
    L181:
        return;
    L7:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.b) == true) goto L162;
        TextView r7 = this.d;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTextView");
    L12:
        r7.setVisibility(8);
        ConstraintLayout r8 = this.c;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L15:
        r8.setVisibility(0);
        KtvMvSingerInfoView r9 = this.c;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerInfoView");
    L18:
        r9.getClass();
        KtvRoomLyricsStateMachineConfig.d r10 = (KtvRoomLyricsStateMachineConfig.d) r15.c;
        KtvRoomLyricsStateMachineConfig.d r11 = (KtvRoomLyricsStateMachineConfig.d) r15.a;
        KtvMusic r12 = null;
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L50;
        r9.V5(0);
        KtvMusic.a r13 = KtvMusic.Companion;
        MusicPanel r14 = ((KtvRoomLyricsStateMachineConfig.d) r15.c).b();
        if (r14 == null) goto L23;
        KtvMusic r16 = r14.a;
    L24:
        r13.getClass();
        r9.U5(KtvMusic.a.a(r16) * ((long) 1000));
        MusicPanel r17 = ((KtvRoomLyricsStateMachineConfig.d) r15.c).b();
        if (r17 == null) goto L29;
        KtvMusic r18 = r17.a;
        if (r18 == null) goto L29;
        String r19 = r18.getMTitle();
    L30:
        r9.Z5(r19);
        if ((r11 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L46;
        OrderInfo r20 = ((KtvRoomLyricsStateMachineConfig.d.e) r11).b.a.getOrderInfo();
        if (r20 == null) goto L37;
        InteractiveSongUserInfo r21 = r20.getTopUser();
        if (r21 == null) goto L37;
        String r22 = r21.getIdString();
    L38:
        OrderInfo r23 = ((KtvRoomLyricsStateMachineConfig.d.e) r10).b.a.getOrderInfo();
        if (r23 == null) goto L43;
        InteractiveSongUserInfo r24 = r23.getTopUser();
        if (r24 == null) goto L43;
        String r25 = r24.getIdString();
    L45:
        if ((!Intrinsics.areEqual(r22, r25)) == true) goto L46;
    L75:
        int r26 = 2131252114;
        if (this.q.isCurrentUserIsSinger() == false) goto L110;
        View r27 = this.g;
        if (r27 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L80:
        r27.setVisibility(0);
        View r28 = this.l;
        if (r28 == null) goto L83;
        r28.setVisibility(8);
    L83:
        oe2.l.a r29 = oe2.l.f;
        MusicPanel r30 = r0.b();
        r29.getClass();
        int r31 = oe2.l.a.a();
        if (r30 == null) goto L86;
        MusicPanel.Track r32 = r30.h();
    L87:
        if (r32 == null) goto L97;
        int r33 = oe2.k.a[r32.ordinal()];
        if (r33 != 1) goto L92;
        if (r31 == 0) goto L97;
        if (r31 != 1) goto L97;
    L96:
        boolean r34 = true;
    L98:
        Cq(r34);
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L101;
        r26 = 2131252109;
    L101:
        ImageView r35 = this.i;
        if (r35 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L104:
        r35.setImageResource(r26);
        ImageView r36 = this.i;
        if (r36 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerStopBtn");
    L107:
        if (r36 == null) goto L151;
        r36.setAlpha(1.0f);
    L151:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.ui.a r37 = this.r;
        if (r37 != null) goto L154;
    L161:
        Bq(r2);
        goto L177
    L154:
        if (r37.d() != true) goto L161;
        MusicPanel r38 = r0.b();
        if (r38 == null) goto L159;
        r12 = r38.a;
    L159:
        if (ne2.a.f(r12) == false) goto L161;
        r2 = true;
        goto L161
    L92:
        if (r33 == 2) goto L96;
    L97:
        r34 = false;
        goto L98
    L86:
        r32 = null;
        goto L87
    L110:
        if (isAnchor() == false) goto L112;
    L136:
        View r39 = this.g;
        if (r39 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L139:
        r39.setVisibility(8);
        View r40 = this.l;
        if (r40 == null) goto L143;
        r40.setVisibility(0);
    L143:
        if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == false) goto L145;
        r26 = 2131252109;
    L145:
        ImageView r41 = this.m;
        if (r41 == null) goto L148;
        r41.setImageResource(r26);
    L148:
        ImageView r42 = this.m;
        if (r42 == null) goto L151;
        r42.setAlpha(1.0f);
        goto L151
    L112:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L136;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == true) goto L116;
    L126:
        boolean r43 = false;
    L127:
        ALogger.i("KtvMvControlAreaWidget", "supportAdminOperate, hasPermission: " + r43);
        if (r43 == true) goto L136;
        View r44 = this.g;
        if (r44 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerControlContainer");
    L133:
        r44.setVisibility(8);
        View r45 = this.l;
        if (r45 == null) goto L151;
        r45.setVisibility(8);
        goto L151
    L116:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue() == false) goto L126;
        com.bytedance.android.livesdk.user.e r46 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r46 == null) goto L126;
        UserAttr r47 = r46.q();
        if (r47 == null) goto L126;
        List r48 = r47.getAdminPrivileges();
        if (r48 == null) goto L126;
        LiveRoomPermission.D.getClass();
        if (r48.contains(Integer.valueOf(LiveRoomPermission.l.a)) != true) goto L126;
        r43 = true;
    L43:
        r25 = null;
    L37:
        r22 = null;
    L46:
        String r49 = ((KtvRoomLyricsStateMachineConfig.d.e) r10).b.g();
        if (r49 == null) goto L75;
        r9.Y5(r49);
    L29:
        r19 = null;
        goto L30
    L23:
        r16 = null;
        goto L24
    L50:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L71;
        if ((r11 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L67;
        OrderInfo r50 = ((KtvRoomLyricsStateMachineConfig.d.f) r11).b.a.getOrderInfo();
        if (r50 == null) goto L58;
        InteractiveSongUserInfo r51 = r50.getTopUser();
        if (r51 == null) goto L58;
        String r52 = r51.getIdString();
    L59:
        OrderInfo r53 = ((KtvRoomLyricsStateMachineConfig.d.f) r10).b.a.getOrderInfo();
        if (r53 == null) goto L64;
        InteractiveSongUserInfo r54 = r53.getTopUser();
        if (r54 == null) goto L64;
        String r55 = r54.getIdString();
    L66:
        if ((!Intrinsics.areEqual(r52, r55)) == false) goto L75;
    L64:
        r55 = null;
    L58:
        r52 = null;
    L67:
        String r56 = ((KtvRoomLyricsStateMachineConfig.d.f) r10).b.g();
        if (r56 == null) goto L75;
        r9.Y5(r56);
        goto L75
    L71:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.a) == false) goto L73;
    L74:
        r9.V5(0);
        goto L75
    L73:
        if ((r10 instanceof KtvRoomLyricsStateMachineConfig.d.b) == false) goto L75;
        goto L74
    }

    public KtvMvControlAreaWidget(KtvRoomViewModel r2, KtvContext r3, KtvRoomChallengeViewWrapper r4) {
        Intrinsics.checkNotNullParameter(r3, "ktvContext");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.n = new CompositeDisposable();
        this.o = (sb0.b) r3.getDataEntity().getValue();
    }
}
