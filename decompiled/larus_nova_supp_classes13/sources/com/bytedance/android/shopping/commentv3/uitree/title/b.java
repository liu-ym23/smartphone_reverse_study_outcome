package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements BackComponent.OnClickListener {
    public final /* synthetic */ CommentTitleUI a;

    public b(CommentTitleUI r1) {
        this.a = r1;
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        CommentTitleUI.o(this.a);
    }
}
