package com.bytedance.sdk.account.settings.common;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class TokenShareMatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f269355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f269356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f269357c;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class PathMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f269358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f269359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Pattern f269360c;

        public static final enum Type extends Enum<Type> {
            public static final Type EXACT = null;
            public static final Type GLOB = null;
            public static final Type PREFIX = null;
            public static final Type REGEX = null;
            public static final Type SUFFIX = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f269361a = null;

            static {
                Type r100 = new Type("PREFIX", 0);
                PREFIX = r100;
                Type r101 = new Type("SUFFIX", 1);
                SUFFIX = r101;
                Type r102 = new Type("EXACT", 2);
                EXACT = r102;
                Type r103 = new Type("GLOB", 3);
                GLOB = r103;
                Type r104 = new Type("REGEX", 4);
                REGEX = r104;
                f269361a = new Type[]{r100, r101, r102, r103, r104};
            }

            public static Type[] values() {
                return (Type[]) f269361a.clone();
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public Type(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final boolean a(String r100) {
            int r101 = a.f269362a[this.f269358a.ordinal()];
            if (r101 == 1) goto L23;
            if (r101 == 2) goto L21;
            if (r101 == 3) goto L19;
            if (r101 != 4) goto L11;
        L13:
            Pattern r102 = this.f269360c;
            if (r102 != null) goto L17;
            return false;
        L17:
            return r102.matcher(r100).matches();
        L11:
            if (r101 == 5) goto L13;
            return false;
        L19:
            return r100.equals(this.f269359b);
        L21:
            return r100.endsWith(this.f269359b);
        L23:
            return r100.startsWith(this.f269359b);
        }

        public PathMatcher(Type r100, String r101, Pattern r102) {
            this.f269358a = r100;
            this.f269359b = r101;
            this.f269360c = r102;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f269362a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f269363b = null;

        static {
            int[] r100 = new int[ShareTokenConfigParser.PathConfig.Type.values().length];
            f269363b = r100;
            r100[ShareTokenConfigParser.PathConfig.Type.SUFFIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L31:
            f269363b[ShareTokenConfigParser.PathConfig.Type.EXACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L37:
            f269363b[ShareTokenConfigParser.PathConfig.Type.GLOB.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L47:
            f269363b[ShareTokenConfigParser.PathConfig.Type.REGEX.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L33:
            f269363b[ShareTokenConfigParser.PathConfig.Type.PREFIX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L12:
            int[] r101 = new int[PathMatcher.Type.values().length];
            f269362a = r101;
            r101[PathMatcher.Type.PREFIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L39:
            f269362a[PathMatcher.Type.SUFFIX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L45:
            f269362a[PathMatcher.Type.EXACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L29:
            f269362a[PathMatcher.Type.GLOB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L41:
            f269362a[PathMatcher.Type.REGEX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f269364a;

        public b(int r100) {
            this.f269364a = Math.max(0, r100);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f269365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f269366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PathMatcher f269367c;

        public c(String r100, String r101, PathMatcher r102) {
            this.f269365a = r100;
            this.f269366b = r101;
            this.f269367c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f269368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f269369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<c> f269370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<c> f269371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<c> f269372e;

        public static d a(List<ShareTokenConfigParser.b> r110, b r111) {
            if (r110 != null) goto L5;
            return null;
        L5:
            if (r110.isEmpty() == true) goto L144;
            ArrayList r100 = new ArrayList();
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            ArrayList r104 = new ArrayList();
            Iterator<ShareTokenConfigParser.b> r105 = r110.iterator();
        L9:
            if (r105.hasNext() == false) goto L94;
            ShareTokenConfigParser.b r106 = r105.next();
            if (r106 == null) goto L9;
            String r107 = r106.f269344a;
            String r112 = r106.f269345b;
            ShareTokenConfigParser.PathConfig r108 = r106.f269346c;
            if (r108 == null) goto L75;
            ShareTokenConfigParser.PathConfig.Type r113 = r108.f269340a;
            String r114 = r108.f269341b;
            if (TextUtils.isEmpty(r114) == true) goto L72;
            int r109 = a.f269363b[r113.ordinal()];
            boolean r115 = true;
            if (r109 == 1) goto L29;
            if (r109 != 2) goto L22;
            PathMatcher.Type r116 = PathMatcher.Type.EXACT;
        L31:
            if (r116 != PathMatcher.Type.REGEX) goto L33;
        L36:
            int r117 = r111.f269364a;
            int r118 = 0;
            if (r117 > 0) goto L39;
            r115 = false;
        L41:
            if (r115 == true) goto L109;
            tb7.a.e("TokenShareMatcher", "regex budget exceeded, skip rule: " + r114);
            goto L72
        L109:
            if (r116 != PathMatcher.Type.GLOB) goto L67;
            StringBuilder r119 = new StringBuilder(r114.length() * 2);     // Catch: Throwable -> L70
            r119.append('^');     // Catch: Throwable -> L70
        L47:
            if (r118 >= r114.length()) goto L66;
            char r120 = r114.charAt(r118);     // Catch: Throwable -> L70
            if (r120 != '$') goto L51;
        L64:
            r119.append('\\');     // Catch: Throwable -> L70
            r119.append(r120);     // Catch: Throwable -> L70
        L65:
            r118 = r118 + 1;     // Catch: Throwable -> L70
            goto L47
        L51:
            if (r120 == '%') goto L64;
            if (r120 == '.') goto L64;
            if (r120 != '?') goto L57;
            r119.append('.');     // Catch: Throwable -> L70
            goto L65
        L57:
            if (r120 == '@') goto L64;
            switch(r120) {
                case 40: goto L64;
                case 41: goto L64;
                case 42: goto L62;
                case 43: goto L64;
                default: goto L59;
            };     // Catch: Throwable -> L70
        L59:
            switch(r120) {
                case 91: goto L64;
                case 92: goto L64;
                case 93: goto L64;
                case 94: goto L64;
                default: goto L60;
            };     // Catch: Throwable -> L70
        L60:
            switch(r120) {
                case 123: goto L64;
                case 124: goto L64;
                case 125: goto L64;
                default: goto L61;
            };     // Catch: Throwable -> L70
        L61:
            r119.append(r120);     // Catch: Throwable -> L70
            goto L65
        L62:
            r119.append(".*");     // Catch: Throwable -> L70
            goto L65
        L66:
            r119.append(Typography.dollar);     // Catch: Throwable -> L70
            String r121 = r119.toString();     // Catch: Throwable -> L70
        L68:
            Pattern r122 = PatternProtector.compile(r121);     // Catch: Throwable -> L70
        L69:
            PathMatcher r123 = new PathMatcher(r116, r114, r122);
        L73:
            if (r123 == null) goto L9;
        L76:
            if (r107 != null) goto L80;
            if (r112 != null) goto L80;
            if (r123 == null) goto L9;
        L80:
            c r124 = new c(r107, r112, r123);
            if (r107 == null) goto L84;
            if (r123 == null) goto L84;
            r100.add(r124);
        L84:
            if (r107 != null) goto L85;
            if (r112 == null) goto L89;
            if (r123 == null) goto L89;
            r102.add(r124);
        L89:
            if (r112 != null) goto L90;
            if (r123 == null) goto L9;
            r104.add(r124);
            goto L9
        L90:
            r103.add(r124);
            goto L9
        L85:
            r101.add(r124);
            goto L9
        L67:
            r121 = r114;
        L70:
            th = move-exception;
            tb7.a.c("TokenShareMatcher", "compile pattern failed: " + r114, th);
            goto L72
        L39:
            r111.f269364a = r117 - 1;
            goto L41
        L33:
            if (r116 == PathMatcher.Type.GLOB) goto L36;
            r122 = null;
            goto L69
        L22:
            if (r109 != 3) goto L24;
            r116 = PathMatcher.Type.GLOB;
            goto L31
        L24:
            if (r109 == 4) goto L26;
            r116 = PathMatcher.Type.PREFIX;
            goto L31
        L26:
            r116 = PathMatcher.Type.REGEX;
            goto L31
        L29:
            r116 = PathMatcher.Type.SUFFIX;
        L72:
            r123 = null;
            goto L73
        L75:
            r123 = null;
            goto L76
        L94:
            if (r100.isEmpty() == false) goto L106;
            if (r101.isEmpty() == false) goto L106;
            if (r102.isEmpty() == false) goto L106;
            if (r103.isEmpty() == false) goto L106;
            if (r104.isEmpty() == false) goto L106;
            return null;
        L106:
            return new d(Collections.unmodifiableList(r100), Collections.unmodifiableList(r101), Collections.unmodifiableList(r102), Collections.unmodifiableList(r103), Collections.unmodifiableList(r104));
        L144:
            return null;
        }

        public final boolean b(String r100, String r101) {
            Iterator<c> r102 = this.f269368a.iterator();
        L4:
            if (r102.hasNext() == false) goto L14;
            c r103 = r102.next();
            Object r104 = r103.f269365a;
            if (r104 == null) goto L4;
            if (r100.equals(r104) == false) goto L4;
            PathMatcher r105 = r103.f269367c;
            if (r105 == null) goto L4;
            if (r105.a(r101) == false) goto L4;
            return true;
        L14:
            Iterator<c> r106 = this.f269369b.iterator();
        L16:
            if (r106.hasNext() == false) goto L22;
            Object r107 = r106.next().f269365a;
            if (r107 == null) goto L16;
            if (r100.equals(r107) == false) goto L16;
            return true;
        L22:
            Iterator<c> r108 = this.f269370c.iterator();
        L24:
            if (r108.hasNext() == false) goto L37;
            c r109 = r108.next();
            String r110 = r109.f269366b;
            if (r110 == null) goto L24;
            if (r100.equals(r110) == false) goto L30;
            boolean r111 = true;
        L31:
            if (r111 == false) goto L24;
            PathMatcher r112 = r109.f269367c;
            if (r112 == null) goto L24;
            if (r112.a(r101) == false) goto L24;
            return true;
        L30:
            r111 = r100.endsWith(r110);
            goto L31
        L37:
            Iterator<c> r113 = this.f269371d.iterator();
        L39:
            if (r113.hasNext() == false) goto L48;
            String r114 = r113.next().f269366b;
            if (r114 == null) goto L39;
            if (r100.equals(r114) == false) goto L45;
            boolean r115 = true;
        L46:
            if (r115 == false) goto L39;
            return true;
        L45:
            r115 = r100.endsWith(r114);
            goto L46
        L48:
            Iterator<c> r116 = this.f269372e.iterator();
        L50:
            if (r116.hasNext() == false) goto L56;
            PathMatcher r117 = r116.next().f269367c;
            if (r117 == null) goto L50;
            if (r117.a(r101) == false) goto L50;
            return true;
        L56:
            return false;
        }

        public d(List<c> r100, List<c> r101, List<c> r102, List<c> r103, List<c> r104) {
            this.f269368a = r100;
            this.f269369b = r101;
            this.f269370c = r102;
            this.f269371d = r103;
            this.f269372e = r104;
        }
    }

    public static TokenShareMatcher a(ShareTokenConfigParser.c r100) {
        HashSet r101 = new HashSet();
        List<String> r102 = r100.f269350d;
        if (r102 == null) goto L10;
        Iterator<String> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        if (TextUtils.isEmpty(r104) == true) goto L6;
        r101.add(r104.toLowerCase(Locale.US));
    L10:
        ShareTokenConfigParser.a r105 = r100.f269353g;
        if (r105 == null) goto L13;
        int r106 = r105.f269343a;
    L14:
        b r107 = new b(r106);
        d r108 = d.a(r100.f269352f, r107);
        d r109 = d.a(r100.f269351e, r107);
        return new TokenShareMatcher(Collections.unmodifiableSet(r101), r108, r109);
    L13:
        r106 = 16;
        goto L14
    }

    public TokenShareMatcher(Set<String> r100, d r101, d r102) {
        this.f269355a = r100;
        this.f269356b = r101;
        this.f269357c = r102;
    }
}
