package com.bytedance.caijing.sdk.infra.base.task;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC2943a f202765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f202766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<T> f202767c;

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.task.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC2943a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f202768a;

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.task.a$a$a, reason: collision with other inner class name */
        public static final class C2944a extends AbstractC2943a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C2944a f202769b = null;

            static {
                f202769b = new C2944a();
            }

            public C2944a() {
            }
        }

        public AbstractC2943a() {
            this.f202768a = 10000;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Object r100, Function0 r101) {
        AbstractC2943a.C2944a r102 = AbstractC2943a.C2944a.f202769b;
        Intrinsics.checkNotNullParameter("getDeviceScore", "name");
        Intrinsics.checkNotNullParameter(r102, "priority");
        Intrinsics.checkNotNullParameter(r101, "block");
        this.f202765a = r102;
        this.f202766b = r100;
        this.f202767c = r101;
    }
}
