package com.larus.init.task;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 implements pd6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f351462a = null;

    static {
        f351462a = new v0();
    }

    public v0() {
    }

    @Override // pd6.b
    public final <T extends pd6.a> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return (T) ServiceManager.get().getService(JvmClassMappingKt.getJavaClass(r100));
    }

    @Override // pd6.b
    public final <T extends pd6.a> List<T> b(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return CollectionsKt.toList(ServiceManager.get().getServices(JvmClassMappingKt.getJavaClass(r100), true));
    }

    @Override // pd6.b
    public final <T extends pd6.a> void c(KClass<T> r100, final T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "impl");
        ServiceManager.get().bind(JvmClassMappingKt.getJavaClass(r100), new u0(r101));
    }
}
