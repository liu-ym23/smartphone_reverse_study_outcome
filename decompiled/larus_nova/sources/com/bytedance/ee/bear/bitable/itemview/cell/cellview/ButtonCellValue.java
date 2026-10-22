package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import com.bytedance.ee.bear.bitable.card.viewmodel.cell.BitableCardButtonLoadingStatus;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ButtonCellValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "activeBgColor", "getActiveBgColor", "setActiveBgColor", "currentBgColor", "getCurrentBgColor", "setCurrentBgColor", "currentTextColor", "getCurrentTextColor", "setCurrentTextColor", "hasBorder", "", "getHasBorder", "()Ljava/lang/Boolean;", "setHasBorder", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "status", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/BitableCardButtonLoadingStatus;", "getStatus", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/BitableCardButtonLoadingStatus;", "setStatus", "(Lcom/bytedance/ee/bear/bitable/card/viewmodel/cell/BitableCardButtonLoadingStatus;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonCellValue implements NonProguard {
    private String activeBgColor;
    private String currentBgColor;
    private String currentTextColor;
    private Boolean hasBorder;
    private BitableCardButtonLoadingStatus status;
    private String title;

    public ButtonCellValue() {
        this.activeBgColor = "";
        this.currentBgColor = "";
        this.currentTextColor = "";
        this.hasBorder = Boolean.FALSE;
    }

    public final String getActiveBgColor() {
        return this.activeBgColor;
    }

    public final String getCurrentBgColor() {
        return this.currentBgColor;
    }

    public final String getCurrentTextColor() {
        return this.currentTextColor;
    }

    public final Boolean getHasBorder() {
        return this.hasBorder;
    }

    public final BitableCardButtonLoadingStatus getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setActiveBgColor(String r100) {
        this.activeBgColor = r100;
    }

    public final void setCurrentBgColor(String r100) {
        this.currentBgColor = r100;
    }

    public final void setCurrentTextColor(String r100) {
        this.currentTextColor = r100;
    }

    public final void setHasBorder(Boolean r100) {
        this.hasBorder = r100;
    }

    public final void setStatus(BitableCardButtonLoadingStatus r100) {
        this.status = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
