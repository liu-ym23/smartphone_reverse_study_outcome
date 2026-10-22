package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.b4;
import com.larus.bmhome.chat.component.bottom.core.l2;
import com.larus.bmhome.chat.component.bottom.core.m4;
import com.larus.bmhome.chat.component.bottom.core.q3;
import com.larus.bmhome.chat.component.bottom.core.x4;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.input.api.officemention.OfficeMentionService;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class ChatInputMentionPanelController {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f298573r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f298574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f298575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y8 f298576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoreInputAbility<?> f298577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final va8.o f298578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qp8.b f298579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MultiTypeMentionPanelController f298580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f298581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f298582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f298583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f298584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f298585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f298586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f298587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f298588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f298589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewTreeObserver f298590q;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Integer> {
        public AnonymousClass1(Object r100) {
            super(0, r100, ChatInputMentionPanelController.class, "resolvePanelTopAnchorY", "resolvePanelTopAnchorY()Ljava/lang/Integer;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            View r100 = ((ChatInputMentionPanelController) this.receiver).f298575b.getRootView();
            if (r100.getHeight() <= 0) goto L5;
            boolean r101 = true;
        L7:
            if (r101 == true) goto L10;
            r100 = null;
        L10:
            if (r100 == null) goto L17;
            WindowInsetsCompat r102 = ViewCompat.getRootWindowInsets(r100);
            if (r102 == null) goto L18;
            int r103 = r102.getInsets(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.displayCutout()).top;
            int[] r104 = new int[2];
            r100.getLocationOnScreen(r104);
            return Integer.valueOf(r104[1] + r103);
        L18:
            return null;
        L17:
            return null;
        L5:
            r101 = false;
            goto L7
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return invoke();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<MentionFilePickerType, Unit> {
        public AnonymousClass6(Object r100) {
            super(1, r100, ChatInputMentionPanelController.class, "launchFilePickerAfterPanelDismissed", "launchFilePickerAfterPanelDismissed(Lcom/larus/bmhome/chat/component/bottom/bottommenu/MentionFilePickerType;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MentionFilePickerType r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ChatInputMentionPanelController r101 = (ChatInputMentionPanelController) this.receiver;
            va8.m r102 = r101.f298576c.vU();
            if (r102 == null) goto L9;
            va8.l r103 = r102.iX();
            if (r103 == null) goto L9;
            View r104 = r103.getRootView();
            if (r104 == null) goto L9;
        L11:
            if (Build.VERSION.SDK_INT <= 33) goto L13;
        L15:
            r101.f298574a.f298612u.invoke(r100);
            return;
        L13:
            if (r101.f298578e.w() == false) goto L15;
            r101.f298577d.qp(true);
            r101.b(r104, r100, 0);
            return;
        L9:
            r104 = r101.f298574a.f298594c;
            goto L11
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MentionFilePickerType r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass7(Object r100) {
            super(1, r100, ChatInputMentionPanelController.class, "onPanelVisibleChanged", "onPanelVisibleChanged(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
            invoke(r100.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r100) {
            ChatInputMentionPanelController r101 = (ChatInputMentionPanelController) this.receiver;
            int r102 = ChatInputMentionPanelController.f298573r;
            r101.d(r100);
        }
    }

    public /* synthetic */ class a implements qp8.d, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatInputMentionPanelController f298591a;

        public a(ChatInputMentionPanelController r100) {
            this.f298591a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof qp8.d) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.f298591a, ChatInputMentionPanelController.class, "onPanelVisibleChanged", "onPanelVisibleChanged(Z)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // qp8.d
        public final void a(boolean r100) {
            this.f298591a.d(r100);
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p0 f298592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f298593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f298594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f298595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final y8 f298596e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CoreInputAbility<?> f298597f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final va8.o f298598g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f298599h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f298600i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f298601j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final CoroutineScope f298602k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f298603l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f298604m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f298605n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final List<String> f298606o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final List<String> f298607p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Fragment f298608q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Function0<Boolean> f298609r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Function0<Boolean> f298610s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final Function0<be8.a> f298611t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final Function1<MentionFilePickerType, Unit> f298612u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Function1<Boolean, Unit> f298613v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final Function1<Boolean, Unit> f298614w;

        public c(p0 r110, ViewGroup r111, ViewGroup r112, View r210, y8 r211, CoreInputAbility r212, va8.o r213, String r214, boolean r215, boolean r216, LifecycleCoroutineScope r217, boolean r218, boolean r219, boolean r310, List r311, List r312, Fragment r313, l2 r314, q3 r315, b4 r316, m4 r317, Function1 r318, x4 r319) {
            Intrinsics.checkNotNullParameter(r110, "inputDelegate");
            Intrinsics.checkNotNullParameter(r111, "panelView");
            Intrinsics.checkNotNullParameter(r112, "underlyingPanelsContainer");
            Intrinsics.checkNotNullParameter(r210, "inputAreaAboveDivider");
            Intrinsics.checkNotNullParameter(r211, "dependency");
            Intrinsics.checkNotNullParameter(r212, "coreInputAbility");
            Intrinsics.checkNotNullParameter(r213, "inputUiAbility");
            Intrinsics.checkNotNullParameter(r214, "appId");
            Intrinsics.checkNotNullParameter(r217, "coroutineScope");
            Intrinsics.checkNotNullParameter(r313, "hostFragment");
            Intrinsics.checkNotNullParameter(r314, "isInTaskMode");
            Intrinsics.checkNotNullParameter(r315, "switchToTaskModeIfNeeded");
            Intrinsics.checkNotNullParameter(r316, "skillAbilityProvider");
            Intrinsics.checkNotNullParameter(r317, "onSelectMentionFile");
            Intrinsics.checkNotNullParameter(r318, "onTaskSkillPanelVisibleChanged");
            Intrinsics.checkNotNullParameter(r319, "onSkillSearchModeChanged");
            this.f298592a = r110;
            this.f298593b = r111;
            this.f298594c = r112;
            this.f298595d = r210;
            this.f298596e = r211;
            this.f298597f = r212;
            this.f298598g = r213;
            this.f298599h = r214;
            this.f298600i = r215;
            this.f298601j = r216;
            this.f298602k = r217;
            this.f298603l = r218;
            this.f298604m = r219;
            this.f298605n = r310;
            this.f298606o = r311;
            this.f298607p = r312;
            this.f298608q = r313;
            this.f298609r = r314;
            this.f298610s = r315;
            this.f298611t = r316;
            this.f298612u = r317;
            this.f298613v = r318;
            this.f298614w = r319;
        }
    }

    static {
    }

    public final void a() {
        ViewTreeObserver.OnPreDrawListener r100 = this.f298589p;
        ViewTreeObserver r101 = this.f298590q;
        if (r100 == null) goto L11;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L11;
        r101.removeOnPreDrawListener(r100);
        goto L11
    L7:
        if (r101.isAlive() != true) goto L9;
        r102 = true;
    L11:
        RecyclerView r103 = this.f298588o;
        if (r103 == null) goto L14;
        r103.setTag(R.id.chat_list_input_panel_restoring, Boolean.FALSE);
    L14:
        this.f298588o = null;
        this.f298589p = null;
        this.f298590q = null;
    }

    public final void c() {
        qp8.b r100 = this.f298579f;
        if (r100 == null) goto L5;
        r100.onDestroy();
    L5:
        MultiTypeMentionPanelController r101 = this.f298580g;
        if (r101 == null) goto L22;
        r101.E = true;
        AccountService.f365697a.D(r101.F);
        r101.C.a();
        r101.o(false);
        r101.T.removeTextChangedListener(r101.f298634b0);
        b0 r102 = r101.U;
        if (r102.f298696a.getViewTreeObserver().isAlive() == false) goto L10;
        r102.f298696a.getViewTreeObserver().removeOnPreDrawListener(r102.f298703h);
    L10:
        r102.f298696a.getOverlay().remove(r102.f298702g);
        ColorStateList r103 = r102.f298701f;
        if (r103 != null) goto L13;
    L15:
        r102.f298701f = null;
        r101.f298633b.removeOnLayoutChangeListener(r101.O);
        ViewCompat.setWindowInsetsAnimationCallback(r101.f298633b, null);
        Job r104 = r101.Q;
        if (r104 == null) goto L18;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L18:
        r101.Q = null;
        Job r105 = r101.R;
        if (r105 == null) goto L21;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L21:
        r101.R = null;
        r101.G = null;
        r101.H = null;
        r101.I = null;
        r101.M = false;
        r101.d();
        r101.g();
        r101.f();
        r101.p(false);
        goto L22
    L13:
        if (r102.f298696a.getCurrentHintTextColor() != 0) goto L15;
        r102.f298696a.setHintTextColor(r103);
    L22:
        this.f298575b.setVisibility(8);
        d(false);
        a();
    }

    public final void d(boolean r110) {
        if (r110 == this.f298582i) goto L58;
        va8.p r100 = (va8.p) s1a.a.g(this.f298574a.f298608q).getAbility(va8.p.class);
        if (r100 == null) goto L7;
        r100.ZN(!r110);
    L7:
        if (r110 == false) goto L39;
        a();
        va8.p r101 = (va8.p) s1a.a.g(this.f298574a.f298608q).getAbility(va8.p.class);
        if (r101 == null) goto L50;
        RecyclerView r102 = r101.Ly();
        if (r102 == null) goto L50;
        if (r102.getHeight() <= 0) goto L50;
        String r103 = null;
        this.f298584k = null;
        this.f298585l = -1;
        this.f298586m = 0;
        u7 r104 = this.f298576c.u3();
        if (r104 == null) goto L18;
        boolean r105 = r104.D80();
    L19:
        this.f298587n = r105;
        RecyclerView.LayoutManager r106 = r102.getLayoutManager();
        if ((r106 instanceof LinearLayoutManager) == false) goto L22;
        LinearLayoutManager r107 = (LinearLayoutManager) r106;
    L23:
        if (r107 == null) goto L50;
        View r108 = r107.getChildAt(0);
        if (r108 == null) goto L50;
        int r109 = r107.getPosition(r108);
        if (r109 == (-1)) goto L50;
        Object r111 = r108.getTag(R.id.chat_list_msg_id);
        if ((r111 instanceof String) == false) goto L34;
        r103 = (String) r111;
    L34:
        this.f298584k = r103;
        this.f298585l = r109;
        if (r107.getReverseLayout() == false) goto L37;
        int r112 = r102.getHeight() - r102.getPaddingBottom();
        int r113 = r107.getDecoratedBottom(r108);
    L38:
        this.f298586m = r112 - r113;
        goto L50
    L37:
        r112 = r107.getDecoratedTop(r108);
        r113 = r102.getPaddingTop();
        goto L38
    L22:
        r107 = null;
        goto L23
    L18:
        r105 = true;
    L50:
        xa8.a r114 = (xa8.a) this.f298581h.getValue();
        if (r114 == null) goto L53;
        r114.H9(r110);
    L53:
        if (r110 == true) goto L58;
        u7 r115 = this.f298576c.u3();
        if (r115 == null) goto L58;
        r115.U1();
        goto L58
    L39:
        a();
        va8.p r116 = (va8.p) s1a.a.g(this.f298574a.f298608q).getAbility(va8.p.class);
        if (r116 == null) goto L50;
        RecyclerView r117 = r116.Ly();
        if (r117 == null) goto L50;
        if (r117.getHeight() > 0) goto L50;
        ViewTreeObserver r118 = r117.getViewTreeObserver();
        if (r118.isAlive() == false) goto L50;
        r117.setTag(R.id.chat_list_input_panel_restoring, Boolean.TRUE);
        p r119 = new p(r117, this);
        this.f298588o = r117;
        this.f298589p = r119;
        this.f298590q = r118;
        r118.addOnPreDrawListener(r119);
    L58:
        if (r110 == this.f298582i) goto L68;
        if (r110 == true) goto L62;
        this.f298578e.e10(this.f298583j);
    L67:
        this.f298582i = r110;
        goto L68
    L62:
        if (this.f298574a.f298595d.getVisibility() != 0) goto L64;
        boolean r120 = true;
    L65:
        this.f298583j = r120;
        this.f298578e.e10(true);
        goto L67
    L64:
        r120 = false;
    L68:
        ViewGroup r121 = this.f298574a.f298594c;
        if ((!r110) == false) goto L71;
        int r122 = 0;
    L72:
        r121.setVisibility(r122);
        if (r110 == true) goto L118;
        if (this.f298577d.FF() != null) goto L106;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r123 = this.f298576c.f70();
        if (r123 != null) goto L79;
    L81:
        boolean r124 = false;
    L82:
        if (r124 == true) goto L106;
        com.larus.bmhome.chat.component.bottom.reference.a r125 = this.f298576c.g5();
        if (r125 != null) goto L86;
    L88:
        boolean r126 = false;
    L89:
        if (r126 == true) goto L106;
        com.larus.bmhome.instruction.g r127 = this.f298576c.vc();
        if (r127 != null) goto L93;
    L95:
        boolean r128 = false;
    L96:
        if (r128 == true) goto L106;
        ys8.a r129 = this.f298576c.DC();
        if (r129 != null) goto L100;
    L102:
        boolean r130 = false;
    L103:
        if (r130 == true) goto L106;
        boolean r131 = false;
    L107:
        if (r131 == true) goto L118;
        if (this.f298576c.f1().C() == false) goto L116;
        int r132 = com.larus.bmhome.chat.immerse.k0.f303286a;
        Integer r133 = this.f298576c.f1().m();
        if (r133 == null) goto L114;
        int r134 = r133.intValue();
    L115:
        int r135 = com.larus.bmhome.chat.immerse.k0.a(r134, 0.1f, 0.35f);
        GradientDrawable r136 = new GradientDrawable();
        r136.setShape(0);
        r136.setCornerRadius(l1.a(this.f298575b.getContext()));
        r136.setColor(r135);
        this.f298578e.l70(r136, r135);
        return;
    L114:
        r134 = 0;
        goto L115
    L116:
        this.f298578e.p9(v19.c.b(R.attr.larus_bg_input_normal, this.f298575b.getContext(), R.drawable.larus_bg_input_normal));
        return;
    L100:
        if (r129.z0() != true) goto L102;
        r130 = true;
        goto L103
    L93:
        if (r127.z0() != true) goto L95;
        r128 = true;
        goto L96
    L86:
        if (r125.i9() != true) goto L88;
        r126 = true;
        goto L89
    L79:
        if (r123.isVisible() != true) goto L81;
        r124 = true;
    L106:
        r131 = true;
    L118:
        if (this.f298576c.f1().C() == false) goto L124;
        int r137 = com.larus.bmhome.chat.immerse.k0.f303286a;
        Integer r138 = this.f298576c.f1().m();
        if (r138 == null) goto L122;
        int r139 = r138.intValue();
    L123:
        int r140 = com.larus.bmhome.chat.immerse.k0.a(r139, 0.1f, 0.35f);
        float r141 = l1.a(this.f298575b.getContext());
        GradientDrawable r142 = new GradientDrawable();
        r142.setShape(0);
        r142.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r141, r141, r141, r141});
        r142.setColor(r140);
        this.f298578e.l70(r142, r140);
        return;
    L122:
        r139 = 0;
        goto L123
    L124:
        this.f298578e.p9(v19.c.b(R.attr.larus_bg_input_normal_no_top_corner, this.f298575b.getContext(), R.drawable.larus_bg_input_normal_no_top_corner));
        return;
    L71:
        r122 = 8;
        goto L72
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.m] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.i] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.j] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.k] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.l] */
    public ChatInputMentionPanelController(c r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r310, "mentionContext");
        this.f298574a = r310;
        ViewGroup r100 = r310.f298593b;
        this.f298575b = r100;
        y8 r101 = r310.f298596e;
        this.f298576c = r101;
        CoreInputAbility<?> r102 = r310.f298597f;
        this.f298577d = r102;
        va8.o r103 = r310.f298598g;
        this.f298578e = r103;
        this.f298581h = LazyKt.lazy(new h(this));
        this.f298585l = -1;
        this.f298587n = true;
        p0 r104 = r310.f298592a;
        qp8.b r105 = null;
        if ((r104 instanceof ChatInputWithMentionDelegate) == false) goto L5;
        ChatInputWithMentionDelegate r106 = (ChatInputWithMentionDelegate) r104;
    L6:
        qp8.e r110 = new qp8.e(r310.f298599h, r310.f298600i, r310.f298601j, new ChatInputMentionPanelController$officeMentionConfig$1(r102));
        if (r310.f298603l == false) goto L10;
        if (r106 == null) goto L10;
        this.f298579f = null;
        ViewGroup r107 = r100;
        this.f298580g = new MultiTypeMentionPanelController(r106, r100, r101, r103.Uv(), new AnonymousClass1(this), r310.f298602k, r110, r310.f298608q, r310.f298609r, r310.f298610s, new i(this), new j(this), new k(this), new l(this), r310.f298611t, new AnonymousClass6(this), new AnonymousClass7(this), r310.f298613v, r310.f298614w, new m(this), r310.f298604m, r310.f298605n, r311, r310.f298606o, r310.f298607p);
    L20:
        if (this.f298579f == null) goto L22;
        return;
    L22:
        if (this.f298580g != null) goto L28;
        r107.setVisibility(8);
        if (r311 == true) goto L29;
        FLogger.f375446a.e("ChatInputMentionPanel", "[init] Office Mention panel is unavailable");
        return;
    L29:
        return;
    L28:
        return;
    L10:
        r107 = r100;
        this.f298580g = null;
        if (r106 == null) goto L13;
        qp8.a r108 = r106.f298618g;
    L14:
        if (r108 == null) goto L18;
        if (r311 == true) goto L18;
        r105 = OfficeMentionService.f311790b.n(r108, r107, r110, new a(this));
    L18:
        this.f298579f = r105;
        goto L20
    L13:
        r108 = null;
        goto L14
    L5:
        r106 = null;
        goto L6
    }

    public final void b(final View r100, final MentionFilePickerType r101, final int r102) {
        if (r100.isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (this.f298578e.w() == false) goto L13;
        if (r102 >= 30) goto L13;
        r100.postOnAnimation(new g(this, r100, r101, r102));
        return;
    L13:
        if ((r100 instanceof ChatConstraintLayout) == false) goto L15;
        ChatConstraintLayout r103 = (ChatConstraintLayout) r100;
    L16:
        if (r103 == null) goto L18;
        r103.u6();
    L18:
        OneShotPreDrawListener.add(r100, new n(r100, r100, this, r101));
        return;
    L15:
        r103 = null;
        goto L16
    }
}
