package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public interface z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f365314a = null;

    public static final class a implements z1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f365315b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<z1> f365316c = null;

        public a() {
        }

        static {
            f365315b = new a();
            f365316c = LazyKt.lazy(new y1());
        }

        @Override // com.larus.platform.api.z1
        public final boolean isLogin() {
            z1 r100 = f365316c.getValue();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.isLogin();
        }
    }

    static {
        f365314a = a.f365315b;
    }

    boolean isLogin();
}
