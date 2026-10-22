package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f231466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ef5.m f231467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e0 f231468c;

    public f0(LinearLayoutManager r100, ef5.m r101, e0 r102) {
        this.f231466a = r100;
        this.f231467b = r101;
        this.f231468c = r102;
    }

    public final void a() {
        int r100 = this.f231466a.findFirstVisibleItemPosition();
        int r101 = this.f231466a.findLastVisibleItemPosition();
        if (r100 == (-1)) goto L19;
        if (r101 == (-1)) goto L22;
        if (r100 > r101) goto L21;
    L7:
        List<CommentBean> r102 = this.f231467b.f472486d;
        String r103 = null;
        if (r102 == null) goto L12;
        CommentBean r104 = (CommentBean) CollectionsKt.getOrNull(r102, r100);
        if (r104 == null) goto L12;
        String r105 = r104.getComment_id();
    L13:
        CommentBean r106 = (CommentBean) CollectionsKt.getOrNull(this.f231467b.f472483a, r100);
        if (r106 == null) goto L16;
        r103 = r106.getComment_id();
    L16:
        this.f231468c.e(this.f231467b.f472483a, r100, !Intrinsics.areEqual(r105, r103));
        if (r100 == r101) goto L23;
        r100 = r100 + 1;
        goto L7
    L23:
        return;
    L12:
        r105 = null;
        goto L13
    L21:
        return;
    L22:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
