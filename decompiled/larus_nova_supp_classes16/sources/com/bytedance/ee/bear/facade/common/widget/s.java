package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class s {
    public final Context a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;

        public a() {
        }
    }

    public String a() {
        return this.a.getString(this.f);
    }

    public String b() {
        String r0 = this.a.getString(2131887269);
        return xo5.a.c(this.a, this.e, "customer_service", r0);
    }

    public String c() {
        String r0 = this.a.getString(2131894314);
        return xo5.a.c(this.a, this.d, "submit_appeal", r0);
    }

    public String d() {
        return this.a.getString(this.c);
    }

    public String e() {
        String r0 = this.a.getString(2131894314);
        return xo5.a.c(this.a, this.b, "submit_appeal", r0);
    }

    public s(Context r2) {
        this.b = 2131887429;
        this.c = 2131887550;
        this.d = 2131887542;
        this.e = 2131887268;
        this.f = 2131887270;
        this.a = r2;
    }

    public s(Context r2, a r3) {
        this.b = 2131887429;
        this.c = 2131887550;
        this.d = 2131887542;
        this.e = 2131887268;
        this.f = 2131887270;
        this.a = r2;
        this.e = r3.d;
        this.f = r3.e;
        this.b = r3.a;
        this.c = r3.b;
        this.d = r3.c;
    }
}
