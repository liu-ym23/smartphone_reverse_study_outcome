package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.common.utility.NetworkUtils;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeadVideoAutoPlayController {
    public static final Lazy a = null;
    public static Long b;
    public static final LinkedList<Long> c = null;
    public static volatile boolean d;
    public static volatile boolean e;
    public static final boolean f = false;
    public static final HeadVideoAutoPlayController g = null;

    public HeadVideoAutoPlayController() {
    }

    public final synchronized void d() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (f == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (d == true) goto L13;
        if (e == true) goto L13;
        e("start load records");     // Catch: Throwable -> L15
        e = true;     // Catch: Throwable -> L15
        b2.a(HeadVideoAutoPlayController$loadPauseEventRecords$1.INSTANCE);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    static {
        final HeadVideoAutoPlayController r0 = new HeadVideoAutoPlayController();
        g = r0;
        a = LazyKt.lazy(new HeadVideoAutoPlayController$playProgressMap$2(r0));
        c = new LinkedList();
        boolean r1 = true;
        if (ECSettingKeys.B0() == 1) goto L8;
        boolean r2 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == true) goto L8;
        r1 = false;
    L8:
        f = r1;
    }

    public static void f() {
        if (f == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        LinkedList<Long> r2 = c;
        r2.add(0, Long.valueOf(System.currentTimeMillis()));
        if (r2.size() <= 21) goto L8;
        r2.remove(r2.size() - 1);
    L8:
        Long r3 = (Long) CollectionsKt.getOrNull(r2, 20);
        if (r3 != null) goto L11;
    L13:
        b2.a(HeadVideoAutoPlayController$savePauseEventToDisk$1.INSTANCE);
        e("call onPauseClick: records size=" + r2.size() + " stopAutoPlayFlag=" + b);
        return;
    L11:
        if ((r0 - r3.longValue()) >= 259200000) goto L13;
        b = Long.valueOf(r0);
        r2.clear();
        b2.a(HeadVideoAutoPlayController$savePauseEventToDisk$1.INSTANCE);
        goto L13
    }

    public static boolean b(s r6) {
        Intrinsics.checkNotNullParameter(r6, "headAbility");
        StringBuilder r0 = new StringBuilder("call canAutoPlay: isEnableAutoPlay=");
        boolean r1 = f;
        r0.append(r1);
        r0.append(" hasLoadedRecordsFromDisk=");
        r0.append(d);
        e(r0.toString());
        boolean r2 = false;
        if (r1 == true) goto L6;
        return false;
    L6:
        if (r6.n0() == true) goto L9;
        return false;
    L9:
        if (r6.oa() == false) goto L12;
        return false;
    L12:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == true) goto L17;
        if (r6.r9() == false) goto L17;
        return false;
    L17:
        if (NetworkUtils.isWifi(r6.getContext()) == true) goto L20;
        return false;
    L20:
        if (d == true) goto L22;
        return false;
    L22:
        long r3 = System.currentTimeMillis();
        Long r7 = b;
        if (r7 != null) goto L25;
        Long r8 = (Long) CollectionsKt.getOrNull(c, 5);
        if (r8 != null) goto L32;
        return true;
    L32:
        if ((r3 - r8.longValue()) <= 86400000) goto L35;
        r2 = true;
    L35:
        return r2;
    L25:
        if ((r3 - r7.longValue()) <= 259200000) goto L28;
        b = null;
        c.clear();
        b2.a(HeadVideoAutoPlayController$savePauseEventToDisk$1.INSTANCE);
        return true;
    L28:
        return false;
    }

    public static void e(String r1) {
        if (ECAppInfoService.e.isLocalTest() == false) goto L6;
        dm.a.a("PdpHeadAutoPlay").i(r1);
        return;
    }

    public static String a(VideoModel r1, s r2) {
        StringBuilder r0 = new StringBuilder();
        CommonMeta r3 = r2.rR().r0();
        if (r3 == null) goto L5;
        String r4 = r3.getPromotionId();
    L6:
        r0.append(r4);
        r0.append('_');
        r0.append(r1.getVid());
        return r0.toString();
    L5:
        r4 = null;
        goto L6
    }

    public static Long c(VideoModel r2, s r3) {
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        if (f == true) goto L5;
        return null;
    L5:
        if (r2 != null) goto L7;
        return null;
    L7:
        String r4 = a(r2, r3);
        StringBuilder r5 = new StringBuilder("call getPlayProgress id=");
        r5.append(r4);
        r5.append(" progress=");
        Lazy r0 = a;
        r5.append((Long) ((HeadVideoAutoPlayController$playProgressMap$2.AnonymousClass1) r0.getValue()).get(r4));
        e(r5.toString());
        return (Long) ((HeadVideoAutoPlayController$playProgressMap$2.AnonymousClass1) r0.getValue()).get(r4);
    }

    public static void g(VideoModel r1, s r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "model");
        Intrinsics.checkNotNullParameter(r2, "headAbility");
        if (f == true) goto L5;
        return;
    L5:
        String r4 = a(r1, r2);
        ((HeadVideoAutoPlayController$playProgressMap$2.AnonymousClass1) a.getValue()).put(r4, Long.valueOf(r3));
        e("call savePlayProgress id=" + r4 + " progress=" + r3);
    }
}
