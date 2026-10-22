package com.ss.android.lark.chat.service.impl;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class EditMessageService extends c38.a<m6b.h> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f416321d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f416322e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m6b.j f416323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.service.p f416324c;

    public static final class a {
    }

    static {
        f416321d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        f416322e = ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool());
    }

    @Inject
    public EditMessageService(b38.b r100, m6b.j r101, com.ss.android.lark.im.sdk.service.p r102) {
        Intrinsics.checkNotNullParameter(r100, "rucket");
        Intrinsics.checkNotNullParameter(r101, "configService");
        Intrinsics.checkNotNullParameter(r102, "msgService");
        super(r100);
        this.f416323b = r101;
        this.f416324c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.ss.android.lark.videosend.compress.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object a(EditMessageService r110, String r111, Map r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof EditMessageService$uploadRichTextMediaIfNeed$1) == false) goto L7;
        EditMessageService$uploadRichTextMediaIfNeed$1 r100 = (EditMessageService$uploadRichTextMediaIfNeed$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        RichTextElement.MediaProperty r115 = (RichTextElement.MediaProperty) r100.L$2;
        String r116 = (String) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L29:
        String r117 = (String) r114;
        if (r117.length() != 0) goto L32;
        boolean r105 = true;
    L34:
        if (r105 == false) goto L36;
        Log.i("EditMessageService", "uploadRichTextMediaIfNeed: compress failed, cancel current upload task");
        CancelAsyncUploadRequest r118 = new CancelAsyncUploadRequest.Builder().upload_ids(CollectionsKt.listOf(r116)).build();
        m6b.h r119 = (m6b.h) r110.f22343a.create(m6b.h.class);
        Intrinsics.checkNotNull(r118);
        r119.cancelAsyncUpload(r118);
        return Unit.INSTANCE;
    L36:
        Log.i("EditMessageService", "compress video success, start upload media");
        String r120 = r115.getName();
        if (r120 != null) goto L39;
    L43:
        r120 = new PolarisFileWrapper(r117).getName();
    L44:
        Intrinsics.checkNotNull(r120);
        UploadResourceRequest r121 = new UploadResourceRequest.Builder().chat_id(r104).upload_id(r116).file(new ResourceFile.Builder().file_path(r117).file_type(ResourceFile.FileType.MEDIA).file_name(r120).build()).build();
        m6b.h r122 = (m6b.h) r110.f22343a.create(m6b.h.class);
        Intrinsics.checkNotNull(r121);
        RucketJob.error$default(r122.uploadResource(r121), null, new EditMessageService$uploadResourceByUploadId$1(null), 1, null);
        return Unit.INSTANCE;
    L39:
        if ((!StringsKt.isBlank(r120)) == true) goto L42;
        r120 = null;
    L42:
        if (r120 != null) goto L44;
    L32:
        r105 = false;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        if (r112.isEmpty() == true) goto L46;
        String r123 = (String) CollectionsKt.firstOrNull(r112.keySet());
        if (r123 == null) goto L47;
        RichTextElement.MediaProperty r124 = (RichTextElement.MediaProperty) r112.get(r123);
        if (r124 == null) goto L48;
        r100.L$0 = r111;
        r100.L$1 = r123;
        r100.L$2 = r124;
        r100.label = 1;
        kotlinx.coroutines.j r106 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r106.C();
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        ?? r108 = new com.ss.android.lark.videosend.compress.a(UUID.randomUUID().hashCode(), r124.getOriginPath(), new t(r106, r107));
        r107.element = r108;
        int r109 = com.ss.android.lark.videosend.compress.d.f444936d;
        com.ss.android.lark.videosend.compress.d.b.f444940a.c(r108);
        Object r125 = r106.B();
        if (r125 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L26:
        if (r125 == r102) goto L50;
        r104 = r111;
        r115 = r124;
        r116 = r123;
        r114 = r125;
        goto L29
    L50:
        return r102;
    L48:
        return Unit.INSTANCE;
    L47:
        return Unit.INSTANCE;
    L46:
        return Unit.INSTANCE;
    L7:
        r100 = new EditMessageService$uploadRichTextMediaIfNeed$1(r110, r113);
        goto L8
    }

    public final void b(String r110, RichText r111, String r112, Chat r210, Context r211, s5c.d r212, List<File> r213) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "richText");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r210 != null) goto L5;
        return;
    L5:
        String r100 = r210.getId();
        if (r100 != null) goto L8;
        return;
    L8:
        WeakReference r101 = new WeakReference(r211);
        BuildersKt.launch$default(f416321d, null, null, new EditMessageService$editMessage$1(r212, r101, r211, r110, r111, r213, this, r112, r100, r210, null), 3, null);
    }
}
