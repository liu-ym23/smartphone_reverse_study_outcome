package com.larus.bot.impl.common.util;

import com.larus.bmhome.chat.bean.RecommendBot;
import ic8.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class RecommendBotHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecommendBotHelper f317671a = null;

    static {
        f317671a = new RecommendBotHelper();
    }

    public RecommendBotHelper() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:28:0x009a). Please report as a decompilation issue!!! */
    public final Object a(List<RecommendBot> r100, List<String> r110, Continuation<? super List<RecommendBot>> r111) {
        if ((r111 instanceof RecommendBotHelper$filterBotInConversationList$1) == false) goto L7;
        RecommendBotHelper$filterBotInConversationList$1 r101 = (RecommendBotHelper$filterBotInConversationList$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        Iterator r105 = (Iterator) r101.L$2;
        HashMap r113 = (HashMap) r101.L$1;
        List<RecommendBot> r106 = (List) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        List r114 = (List) r112;
        if (r114 == null) goto L24;
        String r115 = (String) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L24;
        r113.put(r115, Unit.INSTANCE);
    L24:
        if (r105.hasNext() == false) goto L33;
        wc9.e r116 = (wc9.e) r105.next();
        r101.L$0 = r106;
        r101.L$1 = r113;
        r101.L$2 = r105;
        r101.label = 2;
        r112 = n.c(r116, r101);
        if (r112 != r103) goto L28;
        return r103;
    L33:
        ArrayList r107 = new ArrayList();
        Iterator<T> r117 = r106.iterator();
    L35:
        if (r117.hasNext() == false) goto L45;
        Object r108 = r117.next();
        RecommendBot r109 = (RecommendBot) r108;
        if (r109.j0() == false) goto L39;
    L42:
        boolean r118 = true;
    L43:
        if (r118 == true) goto L35;
        r107.add(r108);
        goto L35
    L39:
        if (r113.containsKey(r109.o()) == true) goto L42;
        r118 = false;
        goto L43
    L45:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        HashMap r119 = (HashMap) r101.L$1;
        List<RecommendBot> r120 = (List) r101.L$0;
        ResultKt.throwOnFailure(r112);
        HashMap r121 = r119;
        r100 = r120;
        Object r122 = r112;
    L22:
        r106 = r100;
        r105 = ((Iterable) r122).iterator();
        r113 = r121;
        goto L24
    L16:
        ResultKt.throwOnFailure(r112);
        if (r100.isEmpty() == false) goto L19;
        return r100;
    L19:
        r121 = new HashMap();
        r101.L$0 = r100;
        r101.L$1 = r121;
        r101.label = 1;
        r122 = BuildersKt.withContext(Dispatchers.getIO(), new RecommendBotHelper$findConversations$2(r110, null), r101);
        if (r122 != r103) goto L22;
        return r103;
    L7:
        r101 = new RecommendBotHelper$filterBotInConversationList$1(this, r111);
        goto L8
    }
}
