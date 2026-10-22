package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f449767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f449768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f449769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f449770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f449771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f449772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f449773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f449774h;

    public final void a() {
        if (this.f449772f != null) goto L5;
        this.f449772f = com.ss.android.account.k.c();
    L5:
        Context r100 = this.f449772f;
        int r101 = 0;
        SharedPreferences r102 = null;
        if (r100 == null) goto L8;
        SharedPreferences r103 = r100.getSharedPreferences("com_ss_android_token_sp_host", 0);
    L10:
        if (r103 == null) goto L15;
        Set<String> r104 = r103.getStringSet("share_cookie_host_list", null);
        if (r104 == null) goto L15;
        ((CopyOnWriteArraySet) this.f449768b).addAll(r104);
    L15:
        if (this.f449772f != null) goto L17;
        this.f449772f = com.ss.android.account.k.c();
    L17:
        Context r105 = this.f449772f;
        if (r105 == null) goto L20;
        r102 = r105.getSharedPreferences("ss_app_config", 0);
    L20:
        if (r102 == null) goto L38;
        String r106 = r102.getString("share_cookie_host_list", "");
        HashSet r107 = new HashSet();
        if (TextUtils.isEmpty(r106) == true) goto L37;
        String[] r108 = r106.split(",");
        if (r108.length <= 0) goto L37;
        int r109 = r108.length;
    L26:
        if (r101 >= r109) goto L37;
        String r110 = r108[r101];
        if (TextUtils.isEmpty(r110) == true) goto L36;
        if (r110.length() > 1) goto L33;
    L35:
        r107.add(r110);
        goto L36
    L33:
        if (r110.startsWith(".") == false) goto L35;
        r110 = r110.substring(1);
    L36:
        r101 = r101 + 1;
    L37:
        ((CopyOnWriteArraySet) this.f449768b).addAll(r107);
    L38:
        d();
        return;
    L8:
        r103 = null;
        goto L10
    }

    public final Set<String> c() {
        if (this.f449769c == true) goto L16;
        Object r100 = this.f449770d;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f449769c == true) goto L9;
        a();     // Catch: Throwable -> L12
    L9:
        this.f449769c = true;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
    L16:
        return this.f449768b;
    }

    public final void d() {
        if (this.f449772f != null) goto L5;
        this.f449772f = com.ss.android.account.k.c();
    L5:
        Context r100 = this.f449772f;
        if (r100 == null) goto L8;
        SharedPreferences r101 = r100.getSharedPreferences("com_ss_android_token_sp_host", 0);
    L9:
        if (r101 == null) goto L14;
        ((CopyOnWriteArraySet) this.f449768b).remove(null);
        if ((!((CopyOnWriteArraySet) this.f449768b).isEmpty()) == false) goto L15;
        r101.edit().putStringSet("share_cookie_host_list", this.f449768b).apply();
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public n() {
        this.f449768b = new CopyOnWriteArraySet();
        this.f449770d = new Object();
        this.f449771e = false;
        this.f449773g = 600000;
        String r100 = "https://" + com.ss.android.account.k.d().S();
        this.f449767a = r100;
        String r101 = "";
        r101 = new URI(r100).getHost().toLowerCase();     // Catch: Exception -> L7
        Matcher r102 = PatternProtector.compile("[^\\.]+(\\.com|\\.net|\\.org|\\.cc|\\.me|\\.tel|\\.mobi|\\.asia|\\.biz|\\.info|\\.name|\\.tv|\\.app|\\.edu)").matcher(r101);     // Catch: Exception -> L7
        if (r102.find() == false) goto L23;
        String r103 = r102.group();     // Catch: Exception -> L7
    L20:
        if (r103 == null) goto L27;
        this.f449768b.add(r103);
        return;
    L27:
        return;
    L23:
    L17:
        e = move-exception;
        TTTokenMonitor.d(e);
    L19:
        r103 = null;
        goto L20
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        String[] r104 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Exception -> L17
        if (r104 == null) goto L19;
        if (r104.length <= 1) goto L19;
        r103 = r104[r104.length - 2] + "." + r104[r104.length - 1];     // Catch: Exception -> L17
    L7:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L23
    }

    public final void b(Collection<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L18;
        this.f449771e = true;
        ((CopyOnWriteArraySet) this.f449768b).addAll(r100);
        Object r101 = this.f449770d;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f449769c == false) goto L10;
        d();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    }
}
