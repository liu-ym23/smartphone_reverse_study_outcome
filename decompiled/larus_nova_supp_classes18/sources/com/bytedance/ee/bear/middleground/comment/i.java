package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements com.bytedance.ee.bear.middleground.comment.cell.i.a {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function1 c;

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final void a(String r1, String r2, MentionUserState r3) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final void b(String r2) {
        this.b.invoke(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final void c(String r2) {
        this.c.invoke(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final boolean isSameSpace(String r2) {
        return ((Boolean) this.a.invoke(r2)).booleanValue();
    }

    public i(Function1 r1, Function1 r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
