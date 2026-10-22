package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f414568a;

    public interface a {
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {
        public c() {
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getPushDependency().f();
        ChatCoreModule.a().getPushDependency().h();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getPushDependency().k();
        ChatCoreModule.a().getPushDependency().l();
    }

    public e(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "mChatId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f414568a = r101;
        new WeakReference(this.f414568a);
        new c();
        new b();
    }
}
