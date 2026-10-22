package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements com.bytedance.ee.bear.middleground.comment.cell.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f231583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f231584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f231585c;

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final void a(String r100, String r101, MentionUserState r102) {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final void b(String r100) {
        this.f231584b.invoke(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final void c(String r100) {
        this.f231585c.invoke(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
    public final boolean isSameSpace(String r100) {
        return ((Boolean) this.f231583a.invoke(r100)).booleanValue();
    }

    public i(Function1 r100, Function1 r101, Function1 r102) {
        this.f231583a = r100;
        this.f231584b = r101;
        this.f231585c = r102;
    }
}
