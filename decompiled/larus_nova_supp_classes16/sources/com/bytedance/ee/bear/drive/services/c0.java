package com.bytedance.ee.bear.drive.services;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.drive.biz.external.OpenExternalFragment;
import com.bytedance.ee.bear.drive.biz.fg.DriveSdkConfig;
import com.bytedance.ee.bear.drive.biz.upload.file.FileUploadFragment;
import com.bytedance.ee.bear.drive.biz.upload.multimedia.MediaUploadFragment;
import com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.UploadListActivity;
import com.bytedance.ee.bear.drive.common.activity.DriveCarrierActivity;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.test.DriveTestActivity;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import z45.e0;
import z45.f0;
import z45.g0;
import z45.h0;
import z45.i0;
import z45.j0;
import z45.l0;
import z45.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class c0 implements w, com.ss.android.lark.passportc.api.r {
    public final Application a;
    public WeakReference<Activity> b;
    public boolean c;
    public final com.bytedance.ee.bear.drive.preload.m d;
    public final boolean e;
    public final j0 f;
    public final CompositeDisposable g;
    public final com.ss.android.lark.passportc.api.m h;
    public final b i;

    public class a implements Runnable {
        public final /* synthetic */ ConnectionService a;
        public final /* synthetic */ c0 b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.services.c0$a$a, reason: collision with other inner class name */
        public class C0169a implements Observer<ConnectionService.NetworkState> {
            public final /* synthetic */ a a;

            public C0169a(a r1) {
                this.a = r1;
            }

            public final void onChanged(Object r4) {
                ConnectionService.NetworkState r5 = (ConnectionService.NetworkState) r4;
                if (r5 == null) goto L10;
                tt5.a.h("DriveServiceImpl", "networkState  = " + r5);
                c0 r0 = this.a.b;
                if (r0.c == r5.a()) goto L9;
                r0.c = r5.a();
                r0.d(true);
                return;
            L9:
                return;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a().observeForever(new C0169a(this));     // Catch: Throwable -> L4
            ((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).d().observeForever(new b0(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c0 r1, com.bytedance.ee.bear.contract.j r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ c0 a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r1) {
        }

        public b(c0 r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r3) {
            WeakReference<Activity> r0 = this.a.b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3 != r0.get()) goto L9;
            c0 r4 = this.a;
            r4.b = new WeakReference(null);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r3) {
            c0 r0 = this.a;
            r0.b = new WeakReference(r3);
        }
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void b() {
    }

    public final synchronized a95.a c() {
        monitor-enter(this);
        a95.a r0 = new a95.a(new o85.f(this.h.getSession()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private Context getContext() {
        WeakReference<Activity> r0 = this.b;
        if (r0 == null) goto L5;
        Activity r1 = r0.get();
    L6:
        if (r1 != null) goto L8;
    L9:
        tt5.a.k("DriveServiceImpl", "Activity is null or finishing. activity = " + r1);
        return this.a;
    L8:
        if (r1.isFinishing() == true) goto L9;
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void a() {
        tt5.a.h("DriveServiceImpl", "cancelTask() start");     // Catch: Exception -> L7
        tt5.a.h("DriveServiceImpl", "IMGDriveInterfaces.class).cancelAll ret=" + ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().a());     // Catch: Exception -> L7
        this.f.e();     // Catch: Exception -> L7
        this.f.j();     // Catch: Exception -> L7
        com.bytedance.ee.bear.drive.preload.m r1 = this.d;     // Catch: Exception -> L7
        r1.getClass();     // Catch: Exception -> L7
        tt5.a.h("DrivePreloadExecutor", "cancelAllTask start()");     // Catch: Exception -> L7
        Iterator r2 = ((CopyOnWriteArrayList) r1.d).iterator();     // Catch: Exception -> L7
    L5:
        if (r2.hasNext() == false) goto L9;
        ((com.bytedance.ee.bear.drive.preload.m.a) r2.next()).d();     // Catch: Exception -> L7
        goto L5
    L9:
        tt5.a.h("DrivePreloadExecutor", "cancelAllTask end()");     // Catch: Exception -> L7
        this.g.clear();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.f("DriveServiceImpl", e, false);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final Flowable<Boolean> n7() {
        return Flowable.just(Boolean.TRUE);
    }

    public final com.ss.android.lark.passportc.api.m getPassport() {
        return this.h;
    }

    @Inject
    public c0(com.ss.android.lark.passportc.api.m r16) {
        this.g = new CompositeDisposable();
        this.h = null;
        b r0 = new b(this);
        this.i = r0;
        if (this.e == false) goto L5;
        return;
    L5:
        this.h = r16;
        Application r1 = LarkContext.getApplication();
        this.a = r1;
        long r2 = System.currentTimeMillis();
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().init();
        com.bytedance.ee.bear.contract.j r4 = com.bytedance.ee.bear.contract.j.a.a;
        this.c = r4.getNetworkState().a();
        this.d = new com.bytedance.ee.bear.drive.preload.m(r1, c());
        final j0 r5 = new j0(r1, c());
        this.f = r5;
        if (r5.i == true) goto L12;
        r5.i = true;
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L11;
        tt5.a.h("DRIVE_MANUAL_CACHE", "ignore init because isSuiteFileFeatureEnable=false");
        goto L12
    L11:
        tt5.a.h("DRIVE_MANUAL_CACHE", "registerManualCacheDataChangeCallback");
        Flowable.just("").subscribeOn(fo5.d.b()).map(new z45.c0()).map(new z45.d0(r5)).subscribe(new e0(), new f0());
        tt5.a.h("DRIVE_MANUAL_CACHE", "checkNoMoreNeedManualOfflineFile start");
        final long r9 = System.currentTimeMillis() - TimeUnit.MILLISECONDS.convert(10, TimeUnit.DAYS);
        final com.bytedance.ee.bear.drive.cache.t r6 = r5.a;
        final a95.a r11 = r5.p;
        r6.getClass();
        Flowable.fromCallable(new com.bytedance.ee.bear.drive.cache.g(r6)).map(new com.bytedance.ee.bear.drive.cache.h(r9, r11)).subscribeOn(fo5.d.b()).observeOn(fo5.d.b()).onErrorResumeNext(Flowable.just(new ArrayList())).flatMap(new g0()).delay(2, TimeUnit.SECONDS).flatMap(new h0(r5)).subscribe(new i0(), new z45.b());
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).w(new l0(r5));
    L12:
        com.bytedance.ee.util.ui.m.a(new a(this, r4));
        t65.k r7 = new t65.k();
        r7.a = r1;
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().m("all_files_token", "", new t65.j(r7, r1));
        w55.j.b().subscribe(new x(), new y());
        DriveSdkConfig.getConfig();
        tt5.a.h("DriveServiceImpl", "registerActivityLifecycleCallbacks");
        r1.registerActivityLifecycleCallbacks(r0);
        r16.d(this);
        this.e = true;
        tt5.a.h("DriveServiceImpl", "DriveServiceImpl.lazyInit finish, cost time=" + (System.currentTimeMillis() - r2));
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void C0(final String r4) {
        final j0 r0 = this.f;
        if (r0 != null) goto L6;
        tt5.a.d("DriveServiceImpl", "mManualCacheDownloadManager is null");
        return;
    L6:
        r0.f(r4);
        Flowable.just(r4).observeOn(fo5.d.b()).map(new z45.b0(r0, r4)).subscribe(new com.bytedance.ee.bear.bitable.homepage.list.a0(), new a0());
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void G(ArrayList<String> r3) {
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().n((String[]) r3.toArray(new String[r3.size()]));
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void G0(Bundle r4) {
        Context r0 = getContext();
        Intent r1 = new Intent(r0, DriveTestActivity.class);     // Catch: Exception -> L11
        if (r4 == null) goto L7;
        r1.putExtras(r4);     // Catch: Exception -> L11
    L7:
        if ((r0 instanceof Application) == false) goto L9;
        r1.addFlags(268435456);     // Catch: Exception -> L11
    L9:
        r0.startActivity(r1);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        tt5.a.e("DriveRouteHelper", "openDriveTestActivity: ", e, false);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void R0(d0 r3) {
        Lazy r0 = DriveOpenMonitorImpl.a;
        Intrinsics.checkNotNullParameter(r3, "driveOpenMonitor");
        ((List) DriveOpenMonitorImpl.a.getValue()).add(new WeakReference(r3));
    }

    public final void afterUserOffline(f0c.h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        a();
        Application r4 = this.a;
        if (r4 == null) goto L5;
        tt5.a.h("DriveServiceImpl", "unRegisterActivityLifecycle");
        r4.unregisterActivityLifecycleCallbacks(this.i);
    L5:
        com.ss.android.lark.passportc.api.m r5 = this.h;
        if (r5 == null) goto L9;
        r5.c(this);
        return;
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void d(boolean r4) {
        if (((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).hasLogin() == false) goto L12;
        boolean r0 = ((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).f();
        tt5.a.h("DriveServiceImpl", "handleAutoResumeUpload isDoze  " + r0);
        if (this.c == false) goto L9;
        if (r0 == true) goto L9;
        tt5.a.h("DriveServiceImpl", "handleAutoResumeUpload resume_all  ");
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().k(!r4).subscribeOn(fo5.d.b()).subscribe();
        return;
    L9:
        if (((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().v() <= 0) goto L14;
        tt5.a.h("DriveServiceImpl", "handleAutoResumeUpload cancel_all getQueueCount is " + ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().v());
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().e().subscribeOn(fo5.d.b()).subscribe();
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final IPlayer l8(Context r2) {
        return new com.bytedance.ee.bear.drive.view.preview.video.player.d(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void m0(ImportFileEntity r2) {
        u85.a.a(getContext(), r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void onLoginStatusChangedEvent(final int r4) {
        StringBuilder r0 = new StringBuilder("onLoginStatusChangedEvent... event = ");
        if (r4 != 0) goto L5;
        String r1 = "BEFORE_LOGOUT";
    L21:
        r0.append(r1);
        tt5.a.h("DriveServiceImpl", r0.toString());
        Flowable.fromCallable(new z(this, r4)).subscribeOn(fo5.d.b()).onErrorReturnItem(Boolean.FALSE).subscribe();
        return;
    L5:
        if (r4 != 1) goto L7;
        r1 = "LOGIN";
        goto L21
    L7:
        if (r4 != 2) goto L9;
        r1 = "LOGOUT";
        goto L21
    L9:
        if (r4 != 3) goto L11;
        r1 = "SWITCH_TENANT_START";
        goto L21
    L11:
        if (r4 != 4) goto L13;
        r1 = "SWITCH_TENANT_END";
        goto L21
    L13:
        if (r4 == 5) goto L15;
        r1 = "UNKNOWN = " + r4;
        goto L21
    L15:
        r1 = "SWITCH_TENANT_FAILED";
        goto L21
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void r(rf5.e r2) {
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().r(r2);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final Flowable<Boolean> D(final int r5, final ArrayList<DriveOfflineDoc> r6) {
        final com.bytedance.ee.bear.drive.preload.m r0 = this.d;
        r0.getClass();
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L5;
        tt5.a.h("DrivePreloadExecutor", "preloadFile ignore because isSuiteFileFeatureEnable=false");
        return Flowable.just(Boolean.FALSE);
    L5:
        tt5.a.h("DrivePreloadExecutor", "start preload drive file, type=" + r5);
        if (CollectionUtils.isEmpty(r6) == false) goto L8;
        tt5.a.k("DrivePreloadExecutor", "preload file list is empty, ignore preload.");
        return Flowable.just(Boolean.FALSE);
    L8:
        tt5.a.h("DrivePreloadExecutor", "preload drive file size=" + r6.size() + " type = " + r5 + " config size=" + r0.a(r5));
        return Flowable.just(r6).observeOn(fo5.d.e()).map(new com.bytedance.ee.bear.drive.preload.a(r0, r5)).map(new com.bytedance.ee.bear.drive.preload.b(r0, r6));
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void i9(String r4, ArrayList<PreviewAction> r5) {
        tt5.a.h("DriveSdk", "DriveServiceImpl#execDriveSdkPreviewAction(), uniqueId=" + r4 + " ,actions=" + r5);
        if (r5 == null) goto L16;
        Iterator<PreviewAction> r6 = r5.iterator();     // Catch: Exception -> L9
    L6:
        if (r6.hasNext() == false) goto L17;
        j75.b.a().b(new j75.b.a(r6.next()));     // Catch: Exception -> L9
        goto L6
    L17:
        return;
    L9:
        e = move-exception;
        tt5.a.e("DriveSdk", "DriveServiceImpl#execDriveSdkPreviewAction() error=", e, false);
        return;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [d55.f] */
    @Override // com.bytedance.ee.bear.drive.services.w
    public final void W(Context r4, String r5, boolean r6) {
        tt5.a.h("DriveServiceImpl", "DriveServiceImpl.requestPreviewUsingPlatformCapability");
        Bundle r1 = new Bundle();
        r1.putString("url", r5);
        final Activity r7 = ContextsKt.findActivity(r4);
        if (r6 == false) goto L10;
        if (r7 == null) goto L9;
        final com.bytedance.ee.bear.drive.biz.external.e r8 = new com.bytedance.ee.bear.drive.biz.external.e(r1, r7, c());
        if (com.bytedance.ee.util.ui.b.a(r7) == true) goto L8;
        tt5.a.h("DRIVE_OpenExternalHandler", "showFileStorageConfirmDialog activity finished");
        return;
    L8:
        final ?? r9 = new d55.f(r8, r7);
        com.ss.android.lark.utils.h.g(r7, new d55.i(r9, r7), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_list_drive_open_external"), new String[0]);
        return;
    L9:
        tt5.a.h("DriveServiceImpl", "DriveServiceImpl.requestPreviewUsingPlatformCapability activity is null");
        return;
    L10:
        DriveCarrierActivity.C1(getContext(), OpenExternalFragment.class, r1, -1);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void kb(boolean r10, final pw4.d r11, final h85.u r12) {
        final j0 r6 = this.f;
        if (r6 != null) goto L6;
        tt5.a.d("DriveServiceImpl", "mManualCacheDownloadManager is null");
        return;
    L6:
        Bundle r0 = r11.c;
        if (r0 == null) goto L12;
        String r1 = r0.getString("module");
        if (TextUtils.isEmpty(r1) == true) goto L12;
        Map<String, String> r2 = r6.o;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(r11.a, r1);
    L12:
        if (r6.j.getNetworkState().a() == true) goto L14;
        final String r5 = du5.d.a(r11.a);
        final String r13 = z75.d.a(r11.a, null, r11.b);
        Disposable r14 = Flowable.just(r11.a).observeOn(fo5.d.b()).map(new z45.m(r6, r5)).map(new m0(r6)).map(new z45.n(r6, r12, r11, r13, r5)).subscribe(new z45.o(r12, r11, r13), new z45.p(r12, r11, r13));
        Map<String, Disposable> r16 = r6.c;
        ConcurrentHashMap r17 = (ConcurrentHashMap) r16;
        r17.put(r11.a, r14);
        return;
    L14:
        r6.g(r11, false, r10, r12);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void m(String r2, String r3, rf5.e r4) {
        ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.a(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().m(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void D0(Activity r5, String r6, String r7, String r8) {
        tt5.a.h("DriveServiceImpl", "DriveServiceImpl.showUploadStateView:  ");
        Intent r0 = new Intent(this.a, UploadListActivity.class);     // Catch: Exception -> L12
        if (r5 == null) goto L6;
        Context r9 = r5;
    L8:
        if ((r9 instanceof Application) == false) goto L10;
        r0.addFlags(268435456);     // Catch: Exception -> L12
    L10:
        r0.putExtra(DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN, r6);     // Catch: Exception -> L12
        r0.putExtra(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r7);     // Catch: Exception -> L12
        r0.putExtra(DocViewModel.EXTRA_SPACE_ID, r8);     // Catch: Exception -> L12
        r9.startActivity(r0);     // Catch: Exception -> L12
        return;
    L6:
        r9 = getContext();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.e("DriveServiceImpl", "showUploadStateView: ", e, false);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void J0(String r3, String r4, Bundle r5, int r6) {
        tt5.a.h("DriveServiceImpl", "DriveServiceImpl.uploadFile, mountPoint: " + r4);
        DriveCarrierActivity.C1(getContext(), FileUploadFragment.class, r65.d.a(r3, r4, r5), r6);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void r0(String r3, String r4, Bundle r5, int r6) {
        tt5.a.h("DriveServiceImpl", "DriveServiceImpl.uploadMedia: mountPoint: " + r4);
        DriveCarrierActivity.C1(getContext(), MediaUploadFragment.class, r65.d.a(r3, r4, r5), r6);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void E(Activity r1, String r2, String r3, Bundle r4, int r5) {
        Bundle r6 = r65.d.a(r2, r3, r4);
        r6.putBoolean("extras_need_result", true);
        DriveCarrierActivity.D1(r1, FileUploadFragment.class, r6, r5);
    }

    @Override // com.bytedance.ee.bear.drive.services.w
    public final void u(Activity r1, String r2, String r3, Bundle r4, int r5) {
        Bundle r6 = r65.d.a(r2, r3, r4);
        r6.putBoolean("extras_need_result", true);
        DriveCarrierActivity.D1(r1, MediaUploadFragment.class, r6, r5);
    }
}
