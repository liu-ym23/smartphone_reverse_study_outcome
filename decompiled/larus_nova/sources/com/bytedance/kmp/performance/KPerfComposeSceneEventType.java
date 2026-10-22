package com.bytedance.kmp.performance;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/performance/KPerfComposeSceneEventType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "FIRST_FRAME", "REMOVE", "performance_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KPerfComposeSceneEventType extends Enum<KPerfComposeSceneEventType> {
    public static final KPerfComposeSceneEventType ADD = null;
    public static final KPerfComposeSceneEventType FIRST_FRAME = null;
    public static final KPerfComposeSceneEventType REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KPerfComposeSceneEventType[] f252573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252574b = null;

    public static EnumEntries<KPerfComposeSceneEventType> getEntries() {
        return f252574b;
    }

    static {
        KPerfComposeSceneEventType r100 = new KPerfComposeSceneEventType("ADD", 0);
        ADD = r100;
        KPerfComposeSceneEventType r101 = new KPerfComposeSceneEventType("FIRST_FRAME", 1);
        FIRST_FRAME = r101;
        KPerfComposeSceneEventType r102 = new KPerfComposeSceneEventType("REMOVE", 2);
        REMOVE = r102;
        KPerfComposeSceneEventType[] r103 = {r100, r101, r102};
        f252573a = r103;
        f252574b = EnumEntriesKt.enumEntries(r103);
    }

    public static KPerfComposeSceneEventType[] values() {
        return (KPerfComposeSceneEventType[]) f252573a.clone();
    }

    public static KPerfComposeSceneEventType valueOf(String r100) {
        return (KPerfComposeSceneEventType) r27.a.a(KPerfComposeSceneEventType.class, r100);
    }

    public KPerfComposeSceneEventType(String r100, int r101) {
        super(r100, r101);
    }
}
