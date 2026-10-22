package com.bytedance.frameworks.baselib.netx.partner.mutable;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.retrofit2.client.Header;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/retrofit2/client/Header;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class MutableHeader$clearHeader$1 extends Lambda implements Function1<Header, Boolean> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $value;

    public MutableHeader$clearHeader$1(String r100, String r101) {
        this.$name = r100;
        this.$value = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Header r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (Intrinsics.areEqual(r100.getName(), this.$name) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getValue(), this.$value) == false) goto L7;
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Header r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
