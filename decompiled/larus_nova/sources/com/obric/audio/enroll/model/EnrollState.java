package com.obric.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/audio/enroll/model/EnrollState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ENROLLING", "ENROLLED_SUCCESS", "ENROLLED_FAILED", "ENROLLED_INTERRUPT", "NEW_ENROLLING", "NEW_ENROLLED_SUCCESS", "NEW_ENROLLED_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnrollState extends Enum<EnrollState> {
    public static final EnrollState ENROLLED_FAILED = null;
    public static final EnrollState ENROLLED_INTERRUPT = null;
    public static final EnrollState ENROLLED_SUCCESS = null;
    public static final EnrollState ENROLLING = null;
    public static final EnrollState IDLE = null;
    public static final EnrollState NEW_ENROLLED_FAILED = null;
    public static final EnrollState NEW_ENROLLED_SUCCESS = null;
    public static final EnrollState NEW_ENROLLING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnrollState[] f395447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f395448b = null;

    public static EnumEntries<EnrollState> getEntries() {
        return f395448b;
    }

    static {
        EnrollState r100 = new EnrollState("IDLE", 0);
        IDLE = r100;
        EnrollState r101 = new EnrollState("ENROLLING", 1);
        ENROLLING = r101;
        EnrollState r102 = new EnrollState("ENROLLED_SUCCESS", 2);
        ENROLLED_SUCCESS = r102;
        EnrollState r103 = new EnrollState("ENROLLED_FAILED", 3);
        ENROLLED_FAILED = r103;
        EnrollState r104 = new EnrollState("ENROLLED_INTERRUPT", 4);
        ENROLLED_INTERRUPT = r104;
        EnrollState r105 = new EnrollState("NEW_ENROLLING", 5);
        NEW_ENROLLING = r105;
        EnrollState r110 = new EnrollState("NEW_ENROLLED_SUCCESS", 6);
        NEW_ENROLLED_SUCCESS = r110;
        EnrollState r111 = new EnrollState("NEW_ENROLLED_FAILED", 7);
        NEW_ENROLLED_FAILED = r111;
        EnrollState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f395447a = r112;
        f395448b = EnumEntriesKt.enumEntries(r112);
    }

    public static EnrollState[] values() {
        return (EnrollState[]) f395447a.clone();
    }

    public static EnrollState valueOf(String r100) {
        return (EnrollState) a.a(EnrollState.class, r100);
    }

    public EnrollState(String r100, int r101) {
        super(r100, r101);
    }
}
