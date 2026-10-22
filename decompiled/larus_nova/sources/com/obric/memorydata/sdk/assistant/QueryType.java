package com.obric.memorydata.sdk.assistant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/QueryType;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "AUDIO", "IM", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum QueryType extends Enum<QueryType> {
    public static final QueryType AUDIO = null;
    public static final a Companion = null;
    public static final QueryType IM = null;
    public static final QueryType NA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QueryType[] f397079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397080b = null;

    public static EnumEntries<QueryType> getEntries() {
        return f397080b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.assistant.QueryType$a] */
    static {
        QueryType r100 = new QueryType("NA", 0);
        NA = r100;
        QueryType r101 = new QueryType("AUDIO", 1);
        AUDIO = r101;
        QueryType r102 = new QueryType("IM", 2);
        IM = r102;
        QueryType[] r103 = {r100, r101, r102};
        f397079a = r103;
        f397080b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static QueryType[] values() {
        return (QueryType[]) f397079a.clone();
    }

    public static QueryType valueOf(String r100) {
        return (QueryType) r27.a.a(QueryType.class, r100);
    }

    public QueryType(String r100, int r101) {
        super(r100, r101);
    }
}
