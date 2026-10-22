package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CommentSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f442884b;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getEditCommentInfo(), new CommentSection$initViewObserver$1$1(this));
        k(r100.getReplyCommentInfo(), new CommentSection$initViewObserver$1$2(this));
        k(r100.getScrollToBottomOfComments(), new CommentSection$initViewObserver$1$3(this));
    }

    public CommentSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f442884b = r100;
    }
}
