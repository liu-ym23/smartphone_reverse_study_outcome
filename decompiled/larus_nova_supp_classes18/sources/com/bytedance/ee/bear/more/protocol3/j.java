package com.bytedance.ee.bear.more.protocol3;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class j implements m, a {
    public g a;
    public String b;
    public Integer c;
    public View.OnClickListener d;

    public j() {
    }

    public int c() {
        return -1;
    }

    public abstract boolean e();

    public String b() {
        String r0 = this.b;
        if (r0 != null) goto L18;
        Integer r1 = this.c;
        if (r1 == null) goto L9;
        int r2 = r1.intValue();
        g r3 = this.a;
        if (r3 == null) goto L9;
        String r4 = r3.e(r2);
    L10:
        if (r4 != null) goto L19;
        g r5 = this.a;
        if (r5 == null) goto L14;
        String r6 = r5.e(c());
    L15:
        if (r6 != null) goto L20;
        return "";
    L20:
        return r6;
    L14:
        r6 = null;
        goto L15
    L19:
        return r4;
    L9:
        r4 = null;
        goto L10
    L18:
        return r0;
    }

    public final oj5.c d() {
        g r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public boolean isEnable() {
        return e();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public boolean isVisible() {
        return e();
    }

    public View.OnClickListener a() {
        return this.d;
    }
}
