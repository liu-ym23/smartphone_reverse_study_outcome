package retrofit2;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes41.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f537564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUrl f537565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f537567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Headers f537568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final MediaType f537569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f537570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f537571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f537572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p<?>[] f537573j;

    public static final class a {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final Pattern f537574w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final Pattern f537575x = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f537576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f537577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f537578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f537579d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f537580e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f537581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f537582g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f537583h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f537584i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f537585j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f537586k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f537587l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f537588m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        public String f537589n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f537590o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f537591p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f537592q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Nullable
        public String f537593r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Nullable
        public Headers f537594s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Nullable
        public MediaType f537595t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Nullable
        public Set<String> f537596u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        public p<?>[] f537597v;

        static {
            f537574w = PatternProtector.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            f537575x = PatternProtector.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        }

        public static Class<?> a(Class<?> r100) {
            if (Boolean.TYPE != r100) goto L7;
            return Boolean.class;
        L7:
            if (Byte.TYPE != r100) goto L11;
            return Byte.class;
        L11:
            if (Character.TYPE != r100) goto L15;
            return Character.class;
        L15:
            if (Double.TYPE != r100) goto L19;
            return Double.class;
        L19:
            if (Float.TYPE != r100) goto L23;
            return Float.class;
        L23:
            if (Integer.TYPE != r100) goto L27;
            return Integer.class;
        L27:
            if (Long.TYPE != r100) goto L31;
            return Long.class;
        L31:
            if (Short.TYPE != r100) goto L34;
            return Short.class;
        L34:
            return r100;
        }

        public a(Retrofit r100, Method r101) {
            this.f537576a = r100;
            this.f537577b = r101;
            this.f537578c = r101.getAnnotations();
            this.f537580e = r101.getGenericParameterTypes();
            this.f537579d = r101.getParameterAnnotations();
        }

        public final void c(int r100, Type r101) {
            if (u.h(r101) == true) goto L6;
            return;
        L6:
            throw u.j(this.f537577b, r100, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r101});
        }

        public final void b(String r100, String r101, boolean r102) {
            String r103 = this.f537589n;
            if (r103 != null) goto L23;
            this.f537589n = r100;
            this.f537590o = r102;
            if (r101.isEmpty() == false) goto L7;
            return;
        L7:
            int r104 = r101.indexOf(63);
            if (r104 != (-1)) goto L10;
        L16:
            this.f537593r = r101;
            Matcher r105 = f537574w.matcher(r101);
            LinkedHashSet r106 = new LinkedHashSet();
        L18:
            if (r105.find() == false) goto L20;
            r106.add(r105.group(1));
            goto L18
        L20:
            this.f537596u = r106;
            return;
        L10:
            if (r104 >= (r101.length() - 1)) goto L16;
            String r107 = r101.substring(r104 + 1);
            if (f537574w.matcher(r107).find() == false) goto L16;
            throw u.i(this.f537577b, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r107});
        L23:
            throw u.i(this.f537577b, null, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r103, r100});
        }
    }

    public s(a r100) {
        this.f537564a = r100.f537577b;
        this.f537565b = r100.f537576a.baseUrl;
        this.f537566c = r100.f537589n;
        this.f537567d = r100.f537593r;
        this.f537568e = r100.f537594s;
        this.f537569f = r100.f537595t;
        this.f537570g = r100.f537590o;
        this.f537571h = r100.f537591p;
        this.f537572i = r100.f537592q;
        this.f537573j = r100.f537597v;
    }
}
