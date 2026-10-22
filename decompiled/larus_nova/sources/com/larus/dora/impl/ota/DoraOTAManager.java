package com.larus.dora.impl.ota;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.ota.connector.DoraOTAWifiConnector;
import com.larus.dora.impl.ota.g.DoraGOTAPlugin;
import com.larus.dora.impl.ota.g2.DownloadOwnerKind;
import com.larus.dora.impl.ota.g2.G2OtaFacade;
import com.larus.dora.impl.ota.g2.b5;
import com.larus.dora.impl.ota.g2.j0;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraOTAManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraOTAManager f337359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<p> f337360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f337361c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StateFlowImpl f337362d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f337363e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MutableSharedFlow f337364f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f337365g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f337366h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f337367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CoroutineScope f337368j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Job f337369k;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f337370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e49.a f337371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f337372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f337373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f337374e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f337375f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f337376g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f337370a, r101.f337370a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337371b, r101.f337371b) == true) goto L15;
            return false;
        L15:
            if (this.f337372c == r101.f337372c) goto L18;
            return false;
        L18:
            if (this.f337373d == r101.f337373d) goto L21;
            return false;
        L21:
            if (this.f337374e == r101.f337374e) goto L24;
            return false;
        L24:
            if (this.f337375f == r101.f337375f) goto L27;
            return false;
        L27:
            if (this.f337376g == r101.f337376g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f337370a.hashCode() * 31) + this.f337371b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f337372c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (((r100 + r102) * 31) + this.f337373d) * 31;
            long r104 = this.f337374e;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            if (this.f337375f == true) goto L10;
            r101 = 1237;
        L10:
            int r106 = (r105 + r101) * 31;
            long r107 = this.f337376g;
            return r106 + ((int) (r107 ^ (r107 >>> 32)));
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "DownloadResumeContext(sn=" + this.f337370a + ", responseWrapper=" + this.f337371b + ", onlyWifi=" + this.f337372c + ", progress=" + this.f337373d + ", progressUpdateTimeMillis=" + this.f337374e + ", waitingWifiResume=" + this.f337375f + ", lastAutoResumeTimeMillis=" + this.f337376g + ')';
        }

        public a(String r100, e49.a r101, boolean r102, int r103, long r104, boolean r105, long r106) {
            Intrinsics.checkNotNullParameter(r100, "sn");
            Intrinsics.checkNotNullParameter(r101, "responseWrapper");
            this.f337370a = r100;
            this.f337371b = r101;
            this.f337372c = r102;
            this.f337373d = r103;
            this.f337374e = r104;
            this.f337375f = r105;
            this.f337376g = r106;
        }
    }

    public DoraOTAManager() {
    }

    static {
        f337359a = new DoraOTAManager();
        f337360b = new CopyOnWriteArrayList();
        k r100 = new k();
        f337361c = r100;
        f337362d = r100.f337773b;
        d r101 = new d();
        f337363e = r101;
        f337364f = r101.f337482b;
        f337365g = LazyKt.lazy(new g());
        f337366h = new Object();
        f337368j = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public static String c(String r110) {
        if (r110 == null) goto L5;
        String r111 = StringsKt.trim(r110).toString();
    L6:
        if (r111 != null) goto L8;
        r111 = "";
    L8:
        boolean r100 = true;
        if (r111.length() != 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
    L38:
        String r112 = "unknown";
    L39:
        AppHost.Companion r102 = AppHost.f326268a;
        File r103 = r102.getApplication().getExternalFilesDir(null);
        if (r103 != null) goto L42;
        r103 = r102.getApplication().getFilesDir();
    L42:
        Intrinsics.checkNotNull(r103);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, "dora/ota");
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, r112);
        if (f(r105, r104) == false) goto L45;
        String r113 = r105.getAbsolutePath();
        Intrinsics.checkNotNull(r113);
        return r113;
    L45:
        File r106 = r102.getApplication().getFilesDir();
        Intrinsics.checkNotNull(r106);
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106, "dora/ota");
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107, r112);
        f(r108, r107);
        String r114 = r108.getAbsolutePath();
        Intrinsics.checkNotNull(r114);
        return r114;
    L15:
        if (Intrinsics.areEqual(r111, ".") == true) goto L38;
        if (Intrinsics.areEqual(r111, DownloadConstants.VULNERABILITY_PATH) == true) goto L38;
        ArrayList r109 = new ArrayList(r111.length());
        int r115 = 0;
    L21:
        if (r115 >= r111.length()) goto L33;
        char r116 = r111.charAt(r115);
        if (Character.isLetterOrDigit(r116) == true) goto L32;
        if (r116 == '_') goto L32;
        if (r116 == '-') goto L32;
        if (r116 == '.') goto L32;
        r116 = '_';
    L32:
        r109.add(Character.valueOf(r116));
        r115 = r115 + 1;
        goto L21
    L33:
        r112 = CollectionsKt.joinToString$default(r109, "", null, null, 0, null, null, 62, null);
        if (r112.length() == 0) goto L37;
        r100 = false;
    L37:
        if (r100 == false) goto L39;
    L11:
        r101 = false;
        goto L12
    L5:
        r111 = null;
        goto L6
    }

    public static p e(DoraDevice r100) {
        p r101 = null;
        if (o59.a.p(r100) == true) goto L6;
        g49.d.d("DoraOTAManager", "getTaskOrNull: " + r100.f204390sn + " not DoraG device");
        return null;
    L6:
        Iterator<p> r102 = f337360b.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        p r103 = r102.next();
        if (Intrinsics.areEqual(r103.getSn(), r100.f204390sn) == false) goto L8;
        r101 = r103;
    L13:
        return r101;
    }

    public final synchronized p d(DoraDevice r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "device");     // Catch: Throwable -> L12
        g49.d.d("DoraOTAManager", "getTask: " + r100.f204390sn);     // Catch: Throwable -> L12
        p r101 = e(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        String r102 = r100.f204390sn;     // Catch: Throwable -> L12
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r101 = new DoraOTATask(r102, f337361c, f337363e, new j(c(r100.getProductName())), new DoraGOTAPlugin(), new DoraOTAWifiConnector());     // Catch: Throwable -> L12
        f337360b.add(r101);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public static void a(String r100, e49.a r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        Object r102 = f337366h;
        monitor-enter(r102);
        a r103 = f337367i;     // Catch: Throwable -> L20
        if (r103 != null) goto L9;
        monitor-exit(r102);
        return;
    L9:
        if (Intrinsics.areEqual(r103.f337370a, r100) == false) goto L17;
        if (r101 != null) goto L12;
    L13:
        g49.d.d("DoraOTAManager", "clearDownloadResumeContext: sn=" + r100);     // Catch: Throwable -> L20
        f337367i = null;     // Catch: Throwable -> L20
        Job r104 = f337369k;     // Catch: Throwable -> L20
        if (r104 == null) goto L16;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);     // Catch: Throwable -> L20
    L16:
        f337369k = null;     // Catch: Throwable -> L20
        goto L17
    L12:
        if (Intrinsics.areEqual(r103.f337371b, r101) == true) goto L13;
    L17:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean f(PolarisFileWrapper r100, PolarisFileWrapper r101) {
        boolean r102 = true;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        String r104 = r101.getCanonicalPath();     // Catch: Throwable -> L12
        String r105 = r100.getCanonicalPath();     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r105, r104) == true) goto L9;
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L12
        if (StringsKt.startsWith$default(r105, r104 + File.separator, false, 2, null) == true) goto L9;
        boolean r106 = false;
    L10:
        Object r107 = Result.m9449constructorimpl(Boolean.valueOf(r106));     // Catch: Throwable -> L12
    L14:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        g49.d.c("DoraOTAManager", "isSubPath: canonical path check failed, file=" + r100.getAbsolutePath() + ", parent=" + r101.getAbsolutePath(), r108);
        r107 = Boolean.FALSE;
    L19:
        if (((Boolean) r107).booleanValue() == true) goto L23;
        g49.d.b("DoraOTAManager", "prepareOtaDir: invalid path=" + r100.getAbsolutePath() + ", root=" + r101.getAbsolutePath());
        return false;
    L23:
        if (r100.exists() == true) goto L26;
        g49.d.d("DoraOTAManager", "prepareOtaDir: mkdirs=" + r100.mkdirs() + ", path=" + r100.getAbsolutePath());
    L26:
        if (r100.isDirectory() == true) goto L28;
    L30:
        r102 = false;
    L31:
        g49.d.d("DoraOTAManager", "prepareOtaDir: path=" + r100.getAbsolutePath() + ", ready=" + r102);
        return r102;
    L28:
        if (r100.canWrite() == false) goto L30;
    L9:
        r106 = true;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static void g(String r100, e49.a r110) {
        Job r101 = f337369k;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        f337369k = BuildersKt.launch$default(f337368j, null, null, new DoraOTAManager$scheduleStalledDownloadCheckLocked$1(r100, r110, null), 3, null);
    }

    public final void h(String r210, boolean r211) {
        if (NetworkUtils.isWifi(AppHost.f326268a.getApplication()) == true) goto L6;
        g49.d.d("DoraOTAManager", "tryResumeLastDownload: skip, not wifi, trigger=".concat(r210));
        return;
    L6:
        long r100 = System.currentTimeMillis();
        Object r101 = f337366h;
        monitor-enter(r101);
        a r102 = f337367i;     // Catch: Throwable -> L96
        if (r102 == null) goto L12;
        String r110 = r102.f337370a;     // Catch: Throwable -> L96
        e49.a r111 = r102.f337371b;     // Catch: Throwable -> L96
        boolean r112 = r102.f337372c;     // Catch: Throwable -> L96
        int r113 = r102.f337373d;     // Catch: Throwable -> L96
        long r114 = r102.f337374e;     // Catch: Throwable -> L96
        boolean r103 = r102.f337375f;     // Catch: Throwable -> L96
        long r104 = r102.f337376g;     // Catch: Throwable -> L96
        Intrinsics.checkNotNullParameter(r110, "sn");     // Catch: Throwable -> L96
        Intrinsics.checkNotNullParameter(r111, "responseWrapper");     // Catch: Throwable -> L96
        a r105 = new a(r110, r111, r112, r113, r114, r103, r104);     // Catch: Throwable -> L96
    L13:
        monitor-exit(r101);
        if (r105 != null) goto L17;
        g49.d.d("DoraOTAManager", "tryResumeLastDownload: skip, no context, trigger=".concat(r210));
        return;
    L17:
        DoraDevice r106 = kj4.a.g().c();
        if (r106 == null) goto L94;
        String r107 = r106.f204390sn;
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        if (Intrinsics.areEqual(r107, r105.f337370a) == false) goto L94;
        if (o59.a.k(r106) == false) goto L94;
        d49.a r108 = (d49.a) ((Map) f337361c.f337773b.getValue()).get(r105.f337370a);
        if (r108 == null) goto L30;
        e49.a r115 = r108.a();
    L32:
        if (r115 == null) goto L37;
        if (Intrinsics.areEqual(r108.a(), r105.f337371b) == true) goto L37;
    L56:
        boolean r116 = false;
    L57:
        if (r116 == true) goto L60;
        g49.d.d("DoraOTAManager", "tryResumeLastDownload: skip, state=" + r108 + ", requireStalled=" + r211 + ", trigger=" + r210);
        return;
    L60:
        monitor-enter(r101);
        a r109 = f337367i;     // Catch: Throwable -> L91
        if (r109 != null) goto L66;
        monitor-exit(r101);
        return;
    L66:
        if (Intrinsics.areEqual(r109.f337370a, r105.f337370a) == true) goto L68;
    L89:
        monitor-exit(r101);
        return;
    L68:
        if (Intrinsics.areEqual(r109.f337371b, r105.f337371b) == false) goto L89;
        if ((r100 - r109.f337376g) >= 30000) goto L75;
        g49.d.d("DoraOTAManager", "tryResumeLastDownload: skip cooldown, trigger=".concat(r210));     // Catch: Throwable -> L91
        monitor-exit(r101);
        return;
    L75:
        r109.f337376g = r100;     // Catch: Throwable -> L91
        r109.f337375f = false;     // Catch: Throwable -> L91
        r109.f337374e = r100;     // Catch: Throwable -> L91
        DoraOTAManager r117 = f337359a;     // Catch: Throwable -> L91
        String r118 = r109.f337370a;     // Catch: Throwable -> L91
        e49.a r119 = r109.f337371b;     // Catch: Throwable -> L91
        r117.getClass();     // Catch: Throwable -> L91
        g(r118, r119);     // Catch: Throwable -> L91
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L91
        monitor-exit(r101);
        g49.d.d("DoraOTAManager", "tryResumeLastDownload: resume, trigger=" + r210 + ", sn=" + r105.f337370a + ", progress=" + r105.f337373d + ", lastOnlyWifi=" + r105.f337372c + ", onlyWifi=true");
        if (r106.productId != ProductNameType.DORA_G.f204375id) goto L87;
        if (r211 == false) goto L86;
        p r121 = d(r106);
        if ((r121 instanceof DoraOTATask) == false) goto L83;
        DoraOTATask r122 = (DoraOTATask) r121;
    L84:
        if (r122 == null) goto L86;
        r122.v(true);
        goto L86
    L83:
        r122 = null;
    L86:
        BuildersKt.launch$default(f337368j, null, null, new DoraOTAManager$tryResumeLastDownload$2(r106, r105, r210, null), 3, null);
        return;
    L87:
        d(r106).e(r105.f337371b, true);
        return;
    L91:
        th = move-exception;
        throw th;
    L37:
        if ((r108 instanceof d49.a.i) == false) goto L43;
        if (r105.f337375f == false) goto L56;
        if (r211 == true) goto L56;
    L55:
        r116 = true;
        goto L57
    L43:
        if ((r108 instanceof d49.a.f) == false) goto L49;
        if (r105.f337375f == false) goto L56;
        if (r211 == true) goto L56;
    L49:
        if ((r108 instanceof d49.a.k) == false) goto L56;
        if (r105.f337375f == false) goto L54;
        if (r211 == false) goto L55;
    L54:
        if ((r100 - r105.f337374e) < 60000) goto L56;
    L30:
        r115 = null;
    L94:
        g49.d.d("DoraOTAManager", "tryResumeLastDownload: skip, device not ready, trigger=" + r210 + ", current=" + r106);
        return;
    L12:
        r105 = null;
    L96:
        th = move-exception;
        throw th;
    }

    public final Object b(DoraDevice r110, e49.a r111, boolean r112, Continuation<? super Boolean> r113) {
        if ((r113 instanceof DoraOTAManager$downloadLegacyWithOwner$1) == false) goto L7;
        DoraOTAManager$downloadLegacyWithOwner$1 r100 = (DoraOTAManager$downloadLegacyWithOwner$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r112 = r100.Z$0;
        r111 = (e49.a) r100.L$1;
        r110 = (DoraDevice) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L17:
        final e49.a r105 = r111;
        final boolean r106 = r112;
        final String r115 = (String) r114;
        boolean r116 = false;
        if (r115 == null) goto L20;
        final DoraDevice r117 = kj4.a.g().c();
        if (r117 != null) goto L24;
    L69:
        G2OtaFacade.INSTANCE.getClass();
        G2OtaFacade.S(r110, r115);
        return Boxing.boxBoolean(false);
    L24:
        if (o59.a.k(r117) == false) goto L69;
        if (Intrinsics.areEqual(r117.f204390sn, r110.f204390sn) == false) goto L69;
        if (r117.productId != r110.productId) goto L69;
        p r118 = d(r117);
        DownloadOwnerKind r107 = null;
        if ((r118 instanceof DoraOTATask) == false) goto L33;
        final DoraOTATask r108 = (DoraOTATask) r118;
    L34:
        if (r108 != null) goto L37;
        G2OtaFacade.INSTANCE.getClass();
        G2OtaFacade.S(r117, r115);
        return Boxing.boxBoolean(false);
    L37:
        G2OtaFacade r119 = G2OtaFacade.INSTANCE;
        Function0 r109 = new e(r108, r105, r106, r117, r115);
        r119.getClass();
        Intrinsics.checkNotNullParameter(r117, "device");
        Intrinsics.checkNotNullParameter(r115, "requestId");
        Intrinsics.checkNotNullParameter(r109, "start");
        com.larus.dora.impl.ota.g2.e r120 = G2OtaFacade.G(r117);
        if (r120 != null) goto L71;
    L62:
        if (r116 == true) goto L65;
        G2OtaFacade.S(r117, r115);
    L65:
        return Boxing.boxBoolean(r116);
    L71:
        DoraDevice r121 = kj4.a.g().c();     // Catch: Throwable -> L66
        com.larus.dora.impl.ota.g2.k r122 = ((b5) G2OtaFacade.A().getValue()).d();     // Catch: Throwable -> L66
        if (r121 != null) goto L44;
    L59:
        g49.d.e("G2OtaFacade", "legacy download start rejected device=" + j0.d(r120) + " request=" + r115);     // Catch: Throwable -> L66
        r104 = false;
    L61:
        r116 = r104;
        goto L62
    L44:
        if (o59.a.k(r121) == false) goto L59;
        if (Intrinsics.areEqual(r121.f204390sn, r120.b()) == false) goto L59;
        if (r121.productId != r120.a()) goto L59;
        if (r122 == null) goto L52;
        r107 = r122.c();     // Catch: Throwable -> L66
    L52:
        if (r107 != DownloadOwnerKind.G1_MANUAL) goto L59;
        if (Intrinsics.areEqual(r122.b(), r120) == false) goto L59;
        if (Intrinsics.areEqual(r122.e(), r115) == false) goto L59;
        r109.invoke();     // Catch: Throwable -> L66
        g49.d.d("G2OtaFacade", "legacy download started device=" + j0.d(r120) + " request=" + r115);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        G2OtaFacade.S(r117, r115);
        throw th;
    L33:
        r108 = null;
        goto L34
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        G2OtaFacade r123 = G2OtaFacade.INSTANCE;
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.Z$0 = r112;
        r100.label = 1;
        r114 = r123.n(r110, r100);
        if (r114 != r102) goto L17;
        return r102;
    L7:
        r100 = new DoraOTAManager$downloadLegacyWithOwner$1(this, r113);
        goto L8
    }
}
