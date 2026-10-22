package com.bytedance.android.shopping.commentv3.base;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.commentv3.base.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a<State extends b> extends e {
    public boolean a;
    public MutableLiveData<State> b;

    public a() {
    }

    public final void e(Function1<? super State, ? extends State> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        MutableLiveData<State> r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L5:
        b r1 = (b) r0.getValue();
        if (r1 == null) goto L8;
        b r4 = (b) r3.invoke(r1);
    L9:
        MutableLiveData<State> r2 = this.b;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L12:
        r2.setValue(r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void d(b r3, BaseUI$bindLogic$1 r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "cb");
        if (this.a == true) goto L5;
        this.a = true;
        this.b = new MutableLiveData(r3);
    L5:
        MutableLiveData<State> r5 = this.b;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("state");
    L8:
        r4.invoke(r5);
    }
}
