package com.bytedance.kmp.ec.yata.view.render.controller.common;

import android.view.ViewGroup;
import ba6.g;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a<CONTAINER extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.kmp.ec.yata.view.c f251843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CONTAINER f251844c;

    public abstract void c();

    public abstract void d(String r100, g r101, LinkedHashSet<c> r102, Function0<Unit> r103);

    public final CONTAINER a() {
        CONTAINER r100 = this.f251844c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final com.bytedance.kmp.ec.yata.view.c b() {
        com.bytedance.kmp.ec.yata.view.c r100 = this.f251843b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewWrapper");
        return null;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f251842a = r100;
    }
}
