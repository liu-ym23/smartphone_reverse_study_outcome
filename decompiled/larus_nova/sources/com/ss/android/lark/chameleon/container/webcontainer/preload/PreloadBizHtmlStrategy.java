package com.ss.android.lark.chameleon.container.webcontainer.preload;

import android.text.TextUtils;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.constants.BridgeConstants;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadBizHtmlStrategy;", "Lcom/ss/android/lark/chameleon/container/webcontainer/preload/IPreloaderStrategy;", "webView", "Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "(Lcom/ss/android/lark/chameleon/container/webcontainer/view/ChameleonWebView;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;)V", "preload", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForReady", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PreloadBizHtmlStrategy implements IPreloaderStrategy {
    public static final Companion Companion = null;
    private static final String TAG = "CML_TAG_PreloadBizHtmlStrategy";
    private final ChameleonConfig chameleonConfig;
    private final ChameleonWebView webView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/PreloadBizHtmlStrategy$Companion;", "", "()V", "TAG", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2", f = "PreloadBizHtmlStrategy.kt", i = {}, l = {49, 55}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $preloadUrl;
        int label;
        final /* synthetic */ PreloadBizHtmlStrategy this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2$1", f = "PreloadBizHtmlStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $preloadUrl;
            int label;
            final /* synthetic */ PreloadBizHtmlStrategy this$0;

            public AnonymousClass1(PreloadBizHtmlStrategy r100, Ref.ObjectRef<String> r101, Continuation<? super AnonymousClass1> r102) {
                this.this$0 = r100;
                this.$preloadUrl = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(this.this$0, this.$preloadUrl, r101);
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
                PreloadBizHtmlStrategy.access$getWebView$p(this.this$0).setPreloadUrl(this.$preloadUrl.element);
                PreloadBizHtmlStrategy.access$getWebView$p(this.this$0).resumeTimers();
                PreloadBizHtmlStrategy.access$getWebView$p(this.this$0).loadUrl(this.$preloadUrl.element);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(PreloadBizHtmlStrategy r100, Ref.ObjectRef<String> r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$preloadUrl = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$preloadUrl, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            boolean r102 = false;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L28:
            Boolean r111 = (Boolean) r110;
            Log.i(PreloadBizHtmlStrategy.TAG, "preload html end, res = " + r111);
            if (r111 != null) goto L31;
            PreloadBizHtmlStrategy.access$getWebView$p(this.this$0).unregisterHandler(BridgeConstants.JSB_DOCUMENT_READY);
        L31:
            if (r111 == null) goto L34;
            r102 = r111.booleanValue();
        L34:
            return Boxing.boxBoolean(r102);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L21:
            PreloadConfig r112 = PreloadBizHtmlStrategy.access$getChameleonConfig$p(this.this$0).getPreloadConfig();
            if (r112 == null) goto L24;
            long r103 = r112.getTimeout();
        L25:
            PreloadBizHtmlStrategy$preload$2$res$1 r113 = new PreloadBizHtmlStrategy$preload$2$res$1(this.this$0, null);
            this.label = 2;
            r110 = TimeoutKt.c(r103, r113, this);
            if (r110 != r100) goto L28;
            return r100;
        L24:
            r103 = 60000;
            goto L25
        L10:
            ResultKt.throwOnFailure(r110);
            if (PreloadBizHtmlStrategy.access$getChameleonConfig$p(this.this$0).getResInterceptConfig() != null) goto L15;
            Log.w(PreloadBizHtmlStrategy.TAG, "resource intercept is disabled");
            return Boxing.boxBoolean(false);
        L15:
            if (PreloadBizHtmlStrategy.access$getWebView$p(this.this$0).getResource(true).getPath() != null) goto L18;
            Log.w(PreloadBizHtmlStrategy.TAG, "resource is not ready");
            return Boxing.boxBoolean(false);
        L18:
            Log.i(PreloadBizHtmlStrategy.TAG, "preload html start");
            MainCoroutineDispatcher r114 = Dispatchers.getMain();
            AnonymousClass1 r104 = new AnonymousClass1(this.this$0, this.$preloadUrl, null);
            this.label = 1;
            if (BuildersKt.withContext(r114, r104, this) != r100) goto L21;
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ ChameleonConfig access$getChameleonConfig$p(PreloadBizHtmlStrategy r100) {
        return r100.chameleonConfig;
    }

    public static final /* synthetic */ ChameleonWebView access$getWebView$p(PreloadBizHtmlStrategy r100) {
        return r100.webView;
    }

    private final Object waitForReady(Continuation<? super Boolean> r100) {
        final j r101 = new j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        access$getWebView$p(this).registerHandler(BridgeConstants.JSB_DOCUMENT_READY, new PreloadBizHtmlStrategy$waitForReady$2$1(r101, this));
        access$getWebView$p(this).addLoadCallback(new PreloadBizHtmlStrategy$waitForReady$2$2(r101, this));
        Object r102 = r101.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.String] */
    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.IPreloaderStrategy
    public Object preload(Continuation<? super Boolean> r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        PreloadConfig r102 = this.chameleonConfig.getPreloadConfig();
        if (r102 == null) goto L5;
        T r103 = r102.getTemplateUrl();
    L6:
        r101.element = r103;
        if (TextUtils.isEmpty((CharSequence) r103) == false) goto L9;
        r101.element = this.chameleonConfig.getLoadUrl();
    L9:
        Log.i(TAG, "preload()... preloadUrl = " + ((String) r101.element));
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r101, null), r100);
    L5:
        r103 = 0;
        goto L6
    }

    public PreloadBizHtmlStrategy(ChameleonWebView r100, ChameleonConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "chameleonConfig");
        this.webView = r100;
        this.chameleonConfig = r101;
    }

    public static final /* synthetic */ Object access$waitForReady(PreloadBizHtmlStrategy r100, Continuation r101) {
        return r100.waitForReady(r101);
    }
}
