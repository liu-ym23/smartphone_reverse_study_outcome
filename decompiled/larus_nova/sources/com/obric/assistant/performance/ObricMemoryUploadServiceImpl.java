package com.obric.assistant.performance;

import android.app.Application;
import android.os.Debug;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricThresholdItemConfig;
import com.obric.assistant.ObricThresholdPssUploadFilesConfig;
import com.obric.assistant.t1;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/assistant/performance/ObricMemoryUploadServiceImpl;", "Lcom/obric/assistant/performance/IObricMemoryUploadService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uploadMemoryInfoRetryCount", "", "isUploadingMemoryInfo", "", "init", "", "shouldUploadMemoryInfo", "isPrivacyAgreed", "retryUploadPendingFile", com.bytedance.android.ec.core.event.a.KEY_DID, "", "findPendingMemoryInfoFile", "Ljava/io/File;", "uploadMemoryInfoFilesOnce", "config", "Lcom/obric/assistant/ObricThresholdItemConfig;", "(Ljava/lang/String;Lcom/obric/assistant/ObricThresholdItemConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareUploadFile", "(Lcom/obric/assistant/ObricThresholdItemConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFileOnce", "file", "cleanupUploadFile", "mergeUploadMemoryFiles", "buildMemoryUploadFile", "timestamp", "", "resolveMemoryUploadDir", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryUploadServiceImpl implements IObricMemoryUploadService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f390999e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f391000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f391001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f391002d;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements ff7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricMemoryUploadServiceImpl f391003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f391004b;

        @Override // ff7.e
        public final void onSuccess() {
            ObricMemoryUploadServiceImpl r100 = this.f391003a;
            File r101 = this.f391004b;
            int r102 = ObricMemoryUploadServiceImpl.f390999e;
            r100.getClass();
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
            if (r101.exists() == true) goto L6;
        L8:
            Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
            if (r105 == null) goto L15;
            FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "cleanupUploadFile error", r105);
        L15:
            this.f391003a.f391001c = -1;
            this.f391003a.f391002d = false;
            FLogger.f375446a.i("ObricMemoryUploadServiceImpl", "uploadOnce success");
            return;
        L6:
            if (r101.delete() == true) goto L8;
            FLogger.f375446a.w("ObricMemoryUploadServiceImpl", "cleanupUploadFile delete failed");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        @Override // ff7.e
        public final void onFail(String r100) {
            this.f391003a.f391001c = this.f391003a.f391001c + 1;
            this.f391003a.f391002d = false;
            FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "uploadOnce failed, msg=" + r100 + ", retryCount=" + this.f391003a.f391001c);
        }

        public b(ObricMemoryUploadServiceImpl r100, File r101) {
            this.f391003a = r100;
            this.f391004b = r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricMemoryUploadServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryUploadServiceImpl$init$1", f = "ObricMemoryUploadServiceImpl.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {73, 79, 93}, m = "invokeSuspend", n = {"$this$launch", "processConfig", "customDid", "thresholdPssKb", "checkIntervalMs", "$this$launch", "processConfig", "customDid", "thresholdPssKb", "checkIntervalMs", "$this$launch", "processConfig", "customDid", "thresholdPssKb", "checkIntervalMs"}, s = {"L$0", "L$1", "L$2", "F$0", "J$0", "L$0", "L$1", "L$2", "F$0", "J$0", "L$0", "L$1", "L$2", "F$0", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        float F$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ObricMemoryUploadServiceImpl this$0;

        public AnonymousClass1(ObricMemoryUploadServiceImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x018e -> B:69:0x01ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0194 -> B:69:0x01ab). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01a8 -> B:69:0x01ab). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            int r102 = 2;
            boolean r103 = true;
            if (r101 == 0) goto L18;
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L12;
            if (r101 != 3) goto L11;
            long r104 = this.J$0;
            float r105 = this.F$0;
            String r106 = (String) this.L$2;
            ObricThresholdItemConfig r107 = (ObricThresholdItemConfig) this.L$1;
            CoroutineScope r110 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L70
            AnonymousClass1 r111 = this;
        L69:
            r102 = 2;
            r103 = true;
        L44:
            if (CoroutineScopeKt.isActive(r110) == false) goto L73;
            r111.L$0 = r110;     // Catch: Exception -> L70
            r111.L$1 = r107;     // Catch: Exception -> L70
            r111.L$2 = r106;     // Catch: Exception -> L70
            r111.F$0 = r105;     // Catch: Exception -> L70
            r111.J$0 = r104;     // Catch: Exception -> L70
            r111.label = r102;     // Catch: Exception -> L70
            if (DelayKt.delay(r104, r111) != r100) goto L48;
            return r100;
        L48:
            ObricMemoryUploadServiceImpl r112 = r111.this$0;     // Catch: Exception -> L70
            int r113 = ObricMemoryUploadServiceImpl.f390999e;     // Catch: Exception -> L70
            r112.getClass();     // Catch: Exception -> L70
            ISecPrivacyService.f326368a.getClass();     // Catch: Exception -> L70
            ISecPrivacyService r114 = ISecPrivacyService.a.a();     // Catch: Exception -> L70
            boolean r115 = false;
            if (r114 != null) goto L51;
        L53:
            boolean r116 = false;
        L54:
            if (r116 == true) goto L56;
            FLogger.f375446a.i("ObricMemoryUploadServiceImpl", "stop upload monitor, privacy switch disabled");     // Catch: Exception -> L70
            goto L73
        L56:
            int r117 = r111.this$0.f391001c;     // Catch: Exception -> L70
            if (r117 < 0) goto L60;
            if (r117 >= 3) goto L60;
            r115 = true;
        L60:
            if (r115 == false) goto L73;
            long r118 = Debug.getPss();     // Catch: Exception -> L70
            FLogger.f375446a.d("ObricMemoryUploadServiceImpl", "check threshold, totalPssKb=" + r118 + ", thresholdPssKb=" + r105 + ", isUploading=" + r111.this$0.f391002d);     // Catch: Exception -> L70
            if (r118 < r105) goto L69;
            if (r111.this$0.f391002d == true) goto L69;
            ObricMemoryUploadServiceImpl r108 = r111.this$0;     // Catch: Exception -> L70
            r111.L$0 = r110;     // Catch: Exception -> L70
            r111.L$1 = r107;     // Catch: Exception -> L70
            r111.L$2 = r106;     // Catch: Exception -> L70
            r111.F$0 = r105;     // Catch: Exception -> L70
            r111.J$0 = r104;     // Catch: Exception -> L70
            r111.label = 3;     // Catch: Exception -> L70
            if (ObricMemoryUploadServiceImpl.b(r108, r106, r107, r111) != r100) goto L69;
            return r100;
        L51:
            if (r114.h() != r103) goto L53;
            r116 = true;
        L73:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r104 = this.J$0;
            r105 = this.F$0;
            r106 = (String) this.L$2;
            r107 = (ObricThresholdItemConfig) this.L$1;
            r110 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L70
            r111 = this;
            goto L48
        L15:
            r104 = this.J$0;
            r105 = this.F$0;
            r106 = (String) this.L$2;
            r107 = (ObricThresholdItemConfig) this.L$1;
            r110 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);     // Catch: Exception -> L70
        L39:
            if (ObricMemoryUploadServiceImpl.a(this.this$0, r106) == true) goto L41;
            r111 = this;
            goto L44
        L41:
            return Unit.INSTANCE;
        L18:
            ResultKt.throwOnFailure(r210);
            r110 = (CoroutineScope) this.L$0;
            ObricThresholdPssUploadFilesConfig r109 = t1.f393353a.N0();     // Catch: Exception -> L70
            Map<String, ObricThresholdItemConfig> r119 = r109.getProcessConfigs();     // Catch: Exception -> L70
            if (r119 == null) goto L23;
            ObricThresholdItemConfig r120 = r119.get(PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Exception -> L70
            if (r120 == null) goto L23;
        L24:
            float r121 = r120.getPssLimit();     // Catch: Exception -> L70
            long r122 = RangesKt.coerceAtLeast(r109.getCheckIntervalMs(), 1);     // Catch: Exception -> L70
            FLogger r123 = FLogger.f375446a;     // Catch: Exception -> L70
            r123.i("ObricMemoryUploadServiceImpl", "start, config=" + r109);     // Catch: Exception -> L70
            if (r109.getEnableMemInfo() == true) goto L31;
            if (Intrinsics.areEqual(AppHost.f326268a.getBuildChannel(), "auto_test") == true) goto L31;
            r123.i("ObricMemoryUploadServiceImpl", "start ignored, disable upload files");     // Catch: Exception -> L70
            return Unit.INSTANCE;
        L31:
            if (r121 >= 1024.0f) goto L34;
            r123.i("ObricMemoryUploadServiceImpl", "start ignored, invalid thresholdPssKb=" + r121);     // Catch: Exception -> L70
            return Unit.INSTANCE;
        L34:
            r106 = "4245639790640852";
            r123.i("ObricMemoryUploadServiceImpl", "start wait memory stable, delayMs=30000");     // Catch: Exception -> L70
            this.L$0 = r110;     // Catch: Exception -> L70
            this.L$1 = r120;     // Catch: Exception -> L70
            this.L$2 = "4245639790640852";     // Catch: Exception -> L70
            this.F$0 = r121;     // Catch: Exception -> L70
            this.J$0 = r122;     // Catch: Exception -> L70
            this.label = 1;     // Catch: Exception -> L70
            if (DelayKt.delay(30000, this) != r100) goto L37;
            return r100;
        L37:
            r107 = r120;
            r105 = r121;
            r104 = r122;
        L23:
            r120 = new ObricThresholdItemConfig(false, false, 0.0f, 0, 15, null);     // Catch: Exception -> L70
        L70:
            e = move-exception;
            FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "start error: " + e);
            goto L73
        }
    }

    static {
    }

    public static PolarisFileWrapper e() {
        Application r100 = AppHost.f326268a.getApplication();
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L8;
        r101 = r100.getCacheDir();
        if (r101 != null) goto L8;
        r101 = r100.getDir("obric_memory_upload", 0);
    L8:
        return new PolarisFileWrapper(r101, "obric_memory_upload");
    }

    @Override // com.obric.assistant.performance.IObricMemoryUploadService
    public final void init() {
        BuildersKt.launch$default(this.f391000b, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public ObricMemoryUploadServiceImpl() {
        this.f391000b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static File c() {
        File[] r100 = e().listFiles(new g());
        File r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        int r102 = 1;
        if (r100.length != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L21;
        r101 = r100[0];
        int r104 = ArraysKt.getLastIndex(r100);
        if (r104 == 0) goto L21;
        long r105 = r101.lastModified();
        if (1 > r104) goto L21;
    L16:
        File r106 = r100[r102];
        long r107 = r106.lastModified();
        if (r105 >= r107) goto L19;
        r101 = r106;
        r105 = r107;
    L19:
        if (r102 == r104) goto L21;
        r102 = r102 + 1;
    L21:
        return r101;
    L8:
        r103 = false;
        goto L9
    }

    public static final boolean a(ObricMemoryUploadServiceImpl r100, String r101) {
        r100.getClass();
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L11;
        FLogger.f375446a.i("ObricMemoryUploadServiceImpl", "retryUpload stop, privacy switch disabled");
        return false;
    L11:
        File r104 = c();
        if (r104 == null) goto L25;
        FLogger r105 = FLogger.f375446a;
        r105.i("ObricMemoryUploadServiceImpl", "retryUpload found pending file");
        if (r104.exists() == true) goto L18;
        r105.i("ObricMemoryUploadServiceImpl", "retryUpload file missing");
        return false;
    L18:
        if (r100.f391002d == false) goto L20;
        r105.i("ObricMemoryUploadServiceImpl", "retryUpload skipped, upload in progress");
    L21:
        return true;
    L20:
        r100.f391002d = true;
        r100.f(r104, r101);
        goto L21
    L25:
        return false;
    L5:
        if (r102.h() != true) goto L7;
        r103 = true;
        goto L9
    }

    public final Object d(ObricThresholdItemConfig r110, Continuation<? super File> r111) {
        if ((r111 instanceof ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1) == false) goto L7;
        ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1 r100 = (ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        File r113 = (File) r100.L$1;
        ObricThresholdItemConfig r105 = (ObricThresholdItemConfig) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L30:
        List r114 = (List) r112;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L59
        File r107 = r113.getParentFile();     // Catch: Throwable -> L59
        if (r107 == null) goto L35;
        Boxing.boxBoolean(r107.mkdirs());     // Catch: Throwable -> L59
    L35:
        if (r113.exists() == false) goto L37;
        r113.delete();     // Catch: Throwable -> L59
    L37:
        OutputStream r108 = new PolarisFileOutputStreamWrapper(r113);     // Catch: Throwable -> L59
        if ((r108 instanceof BufferedOutputStream) == false) goto L40;
        BufferedOutputStream r109 = (BufferedOutputStream) r108;     // Catch: Throwable -> L59
    L41:
        ZipOutputStream r115 = new ZipOutputStream(r109);     // Catch: Throwable -> L59
        r115.putNextEntry(new ZipEntry("memoryinfo.txt"));     // Catch: Throwable -> L48
        ObricMemoryUploadFileHelper.f390998a.getClass();     // Catch: Throwable -> L48
        r115.write(ObricMemoryUploadFileHelper.b(r104).getBytes(Charsets.UTF_8));     // Catch: Throwable -> L48
        r115.closeEntry();     // Catch: Throwable -> L48
        r115.putNextEntry(new ZipEntry("smaps.txt"));     // Catch: Throwable -> L48
        PolarisFileInputStreamWrapper r116 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper("/proc/self/smaps"));     // Catch: Throwable -> L48
        ByteStreamsKt.copyTo$default(r116, r115, 0, 2, null);     // Catch: Throwable -> L50
        CloseableKt.closeFinally(r116, null);     // Catch: Throwable -> L48
        r115.closeEntry();     // Catch: Throwable -> L48
        int r117 = ObricMemoryUploadFileHelper.a(r115, r114, r105);     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r115, null);     // Catch: Throwable -> L59
        Object r118 = Result.m9449constructorimpl(Boxing.boxInt(r117));     // Catch: Throwable -> L59
    L61:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L65;
        r113.delete();
        FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "mergeMemoryFiles error", r119);
    L65:
        if (Result.m9456isSuccessimpl(r118) == false) goto L67;
        ((Number) r118).intValue();
        Object r120 = Result.m9449constructorimpl(r113);
    L69:
        if (Result.m9455isFailureimpl(r120) == false) goto L72;
        return null;
    L72:
        return r120;
    L67:
        r120 = Result.m9449constructorimpl(r118);
        goto L69
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        CloseableKt.closeFinally(r115, th);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L40:
        r109 = new BufferedOutputStream(r108, 8192);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L61
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        long r122 = System.currentTimeMillis();
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L17
        StringBuilder r124 = new StringBuilder("memory_snapshot_");     // Catch: Throwable -> L17
        ObricMemoryUploadFileHelper.f390998a.getClass();     // Catch: Throwable -> L17
        r124.append(ObricMemoryUploadFileHelper.d(r122));     // Catch: Throwable -> L17
        r124.append("__");     // Catch: Throwable -> L17
        r124.append(AppHost.f326268a.getApplication().getPackageName());     // Catch: Throwable -> L17
        r124.append("__");     // Catch: Throwable -> L17
        r124.append(IApplog.f287053a.getDeviceId());     // Catch: Throwable -> L17
        r124.append(".zip");     // Catch: Throwable -> L17
        Object r125 = Result.m9449constructorimpl(new PolarisFileWrapper(e(), r124.toString()));     // Catch: Throwable -> L17
    L19:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L23;
        FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "buildMemoryUploadFile error, timestamp=" + r122, r126);
    L23:
        if (Result.m9452exceptionOrNullimpl(r125) == null) goto L26;
        r125 = new PolarisFileWrapper(e(), "memory_snapshot_" + r122 + ".zip");
    L26:
        File r127 = (File) r125;
        ObricMemoryUploadFileHelper r128 = ObricMemoryUploadFileHelper.f390998a;
        r100.L$0 = r110;
        r100.L$1 = r127;
        r100.J$0 = r122;
        r100.label = 1;
        Object r129 = r128.c(r122, r110, r100);
        if (r129 != r102) goto L29;
        return r102;
    L29:
        r104 = r122;
        r105 = r110;
        r113 = r127;
        r112 = r129;
    L17:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1(this, r111);
        goto L8
    }

    public final void f(File r110, String r111) {
        if (r110.exists() == true) goto L14;
        FLogger.f375446a.w("ObricMemoryUploadServiceImpl", "uploadOnce skipped, file not exists");
        this.f391002d = false;
        this.f391001c++;
        return;
    L14:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        new xs3.a().c(String.valueOf(AppHost.f326268a.getAppId()), r111, "memory_snapshot", CollectionsKt.listOf(r110.getAbsolutePath()), "main_upload", new JSONObject(), new b(this, r110));     // Catch: Throwable -> L8
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L16;
        this.f391001c++;
        this.f391002d = false;
        FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "uploadOnce exception, retryCount=" + this.f391001c, r113);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static final Object b(ObricMemoryUploadServiceImpl r100, String r101, ObricThresholdItemConfig r102, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1) == false) goto L7;
        ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1 r103 = (ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r101 = (String) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L40:
        File r112 = (File) r111;
        if (r112 != null) goto L43;
        r100.f391001c++;
        FLogger.f375446a.w("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce skipped, dump file failed");
        return Unit.INSTANCE;
    L43:
        r100.f391002d = true;
        r100.f(r112, r101);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        int r113 = r100.f391001c;
        if (r113 >= 0) goto L17;
    L19:
        boolean r114 = false;
    L20:
        if (r114 == true) goto L23;
        FLogger.f375446a.i("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce skipped");
        return Unit.INSTANCE;
    L23:
        if (StringsKt.isBlank(r101) == false) goto L25;
        r100.f391001c++;
        FLogger.f375446a.w("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce skipped, did is blank");
        return Unit.INSTANCE;
    L25:
        FLogger r115 = FLogger.f375446a;
        r115.i("ObricMemoryUploadServiceImpl", "uploadMemoryInfoFilesOnce start");
        r103.L$0 = r101;
        r103.label = 1;
        Object r107 = c();
        if (r107 == null) goto L29;
        r115.i("ObricMemoryUploadServiceImpl", "prepareUploadFile retry");
        r111 = r107;
    L38:
        if (r111 != r105) goto L40;
        return r105;
    L29:
        if (r102.getEnableHprof() == true) goto L45;
    L37:
        r111 = r100.d(r102, r103);
        goto L38
    L45:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L32
        r115.i("ObricMemoryUploadServiceImpl", "prepareUploadFile trigger HeapDumper");     // Catch: Throwable -> L32
        s17.d.f().d(System.currentTimeMillis(), 2);     // Catch: Throwable -> L32
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L37;
        FLogger.f375446a.e("ObricMemoryUploadServiceImpl", "prepareUploadFile trigger HeapDumper error", r117);
    L32:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L17:
        if (r113 >= 3) goto L19;
        r114 = true;
    L7:
        r103 = new ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1(r100, r110);
        goto L8
    }
}
