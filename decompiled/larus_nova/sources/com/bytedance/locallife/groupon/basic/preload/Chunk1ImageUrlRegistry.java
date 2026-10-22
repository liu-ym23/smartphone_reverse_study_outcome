package com.bytedance.locallife.groupon.basic.preload;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.ss.ttm.player.C;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u001f\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00112\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/groupon/basic/preload/Chunk1ImageUrlRegistry;", "", "()V", "cleanupIntervalMs", "", "defaultRetentionMs", "lastCleanupAtMs", "Ljava/util/concurrent/atomic/AtomicLong;", "maxRetentionMs", "urlExpireAtMsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "contains", "", "url", "(Ljava/lang/String;)Ljava/lang/Boolean;", "maybeCleanup", "", TriggerTiming.NOW, "normalizeExpireAtMs", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "(Ljava/lang/Long;J)J", "record", "urls", "", "(Ljava/util/List;Ljava/lang/Long;)V", "recordUrl", "expireAtMs", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Chunk1ImageUrlRegistry {
    public static final Chunk1ImageUrlRegistry INSTANCE = null;
    private static final long cleanupIntervalMs = 0;
    private static final long defaultRetentionMs = 0;
    private static final AtomicLong lastCleanupAtMs = null;
    private static final long maxRetentionMs = 0;
    private static final ConcurrentHashMap<String, Long> urlExpireAtMsMap = null;

    private Chunk1ImageUrlRegistry() {
    }

    static {
        INSTANCE = new Chunk1ImageUrlRegistry();
        defaultRetentionMs = TimeUnit.MINUTES.toMillis(10);
        maxRetentionMs = TimeUnit.HOURS.toMillis(24);
        cleanupIntervalMs = TimeUnit.SECONDS.toMillis(30);
        urlExpireAtMsMap = new ConcurrentHashMap(256);
        lastCleanupAtMs = new AtomicLong(0);
    }

    private final void maybeCleanup(long r100) {
        AtomicLong r101 = lastCleanupAtMs;
        long r102 = r101.get();
        if (r102 <= 0) goto L8;
        if ((r100 - r102) >= cleanupIntervalMs) goto L8;
        return;
    L8:
        if (r101.compareAndSet(r102, r100) == true) goto L10;
        return;
    L10:
        Iterator<Map.Entry<String, Long>> r103 = urlExpireAtMsMap.entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, Long> r104 = r103.next();
        String r105 = r104.getKey();
        Long r106 = r104.getValue();
        if (r106.longValue() > r100) goto L12;
        urlExpireAtMsMap.remove(r105, r106);
        goto L12
    }

    public final Boolean contains(String r100) {
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return null;
    L14:
        long r103 = System.currentTimeMillis();
        maybeCleanup(r103);
        ConcurrentHashMap<String, Long> r104 = urlExpireAtMsMap;
        Long r105 = r104.get(r101);
        if (r105 == null) goto L17;
        long r106 = r105.longValue();
        if (r106 > r103) goto L23;
        r104.remove(r101, Long.valueOf(r106));
        return Boolean.FALSE;
    L23:
        return Boolean.TRUE;
    L17:
        return Boolean.FALSE;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    private final long normalizeExpireAtMs(Long r100, long r101) {
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
    L7:
        if (r102 > 0) goto L10;
        r102 = r101 + defaultRetentionMs;
    L17:
        return Math.min(Math.max(r102, defaultRetentionMs + r101), r101 + maxRetentionMs);
    L10:
        if (r102 >= 10000000000L) goto L17;
        if (r102 < C.NANOS_PER_SECOND) goto L15;
        r102 = r102 * 1000;
        goto L17
    L15:
        Long.signum(r102);
        r102 = (r102 * 1000) + r101;
        goto L17
    L5:
        r102 = 0;
        goto L7
    }

    private final void recordUrl(String r100, long r101) {
    L2:
        ConcurrentHashMap<String, Long> r102 = urlExpireAtMsMap;
        Long r103 = r102.get(r100);
        if (r103 == null) goto L5;
        if (r103.longValue() >= r101) goto L9;
        if (r102.replace(r100, r103, Long.valueOf(r101)) == false) goto L2;
        return;
    L9:
        return;
    L5:
        if (r102.putIfAbsent(r100, Long.valueOf(r101)) != null) goto L2;
    }

    public final void record(List<String> r100, Long r101) {
        List<String> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return;
    L11:
        long r104 = System.currentTimeMillis();
        maybeCleanup(r104);
        long r105 = normalizeExpireAtMs(r101, r104);
        HashSet r106 = new HashSet(r100.size());
        Iterator<String> r107 = r100.iterator();
    L13:
        if (r107.hasNext() == false) goto L27;
        String r108 = r107.next();
        if (r108 == null) goto L26;
        String r109 = StringsKt.trim(r108).toString();
        if (r109.length() != 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == true) goto L13;
        if (r106.add(r109) == false) goto L13;
        recordUrl(r109, r105);
        goto L13
    L19:
        r110 = false;
        goto L20
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L27:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
