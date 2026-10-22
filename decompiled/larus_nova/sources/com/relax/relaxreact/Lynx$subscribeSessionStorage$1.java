package com.relax.relaxreact;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "value", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class Lynx$subscribeSessionStorage$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ Function1<Function0<Unit>, Unit> $runWithContext;

    /* JADX WARN: Multi-variable type inference failed */
    public Lynx$subscribeSessionStorage$1(Function1<? super Function0<Unit>, Unit> r100, Function1<Object, Unit> r101) {
        this.$runWithContext = r100;
        this.$callback = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Object r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Function1<Function0<Unit>, Unit> r101 = this.$runWithContext;
        final Function1<Object, Unit> r102 = this.$callback;
        r101.invoke(new AnonymousClass1(r102, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
