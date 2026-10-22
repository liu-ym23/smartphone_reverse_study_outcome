package com.heytap.mcssdk.c;

import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class b extends BaseMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f276304a = "&";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f276305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f276306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f276307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f276308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f276309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f276310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f276311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f276312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f276313j;

    public b() {
        this.f276311h = -2;
    }

    public static <T> String a(List<T> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.append(r102.next());
        r101.append("&");
        goto L4
    L7:
        return r101.toString();
    }

    public String a() {
        return this.f276305b;
    }

    public void a(int r100) {
        this.f276309f = r100;
    }

    public void a(String r100) {
        this.f276305b = r100;
    }

    public String b() {
        return this.f276306c;
    }

    public void b(int r100) {
        this.f276311h = r100;
    }

    public void b(String r100) {
        this.f276306c = r100;
    }

    public String c() {
        return this.f276307d;
    }

    public void c(String r100) {
        this.f276307d = r100;
    }

    public String d() {
        return this.f276308e;
    }

    public void d(String r100) {
        this.f276308e = r100;
    }

    public int e() {
        return this.f276309f;
    }

    public void e(String r100) {
        this.f276310g = r100;
    }

    public String f() {
        return this.f276310g;
    }

    public void f(String r100) {
        this.f276313j = r100;
    }

    public int g() {
        return this.f276311h;
    }

    public void g(String r100) {
        this.f276312i = r100;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.f276313j;
    }

    public String i() {
        return this.f276312i;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f276307d + "', mSdkVersion='" + this.f276308e + "', mCommand=" + this.f276309f + "', mContent='" + this.f276310g + "', mAppPackage=" + this.f276312i + "', mResponseCode=" + this.f276311h + ", miniProgramPkg=" + this.f276313j + '}';
    }
}
