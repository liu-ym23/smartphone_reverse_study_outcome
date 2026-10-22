package com.bytedance.awemeopen.domain.feed.preload;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.feed.preload.AosConsumeCacheFeedListReason;
import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemePreloadManager;
import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemeRequesterImpl;
import com.bytedance.awemeopen.domain.feed.preload.aweme.e;
import com.bytedance.awemeopen.domain.feed.preload.feedlist.AosFeedListPreloadManager;
import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import r14.c;

/* JADX INFO: loaded from: classes44.dex */
public final class RecFeedCacheDataHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AosAwemeRequesterImpl f198325a = null;

    public RecFeedCacheDataHelper() {
    }

    static {
        f198325a = new AosAwemeRequesterImpl(false);
    }

    public static void a(String r110, List r111, List r112) {
        if (r110 == null) goto L4;
        w34.a<c> r100 = e.f198344f.b(r110);
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.a() == false) goto L9;
        ArrayList r113 = (ArrayList) r111;
        r113.add(r100.f558144a);
        return;
    L9:
        Intrinsics.checkNotNull(r110);
        ArrayList r114 = (ArrayList) r112;
        r114.add(new AosAwemePreloadModel(r110, null, null, null, 0, false, null, false, null, null, 1022, null));
        e.f198344f.d(r110);
        return;
    L4:
        r100 = null;
        goto L5
    }

    public static void d(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "cacheAids");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r103 = com.bytedance.awemeopen.infra.base.event.b.a("ao_first_feed_list_consume");
        r103.d("useCache", Integer.valueOf(r100 ? 1 : 0));
        r103.d("cacheCount", Integer.valueOf(r101));
        r103.d("cacheAids", r102);
        r103.a().b();
    }

    public static void e(String r100, boolean r101, long r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "enterAid");
        com.bytedance.awemeopen.infra.base.event.b.C2872b r105 = com.bytedance.awemeopen.infra.base.event.b.a("ao_preload_data_consume");
        r105.d("enterAid", r100);
        r105.d("hitCache", Integer.valueOf(r101 ? 1 : 0));
        r105.d("enterAidFetchDuration", Long.valueOf(r102));
        r105.d("missReasonType", Integer.valueOf(r103));
        r105.d("aweme_type", Integer.valueOf(r104));
        r105.a().b();
    }

    public static /* synthetic */ void c(String r110, String r111, String r112, AosPreloadCacheStrategy r113, boolean r114, Function1 r115) {
        b(r110, r111, null, null, null, null, null, null, r112, r113, r114, r115);
    }

    public static void b(String r210, String r211, String r212, String r213, String r214, String r310, String r311, String r312, String r313, AosPreloadCacheStrategy r314, boolean r315, final Function1 r316) {
        final ArrayList r110 = new ArrayList();
        ArrayList r111 = new ArrayList();
        if (r210 != null) goto L5;
    L10:
        boolean r100 = false;
    L11:
        Sequence r101 = null;
        if (r100 == false) goto L14;
        String r102 = r210;
    L25:
        if (r210 != null) goto L27;
    L30:
        boolean r103 = true;
    L31:
        String r104 = "";
        if (r103 == false) goto L42;
        if (r214 != null) goto L35;
    L38:
        boolean r105 = true;
    L39:
        if (r105 == false) goto L42;
    L110:
        List r106 = CollectionsKt.toMutableList(r111);
    L111:
        r110.addAll(r106);
        if (AosFeedListPreloadManager.f198352e.f557903a == false) goto L138;
        if (r313 == null) goto L117;
        boolean r107 = true;
        if ((!StringsKt.isBlank(r313)) != true) goto L118;
        boolean r112 = true;
    L119:
        if (r112 == true) goto L121;
    L123:
        boolean r113 = false;
    L124:
        if (r113 == true) goto L138;
        if (r314 != AosPreloadCacheStrategy.DEFAULT_STRATEGY) goto L138;
        if (r315 == true) goto L138;
        List r108 = AosFeedListPreloadManager.a(AosConsumeCacheFeedListReason.RECOMMEND_PAGE_CONSUME);
        ArrayList r109 = (ArrayList) r108;
        if (r109.isEmpty() == false) goto L131;
        d(false, 0, r104);
    L132:
        Iterator r114 = r109.iterator();
    L134:
        if (r114.hasNext() == false) goto L136;
        ((c) r114.next()).f535636r = r107;
        goto L134
    L136:
        r110.addAll(r108);
        goto L138
    L131:
        int r115 = r109.size();
        int r116 = AosAwemeRequesterImpl.f198331c;
        d(r107, r115, AosAwemeRequesterImpl.Companion.a(r108));
        goto L132
    L121:
        if (Intrinsics.areEqual(r313, "default") == true) goto L123;
        r113 = true;
    L118:
        r112 = false;
        goto L119
    L117:
        r107 = true;
    L138:
        if (AoPool.isOnMain() == true) goto L140;
        AoPool.g(new RecFeedCacheDataHelper$innerPackageFirstBrushData$2(r316, r110));
        return;
    L140:
        r316.invoke(r110);
        return;
    L35:
        if (r214.length() == 0) goto L38;
        r105 = false;
    L42:
        long r117 = SystemClock.elapsedRealtime();
        ArrayList r118 = new ArrayList();
        if (r212 == null) goto L48;
        Iterator r119 = StringsKt.split$default(r212, new String[]{","}, false, 0, 6, null).iterator();
    L46:
        if (r119.hasNext() == false) goto L48;
        a((String) r119.next(), r111, r118);
    L48:
        if (r213 == null) goto L54;
        Iterator r120 = StringsKt.split$default(r213, new String[]{","}, false, 0, 6, null).iterator();
    L51:
        if (r120.hasNext() == false) goto L54;
        a((String) r120.next(), r111, r118);
    L54:
        if (r111.isEmpty() == false) goto L57;
        a(r102, r111, r118);
    L57:
        if (r118.size() <= 0) goto L60;
        AosAwemePreloadManager.f198326a.preload(r118, null);
    L60:
        if (r111.size() <= 0) goto L96;
        ArrayList r121 = new ArrayList();
        if (r312 == null) goto L64;
        r101 = StringsKt.splitToSequence$default(r312, new String[]{","}, false, 0, 6, null);
    L64:
        if (r101 == null) goto L86;
        Iterator r122 = r101.iterator();
        int r123 = 0;
    L67:
        if (r122.hasNext() == false) goto L86;
        int r124 = r123 + 1;
        String r125 = (String) r122.next();
        Iterator r126 = r111.iterator();
    L70:
        if (r126.hasNext() == false) goto L84;
        c r127 = (c) r126.next();
        if (r127.c().length() <= 0) goto L74;
        boolean r128 = true;
    L75:
        if (r128 == false) goto L70;
        Iterator r215 = r122;
        if (TextUtils.equals(r127.c(), r125) == true) goto L79;
    L82:
        r122 = r215;
        goto L70
    L79:
        if (r123 <= r121.size()) goto L81;
        r121.add(r127);
        goto L82
    L81:
        ListProtector.add(r121, r123, r127);
        goto L82
    L74:
        r128 = false;
        goto L75
    L84:
        r123 = r124;
    L86:
        if ((!r121.isEmpty()) == false) goto L88;
        r111.clear();
        r111.addAll(r121);
    L88:
        if (r210 == null) goto L110;
        Iterator r129 = r111.iterator();
    L91:
        if (r129.hasNext() == false) goto L110;
        c r130 = (c) r129.next();
        if (Intrinsics.areEqual(r210, r130.c()) == false) goto L91;
        e(r210, true, SystemClock.elapsedRealtime() - r117, 0, r130.i());
        goto L91
    L96:
        if (r314 != AosPreloadCacheStrategy.ONLY_NEED_SPECIFIED_AIDS_IN_CACHE) goto L98;
        r106 = CollectionsKt.toMutableList(r111);
        r104 = "";
        r110 = r110;
        goto L111
    L98:
        LinkedHashMap r131 = new LinkedHashMap();
        if (TextUtils.isEmpty(r102) == true) goto L101;
        Intrinsics.checkNotNull(r102);
        r131.put(r102, r311);
    L101:
        AosAwemeRequesterImpl r132 = f198325a;
        String[] r133 = new String[1];
        if (r210 != null) goto L104;
        String r134 = "";
    L105:
        r133[0] = r134;
        List<String> r135 = CollectionsKt.mutableListOf(r133);
        String[] r136 = new String[1];
        if (r214 != null) goto L108;
        String r137 = "";
    L109:
        r136[0] = r137;
        r132.b(r135, r211, r212, r213, CollectionsKt.mutableListOf(r136), r310, r131, r312, r313, "host_preload", false, new b(r111, r210, r117));
        goto L110
    L108:
        r137 = r214;
        goto L109
    L104:
        r134 = r210;
        goto L105
    L27:
        if (r210.length() == 0) goto L30;
        r103 = false;
        goto L31
    L14:
        if (r214 != null) goto L16;
    L21:
        boolean r138 = false;
    L22:
        if (r138 == false) goto L24;
        r102 = r214;
        goto L25
    L24:
        r102 = null;
        goto L25
    L16:
        if (r214.length() <= 0) goto L18;
        boolean r139 = true;
    L19:
        if (r139 != true) goto L21;
        r138 = true;
        goto L22
    L18:
        r139 = false;
        goto L19
    L5:
        if (r210.length() <= 0) goto L7;
        boolean r140 = true;
    L8:
        if (r140 != true) goto L10;
        r100 = true;
        goto L11
    L7:
        r140 = false;
        goto L8
    }
}
