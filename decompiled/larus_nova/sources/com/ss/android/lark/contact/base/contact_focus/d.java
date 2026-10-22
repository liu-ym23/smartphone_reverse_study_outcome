package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.sdk.g;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f418567a = null;

    static {
        f418567a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.sdk.f.a
    public final void a() {
        g.e.f439875a.c(Command.PUSH_FOCUS_CHATTER);
    }
}
