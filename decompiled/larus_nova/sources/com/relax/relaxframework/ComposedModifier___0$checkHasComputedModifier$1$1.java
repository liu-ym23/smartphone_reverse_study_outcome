package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/relax/relaxframework/p6;", "modifier", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/p6;)Ljava/lang/Boolean;", "<no name provided>"}, k = 3, mv = {1, 7, 1})
final class ComposedModifier___0$checkHasComputedModifier$1$1 extends Lambda implements Function1<p6, Boolean> {
    final /* synthetic */ Ref.ObjectRef<p6> $composedModifierItem;
    final /* synthetic */ Ref.BooleanRef $hasComputedModifier;

    public ComposedModifier___0$checkHasComputedModifier$1$1(Ref.ObjectRef<p6> r100, Ref.BooleanRef r101) {
        this.$composedModifierItem = r100;
        this.$hasComputedModifier = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(p6 r100) {
        Intrinsics.checkNotNullParameter(r100, "modifier");
        boolean r101 = true;
        if (this.$composedModifierItem.element.b() != RxModifierType.Computed) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        this.$hasComputedModifier.element = true;
        return Boolean.FALSE;
    L10:
        if (this.$composedModifierItem.element.b() == RxModifierType.Composed) goto L13;
        r101 = false;
    L13:
        if (r101 == false) goto L19;
        p6 r103 = this.$composedModifierItem.element;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.relax.relaxframework.ComposedModifier___0");
        Ref.BooleanRef r104 = this.$hasComputedModifier;
        ((i0) r103).getClass();
        r104.element = false;
        if (this.$hasComputedModifier.element == false) goto L19;
        return Boolean.FALSE;
    L19:
        return Boolean.TRUE;
    L5:
        r102 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(p6 r100) {
        return invoke2(r100);
    }
}
