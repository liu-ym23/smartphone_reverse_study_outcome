package com.larus.bmhome.chat.model.strategy.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/model/strategy/block/PermissionType;", "", "permissionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPermissionName", "()Ljava/lang/String;", "PERMISSION_TYPE_UNSPECIFIED", "FINE_LOCATION", "COARSE_LOCATION", "ALWAYS_BACKGROUND_LOCATION", "RECORD_AUDIO", "BLUETOOTH", "CAMERA", "WRITE_CONTACTS", "CALENDAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionType extends Enum<PermissionType> {
    public static final PermissionType ALWAYS_BACKGROUND_LOCATION = null;
    public static final PermissionType BLUETOOTH = null;
    public static final PermissionType CALENDAR = null;
    public static final PermissionType CAMERA = null;
    public static final PermissionType COARSE_LOCATION = null;
    public static final PermissionType FINE_LOCATION = null;
    public static final PermissionType PERMISSION_TYPE_UNSPECIFIED = null;
    public static final PermissionType RECORD_AUDIO = null;
    public static final PermissionType WRITE_CONTACTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionType[] f308013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308014b = null;
    private final String permissionName;

    public static EnumEntries<PermissionType> getEntries() {
        return f308014b;
    }

    static {
        PermissionType r100 = new PermissionType("PERMISSION_TYPE_UNSPECIFIED", 0, "ACCESS_UNSPECIFIED");
        PERMISSION_TYPE_UNSPECIFIED = r100;
        PermissionType r101 = new PermissionType("FINE_LOCATION", 1, "ACCESS_FINE_LOCATION");
        FINE_LOCATION = r101;
        PermissionType r102 = new PermissionType("COARSE_LOCATION", 2, "ACCESS_COARSE_LOCATION");
        COARSE_LOCATION = r102;
        PermissionType r103 = new PermissionType("ALWAYS_BACKGROUND_LOCATION", 3, "ACCESS_BACKGROUND_LOCATION");
        ALWAYS_BACKGROUND_LOCATION = r103;
        PermissionType r104 = new PermissionType("RECORD_AUDIO", 4, "RECORD_AUDIO");
        RECORD_AUDIO = r104;
        PermissionType r105 = new PermissionType("BLUETOOTH", 5, "BLUETOOTH");
        BLUETOOTH = r105;
        PermissionType r110 = new PermissionType("CAMERA", 6, "CAMERA");
        CAMERA = r110;
        PermissionType r111 = new PermissionType("WRITE_CONTACTS", 7, "WRITE_CONTACTS");
        WRITE_CONTACTS = r111;
        PermissionType r112 = new PermissionType("CALENDAR", 8, "CALENDAR");
        CALENDAR = r112;
        PermissionType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f308013a = r113;
        f308014b = EnumEntriesKt.enumEntries(r113);
    }

    public static PermissionType[] values() {
        return (PermissionType[]) f308013a.clone();
    }

    public final String getPermissionName() {
        return this.permissionName;
    }

    public static PermissionType valueOf(String r100) {
        return (PermissionType) r27.a.a(PermissionType.class, r100);
    }

    public PermissionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.permissionName = r102;
    }
}
