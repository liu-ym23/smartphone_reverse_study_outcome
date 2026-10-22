package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CommentTitleSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f442890g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f442891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f442892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f442893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public lt7.d f442894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q0 f442895f;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
        com.larksuite.framework.section.utils.a.a(this.f442891b.findViewById(R.id.commentShowMoreTv), b(), com.ss.android.lark.todo.impl.features.detail.viewmodel.a.o0.f443746a);
        View r100 = this.f442891b.findViewById(R.id.comment_load_status_iv);
        com.larksuite.framework.section.c r101 = b();
        com.ss.android.lark.todo.impl.features.detail.viewmodel.a.i0 r102 = com.ss.android.lark.todo.impl.features.detail.viewmodel.a.i0.f443711a;
        com.larksuite.framework.section.utils.a.a(r100, r101, r102);
        com.larksuite.framework.section.utils.a.a(this.f442891b.findViewById(R.id.comment_load_status_tv), b(), r102);
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getCommentIsLoading(), new CommentTitleSection$initViewObserver$1$1(this));
        k(r100.getCommentHasMore(), new CommentTitleSection$initViewObserver$1$2(this));
        k(r100.getCommentLoadingMore(), new CommentTitleSection$initViewObserver$1$3(this));
        k(r100.getCommentLoadingFailed(), new CommentTitleSection$initViewObserver$1$4(this));
        k(r100.getCreatorInfo(), new CommentTitleSection$initViewObserver$1$5(this));
    }

    public CommentTitleSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f442891b = r100;
        this.f442892c = r101;
    }
}
