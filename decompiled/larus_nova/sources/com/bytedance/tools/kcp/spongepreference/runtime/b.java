package com.bytedance.tools.kcp.spongepreference.runtime;

import java.lang.reflect.Type;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f271012a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f271013b = null;

        public a() {
        }

        static {
            f271013b = new a();
        }

        @Override // com.bytedance.tools.kcp.spongepreference.runtime.b
        public final <T> com.bytedance.tools.kcp.spongepreference.runtime.a<T> a(String r100, T r101, Type r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "type");
            throw new NotImplementedError("SpongePreference sdk is not initialized.");
        }
    }

    static {
        f271012a = a.f271013b;
    }

    <T> com.bytedance.tools.kcp.spongepreference.runtime.a<T> a(String r100, T r101, Type r102);
}
