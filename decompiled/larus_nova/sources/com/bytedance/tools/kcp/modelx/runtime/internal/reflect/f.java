package com.bytedance.tools.kcp.modelx.runtime.internal.reflect;

import java.lang.reflect.Method;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public interface f {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pair f270990a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f270991b = null;

        public a() {
        }

        static {
            f270991b = new a();
            f270990a = TuplesKt.to(Boolean.FALSE, null);
        }

        @Override // com.bytedance.tools.kcp.modelx.runtime.internal.reflect.f
        public final Pair<Boolean, Object> a(com.bytedance.tools.kcp.modelx.runtime.internal.reflect.a r100, Object r101, Method r102, Object[] r103) {
            Intrinsics.checkNotNullParameter(r100, "$this$maybeInvoke");
            Intrinsics.checkNotNullParameter(r101, "proxy");
            Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
            return f270990a;
        }
    }

    Pair<Boolean, Object> a(com.bytedance.tools.kcp.modelx.runtime.internal.reflect.a r100, Object r101, Method r102, Object[] r103);
}
