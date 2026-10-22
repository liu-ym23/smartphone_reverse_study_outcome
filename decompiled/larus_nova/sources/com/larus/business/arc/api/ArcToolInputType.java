package com.larus.business.arc.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/business/arc/api/ArcToolInputType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "BOOLEAN", "INTEGER", "NUMBER", "OBJECT", "ARRAY", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcToolInputType extends Enum<ArcToolInputType> {

    @SerialName("array")
    public static final ArcToolInputType ARRAY = null;

    @SerialName("boolean")
    public static final ArcToolInputType BOOLEAN = null;
    public static final a Companion = null;

    @SerialName("integer")
    public static final ArcToolInputType INTEGER = null;

    @SerialName("number")
    public static final ArcToolInputType NUMBER = null;

    @SerialName("object")
    public static final ArcToolInputType OBJECT = null;

    @SerialName("string")
    public static final ArcToolInputType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f319868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArcToolInputType[] f319869b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319870c = null;

    public static EnumEntries<ArcToolInputType> getEntries() {
        return f319870c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.arc.api.ArcToolInputType$a] */
    static {
        ArcToolInputType r100 = new ArcToolInputType("STRING", 0);
        STRING = r100;
        ArcToolInputType r101 = new ArcToolInputType("BOOLEAN", 1);
        BOOLEAN = r101;
        ArcToolInputType r102 = new ArcToolInputType("INTEGER", 2);
        INTEGER = r102;
        ArcToolInputType r103 = new ArcToolInputType("NUMBER", 3);
        NUMBER = r103;
        ArcToolInputType r104 = new ArcToolInputType("OBJECT", 4);
        OBJECT = r104;
        ArcToolInputType r105 = new ArcToolInputType("ARRAY", 5);
        ARRAY = r105;
        ArcToolInputType[] r110 = {r100, r101, r102, r103, r104, r105};
        f319869b = r110;
        f319870c = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
        f319868a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new z());
    }

    public static ArcToolInputType[] values() {
        return (ArcToolInputType[]) f319869b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f319868a;
    }

    public static ArcToolInputType valueOf(String r100) {
        return (ArcToolInputType) r27.a.a(ArcToolInputType.class, r100);
    }

    public ArcToolInputType(String r100, int r101) {
        super(r100, r101);
    }
}
