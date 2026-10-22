package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.officewebview.bridge.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f435505a = 0;

    static {
    }

    public static void a(String r100, xwb.d r101, com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r102) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "featureService");
        if (r100 != null) goto L28;
        return;
    L28:
        JSONArray r103 = new JSONObject(r100).optJSONArray("keys");     // Catch: Exception -> L25
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.length() <= 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L34;
        IntRange r105 = RangesKt.until(0, r103.length());     // Catch: Exception -> L25
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));     // Catch: Exception -> L25
        Iterator<Integer> r107 = r105.iterator();     // Catch: Exception -> L25
    L17:
        if (r107.hasNext() == false) goto L19;
        r106.add(JSONArrayProtectorUtils.getString(r103, ((IntIterator) r107).nextInt()));     // Catch: Exception -> L25
        goto L17
    L19:
        lvb.a.a("MmWebFgHandler", "[handle] keysList=" + r106);     // Catch: Exception -> L25
        int r108 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.a.f433792f;     // Catch: Exception -> L25
        Map<String, Boolean> r109 = r102.a(r106, false);     // Catch: Exception -> L25
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L25
        Iterator r111 = ((LinkedHashMap) r109).entrySet().iterator();     // Catch: Exception -> L25
    L21:
        if (r111.hasNext() == false) goto L23;
        Map.Entry r112 = (Map.Entry) r111.next();     // Catch: Exception -> L25
        r110.put((String) r112.getKey(), ((Boolean) r112.getValue()).booleanValue());     // Catch: Exception -> L25
        goto L21
    L23:
        lvb.a.a("MmWebFgHandler", "[handle] result=" + r110);     // Catch: Exception -> L25
        r101.a(Status.SUCCESS, r110);     // Catch: Exception -> L25
        Unit r113 = Unit.INSTANCE;     // Catch: Exception -> L25
        return;
    L34:
        return;
    L10:
        r104 = false;
    L25:
        e = move-exception;
        lvb.a.b("MmWebFgHandler", "[handle] error: " + e);
        r101.a(Status.FAILURE, null);
        Unit r114 = Unit.INSTANCE;
    }
}
