package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYNativeTaskConfig;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "service", "Lcom/bytedance/pitaya/api/bean/PTYNativeService;", "aid", "", "appVersion", "pluginVersion", "(Lcom/bytedance/pitaya/api/bean/PTYNativeService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAid", "()Ljava/lang/String;", "getAppVersion", "getPluginVersion", "getService", "()Lcom/bytedance/pitaya/api/bean/PTYNativeService;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYNativeTaskConfig implements ReflectionCall {
    private final String aid;
    private final String appVersion;
    private final String pluginVersion;
    private final PTYNativeService service;

    public static /* synthetic */ PTYNativeTaskConfig copy$default(PTYNativeTaskConfig r100, PTYNativeService r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.service;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.aid;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.appVersion;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.pluginVersion;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final PTYNativeService component1() {
        return this.service;
    }

    public final String component2() {
        return this.aid;
    }

    public final String component3() {
        return this.appVersion;
    }

    public final String component4() {
        return this.pluginVersion;
    }

    public final PTYNativeTaskConfig copy(PTYNativeService r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "aid");
        return new PTYNativeTaskConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYNativeTaskConfig) == true) goto L8;
        return false;
    L8:
        PTYNativeTaskConfig r101 = (PTYNativeTaskConfig) r100;
        if (this.service == r101.service) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.aid, r101.aid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appVersion, r101.appVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pluginVersion, r101.pluginVersion) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.service.hashCode() * 31) + this.aid.hashCode()) * 31;
        String r101 = this.appVersion;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.pluginVersion;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PTYNativeTaskConfig(service=" + this.service + ", aid=" + this.aid + ", appVersion=" + this.appVersion + ", pluginVersion=" + this.pluginVersion + ')';
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getPluginVersion() {
        return this.pluginVersion;
    }

    public final PTYNativeService getService() {
        return this.service;
    }

    public PTYNativeTaskConfig(PTYNativeService r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "aid");
        this.service = r100;
        this.aid = r101;
        this.appVersion = r102;
        this.pluginVersion = r103;
    }

    public /* synthetic */ PTYNativeTaskConfig(PTYNativeService r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
