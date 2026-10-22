package zd7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.bullet.kit.web.download.WebResourceDownloader;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.thread.ThreadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.downloadFile")
public final class m extends yd7.e {

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.e.c> f571384a;

        public b(CompletionBlock<yd7.e.c> r100) {
            this.f571384a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CompletionBlock.DefaultImpls.onFailure$default(this.f571384a, 0, "file path already exist", null, 4, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f571385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f571387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ yd7.e.b f571388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.e.c> f571389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f571390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f571391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f571392h;

        public c(m r100, IBDXBridgeContext r101, Context r102, yd7.e.b r103, CompletionBlock<yd7.e.c> r104, String r105, String r106, String r107) {
            this.f571385a = r100;
            this.f571386b = r101;
            this.f571387c = r102;
            this.f571388d = r103;
            this.f571389e = r104;
            this.f571390f = r105;
            this.f571391g = r106;
            this.f571392h = r107;
        }

        public final void a() {
            m r100 = this.f571385a;
            IBDXBridgeContext r101 = this.f571386b;
            Context r102 = this.f571387c;
            yd7.e.b r103 = this.f571388d;
            CompletionBlock<yd7.e.c> r104 = this.f571389e;
            String r110 = this.f571390f;
            String r111 = this.f571391g;
            String r105 = this.f571392h;
            r100.getClass();
            Context r106 = r102.getApplicationContext();
            s r112 = new s(r103, r101, r106, r104, r105, r102);
            DownloadTask r107 = Downloader.with(r106).url(r103.getUrl()).name(r110).savePath(r111).addListenerToSameTask(true);
            Boolean r108 = r103.getNeedCommonParams();
            if (r108 == null) goto L5;
            boolean r109 = r108.booleanValue();
        L6:
            DownloadTask r113 = r107.addTTNetCommonParam(r109).deleteCacheIfCheckFailed(true).retryCount(0).autoSetHashCodeForSameTask(true).expiredRedownload(true).mainThreadListener(r112).monitorScene("XBridge");
            Set<String> r114 = SecurityContextUtils.f269807a;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            DownloadTask r115 = r113.extraHeaders(CollectionsKt.listOf(new HttpHeader("x-security-argus", SecurityContextUtils.d(r101))));
            Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L13
            Method r117 = WebResourceDownloader.f246954c;     // Catch: Throwable -> L13
            if (r117 == null) goto L10;
            Object r118 = r117.invoke(r115, new Object[]{1209600L});     // Catch: Throwable -> L13
        L11:
            Result.m9449constructorimpl(r118);     // Catch: Throwable -> L13
        L15:
            r115.asyncDownload(null);
            return;
        L10:
            r118 = null;
        L13:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        L5:
            r109 = true;
            goto L6
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

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yd7.e.b f571393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f571395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f571396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.e.c> f571397e;

        public static final class a implements te7.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f571398a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ yd7.e.b f571399b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f571400c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ CompletionBlock<yd7.e.c> f571401d;

            @Override // te7.b
            public final void a(te7.i r110) {
                String r100 = r110.c();
                boolean r101 = true;
                if (r100.length() <= 0) goto L5;
                boolean r102 = true;
            L6:
                BufferedInputStream r103 = null;
                BufferedOutputStream r104 = null;
                BufferedOutputStream r105 = null;
                r103 = null;
                if (r102 == true) goto L10;
                r100 = null;
            L10:
                if (r100 != null) goto L22;
                Throwable r106 = r110.d();
                if (r106 == null) goto L21;
                r100 = r106.getMessage();
                if (r100 == null) goto L21;
                if (r100.length() > 0) goto L19;
                r101 = false;
            L19:
                if (r101 == true) goto L22;
            L21:
                r100 = null;
            L22:
                InputStream r107 = r110.e();
                int r108 = r110.f545613b.element;
                Integer r111 = r110.b();
                if (r107 != null) goto L26;
                ThreadUtils.a().post(new o(this.f571401d, r100, r108, r111));
                return;
            L26:
                LinkedHashMap<String, String> r109 = r110.f545612a;
                BufferedInputStream r112 = new BufferedInputStream(r107);     // Catch: Throwable -> L52 Exception -> L54
                BufferedOutputStream r113 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(this.f571398a));     // Catch: Throwable -> L48 Exception -> L50
            L85:
                Ref.IntRef r114 = new Ref.IntRef();     // Catch: Throwable -> L44 Exception -> L46
                byte[] r115 = new byte[4096];     // Catch: Throwable -> L44 Exception -> L46
            L30:
                int r116 = r112.read(r115);     // Catch: Throwable -> L44 Exception -> L46
                r114.element = r116;     // Catch: Throwable -> L44 Exception -> L46
                if (r116 == (-1)) goto L33;
                r113.write(r115, 0, r116);     // Catch: Throwable -> L44 Exception -> L46
                goto L30
            L33:
                r113.flush();     // Catch: Throwable -> L44 Exception -> L46
                if (this.f571399b.getSaveToAlbum() == null) goto L41;
                int r117 = ae7.f.f3112a;     // Catch: Throwable -> L44 Exception -> L46
                Context r118 = this.f571400c;     // Catch: Throwable -> L44 Exception -> L46
                String r119 = this.f571398a;     // Catch: Throwable -> L44 Exception -> L46
                String r120 = this.f571399b.getSaveToAlbum();     // Catch: Throwable -> L44 Exception -> L46
                Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L44 Exception -> L46
                ThreadUtils.a().post(new p(this.f571401d, r109, ae7.f.a(r118, r119, Intrinsics.areEqual(r120, "image")), r108, r111));     // Catch: Throwable -> L44 Exception -> L46
                r110.a();     // Catch: IOException -> L38
                r112.close();     // Catch: IOException -> L38
                r113.close();     // Catch: IOException -> L38
                return;
            L38:
                e = move-exception;
                e.printStackTrace();
                return;
            L41:
                ThreadUtils.a().post(new q(this.f571401d, r109, this.f571398a, r108, r111));     // Catch: Throwable -> L44 Exception -> L46
                r110.a();     // Catch: IOException -> L63
                r112.close();     // Catch: IOException -> L63
                r113.close();     // Catch: IOException -> L63
                return;
            L46:
                Exception e100 = e;
                r104 = r113;
            L51:
                BufferedOutputStream r121 = r104;
                r103 = r112;
                BufferedOutputStream r122 = r121;
            L79:
                ThreadUtils.a().post(new r(this.f571401d, e100, r108, r111));     // Catch: Throwable -> L66
                r110.a();     // Catch: IOException -> L63
                if (r103 == null) goto L60;
                r103.close();     // Catch: IOException -> L63
            L60:
                if (r122 == null) goto L89;
                r122.close();     // Catch: IOException -> L63
                return;
            L89:
                return;
            L66:
                Throwable th10 = th;
            L81:
                r110.a();     // Catch: IOException -> L73
                if (r103 == null) goto L70;
                r103.close();     // Catch: IOException -> L73
            L70:
                if (r122 == null) goto L75;
                r122.close();     // Catch: IOException -> L73
            L75:
                throw th10;
            L73:
                e = move-exception;
                e.printStackTrace();
            L44:
                th10 = th;
                r105 = r113;
            L49:
                BufferedOutputStream r123 = r105;
                r103 = r112;
                r122 = r123;
            L50:
                e100 = e;
            L48:
                th10 = th;
                goto L49
            L63:
                e = move-exception;
                e.printStackTrace();
                return;
            L54:
                e = move-exception;
                e100 = e;
                r122 = null;
            L52:
                th = move-exception;
                th10 = th;
                r122 = null;
                goto L81
            L5:
                r102 = false;
                goto L6
            }

            public a(String r100, yd7.e.b r101, Context r102, CompletionBlock<yd7.e.c> r103) {
                this.f571398a = r100;
                this.f571399b = r101;
                this.f571400c = r102;
                this.f571401d = r103;
            }
        }

        public d(yd7.e.b r100, IBDXBridgeContext r101, String r102, Context r103, CompletionBlock<yd7.e.c> r104) {
            this.f571393a = r100;
            this.f571394b = r101;
            this.f571395c = r102;
            this.f571396d = r103;
            this.f571397e = r104;
        }

        public final void a() {
            te7.e r100 = te7.e.f545589a;
            String r101 = this.f571393a.getUrl();
            Map<String, Object> r102 = this.f571393a.getParams();
            PlatformType r103 = this.f571394b.getPlatformType();
            r100.getClass();
            boolean r104 = true;
            String r105 = te7.e.a(r101, r102, r103, true);
            LinkedHashMap r106 = te7.e.f(this.f571393a.getHeader());
            te7.e.b(r106, this.f571394b);
            a r107 = new a(this.f571395c, this.f571393a, this.f571396d, this.f571397e);
            int r108 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
            IHostNetworkDepend r109 = com.bytedance.sdk.xbridge.cn.utils.g.d();
            Boolean r110 = this.f571393a.getNeedCommonParams();
            if (r110 == null) goto L5;
            r104 = r110.booleanValue();
        L5:
            r100.getClass();
            te7.e.e(r105, r106, r107, r109, r104);
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

    static {
    }

    public m() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.e.b r100 = (yd7.e.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        Activity r102 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
        if (r102 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        return;
    L8:
        boolean r103 = true;
        boolean r104 = false;
        if (r100.getUrl().length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L35;
        String r106 = r100.getExtension();
        if (r106 != null) goto L16;
    L19:
        if (r103 == true) goto L35;
        IHostPermissionDepend r107 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r107 == null) goto L24;
        String[] r108 = ae7.h.b();
        r104 = r107.isPermissionAllGranted(r102, (String[]) Arrays.copyOf(r108, r108.length));
    L24:
        if (r104 == false) goto L26;
    L34:
        a(r110, r101, r100, r112);
        return;
    L26:
        if (ae7.f.b() == true) goto L34;
        IHostPermissionDepend r113 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r113 == null) goto L31;
        String r114 = this.f567326a;
        String[] r109 = ae7.h.b();
        r113.requestPermission(r102, r110, r114, (String[]) Arrays.copyOf(r109, r109.length), new n(this, r110, r101, r100, r112));
        Unit r115 = Unit.INSTANCE;
    L32:
        if (r115 != null) goto L39;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "DownloadFileDepend is null", null, 4, null);
        return;
    L39:
        return;
    L31:
        r115 = null;
        goto L32
    L16:
        if (r106.length() == 0) goto L19;
        r103 = false;
    L35:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
        return;
    L11:
        r105 = false;
        goto L12
    }

    public final void a(IBDXBridgeContext r110, Context r111, yd7.e.b r112, CompletionBlock<yd7.e.c> r113) {
        StringBuilder r100 = new StringBuilder();
        char[] r101 = ae7.e.f3111a;
        r100.append(ae7.e.a(r112.getUrl()));
        r100.append(System.currentTimeMillis());
        String r102 = r100.toString() + '.' + r112.getExtension();
        File r103 = r111.getExternalCacheDir();
        if (r103 != null) goto L5;
        r103 = r111.getCacheDir();
    L5:
        if (r103 != null) goto L7;
        String r104 = null;
    L8:
        String r114 = r104;
        if (r114 != null) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r113, 0, "cacheDir is null", null, 4, null);
        return;
    L12:
        String r105 = r114 + '/' + r102;
        if (new PolarisFileWrapper(r105).exists() == false) goto L16;
        ThreadUtils.a().post(new b(r113));
        return;
    L16:
        Map<String, Map<Class<?>, Object>> r106 = x26.a.f562251a;
        w26.g r107 = (w26.g) x26.a.a(w26.g.class);
        if (r107 == null) goto L23;
        w26.e r108 = (w26.e) r107.n0(w26.e.class);
        if (r108 == null) goto L23;
        Boolean r109 = r108.w2();
        if (r109 == null) goto L23;
        boolean r115 = r109.booleanValue();
    L24:
        if (r115 == false) goto L27;
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new c(this, r110, r111, r112, r113, r102, r114, r105));
        return;
    L27:
        com.bytedance.sdk.xbridge.cn.utils.g.a().execute(new d(r112, r110, r105, r111, r113));
        return;
    L23:
        r115 = true;
        goto L24
    L7:
        r104 = r103.getAbsolutePath();
        goto L8
    }
}
