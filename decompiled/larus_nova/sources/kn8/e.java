package kn8;

import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.r;
import jn8.t;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f504284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f504285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f504286c;

    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f504287a;

        @Override // jn8.t
        public final void a() {
            this.f504287a.getClass();
        }

        @Override // jn8.t
        public final void b() {
            this.f504287a.getClass();
        }

        public final void c() {
            e r100 = this.f504287a;
            d r101 = r100.f504286c;
            if (r101 == null) goto L12;
            SearchReferenceData r102 = r101.f504282d;
            if (r102 == null) goto L12;
            if (r.b(r102) == false) goto L12;
            if (r100.f504285b == true) goto L12;
            boolean r103 = true;
        L13:
            if (r103 == false) goto L16;
            r100.f504285b = true;
            return;
        L16:
            return;
        L12:
            r103 = false;
            goto L13
        }

        public a(e r100) {
            this.f504287a = r100;
        }
    }

    public e() {
        this.f504284a = new a(this);
    }
}
