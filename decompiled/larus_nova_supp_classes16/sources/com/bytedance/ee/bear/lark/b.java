package com.bytedance.ee.bear.lark;

import androidx.lifecycle.Observer;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ BaseHeaderFragment a;

    public b(BaseHeaderFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ForsetiViewMode r3 = (ForsetiViewMode) r2;
        BaseHeaderFragment r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.aa0(r3);
    }
}
