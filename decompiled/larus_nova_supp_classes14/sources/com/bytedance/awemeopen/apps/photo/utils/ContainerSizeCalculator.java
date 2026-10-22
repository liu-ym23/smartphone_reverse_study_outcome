package com.bytedance.awemeopen.apps.photo.utils;

import android.content.Context;
import android.util.Size;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ContainerSizeCalculator implements c {
    public final Lazy a;

    public ContainerSizeCalculator() {
        this.a = LazyKt.lazy(new ContainerSizeCalculator$strategy$2(this));
    }

    @Override // com.bytedance.awemeopen.apps.photo.utils.c
    public final Size a(r14.c r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        Intrinsics.checkNotNullParameter(r3, "context");
        Size r4 = ((c) this.a.getValue()).a(r2, r3);
        Objects.toString(r4);
        return r4;
    }
}
