package com.ss.android.lark.flow.threadwindow.plugin;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g<T> implements r7b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowThreadWindowMsgTipsPlugin f424281a;

    public g(FlowThreadWindowMsgTipsPlugin r100) {
        this.f424281a = r100;
    }

    @Override // r7b.b
    public final Object get() {
        Chat r100 = this.f424281a.f424253i;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentChat");
        return null;
    L6:
        return r100;
    }
}
