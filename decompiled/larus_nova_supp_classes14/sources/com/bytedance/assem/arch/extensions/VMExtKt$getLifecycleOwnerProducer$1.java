package com.bytedance.assem.arch.extensions;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleOwner;", "invoke"}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final class VMExtKt$getLifecycleOwnerProducer$1 extends Lambda implements Function0<LifecycleOwner> {
    final /* synthetic */ boolean $requireActivity;
    final /* synthetic */ LifecycleOwner $this_getLifecycleOwnerProducer;

    public VMExtKt$getLifecycleOwnerProducer$1(LifecycleOwner r1, boolean r2) {
        this.$this_getLifecycleOwnerProducer = r1;
        this.$requireActivity = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1112invoke() {
        return invoke();
    }

    public final LifecycleOwner invoke() {
        if (this.$requireActivity == false) goto L10;
        Fragment r0 = this.$this_getLifecycleOwnerProducer;
        if (r0 == null) goto L8;
        return r0.requireActivity();
    L8:
        throw new TypeCastException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
    L10:
        return this.$this_getLifecycleOwnerProducer;
    }
}
