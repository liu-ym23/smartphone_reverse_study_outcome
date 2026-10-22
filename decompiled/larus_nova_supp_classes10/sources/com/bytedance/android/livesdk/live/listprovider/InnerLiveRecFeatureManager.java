package com.bytedance.android.livesdk.live.listprovider;

import am2.x;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.config.g8;
import com.bytedance.android.livesdk.config.l41;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.message.RoomFeatureValue;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class InnerLiveRecFeatureManager {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(InnerLiveRecFeatureManager$liveRecFeatureConfig$2.INSTANCE);
    }

    public static void a(String r4, Object r5, Map r6) {
        List r0 = ((l41) a.getValue()).c();
        if (r0 == null) goto L15;
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((g8) r2.next()).a(), r4) == false) goto L11;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L39;
        RoomFeatureValue r7 = new RoomFeatureValue();
        r7.setValue(r5.toString());
        List r8 = ((l41) a.getValue()).c();
        String r9 = null;
        if (r8 == null) goto L29;
        Iterator r10 = r8.iterator();
    L21:
        if (r10.hasNext() == false) goto L25;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((g8) r11).a(), r4) == false) goto L21;
    L26:
        g8 r12 = (g8) r11;
        if (r12 == null) goto L29;
        r9 = r12.getType();
        goto L29
    L25:
        r11 = null;
    L29:
        if (r9 != null) goto L31;
        r9 = "String";
    L31:
        r7.setType(r9);
        r7.setGenTimeMs(Long.valueOf(System.currentTimeMillis()));
        r7.setExpTimeMs(Long.MAX_VALUE);
        r6.put(r4, r7);
        return;
    L39:
        return;
    L7:
        if (r1.isEmpty() == false) goto L9;
    L15:
        r3 = false;
        goto L16
    }

    public static void b(Room r8, JSONObject r9, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r8, "room");
        Intrinsics.checkNotNullParameter(r9, "fullJson");
        User r11 = r8.getOwner();
        if (r11 == null) goto L99;
        String r12 = r11.getIdStr();
        if (r12 == null) goto L102;
        Lazy r1 = a;
        if (((l41) r1.getValue()).a() == true) goto L10;
        return;
    L10:
        com.bytedance.android.livesdk.log.filter.o r2 = u.l().c(x.class);
        if (r2 == null) goto L16;
        Map<String, String> r3 = r2.getMap();
        if (r3 == null) goto L16;
        String r4 = r3.get("enter_from_merge");
        if (r4 == null) goto L16;
    L17:
        List r5 = ((l41) r1.getValue()).b();
        if (r5 == null) goto L20;
        boolean r6 = r5.contains(r4);
    L21:
        if (r6 == true) goto L75;
        return;
    L75:
        IFeatureService r7 = jc1.k.f(IFeatureService.class);     // Catch: JSONException -> L72
        if (r7 == null) goto L26;
        z90.a r13 = r7.getFeatureManager();     // Catch: JSONException -> L72
    L27:
        LinkedHashMap r14 = new LinkedHashMap();     // Catch: JSONException -> L72
        Iterator<String> r15 = r9.keys();     // Catch: JSONException -> L72
    L29:
        if (r15.hasNext() == false) goto L58;
        String r16 = r15.next();     // Catch: JSONException -> L72
        Object r17 = r9.get(r16);     // Catch: JSONException -> L72
        if (Intrinsics.areEqual(r16, "client_targets_rec_info") == false) goto L42;
        if ((r17 instanceof String) == false) goto L42;
        JSONObject r18 = new JSONObject((String) r17);     // Catch: JSONException -> L39
        Iterator<String> r19 = r18.keys();     // Catch: JSONException -> L39
    L36:
        if (r19.hasNext() == false) goto L29;
        String r20 = r19.next();     // Catch: JSONException -> L39
        a(r20, r18.get(r20), r14);     // Catch: JSONException -> L39
    L39:
        e = move-exception;
        ALogger.e("InnerLiveRecFeatureManager", "processLiveFeatures clientRecJson JSONException: " + e.getMessage());     // Catch: JSONException -> L72
    L42:
        if (Intrinsics.areEqual(r16, "feed_draw_client_targets_rec_info") == false) goto L56;
        if ((r17 instanceof String) == false) goto L56;
        if (r10 != null) goto L49;
        JSONObject r21 = new JSONObject((String) r17);     // Catch: JSONException -> L47
    L50:
        Iterator<String> r22 = r21.keys();     // Catch: JSONException -> L47
    L52:
        if (r22.hasNext() == false) goto L29;
        String r23 = r22.next();     // Catch: JSONException -> L47
        a(r23, r21.get(r23), r14);     // Catch: JSONException -> L47
    L47:
        e = move-exception;
        ALogger.e("InnerLiveRecFeatureManager", "processLiveFeatures feedDrawRecJson JSONException: " + e.getMessage());     // Catch: JSONException -> L72
        goto L29
    L49:
        r21 = r10;
    L56:
        a(r16, r17, r14);     // Catch: JSONException -> L72
        goto L29
    L58:
        if ((!r14.isEmpty()) == false) goto L100;
        StringBuilder r24 = new StringBuilder();     // Catch: JSONException -> L72
        r24.append("putRoomFeatures anchorId is: ");     // Catch: JSONException -> L72
        r24.append(r12);     // Catch: JSONException -> L72
        r24.append(", keys: ");     // Catch: JSONException -> L72
        r24.append(r14.keySet());     // Catch: JSONException -> L72
        r24.append(" values: ");     // Catch: JSONException -> L72
        Collection r110 = r14.values();     // Catch: JSONException -> L72
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));     // Catch: JSONException -> L72
        Iterator r111 = r110.iterator();     // Catch: JSONException -> L72
    L61:
        if (r111.hasNext() == false) goto L68;
        RoomFeatureValue r26 = (RoomFeatureValue) r111.next();     // Catch: JSONException -> L72
        if (r26 == null) goto L66;
        String r27 = r26.getValue();     // Catch: JSONException -> L72
        if (r27 == null) goto L66;
    L67:
        r25.add(r27);     // Catch: JSONException -> L72
    L66:
        r27 = "null";
        goto L67
    L68:
        r24.append(r25);     // Catch: JSONException -> L72
        ALogger.i("InnerLiveRecFeatureManager", r24.toString());     // Catch: JSONException -> L72
        if (r13 == null) goto L101;
        r13.d(r12, r14);     // Catch: JSONException -> L72
        return;
    L101:
        return;
    L100:
        return;
    L26:
        r13 = null;
    L72:
        e = move-exception;
        ALogger.e("InnerLiveRecFeatureManager", "processLiveFeatures JSONException: " + e.getMessage());
        return;
    L20:
        r6 = false;
    L16:
        r4 = "";
        goto L17
    L102:
        return;
    }
}
