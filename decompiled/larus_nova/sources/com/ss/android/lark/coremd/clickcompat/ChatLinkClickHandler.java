package com.ss.android.lark.coremd.clickcompat;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatLinkClickHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f419595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f419596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f419597c;

    public final void a(final n r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "link");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        LarkLinkExtend.f420024f.b(new ChatLinkClickHandler$handleLinkClick$1(this, r101, r100));
    }

    public ChatLinkClickHandler(m2b.a r100, g.b r101, c.a r102) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "messageProvider");
        this.f419595a = r100;
        this.f419596b = r101;
        this.f419597c = r102;
    }
}
