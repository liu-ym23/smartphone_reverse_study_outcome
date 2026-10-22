package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f241787d;

    public d(WikiAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        super(r100);
        this.f241787d = MoveSource.FROM_OTHER.getValue();
    }
}
