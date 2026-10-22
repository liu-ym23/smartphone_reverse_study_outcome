package com.bytedance.ies.uikit.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public class CustomViewAbove extends ViewGroup {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f249025m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f249026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f249027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Scroller f249028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CustomViewBehind f249031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f249033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f249034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<View> f249035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f249036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f249037l;

    public static class a implements Interpolator {
        public a() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public interface b {
        void a();

        void onPageSelected(int r100);
    }

    public static class c implements b {
        public c() {
        }

        @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.b
        public final void a() {
        }
    }

    public void setOnClosedListener(SlidingMenu.e r100) {
    }

    public void setOnOpenedListener(SlidingMenu.g r100) {
    }

    static {
        f249025m = new a();
    }

    public final void b() {
        if (this.f249030e == false) goto L8;
        setScrollingCacheEnabled(false);
        this.f249028c.abortAnimation();
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f249028c.getCurrX();
        int r103 = this.f249028c.getCurrY();
        if (r100 != r102) goto L7;
        if (r101 == r103) goto L8;
    L7:
        scrollTo(r102, r103);
    L8:
        this.f249030e = false;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.f249028c.isFinished() == false) goto L5;
    L17:
        b();
        return;
    L5:
        if (this.f249028c.computeScrollOffset() == false) goto L17;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f249028c.getCurrX();
        int r103 = this.f249028c.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L15:
        invalidate();
        return;
    L9:
        scrollTo(r102, r103);
        int r104 = getWidth();
        int r105 = r102 / r104;
        int r106 = r102 % r104;
        b r107 = this.f249033h;
        if (r107 == null) goto L12;
        r107.a();
    L12:
        b r108 = this.f249034i;
        if (r108 == null) goto L15;
        r108.a();
        goto L15
    }

    public int getBehindWidth() {
        CustomViewBehind r100 = this.f249031f;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getBehindWidth();
    }

    public int getContentLeft() {
        return this.f249026a.getLeft() + this.f249026a.getPaddingLeft();
    }

    public int getDestScrollX() {
        return c(this.f249027b);
    }

    public int getLeftBound() {
        CustomViewBehind r100 = this.f249031f;
        View r101 = this.f249026a;
        int r102 = r100.f249045h;
        if (r102 == 0) goto L12;
        if (r102 == 2) goto L12;
        if (r102 == 1) goto L13;
        return 0;
    L13:
        return r101.getLeft();
    L12:
        return r101.getLeft() - r100.getBehindWidth();
    }

    public float getPercentOpen() {
        return Math.abs(this.f249037l - this.f249026a.getLeft()) / getBehindWidth();
    }

    public int getRightBound() {
        CustomViewBehind r100 = this.f249031f;
        View r101 = this.f249026a;
        int r102 = r100.f249045h;
        if (r102 != 0) goto L6;
        return r101.getLeft();
    L6:
        if (r102 != 1) goto L8;
    L11:
        int r103 = r101.getLeft();
        return r100.getSecondaryBehindWidth() + r103;
    L8:
        if (r102 == 2) goto L11;
        return 0;
    }

    public View getContent() {
        return this.f249026a;
    }

    public int getCurrentItem() {
        return this.f249027b;
    }

    public int getTouchMode() {
        return this.f249036k;
    }

    public CustomViewAbove(Context r100) {
        this(r100, null);
    }

    public final boolean a(int r100) {
        View r101 = findFocus();
        if (r101 != this) goto L5;
        r101 = null;
    L5:
        View r102 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        boolean r103 = false;
        if (r102 == null) goto L18;
        if (r102 == r101) goto L18;
        if (r100 != 17) goto L10;
        r103 = r102.requestFocus();
    L31:
        if (r103 == false) goto L33;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r100));
    L33:
        return r103;
    L10:
        if (r100 != 66) goto L31;
        if (r101 != null) goto L13;
    L17:
        r103 = r102.requestFocus();
        goto L31
    L13:
        if (r102.getLeft() > r101.getLeft()) goto L17;
        int r104 = this.f249027b;
        if (r104 >= 1) goto L31;
        d(r104 + 1, false, 0);
    L30:
        r103 = true;
    L18:
        if (r100 == 17) goto L27;
        if (r100 == 1) goto L27;
        if (r100 != 66) goto L23;
    L24:
        int r105 = this.f249027b;
        if (r105 >= 1) goto L31;
        d(r105 + 1, false, 0);
        goto L30
    L23:
        if (r100 != 2) goto L31;
    L27:
        int r106 = this.f249027b;
        if (r106 <= 0) goto L31;
        d(r106 - 1, false, 0);
        goto L30
    }

    public final int c(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L10;
        return 0;
    L9:
        return this.f249026a.getLeft();
    L10:
        CustomViewBehind r101 = this.f249031f;
        View r102 = this.f249026a;
        int r103 = r101.f249045h;
        if (r103 != 0) goto L18;
        if (r100 == 0) goto L16;
        if (r100 != 2) goto L32;
        return r102.getLeft();
    L32:
        return r102.getLeft();
    L16:
        int r104 = r102.getLeft();
        int r105 = r101.getBehindWidth();
    L34:
        return r104 - r105;
    L18:
        if (r103 != 1) goto L25;
        if (r100 == 0) goto L36;
        if (r100 != 2) goto L32;
        int r106 = r102.getLeft();
        int r107 = r101.getSecondaryBehindWidth();
    L35:
        return r106 + r107;
    L36:
        return r102.getLeft();
    L25:
        if (r103 != 2) goto L32;
        if (r100 == 0) goto L30;
        if (r100 != 2) goto L32;
        r106 = r102.getLeft();
        r107 = r101.getSecondaryBehindWidth();
        goto L35
    L30:
        r104 = r102.getLeft();
        r105 = r101.getBehindWidth();
        goto L34
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        super.dispatchDraw(r110);
        CustomViewBehind r100 = this.f249031f;
        View r101 = this.f249026a;
        int r102 = 0;
        if (r100.f249049l != null) goto L5;
    L20:
        CustomViewBehind r103 = this.f249031f;
        View r104 = this.f249026a;
        float r105 = getPercentOpen();
        if (r103.f249046i == false) goto L34;
        r103.f249047j.setColor(Color.argb((int) ((r103.f249052o * 255.0f) * Math.abs(1.0f - r105)), 0, 0, 0));
        int r106 = r103.f249045h;
        if (r106 != 0) goto L26;
        r102 = r104.getLeft() - r103.getBehindWidth();
        int r107 = r104.getLeft();
    L33:
        r110.drawRect(r102, 0.0f, r107, r103.getHeight(), r103.f249047j);
        goto L34
    L26:
        if (r106 != 1) goto L29;
        int r108 = r104.getRight();
        int r109 = r104.getRight();
        int r111 = r103.getSecondaryBehindWidth();
    L28:
        r102 = r108;
        r107 = r109 + r111;
        goto L33
    L29:
        if (r106 != 2) goto L32;
        r110.drawRect(r104.getLeft() - r103.getSecondaryBehindWidth(), 0.0f, r104.getLeft(), r103.getHeight(), r103.f249047j);
        r108 = r104.getRight();
        r109 = r104.getRight();
        r111 = r103.getSecondaryBehindWidth();
        goto L28
    L32:
        r107 = 0;
    L34:
        this.f249031f.a(this.f249026a, r110, getPercentOpen());
        return;
    L5:
        if (r100.f249051n <= 0) goto L20;
        int r112 = r100.f249045h;
        if (r112 != 0) goto L10;
        int r113 = r101.getLeft();
        int r114 = r100.f249051n;
    L17:
        int r115 = r113 - r114;
    L19:
        r100.f249049l.setBounds(r115, 0, r100.f249051n + r115, r100.getHeight());
        r100.f249049l.draw(r110);
        goto L20
    L10:
        if (r112 != 1) goto L12;
        r115 = r101.getRight();
        goto L19
    L12:
        if (r112 == 2) goto L14;
        r115 = 0;
        goto L19
    L14:
        if (r100.f249050m == null) goto L16;
        int r116 = r101.getRight();
        r100.f249050m.setBounds(r116, 0, r100.f249051n + r116, r100.getHeight());
        r100.f249050m.draw(r110);
    L16:
        r113 = r101.getLeft();
        r114 = r100.f249051n;
        goto L17
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
        return true;
    L5:
        if (r100.getAction() != 0) goto L21;
        int r101 = r100.getKeyCode();
        if (r101 != 21) goto L9;
        boolean r102 = a(17);
    L22:
        if (r102 == true) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r101 != 22) goto L11;
        r102 = a(66);
        goto L22
    L11:
        if (r101 != 61) goto L21;
        if (r100.hasNoModifiers() == false) goto L17;
        r102 = a(2);
        goto L22
    L17:
        if (r100.hasModifiers(1) == false) goto L21;
        r102 = a(1);
    L21:
        r102 = false;
        goto L22
    }

    public final boolean e(MotionEvent r100) {
        int r101 = (int) (r100.getX() + this.f249037l);
        int r102 = this.f249027b;
        boolean r103 = false;
        if (r102 == 0) goto L7;
        if (r102 == 2) goto L7;
        boolean r104 = false;
    L8:
        if (r104 == false) goto L16;
        CustomViewBehind r105 = this.f249031f;
        View r106 = this.f249026a;
        float r107 = r101;
        int r108 = r105.f249038a;
        if (r108 == 0) goto L15;
        if (r108 != 1) goto L52;
        return true;
    L52:
        return false;
    L15:
        return r105.b(r106, r102, r107);
    L16:
        int r109 = this.f249036k;
        if (r109 == 0) goto L28;
        if (r109 == 1) goto L20;
        return false;
    L20:
        Rect r110 = new Rect();
        Iterator r111 = ((ArrayList) this.f249035j).iterator();
    L22:
        if (r111.hasNext() == false) goto L27;
        ((View) r111.next()).getHitRect(r110);
        if (r110.contains((int) r100.getX(), (int) r100.getY()) == false) goto L22;
        r103 = true;
    L27:
        return !r103;
    L28:
        CustomViewBehind r112 = this.f249031f;
        View r113 = this.f249026a;
        r112.getClass();
        int r114 = r113.getLeft();
        int r115 = r113.getRight();
        int r116 = r112.f249045h;
        if (r116 != 0) goto L34;
        if (r101 >= r114) goto L32;
        return false;
    L32:
        if (r101 > (r112.f249041d + r114)) goto L54;
    L46:
        return true;
    L54:
        return false;
    L34:
        if (r116 != 1) goto L39;
        if (r101 <= r115) goto L37;
        return false;
    L37:
        if (r101 >= (r115 - r112.f249041d)) goto L46;
        return false;
    L39:
        if (r116 != 2) goto L57;
        if (r101 >= r114) goto L42;
    L43:
        if (r101 <= r115) goto L45;
        return false;
    L45:
        if (r101 >= (r115 - r112.f249041d)) goto L46;
        return false;
    L42:
        if (r101 <= (r112.f249041d + r114)) goto L46;
    L57:
        return false;
    L7:
        r104 = true;
        goto L8
    }

    public void setAboveOffset(int r100) {
        View r101 = this.f249026a;
        r101.setPadding(r100, r101.getPaddingTop(), this.f249026a.getPaddingRight(), this.f249026a.getPaddingBottom());
    }

    public void setContent(View r100) {
        View r101 = this.f249026a;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        this.f249026a = r100;
        addView(r100);
    }

    public void setCurrentItem(int r100) {
        d(r100, false, 0);
    }

    public void setCustomViewBehind(CustomViewBehind r100) {
        this.f249031f = r100;
    }

    public void setOnPageChangeListener(b r100) {
        this.f249033h = r100;
    }

    public void setScrollingCacheEnabled(boolean r100) {
        if (this.f249029d == r100) goto L6;
        this.f249029d = r100;
        return;
    }

    public void setSlidingEnabled(boolean r100) {
        this.f249032g = r100;
    }

    public void setTouchMode(int r100) {
        this.f249036k = r100;
    }

    public CustomViewAbove(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f249032g = true;
        this.f249035j = new ArrayList();
        this.f249036k = 0;
        this.f249037l = 0.0f;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        this.f249028c = new Scroller(getContext(), f249025m);
        this.f249034i = new com.bytedance.ies.uikit.menu.a(this);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = ViewGroup.getDefaultSize(0, r100);
        int r103 = ViewGroup.getDefaultSize(0, r101);
        setMeasuredDimension(r102, r103);
        int r104 = ViewGroup.getChildMeasureSpec(r100, 0, r102);
        int r105 = ViewGroup.getChildMeasureSpec(r101, 0, r103);
        this.f249026a.measure(r104, r105);
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r110) {
        super.scrollTo(r100, r110);
        this.f249037l = r100;
        int r101 = 2;
        boolean r102 = true;
        if (this.f249032g == false) goto L36;
        CustomViewBehind r103 = this.f249031f;
        View r104 = this.f249026a;
        int r105 = r103.f249045h;
        int r106 = 4;
        if (r105 == 0) goto L7;
        if (r105 == 1) goto L13;
        if (r105 != 2) goto L34;
        View r107 = r103.f249039b;
        if (r100 < r104.getLeft()) goto L21;
        int r108 = 4;
    L22:
        r107.setVisibility(r108);
        View r109 = r103.f249040c;
        if (r100 > r104.getLeft()) goto L25;
        int r111 = 4;
    L26:
        r109.setVisibility(r111);
        if (r100 == 0) goto L31;
        r106 = 0;
    L31:
        if (r100 > r104.getLeft()) goto L33;
        r103.scrollTo((int) ((r100 + r103.getBehindWidth()) * r103.f249048k), r110);
    L35:
        r103.setVisibility(r106);
        goto L36
    L33:
        r103.scrollTo((int) ((r103.getSecondaryBehindWidth() - r103.getWidth()) + ((r100 - r103.getSecondaryBehindWidth()) * r103.f249048k)), r110);
        goto L35
    L25:
        r111 = 0;
        goto L26
    L21:
        r108 = 0;
        goto L22
    L34:
        r106 = 0;
        goto L35
    L13:
        if (r100 <= r104.getLeft()) goto L16;
        r106 = 0;
    L16:
        r103.scrollTo((int) ((r103.getSecondaryBehindWidth() - r103.getWidth()) + ((r100 - r103.getSecondaryBehindWidth()) * r103.f249048k)), r110);
        goto L35
    L7:
        if (r100 >= r104.getLeft()) goto L10;
        r106 = 0;
    L10:
        r103.scrollTo((int) ((r100 + r103.getBehindWidth()) * r103.f249048k), r110);
    L36:
        SlidingMenu r112 = (SlidingMenu) getParent();
        float r113 = getPercentOpen();
        r112.getClass();
        if (r113 > 0.0f) goto L39;
    L41:
        r102 = false;
    L42:
        if (r102 == true) goto L46;
        r101 = 0;
    L46:
        if (r101 == r112.getContent().getLayerType()) goto L49;
        r112.f249059c.post(new h56.a(r112, r101));
        return;
    L49:
        return;
    L39:
        if (r113 >= 1.0f) goto L41;
        goto L41
    }

    public final void d(int r110, boolean r111, int r112) {
        if (r111 == false) goto L5;
    L8:
        CustomViewBehind r113 = this.f249031f;
        r113.getClass();
        int r100 = 2;
        if (r110 <= 1) goto L11;
        r110 = 2;
    L13:
        int r114 = r113.f249045h;
        if (r114 != 0) goto L17;
        if (r110 <= 1) goto L17;
        r100 = 0;
    L22:
        if (this.f249027b == r100) goto L24;
        boolean r115 = true;
    L25:
        this.f249027b = r100;
        int r116 = c(r100);
        if (r115 == false) goto L30;
        b r101 = this.f249033h;
        if (r101 == null) goto L30;
        r101.onPageSelected(r100);
    L30:
        if (r115 == false) goto L35;
        b r117 = this.f249034i;
        if (r117 == null) goto L35;
        r117.onPageSelected(r100);
    L35:
        if (getChildCount() != 0) goto L37;
        setScrollingCacheEnabled(false);
        return;
    L37:
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = r116 - r102;
        int r105 = 0 - r103;
        if (r104 != 0) goto L41;
        if (r105 != 0) goto L41;
        b();
        return;
    L41:
        setScrollingCacheEnabled(true);
        this.f249030e = true;
        int r118 = getBehindWidth();
        float r119 = r118 / 2;
        float r120 = r119 + (((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(r104) * 1.0f) / r118) - 0.5f)) * 0.4712389167638204d))) * r119);
        int r121 = Math.abs(r112);
        if (r121 <= 0) goto L44;
        int r122 = Math.round(Math.abs(r120 / r121) * 1000.0f) * 4;
    L45:
        this.f249028c.startScroll(r102, r103, r104, r105, Math.min(r122, 600));
        invalidate();
        return;
    L44:
        Math.abs(r104);
        r122 = 600;
        goto L45
    L24:
        r115 = false;
    L17:
        if (r114 != 1) goto L20;
        if (r110 < 1) goto L22;
    L20:
        r100 = r110;
        goto L22
    L11:
        if (r110 >= 1) goto L13;
        r110 = 0;
        goto L13
    L5:
        if (this.f249027b != r110) goto L8;
        setScrollingCacheEnabled(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 == r102) goto L6;
        b();
        scrollTo(c(this.f249027b), getScrollY());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = this.f249026a;
        r105.layout(0, 0, r103 - r101, r104 - r102);
    }
}
