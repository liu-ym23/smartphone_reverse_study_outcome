package hda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484639a = 0;

    static {
    }

    public static String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "text");
        String r111 = StringsKt.replace$default(StringsKt.replace$default(r110, "\r\n", "\n", false, 4, null), "\r", "\n", false, 4, null);
        String r112 = new Regex("```(?:\\w+)?\\n?([\\s\\S]*?)```").replace(r111, new y0());
        String r113 = new Regex("(?m)^\\s*[-*_]{3,}\\s*$").replace(r112, "");
        String r114 = new Regex("!\\[([^]]*)]\\([^)]*\\)").replace(r113, "$1");
        String r115 = new Regex("\\[([^]]+)]\\([^)]*\\)").replace(r114, "$1");
        String r116 = new Regex("(?m)^\\s*>+\\s?").replace(r115, "");
        String r117 = new Regex("(?m)^\\s{0,3}#{1,6}\\s*").replace(r116, "");
        String r118 = new Regex("(?m)^\\s*[-*+]\\s*\\[[ xX]]\\s*").replace(r117, "");
        String r119 = new Regex("(?m)^\\s*[-*+][ \\t]+").replace(r118, "");
        String r120 = new Regex("(?m)^\\s*\\d+(?:[.)][ \\t]+|、[ \\t]*)").replace(r119, "");
        String r121 = new Regex("(?m)^\\s*\\|?\\s*:?-{3,}:?\\s*(\\|\\s*:?-{3,}:?\\s*)+\\|?\\s*$").replace(r120, "");
        String r122 = new Regex("(?<!\\d)(?:\\+?86)?1\\d{2}\\*{4}\\d{4}(?!\\d)|[*_`~>#]+").replace(r121, new z0());
        String r123 = new Regex("<[^>]+>").replace(r122, "");
        return StringsKt.trim(CollectionsKt.joinToString$default(StringsKt.lines(new Regex("[ \\t]+").replace(r123, " ")), "\n", null, null, 0, null, new a1(), 30, null)).toString();
    }

    public static List b(String r100) {
        if (r100.length() <= 80) goto L5;
        List<String> r101 = new Regex("(?<=[。！？!?；;])").split(r100, 0);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(StringsKt.trim((String) r103.next()).toString());
        goto L8
    L10:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        Object r106 = r105.next();
        if ((!StringsKt.isBlank((String) r106)) == false) goto L12;
        r104.add(r106);
        goto L12
    L16:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L18:
        if (r108.hasNext() == false) goto L24;
        String r109 = (String) r108.next();
        if (r109.length() > 80) goto L22;
        List r110 = CollectionsKt.listOf(r109);
    L23:
        CollectionsKt.addAll(r107, r110);
        goto L18
    L22:
        r110 = StringsKt.chunked(r109, 80);
        goto L23
    L24:
        boolean r111 = r107.isEmpty();
        List r112 = r107;
        if (r111 == false) goto L32;
        if (r100.length() > 80) goto L29;
        List r113 = CollectionsKt.listOf(r100);
    L30:
        r112 = r113;
        goto L32
    L29:
        r113 = StringsKt.chunked(r100, 80);
    L32:
        return r112;
    L5:
        return CollectionsKt.listOf(r100);
    }

    public static List c(String r100) {
        if (StringsKt.isBlank(r100) == true) goto L5;
        List r101 = StringsKt.lines(r100);
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(StringsKt.trim((String) r103.next()).toString());
        goto L8
    L10:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L17;
        Object r106 = r105.next();
        if ((true ^ StringsKt.isBlank((String) r106)) == false) goto L12;
        r104.add(r106);
        goto L12
    L17:
        if (r104.size() <= 1) goto L24;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L20:
        if (r108.hasNext() == false) goto L22;
        CollectionsKt.addAll(r107, b((String) r108.next()));
        goto L20
    L22:
        return r107;
    L24:
        return b((String) CollectionsKt.single(r104));
    L5:
        return CollectionsKt.emptyList();
    }
}
