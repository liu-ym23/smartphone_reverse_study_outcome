package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimTaskState;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.v;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.multianchor.model.MicDress;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.liveinteract.utils.o1;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.view.MicSeatSponsorView;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.KtvAudioVolumeAnimConfig;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.KtvRoomUserLabel;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.KtvLinkSeatListView;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.adapter.KtvRoomSeatListAdapter;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.diff.KtvRoomDiffCallback;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.viewholder.KtvRoomSeatEmptyViewHolder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.theme.KtvThemeControl;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomInteractViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvInteractElementWidget;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import fd2.k;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class KtvRoomViewManager implements qe2.a, com.bytedance.android.live.liveinteract.animation.e, tb0.a, com.bytedance.android.live.ktv.common.util.c {
    public static final /* synthetic */ int p1 = 0;
    public j22.c A;
    public Function2<? super Boolean, ? super Long, Unit> B;
    public final String C;
    public LinearLayoutManager D;
    public final LinearLayoutManager E;
    public final KtvRoomSeatManager F;
    public int G;
    public final KtvThemeControl H;
    public final Context H0;
    public final com.bytedance.android.livesdk.ktvimpl.ktvroom.theme.c I;
    public final View J;
    public ViewGroup K;
    public final CompositeDisposable L;
    public final ViewGroup L0;
    public List<tf0.e> M;
    public KtvInteractElementWidget N;
    public IVoiceLiveTheme O;
    public LinkPlayerInfo P;
    public final sb0.b P0;
    public MultiLinkGuestViewBinder.a Q;
    public Boolean R;
    public final g S;
    public com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c T;
    public final Pair<String, Long> U;
    public final f V;
    public final Function0<WidgetManager> V0;
    public int W;
    public final String X;
    public final KtvAudioVolumeAnimConfig Y;
    public final int[] Z;
    public boolean a;
    public final Lazy b;
    public final com.bytedance.android.live.pushstream.d b1;
    public final Disposable c;
    public final String d;
    public final ViewGroup e;
    public final Lazy f;
    public final Lazy g;
    public final KtvContext g1;
    public final Lazy h;
    public final GLSurfaceView h1;
    public final FrameLayout i;
    public k j;
    public Widget k;
    public final int[] k0;
    public final qe2.c k1;
    public KtvLinkSeatListView l;
    public HSImageView m;
    public AnchorPauseTipsView n;
    public HSImageView o;
    public View p;
    public final EPointF p0;
    public ViewGroup q;
    public SeatAnimationView r;
    public RecyclerView s;
    public RecyclerView t;
    public View u;
    public FrameLayout v;
    public TextView w;
    public ImageView x;
    public TextView y;
    public View z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewManager a;

        public a(com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            KtvRoomViewManager r4 = this.a;
            r4.getClass();
            ALogger.d("ktv_label", "refreshKtvStatusLabel");
            r4.J();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvRoomViewManager a;

        public b(com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            if (this.a.F == null) goto L15;
            int r3 = KtvRoomSeatManager.t;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r4 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
            if (r4 == null) goto L9;
            hg6.g r5 = r4.rtcManger();
            if (r5 == null) goto L9;
            ei6.a r6 = r5.V0();
        L10:
            if (r6 == null) goto L16;
            vi6.a r7 = r6.v();
            if (r7 == null) goto L17;
            r7.f();
            return;
        L17:
            return;
        L16:
            return;
        L9:
            r6 = null;
            goto L10
        }
    }

    public static final class c implements fd2.h {
        public final /* synthetic */ KtvRoomViewManager a;

        public c(com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a r1) {
            this.a = r1;
        }

        public final DataCenter a() {
            return this.a.P0.getDataCenter();
        }
    }

    public static final class d implements View.OnClickListener {
        public boolean a;
        public final a b;
        public final DataCenter c;
        public final LinkPlayerInfo d;
        public final String e;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a = true;     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (this.a == true) goto L7;
            return;
        L7:
            this.a = false;
            r5.postDelayed(this.b, 500);
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r6 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
            if (r6 != null) goto L10;
        L11:
            o r7 = o3.i(this.c, 0L);
            if (r7 == null) goto L20;
            m r8 = r7.getCleanMode();
            if (r8 == null) goto L20;
            if (((Number) r8.getValue()).intValue() != 2) goto L20;
            if (vm2.e.h() == false) goto L20;
            ALogger.w("ktv_seat_view_manager", "rejected anchor avatar click for pure clean mode");
            return;
        L20:
            DataCenter r9 = this.c;
            if (r9 == null) goto L23;
            r9.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
        L23:
            ILinkPlayerInfoBridge r10 = this.d;
            if (r10 != null) goto L32;
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r11 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
            if (r11 == null) goto L31;
            i<ILinkPlayerInfoBridge> r12 = r11.getLinkUserInfoCenter();
            if (r12 == null) goto L31;
            r10 = (ILinkPlayerInfoBridge) r12.getGuestInfo(this.e.toString(), "");
        L31:
            r10 = null;
        L32:
            if (r10 == null) goto L40;
            i0 r0 = TalkRoomLogUtils.a;
            String r1 = this.e.toString();
            if (je0.d.C(r10) == false) goto L36;
            String r2 = "oneself";
        L37:
            TalkRoomLogUtils.d(r1, r2, n.b(r10));
            return;
        L36:
            r2 = "anchor";
            goto L37
        L40:
            return;
        L10:
            if (r6.isEngineOn() == true) goto L20;
            goto L11
        }

        public d(DataCenter r2, LinkPlayerInfo r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "mOwnerUid");
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.a = true;
            this.b = new a(this);
        }
    }

    public static final class e {
    }

    public static final class f extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b {
        public final /* synthetic */ KtvRoomViewManager a;

        public f(com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.b, com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.e
        public final void a(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r6) {
            Intrinsics.checkNotNullParameter(r6, "valid");
            Object r7 = r6.c;
            KtvRoomLyricsStateMachineConfig.d r0 = (KtvRoomLyricsStateMachineConfig.d) r7;
            if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.e) == false) goto L5;
        L12:
            MusicPanel r8 = ((KtvRoomLyricsStateMachineConfig.d) r7).b();
            if (r8 == null) goto L17;
            KtvMusic r1 = r8.a;
            if (r1 == null) goto L17;
            long r2 = r1.getMId();
        L18:
            if (r8 == null) goto L21;
            String r9 = r8.g();
            if (r9 == null) goto L21;
        L23:
            if ((!Intrinsics.areEqual((String) this.a.U.getFirst(), r9)) == false) goto L25;
        L26:
            List<tf0.e> r10 = this.a.M;
            if (r10 == null) goto L33;
            ALogger.d("SpatialAudio_ktv", "updateSelfPosition case sing");
            this.a.N(r10);
            return;
        L33:
            return;
        L25:
            if (((Number) this.a.U.getSecond()).longValue() != r2) goto L26;
            return;
        L21:
            r9 = "";
        L17:
            r2 = 0;
            goto L18
        L5:
            if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.f) == true) goto L12;
            if ((r0 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d) == true) goto L12;
            List<tf0.e> r11 = this.a.M;
            if (r11 == null) goto L30;
            ALogger.d("SpatialAudio_ktv", "updateSelfPosition case song finished");
            this.a.N(r11);
            return;
        }
    }

    public static final class g implements com.bytedance.android.live.ktv.common.util.c {
        public Function2<? super Boolean, ? super Long, Unit> a;

        public final String getTypeName() {
            return "empty_seat";
        }

        public g() {
        }

        public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
            return this.a;
        }

        public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
            this.a = r1;
        }
    }

    static {
    }

    public void D() {
        throw null;
    }

    public void E() {
        throw null;
    }

    public final ArrayList Ka(int r1, float r2) {
        return null;
    }

    public final boolean Pf(int r1) {
        return true;
    }

    public final ArrayList dm(int r1) {
        return null;
    }

    @Override // qe2.a
    public final void j() {
    }

    public final boolean lo(int r1) {
        return true;
    }

    public final void onBizDestory() {
    }

    public final void onBizHide() {
    }

    public final void onBizShow() {
    }

    public final boolean si() {
        return true;
    }

    public final int x() {
        int[] r1 = new int[2];
        RecyclerView r2 = this.s;
        if (r2 == null) goto L5;
        r2.getLocationOnScreen(r1);
    L5:
        int r3 = r1[1];
        RecyclerView r4 = this.s;
        if (r4 == null) goto L8;
        int r5 = r4.getHeight();
    L10:
        return r3 + (r5 / 2);
    L8:
        r5 = 0;
        goto L10
    }

    public void C() {
        KtvLinkSeatListView r0 = (KtvLinkSeatListView) this.L0.findViewById(2131377071);
        this.l = r0;
        if (r0 == null) goto L5;
        HSImageView r1 = (HSImageView) r0.findViewById(2131376859);
    L6:
        this.m = r1;
        if (r1 == null) goto L9;
        r1.setImportantForAccessibility(2);
    L9:
        KtvLinkSeatListView r2 = this.l;
        if (r2 == null) goto L12;
        View r3 = r2.findViewById(2131376860);
    L13:
        this.z = r3;
        r3.a(r3, s1.B(2131918408));
        View r4 = this.z;
        if (r4 == null) goto L16;
        r4.setClickable(true);
    L16:
        KtvLinkSeatListView r5 = this.l;
        if (r5 == null) goto L19;
        AnchorPauseTipsView r6 = (AnchorPauseTipsView) r5.findViewById(2131377692);
    L20:
        this.n = r6;
        KtvLinkSeatListView r7 = this.l;
        if (r7 == null) goto L23;
        HSImageView r8 = (HSImageView) r7.findViewById(2131376862);
    L24:
        this.o = r8;
        KtvLinkSeatListView r9 = this.l;
        if (r9 == null) goto L27;
        View r10 = r9.findViewById(2131376866);
    L28:
        this.p = r10;
        KtvLinkSeatListView r11 = this.l;
        if (r11 == null) goto L31;
        ViewGroup r12 = (ViewGroup) r11.findViewById(2131376865);
    L32:
        this.q = r12;
        KtvLinkSeatListView r13 = this.l;
        if (r13 == null) goto L35;
        FrameLayout r14 = (FrameLayout) r13.findViewById(2131376864);
    L36:
        this.v = r14;
        KtvLinkSeatListView r15 = this.l;
        if (r15 == null) goto L39;
        TextView r16 = (TextView) r15.findViewById(2131376867);
    L40:
        this.w = r16;
        if (r16 == null) goto L43;
        r16.setImportantForAccessibility(2);
    L43:
        KtvLinkSeatListView r17 = this.l;
        if (r17 == null) goto L46;
        ImageView r18 = (ImageView) r17.findViewById(2131376863);
    L47:
        this.x = r18;
        KtvLinkSeatListView r19 = this.l;
        if (r19 == null) goto L50;
        TextView r20 = (TextView) r19.findViewById(2131377056);
    L51:
        this.y = r20;
        View r21 = this.r;
        if (r21 == null) goto L57;
        ViewGroup r22 = this.q;
        if (r22 == null) goto L68;
        if (r22.indexOfChild(r21) == (-1)) goto L57;
    L68:
        if (((Boolean) vm2.h.G2.getValue(null, vm2.h.a[187(0xbb, float:2.62E-43)])).booleanValue() == false) goto L72;
        HSImageView r23 = this.m;
        if (r23 == null) goto L75;
        r23.setOnClickListener(new d(this.P0.getDataCenter(), s(), this.d));
    L75:
        KtvLinkSeatListView r24 = this.l;
        if (r24 == null) goto L78;
        View r25 = r24.findViewById(2131369197);
    L79:
        this.u = r25;
        KtvLinkSeatListView r26 = this.l;
        if (r26 == null) goto L82;
        RecyclerView r27 = (RecyclerView) r26.findViewById(2131376967);
    L83:
        this.t = r27;
        if (r27 == null) goto L86;
        r27.setItemAnimator(null);
    L86:
        RecyclerView r28 = this.t;
        if (r28 == null) goto L89;
        r28.setLayoutManager(this.E);
    L89:
        KtvLinkSeatListView r29 = this.l;
        if (r29 == null) goto L92;
        RecyclerView r30 = (RecyclerView) r29.findViewById(2131377068);
    L93:
        this.s = r30;
        if (r30 == null) goto L96;
        int r31 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.e;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.f.a.a(r30, new KtvRoomViewManager$initKtvView$1(this));
    L96:
        RecyclerView r32 = this.s;
        if (r32 == null) goto L99;
        r32.setItemAnimator(null);
    L99:
        LinearLayoutManager r33 = new LinearLayoutManager(this.H0, 0, false);
        this.D = r33;
        RecyclerView r34 = this.s;
        if (r34 == null) goto L102;
        r34.setLayoutManager(r33);
    L102:
        RecyclerView r35 = this.s;
        if (r35 == null) goto L105;
        r35.addOnScrollListener(new KtvRoomViewManager$initKtvView$2());
    L105:
        AnchorPauseTipsView r36 = this.n;
        if (r36 == null) goto L108;
        r36.R5();
        AnchorPauseTipsView.U5(r36, 6.0f);
        r2.a(r36, r36.getLayoutParams().width / 2);
    L108:
        this.A = new j22.c(this.o);
        return;
    L92:
        r30 = null;
        goto L93
    L82:
        r27 = null;
        goto L83
    L78:
        r25 = null;
        goto L79
    L72:
        HSImageView r37 = this.m;
        if (r37 == null) goto L75;
        r37.setOnClickListener(x0.a(new KtvRoomViewManager$initAnchorSeatView$2(this)));
    L57:
        KtvRoomSeatManager r38 = this.F;
        if (r38 == null) goto L65;
        View r39 = r38.d;
        if (r39 == null) goto L65;
        ViewGroup.LayoutParams r40 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup r41 = this.q;
        if (r41 == null) goto L64;
        r41.addView(r39, r40);
    L64:
        Unit r42 = Unit.INSTANCE;
    L66:
        this.r = r39;
    L65:
        r39 = null;
        goto L66
    L50:
        r20 = null;
        goto L51
    L46:
        r18 = null;
        goto L47
    L39:
        r16 = null;
        goto L40
    L35:
        r14 = null;
        goto L36
    L31:
        r12 = null;
        goto L32
    L27:
        r10 = null;
        goto L28
    L23:
        r8 = null;
        goto L24
    L19:
        r6 = null;
        goto L20
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void J() {
        IKtvService r0 = jc1.k.f(IKtvService.class);
        CharSequence r1 = null;
        if (r0 == null) goto L5;
        KtvRoomUserLabel r2 = r0.getUserKtvRoomLabel(this.d.toString());
    L6:
        ALogger.d("ktv_label", "anchor label = " + r2);
        if (r2 == null) goto L15;
        int r3 = com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.c.a[r2.ordinal()];
        if (r3 != 1) goto L12;
        FrameLayout r4 = this.v;
        if (r4 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r4);
    L67:
        ImageView r5 = this.x;
        if (r5 == null) goto L70;
        UtilityKotlinExtentionsKt.t(r5);
    L70:
        TextView r6 = this.w;
        if (r6 == null) goto L73;
        UtilityKotlinExtentionsKt.w(r6);
    L73:
        String r7 = s1.B(2131919495);
        if (r7 == null) goto L84;
        TextView r8 = this.w;
        if (r8 == null) goto L78;
        CharSequence r9 = r8.getText();
    L80:
        if ((true ^ Intrinsics.areEqual(r9, r7)) == false) goto L84;
        TextView r10 = this.w;
        if (r10 == null) goto L84;
        r10.setText(r7);
        goto L84
    L78:
        r9 = null;
    L84:
        TextView r11 = this.y;
        if (r11 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r11);
    L87:
        TextView r12 = this.w;
        if (r12 != null) goto L90;
        return;
    L90:
        if (r12.getVisibility() != 0) goto L97;
        View r13 = this.z;
        StringBuilder r14 = new StringBuilder();
        r14.append(s1.B(2131918408));
        TextView r15 = this.w;
        if (r15 == null) goto L94;
        r1 = r15.getText();
    L94:
        r14.append(r1);
        r3.a(r13, r14.toString());
        return;
    L97:
        return;
    L12:
        if (r3 == 2) goto L47;
        if (r3 != 3) goto L15;
        if (A() == false) goto L31;
        FrameLayout r16 = this.v;
        if (r16 == null) goto L30;
        UtilityKotlinExtentionsKt.t(r16);
    L30:
        M();
        goto L87
    L31:
        FrameLayout r17 = this.v;
        if (r17 == null) goto L34;
        UtilityKotlinExtentionsKt.w(r17);
    L34:
        ImageView r18 = this.x;
        if (r18 == null) goto L37;
        UtilityKotlinExtentionsKt.t(r18);
    L37:
        TextView r19 = this.w;
        if (r19 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r19);
    L40:
        TextView r20 = this.w;
        if (r20 == null) goto L43;
        r20.setText(s1.B(2131919494));
    L43:
        TextView r21 = this.y;
        if (r21 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r21);
        goto L87
    L47:
        if (A() == false) goto L52;
        FrameLayout r22 = this.v;
        if (r22 == null) goto L51;
        UtilityKotlinExtentionsKt.t(r22);
    L51:
        M();
        goto L87
    L52:
        FrameLayout r23 = this.v;
        if (r23 == null) goto L55;
        UtilityKotlinExtentionsKt.w(r23);
    L55:
        ImageView r24 = this.x;
        if (r24 == null) goto L58;
        UtilityKotlinExtentionsKt.w(r24);
    L58:
        TextView r25 = this.w;
        if (r25 == null) goto L61;
        UtilityKotlinExtentionsKt.t(r25);
    L61:
        TextView r26 = this.y;
        if (r26 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r26);
    L15:
        String r27 = s1.B(2131919493);
        TextView r28 = this.w;
        if (r28 == null) goto L18;
        CharSequence r29 = r28.getText();
    L20:
        if (TextUtils.equals(r27, r29) == true) goto L87;
        FrameLayout r30 = this.v;
        if (r30 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r30);
    L24:
        M();
        goto L87
    L18:
        r29 = null;
        goto L20
    L5:
        r2 = null;
        goto L6
    }

    public final void M() {
        IKtvService r0 = jc1.k.f(IKtvService.class);
        py.k r1 = null;
        if (r0 == null) goto L5;
        KtvRoomUserLabel r2 = r0.getUserKtvRoomLabel(this.d.toString());
    L7:
        if (r2 != KtvRoomUserLabel.SINGER) goto L12;
        TextView r3 = this.y;
        if (r3 == null) goto L85;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L85:
        return;
    L12:
        LinkPlayerInfo r4 = s();
        if (r4 == null) goto L79;
        MicPosTagInfo r5 = r4.micPosTagInfo;
        if (r5 == null) goto L79;
        if (r5.getTagType() <= 0) goto L74;
        String r6 = r5.getPositionTagName();
        if (r6 == null) goto L74;
        if (r6.length() <= 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 != true) goto L74;
        TextView r8 = this.y;
        if (r8 != null) goto L28;
    L29:
        Long r9 = KtvLoggerHelper.a;
        Intrinsics.checkNotNullParameter("seat", "showPageName");
        Intrinsics.checkNotNullParameter(r5, "tagInfo");
        o r10 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r10 == null) goto L34;
        m r11 = r10.getRoom();
        if (r11 == null) goto L34;
        IRoom r12 = (IRoom) r11.getValue();
    L35:
        LinkedHashMap r13 = new LinkedHashMap();
        String r14 = BDLocationException.ERROR_TIMEOUT;
        if (r12 == null) goto L39;
        String r15 = String.valueOf(r12.getId());
        if (r15 == null) goto L39;
    L40:
        r13.put("room_id", r15);
        if (r12 == null) goto L46;
        String r16 = r12.getOwnerUserIdString();
        if (r16 == null) goto L46;
        r14 = r16;
    L46:
        r13.put("anchor_id", r14);
        KtvLoggerHelper.A(r13);
        if (r12 != null) goto L49;
    L51:
        String r17 = "video_live";
    L52:
        r13.put("live_type", r17);
        r13.put("user_type", KtvLoggerHelper.I());
        r13.put("show_page_name", "seat");
        r13.put("tag_type", String.valueOf(r5.getTagTypeId()));
        r13.put("resource_name", String.valueOf(r5.getPositionTagName()));
        r13.put("resource_type", "ksong");
        j0.l().sendLog("livesdk_connection_audience_tag_show", r13, new Object[]{IRoom.class});
    L53:
        TextView r18 = this.y;
        if (r18 == null) goto L56;
        UtilityKotlinExtentionsKt.w(r18);
    L56:
        TextView r19 = this.y;
        if (r19 == null) goto L59;
        r19.setVisibility(0);
    L59:
        if (r19 == null) goto L83;
        r19.setText(r5.getPositionTagName());
    L83:
        int r20 = Color.parseColor(r5.getTextColor());     // Catch: Exception -> L65
        if (r19 == null) goto L67;
        r19.setTextColor(r20);     // Catch: Exception -> L65
    L67:
        if (r5.getBgColorImg() == null) goto L73;
        py.k r21 = r5.getBgColorImg();
        if ((r21 instanceof py.k) == false) goto L72;
        r1 = r21;
    L72:
        KtvUtilsKt.i(r19, r1);
    L73:
        py.k r22 = Unit.INSTANCE;
    L78:
        if (r22 == null) goto L79;
        return;
    L65:
        ALogger.i("ktv_seat_view_manager", "text color parse error: " + r5.getTextColor());
        goto L67
    L49:
        if (r12.isLiveTypeAudio() != true) goto L51;
        r17 = "voice_live";
    L39:
        r15 = BDLocationException.ERROR_TIMEOUT;
    L34:
        r12 = null;
        goto L35
    L28:
        if (r8.getVisibility() == 0) goto L53;
    L23:
        r7 = false;
    L74:
        TextView r23 = this.y;
        if (r23 == null) goto L77;
        UtilityKotlinExtentionsKt.t(r23);
        r1 = Unit.INSTANCE;
    L77:
        r22 = r1;
    L79:
        TextView r24 = this.y;
        if (r24 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r24);
        Unit r25 = Unit.INSTANCE;
        return;
    L87:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // qe2.a
    public final void b() {
        List<tf0.e> r0 = this.M;
        if (r0 == null) goto L6;
        N(r0);
        return;
    }

    @Override // qe2.a
    public final void clear() {
        KtvThemeControl r0 = this.H;
        if (r0 == null) goto L5;
        r0.b.dispose();
        r0.b = new CompositeDisposable();
        r0.e.removeCallbacks(r0.c);
    L5:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r1 = this.T;
        if (r1 == null) goto L8;
        r1.unregisterKtvCoreListener(this.V);
    L8:
        this.L.clear();
    }

    @Override // qe2.a
    public final int e() {
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L19;
        RecyclerView r2 = this.s;
        KtvRoomSeatListAdapter r1 = r0.e;
        int r3 = 0;
        if (r1 == null) goto L7;
        int r4 = r1.getItemCount();
    L8:
        if (r4 <= 0) goto L24;
        if (r4 < 0) goto L22;
    L11:
        if (r2 == null) goto L13;
        RecyclerView.ViewHolder r5 = r2.findViewHolderForAdapterPosition(r3);
    L15:
        if ((r5 instanceof KtvRoomSeatEmptyViewHolder) == true) goto L23;
        if (r3 == r4) goto L25;
        r3 = r3 + 1;
        goto L11
    L25:
        return -1;
    L23:
        return r3;
    L13:
        r5 = null;
        goto L15
    L22:
        return -1;
    L24:
        return -1;
    L7:
        r4 = 0;
        goto L8
    L19:
        return -1;
    }

    @Override // qe2.a
    public final void end() {
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L16;
        SeatAnimEngineWrapper r1 = r0.b;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        if (r0.c == null) goto L13;
        pj0.b r2 = ThemedCompetitionContext.Companion.c();
        if (r2 == null) goto L13;
        r2.ee(null);
    L13:
        if (r0.k.isDisposed() == true) goto L17;
        r0.k.dispose();
        return;
    L17:
        return;
    }

    @Override // qe2.a
    public final void f() {
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L11;
        SeatAnimEngineWrapper r1 = r0.b;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        DataCenter r2 = r0.r.a();
        if (r2 == null) goto L12;
        SeatAnimEngineWrapper r3 = new SeatAnimEngineWrapper(9, r2, r0.q, r0.s);
        r0.b = r3;
        r3.a();
        return;
    L12:
        return;
    }

    @Override // qe2.a
    public final List<s0> getHeadPointList() {
        RecyclerView r1 = this.t;
        Integer r2 = null;
        if (r1 == null) goto L5;
        RecyclerView.Adapter r3 = r1.getAdapter();
    L6:
        RecyclerView r4 = this.s;
        if (r4 == null) goto L9;
        RecyclerView.Adapter r5 = r4.getAdapter();
    L11:
        if (r3 == null) goto L13;
        int r6 = r3.getItemCount();
    L14:
        if (r5 == null) goto L16;
        int r7 = r5.getItemCount();
    L17:
        ArrayList r8 = new ArrayList();
        int r9 = (r6 + 1) + r7;
        int r10 = 0;
    L18:
        if (r10 >= r9) goto L51;
        EPointF r11 = Kl(0, r10);
        int r12 = s1.f(44);
        float r13 = ((PointF) r11).x;
        float r14 = ((PointF) r11).y;
        if (r10 != 0) goto L26;
        LinkPlayerInfo r15 = s();
        if (r15 == null) goto L48;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L48;
        String r17 = r16.getIdString();
    L47:
        String r18 = r17;
    L49:
        r8.add(new s0(r13, r14, r12, r12, 0.0f, r18, Boolean.TRUE, 31232));
        r10 = r10 + 1;
    L48:
        r18 = null;
        goto L49
    L26:
        List<tf0.e> r19 = this.M;
        if (r19 == null) goto L29;
        int r20 = r19.size();
    L30:
        if (r10 > r20) goto L48;
        List<tf0.e> r21 = this.M;
        if (r21 == null) goto L34;
        tf0.e r22 = (tf0.e) ListProtector.get(r21, r10 - 1);
    L36:
        if ((r22 instanceof MultiLinkGuestViewBinder.a) == true) goto L38;
        r22 = null;
    L38:
        MultiLinkGuestViewBinder.a r23 = (MultiLinkGuestViewBinder.a) r22;
        if (r23 == null) goto L48;
        ch0.e r24 = r23.k;
        if (r24 == null) goto L48;
        ILinkPlayerInfoBridge r25 = r24.a;
        if (r25 == null) goto L48;
        IBaseUser r26 = r25.getUser();
        if (r26 == null) goto L48;
        r17 = r26.getIdString();
        goto L47
    L34:
        r22 = null;
        goto L36
    L29:
        r20 = 0;
        goto L30
    L51:
        if (r8.size() > 0) goto L108;
        KtvRoomSeatManager r27 = this.F;
        if (r27 == null) goto L109;
        HSImageView r28 = this.m;
        LinkPlayerInfo r29 = s();
        if (r29 == null) goto L60;
        IBaseUser r30 = r29.getUser();
        if (r30 == null) goto L60;
        String r31 = r30.getIdString();
    L61:
        ArrayList r110 = new ArrayList();
        if (r28 == null) goto L64;
        int r32 = dd0.a.a;
        r110.add(dd0.a.e(r28, null, String.valueOf(r31), null, false, null, null, null, 4088));
    L64:
        int r33 = dd0.a.a;
        KtvRoomSeatListAdapter r34 = r27.f;
        if (r34 == null) goto L67;
        Integer r35 = Integer.valueOf(r34.getItemCount());
    L68:
        hg0.d r36 = r27.g;
        KtvRoomSeatListAdapter r37 = r27.e;
        if (r37 == null) goto L71;
        r2 = Integer.valueOf(r37.getItemCount());
    L71:
        hg0.d r38 = r27.h;
        ArrayList r39 = new ArrayList();
        if (r35 == null) goto L85;
        if (r36 == null) goto L85;
        int r40 = r35.intValue();
        int r41 = 0;
    L75:
        if (r41 >= r40) goto L85;
        bd0.c r42 = r36.a(r41);
        if (r42 == null) goto L84;
        View r111 = r42.a;
        if (r111 == null) goto L84;
        View r43 = r42.b;
        String r112 = r42.c;
        String r113 = r42.g;
        if (r113 != null) goto L83;
        r113 = "";
    L83:
        r39.add(dd0.a.e(r111, r43, r112, r113, r42.h, r36.a, r42.i, r42.j, 3840));
    L84:
        r41 = r41 + 1;
    L85:
        if (r2 == null) goto L95;
        if (r38 == null) goto L95;
        int r44 = r2.intValue();
        int r45 = 0;
    L88:
        if (r45 >= r44) goto L95;
        bd0.c r46 = r38.a(r45);
        if (r46 == null) goto L94;
        View r47 = r46.a;
        if (r47 == null) goto L94;
        r39.add(dd0.a.a(r46, r47, r38.a, false, 1.0f));
    L94:
        r45 = r45 + 1;
    L95:
        r110.addAll(r39);
        return r110;
    L67:
        r35 = null;
    L60:
        r31 = null;
        goto L61
    L109:
        return null;
    L108:
        return r8;
    L16:
        r7 = 0;
        goto L17
    L13:
        r6 = 0;
        goto L14
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final q50.b jq() {
        GLSurfaceView r2 = this.h1;
        if (r2 == null) goto L5;
        n50.a r3 = k50.e.a(r2);
    L7:
        return new q50.b(new q50.a(r2, r3), 5);
    L5:
        r3 = null;
        goto L7
    }

    public void onBizEnterRoom() {
        jc1.k.n(IInteractService.class).addBusinessDegradeStrategy((com.bytedance.android.livesdk.a) this.b.getValue());
    }

    @Override // qe2.a
    public final void onResume() {
        KtvInteractElementWidget r0 = this.N;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    @Override // qe2.a
    public final void p() {
        this.L0.setVisibility(8);
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        tf0.h r1 = r0.getInteractAnimationService();
        if (r1 == null) goto L7;
        r1.b(2);
    L7:
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 == null) goto L12;
        tf0.h r3 = r2.getInteractAnimationService();
        if (r3 == null) goto L12;
        r3.b(1);
    L12:
        Widget r4 = this.k;
        if (r4 == null) goto L21;
        Widget.WidgetCallback r5 = r4.widgetCallback;
        if (r5 == null) goto L18;
        WidgetManager r6 = r5.getWidgetManager();
        if (r6 == null) goto L18;
    L19:
        if (r6 == null) goto L21;
        r6.unload(r4);
    L18:
        r6 = z();
    L21:
        KtvInteractElementWidget r7 = this.N;
        if (r7 == null) goto L30;
        Widget.WidgetCallback r8 = ((Widget) r7).widgetCallback;
        if (r8 == null) goto L27;
        WidgetManager r9 = r8.getWidgetManager();
        if (r9 == null) goto L27;
    L28:
        if (r9 == null) goto L30;
        r9.unload(r7);
    L27:
        r9 = z();
    L30:
        Object r10 = null;
        this.N = null;
        ViewGroup r11 = this.q;
        if (r11 == null) goto L33;
        r11.removeAllViews();
    L33:
        this.a = false;
        this.j = null;
        this.k = null;
        ViewGroup r12 = this.K;
        if (r12 == null) goto L49;
        int r13 = com.bytedance.android.livesdk.ktvapi.util.b.a;
        FrameLayout r14 = (FrameLayout) r12;
        Intrinsics.checkNotNullParameter(r14, "layout");
        Field r15 = r14.getClass().getDeclaredField("mMatchParentChildren");     // Catch: Exception -> L46
        if (r15 == null) goto L50;
        r15.setAccessible(true);     // Catch: Exception -> L46
        Object r16 = r15.get(r14);     // Catch: Exception -> L46
        if ((r16 instanceof ArrayList) == false) goto L42;
        r10 = r16;
    L42:
        ArrayList r17 = (ArrayList) r10;     // Catch: Exception -> L46
        if (r17 == null) goto L51;
        r17.clear();     // Catch: Exception -> L46
        return;
    L51:
        return;
    L50:
        return;
    L52:
        return;
    }

    public final boolean q() {
        Lazy r0 = KtvCommonSettingHelper.a;
        return KtvCommonSettingHelper.a(this.P0.b().getAnchorAbMap());
    }

    public final LinkPlayerInfo s() {
        if (this.P != null) goto L16;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r0 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        ILinkPlayerInfoBridge r1 = null;
        if (r0 == null) goto L9;
        i<ILinkPlayerInfoBridge> r2 = r0.getLinkUserInfoCenter();
        if (r2 == null) goto L9;
        ILinkPlayerInfoBridge r3 = r2.getGuestInfo(this.d, "");
    L11:
        if ((r3 instanceof LinkPlayerInfo) == false) goto L14;
        r1 = r3;
    L14:
        this.P = (LinkPlayerInfo) r1;
    L9:
        r3 = null;
    L16:
        return this.P;
    }

    public final EPointF w() {
        RecyclerView r1 = this.s;
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(this.k0);
    L5:
        int r2 = 0;
        int r3 = this.k0[0];
        RecyclerView r4 = this.s;
        if (r4 == null) goto L9;
        r2 = r4.getWidth();
    L9:
        return new EPointF((r3 + r2) + s1.f(34.0f), x(), 4);
    }

    public final WidgetManager z() {
        return (WidgetManager) this.V0.invoke();
    }

    public final boolean A() {
        LinkPlayerInfo r0 = s();
        if (r0 == null) goto L7;
        MicPosTagInfo r1 = r0.micPosTagInfo;
        if (r1 == null) goto L7;
        long r3 = r1.getTagTypeId();
    L9:
        if (r3 <= 0) goto L19;
        LinkPlayerInfo r2 = s();
        if (r2 == null) goto L15;
        MicPosTagInfo r4 = r2.micPosTagInfo;
        if (r4 == null) goto L15;
        String r5 = r4.getPositionTagName();
    L17:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        return true;
    L15:
        r5 = null;
    L19:
        return false;
    L7:
        r3 = 0;
        goto L9
    }

    public final void I() {
        LinkPlayerInfo r0 = s();
        if (r0 != null) goto L5;
    L8:
        HSImageView r1 = this.o;
        if (r1 == null) goto L11;
        r1.setController(null);
    L11:
        HSImageView r2 = this.o;
        if (r2 == null) goto L15;
        r2.setVisibility(4);
        return;
    L15:
        return;
    L5:
        if (r0.hasSpecialRadioEffect() != true) goto L8;
        r();
    }

    public final void r() {
        LinkPlayerInfo r0 = s();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasSpecialRadioEffect() == true) goto L8;
        return;
    L8:
        if (this.a == true) goto L32;
        String r1 = this.d;
        LinkPlayerInfo r3 = s();
        if (r3 == null) goto L17;
        MicDress r4 = r3.micDress;
        if (r4 == null) goto L17;
        MicDress.VoiceWave r5 = r4.voiceWave;
        if (r5 == null) goto L17;
        String r6 = r5.dressId;
        if (r6 == null) goto L17;
    L19:
        if (qe2.d.a() != 9) goto L32;
        HashMap r7 = new HashMap();
        Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r8 != null) goto L25;
    L30:
        r7.put("user_type", "user");
    L31:
        r7.put("to_user_id", r1.toString());
        r7.put("decorate_type", "voice_wave");
        r7.put("decorate_id", r6);
        j0.l().sendLog("livesdk_guest_head_decorate_show", r7, new Object[]{IRoom.class});
        this.a = true;
        goto L32
    L25:
        if (r8.intValue() != 2) goto L30;
        if (this.P0.isAnchor() == false) goto L29;
        r7.put("user_type", "anchor");
        goto L31
    L29:
        r7.put("user_type", "guest");
    L17:
        r6 = "";
    L32:
        HSImageView r2 = this.o;
        Animatable r9 = null;
        if (r2 == null) goto L35;
        DraweeController r10 = r2.getController();
    L36:
        if (r10 != null) goto L53;
        LinkPlayerInfo r11 = s();
        if (r11 == null) goto L48;
        MicDress r12 = r11.micDress;
        if (r12 == null) goto L48;
        MicDress.VoiceWave r13 = r12.voiceWave;
        if (r13 == null) goto L48;
        py.k r14 = r13.mediumImg;
        if (r14 == null) goto L48;
        List r15 = r14.getUrls();
        if (r15 == null) goto L48;
        String r16 = (String) CollectionsKt.getOrNull(r15, 0);
    L49:
        if (r16 == null) goto L53;
        AbstractDraweeController r17 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r16)).setAutoPlayAnimations(false).build();
        HSImageView r18 = this.o;
        if (r18 == null) goto L53;
        r18.setController(r17);
    L48:
        r16 = null;
    L53:
        HSImageView r19 = this.o;
        if (r19 == null) goto L58;
        DraweeController r20 = r19.getController();
        if (r20 == null) goto L58;
        Animatable r21 = r20.getAnimatable();
    L60:
        if ((r21 instanceof AnimatedDrawable2) == false) goto L63;
        r9 = r21;
    L63:
        AnimatedDrawable2 r22 = (AnimatedDrawable2) r9;
        if (r22 == null) goto L71;
        HSImageView r23 = this.o;
        if (r23 == null) goto L68;
        r23.setVisibility(0);
    L68:
        r22.stop();
        r22.jumpToFrame(1);
        return;
    L71:
        return;
    L58:
        r21 = null;
        goto L60
    L35:
        r10 = null;
        goto L36
    }

    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.B;
    }

    public final String getTypeName() {
        return this.C;
    }

    public final FrameLayout vj() {
        return this.i;
    }

    public static void L(KtvRoomViewManager r3) {
        r3.getClass();
        r3.K(s1.f(195.0f) + ((int) (s1.y() * 0.6933333f)));
    }

    public final void B(MultiLinkGuestViewBinder.a r3) {
        IVoiceLiveTheme r0 = ((tf0.e) r3).c;
        if (r0 == null) goto L10;
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r0) != true) goto L10;
        j22.c r4 = this.A;
        if (r4 == null) goto L21;
        r4.d = true;
        return;
    L21:
        return;
    L10:
        if (n.f(r3.k.a) == false) goto L14;
        j22.c r5 = this.A;
        if (r5 == null) goto L23;
        r5.d = true;
        return;
    L23:
        return;
    L14:
        HSImageView r6 = this.o;
        if (r6 == null) goto L17;
        r6.setController(null);
    L17:
        HSImageView r7 = this.o;
        if (r7 == null) goto L25;
        r7.setVisibility(4);
        return;
    }

    public final void Bn(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uidString");
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "uid");
        SeatAnimEngineWrapper r1 = r0.b;
        if (r1 == null) goto L7;
        SeatAnimManager r2 = r1.a;
    L8:
        if (r2 == null) goto L12;
        r2.g(r3.toString());
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean Ed(int r6) {
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L7;
        KtvRoomSeatListAdapter r1 = r0.f;
        if (r1 == null) goto L7;
        int r2 = r1.getItemCount();
    L9:
        if (r6 < 0) goto L13;
        if (r2 < r6) goto L13;
        return true;
    L13:
        View r3 = this.D.findViewByPosition((r6 - r2) - 1);
        if (r3 != null) goto L17;
        ALogger.e("interact_emoji", "cannot play seat emoji, " + r6 + " itemView is null");
        return false;
    L17:
        Rect r7 = new Rect();
        r3.getGlobalVisibleRect(r7);
        if (r7.width() >= s1.f(30.8f)) goto L21;
        ALogger.e("interact_emoji", "cannot play seat emoji, avatar not over 70% visible, rect " + r7);
        return false;
    L21:
        return true;
    L7:
        r2 = 0;
        goto L9
    }

    public final void K(int r7) {
        ConstraintLayout.LayoutParams r0 = this.J.getLayoutParams();
        if (s1.y() <= s1.w()) goto L5;
    L8:
        double r1 = s1.w();
        double r3 = 0.7d;
    L9:
        int r2 = (int) (r1 * r3);
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
        ALogger.i("updateMvLayout", "updateMvLayout:" + r7);
        if (q() == false) goto L16;
        r0.guideBegin = r2;
        this.W = r2;
        RecyclerView r4 = this.s;
        if (r4 == null) goto L17;
        r4.post(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.g(this));
    L17:
        this.J.setLayoutParams(r0);
        goto L18
    L16:
        r0.guideBegin = r7;
    L18:
        DataCenter r5 = this.P0.getDataCenter();
        if (r5 == null) goto L21;
        r5.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "ktv_video"));
    L21:
        InteractionWidgetsPosContext r6 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.P0.getDataCenter(), 0, 2);
        if (r6 == null) goto L31;
        m r8 = r6.getKtvSeatBottomPos();
        if (r8 != null) goto L26;
        return;
    L26:
        if (q() == false) goto L28;
        int r9 = r2 - s1.f(21.0f);
    L29:
        r8.setValue(Integer.valueOf(r9));
        return;
    L28:
        r9 = r7 - s1.f(21.0f);
        goto L29
    L31:
        return;
    L5:
        if (FoldScreenUtils.e() == true) goto L8;
        r1 = s1.w();
        r3 = 0.6d;
        goto L9
    }

    public final EPointF Mj(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        int r3 = zl(r2);
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return Kl(0, r3);
    }

    public final void N(List<tf0.e> r19) {
        Intrinsics.checkNotNullParameter(r19, "guestList");
        lj0.a r1 = jc1.k.n(IInteractService.class).getSpatialAudioService();
        if (r1.q3() == true) goto L5;
        return;
    L5:
        IMiddlewareUserService r3 = jc1.k.f(IMiddlewareUserService.class);
        if (r3 == null) goto L10;
        com.bytedance.android.livesdk.user.e r4 = r3.user();
        if (r4 == null) goto L10;
        IBaseUser r5 = r4.b();
    L12:
        if (this.F == null) goto L18;
        int r6 = KtvRoomSeatManager.t;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r7 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r7 == null) goto L18;
        hg6.g r8 = r7.rtcManger();
        if (r8 == null) goto L18;
        ei6.a r9 = r8.V0();
    L19:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r10 = this.T;
        if (r10 == null) goto L27;
        KtvRoomLyricsStateMachineConfig.d r11 = r10.getCurState();
        if (r11 == null) goto L27;
        MusicPanel r12 = r11.b();
        if (r12 == null) goto L27;
        String r13 = r12.g();
        if (r13 == null) goto L27;
    L28:
        IInteractService r14 = jc1.k.f(IInteractService.class);
        if (r14 == null) goto L33;
        wi0.a r15 = r14.getInteractiveSongService();
        if (r15 == null) goto L33;
        String r16 = r15.a();
    L34:
        if (r9 == null) goto L155;
        aj6.a r17 = new aj6.a(h.a(r1.c(9)), r1.a(9));
        ALogger.d("SpatialAudio_ktv", "updateSelfPosition " + r17.toString());
        SpatialAudioManager r18 = r9.m();
        if (r18 == null) goto L43;
        si6.b r110 = r9.b();
        if (r110 == null) goto L40;
        String r111 = r110.m();
    L41:
        r18.g(String.valueOf(r111), r17);
        goto L43
    L40:
        r111 = null;
    L43:
        if (this.P0.b().isAnchor() == true) goto L95;
        LinkPlayerInfo r20 = s();
        if (r20 == null) goto L50;
        IBaseUser r21 = r20.getUser();
        if (r21 == null) goto L50;
        String r22 = r21.getIdString();
        if (r22 == null) goto L50;
    L51:
        aj6.a r112 = new aj6.a(h.a(r1.b(9, zl(r22), r19.size(), null)), r1.a(9));
        LinkPlayerInfo r2 = s();
        if (r2 == null) goto L56;
        IBaseUser r23 = r2.getUser();
        if (r23 == null) goto L56;
        String r24 = r23.getIdString();
    L58:
        if (Intrinsics.areEqual(r24, r13) == false) goto L60;
    L80:
        StringBuilder r25 = new StringBuilder(" removeRemotePosition ");
        LinkPlayerInfo r26 = s();
        if (r26 == null) goto L83;
        String r27 = r26.getInteractId();
    L84:
        r25.append(r27);
        r25.append(" cause he is singing or anchor with nobody singing ");
        ALogger.d("SpatialAudio_ktv", r25.toString());
        SpatialAudioManager r28 = r9.m();
        if (r28 == null) goto L95;
        si6.b r29 = r9.b();
        if (r29 == null) goto L89;
        String r30 = r29.m();
    L90:
        String r31 = String.valueOf(r30);
        LinkPlayerInfo r32 = s();
        if (r32 == null) goto L93;
        String r33 = r32.getInteractId();
    L94:
        r28.e(r31, String.valueOf(r33));
        goto L95
    L93:
        r33 = null;
        goto L94
    L89:
        r30 = null;
        goto L90
    L83:
        r27 = null;
        goto L84
    L60:
        if (r13.length() != 0) goto L62;
        boolean r34 = true;
    L63:
        if (r34 == true) goto L80;
        StringBuilder r35 = new StringBuilder(" updateRemotePosition ");
        LinkPlayerInfo r36 = s();
        if (r36 == null) goto L68;
        String r37 = r36.getInteractId();
    L69:
        r35.append(r37);
        r35.append("  postion : ");
        r35.append(r112);
        ALogger.d("SpatialAudio_ktv", r35.toString());
        SpatialAudioManager r38 = r9.m();
        if (r38 == null) goto L95;
        si6.b r39 = r9.b();
        if (r39 == null) goto L74;
        String r40 = r39.m();
    L75:
        String r41 = String.valueOf(r40);
        LinkPlayerInfo r113 = s();
        if (r113 == null) goto L78;
        String r114 = r113.getInteractId();
    L79:
        r38.f(r41, String.valueOf(r114), r112);
        goto L95
    L78:
        r114 = null;
        goto L79
    L74:
        r40 = null;
        goto L75
    L68:
        r37 = null;
        goto L69
    L62:
        r34 = false;
    L56:
        r24 = null;
    L50:
        r22 = "";
    L95:
        Iterator<tf0.e> r42 = r19.iterator();
    L97:
        if (r42.hasNext() == false) goto L155;
        MultiLinkGuestViewBinder.a r43 = (tf0.e) r42.next();
        if ((r43 instanceof MultiLinkGuestViewBinder.a) == true) goto L101;
    L100:
        Iterator<tf0.e> r115 = r42;
        IBaseUser r116 = r5;
    L153:
        r42 = r115;
        r5 = r116;
        goto L97
    L101:
        ILinkPlayerInfoBridge r44 = r43.k.a;
        IBaseUser r45 = r44.getUser();
        if (r45 == null) goto L104;
        String r46 = r45.getIdString();
    L105:
        if (r46 == null) goto L100;
        IBaseUser r47 = r44.getUser();
        if (r47 == null) goto L109;
        String r48 = r47.getIdString();
    L110:
        if (r5 == null) goto L112;
        String r117 = r5.getIdString();
    L114:
        if (Intrinsics.areEqual(r48, r117) == true) goto L100;
        IBaseUser r49 = r44.getUser();
        if (r49 == null) goto L119;
        String r50 = r49.getIdString();
    L121:
        if (Intrinsics.areEqual(r50, r13) == true) goto L145;
        IBaseUser r51 = r44.getUser();
        if (r51 == null) goto L125;
        String r52 = r51.getIdString();
    L127:
        if (Intrinsics.areEqual(r52, r16) == true) goto L145;
        IBaseUser r53 = r44.getUser();
        if (r53 == null) goto L133;
        String r54 = r53.getIdString();
        if (r54 == null) goto L133;
    L134:
        r115 = r42;
        r116 = r5;
        aj6.a r118 = new aj6.a(h.a(r1.b(9, zl(r54), r19.size(), null)), r1.a(9));
        StringBuilder r55 = new StringBuilder(" updateRemotePosition ");
        String r56 = r44.getInteractId();
        if (r56 != null) goto L138;
        r56 = null;
    L138:
        r55.append(r56);
        r55.append("  postion : ");
        r55.append(r118);
        ALogger.d("SpatialAudio_ktv", r55.toString());
        SpatialAudioManager r57 = r9.m();
        if (r57 == null) goto L153;
        si6.b r58 = r9.b();
        if (r58 == null) goto L143;
        String r59 = r58.m();
    L144:
        r57.f(String.valueOf(r59), String.valueOf(r44.getInteractId()), r118);
        goto L153
    L143:
        r59 = null;
    L133:
        r54 = "";
        goto L134
    L125:
        r52 = null;
    L145:
        r115 = r42;
        r116 = r5;
        SpatialAudioManager r60 = r9.m();
        if (r60 == null) goto L152;
        si6.b r61 = r9.b();
        if (r61 == null) goto L150;
        String r62 = r61.m();
    L151:
        r60.e(String.valueOf(r62), String.valueOf(r44.getInteractId()));
        goto L152
    L150:
        r62 = null;
    L152:
        ALogger.d("SpatialAudio_ktv", " removeRemotePosition " + r44.getInteractId() + " cause he is singing ");
        goto L153
    L119:
        r50 = null;
        goto L121
    L112:
        r117 = null;
        goto L114
    L109:
        r48 = null;
        goto L110
    L104:
        r46 = null;
    L155:
        if (this.P0.b().isAnchor() == false) goto L166;
        if (r9 == null) goto L167;
        vi6.a r63 = r9.v();
        if (r63 == null) goto L168;
        r63.f();
        return;
    L168:
        return;
    L167:
        return;
    L166:
        return;
    L33:
        r16 = null;
    L27:
        r13 = "";
    L18:
        r9 = null;
    L10:
        r5 = null;
        goto L12
    }

    @Override // qe2.a
    public final int S0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "InteractId");
        KtvRoomSeatManager r1 = this.F;
        if (r1 == null) goto L40;
        Intrinsics.checkNotNullParameter(r10, "InteractId");
        DataCenter r0 = r1.r.a();
        String r2 = null;
        if (r0 == null) goto L7;
        ArrayList r3 = (ArrayList) r0.get("data_online_changed_list", new ArrayList());
    L8:
        if (r3 == null) goto L40;
        int r4 = r3.size();
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L49;
        LinkPlayerInfo r6 = (LinkPlayerInfo) ListProtector.get(r3, r5);
        if (r6 == null) goto L39;
        String r7 = r6.getInteractId();
        if (r7 == null) goto L39;
        if (r7.equals(r10) != true) goto L39;
        o r11 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r11 == null) goto L23;
        m r12 = r11.getRoom();
        if (r12 == null) goto L23;
        IRoom r13 = (IRoom) r12.getValue();
    L24:
        IBaseUser r8 = r6.getUser();
        if (r8 == null) goto L27;
        String r9 = r8.getIdString();
    L28:
        if (r13 == null) goto L31;
        r2 = r13.getOwnerUserIdString();
    L31:
        if (Intrinsics.areEqual(r9, r2) == true) goto L48;
        IBaseUser r14 = r6.getUser();
        if (r14 == null) goto L37;
        String r15 = r14.getIdString();
        if (r15 == null) goto L37;
    L47:
        return r1.a(r15);
    L37:
        r15 = "";
        goto L47
    L48:
        return 0;
    L27:
        r9 = null;
    L23:
        r13 = null;
    L39:
        r5 = r5 + 1;
        goto L11
    L49:
        return 0;
    L7:
        r3 = null;
    L40:
        return -1;
    }

    @Override // qe2.a
    public final void a(int r5) {
        if (((Boolean) vm2.h.H2.getValue(null, vm2.h.a[188(0xbc, float:2.63E-43)])).booleanValue() == false) goto L6;
        return;
    L6:
        if (this.G == r5) goto L20;
        this.G = r5;
        View r0 = this.p;
        if (r0 != null) goto L10;
    L18:
        I();
        return;
    L10:
        if (r0.getVisibility() != 8) goto L18;
        if (this.G <= 0) goto L15;
        G(r5, null);
        return;
    L15:
        j22.c r6 = this.A;
        if (r6 == null) goto L29;
        r6.d = true;
        return;
    L29:
        return;
    L20:
        LinkPlayerInfo r7 = s();
        if (r7 != null) goto L23;
        return;
    L23:
        if (r7.hasSpecialRadioEffect() != true) goto L32;
        HSImageView r8 = this.o;
        if (r8 == null) goto L33;
        r8.setVisibility(0);
        return;
    L33:
        return;
    }

    @Override // qe2.a
    public final void c(Function0<? extends IRenderView> r4) {
        Intrinsics.checkNotNullParameter(r4, "provider");
        ALogger.e("ttlive_link_ktv", "player from feed");
        if (this.F == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "provider");
        return;
    }

    @Override // qe2.a
    public final void d(boolean r4) {
        if (r4 == false) goto L5;
        int r5 = s1.j(2131168819);
    L6:
        ObjectAnimator.ofFloat(this.e, "translationY", new float[]{r5}).setDuration(300).start();
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // qe2.a
    public void h(boolean r17) {
        qe2.c r1 = this.k1;
        sb0.b r2 = this.P0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "dataEntityProxy");
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        int r6 = 0;
    L4:
        if (r6 > 7) goto L6;
        r3.add(qe2.c.a(r6));
        r6 = r6 + 1;
        goto L4
    L6:
        List<ch0.e> r5 = r1.c();
        IVoiceLiveTheme r7 = null;
        if (r5 == null) goto L25;
        Iterator<T> r8 = r5.iterator();
    L10:
        if (r8.hasNext() == false) goto L25;
        ch0.e r9 = (ch0.e) r8.next();
        if (r9 == null) goto L18;
        ILinkPlayerInfoBridge r10 = r9.a;
        if (r10 == null) goto L18;
        IBaseUser r11 = r10.getUser();
        if (r11 == null) goto L18;
        String r12 = r11.getIdString();
    L19:
        String r13 = r2.e().toString();
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        if ((!Intrinsics.areEqual(r12, r13)) == false) goto L10;
        r4.add(new MultiLinkGuestViewBinder.a(r9, null, 62));
    L18:
        r12 = null;
    L25:
        int r14 = r4.size();
        int r15 = 0;
    L26:
        if (r15 >= r14) goto L42;
        Object r16 = ListProtector.get(r4, r15);
        if (r16 == null) goto L41;
        MultiLinkGuestViewBinder.a r18 = (MultiLinkGuestViewBinder.a) r16;
        ch0.e r19 = r18.k;
        if (r19 == null) goto L34;
        ILinkPlayerInfoBridge r20 = r19.a;
        if (r20 == null) goto L34;
        IBaseUser r21 = r20.getUser();
    L35:
        if (r21 == null) goto L39;
        if (r15 >= r3.size()) goto L39;
        ListProtector.set(r3, r15, r18);
    L39:
        r15 = r15 + 1;
    L34:
        r21 = null;
        goto L35
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L42:
        this.M = r3;
        C();
        r();
        if (this.m == null) goto L45;
        a1.w(this.m, this.P0.b().c(null), s1.f(36.0f), s1.f(36.0f));
    L45:
        KtvRoomSeatManager r22 = this.F;
        if (r22 == null) goto L78;
        String r23 = this.d;
        Intrinsics.checkNotNullParameter(r23, "ownerUserIdString");
        SeatAnimationView r24 = r22.d;
        MicSeatScene r25 = MicSeatScene.KTV;
        int r26 = SeatAnimationView.t;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "micSeatScene");
        int r27 = SeatAnimationView.d(9, r25, true);
        String r28 = VerticalNitaInflate.Tag.SeatAnimationView.name();
        Context r110 = r24.getContext();
        SparseArray r111 = VerticalNitaInflate.a;
        View r29 = VerticalNitaInflate.a(r28 + 9, r27, r110, r24, true);
        r24.b = r29;
        if (r29 == null) goto L50;
        LinkSucAnimationView r30 = (LinkSucAnimationView) r29.findViewById(2131378017);
    L51:
        r24.d = r30;
        View r31 = r24.b;
        if (r31 == null) goto L54;
        DynamicEmojiView r32 = (DynamicEmojiView) r31.findViewById(2131370473);
    L55:
        r24.e = r32;
        View r33 = r24.b;
        if (r33 == null) goto L58;
        HSImageView r34 = (HSImageView) r33.findViewById(2131371535);
    L59:
        r24.f = r34;
        r24.l = r24.findViewById(2131377075);
        View r35 = r24.b;
        if (r35 == null) goto L62;
        HSImageView r36 = (HSImageView) r35.findViewById(2131374073);
    L63:
        r24.i = r36;
        View r37 = r24.b;
        if (r37 == null) goto L66;
        MicSeatSponsorView r38 = (MicSeatSponsorView) r37.findViewById(2131378753);
    L67:
        r24.j = r38;
        View r39 = r24.b;
        if (r39 == null) goto L70;
        HSImageView r40 = (HSImageView) r39.findViewById(2131388568);
    L71:
        r24.k = r40;
        v r41 = new v();
        r24.a = r41;
        Intrinsics.checkNotNull(r41);
        r41.b(r24.i, r24.j, r24.k, r24.d, r24.e, r24.f, r24.l);
        r24.e();
        SeatAnimEngineWrapper r42 = r22.b;
        if (r42 == null) goto L74;
        SeatAnimManager r43 = r42.a;
    L75:
        if (r43 == null) goto L77;
        r43.e(r23.toString(), r24);
    L77:
        r24.setEmojiCallback(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.b(r24, r22));
        goto L78
    L74:
        r43 = null;
        goto L75
    L70:
        r40 = null;
        goto L71
    L66:
        r38 = null;
        goto L67
    L62:
        r36 = null;
        goto L63
    L58:
        r34 = null;
        goto L59
    L54:
        r32 = null;
        goto L55
    L50:
        r30 = null;
    L78:
        J();
        qe2.c r44 = this.k1;
        List<tf0.e> r45 = this.M;
        r44.getClass();
        List r46 = qe2.c.b(r45);
        KtvRoomSeatManager r47 = this.F;
        if (r47 == null) goto L86;
        RecyclerView r48 = this.t;
        Intrinsics.checkNotNullParameter(r46, "hostList");
        r47.g = new hg0.d(r48);
        r47.f = new KtvRoomSeatListAdapter(r48, r46, KtvRoomSeatListAdapter.SeatListType.KTV_HOST, r47.b);
        VoiceLiveTheme r49 = r47.o;
        if (r49 == null) goto L83;
        Intrinsics.checkNotNullParameter(r49, "theme");
    L83:
        if (r48 == null) goto L86;
        r48.setAdapter(r47.f);
    L86:
        if ((!r46.isEmpty()) == false) goto L93;
        RecyclerView r50 = this.t;
        if (r50 == null) goto L90;
        r50.setVisibility(0);
    L90:
        View r51 = this.u;
        if (r51 == null) goto L99;
        com.bytedance.android.live.core.utils.a1.m(r51, s1.f(8.0f));
    L99:
        qe2.c r52 = this.k1;
        List<tf0.e> r53 = this.M;
        r52.getClass();
        List r54 = qe2.c.d(r53);
        KtvRoomSeatManager r55 = this.F;
        if (r55 == null) goto L121;
        RecyclerView r56 = this.s;
        boolean r57 = q();
        Intrinsics.checkNotNullParameter(r54, "normalGuestList");
        r55.h = new hg0.d(r56);
        if (r57 == false) goto L104;
        KtvRoomSeatListAdapter.SeatListType r58 = KtvRoomSeatListAdapter.SeatListType.OPUS_GUEST;
    L105:
        r55.e = new KtvRoomSeatListAdapter(r56, r54, r58, r55.b);
        VoiceLiveTheme r59 = r55.o;
        if (r59 == null) goto L108;
        Intrinsics.checkNotNullParameter(r59, "theme");
    L108:
        if (r56 == null) goto L110;
        r56.setAdapter(r55.e);
    L110:
        List<tf0.e> r60 = r55.l;
        if (r60 == null) goto L121;
        if ((!r60.isEmpty()) == true) goto L116;
        r60 = null;
    L116:
        if (r60 == null) goto L121;
        Intrinsics.checkNotNullParameter(r60, "normalGuestList");
        r55.l = r60;
        KtvRoomSeatListAdapter r61 = r55.e;
        if (r61 == null) goto L121;
        Intrinsics.checkNotNullParameter(r60, "newList");
        DiffUtil.DiffResult r62 = DiffUtil.calculateDiff(new KtvRoomDiffCallback(r61.c, r60), true);
        r61.c = r60;
        r62.dispatchUpdatesTo(r61);
        goto L121
    L104:
        r58 = KtvRoomSeatListAdapter.SeatListType.NORMAL_GUEST;
    L121:
        if (q() == true) goto L123;
        D();
    L137:
        KtvThemeControl r63 = this.H;
        if (r63 != null) goto L140;
    L159:
        this.L0.setVisibility(0);
        return;
    L140:
        if (vm2.d.q0().isOpenSmoothViewMock() == false) goto L146;
        if (r17 == false) goto L146;
        if (r63.a == true) goto L146;
        r63.f.setAlpha(0.0f);
        r63.e.setAlpha(0.0f);
        r63.f.postDelayed(new com.bytedance.android.livesdk.ktvimpl.ktvroom.theme.a(r63), vm2.d.q0().getKtvBgVisibleFallbackTime());
    L146:
        if (r63.a == false) goto L151;
        if (vm2.d.X().isAnchorEnable() == true) goto L159;
        r63.b();
        goto L159
    L151:
        if (vm2.d.X().isAudienceEnable() == false) goto L158;
        IInteractService r64 = jc1.k.f(IInteractService.class);
        if (r64 == null) goto L157;
        x00.a r65 = r64.getThemeManager(false, r63.g);
        if (r65 == null) goto L157;
        r7 = r65.q(1);
    L157:
        if (r7 != null) goto L159;
    L158:
        r63.b();
        goto L159
    L123:
        if (this.N != null) goto L137;
        this.N = new KtvInteractElementWidget(this.g1, this.P0);
        if (this.W <= 0) goto L129;
        RecyclerView r66 = this.s;
        if (r66 == null) goto L129;
        r66.post(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.g(this));
    L129:
        ViewGroup r67 = (ViewGroup) this.e.findViewById(2131371513);
        if (r67 == null) goto L135;
        WidgetManager r68 = z();
        if (r68 == null) goto L134;
        r68.load(r67, this.N, false);
    L134:
        UtilityKotlinExtentionsKt.w(r67);
    L135:
        L(this);
        goto L137
    L93:
        RecyclerView r69 = this.t;
        if (r69 == null) goto L96;
        r69.setVisibility(8);
    L96:
        View r70 = this.u;
        if (r70 == null) goto L99;
        com.bytedance.android.live.core.utils.a1.m(r70, s1.f(8.0f));
        goto L99
    }

    @Override // qe2.a
    public final void i(boolean r1) {
        if (r1 == false) goto L7;
        View r2 = this.p;
        if (r2 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r2);
    L6:
        I();
        return;
    L7:
        View r3 = this.p;
        if (r3 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    }

    @Override // qe2.a
    public final void l(tlc.d r3) {
        KtvInteractElementWidget r0 = this.N;
        if (r0 == null) goto L9;
        KtvRoomInteractViewModel r1 = r0.d;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("vm");
    L7:
        r1.onMessage(r3);
        return;
    }

    public final int qq(int r2) {
        if (r2 == 4) goto L6;
        return s1.j(2131168823);
    L6:
        return s1.f(50.0f);
    }

    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.B = r1;
    }

    public final EPointF t(View r4) {
        int[] r0 = new int[2];
        r4.getLocationOnScreen(r0);
        return new EPointF(r0[0] + (r4.getWidth() / 2.0f), x());
    }

    @Override // qe2.a
    public final void updateTalkState(Map<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r3, "talkStateMap");
        KtvRoomSeatManager r1 = this.F;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "talkStateMap");
        r1.d(r3, r1.f);
        r1.d(r3, r1.e);
        return;
    }

    public final boolean wc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uidString");
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "uid");
        SeatAnimEngineWrapper r1 = r0.b;
        if (r1 == null) goto L7;
        SeatAnimManager r2 = r1.a;
    L8:
        if (r2 == null) goto L12;
        if (r2.f(r3) != true) goto L12;
        return true;
    L7:
        r2 = null;
    L12:
        return false;
    }

    public final int zl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uidString");
        if (Intrinsics.areEqual(r2, this.d) == false) goto L6;
        return 0;
    L6:
        KtvRoomSeatManager r0 = this.F;
        if (r0 != null) goto L11;
        return -1;
    L11:
        return r0.a(r2);
    }

    public final EPointF C7(int r6, int r7) {
        PointF r0 = new EPointF();
        int r1 = 0;
        if (r6 != 0) goto L7;
        int[] r8 = new int[2];
        HSImageView r9 = this.m;
        if (r9 == null) goto L61;
        r9.getLocationOnScreen(r8);
        float r10 = r8[0];
        HSImageView r2 = this.m;
        Intrinsics.checkNotNull(r2);
        r0.x = r10 + (r2.getLayoutParams().width / 2.0f);
        float r11 = r8[1];
        HSImageView r12 = this.m;
        Intrinsics.checkNotNull(r12);
        r0.y = r11 + (r12.getLayoutParams().height / 2.0f);
    L61:
        ALogger.d("ktv_seat_view_manager", "getSeatStartPoint: " + r0.toString() + ' ');
        return r0;
    L7:
        KtvRoomSeatManager r3 = this.F;
        if (r3 == null) goto L13;
        KtvRoomSeatListAdapter r4 = r3.f;
        if (r4 == null) goto L12;
        r1 = r4.getItemCount();
    L12:
        Integer r5 = Integer.valueOf(r1);
    L15:
        if (r5 != null) goto L17;
    L47:
        int r13 = r6 - 1;
        int r14 = this.D.findFirstVisibleItemPosition();
        int r15 = this.D.findLastVisibleItemPosition();
        View r16 = this.D.findViewByPosition(r13);
        if (r16 != null) goto L51;
        PointF r17 = v(r13, r14, r7);
    L50:
        r0 = r17;
        goto L61
    L51:
        Rect r18 = new Rect();
        r16.getGlobalVisibleRect(r18);
        if (r13 > r14) goto L56;
        r17 = u(r18.width(), r7);
        if (r17 != null) goto L50;
    L60:
        r17 = t(r16);
        goto L50
    L56:
        if (r13 < r15) goto L60;
        if (r18.width() > s1.f(8.0f)) goto L60;
        r17 = w();
        goto L50
    L17:
        if (r5.intValue() == 0) goto L47;
        int r19 = r5.intValue();
        if (new IntRange(1, r19).contains(r6) == false) goto L34;
        int r20 = r6 - 1;
        int r21 = this.E.findFirstVisibleItemPosition();
        int r22 = this.E.findLastVisibleItemPosition();
        View r23 = this.E.findViewByPosition(r20);
        if (r23 != null) goto L24;
        r17 = v(r20, r21, r7);
        goto L50
    L24:
        Rect r24 = new Rect();
        r23.getGlobalVisibleRect(r24);
        if (r20 > r21) goto L29;
        r17 = u(r24.width(), r7);
        if (r17 != null) goto L50;
    L33:
        r17 = t(r23);
        goto L50
    L29:
        if (r20 < r22) goto L33;
        if (r24.width() > s1.f(8.0f)) goto L33;
        r17 = w();
        goto L50
    L34:
        int r25 = (r6 - r19) - 1;
        int r26 = this.D.findFirstVisibleItemPosition();
        int r27 = this.D.findLastVisibleItemPosition();
        View r28 = this.D.findViewByPosition(r25);
        if (r28 != null) goto L37;
        r17 = v(r25, r26, r7);
        goto L50
    L37:
        Rect r29 = new Rect();
        r28.getGlobalVisibleRect(r29);
        if (r25 > r26) goto L42;
        r17 = u(r29.width(), r7);
        if (r17 != null) goto L50;
    L46:
        r17 = t(r28);
        goto L50
    L42:
        if (r25 < r27) goto L46;
        if (r29.width() > s1.f(8.0f)) goto L46;
        r17 = w();
        goto L50
    L13:
        r5 = null;
        goto L15
    }

    public final void F(LinkPlayerInfo r3, boolean r4) {
        if (r3.userPosition != 0) goto L25;
        this.P = r3;
        if (r3.isTalking() == true) goto L14;
        if (r4 == true) goto L14;
        if (r3.hasSpecialRadioEffect() == false) goto L14;
        HSImageView r5 = this.o;
        if (r5 == null) goto L12;
        r5.setController(null);
    L12:
        r();
        return;
    L14:
        if (r3.isTalking() == true) goto L27;
        if (r4 == false) goto L17;
        return;
    L17:
        if (r3.hasSpecialRadioEffect() == true) goto L29;
        HSImageView r6 = this.o;
        if (r6 == null) goto L21;
        r6.setController(null);
    L21:
        HSImageView r7 = this.o;
        if (r7 == null) goto L30;
        r7.setVisibility(4);
        return;
    L30:
        return;
    L29:
        return;
    L27:
        return;
    }

    public final void G(int r13, MultiLinkGuestViewBinder.a r14) {
        LinkPlayerInfo r0 = s();
        py.k r1 = null;
        if (r0 != null) goto L5;
    L16:
        IBaseUser r2 = this.P0.b().getOwner();
        if (r2 == null) goto L19;
        int r7 = r2.getGender();
    L20:
        if (r14 == null) goto L31;
        IVoiceLiveTheme r3 = ((tf0.e) r14).c;
        if (r3 == null) goto L31;
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r3) != true) goto L31;
        IVoiceLiveTheme r4 = ((tf0.e) r14).c;
        if (r4 == null) goto L28;
        r1 = IVoiceLiveThemeKt.getVolumeAnim$default(r4, 3, r13, r7, o1.a(), false, 16, null);
    L28:
        j22.c r15 = this.A;
        if (r15 == null) goto L37;
        r15.e(r1);
    L37:
        HSImageView r16 = this.o;
        if (r16 == null) goto L41;
        r16.setVisibility(0);
        return;
    L41:
        return;
    L31:
        String r17 = this.X;
        String r18 = this.Y.a(r7, r13);
        if (r18 == null) goto L34;
        r17 = r18;
    L34:
        j22.c r19 = this.A;
        if (r19 == null) goto L37;
        r19.d(r17);
        goto L37
    L19:
        r7 = 0;
        goto L20
    L5:
        if (r0.hasSpecialRadioEffect() != true) goto L16;
        j22.c r110 = this.A;
        if (r110 == null) goto L37;
        LinkPlayerInfo r5 = s();
        if (r5 == null) goto L15;
        MicDress r6 = r5.micDress;
        if (r6 == null) goto L15;
        MicDress.VoiceWave r8 = r6.voiceWave;
        if (r8 == null) goto L15;
        r1 = r8.getAnimByState(r13);
    L15:
        r110.f(r1);
        goto L37
    }

    public final void H(MultiLinkGuestViewBinder.a r2, int r3) {
        if (n.f(r2.k.a) == false) goto L21;
        ch0.e r4 = r2.k;
        if (r4 == null) goto L13;
        ILinkPlayerInfoBridge r5 = r4.a;
        if (r5 == null) goto L13;
        kd1.b r6 = r5.getMicDress();
        if (r6 == null) goto L13;
        kd1.c r7 = r6.getVoiceWave();
        if (r7 == null) goto L13;
        py.k r8 = kd1.d.a(r7, r3);
    L14:
        j22.c r9 = this.A;
        if (r9 == null) goto L17;
        r9.f(r8);
    L17:
        HSImageView r10 = this.o;
        if (r10 == null) goto L23;
        r10.setVisibility(0);
        return;
    L23:
        return;
    L13:
        r8 = null;
        goto L14
    L21:
        G(r3, r2);
    }

    public final boolean K5(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "fromUserId");
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        KtvRoomSeatManager r1 = this.F;
        if (r1 == null) goto L32;
        Intrinsics.checkNotNullParameter(r4, "fromUserId");
        Intrinsics.checkNotNullParameter(r5, "toUSerId");
        SeatAnimEngineWrapper r0 = r1.b;
        if (r0 == null) goto L7;
        SeatAnimManager r2 = r0.a;
    L8:
        if (r2 == null) goto L33;
        SeatAnimationView r6 = (SeatAnimationView) ((LinkedHashMap) r2.a).get(r4);
        if (r6 == null) goto L13;
        SeatAnimTaskState r7 = r6.getTaskState();
        if (r7 == null) goto L13;
    L14:
        SeatAnimationView r8 = (SeatAnimationView) ((LinkedHashMap) r2.a).get(r5);
        if (r8 == null) goto L18;
        SeatAnimTaskState r9 = r8.getTaskState();
        if (r9 == null) goto L18;
    L19:
        SeatAnimTaskState r3 = SeatAnimTaskState.LINK_SUC_ANIM;
        if (r7 == r3) goto L27;
        if (r9 == r3) goto L27;
        SeatAnimTaskState r10 = SeatAnimTaskState.REVENUE_DRESS_ANIM;
        if (r7 == r10) goto L27;
        if (r9 == r10) goto L27;
        boolean r11 = false;
    L28:
        if (r11 != true) goto L34;
        return false;
    L34:
        return true;
    L27:
        r11 = true;
    L18:
        r9 = SeatAnimTaskState.IDLE;
    L13:
        r7 = SeatAnimTaskState.IDLE;
        goto L14
    L33:
        return true;
    L7:
        r2 = null;
        goto L8
    L32:
        return true;
    }

    public final EPointF Kl(int r6, int r7) {
        PointF r0 = new EPointF();
        int r1 = 0;
        if (r7 != 0) goto L7;
        int[] r8 = new int[2];
        HSImageView r9 = this.m;
        if (r9 == null) goto L61;
        r9.getLocationOnScreen(r8);
        float r10 = r8[0];
        HSImageView r2 = this.m;
        Intrinsics.checkNotNull(r2);
        r0.x = r10 + (r2.getLayoutParams().width / 2.0f);
        float r11 = r8[1];
        HSImageView r12 = this.m;
        Intrinsics.checkNotNull(r12);
        r0.y = r11 + (r12.getLayoutParams().height / 2.0f);
    L61:
        ALogger.d("ktv_seat_view_manager", "getSeatEndPoint: " + r0.toString() + ' ');
        return r0;
    L7:
        KtvRoomSeatManager r3 = this.F;
        if (r3 == null) goto L13;
        KtvRoomSeatListAdapter r4 = r3.f;
        if (r4 == null) goto L12;
        r1 = r4.getItemCount();
    L12:
        Integer r5 = Integer.valueOf(r1);
    L15:
        if (r5 != null) goto L17;
    L47:
        int r13 = r7 - 1;
        int r14 = this.D.findFirstVisibleItemPosition();
        int r15 = this.D.findLastVisibleItemPosition();
        View r16 = this.D.findViewByPosition(r13);
        if (r16 != null) goto L51;
        PointF r17 = v(r13, r14, r6);
    L50:
        r0 = r17;
        goto L61
    L51:
        Rect r18 = new Rect();
        r16.getGlobalVisibleRect(r18);
        if (r13 > r14) goto L56;
        r17 = u(r18.width(), r6);
        if (r17 != null) goto L50;
    L60:
        r17 = t(r16);
        goto L50
    L56:
        if (r13 < r15) goto L60;
        if (r18.width() > s1.f(8.0f)) goto L60;
        r17 = w();
        goto L50
    L17:
        if (r5.intValue() == 0) goto L47;
        int r19 = r5.intValue();
        if (new IntRange(1, r19).contains(r7) == false) goto L34;
        int r20 = r7 - 1;
        int r21 = this.E.findFirstVisibleItemPosition();
        int r22 = this.E.findLastVisibleItemPosition();
        View r23 = this.E.findViewByPosition(r20);
        if (r23 != null) goto L24;
        r17 = v(r20, r21, r7);
        goto L50
    L24:
        Rect r24 = new Rect();
        r23.getGlobalVisibleRect(r24);
        if (r20 >= r21) goto L29;
        r17 = u(r24.width(), r6);
        if (r17 != null) goto L50;
    L33:
        r17 = t(r23);
        goto L50
    L29:
        if (r20 < r22) goto L33;
        if (r24.width() > s1.f(8.0f)) goto L33;
        r17 = w();
        goto L50
    L34:
        int r25 = (r7 - r19) - 1;
        int r26 = this.D.findFirstVisibleItemPosition();
        int r27 = this.D.findLastVisibleItemPosition();
        View r28 = this.D.findViewByPosition(r25);
        if (r28 != null) goto L37;
        r17 = v(r25, r26, r6);
        goto L50
    L37:
        Rect r29 = new Rect();
        r28.getGlobalVisibleRect(r29);
        if (r25 >= r26) goto L42;
        r17 = u(r29.width(), r6);
        if (r17 != null) goto L50;
    L46:
        r17 = t(r28);
        goto L50
    L42:
        if (r25 < r27) goto L46;
        if (r29.width() > s1.f(8.0f)) goto L46;
        r17 = w();
        goto L50
    L13:
        r5 = null;
        goto L15
    }

    public final boolean W7(EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        return true;
    }

    public final int ma(int r1, int r2) {
        if (r2 == 4) goto L6;
        return s1.j(2131168824);
    L6:
        return s1.f(58.0f);
    }

    public final EPointF u(int r4, int r5) {
        KtvRoomSeatManager r0 = this.F;
        if (r0 == null) goto L7;
        KtvRoomSeatListAdapter r1 = r0.f;
        if (r1 == null) goto L7;
        int r2 = r1.getItemCount();
    L8:
        if (r5 < 0) goto L12;
        if (r2 < r5) goto L12;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L22;
        if (r4 > s1.f(44.0f)) goto L22;
        View r7 = this.u;
        if (r7 == null) goto L29;
        r7.getLocationOnScreen(this.Z);
    L29:
        return new EPointF(this.Z[0] + s1.f(34.0f), x(), 2);
    L22:
        if (r4 > s1.f(28.0f)) goto L27;
        View r8 = this.u;
        if (r8 == null) goto L30;
        r8.getLocationOnScreen(this.Z);
    L30:
        return new EPointF(this.Z[0] - s1.f(34.0f), ((PointF) this.p0).y, 3);
    L27:
        return null;
    L12:
        r6 = false;
    L7:
        r2 = 0;
        goto L8
    }

    public final void Mb(String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "url");
        KtvRoomSeatManager r2 = this.F;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "id");
        Intrinsics.checkNotNullParameter(r5, "url");
        SeatAnimEngineWrapper r0 = r2.b;
        if (r0 == null) goto L7;
        EmojiSoundManager r1 = r0.b;
    L8:
        if (r1 == null) goto L12;
        r1.e(r4, r5, r6);
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final boolean Mk(EPointF r8, EPointF r9, EPointF r10) {
        Intrinsics.checkNotNullParameter(r8, "currentPoint");
        Intrinsics.checkNotNullParameter(r9, "startPoint");
        Intrinsics.checkNotNullParameter(r10, "endPoint");
        View r0 = this.u;
        if (r0 == null) goto L5;
        r0.getLocationOnScreen(this.Z);
    L5:
        int r1 = this.Z[0];
        int r2 = r9.a;
        if (r2 != 2) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L17;
        float r6 = r1;
        if (((PointF) r10).x >= r6) goto L17;
        if (((PointF) r8).x >= r6) goto L50;
        return true;
    L50:
        return false;
    L17:
        if (r2 != 3) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L27;
        float r7 = r1;
        if (((PointF) r10).x <= r7) goto L27;
        if (((PointF) r8).x <= r7) goto L51;
        return true;
    L51:
        return false;
    L27:
        float r11 = ((PointF) r9).x;
        float r4 = r1;
        if (r11 >= r4) goto L39;
        if (r10.a != 2) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L39;
        if (((PointF) r8).x >= r4) goto L52;
        return true;
    L52:
        return false;
    L32:
        r12 = false;
    L39:
        if (r11 > r4) goto L41;
    L49:
        return true;
    L41:
        if (r10.a != 3) goto L43;
        boolean r13 = true;
    L44:
        if (r13 == false) goto L49;
        if (((PointF) r8).x <= r4) goto L53;
        return true;
    L53:
        return false;
    L43:
        r13 = false;
        goto L44
    L19:
        r3 = false;
        goto L20
    L8:
        r5 = false;
        goto L9
    }

    public final boolean ha(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        float r5 = ((PointF) r2).x;
        RecyclerView r6 = this.s;
        if (r6 == null) goto L5;
        r6.getLocationOnScreen(this.k0);
    L5:
        int r7 = this.k0[0];
        RecyclerView r0 = this.s;
        if (r0 == null) goto L8;
        int r1 = r0.getWidth();
    L10:
        if (r5 < (r7 + r1)) goto L13;
        return true;
    L13:
        return false;
    L8:
        r1 = 0;
        goto L10
    }

    public final EPointF v(int r3, int r4, int r5) {
        if (r3 >= r4) goto L25;
        KtvRoomSeatManager r6 = this.F;
        if (r6 == null) goto L8;
        KtvRoomSeatListAdapter r7 = r6.f;
        if (r7 == null) goto L8;
        int r8 = r7.getItemCount();
    L9:
        if (r5 < 0) goto L13;
        if (r8 < r5) goto L13;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L20;
        View r0 = this.u;
        if (r0 == null) goto L26;
        r0.getLocationOnScreen(this.Z);
    L26:
        return new EPointF(this.Z[0] + s1.f(34.0f), x(), 2);
    L20:
        View r1 = this.u;
        if (r1 == null) goto L27;
        r1.getLocationOnScreen(this.Z);
    L27:
        return new EPointF(this.Z[0] - s1.f(34.0f), ((PointF) this.p0).y, 3);
    L13:
        r9 = false;
    L8:
        r8 = 0;
        goto L9
    L25:
        return w();
    }

    public final EPointF Se(int r1, int r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        EPointF r5 = new EPointF();
        ((PointF) r5).y = ((PointF) r4).y;
        ((PointF) r5).x = (((PointF) r3).x + ((PointF) r4).x) / 2;
        return r5;
    }

    public KtvRoomViewManager(Context r19, ViewGroup r20, sb0.b r21, Function0<? extends WidgetManager> r22, com.bytedance.android.live.pushstream.d r23, KtvContext r24, GLSurfaceView r25, qe2.c r26) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "ktvLayout");
        Intrinsics.checkNotNullParameter(r21, "dataEntity");
        Intrinsics.checkNotNullParameter(r22, "widgetProvider");
        Intrinsics.checkNotNullParameter(r24, "ktvContext");
        Intrinsics.checkNotNullParameter(r26, "mDataDispatcher");
        this.H0 = r19;
        this.L0 = r20;
        this.P0 = r21;
        this.V0 = r22;
        this.b1 = r23;
        this.g1 = r24;
        this.h1 = r25;
        this.k1 = r26;
        this.b = LazyKt.lazy(new KtvRoomViewManager$guestSeatDegradeStrategy$2(this));
        this.d = r21.b().a();
        ViewGroup r12 = (ViewGroup) r20.findViewById(2131376977);
        this.e = r12;
        Lazy r1 = LazyKt.lazy(new KtvRoomViewManager$ktvFullScreenThemeBackground$2(this));
        this.f = r1;
        Lazy r2 = LazyKt.lazy(new KtvRoomViewManager$ktvBackground$2(this));
        this.g = r2;
        Lazy r3 = LazyKt.lazy(new KtvRoomViewManager$ktvTopBar$2(this));
        this.h = r3;
        this.i = (FrameLayout) r20.findViewById(2131376972);
        this.C = "guest_seat";
        this.D = new LinearLayoutManager(r19, 0, false);
        this.E = new LinearLayoutManager(r19, 0, false);
        this.J = r20.findViewById(2131376962);
        CompositeDisposable r14 = new CompositeDisposable();
        this.L = r14;
        com.bytedance.android.live.ktv.common.util.e r15 = r24.getBizLcMager();
        g r4 = new g();
        this.S = r4;
        this.U = new Pair("", 0L);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a r13 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.a) this;
        this.V = new f(r13);
        r24.getKtvRoomLabelChangeEvent().onEvent().subscribe(new a(r13));
        ViewGroup.LayoutParams r16 = null;
        if (r21.b().isAnchor() == false) goto L13;
        IKtvService r5 = jc1.k.f(IKtvService.class);
        if (r5 == null) goto L11;
        m r6 = r5.isPushingExternalVideo();
        if (r6 == null) goto L11;
        Observable r7 = r6.a();
        if (r7 == null) goto L11;
        Disposable r8 = r7.subscribe(new b(r13));
    L12:
        this.c = r8;
    L11:
        r8 = null;
    L13:
        r24.getStatisticHelper().b(this);
        r24.getStatisticHelper().b(r4);
        if (q() == true) goto L21;
        Lazy r9 = KtvCommonSettingHelper.a;
        if (((HSImageView) r1.getValue()) == null) goto L18;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.theme.c r10 = new com.bytedance.android.livesdk.ktvimpl.ktvroom.theme.c(r24, r20, (HSImageView) r1.getValue(), (HSImageView) r2.getValue(), r21);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "w");
        r15.b.add(r10);
        tb0.c r11 = r15.a;
        tb0.b r17 = r11.a;
        r10.b(r11);
        r24.getStatisticHelper().b(r10);
        Unit r18 = Unit.INSTANCE;
        this.I = r10;
        goto L21
    L18:
        L(this);
        if (((HSImageView) r1.getValue()) == null) goto L21;
        this.H = new KtvThemeControl((View) r3.getValue(), (HSImageView) r2.getValue(), r20, (HSImageView) r1.getValue(), r19, r21.getDataCenter());
    L21:
        this.F = new KtvRoomSeatManager(r20, r19, new c(r13), r23);
        View r27 = r12.findViewById(2131377060);
        if ((r27 instanceof ViewGroup) == true) goto L24;
        r27 = null;
    L24:
        ViewGroup r28 = (ViewGroup) r27;
        if (r28 == null) goto L33;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if ((r29 instanceof ConstraintLayout.LayoutParams) == false) goto L30;
        r16 = r29;
    L30:
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r16;
        if (r30 == null) goto L33;
        r30.dimensionRatio = "W,260:375";
        ((ViewGroup.MarginLayoutParams) r30).height = 0;
        ((ViewGroup.MarginLayoutParams) r30).width = -1;
        r28.setLayoutParams(r30);
    L33:
        E();
        Disposable r31 = RxUtilKt.h(r26.b).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.d(r13));
        if (r31 == null) goto L37;
        RxUtilKt.c(r31, r14);
    L37:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L42;
        Disposable r32 = RxUtilKt.h(r26.c).subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.e(r13));
        if (r32 == null) goto L42;
        RxUtilKt.c(r32, r14);
    L42:
        if (com.bytedance.android.live.liveinteract.plantform.datamergev2.g.a(0) == false) goto L44;
        RxUtilKt.c(r26.c.subscribe(new com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm.f(r13)), r14);
    L44:
        d9 r33 = vm2.k.a();
        if (TextUtils.isEmpty(r33.seatTalkEffect) == false) goto L47;
        r33.seatTalkEffect = d9.e;
    L47:
        this.X = r33.seatTalkEffect;
        this.Y = vm2.d.a0();
        this.Z = new int[2];
        this.k0 = new int[2];
        EPointF r34 = new EPointF();
        ((PointF) r34).x = s1.f(34.0f);
        ((PointF) r34).y = x();
        r34.a = 1;
        Unit r35 = Unit.INSTANCE;
        this.p0 = r34;
    }
}
