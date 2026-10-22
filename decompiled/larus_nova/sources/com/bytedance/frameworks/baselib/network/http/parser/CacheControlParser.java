package com.bytedance.frameworks.baselib.network.http.parser;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class CacheControlParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f244761b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Directive, String> f244762a;

    public static final enum Directive extends Enum<Directive> {
        public static final Directive MAXAGE = null;
        public static final Directive MAXSTALE = null;
        public static final Directive MINFRESH = null;
        public static final Directive MUSTREVALIDATE = null;
        public static final Directive NOCACHE = null;
        public static final Directive NOSTORE = null;
        public static final Directive NOTRANSFORM = null;
        public static final Directive ONLYIFCACHED = null;
        public static final Directive PRIVATE = null;
        public static final Directive PROXYREVALIDATE = null;
        public static final Directive PUBLIC = null;
        public static final Directive SMAXAGE = null;
        public static final Directive UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Directive[] f244763a = null;

        static {
            Directive r100 = new Directive("MAXAGE", 0);
            MAXAGE = r100;
            Directive r101 = new Directive("MAXSTALE", 1);
            MAXSTALE = r101;
            Directive r102 = new Directive("MINFRESH", 2);
            MINFRESH = r102;
            Directive r103 = new Directive("NOCACHE", 3);
            NOCACHE = r103;
            Directive r104 = new Directive("NOSTORE", 4);
            NOSTORE = r104;
            Directive r105 = new Directive("NOTRANSFORM", 5);
            NOTRANSFORM = r105;
            Directive r110 = new Directive("ONLYIFCACHED", 6);
            ONLYIFCACHED = r110;
            Directive r111 = new Directive("MUSTREVALIDATE", 7);
            MUSTREVALIDATE = r111;
            Directive r112 = new Directive("PRIVATE", 8);
            PRIVATE = r112;
            Directive r113 = new Directive("PROXYREVALIDATE", 9);
            PROXYREVALIDATE = r113;
            Directive r114 = new Directive("PUBLIC", 10);
            PUBLIC = r114;
            Directive r115 = new Directive("SMAXAGE", 11);
            SMAXAGE = r115;
            Directive r106 = new Directive("UNKNOWN", 12);
            UNKNOWN = r106;
            f244763a = new Directive[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        }

        public static Directive[] values() {
            return (Directive[]) f244763a.clone();
        }

        public static Directive select(String r100) {
            return valueOf(r100.toUpperCase().replaceAll("-", ""));
        L5:
            return UNKNOWN;
        }

        public static Directive valueOf(String r100) {
            return (Directive) a.a(Directive.class, r100);
        }

        public Directive(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f244761b = PatternProtector.compile("\\s*([\\w\\-]+)\\s*(=)?\\s*(\\d+|\\\"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)+\\\")?\\s*");
    }

    public CacheControlParser(String r100) {
        this.f244762a = new HashMap();
        Matcher r101 = f244761b.matcher(r100);     // Catch: IllegalArgumentException -> L11
    L5:
        if (r101.find() == false) goto L19;
        Directive r102 = Directive.select(r101.group(1));     // Catch: IllegalArgumentException -> L11
        if (r102 == Directive.UNKNOWN) goto L5;
        this.f244762a.put(r102, r101.group(3));     // Catch: IllegalArgumentException -> L11
    L19:
        return;
    }
}
