package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SAVE", "NOT_SAVE", "FORCE_SAVE", "FORCE_NOT_SAVE", "isSave", "", "isForce", "toNormalType", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAudioSaveType extends Enum<MmAudioSaveType> {
    public static final MmAudioSaveType FORCE_NOT_SAVE = null;
    public static final MmAudioSaveType FORCE_SAVE = null;
    public static final MmAudioSaveType NOT_SAVE = null;
    public static final MmAudioSaveType SAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAudioSaveType[] f434870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434871b = null;
    private final int value;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434872a = null;

        static {
            int[] r100 = new int[MmAudioSaveType.values().length];
            r100[MmAudioSaveType.FORCE_SAVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmAudioSaveType.FORCE_NOT_SAVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f434872a = r100;
        }
    }

    public static EnumEntries<MmAudioSaveType> getEntries() {
        return f434871b;
    }

    static {
        MmAudioSaveType r100 = new MmAudioSaveType("SAVE", 0, 0);
        SAVE = r100;
        MmAudioSaveType r101 = new MmAudioSaveType("NOT_SAVE", 1, 1);
        NOT_SAVE = r101;
        MmAudioSaveType r102 = new MmAudioSaveType("FORCE_SAVE", 2, 3);
        FORCE_SAVE = r102;
        MmAudioSaveType r103 = new MmAudioSaveType("FORCE_NOT_SAVE", 3, 4);
        FORCE_NOT_SAVE = r103;
        MmAudioSaveType[] r104 = {r100, r101, r102, r103};
        f434870a = r104;
        f434871b = EnumEntriesKt.enumEntries(r104);
    }

    public static MmAudioSaveType[] values() {
        return (MmAudioSaveType[]) f434870a.clone();
    }

    public final boolean isForce() {
        if (this != FORCE_SAVE) goto L5;
    L8:
        return true;
    L5:
        if (this == FORCE_NOT_SAVE) goto L8;
        return false;
    }

    public final boolean isSave() {
        if (this != SAVE) goto L5;
    L8:
        return true;
    L5:
        if (this == FORCE_SAVE) goto L8;
        return false;
    }

    public final MmAudioSaveType toNormalType() {
        int r100 = a.f434872a[ordinal()];
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return this;
    L11:
        return NOT_SAVE;
    L9:
        return SAVE;
    }

    public final int getValue() {
        return this.value;
    }

    public static MmAudioSaveType valueOf(String r100) {
        return (MmAudioSaveType) r27.a.a(MmAudioSaveType.class, r100);
    }

    public MmAudioSaveType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
