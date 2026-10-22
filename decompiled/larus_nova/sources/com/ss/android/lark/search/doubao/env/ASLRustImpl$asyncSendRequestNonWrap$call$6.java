package com.ss.android.lark.search.doubao.env;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ASLRustImpl$asyncSendRequestNonWrap$call$6 extends Lambda implements Function1<Throwable, Unit> {
    public static final ASLRustImpl$asyncSendRequestNonWrap$call$6 INSTANCE = null;

    static {
        INSTANCE = new ASLRustImpl$asyncSendRequestNonWrap$call$6();
    }

    public ASLRustImpl$asyncSendRequestNonWrap$call$6() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        RxJavaPlugins.onError(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
