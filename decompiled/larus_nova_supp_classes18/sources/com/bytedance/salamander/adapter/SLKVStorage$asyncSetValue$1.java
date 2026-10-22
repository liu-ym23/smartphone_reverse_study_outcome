package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<no name provided>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncSetValue$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ String $key;
    final /* synthetic */ Object $value;
    final /* synthetic */ SLStorageValueType $valueType;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncSetValue$1(o r1, String r2, Object r3, SLStorageValueType r4) {
        this.this$0 = r1;
        this.$key = r2;
        this.$value = r3;
        this.$valueType = r4;
        super(0);
    }

    public final Boolean invoke() {
        o r0 = this.this$0;
        String r1 = this.$key;
        Object r2 = this.$value;
        SLStorageValueType r3 = this.$valueType;
        p r4 = r0.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r4 = null;
    L5:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        Intrinsics.checkNotNullParameter(r3, "valueType");
        return Boolean.FALSE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m749invoke() {
        return invoke();
    }
}
