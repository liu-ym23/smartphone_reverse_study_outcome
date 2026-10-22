package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum CameraId extends Enum<CameraId> {
    private static final /* synthetic */ CameraId[] $VALUES = null;
    public static final CameraId CAMERA_ID_BACK = null;
    public static final CameraId CAMERA_ID_EXTERNAL = null;
    public static final CameraId CAMERA_ID_FRONT = null;
    public static final CameraId CAMERA_ID_INVALID = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.CameraId$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$CameraId = null;

        static {
            int[] r100 = new int[CameraId.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$CameraId = r100;
            r100[CameraId.CAMERA_ID_FRONT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$data$CameraId[CameraId.CAMERA_ID_BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        CameraId r100 = new CameraId("CAMERA_ID_FRONT", 0, 0);
        CAMERA_ID_FRONT = r100;
        CameraId r101 = new CameraId("CAMERA_ID_BACK", 1, 1);
        CAMERA_ID_BACK = r101;
        CameraId r102 = new CameraId("CAMERA_ID_EXTERNAL", 2, 2);
        CAMERA_ID_EXTERNAL = r102;
        CameraId r103 = new CameraId("CAMERA_ID_INVALID", 3, 3);
        CAMERA_ID_INVALID = r103;
        $VALUES = new CameraId[]{r100, r101, r102, r103};
    }

    public static CameraId[] values() {
        return (CameraId[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$CameraId[ordinal()];
        if (r100 != 1) goto L5;
        return "kCameraIDFront";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kCameraIDBack";
    }

    public int value() {
        return this.value;
    }

    public static CameraId fromId(int r100) {
        CameraId[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        CameraId r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static CameraId valueOf(String r100) {
        return (CameraId) a.a(CameraId.class, r100);
    }

    private CameraId(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
