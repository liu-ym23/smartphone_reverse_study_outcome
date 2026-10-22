package com.bytedance.caijing.sdk.infra.base.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f202346a;

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "evtName");
        Intrinsics.checkNotNullParameter(r101, "actionHash");
        this.f202346a = r101;
    }
}
