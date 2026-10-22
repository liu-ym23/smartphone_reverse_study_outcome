package com.bytedance.ee.lark.infra.network.ref.entity;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ECONetworkSchema extends Enum<ECONetworkSchema> {
    public static final ECONetworkSchema HTTP = null;
    public static final ECONetworkSchema HTTPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECONetworkSchema[] f242807a = null;
    String schema;

    static {
        ECONetworkSchema r100 = new ECONetworkSchema("HTTP", 0, "http");
        HTTP = r100;
        ECONetworkSchema r101 = new ECONetworkSchema("HTTPS", 1, "https");
        HTTPS = r101;
        f242807a = new ECONetworkSchema[]{r100, r101};
    }

    public static ECONetworkSchema[] values() {
        return (ECONetworkSchema[]) f242807a.clone();
    }

    public String getSchema() {
        return this.schema;
    }

    public static ECONetworkSchema valueOf(String r100) {
        return (ECONetworkSchema) a.a(ECONetworkSchema.class, r100);
    }

    public ECONetworkSchema(String r100, int r101, String r102) {
        super(r100, r101);
        this.schema = r102;
    }
}
