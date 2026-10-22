package com.ss.android.lark.coremd.clickcompat;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatCodeBlockClickHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2b.a f419589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f419590b;

    public static final class a {
    }

    static {
    }

    public ChatCodeBlockClickHandler(m2b.a r100, g.b r101) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "messageProvider");
        this.f419589a = r100;
        this.f419590b = r101;
    }

    public final void a(final v7b.g r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        LarkCodeBlockExtend.f420011f.b(new ChatCodeBlockClickHandler$handleCodeBlockClick$1(this, r101, r100));
    }
}
