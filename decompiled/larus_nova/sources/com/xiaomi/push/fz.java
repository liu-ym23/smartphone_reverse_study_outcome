package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: loaded from: classes41.dex */
public class fz implements XMPushService.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f463636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f463637b;

    @Override // com.xiaomi.push.service.XMPushService.n
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9117a() {
        a(this.f606a);
        if (this.f463637b == true) goto L5;
        return;
    L5:
        if (a() == false) goto L14;
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
        gd r100 = gc.a(this.f606a).a();
        if (a(r100) == true) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
        return;
    L11:
        f463636a = true;
        ga.a(this.f606a, r100);
        return;
    }

    private boolean a() {
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f606a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) <= this.f605a) goto L5;
        return true;
    L5:
        return false;
    }

    public fz(Context r100) {
        this.f606a = r100;
    }

    private boolean a(gd r100) {
        if (at.m8819a(this.f606a) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(a(this.f606a.getPackageName())) == false) goto L11;
        return false;
    L11:
        if (new PolarisFileWrapper(this.f606a.getFilesDir(), "tiny_data.data").exists() == true) goto L14;
        return false;
    L14:
        if (f463636a == false) goto L17;
        return false;
    L17:
        if (com.xiaomi.push.service.ah.a(this.f606a).a(gj.aV.a(), false) == true) goto L19;
        return true;
    L19:
        if (i.m9285a(this.f606a) == false) goto L21;
        return true;
    L21:
        if (i.m9288b(this.f606a) == true) goto L26;
        return false;
    L26:
        return true;
    }

    private void a(Context r100) {
        this.f463637b = com.xiaomi.push.service.ah.a(r100).a(gj.f463722ak.a(), true);
        int r101 = com.xiaomi.push.service.ah.a(r100).a(gj.f463723al.a(), 7200);
        this.f605a = r101;
        this.f605a = Math.max(60, r101);
    }

    private String a(String r100) {
        if ("com.xiaomi.xmsf".equals(r100) == false) goto L6;
        return "1000271";
    L6:
        return this.f606a.getSharedPreferences("pref_registered_pkg_names", 0).getString(r100, null);
    }

    public static void a(boolean r100) {
        f463636a = r100;
    }
}
