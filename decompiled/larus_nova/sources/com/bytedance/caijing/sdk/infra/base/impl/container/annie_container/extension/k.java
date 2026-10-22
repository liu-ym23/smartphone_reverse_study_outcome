package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class k implements cd4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<cd4.j> f202420a;

    @Override // cd4.m
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // cd4.m
    public final String getName() {
        return "close";
    }

    @Override // cd4.m
    public final <T> void putDependency(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // cd4.m
    public final void release() {
    }

    public k(Ref.ObjectRef<cd4.j> r100) {
        this.f202420a = r100;
    }

    @Override // cd4.m
    public final void handle(Context r100, JSONObject r101, cd4.k r102) {
        Intrinsics.checkNotNullParameter(r101, "params");
        cd4.j r103 = this.f202420a.element;
        if (r103 == null) goto L6;
        r103.destroy();
        return;
    }
}
