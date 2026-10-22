package com.larus.settings.net;

import com.google.gson.annotations.SerializedName;
import com.larus.network.interceptor.config.TimeoutConfig;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001fBU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012,\b\u0002\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ-\u0010\u0016\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bHÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\\\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032,\b\u0002\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR:\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/settings/net/NetworkTimeoutConfig;", "", "enable", "", "domainTimeout", "Ljava/util/HashMap;", "", "Lcom/larus/network/interceptor/config/TimeoutConfig;", "Lkotlin/collections/HashMap;", "overrides", "", "Lcom/larus/settings/net/NetworkTimeoutConfig$OverrideRule;", "<init>", "(Ljava/lang/Boolean;Ljava/util/HashMap;Ljava/util/List;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDomainTimeout", "()Ljava/util/HashMap;", "getOverrides", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/util/HashMap;Ljava/util/List;)Lcom/larus/settings/net/NetworkTimeoutConfig;", "equals", "other", "hashCode", "", "toString", "OverrideRule", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkTimeoutConfig {

    @SerializedName("domain_timeout")
    private final HashMap<String, TimeoutConfig> domainTimeout;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("overrides")
    private final List<OverrideRule> overrides;

    /* JADX INFO: loaded from: classes31.dex */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/net/NetworkTimeoutConfig$OverrideRule;", "", "domain", "", "path", "timeout", "Lcom/larus/network/interceptor/config/TimeoutConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/network/interceptor/config/TimeoutConfig;)V", "getDomain", "()Ljava/lang/String;", "getPath", "getTimeout", "()Lcom/larus/network/interceptor/config/TimeoutConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OverrideRule {

        @SerializedName("domain")
        private final String domain;

        @SerializedName("path")
        private final String path;

        @SerializedName("timeout")
        private final TimeoutConfig timeout;

        public OverrideRule() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ OverrideRule copy$default(OverrideRule r100, String r101, String r102, TimeoutConfig r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.domain;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.path;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.timeout;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.domain;
        }

        public final String component2() {
            return this.path;
        }

        public final TimeoutConfig component3() {
            return this.timeout;
        }

        public final OverrideRule copy(String r100, String r101, TimeoutConfig r102) {
            return new OverrideRule(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof OverrideRule) == true) goto L8;
            return false;
        L8:
            OverrideRule r101 = (OverrideRule) r100;
            if (Intrinsics.areEqual(this.domain, r101.domain) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.path, r101.path) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.timeout, r101.timeout) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.domain;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.path;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            TimeoutConfig r107 = this.timeout;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "OverrideRule(domain=" + this.domain + ", path=" + this.path + ", timeout=" + this.timeout + ')';
        }

        public final String getDomain() {
            return this.domain;
        }

        public final String getPath() {
            return this.path;
        }

        public final TimeoutConfig getTimeout() {
            return this.timeout;
        }

        public OverrideRule(String r100, String r101, TimeoutConfig r102) {
            this.domain = r100;
            this.path = r101;
            this.timeout = r102;
        }

        public /* synthetic */ OverrideRule(String r100, String r101, TimeoutConfig r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    public NetworkTimeoutConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkTimeoutConfig copy$default(NetworkTimeoutConfig r100, Boolean r101, HashMap r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.domainTimeout;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.overrides;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final HashMap<String, TimeoutConfig> component2() {
        return this.domainTimeout;
    }

    public final List<OverrideRule> component3() {
        return this.overrides;
    }

    public final NetworkTimeoutConfig copy(Boolean r100, HashMap<String, TimeoutConfig> r101, List<OverrideRule> r102) {
        return new NetworkTimeoutConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetworkTimeoutConfig) == true) goto L8;
        return false;
    L8:
        NetworkTimeoutConfig r101 = (NetworkTimeoutConfig) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.domainTimeout, r101.domainTimeout) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.overrides, r101.overrides) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, TimeoutConfig> r104 = this.domainTimeout;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<OverrideRule> r107 = this.overrides;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkTimeoutConfig(enable=" + this.enable + ", domainTimeout=" + this.domainTimeout + ", overrides=" + this.overrides + ')';
    }

    public final HashMap<String, TimeoutConfig> getDomainTimeout() {
        return this.domainTimeout;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final List<OverrideRule> getOverrides() {
        return this.overrides;
    }

    public NetworkTimeoutConfig(Boolean r100, HashMap<String, TimeoutConfig> r101, List<OverrideRule> r102) {
        this.enable = r100;
        this.domainTimeout = r101;
        this.overrides = r102;
    }

    public /* synthetic */ NetworkTimeoutConfig(Boolean r100, HashMap r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new HashMap();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
