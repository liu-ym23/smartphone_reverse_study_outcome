package com.ss.android.lark.inline.ai.creationai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.inline.ai.api.creationai.DragBar;
import com.ss.android.lark.inline.ai.api.creationai.Header;
import com.ss.android.lark.inline.ai.api.creationai.ItemContainer;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.api.creationai.StatusInfo;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import com.ss.android.lark.inline.ai.api.creationai.Title;
import com.ss.android.lark.inline.ai.creationai.operates.ButtonGroupsRecyclerView;
import com.ss.android.lark.inline.ai.creationai.quickPrompt.QuickPromptRecyclerView;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f427109t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlb.a f427110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlb.b f427111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f427112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f427113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final QuickPromptRecyclerView f427114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f427115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f427116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CreationAIDragView f427117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f427118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ButtonGroupsRecyclerView f427119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ButtonGroupsRecyclerView f427120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f427121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f427122m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f427123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f427124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f427125p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f427126q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f427127r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f427128s;

    public static final class a implements CreationAIDragView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f427129a;

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void a(int r100) {
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void b(boolean r100) {
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void c() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void d() {
            g0 r100 = this.f427129a;
            Function1<? super Boolean, Unit> r101 = r100.f427127r;
            if (r101 != null) goto L5;
            g0.c(r100, 3);
            return;
        L5:
            r101.invoke(Boolean.TRUE);
        }

        @Override // com.ss.android.lark.inline.ai.creationai.CreationAIDragView.d
        public final void onClose() {
            Intrinsics.checkNotNullParameter("swipe_down", "closeType");
            Log.i("SubPanelController", "onClose, closeType = swipe_down");
            g0.c(this.f427129a, 3);
            Function1<? super Boolean, Unit> r100 = this.f427129a.f427127r;
            if (r100 == null) goto L6;
            r100.invoke(Boolean.FALSE);
            return;
        }

        public a(g0 r100) {
            this.f427129a = r100;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubPanelInfo f427130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0 f427131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f427132c;

        public c(SubPanelInfo r100, g0 r101, boolean r102) {
            this.f427130a = r100;
            this.f427131b = r101;
            this.f427132c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SubPanelInfo r100 = this.f427130a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            this.f427131b.e(r100, this.f427132c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final FragmentActivity getActivity() {
        return this.f427113d;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void b(SubPanelInfo r110) {
        String r100 = null;
        if (r110 == null) goto L5;
        Header r101 = r110.getHeader();
    L6:
        boolean r102 = true;
        boolean r103 = false;
        if (r101 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        ViewGroup r105 = this.f427122m;
        int r106 = 8;
        if (r104 == false) goto L15;
        int r107 = 0;
    L16:
        r105.setVisibility(r107);
        if (r104 == false) goto L60;
        if (r101 == null) goto L25;
        ItemContainer r108 = r101.getLeftItem();
        if (r108 == null) goto L25;
        if (r108.getShow() != true) goto L25;
        boolean r109 = true;
    L26:
        if (r109 == false) goto L32;
        this.f427119j.setVisibility(0);
        ButtonGroupsRecyclerView r111 = this.f427119j;
        ItemContainer r112 = r101.getLeftItem();
        if (r112 == null) goto L30;
        ArrayList<MenuItem> r113 = r112.getData();
    L31:
        r111.setData(r113);
    L33:
        if (r101 == null) goto L39;
        ItemContainer r114 = r101.getRightItem();
        if (r114 == null) goto L39;
        if (r114.getShow() != true) goto L39;
        boolean r115 = true;
    L40:
        if (r115 == false) goto L46;
        this.f427120k.setVisibility(0);
        ButtonGroupsRecyclerView r116 = this.f427120k;
        ItemContainer r117 = r101.getRightItem();
        if (r117 == null) goto L44;
        ArrayList<MenuItem> r118 = r117.getData();
    L45:
        r116.setData(r118);
    L47:
        if (r101 == null) goto L53;
        Title r119 = r101.getTitle();
        if (r119 == null) goto L53;
        if (r119.getShow() != true) goto L53;
        boolean r120 = true;
    L54:
        if (r120 == false) goto L59;
        this.f427121l.setVisibility(0);
        TextView r121 = this.f427121l;
        Title r122 = r101.getTitle();
        if (r122 == null) goto L58;
        r100 = r122.getText();
    L58:
        r121.setText(r100);
        this.f427121l.getViewTreeObserver().addOnGlobalLayoutListener(new h0(this));
        goto L60
    L59:
        this.f427121l.setVisibility(8);
    L53:
        r120 = false;
        goto L54
    L44:
        r118 = null;
        goto L45
    L46:
        this.f427120k.setVisibility(8);
    L39:
        r115 = false;
        goto L40
    L30:
        r113 = null;
        goto L31
    L32:
        this.f427119j.setVisibility(8);
    L25:
        r109 = false;
    L60:
        if (r110 == null) goto L93;
        StatusInfo r123 = r110.getStatus();
        if (r123 == null) goto L93;
        String r124 = r123.getStatus();
        if (r124 == null) goto L93;
        int r125 = r124.hashCode();
        if (r125 == (-1867169789)) goto L85;
        if (r125 == 96784904) goto L81;
        if (r125 != 336650556) goto L93;
        if (r124.equals("loading") == false) goto L93;
        this.f427123n.setVisibility(0);
        this.f427123n.findViewById(R.id.creation_ai_loading).setVisibility(0);
        this.f427123n.findViewById(R.id.creation_ai_empty_cover).setVisibility(8);
        if (r123.getText() == null) goto L79;
        ((TextView) this.f427116g.findViewById(R.id.creation_ai_loading_tip)).setText(r123.getText());
    L79:
        this.f427114e.setVisibility(8);
        goto L93
    L81:
        if (r124.equals("error") == false) goto L93;
        this.f427123n.setVisibility(0);
        this.f427123n.findViewById(R.id.creation_ai_loading).setVisibility(8);
        this.f427123n.findViewById(R.id.creation_ai_empty_cover).setVisibility(0);
        this.f427114e.setVisibility(8);
        goto L93
    L85:
        if (r124.equals("success") == false) goto L93;
        ArrayList<MenuItem> r126 = r110.getData();
        if (r126 != null) goto L90;
    L92:
        this.f427123n.setVisibility(0);
        this.f427123n.findViewById(R.id.creation_ai_loading).setVisibility(8);
        UDEmptyState r127 = (UDEmptyState) this.f427123n.findViewById(R.id.creation_ai_empty_cover);
        r127.setVisibility(0);
        r127.setImageRes(Integer.valueOf(R.drawable.illustration_empty_neutral_no_content));
        r127.setDesc(r123.getText());
        this.f427114e.setVisibility(8);
        goto L93
    L90:
        if (r126.size() <= 0) goto L92;
        this.f427123n.setVisibility(8);
        this.f427114e.setVisibility(0);
    L93:
        if (r110 == null) goto L97;
        ArrayList<MenuItem> r128 = r110.getData();
        if (r128 == null) goto L97;
        this.f427114e.setData(r128);
        this.f427114e.setOnPromptClickListener(new i0(this));
    L97:
        if (r110 == null) goto L103;
        DragBar r129 = r110.getDragBar();
        if (r129 == null) goto L103;
        if (r129.getShow() != true) goto L103;
    L104:
        ViewGroup r130 = this.f427115f;
        if (r102 == false) goto L107;
        r106 = 0;
    L107:
        r130.setVisibility(r106);
        CreationAIDragView r131 = this.f427117h;
        if (r110 == null) goto L112;
        DragBar r132 = r110.getDragBar();
        if (r132 == null) goto L112;
        r103 = r132.getDoubleConfirm();
    L112:
        r131.B = r103;
        vlb.a r133 = this.f427110a;
        if (r133.f555724b == null) goto L115;
        return;
    L115:
        if (com.ss.android.lark.utils.m0.b(r133.getActivity()) == false) goto L122;
        ConstraintLayout r134 = this.f427116g;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L120;
        ViewGroup.MarginLayoutParams r136 = (ViewGroup.MarginLayoutParams) r135;
        r136.bottomMargin = com.ss.android.lark.utils.m0.a(this.f427110a.getActivity());
        r134.setLayoutParams(r136);
        return;
    L120:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L122:
        return;
    L103:
        r102 = false;
        goto L104
    L15:
        r107 = 8;
        goto L16
    L9:
        if (r101.getShow() != true) goto L11;
        r104 = true;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public static void c(final g0 r100, int r101) {
        boolean r102 = false;
        if ((r101 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if (r100.f427116g.getParent() == null) goto L9;
        r102 = true;
    L9:
        if (r102 == true) goto L11;
        return;
    L11:
        if (r100.f427124o == true) goto L26;
        c r104 = r100.f427128s;
        if (r104 == null) goto L19;
        vlb.a r105 = r100.f427110a;
        View r106 = r105.f555724b;
        if (r106 != null) goto L18;
        r106 = a(r105.getActivity().getWindow());
    L18:
        Intrinsics.checkNotNull(r106);
        r106.removeCallbacks(r104);
    L19:
        r100.f427124o = true;
        if (Intrinsics.areEqual(r100.f427112c, "model_setting_panel") == false) goto L22;
        r100.f427111b.q("closeModelSetting");
    L23:
        final Function0 r107 = null;
        r100.f427117h.h(r103, new SubPanelController$hide$2(r100, r107));
        return;
    L22:
        r100.f427111b.q("closeHistory");
        goto L23
    L26:
        return;
    L5:
        r103 = false;
        goto L7
    }

    public final void d(SubPanelInfo r100, boolean r101) {
        if (this.f427116g.getParent() == null) goto L5;
        b(r100);
        return;
    L5:
        int r102 = d0.f427056b;
        long r103 = System.currentTimeMillis();
        if (d0.f427055a != 0) goto L9;
        d0.f427055a = r103;
    L9:
        if (this.f427110a.f555725c.isKeyboardShowing() == false) goto L18;
        rcb.c.c(this.f427110a.getActivity());
        vlb.a r104 = this.f427110a;
        View r105 = r104.f555724b;
        if (r105 != null) goto L14;
        r105 = a(r104.getActivity().getWindow());
    L14:
        Intrinsics.checkNotNull(r105);
        Runnable r106 = this.f427128s;
        if (r106 == null) goto L17;
        r105.removeCallbacks(r106);
    L17:
        c r107 = new c(r100, this, r101);
        this.f427128s = r107;
        r105.postDelayed(r107, 140);
        return;
    L18:
        e(r100, r101);
    }

    public final void e(SubPanelInfo r100, boolean r101) {
        vlb.a r102 = this.f427110a;     // Catch: Exception -> L12
        Object r103 = r102.f555724b;     // Catch: Exception -> L12
        if (r103 != null) goto L7;
        r103 = a(r102.getActivity().getWindow());     // Catch: Exception -> L12
    L7:
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L12
        if ((r103 instanceof ViewGroup) == false) goto L10;
        ((ViewGroup) r103).addView(this.f427116g);     // Catch: Exception -> L12
    L14:
        b(r100);
        this.f427117h.r(null, null);
        CreationAIDragView r104 = this.f427117h;
        r104.U = r101;
        r104.p(this.f427114e);
        return;
    L10:
        Log.e("SubPanelController", "containerView is not ViewGroup!");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.e("SubPanelController", "addToContainer error", e);
        goto L14
    }

    public g0(vlb.a r210, vlb.b r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "config");
        Intrinsics.checkNotNullParameter(r211, "callback");
        Intrinsics.checkNotNullParameter(r212, "tag");
        this.f427110a = r210;
        this.f427111b = r211;
        this.f427112c = r212;
        this.f427113d = r210.getActivity();
        LifecycleOwnerKt.getLifecycleScope(r210.getActivity());
        View r100 = LayoutInflater.from(r210.getActivity()).inflate(R.layout.creation_ai_sub_panel, null, false);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout r101 = (ConstraintLayout) r100;
        this.f427116g = r101;
        ConstraintLayout r102 = (ConstraintLayout) r101.findViewById(R.id.creation_panel_view);
        View r103 = r101.findViewById(R.id.creation_mask_full_screen);
        this.f427118i = r103;
        int r104 = com.ss.android.lark.inline.ai.utils.e.f427703a;
        r103.setBackground(com.ss.android.lark.inline.ai.utils.e.b(r210.getActivity()));
        ViewGroup r105 = (ViewGroup) r102.findViewById(R.id.creation_drag_view_wrapper);
        this.f427115f = r105;
        this.f427121l = (TextView) r102.findViewById(R.id.creation_header_title);
        ButtonGroupsRecyclerView r110 = (ButtonGroupsRecyclerView) r102.findViewById(R.id.creation_header_left_rv);
        this.f427119j = r110;
        ButtonGroupsRecyclerView r111 = (ButtonGroupsRecyclerView) r102.findViewById(R.id.creation_header_right_rv);
        this.f427120k = r111;
        ViewGroup r112 = (ViewGroup) r102.findViewById(R.id.creation_header_container);
        this.f427122m = r112;
        this.f427114e = (QuickPromptRecyclerView) r102.findViewById(R.id.rv_content);
        this.f427123n = (ViewGroup) r102.findViewById(R.id.creation_ai_loading_state_container);
        CreationAIDragView r113 = new CreationAIDragView(r210.getActivity(), r101, r102, r210.f555725c, new a(this), r210.f555726d, r210.f555727e, r210.f555728f, Intrinsics.areEqual(r212, "model_setting_panel"), r210.f555730h);
        this.f427117h = r113;
        Intrinsics.checkNotNullParameter(r105, "dragView");
        r105.setOnTouchListener(new CreationAIDragView.c(r113));
        r102.setOnClickListener(j0.f427138a);
        r112.setOnClickListener(new k0(this));
        r110.setOnOperateClickListener(new l0(this));
        r111.setOnOperateClickListener(new m0(this));
    }
}
