package com.bytedance.ee.bear.contract.route.parcelable;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public String g;
    public final int h;
    public final String i;
    public final String j;
    public double k;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public int e;
        public String f;
        public String g;
        public int h;
        public String i;
        public double j;

        public a() {
            this.a = "";
            this.b = "";
            this.e = -1;
            this.i = "";
        }
    }

    public m(a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.a = r3.a;
        this.b = r3.b;
        this.d = r3.d;
        this.e = r3.e;
        this.i = r3.i;
        this.j = "";
        this.g = r3.g;
        this.k = r3.j;
        this.h = r3.h;
        this.f = r3.f;
        this.c = r3.c;
    }
}
