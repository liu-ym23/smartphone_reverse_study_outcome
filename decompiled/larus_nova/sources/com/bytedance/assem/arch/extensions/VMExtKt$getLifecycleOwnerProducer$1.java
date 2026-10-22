package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleOwner;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class VMExtKt$getLifecycleOwnerProducer$1 extends Lambda implements Function0<LifecycleOwner> {
    final /* synthetic */ boolean $requireActivity;
    final /* synthetic */ LifecycleOwner $this_getLifecycleOwnerProducer;

    public VMExtKt$getLifecycleOwnerProducer$1(LifecycleOwner r100, boolean r101) {
        this.$this_getLifecycleOwnerProducer = r100;
        this.$requireActivity = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ LifecycleOwner invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LifecycleOwner invoke() {
        if (this.$requireActivity == false) goto L10;
        LifecycleOwner r100 = this.$this_getLifecycleOwnerProducer;
        if (r100 == null) goto L8;
        return ((Fragment) r100).requireActivity();
    L8:
        throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    L10:
        return this.$this_getLifecycleOwnerProducer;
    }
}
