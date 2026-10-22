package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f424232a = null;

    static {
        f424232a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.biz.im.api.s0
    public final Integer a(Chat r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Integer.valueOf(r100.getLastThreadPosition());
    }
}
