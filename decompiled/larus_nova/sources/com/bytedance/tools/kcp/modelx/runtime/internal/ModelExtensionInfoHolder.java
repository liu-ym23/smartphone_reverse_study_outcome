package com.bytedance.tools.kcp.modelx.runtime.internal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class ModelExtensionInfoHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f270934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f270935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f270936c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/internal/ModelExtensionInfoHolder$CompanionBase;", "", "<init>", "()V", "lib-modelx"}, k = 1, mv = {1, 4, 3})
    public static abstract class CompanionBase {
        public CompanionBase() {
        }

        public abstract ModelExtensionInfoHolder a();

        public final void b() {
            ModelExtensionInfoHolder r100 = a();
            CompositeModelExtensionInfoHolder r101 = ModelExtensionProcessor.f270937a;
            Intrinsics.checkNotNullParameter(r100, "holder");
            if (r100.f270934a.compareAndSet(false, true) == false) goto L14;
            CompositeModelExtensionInfoHolder r102 = ModelExtensionProcessor.f270937a;
            monitor-enter(r102);
            Intrinsics.checkNotNullParameter(r100, "holder");     // Catch: Throwable -> L11
            if (r102.f270933h.contains(r100.getClass()) == true) goto L9;
            r102.f270932g = MapsKt.plus(r102.f270932g, TuplesKt.to(r100.getClass(), r100));     // Catch: Throwable -> L11
        L9:
            monitor-exit(r102);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public abstract Set<Class<?>> a();

    public abstract Set<Class<?>> b();

    public abstract Map<Class<?>, Class<?>> c();

    public abstract Map<Class<?>, List<d>> d();

    public final String toString() {
        return "ModelExtensionInfoHolder(involvedInterfaceTypes=" + b() + ", involvedFlexModelInterfaceTypes=" + a() + ')';
    }

    public ModelExtensionInfoHolder() {
        this.f270934a = new AtomicBoolean(false);
        this.f270935b = LazyKt.lazy(new ModelExtensionInfoHolder$interfaceToImplMap$2(this));
        this.f270936c = LazyKt.lazy(new ModelExtensionInfoHolder$flexModelTypeToInfoListMap$2(this));
    }
}
