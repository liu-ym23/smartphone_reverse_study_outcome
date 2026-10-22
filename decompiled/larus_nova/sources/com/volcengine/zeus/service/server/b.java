package com.volcengine.zeus.service.server;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<String, String> f462884a;

    public b() {
        this.f462884a = new a();
    }

    public final void a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (((HashMap) this.f462884a.f462882a).containsKey(r100) == false) goto L13;
        a<String, String> r102 = this.f462884a;
        Object r103 = ((HashMap) r102.f462882a).remove(r100);
        if (r103 == null) goto L13;
        ((HashMap) r102.f462883b).remove(r103);
    L13:
        if (((HashMap) this.f462884a.f462883b).containsKey(r101) == false) goto L17;
        a<String, String> r104 = this.f462884a;
        Object r105 = ((HashMap) r104.f462883b).remove(r101);
        if (r105 == null) goto L17;
        ((HashMap) r104.f462882a).remove(r105);
    L17:
        a<String, String> r106 = this.f462884a;
        if (((HashMap) r106.f462882a).containsKey(r100) == true) goto L26;
        if (((HashMap) r106.f462883b).containsKey(r101) == true) goto L24;
        ((HashMap) r106.f462882a).put(r100, r101);
        ((HashMap) r106.f462883b).put(r101, r100);
        return;
    L24:
        throw new IllegalArgumentException("Value已存在：" + r101);
    L26:
        throw new IllegalArgumentException("Key已存在：" + r100);
    }
}
