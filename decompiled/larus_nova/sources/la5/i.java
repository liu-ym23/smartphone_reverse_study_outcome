package la5;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.drive.view.titlebar.DriveTagTitleView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements TitleBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f508182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f508183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f508184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseTitleBar f508185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f508186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<TitleBar.a> f508187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f508188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f508189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f508190i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f508191j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f508192k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DriveTagTitleView f508193l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<MenuItem> f508194m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<MenuItem> f508195n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<MenuItem> f508196o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f508197p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.ee.bear.browser.plugin.d f508198q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.ee.bear.browser.plugin.d f508199r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f508200s;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f508201a = null;

        static {
            int[] r100 = new int[TitleBar.TitleGravity.values().length];
            f508201a = r100;
            r100[TitleBar.TitleGravity.Left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f508201a[TitleBar.TitleGravity.Center.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public interface b {
        FragmentActivity getActivity();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final /* synthetic */ View a() {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void h() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void k(TitleBar.b r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final /* synthetic */ void setLeftClickListener(View.OnClickListener r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final /* synthetic */ void setTitleSize(int r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void clearMenus() {
        this.f508185d.f();
        this.f508185d.g();
        this.f508185d.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void d() {
        this.f508188g.setTextColor(this.f508183b.getActivity().getResources().getColor(R.color.text_title));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final com.bytedance.ee.bear.browser.plugin.d getDeviceInfo() {
        com.bytedance.ee.bear.browser.plugin.d r100 = this.f508198q;
        if (r100.f216618a != 0) goto L6;
        r100.f216618a = n.E(k.e(this.f508185d.getContext()));
        this.f508198q.f216620c = 1.0f;
    L6:
        return this.f508198q;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void invalidate() {
        this.f508185d.invalidate();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean isLeftIconVisible() {
        return this.f508185d.getLeftIconVisibility();
    }

    public final void m() {
        if (this.f508198q.equals(this.f508199r) == true) goto L11;
        com.bytedance.ee.bear.browser.plugin.d r100 = this.f508198q;
        r100.f216620c = Math.max(Math.min(r100.f216620c, 1.0f), 0.0f);
        Iterator r101 = ((CopyOnWriteArrayList) this.f508187f).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((TitleBar.a) r101.next()).onTitleBarStateChanged(this.f508198q);
        goto L6
    L8:
        this.f508199r = new com.bytedance.ee.bear.browser.plugin.d(this.f508198q);
        return;
    }

    public final void o() {
        if (this.f508185d.getHeight() != 0) goto L6;
        this.f508198q.f216620c = 0.0f;
        return;
    L6:
        int[] r100 = new int[2];
        this.f508185d.getLocationOnScreen(r100);
        int r101 = r100[1] + n.d(this.f508198q.f216619b);
        int r102 = k.e(this.f508185d.getContext());
        int r103 = r101 - r102;
        this.f508198q.f216618a = n.E(r102);
        com.bytedance.ee.bear.browser.plugin.d r104 = this.f508198q;
        float r105 = r104.f216619b;
        if (this.f508197p == false) goto L9;
        r104.f216620c = n.E(r103) / r105;
        return;
    L9:
        r104.f216620c = n.E(r103 - this.f508185d.getResources().getDimensionPixelSize(R.dimen.doc_titlebar_height)) / r105;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final BaseTitleBar getTitleBarLayout() {
        return this.f508185d;
    }

    public i(com.bytedance.ee.bear.drive.core.fragment.b r100) {
        this.f508187f = new CopyOnWriteArrayList();
        this.f508195n = new ArrayList();
        this.f508196o = new ArrayList();
        this.f508197p = true;
        this.f508198q = new com.bytedance.ee.bear.browser.plugin.d();
        this.f508199r = new com.bytedance.ee.bear.browser.plugin.d();
        this.f508183b = r100;
        BaseTitleBar r101 = r100.f224163a;
        this.f508185d = r101;
        this.f508186e = Math.round(r101.getResources().getDimension(R.dimen.doc_titlebar_height));
        ViewGroup.LayoutParams r102 = this.f508185d.getLayoutParams();
        r102.height = this.f508186e;
        this.f508185d.requestLayout();
        this.f508185d.setVisibility(0);
        this.f508185d.setDividerVisible(false);
        this.f508185d.h(6.0f);
        this.f508185d.g();
        this.f508185d.setLeftClickListener(new la5.b(this));
        final GestureDetector r103 = new GestureDetector(this.f508185d.getContext(), new f(this), new Handler(Looper.getMainLooper()));
        this.f508185d.setOnTouchListener(new c(r103));
        this.f508185d.addOnLayoutChangeListener(new g(this));
        if (this.f508182a == null) goto L5;
        this.f508185d.getViewTreeObserver().removeOnPreDrawListener(this.f508182a);
    L5:
        this.f508182a = new h(this);
        this.f508185d.getViewTreeObserver().addOnPreDrawListener(this.f508182a);
        this.f508185d.b();
        FragmentActivity r104 = r100.getActivity();
        this.f508185d.setIsCenterAlways(false);
        View r105 = View.inflate(r104, R.layout.drive_main_title_bar, null);
        BaseTitleBar r106 = this.f508185d;
        DriveTagTitleView r107 = new DriveTagTitleView(r105.getContext());
        this.f508193l = r107;
        r107.setTitleView(r105);
        r106.setCustomTitleView(this.f508193l);
        this.f508188g = (TextView) r105.findViewById(R.id.title);
        Typeface r108 = h18.e.b(r104, 1);
        this.f508188g.setTypeface(r108);
        this.f508189h = (TextView) r105.findViewById(R.id.subTitle);
        this.f508192k = (TextView) r105.findViewById(R.id.subTitleSuffix);
        this.f508191j = (TextView) r105.findViewById(R.id.suffixConnector);
        this.f508190i = r105.findViewById(R.id.subTitleLayout);
        ViewParent r109 = this.f508185d.getCustomTitleView().getParent();
        if ((r109 instanceof RelativeLayout) == false) goto L8;
        ((RelativeLayout) r109).setGravity(8388627);
    L8:
        setTitle(r104.getResources().getString(R.string.Drive_Drive_Default_Title));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void b(TitleBar.TitleGravity r100) {
        int r101 = a.f508201a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f508188g.setGravity(3);
        this.f508189h.setGravity(3);
        this.f508185d.setIsCenterAlways(false);
    L9:
        this.f508185d.b();
        return;
    L5:
        if (r101 != 2) goto L9;
        this.f508189h.setGravity(17);
        this.f508188g.setGravity(17);
        this.f508185d.setIsCenterAlways(true);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void c(TitleBar.a r100) {
        this.f508187f.remove(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void enableTitleBarAlwaysShowing(boolean r100) {
        this.f508200s = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final View findMenuView(String r100) {
        return this.f508185d.d(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void g(TitleBar.a r100) {
        if (this.f508187f.contains(r100) == true) goto L6;
        this.f508187f.add(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void hide(boolean r100) {
        if (this.f508200s == false) goto L5;
        return;
    L5:
        tt5.a.b("DriveSdkSimpleTitleBar", "hide animation:" + r100);
        this.f508197p = false;
        if (r100 == false) goto L8;
        n(false);
    L12:
        o();
        m();
        return;
    L8:
        ValueAnimator r101 = this.f508184c;
        if (r101 == null) goto L11;
        r101.cancel();
        this.f508184c = null;
    L11:
        this.f508198q.f216622e = false;
        this.f508185d.getLayoutParams().height = 0;
        this.f508185d.requestLayout();
        goto L12
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final List<MenuItem> i(TitleBar.MenuType r100) {
        if (r100 != TitleBar.MenuType.Left) goto L6;
        return this.f508195n;
    L6:
        return this.f508196o;
    }

    public final List<MenuItem> l(List<MenuItem> r100) {
        ArrayList r101 = new ArrayList();
        if (hu5.a.d(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<MenuItem> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        MenuItem r103 = r102.next();
        if (r103 == null) goto L7;
        r101.add(r103);
        goto L7
    L11:
        return r101;
    }

    public final void n(boolean r100) {
        ValueAnimator r101 = this.f508184c;
        if (r101 == null) goto L5;
        r101.cancel();
        this.f508184c = null;
    L5:
        this.f508198q.f216622e = r100;
        if (r100 == false) goto L8;
        int r102 = this.f508186e;
    L9:
        ValueAnimator r103 = ObjectAnimator.ofInt(new int[]{this.f508185d.getHeight(), r102});
        this.f508184c = r103;
        r103.setDuration(200);
        this.f508184c.addUpdateListener(new la5.a(this));
        this.f508184c.start();
        return;
    L8:
        r102 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setBackground(int r100) {
        this.f508185d.setBackgroundColor(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setHiddenMenus(List<MenuItem> r100) {
        this.f508194m = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftIconVisibility(boolean r100) {
        this.f508185d.setLeftIconVisibility(r100);
        this.f508185d.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftVisible(boolean r100) {
        this.f508185d.setLeftVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setMenuIconTint(int r100) {
        this.f508185d.setActionIconTint(R.color.selector_color_catalog_icon);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRightVisible(boolean r100) {
        this.f508185d.setRightVisible(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRiskFlag(boolean r100) {
        DriveTagTitleView r101 = this.f508193l;
        if (r101 == null) goto L6;
        int r102 = SpaceTagType.f240339e;
        r101.setLabels(new SpaceTagType[]{SpaceTagType.Companion.g(r100)});
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setSubTitle(CharSequence r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        TextView r101 = this.f508189h;
        if (r101 == null) goto L44;
        r101.setText(r100);
        if (this.f508190i == null) goto L47;
        TextView r102 = this.f508189h;
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L12;
    L16:
        boolean r105 = false;
    L17:
        TextView r106 = this.f508192k;
        if (r106 != null) goto L20;
    L24:
        r103 = false;
    L25:
        TextView r107 = this.f508189h;
        if (r105 == false) goto L28;
        int r108 = 0;
    L29:
        r107.setVisibility(r108);
        TextView r109 = this.f508191j;
        if (r105 == false) goto L33;
        if (r103 == false) goto L33;
        int r110 = 0;
    L34:
        r109.setVisibility(r110);
        TextView r111 = this.f508192k;
        if (r103 == false) goto L37;
        int r112 = 0;
    L38:
        r111.setVisibility(r112);
        View r113 = this.f508190i;
        if (r105 == true) goto L43;
        if (r103 == true) goto L43;
        r104 = 8;
    L43:
        r113.setVisibility(r104);
        return;
    L37:
        r112 = 8;
    L33:
        r110 = 8;
        goto L34
    L28:
        r108 = 8;
        goto L29
    L20:
        if (r106.getText() == null) goto L24;
        if (TextUtils.isEmpty(r106.getText()) == true) goto L24;
    L12:
        if (r102.getText() == null) goto L16;
        if (TextUtils.isEmpty(r102.getText()) == true) goto L16;
        r105 = true;
        goto L17
    L47:
        return;
    L44:
        this.f508185d.setSubTitle(((String) r100).toString());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitle(CharSequence r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f508188g.setText(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleVisibility(boolean r100) {
        if (this.f508185d.getCustomTitleView() != null) goto L5;
        return;
    L5:
        View r101 = this.f508185d.getCustomTitleView();
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTransparent(boolean r100) {
        BaseTitleBar r101 = this.f508185d;
        if (r100 == false) goto L5;
        float r102 = 0.0f;
    L6:
        r101.setAlpha(r102);
        return;
    L5:
        r102 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void show(boolean r100) {
        tt5.a.b("DriveSdkSimpleTitleBar", "show animation:" + r100);
        this.f508197p = true;
        if (r100 == false) goto L5;
        n(true);
        return;
    L5:
        ValueAnimator r101 = this.f508184c;
        if (r101 == null) goto L8;
        r101.cancel();
        this.f508184c = null;
    L8:
        this.f508198q.f216622e = true;
        this.f508185d.getLayoutParams().height = this.f508186e;
        this.f508185d.requestLayout();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean e(String r100, Drawable r101) {
        return this.f508185d.k(r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void j(List<MenuItem> r100, TitleBar.MenuType r101) {
        if (r101 != TitleBar.MenuType.Left) goto L5;
        this.f508185d.f();
        this.f508195n = l(r100);
    L6:
        if (r100 == null) goto L37;
        Iterator<MenuItem> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L37;
        MenuItem r103 = r102.next();
        List<MenuItem> r104 = this.f508194m;
        if (r104 != null) goto L13;
    L21:
        boolean r105 = false;
    L22:
        if (r105 == true) goto L9;
        if (r103.getIcon() == null) goto L27;
        BaseTitleBar.b r106 = new d(r103.getIcon(), r103);
    L30:
        if (r106 == null) goto L31;
        r106.f240048a = r103.getId();
        r106.f240051d = r103.isEnable();
        r106.f240049b = r103.getBadgeStyle();
        r106.f240050c = r103.getBadgeNum();
        if (r101 != TitleBar.MenuType.Left) goto L35;
        View r107 = this.f508185d.a(r106, false);
    L36:
        r103.onShow(r107);
        goto L9
    L35:
        r107 = this.f508185d.a(r106, true);
        goto L36
    L31:
        tt5.a.d("DriveSdkSimpleTitleBar", "Bad menu:" + r103);
        goto L9
    L27:
        if (TextUtils.isEmpty(r103.getText()) == true) goto L29;
        r106 = new e(r103.getText(), r103);
        goto L30
    L29:
        r106 = null;
        goto L30
    L13:
        if (r104.isEmpty() == true) goto L21;
        Iterator<MenuItem> r108 = this.f508194m.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        if (TextUtils.equals(r108.next().getId(), r103.getId()) == false) goto L17;
        r105 = true;
    L37:
        this.f508185d.b();
        return;
    L5:
        this.f508185d.g();
        this.f508196o = l(r100);
        goto L6
    }
}
