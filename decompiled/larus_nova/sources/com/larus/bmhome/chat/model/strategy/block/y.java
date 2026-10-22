package com.larus.bmhome.chat.model.strategy.block;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f308057a = null;

    static {
        int[] r100 = new int[PermissionType.values().length];
        r100[PermissionType.PERMISSION_TYPE_UNSPECIFIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L25:
        r100[PermissionType.FINE_LOCATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L39:
        r100[PermissionType.COARSE_LOCATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L29:
        r100[PermissionType.ALWAYS_BACKGROUND_LOCATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
    L31:
        r100[PermissionType.RECORD_AUDIO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
    L23:
        r100[PermissionType.BLUETOOTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
    L33:
        r100[PermissionType.CAMERA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
    L35:
        r100[PermissionType.WRITE_CONTACTS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
    L27:
        r100[PermissionType.CALENDAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
    L12:
        f308057a = r100;
    }
}
