package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.openPermissionSettings")
public final class XOpenPermissionSettingsMethod extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompletionBlock<f.c> f270162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Permission f270163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f270164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Lifecycle.Event f270165g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod$Permission;", "", "", "", "permission", "Ljava/util/List;", "getPermission", "()Ljava/util/List;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "FINE_LOCATION", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Permission extends Enum<Permission> {
        public static final Permission CALENDAR = null;
        public static final Permission CAMERA = null;
        public static final a Companion = null;
        public static final Permission FINE_LOCATION = null;
        public static final Permission LOCATION = null;
        public static final Permission MICROPHONE = null;
        public static final Permission NOTIFICATION = null;
        public static final Permission PHOTOALBUM = null;
        public static final Permission READ_CALENDAR = null;
        public static final Permission UNKNOWN = null;
        public static final Permission VIBRATE = null;
        public static final Permission WRITE_CALENDAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Permission[] f270166a = null;
        private final List<String> permission;

        public static final class a {
            public a() {
            }
        }

        public static Permission valueOf(String r100) {
            return (Permission) r27.a.a(Permission.class, r100);
        }

        public static Permission[] values() {
            return (Permission[]) f270166a.clone();
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
            Permission r112 = new Permission(HTTP.LOCATION, 8, ae7.h.a());
            LOCATION = r112;
            Permission r113 = new Permission("FINE_LOCATION", 9, ae7.h.a());
            FINE_LOCATION = r113;
            Permission r114 = new Permission("UNKNOWN", 10, CollectionsKt.listOf(null));
            UNKNOWN = r114;
            f270166a = new Permission[]{r100, r101, r102, r103, r104, r110, r111, r105, r112, r113, r114};
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

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270167a = null;

        static {
            int[] r100 = new int[Permission.values().length];
            r100[Permission.NOTIFICATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Permission.LOCATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Permission.FINE_LOCATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Permission.PHOTOALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f270167a = r100;
        }
    }

    public XOpenPermissionSettingsMethod() {
    }

    public final String a(Context r100) {
        Permission r101 = this.f270163e;
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        boolean r103 = false;
        if (r102 != 1) goto L9;
        r103 = NotificationManagerCompat.from(r100).areNotificationsEnabled();     // Catch: Exception -> L72
    L74:
        if (r103 == false) goto L98;
    L75:
        String r104 = "permitted";
    L77:
        return r104;
    L98:
        return "undetermined";
    L72:
        e = move-exception;
        e.printStackTrace();
        goto L74
    L9:
        if (r102 == 2) goto L55;
        if (r102 == 3) goto L55;
        if (r102 == 4) goto L46;
        Permission r105 = this.f270163e;
        if (r105 == null) goto L92;
        List<String> r106 = r105.getPermission();
        if (r106 != null) goto L19;
        return "undetermined";
    L19:
        if (r106.size() != 1) goto L25;
        String r107 = (String) CollectionsKt.first(r106);
        if (r107 != null) goto L23;
    L32:
        boolean r108 = false;
    L34:
        Activity r109 = (Activity) r100;
        Iterator<T> r110 = r106.iterator();
    L36:
        if (r110.hasNext() == false) goto L42;
        String r111 = (String) r110.next();
        if (r111 == null) goto L36;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r109, r111) == true) goto L36;
        r103 = true;
    L42:
        if (r108 == true) goto L75;
        if (r103 == false) goto L94;
    L69:
        r104 = "denied";
        goto L77
    L94:
        return "undetermined";
    L23:
        if (ContextCompat.checkSelfPermission(r100, r107) == (-1)) goto L32;
    L33:
        r108 = true;
        goto L34
    L25:
        Iterator<String> r112 = r106.iterator();
    L27:
        if (r112.hasNext() == false) goto L33;
        String r113 = r112.next();
        if (r113 == null) goto L27;
        if (ContextCompat.checkSelfPermission(r100, r113) != (-1)) goto L27;
    L92:
        return "undetermined";
    L46:
        String r114 = this.f270164f;
        if (r114 != null) goto L49;
        r114 = "readWrite";
    L49:
        boolean r115 = ae7.h.o(r100, r114);
        boolean r116 = ae7.h.p(r100, r114);
        if (r115 == true) goto L75;
        if (r116 == true) goto L69;
        return "undetermined";
    L55:
        if (this.f270163e != Permission.FINE_LOCATION) goto L58;
        r103 = true;
    L58:
        if (ae7.h.k(r100) == true) goto L60;
        return "restricted";
    L60:
        if (r103 != true) goto L62;
        boolean r117 = ae7.h.h(r100);
    L63:
        if (r103 != true) goto L65;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r118 = ae7.h.n(r100, ae7.h.a());
    L66:
        if (r117 == true) goto L75;
        if (r118 == true) goto L69;
        return "undetermined";
    L65:
        r118 = ae7.h.j(r100);
        goto L66
    L62:
        r117 = ae7.h.i(r100);
        goto L63
    L5:
        r102 = a.f270167a[r101.ordinal()];
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(final IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        f.b r113 = (f.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        GenericLifecycleObserver r100 = new XOpenPermissionSettingsMethod$handle$lifeCycleMonitorListener$1(this, r110);
        String r101 = r113.getPermission();
        Permission.Companion.getClass();
        if (r101 != null) goto L53;
        Permission r102 = Permission.UNKNOWN;
    L9:
        if (r102 != Permission.UNKNOWN) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "Illegal permission", null, 4, null);
        return;
    L11:
        this.f270163e = r102;
        Activity r114 = r110.getOwnerActivity();
        if (r114 != null) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L14:
        this.f270164f = r113.getAccessLevel();
        String r115 = a(r114);
        if (Intrinsics.areEqual(r115, "permitted") == false) goto L17;
        XBaseModel r116 = ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class));
        ((f.c) r116).setStatus(r115);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r116, null, 2, null);
        return;
    L17:
        this.f270162d = r112;
        if ((r114 instanceof FragmentActivity) == false) goto L20;
        FragmentActivity r117 = (FragmentActivity) r114;
    L21:
        if (r117 == null) goto L24;
        r117.getLifecycle().addObserver(r100);
    L24:
        if (r102 == Permission.LOCATION) goto L28;
        if (r102 == Permission.FINE_LOCATION) goto L28;
    L36:
        if (r102 != Permission.NOTIFICATION) goto L46;
        Map<String, i.b> r118 = i.f270195a;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        i.b r119 = i.f270195a.get(Build.MANUFACTURER.toLowerCase());
        if (r119 == null) goto L41;
        Intent r120 = r119.b(r114);
        if (r120 == null) goto L41;
    L45:
        r114.startActivity(r120);
        return;
    L41:
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 26) goto L44;
        r120 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        r120.putExtra("android.provider.extra.APP_PACKAGE", r114.getPackageName());
        r120.addFlags(268435456);
        goto L45
    L44:
        r120 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r120.addFlags(268435456);
        r120.setData(Uri.fromParts("package", r114.getPackageName(), null));
        goto L45
    L46:
        Map<String, i.b> r121 = i.f270195a;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        i.b r122 = i.f270195a.get(Build.MANUFACTURER.toLowerCase());
        if (r122 == null) goto L50;
        Intent r123 = r122.a(r114);
        if (r123 == null) goto L50;
    L51:
        r114.startActivity(r123);
        return;
    L50:
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        r123 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r123.addFlags(268435456);
        r123.setData(Uri.fromParts("package", r114.getPackageName(), null));
    L28:
        if (Intrinsics.areEqual(r115, "restricted") == false) goto L36;
        Map<String, i.b> r124 = i.f270195a;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        i.b r125 = i.f270195a.get(Build.MANUFACTURER.toLowerCase());
        if (r125 == null) goto L33;
        Intent r126 = r125.c(r114);
        if (r126 == null) goto L33;
    L34:
        r114.startActivity(r126);
        return;
    L33:
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        r126 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        r126.addFlags(268435456);
        goto L34
    L20:
        r117 = null;
        goto L21
    L53:
        r102 = Permission.valueOf(r101.toUpperCase());     // Catch: Exception -> L6
    L6:
        r102 = Permission.UNKNOWN;
        goto L9
    }
}
