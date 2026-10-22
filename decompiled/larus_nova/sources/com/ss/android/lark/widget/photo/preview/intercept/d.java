package com.ss.android.lark.widget.photo.preview.intercept;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements a.InterfaceC5410a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f446731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f446732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f446733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f446734d;

    @Override // com.ss.android.lark.widget.photo.preview.intercept.a.InterfaceC5410a
    public final Object a(b r100, Continuation<? super c> r101) {
        int r102 = this.f446733c;
        if (r102 <= 0) goto L13;
        a r103 = (a) ListProtector.get(this.f446732b, r102 - 1);
        if (this.f446731a.getContext() != r100.getContext()) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L13;
        throw new IllegalStateException(("Interceptor '" + r103 + "' cannot modify the request's context.").toString());
    L7:
        r104 = false;
    L13:
        return ((a) ListProtector.get(this.f446732b, this.f446733c)).a(new d(this.f446731a, this.f446732b, this.f446733c + 1, r100), r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(b r100, List<? extends a> r101, int r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "initialRequest");
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        Intrinsics.checkNotNullParameter(r103, "request");
        this.f446731a = r100;
        this.f446732b = r101;
        this.f446733c = r102;
        this.f446734d = r103;
    }
}
