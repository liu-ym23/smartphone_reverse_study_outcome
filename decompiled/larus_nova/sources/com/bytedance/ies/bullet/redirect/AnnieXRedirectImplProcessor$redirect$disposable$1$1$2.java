package com.bytedance.ies.bullet.redirect;

import com.bytedance.ies.bullet.redirect.data.RedirectException;
import com.bytedance.ies.bullet.redirect.data.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXRedirectImplProcessor$redirect$disposable$1$1$2 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ ObservableEmitter<b> $emitter;

    public AnnieXRedirectImplProcessor$redirect$disposable$1$1$2(ObservableEmitter<b> r100) {
        this.$emitter = r100;
        super(2);
    }

    public final void invoke(int r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        this.$emitter.onError(new RedirectException(r100, r110, null, 4, null));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
