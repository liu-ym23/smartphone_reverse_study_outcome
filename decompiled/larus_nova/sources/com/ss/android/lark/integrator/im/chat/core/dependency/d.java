package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.chat.core.dependency.ChatSettingDependency;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements ChatSettingDependency {
    public d() {
    }

    @Override // com.ss.android.lark.chat.core.dependency.ChatSettingDependency
    public final void b() {
    }

    @Override // com.ss.android.lark.chat.core.dependency.ChatSettingDependency
    public final void a(aqb.c r100) {
        if (r100 == null) goto L5;
        CopyOnWriteArraySet<aqb.c> r101 = e8b.a.f471416a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        e8b.a.f471416a.add(r100);
        return;
    }

    @Override // com.ss.android.lark.chat.core.dependency.ChatSettingDependency
    public final void c(com.ss.android.lark.chat.chatwindow.chat.v2.push.q.b r100) {
        if (r100 == null) goto L5;
        CopyOnWriteArraySet<aqb.c> r101 = e8b.a.f471416a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        e8b.a.f471416a.remove(r100);
        return;
    }
}
