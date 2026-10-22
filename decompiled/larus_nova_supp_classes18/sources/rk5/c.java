package rk5;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements OfficeThumbnailUrlRepository.a {
    public final /* synthetic */ rk5.a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ List<rk5.a.b> c;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ rk5.a b;
        public final /* synthetic */ List<rk5.a.b> c;
        public final /* synthetic */ Throwable d;

        public a(int r1, rk5.a r2, List<rk5.a.b> r3, Throwable r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.a;
            rk5.a r1 = this.b;
            if (r0 == r1.k) goto L5;
            return;
        L5:
            Iterator<T> r2 = this.c.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            rk5.a.b r3 = (rk5.a.b) r2.next();
            r1.f.remove(r3.a);
            r1.g.remove(r3.a);
            goto L7
        L9:
            tt5.a.l("OfficeVisibleThumbLoader", "visible thumbnail batch request failed, count=" + this.c.size(), this.d);
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
        public final /* synthetic */ List<rk5.a.b> c;
        public final /* synthetic */ Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> d;

        public b(int r1, rk5.a r2, List<rk5.a.b> r3, Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.a;
            rk5.a r1 = this.b;
            if (r0 == r1.k) goto L5;
            return;
        L5:
            Iterator<T> r2 = this.c.iterator();
        L7:
            if (r2.hasNext() == false) goto L10;
            rk5.a.b r3 = (rk5.a.b) r2.next();
            r1.f.remove(r3.a);
            r1.g.remove(r3.a);
            goto L7
        L10:
            if (((Boolean) this.b.b.invoke()).booleanValue() == true) goto L12;
            return;
        L12:
            List<rk5.a.b> r4 = this.c;
            rk5.a r5 = this.b;
            Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r6 = this.d;
            Iterator<T> r7 = r4.iterator();
        L14:
            if (r7.hasNext() == false) goto L22;
            rk5.a.b r8 = (rk5.a.b) r7.next();
            OfficeThumbnailUrlRepository r9 = r5.a;
            Document r10 = r8.b;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r10, "document");
            Set<String> r11 = OfficeThumbnailUrlRepository.c;
            OfficeThumbnailUrlRepository.ThumbnailUrlInfo r12 = r6.get(OfficeThumbnailUrlRepository.c.a(r10));
            if (r12 == null) goto L14;
            if (StringsKt.isBlank(r12.getUrl()) == true) goto L14;
            r5.d.put(r8.a, r12);
            r5.e.put(rk5.a.b(r8.b), r12);
            r5.a(r8.b, r8.c, r12);
            goto L14
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

    @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.a
    public final void onFailure(Throwable r6) {
        Intrinsics.checkNotNullParameter(r6, "throwable");
        rk5.a r0 = this.a;
        r0.l.post(new a(this.b, r0, this.c, r6));
    }

    @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.a
    public final void onSuccess(Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "infos");
        rk5.a r0 = this.a;
        r0.l.post(new b(this.b, r0, this.c, r6));
    }

    public c(rk5.a r1, int r2, List<rk5.a.b> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
