package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class q implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<a> f414656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f414657c;

    public interface a {
        void onQuitGroup(boolean r100);

        void updateDissolveGroupLocalFlag(boolean r100);
    }

    public static final class b implements aqb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f414658a;

        public b(q r100) {
            this.f414658a = r100;
        }

        @Override // aqb.c
        public final void a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            if (Intrinsics.areEqual(this.f414658a.f414655a, r100) == false) goto L8;
            a r102 = this.f414658a.f414656b.get();
            if (r102 == null) goto L9;
            r102.onQuitGroup(r101);
            return;
        L9:
            return;
        }

        @Override // aqb.c
        public final void b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            if (Intrinsics.areEqual(this.f414658a.f414655a, r100) == false) goto L8;
            a r102 = this.f414658a.f414656b.get();
            if (r102 == null) goto L9;
            r102.updateDissolveGroupLocalFlag(r101);
            return;
        L9:
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getChatSettingDependency().a(this.f414657c);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getChatSettingDependency().c(this.f414657c);
    }

    public q(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "mChatId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f414655a = r100;
        this.f414656b = new WeakReference(r101);
        this.f414657c = new b(this);
    }
}
