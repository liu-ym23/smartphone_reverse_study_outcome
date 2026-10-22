package com.bytedance.salamander.adapter;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<no name provided>", ExifInterface.GPS_DIRECTION_TRUE, AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLKVStorage$asyncGetValue$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ Object $defValue;
    final /* synthetic */ String $key;
    final /* synthetic */ SLStorageValueType $valueType;
    final /* synthetic */ o this$0;

    public SLKVStorage$asyncGetValue$1(o r100, String r101, Object r102, SLStorageValueType r103) {
        this.this$0 = r100;
        this.$key = r101;
        this.$defValue = r102;
        this.$valueType = r103;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        o r100 = this.this$0;
        String r101 = this.$key;
        Object r102 = this.$defValue;
        p r103 = r100.f267794a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r103 = null;
    L5:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "key");
        return r102;
    }
}
