package com.bytedance.sync.diff;

import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes22.dex */
public final class DiffMatchPatch {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f270355i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f270356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f270357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f270358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f270359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final short f270360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final short f270361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Pattern f270362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pattern f270363h;

    public static final enum Operation extends Enum<Operation> {
        public static final Operation DELETE = null;
        public static final Operation EQUAL = null;
        public static final Operation INSERT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operation[] f270364a = null;

        static {
            Operation r100 = new Operation("DELETE", 0);
            DELETE = r100;
            Operation r101 = new Operation("INSERT", 1);
            INSERT = r101;
            Operation r102 = new Operation("EQUAL", 2);
            EQUAL = r102;
            f270364a = new Operation[]{r100, r101, r102};
        }

        public static Operation[] values() {
            return (Operation[]) f270364a.clone();
        }

        public static Operation valueOf(String r100) {
            return (Operation) r27.a.a(Operation.class, r100);
        }

        public Operation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270365a = null;

        static {
            int[] r100 = new int[Operation.values().length];
            f270365a = r100;
            r100[Operation.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f270365a[Operation.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f270365a[Operation.EQUAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Operation f270366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f270367b;

        public final int hashCode() {
            Operation r100 = this.f270366a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            String r103 = this.f270367b;
            if (r103 == null) goto L11;
            r101 = r103.hashCode();
        L11:
            return r102 + (r101 * 31);
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Diff(" + this.f270366a + ",\"" + this.f270367b.replace('\n', Typography.paragraph) + "\")";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (b.class == r100.getClass()) goto L11;
            return false;
        L11:
            b r101 = (b) r100;
            if (this.f270366a == r101.f270366a) goto L14;
            return false;
        L14:
            String r102 = this.f270367b;
            if (r102 != null) goto L20;
            if (r101.f270367b == null) goto L22;
            return false;
        L22:
            return true;
        L20:
            if (r102.equals(r101.f270367b) == true) goto L22;
            return false;
        }

        public b(Operation r100, String r101) {
            this.f270366a = r100;
            this.f270367b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedList<b> f270368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f270369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f270370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f270371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f270372e;

        public final String toString() {
            int r100 = this.f270371d;
            if (r100 != 0) goto L5;
            String r101 = this.f270369b + ",0";
        L8:
            int r102 = this.f270372e;
            if (r102 != 0) goto L11;
            String r103 = this.f270370c + ",0";
        L14:
            StringBuilder r104 = new StringBuilder("@@ -");
            r104.append(r101);
            r104.append(" +");
            r104.append(r103);
            r104.append(" @@\n");
            Iterator<b> r105 = this.f270368a.iterator();
        L16:
            if (r105.hasNext() == false) goto L32;
            b r106 = r105.next();
            int r107 = a.f270365a[r106.f270366a.ordinal()];
            if (r107 != 1) goto L20;
            r104.append('+');
        L34:
            r104.append(URLEncoder.encode(r106.f270367b, "UTF-8").replace('+', ' '));     // Catch: UnsupportedEncodingException -> L29
            r104.append("\n");     // Catch: UnsupportedEncodingException -> L29
        L29:
            e = move-exception;
            throw new Error("This system does not support UTF-8.", e);
        L20:
            if (r107 != 2) goto L22;
            r104.append('-');
            goto L34
        L22:
            if (r107 != 3) goto L34;
            r104.append(' ');
            goto L34
        L32:
            String r108 = r104.toString();
            int r109 = DiffMatchPatch.f270355i;
            return r108.replace("%21", "!").replace("%7E", Constants.WAVE_SEPARATOR).replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%3B", i.f25853b).replace("%2F", HTTP.URL_DEFAULT).replace("%3F", "?").replace("%3A", ":").replace("%40", "@").replace("%26", "&").replace("%3D", ContainerUtils.KEY_VALUE_DELIMITER).replace("%2B", Marker.ANY_NON_NULL_MARKER).replace("%24", "$").replace("%2C", ",").replace("%23", "#");
        L11:
            if (r102 != 1) goto L13;
            r103 = Integer.toString(this.f270370c + 1);
            goto L14
        L13:
            r103 = (this.f270370c + 1) + "," + this.f270372e;
            goto L14
        L5:
            if (r100 != 1) goto L7;
            r101 = Integer.toString(this.f270369b + 1);
            goto L8
        L7:
            r101 = (this.f270369b + 1) + "," + this.f270371d;
            goto L8
        }

        public c() {
            this.f270368a = new LinkedList();
        }
    }

    public DiffMatchPatch() {
        this.f270356a = 1.0f;
        this.f270357b = 0.5f;
        this.f270358c = 1000;
        this.f270359d = 0.5f;
        this.f270360e = 4;
        this.f270361f = 32;
        this.f270362g = PatternProtector.compile("\\n\\r?\\n\\Z", 32);
        this.f270363h = PatternProtector.compile("\\A\\r?\\n\\r?\\n", 32);
    }

    static {
    }

    public static void c(LinkedList r110) {
        r110.add(new b(Operation.EQUAL, ""));
        ListIterator r100 = r110.listIterator();
        b r101 = (b) r100.next();
        String r102 = "";
        String r103 = r102;
        b r104 = null;
        int r105 = 0;
        int r106 = 0;
    L3:
        boolean r111 = true;
        if (r101 == null) goto L57;
        int r112 = a.f270365a[r101.f270366a.ordinal()];
        if (r112 != 1) goto L8;
        r105 = r105 + 1;
        r102 = r102 + r101.f270367b;
    L51:
        r104 = null;
    L53:
        if (r100.hasNext() == true) goto L54;
        r101 = null;
        goto L3
    L54:
        r101 = (b) r100.next();
        goto L3
    L8:
        if (r112 != 2) goto L10;
        r106 = r106 + 1;
        r103 = r103 + r101.f270367b;
        goto L51
    L10:
        if (r112 != 3) goto L53;
        if ((r106 + r105) <= 1) goto L46;
        if (r106 == 0) goto L17;
        if (r105 == 0) goto L17;
    L18:
        r100.previous();
    L19:
        int r107 = r106 - 1;
        if (r106 <= 0) goto L22;
        r100.previous();
        r100.remove();
        r106 = r107;
    L22:
        int r108 = r105 - 1;
        if (r105 <= 0) goto L25;
        r100.previous();
        r100.remove();
        r105 = r108;
        goto L22
    L25:
        if (r111 == false) goto L37;
        int r109 = f(r102, r103);
        if (r109 != 0) goto L29;
    L33:
        int r113 = g(r102, r103);
        if (r113 == 0) goto L37;
        b r114 = (b) r100.next();
        r114.f270367b = r102.substring(r102.length() - r113) + r114.f270367b;
        r102 = r102.substring(0, r102.length() - r113);
        r103 = r103.substring(0, r103.length() - r113);
        r100.previous();
        goto L37
    L29:
        if (r100.hasPrevious() == false) goto L31;
        ((b) r100.previous()).f270367b += r102.substring(0, r109);
        r100.next();
    L32:
        String r115 = r102.substring(r109);
        r103 = r103.substring(r109);
        r102 = r115;
        goto L33
    L31:
        r100.add(new b(Operation.EQUAL, r102.substring(0, r109)));
    L37:
        if (r103.length() == 0) goto L40;
        r100.add(new b(Operation.DELETE, r103));
    L40:
        if (r102.length() == 0) goto L43;
        r100.add(new b(Operation.INSERT, r102));
    L43:
        if (r100.hasNext() == false) goto L45;
        r101 = (b) r100.next();
    L48:
        r104 = r101;
        r102 = "";
        r103 = r102;
        r105 = 0;
        r106 = 0;
        goto L53
    L45:
        r101 = null;
    L17:
        r111 = false;
        goto L18
    L46:
        if (r104 == null) goto L48;
        r104.f270367b += r101.f270367b;
        r100.remove();
        r101 = (b) r100.previous();
        r100.next();
        goto L48
    L57:
        if (((b) r110.getLast()).f270367b.length() != 0) goto L59;
        r110.removeLast();
    L59:
        ListIterator r116 = r110.listIterator();
        if (r116.hasNext() == false) goto L62;
        b r117 = (b) r116.next();
    L64:
        if (r116.hasNext() == false) goto L66;
        b r118 = (b) r116.next();
    L68:
        if (r116.hasNext() == false) goto L70;
        b r119 = (b) r116.next();
    L71:
        boolean r120 = false;
    L72:
        if (r119 == null) goto L96;
        Operation r121 = r117.f270366a;
        Operation r122 = Operation.EQUAL;
        if (r121 == r122) goto L76;
    L91:
        r117 = r118;
        r118 = r119;
    L93:
        if (r116.hasNext() == true) goto L94;
        r119 = null;
        goto L72
    L94:
        r119 = (b) r116.next();
        goto L72
    L76:
        if (r119.f270366a != r122) goto L91;
        if (r118.f270367b.endsWith(r117.f270367b) == false) goto L85;
        StringBuilder r123 = new StringBuilder();
        r123.append(r117.f270367b);
        String r124 = r118.f270367b;
        r123.append(r124.substring(0, r124.length() - r117.f270367b.length()));
        r118.f270367b = r123.toString();
        r119.f270367b = r117.f270367b + r119.f270367b;
        r116.previous();
        r116.previous();
        r116.previous();
        r116.remove();
        r116.next();
        r117 = (b) r116.next();
        if (r116.hasNext() == false) goto L82;
        r118 = (b) r116.next();
    L83:
        r120 = true;
        goto L93
    L82:
        r118 = null;
        goto L83
    L85:
        if (r118.f270367b.startsWith(r119.f270367b) == false) goto L91;
        r117.f270367b += r119.f270367b;
        r118.f270367b = r118.f270367b.substring(r119.f270367b.length()) + r119.f270367b;
        r116.remove();
        if (r116.hasNext() == false) goto L89;
        b r125 = (b) r116.next();
    L90:
        r120 = true;
        b r126 = r118;
        r118 = r125;
        r117 = r126;
        goto L93
    L89:
        r125 = null;
        goto L90
    L96:
        if (r120 == false) goto L113;
        c(r110);
        return;
    L113:
        return;
    L70:
        r119 = null;
        goto L71
    L66:
        r118 = null;
        goto L68
    L62:
        r117 = null;
        goto L64
    }

    public static String j(List r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        b r103 = (b) r102.next();
        if (r103.f270366a == Operation.INSERT) goto L4;
        r101.append(r103.f270367b);
        goto L4
    L9:
        return r101.toString();
    }

    public static String k(List r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        b r103 = (b) r102.next();
        if (r103.f270366a == Operation.DELETE) goto L4;
        r101.append(r103.f270367b);
        goto L4
    L9:
        return r101.toString();
    }

    public final void d(LinkedList<b> r110) {
        ListIterator<b> r100 = r110.listIterator();
        if (r100.hasNext() == false) goto L5;
        b r101 = r100.next();
    L7:
        if (r100.hasNext() == false) goto L9;
        b r102 = r100.next();
    L11:
        if (r100.hasNext() == false) goto L49;
        b r103 = r100.next();
        DiffMatchPatch r104 = this;
    L15:
        if (r103 == null) goto L48;
        Operation r105 = r101.f270366a;
        Operation r106 = Operation.EQUAL;
        if (r105 == r106) goto L19;
    L43:
        r101 = r102;
        r102 = r103;
    L45:
        if (r100.hasNext() == true) goto L46;
        r104 = r104;
        r103 = null;
        goto L15
    L46:
        r103 = r100.next();
        goto L15
    L19:
        if (r103.f270366a != r106) goto L43;
        String r107 = r101.f270367b;
        String r108 = r102.f270367b;
        String r109 = r103.f270367b;
        int r111 = g(r107, r108);
        if (r111 == 0) goto L23;
        String r112 = r108.substring(r108.length() - r111);
        r107 = r107.substring(0, r107.length() - r111);
        r108 = r112 + r108.substring(0, r108.length() - r111);
        r109 = r112 + r109;
    L23:
        String r113 = r109;
        String r114 = r113;
        int r115 = r104.e(r107, r108) + r104.e(r108, r109);
        String r116 = r108;
        String r117 = r116;
        String r118 = r107;
    L25:
        if (r116.length() == 0) goto L34;
        if (r113.length() == 0) goto L34;
        if (r116.charAt(0) != r113.charAt(0)) goto L34;
        r118 = r118 + r116.charAt(0);
        r116 = r116.substring(1) + r113.charAt(0);
        r113 = r113.substring(1);
        int r119 = r104.e(r118, r116) + r104.e(r116, r113);
        if (r119 < r115) goto L25;
        r107 = r118;
        r117 = r116;
        r114 = r113;
        r115 = r119;
    L34:
        if (r101.f270367b.equals(r107) == true) goto L43;
        if (r107.length() == 0) goto L38;
        r101.f270367b = r107;
    L39:
        r102.f270367b = r117;
        if (r114.length() == 0) goto L42;
        r103.f270367b = r114;
        goto L43
    L42:
        r100.remove();
        goto L45
    L38:
        r100.previous();
        r100.previous();
        r100.previous();
        r100.remove();
        r100.next();
        r100.next();
        goto L39
    L48:
        return;
    L49:
        r104 = this;
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public static int f(String r100, String r101) {
        int r102 = Math.min(r100.length(), r101.length());
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (r100.charAt(r103) != r101.charAt(r103)) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L8:
        return r102;
    }

    public static int g(String r100, String r101) {
        int r102 = r100.length();
        int r103 = r101.length();
        int r104 = Math.min(r102, r103);
        int r105 = 1;
    L3:
        if (r105 > r104) goto L9;
        if (r100.charAt(r102 - r105) != r101.charAt(r103 - r105)) goto L7;
        r105 = r105 + 1;
        goto L3
    L7:
        return r105 - 1;
    L9:
        return r104;
    }

    public static int l(List r100, int r101) {
        Iterator r102 = r100.iterator();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r102.hasNext() == false) goto L14;
        b r107 = (b) r102.next();
        if (r107.f270366a == Operation.INSERT) goto L9;
        r103 = r103 + r107.f270367b.length();
    L9:
        if (r107.f270366a == Operation.DELETE) goto L11;
        r104 = r104 + r107.f270367b.length();
    L11:
        if (r103 > r101) goto L15;
        r105 = r103;
        r106 = r104;
    L15:
        if (r107 == null) goto L20;
        if (r107.f270366a != Operation.DELETE) goto L20;
        return r106;
    L20:
        return r106 + (r101 - r105);
    L14:
        r107 = null;
        goto L15
    }

    public final int e(String r110, String r111) {
        if (r110.length() != 0) goto L5;
        return 6;
    L5:
        if (r111.length() == 0) goto L69;
        char r100 = r110.charAt(r110.length() - 1);
        char r101 = r111.charAt(0);
        boolean r102 = !Character.isLetterOrDigit(r100);
        boolean r103 = !Character.isLetterOrDigit(r101);
        if (r102 == true) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r103 == true) goto L15;
    L17:
        boolean r105 = false;
    L19:
        if (r104 == true) goto L21;
    L23:
        boolean r106 = false;
    L24:
        if (r105 == true) goto L26;
    L28:
        boolean r107 = false;
    L29:
        if (r106 == true) goto L31;
    L33:
        boolean r112 = false;
    L34:
        if (r107 == true) goto L36;
    L38:
        boolean r113 = false;
    L39:
        if (r112 == true) goto L62;
        if (r113 == true) goto L68;
        if (r106 == true) goto L60;
        if (r107 == true) goto L67;
        if (r102 == false) goto L50;
        if (r104 == true) goto L50;
        if (r105 == false) goto L50;
        return 3;
    L50:
        if (r104 == true) goto L58;
        if (r105 == true) goto L66;
        if (r102 == true) goto L57;
        if (r103 == true) goto L57;
        return 0;
    L57:
        return 1;
    L66:
        return 2;
    L58:
        return 2;
    L67:
        return 4;
    L60:
        return 4;
    L68:
        return 5;
    L62:
        return 5;
    L36:
        if (this.f270363h.matcher(r111).find() == false) goto L38;
        r113 = true;
        goto L39
    L31:
        if (this.f270362g.matcher(r110).find() == false) goto L33;
        r112 = true;
        goto L34
    L26:
        if (Character.getType(r101) != 15) goto L28;
        r107 = true;
        goto L29
    L21:
        if (Character.getType(r100) != 15) goto L23;
        r106 = true;
        goto L24
    L15:
        if (Character.isWhitespace(r101) == false) goto L17;
        r105 = true;
        goto L19
    L10:
        if (Character.isWhitespace(r100) == false) goto L12;
        r104 = true;
        goto L13
    L69:
        return 6;
    }

    public static String[] h(String r110, String r111, int r112) {
        String r100 = r110.substring(r112, (r110.length() / 4) + r112);
        String r101 = "";
        int r102 = -1;
        String r103 = "";
        String r104 = r103;
        String r105 = r104;
        String r113 = r105;
        int r114 = -1;
    L3:
        r114 = r111.indexOf(r100, r114 + 1);
        if (r114 == r102) goto L10;
        int r115 = f(r110.substring(r112), r111.substring(r114));
        int r116 = g(r110.substring(0, r112), r111.substring(0, r114));
        if (r101.length() >= (r116 + r115)) goto L8;
        StringBuilder r106 = new StringBuilder();
        int r107 = r114 - r116;
        r106.append(r111.substring(r107, r114));
        int r108 = r114 + r115;
        r106.append(r111.substring(r114, r108));
        r101 = r106.toString();
        String r109 = r110.substring(0, r112 - r116);
        String r117 = r110.substring(r112 + r115);
        String r118 = r111.substring(0, r107);
        r113 = r111.substring(r108);
        r103 = r109;
        r104 = r117;
        r105 = r118;
    L8:
        r102 = -1;
        goto L3
    L10:
        if ((r101.length() * 2) >= r110.length()) goto L12;
        return null;
    L12:
        return new String[]{r103, r104, r105, r113, r101};
    }

    public final LinkedList<b> a(String r210, String r211, long r212) {
        int r100 = r210.length();
        int r101 = r211.length();
        int r102 = ((r100 + r101) + 1) / 2;
        int r103 = r102 * 2;
        int[] r104 = new int[r103];
        int[] r105 = new int[r103];
        int r106 = 0;
        int r110 = 0;
    L4:
        if (r110 >= r103) goto L6;
        r104[r110] = -1;
        r105[r110] = -1;
        r110 = r110 + 1;
        goto L4
    L6:
        int r111 = r102 + 1;
        r104[r111] = 0;
        r105[r111] = 0;
        int r112 = r100 - r101;
        if ((r112 % 2) == 0) goto L9;
        boolean r113 = true;
    L10:
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
    L11:
        if (r106 >= r102) goto L90;
        if (System.currentTimeMillis() > r212) goto L90;
        int r118 = -r106;
        int r119 = r115;
        int r107 = r118 + r114;
    L17:
        if (r107 > (r106 - r116)) goto L51;
        int r120 = r102 + r107;
        if (r107 == r118) goto L26;
        if (r107 == r106) goto L24;
        int r213 = r106;
        int r214 = r118;
        if (r104[r120 - 1] < r104[r120 + 1]) goto L27;
    L25:
        int r108 = r104[r120 - 1] + 1;
    L28:
        int r121 = r108 - r107;
    L29:
        if (r108 >= r100) goto L34;
        if (r121 >= r101) goto L34;
        int[] r215 = r105;
        if (r210.charAt(r108) != r211.charAt(r121)) goto L35;
        r108 = r108 + 1;
        r121 = r121 + 1;
        r210 = r210;
        r105 = r215;
    L35:
        r104[r120] = r108;
        if (r108 <= r100) goto L38;
        r116 = r116 + 2;
    L50:
        r107 = r107 + 2;
        r210 = r210;
        r105 = r215;
        r106 = r213;
        r118 = r214;
        goto L17
    L38:
        if (r121 <= r101) goto L40;
        r114 = r114 + 2;
        goto L50
    L40:
        if (r113 == false) goto L50;
        int r109 = (r102 + r112) - r107;
        if (r109 < 0) goto L50;
        if (r109 >= r103) goto L50;
        int r122 = r215[r109];
        if (r122 == (-1)) goto L50;
        if (r108 < (r100 - r122)) goto L50;
        return b(r210, r211, r108, r121, r212);
    L34:
        r215 = r105;
    L27:
        r108 = r104[r120 + 1];
        goto L28
    L24:
        r213 = r106;
        r214 = r118;
        goto L25
    L26:
        r213 = r106;
        r214 = r118;
        goto L27
    L51:
        int[] r216 = r105;
        int r217 = r106;
        int r218 = r118;
        int r123 = r218 + r119;
        r115 = r119;
    L53:
        if (r123 > (r217 - r117)) goto L89;
        int r124 = r102 + r123;
        int r125 = r218;
        if (r123 == r125) goto L63;
        int r126 = r217;
        if (r123 == r126) goto L61;
        r218 = r125;
        if (r216[r124 - 1] < r216[r124 + 1]) goto L64;
    L62:
        int r127 = r216[r124 - 1] + 1;
    L65:
        int r128 = r127 - r123;
    L66:
        if (r127 >= r100) goto L71;
        if (r128 >= r101) goto L71;
        int r219 = r114;
        int r129 = r116;
        if (r210.charAt((r100 - r127) - 1) != r211.charAt((r101 - r128) - 1)) goto L72;
        r127 = r127 + 1;
        r128 = r128 + 1;
        r116 = r129;
        r114 = r219;
    L72:
        r216[r124] = r127;
        if (r127 <= r100) goto L75;
        r117 = r117 + 2;
    L88:
        r123 = r123 + 2;
        r116 = r129;
        r114 = r219;
        r217 = r126;
        goto L53
    L75:
        if (r128 <= r101) goto L77;
        r115 = r115 + 2;
        goto L88
    L77:
        if (r113 == true) goto L88;
        int r130 = (r102 + r112) - r123;
        if (r130 < 0) goto L88;
        if (r130 >= r103) goto L88;
        int r131 = r104[r130];
        if (r131 == (-1)) goto L88;
        int r132 = (r102 + r131) - r130;
        if (r131 < (r100 - r127)) goto L88;
        return b(r210, r211, r131, r132, r212);
    L71:
        r219 = r114;
        r129 = r116;
    L64:
        r127 = r216[r124 + 1];
        goto L65
    L61:
        r218 = r125;
        goto L62
    L63:
        r218 = r125;
        r126 = r217;
        goto L64
    L89:
        r106 = r217 + 1;
        r105 = r216;
        r114 = r114;
    L90:
        LinkedList<b> r133 = new LinkedList();
        r133.add(new b(Operation.DELETE, r210));
        r133.add(new b(Operation.INSERT, r211));
        return r133;
    L9:
        r113 = false;
        goto L10
    }

    public final LinkedList i(String r110, String r111, long r112) {
        if (r110 == null) goto L79;
        if (r111 == null) goto L79;
        if (r110.equals(r111) == false) goto L10;
        LinkedList r113 = new LinkedList();
        if (r110.length() == 0) goto L9;
        r113.add(new b(Operation.EQUAL, r110));
    L9:
        return r113;
    L10:
        int r100 = f(r110, r111);
        String r101 = r110.substring(0, r100);
        String r114 = r110.substring(r100);
        String r115 = r111.substring(r100);
        int r102 = g(r114, r115);
        String r103 = r114.substring(r114.length() - r102);
        String r116 = r114.substring(0, r114.length() - r102);
        String r117 = r115.substring(0, r115.length() - r102);
        LinkedList<b> r104 = new LinkedList();
        if (r116.length() != 0) goto L14;
        r104.add(new b(Operation.INSERT, r117));
    L71:
        if (r101.length() == 0) goto L74;
        r104.addFirst(new b(Operation.EQUAL, r101));
    L74:
        if (r103.length() == 0) goto L76;
        r104.addLast(new b(Operation.EQUAL, r103));
    L76:
        c(r104);
        return r104;
    L14:
        if (r117.length() != 0) goto L17;
        r104.add(new b(Operation.DELETE, r116));
        goto L71
    L17:
        if (r116.length() <= r117.length()) goto L19;
        String r105 = r116;
    L21:
        if (r116.length() <= r117.length()) goto L23;
        String r106 = r117;
    L24:
        int r107 = r105.indexOf(r106);
        if (r107 == (-1)) goto L32;
        if (r116.length() <= r117.length()) goto L29;
        Operation r118 = Operation.DELETE;
    L30:
        r104.add(new b(r118, r105.substring(0, r107)));
        r104.add(new b(Operation.EQUAL, r106));
        r104.add(new b(r118, r105.substring(r107 + r106.length())));
        goto L71
    L29:
        r118 = Operation.INSERT;
        goto L30
    L32:
        if (r106.length() != 1) goto L35;
        r104.add(new b(Operation.DELETE, r116));
        r104.add(new b(Operation.INSERT, r117));
        goto L71
    L35:
        if (this.f270356a > 0.0f) goto L38;
    L66:
        String[] r108 = null;
    L67:
        if (r108 == null) goto L69;
        String r119 = r108[0];
        String r120 = r108[1];
        String r109 = r108[2];
        String r121 = r108[3];
        String r122 = r108[4];
        r104 = i(r119, r109, r112);
        LinkedList r123 = i(r120, r121, r112);
        r104.add(new b(Operation.EQUAL, r122));
        r104.addAll(r123);
        goto L71
    L69:
        r104 = a(r116, r117, r112);
        goto L71
    L38:
        if (r116.length() <= r117.length()) goto L40;
        String r124 = r116;
    L42:
        if (r116.length() <= r117.length()) goto L44;
        String r125 = r117;
    L46:
        if (r124.length() < 4) goto L66;
        if ((r125.length() * 2) < r124.length()) goto L66;
        r108 = h(r124, r125, (r124.length() + 3) / 4);
        String[] r126 = h(r124, r125, (r124.length() + 1) / 2);
        if (r108 != null) goto L54;
        if (r126 == null) goto L66;
    L54:
        if (r126 == null) goto L63;
        if (r108 != null) goto L59;
    L61:
        r108 = r126;
        goto L63
    L59:
        if (r108[4].length() <= r126[4].length()) goto L61;
    L63:
        if (r116.length() > r117.length()) goto L67;
        r108 = new String[]{r108[2], r108[3], r108[0], r108[1], r108[4]};
        goto L67
    L44:
        r125 = r116;
        goto L46
    L40:
        r124 = r117;
        goto L42
    L23:
        r106 = r116;
        goto L24
    L19:
        r105 = r117;
    L79:
        throw new IllegalArgumentException("Null inputs. (diff_main)");
    }

    public final int n(String r210, String r211, int r212) {
        if (r210 == null) goto L65;
        if (r211 == null) goto L65;
        int r100 = 0;
        int r101 = Math.max(0, Math.min(r212, r210.length()));
        if (r210.equals(r211) == false) goto L9;
        return 0;
    L9:
        if (r210.length() != 0) goto L12;
        return -1;
    L12:
        if ((r211.length() + r101) <= r210.length()) goto L14;
    L16:
        HashMap r102 = new HashMap();
        char[] r103 = r211.toCharArray();
        int r104 = r103.length;
        int r105 = 0;
    L17:
        if (r105 >= r104) goto L19;
        r102.put(Character.valueOf(r103[r105]), 0);
        r105 = r105 + 1;
        goto L17
    L19:
        int r106 = r103.length;
        int r107 = 0;
        int r110 = 0;
    L20:
        int r111 = 1;
        if (r107 >= r106) goto L23;
        char r112 = r103[r107];
        r102.put(Character.valueOf(r112), Integer.valueOf(((Integer) r102.get(Character.valueOf(r112))).intValue() | (1 << ((r211.length() - r110) - 1))));
        r110 = r110 + 1;
        r107 = r107 + 1;
        goto L20
    L23:
        double r108 = this.f270357b;
        int r109 = r210.indexOf(r211, r101);
        if (r109 == (-1)) goto L28;
        r108 = Math.min(m(0, r109, r101, r211), r108);
        int r113 = r210.lastIndexOf(r211, r211.length() + r101);
        if (r113 == (-1)) goto L28;
        r108 = Math.min(m(0, r113, r101, r211), r108);
    L28:
        int r114 = 1 << (r211.length() - 1);
        int r115 = r211.length() + r210.length();
        int[] r116 = new int[0];
        int r117 = 0;
        int r118 = -1;
    L30:
        if (r117 >= r211.length()) goto L63;
        int r119 = r115;
    L32:
        if (r100 >= r115) goto L38;
        if (m(r117, r101 + r115, r101, r211) > r108) goto L36;
        r100 = r115;
    L37:
        r115 = ((r119 - r100) / 2) + r100;
        goto L32
    L36:
        r119 = r115;
        goto L37
    L38:
        int r120 = Math.max(r111, (r101 - r115) + r111);
        int r121 = Math.min(r101 + r115, r210.length()) + r211.length();
        int[] r122 = new int[r121 + 2];
        r122[r121 + 1] = (r111 << r117) - 1;
    L39:
        if (r121 < r120) goto L59;
        int r123 = r120;
        int r124 = r121 - 1;
        if (r210.length() > r124) goto L43;
    L46:
        int r125 = 0;
    L47:
        if (r117 != 0) goto L49;
        r122[r121] = ((r122[r121 + 1] << 1) | 1) & r125;
    L51:
        if ((r122[r121] & r114) == 0) goto L57;
        double r126 = m(r117, r124, r101, r211);
        if (r126 > r108) goto L57;
        if (r124 <= r101) goto L56;
        r111 = 1;
        r118 = r124;
        r123 = Math.max(1, (r101 * 2) - r124);
        r108 = r126;
    L58:
        r121 = r124;
        r120 = r123;
        goto L39
    L56:
        r111 = 1;
        r118 = r124;
        r108 = r126;
    L57:
        r111 = 1;
        goto L58
    L49:
        int r127 = r121 + 1;
        int r128 = ((r122[r127] << 1) | 1) & r125;
        int r129 = r116[r127];
        r122[r121] = (r128 | (((r129 | r116[r121]) << 1) | 1)) | r129;
        goto L51
    L43:
        if (r102.containsKey(Character.valueOf(r210.charAt(r124))) == false) goto L46;
        r125 = ((Integer) r102.get(Character.valueOf(r210.charAt(r124)))).intValue();
    L59:
        r117 = r117 + 1;
        if (m(r117, r101, r101, r211) > r108) goto L63;
        r116 = r122;
        r100 = 0;
    L63:
        return r118;
    L14:
        if (r210.substring(r101, r211.length() + r101).equals(r211) == false) goto L16;
        return r101;
    L65:
        throw new IllegalArgumentException("Null inputs. (match_main)");
    }

    public final double m(int r100, int r101, int r102, String r103) {
        float r104 = r100 / r103.length();
        int r105 = Math.abs(r102 - r101);
        int r106 = this.f270358c;
        if (r106 != 0) goto L9;
        if (r105 == 0) goto L10;
        return 1.0d;
    L10:
        return r104;
    L9:
        return r104 + (r105 / r106);
    }

    public final LinkedList<b> b(String r100, String r101, int r102, int r103, long r104) {
        String r105 = r100.substring(0, r102);
        String r106 = r101.substring(0, r103);
        String r107 = r100.substring(r102);
        String r108 = r101.substring(r103);
        LinkedList<b> r109 = i(r105, r106, r104);
        r109.addAll(i(r107, r108, r104));
        return r109;
    }
}
