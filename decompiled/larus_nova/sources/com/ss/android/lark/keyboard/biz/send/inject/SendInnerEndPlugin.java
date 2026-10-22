package com.ss.android.lark.keyboard.biz.send.inject;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.larksuite.rucket.job.RucketJob;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.Image;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UpLinkState;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityContent;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileInfo;
import com.ss.android.lark.keyboard.base.ResourceUploadInfo;
import com.ss.android.lark.keyboard.base.e;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.base.l;
import com.ss.android.lark.keyboard.base.q;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.utils.FlowSendMessageUtils;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.utils.g;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.b1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import cya.h;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes36.dex */
public final class SendInnerEndPlugin implements wnb.b<SendInnerEndPlugin>, l {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f428531q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wnb.c f428534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f428535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f428536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f428537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet<String> f428538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet<String> f428539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet<String> f428540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f428541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f428542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Job f428543l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f428544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f428545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f428546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f428547p;

    public static final class a implements wnb.b.a<SendInnerEndPlugin> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f428548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SendInnerEndPlugin f428549b;

        public b(View r100, SendInnerEndPlugin r101) {
            this.f428548a = r100;
            this.f428549b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f428548a.isEnabled() == true) goto L5;
            return;
        L5:
            SendInnerEndPlugin.f(this.f428549b);
        }
    }

    public static final class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendInnerEndPlugin f428550a;

        public c(SendInnerEndPlugin r100) {
            this.f428550a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.keyboard.keyboard2.b r101 = this.f428550a.k().L();
            l r102 = null;
            if ((r101 instanceof f) == false) goto L5;
            f r103 = (f) r101;
        L7:
            if (r103 != null) goto L9;
            return false;
        L9:
            q r104 = r103.N(true);
            com.ss.android.lark.keyboard.keyboard2.b r105 = this.f428550a.k().L();
            if ((r105 instanceof l) == false) goto L12;
            r102 = (l) r105;
        L12:
            if (r102 != null) goto L14;
            return false;
        L14:
            return r102.g(r104);
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class d extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendInnerEndPlugin f428551a;

        public d(SendInnerEndPlugin r100) {
            this.f428551a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            SendInnerEndPlugin.f(this.f428551a);
        }
    }

    static {
        f428531q = new a();
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final boolean g(q r100) {
        return false;
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final void y(boolean r100) {
    }

    @Override // wnb.b
    public final View a() {
        View r100 = LayoutInflater.from(this.f428532a.f410096a.requireContext()).inflate(R.layout.item_icon_button_send, null);
        ImageView r101 = (ImageView) r100.findViewById(R.id.ivSend);
        r101.setImageResource(PluginUtils.b());
        this.f428536e = r101;
        r100.setOnClickListener(new b(r100, this));
        r100.setOnLongClickListener(new c(this));
        this.f428535d = r100;
        com.ss.android.lark.keyboard.keyboard2.b r102 = k().L();
        if ((r102 instanceof f) == false) goto L5;
        f r103 = (f) r102;
    L6:
        if (r103 == null) goto L8;
        r103.p(this);
    L8:
        com.ss.android.lark.keyboard.keyboard2.b r104 = k().L();
        if ((r104 instanceof f) == false) goto L11;
        f r105 = (f) r104;
    L12:
        if (r105 == null) goto L14;
        int r106 = e.f428229a;
        r105.N(false);
    L14:
        k().e().of(this).d(h.class, new SendInnerEndPlugin$refreshSendUI$1$1(this));
        Job r107 = this.f428541j;
        if (r107 == null) goto L17;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L17:
        this.f428541j = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f428532a.f410096a), null, null, new SendInnerEndPlugin$initAttachmentStateFlow$1(this, null), 3, null);
        Job r108 = this.f428542k;
        if (r108 == null) goto L20;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L20:
        this.f428542k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f428532a.f410096a), null, null, new SendInnerEndPlugin$initUploadPush$1(this, null), 3, null);
        Intrinsics.checkNotNull(r100);
        return r100;
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(0, 0, UIHelper.dp2px(12.0f), 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f428534c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final com.ss.android.lark.keyboard.b k() {
        com.ss.android.lark.keyboard.b r100 = this.f428533b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        View r100 = this.f428535d;
        if (r100 == null) goto L5;
        r100.setOnClickListener(null);
    L5:
        View r101 = this.f428535d;
        if (r101 == null) goto L30;
        r101.setOnLongClickListener(null);
    L30:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        com.ss.android.lark.keyboard.keyboard2.b r103 = k().L();     // Catch: Throwable -> L17
        if ((r103 instanceof f) == false) goto L11;
        f r104 = (f) r103;     // Catch: Throwable -> L17
    L12:
        if (r104 == null) goto L14;
        r104.E(this);     // Catch: Throwable -> L17
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L17
    L19:
        Job r106 = this.f428541j;
        if (r106 == null) goto L22;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L22:
        this.f428541j = null;
        Job r107 = this.f428542k;
        if (r107 == null) goto L25;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L25:
        this.f428542k = null;
        Job r108 = this.f428543l;
        if (r108 == null) goto L28;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L28:
        this.f428543l = null;
        this.f428538g.clear();
        this.f428539h.clear();
        this.f428540i.clear();
        this.f428535d = null;
        this.f428536e = null;
        return;
    L14:
        r105 = null;
        goto L15
    L11:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.BOTTOM;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.InnerEndVertical;
    }

    @Override // wnb.b
    public final wnb.b.a<SendInnerEndPlugin> getKey() {
        return f428531q;
    }

    public SendInnerEndPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428532a = r100;
        this.f428537f = LazyKt.lazy(SendInnerEndPlugin$model$2.INSTANCE);
        this.f428538g = new LinkedHashSet();
        this.f428539h = new LinkedHashSet();
        this.f428540i = new LinkedHashSet();
        this.f428544m = LazyKt.lazy(new SendInnerEndPlugin$attachmentExtension$2(this));
        this.f428545n = LazyKt.lazy(new SendInnerEndPlugin$attachmentEntityListStateFlow$2(this));
        this.f428546o = LazyKt.lazy(SendInnerEndPlugin$resourceUploadInfoMap$2.INSTANCE);
        this.f428547p = new d(this);
    }

    public static final void f(SendInnerEndPlugin r100) {
        Job r101 = r100.f428543l;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        r100.f428543l = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.f428532a.f410096a), null, null, new SendInnerEndPlugin$clickWrapper$1(r100, null), 3, null);
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428534c = r100;
    }

    public final String l(UplinkFileEntity r100) {
        String r101 = null;
        if (wxa.f.d(r100) == false) goto L11;
        int r102 = b1.f444699a;
        Context r103 = this.f428532a.f410096a.requireContext();
        Uri r104 = r100.getUri();
        UplinkEntityContent r105 = r100.getUplinkEntityContent();
        if (r105 == null) goto L9;
        Image r106 = r105.getUplinkImageInfo();
        if (r106 == null) goto L9;
        r101 = r106.localResPath;
    L9:
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        return b1.c(r103, r104, r101);
    L11:
        if (wxa.f.c(r100) == false) goto L19;
        int r107 = b1.f444699a;
        Context r108 = this.f428532a.f410096a.requireContext();
        Uri r109 = r100.getUri();
        UplinkEntityContent r110 = r100.getUplinkEntityContent();
        if (r110 == null) goto L28;
        UplinkFileInfo r111 = r110.getUplinkFileInfo();
        if (r111 == null) goto L28;
        r111.getLocalResPath();
    L28:
        return b1.b(r108, r109);
    L19:
        if (wxa.f.e(r100) == false) goto L29;
        int r112 = b1.f444699a;
        Context r113 = this.f428532a.f410096a.requireContext();
        Uri r114 = r100.getUri();
        UplinkEntityContent r115 = r100.getUplinkEntityContent();
        if (r115 == null) goto L25;
        UplinkFileInfo r116 = r115.getUplinkFileInfo();
        if (r116 == null) goto L25;
        r101 = r116.getLocalResPath();
    L25:
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        return b1.c(r113, r114, r101);
    L29:
        return null;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428533b = r100;
    }

    public static final Object j(SendInnerEndPlugin r110, String r111, String r112, String r113, UplinkFileEntity r210, Continuation r211) {
        r110.getClass();
        if ((r211 instanceof SendInnerEndPlugin$uploadResource$1) == false) goto L7;
        SendInnerEndPlugin$uploadResource$1 r100 = (SendInnerEndPlugin$uploadResource$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SendInnerEndPlugin$uploadResource$1 r114 = r100;
        Object r102 = r114.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r114.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L41:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        UplinkFileEntity r104 = (UplinkFileEntity) r114.L$2;
        String r105 = (String) r114.L$1;
        String r106 = (String) r114.L$0;
        ResultKt.throwOnFailure(r102);
        UplinkFileEntity r116 = r104;
        String r117 = r105;
        String r107 = r106;
    L22:
        g r108 = (g) r102;
        UplinkFileEntity r109 = r116;
    L23:
        Log.i("SendInnerEndPlugin", "handleResourceBeforeUpload, handleResult: " + r108);
        if (r108 == null) goto L27;
        String r118 = r108.f430966b;
        if (r118 == null) goto L27;
    L28:
        if (r108 == null) goto L30;
        ResourceFile.FileType r119 = r108.f430965a;
    L32:
        if (TextUtils.isEmpty(r118) == true) goto L39;
        if (r119 == null) goto L39;
        r114.L$0 = null;
        r114.L$1 = null;
        r114.L$2 = null;
        r114.label = 2;
        if (r110.m(r107, r117, r118, r119, r109, r114) != r115) goto L41;
        return r115;
    L39:
        Log.e("SendInnerEndPlugin", "uploadResource failed, uploadId=" + r117 + ", finalPath=" + r118 + ", fileType=" + r119);
        r110.f428538g.remove(r117);
        r110.f428539h.add(r117);
        r110.f428540i.remove(r117);
        r109.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        r109.setUpLinkProcess(Boxing.boxInt(0));
        return Unit.INSTANCE;
    L30:
        r119 = null;
    L27:
        r118 = "";
        goto L28
    L16:
        ResultKt.throwOnFailure(r102);
        Context r120 = r110.f428532a.f410096a.getContext();
        if (r120 != null) goto L19;
        r107 = r111;
        r117 = r112;
        r109 = r210;
        r108 = null;
        goto L23
    L19:
        FlowSendMessageUtils r121 = FlowSendMessageUtils.f430952a;
        ConcurrentHashMap<String, ResourceUploadInfo> r122 = (ConcurrentHashMap) r110.f428546o.getValue();
        r107 = r111;
        r114.L$0 = r107;
        r117 = r112;
        r114.L$1 = r117;
        r116 = r210;
        r114.L$2 = r116;
        r114.label = 1;
        r102 = r121.b(r120, r112, r113, r210, r122, r114);
        if (r102 != r115) goto L22;
        return r115;
    L7:
        r100 = new SendInnerEndPlugin$uploadResource$1(r110, r211);
        goto L8
    }

    public final Object m(String r100, String r101, String r102, ResourceFile.FileType r103, UplinkFileEntity r104, Continuation<? super Unit> r110) {
        if ((r110 instanceof SendInnerEndPlugin$uploadResourceInner$1) == false) goto L7;
        SendInnerEndPlugin$uploadResourceInner$1 r105 = (SendInnerEndPlugin$uploadResourceInner$1) r110;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r111 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r104 = (UplinkFileEntity) r105.L$1;
        r101 = (String) r105.L$0;
        ResultKt.throwOnFailure(r111);
    L17:
        com.larksuite.rucket.job.base.b r112 = (com.larksuite.rucket.job.base.b) r111;
        r112.getClass();
        if ((r112 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L21;
        Log.e("SendInnerEndPlugin", "uploadResource failed, uploadId=" + r101 + ", err=" + r112.a());
        this.f428538g.remove(r101);
        this.f428539h.add(r101);
        this.f428540i.remove(r101);
        r104.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        r104.setUpLinkProcess(Boxing.boxInt(0));
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        UploadResourceRequest r109 = new UploadResourceRequest.Builder().chat_id(r100).upload_id(r101).file(new ResourceFile.Builder().file_path(r102).file_type(r103).build()).build();
        KeyboardModel r113 = (KeyboardModel) this.f428537f.getValue();
        com.ss.android.lark.keyboard.viewmodel.a r114 = (com.ss.android.lark.keyboard.viewmodel.a) b38.b.f17382a.create(com.ss.android.lark.keyboard.viewmodel.a.class);
        Intrinsics.checkNotNull(r109);
        RucketJob<UploadResourceResponse> r115 = r114.uploadResource(r109);
        r105.L$0 = r101;
        r105.L$1 = r104;
        r105.label = 1;
        r111 = r115.awaitGet(r105);
        if (r111 != r107) goto L17;
        return r107;
    L7:
        r105 = new SendInnerEndPlugin$uploadResourceInner$1(this, r110);
        goto L8
    }
}
