package op1;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f524685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f524686b;

    /* JADX INFO: renamed from: op1.a$a, reason: collision with other inner class name */
    public static final class C7083a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f524688b;

        public b(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f524687a = r100;
            this.f524688b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f524689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f524690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f524691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f524692d;

        public c(long r100, long r101, int r102, int r103) {
            this.f524689a = r100;
            this.f524690b = r101;
            this.f524691c = r102;
            this.f524692d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524693a;

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            this.f524693a = r100;
        }
    }

    static {
    }

    public a() {
        this.f524685a = PatternProtector.compile("\\[(\\d+),(\\d+)\\]");
        this.f524686b = PatternProtector.compile("\\<(\\d+),(\\d+)(,\\d+)?\\>");
    }

    public final void b(List<b> r110, String r111) {
        Matcher r100 = this.f524685a.matcher(r111);
        ArrayList r101 = new ArrayList();
    L3:
        int r102 = 0;
        if (r100.find() == false) goto L19;
        String r103 = r100.group();
        if (r103 == null) goto L17;
        String r104 = StringsKt.trim(r103).toString();
        List r105 = StringsKt.split$default(r104.substring(1, r104.length() - 1), new String[]{","}, false, 0, 6, null);
        if (r105.size() == 2) goto L41;
    L12:
        Pair r106 = null;
    L13:
        if (r106 == null) goto L3;
        r101.add(new c(((Number) r106.getFirst()).longValue(), ((Number) r106.getSecond()).longValue(), r100.start(), r100.end()));
        goto L3
    L41:
        long r107 = CastIntegerProtector.parseInt((String) ListProtector.get(r105, 0));     // Catch: Exception -> L40
        r106 = TuplesKt.to(Long.valueOf(r107), Long.valueOf(((long) CastIntegerProtector.parseInt((String) ListProtector.get(r105, 1))) + r107));     // Catch: Exception -> L40
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        if (r101.isEmpty() == false) goto L21;
        return;
    L21:
        int r112 = r101.size();
        Iterator r113 = r101.iterator();
    L23:
        if (r113.hasNext() == false) goto L39;
        Object r108 = r113.next();
        int r114 = r102 + 1;
        if (r102 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        c r109 = (c) r108;
        if (r102 != (r112 - 1)) goto L30;
        a(r109.f524689a, r109.f524690b, r111.substring(r109.f524692d, r111.length()), r110);
    L36:
        r102 = r114;
        goto L23
    L30:
        c r115 = (c) CollectionsKt.getOrNull(r101, r114);
        if (r115 == null) goto L36;
        int r116 = r109.f524692d;
        int r117 = r115.f524691c;
        if (r111 == null) goto L38;
        a(r109.f524689a, r109.f524690b, r111.substring(r116, r117), r110);
        goto L36
    L38:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static void c(String r100, long r101, long r110, ArrayList r111) {
        int r102 = 0;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        if (r100.length() > 1) goto L12;
        r111.add(new d(r100));
        return;
    L12:
        String r104 = StringsKt.trim(r100).toString();
        int r105 = r104.length();
        long r106 = Math.abs(r110 - r101);
        if (r105 == 0) goto L16;
        long r107 = r106 / ((long) r104.length());
    L16:
        int r108 = StringsKt.indexOf$default(r100, r104, 0, false, 6, null);
        Iterator r109 = StringsKt.toList(r100).iterator();
    L18:
        if (r109.hasNext() == false) goto L27;
        Object r112 = r109.next();
        int r113 = r102 + 1;
        if (r102 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        char r114 = ((Character) r112).charValue();
        if (r102 >= r108) goto L25;
        r111.add(new d(String.valueOf(r114)));
    L26:
        r102 = r113;
        goto L18
    L25:
        r111.add(new d(String.valueOf(r114)));
        goto L26
    L27:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void a(long r210, long r211, String r212, List r213) {
        ArrayList r100 = new ArrayList();
        Matcher r101 = this.f524686b.matcher(r212);
        long r110 = r210;
    L3:
        int r102 = 0;
        if (r101.find() == false) goto L18;
        String r103 = r101.group();
        if (r103 == null) goto L17;
        String r104 = StringsKt.trim(r103).toString();
        List r105 = StringsKt.split$default(r104.substring(1, r104.length() - 1), new String[]{","}, false, 0, 6, null);
        if (r105.size() == 3) goto L46;
    L12:
        Pair r106 = null;
    L13:
        if (r106 == null) goto L14;
        r100.add(new c(((Number) r106.getFirst()).longValue(), ((Number) r106.getSecond()).longValue(), r101.start(), r101.end()));
        r110 = ((Number) r106.getSecond()).longValue();
        goto L3
    L14:
        long r107 = r110;
        long r108 = r110;
        r100.add(new c(r107, r108, r101.start(), r101.end()));
        goto L3
    L46:
        long r109 = ((long) CastIntegerProtector.parseInt((String) ListProtector.get(r105, 0))) + r210;     // Catch: Exception -> L45
        long r111 = ((long) CastIntegerProtector.parseInt((String) ListProtector.get(r105, 1))) + r109;     // Catch: Exception -> L45
        r106 = TuplesKt.to(Long.valueOf(r109), Long.valueOf(r111));     // Catch: Exception -> L45
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L18:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r100.iterator();
    L20:
        if (r113.hasNext() == false) goto L37;
        Object r114 = r113.next();
        int r115 = r102 + 1;
        if (r102 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        c r116 = (c) r114;
        if (r102 != (r100.size() - 1)) goto L27;
        c(r212.substring(r116.f524692d, r212.length()), r116.f524689a, r116.f524690b, r112);
    L33:
        r102 = r115;
        goto L20
    L27:
        c r117 = (c) CollectionsKt.getOrNull(r100, r115);
        if (r117 == null) goto L33;
        int r118 = r116.f524692d;
        int r119 = r117.f524691c;
        if (r212 == null) goto L35;
        c(r212.substring(r118, r119), r116.f524689a, r116.f524690b, r112);
        goto L33
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        if (r112.isEmpty() == false) goto L39;
        return;
    L39:
        StringBuilder r120 = new StringBuilder();
        Iterator r121 = r112.iterator();
    L41:
        if (r121.hasNext() == false) goto L43;
        r120.append(((d) r121.next()).f524693a);
        goto L41
    L43:
        ArrayList r122 = (ArrayList) r213;
        r122.add(new b(r120.toString(), r210));
    }
}
