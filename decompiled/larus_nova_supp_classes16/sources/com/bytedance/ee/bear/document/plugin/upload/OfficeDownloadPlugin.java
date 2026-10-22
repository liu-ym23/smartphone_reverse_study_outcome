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
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.c1;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0011\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0002J@\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010&\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/upload/OfficeDownloadPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "downloadKey", "", "progressDialog", "Landroid/app/Dialog;", "copyJob", "Lkotlinx/coroutines/Job;", "onDetachFromHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "cancelDownload", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getBridgeHandlers", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "dismissDialog", "handleDownloadSuccess", "context", "Landroid/content/Context;", "needRename", "", "dir", "Ljava/io/File;", "fileName", "suffix", "currentFile", "renameFileIfNeed", "localFile", "onFailed", "onSuccess", "uri", "Landroid/net/Uri;", "onCancel", "Companion", "OfficeDownloadFileHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ OfficeDownloadPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeDownloadPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, tb5.m r11) {
            DownloadFileModel r12 = (DownloadFileModel) r10;
            Intrinsics.checkNotNullParameter(r11, "callback");
            String r0 = null;
            if (r12 == null) goto L5;
            String r4 = r12.getFileToken();
        L6:
            if (r12 == null) goto L8;
            String r6 = r12.getFileName();
        L9:
            if (r12 == null) goto L11;
            r0 = r12.getSuffix();
        L11:
            String r7 = r0;
            if (r12 == null) goto L15;
            String r13 = r12.getMountPointType();
            if (r13 == null) goto L15;
        L16:
            String r5 = r13;
            boolean r14 = true;
            if (r4 != null) goto L19;
        L22:
            boolean r1 = true;
        L23:
            if (r1 == true) goto L39;
            if (r7 != null) goto L26;
        L29:
            boolean r2 = true;
        L30:
            if (r2 == true) goto L39;
            if (r6 != null) goto L33;
        L36:
            if (r14 == true) goto L39;
            com.ss.android.lark.utils.h.g(OfficeDownloadPlugin.access$getActivity(this.a), new e(this, r4, r5, r6, r7, r11), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_docsdk_download_drive_file_from_fe"), new String[0]);
            return;
        L33:
            if (r6.length() == 0) goto L36;
            r14 = false;
            goto L36
        L26:
            if (r7.length() == 0) goto L29;
            r2 = false;
        L39:
            tt5.a.d(OfficeDownloadPlugin.TAG, "handle: params invalid");
            return;
        L19:
            if (r4.length() == 0) goto L22;
            r1 = false;
        L15:
            r13 = "docx_file";
            goto L16
        L8:
            r6 = null;
            goto L9
        L5:
            r4 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$dismissDialog$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$dismissDialog$1", f = "OfficeDownloadPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeDownloadPlugin this$0;

        public AnonymousClass1(OfficeDownloadPlugin r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_plugin_upload_OfficeDownloadPlugin$dismissDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            Dialog r3 = OfficeDownloadPlugin.access$getProgressDialog$p(this.this$0);
            if (r3 == null) goto L7;
            INVOKEVIRTUAL_com_bytedance_ee_bear_document_plugin_upload_OfficeDownloadPlugin$dismissDialog$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r3);
        L7:
            OfficeDownloadPlugin.access$setProgressDialog$p(this.this$0, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1", f = "OfficeDownloadPlugin.kt", i = {0, 0}, l = {195}, m = "invokeSuspend", n = {"uri", "success"}, s = {"L$0", "L$1"})
    public static final class C03421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
        @DebugMetadata(c = "com.bytedance.ee.bear.document.plugin.upload.OfficeDownloadPlugin$handleDownloadSuccess$1$1", f = "OfficeDownloadPlugin.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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

            public C00931(File r1, String r2, String r3, boolean r4, OfficeDownloadPlugin r5, File r6, Ref.ObjectRef<Uri> r7, Context r8, Ref.BooleanRef r9, Continuation<? super C00931> r10) {
                this.$currentFile = r1;
                this.$suffix = r2;
                this.$fileName = r3;
                this.$needRename = r4;
                this.this$0 = r5;
                this.$dir = r6;
                this.$uri = r7;
                this.$context = r8;
                this.$success = r9;
                super(2, r10);
            }

            public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
                return new C00931(this.$currentFile, this.$suffix, this.$fileName, this.$needRename, this.this$0, this.$dir, this.$uri, this.$context, this.$success, r13);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r14) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r14);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r14);
                final File r4 = this.$currentFile;
                final String r5 = this.$suffix;
                final String r6 = this.$fileName;
                final boolean r7 = this.$needRename;
                final OfficeDownloadPlugin r8 = this.this$0;
                final File r9 = this.$dir;
                final Ref.ObjectRef<Uri> r10 = this.$uri;
                final Context r11 = this.$context;
                final Ref.BooleanRef r12 = this.$success;
                Function0<Unit> r16 = new C00941(r4, r5, r6, r7, r8, r9, r10, r11, r12);
                this.label = 1;
                if (a1.a(r16, this) != r0) goto L12;
                return r0;
            }
        }

        public C03421(OfficeDownloadPlugin r1, tb5.m r2, File r3, String r4, String r5, boolean r6, File r7, Context r8, Continuation<? super C03421> r9) {
            this.this$0 = r1;
            this.$callback = r2;
            this.$currentFile = r3;
            this.$suffix = r4;
            this.$fileName = r5;
            this.$needRename = r6;
            this.$dir = r7;
            this.$context = r8;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new C03421(this.this$0, this.$callback, this.$currentFile, this.$suffix, this.$fileName, this.$needRename, this.$dir, this.$context, r12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            Ref.BooleanRef r3 = (Ref.BooleanRef) this.L$1;
            Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r20);
        L12:
            Uri r5 = (Uri) r4.element;
            if (r3.element == false) goto L16;
            if (r5 == null) goto L16;
            OfficeDownloadPlugin.access$onSuccess(this.this$0, r5, this.$callback);
        L18:
            return Unit.INSTANCE;
        L16:
            OfficeDownloadPlugin.access$onFailed(this.this$0, this.$callback);
            goto L18
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r20);
            r4 = new Ref.ObjectRef();
            Ref.BooleanRef r16 = new Ref.BooleanRef();
            CoroutineDispatcher r14 = Dispatchers.getIO();
            C00931 r13 = new C00931(this.$currentFile, this.$suffix, this.$fileName, this.$needRename, this.this$0, this.$dir, r4, this.$context, r16, null);
            this.L$0 = r4;
            this.L$1 = r16;
            this.label = 1;
            if (BuildersKt.withContext(r14, r13, this) != r1) goto L11;
            return r1;
        L11:
            r3 = r16;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void dismissDialog() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L10;
        LifecycleOwner r1 = r0.getLifecycleOwner();
        if (r1 == null) goto L11;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r1);
        if (r2 == null) goto L12;
        BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
        return;
    L12:
        return;
    L11:
        return;
    }

    public OfficeDownloadPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentActivity access$getActivity(OfficeDownloadPlugin r0) {
        return r0.getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ Context access$getContext(OfficeDownloadPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ String access$getDownloadKey$p(OfficeDownloadPlugin r0) {
        return r0.downloadKey;
    }

    public static final /* synthetic */ Dialog access$getProgressDialog$p(OfficeDownloadPlugin r0) {
        return r0.progressDialog;
    }

    private final void cancelDownload(tb5.m r7) {
        String r0 = this.downloadKey;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.bear.drive.sdk.service.f) LarkContext.spiByDwarf(com.bytedance.ee.bear.drive.sdk.service.f.class)).d0().n(new String[]{r0});
        this.downloadKey = null;
    L5:
        Job r1 = this.copyJob;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        onCancel(r7);
    }

    private final void onCancel(tb5.m r4) {
        dismissDialog();
        if (r4 == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put(TipCallBackData.RESULT, "cancel");
        r4.b(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onFailed(tb5.m r4) {
        dismissDialog();
        UDToast.show(getHost().getContext(), 2131887258);
        JSONObject r0 = new JSONObject();
        r0.put(TipCallBackData.RESULT, "failed");
        r4.b(r0);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super.getBridgeHandlers(r3);
        r3.put(BIZ_UTIL_CANCEL_UPLOAD, new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        tt5.a.h(TAG, "onDetach: cancel download and dismiss dialog");
        cancelDownload$default(this, null, 1, null);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$cancelDownload(OfficeDownloadPlugin r0, tb5.m r1) {
        r0.cancelDownload(r1);
    }

    public static final /* synthetic */ void access$onFailed(OfficeDownloadPlugin r0, tb5.m r1) {
        r0.onFailed(r1);
    }

    public static final /* synthetic */ void access$setDownloadKey$p(OfficeDownloadPlugin r0, String r1) {
        r0.downloadKey = r1;
    }

    public static final /* synthetic */ void access$setProgressDialog$p(OfficeDownloadPlugin r0, Dialog r1) {
        r0.progressDialog = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onSuccess(Uri r4, tb5.m r5) {
        dismissDialog();
        UDToast.show(getHost().getContext(), getContext().getString(2131887288) + c1.c(getContext(), r4));
        JSONObject r6 = new JSONObject();
        r6.put(TipCallBackData.RESULT, "success");
        r5.b(r6);
    }

    public static final /* synthetic */ void access$onSuccess(OfficeDownloadPlugin r0, Uri r1, tb5.m r2) {
        r0.onSuccess(r1, r2);
    }

    public static /* synthetic */ void cancelDownload$default(OfficeDownloadPlugin r0, tb5.m r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.cancelDownload(r1);
    }

    private final File renameFileIfNeed(File r4, String r5, String r6, File r7) {
        boolean r1 = false;
        if (r5.length() <= MAX_FILE_NAME_LENGTH) goto L6;
        r5 = r5.substring(0, MAX_FILE_NAME_LENGTH);
    L6:
        if (r6.length() <= 0) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        r5 = r5 + '.' + r6;
    L10:
        PolarisFileWrapper r8 = new PolarisFileWrapper(r4, r5);
        if (r8.exists() == false) goto L14;
        r8.delete();
    L14:
        if (r7.renameTo(r8) == false) goto L17;
        tt5.a.h(TAG, "Rename success: " + r7.getAbsolutePath() + " -> " + r8.getAbsolutePath());
        return r8;
    L17:
        tt5.a.d(TAG, "Rename failed");
        return r7;
    }

    public static final /* synthetic */ File access$renameFileIfNeed(OfficeDownloadPlugin r0, File r1, String r2, String r3, File r4) {
        return r0.renameFileIfNeed(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleDownloadSuccess(Context r16, boolean r17, File r18, String r19, String r110, File r20, tb5.m r21) {
        this.copyJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getHost().getFragment()), Dispatchers.getMain().getImmediate(), null, new C03421(this, r21, r20, r110, r19, r17, r18, r16, null), 2, null);
    }

    public static final /* synthetic */ void access$handleDownloadSuccess(OfficeDownloadPlugin r0, Context r1, boolean r2, File r3, String r4, String r5, File r6, tb5.m r7) {
        r0.handleDownloadSuccess(r1, r2, r3, r4, r5, r6, r7);
    }
}
