package com.bytedance.android.shopping.commentv3.event_chain;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements v96.g {
    public final Context a;

    public d(Context r1) {
        this.a = r1;
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "content");
        if (this.a != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        return;
    L8:
        ECToast.showToast$default(ECToast.INSTANCE, this.a, r8, null, 4, null);
    }
}
