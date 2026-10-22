package com.larus.network.http;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f360166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f360167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f360168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f360169d;

    public h() {
        this(false, "", false, "");
    }

    public h(boolean r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "boeEnv");
        Intrinsics.checkNotNullParameter(r103, "ppeEnv");
        this.f360166a = r100;
        this.f360167b = r101;
        this.f360168c = r102;
        this.f360169d = r103;
    }
}
