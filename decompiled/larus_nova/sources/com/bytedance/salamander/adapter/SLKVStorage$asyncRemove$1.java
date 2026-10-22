package com.bytedance.salamander.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE, "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncRemove$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $key;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncRemove$1(o r100, String r101) {
        this.this$0 = r100;
        this.$key = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Unit invoke2() {
        o r100 = this.this$0;
        String r101 = this.$key;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        p r102 = r100.f267794a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r102 = null;
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        return invoke2();
    }
}
