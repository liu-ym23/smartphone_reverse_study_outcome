package iaa;

import com.obric.aiagent.platform.depend.ILogDepend;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f488964a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f488965b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f488966c = null;

    static {
        f488964a = new Regex("(\\d+\\.\\d+\\.\\d+\\.\\d+)");
        f488965b = new Regex("(\\d+\\.\\d+\\.\\d+)");
        f488966c = new Regex("(\\d+\\.\\d+)");
    }

    public static long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        Long r101 = StringsKt.toLongOrNull(c(CollectionsKt.joinToString$default(StringsKt.split$default(b(r100), new char[]{'.'}, false, 0, 6, null), "", null, null, 0, null, new c(), 30, null)));     // Catch: Throwable -> L7
        if (r101 == null) goto L9;
        return r101.longValue();
    L9:
        return 0;
    L7:
        th = move-exception;
        ILogDepend.f384986a.e("OsVersionUtil", "convertVersionStringToLong crash", th);
        goto L9
    }

    public static String b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "versionStr");
        Intrinsics.checkNotNullParameter(r110, "versionStr");     // Catch: Throwable -> L31
        MatchResult r100 = Regex.find$default(f488964a, r110, 0, 2, null);     // Catch: Throwable -> L9
        if (r100 == null) goto L11;
        String r101 = r100.getValue();     // Catch: Throwable -> L9
    L12:
        if (r101 == null) goto L14;
        return r101;
    L14:
        Intrinsics.checkNotNullParameter(r110, "versionStr");     // Catch: Throwable -> L31
        MatchResult r102 = Regex.find$default(f488965b, r110, 0, 2, null);     // Catch: Throwable -> L19
        if (r102 == null) goto L21;
        String r103 = r102.getValue();     // Catch: Throwable -> L19
    L22:
        if (r103 != null) goto L24;
        MatchResult r111 = Regex.find$default(f488966c, r110, 0, 2, null);     // Catch: Throwable -> L31
        if (r111 == null) goto L40;
        String r112 = r111.getValue();     // Catch: Throwable -> L31
        if (r112 != null) goto L30;
        return "0.0.0.0";
    L30:
        return r112.concat(".0.0");
    L40:
        return "0.0.0.0";
    L24:
        return r103.concat(".0");
    L21:
        r103 = null;
    L19:
        th = move-exception;
        ILogDepend.f384986a.e("OsVersionUtil", "extractThreePartVersion crash", th);     // Catch: Throwable -> L31
        goto L21
    L11:
        r101 = null;
    L9:
        th = move-exception;
        ILogDepend.f384986a.e("OsVersionUtil", "extractFourPartVersion crash", th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        ILogDepend.f384986a.e("OsVersionUtil", "extractOsVersion crash", th);
        return "0.0.0.0";
    }

    public static String c(String r100) {
        String r101 = r100;
    L3:
        boolean r102 = false;
        if (r101.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L15;
        if (r101.length() > 19) goto L14;
        if (r101.length() != 19) goto L15;
        if (r101.compareTo("9223372036854775807") <= 0) goto L15;
    L14:
        r101 = StringsKt.dropLast(r101, 1);
    L15:
        ILogDepend.f384986a.i("OsVersionUtil", "trimVersionNumberToLongRange: versionNumberString " + r100 + ", trimmedVersion " + r101);
        if (r101.length() != 0) goto L18;
        r102 = true;
    L18:
        if (r102 == false) goto L26;
        return "0";
    L26:
        return r101;
    L6:
        r103 = false;
        goto L7
    }
}
