package com.google.common.base;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class j {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f274718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f274719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f274720c;

        /* JADX INFO: renamed from: com.google.common.base.j$a$a, reason: collision with other inner class name */
        public static final class C3848a extends b {
            public C3848a() {
            }
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @CheckForNull
            public String f274721a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @CheckForNull
            public Object f274722b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @CheckForNull
            public b f274723c;

            public b() {
            }
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder(32);
            r100.append(this.f274718a);
            r100.append('{');
            b r101 = this.f274719b.f274723c;
            String r102 = "";
        L3:
            if (r101 == null) goto L13;
            Object r103 = r101.f274722b;
            boolean r104 = r101 instanceof C3848a;
            r100.append(r102);
            String r105 = r101.f274721a;
            if (r105 == null) goto L7;
            r100.append(r105);
            r100.append(com.alipay.sdk.m.n.a.f25612h);
        L7:
            if (r103 != null) goto L9;
        L11:
            r100.append(r103);
        L12:
            r101 = r101.f274723c;
            r102 = ", ";
            goto L3
        L9:
            if (r103.getClass().isArray() == false) goto L11;
            String r106 = Arrays.deepToString(new Object[]{r103});
            r100.append(r106, 1, r106.length() - 1);
            goto L12
        L13:
            r100.append('}');
            return r100.toString();
        }

        public a(String r100) {
            b r101 = new b();
            this.f274719b = r101;
            this.f274720c = r101;
            this.f274718a = r100;
        }

        public final void d(@CheckForNull Object r100) {
            b r101 = new b();
            this.f274720c.f274723c = r101;
            this.f274720c = r101;
            r101.f274722b = r100;
        }

        public final void a(String r100, long r101) {
            c(r100, String.valueOf(r101));
        }

        public final void b(String r100, @CheckForNull Object r101) {
            b r102 = new b();
            this.f274720c.f274723c = r102;
            this.f274720c = r102;
            r102.f274722b = r101;
            r102.f274721a = r100;
        }

        public final void c(String r100, Object r101) {
            C3848a r102 = new C3848a();
            this.f274720c.f274723c = r102;
            this.f274720c = r102;
            r102.f274722b = r101;
            r102.f274721a = r100;
        }
    }

    public static a b(Object r100) {
        return new a(r100.getClass().getSimpleName());
    }

    public static <T> T a(@CheckForNull T r100, @CheckForNull T r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        if (r101 == null) goto L7;
        return r101;
    L7:
        throw new NullPointerException("Both parameters are null");
    }
}
