package com.bytedance.iesgurd.meta;

import b96.i;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.IESGurdUpdatePriority;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.j;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class PrepareMetaManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ConcurrentHashMap<String, PrepareMeta>> f250761a = null;

    static {
        f250761a = new ConcurrentHashMap();
    }

    public static Map a(String r100) {
        return (Map) ((ConcurrentHashMap) f250761a).get(r100);
    }

    public static PrepareMeta b(String r100, String r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) ((ConcurrentHashMap) f250761a).get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (PrepareMeta) r102.get(r101);
    }

    public static void d(final String r110, final String r111) {
        ConcurrentHashMap r100 = (ConcurrentHashMap) ((ConcurrentHashMap) f250761a).get(r110);
        if (r100 == null) goto L5;
        PrepareMeta r101 = (PrepareMeta) r100.get(r111);
    L6:
        if (r101 != null) goto L10;
        yy5.c.h(r110, r111);
        return;
    L10:
        if (r101.getInQueue() == false) goto L12;
        return;
    L12:
        r101.setInQueue(true);
        r101.ignoreBlocks();
        r101.setReqType(ReqType.UPDATE_BY_ACCESS);
        j r102 = new j("", null, null, IESGurdUpdatePriority.HIGH, new PrepareMetaManager$updateWhenAccess$params$1(r110, r111), false, 230);
        AtomicInteger r112 = i.f18315a;
        i.a(CollectionsKt.listOf(r101), r102);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static void c(String r100, String r101, Long r102) {
        ConcurrentHashMap r103 = (ConcurrentHashMap) ((ConcurrentHashMap) f250761a).get(r100);
        if (r103 == null) goto L11;
        PrepareMeta r104 = (PrepareMeta) r103.get(r101);
        if (r104 == null) goto L12;
        if (r102 != null) goto L8;
    L9:
        GeckoLogger.d("remove update meta:" + r100 + ',' + r101 + ",version:" + r104.getVersion());
        r103.remove(r101);
        return;
    L8:
        if (r104.getVersion() == r102.longValue()) goto L9;
        return;
    L12:
        return;
    }
}
