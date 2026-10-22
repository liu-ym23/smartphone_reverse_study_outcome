package com.bytedance.ee.bear.document.forecast;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "docs_forecast_config")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/forecast/ForecastConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "maxRecordLength", "", "getMaxRecordLength", "()I", "setMaxRecordLength", "(I)V", "disableWebViewPreload", "getDisableWebViewPreload", "setDisableWebViewPreload", "disableTemplatePreload", "getDisableTemplatePreload", "setDisableTemplatePreload", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForecastConfig implements NonProguard {

    @JSONField(name = "disable_template_preload")
    private int disableTemplatePreload;

    @JSONField(name = "disable_webview_preload")
    private int disableWebViewPreload;

    @JSONField(name = "record_length")
    private int maxRecordLength;

    public ForecastConfig() {
    }

    public String toString() {
        return "ForecastConfig(maxRecordLength=" + this.maxRecordLength + ", disableWebViewPreload=" + this.disableWebViewPreload + ", disableTemplatePreload=" + this.disableTemplatePreload + ')';
    }

    public final int getDisableTemplatePreload() {
        return this.disableTemplatePreload;
    }

    public final int getDisableWebViewPreload() {
        return this.disableWebViewPreload;
    }

    public final int getMaxRecordLength() {
        return this.maxRecordLength;
    }

    public final void setDisableTemplatePreload(int r100) {
        this.disableTemplatePreload = r100;
    }

    public final void setDisableWebViewPreload(int r100) {
        this.disableWebViewPreload = r100;
    }

    public final void setMaxRecordLength(int r100) {
        this.maxRecordLength = r100;
    }
}
