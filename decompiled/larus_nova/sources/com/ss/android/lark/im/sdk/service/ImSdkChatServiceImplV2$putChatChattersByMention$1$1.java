package com.ss.android.lark.im.sdk.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.chats.PutChatChatterByMentionResponse;
import com.ss.android.lark.pb.chats.PutChatChatterByMentionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "Lcom/ss/android/lark/pb/chats/PutChatChatterByMentionResponse;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImSdkChatServiceImplV2$putChatChattersByMention$1$1 extends Lambda implements Function1<PutChatChatterByMentionResponse, List<? extends String>> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<Long> $requestedChatterIds;
    final /* synthetic */ String $triggerMessageId;

    public ImSdkChatServiceImplV2$putChatChattersByMention$1$1(List<Long> r100, String r101, String r102) {
        this.$requestedChatterIds = r100;
        this.$chatId = r101;
        this.$triggerMessageId = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2(PutChatChatterByMentionResponse r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        Map<Long, PutChatChatterByMentionResult> r111 = r110.mresults;
        if (r111 != null) goto L5;
        r111 = MapsKt.emptyMap();
    L5:
        List<Long> r100 = this.$requestedChatterIds;
        Intrinsics.checkNotNullParameter(r100, "requestedChatterIds");
        Intrinsics.checkNotNullParameter(r111, "results");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        int r103 = 0;
        if (r102.hasNext() == false) goto L27;
        long r104 = ((Number) r102.next()).longValue();
        PutChatChatterByMentionResult r105 = r111.get(Long.valueOf(r104));
        String r106 = String.valueOf(r104);
        if (r105 == null) goto L16;
        Long r107 = r105.mchatter_id;
        if (r107 == null) goto L16;
        if (r107.longValue() != r104) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == true) goto L19;
    L21:
        if (r103 != 0) goto L24;
        r106 = null;
    L24:
        if (r106 == null) goto L6;
        r101.add(r106);
        goto L6
    L19:
        if (Intrinsics.areEqual(r105.mjoin_result, Boolean.TRUE) == false) goto L21;
        r103 = 1;
    L16:
        r108 = false;
        goto L17
    L27:
        if (r111.isEmpty() == true) goto L35;
        Iterator<Map.Entry<Long, PutChatChatterByMentionResult>> r109 = r111.entrySet().iterator();
    L31:
        if (r109.hasNext() == false) goto L35;
        Map.Entry<Long, PutChatChatterByMentionResult> r112 = r109.next();
        if ((!Intrinsics.areEqual(r112.getValue().mchatter_id, r112.getKey())) == false) goto L31;
        r103 = r103 + 1;
    L35:
        Log.i("MentionAgentTrace", "PUT rsp chat=" + this.$chatId + " msg=" + this.$triggerMessageId + " entries=" + r111.size() + " joined=" + r101.size() + " mismatch=" + r103);
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends String> invoke(PutChatChatterByMentionResponse r100) {
        return invoke2(r100);
    }
}
