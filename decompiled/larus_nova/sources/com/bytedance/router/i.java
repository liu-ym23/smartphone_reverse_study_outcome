package com.bytedance.router;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.router.listener.error.ErrorType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f267552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f267553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Intent f267554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f267555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f267556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Uri f267557f;

    public final Intent b() {
        if (TextUtils.isEmpty(this.f267553b) == false) goto L7;
        r97.a.b("url is null");
        return null;
    L7:
        if (u97.b.c(this.f267553b) == true) goto L10;
        r97.a.b("url is illegal and url is " + this.f267553b);
        return null;
    L10:
        c r100 = c();
        d r101 = d.a.f267543a;
        Context r102 = this.f267552a;
        if (r101.a(r100) == true) goto L14;
        r97.a.a(ErrorType.PARAMERROR, r100, "参数或者url有误");
        return null;
    L14:
        if (r101.f267540c.b(r102, r100) == false) goto L16;
        r97.a.a(ErrorType.INTERCEPT, r100, "buildIntent时被拦截器拦截");
        return null;
    L16:
        c r103 = r101.c(r100);
        if (r103 != null) goto L19;
        r97.a.a(ErrorType.PARAMERROR, r100, "参数或者url有误");
        return null;
    L19:
        String r104 = r101.f267538a.a(r103.f267529c);
        if (TextUtils.isEmpty(r104) == false) goto L25;
        monitor-enter(r101);
        monitor-exit(r101);
        r97.a.a(ErrorType.NOTFOUND, r100, "当前传入的path找不到目标类");
        return null;
    L25:
        if (TextUtils.isEmpty(r104) == false) goto L27;
        r97.a.a(ErrorType.NOTFOUND, r100, "当前传入的path找不到目标类");
        return null;
    L27:
        r103.f267528b.setComponent(new ComponentName(r102.getPackageName(), r104));
        return r103.f267528b;
    }

    public final c c() {
        Intent r100 = new Intent();
        String r101 = this.f267553b;
        r100.putExtras(this.f267554c);
        r100.addFlags(this.f267554c.getFlags());
        int r102 = this.f267555d;
        int r103 = this.f267556e;
        Uri r104 = this.f267557f;
        c r105 = new c();
        SmartRouter.getRouterIntentAdapter();
        c.c(r100, r101, false);
        r105.f267527a = r101;
        if (r105.f267529c.equals(r101) == true) goto L5;
        r105.f267529c = r105.f267527a;
    L5:
        r105.f267528b = r100;
        r105.f267534h = r102;
        r105.f267535i = r103;
        r105.f267537k = r104;
        r105.a();
        return r105;
    }

    public final void d() {
        if (this.f267552a != null) goto L7;
        r97.a.b("open context is null");
        return;
    L7:
        if (TextUtils.isEmpty(this.f267553b) == false) goto L11;
        r97.a.b("url is null");
        return;
    L11:
        if (u97.b.c(this.f267553b) == true) goto L14;
        r97.a.b("url is illegal and url is" + this.f267553b);
        return;
    L14:
        d.a.f267543a.b(this.f267552a, c());
    }

    public i(Context r100) {
        this.f267553b = "";
        this.f267555d = -1;
        this.f267556e = -1;
        this.f267552a = r100;
        this.f267554c = new Intent();
    }

    public final void a(int r100) {
        this.f267554c.addFlags(r100);
    }

    public final void e(int r100) {
        if (r100 == Integer.MIN_VALUE) goto L23;
        if (this.f267552a != null) goto L9;
        r97.a.b("context is null");
        return;
    L9:
        if (TextUtils.isEmpty(this.f267553b) == false) goto L13;
        r97.a.b("url is null");
        return;
    L13:
        if (u97.b.c(this.f267553b) == true) goto L17;
        r97.a.b("url is illegal and url is " + this.f267553b);
        return;
    L17:
        if ((this.f267552a instanceof Activity) == true) goto L20;
        r97.a.b("you have to provide the Context of activity type for use requestCode");
        return;
    L20:
        c r101 = c();
        r101.f267536j = r100;
        d.a.f267543a.b(this.f267552a, r101);
        return;
    L23:
        throw new IllegalArgumentException("requestCode must not be Integer.MIN_VALUE:-2147483648 !!!");
    }

    public final void f(Intent r100) {
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L6;
        this.f267554c.putExtras(r101);
        return;
    }

    public final void g(Bundle r100) {
        this.f267554c.putExtras(r100);
    }

    public final void h(String r100, int r101) {
        this.f267554c.putExtra(r100, r101);
    }

    public final void i(String r100, Serializable r101) {
        this.f267554c.putExtra(r100, r101);
    }

    public final void j(String r100, String r101) {
        this.f267554c.putExtra(r100, r101);
    }

    public final void k(String r100, boolean r101) {
        this.f267554c.putExtra(r100, r101);
    }
}
