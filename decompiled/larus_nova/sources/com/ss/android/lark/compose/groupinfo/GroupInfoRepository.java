package com.ss.android.lark.compose.groupinfo;

import com.lark.kmp.pb.basic.v1.AvatarMeta;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.im.v1.UpdateChatRequest;
import com.lark.kmp.pb.im.v1.UpdateChatResponse;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$$inlined$map$1;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.rustclient.api.model.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class GroupInfoRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.d f417703a;

    public GroupInfoRepository(com.lark.kmp.rustclient.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f417703a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, String r111, Continuation<? super Result<UpdateChatResponse>> r112) {
        if ((r112 instanceof GroupInfoRepository$updateAvatar$1) == false) goto L7;
        GroupInfoRepository$updateAvatar$1 r100 = (GroupInfoRepository$updateAvatar$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L21
    L19:
        Object r114 = Result.m9449constructorimpl((UpdateChatResponse) ((k) r113).f282482b);     // Catch: Throwable -> L21
    L23:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L26;
        int r116 = c.f417711a;
        c.a("GroupInfoRepository updateAvatar failed: " + r115.getMessage());
    L26:
        return r114;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        AvatarMeta.a r117 = new AvatarMeta.a();
        AvatarMeta.Type r104 = AvatarMeta.Type.UPLOAD;
        Intrinsics.checkNotNullParameter(r104, "type");
        r117.f278684d = r104;
        AvatarMeta r105 = new AvatarMeta(r117, r117.c(), null);
        UpdateChatRequest.a r106 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r110, "chat_id");
        r106.f282336d = r110;
        r106.f282351s = r111;
        r106.f282357y = r105;
        com.lark.kmp.rustclient.api.model.c r118 = new com.lark.kmp.rustclient.api.model.c(r106, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120);
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L21
        RustOutputKt$errorAsException$$inlined$map$1 r120 = i.a(this.f417703a.b(r118).a());     // Catch: Throwable -> L21
        r100.label = 1;     // Catch: Throwable -> L21
        r113 = kotlinx.coroutines.flow.e.s(r120, r100);     // Catch: Throwable -> L21
        if (r113 != r102) goto L19;
        return r102;
    L21:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new GroupInfoRepository$updateAvatar$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r110, String r111, Continuation<? super Result<UpdateChatResponse>> r112) {
        if ((r112 instanceof GroupInfoRepository$updateName$1) == false) goto L7;
        GroupInfoRepository$updateName$1 r100 = (GroupInfoRepository$updateName$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L21
    L19:
        Object r114 = Result.m9449constructorimpl((UpdateChatResponse) ((k) r113).f282482b);     // Catch: Throwable -> L21
    L23:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L26;
        int r116 = c.f417711a;
        c.a("GroupInfoRepository updateName failed: " + r115.getMessage());
    L26:
        return r114;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        UpdateChatRequest.a r104 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r110, "chat_id");
        r104.f282336d = r110;
        r104.f282337e = r111;
        com.lark.kmp.rustclient.api.model.c r117 = new com.lark.kmp.rustclient.api.model.c(r104, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L21
        RustOutputKt$errorAsException$$inlined$map$1 r119 = i.a(this.f417703a.b(r117).a());     // Catch: Throwable -> L21
        r100.label = 1;     // Catch: Throwable -> L21
        r113 = kotlinx.coroutines.flow.e.s(r119, r100);     // Catch: Throwable -> L21
        if (r113 != r102) goto L19;
        return r102;
    L21:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new GroupInfoRepository$updateName$1(this, r112);
        goto L8
    }
}
