package q3;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531482a = 0;

    static {
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "quoted");
        int r101 = r100.length();
        if (r101 >= 2) goto L5;
        return r100;
    L5:
        if (r100.charAt(0) != '\"') goto L23;
        int r102 = r101 - 1;
        if (r100.charAt(r102) != '\"') goto L24;
        StringBuffer r103 = new StringBuffer(r101);
        int r104 = 1;
    L9:
        if (r104 >= r102) goto L17;
        char r105 = r100.charAt(r104);
        if (r105 != '\\') goto L15;
        if (r104 == (r101 - 2)) goto L15;
        r104 = r104 + 1;
        r105 = r100.charAt(r104);
    L15:
        r103.append(r105);
        r104 = r104 + 1;
        goto L9
    L17:
        return r103.toString();
    L24:
        return r100;
    L23:
        return r100;
    }
}
