package kotlin.text;

import android.util.EventsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", XmlPullParser.NO_NAMESPACE, "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", XmlPullParser.NO_NAMESPACE, "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", XmlPullParser.NO_NAMESPACE, "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public StringsKt__IndentKt() {
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String r1) {
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return getIndentFunction.1.INSTANCE;
    L9:
        return new getIndentFunction.2(r1);
    L5:
        r0 = false;
        goto L6
    }

    private static final int indentWidth$StringsKt__IndentKt(String r4) {
        int r0 = r4.length();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        if ((!CharsKt.isWhitespace(r4.charAt(r1))) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 == (-1)) goto L12;
        return r1;
    L12:
        return r4.length();
    L9:
        r1 = -1;
        goto L10
    }

    public static String trimIndent(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return replaceIndent(r1, XmlPullParser.NO_NAMESPACE);
    }

    public static final String prependIndent(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(r10), new prependIndent.1(r11)), "\n", null, null, 0, null, null, 62, null);
    }

    public static final String replaceIndent(String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r15, "newIndent");
        List r0 = StringsKt.lines(r14);
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if ((!StringsKt.isBlank((String) r3)) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) r5.next())));
        goto L10
    L12:
        Integer r6 = (Integer) CollectionsKt.minOrNull(r4);
        int r7 = 0;
        if (r6 == null) goto L15;
        int r8 = r6.intValue();
    L16:
        int r16 = r14.length() + (r15.length() * r0.size());
        Function1<String, String> r17 = getIndentFunction$StringsKt__IndentKt(r15);
        int r9 = CollectionsKt.getLastIndex(r0);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r0.iterator();
    L18:
        if (r11.hasNext() == false) goto L38;
        Object r12 = r11.next();
        int r13 = r7 + 1;
        if (r7 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r18 = (String) r12;
        if (r7 == 0) goto L26;
        if (r7 == r9) goto L26;
    L28:
        String r19 = StringsKt.drop(r18, r8);
        if (r19 == null) goto L34;
        String r20 = r17.invoke(r19);
        if (r20 == null) goto L34;
        r18 = r20;
    L34:
        if (r18 == null) goto L36;
        r10.add(r18);
    L36:
        r7 = r13;
    L26:
        if (StringsKt.isBlank(r18) == false) goto L28;
        r18 = null;
        goto L34
    L38:
        return ((StringBuilder) CollectionsKt.joinTo$default(r10, new StringBuilder(r16), "\n", null, null, 0, null, null, 124, null)).toString();
    L15:
        r8 = 0;
        goto L16
    }

    public static final String trimMargin(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "marginPrefix");
        return replaceIndentByMargin(r1, XmlPullParser.NO_NAMESPACE, r2);
    }

    public static final String replaceIndentByMargin(String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Intrinsics.checkNotNullParameter(r22, "newIndent");
        Intrinsics.checkNotNullParameter(r23, "marginPrefix");
        if ((!StringsKt.isBlank(r23)) == false) goto L40;
        List r0 = StringsKt.lines(r21);
        int r8 = r21.length() + (r22.length() * r0.size());
        Function1<String, String> r9 = getIndentFunction$StringsKt__IndentKt(r22);
        int r10 = CollectionsKt.getLastIndex(r0);
        ArrayList r11 = new ArrayList();
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L38;
        Object r3 = r1.next();
        int r13 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r14 = (String) r3;
        String r15 = null;
        if (r2 == 0) goto L14;
        if (r2 == r10) goto L14;
    L16:
        int r4 = r14.length();
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L23;
        if ((!CharsKt.isWhitespace(r14.charAt(r5))) == true) goto L21;
        r5 = r5 + 1;
        goto L18
    L21:
        int r6 = r5;
    L24:
        if (r6 == (-1)) goto L29;
        int r17 = r6;
        if (StringsKt__StringsJVMKt.startsWith$default(r14, r23, r6, false, 4, null) == false) goto L29;
        int r7 = r17 + r23.length();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        r15 = r14.substring(r7);
    L29:
        if (r15 == null) goto L34;
        String r12 = r9.invoke(r15);
        if (r12 == null) goto L34;
        r14 = r12;
    L34:
        if (r14 == null) goto L36;
        r11.add(r14);
    L36:
        r2 = r13;
        goto L6
    L23:
        r6 = -1;
    L14:
        if (StringsKt.isBlank(r14) == false) goto L16;
        r14 = null;
        goto L34
    L38:
        return ((StringBuilder) CollectionsKt.joinTo$default(r11, new StringBuilder(r8), "\n", null, null, 0, null, null, 124, null)).toString();
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String prependIndent$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "    ";
    L6:
        return prependIndent(r0, r1);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> r11, int r12, Function1<? super String, String> r13, Function1<? super String, String> r14) {
        int r0 = CollectionsKt.getLastIndex(r11);
        ArrayList r1 = new ArrayList();
        Iterator<T> r15 = r11.iterator();
        int r3 = 0;
    L4:
        if (r15.hasNext() == false) goto L28;
        Object r4 = r15.next();
        int r5 = r3 + 1;
        if (r3 < 0) goto L8;
    L12:
        String r6 = (String) r4;
        if (r3 == 0) goto L16;
        if (r3 == r0) goto L16;
    L18:
        String r7 = r14.invoke(r6);
        if (r7 == null) goto L24;
        String r8 = r13.invoke(r7);
        if (r8 == null) goto L24;
        r6 = r8;
    L24:
        if (r6 == null) goto L26;
        r1.add(r6);
    L26:
        r3 = r5;
    L16:
        if (StringsKt.isBlank(r6) == false) goto L18;
        r6 = null;
        goto L24
    L8:
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0) == false) goto L11;
        CollectionsKt.throwIndexOverflow();
        goto L12
    L11:
        throw new ArithmeticException("Index overflow has happened.");
    L28:
        return ((StringBuilder) CollectionsKt.joinTo$default(r1, new StringBuilder(r12), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static /* synthetic */ String replaceIndent$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = XmlPullParser.NO_NAMESPACE;
    L6:
        return replaceIndent(r0, r1);
    }

    public static /* synthetic */ String trimMargin$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "|";
    L6:
        return trimMargin(r0, r1);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = XmlPullParser.NO_NAMESPACE;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = "|";
    L9:
        return replaceIndentByMargin(r0, r1, r2);
    }
}
