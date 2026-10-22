package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", VideoSurfaceTexture.KEY_TIME, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class Lynx$requestAnimationFrame$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Long, Unit> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public Lynx$requestAnimationFrame$1(Function1<? super Long, Unit> r100) {
        this.$callback = r100;
        super(1);
    }

    public final void invoke(long r100) {
        Function1<Long, Unit> r101 = this.$callback;
        if (r101 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        r101.invoke(Long.valueOf(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
        invoke(r100.longValue());
        return Unit.INSTANCE;
    }
}
