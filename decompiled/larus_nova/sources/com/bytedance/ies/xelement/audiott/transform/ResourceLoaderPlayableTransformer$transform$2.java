package com.bytedance.ies.xelement.audiott.transform;

import com.bytedance.ies.xelement.audiott.bean.XAudioSrc;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", LynxError.LYNX_THROWABLE, "", "<anonymous parameter 1>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class ResourceLoaderPlayableTransformer$transform$2 extends Lambda implements Function2<Throwable, Boolean, Unit> {
    final /* synthetic */ Function1<g76.a, Unit> $callback;
    final /* synthetic */ XAudioSrc $origin;
    final /* synthetic */ c this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceLoaderPlayableTransformer$transform$2(c r100, XAudioSrc r101, Function1<? super g76.a, Unit> r102) {
        this.$origin = r101;
        this.$callback = r102;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        int r102 = c.f249771b;
        throw null;
    }
}
