package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0013HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0004¨\u0006#"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYProxySetting;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "provideAppLog", "", "(Z)V", "applogProxyEnabled", "getApplogProxyEnabled", "()Z", "setApplogProxyEnabled", "customApplogEvents", "", "getCustomApplogEvents", "()Ljava/lang/String;", "setCustomApplogEvents", "(Ljava/lang/String;)V", "featureStoreProxyEnabled", "getFeatureStoreProxyEnabled", "setFeatureStoreProxyEnabled", "maxApplogEventCacheNum", "", "getMaxApplogEventCacheNum", "()I", "setMaxApplogEventCacheNum", "(I)V", "getProvideAppLog", "useCustomApplogEvents", "getUseCustomApplogEvents", "setUseCustomApplogEvents", "component1", "copy", "equals", "other", "", "hashCode", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYProxySetting implements ReflectionCall {
    private boolean applogProxyEnabled;
    private String customApplogEvents;
    private boolean featureStoreProxyEnabled;
    private int maxApplogEventCacheNum;
    private final boolean provideAppLog;
    private boolean useCustomApplogEvents;

    public static /* synthetic */ PTYProxySetting copy$default(PTYProxySetting r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.provideAppLog;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.provideAppLog;
    }

    public final PTYProxySetting copy(boolean r100) {
        return new PTYProxySetting(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYProxySetting) == true) goto L9;
        return false;
    L9:
        if (this.provideAppLog == ((PTYProxySetting) r100).provideAppLog) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        boolean r100 = this.provideAppLog;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public String toString() {
        return "PTYProxySetting(provideAppLog=" + this.provideAppLog + ')';
    }

    public final boolean getApplogProxyEnabled() {
        return this.applogProxyEnabled;
    }

    public final String getCustomApplogEvents() {
        return this.customApplogEvents;
    }

    public final boolean getFeatureStoreProxyEnabled() {
        return this.featureStoreProxyEnabled;
    }

    public final int getMaxApplogEventCacheNum() {
        return this.maxApplogEventCacheNum;
    }

    public final boolean getProvideAppLog() {
        return this.provideAppLog;
    }

    public final boolean getUseCustomApplogEvents() {
        return this.useCustomApplogEvents;
    }

    public PTYProxySetting(boolean r100) {
        this.provideAppLog = r100;
        this.customApplogEvents = "";
        this.maxApplogEventCacheNum = 100;
    }

    public final void setApplogProxyEnabled(boolean r100) {
        this.applogProxyEnabled = r100;
    }

    public final void setCustomApplogEvents(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customApplogEvents = r100;
    }

    public final void setFeatureStoreProxyEnabled(boolean r100) {
        this.featureStoreProxyEnabled = r100;
    }

    public final void setMaxApplogEventCacheNum(int r100) {
        this.maxApplogEventCacheNum = r100;
    }

    public final void setUseCustomApplogEvents(boolean r100) {
        this.useCustomApplogEvents = r100;
    }
}
