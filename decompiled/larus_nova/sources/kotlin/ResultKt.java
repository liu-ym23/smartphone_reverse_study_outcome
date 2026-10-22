package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0084\u0001\u0010\n\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\r2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u0012\u001a0\u0010\u0013\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052\u0006\u0010\u0014\u001a\u0002H\u0006H\u0087\b¢\u0006\u0002\u0010\u0015\u001a[\u0010\u0016\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0018\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0005H\u0087\b¢\u0006\u0002\u0010\u0019\u001a]\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aP\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u001e0\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aW\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0005\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u001e0\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aa\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0017\u001aT\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u000b*\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u000b0\u00052!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u0002H\u00060\rH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a@\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\r¢\u0006\u0002\b!H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\"\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u0005H\u0001¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"createFailure", "", a.KEY_EXCEPTION, "", "runCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "fold", ExifInterface.GPS_DIRECTION_TRUE, "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "onFailure", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrThrow", "(Ljava/lang/Object;)Ljava/lang/Object;", "map", "transform", "mapCatching", "action", "", "recover", "recoverCatching", "Lkotlin/ExtensionFunctionType;", "throwOnFailure", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ResultKt {
    public static final Object createFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
        return new Result.Failure(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object r100) {
        throwOnFailure(r100);
        return r100;
    }

    private static final <R> Object runCatching(Function0<? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        return Result.m9449constructorimpl(r100.invoke());
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(createFailure(th));
    }

    public static final void throwOnFailure(Object r100) {
        if ((r100 instanceof Result.Failure) == true) goto L6;
        return;
    L6:
        throw ((Result.Failure) r100).exception;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object r100, R r101) {
        if (Result.m9455isFailureimpl(r100) == false) goto L5;
        return r101;
    L5:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object r100, Function1<? super Throwable, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "onFailure");
        Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
        if (r102 != null) goto L6;
        return r100;
    L6:
        return r101.invoke(r102);
    }

    private static final <R, T> Object map(Object r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "transform");
        if (Result.m9456isSuccessimpl(r100) == false) goto L6;
        return Result.m9449constructorimpl(r101.invoke(r100));
    L6:
        return Result.m9449constructorimpl(r100);
    }

    private static final <R, T> Object mapCatching(Object r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "transform");
        if (Result.m9456isSuccessimpl(r100) == false) goto L9;
        return Result.m9449constructorimpl(r101.invoke(r100));
    L6:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        return Result.m9449constructorimpl(createFailure(th));
    L9:
        return Result.m9449constructorimpl(r100);
    }

    private static final <T> Object onFailure(Object r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
        if (r102 == null) goto L5;
        r101.invoke(r102);
    L5:
        return r100;
    }

    private static final <T> Object onSuccess(Object r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (Result.m9456isSuccessimpl(r100) == false) goto L5;
        r101.invoke(r100);
    L5:
        return r100;
    }

    private static final <R, T extends R> Object recover(Object r100, Function1<? super Throwable, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "transform");
        Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
        if (r102 != null) goto L6;
        return r100;
    L6:
        return Result.m9449constructorimpl(r101.invoke(r102));
    }

    private static final <R, T extends R> Object recoverCatching(Object r100, Function1<? super Throwable, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "transform");
        Throwable r102 = Result.m9452exceptionOrNullimpl(r100);
        if (r102 == null) goto L12;
        return Result.m9449constructorimpl(r101.invoke(r102));
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        return Result.m9449constructorimpl(createFailure(th));
    L12:
        return r100;
    }

    private static final <T, R> Object runCatching(T r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        return Result.m9449constructorimpl(r101.invoke(r100));
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        return Result.m9449constructorimpl(createFailure(th));
    }

    private static final <R, T> R fold(Object r100, Function1<? super T, ? extends R> r101, Function1<? super Throwable, ? extends R> r102) {
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r102, "onFailure");
        Throwable r103 = Result.m9452exceptionOrNullimpl(r100);
        if (r103 != null) goto L6;
        return r101.invoke(r100);
    L6:
        return r102.invoke(r103);
    }
}
