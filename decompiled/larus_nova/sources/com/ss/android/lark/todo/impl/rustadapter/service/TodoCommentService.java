package com.ss.android.lark.todo.impl.rustadapter.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.todo.v1.CreateCommentInfo;
import com.bytedance.lark.pb.todo.v1.CreateCommentRequest;
import com.bytedance.lark.pb.todo.v1.CreateCommentResponse;
import com.bytedance.lark.pb.todo.v1.DeleteCommentRequest;
import com.bytedance.lark.pb.todo.v1.DeleteCommentResponse;
import com.bytedance.lark.pb.todo.v1.GetCommentDraftRequest;
import com.bytedance.lark.pb.todo.v1.GetCommentDraftResponse;
import com.bytedance.lark.pb.todo.v1.ListCommentsRequest;
import com.bytedance.lark.pb.todo.v1.ListCommentsResponse;
import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.lark.pb.todo.v1.TodoComment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoCommentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TodoCommentService f444244a = null;

    public static final class a implements RustLog.a<CreateCommentResponse> {
        public a() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(CreateCommentResponse r100) {
            CreateCommentResponse r101 = r100;
            if (r101 == null) goto L8;
            TodoComment r102 = r101.comment;
            if (r102 == null) goto L8;
            String r103 = r102.cid;
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return CreateCommentResponse.ADAPTER.decode(r100);
        }
    }

    public static final class b implements RustLog.a<DeleteCommentResponse> {
        public b() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final /* bridge */ /* synthetic */ String a(DeleteCommentResponse r100) {
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return DeleteCommentResponse.ADAPTER.decode(r100);
        }
    }

    public static final class c implements RustLog.a<ListCommentsResponse> {
        public c() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(ListCommentsResponse r100) {
            ListCommentsResponse r101 = r100;
            if (r101 == null) goto L12;
            List<TodoComment> r102 = r101.comments;
            if (r102 == null) goto L12;
            List<TodoComment> r103 = r102;
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator<T> r105 = r103.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            r104.add(((TodoComment) r105.next()).cid);
            goto L8
        L10:
            String r106 = r104.toString();
            if (r106 == null) goto L12;
            return r106;
        L12:
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return ListCommentsResponse.ADAPTER.decode(r100);
        }
    }

    public static final class d implements RustLog.a<GetCommentDraftResponse> {
        public d() {
        }

        @Override // com.ss.android.lark.todo.impl.rustadapter.service.RustLog.a
        public final String a(GetCommentDraftResponse r100) {
            GetCommentDraftResponse r101 = r100;
            if (r101 == null) goto L8;
            CreateCommentInfo r102 = r101.info;
            if (r102 == null) goto L8;
            String r103 = r102.cid;
            if (r103 == null) goto L8;
            return r103;
        L8:
            return "";
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return GetCommentDraftResponse.ADAPTER.decode(r100);
        }
    }

    static {
        f444244a = new TodoCommentService();
    }

    public TodoCommentService() {
    }

    public static RichContent e(RichText r100) {
        return new RichContent.Builder().rich_text(j8c.c.b(r100)).doc_entity(null).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object d(String r100, Continuation<? super CreateCommentInfo> r101) {
        if ((r101 instanceof TodoCommentService$readCommentDraft$1) == false) goto L7;
        TodoCommentService$readCommentDraft$1 r102 = (TodoCommentService$readCommentDraft$1) r101;
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
        RustLog.b r107 = (RustLog.b) r104;
        if (r107.f444239b == null) goto L20;
        return null;
    L20:
        GetCommentDraftResponse r108 = (GetCommentDraftResponse) r107.f444238a;
        if (r108 == null) goto L23;
        boolean r109 = Intrinsics.areEqual(r108.found, Boxing.boxBoolean(true));
    L24:
        if (r109 == false) goto L29;
        GetCommentDraftResponse r110 = (GetCommentDraftResponse) r107.f444238a;
        if (r110 != null) goto L28;
        return null;
    L28:
        return r110.info;
    L29:
        return null;
    L23:
        r109 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        GetCommentDraftRequest.Builder r111 = new GetCommentDraftRequest.Builder().todo_guid(r100);
        int r112 = RustLog.f444237a;
        Command r113 = Command.GET_TODO_COMMENT_DRAFT;
        Intrinsics.checkNotNull(r111);
        r102.label = 1;
        r104 = RustLog.a(r113, r111, new d(), "guid = " + r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new TodoCommentService$readCommentDraft$1(this, r101);
        goto L8
    }

    public final Object b(String r100, String r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof TodoCommentService$deleteComment$1) == false) goto L7;
        TodoCommentService$deleteComment$1 r103 = (TodoCommentService$deleteComment$1) r102;
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
        ErrorResult r108 = ((RustLog.b) r105).f444239b;
        if (r108 == null) goto L21;
        z8c.a r109 = z8c.a.f570975a;
        z8c.a.c(Scene.TodoComment, Event.todo_comment_delete, r108);
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        DeleteCommentRequest.Builder r110 = new DeleteCommentRequest.Builder().todo_guid(r100).comment_id(r101);
        int r111 = RustLog.f444237a;
        Command r112 = Command.DELETE_TODO_COMMENT;
        Intrinsics.checkNotNull(r110);
        r103.label = 1;
        r105 = RustLog.a(r112, r110, new b(), "guid = " + r100, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new TodoCommentService$deleteComment$1(this, r102);
        goto L8
    }

    public final Object c(String r100, int r101, int r102, ListCommentsRequest.Direction r103, Continuation<? super RustLog.b<ListCommentsResponse>> r110) {
        if ((r110 instanceof TodoCommentService$readComment$1) == false) goto L7;
        TodoCommentService$readComment$1 r104 = (TodoCommentService$readComment$1) r110;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r111 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r104.I$0;
        ResultKt.throwOnFailure(r111);
    L17:
        RustLog.b r112 = (RustLog.b) r111;
        ErrorResult r108 = r112.f444239b;
        if (r108 != null) goto L20;
    L22:
        return r112;
    L20:
        if (r101 != Integer.MAX_VALUE) goto L22;
        z8c.a r109 = z8c.a.f570975a;
        z8c.a.c(Scene.TodoComment, Event.todo_comment_load_first_page, r108);
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        ListCommentsRequest.Builder r113 = new ListCommentsRequest.Builder().todo_guid(r100).position(Boxing.boxInt(r101)).count(Boxing.boxInt(r102)).direction(r103);
        int r114 = RustLog.f444237a;
        Command r115 = Command.LIST_TODO_COMMENTS;
        Intrinsics.checkNotNull(r113);
        r104.I$0 = r101;
        r104.label = 1;
        r111 = RustLog.a(r115, r113, new c(), "guid = " + r100, r104);
        if (r111 != r106) goto L17;
        return r106;
    L7:
        r104 = new TodoCommentService$readComment$1(this, r110);
        goto L8
    }

    public final Object a(String r100, RichText r101, List<TodoAttachment> r102, List<TodoAttachment> r103, String r104, Continuation<? super RustLog.b<CreateCommentResponse>> r110) {
        if ((r110 instanceof TodoCommentService$createComment$1) == false) goto L7;
        TodoCommentService$createComment$1 r105 = (TodoCommentService$createComment$1) r110;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r111 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L21:
        RustLog.b r112 = (RustLog.b) r111;
        ErrorResult r109 = r112.f444239b;
        if (r109 == null) goto L24;
        z8c.a r113 = z8c.a.f570975a;
        z8c.a.c(Scene.TodoComment, Event.todo_comment_send, r109);
    L24:
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        CreateCommentRequest.Builder r114 = new CreateCommentRequest.Builder().todo_guid(r100);
        if (r101 == null) goto L17;
        RichContent r115 = e(r101);
    L18:
        CreateCommentRequest.Builder r116 = r114.content(r115).reply_parent_id(r104).reply_root_id(null).cid(UUID.randomUUID().toString()).attachments(r102).file_attachments(r103).type(TodoComment.Type.RICH_TEXT);
        int r117 = RustLog.f444237a;
        Command r118 = Command.CREATE_TODO_COMMENT;
        Intrinsics.checkNotNull(r116);
        r105.label = 1;
        r111 = RustLog.a(r118, r116, new a(), "guid = " + r100, r105);
        if (r111 != r107) goto L21;
        return r107;
    L17:
        r115 = null;
    L7:
        r105 = new TodoCommentService$createComment$1(this, r110);
        goto L8
    }
}
