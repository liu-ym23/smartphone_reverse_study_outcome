package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncGetValue$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Object $defValue;
    final /* synthetic */ String $key;
    final /* synthetic */ SLStorageValueType $valueType;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncGetValue$1(o r1, String r2, Object r3, SLStorageValueType r4) {
        this.this$0 = r1;
        this.$key = r2;
        this.$defValue = r3;
        this.$valueType = r4;
        super(0);
    }

    public final Object invoke() {
        o r0 = this.this$0;
        String r1 = this.$key;
        Object r2 = this.$defValue;
        p r3 = r0.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r3 = null;
    L5:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        return r2;
    }
}
