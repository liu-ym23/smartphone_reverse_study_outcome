package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class AddToStdlibKt {
    private static final ConcurrentHashMap<Function0<?>, Object> constantMap = null;

    static {
        constantMap = new ConcurrentHashMap();
    }

    public static final Void shouldNotBeCalled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        throw new IllegalStateException(r100.toString());
    }

    public static /* synthetic */ Void shouldNotBeCalled$default(String r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = "should not be called";
    L6:
        return shouldNotBeCalled(r100);
    }
}
