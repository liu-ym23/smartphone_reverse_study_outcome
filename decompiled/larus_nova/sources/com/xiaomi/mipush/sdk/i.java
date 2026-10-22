package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.de;
import com.xiaomi.push.ge;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;

/* JADX INFO: loaded from: classes41.dex */
public class i implements de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463069a;

    @Override // com.xiaomi.push.de
    public String a() {
        return b.m8743a(this.f463069a).d();
    }

    public i(Context r100) {
        this.f463069a = r100;
    }

    @Override // com.xiaomi.push.de
    public void a(hd r100, ge r101, gr r102) {
        u.a(this.f463069a).a(r100, r101, r102);
    }
}
