package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.s;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f302674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f302675b = null;

    public m() {
    }

    static {
        f302674a = new m();
        f302675b = ILegacyChatUiServiceDelegate.f297164b.t8();
    }

    public final Object a(String r210, String r211, ChatPageContext r212, com.larus.bmhome.chat.deepsearch.component.h r310, Continuation r311) {
        String r100 = r210;
        if ((r311 instanceof DeepSearchUtil$sendDeepSearchMessageFrom$1) == false) goto L7;
        DeepSearchUtil$sendDeepSearchMessageFrom$1 r101 = (DeepSearchUtil$sendDeepSearchMessageFrom$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        String r106 = (String) r101.L$5;
        String r107 = (String) r101.L$4;
        Function2 r108 = (Function2) r101.L$3;
        ChatPageContext r109 = (ChatPageContext) r101.L$2;
        String r110 = (String) r101.L$1;
        String r111 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        String r112 = r106;
        Function2 r113 = r108;
        ChatPageContext r213 = r109;
        String r114 = r110;
    L34:
        Message r115 = (Message) r103;
        if (r115 == null) goto L40;
        String r116 = r115.getContent();
        if (r116 == null) goto L40;
        u1 r117 = zh8.a.f572196a.getSender();
        String r118 = new JSONObject(r116).optString("text");
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put("source", "deep_search");
        r119.put("deep_search_from_id", r111);
        u1.a.f(r117, r118, r114, "deep_search", r119, r113, MessageStatus.MessageStatus_INVISIBLE, r112, false, null, "DeepSearchFragment#sendText", null, r213, null, false, 26888);
        FLogger.f375446a.d("DeepSearchUtil", "[biz_deep_search]deepSearchFromId : " + r111 + " , questionMsgID = " + r107);
    L40:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2 r120 = (Function2) r101.L$3;
        ChatPageContext r121 = (ChatPageContext) r101.L$2;
        String r122 = (String) r101.L$1;
        String r123 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Function2 r124 = r120;
        r100 = r123;
        ChatPageContext r125 = r121;
        String r126 = r122;
    L19:
        Message r127 = (Message) r103;
        if (r127 == null) goto L22;
        String r128 = r127.getReplyId();
    L23:
        String r129 = UUID.randomUUID().toString();
        s r130 = f302675b;
        if (r130 == null) goto L26;
        r130.d(r129);
    L26:
        IChatRepoService r131 = zh8.a.f572196a;
        if (r128 != null) goto L29;
        String r132 = "";
    L30:
        r101.L$0 = r100;
        r101.L$1 = r126;
        r101.L$2 = r125;
        r101.L$3 = r124;
        r101.L$4 = r128;
        r101.L$5 = r129;
        r101.label = 2;
        Object r133 = r131.E1(r132, r101);
        if (r133 != r104) goto L33;
        return r104;
    L33:
        r107 = r128;
        r103 = r133;
        r114 = r126;
        r112 = r129;
        r213 = r125;
        r113 = r124;
        r111 = r100;
        goto L34
    L29:
        r132 = r128;
        goto L30
    L22:
        r128 = null;
        goto L23
    L16:
        ResultKt.throwOnFailure(r103);
        IChatRepoService r134 = zh8.a.f572196a;
        r101.L$0 = r100;
        r126 = r211;
        r101.L$1 = r126;
        r125 = r212;
        r101.L$2 = r125;
        r124 = r310;
        r101.L$3 = r124;
        r101.label = 1;
        r103 = r134.E1(r100, r101);
        if (r103 != r104) goto L19;
        return r104;
    L7:
        r101 = new DeepSearchUtil$sendDeepSearchMessageFrom$1(this, r311);
        goto L8
    }
}
