package su5;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f543590a = 0;

    static {
    }

    public static boolean a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        String r101 = (String) r100;
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        if (Pattern.matches("^\\d{1,14}$", r101) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r102 = false;
        goto L6
    }
}
