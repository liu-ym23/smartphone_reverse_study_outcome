package t2;

import android.content.Context;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final String a(Context r100) {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L7;
        boolean r102 = r101.v(r100);
        boolean r103 = true;
        if (r102 != true) goto L7;
    L8:
        if (r103 == false) goto L10;
        return "dark";
    L10:
        return "light";
    L7:
        r103 = false;
        goto L8
    }

    public static final boolean b(Context r100) {
        if (r100 == null) goto L8;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L6;
        Boolean r102 = Boolean.valueOf(r101.o(r100));
    L10:
        return Intrinsics.areEqual(r102, Boolean.TRUE);
    L6:
        r102 = null;
        goto L10
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static final int c(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        TypedValue r103 = new TypedValue();     // Catch: Exception -> L11
        if (r100.getTheme().resolveAttribute(r101, r103, true) == false) goto L9;
        int r104 = r103.resourceId;     // Catch: Exception -> L11
        if (r104 == 0) goto L8;
        r100 = ContextCompat.getColor(r100, r104);     // Catch: Exception -> L11
    L13:
        return r100;
    L8:
        r100 = r103.data;     // Catch: Exception -> L11
        goto L13
    L9:
        r100 = ContextCompat.getColor(r100, r102);     // Catch: Exception -> L11
    L16:
        return ContextCompat.getColor(r100, r102);
    }
}
