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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements TitleBar {
    public h a;
    public final b b;
    public ValueAnimator c;
    public BaseTitleBar d;
    public int e;
    public List<TitleBar.a> f;
    public TextView g;
    public TextView h;
    public View i;
    public TextView j;
    public TextView k;
    public DriveTagTitleView l;
    public List<MenuItem> m;
    public List<MenuItem> n;
    public List<MenuItem> o;
    public boolean p;
    public final com.bytedance.ee.bear.browser.plugin.d q;
    public com.bytedance.ee.bear.browser.plugin.d r;
    public boolean s;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TitleBar.TitleGravity.values().length];
            a = r0;
            r0[TitleBar.TitleGravity.Left.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[TitleBar.TitleGravity.Center.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
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
    public final void k(TitleBar.b r1) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final /* synthetic */ void setLeftClickListener(View.OnClickListener r1) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final /* synthetic */ void setTitleSize(int r1) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void clearMenus() {
        this.d.f();
        this.d.g();
        this.d.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void d() {
        this.g.setTextColor(this.b.getActivity().getResources().getColor(2131106622));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final com.bytedance.ee.bear.browser.plugin.d getDeviceInfo() {
        com.bytedance.ee.bear.browser.plugin.d r0 = this.q;
        if (r0.a != 0) goto L6;
        r0.a = n.E(k.e(this.d.getContext()));
        this.q.c = 1.0f;
    L6:
        return this.q;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void invalidate() {
        this.d.invalidate();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean isLeftIconVisible() {
        return this.d.getLeftIconVisibility();
    }

    public final void m() {
        if (this.q.equals(this.r) == true) goto L11;
        com.bytedance.ee.bear.browser.plugin.d r0 = this.q;
        r0.c = Math.max(Math.min(r0.c, 1.0f), 0.0f);
        Iterator r1 = ((CopyOnWriteArrayList) this.f).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((TitleBar.a) r1.next()).onTitleBarStateChanged(this.q);
        goto L6
    L8:
        this.r = new com.bytedance.ee.bear.browser.plugin.d(this.q);
        return;
    }

    public final void o() {
        if (this.d.getHeight() != 0) goto L6;
        this.q.c = 0.0f;
        return;
    L6:
        int[] r0 = new int[2];
        this.d.getLocationOnScreen(r0);
        int r1 = r0[1] + n.d(this.q.b);
        int r2 = k.e(this.d.getContext());
        int r3 = r1 - r2;
        this.q.a = n.E(r2);
        com.bytedance.ee.bear.browser.plugin.d r4 = this.q;
        float r5 = r4.b;
        if (this.p == false) goto L9;
        r4.c = n.E(r3) / r5;
        return;
    L9:
        r4.c = n.E(r3 - this.d.getResources().getDimensionPixelSize(2131165837)) / r5;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final BaseTitleBar getTitleBarLayout() {
        return this.d;
    }

    public i(com.bytedance.ee.bear.drive.core.fragment.b r8) {
        this.f = new CopyOnWriteArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = true;
        this.q = new com.bytedance.ee.bear.browser.plugin.d();
        this.r = new com.bytedance.ee.bear.browser.plugin.d();
        this.b = r8;
        BaseTitleBar r1 = r8.a;
        this.d = r1;
        this.e = Math.round(r1.getResources().getDimension(2131165837));
        ViewGroup.LayoutParams r2 = this.d.getLayoutParams();
        r2.height = this.e;
        this.d.requestLayout();
        this.d.setVisibility(0);
        this.d.setDividerVisible(false);
        this.d.h(6.0f);
        this.d.g();
        this.d.setLeftClickListener(new la5.b(this));
        final GestureDetector r3 = new GestureDetector(this.d.getContext(), new f(this), new Handler(Looper.getMainLooper()));
        this.d.setOnTouchListener(new c(r3));
        this.d.addOnLayoutChangeListener(new g(this));
        if (this.a == null) goto L5;
        this.d.getViewTreeObserver().removeOnPreDrawListener(this.a);
    L5:
        this.a = new h(this);
        this.d.getViewTreeObserver().addOnPreDrawListener(this.a);
        this.d.b();
        FragmentActivity r9 = r8.getActivity();
        this.d.setIsCenterAlways(false);
        View r4 = View.inflate(r9, 2131560210, null);
        BaseTitleBar r5 = this.d;
        DriveTagTitleView r6 = new DriveTagTitleView(r4.getContext());
        this.l = r6;
        r6.setTitleView(r4);
        r5.setCustomTitleView(this.l);
        this.g = (TextView) r4.findViewById(2131388772);
        Typeface r0 = h18.e.b(r9, 1);
        this.g.setTypeface(r0);
        this.h = (TextView) r4.findViewById(2131387517);
        this.k = (TextView) r4.findViewById(2131387519);
        this.j = (TextView) r4.findViewById(2131387691);
        this.i = r4.findViewById(2131387518);
        ViewParent r7 = this.d.getCustomTitleView().getParent();
        if ((r7 instanceof RelativeLayout) == false) goto L8;
        ((RelativeLayout) r7).setGravity(8388627);
    L8:
        setTitle(r9.getResources().getString(2131888377));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void b(TitleBar.TitleGravity r3) {
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        this.g.setGravity(3);
        this.h.setGravity(3);
        this.d.setIsCenterAlways(false);
    L9:
        this.d.b();
        return;
    L5:
        if (r4 != 2) goto L9;
        this.h.setGravity(17);
        this.g.setGravity(17);
        this.d.setIsCenterAlways(true);
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void c(TitleBar.a r2) {
        this.f.remove(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void enableTitleBarAlwaysShowing(boolean r1) {
        this.s = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final View findMenuView(String r2) {
        return this.d.d(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void g(TitleBar.a r2) {
        if (this.f.contains(r2) == true) goto L6;
        this.f.add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void hide(boolean r3) {
        if (this.s == false) goto L5;
        return;
    L5:
        tt5.a.b("DriveSdkSimpleTitleBar", "hide animation:" + r3);
        this.p = false;
        if (r3 == false) goto L8;
        n(false);
    L12:
        o();
        m();
        return;
    L8:
        ValueAnimator r4 = this.c;
        if (r4 == null) goto L11;
        r4.cancel();
        this.c = null;
    L11:
        this.q.e = false;
        this.d.getLayoutParams().height = 0;
        this.d.requestLayout();
        goto L12
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final List<MenuItem> i(TitleBar.MenuType r2) {
        if (r2 != TitleBar.MenuType.Left) goto L6;
        return this.n;
    L6:
        return this.o;
    }

    public final List<MenuItem> l(List<MenuItem> r3) {
        ArrayList r0 = new ArrayList();
        if (hu5.a.d(r3) == false) goto L5;
        return r0;
    L5:
        Iterator<MenuItem> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        MenuItem r1 = r4.next();
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    public final void n(boolean r4) {
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel();
        this.c = null;
    L5:
        this.q.e = r4;
        if (r4 == false) goto L8;
        int r5 = this.e;
    L9:
        ValueAnimator r6 = ObjectAnimator.ofInt(new int[]{this.d.getHeight(), r5});
        this.c = r6;
        r6.setDuration(200);
        this.c.addUpdateListener(new la5.a(this));
        this.c.start();
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setBackground(int r2) {
        this.d.setBackgroundColor(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setHiddenMenus(List<MenuItem> r1) {
        this.m = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftIconVisibility(boolean r2) {
        this.d.setLeftIconVisibility(r2);
        this.d.b();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setLeftVisible(boolean r2) {
        this.d.setLeftVisible(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setMenuIconTint(int r2) {
        this.d.setActionIconTint(2131105828);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRightVisible(boolean r2) {
        this.d.setRightVisible(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setRiskFlag(boolean r4) {
        DriveTagTitleView r0 = this.l;
        if (r0 == null) goto L6;
        int r2 = SpaceTagType.e;
        r0.setLabels(new SpaceTagType[]{SpaceTagType.Companion.g(r4)});
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setSubTitle(CharSequence r6) {
        if (r6 != null) goto L4;
        r6 = "";
    L4:
        TextView r0 = this.h;
        if (r0 == null) goto L44;
        r0.setText(r6);
        if (this.i == null) goto L47;
        TextView r7 = this.h;
        boolean r1 = true;
        int r2 = 0;
        if (r7 != null) goto L12;
    L16:
        boolean r8 = false;
    L17:
        TextView r3 = this.k;
        if (r3 != null) goto L20;
    L24:
        r1 = false;
    L25:
        TextView r4 = this.h;
        if (r8 == false) goto L28;
        int r5 = 0;
    L29:
        r4.setVisibility(r5);
        TextView r9 = this.j;
        if (r8 == false) goto L33;
        if (r1 == false) goto L33;
        int r10 = 0;
    L34:
        r9.setVisibility(r10);
        TextView r11 = this.k;
        if (r1 == false) goto L37;
        int r12 = 0;
    L38:
        r11.setVisibility(r12);
        View r13 = this.i;
        if (r8 == true) goto L43;
        if (r1 == true) goto L43;
        r2 = 8;
    L43:
        r13.setVisibility(r2);
        return;
    L37:
        r12 = 8;
    L33:
        r10 = 8;
        goto L34
    L28:
        r5 = 8;
        goto L29
    L20:
        if (r3.getText() == null) goto L24;
        if (TextUtils.isEmpty(r3.getText()) == true) goto L24;
    L12:
        if (r7.getText() == null) goto L16;
        if (TextUtils.isEmpty(r7.getText()) == true) goto L16;
        r8 = true;
        goto L17
    L47:
        return;
    L44:
        this.d.setSubTitle(((String) r6).toString());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitle(CharSequence r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.g.setText(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTitleVisibility(boolean r2) {
        if (this.d.getCustomTitleView() != null) goto L5;
        return;
    L5:
        View r0 = this.d.getCustomTitleView();
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void setTransparent(boolean r2) {
        BaseTitleBar r0 = this.d;
        if (r2 == false) goto L5;
        float r3 = 0.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 1.0f;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void show(boolean r3) {
        tt5.a.b("DriveSdkSimpleTitleBar", "show animation:" + r3);
        this.p = true;
        if (r3 == false) goto L5;
        n(true);
        return;
    L5:
        ValueAnimator r4 = this.c;
        if (r4 == null) goto L8;
        r4.cancel();
        this.c = null;
    L8:
        this.q.e = true;
        this.d.getLayoutParams().height = this.e;
        this.d.requestLayout();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final boolean e(String r2, Drawable r3) {
        return this.d.k(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.TitleBar
    public final void j(List<MenuItem> r7, TitleBar.MenuType r8) {
        if (r8 != TitleBar.MenuType.Left) goto L5;
        this.d.f();
        this.n = l(r7);
    L6:
        if (r7 == null) goto L37;
        Iterator<MenuItem> r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L37;
        MenuItem r0 = r9.next();
        List<MenuItem> r1 = this.m;
        if (r1 != null) goto L13;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == true) goto L9;
        if (r0.getIcon() == null) goto L27;
        BaseTitleBar.b r3 = new d(r0.getIcon(), r0);
    L30:
        if (r3 == null) goto L31;
        r3.a = r0.getId();
        r3.d = r0.isEnable();
        r3.b = r0.getBadgeStyle();
        r3.c = r0.getBadgeNum();
        if (r8 != TitleBar.MenuType.Left) goto L35;
        View r4 = this.d.a(r3, false);
    L36:
        r0.onShow(r4);
        goto L9
    L35:
        r4 = this.d.a(r3, true);
        goto L36
    L31:
        tt5.a.d("DriveSdkSimpleTitleBar", "Bad menu:" + r0);
        goto L9
    L27:
        if (TextUtils.isEmpty(r0.getText()) == true) goto L29;
        r3 = new e(r0.getText(), r0);
        goto L30
    L29:
        r3 = null;
        goto L30
    L13:
        if (r1.isEmpty() == true) goto L21;
        Iterator<MenuItem> r5 = this.m.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        if (TextUtils.equals(r5.next().getId(), r0.getId()) == false) goto L17;
        r2 = true;
    L37:
        this.d.b();
        return;
    L5:
        this.d.g();
        this.o = l(r7);
        goto L6
    }
}
