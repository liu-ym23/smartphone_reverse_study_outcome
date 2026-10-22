package com.ss.android.lark.chat.cot.detail.blueprint.block;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.blueprint.BlueprintLayoutInflater;
import com.ss.android.lark.blueprint.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "BlockViewType", "Lcom/ss/android/lark/blueprint/IBlockView;", "it", "Lcom/ss/android/lark/blueprint/BlueprintLayoutInflater;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/blueprint/BlueprintLayoutInflater;)Lcom/ss/android/lark/blueprint/IBlockView;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class AbsCotDetailBlock$acquireBlockView$1 extends Lambda implements Function1<BlueprintLayoutInflater, k<Object>> {
    final /* synthetic */ Function1<BlueprintLayoutInflater, k<Object>> $create;

    /* JADX WARN: Multi-variable type inference failed */
    public AbsCotDetailBlock$acquireBlockView$1(Function1<? super BlueprintLayoutInflater, k<Object>> r100) {
        this.$create = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final k<Object> invoke2(BlueprintLayoutInflater r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return this.$create.invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ k<Object> invoke(BlueprintLayoutInflater r100) {
        return invoke2(r100);
    }
}
