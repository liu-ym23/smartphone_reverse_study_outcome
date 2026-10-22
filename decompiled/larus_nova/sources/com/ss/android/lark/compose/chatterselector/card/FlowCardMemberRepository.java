package com.ss.android.lark.compose.chatterselector.card;

import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.contact.v1.MGetChattersRequest;
import com.lark.kmp.pb.contact.v1.MGetChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$$inlined$map$1;
import com.lark.kmp.rustclient.api.model.c;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.rustclient.api.model.k;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes35.dex */
public final class FlowCardMemberRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f417555a;

    public FlowCardMemberRepository(d r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f417555a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(List<String> r110, String r111, Continuation<? super List<ChatChatter>> r112) {
        if ((r112 instanceof FlowCardMemberRepository$fetchSelectedChatters$1) == false) goto L7;
        FlowCardMemberRepository$fetchSelectedChatters$1 r100 = (FlowCardMemberRepository$fetchSelectedChatters$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r111 = (String) r100.L$1;
        r110 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L21:
        Map<String, Chatter> r114 = ((MGetChattersResponse) ((k) r113).f282482b).getEntity().getChatters();
        ArrayList r104 = new ArrayList();
        Iterator<T> r115 = r110.iterator();
    L23:
        if (r115.hasNext() == false) goto L27;
        Chatter r105 = r114.get((String) r115.next());
        if (r105 == null) goto L23;
        r104.add(r105);
        goto L23
    L27:
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r117 = r104.iterator();
    L29:
        if (r117.hasNext() == false) goto L56;
        Chatter r106 = (Chatter) r117.next();
        com.ss.android.lark.chat.entity.chatter.Chatter r107 = new com.ss.android.lark.chat.entity.chatter.Chatter();
        r107.setId(r106.getId());
        r107.setName(r106.getName());
        String r108 = r106.getLocalized_name();
        if (r108 != null) goto L33;
    L37:
        r108 = r106.getName();
    L38:
        r107.setLocalizedName(r108);
        String r109 = r106.getAlias();
        String r118 = "";
        if (r109 != null) goto L41;
        r109 = "";
    L41:
        r107.setAlias(r109);
        String r119 = r106.getAvatar_key();
        if (r119 == null) goto L45;
        r118 = r119;
    L45:
        r107.setAvatarKey(r118);
        r107.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.valueOf(r106.getType().getValue()));
        ChatChatter r120 = new ChatChatter(r107);
        if (r111 != null) goto L48;
    L51:
        boolean r121 = true;
    L52:
        if (r121 == true) goto L54;
        r120.setChatId(r111);
    L54:
        r116.add(r120);
        goto L29
    L48:
        if (StringsKt.isBlank(r111) == true) goto L51;
        r121 = false;
        goto L52
    L33:
        if (Boolean.valueOf(!StringsKt.isBlank(r108)).booleanValue() == true) goto L36;
        r108 = null;
    L36:
        if (r108 != null) goto L38;
    L56:
        return CollectionsKt.toMutableList(r116);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110.isEmpty() == true) goto L17;
        MGetChattersRequest.a r122 = new MGetChattersRequest.a();
        Intrinsics.checkNotNullParameter(r110, "chatter_ids");
        com.lark.wire.internal.a.a(r110);
        r122.f282223d = r110;
        r122.f282224e = Boxing.boxBoolean(true);
        RustOutputKt$errorAsException$$inlined$map$1 r123 = i.a(this.f417555a.b(new c(r122, MGetChattersResponse.ADAPTER, Command.MGET_CHATTERS, null, 120)).a());
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.label = 1;
        r113 = e.s(r123, r100);
        if (r113 != r102) goto L21;
        return r102;
    L17:
        return new ArrayList();
    L7:
        r100 = new FlowCardMemberRepository$fetchSelectedChatters$1(this, r112);
        goto L8
    }
}
