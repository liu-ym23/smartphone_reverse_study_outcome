package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import com.ss.android.lark.biz.im.api.extension.chat_window.hint.IFooterHintComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f413736a;

    public e(d.a r100) {
        this.f413736a = r100;
    }

    public final void a(txa.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        IFooterHintComponent r101 = (IFooterHintComponent) this.f413736a.a(IFooterHintComponent.class);
        if (r101 == null) goto L6;
        r101.MK();
        return;
    }
}
