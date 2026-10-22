package com.ss.android.ugc.aweme.poi.rate;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/rate/PoiPopupConfig;", "", "", "configName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "sendEventName", "c", "receiveEventName", "b", "type", "getType", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiPopupConfig {

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("receive_event_name")
    private final String receiveEventName;

    @SerializedName("send_event_name")
    private final String sendEventName;

    @SerializedName("type")
    private final String type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiPopupConfig) == true) goto L8;
        return false;
    L8:
        PoiPopupConfig r101 = (PoiPopupConfig) r100;
        if (Intrinsics.areEqual(this.configName, r101.configName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sendEventName, r101.sendEventName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.receiveEventName, r101.receiveEventName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.configName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sendEventName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.receiveEventName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.type;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiPopupConfig(configName=" + this.configName + ", sendEventName=" + this.sendEventName + ", receiveEventName=" + this.receiveEventName + ", type=" + this.type + ')';
    }

    public PoiPopupConfig() {
        this.configName = null;
        this.sendEventName = null;
        this.receiveEventName = null;
        this.type = null;
    }

    public final String a() {
        return this.configName;
    }

    public final String b() {
        return this.receiveEventName;
    }

    public final String c() {
        return this.sendEventName;
    }

    public final String getType() {
        return this.type;
    }
}
