package com.bytedance.ee.bear.bitable.itemview.cell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.itemview.cell.other.EmptyCellData;
import com.bytedance.ee.bear.bitable.itemview.record.list.CellPureUIType;
import com.bytedance.ee.bear.bitable.itemview.util.ReportEvent;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010U\u001a\u00020\u001aJ\u0006\u0010V\u001a\u00020\u001aJ\u0006\u0010W\u001a\u00020\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u001e\u0010!\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010'\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001c\u00103\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001c\u00106\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001c\u00109\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001b\"\u0004\bJ\u0010\u001dR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\t¨\u0006X"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/ItemViewRecordCellData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "originalFieldUIType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "getOriginalFieldUIType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "setOriginalFieldUIType", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "pureUIType", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;", "getPureUIType", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;", "setPureUIType", "(Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;)V", "isSync", "", "()Z", "setSync", "(Z)V", "fieldWarning", "getFieldWarning", "setFieldWarning", "showAITag", "getShowAITag", "()Ljava/lang/Boolean;", "setShowAITag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showFieldLoading", "getShowFieldLoading", "setShowFieldLoading", "clickDescAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getClickDescAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setClickDescAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "clickAction", "getClickAction", "setClickAction", "clearAction", "getClearAction", "setClearAction", "setValueAction", "getSetValueAction", "setSetValueAction", "clickLinkAction", "getClickLinkAction", "setClickLinkAction", "cellValue", "", "getCellValue", "()Ljava/lang/Object;", "setCellValue", "(Ljava/lang/Object;)V", "emptyData", "Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellData;", "getEmptyData", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellData;", "setEmptyData", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellData;)V", "editable", "getEditable", "setEditable", "cellViewEvent", "Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;", "getCellViewEvent", "()Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;", "setCellViewEvent", "(Lcom/bytedance/ee/bear/bitable/itemview/util/ReportEvent;)V", "recordId", "getRecordId$annotations", "getRecordId", "setRecordId", "showDescIcon", "showWarningIcon", "supportEditScroll", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordCellData implements NonProguard {
    private Object cellValue;
    private ReportEvent cellViewEvent;
    private ActionPayload clearAction;
    private ActionPayload clickAction;
    private ActionPayload clickDescAction;
    private ActionPayload clickLinkAction;
    private boolean editable;
    private EmptyCellData emptyData;
    private String fieldWarning;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f213790id;
    private boolean isSync;
    private String name;
    private EFieldUIType originalFieldUIType;
    private CellPureUIType pureUIType;
    private String recordId;
    private ActionPayload setValueAction;
    private Boolean showAITag;
    private Boolean showFieldLoading;

    @ContextField
    public static /* synthetic */ void getRecordId$annotations() {
    }

    public final boolean supportEditScroll() {
        return SetsKt.setOf(new EFieldUIType[]{EFieldUIType.TEXT, EFieldUIType.EMAIL, EFieldUIType.NUMBER, EFieldUIType.CURRENCY}).contains(this.originalFieldUIType);
    }

    public final boolean showDescIcon() {
        if (this.clickDescAction == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean showWarningIcon() {
        return !TextUtils.isEmpty(this.fieldWarning);
    }

    public ItemViewRecordCellData() {
        this.f213790id = "";
        this.name = "";
        this.originalFieldUIType = EFieldUIType.NOT_SUPPORT;
        this.pureUIType = CellPureUIType.NotSupport;
        Boolean r100 = Boolean.FALSE;
        this.showAITag = r100;
        this.showFieldLoading = r100;
        this.recordId = "";
    }

    public final Object getCellValue() {
        return this.cellValue;
    }

    public final ReportEvent getCellViewEvent() {
        return this.cellViewEvent;
    }

    public final ActionPayload getClearAction() {
        return this.clearAction;
    }

    public final ActionPayload getClickAction() {
        return this.clickAction;
    }

    public final ActionPayload getClickDescAction() {
        return this.clickDescAction;
    }

    public final ActionPayload getClickLinkAction() {
        return this.clickLinkAction;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final EmptyCellData getEmptyData() {
        return this.emptyData;
    }

    public final String getFieldWarning() {
        return this.fieldWarning;
    }

    public final String getId() {
        return this.f213790id;
    }

    public final String getName() {
        return this.name;
    }

    public final EFieldUIType getOriginalFieldUIType() {
        return this.originalFieldUIType;
    }

    public final CellPureUIType getPureUIType() {
        return this.pureUIType;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final ActionPayload getSetValueAction() {
        return this.setValueAction;
    }

    public final Boolean getShowAITag() {
        return this.showAITag;
    }

    public final Boolean getShowFieldLoading() {
        return this.showFieldLoading;
    }

    public final boolean isSync() {
        return this.isSync;
    }

    public final void setCellValue(Object r100) {
        this.cellValue = r100;
    }

    public final void setCellViewEvent(ReportEvent r100) {
        this.cellViewEvent = r100;
    }

    public final void setClearAction(ActionPayload r100) {
        this.clearAction = r100;
    }

    public final void setClickAction(ActionPayload r100) {
        this.clickAction = r100;
    }

    public final void setClickDescAction(ActionPayload r100) {
        this.clickDescAction = r100;
    }

    public final void setClickLinkAction(ActionPayload r100) {
        this.clickLinkAction = r100;
    }

    public final void setEditable(boolean r100) {
        this.editable = r100;
    }

    public final void setEmptyData(EmptyCellData r100) {
        this.emptyData = r100;
    }

    public final void setFieldWarning(String r100) {
        this.fieldWarning = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213790id = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setOriginalFieldUIType(EFieldUIType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originalFieldUIType = r100;
    }

    public final void setPureUIType(CellPureUIType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pureUIType = r100;
    }

    public final void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordId = r100;
    }

    public final void setSetValueAction(ActionPayload r100) {
        this.setValueAction = r100;
    }

    public final void setShowAITag(Boolean r100) {
        this.showAITag = r100;
    }

    public final void setShowFieldLoading(Boolean r100) {
        this.showFieldLoading = r100;
    }

    public final void setSync(boolean r100) {
        this.isSync = r100;
    }
}
