package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.sdk.refactor.SDKInitStrategy;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Deprecated(message = "delete when Rust SDK refactoring's FG 100%")
public final class s extends WaitConditionInterceptor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f254015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.lark.sdk.refactor.o f254016e;

    public static final class a implements se6.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f254017a;

        @Override // se6.d
        public final void onInit() {
            this.f254017a.d();
        }

        public a(s r100) {
            this.f254017a = r100;
        }
    }

    @Override // com.bytedance.lark.rustclient.internal.WaitConditionInterceptor
    public final <T> boolean c(com.bytedance.lark.rustclient.api.b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        if (this.f254016e.b() != SDKInitStrategy.SYNC) goto L6;
        return true;
    L6:
        if (this.f254016e.e(r100.f253903a.a().getValue()) == false) goto L9;
        return true;
    L9:
        return this.f254015d.hasInit();
    }

    public s(n r100, com.bytedance.lark.sdk.refactor.o r101) {
        Intrinsics.checkNotNullParameter(r100, "rustSDK");
        Intrinsics.checkNotNullParameter(r101, "definition");
        this.f254015d = r100;
        this.f254016e = r101;
        r100.x(new a(this));
    }
}
