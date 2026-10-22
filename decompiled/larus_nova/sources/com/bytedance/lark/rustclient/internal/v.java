package com.bytedance.lark.rustclient.internal;

import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Deprecated(message = "delete when Rust SDK refactoring's FG 100%")
public final class v extends WaitConditionInterceptor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f254029d;

    public static final class a implements se6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f254030a;

        public a(v r100) {
            this.f254030a = r100;
        }

        @Override // se6.e
        public final void a(boolean r100) {
            v r101 = this.f254030a;
            if (r100 == true) goto L5;
            r101.d();
            return;
        L5:
            r101.getClass();
        }
    }

    public v(n r100) {
        Intrinsics.checkNotNullParameter(r100, "rustSDK");
        this.f254029d = r100;
        r100.n(new a(this));
    }

    @Override // com.bytedance.lark.rustclient.internal.WaitConditionInterceptor
    public final <T> boolean c(com.bytedance.lark.rustclient.api.b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return !this.f254029d.g();
    }
}
