package com.ss.android.lark.picker.config.condition;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [C] */
/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class FoldCondition$inter$2<C> extends Lambda implements Function1<C, Boolean> {
    final /* synthetic */ FoldCondition<C, F> this$0;

    public FoldCondition$inter$2(FoldCondition<C, F> r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX WARN: Incorrect types in method signature: (TC;)Ljava/lang/Boolean; */
    public final Boolean invoke(Condition.Element r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(!this.this$0.getSet().containsKey(r100.getKey()));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100) {
        return invoke((Condition.Element) r100);
    }
}
