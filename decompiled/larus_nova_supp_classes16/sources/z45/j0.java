package z45;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveManualResponseEntity;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncData;
import com.bytedance.ee.bear.drive.biz.cache.manual.model.ManualOfflineSyncDeletedTokenData;
import com.bytedance.ee.bear.drive.loader.download.DownStrategy;
import com.bytedance.ee.bear.drive.loader.download.platform.PlatformDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.ApiDriveExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j0 {
    public final com.bytedance.ee.bear.drive.cache.t a;
    public final Map<String, String> b;
    public final Map<String, Disposable> c;
    public final Map<String, Disposable> d;
    public final IDownloader e;
    public final com.bytedance.ee.bear.drive.config.strategy.d f;
    public final Context g;
    public final c h;
    public volatile boolean i;
    public final com.bytedance.ee.bear.contract.j j;
    public final com.bytedance.ee.bear.drive.view.preview.excel.b k;
    public final g85.f l;
    public final ww4.a m;
    public final com.bytedance.ee.bear.drive.report.c n;
    public final Map<String, String> o;
    public final a95.a p;

    public class a extends c85.b {
        public final /* synthetic */ a95.a e;
        public final /* synthetic */ j0 f;

        @Override // c85.b, c85.a
        public final boolean d(DriveCache r3, w75.c<f85.a> r4) {
            boolean r5 = super.d(r3, r4);
            if (r5 == false) goto L10;
            g85.f r0 = this.f.l;
            g85.b r1 = (g85.b) r0;
            if (r1.m(r3.d) == false) goto L10;
            if (z75.b.d(r3.b, this.e.b) == true) goto L10;
            tt5.a.h("DRIVE_MANUAL_CACHE", "manual cache download, ignore pdf streaming cache");
            return false;
        L10:
            return r5;
        }

        public a(j0 r1, com.bytedance.ee.bear.drive.config.strategy.d r2, a95.a r3, a95.a r4) {
            this.f = r1;
            this.e = r4;
            super(r2, r3);
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrCode.values().length];
            a = r0;
            r0[ErrCode.MANUAL_CACHE_NEED_WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            a[ErrCode.REQUEST_FILE_INFO_EXP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            a[ErrCode.FILE_NOT_FOUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            a[ErrCode.OWNER_DELETED_FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            a[ErrCode.PERMISSION_DENIED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ErrCode.POLICY_DENIED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            a[ErrCode.COPY_TIMEOUT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            a[ErrCode.COPY_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public class c implements com.bytedance.ee.bear.contract.n.d {
        public final /* synthetic */ j0 a;

        public c(j0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.n.d
        public final void a(String r6) {
            tt5.a.b("DRIVE_MANUAL_CACHE", "receive MG data callback: " + r6);
            JSONObject r7 = JSON.parseObject(r6);     // Catch: Exception -> L11
            String r1 = r7.getString(JSEventListener.ACTION);     // Catch: Exception -> L11
            if (ManualOfflineSyncData.ACTION_UPDATE.equals(r1) == false) goto L14;
            tt5.a.h("DRIVE_MANUAL_CACHE", "receive drive offWatchDriveUpdate");     // Catch: Exception -> L11
            ManualOfflineSyncData r8 = (ManualOfflineSyncData) r7.getJSONObject("data").toJavaObject(ManualOfflineSyncData.class);     // Catch: Exception -> L11
            if (r8.getType() == sbb.e.l.b) goto L10;
            tt5.a.h("DRIVE_MANUAL_CACHE", "receive not drive sync data push ignore it");     // Catch: Exception -> L11
            return;
        L10:
            tt5.a.h("DRIVE_MANUAL_CACHE", "receive drive sync data push");     // Catch: Exception -> L11
            tt5.a.h("DRIVE_MANUAL_CACHE", "receive drive channel = " + r8.getData().getChannel());     // Catch: Exception -> L11
            j0.b(this.a, r8.getToken());     // Catch: Exception -> L11
            return;
        L14:
            if (ManualOfflineSyncDeletedTokenData.ACTION_DELETED.equals(r1) == false) goto L25;
            ManualOfflineSyncDeletedTokenData r9 = (ManualOfflineSyncDeletedTokenData) r7.getJSONObject("data").toJavaObject(ManualOfflineSyncDeletedTokenData.class);     // Catch: Exception -> L11
            if (r9 != null) goto L18;
            return;
        L18:
            if (hu5.a.d(r9.getTokens()) == true) goto L27;
            j0.c(this.a, r9);     // Catch: Exception -> L11
            return;
        L27:
            return;
        L25:
            return;
        L11:
            e = move-exception;
            tt5.a.f("DRIVE_MANUAL_CACHE", e, false);
        }
    }

    public final void e() {
        tt5.a.h("DRIVE_MANUAL_CACHE", "cancelAllTask() start");
        Iterator r1 = ((ConcurrentHashMap) this.c).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        f((String) ((Map.Entry) r1.next()).getKey());
        goto L4
    L6:
        tt5.a.h("DRIVE_MANUAL_CACHE", "cancelAllTask() end");
    }

    public final void j() {
        tt5.a.h("DRIVE_MANUAL_CACHE", "unregister");
        tt5.a.h("DRIVE_MANUAL_CACHE", "unRegisterManualCacheDataChangeCallback");
        Flowable.just("").subscribeOn(fo5.d.b()).map(new f()).map(new g(this)).subscribe(new h(), new i());
    }

    public final void f(String r6) {
        if (((ConcurrentHashMap) this.b).get(r6) == null) goto L5;
        ((com.bytedance.ee.bear.h) org.koin.java.a.a(com.bytedance.ee.bear.h.class)).G(new ArrayList(Arrays.asList(new String[]{(String) ((ConcurrentHashMap) this.b).get(r6)})));
    L5:
        Disposable r7 = (Disposable) ((ConcurrentHashMap) this.c).get(r6);
        if (r7 != null) goto L8;
    L10:
        this.k.c.a();
        return;
    L8:
        if (r7.isDisposed() == true) goto L10;
        r7.dispose();
        goto L10
    }

    public j0(Context r6, a95.a r7) {
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.p = r7;
        o75.a r0 = o75.b.a();
        com.bytedance.ee.bear.drive.cache.t r1 = r0.getCacheManager();
        this.a = r1;
        com.bytedance.ee.bear.drive.config.strategy.d r2 = r0.Ic(com.bytedance.ee.bear.drive.config.strategy.g.class);
        this.f = r2;
        this.j = com.bytedance.ee.bear.contract.j.a.a;
        this.g = r6;
        this.h = new c(this);
        this.m = (ww4.a) org.koin.java.a.a(ww4.a.class);
        this.n = o75.b.a().Ke();
        this.e = PlatformDownloader.create(new ApiDriveExecutor("2", r7), new DownStrategy(r2), new a(this, r2, r7, r7), r7);
        this.k = new com.bytedance.ee.bear.drive.view.preview.excel.b(r1, r6, r7);
        this.l = o75.b.a().getMimeTypeManager();
    }

    public static void b(final j0 r3, final String r4) {
        r3.getClass();
        tt5.a.h("DRIVE_MANUAL_CACHE", "start handleReceiveSyncFile");
        if (((ConcurrentHashMap) r3.d).get(r4) != null) goto L5;
    L7:
        Disposable r0 = Flowable.timer(100, TimeUnit.MILLISECONDS).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).flatMap(new z45.c(r3, r4)).subscribe(new com.bytedance.ee.bear.bitable.homepage.list.a0(), new d());
        ((ConcurrentHashMap) r3.d).put(r4, r0);
        return;
    L5:
        if (((Disposable) ((ConcurrentHashMap) r3.d).get(r4)).isDisposed() == true) goto L7;
        ((Disposable) ((ConcurrentHashMap) r3.d).get(r4)).dispose();
        goto L7
    }

    public static void c(final j0 r2, ManualOfflineSyncDeletedTokenData r3) {
        r2.getClass();
        tt5.a.h("DRIVE_MANUAL_CACHE", "start handleReceiveDeletedFile");
        Flowable.create(new s0(r3), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.a()).observeOn(fo5.d.b()).flatMap(new z45.a(r2)).subscribe(new l(), new w());
    }

    public static void h(Throwable r2, final String r3) {
        if ((r2 instanceof DriveException) == false) goto L14;
        ErrCode r4 = ((DriveException) r2).getErrorCode();
        tt5.a.h("DRIVE_MANUAL_CACHE", " code = " + r4);
        if (r4 != ErrCode.PERMISSION_DENIED) goto L7;
    L12:
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).G(r3).observeOn(fo5.d.b()).subscribe(new x(r3), new y());
        return;
    L7:
        if (r4 == ErrCode.OWNER_DELETED_FILE) goto L12;
        if (r4 == ErrCode.FILE_NOT_FOUND) goto L12;
        if (r4 == ErrCode.POLICY_DENIED) goto L12;
        return;
    }

    public static void i(Throwable r12, com.bytedance.ee.bear.drive.services.w.b r13, f85.a r14, String r16) {
        tt5.a.f("DRIVE_MANUAL_CACHE", r12, false);
        if ((r12 instanceof DriveException) == true) goto L5;
    L13:
        if (r13 == null) goto L22;
        String r2 = ((f85.a.C0229a) r14.a).a;
        StringBuilder r17 = new StringBuilder("unexcepted error, ");
        if (r12 != null) goto L17;
        String r18 = "";
    L18:
        r17.append(r18);
        h85.u r19 = (h85.u) r13;
        r19.a(new DriveManualResponseEntity(0, r2, 0, r16, 0, r17.toString(), 0, null, 448));
        return;
    L17:
        r18 = r12.getMessage();
        goto L18
    L22:
        return;
    L5:
        switch(b.a[((DriveException) r12).getErrorCode().ordinal()]) {
            case 1: goto L10;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L13;
        };
    L7:
        if (r13 == null) goto L20;
        h85.u r110 = (h85.u) r13;
        r110.a(new DriveManualResponseEntity(((f85.a.C0229a) r14.a).a, r16, 501));
        return;
    L20:
        return;
    L10:
        if (r13 == null) goto L21;
        f85.a.C0229a r111 = (f85.a.C0229a) r14.a;
        h85.u r112 = (h85.u) r13;
        r112.a(new DriveManualResponseEntity(0, r111.a, 0, r16, 507, "", r111.c, r111.k));
        return;
    }

    public final void g(final pw4.d r12, final boolean r13, final boolean r14, final h85.u r16) {
        final String r0 = z75.d.a(r12.a, null, r12.b);
        CCMConfig r1 = this.m.a();
        if (r1.e != null) goto L6;
        r1.e = new CCMConfig.SubConfig();
    L6:
        if (r1.e.a == true) goto L11;
        tt5.a.d("DRIVE_MANUAL_CACHE", "downloadManualOfflineFileInternal() lean model!!!, ignore downloadManualOfflineFileInternal, callback failed");
        if (r16 == null) goto L13;
        r16.a(new DriveManualResponseEntity(r12.a, r0, 506));
        return;
    L13:
        return;
    L11:
        f(r12.a);
        final AtomicReference r2 = new AtomicReference();
        Disposable r17 = FileInfoPuller.V1((NetService) org.koin.java.a.a(NetService.class)).pull(new FileInfoV1Puller.Params(r12.a, null, FileInfoPuller.CALLER_EXPLORER, null, null, null)).doOnNext(new q(r2)).observeOn(fo5.d.e()).doOnNext(new r()).doOnError(new s(this, r12)).map(new t(this, r14, r13, r16, r12, r0)).flatMap(new u(this, r16, r12, r0)).subscribe(new com.bytedance.ee.bear.bitable.homepage.list.a0(), new v(this, r2, r16, r0, r12));
        Map<String, Disposable> r18 = this.c;
        ConcurrentHashMap r19 = (ConcurrentHashMap) r18;
        r19.put(r12.a, r17);
    }

    public static void d(j0 r10, com.bytedance.ee.bear.drive.services.w.b r11, w75.c r12, String r13, String r14) {
        r10.getClass();
        if (r11 == null) goto L9;
        f85.a.C0229a r16 = (f85.a.C0229a) ((f85.a) r12.getDetails()).a;
        if (TextUtils.isEmpty(r16.a) == true) goto L7;
        r13 = r16.a;
    L7:
        h85.u r17 = (h85.u) r11;
        r17.a(new DriveManualResponseEntity(0, r13, 0, r14, 505, "wrong streamingUrlCompleted step", r16.c, r16.k));
        return;
    }

    public static void a(j0 r8, final f85.a r9, final String r10, final String r11, final com.bytedance.ee.bear.drive.services.w.b r12, boolean r13) {
        r8.getClass();
        final f85.a.C0229a r0 = (f85.a.C0229a) r9.a;
        v85.c.a r1 = new v85.c.a();
        r1.a = 2;
        r1.b = r8.f.i(r9);
        r1.c = r0.a;
        r1.d = r0.b;
        r1.c(r9.a());
        r1.d(r9.b());
        r1.g = r9.r;
        r1.h = r0.p;
        r1.i = r0.k;
        r1.j = r9.f;
        r1.k = r9.h;
        r1.l = r8.f.getPreviewFileSourceType();
        r1.n = r0.g;
        r1.o = r9.e();
        r1.s = r13;
        v85.c r14 = new v85.c(r1);
        r8.a.m(r14, r8.p.b).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).subscribe(new z(r12, r0, r10, r11, r9), new a0(r12, r0, r10, r11, r9));
    }
}
