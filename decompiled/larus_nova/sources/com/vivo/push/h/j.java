package com.vivo.push.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
final class j extends com.vivo.push.s {
    public j(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r110) {
        if (this.f462510a.getPackageName().equals(com.vivo.push.util.aa.a(this.f462510a)) == false) goto L5;
        return;
    L5:
        com.vivo.push.b.j r111 = (com.vivo.push.b.j) r110;
        int r100 = r111.e();
        int r112 = r111.f();
        com.vivo.push.util.t.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + r100 + " ; receiverStatus is " + r112);
        if (r100 != 2) goto L17;
        Context r101 = this.f462510a;
        Intent r102 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        r102.setPackage(r101.getPackageName());
        List<ResolveInfo> r103 = r101.getPackageManager().queryIntentServices(r102, 576);
        if (r103 != null) goto L10;
    L16:
        com.vivo.push.util.t.a("OnChangePushStatusTask", "disableService error: can not find push service.");
    L39:
        if (r112 != 2) goto L57;
        Context r113 = this.f462510a;
        List<ResolveInfo> r104 = a(r113);
        if (r104 != null) goto L43;
    L55:
        com.vivo.push.util.t.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
        return;
    L43:
        if (r104.size() <= 0) goto L55;
        String r105 = ((ResolveInfo) ListProtector.get(r104, 0)).activityInfo.name;
        if (TextUtils.isEmpty(r105) == false) goto L49;
        com.vivo.push.util.t.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
        return;
    L49:
        PackageManager r106 = r113.getPackageManager();
        ComponentName r107 = new ComponentName(r113, r105);
        if (r106.getComponentEnabledSetting(r107) == 2) goto L53;
        r106.setComponentEnabledSetting(r107, 2, 1);
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service disableReceiver ");
        return;
    L53:
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has disableReceiver ");
        return;
    L57:
        if (r112 != 1) goto L75;
        Context r114 = this.f462510a;
        List<ResolveInfo> r108 = a(r114);
        if (r108 != null) goto L61;
    L73:
        com.vivo.push.util.t.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
        return;
    L61:
        if (r108.size() <= 0) goto L73;
        String r109 = ((ResolveInfo) ListProtector.get(r108, 0)).activityInfo.name;
        if (TextUtils.isEmpty(r109) == false) goto L67;
        com.vivo.push.util.t.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
        return;
    L67:
        PackageManager r115 = r114.getPackageManager();
        ComponentName r116 = new ComponentName(r114, r109);
        if (r115.getComponentEnabledSetting(r116) == 1) goto L71;
        r115.setComponentEnabledSetting(r116, 1, 1);
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service enableReceiver ");
        return;
    L71:
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has enableReceiver ");
        return;
    L75:
        if (r112 != 0) goto L92;
        Context r117 = this.f462510a;
        List<ResolveInfo> r118 = a(r117);
        if (r118 != null) goto L79;
    L90:
        com.vivo.push.util.t.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        return;
    L79:
        if (r118.size() <= 0) goto L90;
        String r119 = ((ResolveInfo) ListProtector.get(r118, 0)).activityInfo.name;
        if (TextUtils.isEmpty(r119) == false) goto L85;
        com.vivo.push.util.t.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
        return;
    L85:
        PackageManager r120 = r117.getPackageManager();
        ComponentName r121 = new ComponentName(r117, r119);
        if (r120.getComponentEnabledSetting(r121) == 0) goto L89;
        r120.setComponentEnabledSetting(r121, 0, 1);
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service defaultReceiver ");
        return;
    L89:
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has defaulted");
        return;
    L92:
        return;
    L10:
        if (r103.size() <= 0) goto L16;
        PackageManager r122 = r101.getPackageManager();
        ComponentName r123 = new ComponentName(r101, ((ResolveInfo) ListProtector.get(r103, 0)).serviceInfo.name);
        if (r122.getComponentEnabledSetting(r123) == 2) goto L15;
        r122.setComponentEnabledSetting(r123, 2, 1);
        com.vivo.push.util.t.d("OnChangePushStatusTask", "disableService push service.");
        goto L39
    L15:
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has disabled");
        goto L39
    L17:
        if (r100 != 1) goto L28;
        Context r124 = this.f462510a;
        Intent r125 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        r125.setPackage(r124.getPackageName());
        List<ResolveInfo> r126 = r124.getPackageManager().queryIntentServices(r125, 576);
        if (r126 != null) goto L21;
    L27:
        com.vivo.push.util.t.a("OnChangePushStatusTask", "enableService error: can not find push service.");
        goto L39
    L21:
        if (r126.size() <= 0) goto L27;
        PackageManager r127 = r124.getPackageManager();
        ComponentName r128 = new ComponentName(r124, ((ResolveInfo) ListProtector.get(r126, 0)).serviceInfo.name);
        if (r127.getComponentEnabledSetting(r128) == 1) goto L26;
        r127.setComponentEnabledSetting(r128, 1, 1);
        com.vivo.push.util.t.d("OnChangePushStatusTask", "enableService push service.");
        goto L39
    L26:
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has enabled");
        goto L39
    L28:
        if (r100 != 0) goto L39;
        Context r129 = this.f462510a;
        Intent r130 = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        r130.setPackage(r129.getPackageName());
        List<ResolveInfo> r131 = r129.getPackageManager().queryIntentServices(r130, 576);
        if (r131 != null) goto L32;
    L38:
        com.vivo.push.util.t.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
        goto L39
    L32:
        if (r131.size() <= 0) goto L38;
        PackageManager r132 = r129.getPackageManager();
        ComponentName r133 = new ComponentName(r129, ((ResolveInfo) ListProtector.get(r131, 0)).serviceInfo.name);
        if (r132.getComponentEnabledSetting(r133) == 0) goto L37;
        r132.setComponentEnabledSetting(r133, 0, 1);
        com.vivo.push.util.t.d("OnChangePushStatusTask", "defaultService push service.");
        goto L39
    L37:
        com.vivo.push.util.t.d("OnChangePushStatusTask", "push service has defaulted");
        goto L39
    }

    private static List<ResolveInfo> a(Context r100) {
        Intent r101 = new Intent("com.vivo.pushservice.action.RECEIVE");
        r101.setPackage(r100.getPackageName());
        List<ResolveInfo> r102 = r100.getPackageManager().queryBroadcastReceivers(r101, 576);     // Catch: Exception -> L5
    L6:
        if (r102 != null) goto L8;
    L9:
        Intent r103 = new Intent("com.vivo.pushclient.action.RECEIVE");
        r103.setPackage(r100.getPackageName());
        return r100.getPackageManager().queryBroadcastReceivers(r103, 576);
    L18:
        return r102;
    L8:
        if (r102.size() <= 0) goto L9;
        return r102;
    L5:
        r102 = null;
        goto L6
    }
}
