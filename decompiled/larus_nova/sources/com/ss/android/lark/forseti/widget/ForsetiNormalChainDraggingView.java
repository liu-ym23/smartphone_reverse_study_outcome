package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u000212B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0014J\u000e\u0010&\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010'\u001a\u00020\"2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020\"H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "outerRectangle", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper$Region;", "innerRectangle", "status", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;", "getStatus", "()Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;", "setStatus", "(Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;)V", "draggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "getDraggingHelper", "()Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "setDraggingHelper", "(Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;)V", "isDraggingSupport", "", "()Z", "setDraggingSupport", "(Z)V", "isKeyboardVisible", "animationYOffset", "", "setKeyboardStateListener", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateDraggingStatus", "setForsetiColumnsDraggingHelper", "drawRectanglesInDraggingUnderFull", "drawRectanglesUnderFull", "drawRectangles", "drawFullScreenLine", "drawHalfScreenLines", "animateButtonPosition", "fromOffset", "toOffset", "onDetachedFromWindow", "DraggingStatus", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiNormalChainDraggingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ForsetiColumnsDraggingHelper.b f424648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DraggingStatus f424649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ForsetiColumnsDraggingHelper f424650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f424651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f424652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f424653f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DRAGGING_UNDER_FULL", "UN_DRAGGING_UNDER_FULL", "UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DraggingStatus extends Enum<DraggingStatus> {
        public static final DraggingStatus DRAGGING_UNDER_FULL = null;
        public static final DraggingStatus UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL = null;
        public static final DraggingStatus UN_DRAGGING_UNDER_FULL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DraggingStatus[] f424654a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f424655b = null;

        public static EnumEntries<DraggingStatus> getEntries() {
            return f424655b;
        }

        static {
            DraggingStatus r100 = new DraggingStatus("DRAGGING_UNDER_FULL", 0);
            DRAGGING_UNDER_FULL = r100;
            DraggingStatus r101 = new DraggingStatus("UN_DRAGGING_UNDER_FULL", 1);
            UN_DRAGGING_UNDER_FULL = r101;
            DraggingStatus r102 = new DraggingStatus("UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL", 2);
            UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL = r102;
            DraggingStatus[] r103 = {r100, r101, r102};
            f424654a = r103;
            f424655b = EnumEntriesKt.enumEntries(r103);
        }

        public static DraggingStatus[] values() {
            return (DraggingStatus[]) f424654a.clone();
        }

        public static DraggingStatus valueOf(String r100) {
            return (DraggingStatus) r27.a.a(DraggingStatus.class, r100);
        }

        public DraggingStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f424656a = null;

        static {
            int[] r100 = new int[DraggingStatus.values().length];
            r100[DraggingStatus.DRAGGING_UNDER_FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DraggingStatus.UN_DRAGGING_UNDER_FULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DraggingStatus.UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f424656a = r100;
        }
    }

    static {
    }

    public ForsetiNormalChainDraggingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ForsetiNormalChainDraggingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public final ForsetiColumnsDraggingHelper getDraggingHelper() {
        return this.f424650c;
    }

    public final DraggingStatus getStatus() {
        return this.f424649b;
    }

    public final void a(Canvas r100) {
        ForsetiColumnsDraggingHelper r101 = this.f424650c;
        float r102 = (r101.f424599s - r101.B.getStrokeWidth()) / 2.0f;
        r100.drawLine(r102, 0.0f, r102, getMeasuredHeight(), this.f424650c.D);
    }

    public final void b(Canvas r110) {
        ForsetiColumnsDraggingHelper r100 = this.f424650c;
        ForsetiColumnsDraggingHelper.b r101 = null;
        if (ForsetiColumnsDraggingHelper.h(r100.f424606z) == false) goto L5;
        ForsetiColumnsDraggingHelper.b r102 = null;
    L6:
        if (r102 == null) goto L8;
        float r103 = r102.f424607a;
        float r104 = r102.f424608b;
        float r105 = this.f424653f;
        float r111 = r104 - r105;
        float r112 = r102.f424609c;
        float r113 = r102.f424610d - r105;
        ForsetiColumnsDraggingHelper r106 = this.f424650c;
        float r114 = r106.f424594n;
        r110.drawRoundRect(r103, r111, r112, r113, r114, r114, r106.B);
    L9:
        this.f424648a = r102;
        ForsetiColumnsDraggingHelper r107 = this.f424650c;
        if (ForsetiColumnsDraggingHelper.h(r107.f424606z) == true) goto L13;
        int r108 = r107.f424599s;
        int r109 = r107.f424597q;
        float r115 = (r108 - r109) / 2.0f;
        float r116 = r107.f424606z;
        float r117 = r107.f424596p;
        float r118 = (r116 - r117) / 2.0f;
        r101 = new ForsetiColumnsDraggingHelper.b(r115, r118, r109 + r115, r117 + r118);
    L13:
        if (r101 == null) goto L16;
        float r119 = r101.f424607a;
        float r120 = r101.f424608b;
        float r121 = this.f424653f;
        float r122 = r120 - r121;
        float r123 = r101.f424609c;
        float r124 = r101.f424610d - r121;
        ForsetiColumnsDraggingHelper r125 = this.f424650c;
        float r126 = r125.f424598r;
        r110.drawRoundRect(r119, r122, r123, r124, r126, r126, r125.E);
        return;
    L16:
        return;
    L8:
        r102 = null;
        goto L9
    L5:
        int r127 = r100.f424599s;
        int r128 = r100.f424593m;
        float r129 = (r127 - r128) / 2.0f;
        float r130 = r100.f424606z;
        float r131 = r100.f424592l;
        float r132 = (r130 - r131) / 2.0f;
        r102 = new ForsetiColumnsDraggingHelper.b(r129, r132, r128 + r129, r131 + r132);
        goto L6
    }

    public final void c(Canvas r110) {
        ForsetiColumnsDraggingHelper r100 = this.f424650c;
        ForsetiColumnsDraggingHelper.b r101 = null;
        if (ForsetiColumnsDraggingHelper.h(r100.f424606z) == false) goto L5;
        ForsetiColumnsDraggingHelper.b r102 = null;
    L6:
        this.f424648a = r102;
        Path r103 = new Path();
        ForsetiColumnsDraggingHelper r104 = this.f424650c;
        float r105 = r104.f424594n;
        Paint r106 = r104.C;
        ForsetiColumnsDraggingHelper.b r107 = this.f424648a;
        if (r107 == null) goto L9;
        float r108 = r107.f424607a;
    L10:
        if (r107 == null) goto L12;
        float r109 = r107.f424608b;
    L13:
        float r111 = this.f424653f;
        float r112 = r109 - r111;
        if (r107 == null) goto L16;
        float r113 = r107.f424609c;
    L17:
        if (r107 == null) goto L19;
        float r114 = r107.f424610d;
    L20:
        float r115 = r114 - r111;
        r103.reset();
        r103.moveTo(r108, r112);
        r103.lineTo(r113 - r105, r112);
        float r116 = 2 * r105;
        float r117 = r113 - r116;
        r103.arcTo(new RectF(r117, r112, r113, r112 + r116), -90.0f, 90.0f);
        r103.lineTo(r113, r115 - r105);
        r103.arcTo(new RectF(r117, r115 - r116, r113, r115), 0.0f, 90.0f);
        r103.lineTo(r108, r115);
        r103.close();
        r110.drawPath(r103, r106);
        ForsetiColumnsDraggingHelper r118 = this.f424650c;
        if (ForsetiColumnsDraggingHelper.h(r118.f424606z) == true) goto L24;
        float r119 = ((r118.f424595o - r118.f424597q) / 2.0f) + ((r118.f424599s - r118.B.getStrokeWidth()) / 2.0f);
        float r120 = r118.f424597q + r119;
        float r121 = r118.f424606z;
        float r122 = r118.f424596p;
        float r123 = (r121 - r122) / 2.0f;
        r101 = new ForsetiColumnsDraggingHelper.b(r119, r123, r120, r122 + r123);
    L24:
        if (r101 == null) goto L27;
        float r124 = r101.f424607a;
        float r125 = r101.f424608b;
        float r126 = this.f424653f;
        float r127 = r125 - r126;
        float r128 = r101.f424609c;
        float r129 = r101.f424610d - r126;
        ForsetiColumnsDraggingHelper r130 = this.f424650c;
        float r131 = r130.f424598r;
        r110.drawRoundRect(r124, r127, r128, r129, r131, r131, r130.E);
        return;
    L27:
        return;
    L19:
        r114 = 0.0f;
        goto L20
    L16:
        r113 = 0.0f;
        goto L17
    L12:
        r109 = 0.0f;
        goto L13
    L9:
        r108 = 0.0f;
        goto L10
    L5:
        float r132 = (r100.f424599s - r100.B.getStrokeWidth()) / 2.0f;
        float r133 = r100.f424595o + r132;
        float r134 = r100.f424606z;
        float r135 = r100.f424592l;
        float r136 = (r134 - r135) / 2.0f;
        r102 = new ForsetiColumnsDraggingHelper.b(r132, r136, r133, r135 + r136);
        goto L6
    }

    public final void d(Canvas r110) {
        ForsetiColumnsDraggingHelper r100 = this.f424650c;
        ForsetiColumnsDraggingHelper.b r101 = null;
        if (ForsetiColumnsDraggingHelper.h(r100.f424606z) == false) goto L5;
        ForsetiColumnsDraggingHelper.b r102 = null;
    L6:
        this.f424648a = r102;
        Path r103 = new Path();
        ForsetiColumnsDraggingHelper r104 = this.f424650c;
        float r105 = r104.f424594n;
        if (r104.e() == true) goto L9;
        Paint r106 = this.f424650c.F;
    L11:
        if (this.f424650c.e() == true) goto L13;
        Paint r107 = this.f424650c.G;
    L14:
        Paint r111 = r107;
        ForsetiColumnsDraggingHelper.b r108 = this.f424648a;
        if (r108 == null) goto L17;
        float r109 = r108.f424607a;
    L18:
        if (r108 == null) goto L20;
        float r112 = r108.f424608b;
    L21:
        float r113 = this.f424653f;
        float r114 = r112 - r113;
        if (r108 == null) goto L24;
        float r115 = r108.f424609c;
    L25:
        if (r108 == null) goto L27;
        float r116 = r108.f424610d;
    L28:
        float r117 = r116 - r113;
        r103.reset();
        r103.moveTo(r109, r114);
        r103.lineTo(r115 - r105, r114);
        float r118 = 2 * r105;
        float r119 = r115 - r118;
        r103.arcTo(new RectF(r119, r114, r115, r114 + r118), -90.0f, 90.0f);
        r103.lineTo(r115, r117 - r105);
        r103.arcTo(new RectF(r119, r117 - r118, r115, r117), 0.0f, 90.0f);
        r103.lineTo(r109, r117);
        r103.close();
        r110.drawPath(r103, r106);
        ForsetiColumnsDraggingHelper r120 = this.f424650c;
        if (ForsetiColumnsDraggingHelper.h(r120.f424606z) == true) goto L32;
        float r121 = ((r120.f424593m - r120.f424597q) / 2.0f) + ((r120.f424599s - r120.B.getStrokeWidth()) / 2.0f);
        float r122 = r120.f424597q + r121;
        float r123 = r120.f424606z;
        float r124 = r120.f424596p;
        float r125 = (r123 - r124) / 2.0f;
        r101 = new ForsetiColumnsDraggingHelper.b(r121, r125, r122, r124 + r125);
    L32:
        if (r101 == null) goto L35;
        float r126 = r101.f424607a;
        float r127 = r101.f424608b;
        float r128 = this.f424653f;
        float r129 = r101.f424609c;
        float r130 = r101.f424610d - r128;
        float r131 = this.f424650c.f424598r;
        r110.drawRoundRect(r126, r127 - r128, r129, r130, r131, r131, r111);
        return;
    L35:
        return;
    L27:
        r116 = 0.0f;
        goto L28
    L24:
        r115 = 0.0f;
        goto L25
    L20:
        r112 = 0.0f;
        goto L21
    L17:
        r109 = 0.0f;
        goto L18
    L13:
        r107 = this.f424650c.E;
        goto L14
    L9:
        r106 = this.f424650c.C;
        goto L11
    L5:
        float r132 = (r100.f424599s - r100.B.getStrokeWidth()) / 2.0f;
        float r133 = r100.f424593m + r132;
        float r134 = r100.f424606z;
        float r135 = r100.f424592l;
        float r136 = (r134 - r135) / 2.0f;
        r102 = new ForsetiColumnsDraggingHelper.b(r132, r136, r133, r135 + r136);
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f424650c.f() == true) goto L19;
        a(r100);
        if (this.f424651d == true) goto L8;
        Log.i("ForsetiNormalChainDraggingView", "current not support dragging, stops to draw button.");
        return;
    L8:
        int r101 = b.f424656a[this.f424649b.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L14;
        b(r100);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        d(r100);
        return;
    L16:
        c(r100);
        return;
    L19:
        if (this.f424651d == true) goto L22;
        Log.i("ForsetiNormalChainDraggingView", "current not support dragging, stops to draw button.");
        a(r100);
        return;
    L22:
        int r102 = b.f424656a[this.f424649b.ordinal()];
        if (r102 == 1) goto L30;
        if (r102 == 2) goto L29;
        if (r102 != 3) goto L28;
        b(r100);
        ForsetiColumnsDraggingHelper r103 = this.f424650c;
        float r104 = (r103.f424599s - r103.B.getStrokeWidth()) / 2.0f;
        float r105 = getMeasuredHeight();
        ForsetiColumnsDraggingHelper r106 = this.f424650c;
        float r107 = (r105 - r106.f424592l) / 2.0f;
        r100.drawLine(r104, 0.0f, r104, r107, r106.D);
        r100.drawLine(r104, r107 + this.f424650c.f424592l, r104, getMeasuredHeight(), this.f424650c.D);
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        d(r100);
        a(r100);
        return;
    L30:
        c(r100);
        a(r100);
    }

    public final void setDraggingHelper(ForsetiColumnsDraggingHelper r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f424650c = r100;
    }

    public final void setDraggingSupport(boolean r100) {
        this.f424651d = r100;
    }

    public final void setForsetiColumnsDraggingHelper(ForsetiColumnsDraggingHelper r100) {
        if (r100 == null) goto L5;
        this.f424650c = r100;
        return;
    }

    public final void setStatus(DraggingStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f424649b = r100;
    }

    public ForsetiNormalChainDraggingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f424649b = DraggingStatus.UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL;
        this.f424650c = new ForsetiColumnsDraggingHelper(r100);
        setWillNotDraw(false);
        if (this.f424650c.f() == false) goto L5;
        Log.i("ForsetiNormalChainDraggingView", "setKeyboardStateListener: optimizeDraggingViewUnderKeyboardDisabled");
        return;
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new c(this));
    }

    public /* synthetic */ ForsetiNormalChainDraggingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
