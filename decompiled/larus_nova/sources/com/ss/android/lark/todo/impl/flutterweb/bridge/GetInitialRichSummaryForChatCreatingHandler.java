package com.ss.android.lark.todo.impl.flutterweb.bridge;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.larksuite.framework.utils.l0;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.detail.create.richtext.PostEntity;
import com.ss.android.lark.todo.impl.features.detail.create.richtext.RichTextMessage;
import com.ss.android.lark.todo.impl.features.detail.create.richtext.TextEntity;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoRichContent;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCommon;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
public final class GetInitialRichSummaryForChatCreatingHandler extends AbsChameleonHandler<Unit> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static RichTextMessage f444138c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsChameleonPlugin f444139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f444140b;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.f444140b;
    }

    public GetInitialRichSummaryForChatCreatingHandler(AbsChameleonPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        this.f444139a = r100;
        this.f444140b = LKAPIModules.Biz.Todo.GetInitialRichSummaryForChatCreating.getValue();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(Callback r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        Log.i("TodoWeb", "call " + this.f444140b);
        RichTextMessage r100 = f444138c;
        if (r100 != null) goto L6;
        Log.w("TodoWeb", "richTextMessage is null");
        r110.success(null);
        f444138c = null;
        return;
    L6:
        if (r100 == null) goto L23;
        TextEntity r101 = r100.getMessageContent().getTextEntity();
        if (r101 == null) goto L13;
        RichText r102 = r101.getText();
        if (r102 == null) goto L13;
    L12:
        RichText r103 = r102;
    L17:
        com.bytedance.lark.pb.basic.v1.RichText r104 = j8c.c.b(r103);
        if (r104 != null) goto L21;
        Log.w("TodoWeb", "pbRichText is null");
        r110.success(null);
        f444138c = null;
        return;
    L21:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f444139a.getHost().getLifecycleOwner()), Dispatchers.getIO(), null, new GetInitialRichSummaryForChatCreatingHandler$handle$1$1(this, r103, r104, r110, null), 2, null);
        return;
    L13:
        PostEntity r105 = r100.getMessageContent().getPostEntity();
        if (r105 == null) goto L16;
        r102 = r105.getContent();
        goto L12
    L16:
        r103 = null;
        goto L17
    }

    public static void c(RichText r100, TodoRichContent r110) {
        if (r100 == null) goto L21;
        RichText.RichTextElements r101 = r100.getElements();
        if (r101 == null) goto L35;
        Map<String, RichTextElement> r102 = r101.getDictionary();
        if (r102 == null) goto L36;
        Iterator<Map.Entry<String, RichTextElement>> r103 = r102.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L37;
        RichTextElement r104 = r103.next().getValue();
        if (r104 == null) goto L9;
        if ((r104.getProperty() instanceof RichTextElement.AnchorProperty) == false) goto L9;
        RichTextElement.AnchorProperty r105 = (RichTextElement.AnchorProperty) r104.getProperty();
        if (TextUtils.isEmpty(r105.getDisplayTitle()) == true) goto L9;
        if (TextUtils.isEmpty(r105.getFaviconUrl()) == true) goto L9;
        if (TextUtils.isEmpty(r105.getHref()) == true) goto L9;
        String r106 = l0.a().toString();
        r110.insertUrlPreviewEntity(new UrlInlinePreviewEntity.Builder().sourceId("").previewId(r106).url(new Url(r105.getHref(), "", "", "", "")).useColorIcon(true).headerInfo(new UnifiedHeaderInfo(new ColorIcon(null, r105.getFaviconUrl(), null, null))).title(r105.getDisplayTitle()).needReload(false).netUrlTag(null).version(0).udIcon(null).passThroughImage(null).isSdkPreview(false).build());
        goto L9
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    public static final Object a(GetInitialRichSummaryForChatCreatingHandler r110, RichText r111, com.bytedance.lark.pb.basic.v1.RichText r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1) == false) goto L7;
        GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1 r100 = (GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L16;
        if (r102 != 1) goto L15;
        TodoRichContent r116 = (TodoRichContent) r100.L$3;
        String r117 = (String) r100.L$2;
        RichContent.Builder r118 = (RichContent.Builder) r100.L$1;
        RichText r103 = (RichText) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L44
        TodoRichContent r104 = r116;
        String r105 = r117;
        r111 = r103;
    L41:
        UrlInlinePreviewEntity r119 = (UrlInlinePreviewEntity) r114;     // Catch: Throwable -> L44
        if (r119 != null) goto L46;
        c(r111, r104);     // Catch: Throwable -> L44
    L47:
        RichContent r120 = r104.parseToPb();     // Catch: Throwable -> L44
    L53:
        return r120;
    L46:
        r104.insertUrlPreviewEntity(r119.getBuilder().url(new Url(r105, "", "", "", "")).build());     // Catch: Throwable -> L44
    L44:
        Throwable th10 = th;
    L51:
        Log.e("TodoWeb", "buildRichContentWithUrlPreview error", th10);
        r120 = r118.build();
        Intrinsics.checkNotNull(r120);
        goto L53
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r114);
        RichContent.Builder r121 = new RichContent.Builder().rich_text(r112);
        DefaultConstructorMarker r122 = null;
        RichContent.Builder r123 = r121.doc_entity(null);
        if (r111 == null) goto L20;
        String r106 = com.ss.android.lark.widget.richtext.i.i(r111);
        if (r106 == null) goto L20;
    L21:
        boolean r107 = false;
        if (r106.length() != 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == true) goto L61;
    L27:
        int r109 = 2;
        if (r106.length() <= 1) goto L33;
        if (StringsKt.startsWith$default(r106, " ", false, 2, null) == false) goto L33;
        r106 = r106.substring(1);
    L33:
        if (r106.length() > 1) goto L35;
    L56:
        r104 = new TodoRichContent(r123.build(), r107, r109, r122);     // Catch: Throwable -> L49
        TodoRustCommon r124 = TodoRustCommon.f444251a;     // Catch: Throwable -> L49
        r100.L$0 = r111;     // Catch: Throwable -> L49
        r100.L$1 = r123;     // Catch: Throwable -> L49
        r100.L$2 = r106;     // Catch: Throwable -> L49
        r100.L$3 = r104;     // Catch: Throwable -> L49
        r100.label = 1;     // Catch: Throwable -> L49
        Object r125 = TodoRustCommon.d(r106, r100);     // Catch: Throwable -> L49
        if (r125 == r115) goto L62;
        r118 = r123;
        r114 = r125;
        r105 = r106;
        goto L41
    L62:
        return r115;
    L49:
        th = move-exception;
        r118 = r123;
        th10 = th;
        goto L51
    L35:
        if (StringsKt.endsWith$default(r106, "\n", false, 2, null) == false) goto L56;
        r106 = r106.substring(0, r106.length() - 1);
        goto L33
    L61:
        return r123.build();
    L24:
        r108 = false;
    L20:
        r106 = "";
    L7:
        r100 = new GetInitialRichSummaryForChatCreatingHandler$buildRichContentWithUrlPreview$1(r110, r113);
        goto L8
    }
}
