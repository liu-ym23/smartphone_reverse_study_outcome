package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.TextContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends v5b.a<TextContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f411958b;

    public g() {
        super(new TextContent());
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == false) goto L13;
        String r101 = this.f411958b;
        String r102 = null;
        if ((r100 instanceof g) == false) goto L7;
        g r103 = (g) r100;
    L8:
        if (r103 == null) goto L11;
        r102 = r103.f411958b;
    L11:
        if (Intrinsics.areEqual(r101, r102) == false) goto L13;
        return true;
    L7:
        r103 = null;
    L13:
        return false;
    }
}
