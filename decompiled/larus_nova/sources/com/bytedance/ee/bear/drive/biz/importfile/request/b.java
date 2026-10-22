package com.bytedance.ee.bear.drive.biz.importfile.request;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes16.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3186b f223063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b55.g f223064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.c f223065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.report.a f223066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f223067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImportFileEntity f223068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l55.c f223069g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f223070h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f223071i;

    public interface a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.importfile.request.b$b, reason: collision with other inner class name */
    public class C3186b implements bu5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f223072a;

        public C3186b(StartImportRequesterManagerImplV2 r100) {
            this.f223072a = r100;
        }

        @Override // bu5.a
        public final void didReceivePush(String r100) {
            b r101 = this.f223072a;
            if (r101.f223064b == null) goto L15;
            LiveData<ConnectionService.NetworkState> r102 = r101.f223067e;
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.getValue() != null) goto L9;
            return;
        L9:
            if (r101.f223067e.getValue().a() == false) goto L18;
            ImportFileEntity r103 = r101.f223068f;
            if (r103 == null) goto L19;
            b55.g r104 = r101.f223064b;
            final String r105 = r103.f224401a;
            final com.bytedance.ee.bear.drive.biz.importfile.request.a r106 = new com.bytedance.ee.bear.drive.biz.importfile.request.a(r101);
            r104.getClass();
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().a(r105, sbb.e.f541301l.f541317b).observeOn(fo5.d.d()).subscribe(new b55.d(r106, r105), new b55.e(r106));
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    public b() {
        ((NetService) org.koin.java.a.a(NetService.class)).Vc(new l55.d());
        j r100 = j.a.f217090a;
        this.f223069g = new l55.c();
        this.f223070h = new CompositeDisposable();
        this.f223065c = o75.b.a().Ke();
        this.f223066d = o75.b.a().Tb();
    }
}
