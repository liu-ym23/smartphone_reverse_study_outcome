package com.larus.avlink.gallery.gecko;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.larus.common.apphost.AppHost;
import com.larus.ivykit.forest.IFlowForestService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes25.dex */
public final class MorphoGeckoFileHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MorphoGeckoFileHelper f292575a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f292576b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f292577c = null;

    public static final class a implements Function2<Boolean, String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MorphoGeckoFileHelper f292578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i<String> f292579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IFlowForestService f292580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f292581d;

        public a(MorphoGeckoFileHelper r100, j r101, IFlowForestService r102, String r103) {
            this.f292578a = r100;
            this.f292579b = r101;
            this.f292580c = r102;
            this.f292581d = r103;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Boolean r100, String r101) {
            boolean r102 = r100.booleanValue();
            String r103 = r101;
            Intrinsics.checkNotNullParameter(r103, "errorMessage");
            this.f292578a.getClass();
            MorphoGeckoFileHelper.h("[download] downloadResAsync: success=" + r102 + ", message=" + r103);
            if (this.f292579b.isActive() == false) goto L6;
            this.f292580c.c(this.f292581d, new com.larus.avlink.gallery.gecko.a(this.f292578a, this.f292579b));
        L6:
            return Unit.INSTANCE;
        }
    }

    public MorphoGeckoFileHelper() {
    }

    static {
        f292575a = new MorphoGeckoFileHelper();
        f292576b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f292577c = new AtomicBoolean(false);
    }

    public static PolarisFileWrapper e() {
        return new PolarisFileWrapper(new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "morpho_plugin"), "facev2.bin");
    }

    public static void d() {
        PolarisFileWrapper r100 = e();
        h("[ensure] checking model: path=" + r100.getAbsolutePath());
        if (f(r100) == false) goto L7;
        h("[ensure] model ready: size=" + r100.length());
        return;
    L7:
        if (f292577c.compareAndSet(false, true) == false) goto L9;
        h("[ensure] model unavailable, starting background download");
        BuildersKt.launch$default(f292576b, null, null, new MorphoGeckoFileHelper$startDownloadIfNeeded$1(null), 3, null);
        return;
    L9:
        h("[ensure] model download already in progress");
    }

    public static void b(PolarisFileWrapper r100) {
        if (r100.exists() == true) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException(("Failed to delete file: " + r100.getAbsolutePath()).toString());
    L5:
        if (r100.delete() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean f(File r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        if (r100.length() <= 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r100.isFile() != true) goto L7;
        r101 = true;
        goto L8
    }

    public static void h(String r100) {
        FLogger.f375446a.i("MorphoGeckoFileHelper", r100);
    }

    public static File k(PolarisFileWrapper r100) {
        File r101 = r100.getParentFile();
        if (r101 == null) goto L16;
        if (r101.exists() == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        return r101;
    L14:
        throw new IllegalStateException(("Failed to create target directory: " + r101.getAbsolutePath()).toString());
    L7:
        if (r101.mkdirs() == true) goto L10;
        r102 = false;
        goto L11
    L16:
        throw new IllegalStateException(("Target parent is missing: " + r100.getAbsolutePath()).toString());
    }

    public static void l(PolarisFileWrapper r100) {
        if (f(r100) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(("File is missing or empty: " + r100.getAbsolutePath()).toString());
    }

    public final Object c(Continuation<? super Unit> r110) {
        if ((r110 instanceof MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1) == false) goto L7;
        MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1 r100 = (MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L21:
        File r112 = (File) r111;
        if (r112 != null) goto L25;
        h("[install] stopped, Gecko resource unavailable");
        return Unit.INSTANCE;
    L25:
        Object r105 = null;
        File r106 = null;
        r106 = null;
        r106 = null;
        if (r112.isDirectory() == false) goto L41;
        Iterator<File> r107 = FilesKt.walkTopDown(r112).iterator();
    L29:
        if (r107.hasNext() == false) goto L38;
        File r108 = r107.next();
        File r109 = r108;
        f292575a.getClass();
        if (Intrinsics.areEqual(r109.getName(), "facev2.bin") == true) goto L33;
    L35:
        boolean r113 = false;
    L36:
        if (r113 == false) goto L29;
    L39:
        File r114 = r108;
    L49:
        if (r114 == null) goto L51;
        h("[install] using Gecko model: path=" + r114.getAbsolutePath());
        PolarisFileWrapper r115 = e();
        if (f(r114) == true) goto L109;
        h("[install] source file invalid: path=" + r114.getAbsolutePath());
    L103:
        if (f(r106) == false) goto L105;
        String r116 = "[install] success";
    L106:
        h(r116);
        return Unit.INSTANCE;
    L105:
        r116 = "[install] failed";
        goto L106
    L109:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L89
        File r118 = k(r115);     // Catch: Throwable -> L89
        PolarisFileWrapper r119 = new PolarisFileWrapper(r118, "." + r115.getName() + DefaultDiskStorage.FileType.TEMP);     // Catch: Throwable -> L89
        PolarisFileWrapper r120 = new PolarisFileWrapper(r118, "." + r115.getName() + ".backup");     // Catch: Throwable -> L89
        b(r119);     // Catch: Throwable -> L89
        b(r120);     // Catch: Throwable -> L89
        FilesKt.copyTo$default(r114, r119, true, 0, 4, null);     // Catch: Throwable -> L82
        l(r119);     // Catch: Throwable -> L82
        boolean r121 = r115.exists();     // Catch: Throwable -> L82
        if (r121 == false) goto L67;
        if (r115.renameTo(r120) == true) goto L67;
        throw new IllegalStateException(("Failed to back up target file: " + r115.getAbsolutePath()).toString());     // Catch: Throwable -> L82
    L67:
        if (r119.renameTo(r115) == true) goto L75;
        if (r121 == false) goto L74;
        if (r120.renameTo(r115) == true) goto L74;
        throw new IllegalStateException(("Failed to restore target file: " + r115.getAbsolutePath()).toString());     // Catch: Throwable -> L82
    L74:
        throw new IllegalStateException(("Failed to move temp file to target: " + r115.getAbsolutePath()).toString());     // Catch: Throwable -> L82
    L75:
        b(r120);     // Catch: Throwable -> L82
        b(r119);     // Catch: Throwable -> L89
        if (r115.exists() == false) goto L79;
    L81:
        l(r115);     // Catch: Throwable -> L89
        Object r122 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L89
    L92:
        if (Result.m9456isSuccessimpl(r122) == false) goto L94;
        File r123 = (File) r122;
        MorphoGeckoFileHelper r124 = f292575a;
        String r125 = "[install] model copied: path=" + r115.getAbsolutePath() + ", size=" + r115.length();
        r124.getClass();
        h(r125);
    L94:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r122);
        if (r126 == null) goto L98;
        MorphoGeckoFileHelper r127 = f292575a;
        String r128 = "[install] failed to copy model: target=" + r115.getAbsolutePath();
        r127.getClass();
        g(r128, r126);
    L98:
        if (Result.m9455isFailureimpl(r122) == true) goto L101;
        r105 = r122;
    L101:
        r106 = (File) r105;
        goto L103
    L79:
        if (r120.exists() == false) goto L81;
        r120.renameTo(r115);     // Catch: Throwable -> L89
    L82:
        th = move-exception;
        b(r119);     // Catch: Throwable -> L89
        if (r115.exists() == false) goto L86;
    L88:
        throw th;     // Catch: Throwable -> L89
    L86:
        if (r120.exists() == false) goto L88;
        r120.renameTo(r115);     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L92
    L51:
        if (r112.isDirectory() == false) goto L53;
        h("[install] facev2.bin missing: directory=" + r112.getAbsolutePath());
        goto L103
    L53:
        h("[install] Gecko resource is not target model: path=" + r112.getAbsolutePath());
        goto L103
    L33:
        if (f(r109) == false) goto L35;
        r113 = true;
        goto L36
    L38:
        r108 = null;
        goto L39
    L41:
        if (Intrinsics.areEqual(r112.getName(), "facev2.bin") == true) goto L43;
    L45:
        r104 = false;
    L46:
        if (r104 == false) goto L48;
        r114 = r112;
        goto L49
    L48:
        r114 = null;
        goto L49
    L43:
        if (f(r112) == false) goto L45;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        PolarisFileWrapper r130 = e();
        h("[install] start: model=facev2.bin");
        if (f(r130) == false) goto L18;
        h("[install] skipped, model already ready: path=" + r130.getAbsolutePath());
        return Unit.INSTANCE;
    L18:
        r100.label = 1;
        r111 = j(r100);
        if (r111 != r102) goto L21;
        return r102;
    L7:
        r100 = new MorphoGeckoFileHelper$downloadAndInstallFaceSrModel$1(this, r110);
        goto L8
    }

    public final Object j(Continuation<? super File> r100) {
        if ((r100 instanceof MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1) == false) goto L7;
        MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1 r101 = (MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        File r106 = (File) r103;
        StringBuilder r107 = new StringBuilder("[download] Gecko resource ready: path=");
        if (r106 == null) goto L20;
        String r108 = r106.getAbsolutePath();
    L21:
        r107.append(r108);
        h(r107.toString());
        return r106;
    L20:
        r108 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r101.label = 1;
        r103 = i("local", "facev2.bin", r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MorphoGeckoFileHelper$queryLocalFaceSrModelFromGecko$1(this, r100);
        goto L8
    }

    public static final Object a(MorphoGeckoFileHelper r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1) == false) goto L7;
        MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1 r102 = (MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L19
    L26:
    L21:
        f292577c.set(false);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;     // Catch: Throwable -> L19
        if (r100.c(r102) != r105) goto L26;
        return r105;
    L19:
        th = move-exception;
        g("[install] unexpected failure", th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        f292577c.set(false);
        throw th;
    L7:
        r102 = new MorphoGeckoFileHelper$downloadAndInstallFaceSrModelSafely$1(r100, r101);
        goto L8
    }

    public static void g(String r100, Throwable r101) {
        FLogger.f375446a.e("MorphoGeckoFileHelper", r100 + ", error=" + r101.getMessage(), r101);
    }

    public final Object i(String r110, String r111, Continuation<? super File> r112) {
        if ((r112 instanceof MorphoGeckoFileHelper$queryGeckoFile$1) == false) goto L7;
        MorphoGeckoFileHelper$queryGeckoFile$1 r100 = (MorphoGeckoFileHelper$queryGeckoFile$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r104 = "";
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        MorphoGeckoFileHelper$queryGeckoFile$1 r114 = (MorphoGeckoFileHelper$queryGeckoFile$1) r100.L$3;
        MorphoGeckoFileHelper r115 = (MorphoGeckoFileHelper) r100.L$2;
        String r116 = (String) r100.L$1;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L28
    L26:
        Object r117 = Result.m9449constructorimpl((String) r113);     // Catch: Throwable -> L28
    L30:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L33;
        f292575a.getClass();
        g("[download] Gecko " + r110 + " query failed", r118);
    L33:
        PolarisFileWrapper r105 = null;
        if (Result.m9455isFailureimpl(r117) == false) goto L36;
        r117 = null;
    L36:
        String r119 = (String) r117;
        if (r119 == null) goto L40;
        r104 = r119;
    L40:
        h("[download] Gecko path=".concat(r104));
        if ((!StringsKt.isBlank(r104)) == false) goto L43;
        String r120 = r104;
    L44:
        if (r120 == null) goto L55;
        PolarisFileWrapper r121 = new PolarisFileWrapper(r120);
        if (r121.isDirectory() == true) goto L51;
        f292575a.getClass();
        if (f(r121) == true) goto L51;
        boolean r122 = false;
    L52:
        if (r122 == false) goto L55;
        r105 = r121;
    L51:
        r122 = true;
    L55:
        if ((!StringsKt.isBlank(r104)) == false) goto L58;
        if (r105 != null) goto L58;
        h("[download] Gecko " + r110 + " path invalid: path=" + r104);
    L58:
        return r105;
    L43:
        r120 = null;
        goto L44
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r113);
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L28
        r100.L$0 = r110;     // Catch: Throwable -> L28
        r100.L$1 = r111;     // Catch: Throwable -> L28
        r100.L$2 = this;     // Catch: Throwable -> L28
        r100.L$3 = r100;     // Catch: Throwable -> L28
        r100.label = 1;     // Catch: Throwable -> L28
        j r124 = new j(IntrinsicsKt.intercepted(r100), 1);     // Catch: Throwable -> L28
        r124.C();     // Catch: Throwable -> L28
        IFlowForestService r106 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Throwable -> L28
        if (r106 != null) goto L20;
        h("[download] Gecko " + r110 + " query failed: IFlowForestService unavailable");     // Catch: Throwable -> L28
        r124.resumeWith(Result.m9449constructorimpl(""));     // Catch: Throwable -> L28
    L21:
        r113 = r124.B();     // Catch: Throwable -> L28
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r100);     // Catch: Throwable -> L28
    L24:
        if (r113 != r102) goto L26;
        return r102;
    L20:
        r106.e("FlowGeckoResDownloadAsync", CollectionsKt.listOf("com_flow_dora_g2_facesr"), 3, new a(this, r124, r106, r111));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new MorphoGeckoFileHelper$queryGeckoFile$1(this, r112);
        goto L8
    }
}
