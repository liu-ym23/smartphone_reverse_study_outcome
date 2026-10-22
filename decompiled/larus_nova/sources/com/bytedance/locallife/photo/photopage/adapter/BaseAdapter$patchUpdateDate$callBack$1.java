package com.bytedance.locallife.photo.photopage.adapter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
final /* synthetic */ class BaseAdapter$patchUpdateDate$callBack$1 extends FunctionReferenceImpl implements Function2<Object, Object, Boolean> {
    public BaseAdapter$patchUpdateDate$callBack$1(Object r100) {
        super(2, r100, Function2.class, AbsMethodDelegate.TAG_INVOKE, "invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(Object r100, Object r101) {
        return (Boolean) ((Function2) this.receiver).invoke(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Object r100, Object r101) {
        return invoke(r100, r101);
    }
}
