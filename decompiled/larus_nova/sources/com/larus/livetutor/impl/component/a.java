package com.larus.livetutor.impl.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC4405a {

        /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$a$a, reason: collision with other inner class name */
        public static final class C4406a extends AbstractC4405a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4406a f355907a = null;

            static {
                f355907a = new C4406a();
            }

            public C4406a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$a$b */
        public static final class b extends AbstractC4405a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f355908a = null;

            static {
                f355908a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$a$c */
        public static final class c extends AbstractC4405a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f355909a = null;

            static {
                f355909a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$a$d */
        public static final class d extends AbstractC4405a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f355910a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f355910a, ((d) r100).f355910a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f355910a.hashCode();
            }

            public final String toString() {
                return "Succeed(text=" + this.f355910a + ')';
            }

            public d(String r100) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f355910a = r100;
            }
        }

        public AbstractC4405a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$b$a, reason: collision with other inner class name */
        public static final class C4407a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4407a f355911a = null;

            static {
                f355911a = new C4407a();
            }

            public C4407a() {
            }
        }

        /* JADX INFO: renamed from: com.larus.livetutor.impl.component.a$b$b, reason: collision with other inner class name */
        public static final class C4408b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4408b f355912a = null;

            static {
                f355912a = new C4408b();
            }

            public C4408b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f355913a = null;

            static {
                f355913a = new c();
            }

            public c() {
            }
        }

        public b() {
        }
    }

    void a(String r100);

    void c(String r100);

    boolean d();

    void e(b r100);

    void f(AbstractC4405a r100);

    void openCamera();
}
