package com.bytedance.ee.bear.drive.biz.importfile.request;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b {
    public C0130b a;
    public b55.g b;
    public final com.bytedance.ee.bear.drive.report.c c;
    public final com.bytedance.ee.bear.drive.report.a d;
    public LiveData<ConnectionService.NetworkState> e;
    public ImportFileEntity f;
    public final l55.c g;
    public final CompositeDisposable h;
    public a i;

    public interface a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.importfile.request.b$b, reason: collision with other inner class name */
    public class C0130b implements bu5.a {
        public final /* synthetic */ b a;

        public C0130b(StartImportRequesterManagerImplV2 r1) {
            this.a = r1;
        }

        public final void didReceivePush(String r4) {
            b r5 = this.a;
            if (r5.b == null) goto L15;
            LiveData<ConnectionService.NetworkState> r0 = r5.e;
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.getValue() != null) goto L9;
            return;
        L9:
            if (((ConnectionService.NetworkState) r5.e.getValue()).a() == false) goto L18;
            ImportFileEntity r1 = r5.f;
            if (r1 == null) goto L19;
            b55.g r2 = r5.b;
            final String r3 = r1.a;
            final com.bytedance.ee.bear.drive.biz.importfile.request.a r6 = new com.bytedance.ee.bear.drive.biz.importfile.request.a(r5);
            r2.getClass();
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().a(r3, sbb.e.l.b).observeOn(fo5.d.d()).subscribe(new b55.d(r6, r3), new b55.e(r6));
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    public b() {
        ((NetService) org.koin.java.a.a(NetService.class)).Vc(new l55.d());
        j r0 = j.a.a;
        this.g = new l55.c();
        this.h = new CompositeDisposable();
        this.c = o75.b.a().Ke();
        this.d = o75.b.a().Tb();
    }
}
