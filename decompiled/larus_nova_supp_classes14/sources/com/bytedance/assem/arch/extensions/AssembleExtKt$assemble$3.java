package com.bytedance.assem.arch.extensions;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.core.Assembler;
import com.bytedance.assem.arch.core.UIAssem;
import com.bytedance.assem.arch.view.UIContentAssem;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/assem/arch/extensions/AssembleExtKt$assemble$3", "Landroidx/lifecycle/LifecycleEventObserver;", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssembleExtKt$assemble$3 implements LifecycleEventObserver {
    public final /* synthetic */ UIAssem a;
    public final /* synthetic */ Assembler b;

    public AssembleExtKt$assemble$3(UIContentAssem r1, Assembler r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
        if (b.b[r2.ordinal()] != 1) goto L7;
        this.b.clearAsLifecycleOwner(this.a);
        return;
    }
}
