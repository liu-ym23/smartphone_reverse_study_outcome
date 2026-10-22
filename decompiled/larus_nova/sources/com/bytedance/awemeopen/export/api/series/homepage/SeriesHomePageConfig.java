package com.bytedance.awemeopen.export.api.series.homepage;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b&\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/export/api/series/homepage/SeriesHomePageConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "aid", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "openId", "getOpenId", "setOpenId", "homepageSeries", "getHomepageSeries", "setHomepageSeries", "Lt54/a;", "homeSeriesConfig", "Lt54/a;", "getHomeSeriesConfig", "()Lt54/a;", "setHomeSeriesConfig", "(Lt54/a;)V", "", d.f25927q, "Z", "getShowBackButton", "()Z", "setShowBackButton", "(Z)V", "isSeriesTab", "setSeriesTab", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class SeriesHomePageConfig implements Parcelable {
    public static final a CREATOR = null;
    private String aid;
    private t54.a homeSeriesConfig;
    private String homepageSeries;
    private boolean isSeriesTab;
    private String openId;
    private boolean showBackButton;

    public static final class a implements Parcelable.Creator<SeriesHomePageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SeriesHomePageConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SeriesHomePageConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SeriesHomePageConfig[] newArray(int r100) {
            return new SeriesHomePageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final t54.a getHomeSeriesConfig() {
        return null;
    }

    public final void setHomeSeriesConfig(t54.a r100) {
    }

    public SeriesHomePageConfig() {
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getHomepageSeries() {
        return this.homepageSeries;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    public final boolean isSeriesTab() {
        return this.isSeriesTab;
    }

    public SeriesHomePageConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.aid = r100.readString();
        this.openId = r100.readString();
        this.homepageSeries = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.showBackButton = r102;
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.isSeriesTab = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setAid(String r100) {
        this.aid = r100;
    }

    public final void setHomepageSeries(String r100) {
        this.homepageSeries = r100;
    }

    public final void setOpenId(String r100) {
        this.openId = r100;
    }

    public final void setSeriesTab(boolean r100) {
        this.isSeriesTab = r100;
    }

    public final void setShowBackButton(boolean r100) {
        this.showBackButton = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.aid);
        r100.writeString(this.openId);
        r100.writeString(this.homepageSeries);
        r100.writeByte(this.showBackButton ? 1 : 0);
        r100.writeByte(this.isSeriesTab ? 1 : 0);
    }
}
