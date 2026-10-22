package com.tencent.open.a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes29.dex */
class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Response f461688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f461690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f461691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f461692e;

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.f461689b != null) goto L11;
        ResponseBody r100 = this.f461688a.body();
        if (r100 == null) goto L8;
        this.f461689b = r100.string();
    L8:
        if (this.f461689b != null) goto L11;
        this.f461689b = "";
    L11:
        return this.f461689b;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.f461689b + this.f461690c + this.f461691d + this.f461692e;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f461692e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f461691d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f461690c;
    }

    public d(Response r100, int r101) {
        this.f461689b = null;
        this.f461688a = r100;
        this.f461691d = r101;
        this.f461690c = r100.code();
        ResponseBody r102 = this.f461688a.body();
        if (r102 == null) goto L5;
        this.f461692e = (int) r102.contentLength();
        return;
    L5:
        this.f461692e = 0;
    }
}
