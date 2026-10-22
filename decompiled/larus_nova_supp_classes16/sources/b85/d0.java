package b85;

import android.app.Application;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.loader.download.DownCallback;
import com.bytedance.ee.bear.drive.loader.download.ErrReportHandler;
import com.bytedance.ee.bear.drive.loader.download.IFileDownloadDependency;
import com.bytedance.ee.bear.drive.loader.download.platform.DownloadOptions;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.VCFollowPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.ServerErrParser;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SheetInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.SlidesInfoPuller;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d0<P, FM extends w75.a> {
    public final IFileDownloadDependency a;
    public final CompositeDisposable b;
    public final hb5.a c;
    public final a85.d d;
    public final List<d85.d> e;
    public final Set<String> f;
    public final a95.a g;
    public final f0<P> h;
    public final IDownloader i;
    public final IApiPuller<P, FM> j;
    public final IApiPuller<SheetInfoPuller.Params, SheetInfoPuller.Result> k;
    public final IApiPuller<SlidesInfoPuller.Params, SlidesInfoPuller.Result> l;
    public final c85.f<DriveCache, FM> m;
    public final u75.b.a n;
    public final BaseOpenEntity o;

    public class a extends DownCallback<FM> {
        public final /* synthetic */ w75.c a;
        public final /* synthetic */ d0 b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
        public final void onFailure(DriveException r4) {
            super.onFailure(r4);
            this.b.e(r4, this.a.getDetails(), false);
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.DownCallback, com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
        public final void onServerTransform(w75.c<FM> r2) {
            super.onServerTransform(r2);
            d0.a(this.b, this.a.getDetails());
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader.ICallback
        public final void onSubmit(String r4) {
            super.onSubmit(r4);
            ((HashSet) this.b.f).add(r4);
            com.bytedance.ee.bear.drive.report.a r5 = this.b.a.getDevReport();
            d0 r0 = this.b;
            r5.b(r0.h.a, "rust_download", r0.a.getPreviewStrategy());
            this.b.n.onProgress(0);
            d0.a(this.b, this.a.getDetails());
        }

        public a(d0 r8, w75.c r9, u75.b.a r10, IFileDownloadDependency r11, a95.a r12, DownloadOptions r13, w75.c r14) {
            this.b = r8;
            this.a = r14;
            super(r9, r10, r11, 3, r12, r13);
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            a = r0;
            r0[ErrCode.FILE_NOT_CHANGED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ErrCode.WPS_PREVIEW_EXP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ErrCode.SHEET_PREVIEW_EXP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[ErrCode.SLIDES_PREVIEW_EXP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[ErrCode.TNS_BLOCK_VIEW.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class c<P, FM extends w75.a> {
        public final f0 a;
        public IFileDownloadDependency b;
        public a85.d c;
        public IDownloader d;
        public a95.a e;
        public IApiPuller<P, FM> f;
        public IApiPuller<SheetInfoPuller.Params, SheetInfoPuller.Result> g;
        public IApiPuller<SlidesInfoPuller.Params, SlidesInfoPuller.Result> h;
        public c85.f<DriveCache, FM> i;
        public u75.b.a j;
        public BaseOpenEntity k;

        public final d0<P, FM> a() {
            if (this.b == null) goto L19;
            if (this.d == null) goto L19;
            if (this.f == null) goto L19;
            if (this.g == null) goto L19;
            if (this.h == null) goto L19;
            if (this.j == null) goto L19;
            if (this.a == null) goto L19;
            return new d0(this);
        L19:
            throw new NullPointerException("you should setDownloadDependency");
        }

        public c() {
            this.a = new f0();
        }
    }

    public static class d implements Function<Flowable<? extends Throwable>, Flowable<?>> {
        public final int a;
        public int b;
        public final u75.b.a c;
        public final List<Long> d;

        public d(u75.b.a r4) {
            List<Long> r0 = Arrays.asList(new Long[]{1L, 1L, 1L, 3L, 5L, 10L, 15L, 30L});
            this.d = r0;
            this.c = r4;
            this.a = r0.size();
        }

        public final Object apply(Object r2) throws Exception {
            return ((Flowable) r2).flatMap(new e0(this));
        }
    }

    public final void c() {
        tt5.a.h("PreviewFileExecutor", "exe1 start. enable async: true");
        final AtomicReference r0 = new AtomicReference();
        final AtomicReference r1 = new AtomicReference();
        final boolean r2 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        Flowable r3 = Flowable.just(this.h).flatMap(new i(this, r2)).onErrorResumeNext(new j()).flatMap(new b85.a()).doOnNext(new y(this, r0, r2));
        this.b.add(r3.observeOn(fo5.d.b()).flatMap(new p(this)).doOnNext(new z(this, r0)).flatMap(new a0(this, r0)).observeOn(fo5.d.b()).flatMap(new b0(r0)).doOnNext(new c0(this, r1)).flatMap(new b85.b(this)).observeOn(fo5.d.b()).flatMap(new b85.c(this)).observeOn(fo5.d.b()).flatMap(new b85.d(this)).flatMap(new e(this, r0)).flatMap(new l(this, r0)).flatMap(new v(this)).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new w(), new x(this, r1, r0)));
    }

    public d0(c r9) {
        this.b = new CompositeDisposable();
        this.f = new HashSet();
        IDownloader r0 = r9.d;
        this.i = r0;
        IFileDownloadDependency r1 = r9.b;
        this.a = r1;
        this.j = r9.f;
        this.k = r9.g;
        this.l = r9.h;
        this.m = r9.i;
        a95.a r2 = r9.e;
        int r3 = a95.a.d;
        a95.a r4 = a95.a.b.a(r2);
        this.g = r4;
        Application r5 = eu5.b.a;
        com.bytedance.ee.bear.drive.preload.r.b(r4);
        this.c = (hb5.a) org.koin.java.a.a(hb5.a.class);
        f0<P> r6 = r9.a;
        this.h = r6;
        this.n = r9.j;
        ArrayList r7 = new ArrayList(4);
        r7.add(new d85.a(r1.getPreviewStrategy(), r1.getCacheManager(), r4));
        r1.getPreviewStrategy();
        r7.add(new d85.e(r0));
        r7.add(new d85.c(r1.getPreviewStrategy(), r1.getCacheManager(), r4));
        r7.add(new d85.f(r6.b));
        r7.add(new d85.b());
        g75.a r8 = r6.f;
        if (r8 == null) goto L5;
        r7.add(r8.getAsyncWpsCostOptimizationCacheHandler());
    L5:
        this.e = r7;
        if (r6.b == false) goto L8;
        r0.addCustomizationAdjust(new VCFollowPriorityAdjuster());
    L8:
        g75.a r10 = r6.f;
        if (r10 == null) goto L11;
        r0.addCustomizationAdjust(r10.getCustomizationAdjust());
    L11:
        this.d = r9.c;
        this.o = r9.k;
    }

    public final Flowable<Boolean> b(w75.c<FM> r11) {
        tt5.a.h("PreviewFileExecutor", "downloadFile, start. please check the event callback. ");
        BaseOpenEntity r1 = this.o;
        if (r1 != null) goto L5;
        tt5.a.d("PreviewFileExecutor", "downloadFile, baseOpenEntity is null.");
        DownloadOptions r0 = DownloadOptions.defaultOptions();
    L6:
        a r2 = new a(this, r11, this.n, this.a, this.g, r0, r11);
        return this.i.downloadPreviewFile(r11, r2, r0);
    L5:
        r0 = DownloadOptions.from(r1);
        r0.setDriveWatermarkScene(DriveWatermarkScene.DriveWatermarkScene_NONE);
        goto L6
    }

    public final void d(final w75.c<FM> r5) {
        this.b.add(Flowable.just(r5).observeOn(fo5.d.e()).flatMap(new f(this)).observeOn(fo5.d.d()).subscribe(new g(), new h(this, r5)));
    }

    public final List<e85.d<FM>> f(FM r12) {
        ArrayList r0 = new ArrayList();
        r0.add(new e85.c(r12, this.h, this.a, this.g));
        r0.add(new e85.f(r12, this.h, this.a, this.g));
        r0.add(new e85.e(r12, this.h, this.a, this.g));
        r0.add(new e85.b(r12, this.h, this.a, this.m, this.g));
        return r0;
    }

    public static void a(d0 r4, w75.a r5) {
        r4.getClass();
        tt5.a.h("PreviewFileExecutor", "checkMobileNetwork start.");
        if (r4.h.d == false) goto L5;
        return;
    L5:
        if (r4.a.getPreviewStrategy().g(null, f85.c.a(r5)) == false) goto L9;
        tt5.a.h("PreviewFileExecutor", "checkMobileNetwork, need MobileNetworkWarning.");
        r4.n.a(InfoCode.MobileNetworkWarning, r5);
        return;
    }

    public final void e(Throwable r5, FM r6, boolean r7) {
        ErrReportHandler.handle(this.a.getDevReport(), r5, this.h.a, 3, r7);
        tt5.a.d("PreviewFileExecutor", "handleErr, exp: " + r5);
        if (r7 == false) goto L15;
        if (ErrReportHandler.isExpNotEffectPreview(r5) == false) goto L15;
        tt5.a.h("PreviewFileExecutor", "preview error but can use cache, exp = " + r5);
        if ((r5 instanceof DriveException) == false) goto L42;
        DriveException r8 = (DriveException) r5;
        ErrCode r9 = r8.getErrorCode();
        if (r9.getCause() != null) goto L11;
        return;
    L11:
        if (ServerErrParser.isPreviewDLPFail(r9.getCause()) == false) goto L44;
        this.n.c(r8.getErrorCode());
        return;
    L44:
        return;
    L42:
        return;
    L15:
        if ((r5 instanceof DriveException) == false) goto L39;
        DriveException r10 = (DriveException) r5;
        tt5.a.d("PreviewFileExecutor", "handle download Err, errCode: " + r10.getErrorCode());
        int r0 = b.a[r10.getErrorCode().ordinal()];     // Catch: Exception -> L37
        if (r0 != 1) goto L20;
        u75.b.a r11 = this.n;     // Catch: Exception -> L37
        InfoCode r12 = InfoCode.FileNotChange;     // Catch: Exception -> L37
        Objects.requireNonNull(r6);     // Catch: Exception -> L37
        FM r1 = r6;     // Catch: Exception -> L37
        r11.a(r12, r6);     // Catch: Exception -> L37
        return;
    L20:
        if (r0 == 2) goto L33;
        if (r0 != 3) goto L23;
        u75.b.a r13 = this.n;     // Catch: Exception -> L37
        InfoCode r14 = InfoCode.SHEET_PREVIEW;     // Catch: Exception -> L37
        Object r16 = r10.getExtra();     // Catch: Exception -> L37
        Objects.requireNonNull(r16);     // Catch: Exception -> L37
        r13.a(r14, r16);     // Catch: Exception -> L37
        return;
    L23:
        if (r0 != 4) goto L25;
        u75.b.a r17 = this.n;     // Catch: Exception -> L37
        InfoCode r18 = InfoCode.SLIDES_PREVIEW;     // Catch: Exception -> L37
        Object r19 = r10.getExtra();     // Catch: Exception -> L37
        Objects.requireNonNull(r19);     // Catch: Exception -> L37
        r17.a(r18, r19);     // Catch: Exception -> L37
        return;
    L25:
        if (r0 == 5) goto L27;
        this.n.c(((DriveException) r5).getErrorCode());     // Catch: Exception -> L37
        return;
    L27:
        ((DriveException) r5).getErrorCode().setCause(r5);     // Catch: Exception -> L37
        this.n.c(((DriveException) r5).getErrorCode());     // Catch: Exception -> L37
        return;
    L33:
        u75.b.a r20 = this.n;     // Catch: Exception -> L37
        InfoCode r21 = InfoCode.WPS_PREVIEW;     // Catch: Exception -> L37
        Objects.requireNonNull(r6);     // Catch: Exception -> L37
        FM r2 = r6;     // Catch: Exception -> L37
        r20.a(r21, r6);     // Catch: Exception -> L37
        this.n.b(r6.i());     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        tt5.a.f("PreviewFileExecutor", e, false);
        this.n.c(ErrCode.DEFAULT);
        return;
    L39:
        this.n.c(ErrCode.DEFAULT);
    }
}
