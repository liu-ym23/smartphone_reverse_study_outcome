package com.bytedance.ee.bear.office.space.preload;

import android.content.Context;
import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadHandle;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadLevel;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadLevelState;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.preload.a;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSpacePreloadManager {
    public static final ConcurrentHashMap<String, OfficeSpacePreloadState> a = null;
    public static final ConcurrentHashMap<String, a.InterfaceC0135a> b = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static String b(String r10) {
        byte[] r1 = MessageDigest.getInstance("SHA-256").digest(r10.getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r1);
        return StringsKt.take(ArraysKt.joinToString$default(r1, "", null, null, 0, null, OfficeSpacePreloadManager$sha256$1.INSTANCE, 30, null), 16);
    }

    public static OfficeSpacePreloadHandle a(Context r31, final OfficeSpacePreloadRequest r32, int r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r32, "request");
        OfficeSpaceConfig r2 = r32.getConfig();
        String[] r3 = new String[8];
        r3[0] = "userScope=" + r33;
        r3[1] = "initial=" + r2.getInitialTab().name();
        StringBuilder r4 = new StringBuilder("tabs=");
        Set<OfficeSpaceTab> r7 = r2.getEnabledTabs();
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r8.add(((OfficeSpaceTab) r9.next()).name());
        goto L4
    L6:
        r4.append(CollectionsKt.joinToString$default(CollectionsKt.sorted(r8), ",", null, null, 0, null, null, 62, null));
        r3[2] = r4.toString();
        r3[3] = "display=" + r2.getListConfig().getDisplayMode().name();
        StringBuilder r5 = new StringBuilder("recent=");
        Object r10 = r2.getListConfig().getRecentFilterTabType();
        if (r10 != null) goto L9;
        r10 = "none";
    L9:
        r5.append(r10);
        r3[4] = r5.toString();
        r3[5] = "multi=" + r2.getListConfig().getEnableMultiSelect();
        r3[6] = "folderFallback=" + r2.getListConfig().getDisableInternalFolderFallback();
        StringBuilder r6 = new StringBuilder("menu=");
        String r11 = r2.getMenuConfigJson();
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        r6.append(b(r11));
        r3[7] = r6.toString();
        final String r12 = b(CollectionsKt.joinToString$default(CollectionsKt.listOf(r3), "|", null, null, 0, null, null, 62, null));
        OfficeSpacePreloadState r15 = a.get(r12);
        if (r15 != null) goto L15;
    L29:
        final String r13 = UUID.randomUUID().toString();
        if (r34 == true) goto L32;
    L34:
        boolean r14 = false;
    L35:
        Set<OfficeSpacePreloadLevel> r16 = r32.getLevels();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L37:
        if (r18.hasNext() == false) goto L48;
        Object r19 = r18.next();
        OfficeSpacePreloadLevel r110 = (OfficeSpacePreloadLevel) r19;
        if (r110 != OfficeSpacePreloadLevel.INIT) goto L41;
    L45:
        boolean r111 = true;
    L46:
        if (r111 == false) goto L37;
        r17.add(r19);
        goto L37
    L41:
        if (r110 != OfficeSpacePreloadLevel.DB) goto L44;
        if (r14 == true) goto L45;
    L44:
        r111 = false;
        goto L46
    L48:
        Set r20 = CollectionsKt.toSet(r17);
        Set<OfficeSpacePreloadLevel> r21 = r32.getLevels();
        LinkedHashMap r112 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r21, 10)), 16));
        Iterator<T> r22 = r21.iterator();
    L50:
        if (r22.hasNext() == false) goto L59;
        Object r23 = r22.next();
        OfficeSpacePreloadLevel r113 = (OfficeSpacePreloadLevel) r23;
        if (r20.contains(r113) == false) goto L55;
        OfficeSpacePreloadLevelState r114 = OfficeSpacePreloadLevelState.RUNNING;
    L58:
        r112.put(r23, r114);
        goto L50
    L55:
        if (r113 != OfficeSpacePreloadLevel.DB) goto L57;
        r114 = OfficeSpacePreloadLevelState.SKIPPED;
        goto L58
    L57:
        r114 = OfficeSpacePreloadLevelState.UNSUPPORTED;
        goto L58
    L59:
        final OfficeSpacePreloadState r24 = new OfficeSpacePreloadState(r32.getPreloadId(), r13, r12, r32.getScene(), r112, System.currentTimeMillis(), null, r32.getCreatedAtMs() + r32.getTtlMs(), null, null, 832, null);
        ConcurrentHashMap<String, OfficeSpacePreloadState> r25 = a;
        r25.put(r12, r24);
        tt5.a.h("OfficeSpacePreloadManager", "office_space_preload_start preloadId=" + r32.getPreloadId() + " requestId=" + r13 + " key=" + r12 + " scene=" + r32.getScene() + " levels=" + r32.getLevels());
        if (r20.contains(OfficeSpacePreloadLevel.DB) == true) goto L66;
        Map r0 = MapsKt.toMutableMap(r24.getLevelStates());
        OfficeSpacePreloadLevel r26 = OfficeSpacePreloadLevel.INIT;
        if (r20.contains(r26) == false) goto L64;
        r0.put(r26, OfficeSpacePreloadLevelState.SUCCESS);
    L64:
        Unit r27 = Unit.INSTANCE;
        OfficeSpacePreloadState r115 = OfficeSpacePreloadState.copy$default(r24, null, null, null, null, r0, 0, Long.valueOf(System.currentTimeMillis()), 0, null, null, 943, null);
        r25.put(r12, r115);
        tt5.a.h("OfficeSpacePreloadManager", "office_space_preload_finish requestId=" + r13 + " key=" + r12 + " no_db_level=true");
        return new OfficeSpacePreloadHandle(r32.getPreloadId(), r13, r12, r20, r115);
    L66:
        int r28 = a.a;
        b.put(r12, a.a(r31, r32, r13, r12, new OfficeSpacePreloadManager$preload$newTask$1(r12, r13, r24, r32)));
        return new OfficeSpacePreloadHandle(r32.getPreloadId(), r13, r12, r20, r24);
    L32:
        if (r32.getConfig().getListConfig().getDisplayMode() != OfficeListDisplayMode.FLOW) goto L34;
        r14 = true;
        goto L35
    L15:
        if (r15.getTtlDeadlineMs() < System.currentTimeMillis()) goto L29;
        tt5.a.h("OfficeSpacePreloadManager", "office_space_preload_start reuse requestId=" + r15.getRequestId() + " key=" + r12 + " scene=" + r32.getScene());
        String r116 = r15.getPreloadId();
        String r117 = r15.getRequestId();
        Map<OfficeSpacePreloadLevel, OfficeSpacePreloadLevelState> r1 = r15.getLevelStates();
        LinkedHashMap r29 = new LinkedHashMap();
        Iterator<Map.Entry<OfficeSpacePreloadLevel, OfficeSpacePreloadLevelState>> r30 = r1.entrySet().iterator();
    L18:
        if (r30.hasNext() == false) goto L28;
        Map.Entry<OfficeSpacePreloadLevel, OfficeSpacePreloadLevelState> r35 = r30.next();
        OfficeSpacePreloadLevelState r36 = r35.getValue();
        if (r36 != OfficeSpacePreloadLevelState.UNSUPPORTED) goto L22;
    L24:
        boolean r37 = false;
    L25:
        if (r37 == false) goto L18;
        r29.put(r35.getKey(), r35.getValue());
        goto L18
    L22:
        if (r36 == OfficeSpacePreloadLevelState.SKIPPED) goto L24;
        r37 = true;
        goto L25
    L28:
        return new OfficeSpacePreloadHandle(r116, r117, r12, r29.keySet(), r15);
    }
}
