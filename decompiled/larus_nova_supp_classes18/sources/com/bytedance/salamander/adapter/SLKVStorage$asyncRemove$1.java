package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<no name provided>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncRemove$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $key;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncRemove$1(o r1, String r2) {
        this.this$0 = r1;
        this.$key = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Unit m748invoke() {
        o r0 = this.this$0;
        String r1 = this.$key;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        p r2 = r0.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r2 = null;
    L5:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m748invoke();
    }
}
