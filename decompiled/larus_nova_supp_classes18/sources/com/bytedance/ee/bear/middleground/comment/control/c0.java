package com.bytedance.ee.bear.middleground.comment.control;

import android.view.View;
import ef5.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class c0 implements com.ss.android.lark.reaction.widget.panel.e.a {
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final String b;

    public void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.a.N.a(new d0(this.b));
    }

    public c0(com.bytedance.ee.bear.middleground.comment.uitls.p r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "menuId");
        this.a = r2;
        this.b = r3;
    }
}
