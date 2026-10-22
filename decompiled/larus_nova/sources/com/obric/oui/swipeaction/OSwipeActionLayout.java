package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "使用 OSwipeLayout")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u000bB'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0002¢\u0006\u0004\b6\u00107R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001f\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000eR\u0014\u0010!\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000eR\u0014\u0010#\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000eR\u0014\u0010%\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0006R\u0014\u0010'\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u0014\u0010)\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000eR$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00068"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getDirection", "()I", "setDirection", "(I)V", "direction", "", "b", "Z", "getSwipeEnabled", "()Z", "setSwipeEnabled", "(Z)V", "swipeEnabled", "c", "getContinuousSwipe", "setContinuousSwipe", "continuousSwipe", "value", "o", "setRightViewPadding", "rightViewPadding", "getPreviousPosition", "previousPosition", "getRightViewOpened", "rightViewOpened", "getLeftViewOpened", "leftViewOpened", "getRightOpenFinished", "rightOpenFinished", "getLeftOpenFinished", "leftOpenFinished", "getLViewWidth", "lViewWidth", "getRViewWidth", "rViewWidth", "getRightViewEmpty", "rightViewEmpty", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;", "actionsListener", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;", "getActionsListener", "()Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;", "setActionsListener", "(Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSwipeActionLayout extends FrameLayout {
    public View A;
    public final int B;
    public View C;
    public View D;
    public final int E;
    public final c F;
    public final OSwipeActionLayout$dragHelperCallback$1 G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f403053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f403054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f403055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f403056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f403057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f403058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f403059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f403060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f403061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f403062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f403063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f403064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f403065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f403066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f403067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f403068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f403069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f403070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewDragHelper f403071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GestureDetectorCompat f403072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f403073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f403074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f403075w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f403076x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f403077y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f403078z;

    public static final class a {
    }

    public interface b {
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeActionLayout f403079a;

        public c(OSwipeActionLayout r100) {
            this.f403079a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, "e1");
            Intrinsics.checkNotNullParameter(r101, "e2");
            ViewParent r104 = this.f403079a.getParent();
            if (r104 == null) goto L8;
            r104.requestDisallowInterceptTouchEvent(true);
            return false;
        L8:
            return false;
        }
    }

    static {
    }

    public OSwipeActionLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSwipeActionLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static /* synthetic */ void a(OSwipeActionLayout r100) {
        m8591setupPost$lambda2(r100);
    }

    public final b getActionsListener() {
        return null;
    }

    public final void setActionsListener(b r100) {
    }

    private final boolean getLeftOpenFinished() {
        if (this.f403073u != (this.f403074v - this.E)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        if (this.C != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f403073u != getLViewWidth()) goto L7;
        return true;
    }

    private final int getPreviousPosition() {
        if (this.f403075w == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.f403076x == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final boolean getRightOpenFinished() {
        if (this.f403073u != ((-this.f403074v) + this.B)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        if (this.f403078z != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewOpened() {
        if (this.f403078z != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f403073u != (-getRViewWidth())) goto L7;
        return true;
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r100 = this.f403071s;
        Intrinsics.checkNotNull(r100);
        if (r100.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        int r100 = this.f403065m;
        if (r100 == 0) goto L5;
        this.f403077y = findViewById(r100);
    L5:
        int r101 = this.f403062j;
        if (r101 == 0) goto L8;
        this.C = findViewById(r101);
    L8:
        int r102 = this.f403059g;
        if (r102 == 0) goto L11;
        this.f403078z = findViewById(r102);
    L11:
        int r103 = this.f403060h;
        if (r103 == 0) goto L14;
        this.A = findViewById(r103);
    L14:
        int r104 = this.f403063k;
        if (r104 == 0) goto L18;
        this.D = findViewById(r104);
    L18:
        if (this.f403077y == null) goto L61;
        int r105 = this.f403053a;
        if (r105 != 1) goto L27;
        if (this.f403078z != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r105 == 2) goto L29;
    L33:
        if (r105 == 1) goto L35;
    L41:
        if (r105 != 2) goto L50;
        if (this.f403055c == true) goto L50;
        if (this.C != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r105 == 3) goto L52;
    L58:
        this.f403071s = ViewDragHelper.create(this, 1.0f, this.G);
        this.f403072t = new GestureDetectorCompat(getContext(), this.F);
        post(new com.obric.oui.swipeaction.a(this));
        super.onFinishInflate();
        return;
    L52:
        if (this.f403078z == null) goto L57;
        if (this.C != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.f403055c == true) goto L41;
        if (this.f403078z != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.C != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    private final int getLViewWidth() {
        return this.f403064l;
    }

    private final int getRViewWidth() {
        return this.f403061i;
    }

    public final boolean getContinuousSwipe() {
        return this.f403055c;
    }

    public final int getDirection() {
        return this.f403053a;
    }

    public final boolean getSwipeEnabled() {
        return this.f403054b;
    }

    public static final /* synthetic */ int h(OSwipeActionLayout r100) {
        return r100.getPreviousPosition();
    }

    public static final void i(OSwipeActionLayout r100) {
        if (r100.f403073u != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L17;
        r100.f403075w = false;
        r100.f403076x = false;
        View r102 = r100.f403078z;
        if (r102 == null) goto L11;
        r102.layout(0, r102.getTop(), r102.getWidth(), r102.getBottom());
    L11:
        View r103 = r100.C;
        if (r103 == null) goto L15;
        r103.layout(0, r103.getTop(), r103.getWidth(), r103.getBottom());
    L15:
        r100.f403066n = 0;
        return;
    L17:
        if (r100.getLeftOpenFinished() == false) goto L19;
    L26:
        r100.f403075w = true;
        r100.f403076x = false;
        return;
    L19:
        if (r100.getLeftViewOpened() == true) goto L26;
        if (r100.getRightOpenFinished() == false) goto L24;
    L25:
        r100.f403075w = false;
        r100.f403076x = true;
        return;
    L24:
        if (r100.getRightViewOpened() == true) goto L25;
        return;
    L5:
        r101 = false;
        goto L6
    }

    private final void setRightViewPadding(int r100) {
        this.f403067o = r100;
        if (this.f403055c == false) goto L8;
        if (this.f403053a == 3) goto L8;
        this.f403057e = true;
    L8:
        if (this.f403053a != 3) goto L11;
        setRightViewPadding(0);
        this.f403068p = 0;
        return;
    }

    /* JADX INFO: renamed from: setupPost$lambda-2, reason: not valid java name */
    private static final void m8591setupPost$lambda2(OSwipeActionLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        int r101 = r100.f403053a;
        if (r101 != 1) goto L5;
        View r102 = r100.f403078z;
        Intrinsics.checkNotNull(r102);
        r102.setX(r100.f403074v);
        return;
    L5:
        if (r101 != 2) goto L7;
        View r103 = r100.C;
        Intrinsics.checkNotNull(r103);
        View r104 = r100.C;
        Intrinsics.checkNotNull(r104);
        r103.setX(-r104.getWidth());
        return;
    L7:
        if (r101 != 3) goto L15;
        View r105 = r100.f403078z;
        Intrinsics.checkNotNull(r105);
        r105.setX(r100.f403074v);
        View r106 = r100.C;
        Intrinsics.checkNotNull(r106);
        View r107 = r100.C;
        Intrinsics.checkNotNull(r107);
        r106.setX(-r107.getWidth());
        return;
    }

    public final boolean k(MotionEvent r100) {
        int[] r101 = new int[2];
        View r102 = this.f403077y;
        Intrinsics.checkNotNull(r102);
        r102.getLocationOnScreen(r101);
        int r103 = r101[1];
        View r104 = this.f403077y;
        Intrinsics.checkNotNull(r104);
        int r105 = r103 + r104.getMeasuredHeight();
        int r106 = r101[1];
        int r107 = (int) r100.getRawY();
        if ((r106 + 1) > r107) goto L6;
        if (r107 >= r105) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f403069q == false) goto L21;
        View r101 = this.f403077y;
        if ((r101 instanceof ViewGroup) == false) goto L21;
        View r102 = j(r100, (ViewGroup) r101);
        Point r103 = new Point((int) r100.getX(), (int) r100.getY());
        if (r102 == null) goto L21;
        if (r103.y >= r102.getTop()) goto L11;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L21;
        return false;
    L11:
        if (r103.y >= r102.getBottom()) goto L17;
        if (r103.x < r102.getLeft()) goto L17;
        if (r103.y >= r102.getRight()) goto L17;
        r104 = true;
    L21:
        if (k(r100) == false) goto L25;
        ViewDragHelper r105 = this.f403071s;
        Intrinsics.checkNotNull(r105);
        if (r105.shouldInterceptTouchEvent(r100) == false) goto L25;
        return true;
    L25:
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (k(r100) == true) goto L14;
        int r101 = this.f403070r;
        if (r101 != 1) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        return super.onTouchEvent(r100);
    L7:
        if (r101 == 2) goto L10;
        r102 = false;
    L14:
        GestureDetectorCompat r103 = this.f403072t;
        Intrinsics.checkNotNull(r103);
        r103.onTouchEvent(r100);
        ViewDragHelper r104 = this.f403071s;
        Intrinsics.checkNotNull(r104);
        r104.processTouchEvent(r100);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        this.f403069q = r100;
    }

    public final void setContinuousSwipe(boolean r100) {
        this.f403055c = r100;
    }

    public final void setDirection(int r100) {
        this.f403053a = r100;
    }

    public final void setSwipeEnabled(boolean r100) {
        this.f403054b = r100;
    }

    public static final int c(OSwipeActionLayout r100, int r101) {
        if (r100.f403055c == false) goto L16;
        if (r100.getRightViewEmpty() == false) goto L16;
        if (r100.f403058f == false) goto L12;
        int r102 = r100.f403074v;
        if (r101 <= r102) goto L36;
        return 0;
    L36:
        return RangesKt.coerceAtLeast(r101, -r102);
    L12:
        if (r101 <= 0) goto L37;
        return 0;
    L37:
        return RangesKt.coerceAtLeast(r101, -r100.f403074v);
    L16:
        if (r100.f403057e == false) goto L27;
        if (r100.f403058f == false) goto L23;
        int r103 = r100.f403074v;
        if (r101 <= r103) goto L38;
        return 0;
    L38:
        return RangesKt.coerceAtLeast(r101, r100.f403068p - r103);
    L23:
        if (r101 <= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtLeast(r101, r100.f403068p - r100.f403074v);
    L27:
        if (r100.f403058f == true) goto L29;
        if (r101 <= 0) goto L35;
        return 0;
    L35:
        return RangesKt.coerceAtLeast(r101, -r100.getRViewWidth());
    L29:
        if (r101 <= r100.f403074v) goto L40;
        return 0;
    L40:
        return RangesKt.coerceAtLeast(r101, -r100.getRViewWidth());
    }

    public static final int d(OSwipeActionLayout r100, int r101) {
        if (r100.f403055c == false) goto L16;
        if (r100.getRightViewEmpty() == false) goto L16;
        if (r100.f403058f == false) goto L12;
        int r102 = r100.f403074v;
        int r103 = -r102;
        if (r101 >= r103) goto L37;
        return r103;
    L37:
        return RangesKt.coerceAtMost(r101, r102);
    L12:
        if (r101 >= 0) goto L38;
        return 0;
    L38:
        return RangesKt.coerceAtMost(r101, r100.f403074v);
    L16:
        if (r100.f403057e == false) goto L28;
        if (r100.f403058f == false) goto L24;
        int r104 = r100.f403074v;
        int r105 = -r104;
        if (r101 < r105) goto L44;
        int r106 = RangesKt.coerceAtMost(r101, r104 - r100.f403067o);
    L39:
        return r106;
    L44:
        return r105;
    L24:
        if (r101 >= 0) goto L40;
        return 0;
    L40:
        return RangesKt.coerceAtMost(r101, r100.f403074v - r100.f403067o);
    L28:
        if (r100.f403058f == false) goto L33;
        int r107 = -r100.f403074v;
        if (r101 < r107) goto L41;
        r106 = RangesKt.coerceAtMost(r101, r100.getLViewWidth());
        goto L39
    L41:
        return r107;
    L33:
        if (r101 >= 0) goto L36;
        return 0;
    L36:
        return RangesKt.coerceAtMost(r101, r100.getLViewWidth());
    }

    public static final int e(OSwipeActionLayout r100, float r110) {
        boolean r101 = true;
        if (r110 < 0.0f) goto L13;
        int r102 = r100.f403073u;
        if (r102 > 0) goto L8;
    L9:
        if (r102 <= 0) goto L13;
        if (Math.abs(r102) <= (r100.getLViewWidth() / 2)) goto L13;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        return r100.getLViewWidth();
    L17:
        if (r110 > 0.0f) goto L27;
        int r104 = r100.f403073u;
        if (r104 < 0) goto L22;
    L23:
        if (r104 >= 0) goto L27;
        if (Math.abs(r104) <= (r100.getRViewWidth() / 2)) goto L27;
    L26:
        boolean r105 = true;
    L28:
        if (r105 == true) goto L51;
        int r106 = r100.f403073u;
        if (r106 >= 0) goto L33;
    L34:
        if (r106 <= 0) goto L36;
    L37:
        if (r106 >= 0) goto L39;
    L40:
        int r111 = r100.f403073u;
        if (r111 <= 0) goto L43;
    L45:
        r101 = false;
    L46:
        if (r101 == true) goto L52;
        return -1;
    L52:
        return 0;
    L43:
        if (Math.abs(r111) >= (r100.getRViewWidth() / 2)) goto L45;
    L39:
        if (Math.abs(r106) < (r100.getLViewWidth() / 2)) goto L46;
    L36:
        if (r110 > r100.f403056d) goto L46;
    L33:
        if (r110 < (-r100.f403056d)) goto L46;
    L51:
        return -r100.getRViewWidth();
    L22:
        if (r110 < (-r100.f403056d)) goto L26;
    L27:
        r105 = false;
        goto L28
    L8:
        if (r110 > r100.f403056d) goto L12;
    L13:
        r103 = false;
        goto L14
    }

    public static final int f(OSwipeActionLayout r100, float r101) {
        boolean r102 = true;
        if (r100.f403055c == true) goto L5;
    L26:
        double r103 = r101;
        double r104 = r100.f403056d;
        if (r103 <= r104) goto L30;
    L40:
        r102 = false;
    L41:
        if (r102 == true) goto L43;
        return 0;
    L43:
        return -r100.getRViewWidth();
    L30:
        if (r103 < (-r104)) goto L41;
        int r105 = r100.f403073u;
        if (r105 < 0) goto L35;
    L37:
        int r106 = r100.f403073u;
        if (r106 >= 0) goto L40;
        Math.abs(r106);
        int r107 = r100.getRViewWidth() / 2;
        goto L40
    L35:
        if (Math.abs(r105) <= (r100.getRViewWidth() / 2)) goto L37;
    L5:
        if (r100.getRightViewEmpty() == false) goto L15;
        int r108 = r100.f403073u;
        if (r108 >= 0) goto L11;
        if (Math.abs(r108) <= (r100.f403074v / 2)) goto L11;
    L12:
        int r109 = -r100.f403074v;
        int r110 = r100.B;
    L45:
        return r109 + r110;
    L11:
        if (r101 < (-r100.f403056d)) goto L12;
        return 0;
    L15:
        if (r101 < (-r100.f403056d)) goto L17;
    L18:
        int r111 = r100.f403073u;
        if (r111 < 0) goto L21;
    L23:
        boolean r112 = false;
    L24:
        if (r112 == false) goto L26;
        r109 = -r100.f403074v;
        r110 = r100.B;
        goto L45
    L21:
        if (Math.abs(r111) <= (r100.f403074v / 2)) goto L23;
    L22:
        r112 = true;
        goto L24
    L17:
        if (Math.abs(r100.f403073u) > r100.getRViewWidth()) goto L22;
        goto L18
    }

    public static final int g(OSwipeActionLayout r100, float r101) {
        boolean r102 = true;
        if (r100.f403055c == true) goto L5;
    L26:
        double r103 = r101;
        double r104 = r100.f403056d;
        if (r103 <= r104) goto L30;
    L41:
        if (r102 == true) goto L43;
        return 0;
    L43:
        return r100.getLViewWidth();
    L30:
        if (r103 < (-r104)) goto L40;
        int r105 = r100.f403073u;
        if (r105 > 0) goto L35;
    L37:
        int r106 = r100.f403073u;
        if (r106 <= 0) goto L40;
        Math.abs(r106);
        int r107 = r100.getLViewWidth() / 2;
        goto L40
    L35:
        if (Math.abs(r105) <= (r100.getLViewWidth() / 2)) goto L37;
    L40:
        r102 = false;
        goto L41
    L5:
        if (r100.getRightViewEmpty() == false) goto L15;
        int r108 = r100.f403073u;
        if (r108 <= 0) goto L11;
        if (Math.abs(r108) <= (r100.f403074v / 2)) goto L11;
    L12:
        int r109 = r100.f403074v;
        int r110 = r100.E;
    L45:
        return r109 - r110;
    L11:
        if (r101 > r100.f403056d) goto L12;
        return 0;
    L15:
        if (r101 > r100.f403056d) goto L17;
    L18:
        int r111 = r100.f403073u;
        if (r111 > 0) goto L21;
    L23:
        boolean r112 = false;
    L24:
        if (r112 == false) goto L26;
        r109 = r100.f403074v;
        r110 = r100.E;
        goto L45
    L21:
        if (Math.abs(r111) <= (r100.f403074v / 2)) goto L23;
    L22:
        r112 = true;
        goto L24
    L17:
        if (Math.abs(r100.f403073u) > r100.getLViewWidth()) goto L22;
        goto L18
    }

    public static View j(MotionEvent r100, ViewGroup r101) {
        Intrinsics.checkNotNull(r101);
        if (r101.onInterceptTouchEvent(r100) == false) goto L5;
        return r101;
    L5:
        int r102 = r101.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        int r104 = r103 + 1;
        View r105 = r101.getChildAt(r103);
        if ((r105 instanceof ViewGroup) == true) goto L11;
        r103 = r104;
        goto L6
    L11:
        return j(r100, (ViewGroup) r105);
    L12:
        return null;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.obric.oui.swipeaction.OSwipeActionLayout$dragHelperCallback$1] */
    public OSwipeActionLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403053a = 1;
        this.f403069q = true;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.oui_sal_autoMovingSensitivity, R.attr.oui_sal_continuousSwipe, R.attr.oui_sal_direction, R.attr.oui_sal_dragAfterOpened, R.attr.oui_sal_draggedItem, R.attr.oui_sal_freeDrag, R.attr.oui_sal_leftItem, R.attr.oui_sal_leftItem_bg, R.attr.oui_sal_leftItem_first_expand_width, R.attr.oui_sal_leftItem_full_open_pending, R.attr.oui_sal_leftViewPadding, R.attr.oui_sal_rightItem, R.attr.oui_sal_rightItem_bg, R.attr.oui_sal_rightItem_first_expand_width, R.attr.oui_sal_rightItem_full_open_pending, R.attr.oui_sal_rightViewPadding, R.attr.oui_sal_swipeEnabled});
        this.f403053a = 1;
        this.f403054b = r103.getBoolean(16, true);
        this.f403055c = r103.getBoolean(1, true);
        this.f403056d = r103.getInt(0, 1000);
        this.f403057e = r103.getBoolean(3, false);
        this.f403058f = r103.getBoolean(5, true);
        this.f403059g = r103.getResourceId(11, 0);
        this.f403060h = r103.getResourceId(12, 0);
        this.f403061i = (int) r103.getDimension(13, 0.0f);
        this.B = (int) r103.getDimension(14, 0.0f);
        this.f403062j = r103.getResourceId(6, 0);
        this.f403063k = r103.getResourceId(7, 0);
        this.f403064l = (int) r103.getDimension(8, 0.0f);
        this.E = (int) r103.getDimension(9, 0.0f);
        this.f403065m = r103.getResourceId(4, 0);
        setRightViewPadding((int) r103.getDimension(15, 0.0f));
        this.f403068p = (int) r103.getDimension(10, 0.0f);
        if (this.f403055c == false) goto L8;
        if (this.f403053a == 3) goto L8;
        this.f403057e = true;
    L8:
        if (this.f403053a != 3) goto L10;
        setRightViewPadding(0);
        this.f403068p = 0;
    L10:
        r103.recycle();
        this.F = new c(this);
        this.G = new OSwipeActionLayout$dragHelperCallback$1(this);
    }

    public static final int b(OSwipeActionLayout r100, int r101, int r102) {
        boolean r103 = r100.f403058f;
        if (r103 == false) goto L5;
    L8:
        if (r103 == false) goto L10;
    L13:
        boolean r104 = r100.f403057e;
        if (r104 == true) goto L17;
        if (r101 <= 0) goto L17;
        return RangesKt.coerceAtMost(r101, r100.getLViewWidth());
    L17:
        if (r104 == true) goto L20;
        if (r101 >= 0) goto L20;
        return RangesKt.coerceAtLeast(r101, -r100.getRViewWidth());
    L20:
        if (r101 >= 0) goto L23;
        return RangesKt.coerceAtLeast(r101, r100.f403068p - r100.f403074v);
    L23:
        return RangesKt.coerceAtMost(r101, r100.f403074v - r100.f403067o);
    L10:
        if (r100.f403076x == false) goto L13;
        if (r102 <= 0) goto L13;
        return RangesKt.coerceAtMost(r101, 0);
    L5:
        if (r100.f403075w == false) goto L8;
        if (r102 >= 0) goto L8;
        return RangesKt.coerceAtLeast(r101, 0);
    }

    public /* synthetic */ OSwipeActionLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        this.f403074v = r100;
        super.onSizeChanged(r100, r101, r102, r103);
    }
}
