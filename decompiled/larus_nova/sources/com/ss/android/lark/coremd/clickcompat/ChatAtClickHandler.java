package com.ss.android.lark.coremd.clickcompat;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatAtClickHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f419587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f419588b;

    public ChatAtClickHandler(m2b.a r100, g.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "messageProvider");
        this.f419587a = r100;
        this.f419588b = r101;
    }

    public final void a(final eab.a r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "atNode");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        IMAtNodeExtend.f419650i.b(new ChatAtClickHandler$handleAtClick$1(this, r101, r100));
    }
}
