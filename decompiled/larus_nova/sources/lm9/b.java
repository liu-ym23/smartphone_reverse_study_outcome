package lm9;

import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f509897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f509898b = null;

    /* JADX WARN: Type inference failed for: r0v1, types: [lm9.a] */
    static {
        f509898b = new a();
    }

    public static Object a() {
        if (f509897a == false) goto L21;
        return Boxing.boxBoolean(true);
    L21:
        String r100 = (String) TTExecutors.getNormalExecutor().submit(f509898b).get(1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L19
        if (r100 != null) goto L10;
    L13:
        boolean r101 = true;
    L14:
        boolean r102 = !r101;     // Catch: Exception -> L19
        if (r102 == false) goto L17;
        f509897a = true;     // Catch: Exception -> L19
    L17:
        return Boxing.boxBoolean(r102);
    L10:
        if (r100.length() == 0) goto L13;
        r101 = false;
    L20:
        return Boxing.boxBoolean(false);
    }
}
