package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends f<MergeForwardContent> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f411950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public pxa.a f411951i;

    public c(MergeForwardContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof c) == true) goto L9;
        return false;
    L9:
        if (y28.a.a(this.f411951i, ((c) r100).f411951i) == false) goto L14;
        return true;
    L14:
        return false;
    }
}
