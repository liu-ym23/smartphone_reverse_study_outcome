package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.q0;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiTreeObserver {
    public static final NonStickyMutableLiveData<f> a = null;
    public static final NonStickyMutableLiveData<b> b = null;
    public static final NonStickyMutableLiveData<c> c = null;
    public static final a d = null;
    public static final NonStickyMutableLiveData<g> e = null;
    public static final NonStickyMutableLiveData<h> f = null;
    public static final NonStickyMutableLiveData<i> g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;

    public static final class a extends NonStickyMutableLiveData<d> {
        public final C0210a b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver$a$a, reason: collision with other inner class name */
        public static final class C0210a extends q0 {
            public final /* synthetic */ a a;

            public C0210a(a r1) {
                this.a = r1;
            }

            public final void f(String r4, boolean r5) {
                if (r4 != null) goto L4;
            L7:
                boolean r0 = true;
            L8:
                if (r0 == true) goto L11;
                this.a.e(new d("", r4, r5));
                return;
            L11:
                return;
            L4:
                if (r4.length() == 0) goto L7;
                r0 = false;
                goto L8
            }
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData
        public final void b() {
            ((c0) org.koin.java.a.c(c0.class, null, null, 6)).q0(this.b);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData
        public final void c() {
            ((c0) org.koin.java.a.c(c0.class, null, null, 6)).d0(this.b);
        }

        public a() {
            this.b = new C0210a(this);
        }
    }

    static {
        a = new NonStickyMutableLiveData();
        b = new NonStickyMutableLiveData();
        c = new NonStickyMutableLiveData();
        d = new a();
        e = new NonStickyMutableLiveData();
        f = new NonStickyMutableLiveData();
        g = new NonStickyMutableLiveData();
        h = LazyKt.lazy(WikiTreeObserver$doDelete$2.INSTANCE);
        i = LazyKt.lazy(WikiTreeObserver$doExploreFavorite$2.INSTANCE);
        j = LazyKt.lazy(WikiTreeObserver$doReload$2.INSTANCE);
    }

    public static NonStickyMutableLiveData a() {
        return (NonStickyMutableLiveData) h.getValue();
    }

    public static NonStickyMutableLiveData b() {
        return (NonStickyMutableLiveData) i.getValue();
    }
}
