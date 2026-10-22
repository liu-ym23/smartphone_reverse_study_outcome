package com.bytedance.ee.bear.middleground.comment;

import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.comment.export.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.middleground.comment.uitls.p> f230725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> f230726b;

    public static final class a<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f230727a;

        public a(boolean r100) {
            this.f230727a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.f232243s = this.f230727a;
        }
    }

    public static final class b<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f230728a;

        public b(float r100) {
            this.f230728a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.f232221b0 = this.f230728a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.c$c, reason: collision with other inner class name */
    public static final class C3302c<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f230729a;

        public C3302c(float r100) {
            this.f230729a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.f232223c0 = this.f230729a;
        }
    }

    public static final class d<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f230730a;

        public d(float r100) {
            this.f230730a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.Z = this.f230730a;
        }
    }

    public static final class e<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f230731a;

        public e(float r100) {
            this.f230731a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.f232219a0 = this.f230731a;
        }
    }

    public static final class f<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f230732a;

        public f(long r100) {
            this.f230732a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.f232240p = this.f230732a;
        }
    }

    public static final class g<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TranslateConfig f230733a;

        public g(TranslateConfig r100) {
            this.f230733a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            TranslateConfig r102 = this.f230733a;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f232248x = r102;
        }
    }

    public static final class h<T> implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f230734a;

        public h(boolean r100) {
            this.f230734a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.s
        public final void a(Object r100) {
            com.bytedance.ee.bear.middleground.comment.uitls.p r101 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r100;
            Intrinsics.checkNotNullParameter(r101, "config");
            r101.C = this.f230734a;
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void f() {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r100 = this.f230726b;
        ArrayList r101 = (ArrayList) r100;
        r101.add(new com.bytedance.ee.bear.middleground.comment.d());
        Iterator<T> r102 = this.f230725a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r103 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r102.next();
        Iterator r104 = ((ArrayList) this.f230726b).iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        ((s) r104.next()).a(r103);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void j() {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r100 = this.f230726b;
        ArrayList r101 = (ArrayList) r100;
        r101.add(new com.bytedance.ee.bear.middleground.comment.e());
        Iterator<T> r102 = this.f230725a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r103 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r102.next();
        Iterator r104 = ((ArrayList) this.f230726b).iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        ((s) r104.next()).a(r103);
        goto L7
    }

    public c(int r100) {
        ArrayList r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "configList");
        this.f230725a = r101;
        this.f230726b = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void a(TranslateConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "translate");
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new g(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void b(float r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new b(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void c(float r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new e(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void d(boolean r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new h(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void e(long r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new f(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator r105 = ((ArrayList) this.f230726b).iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void g(float r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new C3302c(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void h(boolean r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new a(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.j
    public final void i(float r100) {
        List<s<com.bytedance.ee.bear.middleground.comment.uitls.p>> r101 = this.f230726b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new d(r100));
        Iterator<T> r103 = this.f230725a.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        com.bytedance.ee.bear.middleground.comment.uitls.p r104 = (com.bytedance.ee.bear.middleground.comment.uitls.p) r103.next();
        Iterator<T> r105 = this.f230726b.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        ((s) r105.next()).a(r104);
        goto L7
    }
}
