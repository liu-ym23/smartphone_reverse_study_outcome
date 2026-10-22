package com.bytedance.ee.bear.list.homepage.title;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import bd5.d;
import bd5.e;
import bd5.f;
import bd5.r;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeMainTitleBar extends LinearLayout implements com.bytedance.ee.bear.list.homepage.title.b {
    public static final /* synthetic */ int q = 0;
    public int a;
    public int b;
    public BaseTitleBar c;
    public SpaceTagTitleView d;
    public LinearLayout e;
    public AppCompatImageView f;
    public AppCompatImageView g;
    public AppCompatImageView h;
    public String i;
    public int j;
    public Animator k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public r p;

    public static final enum TitleType extends Enum<TitleType> {
        public static final TitleType FOLDER_SUB = null;
        public static final TitleType HOMEPAGE = null;
        public static final TitleType SPACE_ROUTE = null;
        public static final TitleType WIKI_HOME = null;
        public static final /* synthetic */ TitleType[] a = null;

        static {
            TitleType r0 = new TitleType("HOMEPAGE", 0);
            HOMEPAGE = r0;
            TitleType r1 = new TitleType("FOLDER_SUB", 1);
            FOLDER_SUB = r1;
            TitleType r3 = new TitleType("WIKI_HOME", 2);
            WIKI_HOME = r3;
            TitleType r5 = new TitleType("SPACE_ROUTE", 3);
            SPACE_ROUTE = r5;
            a = new TitleType[]{r0, r1, r3, r5};
        }

        public static TitleType[] values() {
            return (TitleType[]) a.clone();
        }

        public static TitleType valueOf(String r1) {
            return (TitleType) r27.a.a(TitleType.class, r1);
        }

        public TitleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public View getCreateView() {
        return null;
    }

    public View getLeftView() {
        return null;
    }

    public void setCreateViewEnable(boolean r1) {
    }

    public /* bridge */ /* synthetic */ void setMoreViewClickListener(View.OnClickListener r1) {
    }

    public void setOnLeftViewClickListener(View.OnClickListener r1) {
    }

    public void setShowBadgeDelegate(b r1) {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
        this.p.c = 0;
        int r0 = this.a;
        ViewGroup.LayoutParams r2 = getLayoutParams();
        r2.height = r0;
        setLayoutParams(r2);
        setAlpha(1.0f);
        setVisibility(0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c() {
        FrameLayout r0 = new FrameLayout(getContext());
        this.d = new SpaceTagTitleView(getContext());
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        r0.addView(this.d, r1);
        this.d.setTitleBold(true);
        this.d.setTitleSize(17.0f);
        this.c.setCustomTitleView(r0);
    }

    public final void e() {
        if (this.h != null) goto L5;
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        this.h = r0;
        r0.setBackgroundResource(2131255617);
        l.b(this.h, 2131101926);
    L5:
        d(this.h);
    }

    public final void g() {
        this.j = TitleType.SPACE_ROUTE.ordinal();
        c();
        e();
        qc5.a.k();
    }

    public Bitmap getTitleSnapshot() {
        return t0.q(this.c);
    }

    public final void h() {
        this.j = TitleType.FOLDER_SUB.ordinal();
        c();
        e();
        qc5.a.k();
        if (this.g != null) goto L5;
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        this.g = r0;
        r0.setBackgroundResource(2131255147);
        l.b(this.g, 2131101926);
    L5:
        d(this.g);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(2131167714);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.c = new BaseTitleBar(getContext());
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        r0.height = (int) getResources().getDimension(2131167714);
        addView(this.c, r0);
        this.c.setDividerVisible(false);
        LinearLayout r1 = (LinearLayout) LayoutInflater.from(getContext()).inflate(2131563506, null).findViewById(2131377167);
        this.e = r1;
        this.c.setCustomRightView(r1);
        this.c.setClickable(true);
    }

    public String getOriginTitle() {
        return this.i;
    }

    public BaseTitleBar getTitleBar() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleType() {
        return this.j;
    }

    public SpaceTagTitleView getTitleView() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r6) {
        int r7 = this.p.b(getLayoutParams().height, r6);
        float r0 = this.p.a(r7);
        this.p.getClass();
        if (r0 <= 0.1f) goto L5;
        boolean r1 = true;
    L6:
        ViewGroup.LayoutParams r2 = getLayoutParams();
        r2.height = r7;
        setLayoutParams(r2);
        if (r1 == this.l) goto L23;
        Animator r8 = this.k;
        if (r8 == null) goto L12;
        r8.cancel();
    L12:
        this.l = r1;
        if (r1 == false) goto L15;
        setVisibility(0);
    L15:
        boolean r9 = this.l;
        float r3 = 0.0f;
        if (r9 == false) goto L18;
        float r4 = 0.0f;
    L19:
        if (r9 == false) goto L21;
        r3 = 1.0f;
    L21:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, "alpha", new float[]{r4, r3}).setDuration(200);
        this.k = r10;
        r10.start();
        this.k.addListener(new f(this));
        return;
    L18:
        r4 = 1.0f;
        goto L19
    L23:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void d(View r6) {
        this.e.removeView(r6);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.setMargins(n.d(8), n.d(8), n.d(8), n.d(8));
        this.e.addView(r6, r0);
    }

    public final void f(AttributeSet r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r5, new int[]{2130970477, 2130974111});
        this.b = (int) r6.getDimension(1, 0.0f);
        int r1 = (int) r6.getDimension(0, 0.0f);
        this.a = r1;
        this.p = new r(this.b, r1);
        r6.recycle();
        this.p.c = 0;
    }

    public void setLeftExtraClickListener(final Fragment r3) {
        if (this.c == null) goto L11;
        if (r3 != null) goto L7;
        return;
    L7:
        if (ForsetiHelper.b(r3) == true) goto L9;
        return;
    L9:
        this.c.setLeftExtraClickListener(new e(this, r3));
        return;
    }

    public void setMoreViewEnable(boolean r2) {
        AppCompatImageView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        AppCompatImageView r1 = this.g;
        if (r1 == null) goto L12;
        if (r2 == false) goto L9;
        View.OnClickListener r3 = this.o;
    L10:
        r1.setOnClickListener(r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public void setOnCreateViewClickListener(View.OnClickListener r1) {
        this.n = r1;
    }

    public void setOnGridViewClickListener(a r2) {
        AppCompatImageView r3 = this.f;
        if (r3 == null) goto L6;
        r3.setOnClickListener(new d(this));
        return;
    }

    public void setOnMoreViewClickListener(View.OnClickListener r2) {
        this.o = r2;
        AppCompatImageView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setOnSearchBtnClickListener(View.OnClickListener r2) {
        AppCompatImageView r0 = this.h;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setSearchEnable(boolean r2) {
        AppCompatImageView r0 = this.h;
        if (r0 == null) goto L6;
        r0.setEnabled(r2);
        return;
    }

    public void setSearchViewClickListener(View.OnClickListener r1) {
        throw null;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public void setTitle(String r2) {
        this.i = r2;
        SpaceTagTitleView r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTitle(r2);
    }

    public HomeMainTitleBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 0;
        this.b = 0;
        this.i = "";
        this.l = true;
        f(r2);
    }

    public HomeMainTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 0;
        this.b = 0;
        this.i = "";
        this.l = true;
        f(r2);
    }
}
