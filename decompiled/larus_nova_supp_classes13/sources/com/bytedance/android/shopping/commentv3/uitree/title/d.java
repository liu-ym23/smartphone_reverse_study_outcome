package com.bytedance.android.shopping.commentv3.uitree.title;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements CapsuleComponent.OnClickMenuListener {
    public final /* synthetic */ CommentTitleUI a;
    public final /* synthetic */ View b;
    public final /* synthetic */ IECAIHostService c;
    public final /* synthetic */ Context d;

    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, FreqActions.ACTION_VIEW);
        CommentTitleUI r6 = this.a;
        View r0 = this.b;
        int r1 = CommentTitleUI.v;
        r6.getClass();
        if (r0 == null) goto L7;
        boolean r7 = r0.performClick();
        boolean r2 = true;
        if (r7 != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        this.c.showAppletPanel(this.d, "product_comment", CollectionsKt.emptyList(), null);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public d(CommentTitleUI r1, View r2, IECAIHostService r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
