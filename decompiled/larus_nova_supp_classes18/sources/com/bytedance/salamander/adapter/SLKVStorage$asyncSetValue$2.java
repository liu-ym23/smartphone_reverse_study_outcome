package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "result", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncSetValue$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function2<Boolean, String, Unit> $completion;

    /* JADX WARN: Multi-variable type inference failed */
    public SLKVStorage$asyncSetValue$2(Function2<? super Boolean, ? super String, Unit> r1) {
        this.$completion = r1;
        super(1);
    }

    public final void invoke(boolean r3) {
        if (r3 == true) goto L4;
        String r0 = "save failed. please check the key and value type.";
    L5:
        this.$completion.invoke(Boolean.valueOf(r3), r0);
        return;
    L4:
        r0 = "success";
        goto L5
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
