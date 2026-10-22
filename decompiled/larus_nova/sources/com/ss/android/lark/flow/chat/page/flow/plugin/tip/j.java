package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j<T> implements r7b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowMessageTipsPlugin f422895a;

    public j(FlowMessageTipsPlugin r100) {
        this.f422895a = r100;
    }

    @Override // r7b.b
    public final Object get() {
        Chat r100 = this.f422895a.f422863i;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentChat");
        return null;
    L6:
        return r100;
    }
}
