package com.bytedance.rts.foundation;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "reason", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RTSPromiseKt$await$2$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Continuation<Object> $continuation;

    public RTSPromiseKt$await$2$2(Continuation<Object> r100) {
        this.$continuation = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if ((r100 instanceof Throwable) == false) goto L5;
        Throwable r101 = (Throwable) r100;
    L6:
        Continuation<Object> r102 = this.$continuation;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r101)));
        return;
    L5:
        r101 = new RuntimeException(r100.toString());
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
