package sg4;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends c {
    public b() {
    }

    public static int c(String r100) {
        List r101 = StringsKt.split$default(r100, new String[]{":", "."}, false, 0, 6, null);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r104 = r103.next();
        if ((true ^ StringsKt.isBlank((String) r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L9:
        if (r102.size() < 2) goto L41;
        int r105 = 0;
        Integer r106 = StringsKt.toIntOrNull((String) ListProtector.get(r102, 0));
        if (r106 == null) goto L39;
        int r107 = r106.intValue();
        if (r107 < 0) goto L37;
        if (59 < r107) goto L37;
        Integer r108 = StringsKt.toIntOrNull((String) ListProtector.get(r102, 1));
        if (r108 == null) goto L35;
        int r109 = r108.intValue();
        if (r109 < 0) goto L33;
        if (59 < r109) goto L33;
        if (r102.size() < 3) goto L31;
        String r110 = (String) ListProtector.get(r102, 2);
        int r111 = r110.length();
        if (r111 == 1) goto L28;
        if (r111 == 2) goto L27;
        int r112 = CastIntegerProtector.parseInt(StringsKt.take(r110, 3));
    L29:
        r105 = RangesKt.coerceAtMost(r112, 999);
        goto L31
    L27:
        r112 = CastIntegerProtector.parseInt(r110) * 10;
        goto L29
    L28:
        r112 = CastIntegerProtector.parseInt(r110) * 100;
    L31:
        return (((r107 * 60) + r109) * 1000) + r105;
    L33:
        throw new IllegalArgumentException("Seconds must be between 0 and 59: " + r109);
    L35:
        throw new IllegalArgumentException("Invalid seconds: " + ((String) ListProtector.get(r102, 1)));
    L37:
        throw new IllegalArgumentException("Minutes must be between 0 and 59: " + r107);
    L39:
        throw new IllegalArgumentException("Invalid minutes: " + ((String) ListProtector.get(r102, 0)));
    L41:
        throw new IllegalArgumentException("Invalid LRC time format: " + r100 + " (expected mm:ss or mm:ss.ms)");
    }

    @Override // sg4.c
    public final d a(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "lyricsFile");
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L36
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r101, rg4.c.f537692a));     // Catch: Throwable -> L31
        TreeMap r103 = new TreeMap();     // Catch: Throwable -> L26
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L26
        String r105 = r102.readLine();     // Catch: Throwable -> L26
    L6:
        if (r105 == null) goto L8;
        r104.add(r105);     // Catch: Throwable -> L26
        b(r103, r105);     // Catch: Throwable -> L26
        r105 = r102.readLine();     // Catch: Throwable -> L26
        goto L6
    L8:
        TreeMap r106 = new TreeMap();     // Catch: Throwable -> L26
        Iterator r107 = r103.values().iterator();     // Catch: Throwable -> L26
        int r108 = 0;
    L10:
        if (r107.hasNext() == false) goto L21;
        Object r109 = r107.next();     // Catch: Throwable -> L26
        int r110 = r108 + 1;     // Catch: Throwable -> L26
        if (r108 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L26
    L14:
        pg4.d r111 = (pg4.d) r109;     // Catch: Throwable -> L26
        if (r108 >= 0) goto L17;
    L19:
        Object r112 = "";
    L20:
        r111.f529202h = (String) r112;     // Catch: Throwable -> L26
        r106.put(Integer.valueOf(r108), r111);     // Catch: Throwable -> L26
        r108 = r110;
        goto L10
    L17:
        if (r108 > CollectionsKt.getLastIndex(r104)) goto L19;
        r112 = r104.get(r108);     // Catch: Throwable -> L26
        goto L20
    L21:
        d r113 = new d(r106);     // Catch: Throwable -> L26
        goto L37
    L23:
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L36
        return r113;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L37:
        return new d(new TreeMap());
    }

    public static void b(TreeMap r110, String r111) {
        Matcher r100 = rg4.c.f537695d.matcher(r111);     // Catch: Exception -> L18
        if (r100.find() == false) goto L25;
        Matcher r101 = rg4.c.f537696e.matcher(r100.group());     // Catch: Exception -> L18
    L7:
        if (r101.find() == false) goto L26;
        String r102 = r101.group();     // Catch: Exception -> L18
        if (r102 == null) goto L17;
        String r103 = StringsKt.trim(r102).toString();     // Catch: Exception -> L18
        int r104 = c(r103.substring(1, r103.length() - 1));     // Catch: Exception -> L18
        String r105 = r111.substring(r100.end());     // Catch: Exception -> L18
        if (r105 == null) goto L15;
        r110.put(Integer.valueOf(r104), new pg4.d(null, r104, 0, null, null, StringsKt.trim(r105).toString(), 16315));     // Catch: Exception -> L18
        goto L7
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Exception -> L18
    L26:
        return;
    L25:
        return;
    L18:
        e = move-exception;
        ug4.b.a(new Object[]{"parseLrcLine error", r111, e});
    }
}
