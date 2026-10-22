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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/business/arc/api/ArcStage;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARE", "EXECUTE", "FINALIZE", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcStage extends Enum<ArcStage> {
    public static final a Companion = null;

    @SerialName("execute")
    public static final ArcStage EXECUTE = null;

    @SerialName("finalize")
    public static final ArcStage FINALIZE = null;

    @SerialName("prepare")
    public static final ArcStage PREPARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f319865a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArcStage[] f319866b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319867c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcStage> serializer() {
            return (juc.d) ArcStage.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcStage> getEntries() {
        return f319867c;
    }

    static {
        ArcStage r100 = new ArcStage("PREPARE", 0);
        PREPARE = r100;
        ArcStage r101 = new ArcStage("EXECUTE", 1);
        EXECUTE = r101;
        ArcStage r102 = new ArcStage("FINALIZE", 2);
        FINALIZE = r102;
        ArcStage[] r103 = {r100, r101, r102};
        f319866b = r103;
        f319867c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        f319865a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new w());
    }

    public static ArcStage[] values() {
        return (ArcStage[]) f319866b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f319865a;
    }

    public static ArcStage valueOf(String r100) {
        return (ArcStage) r27.a.a(ArcStage.class, r100);
    }

    public ArcStage(String r100, int r101) {
        super(r100, r101);
    }
}
