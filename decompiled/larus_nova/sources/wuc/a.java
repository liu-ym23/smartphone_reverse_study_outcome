package wuc;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import tuc.b;
import xuc.c;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends FrameLayout implements uuc.a, b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HorizontalScrollView f561486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f561487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f561488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f561489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xuc.a f561490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f561491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f561492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f561493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f561494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f561495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f561496k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f561497l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f561498m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f561499n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f561500o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<zuc.a> f561501p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C8165a f561502q;

    /* JADX INFO: renamed from: wuc.a$a, reason: collision with other inner class name */
    public class C8165a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f561503a;

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            a r100 = this.f561503a;
            b r101 = r100.f561491f;
            r101.f547655c = r100.f561490e.a();
            r101.f547653a.clear();
            r101.f547654b.clear();
            this.f561503a.c();
        }

        public C8165a(a r100) {
            this.f561503a = r100;
        }
    }

    @Override // uuc.a
    public final void b() {
    }

    public final void c() {
        removeAllViews();
        if (this.f561492g == false) goto L5;
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout_no_scroll, this);
    L6:
        this.f561486a = (HorizontalScrollView) r100.findViewById(R.id.scroll_view);
        LinearLayout r101 = (LinearLayout) r100.findViewById(R.id.title_container);
        this.f561487b = r101;
        r101.setPadding(this.f561498m, 0, this.f561497l, 0);
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.indicator_container);
        this.f561488c = r102;
        if (this.f561499n == false) goto L9;
        r102.getParent().bringChildToFront(this.f561488c);
    L9:
        int r103 = this.f561491f.f547655c;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L20;
        Object r105 = this.f561490e.c(getContext(), r104);
        if ((r105 instanceof View) == false) goto L19;
        View r106 = (View) r105;
        if (this.f561492g == false) goto L17;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(0, -1);
        xuc.a r108 = this.f561490e;
        getContext();
        r108.getClass();
        r107.weight = 1.0f;
    L18:
        this.f561487b.addView(r106, r107);
        goto L19
    L17:
        r107 = new LinearLayout.LayoutParams(-2, -1);
    L19:
        r104 = r104 + 1;
        goto L11
    L20:
        xuc.a r109 = this.f561490e;
        if (r109 == null) goto L29;
        c r110 = r109.b(getContext());
        this.f561489d = r110;
        if ((r110 instanceof View) == false) goto L30;
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -1);
        this.f561488c.addView((View) this.f561489d, r111);
        return;
    L30:
        return;
    L29:
        return;
    L5:
        r100 = LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout, this);
        goto L6
    }

    @Override // uuc.a
    public final void a() {
        c();
    }

    public xuc.a getAdapter() {
        return this.f561490e;
    }

    public int getLeftPadding() {
        return this.f561498m;
    }

    public c getPagerIndicator() {
        return this.f561489d;
    }

    public int getRightPadding() {
        return this.f561497l;
    }

    public float getScrollPivotX() {
        return this.f561494i;
    }

    public LinearLayout getTitleContainer() {
        return this.f561487b;
    }

    public a(Context r100) {
        super(r100);
        this.f561494i = 0.5f;
        this.f561495j = true;
        this.f561496k = true;
        this.f561500o = true;
        this.f561501p = new ArrayList();
        this.f561502q = new C8165a(this);
        b r101 = new b();
        this.f561491f = r101;
        r101.f547661i = this;
    }

    @Override // uuc.a
    public final void onPageScrollStateChanged(int r100) {
        if (this.f561490e == null) goto L8;
        this.f561491f.f547659g = r100;
        c r101 = this.f561489d;
        if (r101 == null) goto L9;
        r101.a();
        return;
    L9:
        return;
    }

    @Override // uuc.a
    public final void onPageSelected(int r100) {
        if (this.f561490e == null) goto L22;
        b r101 = this.f561491f;
        r101.f547657e = r101.f547656d;
        r101.f547656d = r100;
        r101.d(r100);
        int r102 = 0;
    L6:
        if (r102 >= r101.f547655c) goto L14;
        if (r102 == r101.f547656d) goto L13;
        if (r101.f547653a.get(r102) == true) goto L13;
        r101.a(r102);
    L13:
        r102 = r102 + 1;
        goto L6
    L14:
        c r103 = this.f561489d;
        if (r103 == null) goto L23;
        r103.onPageSelected();
        return;
    L23:
        return;
    }

    public void setAdapter(xuc.a r100) {
        xuc.a r101 = this.f561490e;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L7;
        C8165a r102 = this.f561502q;
        r101.f565128a.unregisterObserver(r102);
    L7:
        this.f561490e = r100;
        if (r100 == null) goto L12;
        C8165a r103 = this.f561502q;
        r100.f565128a.registerObserver(r103);
        b r104 = this.f561491f;
        r104.f547655c = this.f561490e.a();
        r104.f547653a.clear();
        r104.f547654b.clear();
        if (this.f561487b == null) goto L14;
        this.f561490e.f565128a.notifyChanged();
        return;
    L14:
        return;
    L12:
        b r105 = this.f561491f;
        r105.f547655c = 0;
        r105.f547653a.clear();
        r105.f547654b.clear();
        c();
    }

    public void setAdjustMode(boolean r100) {
        this.f561492g = r100;
    }

    public void setEnablePivotScroll(boolean r100) {
        this.f561493h = r100;
    }

    public void setFollowTouch(boolean r100) {
        this.f561496k = r100;
    }

    public void setIndicatorOnTop(boolean r100) {
        this.f561499n = r100;
    }

    public void setLeftPadding(int r100) {
        this.f561498m = r100;
    }

    public void setReselectWhenLayout(boolean r100) {
        this.f561500o = r100;
    }

    public void setRightPadding(int r100) {
        this.f561497l = r100;
    }

    public void setScrollPivotX(float r100) {
        this.f561494i = r100;
    }

    public void setSkimOver(boolean r100) {
        this.f561491f.f547660h = r100;
    }

    public void setSmoothScroll(boolean r100) {
        this.f561495j = r100;
    }

    @Override // uuc.a
    public final void onPageScrolled(int r110, float r111, int r112) {
        if (this.f561490e == null) goto L71;
        b r100 = this.f561491f;
        float r101 = r110 + r111;
        float r102 = r100.f547658f;
        if (r102 > r101) goto L7;
        boolean r103 = true;
    L9:
        if (r100.f547659g != 0) goto L11;
        int r104 = 0;
    L35:
        if (r104 >= r100.f547655c) goto L46;
        if (r104 == r100.f547656d) goto L45;
        if (r100.f547653a.get(r104) == true) goto L43;
        r100.a(r104);
    L43:
        if (r100.f547654b.get(r104, Float.valueOf(0.0f)).floatValue() == 1.0f) goto L45;
        r100.c(r104, 1.0f, false, true);
    L45:
        r104 = r104 + 1;
        goto L35
    L46:
        r100.b(r100.f547656d, 1.0f, false, true);
        r100.d(r100.f547656d);
    L47:
        r100.f547658f = r101;
    L48:
        c r105 = this.f561489d;
        if (r105 == null) goto L52;
        r105.onPageScrolled(r110, r111, r112);
    L52:
        if (this.f561486a != null) goto L54;
        return;
    L54:
        if (((ArrayList) this.f561501p).size() <= 0) goto L73;
        if (r110 >= 0) goto L57;
        return;
    L57:
        if (r110 < ((ArrayList) this.f561501p).size()) goto L59;
        return;
    L59:
        if (this.f561496k == false) goto L76;
        int r113 = Math.min(((ArrayList) this.f561501p).size() - 1, r110);
        int r114 = Math.min(((ArrayList) this.f561501p).size() - 1, r110 + 1);
        zuc.a r115 = (zuc.a) ListProtector.get(this.f561501p, r113);
        zuc.a r116 = (zuc.a) ListProtector.get(this.f561501p, r114);
        int r106 = r115.f573672a;
        float r117 = (r106 + ((r115.f573674c - r106) / 2)) - (this.f561486a.getWidth() * this.f561494i);
        int r107 = r116.f573672a;
        this.f561486a.scrollTo((int) (r117 + ((((r107 + ((r116.f573674c - r107) / 2)) - (this.f561486a.getWidth() * this.f561494i)) - r117) * r111)), 0);
        return;
    L76:
        return;
    L73:
        return;
    L11:
        if (r101 == r102) goto L48;
        int r108 = r110 + 1;
        if (r111 != 0.0f) goto L17;
        if (r103 == false) goto L17;
        r108 = r110 - 1;
        boolean r109 = false;
    L18:
        int r118 = 0;
    L20:
        if (r118 >= r100.f547655c) goto L28;
        if (r118 == r110) goto L27;
        if (r118 == r108) goto L27;
        if (r100.f547654b.get(r118, Float.valueOf(0.0f)).floatValue() == 1.0f) goto L27;
        r100.c(r118, 1.0f, r103, true);
    L27:
        r118 = r118 + 1;
        goto L20
    L28:
        if (r109 == false) goto L32;
        if (r103 == false) goto L31;
        r100.c(r110, r111, true, false);
        r100.b(r108, r111, true, false);
        goto L47
    L31:
        float r119 = 1.0f - r111;
        r100.c(r108, r119, false, false);
        r100.b(r110, r119, false, false);
        goto L47
    L32:
        float r120 = 1.0f - r111;
        r100.c(r108, r120, true, false);
        r100.b(r110, r120, true, false);
    L17:
        r109 = true;
        goto L18
    L7:
        r103 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f561490e == null) goto L26;
        ((ArrayList) this.f561501p).clear();
        int r105 = this.f561491f.f547655c;
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L13;
        zuc.a r107 = new zuc.a();
        View r108 = this.f561487b.getChildAt(r106);
        if (r108 == 0) goto L12;
        r107.f573672a = r108.getLeft();
        r107.f573673b = r108.getTop();
        r107.f573674c = r108.getRight();
        r108.getBottom();
        if ((r108 instanceof xuc.b) == false) goto L11;
        xuc.b r109 = (xuc.b) r108;
        r107.f573675d = r109.getContentLeft();
        r109.getContentTop();
        r107.f573676e = r109.getContentRight();
        r109.getContentBottom();
        goto L12
    L11:
        r107.f573675d = r107.f573672a;
        r107.f573676e = r107.f573674c;
    L12:
        ((ArrayList) this.f561501p).add(r107);
        r106 = r106 + 1;
        goto L5
    L13:
        c r110 = this.f561489d;
        if (r110 == null) goto L17;
        r110.b(this.f561501p);
    L17:
        if (this.f561500o == false) goto L27;
        b r111 = this.f561491f;
        if (r111.f547659g != 0) goto L28;
        onPageSelected(r111.f547656d);
        onPageScrolled(this.f561491f.f547656d, 0.0f, 0);
        return;
    L28:
        return;
    L27:
        return;
    }
}
