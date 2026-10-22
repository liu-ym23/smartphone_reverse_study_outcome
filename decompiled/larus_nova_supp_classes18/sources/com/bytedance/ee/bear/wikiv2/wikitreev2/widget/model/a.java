package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends h {
    public final Throwable d;
    public int e;

    public a(WikiAction r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "err");
        super(r2);
        this.d = r3;
        this.e = MoveSource.FROM_OTHER.getValue();
    }
}
