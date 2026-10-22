package com.ss.android.lark.keyboard.edittext2.copy;

import b38.b;
import com.bytedance.lark.pb.im.v1.BatchHardLinkResourcesV2Request;
import com.bytedance.lark.pb.im.v1.BatchHardLinkResourcesV2Response;
import com.bytedance.lark.pb.im.v1.ResourceExtraInfo;
import com.bytedance.lark.pb.im.v1.TransformHtmlToRichTextRequest;
import com.bytedance.lark.pb.im.v1.TransformHtmlToRichTextResponse;
import com.bytedance.lark.pb.im.v1.TransformRichTextToHtmlRequest;
import com.bytedance.lark.pb.im.v1.TransformRichTextToHtmlResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class CopyProtocolServiceImpl implements com.ss.android.lark.keyboard.edittext2.copy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f428967b;

    public interface a {
        @SdkCall(50703)
        RucketJob<BatchHardLinkResourcesV2Response> batchHardLinkV2(BatchHardLinkResourcesV2Request r100);

        @SdkCall(50701)
        RucketJob<TransformHtmlToRichTextResponse> htmlToRichText(TransformHtmlToRichTextRequest r100);

        @SdkCall(50702)
        RucketJob<TransformRichTextToHtmlResponse> richTextToHtml(TransformRichTextToHtmlRequest r100);
    }

    public CopyProtocolServiceImpl() {
        this.f428967b = (a) b.f17382a.create(a.class);
    }

    public final Object a(String r100, Continuation<? super Result<com.ss.android.lark.keyboard.edittext2.copy.a.C5087a>> r101) {
        if ((r101 instanceof CopyProtocolServiceImpl$htmlToRichText$1) == false) goto L7;
        CopyProtocolServiceImpl$htmlToRichText$1 r102 = (CopyProtocolServiceImpl$htmlToRichText$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        com.larksuite.rucket.job.base.b r107 = (com.larksuite.rucket.job.base.b) r104;
        r107.getClass();
        if ((r107 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L24;
        Result.Companion r108 = Result.Companion;
        ErrorResult r109 = r107.a();
        if (r109 != null) goto L23;
        r109 = new ErrorResult("");
    L23:
        return Result.m9449constructorimpl(ResultKt.createFailure(r109));
    L24:
        TransformHtmlToRichTextResponse r110 = (TransformHtmlToRichTextResponse) r107.b();
        Result.Companion r111 = Result.Companion;
        return Result.m9449constructorimpl(new com.ss.android.lark.keyboard.edittext2.copy.a.C5087a(g0.e(r110.rich_text, null), r110.extra_infos));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        RucketJob<TransformHtmlToRichTextResponse> r112 = this.f428967b.htmlToRichText(new TransformHtmlToRichTextRequest.Builder().html_string(r100).build());
        r102.label = 1;
        r104 = r112.awaitGet(r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new CopyProtocolServiceImpl$htmlToRichText$1(this, r101);
        goto L8
    }

    public final Object b(RichText r100, List<ResourceExtraInfo> r101, Continuation<? super String> r102) {
        if ((r102 instanceof CopyProtocolServiceImpl$richTextToHtml$1) == false) goto L7;
        CopyProtocolServiceImpl$richTextToHtml$1 r103 = (CopyProtocolServiceImpl$richTextToHtml$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        com.larksuite.rucket.job.base.b r108 = (com.larksuite.rucket.job.base.b) r105;
        r108.getClass();
        if ((r108 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L20;
        return "";
    L20:
        String r109 = ((TransformRichTextToHtmlResponse) r108.b()).html_string;
        if (r109 != null) goto L24;
        return "";
    L24:
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        com.bytedance.lark.pb.basic.v1.RichText r110 = g0.d(r100);
        RucketJob<TransformRichTextToHtmlResponse> r111 = this.f428967b.richTextToHtml(new TransformRichTextToHtmlRequest.Builder().rich_text(r110).extra_infos(r101).build());
        r103.label = 1;
        r105 = r111.awaitGet(r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new CopyProtocolServiceImpl$richTextToHtml$1(this, r102);
        goto L8
    }
}
