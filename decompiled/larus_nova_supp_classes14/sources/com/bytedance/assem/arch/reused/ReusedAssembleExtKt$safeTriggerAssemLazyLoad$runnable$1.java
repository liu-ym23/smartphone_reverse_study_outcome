package com.bytedance.assem.arch.reused;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.assem.arch.core.Assembler;
import com.bytedance.assem.arch.extensions.AssemExtKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "Lcom/bytedance/tiktok/proxy/a;", "REUSED", "Lcom/bytedance/assem/arch/core/Assembler;", "invoke", "()Lcom/bytedance/assem/arch/core/Assembler;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ReusedAssembleExtKt$safeTriggerAssemLazyLoad$runnable$1 extends Lambda implements Function0<Assembler> {
    final /* synthetic */ KClass $clazz;
    final /* synthetic */ ReusedUIAssem $this_safeTriggerAssemLazyLoad;

    public ReusedAssembleExtKt$safeTriggerAssemLazyLoad$runnable$1(ReusedUIAssem r1, KClass r2) {
        this.$this_safeTriggerAssemLazyLoad = r1;
        this.$clazz = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1125invoke() {
        return invoke();
    }

    public final Assembler invoke() {
        ReusedUIAssem r0 = this.$this_safeTriggerAssemLazyLoad;
        if ((r0.getContext() instanceof FragmentActivity) == false) goto L9;
        Context r1 = this.$this_safeTriggerAssemLazyLoad.getContext();
        if (r1 == null) goto L8;
        FragmentActivity r2 = (FragmentActivity) r1;
    L11:
        Assembler r3 = (Assembler) ViewModelProviders.of(r2).get(Assembler.class);
        r3.checkAndTriggerLazyLoad$assem_release(this.$this_safeTriggerAssemLazyLoad, this.$clazz);
        return r3;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L9:
        r2 = AssemExtKt.a(r0);
        if (r2 != null) goto L11;
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
