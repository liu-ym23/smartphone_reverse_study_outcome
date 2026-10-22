package com.larus.init.task.speech;

import b3a.b;
import bg9.i;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.larus.vesdk.api.IVeSDK;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.bean.SpeechAecDownloadResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/larus/init/task/speech/InitSpeechAecModelTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", "", "SPEECH_AEC_COLLECTION_NAME", "AUDIOX_AEC_COLLECTION_NAME", "MODELS_JSON_FILE_NAME", "modelsMetaLock", "", "modelMetaMap", "", "Lcom/larus/voicecall/api/bean/SpeechAecModelMeta;", "isDownloading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scene", "getScene", "()Ljava/lang/String;", "runInternal", "", "downloadModel", "downloadCollection", "collectionName", "handleCollectionDownloaded", "path", "getAlgorithmResourceManagerOrNull", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "unzipCollection", "", "readModelMeta", "collectionDirPath", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitSpeechAecModelTask extends bf6.a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f351451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f351452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, b> f351453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f351454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f351455h;

    /* JADX INFO: renamed from: com.larus.init.task.speech.InitSpeechAecModelTask$runInternal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.init.task.speech.InitSpeechAecModelTask$runInternal$1", f = "InitSpeechAecModelTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InitSpeechAecModelTask this$0;

        public AnonymousClass1(InitSpeechAecModelTask r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L45;
            ResultKt.throwOnFailure(r110);
            FLogger r111 = FLogger.f375446a;
            r111.i(this.this$0.f351448a, "init start");
            IVeSDK r100 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);
            if (r100 == null) goto L8;
            r100.e();
        L8:
            if (AlgorithmResourceManager.Companion.isInitialized() == true) goto L11;
            r111.e(this.this$0.f351448a, "AlgorithmResourceManager not initialized, skip download");
            return Unit.INSTANCE;
        L11:
            InitSpeechAecModelTask r101 = this.this$0;
            if (r101.f351454g.compareAndSet(false, true) == true) goto L14;
            r111.i(r101.f351448a, "downloadModel, isDownloading");
        L43:
            return Unit.INSTANCE;
        L14:
            Iterator r112 = CollectionsKt.listOf(new String[]{r101.f351449b, r101.f351450c}).iterator();
        L16:
            if (r112.hasNext() == false) goto L41;
            String r102 = (String) r112.next();
            Object r103 = r101.f351452e;
            monitor-enter(r103);
            if (((LinkedHashMap) r101.f351453f).get(r102) != null) goto L21;
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L38
            monitor-exit(r103);
            String r105 = InitSpeechAecModelTask.b(r102);
            FLogger r106 = FLogger.f375446a;
            r106.i(r101.f351448a, "start downloadCollection, collectionName: " + r102 + ", aec root path: " + r105);
            AlgorithmResourceManager.Companion r107 = AlgorithmResourceManager.Companion;     // Catch: Exception -> L32
            if (r107.isInitialized() == true) goto L30;
            r106.e(r101.f351448a, "AlgorithmResourceManager not initialized, collectionName: " + r102);     // Catch: Exception -> L32
        L34:
            AlgorithmResourceManager r108 = null;
        L35:
            if (r108 == null) goto L16;
            r108.fetchResourcesWithModelNames(0, new String[]{r102}, new com.ss.ugc.effectplatform.a(), new a(r101, r102, r108));
            goto L16
        L30:
            r108 = r107.getInstance();     // Catch: Exception -> L32
        L32:
            e = move-exception;
            FLogger.f375446a.e(r101.f351448a, "getAlgorithmResourceManager failed, collectionName: " + r102, e);
            goto L34
        L21:
            FLogger.f375446a.i(r101.f351448a, "meta loaded, collectionName: " + r102);     // Catch: Throwable -> L38
            monitor-exit(r103);
        L38:
            th = move-exception;
            throw th;
        L41:
            r101.f351454g.set(false);
            goto L43
        L45:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    public InitSpeechAecModelTask() {
        this.f351448a = "InitSpeechAecModelTask";
        this.f351449b = "speech_aec_collection";
        this.f351450c = "audiox_aec_collection";
        this.f351451d = "models.json";
        this.f351452e = new Object();
        this.f351453f = new LinkedHashMap();
        this.f351454g = new AtomicBoolean(false);
        this.f351455h = ServiceType.AUDIO;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final void runInternal() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351455h;
    }

    public static String b(String r100) {
        return AppHost.f326268a.getApplication().getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + r100;
    }

    public static final void a(InitSpeechAecModelTask r100, String r110, String r111) {
        r100.getClass();
        boolean r101 = true;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r111);     // Catch: Exception -> L37
        if (r102.exists() == true) goto L6;
        FLogger.f375446a.e(r100.f351448a, "zip file not exist: " + r111);     // Catch: Exception -> L37
    L39:
        boolean r112 = false;
    L40:
        if (r112 == true) goto L44;
        IVoiceCallService r103 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r103 == null) goto L92;
        r103.m(r110, SpeechAecDownloadResult.UNZIP_FAILED);
        return;
    L92:
        return;
    L44:
        String r104 = b(r110);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, r100.f351451d);
        if (r105.exists() == true) goto L85;
        FLogger.f375446a.e(r100.f351448a, "json file not exists: " + r105);
    L67:
        r101 = false;
    L68:
        if (r101 == true) goto L72;
        IVoiceCallService r106 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r106 == null) goto L94;
        r106.m(r110, SpeechAecDownloadResult.META_LOAD_FAILED);
        return;
    L94:
        return;
    L72:
        IVoiceCallService r107 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r107 == null) goto L96;
        r107.m(r110, SpeechAecDownloadResult.SUCCESS);
        return;
    L96:
        return;
    L85:
        String r108 = FilesKt.readText$default(r105, null, 1, null);     // Catch: Exception -> L66
        FLogger.f375446a.i(r100.f351448a, "Read json content: " + r108);     // Catch: Exception -> L66
        JSONObject r113 = new JSONObject(r108);     // Catch: Exception -> L66
        JSONArray r109 = r113.optJSONArray("models");     // Catch: Exception -> L66
        b r114 = new b(r110, 6);     // Catch: Exception -> L66
        String r115 = r113.optString("version");     // Catch: Exception -> L66
        Intrinsics.checkNotNullParameter(r115, "<set-?>");     // Catch: Exception -> L66
        r114.f17396b = r115;     // Catch: Exception -> L66
        if (r109 == null) goto L55;
        int r116 = r109.length();     // Catch: Exception -> L66
        int r117 = 0;
    L50:
        if (r117 >= r116) goto L55;
        String r118 = r109.optJSONObject(r117).optString("name");     // Catch: Exception -> L66
        PolarisFileWrapper r119 = new PolarisFileWrapper(r104, r118);     // Catch: Exception -> L66
        if (r119.exists() == false) goto L54;
        List<String> r120 = r114.f17397c;     // Catch: Exception -> L66
        Intrinsics.checkNotNull(r118);     // Catch: Exception -> L66
        r120.add(r118);     // Catch: Exception -> L66
        r117 = r117 + 1;     // Catch: Exception -> L66
        goto L50
    L54:
        FLogger.f375446a.e(r100.f351448a, "model file not exists: " + r119);     // Catch: Exception -> L66
    L55:
        Object r121 = r100.f351452e;     // Catch: Exception -> L66
        monitor-enter(r121);     // Catch: Exception -> L66
        r100.f351453f.put(r110, r114);     // Catch: Throwable -> L63
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r121);     // Catch: Exception -> L66
        IVoiceCallService r123 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);     // Catch: Exception -> L66
        if (r123 == null) goto L62;
        r123.n(r114);     // Catch: Exception -> L66
    L62:
        FLogger.f375446a.i(r100.f351448a, "aec model meta update, collectionName: " + r110);     // Catch: Exception -> L66
        goto L68
    L63:
        th = move-exception;
        throw th;     // Catch: Exception -> L66
    L66:
        FLogger.f375446a.e(r100.f351448a, "json not parse failed");
        goto L67
    L6:
        String r124 = b(r110);     // Catch: Exception -> L37
        PolarisFileWrapper r125 = new PolarisFileWrapper(r124);     // Catch: Exception -> L37
        if (r125.exists() == true) goto L9;
        r125.mkdirs();     // Catch: Exception -> L37
    L9:
        ZipInputStream r126 = new ZipInputStream(new PolarisFileInputStreamWrapper(r102));     // Catch: Exception -> L37
        ZipEntry r127 = r126.getNextEntry();     // Catch: Throwable -> L32
    L11:
        if (r127 == null) goto L29;
        PolarisFileWrapper r128 = new PolarisFileWrapper(r125, r127.getName());     // Catch: Throwable -> L32
        if (r127.isDirectory() == true) goto L27;
        File r129 = r128.getParentFile();     // Catch: Throwable -> L32
        if (r129 == null) goto L17;
        r129.mkdirs();     // Catch: Throwable -> L32
    L17:
        PolarisFileOutputStreamWrapper r130 = new PolarisFileOutputStreamWrapper(r128);     // Catch: Throwable -> L32
        ByteStreamsKt.copyTo$default(r126, r130, 0, 2, null);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r130, null);     // Catch: Throwable -> L32
    L28:
        r126.closeEntry();     // Catch: Throwable -> L32
        r127 = r126.getNextEntry();     // Catch: Throwable -> L32
        goto L11
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r130, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L27:
        r128.mkdirs();     // Catch: Throwable -> L32
        goto L28
    L29:
        Unit r131 = Unit.INSTANCE;     // Catch: Throwable -> L32
        CloseableKt.closeFinally(r126, null);     // Catch: Exception -> L37
        FLogger.f375446a.i(r100.f351448a, "unzip success, collectionName: " + r110 + ", path: " + r124);     // Catch: Exception -> L37
        r112 = true;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r126, th);     // Catch: Exception -> L37
        throw th;     // Catch: Exception -> L37
    L37:
        e = move-exception;
        FLogger.f375446a.e(r100.f351448a, "aec exception got: " + e.getMessage());
        goto L39
    }
}
