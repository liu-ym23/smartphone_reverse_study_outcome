package pq7;

import java.util.Stack;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f530286b = null;

    public class a extends ThreadLocal<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f530287a;

        public a() {
            this.f530287a = new d();
        }

        @Override // java.lang.ThreadLocal
        public final d initialValue() {
            return this.f530287a;
        }
    }

    public class b extends ThreadLocal<C7228c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C7228c f530288a;

        public b() {
            this.f530288a = new C7228c();
        }

        @Override // java.lang.ThreadLocal
        public final C7228c initialValue() {
            return this.f530288a;
        }
    }

    /* JADX INFO: renamed from: pq7.c$c, reason: collision with other inner class name */
    public static class C7228c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack f530289a;

        public final void a() {
            this.f530289a.pop();
        }

        public final void b() {
            this.f530289a.push(null);
        }

        public C7228c() {
            this.f530289a = new Stack();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack<iq7.c[]> f530290a;

        public d() {
            this.f530290a = new Stack();
        }
    }

    static {
        f530285a = new a();
        f530286b = new b();
    }
}
