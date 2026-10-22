package com.ss.android.lark.compose.groupqrcode.repository;

import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.contact.v1.MGetChattersRequest;
import com.lark.kmp.pb.contact.v1.MGetChattersResponse;
import com.lark.kmp.pb.im.v1.GetChatQRCodeTokenRequest;
import com.lark.kmp.pb.im.v1.GetChatQRCodeTokenResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$$inlined$map$1;
import com.lark.kmp.rustclient.api.model.c;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.rustclient.api.model.k;
import f8b.a;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes35.dex */
public final class GroupQrCodeRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f417729a;

    public GroupQrCodeRepository(d r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f417729a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, Continuation<? super Result<Chatter>> r111) {
        if ((r111 instanceof GroupQrCodeRepository$fetchGroupOwner$1) == false) goto L7;
        GroupQrCodeRepository$fetchGroupOwner$1 r100 = (GroupQrCodeRepository$fetchGroupOwner$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L17;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L14
    L22:
        Object r113 = Result.m9449constructorimpl(((MGetChattersResponse) ((k) r112).f282482b).getEntity().getChatters().get(r110));     // Catch: Throwable -> L14
    L25:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r113);
        if (r104 == null) goto L28;
        int r105 = a.f475936a;
        a.a("GroupQrCodeRepository fetchGroupOwner error for ownerId: " + r110 + ", message: " + r104.getMessage());
    L28:
        return r113;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        MGetChattersRequest.a r106 = new MGetChattersRequest.a();
        List<String> r114 = CollectionsKt.listOf(r110);
        Intrinsics.checkNotNullParameter(r114, "chatter_ids");
        com.lark.wire.internal.a.a(r114);
        r106.f282223d = r114;
        r106.f282224e = Boxing.boxBoolean(true);
        c r115 = new c(r106, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, 120);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        RustOutputKt$errorAsException$$inlined$map$1 r116 = i.a(this.f417729a.b(r115).a());     // Catch: Throwable -> L14
        r100.L$0 = r110;     // Catch: Throwable -> L14
        r100.label = 1;     // Catch: Throwable -> L14
        r112 = e.s(r116, r100);     // Catch: Throwable -> L14
        if (r112 != r102) goto L22;
        return r102;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new GroupQrCodeRepository$fetchGroupOwner$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r110, int r111, boolean r112, Continuation<? super Result<GetChatQRCodeTokenResponse>> r113) {
        if ((r113 instanceof GroupQrCodeRepository$fetchQRCodeToken$1) == false) goto L7;
        GroupQrCodeRepository$fetchQRCodeToken$1 r100 = (GroupQrCodeRepository$fetchQRCodeToken$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L21
    L19:
        Object r115 = Result.m9449constructorimpl((GetChatQRCodeTokenResponse) ((k) r114).f282482b);     // Catch: Throwable -> L21
    L23:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L26;
        int r117 = a.f475936a;
        a.a("GroupQrCodeRepository fetchQRCodeToken error: " + r116.getMessage());
    L26:
        return r115;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r114);
        GetChatQRCodeTokenRequest.a r104 = new GetChatQRCodeTokenRequest.a();
        Intrinsics.checkNotNullParameter(r110, "chat_id");
        r104.f282301d = r110;
        r104.f282302e = Boxing.boxInt(r111);
        r104.f282303f = Boxing.boxBoolean(r112);
        c r118 = new c(r104, GetChatQRCodeTokenResponse.ADAPTER, Command.GET_CHAT_QRCODE_TOKEN, null, 120);
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L21
        RustOutputKt$errorAsException$$inlined$map$1 r120 = i.a(this.f417729a.b(r118).a());     // Catch: Throwable -> L21
        r100.label = 1;     // Catch: Throwable -> L21
        r114 = e.s(r120, r100);     // Catch: Throwable -> L21
        if (r114 != r102) goto L19;
        return r102;
    L21:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new GroupQrCodeRepository$fetchQRCodeToken$1(this, r113);
        goto L8
    }
}
