package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.comment.export.j {
    public final List<com.bytedance.ee.bear.middleground.comment.uitls.p> a;
    public final List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> b;

    public static final class a<T> implements s {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            r3.s = this.a;
        }
    }

    public static final class b<T> implements s {
        public final /* synthetic */ float a;

        public b(float r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            r3.b0 = this.a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.c$c, reason: collision with other inner class name */
    public static final class C0055c<T> implements s {
        public final /* synthetic */ float a;

        public C0055c(float r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            r3.c0 = this.a;
        }
    }

    public static final class d<T> implements s {
        public final /* synthetic */ float a;

        public d(float r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            r3.Z = this.a;
        }
    }

    public static final class e<T> implements s {
        public final /* synthetic */ float a;

        public e(float r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            r3.a0 = this.a;
        }
    }

    public static final class f<T> implements s {
        public final /* synthetic */ long a;

        public f(long r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r3) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r4 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r3;
            Intrinsics.checkNotNullParameter(r4, "config");
            r4.p = this.a;
        }
    }

    public static final class g<T> implements s {
        public final /* synthetic */ TranslateConfig a;

        public g(TranslateConfig r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r3) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r4 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r3;
            Intrinsics.checkNotNullParameter(r4, "config");
            TranslateConfig r0 = this.a;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r4.x = r0;
        }
    }

    public static final class h<T> implements s {
        public final /* synthetic */ boolean a;

        public h(boolean r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r2) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            r3.C = this.a;
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void f() {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new com.bytedance.ee.bear.middleground.comment.d());
        Iterator<T> r2 = this.a.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2.next();
        Iterator r4 = ((ArrayList) this.b).iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        ((s) r4.next()).a(r3);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void j() {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new com.bytedance.ee.bear.middleground.comment.e());
        Iterator<T> r2 = this.a.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r3 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r2.next();
        Iterator r4 = ((ArrayList) this.b).iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        ((s) r4.next()).a(r3);
        goto L7
    }

    public c(int r2) {
        ArrayList r3 = new ArrayList();
        Intrinsics.checkNotNullParameter(r3, "configList");
        this.a = r3;
        this.b = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void a(TranslateConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "translate");
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new g(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void b(float r4) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new b(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void c(float r4) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new e(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void d(boolean r4) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new h(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void e(long r3) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new f(r3));
        Iterator<T> r4 = this.a.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r5 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r4.next();
        Iterator r2 = ((ArrayList) this.b).iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        ((s) r2.next()).a(r5);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void g(float r4) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new C0055c(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void h(boolean r4) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new a(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void i(float r4) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new d(r4));
        Iterator<T> r5 = this.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r5.next();
        Iterator<T> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        ((s) r3.next()).a(r2);
        goto L7
    }
}
