package com.ss.android.ugc.aweme.search.vision.result.v1.saas;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.search.common.list.utils.ECSearchPreLoadHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PhotoSearchResultSaaSFragment$initESCommonList$3 extends FunctionReferenceImpl implements Function1<String, Integer> {
    public PhotoSearchResultSaaSFragment$initESCommonList$3(ECSearchPreLoadHandler r100) {
        super(1, r100, ECSearchPreLoadHandler.class, "preLoadConfigFunc", "preLoadConfigFunc(Ljava/lang/String;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((ECSearchPreLoadHandler) this.receiver).getClass();
        return ECSearchPreLoadHandler.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(String r100) {
        return Integer.valueOf(invoke2(r100));
    }
}
