package com.bytedance.ee.bear.bitable.card.view.page;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0014J0\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"H\u0014J\u0010\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010/\u001a\u00020\fJ\u0012\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000102H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/PageCellContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTitleLayout", "Landroid/view/View;", "mContentLayout", "mIsInsideHotSpot", "", "openRecordTraceId", "", "getOpenRecordTraceId", "()Ljava/lang/String;", "setOpenRecordTraceId", "(Ljava/lang/String;)V", "fieldUiType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "getFieldUiType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "setFieldUiType", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "drawTimeMonitor", "Lcom/bytedance/ee/bear/bitable/statistic/common/layoutdraw/BitableListItemDrawTimeView;", "getDrawTimeMonitor", "()Lcom/bytedance/ee/bear/bitable/statistic/common/layoutdraw/BitableListItemDrawTimeView;", "drawTimeMonitor$delegate", "Lkotlin/Lazy;", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "draw", "canvas", "Landroid/graphics/Canvas;", "onViewAdded", "view", "isInsideHotSpot", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "checkIsInsideHotSpotInternal", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageCellContainerLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f208464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f208465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f208466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f208467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EFieldUIType f208468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f208469f;

    public static final class a {
    }

    static {
    }

    private final com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.c getDrawTimeMonitor() {
        return (com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.c) this.f208469f.getValue();
    }

    public final EFieldUIType getFieldUiType() {
        return this.f208468e;
    }

    public final String getOpenRecordTraceId() {
        return this.f208467d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        if (r110 == null) goto L31;
        boolean r100 = false;
        if (r110.getAction() != 0) goto L7;
        this.f208466c = false;
        goto L31
    L7:
        if (r110.getAction() != 1) goto L31;
        View r101 = this.f208464a;
        View r102 = this.f208465b;
        if (r101 == null) goto L29;
        if (r102 == null) goto L29;
        if (r101.getLeft() == r102.getLeft()) goto L15;
        int r103 = r101.getRight();
        int r104 = r102.getRight();
        int r105 = r102.getTop();
        int r106 = r102.getBottom();
    L16:
        StringBuilder r107 = new StringBuilder();
        r107.append(r103);
        r107.append(' ');
        r107.append(r105);
        r107.append(' ');
        r107.append(r104);
        r107.append(' ');
        r107.append(r106);
        tt5.a.b("PageCellLayout", r107.toString());
        int r108 = Float.valueOf(r110.getX()).intValue();
        int r109 = Float.valueOf(r110.getY()).intValue();
        if (r103 > r108) goto L20;
        if (r108 > r104) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L28;
        if (r105 > r109) goto L25;
        if (r109 > r106) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L28;
        r100 = true;
    L25:
        r112 = false;
    L28:
        this.f208466c = r100;
        tt5.a.h("PageCellLayout", "inside hotspot " + this.f208466c);
    L20:
        r111 = false;
        goto L21
    L15:
        r103 = getLeft();
        r104 = getRight();
        r105 = r102.getTop();
        r106 = r102.getBottom();
    L29:
        tt5.a.h("PageCellLayout", "layout null");
    L31:
        return super.dispatchTouchEvent(r110);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        long r101 = System.currentTimeMillis();
        super.draw(r100);
        getDrawTimeMonitor().a(r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View r100) {
        super.onViewAdded(r100);
        boolean r101 = true;
        if (this.f208464a != null) goto L12;
        if (r100 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L12;
        this.f208464a = r100;
        goto L12
    L6:
        if (r100.getId() != R.id.cell_title_container) goto L8;
        r102 = true;
    L12:
        if (this.f208465b != null) goto L21;
        if (r100 != null) goto L15;
    L17:
        r101 = false;
    L18:
        if (r101 == false) goto L22;
        this.f208465b = r100;
        return;
    L22:
        return;
    L15:
        if (r100.getId() != R.id.cell_content_container) goto L17;
    }

    public final void setFieldUiType(EFieldUIType r100) {
        this.f208468e = r100;
    }

    public final void setOpenRecordTraceId(String r100) {
        this.f208467d = r100;
    }

    public PageCellContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f208469f = LazyKt.lazy(new PageCellContainerLayout$drawTimeMonitor$2(this));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        long r102 = System.currentTimeMillis();
        super.onMeasure(r100, r101);
        com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.c r103 = getDrawTimeMonitor();
        int[] r104 = r103.f215636b;
        r104[0] = r104[0] + 1;
        int[] r105 = r103.f215637c;
        r105[0] = r105[0] + ((int) (System.currentTimeMillis() - r102));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        long r105 = System.currentTimeMillis();
        super.onLayout(r100, r101, r102, r103, r104);
        com.bytedance.ee.bear.bitable.statistic.common.layoutdraw.c r106 = getDrawTimeMonitor();
        int[] r107 = r106.f215636b;
        r107[1] = r107[1] + 1;
        int[] r108 = r106.f215637c;
        r108[1] = r108[1] + ((int) (System.currentTimeMillis() - r105));
    }
}
