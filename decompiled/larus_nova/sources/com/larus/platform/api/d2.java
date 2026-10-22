package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public interface d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365089a = null;

    public static final class a implements d2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f365090b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<d2> f365091c = null;

        public a() {
        }

        static {
            f365090b = new a();
            f365091c = LazyKt.lazy(new c2());
        }

        @Override // com.larus.platform.api.d2
        public final Integer a() {
            d2 r100 = f365091c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.a();
        }
    }

    static {
        f365089a = a.f365090b;
    }

    Integer a();
}
