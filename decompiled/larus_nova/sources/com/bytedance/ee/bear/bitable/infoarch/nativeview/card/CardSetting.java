package com.bytedance.ee.bear.bitable.infoarch.nativeview.card;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewSetting;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/CardSetting;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewSetting;", "<init>", "()V", "columnCount", "", "getColumnCount", "()I", "setColumnCount", "(I)V", "padColumnCount", "getPadColumnCount", "setPadColumnCount", "fieldCount", "getFieldCount", "setFieldCount", "showCover", "", "getShowCover", "()Z", "setShowCover", "(Z)V", "showSubTitle", "getShowSubTitle", "setShowSubTitle", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardSetting extends BaseViewSetting {
    private int columnCount;
    private int fieldCount;
    private int padColumnCount;
    private boolean showCover;
    private boolean showSubTitle;

    public CardSetting() {
        this.columnCount = 2;
        this.padColumnCount = 5;
        this.fieldCount = 4;
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final int getFieldCount() {
        return this.fieldCount;
    }

    public final int getPadColumnCount() {
        return this.padColumnCount;
    }

    public final boolean getShowCover() {
        return this.showCover;
    }

    public final boolean getShowSubTitle() {
        return this.showSubTitle;
    }

    public final void setColumnCount(int r100) {
        this.columnCount = r100;
    }

    public final void setFieldCount(int r100) {
        this.fieldCount = r100;
    }

    public final void setPadColumnCount(int r100) {
        this.padColumnCount = r100;
    }

    public final void setShowCover(boolean r100) {
        this.showCover = r100;
    }

    public final void setShowSubTitle(boolean r100) {
        this.showSubTitle = r100;
    }
}
