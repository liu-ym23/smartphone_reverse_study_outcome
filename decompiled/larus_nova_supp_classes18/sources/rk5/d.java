package rk5;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements OfficeThumbnailUrlRepository.h {
    public final /* synthetic */ rk5.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ rk5.a.d c;
    public final /* synthetic */ Document d;
    public final /* synthetic */ List<Document> e;
    public final /* synthetic */ String f;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ rk5.a b;
        public final /* synthetic */ rk5.a.d c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Throwable e;

        public a(int r1, rk5.a r2, rk5.a.d r3, String r4, Throwable r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            int r0 = this.a;
            rk5.a r1 = this.b;
            if (r0 == r1.k) goto L5;
            return;
        L5:
            r1.f.remove(this.c);
            this.b.g.remove(this.c);
            StringBuilder r2 = new StringBuilder("visible thumbnail request failed, token=");
            rk5.a r3 = this.b;
            String r4 = this.d;
            r3.getClass();
            r2.append(du5.b.k(r4));
            tt5.a.l("OfficeVisibleThumbLoader", r2.toString(), this.e);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ rk5.a b;
        public final /* synthetic */ rk5.a.d c;
        public final /* synthetic */ OfficeThumbnailUrlRepository.ThumbnailUrlInfo d;
        public final /* synthetic */ Document e;
        public final /* synthetic */ List<Document> f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(int r1, rk5.a r2, rk5.a.d r3, OfficeThumbnailUrlRepository.ThumbnailUrlInfo r4, Document r5, List<? extends Document> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void a() {
            int r0 = this.a;
            rk5.a r1 = this.b;
            if (r0 == r1.k) goto L5;
            return;
        L5:
            r1.f.remove(this.c);
            this.b.g.remove(this.c);
            if (((Boolean) this.b.b.invoke()).booleanValue() == true) goto L9;
            return;
        L9:
            if (StringsKt.isBlank(this.d.getUrl()) == false) goto L11;
            return;
        L11:
            this.b.d.put(this.c, this.d);
            this.b.e.put(rk5.a.b(this.e), this.d);
            this.b.a(this.e, this.f, this.d);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.h
    public final void a(OfficeThumbnailUrlRepository.ThumbnailUrlInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        rk5.a r3 = this.a;
        r3.l.post(new b(this.b, r3, this.c, r10, this.d, this.e));
    }

    @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.h
    public final void onFailure(Throwable r9) {
        Intrinsics.checkNotNullParameter(r9, "throwable");
        rk5.a r3 = this.a;
        r3.l.post(new a(this.b, r3, this.c, this.f, r9));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(rk5.a r1, int r2, rk5.a.d r3, Document r4, List<? extends Document> r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
