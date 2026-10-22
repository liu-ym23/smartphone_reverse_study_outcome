package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.utils.StreamUtils;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o<T> implements l47.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<n.d> f266210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266211b;

    public o(m47.h r100, m47.i r101) {
        this.f266210a = r100;
        this.f266211b = r101;
    }

    @Override // l47.a
    public final void accept(Object r100) {
        i47.e r101 = (i47.e) r100;
        if ((r101.getData() instanceof q47.c) == false) goto L5;
        l47.a<n.d> r102 = this.f266210a;
        InputStream r103 = r101.getData();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.pia.core.misc.CopyableInputStream");
        r102.accept(new n.d(StreamUtils.b(((q47.c) r103).a(), "")));
        return;
    L5:
        this.f266211b.accept(new PiaMethod.Error("stream in not a CopyableInputStream"));
    }
}
