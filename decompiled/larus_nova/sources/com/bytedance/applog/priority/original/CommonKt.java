package com.bytedance.applog.priority.original;

import android.database.sqlite.SQLiteDatabase;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.common.applog.EventVerify;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.KeyGenerator;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class CommonKt {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192644a = null;

        static {
            int[] r100 = new int[Model$EventType.values().length];
            r100[Model$EventType.V3.ordinal()] = 1;
            r100[Model$EventType.V1.ordinal()] = 2;
            r100[Model$EventType.LogData.ordinal()] = 3;
            r100[Model$EventType.Launch.ordinal()] = 4;
            r100[Model$EventType.Terminate.ordinal()] = 5;
            f192644a = r100;
        }
    }

    public static final void b(SQLiteDatabase r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isOpen() == true) goto L6;
        return;
    L6:
        if (r100.inTransaction() == false) goto L14;
        r100.endTransaction();     // Catch: Throwable -> L9
        return;
    L15:
        return;
    }

    public static final void d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "packJson");
        r100.put("magic_tag", "ss_app_log");
        r100.put("local_time", System.currentTimeMillis() / ((long) 1000));
        r100.put("_gen_time", System.currentTimeMillis());
    }

    public static final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return 0;
    L8:
        int r103 = 0;
    L10:
        if (r101 >= r100.length()) goto L22;
        char r104 = r100.charAt(r101);
        if (r104 > 127) goto L15;
        r103 = r103 + 1;
    L21:
        r101 = r101 + 1;
        goto L10
    L15:
        if (r104 > 2047) goto L18;
        r103 = r103 + 2;
        goto L21
    L18:
        if (Character.isHighSurrogate(r104) == false) goto L20;
        r103 = r103 + 4;
        r101 = r101 + 1;
        goto L21
    L20:
        r103 = r103 + 3;
        goto L21
    L22:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    public static final long i(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "intervals");
        int r101 = r100.size();
        if (r101 != 0) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (r101 == 1) goto L14;
        long r102 = ((Number) ListProtector.get(r100, 0)).longValue();
        long r103 = i(r100.subList(1, r100.size()));
        long r104 = RangesKt.coerceAtLeast(1, r102);
        long r105 = RangesKt.coerceAtLeast(1, r103);
    L8:
        if (r105 == 0) goto L15;
        long r106 = r104 % r105;
        r104 = r105;
        r105 = r106;
        goto L8
    L15:
        return r104;
    L14:
        return RangesKt.coerceAtLeast(1, ((Number) ListProtector.get(r100, 0)).longValue());
    }

    public static final void e(JSONObject r100, PriorityCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "options");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Object r102 = r101.getOpaquePayloadJson();
        if (r102 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r102, JSONObject.NULL) == true) goto L12;
        r100.put("opaque_payload", r102);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public static final Pair<String, String> f(JSONObject r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "packJson");
        boolean r102 = true;
        r100.put("uid_enable", 1);
        if (r101 == true) goto L23;
        return null;
    L23:
        KeyGenerator r103 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L17
        SecureRandom r104 = new SecureRandom();     // Catch: Throwable -> L17
        r103.init(128, r104);     // Catch: Throwable -> L17
        String r105 = e.a(r103.generateKey().getEncoded());     // Catch: Throwable -> L17
        byte[] r106 = new byte[8];     // Catch: Throwable -> L17
        r104.nextBytes(r106);     // Catch: Throwable -> L17
        String r107 = e.a(r106);     // Catch: Throwable -> L17
        if (r105 == null) goto L13;
        if (r107 == null) goto L13;
        if (r105.length() != 32) goto L13;
        if (r107.length() != 16) goto L13;
    L14:
        if (r102 == false) goto L18;
        Pair r108 = TuplesKt.to(r105, r107);     // Catch: Throwable -> L17
    L19:
        if (r108 != null) goto L21;
        return null;
    L21:
        String r109 = (String) r108.component1();
        String r110 = (String) r108.component2();
        r100.put("key", r109);
        r100.put(CJPayFingerprintSharedPrefUtils.KEY_IV, r110);
        return TuplesKt.to(r109, r110);
    L13:
        r102 = false;
    L18:
        r108 = null;
        goto L19
    }

    public static final void h(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "targetJson");
        Intrinsics.checkNotNullParameter(r101, "sourceJson");
        if (r101.length() > 0) goto L5;
        return;
    L5:
        Iterator<String> r102 = r101.keys();
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        r100.put(r103, r101.get(r103));
        goto L7
    }

    public static final JSONObject n(PriorityCallback r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "priorityCallback");
        String r102 = r100.getHeaderJson();
        if (r102 != null) goto L5;
    L12:
        if (r101 <= 0) goto L15;
        Thread.sleep(300);
        return n(r100, r101 - 1);
    L15:
        return null;
    L5:
        if (r102.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L12;
        return new JSONObject(r102);
    L7:
        r103 = false;
        goto L8
    }

    public static final String a(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "reportHost");
        Intrinsics.checkNotNullParameter(r102, "reportPath");
        return r101 + r102 + "?app_log_priority=" + r100;
    }

    public static final void c(JSONObject r100, Map<j, ? extends JSONObject> r101, com.bytedance.applog.log.a r110) {
        Intrinsics.checkNotNullParameter(r100, "packJson");
        Intrinsics.checkNotNullParameter(r101, "events");
        Intrinsics.checkNotNullParameter(r110, "logger");
        final JSONArray r102 = new JSONArray();
        final JSONArray r103 = new JSONArray();
        final JSONArray r104 = new JSONArray();
        final JSONArray r105 = new JSONArray();
        final JSONArray r106 = new JSONArray();
        Iterator<Map.Entry<j, ? extends JSONObject>> r107 = r101.entrySet().iterator();
    L4:
        if (r107.hasNext() == false) goto L22;
        Map.Entry<j, ? extends JSONObject> r108 = r107.next();
        j r109 = r108.getKey();
        JSONObject r111 = r108.getValue();
        Model$EventType r112 = r109.f192745d;
        int r113 = a.f192644a[r112.ordinal()];
        if (r113 != 1) goto L8;
        r102.put(r111);
        goto L4
    L8:
        if (r113 != 2) goto L10;
        r103.put(r111);
        goto L4
    L10:
        if (r113 != 3) goto L12;
        r104.put(r111);
        goto L4
    L12:
        if (r113 != 4) goto L14;
        r105.put(r111);
        goto L4
    L14:
        if (r113 != 5) goto L4;
        r106.put(r111);
        goto L4
    L22:
        if (r102.length() <= 0) goto L25;
        r100.put("event_v3", r102);
    L25:
        if (r103.length() <= 0) goto L28;
        r100.put("event", r103);
    L28:
        if (r104.length() <= 0) goto L31;
        r100.put("log_data", r104);
    L31:
        if (r105.length() <= 0) goto L34;
        r100.put(EventVerify.TYPE_LAUNCH, r105);
    L34:
        if (r106.length() <= 0) goto L36;
        r100.put(EventVerify.TYPE_TERMINATE, r106);
    L36:
        r110.a("fillEventToPackJson", new CommonKt$fillEventToPackJson$1(r102, r103, r104, r105, r106));
    }

    public static final void j(PriorityCallback r100, int r101, Map<j, ? extends JSONObject> r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r102, "events");
        Iterator<j> r103 = r102.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        j r104 = r103.next();
        long r105 = (System.currentTimeMillis() / ((long) 1000)) - r104.f192744c;
        r100.monitorLatency(r101, r104.f192745d.getType(), (int) r105);
        goto L4
    }

    public static final void m(PriorityCallback r100, String r101, Map<j, ? extends JSONObject> r110, Model$PriorityName r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r110, "events");
        Intrinsics.checkNotNullParameter(r111, "priorityName");
        if (r100.isStageEnabled() == true) goto L5;
        return;
    L5:
        Iterator<Map.Entry<j, ? extends JSONObject>> r113 = r110.entrySet().iterator();
    L7:
        if (r113.hasNext() == false) goto L9;
        Map.Entry<j, ? extends JSONObject> r102 = r113.next();
        j r103 = r102.getKey();
        JSONObject r104 = r102.getValue();
        l(r100, r101, r103.f192745d.getType(), r104, r111, r112);
        goto L7
    }

    public static final void k(PriorityCallback r100, String r101, int r102, Lazy<? extends JSONObject> r103, Model$PriorityName r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r103, "json");
        Intrinsics.checkNotNullParameter(r110, "priorityName");
        if (r100.isStageEnabled() == true) goto L5;
        return;
    L5:
        l(r100, r101, r102, r103.getValue(), r110, r111);
    }

    public static final void l(PriorityCallback r110, String r111, int r112, JSONObject r113, Model$PriorityName r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "stage");
        Intrinsics.checkNotNullParameter(r113, "json");
        Intrinsics.checkNotNullParameter(r114, "priorityName");
        if (r110.isStageEnabled() == true) goto L6;
        return;
    L6:
        if (r113.optInt("event_stained") > 0) goto L8;
        return;
    L8:
        String r100 = r114.name();
        Intrinsics.checkNotNullParameter(r113, "json");
        Model$EventType.Companion.getClass();
        Model$EventType r101 = Model$EventType.a.a(r112);
        int r102 = a.f192644a[r101.ordinal()];
        if (r102 != 1) goto L11;
        String r103 = r113.optString("event");
    L18:
        r110.monitorStage(r111, r100, r115, r112, r103, r113.optString("monitor_id"), r113.optLong("local_time_ms", System.currentTimeMillis()));
        return;
    L11:
        if (r102 != 2) goto L13;
        r103 = r113.optString("tag");
        goto L18
    L13:
        if (r102 == 3) goto L15;
        r103 = r101.getAlias();
        goto L18
    L15:
        r103 = r113.optString(FrescoMonitorConst.LOG_TYPE);
        goto L18
    }
}
