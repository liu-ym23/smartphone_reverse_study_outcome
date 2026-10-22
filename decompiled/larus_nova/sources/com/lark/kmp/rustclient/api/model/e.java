package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f282473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f282474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f282475c;

    public e(int r100, byte[] r101, Command r102, String r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "originCommand");
        Intrinsics.checkNotNullParameter(r103, "contextId");
        this.f282473a = r100;
        this.f282474b = r101;
        this.f282475c = r104;
    }
}
