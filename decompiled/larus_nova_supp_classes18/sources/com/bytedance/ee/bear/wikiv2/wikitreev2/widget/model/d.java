package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends h {
    public int d;

    public d(WikiAction r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
        this.d = MoveSource.FROM_OTHER.getValue();
    }
}
