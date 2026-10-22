package com.bytedance.assem.arch.view;

import android.view.View;
import com.bytedance.assem.arch.core.UIAssem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/view/UIContentAssem;", "Lcom/bytedance/assem/arch/core/UIAssem;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class UIContentAssem extends UIAssem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f193057i;

    @Override // com.bytedance.assem.arch.core.UIAssem
    public final void p() {
        View r100 = this.f192883h;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L12;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L9:
        r(r100);
        return;
    L12:
        if (this.f193057i == 0) goto L20;
        View r102 = j().f192875f;
        if (r102 == null) goto L21;
        View r103 = r102.findViewById(this.f193057i);
        if (r103 == null) goto L19;
        this.f192883h = r103;
        r(r103);
        return;
    L19:
        throw new IllegalStateException("Required value was null.".toString());
    L21:
        return;
    L20:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public UIContentAssem() {
    }
}
