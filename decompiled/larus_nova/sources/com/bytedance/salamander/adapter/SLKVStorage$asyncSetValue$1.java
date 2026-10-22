package com.bytedance.salamander.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncSetValue$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ String $key;
    final /* synthetic */ Object $value;
    final /* synthetic */ SLStorageValueType $valueType;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncSetValue$1(o r100, String r101, Object r102, SLStorageValueType r103) {
        this.this$0 = r100;
        this.$key = r101;
        this.$value = r102;
        this.$valueType = r103;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        o r100 = this.this$0;
        String r101 = this.$key;
        Object r102 = this.$value;
        SLStorageValueType r103 = this.$valueType;
        p r104 = r100.f267794a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r104 = null;
    L5:
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r103, "valueType");
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
