package com.story.ai.biz.comment.adapter;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentListAdapterV2 f459812a;

    public /* synthetic */ h(CommentListAdapterV2 r100) {
        this.f459812a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        CommentListAdapterV2 r101 = this.f459812a;
        ViewGroup r102 = (ViewGroup) r100;
        Intrinsics.checkNotNullParameter(r102, "parent");
        r101.f459788p = r102;
        r102.removeAllViews();
        View r103 = r101.f459787o;
        if (r103 == null) goto L6;
        r102.addView(r103);
    L6:
        return Unit.INSTANCE;
    }
}
