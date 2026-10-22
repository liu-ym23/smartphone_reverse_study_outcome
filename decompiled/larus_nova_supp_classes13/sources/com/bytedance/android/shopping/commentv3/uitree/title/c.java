package com.bytedance.android.shopping.commentv3.uitree.title;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements CapsuleComponent.OnClickCloseListener {
    public final /* synthetic */ IECAIHostService a;

    public c(IECAIHostService r1) {
        this.a = r1;
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.closeApplet("product_comment");
    }
}
