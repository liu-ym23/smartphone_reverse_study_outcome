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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class HomeMainTitleBar extends LinearLayout implements com.bytedance.ee.bear.list.homepage.title.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f228348q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f228349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f228350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseTitleBar f228351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpaceTagTitleView f228352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f228353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f228354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AppCompatImageView f228355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatImageView f228356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f228357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f228358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Animator f228359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f228360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f228361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View.OnClickListener f228362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f228363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public r f228364p;

    public static final enum TitleType extends Enum<TitleType> {
        public static final TitleType FOLDER_SUB = null;
        public static final TitleType HOMEPAGE = null;
        public static final TitleType SPACE_ROUTE = null;
        public static final TitleType WIKI_HOME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleType[] f228365a = null;

        static {
            TitleType r100 = new TitleType("HOMEPAGE", 0);
            HOMEPAGE = r100;
            TitleType r101 = new TitleType("FOLDER_SUB", 1);
            FOLDER_SUB = r101;
            TitleType r102 = new TitleType("WIKI_HOME", 2);
            WIKI_HOME = r102;
            TitleType r103 = new TitleType("SPACE_ROUTE", 3);
            SPACE_ROUTE = r103;
            f228365a = new TitleType[]{r100, r101, r102, r103};
        }

        public static TitleType[] values() {
            return (TitleType[]) f228365a.clone();
        }

        public static TitleType valueOf(String r100) {
            return (TitleType) r27.a.a(TitleType.class, r100);
        }

        public TitleType(String r100, int r101) {
            super(r100, r101);
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

    public void setCreateViewEnable(boolean r100) {
    }

    public /* bridge */ /* synthetic */ void setMoreViewClickListener(View.OnClickListener r100) {
    }

    public void setOnLeftViewClickListener(View.OnClickListener r100) {
    }

    public void setShowBadgeDelegate(b r100) {
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
        this.f228364p.f18677c = 0;
        int r100 = this.f228349a;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        r101.height = r100;
        setLayoutParams(r101);
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
        FrameLayout r100 = new FrameLayout(getContext());
        this.f228352d = new SpaceTagTitleView(getContext());
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 17;
        r100.addView(this.f228352d, r101);
        this.f228352d.setTitleBold(true);
        this.f228352d.setTitleSize(17.0f);
        this.f228351c.setCustomTitleView(r100);
    }

    public final void e() {
        if (this.f228356h != null) goto L5;
        AppCompatImageView r100 = new AppCompatImageView(getContext());
        this.f228356h = r100;
        r100.setBackgroundResource(R.drawable.ud_icon_search_outlined);
        l.b(this.f228356h, R.color.facade_selector_icon_n1);
    L5:
        d(this.f228356h);
    }

    public final void g() {
        this.f228358j = TitleType.SPACE_ROUTE.ordinal();
        c();
        e();
        qc5.a.k();
    }

    public Bitmap getTitleSnapshot() {
        return t0.q(this.f228351c);
    }

    public final void h() {
        this.f228358j = TitleType.FOLDER_SUB.ordinal();
        c();
        e();
        qc5.a.k();
        if (this.f228355g != null) goto L5;
        AppCompatImageView r100 = new AppCompatImageView(getContext());
        this.f228355g = r100;
        r100.setBackgroundResource(R.drawable.ud_icon_more_outlined);
        l.b(this.f228355g, R.color.facade_selector_icon_n1);
    L5:
        d(this.f228355g);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.list_home_title_bar_height_min);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f228351c = new BaseTitleBar(getContext());
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-1, -2);
        r100.height = (int) getResources().getDimension(R.dimen.list_home_title_bar_height_min);
        addView(this.f228351c, r100);
        this.f228351c.setDividerVisible(false);
        LinearLayout r101 = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.list_main_title_menu, null).findViewById(R.id.lark_main_title_menu_container);
        this.f228353e = r101;
        this.f228351c.setCustomRightView(r101);
        this.f228351c.setClickable(true);
    }

    public String getOriginTitle() {
        return this.f228357i;
    }

    public BaseTitleBar getTitleBar() {
        return this.f228351c;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleType() {
        return this.f228358j;
    }

    public SpaceTagTitleView getTitleView() {
        return this.f228352d;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r100) {
        int r101 = this.f228364p.b(getLayoutParams().height, r100);
        float r102 = this.f228364p.a(r101);
        this.f228364p.getClass();
        if (r102 <= 0.1f) goto L5;
        boolean r103 = true;
    L6:
        ViewGroup.LayoutParams r104 = getLayoutParams();
        r104.height = r101;
        setLayoutParams(r104);
        if (r103 == this.f228360l) goto L23;
        Animator r105 = this.f228359k;
        if (r105 == null) goto L12;
        r105.cancel();
    L12:
        this.f228360l = r103;
        if (r103 == false) goto L15;
        setVisibility(0);
    L15:
        boolean r106 = this.f228360l;
        float r107 = 0.0f;
        if (r106 == false) goto L18;
        float r108 = 0.0f;
    L19:
        if (r106 == false) goto L21;
        r107 = 1.0f;
    L21:
        ObjectAnimator r109 = ObjectAnimator.ofFloat(this, "alpha", new float[]{r108, r107}).setDuration(200);
        this.f228359k = r109;
        r109.start();
        this.f228359k.addListener(new f(this));
        return;
    L18:
        r108 = 1.0f;
        goto L19
    L23:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void d(View r100) {
        this.f228353e.removeView(r100);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -2);
        r101.setMargins(n.d(8), n.d(8), n.d(8), n.d(8));
        this.f228353e.addView(r100, r101);
    }

    public final void f(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.largeHeight, R.attr.smallHeight});
        this.f228350b = (int) r101.getDimension(1, 0.0f);
        int r102 = (int) r101.getDimension(0, 0.0f);
        this.f228349a = r102;
        this.f228364p = new r(this.f228350b, r102);
        r101.recycle();
        this.f228364p.f18677c = 0;
    }

    public void setLeftExtraClickListener(final Fragment r100) {
        if (this.f228351c == null) goto L11;
        if (r100 != null) goto L7;
        return;
    L7:
        if (ForsetiHelper.b(r100) == true) goto L9;
        return;
    L9:
        this.f228351c.setLeftExtraClickListener(new e(this, r100));
        return;
    }

    public void setMoreViewEnable(boolean r100) {
        AppCompatImageView r101 = this.f228355g;
        if (r101 == null) goto L5;
        r101.setEnabled(r100);
    L5:
        AppCompatImageView r102 = this.f228355g;
        if (r102 == null) goto L12;
        if (r100 == false) goto L9;
        View.OnClickListener r103 = this.f228363o;
    L10:
        r102.setOnClickListener(r103);
        return;
    L9:
        r103 = null;
        goto L10
    }

    public void setOnCreateViewClickListener(View.OnClickListener r100) {
        this.f228362n = r100;
    }

    public void setOnGridViewClickListener(a r100) {
        AppCompatImageView r101 = this.f228354f;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new d(this));
        return;
    }

    public void setOnMoreViewClickListener(View.OnClickListener r100) {
        this.f228363o = r100;
        AppCompatImageView r101 = this.f228355g;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setOnSearchBtnClickListener(View.OnClickListener r100) {
        AppCompatImageView r101 = this.f228356h;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setSearchEnable(boolean r100) {
        AppCompatImageView r101 = this.f228356h;
        if (r101 == null) goto L6;
        r101.setEnabled(r100);
        return;
    }

    public void setSearchViewClickListener(View.OnClickListener r100) {
        throw null;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public void setTitle(String r100) {
        this.f228357i = r100;
        SpaceTagTitleView r101 = this.f228352d;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTitle(r100);
    }

    public HomeMainTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f228349a = 0;
        this.f228350b = 0;
        this.f228357i = "";
        this.f228360l = true;
        f(r101);
    }

    public HomeMainTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f228349a = 0;
        this.f228350b = 0;
        this.f228357i = "";
        this.f228360l = true;
        f(r101);
    }
}
