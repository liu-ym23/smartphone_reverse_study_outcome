package com.bytedance.awemeopen.export.api.pageconfig.series;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/series/SeriesPageConfigBuilder;", "", "", "seriesId", "withSeriesId", "", "currentIndex", "withCurrentIndex", "defaultLockIndex", "withDefaultLockIndex", "", "enterMethod", "withEnterMethod", "", "showBackBtn", "withShowBackBtn", "Lcom/bytedance/awemeopen/export/api/pageconfig/series/SeriesPageConfig;", "build", "Ljava/lang/String;", "J", "I", "Z", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class SeriesPageConfigBuilder {
    public static final a Companion = null;
    private int currentIndex;
    private int defaultLockIndex;
    private String enterMethod;
    private long seriesId;
    private boolean showBackBtn;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final SeriesPageConfig build() {
        SeriesPageConfig r100 = new SeriesPageConfig();
        r100.setEnterMethod(this.enterMethod);
        r100.setSeriesId(this.seriesId);
        r100.setCurrentIndex(this.currentIndex);
        r100.setShowBackButton(this.showBackBtn);
        r100.setDefaultLockIndex(this.defaultLockIndex);
        return r100;
    }

    public SeriesPageConfigBuilder() {
        this.showBackBtn = true;
    }

    public final SeriesPageConfigBuilder withCurrentIndex(int r100) {
        this.currentIndex = r100;
        return this;
    }

    public final SeriesPageConfigBuilder withDefaultLockIndex(int r100) {
        this.defaultLockIndex = r100;
        return this;
    }

    public final SeriesPageConfigBuilder withEnterMethod(String r100) {
        this.enterMethod = r100;
        return this;
    }

    public final SeriesPageConfigBuilder withSeriesId(long r100) {
        this.seriesId = r100;
        return this;
    }

    public final SeriesPageConfigBuilder withShowBackBtn(boolean r100) {
        this.showBackBtn = r100;
        return this;
    }
}
