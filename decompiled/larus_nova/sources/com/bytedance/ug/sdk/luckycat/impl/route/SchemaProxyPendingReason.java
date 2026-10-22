package com.bytedance.ug.sdk.luckycat.impl.route;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/route/SchemaProxyPendingReason;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "SDK_INIT", "STATIC_SETTINGS_UPDATE", "UNKNOWN", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final enum SchemaProxyPendingReason extends Enum<SchemaProxyPendingReason> {
    public static final SchemaProxyPendingReason SDK_INIT = null;
    public static final SchemaProxyPendingReason STATIC_SETTINGS_UPDATE = null;
    public static final SchemaProxyPendingReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SchemaProxyPendingReason[] f271437a = null;
    private final String reason;

    static {
        SchemaProxyPendingReason r100 = new SchemaProxyPendingReason("SDK_INIT", 0, "sdk_init");
        SDK_INIT = r100;
        SchemaProxyPendingReason r101 = new SchemaProxyPendingReason("STATIC_SETTINGS_UPDATE", 1, "static_settings_update");
        STATIC_SETTINGS_UPDATE = r101;
        SchemaProxyPendingReason r102 = new SchemaProxyPendingReason("UNKNOWN", 2, "unknown");
        UNKNOWN = r102;
        f271437a = new SchemaProxyPendingReason[]{r100, r101, r102};
    }

    public static SchemaProxyPendingReason valueOf(String r100) {
        return (SchemaProxyPendingReason) r27.a.a(SchemaProxyPendingReason.class, r100);
    }

    public static SchemaProxyPendingReason[] values() {
        return (SchemaProxyPendingReason[]) f271437a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public SchemaProxyPendingReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}
