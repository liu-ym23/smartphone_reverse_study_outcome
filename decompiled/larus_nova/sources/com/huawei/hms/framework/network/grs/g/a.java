package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected d f277195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f277196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f277197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f277198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f277199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f277200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GrsBaseInfo f277201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.c f277202h;

    public a(String r100, int r101, c r102, Context r103, String r104, GrsBaseInfo r105, com.huawei.hms.framework.network.grs.e.c r106) {
        this.f277196b = r100;
        this.f277197c = r102;
        this.f277198d = r101;
        this.f277199e = r103;
        this.f277200f = r104;
        this.f277201g = r105;
        this.f277202h = r106;
    }

    public Context a() {
        return this.f277199e;
    }

    public c b() {
        return this.f277197c;
    }

    public String c() {
        return this.f277196b;
    }

    public int d() {
        return this.f277198d;
    }

    public String e() {
        return this.f277200f;
    }

    public com.huawei.hms.framework.network.grs.e.c f() {
        return this.f277202h;
    }

    public Callable<d> g() {
        return new f(this.f277196b, this.f277198d, this.f277197c, this.f277199e, this.f277200f, this.f277201g, this.f277202h);
    }
}
