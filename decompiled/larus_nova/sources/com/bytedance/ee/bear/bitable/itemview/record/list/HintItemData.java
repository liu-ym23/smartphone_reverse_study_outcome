package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.ee.bear.bitable.itemview.record.biz.IRenderFontStyle;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HintItemData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "hint", "", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "hintStyle", "Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "getHintStyle", "()Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "setHintStyle", "(Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;)V", "paddingVertical", "", "getPaddingVertical", "()I", "setPaddingVertical", "(I)V", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HintItemData implements NonProguard {
    private String hint;
    private IRenderFontStyle hintStyle;
    private int paddingHorizontal;
    private int paddingVertical;

    public HintItemData() {
    }

    public final String getHint() {
        return this.hint;
    }

    public final IRenderFontStyle getHintStyle() {
        return this.hintStyle;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    public final void setHint(String r100) {
        this.hint = r100;
    }

    public final void setHintStyle(IRenderFontStyle r100) {
        this.hintStyle = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setPaddingVertical(int r100) {
        this.paddingVertical = r100;
    }
}
