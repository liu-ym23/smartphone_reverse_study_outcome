package com.bytedance.ee.bear.bitable.celleditor.editor.text;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/text/TextEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "<init>", "()V", "selectAll", "", "getSelectAll", "()Ljava/lang/Boolean;", "setSelectAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "supportMention", "getSupportMention", "setSupportMention", "checkEmailFormat", "getCheckEmailFormat", "setCheckEmailFormat", "supportVoiceInput", "getSupportVoiceInput", "setSupportVoiceInput", "cursorPosition", "", "getCursorPosition", "()Ljava/lang/Integer;", "setCursorPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextEditorModel extends CommonEditorModel<List<? extends SegmentModel>> {
    private Boolean checkEmailFormat;
    private Integer cursorPosition;
    private String fieldName;
    private Boolean selectAll;
    private Boolean supportMention;
    private Boolean supportVoiceInput;

    public TextEditorModel() {
        Boolean r100 = Boolean.FALSE;
        this.selectAll = r100;
        this.supportMention = r100;
        this.checkEmailFormat = r100;
        this.supportVoiceInput = r100;
        this.cursorPosition = -1;
    }

    public final Boolean getCheckEmailFormat() {
        return this.checkEmailFormat;
    }

    public final Integer getCursorPosition() {
        return this.cursorPosition;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final Boolean getSelectAll() {
        return this.selectAll;
    }

    public final Boolean getSupportMention() {
        return this.supportMention;
    }

    public final Boolean getSupportVoiceInput() {
        return this.supportVoiceInput;
    }

    public final void setCheckEmailFormat(Boolean r100) {
        this.checkEmailFormat = r100;
    }

    public final void setCursorPosition(Integer r100) {
        this.cursorPosition = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setSelectAll(Boolean r100) {
        this.selectAll = r100;
    }

    public final void setSupportMention(Boolean r100) {
        this.supportMention = r100;
    }

    public final void setSupportVoiceInput(Boolean r100) {
        this.supportVoiceInput = r100;
    }
}
