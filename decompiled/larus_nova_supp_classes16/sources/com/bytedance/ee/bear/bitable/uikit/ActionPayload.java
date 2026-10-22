package com.bytedance.ee.bear.bitable.uikit;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.PullDataAction;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R.\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\"\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001e\u0010:\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b;\u0010'\"\u0004\b<\u0010)R\u001e\u0010=\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u001c\u0010@\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR:\u0010C\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010Dj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "Lcom/bytedance/ee/bear/bitable/uikit/Action;", "<init>", "()V", "stackIdentify", "", "getStackIdentify", "()Ljava/lang/String;", "setStackIdentify", "(Ljava/lang/String;)V", "recordId", "getRecordId", "setRecordId", "fieldId", "getFieldId", "setFieldId", "list", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/RenderItem;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "recordList", "getRecordList", "setRecordList", "pullDataActions", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/PullDataAction;", "getPullDataActions", "setPullDataActions", "content", "getContent", "setContent", "renderId", "getRenderId", "setRenderId", "isFold", "", "()Ljava/lang/Boolean;", "setFold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "transactionId", "getTransactionId", "setTransactionId", "editResult", "", "getEditResult", "()Ljava/lang/Object;", "setEditResult", "(Ljava/lang/Object;)V", "value", "getValue", "setValue", "editType", "getEditType", "setEditType", "networkError", "getNetworkError", "setNetworkError", "submitFailed", "getSubmitFailed", "setSubmitFailed", "teaScene", "getTeaScene", "setTeaScene", "teaParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getTeaParams", "()Ljava/util/HashMap;", "setTeaParams", "(Ljava/util/HashMap;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ActionPayload extends Action {
    private String content;
    private Object editResult;
    private String editType;
    private String fieldId;

    @JSONField(name = "isFold")
    private Boolean isFold;
    private ArrayList<RenderItem> list;
    private Boolean networkError;
    private ArrayList<PullDataAction> pullDataActions;
    private String recordId;
    private ArrayList<String> recordList;
    private String renderId;
    private String stackIdentify;
    private Boolean submitFailed;
    private HashMap<String, String> teaParams;
    private String teaScene;
    private String transactionId;
    private Object value;

    public ActionPayload() {
        super(null, null, 3, null);
    }

    public final String getContent() {
        return this.content;
    }

    public final Object getEditResult() {
        return this.editResult;
    }

    public final String getEditType() {
        return this.editType;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final ArrayList<RenderItem> getList() {
        return this.list;
    }

    public final Boolean getNetworkError() {
        return this.networkError;
    }

    public final ArrayList<PullDataAction> getPullDataActions() {
        return this.pullDataActions;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final ArrayList<String> getRecordList() {
        return this.recordList;
    }

    public final String getRenderId() {
        return this.renderId;
    }

    public final String getStackIdentify() {
        return this.stackIdentify;
    }

    public final Boolean getSubmitFailed() {
        return this.submitFailed;
    }

    public final HashMap<String, String> getTeaParams() {
        return this.teaParams;
    }

    public final String getTeaScene() {
        return this.teaScene;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final Object getValue() {
        return this.value;
    }

    public final Boolean isFold() {
        return this.isFold;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setEditResult(Object r1) {
        this.editResult = r1;
    }

    public final void setEditType(String r1) {
        this.editType = r1;
    }

    public final void setFieldId(String r1) {
        this.fieldId = r1;
    }

    public final void setFold(Boolean r1) {
        this.isFold = r1;
    }

    public final void setList(ArrayList<RenderItem> r1) {
        this.list = r1;
    }

    public final void setNetworkError(Boolean r1) {
        this.networkError = r1;
    }

    public final void setPullDataActions(ArrayList<PullDataAction> r1) {
        this.pullDataActions = r1;
    }

    public final void setRecordId(String r1) {
        this.recordId = r1;
    }

    public final void setRecordList(ArrayList<String> r1) {
        this.recordList = r1;
    }

    public final void setRenderId(String r1) {
        this.renderId = r1;
    }

    public final void setStackIdentify(String r1) {
        this.stackIdentify = r1;
    }

    public final void setSubmitFailed(Boolean r1) {
        this.submitFailed = r1;
    }

    public final void setTeaParams(HashMap<String, String> r1) {
        this.teaParams = r1;
    }

    public final void setTeaScene(String r1) {
        this.teaScene = r1;
    }

    public final void setTransactionId(String r1) {
        this.transactionId = r1;
    }

    public final void setValue(Object r1) {
        this.value = r1;
    }
}
