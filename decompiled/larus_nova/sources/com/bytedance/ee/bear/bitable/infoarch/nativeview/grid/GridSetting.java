package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewSetting;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00104\u001a\u00020)J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u00020#H\u0002J\u000e\u00107\u001a\u00020#2\u0006\u00106\u001a\u00020#J\u000e\u00108\u001a\u00020#2\u0006\u00106\u001a\u00020#J\u000e\u00109\u001a\u00020#2\u0006\u00106\u001a\u00020#J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u00106\u001a\u00020#H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u00106\u001a\u00020#H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001a\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\t¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSetting;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewSetting;", "<init>", "()V", "showAddCol", "", "getShowAddCol", "()Z", "setShowAddCol", "(Z)V", "colWidth", "", "getColWidth", "()[F", "setColWidth", "([F)V", "maxFixedRatio", "", "getMaxFixedRatio", "()F", "setMaxFixedRatio", "(F)V", "defaultFixedRatio", "getDefaultFixedRatio", "setDefaultFixedRatio", "minFixedRatio", "getMinFixedRatio", "setMinFixedRatio", "wideScreenDefaultFixedRatio", "getWideScreenDefaultFixedRatio", "setWideScreenDefaultFixedRatio", "wideScreenMinFixedRatio", "getWideScreenMinFixedRatio", "setWideScreenMinFixedRatio", "wideScreenThreshold", "", "getWideScreenThreshold", "()I", "setWideScreenThreshold", "(I)V", "forceColWidth", "", "getForceColWidth", "()[I", "setForceColWidth", "([I)V", "calculateViewWidth", "getCalculateViewWidth", "setCalculateViewWidth", "showNoMarginDivider", "getShowNoMarginDivider", "setShowNoMarginDivider", "getColWidthInDp", "getViewWidth", "viewWidth", "getMinFixedWidth", "getMaxFixedWidth", "getInitScrollX", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridSetting extends BaseViewSetting {
    private boolean calculateViewWidth;
    private float[] colWidth;
    private float defaultFixedRatio;
    private int[] forceColWidth;
    private float maxFixedRatio;
    private float minFixedRatio;
    private boolean showAddCol;
    private boolean showNoMarginDivider;
    private float wideScreenDefaultFixedRatio;
    private float wideScreenMinFixedRatio;
    private int wideScreenThreshold;

    public final int[] getColWidthInDp() {
        int r100 = this.colWidth.length;
        int[] r101 = new int[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = n.c(this.colWidth[r102]);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public GridSetting() {
        this.colWidth = new float[0];
        this.maxFixedRatio = 0.95f;
        this.defaultFixedRatio = 0.7f;
        this.minFixedRatio = 0.35f;
        this.wideScreenDefaultFixedRatio = 0.35f;
        this.wideScreenMinFixedRatio = 0.25f;
        this.wideScreenThreshold = n.d(600);
    }

    public final boolean getCalculateViewWidth() {
        return this.calculateViewWidth;
    }

    public final float[] getColWidth() {
        return this.colWidth;
    }

    public final float getDefaultFixedRatio() {
        return this.defaultFixedRatio;
    }

    public final int[] getForceColWidth() {
        return this.forceColWidth;
    }

    public final float getMaxFixedRatio() {
        return this.maxFixedRatio;
    }

    public final float getMinFixedRatio() {
        return this.minFixedRatio;
    }

    public final boolean getShowAddCol() {
        return this.showAddCol;
    }

    public final boolean getShowNoMarginDivider() {
        return this.showNoMarginDivider;
    }

    public final float getWideScreenDefaultFixedRatio() {
        return this.wideScreenDefaultFixedRatio;
    }

    public final float getWideScreenMinFixedRatio() {
        return this.wideScreenMinFixedRatio;
    }

    public final int getWideScreenThreshold() {
        return this.wideScreenThreshold;
    }

    private final float defaultFixedRatio(int r100) {
        if (getViewWidth(r100) <= this.wideScreenThreshold) goto L6;
        return this.wideScreenDefaultFixedRatio;
    L6:
        return this.defaultFixedRatio;
    }

    private final int getViewWidth(int r100) {
        if (this.calculateViewWidth == false) goto L7;
        if (r100 <= 0) goto L7;
        return r100;
    L7:
        return n.v();
    }

    private final float minFixedRatio(int r100) {
        if (getViewWidth(r100) <= this.wideScreenThreshold) goto L6;
        return this.wideScreenMinFixedRatio;
    L6:
        return this.minFixedRatio;
    }

    public final int getInitScrollX(int r100) {
        if (this.forceColWidth == null) goto L6;
        return 0;
    L6:
        return (int) ((this.maxFixedRatio - defaultFixedRatio(r100)) * getViewWidth(r100));
    }

    public final int getMaxFixedWidth(int r100) {
        return (int) (this.maxFixedRatio * getViewWidth(r100));
    }

    public final int getMinFixedWidth(int r100) {
        return (int) (minFixedRatio(r100) * getViewWidth(r100));
    }

    public final void setCalculateViewWidth(boolean r100) {
        this.calculateViewWidth = r100;
    }

    public final void setColWidth(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.colWidth = r100;
    }

    public final void setDefaultFixedRatio(float r100) {
        this.defaultFixedRatio = r100;
    }

    public final void setForceColWidth(int[] r100) {
        this.forceColWidth = r100;
    }

    public final void setMaxFixedRatio(float r100) {
        this.maxFixedRatio = r100;
    }

    public final void setMinFixedRatio(float r100) {
        this.minFixedRatio = r100;
    }

    public final void setShowAddCol(boolean r100) {
        this.showAddCol = r100;
    }

    public final void setShowNoMarginDivider(boolean r100) {
        this.showNoMarginDivider = r100;
    }

    public final void setWideScreenDefaultFixedRatio(float r100) {
        this.wideScreenDefaultFixedRatio = r100;
    }

    public final void setWideScreenMinFixedRatio(float r100) {
        this.wideScreenMinFixedRatio = r100;
    }

    public final void setWideScreenThreshold(int r100) {
        this.wideScreenThreshold = r100;
    }
}
