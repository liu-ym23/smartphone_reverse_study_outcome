package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f278237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Character f278238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Character f278239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f278240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f278241e;

    public boolean a() {
        if (this.f278238b == null) goto L5;
        return true;
    L5:
        String r100 = this.f278237a;
        if (r100 != null) goto L9;
        return false;
    L9:
        if (r100.length() != 0) goto L12;
        return false;
    L12:
        if (this.f278240d < this.f278237a.length()) goto L14;
        return false;
    L14:
        return true;
    }

    public void c() {
        this.f278239c = this.f278238b;
        this.f278241e = this.f278240d;
    }

    public Character d() {
        Character r100 = this.f278238b;
        if (r100 == null) goto L6;
        this.f278238b = null;
        return r100;
    L6:
        String r101 = this.f278237a;
        if (r101 != null) goto L10;
        return null;
    L10:
        if (r101.length() != 0) goto L13;
        return null;
    L13:
        if (this.f278240d < this.f278237a.length()) goto L15;
        return null;
    L15:
        String r102 = this.f278237a;
        int r103 = this.f278240d;
        this.f278240d = r103 + 1;
        return Character.valueOf(r102.charAt(r103));
    }

    public Character g() {
        Character r100 = this.f278238b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = this.f278237a;
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.length() != 0) goto L12;
        return null;
    L12:
        if (this.f278240d < this.f278237a.length()) goto L15;
        return null;
    L15:
        return Character.valueOf(this.f278237a.charAt(this.f278240d));
    }

    public String h() {
        String r100 = this.f278237a.substring(this.f278240d);
        if (this.f278238b != null) goto L5;
        return r100;
    L5:
        return this.f278238b + r100;
    }

    public void i() {
        this.f278238b = this.f278239c;
        this.f278240d = this.f278241e;
    }

    public Character e() {
        Character r100 = d();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (b(r100) == false) goto L8;
        return r100;
    L8:
        return null;
    }

    public Character f() {
        Character r100 = d();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (c(r100) == false) goto L8;
        return r100;
    L8:
        return null;
    }

    public int b() {
        return this.f278240d;
    }

    public a(String r100) {
        this.f278240d = 0;
        this.f278241e = 0;
        this.f278237a = r100;
    }

    public static boolean b(Character r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        char r101 = r100.charValue();
        if (r101 < '0') goto L10;
        if (r101 > '9') goto L10;
    L17:
        return true;
    L10:
        if (r101 < 'a') goto L14;
        if (r101 <= 'f') goto L17;
    L14:
        if (r101 >= 'A') goto L16;
        return false;
    L16:
        if (r101 <= 'F') goto L17;
        return false;
    }

    public static boolean c(Character r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        char r101 = r100.charValue();
        if (r101 >= '0') goto L8;
        return false;
    L8:
        if (r101 > '7') goto L12;
        return true;
    L12:
        return false;
    }

    public boolean a(char r100) {
        Character r101 = this.f278238b;
        if (r101 != null) goto L5;
    L7:
        String r102 = this.f278237a;
        if (r102 != null) goto L11;
        return false;
    L11:
        if (r102.length() != 0) goto L14;
        return false;
    L14:
        if (this.f278240d < this.f278237a.length()) goto L17;
        return false;
    L17:
        if (this.f278237a.charAt(this.f278240d) == r100) goto L21;
        return false;
    L21:
        return true;
    L5:
        if (r101.charValue() != r100) goto L7;
        return true;
    }

    public void a(Character r100) {
        this.f278238b = r100;
    }
}
