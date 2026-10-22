package rk5;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements OfficeThumbnailUrlRepository.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rk5.a f538284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f538285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<rk5.a.b> f538286c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f538287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rk5.a f538288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<rk5.a.b> f538289c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Throwable f538290d;

        public a(int r100, rk5.a r101, List<rk5.a.b> r102, Throwable r103) {
            this.f538287a = r100;
            this.f538288b = r101;
            this.f538289c = r102;
            this.f538290d = r103;
        }

        public final void a() {
            int r100 = this.f538287a;
            rk5.a r101 = this.f538288b;
            if (r100 == r101.f538266k) goto L5;
            return;
        L5:
            Iterator<T> r102 = this.f538289c.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            rk5.a.b r103 = (rk5.a.b) r102.next();
            r101.f538261f.remove(r103.f538268a);
            r101.f538262g.remove(r103.f538268a);
            goto L7
        L9:
            tt5.a.l("OfficeVisibleThumbLoader", "visible thumbnail batch request failed, count=" + this.f538289c.size(), this.f538290d);
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f538291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rk5.a f538292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<rk5.a.b> f538293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> f538294d;

        public b(int r100, rk5.a r101, List<rk5.a.b> r102, Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r103) {
            this.f538291a = r100;
            this.f538292b = r101;
            this.f538293c = r102;
            this.f538294d = r103;
        }

        public final void a() {
            int r100 = this.f538291a;
            rk5.a r101 = this.f538292b;
            if (r100 == r101.f538266k) goto L5;
            return;
        L5:
            Iterator<T> r102 = this.f538293c.iterator();
        L7:
            if (r102.hasNext() == false) goto L10;
            rk5.a.b r103 = (rk5.a.b) r102.next();
            r101.f538261f.remove(r103.f538268a);
            r101.f538262g.remove(r103.f538268a);
            goto L7
        L10:
            if (this.f538292b.f538257b.invoke().booleanValue() == true) goto L12;
            return;
        L12:
            List<rk5.a.b> r104 = this.f538293c;
            rk5.a r105 = this.f538292b;
            Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r106 = this.f538294d;
            Iterator<T> r107 = r104.iterator();
        L14:
            if (r107.hasNext() == false) goto L22;
            rk5.a.b r108 = (rk5.a.b) r107.next();
            OfficeThumbnailUrlRepository r109 = r105.f538256a;
            Document r110 = r108.f538269b;
            r109.getClass();
            Intrinsics.checkNotNullParameter(r110, "document");
            Set<String> r111 = OfficeThumbnailUrlRepository.f229772c;
            OfficeThumbnailUrlRepository.ThumbnailUrlInfo r112 = r106.get(OfficeThumbnailUrlRepository.c.a(r110));
            if (r112 == null) goto L14;
            if (StringsKt.isBlank(r112.getUrl()) == true) goto L14;
            r105.f538259d.put(r108.f538268a, r112);
            r105.f538260e.put(rk5.a.b(r108.f538269b), r112);
            r105.a(r108.f538269b, r108.f538270c, r112);
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
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        rk5.a r101 = this.f538284a;
        r101.f538267l.post(new a(this.f538285b, r101, this.f538286c, r100));
    }

    @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.a
    public final void onSuccess(Map<String, OfficeThumbnailUrlRepository.ThumbnailUrlInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "infos");
        rk5.a r101 = this.f538284a;
        r101.f538267l.post(new b(this.f538285b, r101, this.f538286c, r100));
    }

    public c(rk5.a r100, int r101, List<rk5.a.b> r102) {
        this.f538284a = r100;
        this.f538285b = r101;
        this.f538286c = r102;
    }
}
