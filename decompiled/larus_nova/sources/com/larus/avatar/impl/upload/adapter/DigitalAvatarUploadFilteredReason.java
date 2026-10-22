package com.larus.avatar.impl.upload.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avatar/impl/upload/adapter/DigitalAvatarUploadFilteredReason;", "", "<init>", "(Ljava/lang/String;I)V", "MULTI_FACE", "NO_FACE", "NOT_YOURSELF", "UN_SHARP", "BIG_COLOR_SCALE", "FACE_SHIELD", "YAW_FAIL", "PITCH_FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DigitalAvatarUploadFilteredReason extends Enum<DigitalAvatarUploadFilteredReason> {
    public static final DigitalAvatarUploadFilteredReason BIG_COLOR_SCALE = null;
    public static final DigitalAvatarUploadFilteredReason FACE_SHIELD = null;
    public static final DigitalAvatarUploadFilteredReason MULTI_FACE = null;
    public static final DigitalAvatarUploadFilteredReason NOT_YOURSELF = null;
    public static final DigitalAvatarUploadFilteredReason NO_FACE = null;
    public static final DigitalAvatarUploadFilteredReason PITCH_FAIL = null;
    public static final DigitalAvatarUploadFilteredReason UN_SHARP = null;
    public static final DigitalAvatarUploadFilteredReason YAW_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitalAvatarUploadFilteredReason[] f291283a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291284b = null;

    public static EnumEntries<DigitalAvatarUploadFilteredReason> getEntries() {
        return f291284b;
    }

    static {
        DigitalAvatarUploadFilteredReason r100 = new DigitalAvatarUploadFilteredReason("MULTI_FACE", 0);
        MULTI_FACE = r100;
        DigitalAvatarUploadFilteredReason r101 = new DigitalAvatarUploadFilteredReason("NO_FACE", 1);
        NO_FACE = r101;
        DigitalAvatarUploadFilteredReason r102 = new DigitalAvatarUploadFilteredReason("NOT_YOURSELF", 2);
        NOT_YOURSELF = r102;
        DigitalAvatarUploadFilteredReason r103 = new DigitalAvatarUploadFilteredReason("UN_SHARP", 3);
        UN_SHARP = r103;
        DigitalAvatarUploadFilteredReason r104 = new DigitalAvatarUploadFilteredReason("BIG_COLOR_SCALE", 4);
        BIG_COLOR_SCALE = r104;
        DigitalAvatarUploadFilteredReason r105 = new DigitalAvatarUploadFilteredReason("FACE_SHIELD", 5);
        FACE_SHIELD = r105;
        DigitalAvatarUploadFilteredReason r110 = new DigitalAvatarUploadFilteredReason("YAW_FAIL", 6);
        YAW_FAIL = r110;
        DigitalAvatarUploadFilteredReason r111 = new DigitalAvatarUploadFilteredReason("PITCH_FAIL", 7);
        PITCH_FAIL = r111;
        DigitalAvatarUploadFilteredReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f291283a = r112;
        f291284b = EnumEntriesKt.enumEntries(r112);
    }

    public static DigitalAvatarUploadFilteredReason[] values() {
        return (DigitalAvatarUploadFilteredReason[]) f291283a.clone();
    }

    public static DigitalAvatarUploadFilteredReason valueOf(String r100) {
        return (DigitalAvatarUploadFilteredReason) a.a(DigitalAvatarUploadFilteredReason.class, r100);
    }

    public DigitalAvatarUploadFilteredReason(String r100, int r101) {
        super(r100, r101);
    }
}
