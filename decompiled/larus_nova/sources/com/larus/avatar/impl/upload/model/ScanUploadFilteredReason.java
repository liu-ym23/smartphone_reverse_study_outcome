package com.larus.avatar.impl.upload.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avatar/impl/upload/model/ScanUploadFilteredReason;", "", "<init>", "(Ljava/lang/String;I)V", "MULTI_FACE", "NO_FACE", "NOT_YOURSELF", "UN_SHARP", "BIG_COLOR_SCALE", "FACE_SHIELD", "YAW_FAIL", "PITCH_FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScanUploadFilteredReason extends Enum<ScanUploadFilteredReason> {
    public static final ScanUploadFilteredReason BIG_COLOR_SCALE = null;
    public static final ScanUploadFilteredReason FACE_SHIELD = null;
    public static final ScanUploadFilteredReason MULTI_FACE = null;
    public static final ScanUploadFilteredReason NOT_YOURSELF = null;
    public static final ScanUploadFilteredReason NO_FACE = null;
    public static final ScanUploadFilteredReason PITCH_FAIL = null;
    public static final ScanUploadFilteredReason UN_SHARP = null;
    public static final ScanUploadFilteredReason YAW_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScanUploadFilteredReason[] f291309a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291310b = null;

    public static EnumEntries<ScanUploadFilteredReason> getEntries() {
        return f291310b;
    }

    static {
        ScanUploadFilteredReason r100 = new ScanUploadFilteredReason("MULTI_FACE", 0);
        MULTI_FACE = r100;
        ScanUploadFilteredReason r101 = new ScanUploadFilteredReason("NO_FACE", 1);
        NO_FACE = r101;
        ScanUploadFilteredReason r102 = new ScanUploadFilteredReason("NOT_YOURSELF", 2);
        NOT_YOURSELF = r102;
        ScanUploadFilteredReason r103 = new ScanUploadFilteredReason("UN_SHARP", 3);
        UN_SHARP = r103;
        ScanUploadFilteredReason r104 = new ScanUploadFilteredReason("BIG_COLOR_SCALE", 4);
        BIG_COLOR_SCALE = r104;
        ScanUploadFilteredReason r105 = new ScanUploadFilteredReason("FACE_SHIELD", 5);
        FACE_SHIELD = r105;
        ScanUploadFilteredReason r110 = new ScanUploadFilteredReason("YAW_FAIL", 6);
        YAW_FAIL = r110;
        ScanUploadFilteredReason r111 = new ScanUploadFilteredReason("PITCH_FAIL", 7);
        PITCH_FAIL = r111;
        ScanUploadFilteredReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f291309a = r112;
        f291310b = EnumEntriesKt.enumEntries(r112);
    }

    public static ScanUploadFilteredReason[] values() {
        return (ScanUploadFilteredReason[]) f291309a.clone();
    }

    public static ScanUploadFilteredReason valueOf(String r100) {
        return (ScanUploadFilteredReason) a.a(ScanUploadFilteredReason.class, r100);
    }

    public ScanUploadFilteredReason(String r100, int r101) {
        super(r100, r101);
    }
}
