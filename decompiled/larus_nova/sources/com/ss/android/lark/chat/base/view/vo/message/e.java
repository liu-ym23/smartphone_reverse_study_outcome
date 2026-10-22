package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.TextContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e extends BaseTextContentVO<TextContent> {
    public e(TextContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO, com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
    L13:
        return false;
    L5:
        if ((r100 instanceof e) == false) goto L13;
        e r101 = (e) r100;
        if (y28.a.a(this.f411872h, r101.f411872h) == false) goto L13;
        if (y28.a.a(this.f411873i, r101.f411873i) == false) goto L13;
        if (y28.a.a(this.f411874j, r101.f411874j) == false) goto L13;
        return true;
    }
}
