package com.bytedance.ee.bear.bitable.uikit;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.RenderItem;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.PullDataAction;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX WARN: Multi-variable type inference failed */
    public ActionPayload() {
        Object[] r100 = 0 == true ? 1 : 0;
        super(null, r100, 3, 0 == true ? 1 : 0);
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

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setEditResult(Object r100) {
        this.editResult = r100;
    }

    public final void setEditType(String r100) {
        this.editType = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFold(Boolean r100) {
        this.isFold = r100;
    }

    public final void setList(ArrayList<RenderItem> r100) {
        this.list = r100;
    }

    public final void setNetworkError(Boolean r100) {
        this.networkError = r100;
    }

    public final void setPullDataActions(ArrayList<PullDataAction> r100) {
        this.pullDataActions = r100;
    }

    public final void setRecordId(String r100) {
        this.recordId = r100;
    }

    public final void setRecordList(ArrayList<String> r100) {
        this.recordList = r100;
    }

    public final void setRenderId(String r100) {
        this.renderId = r100;
    }

    public final void setStackIdentify(String r100) {
        this.stackIdentify = r100;
    }

    public final void setSubmitFailed(Boolean r100) {
        this.submitFailed = r100;
    }

    public final void setTeaParams(HashMap<String, String> r100) {
        this.teaParams = r100;
    }

    public final void setTeaScene(String r100) {
        this.teaScene = r100;
    }

    public final void setTransactionId(String r100) {
        this.transactionId = r100;
    }

    public final void setValue(Object r100) {
        this.value = r100;
    }
}
