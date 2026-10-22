package com.bytedance.ee.bear.bitable.celleditor.editor.barcode;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001d2\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/barcode/BarcodeEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "<init>", "()V", "isForm", "", "()Z", "setForm", "(Z)V", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "textEditable", "getTextEditable", "setTextEditable", "scanEnable", "getScanEnable", "setScanEnable", RemoteMessageConst.INPUT_TYPE, "", "getInputType", "()I", "setInputType", "(I)V", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BarcodeEditorModel extends CommonEditorModel<List<? extends SegmentModel>> {
    public static final a Companion = null;
    public static final int INPUT_TYPE_PANEL = 0;
    public static final int INPUT_TYPE_SCAN = 1;
    private String fieldName;
    private int inputType;
    private boolean isForm;
    private boolean scanEnable;
    private boolean textEditable;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BarcodeEditorModel() {
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final boolean getScanEnable() {
        return this.scanEnable;
    }

    public final boolean getTextEditable() {
        return this.textEditable;
    }

    public final boolean isForm() {
        return this.isForm;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setForm(boolean r100) {
        this.isForm = r100;
    }

    public final void setInputType(int r100) {
        this.inputType = r100;
    }

    public final void setScanEnable(boolean r100) {
        this.scanEnable = r100;
    }

    public final void setTextEditable(boolean r100) {
        this.textEditable = r100;
    }
}
