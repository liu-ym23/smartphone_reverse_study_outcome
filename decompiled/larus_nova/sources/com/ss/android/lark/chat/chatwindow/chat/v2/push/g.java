package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f414581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f414582b;

    public interface a {
        void onPushUploadProgress(String r100, int r101);
    }

    public static final class b implements aqb.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f414583a;

        public b(g r100) {
            this.f414583a = r100;
        }

        @Override // aqb.g
        public final void onPushUploadProgress(String r100, int r101) {
            a r102 = this.f414583a.f414581a.get();
            if (r102 == null) goto L6;
            r102.onPushUploadProgress(r100, r101);
            return;
        }
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        ChatCoreModule.a().getPushDependency().b(this.f414582b);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        ChatCoreModule.a().getPushDependency().d(this.f414582b);
    }

    public g(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f414581a = new WeakReference(r100);
        this.f414582b = new b(this);
    }
}
