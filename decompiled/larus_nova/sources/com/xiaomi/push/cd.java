package com.xiaomi.push;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes41.dex */
public final class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f306a;

    public String toString() {
        if (this.f463240a <= 0) goto L7;
        return this.f306a + ":" + this.f463240a;
    L7:
        return this.f306a;
    }

    public int a() {
        return this.f463240a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8894a() {
        return this.f306a;
    }

    public cd(String r100, int r101) {
        this.f306a = r100;
        this.f463240a = r101;
    }

    public static cd a(String r100, int r101) {
        int r102 = r100.lastIndexOf(":");
        if (r102 == (-1)) goto L11;
        String r103 = r100.substring(0, r102);
        int r104 = CastIntegerProtector.parseInt(r100.substring(r102 + 1));     // Catch: NumberFormatException -> L12
        if (r104 <= 0) goto L9;
        r101 = r104;
    L9:
        r100 = r103;
    L11:
        return new cd(r100, r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m8893a(String r100, int r101) {
        cd r102 = a(r100, r101);
        return new InetSocketAddress(r102.m8894a(), r102.a());
    }
}
