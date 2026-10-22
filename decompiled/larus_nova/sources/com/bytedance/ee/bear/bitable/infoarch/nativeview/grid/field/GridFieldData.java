package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field;

import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.TextModel;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010I\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001a\u0010*\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\u001a\u0010-\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "fieldId", "getFieldId", "setFieldId", "fieldTag", "", "getFieldTag", "()I", "setFieldTag", "(I)V", "showFieldDesc", "", "getShowFieldDesc", "()Z", "setShowFieldDesc", "(Z)V", "showFieldWaring", "getShowFieldWaring", "setShowFieldWaring", "showFieldLoading", "getShowFieldLoading", "setShowFieldLoading", "showMarginLeft", "getShowMarginLeft", "setShowMarginLeft", "clickAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "isAddCol", "setAddCol", "layoutStart", "getLayoutStart", "setLayoutStart", "fieldWidth", "getFieldWidth", "setFieldWidth", "highlightColorV2", "Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;", "getHighlightColorV2", "()Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;", "setHighlightColorV2", "(Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;)V", "isBold", "()Ljava/lang/Boolean;", "setBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fieldNameEx", "Lcom/bytedance/ee/bear/bitable/panel/TextModel;", "getFieldNameEx", "()Lcom/bytedance/ee/bear/bitable/panel/TextModel;", "setFieldNameEx", "(Lcom/bytedance/ee/bear/bitable/panel/TextModel;)V", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "isLoading", "setLoading", "showTag", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridFieldData implements NonProguard {
    private ActionPayload clickAction;
    private String fieldId;
    private String fieldName;
    private TextModel fieldNameEx;
    private int fieldTag;
    private int fieldWidth;
    private HighlightModel highlightColorV2;
    private Icon icon;
    private boolean isAddCol;
    private Boolean isBold;
    private boolean isLoading;
    private boolean layoutStart;
    private boolean showFieldDesc;
    private boolean showFieldLoading;
    private boolean showFieldWaring;
    private boolean showMarginLeft;

    public final boolean showTag() {
        if (this.fieldTag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public GridFieldData() {
        this.fieldName = "";
        this.fieldId = "";
        this.isBold = Boolean.FALSE;
    }

    public final ActionPayload getClickAction() {
        return this.clickAction;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final TextModel getFieldNameEx() {
        return this.fieldNameEx;
    }

    public final int getFieldTag() {
        return this.fieldTag;
    }

    public final int getFieldWidth() {
        return this.fieldWidth;
    }

    public final HighlightModel getHighlightColorV2() {
        return this.highlightColorV2;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final boolean getLayoutStart() {
        return this.layoutStart;
    }

    public final boolean getShowFieldDesc() {
        return this.showFieldDesc;
    }

    public final boolean getShowFieldLoading() {
        return this.showFieldLoading;
    }

    public final boolean getShowFieldWaring() {
        return this.showFieldWaring;
    }

    public final boolean getShowMarginLeft() {
        return this.showMarginLeft;
    }

    public final boolean isAddCol() {
        return this.isAddCol;
    }

    public final Boolean isBold() {
        return this.isBold;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setAddCol(boolean r100) {
        this.isAddCol = r100;
    }

    public final void setBold(Boolean r100) {
        this.isBold = r100;
    }

    public final void setClickAction(ActionPayload r100) {
        this.clickAction = r100;
    }

    public final void setFieldId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldId = r100;
    }

    public final void setFieldName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldName = r100;
    }

    public final void setFieldNameEx(TextModel r100) {
        this.fieldNameEx = r100;
    }

    public final void setFieldTag(int r100) {
        this.fieldTag = r100;
    }

    public final void setFieldWidth(int r100) {
        this.fieldWidth = r100;
    }

    public final void setHighlightColorV2(HighlightModel r100) {
        this.highlightColorV2 = r100;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setLayoutStart(boolean r100) {
        this.layoutStart = r100;
    }

    public final void setLoading(boolean r100) {
        this.isLoading = r100;
    }

    public final void setShowFieldDesc(boolean r100) {
        this.showFieldDesc = r100;
    }

    public final void setShowFieldLoading(boolean r100) {
        this.showFieldLoading = r100;
    }

    public final void setShowFieldWaring(boolean r100) {
        this.showFieldWaring = r100;
    }

    public final void setShowMarginLeft(boolean r100) {
        this.showMarginLeft = r100;
    }
}
