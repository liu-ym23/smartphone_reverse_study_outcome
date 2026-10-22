package com.bytedance.ee.bear.bitable.pro;

import android.view.ActionMode;
import android.view.MotionEvent;
import com.bytedance.ee.bear.bitable.pro.accessconfig.BitableDefaultMemberAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements sa5.w {
    public final /* synthetic */ BitableProFragment a;

    public k(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r3) {
        BitableDefaultMemberAdapter r4 = this.a.H;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultMemberAdapter");
        r4 = null;
    L5:
        ActionMode r1 = r4.a;
        if (r1 == null) goto L8;
        r1.finish();
    L8:
        r4.a = null;
        return false;
    }
}
