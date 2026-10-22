package com.bytedance.ies.tools.prefetch;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f248811a = null;

    static {
        f248811a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(e.class), "cacheShared", "getCacheShared()Landroid/content/SharedPreferences;"))};
    }

    public static void c() {
        KProperty r100 = f248811a[0];
        throw null;
    }

    @Override // com.bytedance.ies.tools.prefetch.h
    public final Collection b() {
        c();
        throw null;
    }

    @Override // com.bytedance.ies.tools.prefetch.h
    public final void removeAll() {
        c();
        throw null;
    }

    @Override // com.bytedance.ies.tools.prefetch.h
    public final void a(Collection r100) {
        if ((r100 instanceof Set) == true) goto L5;
        return;
    L5:
        c();
        throw null;
    }

    @Override // com.bytedance.ies.tools.prefetch.h
    public final String getString(String r100) {
        c();
        throw null;
    }

    @Override // com.bytedance.ies.tools.prefetch.h
    public final void remove(String r100) {
        c();
        throw null;
    }

    @Override // com.bytedance.ies.tools.prefetch.h
    public final void putString(String r100, String r101) {
        c();
        throw null;
    }
}
