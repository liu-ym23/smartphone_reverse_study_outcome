package com.ss.android.lark.todo.impl.features.detail.comment;

import android.content.Context;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements ReactionFlowLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f442952a;

    public k(Context r100) {
        this.f442952a = r100;
    }

    @Override // com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout.a
    public final void a(String r100) {
        c7c.a r101 = CommentAdapterV2.f442829d;
        Context r102 = this.f442952a;
        Intrinsics.checkNotNull(r100);
        CommentAdapterV2.a.a(r102, r100);
    }
}
