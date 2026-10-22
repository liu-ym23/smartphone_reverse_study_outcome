package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import ef5.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class c0 implements com.ss.android.lark.reaction.widget.panel.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.uitls.p f231204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f231205b;

    @Override // com.ss.android.lark.reaction.widget.panel.e.a
    public void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f231204a.N.a(new d0(this.f231205b));
    }

    public c0(com.bytedance.ee.bear.middleground.comment.uitls.p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "menuId");
        this.f231204a = r100;
        this.f231205b = r101;
    }
}
