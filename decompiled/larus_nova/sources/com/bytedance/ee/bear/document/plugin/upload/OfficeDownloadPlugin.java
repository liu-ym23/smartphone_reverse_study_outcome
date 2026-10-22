package com.bytedance.ee.bear.document.plugin.upload;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSONObject;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.a1;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0011\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0002J@\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010&\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/upload/OfficeDownloadPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "downloadKey", "", "progressDialog", "Landroid/app/Dialog;", "copyJob", "Lkotlinx/coroutines/Job;", "onDetachFromHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "cancelDownload", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "dismissDialog", "handleDownloadSuccess", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "needRename", "", MapBundleKey.MapObjKey.OBJ_DIR, "Ljava/io/File;", "fileName", "suffix", "currentFile", "renameFileIfNeed", "localFile", "onFailed", "onSuccess", "uri", "Landroid/net/Uri;", "onCancel", "Companion", "OfficeDownloadFileHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDownloadPlugin extends DocumentPluginV3 {
    private static final String BIZ_UTIL_CANCEL_UPLOAD = "biz.util.downloadFile";
    public static final a Companion = null;
    private static final int MAX_FILE_NAME_LENGTH = 75;
    private static final String TAG = "OfficeDownloadPlugin";
    private Job copyJob;
    private String downloadKey;
    private Dialog progressDialog;

    public static final class a {
        public a() {
        }
    }

    public final class b implements tb5.i<DownloadFileModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeDownloadPlugin f221004a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeDownloadPlugin r100) {
            this.f221004a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, tb5.m r111) {
            DownloadFileModel r112 = (DownloadFileModel) r110;
            Intrinsics.checkNotNullParameter(r111, "callback");
            String r100 = null;
            if (r112 == null) goto L5;
            String r101 = r112.getFileToken();
        L6:
            if (r112 == null) goto L8;
            String r102 = r112.getFileName();
        L9:
            if (r112 == null) goto L11;
            r100 = r112.getSuffix();
        L11:
            String r103 = r100;
            if (r112 == null) goto L15;
            String r113 = r112.getMountPointType();
            if (r113 == null) goto L15;
        L16:
            String r104 = r113;
            boolean r114 = true;
            if (r101 != null) goto L19;
        L22:
            boolean r105 = true;
        L23:
            if (r105 == true) goto L39;
            if (r103 != null) goto L26;
        L29:
            boolean r106 = true;
        L30:
            if (r106 == true) goto L39;
            if (r102 != null) goto L33;
        L36:
            if (r114 == true) goto L39;
            com.ss.android.lark.utils.h.g(OfficeDownloadPlugin.access$getActivity(this.f221004a), new e(this, r101, r104, r102, r103, r111), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_docsdk_download_drive_file_from_fe"), new String[0]);
            return;
        L33:
            if (r102.length() == 0) goto L36;
            r114 = false;
            goto L36
        L26:
            if (r103.length() == 0) goto L29;
            r106 = false;
        L39:
            tt5.a.d(OfficeDownloadPlugin.TAG, "handle: params invalid");
            return;
        L19:
            if (r101.length() == 0) goto L22;
            r105 = false;
        L15:
            r113 = "docx_file";
            goto L16
        L8:
            r102 = null;
            goto L9
        L5:
            r101 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$dismissDialog$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$dismissDialog$1", f = "OfficeDownloadPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeDownloadPlugin this$0;

        public AnonymousClass1(OfficeDownloadPlugin r100, Continuation<? super AnonymousClass1> r101) {
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

        public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_plugin_upload_OfficeDownloadPlugin$dismissDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            Dialog r101 = OfficeDownloadPlugin.access$getProgressDialog$p(this.this$0);
            if (r101 == null) goto L7;
            INVOKEVIRTUAL_com_bytedance_ee_bear_document_plugin_upload_OfficeDownloadPlugin$dismissDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r101);
        L7:
            OfficeDownloadPlugin.access$setProgressDialog$p(this.this$0, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1", f = "OfficeDownloadPlugin.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO}, m = "invokeSuspend", n = {"uri", "success"}, s = {"L$0", "L$1"})
    public static final class C105221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ tb5.m $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ File $currentFile;
        final /* synthetic */ File $dir;
        final /* synthetic */ String $fileName;
        final /* synthetic */ boolean $needRename;
        final /* synthetic */ String $suffix;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ OfficeDownloadPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1$1", f = "OfficeDownloadPlugin.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE}, m = "invokeSuspend", n = {}, s = {})
        public static final class C31491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ File $currentFile;
            final /* synthetic */ File $dir;
            final /* synthetic */ String $fileName;
            final /* synthetic */ boolean $needRename;
            final /* synthetic */ Ref.BooleanRef $success;
            final /* synthetic */ String $suffix;
            final /* synthetic */ Ref.ObjectRef<Uri> $uri;
            int label;
            final /* synthetic */ OfficeDownloadPlugin this$0;

            public C31491(File r100, String r101, String r102, boolean r103, OfficeDownloadPlugin r104, File r105, Ref.ObjectRef<Uri> r106, Context r107, Ref.BooleanRef r108, Continuation<? super C31491> r110) {
                this.$currentFile = r100;
                this.$suffix = r101;
                this.$fileName = r102;
                this.$needRename = r103;
                this.this$0 = r104;
                this.$dir = r105;
                this.$uri = r106;
                this.$context = r107;
                this.$success = r108;
                super(2, r110);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
                return new C31491(this.$currentFile, this.$suffix, this.$fileName, this.$needRename, this.this$0, this.$dir, this.$uri, this.$context, this.$success, r111);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C31491) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L8;
                if (r101 != 1) goto L7;
                ResultKt.throwOnFailure(r110);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r110);
                final File r102 = this.$currentFile;
                final String r103 = this.$suffix;
                final String r104 = this.$fileName;
                final boolean r105 = this.$needRename;
                final OfficeDownloadPlugin r106 = this.this$0;
                final File r107 = this.$dir;
                final Ref.ObjectRef<Uri> r111 = this.$uri;
                final Context r112 = this.$context;
                final Ref.BooleanRef r113 = this.$success;
                Function0<Unit> r114 = new C31501(r102, r103, r104, r105, r106, r107, r111, r112, r113);
                this.label = 1;
                if (a1.a(r114, this) != r100) goto L12;
                return r100;
            }
        }

        public C105221(OfficeDownloadPlugin r100, tb5.m r101, File r102, String r103, String r104, boolean r105, File r106, Context r107, Continuation<? super C105221> r108) {
            this.this$0 = r100;
            this.$callback = r101;
            this.$currentFile = r102;
            this.$suffix = r103;
            this.$fileName = r104;
            this.$needRename = r105;
            this.$dir = r106;
            this.$context = r107;
            super(2, r108);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new C105221(this.this$0, this.$callback, this.$currentFile, this.$suffix, this.$fileName, this.$needRename, this.$dir, this.$context, r111);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C105221) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            Ref.BooleanRef r102 = (Ref.BooleanRef) this.L$1;
            Ref.ObjectRef r103 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r210);
        L12:
            Uri r104 = (Uri) r103.element;
            if (r102.element == false) goto L16;
            if (r104 == null) goto L16;
            OfficeDownloadPlugin.access$onSuccess(this.this$0, r104, this.$callback);
        L18:
            return Unit.INSTANCE;
        L16:
            OfficeDownloadPlugin.access$onFailed(this.this$0, this.$callback);
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            r103 = new Ref.ObjectRef();
            Ref.BooleanRef r110 = new Ref.BooleanRef();
            CoroutineDispatcher r111 = Dispatchers.getIO();
            C31491 r112 = new C31491(this.$currentFile, this.$suffix, this.$fileName, this.$needRename, this.this$0, this.$dir, r103, this.$context, r110, null);
            this.L$0 = r103;
            this.L$1 = r110;
            this.label = 1;
            if (BuildersKt.withContext(r111, r112, this) != r100) goto L11;
            return r100;
        L11:
            r102 = r110;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final void dismissDialog() {
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L10;
        LifecycleOwner r101 = r100.getLifecycleOwner();
        if (r101 == null) goto L11;
        LifecycleCoroutineScope r102 = LifecycleOwnerKt.getLifecycleScope(r101);
        if (r102 == null) goto L12;
        BuildersKt.launch$default(r102, Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    }

    public OfficeDownloadPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(OfficeDownloadPlugin r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(OfficeDownloadPlugin r100) {
        return r100.getContext();
    }

    public static final /* synthetic */ String access$getDownloadKey$p(OfficeDownloadPlugin r100) {
        return r100.downloadKey;
    }

    public static final /* synthetic */ Dialog access$getProgressDialog$p(OfficeDownloadPlugin r100) {
        return r100.progressDialog;
    }

    private final void cancelDownload(tb5.m r100) {
        String r101 = this.downloadKey;
        if (r101 == null) goto L5;
        ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().n(new String[]{r101});
        this.downloadKey = null;
    L5:
        Job r102 = this.copyJob;
        if (r102 == null) goto L8;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L8:
        onCancel(r100);
    }

    private final void onCancel(tb5.m r100) {
        dismissDialog();
        if (r100 == null) goto L6;
        JSONObject r101 = new JSONObject();
        r101.put2("result", "cancel");
        r100.b(r101);
        return;
    }

    private final void onFailed(tb5.m r100) {
        dismissDialog();
        UDToast.show(getHost().getContext(), R.string.CreationMobile_ECM_DownloadUnableToast);
        JSONObject r101 = new JSONObject();
        r101.put2("result", "failed");
        r100.b(r101);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put(BIZ_UTIL_CANCEL_UPLOAD, new b(this));
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        super.onDetachFromHost(r100);
        tt5.a.h(TAG, "onDetach: cancel download and dismiss dialog");
        cancelDownload$default(this, null, 1, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$cancelDownload(OfficeDownloadPlugin r100, tb5.m r101) {
        r100.cancelDownload(r101);
    }

    public static final /* synthetic */ void access$onFailed(OfficeDownloadPlugin r100, tb5.m r101) {
        r100.onFailed(r101);
    }

    public static final /* synthetic */ void access$setDownloadKey$p(OfficeDownloadPlugin r100, String r101) {
        r100.downloadKey = r101;
    }

    public static final /* synthetic */ void access$setProgressDialog$p(OfficeDownloadPlugin r100, Dialog r101) {
        r100.progressDialog = r101;
    }

    private final void onSuccess(Uri r100, tb5.m r101) {
        dismissDialog();
        UDToast.show(getHost().getContext(), getContext().getString(R.string.CreationMobile_ECM_SaveToLocal_saved_toast) + c1.c(getContext(), r100));
        JSONObject r102 = new JSONObject();
        r102.put2("result", "success");
        r101.b(r102);
    }

    public static final /* synthetic */ void access$onSuccess(OfficeDownloadPlugin r100, Uri r101, tb5.m r102) {
        r100.onSuccess(r101, r102);
    }

    public static /* synthetic */ void cancelDownload$default(OfficeDownloadPlugin r100, tb5.m r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.cancelDownload(r101);
    }

    private final File renameFileIfNeed(File r100, String r101, String r102, File r103) {
        boolean r104 = false;
        if (r101.length() <= 75) goto L6;
        r101 = r101.substring(0, 75);
    L6:
        if (r102.length() <= 0) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L10;
        r101 = r101 + '.' + r102;
    L10:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r100, r101);
        if (r105.exists() == false) goto L14;
        r105.delete();
    L14:
        if (r103.renameTo(r105) == false) goto L17;
        tt5.a.h(TAG, "Rename success: " + r103.getAbsolutePath() + " -> " + r105.getAbsolutePath());
        return r105;
    L17:
        tt5.a.d(TAG, "Rename failed");
        return r103;
    }

    public static final /* synthetic */ File access$renameFileIfNeed(OfficeDownloadPlugin r100, File r101, String r102, String r103, File r104) {
        return r100.renameFileIfNeed(r101, r102, r103, r104);
    }

    private final void handleDownloadSuccess(Context r110, boolean r111, File r112, String r113, String r114, File r210, tb5.m r211) {
        this.copyJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getHost().getFragment()), Dispatchers.getMain().getImmediate(), null, new C105221(this, r211, r210, r114, r113, r111, r112, r110, null), 2, null);
    }

    public static final /* synthetic */ void access$handleDownloadSuccess(OfficeDownloadPlugin r100, Context r101, boolean r102, File r103, String r104, String r105, File r106, tb5.m r107) {
        r100.handleDownloadSuccess(r101, r102, r103, r104, r105, r106, r107);
    }
}
