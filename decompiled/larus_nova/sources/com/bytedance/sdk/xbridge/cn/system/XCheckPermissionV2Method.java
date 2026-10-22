package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.checkPermissionV2")
public final class XCheckPermissionV2Method extends c {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XCheckPermissionV2Method$Permission;", "", "", "", "permission", "Ljava/util/List;", "getPermission", "()Ljava/util/List;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "FINE_LOCATION", "CONTACTS", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
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
        public static final /* synthetic */ Permission[] f270161a = null;
        private final List<String> permission;

        public static final class a {
            public a() {
            }
        }

        public static Permission valueOf(String r100) {
            return (Permission) r27.a.a(Permission.class, r100);
        }

        public static Permission[] values() {
            return (Permission[]) f270161a.clone();
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
            Permission r114 = new Permission("CONTACTS", 10, CollectionsKt.listOf("android.permission.READ_CONTACTS"));
            CONTACTS = r114;
            Permission r106 = new Permission("UNKNOWN", 11, CollectionsKt.listOf(null));
            UNKNOWN = r106;
            f270161a = new Permission[]{r100, r101, r102, r103, r104, r110, r111, r105, r112, r113, r114, r106};
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

    public XCheckPermissionV2Method() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        c.b r113 = (c.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getPermission();
        Permission.Companion.getClass();
        if (r100 != null) goto L87;
        Permission r101 = Permission.UNKNOWN;
    L9:
        if (r101 != Permission.UNKNOWN) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "Illegal permission", null, 4, null);
        return;
    L11:
        Activity r114 = r110.getOwnerActivity();
        if (r114 != null) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L14:
        String r102 = "permitted";
        boolean r103 = false;
        if (r101 != Permission.NOTIFICATION) goto L26;
        r103 = NotificationManagerCompat.from(r114).areNotificationsEnabled();     // Catch: Exception -> L18
    L20:
        XBaseModel r115 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        c.InterfaceC3777c r116 = (c.InterfaceC3777c) r115;
        if (r103 == true) goto L24;
        r102 = "undetermined";
    L24:
        r116.setStatus(r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r115, null, 2, null);
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L26:
        if (r101 == Permission.LOCATION) goto L68;
        if (r101 == Permission.FINE_LOCATION) goto L68;
        if (r101 != Permission.PHOTOALBUM) goto L45;
        int r104 = ae7.h.f3113a;
        String r105 = r113.getAccessLevel();
        String r106 = "readWrite";
        if (r105 != null) goto L35;
        r105 = "readWrite";
    L35:
        boolean r107 = ae7.h.o(r114, r105);
        String r117 = r113.getAccessLevel();
        if (r117 == null) goto L39;
        r106 = r117;
    L39:
        boolean r118 = ae7.h.p(r114, r106);
        if (r107 == false) goto L42;
        XBaseModel r119 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r119).setStatus("permitted");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r119, null, 2, null);
        return;
    L42:
        if (r118 == false) goto L44;
        XBaseModel r120 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r120).setStatus("denied");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r120, null, 2, null);
        return;
    L44:
        XBaseModel r121 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r121).setStatus("undetermined");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r121, null, 2, null);
        return;
    L45:
        List<String> r122 = r101.getPermission();
        if (r122.size() != 1) goto L52;
        String r108 = (String) CollectionsKt.first(r122);
        if (r108 != null) goto L50;
    L61:
        boolean r123 = ae7.h.m(r114, r122);
        if (r103 == false) goto L64;
        XBaseModel r124 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r124).setStatus("permitted");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r124, null, 2, null);
        return;
    L64:
        if (r123 == false) goto L66;
        XBaseModel r125 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r125).setStatus("denied");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r125, null, 2, null);
        return;
    L66:
        XBaseModel r126 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r126).setStatus("undetermined");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r126, null, 2, null);
        return;
    L50:
        if (ContextCompat.checkSelfPermission(r114, r108) == (-1)) goto L61;
    L60:
        r103 = true;
        goto L61
    L52:
        Iterator<String> r109 = r122.iterator();
    L54:
        if (r109.hasNext() == false) goto L60;
        String r127 = r109.next();
        if (r127 == null) goto L54;
        if (ContextCompat.checkSelfPermission(r114, r127) != (-1)) goto L54;
    L68:
        if (r101 != Permission.FINE_LOCATION) goto L71;
        r103 = true;
    L71:
        if (ae7.h.k(r114) == true) goto L73;
        XBaseModel r128 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        ((c.InterfaceC3777c) r128).setStatus("denied");
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r128, null, 2, null);
        return;
    L73:
        if (r103 != true) goto L75;
        boolean r129 = ae7.h.h(r114);
    L76:
        if (r103 != true) goto L78;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r130 = ae7.h.n(r114, ae7.h.a());
    L79:
        XBaseModel r131 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC3777c.class));
        c.InterfaceC3777c r132 = (c.InterfaceC3777c) r131;
        if (r129 == true) goto L85;
        if (r130 == false) goto L84;
        r102 = "denied";
        goto L85
    L84:
        r102 = "undetermined";
    L85:
        r132.setStatus(r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r131, null, 2, null);
        return;
    L78:
        r130 = ae7.h.j(r114);
        goto L79
    L75:
        r129 = ae7.h.i(r114);
        goto L76
    L87:
        r101 = Permission.valueOf(r100.toUpperCase());     // Catch: Exception -> L6
    L6:
        r101 = Permission.UNKNOWN;
        goto L9
    }
}
