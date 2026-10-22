package com.bytedance.ies.xbridge.system.idl_bridge;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nR\u001f\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"com/bytedance/ies/xbridge/system/idl_bridge/XCheckPermissionV2Method$Permission", "", "Lcom/bytedance/ies/xbridge/system/idl_bridge/XCheckPermissionV2Method$Permission;", "", "", "permission", "Ljava/util/List;", "getPermission", "()Ljava/util/List;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "UNKNOWN", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XCheckPermissionV2Method$Permission extends Enum<XCheckPermissionV2Method$Permission> {
    public static final XCheckPermissionV2Method$Permission CALENDAR = null;
    public static final XCheckPermissionV2Method$Permission CAMERA = null;
    public static final a Companion = null;
    public static final XCheckPermissionV2Method$Permission LOCATION = null;
    public static final XCheckPermissionV2Method$Permission MICROPHONE = null;
    public static final XCheckPermissionV2Method$Permission NOTIFICATION = null;
    public static final XCheckPermissionV2Method$Permission PHOTOALBUM = null;
    public static final XCheckPermissionV2Method$Permission READ_CALENDAR = null;
    public static final XCheckPermissionV2Method$Permission UNKNOWN = null;
    public static final XCheckPermissionV2Method$Permission VIBRATE = null;
    public static final XCheckPermissionV2Method$Permission WRITE_CALENDAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XCheckPermissionV2Method$Permission[] f249546a = null;
    private final List<String> permission;

    public static XCheckPermissionV2Method$Permission valueOf(String r100) {
        return (XCheckPermissionV2Method$Permission) r27.a.a(XCheckPermissionV2Method$Permission.class, r100);
    }

    public static XCheckPermissionV2Method$Permission[] values() {
        return (XCheckPermissionV2Method$Permission[]) f249546a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.ies.xbridge.system.idl_bridge.XCheckPermissionV2Method$Permission$a] */
    static {
        XCheckPermissionV2Method$Permission r100 = new XCheckPermissionV2Method$Permission("CAMERA", 0, CollectionsKt.listOf("android.permission.CAMERA"));
        CAMERA = r100;
        XCheckPermissionV2Method$Permission r101 = new XCheckPermissionV2Method$Permission("MICROPHONE", 1, CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
        MICROPHONE = r101;
        XCheckPermissionV2Method$Permission r102 = new XCheckPermissionV2Method$Permission("PHOTOALBUM", 2, CollectionsKt.emptyList());
        PHOTOALBUM = r102;
        XCheckPermissionV2Method$Permission r103 = new XCheckPermissionV2Method$Permission("VIBRATE", 3, CollectionsKt.listOf("android.permission.VIBRATE"));
        VIBRATE = r103;
        XCheckPermissionV2Method$Permission r104 = new XCheckPermissionV2Method$Permission("READ_CALENDAR", 4, CollectionsKt.listOf("android.permission.READ_CALENDAR"));
        READ_CALENDAR = r104;
        XCheckPermissionV2Method$Permission r110 = new XCheckPermissionV2Method$Permission("WRITE_CALENDAR", 5, CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
        WRITE_CALENDAR = r110;
        XCheckPermissionV2Method$Permission r111 = new XCheckPermissionV2Method$Permission("CALENDAR", 6, CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}));
        CALENDAR = r111;
        XCheckPermissionV2Method$Permission r105 = new XCheckPermissionV2Method$Permission(BannerBizName.NOTIFICATION, 7, CollectionsKt.listOf(""));
        NOTIFICATION = r105;
        XCheckPermissionV2Method$Permission r112 = new XCheckPermissionV2Method$Permission(HTTP.LOCATION, 8, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        LOCATION = r112;
        XCheckPermissionV2Method$Permission r113 = new XCheckPermissionV2Method$Permission("UNKNOWN", 9, CollectionsKt.listOf(null));
        UNKNOWN = r113;
        f249546a = new XCheckPermissionV2Method$Permission[]{r100, r101, r102, r103, r104, r110, r111, r105, r112, r113};
        Companion = new a();
    }

    public final List<String> getPermission() {
        return this.permission;
    }

    public XCheckPermissionV2Method$Permission(String r100, int r101, List r102) {
        super(r100, r101);
        this.permission = r102;
    }
}
