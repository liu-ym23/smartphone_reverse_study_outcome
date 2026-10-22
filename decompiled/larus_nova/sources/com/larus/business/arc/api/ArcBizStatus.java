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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/business/arc/api/ArcBizStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "NOT_STARTED", "UNKNOWN", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum ArcBizStatus extends Enum<ArcBizStatus> {
    public static final a Companion = null;

    @SerialName("failed")
    public static final ArcBizStatus FAILED = null;

    @SerialName("not_started")
    public static final ArcBizStatus NOT_STARTED = null;

    @SerialName("success")
    public static final ArcBizStatus SUCCESS = null;

    @SerialName("unknown")
    public static final ArcBizStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<juc.d<Object>> f319835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ArcBizStatus[] f319836b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319837c = null;

    public static final class a {
        public a() {
        }

        public final juc.d<ArcBizStatus> serializer() {
            return (juc.d) ArcBizStatus.access$get$cachedSerializer$delegate$cp().getValue();
        }
    }

    public static EnumEntries<ArcBizStatus> getEntries() {
        return f319837c;
    }

    static {
        ArcBizStatus r100 = new ArcBizStatus("SUCCESS", 0);
        SUCCESS = r100;
        ArcBizStatus r101 = new ArcBizStatus("FAILED", 1);
        FAILED = r101;
        ArcBizStatus r102 = new ArcBizStatus("NOT_STARTED", 2);
        NOT_STARTED = r102;
        ArcBizStatus r103 = new ArcBizStatus("UNKNOWN", 3);
        UNKNOWN = r103;
        ArcBizStatus[] r104 = {r100, r101, r102, r103};
        f319836b = r104;
        f319837c = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
        f319835a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new f());
    }

    public static ArcBizStatus[] values() {
        return (ArcBizStatus[]) f319836b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f319835a;
    }

    public static ArcBizStatus valueOf(String r100) {
        return (ArcBizStatus) r27.a.a(ArcBizStatus.class, r100);
    }

    public ArcBizStatus(String r100, int r101) {
        super(r100, r101);
    }
}
