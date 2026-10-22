package kg;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        return "shopping-debug-".concat(r100);
    }
}
