package com.bytedance.ug.sdk.luckydog.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/model/SchemaAckType;", "", "ACK_TIME", "ACK_COUNT", "UNKNOWN", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum SchemaAckType extends Enum<SchemaAckType> {
    public static final SchemaAckType ACK_COUNT = null;
    public static final SchemaAckType ACK_TIME = null;
    public static final SchemaAckType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SchemaAckType[] f271591a = null;

    static {
        SchemaAckType r100 = new SchemaAckType("ACK_TIME", 0);
        ACK_TIME = r100;
        SchemaAckType r101 = new SchemaAckType("ACK_COUNT", 1);
        ACK_COUNT = r101;
        SchemaAckType r102 = new SchemaAckType("UNKNOWN", 2);
        UNKNOWN = r102;
        f271591a = new SchemaAckType[]{r100, r101, r102};
    }

    public static SchemaAckType valueOf(String r100) {
        return (SchemaAckType) a.a(SchemaAckType.class, r100);
    }

    public static SchemaAckType[] values() {
        return (SchemaAckType[]) f271591a.clone();
    }

    public SchemaAckType(String r100, int r101) {
        super(r100, r101);
    }
}
