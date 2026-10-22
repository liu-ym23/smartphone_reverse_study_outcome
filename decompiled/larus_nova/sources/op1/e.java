package op1;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<d> f524696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f524697b;

    public e() {
        this.f524696a = new ArrayList();
        this.f524697b = PatternProtector.compile("\\[\\d{1,2}:\\d{1,2}([\\.:]\\d{1,3})?\\]");
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "line");
        Matcher r101 = PatternProtector.compile("\\[(offset):[^\\]]+\\]").matcher(r100);
    L4:
        if (r101.find() == false) goto L13;
        String r102 = r101.group();
        if (r102 == null) goto L12;
        String r103 = r102.substring(1, 7);
        if (r103.hashCode() != (-1019779949)) goto L4;
        r103.equals("offset");
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "line");
        Matcher r100 = this.f524697b.matcher(r110);
        ArrayList r101 = new ArrayList();
        boolean r102 = false;
        int r103 = 0;
    L3:
        long r104 = -1;
        boolean r111 = true;
        if (r100.find() == false) goto L41;
        String r105 = r100.group();
        Intrinsics.checkNotNullParameter(r105, "line");
        String r106 = StringsKt.trim(r105).toString();
        List r107 = StringsKt.split$default(r106.substring(1, r106.length() - 1), new String[]{":", "."}, false, 0, 6, null);
        if (r107.size() < 2) goto L40;
        if (r107.size() != 2) goto L20;
        int r108 = CastIntegerProtector.parseInt((String) ListProtector.get(r107, 0));     // Catch: NumberFormatException -> L17
        int r109 = CastIntegerProtector.parseInt((String) ListProtector.get(r107, 1));     // Catch: NumberFormatException -> L17
        if (r108 < 0) goto L16;
        if (r109 < 0) goto L16;
        if (r109 >= 60) goto L16;
        r104 = ((long) ((r108 * 60) + r109)) * 1000;     // Catch: NumberFormatException -> L17
    L16:
        throw new NumberFormatException();     // Catch: NumberFormatException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L20:
        if (r107.size() != 3) goto L40;
        int r112 = CastIntegerProtector.parseInt((String) ListProtector.get(r107, 0));     // Catch: NumberFormatException -> L38
        int r113 = CastIntegerProtector.parseInt((String) ListProtector.get(r107, 1));     // Catch: NumberFormatException -> L38
        int r114 = CastIntegerProtector.parseInt((String) ListProtector.get(r107, 2));     // Catch: NumberFormatException -> L38
        if (r112 < 0) goto L30;
        if (r113 < 0) goto L30;
        if (r113 >= 60) goto L30;
        if (r114 < 0) goto L30;
        if (r114 > 999) goto L30;
        r111 = false;
    L30:
        if (r111 == true) goto L37;
        int r115 = (r112 * 60) + r113;     // Catch: NumberFormatException -> L38
        if (r114 <= 99) goto L34;
        long r116 = ((long) r115) * 1000;     // Catch: NumberFormatException -> L38
    L35:
        r104 = r116 + ((long) r114);     // Catch: NumberFormatException -> L38
        goto L40
    L34:
        r116 = ((long) r115) * 1000;     // Catch: NumberFormatException -> L38
        r114 = r114 * 10;     // Catch: NumberFormatException -> L38
        goto L35
    L37:
        throw new NumberFormatException();     // Catch: NumberFormatException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L40:
        r101.add(Long.valueOf(r104));
        r103 = r100.end();
        ((Number) CollectionsKt.last(r101)).longValue();
        goto L3
    L41:
        String r117 = r110.substring(r103, r110.length());
        if (r117 == null) goto L62;
        String r118 = StringsKt.trim(r117).toString();
        if (StringsKt.startsWith$default(r118, "[", false, 2, null) == true) goto L46;
    L48:
        if (r118 != null) goto L50;
    L51:
        r102 = true;
    L52:
        if (r102 == false) goto L54;
        return;
    L54:
        Iterator r119 = r101.iterator();
    L56:
        if (r119.hasNext() == false) goto L60;
        long r120 = ((Number) r119.next()).longValue();
        if (r120 == (-1)) goto L56;
        this.f524696a.add(new d(r120 / 1000.0f, r118));
        goto L56
    L60:
        return;
    L50:
        if (r118.length() != 0) goto L52;
    L46:
        if (StringsKt.endsWith$default(r118, "]", false, 2, null) == false) goto L48;
        r118 = "";
        goto L48
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final String c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "line");
        StringBuffer r100 = new StringBuffer();
        List r111 = StringsKt.split$default(r110, new String[]{"]"}, false, 0, 6, null);
        int r101 = r111.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L22;
        String r103 = (String) ListProtector.get(r111, r102);
        if (r102 == (r111.size() - 1)) goto L7;
        r103 = r103 + "]";
    L11:
        if (StringsKt.startsWith$default(r103, "[", false, 2, null) == true) goto L13;
    L19:
        r100.append(r103);
    L20:
        r102 = r102 + 1;
        goto L3
    L13:
        if (StringsKt.endsWith$default(r103, "]", false, 2, null) == false) goto L19;
        if (this.f524697b.matcher(r103).find() == false) goto L17;
        r100.append(r103);
        goto L20
    L17:
        return "";
    L7:
        if (StringsKt.endsWith$default(r103, "]", false, 2, null) == false) goto L11;
        r103 = r103 + "]";
        goto L11
    L22:
        return r100.toString();
    }
}
