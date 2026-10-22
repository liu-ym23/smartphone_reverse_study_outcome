package com.bytedance.ee.bear.appsetting.host;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/appsetting/host/CcmHostExportConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "docxExportFormats", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDocxExportFormats", "()Ljava/util/ArrayList;", "setDocxExportFormats", "(Ljava/util/ArrayList;)V", "eventSource", "", "getEventSource", "()Ljava/lang/Integer;", "setEventSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "base-app-setting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmHostExportConfig implements NonProguard {

    @SerializedName("docx_export_formats")
    private ArrayList<String> docxExportFormats;

    @SerializedName("event_source")
    private Integer eventSource;

    public CcmHostExportConfig() {
    }

    public final ArrayList<String> getDocxExportFormats() {
        return this.docxExportFormats;
    }

    public final Integer getEventSource() {
        return this.eventSource;
    }

    public final void setDocxExportFormats(ArrayList<String> r100) {
        this.docxExportFormats = r100;
    }

    public final void setEventSource(Integer r100) {
        this.eventSource = r100;
    }
}
