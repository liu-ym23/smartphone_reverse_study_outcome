package com.larus.im.internal.jni;

import com.bytedance.bmmt.base.ContextUtils;
import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.FlowRuntime;
import com.larus.im.internal.jni.service.NativeAudioPlatformSettings;
import com.larus.im.internal.jni.service.OmniMediaService;
import com.larus.im.internal.jni.service.OmniRtcEnginePoolService;
import com.larus.im.internal.jni.service.OmniTokenService;
import com.larus.utils.logger.FLogger;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0082 J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0006\u0010\u0010\u001a\u00020\u0011J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0006\u0010\u0012\u001a\u00020\u0013J\u0011\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/im/internal/jni/NativeAVSDK;", "", "userId", "", "<init>", "(Ljava/lang/String;)V", "nativePtr", "", "initSDK", "activeNativePtr", "getMediaService", "Lcom/larus/im/internal/jni/service/OmniMediaService;", "getOmniTokenService", "Lcom/larus/im/internal/jni/service/OmniTokenService;", "getRtcEnginePoolService", "Lcom/larus/im/internal/jni/service/OmniRtcEnginePoolService;", "getPlatformSettings", "Lcom/larus/im/internal/jni/service/NativeAudioPlatformSettings;", "release", "", "releaseSDK", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeAVSDK {
    public static final Companion Companion = null;
    private static final String ENABLE_RTC_NATIVE_LIBS_INIT = "enable_av_rtc_native";
    private static final Lazy<Boolean> enableRtcNativeLibsInit$delegate = null;
    private static final Map<String, NativeAVSDK> sdkInstMap = null;
    private volatile long nativePtr;
    private final String userId;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/im/internal/jni/NativeAVSDK$Companion;", "", "<init>", "()V", "ENABLE_RTC_NATIVE_LIBS_INIT", "", "enableRtcNativeLibsInit", "", "getEnableRtcNativeLibsInit", "()Z", "enableRtcNativeLibsInit$delegate", "Lkotlin/Lazy;", "sdkInstMap", "", "Lcom/larus/im/internal/jni/NativeAVSDK;", "getOrCreateAVSDK", "userId", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: renamed from: com.larus.im.internal.jni.NativeAVSDK$Companion$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.im.internal.jni.NativeAVSDK$Companion$1", f = "NativeAVSDK.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
                super(2, r100);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(r101);
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
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r100);
                RTCEngineImpl.initializeNativeLibs();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final boolean getEnableRtcNativeLibsInit() {
            return ((Boolean) NativeAVSDK.access$getEnableRtcNativeLibsInit$delegate$cp().getValue()).booleanValue();
        }

        public static final /* synthetic */ boolean access$getEnableRtcNativeLibsInit(Companion r100) {
            return r100.getEnableRtcNativeLibsInit();
        }

        public final NativeAVSDK getOrCreateAVSDK(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            NativeAVSDK r101 = (NativeAVSDK) NativeAVSDK.access$getSdkInstMap$cp().get(r100);
            if (r101 == null) goto L5;
            return r101;
        L5:
            KClass r102 = Reflection.getOrCreateKotlinClass(NativeAVSDK.class);
            monitor-enter(r102);
            NativeAVSDK r103 = (NativeAVSDK) NativeAVSDK.access$getSdkInstMap$cp().get(r100);     // Catch: Throwable -> L14
            if (r103 == null) goto L11;
            monitor-exit(r102);
            return r103;
        L11:
            NativeAVSDK r104 = new NativeAVSDK(r100, null);     // Catch: Throwable -> L14
            NativeAVSDK.access$getSdkInstMap$cp().put(r100, r104);     // Catch: Throwable -> L14
            monitor-exit(r102);
            return r104;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public /* synthetic */ NativeAVSDK(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static /* synthetic */ boolean a() {
        return enableRtcNativeLibsInit_delegate$lambda$4();
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private final native OmniMediaService getMediaService(long r100);

    private final native OmniTokenService getOmniTokenService(long r100);

    private final native NativeAudioPlatformSettings getPlatformSettings(long r100);

    private final native OmniRtcEnginePoolService getRtcEnginePoolService(long r100);

    private final native long initSDK(String r100);

    private final native void releaseSDK(long r100);

    public final void release() {
        monitor-enter(this);
        long r100 = this.nativePtr;     // Catch: Throwable -> L18
        if (r100 != 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.nativePtr = 0;     // Catch: Throwable -> L18
        KClass r101 = Reflection.getOrCreateKotlinClass(NativeAVSDK.class);     // Catch: Throwable -> L18
        monitor-enter(r101);     // Catch: Throwable -> L18
        NativeAVSDK r102 = sdkInstMap.remove(this.userId);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L18
        monitor-exit(this);
        releaseSDK(r100);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    static {
        Companion r100 = new Companion(null);
        Companion = r100;
        enableRtcNativeLibsInit$delegate = LazyKt.lazy(new a());
        ContextUtils.initialize(com.larus.im.internal.delegate.c.f348197a.getApplication().getApplicationContext());
        OmniFoundationInitializer.INSTANCE.initialize();
        INVOKESTATIC_com_larus_im_internal_jni_NativeAVSDK_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("ByteMMT");
        OmniSoNameProvider.INSTANCE.loadAVLibraries();
        if (Companion.access$getEnableRtcNativeLibsInit(r100) == false) goto L5;
        CoroutineExtKt.a(new Companion.AnonymousClass1(null));
    L5:
        sdkInstMap = new LinkedHashMap();
    }

    private final long activeNativePtr() {
        long r100 = this.nativePtr;
        if (r100 == 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return r100;
    L9:
        throw new IllegalStateException("NativeAVSDK has been released".toString());
    L5:
        r101 = false;
        goto L6
    }

    private static final boolean enableRtcNativeLibsInit_delegate$lambda$4() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(FlowRuntime.b().b().d(ENABLE_RTC_NATIVE_LIBS_INIT, false)));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final OmniMediaService getMediaService() {
        return getMediaService(activeNativePtr());
    }

    public final OmniTokenService getOmniTokenService() {
        return getOmniTokenService(activeNativePtr());
    }

    public final NativeAudioPlatformSettings getPlatformSettings() {
        return getPlatformSettings(activeNativePtr());
    }

    public final OmniRtcEnginePoolService getRtcEnginePoolService() {
        return getRtcEnginePoolService(activeNativePtr());
    }

    public static final /* synthetic */ Lazy access$getEnableRtcNativeLibsInit$delegate$cp() {
        return enableRtcNativeLibsInit$delegate;
    }

    public static final /* synthetic */ Map access$getSdkInstMap$cp() {
        return sdkInstMap;
    }

    private NativeAVSDK(String r100) {
        this.userId = r100;
        this.nativePtr = initSDK(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_larus_im_internal_jni_NativeAVSDK_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
