package com.ss.android.lark.im.sdk.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.chats.CheckPutChatChatterResponse;
import com.ss.android.lark.pb.chats.CheckPutChatChatterResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "Lcom/ss/android/lark/pb/chats/CheckPutChatChatterResponse;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImSdkChatServiceImplV2$checkMentionBotInvitableIds$1$1 extends Lambda implements Function1<CheckPutChatChatterResponse, List<? extends String>> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ LinkedHashMap<Long, String> $requestedBotIds;

    public ImSdkChatServiceImplV2$checkMentionBotInvitableIds$1$1(LinkedHashMap<Long, String> r100, String r101) {
        this.$requestedBotIds = r100;
        this.$chatId = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2(CheckPutChatChatterResponse r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        Map<Long, CheckPutChatChatterResult> r111 = r110.mresults;
        if (r111 != null) goto L5;
        r111 = MapsKt.emptyMap();
    L5:
        LinkedHashMap<Long, String> r100 = this.$requestedBotIds;
        Intrinsics.checkNotNullParameter(r100, "requestedBotIds");
        Intrinsics.checkNotNullParameter(r111, "results");
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<Long, String>> r102 = r100.entrySet().iterator();
    L6:
        boolean r103 = true;
        int r104 = 0;
        if (r102.hasNext() == false) goto L25;
        Map.Entry<Long, String> r105 = r102.next();
        long r106 = r105.getKey().longValue();
        String r107 = r105.getValue();
        CheckPutChatChatterResult r108 = r111.get(Long.valueOf(r106));
        if (r108 == null) goto L16;
        Long r109 = r108.mchatter_id;
        if (r109 == null) goto L16;
        if (r109.longValue() != r106) goto L16;
    L17:
        if (r103 == true) goto L19;
    L21:
        r107 = null;
    L22:
        if (r107 == null) goto L6;
        r101.add(r107);
        goto L6
    L19:
        if (Intrinsics.areEqual(r108.mcheck_result, Boolean.TRUE) == false) goto L21;
    L16:
        r103 = false;
        goto L17
    L25:
        if (r111.isEmpty() == false) goto L27;
        int r112 = 0;
    L33:
        StringBuilder r113 = new StringBuilder("CHECK rsp chat=");
        r113.append(this.$chatId);
        r113.append(" entries=");
        r113.append(r111.size());
        r113.append(" pass=");
        Collection<CheckPutChatChatterResult> r114 = r111.values();
        if ((r114 instanceof Collection) == true) goto L36;
    L38:
        Iterator<T> r115 = r114.iterator();
    L40:
        if (r115.hasNext() == false) goto L46;
        if (Intrinsics.areEqual(((CheckPutChatChatterResult) r115.next()).mcheck_result, Boolean.TRUE) == false) goto L40;
        r104 = r104 + 1;
        if (r104 >= 0) goto L40;
        CollectionsKt.throwCountOverflow();
    L46:
        r113.append(r104);
        r113.append(" allowed=");
        r113.append(r101.size());
        r113.append(" mismatch=");
        r113.append(r112);
        Log.i("MentionAgentTrace", r113.toString());
        return r101;
    L36:
        if (r114.isEmpty() == false) goto L38;
    L27:
        Iterator<Map.Entry<Long, CheckPutChatChatterResult>> r116 = r111.entrySet().iterator();
        r112 = 0;
    L29:
        if (r116.hasNext() == false) goto L33;
        Map.Entry<Long, CheckPutChatChatterResult> r117 = r116.next();
        if ((!Intrinsics.areEqual(r117.getValue().mchatter_id, r117.getKey())) == false) goto L29;
        r112 = r112 + 1;
        goto L29
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends String> invoke(CheckPutChatChatterResponse r100) {
        return invoke2(r100);
    }
}
