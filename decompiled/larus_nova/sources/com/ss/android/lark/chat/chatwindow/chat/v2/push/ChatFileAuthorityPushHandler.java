package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatFileAuthorityPushHandler implements c0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.auditsdk.v2.receivecheck.a f414542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<b> f414543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f414544c;

    public static final class a {
    }

    public interface b {
        void onPushFileAuthority(Map<String, ValidateIMFileResult> r100);
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        this.f414542a.a((com.ss.android.lark.auditsdk.v2.receivecheck.a.InterfaceC4761a) this.f414544c.getValue());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        this.f414542a.c((com.ss.android.lark.auditsdk.v2.receivecheck.a.InterfaceC4761a) this.f414544c.getValue());
    }

    public ChatFileAuthorityPushHandler(com.ss.android.lark.auditsdk.v2.receivecheck.a r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "checker");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f414542a = r100;
        this.f414543b = new WeakReference(r101);
        this.f414544c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ChatFileAuthorityPushHandler$observer$2(this));
    }
}
