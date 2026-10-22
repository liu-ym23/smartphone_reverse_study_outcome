package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/orchestrator/SceneRelation;", "", "<init>", "(Ljava/lang/String;I)V", "COEXIST", "INTERRUPT", "REJECT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SceneRelation extends Enum<SceneRelation> {
    public static final SceneRelation COEXIST = null;
    public static final SceneRelation INTERRUPT = null;
    public static final SceneRelation REJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneRelation[] f434212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434213b = null;

    public static EnumEntries<SceneRelation> getEntries() {
        return f434213b;
    }

    static {
        SceneRelation r100 = new SceneRelation("COEXIST", 0);
        COEXIST = r100;
        SceneRelation r101 = new SceneRelation("INTERRUPT", 1);
        INTERRUPT = r101;
        SceneRelation r102 = new SceneRelation("REJECT", 2);
        REJECT = r102;
        SceneRelation[] r103 = {r100, r101, r102};
        f434212a = r103;
        f434213b = EnumEntriesKt.enumEntries(r103);
    }

    public static SceneRelation[] values() {
        return (SceneRelation[]) f434212a.clone();
    }

    public static SceneRelation valueOf(String r100) {
        return (SceneRelation) r27.a.a(SceneRelation.class, r100);
    }

    public SceneRelation(String r100, int r101) {
        super(r100, r101);
    }
}
