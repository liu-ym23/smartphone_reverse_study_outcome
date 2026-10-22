package com.bytedance.ies.xbridge.system.idl_bridge;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import x66.b;

/* JADX INFO: loaded from: classes19.dex */
public final class XOpenPermissionSettingsMethod extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f249547c = 0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/xbridge/system/idl_bridge/XOpenPermissionSettingsMethod$Permission;", "", "", "", "permission", "Ljava/util/List;", "getPermission", "()Ljava/util/List;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "UNKNOWN", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Permission extends Enum<Permission> {
        public static final Permission CALENDAR = null;
        public static final Permission CAMERA = null;
        public static final a Companion = null;
        public static final Permission LOCATION = null;
        public static final Permission MICROPHONE = null;
        public static final Permission NOTIFICATION = null;
        public static final Permission PHOTOALBUM = null;
        public static final Permission READ_CALENDAR = null;
        public static final Permission UNKNOWN = null;
        public static final Permission VIBRATE = null;
        public static final Permission WRITE_CALENDAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Permission[] f249548a = null;
        private final List<String> permission;

        public static final class a {
            public a() {
            }
        }

        public static Permission valueOf(String r100) {
            return (Permission) r27.a.a(Permission.class, r100);
        }

        public static Permission[] values() {
            return (Permission[]) f249548a.clone();
        }

        static {
            Permission r100 = new Permission("CAMERA", 0, CollectionsKt.listOf("android.permission.CAMERA"));
            CAMERA = r100;
            Permission r101 = new Permission("MICROPHONE", 1, CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
            MICROPHONE = r101;
            Permission r102 = new Permission("PHOTOALBUM", 2, CollectionsKt.emptyList());
            PHOTOALBUM = r102;
            Permission r103 = new Permission("VIBRATE", 3, CollectionsKt.listOf("android.permission.VIBRATE"));
            VIBRATE = r103;
            Permission r104 = new Permission("READ_CALENDAR", 4, CollectionsKt.listOf("android.permission.READ_CALENDAR"));
            READ_CALENDAR = r104;
            Permission r110 = new Permission("WRITE_CALENDAR", 5, CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
            WRITE_CALENDAR = r110;
            Permission r111 = new Permission("CALENDAR", 6, CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}));
            CALENDAR = r111;
            Permission r105 = new Permission(BannerBizName.NOTIFICATION, 7, CollectionsKt.listOf(""));
            NOTIFICATION = r105;
            Permission r112 = new Permission(HTTP.LOCATION, 8, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
            LOCATION = r112;
            Permission r113 = new Permission("UNKNOWN", 9, CollectionsKt.listOf(null));
            UNKNOWN = r113;
            f249548a = new Permission[]{r100, r101, r102, r103, r104, r110, r111, r105, r112, r113};
            Companion = new a();
        }

        public final List<String> getPermission() {
            return this.permission;
        }

        public Permission(String r100, int r101, List r102) {
            super(r100, r101);
            this.permission = r102;
        }
    }
}
