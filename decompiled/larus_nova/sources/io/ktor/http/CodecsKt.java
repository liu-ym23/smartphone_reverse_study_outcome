package io.ktor.http;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes41.dex */
public final class CodecsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Byte> f491800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Character> f491801b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Character> f491802c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Byte> f491803d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Character> f491804e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<Character> f491805f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Byte> f491806g = null;

    public static final int b(char r100) {
        boolean r101 = true;
        if ('0' <= r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L28;
        char r103 = 'A';
        if ('A' <= r100) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L29;
        r103 = 'a';
        if ('a' <= r100) goto L21;
    L23:
        r101 = false;
    L24:
        if (r101 == true) goto L29;
        return -1;
    L21:
        if (r100 >= 'g') goto L23;
    L29:
        return (r100 - r103) + 10;
    L13:
        if (r100 >= 'G') goto L15;
        r104 = true;
        goto L16
    L28:
        return r100 - '0';
    L5:
        if (r100 >= ':') goto L7;
        r102 = true;
        goto L8
    }

    static {
        List r100 = CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', Matrix.MATRIX_TYPE_ZERO)), new CharRange('0', '9'));
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(Byte.valueOf((byte) ((Character) r102.next()).charValue()));
        goto L4
    L6:
        f491800a = CollectionsKt.toSet(r101);
        f491801b = CollectionsKt.toSet(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', Matrix.MATRIX_TYPE_ZERO)), new CharRange('0', '9')));
        f491802c = CollectionsKt.toSet(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'f'), new CharRange('A', 'F')), new CharRange('0', '9')));
        Set r103 = SetsKt.setOf(new Character[]{':', '/', '?', '#', '[', ']', '@', '!', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '\'', '(', ')', '*', ',', ';', Character.valueOf(com.alipay.sdk.m.n.a.f25612h), '-', '.', '_', '~', '+'});
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r110.add(Byte.valueOf((byte) ((Character) r104.next()).charValue()));
        goto L8
    L10:
        f491803d = r110;
        f491804e = SetsKt.setOf(new Character[]{':', '@', '!', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '\'', '(', ')', '*', '+', ',', ';', Character.valueOf(com.alipay.sdk.m.n.a.f25612h), '-', '.', '_', '~'});
        f491805f = SetsKt.plus(f491801b, SetsKt.setOf(new Character[]{'!', '#', Character.valueOf(Typography.dollar), Character.valueOf(Typography.amp), '+', '-', '.', '^', '_', '`', '|', '~'}));
        List r105 = CollectionsKt.listOf(new Character[]{'-', '.', '_', '~'});
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r106.add(Byte.valueOf((byte) ((Character) r107.next()).charValue()));
        goto L12
    L14:
        f491806g = r106;
    }

    public static final String a(byte r100) {
        int r101 = r100 & UByte.MAX_VALUE;
        char[] r102 = new char[3];
        boolean r103 = false;
        r102[0] = '%';
        int r104 = r101 >> 4;
        if (r104 < 0) goto L6;
        if (r104 >= 10) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
        int r106 = r104 + 48;
    L10:
        r102[1] = (char) r106;
        int r107 = r101 & 15;
        if (r107 < 0) goto L14;
        if (r107 >= 10) goto L14;
        r103 = true;
    L14:
        if (r103 == false) goto L16;
        int r108 = r107 + 48;
    L17:
        r102[2] = (char) r108;
        return StringsKt.concatToString(r102);
    L16:
        r108 = ((char) (r107 + 65)) - '\n';
        goto L17
    L9:
        r106 = ((char) (r104 + 65)) - '\n';
    L6:
        r105 = false;
        goto L7
    }

    public static String d(String r100) {
        int r101 = r100.length();
        Charset r102 = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "charset");
        return c(r100, 0, r101, false, r102);
    }

    public static final String g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return f(r100, true);
    }

    public static final String f(String r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final StringBuilder r102 = new StringBuilder();
        h(ksc.b.b(Charsets.UTF_8.newEncoder(), r100, 0, r100.length()), new CodecsKt$encodeURLParameter$1$1(r102, r101));
        return r102.toString();
    }

    public static final void h(io.ktor.utils.io.core.k r100, Function1<? super Byte, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = true;
        io.ktor.utils.io.core.internal.a r103 = r100.m(1);
        if (r103 != null) goto L24;
        return;
    L24:
        int r104 = r103.f492022c;     // Catch: Throwable -> L12
        int r105 = r103.f492021b;     // Catch: Throwable -> L12
        if (r104 <= r105) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L10;
        r103 = io.ktor.utils.io.core.internal.c.b(r100, r103);     // Catch: Throwable -> L19
        if (r103 != null) goto L24;
        return;
    L19:
        th = th;
        r102 = false;
    L21:
        if (r102 == false) goto L23;
        io.ktor.utils.io.core.internal.c.a(r100, r103);
    L23:
        throw th;
    L10:
        if (r105 == r104) goto L15;
        r103.f492021b = r105 + 1;     // Catch: Throwable -> L12
        r101.invoke(Byte.valueOf(r103.f492020a.get(r105)));     // Catch: Throwable -> L12
        goto L24
    L15:
        throw new EOFException("No readable bytes available.");     // Catch: Throwable -> L12
    L8:
        r106 = false;
    L12:
        th = th;
        goto L21
    }

    public static final String c(String r110, int r111, int r112, boolean r113, Charset r114) {
        int r100 = r111;
    L3:
        if (r100 >= r112) goto L44;
        char r101 = r110.charAt(r100);
        if (r101 == '%') goto L10;
        if (r113 == false) goto L9;
        if (r101 == '+') goto L10;
    L9:
        r100 = r100 + 1;
    L10:
        int r102 = r112 - r111;
        if (r102 <= 255) goto L13;
        r102 = r102 / 3;
    L13:
        StringBuilder r103 = new StringBuilder(r102);
        if (r100 <= r111) goto L16;
        r103.append(r110, r111, r100);
    L16:
        byte[] r104 = null;
    L17:
        if (r100 >= r112) goto L43;
        char r105 = r110.charAt(r100);
        if (r113 == false) goto L22;
        if (r105 != '+') goto L22;
        r103.append(' ');
    L41:
        r100 = r100 + 1;
    L22:
        if (r105 != '%') goto L40;
        if (r104 != null) goto L25;
        r104 = new byte[(r112 - r100) / 3];
    L25:
        int r106 = 0;
    L26:
        if (r100 >= r112) goto L39;
        if (r110.charAt(r100) != '%') goto L39;
        int r107 = r100 + 2;
        if (r107 >= r112) goto L38;
        int r115 = r100 + 1;
        int r116 = b(r110.charAt(r115));
        int r117 = b(r110.charAt(r107));
        if (r116 == (-1)) goto L36;
        if (r117 == (-1)) goto L36;
        r104[r106] = (byte) ((r116 * 16) + r117);
        r100 = r100 + 3;
        r106 = r106 + 1;
    L36:
        throw new URLDecodeException("Wrong HEX escape: %" + r110.charAt(r115) + r110.charAt(r107) + ", in " + r110 + ", at " + r100);
    L38:
        throw new URLDecodeException("Incomplete trailing HEX escape: " + r110.subSequence(r100, r110.length()).toString() + ", in " + r110 + " at " + r100);
    L39:
        r103.append(new String(r104, 0, r106, r114));
        goto L17
    L40:
        r103.append(r105);
        goto L41
    L43:
        return r103.toString();
    L44:
        if (r111 != 0) goto L49;
        if (r112 != r110.length()) goto L49;
        return r110;
    L49:
        return r110.substring(r111, r112);
    }

    public static String e(String r100, int r101, int r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        Charset r105 = Charsets.UTF_8;
    L15:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r105, "charset");
        return c(r100, r101, r102, r103, r105);
    L14:
        r105 = null;
        goto L15
    }
}
