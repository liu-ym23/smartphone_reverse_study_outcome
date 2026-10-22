package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.memorydata.sdk.proactive.ProactiveAllPageSnapshot;
import com.obric.memorydata.sdk.proactive.ProactiveDayHeaderDto;
import com.obric.memorydata.sdk.proactive.ProactiveDayPageResult;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import com.obric.memorydata.sdk.proactive.ProactiveRecommendationDto;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class ProactiveAgentRepository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f387462b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f387463a;

    public static final class a {
    }

    static {
    }

    public ProactiveAgentRepository(Context r100) {
        if (r100 == null) goto L5;
        Context r101 = r100.getApplicationContext();
    L6:
        this.f387463a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final n d(g5 r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        l5 r101 = e.f387469a;
        ProactiveLabelingFeedbackConfigDto r102 = new ProactiveLabelingFeedbackConfigDto(i.a().f387364g, i.a().f387365h, i.a().f387366i);
        Context r103 = this.f387463a;
        if (r103 != null) goto L7;
        return new n(CollectionsKt.emptyList(), r102);
    L7:
        return (n) BuildersKt.runBlocking$default(null, new ProactiveAgentRepository$loadSnapshot$1(r103, r102, r100, this, null), 1, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009b -> B:22:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c1 -> B:27:0x00c7). Please report as a decompilation issue!!! */
    public static final Object b(ProactiveAgentRepository r110, g5 r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1) == false) goto L7;
        ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1 r100 = (ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        int r115 = r100.I$0;
        String r103 = (String) r100.L$3;
        Iterator r104 = (Iterator) r100.L$2;
        LinkedHashMap r105 = (LinkedHashMap) r100.L$1;
        g5 r106 = (g5) r100.L$0;
        ResultKt.throwOnFailure(r113);
        ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1 r116 = r100;
        Object r107 = r114;
        String r117 = r103;
        ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1 r108 = r116;
    L27:
        ProactiveDayPageResult r118 = (ProactiveDayPageResult) r113;
        List<ProactiveRecommendationDto> r109 = r118.f397158d;
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r109.iterator();
    L29:
        if (r120.hasNext() == false) goto L38;
        Object r121 = r120.next();
        ProactiveRecommendationDto r122 = (ProactiveRecommendationDto) r121;
        if (m.b(r122) == true) goto L33;
    L35:
        boolean r123 = false;
    L36:
        if (r123 == false) goto L29;
        r119.add(r121);
        goto L29
    L33:
        if (m.a(r106, r122.f397179j) == false) goto L35;
        r123 = true;
        goto L36
    L38:
        Iterator r124 = r119.iterator();
    L40:
        if (r124.hasNext() == false) goto L42;
        ProactiveRecommendationDto r125 = (ProactiveRecommendationDto) r124.next();
        r105.put(m.e(r125), r125);
        goto L40
    L42:
        int r126 = r115 + r118.f397158d.size();
        if (r118.f397157c == true) goto L45;
    L47:
        boolean r127 = false;
    L48:
        g5 r128 = r106;
        boolean r129 = r127;
        LinkedHashMap r130 = r105;
        String r131 = r117;
        int r132 = r126;
        r111 = r128;
    L22:
        if (r129 == false) goto L49;
        ska.b r133 = ska.b.f542436a;
        r108.L$0 = r111;
        r108.L$1 = r130;
        r108.L$2 = r104;
        r108.L$3 = r131;
        r108.I$0 = r132;
        r108.label = 1;
        ProactiveDayPageResult r134 = ska.b.c(r133, 0, r131, r132);
        if (r134 == r107) goto L64;
        String r135 = r131;
        r105 = r130;
        r113 = r134;
        r106 = r111;
        r115 = r132;
        r117 = r135;
        goto L27
    L64:
        return r107;
    L49:
        r114 = r107;
        r100 = r108;
        Iterator r136 = r104;
    L20:
        if (r136.hasNext() == false) goto L50;
        r131 = (String) r136.next();
        r129 = true;
        r104 = r136;
        r108 = r100;
        r107 = r114;
        r132 = 0;
        goto L22
    L50:
        Collection r137 = r130.values();
        ArrayList r138 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r137, 10));
        Iterator r139 = r137.iterator();
    L52:
        if (r139.hasNext() == false) goto L55;
        ProactiveRecommendationDto r140 = (ProactiveRecommendationDto) r139.next();
        Intrinsics.checkNotNull(r140);
        r138.add(m.f(r140));
        goto L52
    L55:
        return CollectionsKt.sortedWith(r138, new p(new o()));
    L45:
        if ((!r118.f397158d.isEmpty()) == false) goto L47;
        r127 = true;
        goto L48
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r130 = new LinkedHashMap();
        h5 r141 = g5.a(r111);
        ZoneId r142 = ZoneId.systemDefault();
        LocalDate r143 = Instant.ofEpochMilli(r141.f387304b).atZone(r142).toLocalDate();
        LocalDate r144 = Instant.ofEpochMilli(r141.f387303a).atZone(r142).toLocalDate();
        ArrayList r145 = new ArrayList();
    L16:
        if (r143.isBefore(r144) == true) goto L18;
        r145.add(r143.toString());
        r143 = r143.minusDays(1);
        goto L16
    L18:
        r136 = r145.iterator();
    L7:
        r100 = new ProactiveAgentRepository$loadRecommendationsWithoutSnapshot$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:20:0x0079). Please report as a decompilation issue!!! */
    public final Object c(long r110, String r210, Continuation<? super List<ProactiveRecommendationDto>> r211) {
        if ((r211 instanceof ProactiveAgentRepository$loadPagedDayRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadPagedDayRecommendations$1 r100 = (ProactiveAgentRepository$loadPagedDayRecommendations$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r100.I$0;
        long r106 = r100.J$0;
        List r107 = (List) r100.L$1;
        String r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r108 = r103;
        String r109 = r111;
        List r112 = r107;
    L20:
        ProactiveDayPageResult r113 = (ProactiveDayPageResult) r102;
        long r114 = r113.f397155a;
        if (r114 != 0) goto L23;
    L25:
        CollectionsKt.addAll(r112, r113.f397158d);
        int r115 = r105 + r113.f397158d.size();
        if (r113.f397157c == true) goto L28;
    L30:
        boolean r116 = false;
    L31:
        List r117 = r112;
        boolean r118 = r116;
        ProactiveAgentRepository$loadPagedDayRecommendations$1 r119 = r100;
        long r120 = r106;
        Object r121 = r108;
        List r122 = r117;
        int r123 = r115;
    L15:
        if (r118 == false) goto L32;
        ska.b r124 = ska.b.f542436a;
        r119.L$0 = r109;
        r119.L$1 = r122;
        r119.J$0 = r120;
        r119.I$0 = r123;
        r119.label = 1;
        ProactiveDayPageResult r125 = ska.b.c(r124, r120, r109, r123);
        if (r125 != r121) goto L19;
        return r121;
    L19:
        long r126 = r120;
        r100 = r119;
        r105 = r123;
        r102 = r125;
        r112 = r122;
        r108 = r121;
        r106 = r126;
        goto L20
    L32:
        return r122;
    L28:
        if ((!r113.f397158d.isEmpty()) == false) goto L30;
        r116 = true;
        goto L31
    L23:
        if (r114 == r106) goto L25;
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r122 = new ArrayList();
        r119 = r100;
        r121 = r103;
        r123 = 0;
        r118 = true;
        r120 = r110;
        r109 = r210;
    L7:
        r100 = new ProactiveAgentRepository$loadPagedDayRecommendations$1(this, r211);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0072 -> B:20:0x0077). Please report as a decompilation issue!!! */
    public final Object e(ProactiveAllPageSnapshot r110, ProactiveDayHeaderDto r111, Continuation<? super List<ProactiveRecommendationDto>> r112) {
        if ((r112 instanceof ProactiveAgentRepository$loadTodayRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadTodayRecommendations$1 r100 = (ProactiveAgentRepository$loadTodayRecommendations$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r114 = r100.I$0;
        List r115 = (List) r100.L$2;
        ProactiveDayHeaderDto r104 = (ProactiveDayHeaderDto) r100.L$1;
        ProactiveAllPageSnapshot r105 = (ProactiveAllPageSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r113);
        int r106 = r114;
        r110 = r105;
        Object r107 = r102;
        ProactiveAgentRepository$loadTodayRecommendations$1 r108 = r100;
        ProactiveDayHeaderDto r109 = r104;
    L20:
        ProactiveDayPageResult r116 = (ProactiveDayPageResult) r113;
        long r117 = r116.f397155a;
        if (r117 != 0) goto L23;
    L25:
        CollectionsKt.addAll(r115, r116.f397158d);
        r106 = r106 + r116.f397158d.size();
        if (r116.f397157c == true) goto L28;
    L30:
        boolean r118 = false;
    L31:
        Object r119 = r107;
        boolean r120 = r118;
        ProactiveDayHeaderDto r121 = r109;
        r100 = r108;
        r102 = r119;
    L15:
        if (r120 == false) goto L32;
        ska.b r122 = ska.b.f542436a;
        long r123 = r110.f397148a;
        String r124 = r121.f397152a;
        r100.L$0 = r110;
        r100.L$1 = r121;
        r100.L$2 = r115;
        r100.I$0 = r106;
        r100.label = 1;
        ProactiveDayPageResult r125 = ska.b.c(r122, r123, r124, r106);
        if (r125 != r102) goto L19;
        return r102;
    L19:
        ProactiveAgentRepository$loadTodayRecommendations$1 r126 = r100;
        r109 = r121;
        r113 = r125;
        r107 = r102;
        r108 = r126;
    L32:
        return r115;
    L28:
        if ((!r116.f397158d.isEmpty()) == false) goto L30;
        r118 = true;
        goto L31
    L23:
        if (r117 == r110.f397148a) goto L25;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        List r127 = CollectionsKt.toMutableList(r110.f397150c);
        r106 = r127.size();
        r120 = r110.f397151d;
        r121 = r111;
        r115 = r127;
    L7:
        r100 = new ProactiveAgentRepository$loadTodayRecommendations$1(this, r112);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d1 -> B:23:0x00d7). Please report as a decompilation issue!!! */
    public final Object f(ProactiveAllPageSnapshot r110, g5 r210, h5 r211, Continuation<? super List<ProactiveRecommendationDto>> r212) {
        ProactiveAllPageSnapshot r100 = r110;
        if ((r212 instanceof ProactiveAgentRepository$loadWindowRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadWindowRecommendations$1 r101 = (ProactiveAgentRepository$loadWindowRecommendations$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r101.I$0;
        List r107 = (List) r101.L$3;
        h5 r108 = (h5) r101.L$2;
        g5 r109 = (g5) r101.L$1;
        ProactiveAllPageSnapshot r111 = (ProactiveAllPageSnapshot) r101.L$0;
        ResultKt.throwOnFailure(r103);
        List r112 = r107;
        int r113 = r106;
        r100 = r111;
        ProactiveAgentRepository$loadWindowRecommendations$1 r114 = r101;
        h5 r115 = r108;
        Object r116 = r104;
    L23:
        ProactiveDayPageResult r117 = (ProactiveDayPageResult) r103;
        long r118 = r117.f397155a;
        if (r118 != 0) goto L26;
    L28:
        CollectionsKt.addAll(r112, r117.f397158d);
        r113 = r113 + r117.f397158d.size();
        if (r117.f397157c == false) goto L34;
        if ((!r117.f397158d.isEmpty()) == false) goto L34;
        boolean r119 = true;
    L35:
        g5 r120 = r109;
        List r121 = r112;
    L15:
        if (r119 == false) goto L37;
        ska.b r122 = ska.b.f542436a;
        long r123 = r100.f397148a;
        long r124 = r115.f387303a;
        long r125 = r115.f387304b;
        r114.L$0 = r100;
        r114.L$1 = r120;
        r114.L$2 = r115;
        r114.L$3 = r121;
        r114.I$0 = r113;
        r114.label = 1;
        r122.getClass();
        String r126 = ska.b.a("loadAiProactiveRecommendationsPage", "requestJson", new JSONObject().put("batchId", r123).put("earliestTimeMillis", r124).put("latestTimeMillis", r125).put("offset", r113).put(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, 50).toString());
        if (r126 == null) goto L19;
        ProactiveDayPageResult r127 = ska.b.f(r126);
    L20:
        if (r127 != r116) goto L22;
        return r116;
    L22:
        List r128 = r121;
        r109 = r120;
        r103 = r127;
        r112 = r128;
        goto L23
    L19:
        r127 = new ProactiveDayPageResult(r123, LiveEndPageData.TAG_WINDOW, false, CollectionsKt.emptyList());
    L37:
        ArrayList r129 = new ArrayList();
        Iterator r130 = r121.iterator();
    L39:
        if (r130.hasNext() == false) goto L48;
        Object r131 = r130.next();
        ProactiveRecommendationDto r132 = (ProactiveRecommendationDto) r131;
        if (m.b(r132) == true) goto L43;
    L45:
        boolean r133 = false;
    L46:
        if (r133 == false) goto L39;
        r129.add(r131);
        goto L39
    L43:
        if (m.a(r120, r132.f397179j) == false) goto L45;
        r133 = true;
        goto L46
    L48:
        HashSet r134 = new HashSet();
        ArrayList r135 = new ArrayList();
        Iterator r136 = r129.iterator();
    L50:
        if (r136.hasNext() == false) goto L54;
        Object r137 = r136.next();
        if (r134.add(m.e((ProactiveRecommendationDto) r137)) == false) goto L50;
        r135.add(r137);
        goto L50
    L54:
        return r135;
    L34:
        r119 = false;
        goto L35
    L26:
        if (r118 == r100.f397148a) goto L28;
        r120 = r109;
        r121 = r112;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        List r138 = CollectionsKt.toMutableList(r100.f397150c);
        r113 = r138.size();
        r121 = r138;
        r119 = r100.f397151d;
        r120 = r210;
        r116 = r104;
        r114 = r101;
        r115 = r211;
    L7:
        r101 = new ProactiveAgentRepository$loadWindowRecommendations$1(this, r212);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0167 -> B:67:0x016f). Please report as a decompilation issue!!! */
    public static final Object a(ProactiveAgentRepository r210, ProactiveAllPageSnapshot r211, g5 r212, h5 r213, boolean r214, Continuation r215) {
        ProactiveAllPageSnapshot r100 = r211;
        r210.getClass();
        if ((r215 instanceof ProactiveAgentRepository$loadRecommendations$1) == false) goto L7;
        ProactiveAgentRepository$loadRecommendations$1 r101 = (ProactiveAgentRepository$loadRecommendations$1) r215;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        Iterator r106 = (Iterator) r101.L$4;
        LinkedHashMap r107 = (LinkedHashMap) r101.L$3;
        String r108 = (String) r101.L$2;
        g5 r110 = (g5) r101.L$1;
        ProactiveAllPageSnapshot r111 = (ProactiveAllPageSnapshot) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L67:
        List r109 = (List) r103;
    L62:
        String r216 = r108;
        Iterator r112 = r106;
        r100 = r111;
        String r113 = r216;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r109.iterator();
    L70:
        if (r115.hasNext() == false) goto L79;
        Object r116 = r115.next();
        ProactiveRecommendationDto r117 = (ProactiveRecommendationDto) r116;
        if (m.b(r117) == true) goto L74;
    L76:
        boolean r118 = false;
    L77:
        if (r118 == false) goto L70;
        r114.add(r116);
        goto L70
    L74:
        if (m.a(r110, r117.f397179j) == false) goto L76;
        r118 = true;
        goto L77
    L79:
        Iterator r119 = r114.iterator();
    L81:
        if (r119.hasNext() == false) goto L83;
        ProactiveRecommendationDto r120 = (ProactiveRecommendationDto) r119.next();
        r107.put(m.e(r120), r120);
        goto L81
    L83:
        g5 r121 = r110;
    L54:
        if (r112.hasNext() == false) goto L85;
        ProactiveDayHeaderDto r122 = (ProactiveDayHeaderDto) r112.next();
        if (Intrinsics.areEqual(r122.f397152a, r113) == false) goto L63;
        r101.L$0 = r100;
        r101.L$1 = r121;
        r101.L$2 = r113;
        r101.L$3 = r107;
        r101.L$4 = r112;
        r101.label = 2;
        Object r123 = r210.e(r100, r122, r101);
        if (r123 == r104) goto L100;
        r110 = r121;
        String r217 = r113;
        r111 = r100;
        r106 = r112;
        r108 = r217;
        r109 = (List) r123;
        goto L62
    L100:
        return r104;
    L63:
        long r124 = r100.f397148a;
        String r125 = r122.f397152a;
        r101.L$0 = r100;
        r101.L$1 = r121;
        r101.L$2 = r113;
        r101.L$3 = r107;
        r101.L$4 = r112;
        r101.label = 3;
        Object r126 = r210.c(r124, r125, r101);
        if (r126 == r104) goto L101;
        r110 = r121;
        r103 = r126;
        String r218 = r113;
        r111 = r100;
        r106 = r112;
        r108 = r218;
        goto L67
    L101:
        return r104;
    L85:
        return CollectionsKt.toList(r107.values());
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r106 = (Iterator) r101.L$4;
        r107 = (LinkedHashMap) r101.L$3;
        r108 = (String) r101.L$2;
        r110 = (g5) r101.L$1;
        r111 = (ProactiveAllPageSnapshot) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r109 = (List) r103;
        goto L62
    L17:
        ResultKt.throwOnFailure(r103);
    L98:
        return r103;
    L18:
        ResultKt.throwOnFailure(r103);
        if (r214 == false) goto L24;
        r101.label = 1;
        r103 = r210.f(r100, r212, r213, r101);
        if (r103 != r104) goto L98;
        return r104;
    L24:
        r121 = r212;
        Iterator<T> r127 = r100.f397149b.iterator();
        r113 = null;
        if (r127.hasNext() == true) goto L27;
        Object r128 = null;
    L37:
        ProactiveDayHeaderDto r129 = (ProactiveDayHeaderDto) r128;
        if (r129 == null) goto L40;
        r113 = r129.f397152a;
    L40:
        List<ProactiveDayHeaderDto> r130 = r100.f397149b;
        ArrayList r131 = new ArrayList();
        Iterator<T> r132 = r130.iterator();
    L42:
        if (r132.hasNext() == false) goto L52;
        Object r133 = r132.next();
        long r134 = ((ProactiveDayHeaderDto) r133).f397153b;
        if (((r134 + 86400000) - 1) >= r213.f387303a) goto L46;
    L48:
        boolean r135 = false;
    L49:
        if (r135 == false) goto L42;
        r131.add(r133);
        goto L42
    L46:
        if (r134 > r213.f387304b) goto L48;
        r135 = true;
        goto L49
    L52:
        r107 = new LinkedHashMap();
        r112 = r131.iterator();
        goto L54
    L27:
        r128 = r127.next();
        if (r127.hasNext() == false) goto L37;
        long r136 = ((ProactiveDayHeaderDto) r128).f397153b;
    L31:
        Object r137 = r127.next();
        Object r219 = r128;
        long r138 = ((ProactiveDayHeaderDto) r137).f397153b;
        if (r136 >= r138) goto L34;
        r136 = r138;
        r128 = r137;
    L36:
        if (r127.hasNext() == true) goto L31;
    L34:
        r128 = r219;
    L7:
        r101 = new ProactiveAgentRepository$loadRecommendations$1(r210, r215);
        goto L8
    }
}
