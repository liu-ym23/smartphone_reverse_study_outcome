package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes42.dex */
public final class FunctionsKt {
    private static final Function1<Object, Object> ALWAYS_NULL = null;
    private static final Function1<Object, Boolean> ALWAYS_TRUE = null;
    private static final Function1<Object, Unit> DO_NOTHING = null;
    private static final Function2<Object, Object, Unit> DO_NOTHING_2 = null;
    private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = null;
    private static final Function1<Object, Object> IDENTITY = null;

    private static final boolean ALWAYS_TRUE$lambda$1(Object r100) {
        return true;
    }

    private static final Object IDENTITY$lambda$0(Object r100) {
        return r100;
    }

    public static /* synthetic */ Object accessor$FunctionsKt$lambda3(Object r100) {
        return IDENTITY$lambda$0(r100);
    }

    public static /* synthetic */ boolean accessor$FunctionsKt$lambda4(Object r100) {
        return ALWAYS_TRUE$lambda$1(r100);
    }

    public static /* synthetic */ Unit accessor$FunctionsKt$lambda5(Object r100) {
        return DO_NOTHING$lambda$2(r100);
    }

    public static /* synthetic */ Unit accessor$FunctionsKt$lambda6(Object r100, Object r101) {
        return DO_NOTHING_2$lambda$3(r100, r101);
    }

    public static /* synthetic */ Unit accessor$FunctionsKt$lambda7(Object r100, Object r101, Object r102) {
        return DO_NOTHING_3$lambda$4(r100, r101, r102);
    }

    static {
        IDENTITY = FunctionsKt$$Lambda$3.INSTANCE;
        ALWAYS_TRUE = FunctionsKt$$Lambda$4.INSTANCE;
        ALWAYS_NULL = FunctionsKt$ALWAYS_NULL$1.INSTANCE;
        DO_NOTHING = FunctionsKt$$Lambda$5.INSTANCE;
        DO_NOTHING_2 = FunctionsKt$$Lambda$6.INSTANCE;
        DO_NOTHING_3 = FunctionsKt$$Lambda$7.INSTANCE;
    }

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) ALWAYS_TRUE;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }

    private static final Unit DO_NOTHING$lambda$2(Object r100) {
        return Unit.INSTANCE;
    }

    private static final Unit DO_NOTHING_2$lambda$3(Object r100, Object r101) {
        return Unit.INSTANCE;
    }

    private static final Unit DO_NOTHING_3$lambda$4(Object r100, Object r101, Object r102) {
        return Unit.INSTANCE;
    }
}
