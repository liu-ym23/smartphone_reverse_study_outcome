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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/business/arc/api/ArcRegion;", "", "<init>", "(Ljava/lang/String;I)V", "MAINLAND", "OVERSEA", "UNKNOWN", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcRegion extends Enum<ArcRegion> {
    public static final a Companion = null;

    @SerialName("mainland")
    public static final ArcRegion MAINLAND = null;

    @SerialName("oversea")
    public static final ArcRegion OVERSEA = null;

    @SerialName("unknown")
    public static final ArcRegion UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f319862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArcRegion[] f319863b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319864c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcRegion> serializer() {
            return (juc.d) ArcRegion.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcRegion> getEntries() {
        return f319864c;
    }

    static {
        ArcRegion r100 = new ArcRegion("MAINLAND", 0);
        MAINLAND = r100;
        ArcRegion r101 = new ArcRegion("OVERSEA", 1);
        OVERSEA = r101;
        ArcRegion r102 = new ArcRegion("UNKNOWN", 2);
        UNKNOWN = r102;
        ArcRegion[] r103 = {r100, r101, r102};
        f319863b = r103;
        f319864c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        f319862a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r());
    }

    public static ArcRegion[] values() {
        return (ArcRegion[]) f319863b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f319862a;
    }

    public static ArcRegion valueOf(String r100) {
        return (ArcRegion) r27.a.a(ArcRegion.class, r100);
    }

    public ArcRegion(String r100, int r101) {
        super(r100, r101);
    }
}
