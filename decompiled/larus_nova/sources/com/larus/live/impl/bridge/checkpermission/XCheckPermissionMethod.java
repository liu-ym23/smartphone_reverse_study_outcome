package com.larus.live.impl.bridge.checkpermission;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import pi9.b;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@XBridgeMethod(name = "x.checkPermission")
public final class XCheckPermissionMethod extends b implements h {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0019\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/larus/live/impl/bridge/checkpermission/XCheckPermissionMethod$Permission;", "", "permission", "", "", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getPermission", "()Ljava/util/List;", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "CALENDAR", "READ_CALENDAR", "WRITE_CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "UNKNOWN", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public static final /* synthetic */ Permission[] f355747a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f355748b = null;
        private final List<String> permission;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Permission> getEntries() {
            return f355748b;
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
            Permission r104 = new Permission("CALENDAR", 4, CollectionsKt.listOf(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}));
            CALENDAR = r104;
            Permission r110 = new Permission("READ_CALENDAR", 5, CollectionsKt.listOf("android.permission.READ_CALENDAR"));
            READ_CALENDAR = r110;
            Permission r105 = new Permission("WRITE_CALENDAR", 6, CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
            WRITE_CALENDAR = r105;
            Permission r111 = new Permission(BannerBizName.NOTIFICATION, 7, CollectionsKt.listOf(""));
            NOTIFICATION = r111;
            Permission r112 = new Permission(HTTP.LOCATION, 8, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
            LOCATION = r112;
            Permission r113 = new Permission("UNKNOWN", 9, CollectionsKt.listOf(null));
            UNKNOWN = r113;
            Permission[] r114 = {r100, r101, r102, r103, r104, r110, r105, r111, r112, r113};
            f355747a = r114;
            f355748b = EnumEntriesKt.enumEntries(r114);
            Companion = new a();
        }

        public static Permission[] values() {
            return (Permission[]) f355747a.clone();
        }

        public final List<String> getPermission() {
            return this.permission;
        }

        public static Permission valueOf(String r100) {
            return (Permission) r27.a.a(Permission.class, r100);
        }

        public Permission(String r100, int r101, List r102) {
            super(r100, r101);
            this.permission = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/live/impl/bridge/checkpermission/XCheckPermissionMethod$PermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PERMITTED", "DENIED", "UNDETERMINED", "RESTRICTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PermissionStatus extends Enum<PermissionStatus> {
        public static final PermissionStatus DENIED = null;
        public static final PermissionStatus PERMITTED = null;
        public static final PermissionStatus RESTRICTED = null;
        public static final PermissionStatus UNDETERMINED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PermissionStatus[] f355749a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f355750b = null;

        public static EnumEntries<PermissionStatus> getEntries() {
            return f355750b;
        }

        static {
            PermissionStatus r100 = new PermissionStatus("PERMITTED", 0);
            PERMITTED = r100;
            PermissionStatus r101 = new PermissionStatus("DENIED", 1);
            DENIED = r101;
            PermissionStatus r102 = new PermissionStatus("UNDETERMINED", 2);
            UNDETERMINED = r102;
            PermissionStatus r103 = new PermissionStatus("RESTRICTED", 3);
            RESTRICTED = r103;
            PermissionStatus[] r104 = {r100, r101, r102, r103};
            f355749a = r104;
            f355750b = EnumEntriesKt.enumEntries(r104);
        }

        public static PermissionStatus[] values() {
            return (PermissionStatus[]) f355749a.clone();
        }

        public static PermissionStatus valueOf(String r100) {
            return (PermissionStatus) a.a(PermissionStatus.class, r100);
        }

        public PermissionStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public XCheckPermissionMethod() {
    }
}
