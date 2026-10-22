package kotlinx.coroutines.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "e", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ExceptionsConstructorKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Function1<Throwable, Throwable> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionsConstructorKt$safeCtor$1(Function1<? super Throwable, ? extends Throwable> r100) {
        this.$block = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Throwable invoke2(Throwable r100) {
        Function1<Throwable, Throwable> r101 = this.$block;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Throwable r104 = r101.invoke(r100);     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r100.getMessage(), r104.getMessage()) == false) goto L6;
    L8:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r102 = r105;
    L17:
        return (Throwable) r102;
    L6:
        if (Intrinsics.areEqual(r104.getMessage(), r100.toString()) == true) goto L8;
        r104 = null;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Throwable invoke(Throwable r100) {
        return invoke2(r100);
    }
}
