package com.bytedance.ee.bear.more.protocol3;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public abstract class j implements m, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f234897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f234898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f234899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View.OnClickListener f234900d;

    public j() {
    }

    public int c() {
        return -1;
    }

    public abstract boolean e();

    public String b() {
        String r100 = this.f234898b;
        if (r100 != null) goto L18;
        Integer r101 = this.f234899c;
        if (r101 == null) goto L9;
        int r102 = r101.intValue();
        g r103 = this.f234897a;
        if (r103 == null) goto L9;
        String r104 = r103.e(r102);
    L10:
        if (r104 != null) goto L19;
        g r105 = this.f234897a;
        if (r105 == null) goto L14;
        String r106 = r105.e(c());
    L15:
        if (r106 != null) goto L20;
        return "";
    L20:
        return r106;
    L14:
        r106 = null;
        goto L15
    L19:
        return r104;
    L9:
        r104 = null;
        goto L10
    L18:
        return r100;
    }

    public final oj5.c d() {
        g r100 = this.f234897a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public boolean isEnable() {
        return e();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public boolean isVisible() {
        return e();
    }

    public View.OnClickListener a() {
        return this.f234900d;
    }
}
