package com.bytedance.ee.bear.wikiv2.wikitreev2;

import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.q0;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiTreeObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NonStickyMutableLiveData<f> f241338a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NonStickyMutableLiveData<b> f241339b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NonStickyMutableLiveData<c> f241340c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f241341d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final NonStickyMutableLiveData<g> f241342e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final NonStickyMutableLiveData<h> f241343f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final NonStickyMutableLiveData<i> f241344g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f241345h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f241346i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f241347j = null;

    public static final class a extends NonStickyMutableLiveData<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C3457a f241348b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver$a$a, reason: collision with other inner class name */
        public static final class C3457a extends q0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f241349a;

            public C3457a(a r100) {
                this.f241349a = r100;
            }

            @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
            public final void f(String r100, boolean r101) {
                if (r100 != null) goto L4;
            L7:
                boolean r102 = true;
            L8:
                if (r102 == true) goto L11;
                this.f241349a.e(new d("", r100, r101));
                return;
            L11:
                return;
            L4:
                if (r100.length() == 0) goto L7;
                r102 = false;
                goto L8
            }
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData
        public final void b() {
            ((c0) org.koin.java.a.c(c0.class, null, null, 6)).q0(this.f241348b);
        }

        @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData
        public final void c() {
            ((c0) org.koin.java.a.c(c0.class, null, null, 6)).d0(this.f241348b);
        }

        public a() {
            this.f241348b = new C3457a(this);
        }
    }

    static {
        f241338a = new NonStickyMutableLiveData();
        f241339b = new NonStickyMutableLiveData();
        f241340c = new NonStickyMutableLiveData();
        f241341d = new a();
        f241342e = new NonStickyMutableLiveData();
        f241343f = new NonStickyMutableLiveData();
        f241344g = new NonStickyMutableLiveData();
        f241345h = LazyKt.lazy(WikiTreeObserver$doDelete$2.INSTANCE);
        f241346i = LazyKt.lazy(WikiTreeObserver$doExploreFavorite$2.INSTANCE);
        f241347j = LazyKt.lazy(WikiTreeObserver$doReload$2.INSTANCE);
    }

    public static NonStickyMutableLiveData a() {
        return (NonStickyMutableLiveData) f241345h.getValue();
    }

    public static NonStickyMutableLiveData b() {
        return (NonStickyMutableLiveData) f241346i.getValue();
    }
}
