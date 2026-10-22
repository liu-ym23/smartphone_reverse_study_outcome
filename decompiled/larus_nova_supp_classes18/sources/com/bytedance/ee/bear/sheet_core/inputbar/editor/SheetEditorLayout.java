package com.bytedance.ee.bear.sheet_core.inputbar.editor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import qn5.b0;
import qn5.d0;
import qn5.g0;
import qn5.j0;
import qn5.k;
import qn5.k0;
import qn5.l;
import qn5.l0;
import qn5.m;
import qn5.m0;
import qn5.n0;
import qn5.o;
import qn5.o0;
import qn5.p;
import qn5.p0;
import qn5.q;
import qn5.q0;
import qn5.r;
import qn5.u;
import qn5.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetEditorLayout extends LinearLayout {
    public static final /* synthetic */ int H0 = 0;
    public h A;
    public boolean B;
    public boolean C;
    public boolean D;
    public Runnable E;
    public boolean F;
    public Runnable G;
    public int H;
    public int I;
    public boolean J;
    public String K;
    public String L;
    public String M;
    public BearUrl N;
    public v O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public String T;
    public boolean U;
    public boolean V;
    public Boolean W;
    public ScrollView a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public ImageView g;
    public View h;
    public View i;
    public SheetAtEditText j;
    public View k;
    public final e k0;
    public View l;
    public SheetAtEditText m;
    public View n;
    public View o;
    public kn4.g p;
    public final f p0;
    public boolean q;
    public int r;
    public boolean s;
    public j t;
    public wm5.b u;
    public final on5.a v;
    public wm5.a w;
    public j0 x;
    public g y;
    public o z;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ SheetEditorLayout d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            if (this.a != 0) goto L5;
            SheetEditorLayout r4 = this.d;
            int r0 = SheetEditorLayout.H0;
            r4.r();
        L6:
            SheetEditorLayout r5 = this.d;
            r5.D = false;
            Runnable r1 = r5.E;
            r5.E = null;
            if (r1 == null) goto L10;
            r1.run();
            return;
        L10:
            return;
        L5:
            this.d.b.setTranslationX(-this.b);
            this.d.n.setAlpha(1.0f);
            ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) this.d.m.getLayoutParams();
            r6.bottomMargin = this.c;
            this.d.m.setLayoutParams(r6);
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            if (this.a != 0) goto L5;
            this.d.n.setVisibility(8);
        L6:
            SheetEditorLayout r4 = this.d;
            int r0 = r4.k.getHeight();
            g r5 = r4.y;
            if (r5 == null) goto L9;
            r5.a(r0);
        L9:
            SheetEditorLayout r6 = this.d;
            r6.D = false;
            Runnable r1 = r6.E;
            r6.E = null;
            if (r1 == null) goto L13;
            r1.run();
            return;
        L13:
            return;
        L5:
            super.onAnimationEnd(r3);
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            SheetEditorLayout r4 = this.d;
            r4.D = true;
            if (1 != this.a) goto L6;
            r4.n.setVisibility(0);
            return;
        }

        public a(SheetEditorLayout r1, int r2, int r3, int r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public class b implements Consumer<Throwable> {
        public final /* synthetic */ SheetEditorLayout a;

        public b(SheetEditorLayout r1) {
            this.a = r1;
        }

        public final void accept(Object r4) throws Exception {
            tt5.a.e("SheetEditorLayout", "setSegments error", (Throwable) r4, false);
            SheetEditorLayout r5 = this.a;
            r5.s = false;
            if (r5.t != null) goto L5;
            return;
        L5:
            if (r5.getContext() == null) goto L7;
            UDToast.show(this.a.getContext(), 2131887802);
        L7:
            this.a.t.onFailed();
        }
    }

    public class c implements kn4.g.b {
        public final /* synthetic */ SheetEditorLayout a;

        public c(SheetEditorLayout r1) {
            this.a = r1;
        }

        public final void b(boolean r3) {
            SheetEditorLayout r0 = this.a;
            if (r0.B == false) goto L8;
            if (r3 == false) goto L6;
            int r4 = (int) r0.getContext().getResources().getDimension(2131168152);
        L7:
            SheetEditorLayout r1 = this.a;
            r1.a.getLayoutParams().height = r4;
            r1.a.requestLayout();
            goto L8
        L6:
            r4 = -1;
        L8:
            HashMap r5 = new HashMap();
            r5.put("click", "insert_mention");
            r5.put("target", "ccm_mention_panel_view");
            qm5.b.b("ccm_sheet_content_page_click", r5);
        }

        public final void a(int r4, int r5) {
            SheetEditorLayout r0 = this.a;
            if (r0.B == false) goto L6;
            ViewGroup.LayoutParams r1 = r0.a.getLayoutParams();
            tt5.a.b("SheetEditorLayout", "onFinderViewHeightChange(): mentionHeight=" + r4 + ",notFoundHeight=" + r5);
            r1.height = r4 - r5;
            this.a.a.requestLayout();
            return;
        }
    }

    public class d implements kn4.g.a {
        public final /* synthetic */ SheetEditorLayout a;

        public final void b() {
        }

        public final void c() {
        }

        public d(SheetEditorLayout r1) {
            this.a = r1;
        }

        public final void a(bo4.a r2) {
            if (this.a.m.getVisibility() != 0) goto L8;
            if (this.a.i.getVisibility() == 0) goto L8;
            this.a.m.G(r2);
            SheetEditorLayout.d(this.a, "fx_bar");
            return;
        L8:
            if (this.a.j.getVisibility() == 0) goto L10;
            return;
        L10:
            if (this.a.i.getVisibility() != 0) goto L15;
            this.a.j.G(r2);
            SheetEditorLayout.d(this.a, "full_screen_toolbar");
            return;
        }
    }

    public class e implements TextWatcher {
        public final /* synthetic */ SheetEditorLayout a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public e(SheetEditorLayout r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            SheetEditorLayout r3 = this.a;
            int r0 = SheetEditorLayout.H0;
            r3.w();
            if (this.a.q == false) goto L8;
            com.bytedance.ee.util.ui.j.c(new d0(this));
            h r4 = this.a.A;
            if (r4 == null) goto L9;
            ((wm5.v) r4).a();
            return;
        L9:
            return;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
            SheetEditorLayout r6 = this.a;
            int r0 = SheetEditorLayout.H0;
            r6.getClass();
            boolean r7 = false;
            if (r2 == null) goto L11;
            if (r5 <= 0) goto L11;
            int r1 = r2.length();
            int r8 = Math.max(0, Math.min(r3, r1));
            int r9 = Math.max(r8, Math.min(r5 + r8, r1));
            if (r9 <= r8) goto L11;
            if (r2.subSequence(r8, r9).toString().contains("<doc.at.~#_%=`>") == false) goto L11;
            r7 = true;
        L11:
            if (r7 == false) goto L13;
            return;
        L13:
            this.a.h(r2);
        }
    }

    public class f implements TextWatcher {
        public final /* synthetic */ SheetEditorLayout a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public f(SheetEditorLayout r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            SheetEditorLayout r3 = this.a;
            int r0 = SheetEditorLayout.H0;
            r3.w();
            if (this.a.q == false) goto L8;
            com.bytedance.ee.util.ui.j.c(new g0(this));
            h r4 = this.a.A;
            if (r4 == null) goto L9;
            ((wm5.v) r4).a();
            return;
        L9:
            return;
        }
    }

    public interface g {
        void a(int r1);
    }

    public interface h {
    }

    public interface i {
    }

    public interface j {
        void onFailed();
    }

    public void setSheetAtListener(i r1) {
    }

    public final void f() {
        kn4.g r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (this.B == false) goto L8;
        r0.i(1);
        int r1 = getResources().getDimensionPixelSize(2131168152);
    L9:
        Context r3 = getContext();
        boolean r4 = ku5.c.k(r3);
        if ((r3 instanceof Activity) == true) goto L12;
    L14:
        r2 = false;
    L15:
        tt5.a.h("SheetEditorLayout", "isMagicWindow: " + r2 + " isPad: " + r4);
        if (r4 == false) goto L19;
        if (r2 == false) goto L19;
        r1 = 0;
    L19:
        this.p.e(r1);
        this.p.update();
        return;
    L12:
        if (n.D((Activity) r3) == false) goto L14;
    L8:
        r0.i(this.k.getHeight() + getResources().getDimensionPixelSize(2131168151));
        r1 = getResources().getDimensionPixelSize(2131168151);
        goto L9
    }

    public SheetAtEditText getCurrentEditText() {
        if (this.B == false) goto L6;
        return this.j;
    L6:
        return this.m;
    }

    public Editable getFullEditable() {
        UDEditText r0 = this.j;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getEditableText();
    }

    public Editable getInputEditable() {
        UDEditText r0 = this.m;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getEditableText();
    }

    public final void j() {
        kn4.g r0 = this.p;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final void k() {
        this.m.D();
    }

    public final boolean l() {
        if (this.V == true) goto L5;
    L7:
        return false;
    L5:
        if (this.S == false) goto L7;
        return true;
    }

    public final void o() {
        tt5.a.b("SheetEditorLayout", "onHideFullScreenInput()...");
        j();
        tt5.a.b("SheetEditorLayout", "startHideFullScreenAnim()...");
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{this.k.getHeight(), getRootView().getHeight()});
        r0.setDuration(350);
        r0.setInterpolator(new AccelerateInterpolator());
        r0.addUpdateListener(new qn5.d(this));
        r0.addListener(new b0(this));
        r0.start();
    }

    public final void p() {
        tt5.a.b("SheetEditorLayout", "onHideInputBar()... editState = 2");
        if (this.P == true) goto L7;
        if (this.Q == true) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (this.k.getVisibility() != 4) goto L14;
        if (r1 == true) goto L14;
        return;
    L14:
        if (this.O == null) goto L16;
        tt5.a.h("SheetEditorLayout", "showKeyboardRunnable remove");
        removeCallbacks(this.O);
        this.O = null;
    L16:
        this.k.setVisibility(4);
        j();
        if (this.B == false) goto L19;
        SheetAtEditText r0 = this.j;
    L20:
        r0.getSegments().subscribe(new qn5.a(this), new l());
        wm5.b r2 = this.u;
        if (r2 == null) goto L23;
        r2.a();
    L23:
        r();
        this.k.removeOnLayoutChangeListener(this.z);
        return;
    L19:
        r0 = this.m;
    L7:
        if (l() == false) goto L9;
        r1 = true;
        goto L11
    }

    public final void r() {
        this.b.setTranslationX(0.0f);
        this.n.setAlpha(0.0f);
        this.n.setVisibility(8);
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
        r0.bottomMargin = 0;
        this.m.setLayoutParams(r0);
        this.C = false;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [qn5.v] */
    public final void t() {
        tt5.a.h("SheetEditorLayout", "showInputBarViews()...");
        int r1 = 0;
        setVisibility(0);
        View r2 = this.k;
        if (this.B == false) goto L5;
        int r3 = 8;
    L6:
        r2.setVisibility(r3);
        View r4 = this.i;
        if (this.B == true) goto L10;
        r1 = 8;
    L10:
        r4.setVisibility(r1);
        if (this.J == false) goto L16;
        v r5 = this.O;
        if (r5 == null) goto L15;
        removeCallbacks(r5);
        tt5.a.h("SheetEditorLayout", "showKeyboardRunnable before remove");
    L15:
        this.O = new v(this);
        tt5.a.h("SheetEditorLayout", "post show keyboard");
        post(this.O);
    L16:
        post(new qn5.b(this));
        on5.a r0 = this.v;
        r0.a = this.N;
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void v() {
        if (this.V == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Boolean r1 = this.W;
        if (r1 != null) goto L11;
    L13:
        this.W = Boolean.valueOf(r0);
        e(this.m, r0);
        e(this.j, r0);
        return;
    L11:
        if (r1.booleanValue() != r0) goto L13;
        return;
    L5:
        if (n() == false) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.widget.EditText, com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText] */
    public final void w() {
        if (this.V == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        this.S = true;
    L10:
        ImageView r3 = this.g;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r0 == false) goto L15;
        int r1 = 0;
    L17:
        if (r3.getVisibility() != r1) goto L24;
        View r4 = this.h;
        if (r4 != null) goto L21;
    L22:
        v();
        return;
    L21:
        if (r4.getVisibility() == r1) goto L22;
    L24:
        final ?? r5 = getCurrentEditText();
        final int r6 = -1;
        if (r5 != 0) goto L27;
        final int r7 = -1;
    L28:
        if (r5 == 0) goto L31;
        r6 = r5.getSelectionEnd();
    L31:
        this.U = true;
        this.g.setVisibility(r1);
        View r2 = this.h;
        if (r2 == null) goto L34;
        r2.setVisibility(r1);
    L34:
        if (r5 == 0) goto L40;
        if (r7 < 0) goto L40;
        if (r6 < r7) goto L40;
        if (r5.post(new r(this, r5, r7, r6)) == true) goto L41;
        this.U = false;
    L41:
        v();
        return;
    L40:
        this.U = false;
        goto L41
    L27:
        r7 = r5.getSelectionStart();
        goto L28
    L15:
        r1 = 8;
        goto L17
    L5:
        if (n() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final boolean n() {
        SheetAtEditText r0 = getCurrentEditText();
        if (r0 != null) goto L5;
        return false;
    L5:
        Editable r1 = r0.getText();
        if (r1 != null) goto L8;
        return false;
    L8:
        int r2 = r1.length();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L13;
        if (Character.isWhitespace(r1.charAt(r3)) == false) goto L13;
        r3 = r3 + 1;
    L13:
        if (r3 < r2) goto L15;
        return false;
    L15:
        if (r1.charAt(r3) != '=') goto L21;
        return true;
    L21:
        return false;
    }

    public SheetEditorLayout(Context r3) {
        super(r3);
        this.s = true;
        this.v = new on5.a();
        this.J = true;
        this.K = "text";
        this.L = "";
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.k0 = new e(this);
        this.p0 = new f(this);
        m(r3);
    }

    public static /* synthetic */ void a(SheetEditorLayout r1) {
        r1.setMentionAnalyticParam("full_screen_toolbar");
    }

    public static /* synthetic */ void b(SheetEditorLayout r1) {
        r1.setMentionAnalyticParam("fx_bar");
    }

    private void setEditTextContent(List<BaseSegment> r6) {
        this.s = true;
        this.q = false;
        b r1 = new b(this);
        boolean r2 = this.B;
        if (r2 == false) goto L5;
        SheetAtEditText r3 = this.m;
    L6:
        if (r2 == false) goto L8;
        SheetAtEditText r4 = this.j;
    L9:
        FormulaInputStyleData r5 = r3.getPendingFormulaStyle();
        if (this.B == false) goto L12;
        this.j.requestFocus();
        this.j.O(r6, r1);
    L13:
        if (r5 == null) goto L15;
        r4.K(r5);
    L15:
        this.q = true;
        w();
        return;
    L12:
        this.m.requestFocus();
        this.m.O(r6, r1);
        goto L13
    L8:
        r4 = this.m;
        goto L9
    L5:
        r3 = this.j;
        goto L6
    }

    private void setMentionAnalyticParam(String r3) {
        if (this.p == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("zone", r3);
        this.p.a(r0);
        return;
    }

    public final void h(CharSequence r6) {
        int r0 = this.m.getLineCount();
        String r7 = r6.toString();
        if (r7.contains("<doc.at.~#_%=`>") == false) goto L5;
        int r2 = (r7.length() - r7.replace("<doc.at.~#_%=`>", "").length()) / 15;
        float r8 = this.m.getPaint().measureText(r7.replace("<doc.at.~#_%=`>", "")) + (this.I * r2);
    L6:
        int r1 = this.r;
        if (r1 > 0) goto L9;
    L10:
        if (r0 <= 1) goto L14;
    L11:
        SheetEditorLayout r9 = this.x.a;
        if (r9.C == true) goto L18;
        r9.C = true;
        r9.u(1);
        return;
    L18:
        return;
    L14:
        SheetEditorLayout r10 = this.x.a;
        if (r10.C == false) goto L20;
        r10.C = false;
        r10.u(0);
        return;
    L20:
        return;
    L9:
        if (r8 >= r1) goto L11;
    L5:
        r8 = this.m.getPaint().measureText(r7);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [qn5.o] */
    public final void m(Context r3) {
        LayoutInflater.from(r3).inflate(2131564536, this);
        this.a = (ScrollView) findViewById(2131386161);
        this.k = findViewById(2131386160);
        this.l = findViewById(2131386167);
        com.bytedance.ee.util.ui.l.b(this.k, 2131105847);
        this.i = findViewById(2131386156);
        View r4 = findViewById(2131371383);
        this.n = r4;
        com.bytedance.ee.util.ui.l.c((ImageView) r4, 2131102418);
        View r5 = findViewById(2131371389);
        this.o = r5;
        com.bytedance.ee.util.ui.l.c((ImageView) r5, 2131102418);
        View r6 = findViewById(2131374771);
        this.b = r6;
        com.bytedance.ee.util.ui.l.b(r6, 2131105848);
        View r7 = findViewById(2131371459);
        this.c = r7;
        com.bytedance.ee.util.ui.l.c((ImageView) r7, 2131102418);
        this.m = (SheetAtEditText) findViewById(2131386158);
        this.j = (SheetAtEditText) findViewById(2131386157);
        this.d = findViewById(2131371421);
        this.e = findViewById(2131371422);
        this.g = (ImageView) findViewById(2131371406);
        this.h = findViewById(2131371407);
        com.bytedance.ee.util.ui.l.c(this.g, 2131101111);
        View r1 = findViewById(2131371460);
        this.f = r1;
        com.bytedance.ee.util.ui.l.c((ImageView) r1, 2131102418);
        this.m.setRawInputType(1);
        this.o.setOnClickListener(new n0(this));
        this.n.setOnClickListener(new o0(this));
        this.m.setPreImeListener(new p0(this));
        this.j.setPreImeListener(new q0(this));
        this.c.setOnClickListener(new com.bytedance.ee.bear.sheet_core.inputbar.editor.b(this));
        findViewById(2131371460).setOnClickListener(new com.bytedance.ee.bear.sheet_core.inputbar.editor.a(this));
        this.m.setOpenMentionListener(new qn5.e(this));
        this.j.setOpenMentionListener(new qn5.f(this));
        this.d.setOnClickListener(new l0(this));
        this.e.setOnClickListener(new m0(this));
        this.z = new o(this);
        this.x = new j0(this);
        this.m.setOnEditorActionListener(new p(this));
        this.m.addTextChangedListener(this.k0);
        this.j.addTextChangedListener(this.p0);
        SheetAtEditText.b r8 = new q(this);
        this.m.setSelectionChangeListener(r8);
        this.j.setSelectionChangeListener(r8);
        ImageView r9 = this.g;
        if (r9 == null) goto L5;
        r9.setOnClickListener(new k0(this));
    L5:
        this.I = n.d(19);
    }

    public final void q(boolean r2) {
        if (l() == true) goto L5;
        return;
    L5:
        if (this.R == true) goto L14;
        this.R = true;
        if (r2 == false) goto L10;
        this.P = true;
    L11:
        p();
        return;
    L10:
        this.Q = true;
        goto L11
    }

    public void setAtIconVisibility(int r2) {
        findViewById(2131371459).setVisibility(r2);
        findViewById(2131371460).setVisibility(r2);
    }

    public void setAtWindowShowCallback(SheetAtEditText.a r2) {
        SheetAtEditText r0 = this.j;
        if (r0 == null) goto L5;
        r0.setAtWindowShowCallback(r2);
    L5:
        SheetAtEditText r1 = this.m;
        if (r1 == null) goto L9;
        r1.setAtWindowShowCallback(r2);
        return;
    }

    public void setCellInfo(String r1) {
        this.M = r1;
    }

    public void setCellStyle(SegmentStyle r2) {
        this.m.setCellStyle(r2);
        this.j.setCellStyle(r2);
    }

    public void setCursorVisible(boolean r2) {
        this.m.setCursorVisible(r2);
        this.j.setCursorVisible(r2);
    }

    public void setDateType(String r1) {
        this.L = r1;
    }

    public void setDocumentUrl(BearUrl r1) {
        this.N = r1;
    }

    public void setEditDelegate(wm5.a r1) {
        this.w = r1;
    }

    public void setFormat(String r1) {
        this.K = r1;
    }

    public void setFormulaAssistVisible(boolean r2) {
        View r0 = this.l;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 8;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 0;
        goto L7
    }

    public void setFullScreenCallback(wm5.b r1) {
        this.u = r1;
    }

    public void setHeightChangeListener(g r1) {
        this.y = r1;
    }

    public void setInputTextChangedListener(h r1) {
        this.A = r1;
    }

    public void setMobileFormulaEditorEnabled(boolean r1) {
        this.V = r1;
        if (r1 == true) goto L5;
        this.T = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
    L5:
        w();
    }

    public void setNeedShowKeyboard(boolean r1) {
        this.J = r1;
    }

    public void setNewLineEnable(boolean r2) {
        this.d.setEnabled(r2);
        this.d.setClickable(r2);
        this.e.setEnabled(r2);
        this.e.setClickable(r2);
    }

    public void setPermDelegate(DocViewModel r3) {
        SheetAtEditText r0 = this.m;
        if (r0 == null) goto L6;
        r0.setIPermissionCopyChecker(new pn5.j(r3));
        return;
    }

    public void setShowInputResultCallBack(j r1) {
        this.t = r1;
    }

    public final void u(int r14) {
        int r0 = getResources().getDimensionPixelSize(2131168149) + getResources().getDimensionPixelSize(2131168148);
        int r1 = getResources().getDimensionPixelSize(2131168149);
        if (r14 != 0) goto L5;
        int r4 = -r0;
        int r8 = r1;
        int r5 = 0;
        int r6 = 1;
        int r7 = 0;
        int r9 = 0;
    L6:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{r4, r5});
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.n, "alpha", new float[]{r6, r7});
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r8, r9});
        r12.addUpdateListener(new u(this));
        AnimatorSet r13 = new AnimatorSet();
        r13.setDuration(300);
        r13.addListener(new a(this, r14, r0, r1));
        r13.playTogether(new Animator[]{r10, r11, r12});
        r13.start();
        return;
    L5:
        r9 = r1;
        r5 = -r0;
        r4 = 0;
        r6 = 0;
        r7 = 1;
        r8 = 0;
        goto L6
    }

    public SheetEditorLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.s = true;
        this.v = new on5.a();
        this.J = true;
        this.K = "text";
        this.L = "";
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.k0 = new e(this);
        this.p0 = new f(this);
        m(r2);
    }

    public static /* synthetic */ void c(SheetEditorLayout r0, List r1) {
        r0.setEditTextContent(r1);
    }

    public static /* synthetic */ void d(SheetEditorLayout r0, String r1) {
        r0.setMentionAnalyticParam(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(SheetAtEditText r2, boolean r3) {
        if (r2 != 0) goto L4;
        return;
    L4:
        if (r3 == false) goto L6;
        int r4 = 1073741825;
    L7:
        r2.setInputType(131073);
        r2.setImeOptions(r4);
        if (r2.hasFocus() == false) goto L13;
        InputMethodManager r5 = (InputMethodManager) getContext().getSystemService("input_method");
        if (r5 == null) goto L14;
        r5.restartInput(r2);
        return;
    L14:
        return;
    L13:
        return;
    L6:
        r4 = 5;
        goto L7
    }

    public final void g(final String r3, final String r4) {
        if (this.B == true) goto L5;
        this.m.getSegments().subscribe(new qn5.j(this, r3, r4), new k());
        return;
    L5:
        this.j.getSegments().subscribe(new m(this, r3, r4), new qn5.n());
    }

    public SheetEditorLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.s = true;
        this.v = new on5.a();
        this.J = true;
        this.K = "text";
        this.L = "";
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.k0 = new e(this);
        this.p0 = new f(this);
        m(r1);
    }

    public static boolean i(SheetAtEditText r1, int r2, int r3) {
        if (r3 >= r2) goto L5;
        return false;
    L5:
        int r4 = r1.getText().length();
        if (r2 < 0) goto L11;
        if (r3 > r4) goto L11;
        return true;
    L11:
        return false;
    }

    public final void s(List<BaseSegment> r8, String r9, int r10, boolean r11) {
        tt5.a.b("SheetEditorLayout", " show(): ");
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        if (this.m.getAtWindow() != null) goto L6;
        if (r11 == false) goto L6;
        FragmentActivity r0 = getContext();
        kn4.h r12 = new kn4.h(kn4.f.a().a(), r10, r9, "fx_bar", "text");
        r12.i = sbb.e.h.b;
        r12.p = kn4.f.a().b();
        this.m.C(r12);
        kn4.g r13 = this.m.getAtWindow();
        this.p = r13;
        this.j.setAtWindow(r13);
    L6:
        kn4.g r14 = this.p;
        if (r14 == null) goto L9;
        r14.b(new c(this));
        f();
        this.p.f(new d(this));
    L9:
        setEditTextContent(r8);
        t();
        this.k.addOnLayoutChangeListener(this.z);
    }

    public final void x(int r13, List<BaseSegment> r14, String r15, String r16, String r17) {
        if (this.s == true) goto L6;
        tt5.a.k("SheetEditorLayout", "segment parse failed!");
        return;
    L6:
        boolean r3 = true;
        int r4 = 0;
        if (r13 == 2) goto L9;
    L15:
        boolean r5 = false;
    L16:
        if (r13 != 2) goto L25;
        if (l() == false) goto L25;
        if (this.P == true) goto L25;
        if (this.Q == true) goto L25;
        return;
    L25:
        if (this.P == false) goto L28;
        this.P = false;
    L28:
        if (this.Q == false) goto L30;
        this.Q = false;
    L30:
        if (r5 == false) goto L32;
        this.S = false;
    L32:
        wm5.a r6 = this.w;
        if (r6 != null) goto L35;
        return;
    L35:
        if (this.V == true) goto L38;
        r6.updateSheetEdit(r13, r14, r15, r16, r17);
        return;
    L38:
        UDEditText r7 = getCurrentEditText();
        if (r7 == null) goto L54;
        int r8 = r7.getSelectionStart();
        int r9 = r7.getSelectionEnd();
        Editable r10 = r7.getText();
        int[] r11 = null;
        if (r10 == null) goto L48;
        int r12 = BaseInputConnection.getComposingSpanStart(r10);
        int r18 = BaseInputConnection.getComposingSpanEnd(r10);
        if (r12 < 0) goto L48;
        if (r18 < 0) goto L48;
        r11 = new int[]{r12, r18};
    L48:
        if (r11 != null) goto L50;
    L52:
        r3 = false;
    L53:
        r4 = r8;
    L56:
        if (r13 != 3) goto L58;
        String r19 = "keystroke";
    L59:
        String r20 = r19;
        if (r13 != 3) goto L70;
        if (r7 == null) goto L70;
        Editable r1 = r7.getText();
        StringBuilder r21 = new StringBuilder();
        if (r1 == null) goto L65;
        String r2 = r1.toString();
    L66:
        r21.append(r2);
        r21.append("|");
        r21.append(r4);
        r21.append("|");
        r21.append(r9);
        r21.append("|");
        r21.append(r3);
        String r22 = r21.toString();
        if (TextUtils.equals(r22, this.T) == false) goto L69;
        return;
    L69:
        this.T = r22;
        goto L70
    L65:
        r2 = "";
    L70:
        this.w.updateSheetEditWithFormulaMeta(r13, r14, r15, r16, r17, Integer.valueOf(r4), Integer.valueOf(r9), r20, Boolean.valueOf(r3));
        return;
    L58:
        r19 = "picker-confirm";
        goto L59
    L50:
        if (r11[1] <= r11[0]) goto L52;
    L54:
        r3 = false;
        r9 = 0;
        goto L56
    L9:
        if (l() == false) goto L15;
        if (this.P == false) goto L13;
    L14:
        r5 = true;
        goto L16
    L13:
        if (this.Q == false) goto L15;
        goto L14
    }
}
