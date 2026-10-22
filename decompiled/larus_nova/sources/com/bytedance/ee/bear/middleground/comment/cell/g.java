package com.bytedance.ee.bear.middleground.comment.cell;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p f231051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.t f231052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommentBean.CommentDetail f231053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f231054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f231055e;

    public g(com.bytedance.ee.bear.middleground.comment.uitls.p r100, com.bytedance.ee.bear.middleground.comment.control.t r101, CommentBean.CommentDetail r102, String r103, Function0<Unit> r104) {
        this.f231051a = r100;
        this.f231052b = r101;
        this.f231053c = r102;
        this.f231054d = r103;
        this.f231055e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = h.f231056a;
        h.a(this.f231051a, this.f231052b, this.f231053c, this.f231054d);
        Function0<Unit> r102 = this.f231055e;
        if (r102 == null) goto L6;
        r102.invoke();
        return;
    }
}
