package com.bytedance.webx.seclink.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f272626a;

    public final void a() {
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f272626a.f272633f != null) goto L8;
        Context r100 = cr7.a.getContext();     // Catch: Exception -> L15
        if (r100 == null) goto L8;
        c r101 = this.f272626a;     // Catch: Exception -> L15
        r101.f272633f = r100.getSharedPreferences("sec_link_config", 0);     // Catch: Exception -> L15
    L8:
        SharedPreferences r102 = this.f272626a.f272633f;     // Catch: Exception -> L15
        if (r102 == null) goto L20;
        String r103 = r102.getString("setting_config", "");     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r103) == true) goto L13;
        c r104 = this.f272626a;     // Catch: Exception -> L15
        r104.f272635h = ir7.a.a(r103);     // Catch: Exception -> L15
        c r105 = this.f272626a;     // Catch: Exception -> L15
        r105.h(r105.f272635h);     // Catch: Exception -> L15
    L13:
        String r106 = this.f272626a.f272633f.getString("setting_host_index", "0");     // Catch: Exception -> L15
        String r107 = this.f272626a.f272633f.getString("verify_host_index", "0");     // Catch: Exception -> L15
        c r108 = this.f272626a;     // Catch: Exception -> L15
        r108.f272630c = CastIntegerProtector.parseInt(r106);     // Catch: Exception -> L15
        c r109 = this.f272626a;     // Catch: Exception -> L15
        r109.f272631d = CastIntegerProtector.parseInt(r107);     // Catch: Exception -> L15
        c.a(this.f272626a);     // Catch: Exception -> L15
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100) {
        this.f272626a = r100;
    }
}
