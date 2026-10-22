package com.larus.uaigc.service;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements ky9.a {
    public o() {
    }

    @Override // ky9.a
    public final void a(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @Override // ky9.a
    public final void c(String r100, boolean r101, Message r102) {
        Intrinsics.checkNotNullParameter(r102, "msg");
    }

    @Override // ky9.a
    public final void d(String r100, Message r101, Message r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @Override // ky9.a
    public final void e(Message r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // ky9.a
    public final boolean b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        return false;
    }
}
