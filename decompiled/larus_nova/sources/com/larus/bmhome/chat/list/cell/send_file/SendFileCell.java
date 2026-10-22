package com.larus.bmhome.chat.list.cell.send_file;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.holder.helper.b1;
import com.larus.bmhome.chat.layout.holder.helper.o;
import com.larus.bmhome.chat.layout.holder.helper.x2;
import com.larus.bmhome.chat.layout.holder.menu.item.AttachmentCiteCopyMenuHandler;
import com.larus.bmhome.chat.layout.item.f4;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.databinding.LarusLayoutFileCardBinding;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceSignUrlData;
import com.larus.bmhome.rc.SignUrlMode;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.bmhome.view.FileNameView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.SendFile;
import com.larus.nova.R;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020!H\u0002J\u001a\u0010&\u001a\u00020\u001a2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020!H\u0002J\u0018\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020(H\u0082@¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010.J*\u00100\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010%\u001a\u00020!2\u0006\u00103\u001a\u00020(H\u0002J\u0010\u00104\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/send_file/SendFileCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/send_file/SendFileCellState;", "<init>", "()V", "sendFileBox", "Lcom/larus/bmhome/chat/layout/item/SendFileBox;", "chatParams", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParams", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParams$delegate", "Lkotlin/Lazy;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "setupLongClickMenu", "itemView", "data", "Lcom/larus/im/bean/message/Message;", "nonCompliance", "", "setUpCompliance", "msg", "setupImgViewAndTextView", "requireFileUrl", "", "content", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireFileUrlByResourceId", "file", "Lcom/larus/im/bean/message/SendFile;", "(Lcom/larus/im/bean/message/SendFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireFileUrlByTosKey", "onSuccess", "entity", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "fileName", "triggerLoading", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendFileCell extends BaseMessageListCell<d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f305852i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f4 f305853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f305854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f305855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f305856h;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
    }

    static {
    }

    public SendFileCell() {
        this.f305854f = LazyKt.lazy(new b(this));
        this.f305855g = LazyKt.lazy(new c(this));
    }

    public final Object r(SendFile r100, Continuation<? super String> r110) {
        if ((r110 instanceof SendFileCell$requireFileUrlByResourceId$1) == false) goto L7;
        SendFileCell$requireFileUrlByResourceId$1 r101 = (SendFileCell$requireFileUrlByResourceId$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        String r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r106 = (String) r101.L$1;
        SendFile r107 = (SendFile) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L22:
        ResourceSignUrlData r108 = (ResourceSignUrlData) ((Map) r111).get(r106);
        if (r108 == null) goto L27;
        String r109 = r108.getExternalUrl();
        if (r109 == null) goto L27;
        r105 = p0.a(r109);
    L27:
        FLogger.f375446a.i("SendFileCell", "[requireFileUrlByResourceId] resourceId:" + r107 + ", url:" + r105);
    L28:
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        String r112 = r100.getResourceId();
        if (r112 == null) goto L28;
        String r113 = p0.a(r112);
        if (r113 == null) goto L28;
        ResourceCenter r114 = ResourceCenter.f313541a;
        List<String> r115 = CollectionsKt.listOf(r113);
        SignUrlMode r116 = SignUrlMode.Outer;
        r101.L$0 = r100;
        r101.L$1 = r113;
        r101.label = 1;
        Object r117 = r114.m(r115, r116, r101);
        if (r117 != r103) goto L21;
        return r103;
    L21:
        r107 = r100;
        r106 = r113;
        r111 = r117;
    L7:
        r101 = new SendFileCell$requireFileUrlByResourceId$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object s(SendFile r100, Continuation<? super String> r101) {
        if ((r101 instanceof SendFileCell$requireFileUrlByTosKey$1) == false) goto L7;
        SendFileCell$requireFileUrlByTosKey$1 r102 = (SendFileCell$requireFileUrlByTosKey$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r107 = null;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        FileUrlRespData r109 = (FileUrlRespData) ((com.larus.network.http.a) r104).f360135b;
        if (r109 == null) goto L27;
        List<FileUrlData> r110 = r109.getFileUrlList();
        if (r110 == null) goto L27;
        FileUrlData r111 = (FileUrlData) CollectionsKt.firstOrNull(r110);
        if (r111 == null) goto L27;
        r107 = r111.getMainUrl();
    L27:
        FLogger.f375446a.i("SendFileCell", "[requireFileUrlByTosKey] tosKey:" + r108 + ", url:" + r107);
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r108 = r100.getTosKey();
        if (r108 != null) goto L17;
        return null;
    L17:
        Lazy<ChatApi> r112 = ChatApi.f297153a;
        ChatApi r113 = ChatApi.a.a();
        List r114 = CollectionsKt.listOf(r108);
        String r115 = UploadDataType.FILE.getType();
        r102.L$0 = r108;
        r102.label = 1;
        r113.getClass();
        r104 = ChatApi.e(r114, r115, r102);
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new SendFileCell$requireFileUrlByTosKey$1(this, r101);
        goto L8
    }

    public static final Object o(SendFileCell r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof SendFileCell$requireFileUrl$1) == false) goto L7;
        SendFileCell$requireFileUrl$1 r103 = (SendFileCell$requireFileUrl$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L16;
        if (r107 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
    L39:
        return r105;
    L17:
        SendFile r108 = (SendFile) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L28:
        r105 = (String) r105;
        if (r105 != null) goto L39;
        r103.L$0 = null;
        r103.label = 2;
        r105 = r100.s(r108, r103);
        if (r105 != r106) goto L39;
        return r106;
    L18:
        ResultKt.throwOnFailure(r105);
        List<SendFile> r109 = com.larus.bmhome.chat.sendimage.e.f(r101).getFileList();
        if (r109 == null) goto L38;
        r108 = (SendFile) CollectionsKt.firstOrNull(r109);
        if (r108 == null) goto L38;
        ResourceCenter.f313541a.getClass();
        if (ResourceCenter.c() == false) goto L33;
        r103.L$0 = r108;
        r103.label = 1;
        r105 = r100.r(r108, r103);
        if (r105 != r106) goto L28;
        return r106;
    L33:
        r103.label = 3;
        r105 = r100.s(r108, r103);
        if (r105 != r106) goto L39;
        return r106;
    L38:
        return null;
    L7:
        r103 = new SendFileCell$requireFileUrl$1(r100, r102);
        goto L8
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f4 r103 = new f4(r100);
        r103.setBoxType(r102);
        ChatParam r104 = (ChatParam) this.f305854f.getValue();
        if (r104 == null) goto L5;
        boolean r105 = r104.f296894f;
    L6:
        r103.setUseSubscribedColor(r105);
        this.f305853e = r103;
        return r103;
    L5:
        r105 = false;
        goto L6
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r110, f r111, int r210) {
        d r100 = (d) r111;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r100, "state");
        final Message r101 = r100.f563233a;
        f4 r102 = this.f305853e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sendFileBox");
        f4 r112 = null;
    L6:
        Context r103 = r112.getContext();
        if (r101.getMessageStatus() != MessageStatus.MessageStatus_NOTCOMPLIANT) goto L9;
        boolean r104 = true;
    L10:
        this.f305856h = r104;
        if (r104 == false) goto L16;
        f4 r105 = this.f305853e;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("sendFileBox");
        r105 = null;
    L15:
        r105.n(true, r103.getString(R.string.larus_file_upload_safety_reject));
    L20:
        final Context r106 = r112.getContext();
        final String r107 = r101.getContent();
        if (r107 != null) goto L23;
    L26:
        boolean r108 = true;
    L28:
        if (r108 == true) goto L63;
        List<SendFile> r109 = com.larus.bmhome.chat.sendimage.e.f(r107).getFileList();
        if (r109 == null) goto L63;
        SendFile r113 = (SendFile) CollectionsKt.firstOrNull(r109);
        if (r113 == null) goto L63;
        final String r114 = r113.getFileName();
        if (r114 == null) goto L63;
        List<SendFile> r115 = com.larus.bmhome.chat.sendimage.e.f(r107).getFileList();
        if (r115 == null) goto L42;
        SendFile r116 = (SendFile) CollectionsKt.firstOrNull(r115);
        if (r116 == null) goto L42;
        final String r117 = r116.getLocalResPath();
    L43:
        f4 r118 = this.f305853e;
        if (r118 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("sendFileBox");
        r118 = null;
    L46:
        r118.getClass();
        Intrinsics.checkNotNullParameter(r114, "fileName");
        String r119 = StringsKt.substringAfterLast$default(r114, '.', null, 2, null);
        String r120 = FileMimeTypeUtils.c(r119);
        LarusLayoutFileCardBinding r121 = r118.f304361r;
        if (r121 == null) goto L53;
        FileNameView r122 = r121.f311021b;
        if (r122 == null) goto L53;
        r122.setText(r114);
        if (o0.d(r119) == false) goto L53;
        r122.setTailContent(r119);
    L53:
        LarusLayoutFileCardBinding r123 = r118.f304361r;
        if (r123 == null) goto L58;
        AppCompatImageView r124 = r123.f311023d;
        if (r124 == null) goto L58;
        r124.setImageResource(FileMimeTypeUtils.b(r120, null, false));
    L58:
        f4 r125 = this.f305853e;
        if (r125 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("sendFileBox");
        f4 r126 = null;
    L62:
        e1.d(r126, new com.larus.bmhome.chat.list.cell.send_file.a(this, r106, r101, r114, r107, r117));
        goto L63
    L61:
        r126 = r125;
    L42:
        r117 = null;
    L63:
        Map<String, String> r127 = r101.getBusinessExt();
        if (r127 == null) goto L66;
        String r128 = r127.get("loading");
    L67:
        boolean r129 = Intrinsics.areEqual(r128, "1");
        Map<String, String> r130 = r101.getBusinessExt();     // Catch: Exception -> L74
        if (r130 == null) goto L75;
        String r131 = r130.get("progress");     // Catch: Exception -> L74
        if (r131 == null) goto L75;
        long r132 = CastLongProtector.parseLong(r131);     // Catch: Exception -> L74
    L76:
        FLogger r133 = FLogger.f375446a;
        StringBuilder r134 = new StringBuilder("this ");
        r134.append(hashCode());
        r134.append(" ,shouldLoading ");
        r134.append(r129);
        r134.append(" , sendFileUploadProcess ");
        r134.append(r132);
        r134.append(" loading=");
        Map<String, String> r135 = r101.getBusinessExt();
        if (r135 == null) goto L79;
        String r136 = r135.get("loading");
    L80:
        r134.append(r136);
        r133.d("SendFileCell", r134.toString());
        f4 r137 = this.f305853e;
        if (r137 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("sendFileBox");
        r137 = null;
    L83:
        r137.setProcess(r132);
        if (r129 == false) goto L91;
        CircleProgressBarView r138 = r137.f304360q;
        if (r138 == null) goto L88;
        e1.x(r138);
    L88:
        FrameLayout r139 = r137.f304359p;
        if (r139 == null) goto L97;
        e1.x(r139);
    L97:
        ic8.e.f489187a.getClass();
        String r140 = ic8.e.b(r101, null);
        q0 r141 = lf8.a.b(this);
        q0 r142 = lf8.a.b(this);
        if (r142 == null) goto L100;
        q0.a r143 = r142.getProvider();
    L101:
        b1.a(new o(r101, r141, r143, new com.larus.bmhome.chat.layout.holder.helper.f(r140, new x2()), CollectionsKt.listOf(new com.larus.bmhome.chat.layout.holder.menu.item.a[]{new AttachmentCiteCopyMenuHandler(), new com.larus.bmhome.chat.layout.holder.menu.item.d()}), null, null, 96), r112);
        return;
    L100:
        r143 = null;
        goto L101
    L91:
        CircleProgressBarView r144 = r137.f304360q;
        if (r144 == null) goto L94;
        e1.o(r144);
    L94:
        FrameLayout r145 = r137.f304359p;
        if (r145 == null) goto L97;
        e1.o(r145);
        goto L97
    L79:
        r136 = null;
    L75:
        r132 = 0;
    L74:
        FLogger.f375446a.d("SendFileCell", "this " + hashCode() + " ,shouldLoading " + r129 + " , sendFileUploadProcess 0");
        goto L75
    L66:
        r128 = null;
        goto L67
    L23:
        if (r107.length() == 0) goto L26;
        r108 = false;
        goto L28
    L16:
        f4 r146 = this.f305853e;
        if (r146 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("sendFileBox");
        r146 = null;
    L19:
        int r147 = f4.f304358s;
        r146.n(false, "");
        goto L20
    L9:
        r104 = false;
        goto L10
    L5:
        r112 = r102;
        goto L6
    }
}
