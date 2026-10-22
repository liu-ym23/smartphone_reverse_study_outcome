package of4;

import com.bytedance.sdk.bridge.model.BridgeResult;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f523101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f523102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f523103c;

    static {
    }

    @JvmStatic
    public static final void a(BridgeResult r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Boolean r102 = f523102b;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        boolean r103 = r102.booleanValue();
    L15:
        if (r103 == false) goto L30;
        Field r104 = f523103c;     // Catch: IllegalAccessException -> L20
        if (r104 == null) goto L31;
        r104.set(r100, Boolean.valueOf(r101));     // Catch: IllegalAccessException -> L20
        return;
    L31:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L30:
        return;
    L5:
        r103 = true;
        Field r105 = BridgeResult.class.getDeclaredField("isRaw");     // Catch: NoSuchFieldException -> L8
        r105.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        f523103c = r105;     // Catch: NoSuchFieldException -> L8
        f523102b = Boolean.TRUE;     // Catch: NoSuchFieldException -> L8
    L25:
        BridgeResult.class.getMethod("isRaw", new Class[0]);     // Catch: NoSuchMethodException -> L11
        f523103c = null;     // Catch: NoSuchMethodException -> L11
    L14:
        f523102b = Boolean.valueOf(r103);
    L11:
        BridgeResult.class.getMethod("getIsRaw", new Class[0]);     // Catch: NoSuchMethodException -> L13
    L13:
        r103 = false;
        goto L14
    }
}
