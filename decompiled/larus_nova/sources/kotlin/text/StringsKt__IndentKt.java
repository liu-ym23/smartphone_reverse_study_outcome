package kotlin.text;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public StringsKt__IndentKt() {
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
    L9:
        return new StringsKt__IndentKt$getIndentFunction$2(r100);
    L5:
        r101 = false;
        goto L6
    }

    private static final int indentWidth$StringsKt__IndentKt(String r100) {
        int r101 = r100.length();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L9;
        if ((!CharsKt.isWhitespace(r100.charAt(r102))) == true) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 == (-1)) goto L12;
        return r102;
    L12:
        return r100.length();
    L9:
        r102 = -1;
        goto L10
    }

    public static String trimIndent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return replaceIndent(r100, "");
    }

    public static final String prependIndent(String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(r110), new AnonymousClass1(r111)), "\n", null, null, 0, null, null, 62, null);
    }

    public static final String replaceIndent(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "newIndent");
        List r100 = StringsKt.lines(r110);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((!StringsKt.isBlank((String) r103)) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) r105.next())));
        goto L10
    L12:
        Integer r106 = (Integer) CollectionsKt.minOrNull(r104);
        int r107 = 0;
        if (r106 == null) goto L15;
        int r108 = r106.intValue();
    L16:
        int r112 = r110.length() + (r111.length() * r100.size());
        Function1<String, String> r113 = getIndentFunction$StringsKt__IndentKt(r111);
        int r109 = CollectionsKt.getLastIndex(r100);
        ArrayList r114 = new ArrayList();
        Iterator r115 = r100.iterator();
    L18:
        if (r115.hasNext() == false) goto L38;
        Object r116 = r115.next();
        int r117 = r107 + 1;
        if (r107 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r118 = (String) r116;
        if (r107 == 0) goto L26;
        if (r107 == r109) goto L26;
    L28:
        String r119 = StringsKt.drop(r118, r108);
        if (r119 == null) goto L34;
        String r120 = r113.invoke(r119);
        if (r120 == null) goto L34;
        r118 = r120;
    L34:
        if (r118 == null) goto L36;
        r114.add(r118);
    L36:
        r107 = r117;
    L26:
        if (StringsKt.isBlank(r118) == false) goto L28;
        r118 = null;
        goto L34
    L38:
        return ((StringBuilder) CollectionsKt.joinTo$default(r114, new StringBuilder(r112), "\n", null, null, 0, null, null, 124, null)).toString();
    L15:
        r108 = 0;
        goto L16
    }

    public static final String trimMargin(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "marginPrefix");
        return replaceIndentByMargin(r100, "", r101);
    }

    public static final String replaceIndentByMargin(String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter(r211, "newIndent");
        Intrinsics.checkNotNullParameter(r212, "marginPrefix");
        if ((!StringsKt.isBlank(r212)) == false) goto L40;
        List r100 = StringsKt.lines(r210);
        int r101 = r210.length() + (r211.length() * r100.size());
        Function1<String, String> r102 = getIndentFunction$StringsKt__IndentKt(r211);
        int r110 = CollectionsKt.getLastIndex(r100);
        ArrayList r111 = new ArrayList();
        Iterator r103 = r100.iterator();
        int r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L38;
        Object r105 = r103.next();
        int r112 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r113 = (String) r105;
        String r114 = null;
        if (r104 == 0) goto L14;
        if (r104 == r110) goto L14;
    L16:
        int r106 = r113.length();
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L23;
        if ((!CharsKt.isWhitespace(r113.charAt(r107))) == true) goto L21;
        r107 = r107 + 1;
        goto L18
    L21:
        int r108 = r107;
    L24:
        if (r108 == (-1)) goto L29;
        int r115 = r108;
        if (StringsKt__StringsJVMKt.startsWith$default(r113, r212, r108, false, 4, null) == false) goto L29;
        int r109 = r115 + r212.length();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type java.lang.String");
        r114 = r113.substring(r109);
    L29:
        if (r114 == null) goto L34;
        String r116 = r102.invoke(r114);
        if (r116 == null) goto L34;
        r113 = r116;
    L34:
        if (r113 == null) goto L36;
        r111.add(r113);
    L36:
        r104 = r112;
        goto L6
    L23:
        r108 = -1;
    L14:
        if (StringsKt.isBlank(r113) == false) goto L16;
        r113 = null;
        goto L34
    L38:
        return ((StringBuilder) CollectionsKt.joinTo$default(r111, new StringBuilder(r101), "\n", null, null, 0, null, null, 124, null)).toString();
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String prependIndent$default(String r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = LineContent.FOUR_SPACE;
    L6:
        return prependIndent(r100, r101);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> r110, int r111, Function1<? super String, String> r112, Function1<? super String, String> r113) {
        int r100 = CollectionsKt.getLastIndex(r110);
        ArrayList r101 = new ArrayList();
        Iterator<T> r114 = r110.iterator();
        int r102 = 0;
    L4:
        if (r114.hasNext() == false) goto L28;
        Object r103 = r114.next();
        int r104 = r102 + 1;
        if (r102 < 0) goto L8;
    L12:
        String r105 = (String) r103;
        if (r102 == 0) goto L16;
        if (r102 == r100) goto L16;
    L18:
        String r106 = r113.invoke(r105);
        if (r106 == null) goto L24;
        String r107 = r112.invoke(r106);
        if (r107 == null) goto L24;
        r105 = r107;
    L24:
        if (r105 == null) goto L26;
        r101.add(r105);
    L26:
        r102 = r104;
    L16:
        if (StringsKt.isBlank(r105) == false) goto L18;
        r105 = null;
        goto L24
    L8:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L11;
        CollectionsKt.throwIndexOverflow();
        goto L12
    L11:
        throw new ArithmeticException("Index overflow has happened.");
    L28:
        return ((StringBuilder) CollectionsKt.joinTo$default(r101, new StringBuilder(r111), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String replaceIndent$default(String r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = "";
    L6:
        return replaceIndent(r100, r101);
    }

    public static /* synthetic */ String trimMargin$default(String r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
    L6:
        return trimMargin(r100, r101);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
    L9:
        return replaceIndentByMargin(r100, r101, r102);
    }
}
