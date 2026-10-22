package com.bytedance.awemeopen.export.api.series.homepage;

import com.alipay.sdk.m.x.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfigBuilder;", "", "", "aid", "withAid", "openId", "withOpenId", "homepageSeries", "withHomeSeriesConfig", "", d.f25927q, "withShowBackButton", "Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "build", "Ljava/lang/String;", "Z", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class SeriesHomePageConfigBuilder {
    public static final String CONFIG_KEY = "SERIES_HOMEPAGE_CONFIG_CONFIG_KEY";
    public static final a Companion = null;
    private String aid;
    private String homepageSeries;
    private String openId;
    private boolean showBackButton;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final SeriesHomePageConfig build() {
        SeriesHomePageConfig r100 = new SeriesHomePageConfig();
        r100.setAid(this.aid);
        r100.setOpenId(this.openId);
        r100.setHomepageSeries(this.homepageSeries);
        r100.setShowBackButton(this.showBackButton);
        return r100;
    }

    public SeriesHomePageConfigBuilder() {
    }

    public final SeriesHomePageConfigBuilder withAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        this.aid = r100;
        return this;
    }

    public final SeriesHomePageConfigBuilder withHomeSeriesConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "homepageSeries");
        this.homepageSeries = r100;
        return this;
    }

    public final SeriesHomePageConfigBuilder withOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        this.openId = r100;
        return this;
    }

    public final SeriesHomePageConfigBuilder withShowBackButton(boolean r100) {
        this.showBackButton = r100;
        return this;
    }
}
