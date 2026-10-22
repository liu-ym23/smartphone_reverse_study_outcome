package com.bytedance.ee.bear.bitable.celleditor.editor.date;

import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/date/DateEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "<init>", "()V", "dateFormat", "", "getDateFormat", "()Ljava/lang/String;", "setDateFormat", "(Ljava/lang/String;)V", "timeFormat", "getTimeFormat", "setTimeFormat", TimeZoneItemV2.TIME_ZONE, "getTimeZone", "setTimeZone", "fieldName", "getFieldName", "setFieldName", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DateEditorModel extends CommonEditorModel<Long> {
    private String dateFormat;
    private String fieldName;
    private String timeFormat;
    private String timeZone;

    public DateEditorModel() {
    }

    public final String getDateFormat() {
        return this.dateFormat;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final String getTimeFormat() {
        return this.timeFormat;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final void setDateFormat(String r100) {
        this.dateFormat = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setTimeFormat(String r100) {
        this.timeFormat = r100;
    }

    public final void setTimeZone(String r100) {
        this.timeZone = r100;
    }
}
