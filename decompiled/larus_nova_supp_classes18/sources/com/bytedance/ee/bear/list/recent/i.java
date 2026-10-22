package com.bytedance.ee.bear.list.recent;

import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public final ce5.a a;

    public i(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        this.a = r2;
    }

    public final boolean a(Document r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (com.bytedance.ee.bear.list.t0.u(r3, this.a) == false) goto L5;
    L9:
        return false;
    L5:
        if (this.a.d.isCurrentEnable("ccm.workspace.recent_delete_enable") == false) goto L9;
        if (TextUtils.equals(this.a.b.b, r3.e) == false) goto L9;
        return true;
    }
}
