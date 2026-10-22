package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements com.bytedance.ug.sdk.luckycat.utils.j.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f271323f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ug.sdk.luckycat.utils.j f271324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f271325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<List<a>> f271326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f271327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f271328e;

    public interface a {
    }

    static {
        f271323f = new j();
    }

    public static boolean a() {
        com.bytedance.ug.sdk.luckycat.api.depend.c r100 = m.a.f271349a.f271335c;
        if (r100 == null) goto L5;
        String r101 = r100.getUserId();
    L6:
        String r102 = String.valueOf(r101);
        if (TextUtils.isEmpty(r102) == false) goto L11;
        return false;
    L11:
        return r102.equals(com.bytedance.ug.sdk.luckycat.impl.utils.u.a().c("polaris_pre_active_user", ""));
    L5:
        r101 = "";
        goto L6
    }

    public final void b() {
        if (m.a.f271349a.f271333a != null) goto L5;
        return;
    L5:
        i r100 = i.a.f271322a;
        String r101 = "false";
        String r102 = r100.b("is_tab_stop_prize", "false");
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r101 = r102;
    L9:
        boolean r103 = true;
        if (Boolean.getBoolean(r101) == false) goto L12;
        int r104 = 14;
        String r105 = r100.b("new_user_active_days", "");     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r105) == true) goto L20;
        r104 = CastIntegerProtector.valueOf(r105).intValue();     // Catch: Throwable -> L43
    L20:
        int r106 = 7;
        String r107 = r100.b("tab_no_active_days", "");     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r107) == true) goto L25;
        r106 = CastIntegerProtector.valueOf(r107).intValue();     // Catch: Throwable -> L44
    L25:
        long r108 = System.currentTimeMillis();
        if ((r108 - this.f271328e) <= (((long) r104) * 86400000)) goto L28;
        com.bytedance.ug.sdk.luckycat.impl.utils.u r109 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a();
        r109.e("polaris_pre_active");
        long r110 = 0;
        long r111 = r109.f271527a.getLong("polaris_pre_active", 0);
        if (a() == false) goto L36;
        r110 = r111;
    L36:
        if ((r108 - r110) <= (((long) r106) * 86400000)) goto L40;
        r103 = false;
    L40:
        if (this.f271327d == r103) goto L51;
        this.f271327d = r103;
        this.f271324a.sendEmptyMessage(0);
        return;
    L51:
        return;
    L28:
        if (this.f271327d == true) goto L50;
        this.f271327d = true;
        this.f271324a.sendEmptyMessage(0);
        return;
    L50:
        return;
    L12:
        if (this.f271327d == true) goto L49;
        this.f271327d = true;
        this.f271324a.sendEmptyMessage(0);
        return;
    }

    public j() {
        this.f271324a = new com.bytedance.ug.sdk.luckycat.utils.j(Looper.getMainLooper(), this);
        this.f271325b = new ArrayList();
        this.f271326c = new WeakReference(this.f271325b);
        this.f271327d = true;
        this.f271328e = 0;
        if (m.a.f271349a.f271333a == null) goto L8;
        com.bytedance.ug.sdk.luckycat.impl.utils.u r100 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a();
        r100.e("enable_polaris_active_status_time");
        long r101 = r100.f271527a.getLong("enable_polaris_active_status_time", 0);
        this.f271328e = r101;
        if (r101 > 0) goto L8;
        this.f271328e = System.currentTimeMillis();
        com.bytedance.ug.sdk.luckycat.impl.utils.u r102 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a();
        long r103 = this.f271328e;
        r102.e("enable_polaris_active_status_time");
        SharedPreferences.Editor r104 = r102.f271527a.edit();
        r104.putLong("enable_polaris_active_status_time", r103);
        r104.apply();
    L8:
        b();
    }

    @Override // com.bytedance.ug.sdk.luckycat.utils.j.a
    public final void handleMsg(Message r100) {
        if (r100.what != 0) goto L16;
        WeakReference<List<a>> r101 = this.f271326c;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.get() != null) goto L9;
        return;
    L9:
        if (this.f271326c.get().size() == 0) goto L22;
        Iterator<a> r102 = this.f271326c.get().iterator();
    L13:
        if (r102.hasNext() == false) goto L23;
        if (r102.next() != null) goto L13;
        return;
    L23:
        return;
    L22:
        return;
    }
}
