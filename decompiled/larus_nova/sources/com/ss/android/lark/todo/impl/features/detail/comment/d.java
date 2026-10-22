package com.ss.android.lark.todo.impl.features.detail.comment;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoUser;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f442923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoUser f442924b;

    public d(Context r100, TodoUser r101) {
        this.f442923a = r100;
        this.f442924b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c7c.a r101 = CommentAdapterV2.f442829d;
        CommentAdapterV2.a.a(this.f442923a, this.f442924b.user_id);
    }
}
