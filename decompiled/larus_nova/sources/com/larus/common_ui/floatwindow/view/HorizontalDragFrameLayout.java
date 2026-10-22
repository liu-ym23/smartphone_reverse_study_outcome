package com.larus.common_ui.floatwindow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000289B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u000203H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001c\u0010.\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'¨\u0006:"}, d2 = {"Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "isDragging", "", "allowDragGesture", "allowClickGesture", "isDragCancelledByVerticalMove", "lastDragEventTime", "", "lastDragVelocityX", "touchSlop", "onDragListener", "Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnHorizontalDragListener;", "getOnDragListener", "()Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnHorizontalDragListener;", "setOnDragListener", "(Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnHorizontalDragListener;)V", "onClickHotAreaListener", "Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnClickHotAreaListener;", "getOnClickHotAreaListener", "()Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnClickHotAreaListener;", "setOnClickHotAreaListener", "(Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnClickHotAreaListener;)V", "dragHotArea", "Lkotlin/ranges/IntRange;", "getDragHotArea", "()Lkotlin/ranges/IntRange;", "setDragHotArea", "(Lkotlin/ranges/IntRange;)V", "dragHotAreaX", "getDragHotAreaX", "setDragHotAreaX", "clickHotArea", "getClickHotArea", "setClickHotArea", "clickHotAreaX", "getClickHotAreaX", "setClickHotAreaX", "isInDragHotArea", "ev", "Landroid/view/MotionEvent;", "isInClickHotArea", "onInterceptTouchEvent", "onTouchEvent", "event", "OnHorizontalDragListener", "OnClickHotAreaListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalDragFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f327452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f327453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f327454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f327455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f327456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f327457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f327458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f327459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f327460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f327461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f327462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IntRange f327463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IntRange f327464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IntRange f327465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IntRange f327466o;

    public interface a {
        void a();
    }

    public interface b {
        void a(float r100);

        void c(float r100);
    }

    public HorizontalDragFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalDragFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final IntRange getClickHotArea() {
        return this.f327465n;
    }

    public final IntRange getClickHotAreaX() {
        return this.f327466o;
    }

    public final IntRange getDragHotArea() {
        return this.f327463l;
    }

    public final IntRange getDragHotAreaX() {
        return this.f327464m;
    }

    public final a getOnClickHotAreaListener() {
        return this.f327462k;
    }

    public final b getOnDragListener() {
        return this.f327461j;
    }

    public final boolean a(MotionEvent r100) {
        IntRange r101 = this.f327465n;
        if (r101 != null) goto L5;
        return false;
    L5:
        IntRange r102 = this.f327466o;
        int r103 = r101.getFirst();
        int r104 = r101.getLast();
        int r105 = (int) r100.getY();
        if (r103 > r105) goto L9;
        if (r105 > r104) goto L9;
        boolean r106 = true;
    L10:
        if (r102 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r106 == false) goto L20;
        if (r107 == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L12:
        if (r102.contains((int) r100.getX()) == true) goto L15;
        r107 = false;
    L9:
        r106 = false;
        goto L10
    }

    public final boolean b(MotionEvent r100) {
        IntRange r101 = this.f327463l;
        IntRange r102 = this.f327464m;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r103 == false) goto L19;
        if (r104 == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L11:
        if (r102.contains((int) r100.getX()) == true) goto L14;
        r104 = false;
        goto L15
    L5:
        if (r101.contains((int) r100.getY()) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L36;
        if (r101 != 1) goto L6;
    L35:
        this.f327455d = false;
        this.f327456e = false;
        this.f327454c = false;
        this.f327457f = false;
    L45:
        return super.onInterceptTouchEvent(r100);
    L6:
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L35;
    L11:
        if (this.f327455d == true) goto L15;
        if (this.f327456e == true) goto L15;
    L17:
        return super.onInterceptTouchEvent(r100);
    L15:
        if (this.f327457f == true) goto L17;
        float r102 = r100.getRawX() - this.f327452a;
        float r103 = r100.getRawY() - this.f327453b;
        float r104 = Math.abs(r102);
        float r105 = Math.abs(r103);
        boolean r106 = this.f327454c;
        if (r106 == false) goto L21;
    L26:
        if (r106 == true) goto L45;
        if (this.f327455d == false) goto L45;
        if (r104 <= this.f327460i) goto L45;
        if (r104 <= (r105 * 1.5f)) goto L45;
        this.f327454c = true;
        this.f327456e = false;
        return true;
    L21:
        if (r105 <= this.f327460i) goto L26;
        if (r105 <= r104) goto L26;
        this.f327457f = true;
        this.f327455d = false;
        this.f327456e = false;
        this.f327454c = false;
        return super.onInterceptTouchEvent(r100);
    L36:
        this.f327455d = b(r100);
        boolean r107 = a(r100);
        this.f327456e = r107;
        if (this.f327455d == true) goto L41;
        if (r107 == true) goto L41;
        this.f327454c = false;
        this.f327456e = false;
        this.f327457f = false;
        return super.onInterceptTouchEvent(r100);
    L41:
        this.f327452a = r100.getRawX();
        this.f327453b = r100.getRawY();
        this.f327454c = false;
        this.f327457f = false;
        this.f327458g = r100.getEventTime();
        this.f327459h = 0.0f;
        if (this.f327456e == false) goto L45;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = r110.getActionMasked();
        if (r100 != 0) goto L5;
        this.f327455d = b(r110);
        boolean r101 = a(r110);
        this.f327456e = r101;
        if (this.f327455d == true) goto L72;
        if (r101 == true) goto L72;
        this.f327454c = false;
        this.f327456e = false;
        this.f327457f = false;
        return super.onTouchEvent(r110);
    L72:
        this.f327452a = r110.getRawX();
        this.f327453b = r110.getRawY();
        this.f327454c = false;
        this.f327457f = false;
        this.f327458g = r110.getEventTime();
        this.f327459h = 0.0f;
        return true;
    L5:
        if (r100 == 1) goto L44;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L44;
        return super.onTouchEvent(r110);
    L13:
        if (this.f327455d == true) goto L17;
        if (this.f327456e == true) goto L17;
    L19:
        return super.onTouchEvent(r110);
    L17:
        if (this.f327457f == true) goto L19;
        float r102 = r110.getRawX() - this.f327452a;
        float r103 = r110.getRawY() - this.f327453b;
        float r104 = Math.abs(r102);
        float r105 = Math.abs(r103);
        boolean r106 = this.f327454c;
        if (r106 == false) goto L23;
    L28:
        if (r106 == true) goto L37;
        if (this.f327455d == false) goto L37;
        if (r104 <= this.f327460i) goto L37;
        if (r104 <= (r105 * 1.5f)) goto L37;
        this.f327454c = true;
        this.f327456e = false;
    L37:
        if (this.f327454c == false) goto L42;
        this.f327459h = (r102 / RangesKt.coerceAtLeast(r110.getEventTime() - this.f327458g, 1)) * 1000.0f;
        b r107 = this.f327461j;
        if (r107 == null) goto L41;
        r107.a(r102);
    L41:
        this.f327452a = r110.getRawX();
        this.f327453b = r110.getRawY();
        this.f327458g = r110.getEventTime();
    L42:
        return true;
    L23:
        if (r105 <= this.f327460i) goto L28;
        if (r105 <= r104) goto L28;
        this.f327457f = true;
        this.f327455d = false;
        this.f327456e = false;
        this.f327454c = false;
        return super.onTouchEvent(r110);
    L44:
        if (this.f327454c == false) goto L59;
        long r108 = RangesKt.coerceAtLeast(r110.getEventTime() - this.f327458g, 1);
        if (r110.getActionMasked() != 1) goto L54;
        float r111 = r110.getRawX() - this.f327452a;
        if (r111 != 0.0f) goto L50;
        boolean r109 = true;
    L51:
        if (r109 == false) goto L53;
        float r112 = this.f327459h;
    L55:
        b r113 = this.f327461j;
        if (r113 == null) goto L65;
        r113.c(r112);
    L65:
        this.f327454c = false;
        this.f327455d = false;
        this.f327456e = false;
        this.f327457f = false;
        this.f327458g = 0;
        this.f327459h = 0.0f;
        return true;
    L53:
        r112 = (r111 / r108) * 1000.0f;
        goto L55
    L50:
        r109 = false;
        goto L51
    L54:
        r112 = 0.0f;
        goto L55
    L59:
        if (this.f327456e == false) goto L65;
        if (this.f327457f == true) goto L65;
        a r114 = this.f327462k;
        if (r114 == null) goto L65;
        r114.a();
        goto L65
    }

    public final void setClickHotArea(IntRange r100) {
        this.f327465n = r100;
    }

    public final void setClickHotAreaX(IntRange r100) {
        this.f327466o = r100;
    }

    public final void setDragHotArea(IntRange r100) {
        this.f327463l = r100;
    }

    public final void setDragHotAreaX(IntRange r100) {
        this.f327464m = r100;
    }

    public final void setOnClickHotAreaListener(a r100) {
        this.f327462k = r100;
    }

    public final void setOnDragListener(b r100) {
        this.f327461j = r100;
    }

    public HorizontalDragFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f327460i = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ HorizontalDragFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
