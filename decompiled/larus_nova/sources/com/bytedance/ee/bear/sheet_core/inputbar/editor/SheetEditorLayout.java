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
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.at.AtConstant$Zone;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaInputStyleData;
import com.bytedance.ee.bear.sheet_core.inputbar.at.SheetAtEditText;
import com.bytedance.ee.util.ui.n;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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

/* JADX INFO: loaded from: classes18.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f238467J;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollView f238468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f238469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f238470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f238471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f238472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f238473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f238474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f238475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f238476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SheetAtEditText f238477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f238478k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final e f238479k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f238480l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SheetAtEditText f238481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f238482n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f238483o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kn4.g f238484p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final f f238485p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f238486q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f238487r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f238488s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public j f238489t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public wm5.b f238490u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final on5.a f238491v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public wm5.a f238492w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j0 f238493x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g f238494y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public o f238495z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f238496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f238497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f238498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f238499d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            if (this.f238496a != 0) goto L5;
            SheetEditorLayout r101 = this.f238499d;
            int r102 = SheetEditorLayout.H0;
            r101.r();
        L6:
            SheetEditorLayout r103 = this.f238499d;
            r103.D = false;
            Runnable r104 = r103.E;
            r103.E = null;
            if (r104 == null) goto L10;
            r104.run();
            return;
        L10:
            return;
        L5:
            this.f238499d.f238469b.setTranslationX(-this.f238497b);
            this.f238499d.f238482n.setAlpha(1.0f);
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) this.f238499d.f238481m.getLayoutParams();
            r105.bottomMargin = this.f238498c;
            this.f238499d.f238481m.setLayoutParams(r105);
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f238496a != 0) goto L5;
            this.f238499d.f238482n.setVisibility(8);
        L6:
            SheetEditorLayout r101 = this.f238499d;
            int r102 = r101.f238478k.getHeight();
            g r103 = r101.f238494y;
            if (r103 == null) goto L9;
            r103.a(r102);
        L9:
            SheetEditorLayout r104 = this.f238499d;
            r104.D = false;
            Runnable r105 = r104.E;
            r104.E = null;
            if (r105 == null) goto L13;
            r105.run();
            return;
        L13:
            return;
        L5:
            super.onAnimationEnd(r100);
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            SheetEditorLayout r101 = this.f238499d;
            r101.D = true;
            if (1 != this.f238496a) goto L6;
            r101.f238482n.setVisibility(0);
            return;
        }

        public a(SheetEditorLayout r100, int r101, int r102, int r103) {
            this.f238499d = r100;
            this.f238496a = r101;
            this.f238497b = r102;
            this.f238498c = r103;
        }
    }

    public class b implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f238500a;

        public b(SheetEditorLayout r100) {
            this.f238500a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.e("SheetEditorLayout", "setSegments error", r100, false);
            SheetEditorLayout r101 = this.f238500a;
            r101.f238488s = false;
            if (r101.f238489t != null) goto L5;
            return;
        L5:
            if (r101.getContext() == null) goto L7;
            UDToast.show(this.f238500a.getContext(), R.string.Doc_Facade_OperateFailed);
        L7:
            this.f238500a.f238489t.onFailed();
        }
    }

    public class c implements kn4.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f238501a;

        public c(SheetEditorLayout r100) {
            this.f238501a = r100;
        }

        @Override // kn4.g.b
        public final void b(boolean r100) {
            SheetEditorLayout r101 = this.f238501a;
            if (r101.B == false) goto L8;
            if (r100 == false) goto L6;
            int r102 = (int) r101.getContext().getResources().getDimension(R.dimen.sheet_edittext_margin_top);
        L7:
            SheetEditorLayout r103 = this.f238501a;
            r103.f238468a.getLayoutParams().height = r102;
            r103.f238468a.requestLayout();
            goto L8
        L6:
            r102 = -1;
        L8:
            HashMap r104 = new HashMap();
            r104.put("click", "insert_mention");
            r104.put(PickerReporterConstants.KEY.TARGET, "ccm_mention_panel_view");
            qm5.b.b("ccm_sheet_content_page_click", r104);
        }

        @Override // kn4.g.b
        public final void a(int r100, int r101) {
            SheetEditorLayout r102 = this.f238501a;
            if (r102.B == false) goto L6;
            ViewGroup.LayoutParams r103 = r102.f238468a.getLayoutParams();
            tt5.a.b("SheetEditorLayout", "onFinderViewHeightChange(): mentionHeight=" + r100 + ",notFoundHeight=" + r101);
            r103.height = r100 - r101;
            this.f238501a.f238468a.requestLayout();
            return;
        }
    }

    public class d implements kn4.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f238502a;

        @Override // kn4.g.a
        public final void b() {
        }

        @Override // kn4.g.a
        public final void c() {
        }

        public d(SheetEditorLayout r100) {
            this.f238502a = r100;
        }

        @Override // kn4.g.a
        public final void a(bo4.a r100) {
            if (this.f238502a.f238481m.getVisibility() != 0) goto L8;
            if (this.f238502a.f238476i.getVisibility() == 0) goto L8;
            this.f238502a.f238481m.G(r100);
            SheetEditorLayout.d(this.f238502a, AtConstant$Zone.FX_BAR);
            return;
        L8:
            if (this.f238502a.f238477j.getVisibility() == 0) goto L10;
            return;
        L10:
            if (this.f238502a.f238476i.getVisibility() != 0) goto L15;
            this.f238502a.f238477j.G(r100);
            SheetEditorLayout.d(this.f238502a, AtConstant$Zone.FULL_SCREEN_TOOLBAR);
            return;
        }
    }

    public class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f238503a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public e(SheetEditorLayout r100) {
            this.f238503a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            SheetEditorLayout r101 = this.f238503a;
            int r102 = SheetEditorLayout.H0;
            r101.w();
            if (this.f238503a.f238486q == false) goto L8;
            com.bytedance.ee.util.ui.j.c(new d0(this));
            h r103 = this.f238503a.A;
            if (r103 == null) goto L9;
            ((wm5.v) r103).a();
            return;
        L9:
            return;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            SheetEditorLayout r104 = this.f238503a;
            int r105 = SheetEditorLayout.H0;
            r104.getClass();
            boolean r106 = false;
            if (r100 == null) goto L11;
            if (r103 <= 0) goto L11;
            int r107 = r100.length();
            int r108 = Math.max(0, Math.min(r101, r107));
            int r109 = Math.max(r108, Math.min(r103 + r108, r107));
            if (r109 <= r108) goto L11;
            if (r100.subSequence(r108, r109).toString().contains("<doc.at.~#_%=`>") == false) goto L11;
            r106 = true;
        L11:
            if (r106 == false) goto L13;
            return;
        L13:
            this.f238503a.h(r100);
        }
    }

    public class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f238504a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public f(SheetEditorLayout r100) {
            this.f238504a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            SheetEditorLayout r101 = this.f238504a;
            int r102 = SheetEditorLayout.H0;
            r101.w();
            if (this.f238504a.f238486q == false) goto L8;
            com.bytedance.ee.util.ui.j.c(new g0(this));
            h r103 = this.f238504a.A;
            if (r103 == null) goto L9;
            ((wm5.v) r103).a();
            return;
        L9:
            return;
        }
    }

    public interface g {
        void a(int r100);
    }

    public interface h {
    }

    public interface i {
    }

    public interface j {
        void onFailed();
    }

    public void setSheetAtListener(i r100) {
    }

    public final void f() {
        kn4.g r100 = this.f238484p;
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = true;
        if (this.B == false) goto L8;
        r100.i(1);
        int r102 = getResources().getDimensionPixelSize(R.dimen.sheet_edittext_margin_top);
    L9:
        Context r103 = getContext();
        boolean r104 = ku5.c.k(r103);
        if ((r103 instanceof Activity) == true) goto L12;
    L14:
        r101 = false;
    L15:
        tt5.a.h("SheetEditorLayout", "isMagicWindow: " + r101 + " isPad: " + r104);
        if (r104 == false) goto L19;
        if (r101 == false) goto L19;
        r102 = 0;
    L19:
        this.f238484p.e(r102);
        this.f238484p.update();
        return;
    L12:
        if (n.D((Activity) r103) == false) goto L14;
    L8:
        r100.i(this.f238478k.getHeight() + getResources().getDimensionPixelSize(R.dimen.sheet_edit_toolbar_height));
        r102 = getResources().getDimensionPixelSize(R.dimen.sheet_edit_toolbar_height);
        goto L9
    }

    public SheetAtEditText getCurrentEditText() {
        if (this.B == false) goto L6;
        return this.f238477j;
    L6:
        return this.f238481m;
    }

    public Editable getFullEditable() {
        SheetAtEditText r100 = this.f238477j;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getEditableText();
    }

    public Editable getInputEditable() {
        SheetAtEditText r100 = this.f238481m;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getEditableText();
    }

    public final void j() {
        kn4.g r100 = this.f238484p;
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    public final void k() {
        this.f238481m.D();
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
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{this.f238478k.getHeight(), getRootView().getHeight()});
        r100.setDuration(350);
        r100.setInterpolator(new AccelerateInterpolator());
        r100.addUpdateListener(new qn5.d(this));
        r100.addListener(new b0(this));
        r100.start();
    }

    public final void p() {
        tt5.a.b("SheetEditorLayout", "onHideInputBar()... editState = 2");
        if (this.P == true) goto L7;
        if (this.Q == true) goto L7;
    L9:
        boolean r100 = false;
    L11:
        if (this.f238478k.getVisibility() != 4) goto L14;
        if (r100 == true) goto L14;
        return;
    L14:
        if (this.O == null) goto L16;
        tt5.a.h("SheetEditorLayout", "showKeyboardRunnable remove");
        removeCallbacks(this.O);
        this.O = null;
    L16:
        this.f238478k.setVisibility(4);
        j();
        if (this.B == false) goto L19;
        SheetAtEditText r101 = this.f238477j;
    L20:
        r101.getSegments().subscribe(new qn5.a(this), new l());
        wm5.b r102 = this.f238490u;
        if (r102 == null) goto L23;
        r102.a();
    L23:
        r();
        this.f238478k.removeOnLayoutChangeListener(this.f238495z);
        return;
    L19:
        r101 = this.f238481m;
    L7:
        if (l() == false) goto L9;
        r100 = true;
        goto L11
    }

    public final void r() {
        this.f238469b.setTranslationX(0.0f);
        this.f238482n.setAlpha(0.0f);
        this.f238482n.setVisibility(8);
        ViewGroup.MarginLayoutParams r100 = (ViewGroup.MarginLayoutParams) this.f238481m.getLayoutParams();
        r100.bottomMargin = 0;
        this.f238481m.setLayoutParams(r100);
        this.C = false;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [qn5.v] */
    public final void t() {
        tt5.a.h("SheetEditorLayout", "showInputBarViews()...");
        int r100 = 0;
        setVisibility(0);
        View r101 = this.f238478k;
        if (this.B == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        View r103 = this.f238476i;
        if (this.B == true) goto L10;
        r100 = 8;
    L10:
        r103.setVisibility(r100);
        if (this.f238467J == false) goto L16;
        v r104 = this.O;
        if (r104 == null) goto L15;
        removeCallbacks(r104);
        tt5.a.h("SheetEditorLayout", "showKeyboardRunnable before remove");
    L15:
        this.O = new v(this);
        tt5.a.h("SheetEditorLayout", "post show keyboard");
        post(this.O);
    L16:
        post(new qn5.b(this));
        on5.a r105 = this.f238491v;
        r105.f524353a = this.N;
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void v() {
        if (this.V == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        Boolean r101 = this.W;
        if (r101 != null) goto L11;
    L13:
        this.W = Boolean.valueOf(r100);
        e(this.f238481m, r100);
        e(this.f238477j, r100);
        return;
    L11:
        if (r101.booleanValue() != r100) goto L13;
        return;
    L5:
        if (n() == false) goto L7;
        r100 = true;
        goto L8
    }

    public final void w() {
        if (this.V == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        this.S = true;
    L10:
        ImageView r101 = this.f238474g;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r100 == false) goto L15;
        int r102 = 0;
    L17:
        if (r101.getVisibility() != r102) goto L24;
        View r103 = this.f238475h;
        if (r103 != null) goto L21;
    L22:
        v();
        return;
    L21:
        if (r103.getVisibility() == r102) goto L22;
    L24:
        final SheetAtEditText r104 = getCurrentEditText();
        final int r105 = -1;
        if (r104 != null) goto L27;
        final int r106 = -1;
    L28:
        if (r104 == null) goto L31;
        r105 = r104.getSelectionEnd();
    L31:
        this.U = true;
        this.f238474g.setVisibility(r102);
        View r107 = this.f238475h;
        if (r107 == null) goto L34;
        r107.setVisibility(r102);
    L34:
        if (r104 == null) goto L40;
        if (r106 < 0) goto L40;
        if (r105 < r106) goto L40;
        if (r104.post(new r(this, r104, r106, r105)) == true) goto L41;
        this.U = false;
    L41:
        v();
        return;
    L40:
        this.U = false;
        goto L41
    L27:
        r106 = r104.getSelectionStart();
        goto L28
    L15:
        r102 = 8;
        goto L17
    L5:
        if (n() == false) goto L7;
        r100 = true;
        goto L8
    }

    public final boolean n() {
        SheetAtEditText r100 = getCurrentEditText();
        if (r100 != null) goto L5;
        return false;
    L5:
        Editable r101 = r100.getText();
        if (r101 != null) goto L8;
        return false;
    L8:
        int r102 = r101.length();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L13;
        if (Character.isWhitespace(r101.charAt(r103)) == false) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 < r102) goto L15;
        return false;
    L15:
        if (r101.charAt(r103) != '=') goto L21;
        return true;
    L21:
        return false;
    }

    public SheetEditorLayout(Context r100) {
        super(r100);
        this.f238488s = true;
        this.f238491v = new on5.a();
        this.f238467J = true;
        this.K = "text";
        this.L = "";
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.f238479k0 = new e(this);
        this.f238485p0 = new f(this);
        m(r100);
    }

    public static /* synthetic */ void a(SheetEditorLayout r100) {
        r100.setMentionAnalyticParam(AtConstant$Zone.FULL_SCREEN_TOOLBAR);
    }

    public static /* synthetic */ void b(SheetEditorLayout r100) {
        r100.setMentionAnalyticParam(AtConstant$Zone.FX_BAR);
    }

    private void setEditTextContent(List<BaseSegment> r100) {
        this.f238488s = true;
        this.f238486q = false;
        b r101 = new b(this);
        boolean r102 = this.B;
        if (r102 == false) goto L5;
        SheetAtEditText r103 = this.f238481m;
    L6:
        if (r102 == false) goto L8;
        SheetAtEditText r104 = this.f238477j;
    L9:
        FormulaInputStyleData r105 = r103.getPendingFormulaStyle();
        if (this.B == false) goto L12;
        this.f238477j.requestFocus();
        this.f238477j.O(r100, r101);
    L13:
        if (r105 == null) goto L15;
        r104.K(r105);
    L15:
        this.f238486q = true;
        w();
        return;
    L12:
        this.f238481m.requestFocus();
        this.f238481m.O(r100, r101);
        goto L13
    L8:
        r104 = this.f238481m;
        goto L9
    L5:
        r103 = this.f238477j;
        goto L6
    }

    private void setMentionAnalyticParam(String r100) {
        if (this.f238484p == null) goto L6;
        HashMap r101 = new HashMap();
        r101.put("zone", r100);
        this.f238484p.a(r101);
        return;
    }

    public final void h(CharSequence r100) {
        int r101 = this.f238481m.getLineCount();
        String r102 = r100.toString();
        if (r102.contains("<doc.at.~#_%=`>") == false) goto L5;
        int r103 = (r102.length() - r102.replace("<doc.at.~#_%=`>", "").length()) / 15;
        float r104 = this.f238481m.getPaint().measureText(r102.replace("<doc.at.~#_%=`>", "")) + (this.I * r103);
    L6:
        int r105 = this.f238487r;
        if (r105 > 0) goto L9;
    L10:
        if (r101 <= 1) goto L14;
    L11:
        SheetEditorLayout r106 = this.f238493x.f534052a;
        if (r106.C == true) goto L18;
        r106.C = true;
        r106.u(1);
        return;
    L18:
        return;
    L14:
        SheetEditorLayout r107 = this.f238493x.f534052a;
        if (r107.C == false) goto L20;
        r107.C = false;
        r107.u(0);
        return;
    L20:
        return;
    L9:
        if (r104 >= r105) goto L11;
    L5:
        r104 = this.f238481m.getPaint().measureText(r102);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [qn5.o] */
    public final void m(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.sheet_core_edit_input, this);
        this.f238468a = (ScrollView) findViewById(R.id.sheet_edit_scroll_view);
        this.f238478k = findViewById(R.id.sheet_edit_input_layout);
        this.f238480l = findViewById(R.id.sheet_editor_top_divider);
        com.bytedance.ee.util.ui.l.b(this.f238478k, R.color.sheet_edit_input_bar_bg);
        this.f238476i = findViewById(R.id.sheet_edit_full_layout);
        View r101 = findViewById(R.id.editExpand);
        this.f238482n = r101;
        com.bytedance.ee.util.ui.l.c((ImageView) r101, R.color.icon_n1);
        View r102 = findViewById(R.id.editUnexpand);
        this.f238483o = r102;
        com.bytedance.ee.util.ui.l.c((ImageView) r102, R.color.icon_n1);
        View r103 = findViewById(R.id.icon_layout);
        this.f238469b = r103;
        com.bytedance.ee.util.ui.l.b(r103, R.color.sheet_edit_input_icon_layout_bg);
        View r104 = findViewById(R.id.edit_sheet_at);
        this.f238470c = r104;
        com.bytedance.ee.util.ui.l.c((ImageView) r104, R.color.icon_n1);
        this.f238481m = (SheetAtEditText) findViewById(R.id.sheet_edit_input);
        this.f238477j = (SheetAtEditText) findViewById(R.id.sheet_edit_full_screen_input);
        this.f238471d = findViewById(R.id.edit_new_line);
        this.f238472e = findViewById(R.id.edit_new_line_full);
        this.f238474g = (ImageView) findViewById(R.id.edit_formula_done);
        this.f238475h = findViewById(R.id.edit_formula_done_separator);
        com.bytedance.ee.util.ui.l.c(this.f238474g, R.color.colorful_blue);
        View r105 = findViewById(R.id.edit_sheet_at_full);
        this.f238473f = r105;
        com.bytedance.ee.util.ui.l.c((ImageView) r105, R.color.icon_n1);
        this.f238481m.setRawInputType(1);
        this.f238483o.setOnClickListener(new n0(this));
        this.f238482n.setOnClickListener(new o0(this));
        this.f238481m.setPreImeListener(new p0(this));
        this.f238477j.setPreImeListener(new q0(this));
        this.f238470c.setOnClickListener(new com.bytedance.ee.bear.sheet_core.inputbar.editor.b(this));
        findViewById(R.id.edit_sheet_at_full).setOnClickListener(new com.bytedance.ee.bear.sheet_core.inputbar.editor.a(this));
        this.f238481m.setOpenMentionListener(new qn5.e(this));
        this.f238477j.setOpenMentionListener(new qn5.f(this));
        this.f238471d.setOnClickListener(new l0(this));
        this.f238472e.setOnClickListener(new m0(this));
        this.f238495z = new o(this);
        this.f238493x = new j0(this);
        this.f238481m.setOnEditorActionListener(new p(this));
        this.f238481m.addTextChangedListener(this.f238479k0);
        this.f238477j.addTextChangedListener(this.f238485p0);
        SheetAtEditText.b r106 = new q(this);
        this.f238481m.setSelectionChangeListener(r106);
        this.f238477j.setSelectionChangeListener(r106);
        ImageView r107 = this.f238474g;
        if (r107 == null) goto L5;
        r107.setOnClickListener(new k0(this));
    L5:
        this.I = n.d(19);
    }

    public final void q(boolean r100) {
        if (l() == true) goto L5;
        return;
    L5:
        if (this.R == true) goto L14;
        this.R = true;
        if (r100 == false) goto L10;
        this.P = true;
    L11:
        p();
        return;
    L10:
        this.Q = true;
        goto L11
    }

    public void setAtIconVisibility(int r100) {
        findViewById(R.id.edit_sheet_at).setVisibility(r100);
        findViewById(R.id.edit_sheet_at_full).setVisibility(r100);
    }

    public void setAtWindowShowCallback(SheetAtEditText.a r100) {
        SheetAtEditText r101 = this.f238477j;
        if (r101 == null) goto L5;
        r101.setAtWindowShowCallback(r100);
    L5:
        SheetAtEditText r102 = this.f238481m;
        if (r102 == null) goto L9;
        r102.setAtWindowShowCallback(r100);
        return;
    }

    public void setCellInfo(String r100) {
        this.M = r100;
    }

    public void setCellStyle(SegmentStyle r100) {
        this.f238481m.setCellStyle(r100);
        this.f238477j.setCellStyle(r100);
    }

    public void setCursorVisible(boolean r100) {
        this.f238481m.setCursorVisible(r100);
        this.f238477j.setCursorVisible(r100);
    }

    public void setDateType(String r100) {
        this.L = r100;
    }

    public void setDocumentUrl(BearUrl r100) {
        this.N = r100;
    }

    public void setEditDelegate(wm5.a r100) {
        this.f238492w = r100;
    }

    public void setFormat(String r100) {
        this.K = r100;
    }

    public void setFormulaAssistVisible(boolean r100) {
        View r101 = this.f238480l;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 8;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public void setFullScreenCallback(wm5.b r100) {
        this.f238490u = r100;
    }

    public void setHeightChangeListener(g r100) {
        this.f238494y = r100;
    }

    public void setInputTextChangedListener(h r100) {
        this.A = r100;
    }

    public void setMobileFormulaEditorEnabled(boolean r100) {
        this.V = r100;
        if (r100 == true) goto L5;
        this.T = null;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
    L5:
        w();
    }

    public void setNeedShowKeyboard(boolean r100) {
        this.f238467J = r100;
    }

    public void setNewLineEnable(boolean r100) {
        this.f238471d.setEnabled(r100);
        this.f238471d.setClickable(r100);
        this.f238472e.setEnabled(r100);
        this.f238472e.setClickable(r100);
    }

    public void setPermDelegate(DocViewModel r100) {
        SheetAtEditText r101 = this.f238481m;
        if (r101 == null) goto L6;
        r101.setIPermissionCopyChecker(new pn5.j(r100));
        return;
    }

    public void setShowInputResultCallBack(j r100) {
        this.f238489t = r100;
    }

    public final void u(int r110) {
        int r100 = getResources().getDimensionPixelSize(R.dimen.sheet_edit_icon_size) + getResources().getDimensionPixelSize(R.dimen.sheet_edit_icon_margin);
        int r101 = getResources().getDimensionPixelSize(R.dimen.sheet_edit_icon_size);
        if (r110 != 0) goto L5;
        int r102 = -r100;
        int r103 = r101;
        int r104 = 0;
        int r105 = 1;
        int r106 = 0;
        int r107 = 0;
    L6:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this.f238469b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, r104});
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this.f238482n, "alpha", new float[]{r105, r106});
        ValueAnimator r111 = ValueAnimator.ofInt(new int[]{r103, r107});
        r111.addUpdateListener(new u(this));
        AnimatorSet r112 = new AnimatorSet();
        r112.setDuration(300);
        r112.addListener(new a(this, r110, r100, r101));
        r112.playTogether(new Animator[]{r108, r109, r111});
        r112.start();
        return;
    L5:
        r107 = r101;
        r104 = -r100;
        r102 = 0;
        r105 = 0;
        r106 = 1;
        r103 = 0;
        goto L6
    }

    public SheetEditorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f238488s = true;
        this.f238491v = new on5.a();
        this.f238467J = true;
        this.K = "text";
        this.L = "";
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.f238479k0 = new e(this);
        this.f238485p0 = new f(this);
        m(r100);
    }

    public static /* synthetic */ void c(SheetEditorLayout r100, List r101) {
        r100.setEditTextContent(r101);
    }

    public static /* synthetic */ void d(SheetEditorLayout r100, String r101) {
        r100.setMentionAnalyticParam(r101);
    }

    public final void e(SheetAtEditText r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == false) goto L6;
        int r102 = 1073741825;
    L7:
        r100.setInputType(131073);
        r100.setImeOptions(r102);
        if (r100.hasFocus() == false) goto L13;
        InputMethodManager r103 = (InputMethodManager) getContext().getSystemService("input_method");
        if (r103 == null) goto L14;
        r103.restartInput(r100);
        return;
    L14:
        return;
    L13:
        return;
    L6:
        r102 = 5;
        goto L7
    }

    public final void g(final String r100, final String r101) {
        if (this.B == true) goto L5;
        this.f238481m.getSegments().subscribe(new qn5.j(this, r100, r101), new k());
        return;
    L5:
        this.f238477j.getSegments().subscribe(new m(this, r100, r101), new qn5.n());
    }

    public SheetEditorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f238488s = true;
        this.f238491v = new on5.a();
        this.f238467J = true;
        this.K = "text";
        this.L = "";
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.U = false;
        this.V = false;
        this.f238479k0 = new e(this);
        this.f238485p0 = new f(this);
        m(r100);
    }

    public static boolean i(SheetAtEditText r100, int r101, int r102) {
        if (r102 >= r101) goto L5;
        return false;
    L5:
        int r103 = r100.getText().length();
        if (r101 < 0) goto L11;
        if (r102 > r103) goto L11;
        return true;
    L11:
        return false;
    }

    public final void s(List<BaseSegment> r100, String r101, int r110, boolean r111) {
        tt5.a.b("SheetEditorLayout", " show(): ");
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        if (this.f238481m.getAtWindow() != null) goto L6;
        if (r111 == false) goto L6;
        FragmentActivity r102 = (FragmentActivity) getContext();
        kn4.h r112 = new kn4.h(kn4.f.a().a(), r110, r101, AtConstant$Zone.FX_BAR, "text");
        r112.f504238i = sbb.e.f541297h.f541317b;
        r112.f504245p = kn4.f.a().b();
        this.f238481m.C(r112);
        kn4.g r103 = this.f238481m.getAtWindow();
        this.f238484p = r103;
        this.f238477j.setAtWindow(r103);
    L6:
        kn4.g r104 = this.f238484p;
        if (r104 == null) goto L9;
        r104.b(new c(this));
        f();
        this.f238484p.f(new d(this));
    L9:
        setEditTextContent(r100);
        t();
        this.f238478k.addOnLayoutChangeListener(this.f238495z);
    }

    public final void x(int r110, List<BaseSegment> r111, String r112, String r113, String r114) {
        if (this.f238488s == true) goto L6;
        tt5.a.k("SheetEditorLayout", "segment parse failed!");
        return;
    L6:
        boolean r100 = true;
        int r101 = 0;
        if (r110 == 2) goto L9;
    L15:
        boolean r102 = false;
    L16:
        if (r110 != 2) goto L25;
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
        if (r102 == false) goto L32;
        this.S = false;
    L32:
        wm5.a r103 = this.f238492w;
        if (r103 != null) goto L35;
        return;
    L35:
        if (this.V == true) goto L38;
        r103.updateSheetEdit(r110, r111, r112, r113, r114);
        return;
    L38:
        SheetAtEditText r104 = getCurrentEditText();
        if (r104 == null) goto L54;
        int r105 = r104.getSelectionStart();
        int r106 = r104.getSelectionEnd();
        Editable r107 = r104.getText();
        int[] r108 = null;
        if (r107 == null) goto L48;
        int r115 = BaseInputConnection.getComposingSpanStart(r107);
        int r109 = BaseInputConnection.getComposingSpanEnd(r107);
        if (r115 < 0) goto L48;
        if (r109 < 0) goto L48;
        r108 = new int[]{r115, r109};
    L48:
        if (r108 != null) goto L50;
    L52:
        r100 = false;
    L53:
        r101 = r105;
    L56:
        if (r110 != 3) goto L58;
        String r116 = "keystroke";
    L59:
        String r117 = r116;
        if (r110 != 3) goto L70;
        if (r104 == null) goto L70;
        Editable r118 = r104.getText();
        StringBuilder r119 = new StringBuilder();
        if (r118 == null) goto L65;
        String r120 = r118.toString();
    L66:
        r119.append(r120);
        r119.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r119.append(r101);
        r119.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r119.append(r106);
        r119.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r119.append(r100);
        String r121 = r119.toString();
        if (TextUtils.equals(r121, this.T) == false) goto L69;
        return;
    L69:
        this.T = r121;
        goto L70
    L65:
        r120 = "";
    L70:
        this.f238492w.updateSheetEditWithFormulaMeta(r110, r111, r112, r113, r114, Integer.valueOf(r101), Integer.valueOf(r106), r117, Boolean.valueOf(r100));
        return;
    L58:
        r116 = "picker-confirm";
        goto L59
    L50:
        if (r108[1] <= r108[0]) goto L52;
    L54:
        r100 = false;
        r106 = 0;
        goto L56
    L9:
        if (l() == false) goto L15;
        if (this.P == false) goto L13;
    L14:
        r102 = true;
        goto L16
    L13:
        if (this.Q == false) goto L15;
        goto L14
    }
}
