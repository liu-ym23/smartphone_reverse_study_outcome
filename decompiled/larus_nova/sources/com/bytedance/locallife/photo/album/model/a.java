package com.bytedance.locallife.photo.album.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestStatus f261971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f261972b;

    public a(RequestStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f261971a = r100;
        this.f261972b = r101;
    }

    public /* synthetic */ a(String r100, RequestStatus r101) {
        this(r101, "");
    }
}
