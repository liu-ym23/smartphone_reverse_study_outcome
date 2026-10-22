package com.ss.android.lark.search.doubao.env;

import com.bytedance.lark.rustclient.api.p;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/rustclient/api/RustClientError;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ASLRustImpl$asyncSendRequestNonWrap$call$5 extends Lambda implements Function1<p, Unit> {
    final /* synthetic */ IGetDataCallback<Object> $callback;

    public ASLRustImpl$asyncSendRequestNonWrap$call$5(IGetDataCallback<Object> r100) {
        this.$callback = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(p r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        IGetDataCallback<Object> r101 = this.$callback;
        if (r101 == null) goto L6;
        r101.onError(p.a(r100));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(p r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
