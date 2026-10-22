package com.ivy.ivykit.plugin.impl.web;

import android.net.Uri;
import b36.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements ix7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b36.b f278484a;

    @Override // ix7.a
    public final void a() {
        this.f278484a.a();
    }

    @Override // ix7.a
    public final Uri getOrigin() {
        return this.f278484a.getOrigin();
    }

    @Override // ix7.a
    public String[] getResources() {
        return this.f278484a.getResources();
    }

    public b(m r100) {
        this.f278484a = r100;
    }

    @Override // ix7.a
    public final void b(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "resources");
        this.f278484a.b(r100);
    }
}
