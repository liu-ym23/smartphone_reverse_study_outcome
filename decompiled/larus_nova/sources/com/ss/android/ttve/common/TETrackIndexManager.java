package com.ss.android.ttve.common;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class TETrackIndexManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f449832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f449833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f449834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f449835d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TETrackType {
    }

    public final void d() {
        this.f449832a = -1;
        this.f449833b = -1;
        ((ArrayList) this.f449834c).clear();
        ((ArrayList) this.f449835d).clear();
    }

    public TETrackIndexManager() {
        this.f449832a = -1;
        this.f449833b = -1;
        this.f449834c = new ArrayList();
        this.f449835d = new ArrayList();
    }

    public final int a(int r100, int r101) {
        if (r101 >= 0) goto L5;
        return r101;
    L5:
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L10;
        return r101;
    L10:
        if (this.f449833b != (-1)) goto L13;
        this.f449833b = r101;
    L13:
        if (((ArrayList) this.f449835d).size() <= 0) goto L15;
        List<Integer> r102 = this.f449835d;
        r101 = ((Integer) ListProtector.get(r102, ((ArrayList) r102).size() - 1)).intValue() + 1;
    L15:
        List<Integer> r103 = this.f449835d;
        ArrayList r104 = (ArrayList) r103;
        r104.add(Integer.valueOf(r101));
        return r101;
    L18:
        if (this.f449832a != (-1)) goto L21;
        this.f449832a = r101;
    L21:
        if (((ArrayList) this.f449834c).size() <= 0) goto L23;
        List<Integer> r105 = this.f449834c;
        r101 = ((Integer) ListProtector.get(r105, ((ArrayList) r105).size() - 1)).intValue() + 1;
    L23:
        List<Integer> r106 = this.f449834c;
        ArrayList r107 = (ArrayList) r106;
        r107.add(Integer.valueOf(r101));
        return r101;
    }

    public final int b(int r100, int r101) {
        int r102 = 0;
        if (r100 != 1) goto L5;
        int r103 = this.f449832a;
        if (r101 < r103) goto L30;
        if (r103 == (-1)) goto L30;
    L25:
        if (r102 >= ((ArrayList) this.f449834c).size()) goto L30;
        if (r101 == ((Integer) ListProtector.get(this.f449834c, r102)).intValue()) goto L28;
        r102 = r102 + 1;
        goto L25
    L28:
        int r104 = this.f449832a;
    L17:
        return r102 + r104;
    L30:
        return r101;
    L5:
        if (r100 != 2) goto L30;
        int r105 = this.f449833b;
        if (r101 < r105) goto L19;
        if (r105 == (-1)) goto L19;
    L12:
        if (r102 >= ((ArrayList) this.f449835d).size()) goto L30;
        if (r101 == ((Integer) ListProtector.get(this.f449835d, r102)).intValue()) goto L15;
        r102 = r102 + 1;
        goto L12
    L15:
        r104 = this.f449833b;
    L19:
        return r101;
    }

    public final void c(int r100, int r101) {
        if (r100 != 1) goto L5;
        List<Integer> r102 = this.f449834c;
        ArrayList r103 = (ArrayList) r102;
        r103.remove(Integer.valueOf(r101));
        return;
    L5:
        if (r100 == 2) goto L7;
        return;
    L7:
        List<Integer> r104 = this.f449835d;
        ArrayList r105 = (ArrayList) r104;
        r105.remove(Integer.valueOf(r101));
    }
}
