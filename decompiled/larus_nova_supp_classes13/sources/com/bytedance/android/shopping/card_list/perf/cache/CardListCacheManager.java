package com.bytedance.android.shopping.card_list.perf.cache;

import cb3.b;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.error.a;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListFirstScreenPoint;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCacheManager {
    public static final /* synthetic */ int j = 0;
    public final CardListYataMonitorManager a;
    public final CacheMonitor b;
    public final a c;
    public final int d;
    public final LauncherBizType e;
    public final boolean f;
    public final Lazy g;
    public final String h;
    public final String i;

    public static final class Companion {
        public static boolean a(CacheMonitor r10, String r11, int r12, LauncherBizType r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r13, "bizType");
            if (r14 == true) goto L5;
            return false;
        L5:
            long r1 = System.currentTimeMillis();
            CardListRepository r15 = CardListRepository.INSTANCE;
            long r2 = r1 - r15.getResponseKeva().getLong("card_list_query_response_timestamp" + r13.name(), 0);
            long r3 = (long) (r12 * 1000);
            if (1 <= r2) goto L8;
        L20:
            String r4 = "cache_duration_invalid";
        L22:
            if (r4.length() != 0) goto L24;
            boolean r5 = true;
        L25:
            if (r5 == false) goto L27;
            return true;
        L27:
            r15.getResponseKeva().erase("card_list_query_response" + r13.name());
            if (r10 == null) goto L32;
            if (r11 != null) goto L31;
            r11 = "";
        L31:
            CacheMonitor.a(r10, r4, r11, r15.getResponseKeva().getString("card_list_cache_source" + r13.name(), ""));
        L32:
            return false;
        L24:
            r5 = false;
            goto L25
        L8:
            if (r3 < r2) goto L20;
            if (r15.getResponseKeva().contains("card_list_query_response" + r13.name()) == true) goto L14;
            r4 = "cache_response_empty";
            goto L22
        L14:
            if ((!Intrinsics.areEqual(r15.getResponseKeva().getString("card_list_uid" + r13.name(), ""), r.a.getCurrentUserId())) == false) goto L17;
            r4 = "cache_not_current_user";
            goto L22
        L17:
            if ((!Intrinsics.areEqual(r15.getResponseKeva().getString("card_list_biz_type" + r13.name(), ""), r13.name())) == false) goto L19;
            r4 = "cache_not_current_biz_type";
            goto L22
        L19:
            r4 = "";
            goto L22
        }

        public static void b(String r9, String r10, String r11, LauncherBizType r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "responseBody");
            Intrinsics.checkNotNullParameter(r12, "bizType");
            if (r13 == true) goto L5;
            return;
        L5:
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CardListCacheManager$Companion$setResponse$1(r9, r10, r12, r11, null), 3, null);
        }
    }

    static {
    }

    public final void a() {
        if (this.f == true) goto L5;
        return;
    L5:
        CardListRepository r0 = CardListRepository.INSTANCE;
        Pair<LauncherBizType, e> r1 = r0.getCacheResponse();
        if (r1 == null) goto L8;
        LauncherBizType r2 = (LauncherBizType) r1.getFirst();
    L10:
        if (r2 != this.e) goto L19;
        Pair<LauncherBizType, e> r3 = r0.getCacheResponse();
        if (r3 == null) goto L14;
        e r4 = (e) r3.getSecond();
    L15:
        if (r4 == null) goto L19;
        if (((Boolean) this.g.getValue()).booleanValue() == false) goto L19;
        b();
        int r5 = b.a;
        b.a(r0.getCacheResponse());
        return;
    L14:
        r4 = null;
    L19:
        Map<String, Map<String, Long>> r6 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(this.h, "GetCacheResponse");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CardListCacheManager$getCacheResponse$1(this, null), 3, null);
        return;
    L8:
        r2 = null;
        goto L10
    }

    public final void b() {
        CardListYataMonitorManager r0 = this.a;
        if (r0 == null) goto L7;
        CardListYataFirstScreenDurationMonitor r1 = r0.d;
        if (r1 == null) goto L7;
        CardListYataFirstScreenDurationMonitor.b(r1, CardListFirstScreenPoint.REQUEST_END);
    L7:
        CardListYataMonitorManager r2 = this.a;
        if (r2 == null) goto L13;
        CardListYataFirstScreenDurationMonitor r3 = r2.d;
        if (r3 == null) goto L14;
        CardListYataFirstScreenDurationMonitor.b(r3, CardListFirstScreenPoint.RENDER_START);
        return;
    L14:
        return;
    }

    public CardListCacheManager(String r6, String r7, String r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r6, "sessionId");
        this.h = r6;
        this.i = r7;
        Map<String, CardListYataMonitorManager> r10 = CardListYataMonitorManager.k;
        CardListYataMonitorManager r11 = CardListYataMonitorManager.a.a(r8);
        this.a = r11;
        LauncherBizType r12 = null;
        if (r11 == null) goto L5;
        CacheMonitor r13 = r11.i;
    L6:
        this.b = r13;
        if (r11 == null) goto L9;
        a r14 = r11.e;
    L10:
        this.c = r14;
        boolean r15 = false;
        if (r9 == null) goto L13;
        int r16 = CardListExtentionsKt.d(r9, "cache_valid_duration", 0);
    L14:
        this.d = r16;
        if (r9 == null) goto L29;
        int r17 = CardListExtentionsKt.d(r9, "biz_type", 0);
        LauncherBizType[] r0 = LauncherBizType.values();
        int r1 = r0.length;
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L25;
        LauncherBizType r3 = r0[r2];
        if (r3.ordinal() != r17) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == true) goto L23;
        r2 = r2 + 1;
        goto L17
    L23:
        r12 = r3;
        goto L25
    L21:
        r4 = false;
    L25:
        if (r12 == null) goto L28;
    L30:
        this.e = r12;
        if (r9 == null) goto L33;
        r15 = CardListExtentionsKt.c(r9, "need_cache_manager", false);
    L33:
        this.f = r15;
        this.g = LazyKt.lazy(new CardListCacheManager$isCacheResponseValid$2(this));
        return;
    L28:
        throw new IllegalArgumentException("Invalid enum value: " + r17);
    L29:
        r12 = LauncherBizType.NONE;
        goto L30
    L13:
        r16 = 0;
        goto L14
    L9:
        r14 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}
