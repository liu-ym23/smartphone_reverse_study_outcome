package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.q0;
import com.ss.android.lark.biz.im.api.r0;
import com.ss.android.lark.chat.entity.chat.Chat;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f424233a = null;

    static {
        f424233a = new e();
    }

    public e() {
    }

    @Override // com.ss.android.lark.biz.im.api.r0
    public final q0 a(Chat r100) {
        return new q0(r100.getThreadUnReadBadgeCount(), r100.getReadThreadPosition());
    }
}
