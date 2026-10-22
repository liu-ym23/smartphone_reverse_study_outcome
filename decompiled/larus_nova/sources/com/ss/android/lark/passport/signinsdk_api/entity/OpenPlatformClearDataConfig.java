package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@AppConfig(key = "openplatform_clear_data")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/OpenPlatformClearDataConfig;", "", "appConfig", "", "", "Lcom/ss/android/lark/passport/signinsdk_api/entity/ClearDataModel;", "<init>", "(Ljava/util/Map;)V", "getAppConfig", "()Ljava/util/Map;", "setAppConfig", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformClearDataConfig {

    @SerializedName("appConfig")
    private Map<String, ClearDataModel> appConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformClearDataConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformClearDataConfig copy$default(OpenPlatformClearDataConfig r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.appConfig;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, ClearDataModel> component1() {
        return this.appConfig;
    }

    public final OpenPlatformClearDataConfig copy(Map<String, ClearDataModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "appConfig");
        return new OpenPlatformClearDataConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformClearDataConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.appConfig, ((OpenPlatformClearDataConfig) r100).appConfig) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.appConfig.hashCode();
    }

    public String toString() {
        return "OpenPlatformClearDataConfig(appConfig=" + this.appConfig + ')';
    }

    public final Map<String, ClearDataModel> getAppConfig() {
        return this.appConfig;
    }

    public OpenPlatformClearDataConfig(Map<String, ClearDataModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "appConfig");
        this.appConfig = r100;
    }

    public final void setAppConfig(Map<String, ClearDataModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appConfig = r100;
    }

    public /* synthetic */ OpenPlatformClearDataConfig(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        this(r100);
    }
}
