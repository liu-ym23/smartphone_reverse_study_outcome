package com.google.android.gms.internal.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f274643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f274645c;

    public a() {
        this.f274643a = new Object[4];
        this.f274644b = 0;
    }

    public final void a(Object r100) {
        r100.getClass();
        int r101 = this.f274644b + 1;
        Object[] r102 = this.f274643a;
        int r103 = r102.length;
        if (r103 >= r101) goto L11;
        int r104 = (r103 + (r103 >> 1)) + 1;
        if (r104 >= r101) goto L7;
        int r105 = Integer.highestOneBit(r101 - 1);
        r104 = r105 + r105;
    L7:
        if (r104 >= 0) goto L9;
        r104 = Integer.MAX_VALUE;
    L9:
        this.f274643a = Arrays.copyOf(r102, r104);
        this.f274645c = false;
    L13:
        Object[] r106 = this.f274643a;
        int r107 = this.f274644b;
        this.f274644b = r107 + 1;
        r106[r107] = r100;
        return;
    L11:
        if (this.f274645c == false) goto L13;
        this.f274643a = (Object[]) r102.clone();
        this.f274645c = false;
        goto L13
    }
}
