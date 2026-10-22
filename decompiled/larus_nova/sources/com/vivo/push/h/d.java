package com.vivo.push.h;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends ab {
    public d(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.p r101 = (com.vivo.push.b.p) r100;
        if (r101 != null) goto L6;
        com.vivo.push.util.t.d("NotifyInnerClientTask", "current onNotifyArrivedCommand is null");
        return;
    L6:
        InsideNotificationItem r102 = r101.g();
        if (r102 != null) goto L10;
        com.vivo.push.util.t.d("NotifyInnerClientTask", "current notification item is null");
        return;
    L10:
        UPSNotificationMessage r103 = com.vivo.push.util.u.a(r102);
        boolean r104 = this.f462510a.getPackageName().equals(r101.e());
        if (r104 == false) goto L13;
        NotifyAdapterUtil.cancelNotify(this.f462510a);
    L13:
        if (r104 == false) goto L59;
        com.vivo.push.b.y r105 = new com.vivo.push.b.y(1030);
        HashMap<String, String> r106 = new HashMap();
        r106.put("type", "2");
        r106.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(r101.f()));
        r106.put("platform", this.f462510a.getPackageName());
        String r107 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r107) == true) goto L17;
        r106.put("remoteAppId", r107);
    L17:
        r105.a(r106);
        com.vivo.push.m.a().a(r105);
        com.vivo.push.util.t.d("NotifyInnerClientTask", "notification is clicked by skip type[" + r103.getSkipType() + "]");
        com.vivo.push.util.t.d("NotifyInnerClientTask", "notification is clicked by skip content[" + r103.getSkipContent() + "]");
    L56:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        if (r103.getSkipType() != 2) goto L31;
        String r108 = r103.getSkipContent();     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r108) == true) goto L27;
        String r109 = r108.toLowerCase();     // Catch: Exception -> L56
        if (r109.startsWith("http://") == false) goto L25;
    L26:
        boolean r110 = true;
    L28:
        if (r110 == true) goto L30;
        return;
    L30:
        Intent r111 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r108));     // Catch: Exception -> L56
        r111.setFlags(268435456);     // Catch: Exception -> L56
    L54:
        r111.putExtras(r101.l());     // Catch: Exception -> L56
        this.f462510a.startActivity(r111);     // Catch: Exception -> L56
        return;
    L25:
        if (r109.startsWith("https://") == true) goto L26;
    L27:
        r110 = false;
        goto L28
    L31:
        r111 = new Intent(r101.h());     // Catch: Exception -> L56
        if (TextUtils.isEmpty(r101.i()) == true) goto L37;
        if (TextUtils.isEmpty(r101.j()) == true) goto L37;
        r111.setComponent(new ComponentName(r101.i(), r101.j()));     // Catch: Exception -> L56
    L37:
        if (r111.getComponent() != null) goto L39;
        String r112 = null;
    L41:
        if (TextUtils.isEmpty(r112) == true) goto L47;
        if (this.f462510a.getPackageName().equals(r112) == true) goto L47;
        com.vivo.push.util.t.a("NotifyInnerClientTask", "inner activity component error : local pkgName is " + this.f462510a.getPackageName() + "; but remote pkgName is " + r112);     // Catch: Exception -> L56
        return;
    L47:
        if (r101.k() == null) goto L49;
        r111.setData(r101.k());     // Catch: Exception -> L56
    L49:
        r111.setSelector(null);     // Catch: Exception -> L56
        r111.setPackage(this.f462510a.getPackageName());     // Catch: Exception -> L56
        r111.addFlags(335544320);     // Catch: Exception -> L56
        ActivityInfo r113 = r111.resolveActivityInfo(this.f462510a.getPackageManager(), 65536);     // Catch: Exception -> L56
        if (r113 == null) goto L54;
        if (r113.exported == true) goto L54;
        com.vivo.push.util.t.d("NotifyInnerClientTask", "activity is not exported : " + r113.toString());     // Catch: Exception -> L56
        goto L54
    L39:
        r112 = r111.getComponent().getPackageName();     // Catch: Exception -> L56
        goto L41
    L59:
        com.vivo.push.util.t.a("NotifyInnerClientTask", "notify is " + r103 + " ; isMatch is " + r104);
    }
}
