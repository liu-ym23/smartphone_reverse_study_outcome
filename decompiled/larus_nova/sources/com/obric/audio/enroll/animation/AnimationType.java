package com.obric.audio.enroll.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/audio/enroll/animation/AnimationType;", "", "<init>", "(Ljava/lang/String;I)V", "FADE_IN_TO_CANDIDATE", "FROM_CANDIDATE_TO_STAGE", "FROM_STAGE_TO_DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AnimationType extends Enum<AnimationType> {
    public static final AnimationType FADE_IN_TO_CANDIDATE = null;
    public static final AnimationType FROM_CANDIDATE_TO_STAGE = null;
    public static final AnimationType FROM_STAGE_TO_DONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationType[] f395427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f395428b = null;

    public static EnumEntries<AnimationType> getEntries() {
        return f395428b;
    }

    static {
        AnimationType r100 = new AnimationType("FADE_IN_TO_CANDIDATE", 0);
        FADE_IN_TO_CANDIDATE = r100;
        AnimationType r101 = new AnimationType("FROM_CANDIDATE_TO_STAGE", 1);
        FROM_CANDIDATE_TO_STAGE = r101;
        AnimationType r102 = new AnimationType("FROM_STAGE_TO_DONE", 2);
        FROM_STAGE_TO_DONE = r102;
        AnimationType[] r103 = {r100, r101, r102};
        f395427a = r103;
        f395428b = EnumEntriesKt.enumEntries(r103);
    }

    public static AnimationType[] values() {
        return (AnimationType[]) f395427a.clone();
    }

    public static AnimationType valueOf(String r100) {
        return (AnimationType) a.a(AnimationType.class, r100);
    }

    public AnimationType(String r100, int r101) {
        super(r100, r101);
    }
}
