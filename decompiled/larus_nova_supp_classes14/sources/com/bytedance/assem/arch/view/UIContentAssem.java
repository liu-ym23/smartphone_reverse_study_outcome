package com.bytedance.assem.arch.view;

import android.view.View;
import com.bytedance.assem.arch.core.UIAssem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/view/UIContentAssem;", "Lcom/bytedance/assem/arch/core/UIAssem;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class UIContentAssem extends UIAssem {
    public int i;

    @Override // com.bytedance.assem.arch.core.UIAssem
    public final void p() {
        View r0 = this.h;
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L9:
        r(r0);
        return;
    L12:
        if (this.i == 0) goto L20;
        View r2 = j().f;
        if (r2 == null) goto L21;
        View r3 = r2.findViewById(this.i);
        if (r3 == null) goto L19;
        this.h = r3;
        r(r3);
        return;
    L19:
        throw new IllegalStateException("Required value was null.".toString());
    L21:
        return;
    L20:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public UIContentAssem() {
    }
}
