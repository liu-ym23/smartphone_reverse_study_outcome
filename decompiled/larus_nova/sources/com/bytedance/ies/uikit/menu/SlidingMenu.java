package com.bytedance.ies.uikit.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public class SlidingMenu extends RelativeLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f249056q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CustomViewAbove f249057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CustomViewBehind f249058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f249059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f249060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f249063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f249064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f249065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f249066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f249067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f249068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f249069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f249070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f249071o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f249072p;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f249073a;

        public static class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f249073a = r100.readInt();
        }

        public SavedState(Parcelable r100, int r101) {
            super(r100);
            this.f249073a = r101;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f249073a);
        }
    }

    public class a implements CustomViewAbove.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SlidingMenu f249074a;

        @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.b
        public final void a() {
        }

        public a(SlidingMenu r100) {
            this.f249074a = r100;
        }

        @Override // com.bytedance.ies.uikit.menu.CustomViewAbove.b
        public final void onPageSelected(int r100) {
            if (r100 != 0) goto L5;
            SlidingMenu r101 = this.f249074a;
            int r102 = SlidingMenu.f249056q;
            r101.getClass();
        L5:
            if (r100 != 1) goto L8;
            SlidingMenu r103 = this.f249074a;
            int r104 = SlidingMenu.f249056q;
            r103.getClass();
            return;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public interface f {
    }

    public interface g {
    }

    public final void b() {
        this.f249062f = false;
        this.f249060d = false;
        this.f249061e = false;
        this.f249067k = -1;
        VelocityTracker r100 = this.f249068l;
        if (r100 == null) goto L6;
        r100.recycle();
        this.f249068l = null;
        return;
    }

    public void setIgnoreContentsBackground(boolean r100) {
    }

    public void setOnClickCloseListener(c r100) {
    }

    public void setOnCloseListener(d r100) {
    }

    public void setOnOpenListener(f r100) {
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.f249058b.getLayoutParams()).rightMargin;
    }

    public float getBehindScrollScale() {
        return this.f249058b.getScrollScale();
    }

    public View getContent() {
        return this.f249057a.getContent();
    }

    public int getCurrentItem() {
        return this.f249057a.getCurrentItem();
    }

    public View getMenu() {
        return this.f249058b.getContent();
    }

    public int getMode() {
        return this.f249058b.getMode();
    }

    public View getSecondaryMenu() {
        return this.f249058b.getSecondaryContent();
    }

    public int getTouchModeAbove() {
        return this.f249057a.getTouchMode();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f249057a.getCurrentItem());
    }

    public SlidingMenu(Context r100) {
        this(r100, null);
    }

    public final void a(MotionEvent r110) {
        int r100 = this.f249067k;
        int r101 = MotionEventCompat.findPointerIndex(r110, r100);
        if (r101 != (-1)) goto L5;
        this.f249067k = -1;
    L5:
        if (r100 != (-1)) goto L7;
        return;
    L7:
        float r102 = MotionEventCompat.getX(r110, r101);
        float r103 = r102 - this.f249065i;
        float r104 = Math.abs(r103);
        float r111 = MotionEventCompat.getY(r110, r101);
        float r105 = Math.abs(r111 - this.f249066j);
        CustomViewAbove r106 = this.f249057a;
        int r107 = r106.f249027b;
        if (r107 == 0) goto L12;
        if (r107 == 2) goto L12;
        boolean r108 = false;
    L13:
        if (r108 == false) goto L15;
        int r109 = this.f249063g / 2;
    L17:
        if (r104 <= r109) goto L53;
        if (r104 <= r105) goto L53;
        if (r107 == 0) goto L24;
        if (r107 == 2) goto L24;
        boolean r112 = false;
    L26:
        if (r112 == false) goto L38;
        int r113 = r106.f249031f.f249045h;
        if (r113 == 0) goto L30;
        if (r113 == 1) goto L34;
        if (r113 == 2) goto L48;
    L49:
        boolean r114 = false;
    L50:
        if (r114 == false) goto L53;
        this.f249060d = true;
        this.f249062f = false;
        this.f249065i = r102;
        this.f249066j = r111;
        r106.setScrollingCacheEnabled(true);
        return;
    L48:
        r114 = true;
        goto L50
    L34:
        if (r103 <= 0.0f) goto L49;
    L30:
        if (r103 >= 0.0f) goto L49;
    L38:
        int r115 = r106.f249031f.f249045h;
        if (r115 == 0) goto L41;
        if (r115 == 1) goto L45;
        if (r115 != 2) goto L49;
    L45:
        if (r103 >= 0.0f) goto L49;
    L41:
        if (r103 <= 0.0f) goto L49;
    L24:
        r112 = true;
    L53:
        if (r104 <= this.f249063g) goto L57;
        this.f249061e = true;
        return;
    L57:
        return;
    L15:
        r109 = this.f249063g;
    L12:
        r108 = true;
        goto L13
    }

    public final void c(MotionEvent r100) {
        int r101 = MotionEventCompat.getActionIndex(r100);
        if (MotionEventCompat.getPointerId(r100, r101) != this.f249067k) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f249065i = MotionEventCompat.getX(r100, r102);
        this.f249067k = MotionEventCompat.getPointerId(r100, r102);
        VelocityTracker r103 = this.f249068l;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect r100) {
        int r101 = r100.left;
        int r102 = r100.right;
        setPadding(r101, r100.top, r102, r100.bottom);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f249072p == true) goto L5;
        return false;
    L5:
        int r101 = r100.getAction() & 255;
        if (r101 != 3) goto L8;
    L49:
        b();
        return false;
    L8:
        if (r101 == 1) goto L49;
        if (r101 == 0) goto L14;
        if (this.f249061e == true) goto L49;
    L14:
        if (r101 == 0) goto L21;
        if (r101 != 2) goto L17;
        a(r100);
    L38:
        if (this.f249060d == true) goto L44;
        if (this.f249068l != null) goto L42;
        this.f249068l = VelocityTracker.obtain();
    L42:
        this.f249068l.addMovement(r100);
    L44:
        if (this.f249060d == false) goto L46;
    L47:
        return true;
    L46:
        if (this.f249062f == true) goto L47;
        return false;
    L17:
        if (r101 != 6) goto L38;
        c(r100);
        goto L38
    L21:
        int r102 = MotionEventCompat.getActionIndex(r100);
        int r103 = MotionEventCompat.getPointerId(r100, r102);
        this.f249067k = r103;
        if (r103 == (-1)) goto L38;
        float r104 = MotionEventCompat.getX(r100, r102);
        this.f249064h = r104;
        this.f249065i = r104;
        this.f249066j = MotionEventCompat.getY(r100, r102);
        if (this.f249057a.e(r100) == false) goto L36;
        this.f249060d = false;
        this.f249061e = false;
        this.f249062f = false;
        CustomViewAbove r105 = this.f249057a;
        int r106 = r105.f249027b;
        if (r106 == 0) goto L31;
        if (r106 == 2) goto L31;
        boolean r107 = false;
    L32:
        if (r107 == false) goto L38;
        if (r105.f249031f.b(r105.f249026a, r106, r100.getX() + r105.f249037l) == false) goto L38;
        this.f249062f = true;
    L31:
        r107 = true;
        goto L32
    L36:
        this.f249061e = true;
        goto L38
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f249057a.setCurrentItem(r101.f249073a);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f249072p == true) goto L6;
        return false;
    L6:
        if (this.f249060d == false) goto L8;
    L10:
        int r101 = r100.getAction();
        if (this.f249068l != null) goto L13;
        this.f249068l = VelocityTracker.obtain();
    L13:
        this.f249068l.addMovement(r100);
        int r102 = r101 & 255;
        if (r102 != 0) goto L16;
        this.f249057a.b();
        this.f249067k = MotionEventCompat.getPointerId(r100, MotionEventCompat.getActionIndex(r100));
        float r103 = r100.getX();
        this.f249064h = r103;
        this.f249065i = r103;
    L89:
        return true;
    L16:
        if (r102 == 1) goto L63;
        if (r102 == 2) goto L38;
        if (r102 == 3) goto L35;
        if (r102 != 5) goto L24;
        int r104 = MotionEventCompat.getActionIndex(r100);
        this.f249065i = MotionEventCompat.getX(r100, r104);
        this.f249067k = MotionEventCompat.getPointerId(r100, r104);
        goto L89
    L24:
        if (r102 != 6) goto L89;
        c(r100);
        int r105 = MotionEventCompat.findPointerIndex(r100, this.f249067k);
        if (r105 != (-1)) goto L30;
        this.f249067k = -1;
    L30:
        if (this.f249067k == (-1)) goto L89;
        this.f249065i = MotionEventCompat.getX(r100, r105);
        goto L89
    L35:
        if (this.f249060d == false) goto L89;
        CustomViewAbove r106 = this.f249057a;
        r106.d(r106.getCurrentItem(), true, 0);
        this.f249067k = -1;
        b();
        goto L89
    L38:
        if (this.f249060d == true) goto L43;
        a(r100);
        if (this.f249061e == false) goto L43;
        return false;
    L43:
        if (this.f249060d == false) goto L89;
        int r107 = MotionEventCompat.findPointerIndex(r100, this.f249067k);
        if (r107 != (-1)) goto L48;
        this.f249067k = -1;
    L48:
        if (this.f249067k == (-1)) goto L89;
        float r108 = MotionEventCompat.getX(r100, r107);
        float r109 = this.f249065i - r108;
        this.f249065i = r108;
        float r110 = this.f249057a.getScrollX() + r109;
        float r111 = this.f249057a.getLeftBound();
        float r112 = this.f249057a.getRightBound();
        if (r110 >= r111) goto L54;
        r110 = r111;
    L56:
        int r113 = (int) r110;
        this.f249065i += r110 - r113;
        this.f249057a.scrollTo(r113, getScrollY());
        CustomViewAbove r114 = this.f249057a;
        int r115 = r114.getWidth();
        int r116 = r113 / r115;
        int r117 = r113 % r115;
        CustomViewAbove.b r118 = r114.f249033h;
        if (r118 == null) goto L59;
        r118.a();
    L59:
        CustomViewAbove.b r119 = r114.f249034i;
        if (r119 == null) goto L89;
        r119.a();
        goto L89
    L54:
        if (r110 <= r112) goto L56;
        r110 = r112;
        goto L56
    L63:
        if (this.f249060d == false) goto L84;
        VelocityTracker r120 = this.f249068l;
        r120.computeCurrentVelocity(1000, this.f249070n);
        int r121 = (int) VelocityTrackerCompat.getXVelocity(r120, this.f249067k);
        float r122 = (this.f249057a.getScrollX() - this.f249057a.getDestScrollX()) / this.f249058b.getBehindWidth();
        int r123 = MotionEventCompat.findPointerIndex(r100, this.f249067k);
        if (r123 != (-1)) goto L68;
        this.f249067k = -1;
    L68:
        if (this.f249067k == (-1)) goto L81;
        int r124 = (int) (MotionEventCompat.getX(r100, r123) - this.f249064h);
        int r125 = this.f249057a.getCurrentItem();
        if (Math.abs(r124) > this.f249071o) goto L72;
    L79:
        r125 = Math.round(r125 + r122);
    L80:
        this.f249057a.d(r125, true, r121);
    L82:
        this.f249067k = -1;
        b();
        goto L89
    L72:
        if (Math.abs(r121) <= this.f249069m) goto L79;
        if (r121 <= 0) goto L76;
        if (r124 <= 0) goto L76;
        r125 = r125 - 1;
    L76:
        if (r121 >= 0) goto L80;
        if (r124 >= 0) goto L80;
        r125 = r125 + 1;
        goto L80
    L81:
        CustomViewAbove r126 = this.f249057a;
        r126.d(r126.getCurrentItem(), true, r121);
        goto L82
    L84:
        if (this.f249062f == false) goto L89;
        CustomViewAbove r127 = this.f249057a;
        if (r127.f249031f.b(r127.f249026a, r127.f249027b, r100.getX() + r127.f249037l) == false) goto L89;
        this.f249057a.setCurrentItem(1);
        b();
        goto L89
    L8:
        if (this.f249057a.e(r100) == true) goto L10;
        return false;
    }

    public void setAboveOffset(int r100) {
        this.f249057a.setAboveOffset(r100);
    }

    public void setAboveOffsetRes(int r100) {
        setAboveOffset((int) getContext().getResources().getDimension(r100));
    }

    public void setBehindCanvasTransformer(b r100) {
        this.f249058b.setCanvasTransformer(r100);
    }

    public void setBehindOffset(int r100) {
        this.f249058b.setWidthOffset(r100);
    }

    public void setBehindOffsetRes(int r100) {
        setBehindOffset((int) getContext().getResources().getDimension(r100));
    }

    public void setBehindScrollScale(float r100) {
        if (r100 < 0.0f) goto L5;
    L9:
        this.f249058b.setScrollScale(r100);
        return;
    L5:
        if (r100 <= 1.0f) goto L9;
        throw new IllegalStateException("ScrollScale must be between 0 and 1");
    }

    public void setBehindWidth(int r100) {
        Display r101 = ((WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r102 = new Point();     // Catch: Exception -> L5
        Display.class.getMethod("getSize", new Class[]{Point.class}).invoke(r101, new Object[]{r102});     // Catch: Exception -> L5
        int r103 = r102.x;     // Catch: Exception -> L5
    L6:
        setBehindOffset(r103 - r100);
        return;
    L5:
        r103 = r101.getWidth();
        goto L6
    }

    public void setBehindWidthRes(int r100) {
        setBehindWidth((int) getContext().getResources().getDimension(r100));
    }

    public void setContent(int r100) {
        setContent(LayoutInflater.from(getContext()).inflate(r100, null));
    }

    public void setFadeDegree(float r100) {
        this.f249058b.setFadeDegree(r100);
    }

    public void setFadeEnabled(boolean r100) {
        this.f249058b.setFadeEnabled(r100);
    }

    public void setMenu(int r100) {
        setMenu(LayoutInflater.from(getContext()).inflate(r100, null));
    }

    public void setMode(int r100) {
        if (r100 != 0) goto L4;
    L10:
        this.f249058b.setMode(r100);
        return;
    L4:
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L10;
        throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
    }

    public void setOnClosedListener(e r100) {
        this.f249057a.setOnClosedListener(r100);
    }

    public void setOnOpenedListener(g r100) {
        this.f249057a.setOnOpenedListener(r100);
    }

    public void setRightBehindOffset(int r100) {
        this.f249058b.setSecondaryWidthOffset(r100);
    }

    public void setRightBehindOffsetRes(int r100) {
        setRightBehindOffset((int) getContext().getResources().getDimension(r100));
    }

    public void setSecondaryMenu(int r100) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(r100, null));
    }

    public void setSecondaryShadowDrawable(int r100) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(r100));
    }

    public void setSelectedView(View r100) {
        this.f249058b.setSelectedView(r100);
    }

    public void setSelectorBitmap(Bitmap r100) {
        this.f249058b.setSelectorBitmap(r100);
    }

    public void setSelectorDrawable(int r100) {
        this.f249058b.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), r100));
    }

    public void setSelectorEnabled(boolean r100) {
        this.f249058b.setSelectorEnabled(true);
    }

    public void setShadowDrawable(int r100) {
        setShadowDrawable(getContext().getResources().getDrawable(r100));
    }

    public void setShadowWidth(int r100) {
        this.f249058b.setShadowWidth(r100);
    }

    public void setShadowWidthRes(int r100) {
        setShadowWidth((int) getResources().getDimension(r100));
    }

    public void setSlidingEnabled(boolean r100) {
        this.f249072p = r100;
        this.f249057a.setSlidingEnabled(r100);
    }

    public void setStatic(boolean r100) {
        if (r100 == false) goto L5;
        setSlidingEnabled(false);
        this.f249057a.setCustomViewBehind(null);
        this.f249057a.setCurrentItem(1);
        return;
    L5:
        this.f249057a.setCurrentItem(1);
        this.f249057a.setCustomViewBehind(this.f249058b);
        setSlidingEnabled(true);
    }

    public void setTouchModeAbove(int r100) {
        if (r100 == 1) goto L10;
        if (r100 == 0) goto L10;
        if (r100 == 2) goto L10;
        throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    L10:
        this.f249057a.setTouchMode(r100);
    }

    public void setTouchModeBehind(int r100) {
        if (r100 == 1) goto L10;
        if (r100 == 0) goto L10;
        if (r100 == 2) goto L10;
        throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    L10:
        this.f249058b.setTouchMode(r100);
    }

    public void setContent(View r100) {
        this.f249057a.setContent(r100);
        this.f249057a.d(1, false, 0);
    }

    public void setMenu(View r100) {
        this.f249058b.setContent(r100);
    }

    public void setSecondaryMenu(View r100) {
        this.f249058b.setSecondaryContent(r100);
    }

    public void setSecondaryShadowDrawable(Drawable r100) {
        this.f249058b.setSecondaryShadowDrawable(r100);
    }

    public void setShadowDrawable(Drawable r100) {
        this.f249058b.setShadowDrawable(r100);
    }

    public SlidingMenu(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public SlidingMenu(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f249059c = new Handler();
        this.f249062f = false;
        this.f249067k = -1;
        this.f249072p = true;
        ViewConfiguration r103 = ViewConfiguration.get(r100);
        this.f249063g = ViewConfigurationCompat.getScaledPagingTouchSlop(r103);
        this.f249069m = r103.getScaledMinimumFlingVelocity();
        this.f249070n = r103.getScaledMaximumFlingVelocity();
        Resources r104 = r100.getResources();
        this.f249071o = (int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 25.0f);
        ViewGroup.LayoutParams r105 = new RelativeLayout.LayoutParams(-1, -1);
        CustomViewBehind r106 = new CustomViewBehind(r100);
        this.f249058b = r106;
        addView(r106, r105);
        ViewGroup.LayoutParams r107 = new RelativeLayout.LayoutParams(-1, -1);
        CustomViewAbove r108 = new CustomViewAbove(r100);
        this.f249057a = r108;
        addView(r108, r107);
        r108.setCustomViewBehind(r106);
        r106.setCustomViewAbove(r108);
        r108.setOnPageChangeListener(new a(this));
        TypedArray r109 = r100.obtainStyledAttributes(r101, new int[]{R.attr.appearMode, R.attr.behindOffset, R.attr.behindScrollScale, R.attr.behindWidth, R.attr.fadeDegree, R.attr.fadeEnabled, R.attr.mode, R.attr.selectorDrawable, R.attr.selectorEnabled, R.attr.shadowDrawable, R.attr.shadowWidth, R.attr.touchModeAbove, R.attr.touchModeBehind, R.attr.viewAbove, R.attr.viewBehind});
        setMode(r109.getInt(0, 0));
        int r110 = r109.getResourceId(13, -1);
        if (r110 == (-1)) goto L5;
        setContent(r110);
    L6:
        int r111 = r109.getResourceId(14, -1);
        if (r111 == (-1)) goto L9;
        setMenu(r111);
    L10:
        setTouchModeAbove(r109.getInt(11, 0));
        setTouchModeBehind(r109.getInt(12, 0));
        int r112 = (int) r109.getDimension(1, -1.0f);
        int r113 = (int) r109.getDimension(3, -1.0f);
        if (r112 == (-1)) goto L16;
        if (r113 == (-1)) goto L16;
        throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
    L16:
        if (r112 == (-1)) goto L18;
        setBehindOffset(r112);
    L21:
        setBehindScrollScale(r109.getFloat(2, 0.33f));
        int r114 = r109.getResourceId(9, -1);
        if (r114 == (-1)) goto L24;
        setShadowDrawable(r114);
    L24:
        setShadowWidth((int) r109.getDimension(10, 0.0f));
        setFadeEnabled(r109.getBoolean(5, true));
        setFadeDegree(r109.getFloat(4, 0.33f));
        setSelectorEnabled(r109.getBoolean(8, false));
        int r115 = r109.getResourceId(7, -1);
        if (r115 == (-1)) goto L27;
        setSelectorDrawable(r115);
    L27:
        r109.recycle();
        return;
    L18:
        if (r113 == (-1)) goto L20;
        setBehindWidth(r113);
        goto L21
    L20:
        setBehindOffset(0);
        goto L21
    L9:
        setMenu(new FrameLayout(r100));
        goto L10
    L5:
        setContent(new FrameLayout(r100));
        goto L6
    }
}
