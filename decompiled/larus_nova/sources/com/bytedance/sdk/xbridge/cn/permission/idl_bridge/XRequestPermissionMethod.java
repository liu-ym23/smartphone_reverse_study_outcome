package com.bytedance.sdk.xbridge.cn.permission.idl_bridge;

import ae7.h;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.g;
import com.bytedance.sdk.xbridge.cn.utils.k;
import com.flow.performance.perftag.LocationPermissionStateTagValue;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.requestPermission")
public final class XRequestPermissionMethod extends he7.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f269945f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CompletionBlock<he7.a.c> f269946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Lifecycle.Event f269947e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/permission/idl_bridge/XRequestPermissionMethod$Permission;", "", "", "", "permission", "Ljava/util/List;", "getPermission", "()Ljava/util/List;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "FINE_LOCATION", "CONTACTS", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Permission extends Enum<Permission> {
        public static final Permission CALENDAR = null;
        public static final Permission CAMERA = null;
        public static final Permission CONTACTS = null;
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
        public static final /* synthetic */ Permission[] f269948a = null;
        private final List<String> permission;

        public static final class a {
            public a() {
            }
        }

        public static Permission valueOf(String r100) {
            return (Permission) r27.a.a(Permission.class, r100);
        }

        public static Permission[] values() {
            return (Permission[]) f269948a.clone();
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
            Permission r112 = new Permission(HTTP.LOCATION, 8, h.a());
            LOCATION = r112;
            Permission r113 = new Permission("FINE_LOCATION", 9, h.a());
            FINE_LOCATION = r113;
            Permission r114 = new Permission("CONTACTS", 10, CollectionsKt.listOf("android.permission.READ_CONTACTS"));
            CONTACTS = r114;
            Permission r106 = new Permission("UNKNOWN", 11, CollectionsKt.listOf(null));
            UNKNOWN = r106;
            f269948a = new Permission[]{r100, r101, r102, r103, r104, r110, r111, r105, r112, r113, r114, r106};
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

    public XRequestPermissionMethod() {
    }

    public static String a(Context r100) {
        if (h.h(r100) == false) goto L5;
        return LocationPermissionStateTagValue.FINE;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return LocationPermissionStateTagValue.COARSE;
    L11:
        return "failed";
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(final IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        he7.a.b r100 = (he7.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Lazy r101 = LazyKt.lazy(new XRequestPermissionMethod$handle$lifeCycleMonitorListener$2(this, r110));
        String r102 = r100.getPermission();
        Permission.Companion.getClass();
        if (r102 != null) goto L162;
        Permission r103 = Permission.UNKNOWN;
    L9:
        if (r103 != Permission.UNKNOWN) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "Illegal permission", null, 4, null);
        return;
    L11:
        Activity r104 = r110.getOwnerActivity();
        if (r104 != null) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L14:
        String r105 = "undetermined";
        boolean r113 = false;
        if (r103 == Permission.NOTIFICATION) goto L160;
        boolean r106 = true;
        if (r103 == Permission.LOCATION) goto L140;
        if (r103 == Permission.FINE_LOCATION) goto L140;
        if (r103 != Permission.PHOTOALBUM) goto L105;
        String r107 = r100.getAccessLevel();
        if (r107 != null) goto L50;
        r107 = "readWrite";
    L50:
        if (h.o(r104, r107) == false) goto L52;
        XBaseModel r108 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r109 = (he7.a.c) r108;
        r109.setStatus("permitted");
        r109.setLocationStatus("unknown");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r108, null, 2, null);
        return;
    L52:
        Intrinsics.checkNotNullParameter(r107, "type");
        int r114 = r107.hashCode();
        if (r114 == (-1406475221)) goto L80;
        if (r114 == (-1120887831)) goto L70;
        if (r114 == (-867683742)) goto L60;
    L81:
        List r115 = CollectionsKt.emptyList();
    L89:
        Activity r116 = k.f270262a.getActivity(r104);
        if (r116 == null) goto L192;
        IHostPermissionDepend r117 = g.f(r110);
        if (r117 == null) goto L184;
        String r118 = this.f484887a;
        ArrayList r119 = new ArrayList();
        Iterator r120 = r115.iterator();
    L96:
        if (r120.hasNext() == false) goto L100;
        String r121 = (String) r120.next();
        if (r121 == null) goto L96;
        r119.add(r121);
        goto L96
    L100:
        Object[] r122 = r119.toArray(new String[0]);
        if (r122 == null) goto L104;
        String[] r123 = (String[]) r122;
        r117.requestPermission(r116, r110, r118, (String[]) Arrays.copyOf(r123, r123.length), new b(r117, r104, r112));
        return;
    L104:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L184:
        return;
    L192:
        return;
    L60:
        if (r107.equals("readOnly") == false) goto L81;
        if (h.q() == false) goto L66;
        r115 = CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
        goto L89
    L66:
        if (h.g() == false) goto L68;
        r115 = CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
        goto L89
    L68:
        r115 = CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
        goto L89
    L70:
        if (r107.equals("readWrite") == false) goto L81;
        if (h.q() == false) goto L76;
        r115 = CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO});
        goto L89
    L76:
        if (h.g() == false) goto L78;
        r115 = CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
        goto L89
    L78:
        r115 = CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
        goto L89
    L80:
        if (r107.equals("writeOnly") == false) goto L81;
        if (h.q() == false) goto L86;
        r115 = CollectionsKt.emptyList();
        goto L89
    L86:
        if (h.g() == false) goto L88;
        r115 = CollectionsKt.emptyList();
        goto L89
    L88:
        r115 = CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
        goto L89
    L105:
        List<String> r124 = r103.getPermission();
        IHostPermissionDepend r125 = g.f(r110);
        if (r125 == null) goto L120;
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r124.iterator();
    L109:
        if (r127.hasNext() == false) goto L113;
        String r128 = (String) r127.next();
        if (r128 == null) goto L109;
        r126.add(r128);
        goto L109
    L113:
        Object[] r129 = r126.toArray(new String[0]);
        if (r129 == null) goto L119;
        String[] r130 = (String[]) r129;
        if (r125.isPermissionAllGranted(r104, (String[]) Arrays.copyOf(r130, r130.length)) != true) goto L120;
    L121:
        if (r106 == false) goto L123;
        XBaseModel r131 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r132 = (he7.a.c) r131;
        r132.setStatus("permitted");
        r132.setLocationStatus("unknown");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r131, null, 2, null);
        return;
    L123:
        List<String> r133 = r103.getPermission();
        Activity r134 = k.f270262a.getActivity(r104);
        if (r134 == null) goto L193;
        IHostPermissionDepend r135 = g.f(r110);
        if (r135 == null) goto L187;
        String r136 = this.f484887a;
        ArrayList r137 = new ArrayList();
        Iterator<T> r138 = r133.iterator();
    L130:
        if (r138.hasNext() == false) goto L134;
        String r139 = (String) r138.next();
        if (r139 == null) goto L130;
        r137.add(r139);
        goto L130
    L134:
        Object[] r140 = r137.toArray(new String[0]);
        if (r140 == null) goto L138;
        String[] r141 = (String[]) r140;
        r135.requestPermission(r134, r110, r136, (String[]) Arrays.copyOf(r141, r141.length), new a(r112));
        return;
    L138:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L187:
        return;
    L193:
        return;
    L119:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L120:
        r106 = false;
    L140:
        if (r103 != Permission.FINE_LOCATION) goto L143;
        r113 = true;
    L143:
        if (h.k(r104) == true) goto L145;
        r105 = "denied";
    L151:
        if (Intrinsics.areEqual(r105, "permitted") == false) goto L154;
        XBaseModel r142 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r143 = (he7.a.c) r142;
        r143.setStatus(r105);
        r143.setLocationStatus(a(r104));
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r142, null, 2, null);
        return;
    L154:
        if (Intrinsics.areEqual(r105, "denied") == false) goto L156;
        XBaseModel r144 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r145 = (he7.a.c) r144;
        r145.setStatus(r105);
        r145.setLocationStatus(a(r104));
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r144, null, 2, null);
        return;
    L156:
        int r146 = g.f270260a;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostLocationPermissionDepend r147 = XBaseRuntime.f270108n;
        if (r147 == null) goto L191;
        r147.requestPermission(r104, r110, this.f484887a, new c(r112, this, r104, r103));
        return;
    L191:
        return;
    L145:
        if (r113 != true) goto L147;
        boolean r148 = h.h(r104);
    L148:
        if (r148 == false) goto L151;
        r105 = "permitted";
        goto L151
    L147:
        r148 = h.i(r104);
        goto L148
    L160:
        r113 = NotificationManagerCompat.from(r104).areNotificationsEnabled();     // Catch: Exception -> L18
    L20:
        if (r113 == false) goto L23;
        r105 = "permitted";
    L23:
        if (Intrinsics.areEqual(r105, "permitted") == false) goto L25;
        XBaseModel r149 = e.c(Reflection.getOrCreateKotlinClass(he7.a.c.class));
        he7.a.c r150 = (he7.a.c) r149;
        r150.setStatus(r105);
        r150.setLocationStatus("unknown");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r149, null, 2, null);
        return;
    L25:
        this.f269946d = r112;
        if ((r104 instanceof FragmentActivity) == false) goto L28;
        FragmentActivity r151 = (FragmentActivity) r104;
    L29:
        if (r151 == null) goto L33;
        Lifecycle r152 = r151.getLifecycle();
        if (r152 == null) goto L33;
        r152.addObserver((LifecycleObserver) r101.getValue());
    L33:
        Map<String, ie7.a.b> r153 = ie7.a.f489497a;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        ie7.a.b r154 = ie7.a.f489497a.get(Build.MANUFACTURER.toLowerCase());
        if (r154 == null) goto L37;
        Intent r155 = r154.b(r104);
        if (r155 == null) goto L37;
    L38:
        r104.startActivity(r155);
        return;
    L37:
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        r155 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r155.addFlags(268435456);
        r155.setData(Uri.fromParts("package", r104.getPackageName(), null));
        goto L38
    L28:
        r151 = null;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L162:
        r103 = Permission.valueOf(r102.toUpperCase(Locale.ROOT));     // Catch: Exception -> L6
    L6:
        r103 = Permission.UNKNOWN;
        goto L9
    }
}
