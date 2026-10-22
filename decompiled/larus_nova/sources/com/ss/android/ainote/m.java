package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f407128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AINoteScene f407129b;

    public final l a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        l r101 = new l("click", this.f407128a);
        r101.c(this.f407129b);
        Intrinsics.checkNotNullParameter(r100, "click");
        r101.b("click", r100);
        return r101;
    }

    public m(r0 r100, AINoteScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f407128a = r100;
        this.f407129b = r101;
    }
}
