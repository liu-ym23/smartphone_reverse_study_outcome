package wa8;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {
    public static final String a() {
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINA.getLanguage()) == false) goto L5;
        return "，";
    L5:
        return ", ";
    }
}
