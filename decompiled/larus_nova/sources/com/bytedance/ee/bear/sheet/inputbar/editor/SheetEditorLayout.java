package com.bytedance.ee.bear.sheet.inputbar.editor;

import an5.b0;
import an5.d0;
import an5.g0;
import an5.j0;
import an5.k;
import an5.k0;
import an5.l0;
import an5.m0;
import an5.n0;
import an5.o;
import an5.o0;
import an5.p;
import an5.p0;
import an5.q;
import an5.r;
import an5.u;
import an5.v;
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
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import wm5.c1;

/* JADX INFO: loaded from: classes18.dex */
public class SheetEditorLayout extends LinearLayout {
    public static final /* synthetic */ int H0 = 0;
    public j0 A;
    public g B;
    public an5.a C;
    public h D;
    public boolean E;
    public boolean F;
    public boolean G;
    public Runnable H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Runnable f237944J;
    public int K;
    public int L;
    public boolean M;
    public String N;
    public String O;
    public String P;
    public BearUrl Q;
    public u R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public Boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollView f237945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f237946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f237947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f237948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f237949e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f237950f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f237951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f237952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f237953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SheetAtEditText f237954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f237955k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final e f237956k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f237957l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SheetAtEditText f237958m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f237959n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f237960o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kn4.g f237961p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final f f237962p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f237963q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f237964r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f237965s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f237966t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f237967u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f237968v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j f237969w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public wm5.b f237970x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final qm5.a f237971y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public wm5.a f237972z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f237973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f237974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f237975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f237976d;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            if (this.f237973a != 0) goto L5;
            SheetEditorLayout r101 = this.f237976d;
            int r102 = SheetEditorLayout.H0;
            r101.r();
        L6:
            SheetEditorLayout r103 = this.f237976d;
            r103.G = false;
            Runnable r104 = r103.H;
            r103.H = null;
            if (r104 == null) goto L10;
            r104.run();
            return;
        L10:
            return;
        L5:
            this.f237976d.f237946b.setTranslationX(-this.f237974b);
            this.f237976d.f237959n.setAlpha(1.0f);
            ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) this.f237976d.f237958m.getLayoutParams();
            r105.bottomMargin = this.f237975c;
            this.f237976d.f237958m.setLayoutParams(r105);
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (this.f237973a != 0) goto L5;
            this.f237976d.f237959n.setVisibility(8);
        L6:
            SheetEditorLayout r101 = this.f237976d;
            int r102 = r101.f237955k.getHeight();
            g r103 = r101.B;
            if (r103 == null) goto L9;
            r103.a(r102);
        L9:
            SheetEditorLayout r104 = this.f237976d;
            r104.G = false;
            Runnable r105 = r104.H;
            r104.H = null;
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
            SheetEditorLayout r101 = this.f237976d;
            r101.G = true;
            if (1 != this.f237973a) goto L6;
            r101.f237959n.setVisibility(0);
            return;
        }

        public a(SheetEditorLayout r100, int r101, int r102, int r103) {
            this.f237976d = r100;
            this.f237973a = r101;
            this.f237974b = r102;
            this.f237975c = r103;
        }
    }

    public class b implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f237977a;

        public b(SheetEditorLayout r100) {
            this.f237977a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.e("SheetEditorLayout", "setSegments error", r100, false);
            SheetEditorLayout r101 = this.f237977a;
            r101.f237968v = false;
            if (r101.f237969w != null) goto L5;
            return;
        L5:
            if (r101.getContext() == null) goto L7;
            UDToast.show(this.f237977a.getContext(), R.string.Doc_Facade_OperateFailed);
        L7:
            this.f237977a.f237969w.onFailed();
        }
    }

    public class c implements kn4.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f237978a;

        public c(SheetEditorLayout r100) {
            this.f237978a = r100;
        }

        @Override // kn4.g.b
        public final void b(boolean r100) {
            SheetEditorLayout r101 = this.f237978a;
            if (r101.E == false) goto L8;
            if (r100 == false) goto L6;
            int r102 = (int) r101.getContext().getResources().getDimension(R.dimen.sheet_edittext_margin_top);
        L7:
            SheetEditorLayout r103 = this.f237978a;
            r103.f237945a.getLayoutParams().height = r102;
            r103.f237945a.requestLayout();
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
            SheetEditorLayout r102 = this.f237978a;
            if (r102.E == false) goto L6;
            ViewGroup.LayoutParams r103 = r102.f237945a.getLayoutParams();
            tt5.a.b("SheetEditorLayout", "onFinderViewHeightChange(): mentionHeight=" + r100 + ",notFoundHeight=" + r101);
            r103.height = r100 - r101;
            this.f237978a.f237945a.requestLayout();
            return;
        }
    }

    public class d implements kn4.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f237979a;

        @Override // kn4.g.a
        public final void b() {
        }

        @Override // kn4.g.a
        public final void c() {
        }

        public d(SheetEditorLayout r100) {
            this.f237979a = r100;
        }

        @Override // kn4.g.a
        public final void a(bo4.a r100) {
            if (this.f237979a.f237958m.getVisibility() != 0) goto L8;
            if (this.f237979a.f237953i.getVisibility() == 0) goto L8;
            this.f237979a.f237958m.G(r100);
            SheetEditorLayout.d(this.f237979a, AtConstant$Zone.FX_BAR);
            return;
        L8:
            if (this.f237979a.f237954j.getVisibility() == 0) goto L10;
            return;
        L10:
            if (this.f237979a.f237953i.getVisibility() != 0) goto L15;
            this.f237979a.f237954j.G(r100);
            SheetEditorLayout.d(this.f237979a, AtConstant$Zone.FULL_SCREEN_TOOLBAR);
            return;
        }
    }

    public class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f237980a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public e(SheetEditorLayout r100) {
            this.f237980a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            SheetEditorLayout r101 = this.f237980a;
            int r102 = SheetEditorLayout.H0;
            r101.w();
            if (this.f237980a.f237963q == false) goto L8;
            com.bytedance.ee.util.ui.j.c(new d0(this));
            h r103 = this.f237980a.D;
            if (r103 == null) goto L9;
            ((c1) r103).a();
            return;
        L9:
            return;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            SheetEditorLayout r104 = this.f237980a;
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
            this.f237980a.h(r100);
        }
    }

    public class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetEditorLayout f237981a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public f(SheetEditorLayout r100) {
            this.f237981a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            SheetEditorLayout r101 = this.f237981a;
            int r102 = SheetEditorLayout.H0;
            r101.w();
            if (this.f237981a.f237963q == false) goto L8;
            com.bytedance.ee.util.ui.j.c(new g0(this));
            h r103 = this.f237981a.D;
            if (r103 == null) goto L9;
            ((c1) r103).a();
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
        boolean r100 = true;
        if (this.E == false) goto L5;
        this.f237961p.i(1);
        int r101 = getResources().getDimensionPixelSize(R.dimen.sheet_edittext_margin_top);
    L6:
        Context r102 = getContext();
        boolean r103 = ku5.c.k(r102);
        if ((r102 instanceof Activity) == true) goto L9;
    L11:
        r100 = false;
    L12:
        tt5.a.h("SheetEditorLayout", "isMagicWindow: " + r100 + " isPad: " + r103);
        if (r103 == false) goto L16;
        if (r100 == false) goto L16;
        r101 = 0;
    L16:
        this.f237961p.e(r101);
        this.f237961p.update();
        return;
    L9:
        if (n.D((Activity) r102) == false) goto L11;
    L5:
        this.f237961p.i(this.f237955k.getHeight() + getResources().getDimensionPixelSize(R.dimen.sheet_edit_toolbar_height));
        r101 = getResources().getDimensionPixelSize(R.dimen.sheet_edit_toolbar_height);
        goto L6
    }

    public SheetAtEditText getCurrentEditText() {
        if (this.E == false) goto L6;
        return this.f237954j;
    L6:
        return this.f237958m;
    }

    public Editable getFullEditable() {
        SheetAtEditText r100 = this.f237954j;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getEditableText();
    }

    public Editable getInputEditable() {
        SheetAtEditText r100 = this.f237958m;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getEditableText();
    }

    public final void j() {
        kn4.g r100 = this.f237961p;
        if (r100 == null) goto L6;
        r100.j();
        return;
    }

    public final void k() {
        this.f237958m.D();
    }

    public final boolean l() {
        if (this.f237967u == true) goto L5;
    L7:
        return false;
    L5:
        if (this.V == false) goto L7;
        return true;
    }

    public final void o() {
        tt5.a.b("SheetEditorLayout", "onHideFullScreenInput()...");
        j();
        tt5.a.b("SheetEditorLayout", "startHideFullScreenAnim()...");
        ValueAnimator r100 = ValueAnimator.ofInt(new int[]{this.f237955k.getHeight(), getRootView().getHeight()});
        r100.setDuration(350);
        r100.setInterpolator(new AccelerateInterpolator());
        r100.addUpdateListener(new an5.d(this));
        r100.addListener(new b0(this));
        r100.start();
    }

    public final void p() {
        tt5.a.b("SheetEditorLayout", "onHideInputBar()... editState = 2");
        if (this.S == true) goto L7;
        if (this.T == true) goto L7;
    L9:
        boolean r100 = false;
    L11:
        if (this.f237955k.getVisibility() != 4) goto L14;
        if (r100 == true) goto L14;
        return;
    L14:
        if (this.R == null) goto L16;
        tt5.a.h("SheetEditorLayout", "showKeyboardRunnable remove");
        removeCallbacks(this.R);
        this.R = null;
    L16:
        this.f237955k.setVisibility(4);
        j();
        if (this.E == false) goto L19;
        SheetAtEditText r101 = this.f237954j;
    L20:
        r101.getSegments().subscribe(new p(this), new q());
        wm5.b r102 = this.f237970x;
        if (r102 == null) goto L23;
        r102.a();
    L23:
        r();
        this.f237955k.removeOnLayoutChangeListener(this.C);
        return;
    L19:
        r101 = this.f237958m;
    L7:
        if (l() == false) goto L9;
        r100 = true;
        goto L11
    }

    public final void r() {
        this.f237946b.setTranslationX(0.0f);
        this.f237959n.setAlpha(0.0f);
        this.f237959n.setVisibility(8);
        ViewGroup.MarginLayoutParams r100 = (ViewGroup.MarginLayoutParams) this.f237958m.getLayoutParams();
        r100.bottomMargin = 0;
        this.f237958m.setLayoutParams(r100);
        this.F = false;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [an5.u] */
    public final void t() {
        tt5.a.h("SheetEditorLayout", "showInputBarViews()...");
        int r100 = 0;
        setVisibility(0);
        View r101 = this.f237955k;
        if (this.E == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        View r103 = this.f237953i;
        if (this.E == true) goto L10;
        r100 = 8;
    L10:
        r103.setVisibility(r100);
        if (this.M == false) goto L16;
        u r104 = this.R;
        if (r104 == null) goto L15;
        removeCallbacks(r104);
        tt5.a.h("SheetEditorLayout", "showKeyboardRunnable before remove");
    L15:
        this.R = new u(this);
        tt5.a.h("SheetEditorLayout", "post show keyboard");
        post(this.R);
    L16:
        post(new v(this));
        qm5.a r105 = this.f237971y;
        r105.f533874a = this.Q;
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void v() {
        if (this.f237967u == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        Boolean r101 = this.W;
        if (r101 != null) goto L11;
    L13:
        this.W = Boolean.valueOf(r100);
        e(this.f237958m, r100);
        e(this.f237954j, r100);
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
        if (this.f237967u == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L10;
        this.V = true;
    L10:
        ImageView r101 = this.f237951g;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r100 == false) goto L15;
        int r102 = 0;
    L17:
        if (r101.getVisibility() != r102) goto L24;
        View r103 = this.f237952h;
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
        this.f237966t = true;
        this.f237951g.setVisibility(r102);
        View r107 = this.f237952h;
        if (r107 == null) goto L34;
        r107.setVisibility(r102);
    L34:
        if (r104 == null) goto L40;
        if (r106 < 0) goto L40;
        if (r105 < r106) goto L40;
        if (r104.post(new r(this, r104, r106, r105)) == true) goto L41;
        this.f237966t = false;
    L41:
        v();
        return;
    L40:
        this.f237966t = false;
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
        this.f237966t = false;
        this.f237967u = false;
        this.f237968v = true;
        this.f237971y = new qm5.a();
        this.M = true;
        this.N = "text";
        this.O = "";
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f237956k0 = new e(this);
        this.f237962p0 = new f(this);
        m(r100);
    }

    public static /* synthetic */ void a(SheetEditorLayout r100) {
        r100.setMentionAnalyticParam(AtConstant$Zone.FULL_SCREEN_TOOLBAR);
    }

    public static /* synthetic */ void b(SheetEditorLayout r100) {
        r100.setMentionAnalyticParam(AtConstant$Zone.FX_BAR);
    }

    private void setEditTextContent(List<BaseSegment> r100) {
        this.f237968v = true;
        this.f237963q = false;
        b r101 = new b(this);
        boolean r102 = this.E;
        if (r102 == false) goto L5;
        SheetAtEditText r103 = this.f237958m;
    L6:
        if (r102 == false) goto L8;
        SheetAtEditText r104 = this.f237954j;
    L9:
        FormulaInputStyleData r105 = r103.getPendingFormulaStyle();
        if (this.E == false) goto L12;
        this.f237954j.requestFocus();
        this.f237954j.O(r100, r101);
    L13:
        if (r105 == null) goto L15;
        r104.K(r105);
    L15:
        this.f237963q = true;
        w();
        return;
    L12:
        this.f237958m.requestFocus();
        this.f237958m.O(r100, r101);
        goto L13
    L8:
        r104 = this.f237958m;
        goto L9
    L5:
        r103 = this.f237954j;
        goto L6
    }

    private void setMentionAnalyticParam(String r100) {
        if (this.f237961p == null) goto L6;
        HashMap r101 = new HashMap();
        r101.put("zone", r100);
        this.f237961p.a(r101);
        return;
    }

    public final void h(CharSequence r100) {
        int r101 = this.f237958m.getLineCount();
        String r102 = r100.toString();
        if (r102.contains("<doc.at.~#_%=`>") == false) goto L5;
        int r103 = (r102.length() - r102.replace("<doc.at.~#_%=`>", "").length()) / 15;
        float r104 = this.f237958m.getPaint().measureText(r102.replace("<doc.at.~#_%=`>", "")) + (this.L * r103);
    L6:
        int r105 = this.f237964r;
        if (r105 > 0) goto L9;
    L10:
        if (r101 <= 1) goto L14;
    L11:
        SheetEditorLayout r106 = this.A.f4520a;
        if (r106.F == true) goto L18;
        r106.F = true;
        r106.u(1);
        return;
    L18:
        return;
    L14:
        SheetEditorLayout r107 = this.A.f4520a;
        if (r107.F == false) goto L20;
        r107.F = false;
        r107.u(0);
        return;
    L20:
        return;
    L9:
        if (r104 >= r105) goto L11;
    L5:
        r104 = this.f237958m.getPaint().measureText(r102);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [an5.a] */
    public final void m(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.sheet_edit_input, this);
        this.f237945a = (ScrollView) findViewById(R.id.sheet_edit_scroll_view);
        this.f237955k = findViewById(R.id.sheet_edit_input_layout);
        this.f237957l = findViewById(R.id.sheet_editor_top_divider);
        l.b(this.f237955k, R.color.bg_body);
        this.f237953i = findViewById(R.id.sheet_edit_full_layout);
        View r101 = findViewById(R.id.editExpand);
        this.f237959n = r101;
        l.c((ImageView) r101, R.color.icon_n1);
        View r102 = findViewById(R.id.editUnexpand);
        this.f237960o = r102;
        l.c((ImageView) r102, R.color.icon_n1);
        View r103 = findViewById(R.id.icon_layout);
        this.f237946b = r103;
        l.b(r103, R.color.bg_body);
        View r104 = findViewById(R.id.edit_sheet_at);
        this.f237947c = r104;
        l.c((ImageView) r104, R.color.icon_n1);
        this.f237958m = (SheetAtEditText) findViewById(R.id.sheet_edit_input);
        this.f237954j = (SheetAtEditText) findViewById(R.id.sheet_edit_full_screen_input);
        this.f237948d = findViewById(R.id.edit_new_line);
        this.f237949e = findViewById(R.id.edit_new_line_full);
        this.f237951g = (ImageView) findViewById(R.id.edit_formula_done);
        this.f237952h = findViewById(R.id.edit_formula_done_separator);
        l.c(this.f237951g, R.color.colorful_blue);
        View r105 = findViewById(R.id.edit_sheet_at_full);
        this.f237950f = r105;
        l.c((ImageView) r105, R.color.icon_n1);
        this.f237958m.setRawInputType(1);
        this.f237960o.setOnClickListener(new n0(this));
        this.f237959n.setOnClickListener(new o0(this));
        this.f237958m.setPreImeListener(new com.bytedance.ee.bear.sheet.inputbar.editor.b(this));
        this.f237954j.setPreImeListener(new p0(this));
        this.f237947c.setOnClickListener(new com.bytedance.ee.bear.sheet.inputbar.editor.c(this));
        findViewById(R.id.edit_sheet_at_full).setOnClickListener(new com.bytedance.ee.bear.sheet.inputbar.editor.a(this));
        this.f237958m.setOpenMentionListener(new an5.e(this));
        this.f237954j.setOpenMentionListener(new an5.f(this));
        this.f237948d.setOnClickListener(new l0(this));
        this.f237949e.setOnClickListener(new m0(this));
        this.C = new an5.a(this);
        this.A = new j0(this);
        this.f237958m.setOnEditorActionListener(new an5.l(this));
        this.f237958m.addTextChangedListener(this.f237956k0);
        this.f237954j.addTextChangedListener(this.f237962p0);
        SheetAtEditText.b r106 = new o(this);
        this.f237958m.setSelectionChangeListener(r106);
        this.f237954j.setSelectionChangeListener(r106);
        ImageView r107 = this.f237951g;
        if (r107 == null) goto L5;
        r107.setOnClickListener(new k0(this));
    L5:
        this.L = getResources().getDrawable(R.drawable.doc_file_at_prefix).getIntrinsicWidth() + getResources().getDimensionPixelSize(R.dimen.doc_file_prefix_space);
    }

    public final void q(boolean r100) {
        if (l() == true) goto L5;
        return;
    L5:
        if (this.U == true) goto L14;
        this.U = true;
        if (r100 == false) goto L10;
        this.S = true;
    L11:
        p();
        return;
    L10:
        this.T = true;
        goto L11
    }

    public void setAtIconVisibility(int r100) {
        findViewById(R.id.edit_sheet_at).setVisibility(r100);
        findViewById(R.id.edit_sheet_at_full).setVisibility(r100);
    }

    public void setAtWindowShowCallback(SheetAtEditText.a r100) {
        SheetAtEditText r101 = this.f237954j;
        if (r101 == null) goto L5;
        r101.setAtWindowShowCallback(r100);
    L5:
        SheetAtEditText r102 = this.f237958m;
        if (r102 == null) goto L9;
        r102.setAtWindowShowCallback(r100);
        return;
    }

    public void setCellInfo(String r100) {
        this.P = r100;
    }

    public void setCellStyle(SegmentStyle r100) {
        this.f237958m.setCellStyle(r100);
        this.f237954j.setCellStyle(r100);
    }

    public void setCursorVisible(boolean r100) {
        this.f237958m.setCursorVisible(r100);
        this.f237954j.setCursorVisible(r100);
    }

    public void setDateType(String r100) {
        this.O = r100;
    }

    public void setDocumentUrl(BearUrl r100) {
        this.Q = r100;
    }

    public void setEditDelegate(wm5.a r100) {
        this.f237972z = r100;
    }

    public void setFormat(String r100) {
        this.N = r100;
    }

    public void setFormulaAssistVisible(boolean r100) {
        View r101 = this.f237957l;
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
        this.f237970x = r100;
    }

    public void setHeightChangeListener(g r100) {
        this.B = r100;
    }

    public void setInputTextChangedListener(h r100) {
        this.D = r100;
    }

    public void setMobileFormulaEditorEnabled(boolean r100) {
        this.f237967u = r100;
        if (r100 == true) goto L5;
        this.f237965s = null;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
    L5:
        w();
    }

    public void setNeedShowKeyboard(boolean r100) {
        this.M = r100;
    }

    public void setNewLineEnable(boolean r100) {
        this.f237948d.setEnabled(r100);
        this.f237948d.setClickable(r100);
        this.f237949e.setEnabled(r100);
        this.f237949e.setClickable(r100);
    }

    public void setPermDelegate(DocViewModel r100) {
        SheetAtEditText r101 = this.f237958m;
        if (r101 == null) goto L6;
        r101.setIPermissionCopyChecker(new pn5.j(r100));
        return;
    }

    public void setShowInputResultCallBack(j r100) {
        this.f237969w = r100;
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
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this.f237946b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, r104});
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this.f237959n, "alpha", new float[]{r105, r106});
        ValueAnimator r111 = ValueAnimator.ofInt(new int[]{r103, r107});
        r111.addUpdateListener(new an5.g(this));
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
        this.f237966t = false;
        this.f237967u = false;
        this.f237968v = true;
        this.f237971y = new qm5.a();
        this.M = true;
        this.N = "text";
        this.O = "";
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f237956k0 = new e(this);
        this.f237962p0 = new f(this);
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
        if (this.E == true) goto L5;
        this.f237958m.getSegments().subscribe(new an5.h(this, r100, r101), new an5.i());
        return;
    L5:
        this.f237954j.getSegments().subscribe(new an5.j(this, r100, r101), new k());
    }

    public SheetEditorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f237966t = false;
        this.f237967u = false;
        this.f237968v = true;
        this.f237971y = new qm5.a();
        this.M = true;
        this.N = "text";
        this.O = "";
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.f237956k0 = new e(this);
        this.f237962p0 = new f(this);
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

    public final void s(List<BaseSegment> r100, String r101, int r110) {
        tt5.a.b("SheetEditorLayout", " show(): ");
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        if (this.f237958m.getAtWindow() != null) goto L5;
        FragmentActivity r102 = (FragmentActivity) getContext();
        kn4.h r103 = new kn4.h(kn4.f.a().a(), r110, r101, AtConstant$Zone.FX_BAR, "text");
        r103.f504238i = sbb.e.f541297h.f541317b;
        r103.f504245p = kn4.f.a().b();
        this.f237958m.C(r103);
        kn4.g r104 = this.f237958m.getAtWindow();
        this.f237961p = r104;
        this.f237954j.setAtWindow(r104);
    L5:
        this.f237961p.b(new c(this));
        f();
        this.f237961p.f(new d(this));
        setEditTextContent(r100);
        t();
        this.f237955k.addOnLayoutChangeListener(this.C);
    }

    public final void x(int r110, List<BaseSegment> r111, String r112, String r113, String r114) {
        if (this.f237968v == true) goto L6;
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
        if (this.S == true) goto L25;
        if (this.T == true) goto L25;
        return;
    L25:
        if (this.S == false) goto L28;
        this.S = false;
    L28:
        if (this.T == false) goto L30;
        this.T = false;
    L30:
        if (r102 == false) goto L32;
        this.V = false;
    L32:
        wm5.a r103 = this.f237972z;
        if (r103 != null) goto L35;
        return;
    L35:
        if (this.f237967u == true) goto L38;
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
        if (TextUtils.equals(r121, this.f237965s) == false) goto L69;
        return;
    L69:
        this.f237965s = r121;
        goto L70
    L65:
        r120 = "";
    L70:
        this.f237972z.updateSheetEditWithFormulaMeta(r110, r111, r112, r113, r114, Integer.valueOf(r101), Integer.valueOf(r106), r117, Boolean.valueOf(r100));
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
        if (this.S == false) goto L13;
    L14:
        r102 = true;
        goto L16
    L13:
        if (this.T == false) goto L15;
        goto L14
    }
}
