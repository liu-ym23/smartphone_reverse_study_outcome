package com.ss.android.lark.chat.preview.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f416309a = null;

    static {
        f416309a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.f.a
    public final void a() {
        g.e.f439875a.c(Command.PUSH_PREVIEWS);
    }
}
