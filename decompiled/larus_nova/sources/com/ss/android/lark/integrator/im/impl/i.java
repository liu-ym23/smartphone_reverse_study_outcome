package com.ss.android.lark.integrator.im.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class i implements jza.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jza.c f427979a;

    @Inject
    public i(jza.c r100) {
        Intrinsics.checkNotNullParameter(r100, "internalFileSecurityService");
        this.f427979a = r100;
    }
}
