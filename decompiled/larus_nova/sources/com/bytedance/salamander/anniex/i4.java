package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f268114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f268115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f268116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f268117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f268118e;

    public final String getType() {
        return this.f268115b;
    }

    public i4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter("success", "type");
        this.f268114a = "";
        this.f268115b = "";
        this.f268117d = "error";
        this.f268114a = r100;
        this.f268115b = "success";
        this.f268116c = null;
        this.f268117d = null;
        this.f268118e = null;
    }
}
