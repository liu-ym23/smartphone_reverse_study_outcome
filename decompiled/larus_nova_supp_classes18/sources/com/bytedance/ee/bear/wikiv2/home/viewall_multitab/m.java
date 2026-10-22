package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ WikiSpaceTabFragment a;

    public m(WikiSpaceTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        BaseTitleBar r0 = this.a.V90();
        Intrinsics.checkNotNull(r3);
        r0.setTitle(r3.intValue());
    }
}
