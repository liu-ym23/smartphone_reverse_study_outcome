package rk5;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements OfficeThumbnailUrlRepository.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rk5.a f538295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f538296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ rk5.a.d f538297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Document f538298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List<Document> f538299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f538300f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f538301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rk5.a f538302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ rk5.a.d f538303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f538304d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Throwable f538305e;

        public a(int r100, rk5.a r101, rk5.a.d r102, String r103, Throwable r104) {
            this.f538301a = r100;
            this.f538302b = r101;
            this.f538303c = r102;
            this.f538304d = r103;
            this.f538305e = r104;
        }

        public final void a() {
            int r100 = this.f538301a;
            rk5.a r101 = this.f538302b;
            if (r100 == r101.f538266k) goto L5;
            return;
        L5:
            r101.f538261f.remove(this.f538303c);
            this.f538302b.f538262g.remove(this.f538303c);
            StringBuilder r102 = new StringBuilder("visible thumbnail request failed, token=");
            rk5.a r103 = this.f538302b;
            String r104 = this.f538304d;
            r103.getClass();
            r102.append(du5.b.k(r104));
            tt5.a.l("OfficeVisibleThumbLoader", r102.toString(), this.f538305e);
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
        public final /* synthetic */ int f538306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rk5.a f538307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ rk5.a.d f538308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OfficeThumbnailUrlRepository.ThumbnailUrlInfo f538309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Document f538310e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List<Document> f538311f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(int r100, rk5.a r101, rk5.a.d r102, OfficeThumbnailUrlRepository.ThumbnailUrlInfo r103, Document r104, List<? extends Document> r105) {
            this.f538306a = r100;
            this.f538307b = r101;
            this.f538308c = r102;
            this.f538309d = r103;
            this.f538310e = r104;
            this.f538311f = r105;
        }

        public final void a() {
            int r100 = this.f538306a;
            rk5.a r101 = this.f538307b;
            if (r100 == r101.f538266k) goto L5;
            return;
        L5:
            r101.f538261f.remove(this.f538308c);
            this.f538307b.f538262g.remove(this.f538308c);
            if (this.f538307b.f538257b.invoke().booleanValue() == true) goto L9;
            return;
        L9:
            if (StringsKt.isBlank(this.f538309d.getUrl()) == false) goto L11;
            return;
        L11:
            this.f538307b.f538259d.put(this.f538308c, this.f538309d);
            this.f538307b.f538260e.put(rk5.a.b(this.f538310e), this.f538309d);
            this.f538307b.a(this.f538310e, this.f538311f, this.f538309d);
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
    public final void a(OfficeThumbnailUrlRepository.ThumbnailUrlInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        rk5.a r100 = this.f538295a;
        r100.f538267l.post(new b(this.f538296b, r100, this.f538297c, r110, this.f538298d, this.f538299e));
    }

    @Override // com.bytedance.ee.bear.list.thumbnail.OfficeThumbnailUrlRepository.h
    public final void onFailure(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        rk5.a r101 = this.f538295a;
        r101.f538267l.post(new a(this.f538296b, r101, this.f538297c, this.f538300f, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(rk5.a r100, int r101, rk5.a.d r102, Document r103, List<? extends Document> r104, String r105) {
        this.f538295a = r100;
        this.f538296b = r101;
        this.f538297c = r102;
        this.f538298d = r103;
        this.f538299e = r104;
        this.f538300f = r105;
    }
}
