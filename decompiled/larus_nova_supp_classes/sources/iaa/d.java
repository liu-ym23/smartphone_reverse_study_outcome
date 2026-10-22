package iaa;

import com.bytedance.mira.log.MiraMonitor;
import com.obric.aiagent.platform.depend.ILogDepend;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final Regex a = null;
    public static final Regex b = null;
    public static final Regex c = null;

    static {
        a = new Regex("(\\d+\\.\\d+\\.\\d+\\.\\d+)");
        b = new Regex("(\\d+\\.\\d+\\.\\d+)");
        c = new Regex("(\\d+\\.\\d+)");
    }

    public static long a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "version");
        Long r10 = StringsKt.toLongOrNull(c(CollectionsKt.joinToString$default(StringsKt.split$default(b(r9), new char[]{'.'}, false, 0, 6, null), XmlPullParser.NO_NAMESPACE, null, null, 0, null, new c(), 30, null)));     // Catch: Throwable -> L7
        if (r10 == null) goto L9;
        return r10.longValue();
    L9:
        return 0;
    L7:
        th = move-exception;
        ILogDepend.a.e("OsVersionUtil", "convertVersionStringToLong crash", th);
        goto L9
    }

    public static String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "versionStr");
        Intrinsics.checkNotNullParameter(r10, "versionStr");     // Catch: Throwable -> L31
        MatchResult r7 = Regex.find$default(a, r10, 0, 2, null);     // Catch: Throwable -> L9
        if (r7 == null) goto L11;
        String r8 = r7.getValue();     // Catch: Throwable -> L9
    L12:
        if (r8 == null) goto L14;
        return r8;
    L14:
        Intrinsics.checkNotNullParameter(r10, "versionStr");     // Catch: Throwable -> L31
        MatchResult r3 = Regex.find$default(b, r10, 0, 2, null);     // Catch: Throwable -> L19
        if (r3 == null) goto L21;
        String r4 = r3.getValue();     // Catch: Throwable -> L19
    L22:
        if (r4 != null) goto L24;
        MatchResult r11 = Regex.find$default(c, r10, 0, 2, null);     // Catch: Throwable -> L31
        if (r11 == null) goto L40;
        String r12 = r11.getValue();     // Catch: Throwable -> L31
        if (r12 != null) goto L30;
        return "0.0.0.0";
    L30:
        return r12.concat(".0.0");
    L40:
        return "0.0.0.0";
    L24:
        return r4.concat(".0");
    L21:
        r4 = null;
    L19:
        th = move-exception;
        ILogDepend.a.e("OsVersionUtil", "extractThreePartVersion crash", th);     // Catch: Throwable -> L31
        goto L21
    L11:
        r8 = null;
    L9:
        th = move-exception;
        ILogDepend.a.e("OsVersionUtil", "extractFourPartVersion crash", th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        ILogDepend.a.e("OsVersionUtil", "extractOsVersion crash", th);
        return "0.0.0.0";
    }

    public static String c(String r6) {
        String r0 = r6;
    L3:
        boolean r2 = false;
        if (r0.length() <= 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L15;
        if (r0.length() > 19) goto L14;
        if (r0.length() != 19) goto L15;
        if (r0.compareTo("9223372036854775807") <= 0) goto L15;
    L14:
        r0 = StringsKt.dropLast(r0, 1);
    L15:
        ILogDepend.a.i("OsVersionUtil", "trimVersionNumberToLongRange: versionNumberString " + r6 + ", trimmedVersion " + r0);
        if (r0.length() != 0) goto L18;
        r2 = true;
    L18:
        if (r2 == false) goto L26;
        return MiraMonitor.VALUE_DEFAULT;
    L26:
        return r0;
    L6:
        r1 = false;
        goto L7
    }
}
