package com.bytedance.ee.bear.bitable.itemview.cell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.itemview.record.biz.IRenderFontStyle;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010/\u001a\u00020\u000bJ\u0006\u00100\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellRenderItemData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "highLightType", "", "getHighLightType", "()I", "setHighLightType", "(I)V", "showRequired", "", "getShowRequired", "()Z", "setShowRequired", "(Z)V", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "showFieldName", "getShowFieldName", "setShowFieldName", "showFieldIcon", "getShowFieldIcon", "setShowFieldIcon", "layout", "getLayout", "setLayout", "showLeftDivider", "getShowLeftDivider", "setShowLeftDivider", "paddingHorizontal", "getPaddingHorizontal", "setPaddingHorizontal", "fontStyle", "Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "getFontStyle", "()Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;", "setFontStyle", "(Lcom/bytedance/ee/bear/bitable/itemview/record/biz/IRenderFontStyle;)V", "renderId", "getRenderId$annotations", "getRenderId", "setRenderId", "isHorizontalLayout", "isSecondsHighLight", "isEditHighLight", "isErrorHighLight", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewCellRenderItemData implements NonProguard {
    private String errorMsg;
    private IRenderFontStyle fontStyle;
    private int highLightType;
    private int layout;
    private int paddingHorizontal;
    private String renderId;
    private boolean showFieldIcon;
    private boolean showFieldName;
    private boolean showLeftDivider;
    private boolean showRequired;

    @ContextField
    public static /* synthetic */ void getRenderId$annotations() {
    }

    public final boolean isEditHighLight() {
        if (this.highLightType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isErrorHighLight() {
        return !TextUtils.isEmpty(this.errorMsg);
    }

    public final boolean isHorizontalLayout() {
        if (this.layout == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isSecondsHighLight() {
        if (this.highLightType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public ItemViewCellRenderItemData() {
        this.showFieldName = true;
        this.showFieldIcon = true;
        this.layout = 1;
        this.renderId = "";
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final IRenderFontStyle getFontStyle() {
        return this.fontStyle;
    }

    public final int getHighLightType() {
        return this.highLightType;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final String getRenderId() {
        return this.renderId;
    }

    public final boolean getShowFieldIcon() {
        return this.showFieldIcon;
    }

    public final boolean getShowFieldName() {
        return this.showFieldName;
    }

    public final boolean getShowLeftDivider() {
        return this.showLeftDivider;
    }

    public final boolean getShowRequired() {
        return this.showRequired;
    }

    public final void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public final void setFontStyle(IRenderFontStyle r100) {
        this.fontStyle = r100;
    }

    public final void setHighLightType(int r100) {
        this.highLightType = r100;
    }

    public final void setLayout(int r100) {
        this.layout = r100;
    }

    public final void setPaddingHorizontal(int r100) {
        this.paddingHorizontal = r100;
    }

    public final void setRenderId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderId = r100;
    }

    public final void setShowFieldIcon(boolean r100) {
        this.showFieldIcon = r100;
    }

    public final void setShowFieldName(boolean r100) {
        this.showFieldName = r100;
    }

    public final void setShowLeftDivider(boolean r100) {
        this.showLeftDivider = r100;
    }

    public final void setShowRequired(boolean r100) {
        this.showRequired = r100;
    }
}
