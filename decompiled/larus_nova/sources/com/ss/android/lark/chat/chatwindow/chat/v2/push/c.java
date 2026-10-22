package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f414555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f414556b;

    public interface a {
        void onBadgeChange(int r100);
    }

    public static final class b implements aqb.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f414557a;

        public b(c r100) {
            this.f414557a = r100;
        }

        @Override // aqb.j
        public final void onBadgeChange(int r100) {
            a r101 = this.f414557a.f414555a.get();
            if (r101 == null) goto L6;
            r101.onBadgeChange(r100);
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getFeedDependency().a(this.f414556b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getFeedDependency().c(this.f414556b);
    }

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f414555a = new WeakReference(r100);
        this.f414556b = new b(this);
    }
}
