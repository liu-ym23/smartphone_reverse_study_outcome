package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365250a = null;

    public static final class a implements r3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f365251b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<r3> f365252c = null;

        public a() {
        }

        static {
            f365251b = new a();
            f365252c = LazyKt.lazy(new q3());
        }

        @Override // com.larus.platform.api.r3
        public final b a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            r3 r101 = f365252c.getValue();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.a(r100);
        }
    }

    public interface b {
        void end();

        void start();
    }

    static {
        f365250a = a.f365251b;
    }

    b a(String r100);
}
