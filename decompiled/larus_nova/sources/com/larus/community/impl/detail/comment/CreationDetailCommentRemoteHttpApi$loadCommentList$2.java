package com.larus.community.impl.detail.comment;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.model.comment.api.CommentHttpApi$GetCommentListData;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/comment/api/CommentHttpApi$GetCommentListData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.comment.CreationDetailCommentRemoteHttpApi$loadCommentList$2", f = "CreationDetailDataMediator.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailCommentRemoteHttpApi$loadCommentList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends CommentHttpApi$GetCommentListData>>, Object> {
    final /* synthetic */ String $anchorCommentId;
    final /* synthetic */ String $entityId;
    final /* synthetic */ String $preOffsetToken;
    int label;

    public CreationDetailCommentRemoteHttpApi$loadCommentList$2(String r100, String r101, String r102, Continuation<? super CreationDetailCommentRemoteHttpApi$loadCommentList$2> r103) {
        this.$entityId = r100;
        this.$preOffsetToken = r101;
        this.$anchorCommentId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CreationDetailCommentRemoteHttpApi$loadCommentList$2(this.$entityId, this.$preOffsetToken, this.$anchorCommentId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.larus.network.http.a<? extends CommentHttpApi$GetCommentListData>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.larus.network.http.a<CommentHttpApi$GetCommentListData>> r101) {
        return ((CreationDetailCommentRemoteHttpApi$loadCommentList$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L27:
        return (com.larus.network.http.a) r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        JSONObject r102 = new JSONObject();
        String r103 = this.$entityId;
        String r104 = this.$preOffsetToken;
        String r105 = this.$anchorCommentId;
        r102.put(PickerReporterConstants.KEY.ENTITY_ID, r103);
        boolean r106 = false;
        if (r104 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L17;
        r102.put("pre_offset_token", r104);
    L17:
        if (r105 != null) goto L19;
    L20:
        r106 = true;
    L21:
        if (r106 == true) goto L23;
        r102.put("anchor_comment_id", r105);
    L23:
        Unit r108 = Unit.INSTANCE;
        this.label = 1;
        r110 = HttpExtKt.k(ServiceType.UGC, CommentHttpApi$GetCommentListData.class, "/creativity/community/comment/list", r102, null, null, false, null, null, null, this, 1008);
        if (r110 != r100) goto L27;
        return r100;
    L19:
        if (r105.length() != 0) goto L21;
    L11:
        if (r104.length() == 0) goto L14;
        r107 = false;
        goto L15
    }
}
