package com.relax.relaxframework;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public KeyframeState f405278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f405279b;

    public t1 c(int r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        return this;
    }

    public c a() {
        return new c(new LinkedHashMap(), this.f405279b);
    }

    public String b() {
        return this.f405279b;
    }

    public t1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f405278a = KeyframeState.Init;
        this.f405279b = "";
        this.f405279b = r100;
    }
}
