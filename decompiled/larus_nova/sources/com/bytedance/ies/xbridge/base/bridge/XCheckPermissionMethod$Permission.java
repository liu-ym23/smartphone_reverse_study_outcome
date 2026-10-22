package com.bytedance.ies.xbridge.base.bridge;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"com/bytedance/ies/xbridge/base/bridge/XCheckPermissionMethod$Permission", "", "Lcom/bytedance/ies/xbridge/base/bridge/XCheckPermissionMethod$Permission;", "", "permission", "Ljava/lang/String;", "getPermission", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "UNKNOWN", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XCheckPermissionMethod$Permission extends Enum<XCheckPermissionMethod$Permission> {
    public static final XCheckPermissionMethod$Permission CAMERA = null;
    public static final a Companion = null;
    public static final XCheckPermissionMethod$Permission MICROPHONE = null;
    public static final XCheckPermissionMethod$Permission PHOTOALBUM = null;
    public static final XCheckPermissionMethod$Permission READ_CALENDAR = null;
    public static final XCheckPermissionMethod$Permission UNKNOWN = null;
    public static final XCheckPermissionMethod$Permission VIBRATE = null;
    public static final XCheckPermissionMethod$Permission WRITE_CALENDAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XCheckPermissionMethod$Permission[] f249442a = null;
    private final String permission;

    public static XCheckPermissionMethod$Permission valueOf(String r100) {
        return (XCheckPermissionMethod$Permission) r27.a.a(XCheckPermissionMethod$Permission.class, r100);
    }

    public static XCheckPermissionMethod$Permission[] values() {
        return (XCheckPermissionMethod$Permission[]) f249442a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.xbridge.base.bridge.XCheckPermissionMethod$Permission$a] */
    static {
        XCheckPermissionMethod$Permission r100 = new XCheckPermissionMethod$Permission("CAMERA", 0, "android.permission.CAMERA");
        CAMERA = r100;
        XCheckPermissionMethod$Permission r101 = new XCheckPermissionMethod$Permission("MICROPHONE", 1, "android.permission.RECORD_AUDIO");
        MICROPHONE = r101;
        XCheckPermissionMethod$Permission r102 = new XCheckPermissionMethod$Permission("PHOTOALBUM", 2, null);
        PHOTOALBUM = r102;
        XCheckPermissionMethod$Permission r103 = new XCheckPermissionMethod$Permission("VIBRATE", 3, "android.permission.VIBRATE");
        VIBRATE = r103;
        XCheckPermissionMethod$Permission r104 = new XCheckPermissionMethod$Permission("READ_CALENDAR", 4, "android.permission.READ_CALENDAR");
        READ_CALENDAR = r104;
        XCheckPermissionMethod$Permission r110 = new XCheckPermissionMethod$Permission("WRITE_CALENDAR", 5, "android.permission.WRITE_CALENDAR");
        WRITE_CALENDAR = r110;
        XCheckPermissionMethod$Permission r111 = new XCheckPermissionMethod$Permission("UNKNOWN", 6, null);
        UNKNOWN = r111;
        f249442a = new XCheckPermissionMethod$Permission[]{r100, r101, r102, r103, r104, r110, r111};
        Companion = new a();
    }

    public final String getPermission() {
        return this.permission;
    }

    public XCheckPermissionMethod$Permission(String r100, int r101, String r102) {
        super(r100, r101);
        this.permission = r102;
    }
}
