package com.bytedance.lark.sdk.stream;

import com.bytedance.lark.pb.tool.v1.FetchRequest;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/sdk/stream/RustStreamRequestBodyReader;", "it", "Lcom/bytedance/lark/pb/tool/v1/FetchRequest;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class RustStreamClientImpl$2 extends Lambda implements Function1<FetchRequest, j> {
    public static final RustStreamClientImpl$2 INSTANCE = null;

    static {
        INSTANCE = new RustStreamClientImpl$2();
    }

    public RustStreamClientImpl$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j invoke2(FetchRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        j.f254389a.getClass();
        return j.a.f254391b;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j invoke(FetchRequest r100) {
        return invoke2(r100);
    }
}
