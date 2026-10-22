package com.bytedance.upc.bridge.impl;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.common.ICommonBusinessService;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "upc.getSystemAuthorityStatus", owner = "wanglijie.skin")
public final class k extends gp7.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f272433d;

    public k() {
        this.f272433d = "upcsdk://upc.system?package=%s&action=%s&target=settings&permission=%s";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v100 */
    /* JADX WARN: Type inference failed for: r7v101 */
    /* JADX WARN: Type inference failed for: r7v102 */
    /* JADX WARN: Type inference failed for: r7v103 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v81, types: [int] */
    /* JADX WARN: Type inference failed for: r7v94 */
    /* JADX WARN: Type inference failed for: r7v95 */
    /* JADX WARN: Type inference failed for: r7v96 */
    /* JADX WARN: Type inference failed for: r7v97 */
    /* JADX WARN: Type inference failed for: r7v98 */
    /* JADX WARN: Type inference failed for: r7v99 */
    public final List<Map<String, Object>> b(IBDXBridgeContext r110, List<? extends gp7.g.d> r111) {
        List<? extends gp7.g.d> r100 = r111;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        View r102 = r110.getEngineView();
        if (r102 == null) goto L126;
        Context r103 = r102.getContext();
        if (r103 == null) goto L126;
        com.bytedance.upc.a r104 = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r111.iterator();
    L18:
        if (r106.hasNext() == false) goto L124;
        gp7.g.d r107 = (gp7.g.d) r106.next();
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("type", r107.getType());
        String r109 = r107.getType();
        int r112 = r109.hashCode();
        String r113 = CameraParam.TYPE_SYSTEM_CAMERA;
        switch(r112) {
            case -1953474717: goto L113;
            case -1611296843: goto L103;
            case -1354519578: goto L96;
            case -1166291365: goto L75;
            case 62628790: goto L68;
            case 76105038: goto L61;
            case 215175251: goto L54;
            case 604302142: goto L44;
            case 1186196854: goto L30;
            case 1980544805: goto L23;
            default: goto L119;
        };
    L119:
        ?? r114 = 0;
    L120:
        r108.put("status", Integer.valueOf(r114));
        r108.put("authorityType", r113);
        if (Build.VERSION.SDK_INT > 23) goto L123;
        StringCompanionObject r115 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS"}, 2)));
    L123:
        r105.add(r108);
        goto L18
    L23:
        if (r109.equals("CAMERA") == false) goto L119;
        if (a(r103, "android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0) goto L27;
        boolean r116 = true;
    L28:
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CAMERA"}, 3)));
        r114 = r116;
        goto L120
    L27:
        r116 = false;
        goto L28
    L30:
        if (r109.equals("CLIPBOARD") == false) goto L119;
        if (jp7.c.a().b() == true) goto L35;
        r113 = "app";
    L35:
        if (jp7.c.a().b() == false) goto L37;
        boolean r118 = jp7.a.a();
    L42:
        StringCompanionObject r119 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CLIPBOARD"}, 3)));
        r108.put("privacyType", BDLocationException.ERROR_INIT_LOCATION);
        r114 = r118;
        goto L120
    L37:
        com.bytedance.upc.e r120 = r104.f272402c;
        if (r120 == null) goto L40;
        String r121 = r120.c();
    L41:
        r118 = Intrinsics.areEqual(r121, "on");
        goto L42
    L40:
        r121 = null;
        goto L41
    L44:
        if (r109.equals("CALENDAR") == false) goto L119;
        if (a(r103, "android.permission.WRITE_CALENDAR", Process.myPid(), Process.myUid()) != 0) goto L48;
    L51:
        boolean r122 = true;
    L52:
        StringCompanionObject r123 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CALENDAR"}, 3)));
        r114 = r122;
        goto L120
    L48:
        if (a(r103, "android.permission.READ_CALENDAR", Process.myPid(), Process.myUid()) == 0) goto L51;
        r122 = false;
        goto L52
    L54:
        if (r109.equals("CONTACTS") == false) goto L119;
        if (a(r103, "android.permission.READ_CONTACTS", Process.myPid(), Process.myUid()) != 0) goto L58;
        boolean r124 = true;
    L59:
        StringCompanionObject r125 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "CONTACTS"}, 3)));
        r114 = r124;
        goto L120
    L58:
        r124 = false;
        goto L59
    L61:
        if (r109.equals("PHONE") == false) goto L119;
        if (a(r103, "android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != 0) goto L65;
        boolean r126 = true;
    L66:
        StringCompanionObject r127 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "PHONE"}, 3)));
        r114 = r126;
        goto L120
    L65:
        r126 = false;
        goto L66
    L68:
        if (r109.equals("AUDIO") == false) goto L119;
        if (a(r103, "android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) != 0) goto L72;
        boolean r128 = true;
    L73:
        StringCompanionObject r129 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "AUDIO"}, 3)));
        r114 = r128;
        goto L120
    L72:
        r128 = false;
        goto L73
    L75:
        if (r109.equals("STORAGE") == false) goto L119;
        if (Build.VERSION.SDK_INT < 33) goto L88;
        if (r103.getApplicationInfo().targetSdkVersion < 33) goto L88;
        if (a(r103, BaseConstants.PERMISSION_READ_MEDIA_AUDIO, Process.myPid(), Process.myUid()) != 0) goto L83;
    L93:
        boolean r130 = true;
    L94:
        StringCompanionObject r131 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "STORAGE"}, 3)));
        r114 = r130;
        goto L120
    L83:
        if (a(r103, BaseConstants.PERMISSION_READ_MEDIA_IMAGES, Process.myPid(), Process.myUid()) == 0) goto L93;
        if (a(r103, "android.permission.READ_LOGS", Process.myPid(), Process.myUid()) == 0) goto L93;
    L92:
        r130 = false;
    L88:
        if (a(r103, "android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) goto L93;
        if (a(r103, "android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != 0) goto L92;
    L96:
        if (r109.equals("ACCOUNTS") == false) goto L119;
        if (a(r103, "android.permission.GET_ACCOUNTS", Process.myPid(), Process.myUid()) != 0) goto L100;
        boolean r132 = true;
    L101:
        StringCompanionObject r133 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", "ACCOUNTS"}, 3)));
        r114 = r132;
        goto L120
    L100:
        r132 = false;
        goto L101
    L103:
        if (r109.equals(HTTP.LOCATION) == false) goto L119;
        if (a(r103, "android.permission.ACCESS_COARSE_LOCATION", Process.myPid(), Process.myUid()) != 0) goto L107;
    L110:
        boolean r134 = true;
    L111:
        StringCompanionObject r135 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", HTTP.LOCATION}, 3)));
        r114 = r134;
        goto L120
    L107:
        if (a(r103, "android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) == 0) goto L110;
        r134 = false;
        goto L111
    L113:
        if (r109.equals(AccountType.OTHERS) == false) goto L119;
        if (a(r103, "android.permission.READ_CONTACTS", Process.myPid(), Process.myUid()) != 0) goto L117;
        boolean r136 = true;
    L118:
        StringCompanionObject r137 = StringCompanionObject.INSTANCE;
        r108.put("schema", String.format(this.f272433d, Arrays.copyOf(new Object[]{r103.getApplicationInfo().packageName, "android.settings.APPLICATION_DETAILS_SETTINGS", AccountType.OTHERS}, 3)));
        r114 = r136;
        goto L120
    L117:
        r136 = false;
        goto L118
    L124:
        return r105;
    L126:
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        CompletionBlock.DefaultImpls.onSuccess$default(r102, new j(b(r100, ((gp7.g.b) r101).getAuthorityList())), null, 2, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "get system authority error: " + th, null, 4, null);
    }

    public static int a(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_bytedance_upc_bridge_impl_UpcGetSystemAuthorityStatusMethodIDLImpl_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
