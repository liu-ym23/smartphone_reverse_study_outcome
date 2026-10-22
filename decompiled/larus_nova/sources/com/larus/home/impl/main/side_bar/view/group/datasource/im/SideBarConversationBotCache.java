package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes29.dex */
public final class SideBarConversationBotCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SideBarConversationBotCache f345314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, BotModel> f345315b = null;

    public SideBarConversationBotCache() {
    }

    static {
        f345314a = new SideBarConversationBotCache();
        f345315b = new ConcurrentHashMap();
    }

    public final Object a(List<wc9.e> r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof SideBarConversationBotCache$fetchMissing$1) == false) goto L7;
        SideBarConversationBotCache$fetchMissing$1 r100 = (SideBarConversationBotCache$fetchMissing$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SideBarConversationBotCache$fetchMissing$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        final List r113 = (List) r102.L$0;
        ResultKt.throwOnFailure(r112);
    L51:
        Map r114 = (Map) r112;
        if (r114 == null) goto L54;
        Ref.BooleanRef r105 = new Ref.BooleanRef();
        Iterator r115 = r114.entrySet().iterator();
    L57:
        if (r115.hasNext() == false) goto L62;
        Map.Entry r106 = (Map.Entry) r115.next();
        String r107 = (String) r106.getKey();
        BotModel r108 = (BotModel) CollectionsKt.firstOrNull((List) r106.getValue());
        if (r108 == null) goto L57;
        f345315b.put(r107, r108);
        r105.element = true;
        goto L57
    L62:
        FLogger.f375446a.i("SideBarConversationBotCache", "fetchMissing requested=" + r113.size() + " updated=" + r105.element);
        return Boxing.boxBoolean(r105.element);
    L54:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r110.iterator();
    L16:
        if (r117.hasNext() == false) goto L26;
        Object r109 = r117.next();
        Integer r118 = ((wc9.e) r109).f559207j;
        if (r118 != null) goto L21;
    L23:
        boolean r119 = false;
    L24:
        if (r119 == false) goto L16;
        r116.add(r109);
        goto L16
    L21:
        if (r118.intValue() != 3) goto L23;
        r119 = true;
        goto L24
    L26:
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r121 = r116.iterator();
    L28:
        if (r121.hasNext() == false) goto L30;
        r120.add(((wc9.e) r121.next()).f559198a);
        goto L28
    L30:
        ArrayList r122 = new ArrayList();
        Iterator r123 = r120.iterator();
    L32:
        if (r123.hasNext() == false) goto L44;
        Object r124 = r123.next();
        String r125 = (String) r124;
        if (r125.length() <= 0) goto L36;
        boolean r126 = true;
    L37:
        if (r126 == true) goto L39;
    L41:
        boolean r127 = false;
    L42:
        if (r127 == false) goto L32;
        r122.add(r124);
        goto L32
    L39:
        if (f345315b.containsKey(r125) == true) goto L41;
        r127 = true;
        goto L42
    L36:
        r126 = false;
        goto L37
    L44:
        r113 = CollectionsKt.distinct(r122);
        if (r113.isEmpty() == true) goto L47;
        String r128 = "requested=" + r113.size();
        Function1 r129 = new i0(r113);
        r102.L$0 = r113;
        r102.label = 1;
        r112 = p.a(2500, "query_bot", r128, r129, r102);
        if (r112 != r103) goto L51;
        return r103;
    L47:
        return Boxing.boxBoolean(false);
    L7:
        r100 = new SideBarConversationBotCache$fetchMissing$1(this, r111);
        goto L8
    }
}
