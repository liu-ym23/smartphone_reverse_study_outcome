package k55;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends m75.a<o55.b> implements com.bytedance.ee.bear.drive.biz.importfile.request.b.a, i<o55.b> {
    public final b55.g e;
    public final StartImportRequesterManagerImplV2 f;
    public ImportFileEntity g;
    public final com.bytedance.ee.bear.drive.report.c h;
    public ImportFailedType i;

    public class a implements Consumer<String> {
        public final /* synthetic */ ImportFailedType a;
        public final /* synthetic */ int b;
        public final /* synthetic */ h c;

        public final void accept(Object r3) throws Exception {
            String r4 = (String) r3;
            h r5 = this.c;
            ImportFailedType r0 = this.a;
            r5.i = r0;
            ((o55.b) r5.a).Do(r0, this.b);
        }

        public a(h r1, ImportFailedType r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // i55.i
    public final /* synthetic */ String c() {
        return i55.h.a();
    }

    @Override // i55.i
    public final void b() {
        this.f.getClass();
    }

    @Override // i55.i
    public final void d() {
        final StartImportRequesterManagerImplV2 r0 = this.f;
        ImportFileEntity r1 = this.g;
        final String r2 = r1.a;
        final String r3 = r1.b;
        final l55.c r4 = r0.g;
        String r6 = r0.f.a;
        r4.getClass();
        FileInfoV1Puller.Params r5 = new FileInfoV1Puller.Params(r6, null, null, null, null, null);
        Disposable r7 = FileInfoPuller.V1(r4.c).pull(r5).onErrorResumeNext(new l55.a()).map(new l55.b(r4)).map(new l55.i(r0)).observeOn(fo5.d.d()).subscribe(new l55.g(r0, r2, r3), new l55.h(r0));
        r0.h.add(r7);
    }

    @Override // i55.i
    public final CompositeDisposable getCompositeDisposable() {
        return this.f.h;
    }

    @Override // i55.i
    public final void r() {
        final b55.g r0 = this.e;
        String r1 = this.g.a;
        r0.getClass();
        if (r1 != null) goto L5;
        final String r3 = "";
    L6:
        int r4 = t05.a.a;
        sbb.e r5 = sbb.e.l;
        Flowable.zip(t05.a.a(r3, r5.b), ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().a(r1, r5.b), ((rc5.a) org.koin.java.a.a(rc5.a.class)).f(r1, r5.b), new b55.f(r0, r3)).onErrorReturnItem(new oj5.a()).subscribe(new b(), new c());
        Flowable.just("").subscribeOn(fo5.d.b()).map(new d()).map(new e()).subscribe(new f(), new g());
        return;
    L5:
        r3 = r1;
        goto L6
    }

    @Override // m75.a, m75.d
    public final void onDestroy() {
        super.onDestroy();
        StartImportRequesterManagerImplV2 r0 = this.f;
        r0.i = null;
        if (r0.a == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).Lc(r0.a);
    L5:
        CompositeDisposable r1 = r0.h;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        ImportFailedType r2 = this.i;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2 != ImportFailedType.FailedOverLimitCount) goto L19;
        com.bytedance.ee.bear.drive.report.c r3 = this.h;
        ImportFileEntity r4 = this.g;
        r3.getClass();
        HashMap<String, Object> r5 = new HashMap();
        r5.put(JSEventListener.ACTION, "cancel");
        String r6 = r4.a;
        String r7 = r4.b;
        if (r7 == null) goto L15;
        String r8 = com.bytedance.ee.util.io.a.c(r7);
    L16:
        r3.z(r5, r6, r8);
        r5.put("trigger_action", "import");
        r3.d.v("client_commerce", r5);
        return;
    L15:
        r8 = "";
        goto L16
    }

    public h(FragmentActivity r1) {
        super(r1);
        o75.b.a().getDriveConfig();
        this.f = new StartImportRequesterManagerImplV2();
        this.e = new b55.g();
        this.h = o75.b.a().Ke();
    }

    @Override // i55.i
    public final void a(ImportFileEntity r6) {
        this.g = r6;
        this.h.B(r6);
        StartImportRequesterManagerImplV2 r0 = this.f;
        b55.g r1 = this.e;
        r0.c.B(r6);
        r0.f = r6;
        r0.i = this;
        r0.a = new com.bytedance.ee.bear.drive.biz.importfile.request.b.C0130b(r0);
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.a(com.bytedance.ee.space.sync.b.class)).i4(r6.a, 12, r0.a);
        r0.b = r1;
    }

    @Override // i55.i
    public final void g(LiveData<ConnectionService.NetworkState> r2) {
        this.f.e = r2;
    }

    public final void j(ImportFailedType r3, int r4) {
        if (this.a == 0) goto L6;
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new a(this, r3, r4));
        return;
    }
}
