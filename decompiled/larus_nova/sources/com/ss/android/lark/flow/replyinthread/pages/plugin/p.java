package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f424061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReplyInThreadTitleBarPlugin f424062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f424063c;

    public p(String r100, ReplyInThreadTitleBarPlugin r101, int r102) {
        this.f424061a = r100;
        this.f424062b = r101;
        this.f424063c = r102;
    }

    public final void a() {
        String r100 = this.f424061a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r102 = null;
        if (r101 == false) goto L15;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r103 = this.f424062b.f424007g;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L13:
        Context r104 = r102.getContext();
        String r105 = this.f424061a;
        Intrinsics.checkNotNull(r105);
        FlowToast.d(r104, r105);
        return;
    L12:
        r102 = r103;
        goto L13
    L15:
        if (this.f424063c == 0) goto L23;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r106 = this.f424062b.f424007g;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L20:
        FlowToast.c(r102.getContext(), this.f424063c);
        return;
    L19:
        r102 = r106;
        goto L20
    L23:
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        r101 = true;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
