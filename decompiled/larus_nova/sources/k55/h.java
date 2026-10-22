package k55;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.biz.importfile.request.StartImportRequesterManagerImplV2;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import i55.i;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends m75.a<o55.b> implements com.bytedance.ee.bear.drive.biz.importfile.request.b.a, i<o55.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b55.g f501838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StartImportRequesterManagerImplV2 f501839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImportFileEntity f501840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.c f501841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImportFailedType f501842i;

    public class a implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImportFailedType f501843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f501844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f501845c;

        @Override // io.reactivex.functions.Consumer
        public final void accept(String r100) throws Exception {
            h r101 = this.f501845c;
            ImportFailedType r102 = this.f501843a;
            r101.f501842i = r102;
            ((o55.b) r101.f512352a).Do(r102, this.f501844b);
        }

        public a(h r100, ImportFailedType r101, int r102) {
            this.f501845c = r100;
            this.f501843a = r101;
            this.f501844b = r102;
        }
    }

    @Override // i55.i
    public final /* synthetic */ String c() {
        return i55.h.a();
    }

    @Override // i55.i
    public final void b() {
        this.f501839f.getClass();
    }

    @Override // i55.i
    public final void d() {
        final StartImportRequesterManagerImplV2 r100 = this.f501839f;
        ImportFileEntity r101 = this.f501840g;
        final String r102 = r101.f224401a;
        final String r103 = r101.f224402b;
        final l55.c r104 = r100.f223069g;
        String r105 = r100.f223068f.f224401a;
        r104.getClass();
        FileInfoV1Puller.Params r106 = new FileInfoV1Puller.Params(r105, null, null, null, null, null);
        Disposable r107 = FileInfoPuller.V1(r104.f507514c).pull(r106).onErrorResumeNext(new l55.a()).map(new l55.b(r104)).map(new l55.i(r100)).observeOn(fo5.d.d()).subscribe(new l55.g(r100, r102, r103), new l55.h(r100));
        r100.f223070h.add(r107);
    }

    @Override // i55.i
    public final CompositeDisposable getCompositeDisposable() {
        return this.f501839f.f223070h;
    }

    @Override // i55.i
    public final void r() {
        final b55.g r100 = this.f501838e;
        String r101 = this.f501840g.f224401a;
        r100.getClass();
        if (r101 != null) goto L5;
        final String r102 = "";
    L6:
        int r103 = t05.a.f544124a;
        sbb.e r104 = sbb.e.f541301l;
        Flowable.zip(t05.a.a(r102, r104.f541317b), ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().a(r101, r104.f541317b), ((rc5.a) org.koin.java.a.a(rc5.a.class)).f(r101, r104.f541317b), new b55.f(r100, r102)).onErrorReturnItem(new oj5.a()).subscribe(new b(), new c());
        Flowable.just("").subscribeOn(fo5.d.b()).map(new d()).map(new e()).subscribe(new f(), new g());
        return;
    L5:
        r102 = r101;
        goto L6
    }

    @Override // m75.a, m75.d
    public final void onDestroy() {
        super.onDestroy();
        StartImportRequesterManagerImplV2 r100 = this.f501839f;
        r100.f223071i = null;
        if (r100.f223063a == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).Lc(r100.f223063a);
    L5:
        CompositeDisposable r101 = r100.f223070h;
        if (r101 == null) goto L8;
        r101.clear();
    L8:
        ImportFailedType r102 = this.f501842i;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102 != ImportFailedType.FailedOverLimitCount) goto L19;
        com.bytedance.ee.bear.drive.report.c r103 = this.f501841h;
        ImportFileEntity r104 = this.f501840g;
        r103.getClass();
        HashMap<String, Object> r105 = new HashMap();
        r105.put("action", "cancel");
        String r106 = r104.f224401a;
        String r107 = r104.f224402b;
        if (r107 == null) goto L15;
        String r108 = com.bytedance.ee.util.io.a.c(r107);
    L16:
        r103.z(r105, r106, r108);
        r105.put("trigger_action", "import");
        r103.f224585d.v("client_commerce", r105);
        return;
    L15:
        r108 = "";
        goto L16
    }

    public h(FragmentActivity r100) {
        super(r100);
        o75.b.a().getDriveConfig();
        this.f501839f = new StartImportRequesterManagerImplV2();
        this.f501838e = new b55.g();
        this.f501841h = o75.b.a().Ke();
    }

    @Override // i55.i
    public final void a(ImportFileEntity r100) {
        this.f501840g = r100;
        this.f501841h.B(r100);
        StartImportRequesterManagerImplV2 r101 = this.f501839f;
        b55.g r102 = this.f501838e;
        r101.f223065c.B(r100);
        r101.f223068f = r100;
        r101.f223071i = this;
        r101.f223063a = new com.bytedance.ee.bear.drive.biz.importfile.request.b.C3186b(r101);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).i4(r100.f224401a, 12, r101.f223063a);
        r101.f223064b = r102;
    }

    @Override // i55.i
    public final void g(LiveData<ConnectionService.NetworkState> r100) {
        this.f501839f.f223067e = r100;
    }

    public final void j(ImportFailedType r100, int r101) {
        if (this.f512352a == 0) goto L6;
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new a(this, r100, r101));
        return;
    }
}
