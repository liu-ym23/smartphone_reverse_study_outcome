package com.bytedance.ies.xelement;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", LynxError.LYNX_THROWABLE, "", "isDebug", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LynxLottieView$setSrc$1$1$2 extends Lambda implements Function2<Throwable, Boolean, Unit> {
    final /* synthetic */ String $src;
    final /* synthetic */ LynxLottieView this$0;

    public LynxLottieView$setSrc$1$1$2(LynxLottieView r100, String r101) {
        this.this$0 = r100;
        this.$src = r101;
        super(2);
    }

    public final void invoke(Throwable r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        r100.getMessage();
        if (r101 == false) goto L6;
        LynxLottieView r102 = this.this$0;
        String r103 = this.$src;
        int r104 = LynxLottieView.A;
        r102.P(r103);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }
}
