package com.bytedance.helios.sdk.detector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class ApiConfig {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f245511e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f245512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f245513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f245514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245515d;

    /* JADX INFO: loaded from: classes19.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ApiType {
    }

    public ApiConfig() {
        throw null;
    }

    public final String toString() {
        return "ApiConfig{id=" + this.f245512a + ", type=" + f245511e[this.f245513b] + ", actionId=" + this.f245514c + com.alipay.sdk.m.u.i.f25855d;
    }

    static {
        f245511e = new String[]{"start", "end", "sensitive", "tag"};
    }

    public ApiConfig(String r100, String r101, int r102, int r103) {
        this.f245512a = r100;
        this.f245515d = r101;
        this.f245513b = r103;
        this.f245514c = r102;
    }
}
