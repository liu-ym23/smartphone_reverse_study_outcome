package com.bytedance.sdk.account.monitor.settings;

import ac7.e;
import ac7.g;
import ac7.j;
import ac7.k;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.account.monitor.settings.a> f269204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f269205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f269206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f269207d;

    public static final class a {
        public static b a(boolean r110, JSONObject r111, int r112, String r210) {
            b r100 = new b(r110, r112, r210);
            if (r110 == false) goto L86;
            Iterator<String> r113 = r111.keys();
        L6:
            if (r113.hasNext() == false) goto L86;
            String r114 = r113.next();
            Map<String, com.bytedance.sdk.account.monitor.settings.a> r115 = r100.f269204a;
            JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r111, r114);
            if ((r101 instanceof JSONObject) == false) goto L85;
            int r102 = r101.optInt(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, 1);
            int r103 = 0;
            int r104 = r101.optInt("sample_mode", 0);
            if (r101.has("sample_if") == false) goto L59;
            int r105 = e.f2750a;
            Object r106 = r101.get("sample_if");
            if (Intrinsics.areEqual(r106, JSONObject.NULL) == false) goto L15;
            g r107 = ac7.a.f2746a;
        L56:
            g r108 = r107;
        L60:
            String r109 = r101.optString("sample_group", "");
            if (r109.length() <= 0) goto L63;
            boolean r116 = true;
        L64:
            if (r116 == false) goto L66;
            String r117 = r109;
        L67:
            JSONArray r118 = r101.optJSONArray(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS);
            if (r118 == null) goto L82;
            IntRange r119 = RangesKt.until(0, r118.length());
            ArrayList r120 = new ArrayList();
            Iterator<Integer> r121 = r119.iterator();
        L71:
            if (r121.hasNext() == false) goto L81;
            String r122 = r118.optString(((IntIterator) r121).nextInt());
            if (r122.length() <= 0) goto L75;
            boolean r123 = true;
        L76:
            if (r123 == true) goto L79;
            r122 = null;
        L79:
            if (r122 == null) goto L71;
            r120.add(r122);
            goto L71
        L75:
            r123 = false;
            goto L76
        L81:
            Set r124 = CollectionsKt.toSet(r120);
        L83:
            String r125 = r117;
            Set r126 = r124;
            r115.put(r114, new com.bytedance.sdk.account.monitor.settings.a(r100, r102, r104, r108, r125, r126, r101.optBoolean("log_all_params", false), 4));
            goto L6
        L82:
            r124 = null;
            goto L83
        L66:
            r117 = null;
            goto L67
        L63:
            r116 = false;
            goto L64
        L15:
            if ((r106 instanceof String) == false) goto L18;
            int r127 = k.f2758a;
            r107 = k.a.a((String) r106);
            goto L56
        L18:
            if ((r106 instanceof JSONArray) == false) goto L58;
            JSONArray r128 = (JSONArray) r106;
            if (r128.length() != 0) goto L22;
            r107 = ac7.a.f2746a;
            goto L56
        L22:
            Object r129 = r128.opt(0);
            if ((r129 instanceof String) == false) goto L35;
            IntRange r130 = RangesKt.until(0, r128.length());
            ArrayList r131 = new ArrayList();
            Iterator<Integer> r132 = r130.iterator();
        L26:
            if (r132.hasNext() == false) goto L33;
            String r133 = JSONArrayProtectorUtils.getString(r128, ((IntIterator) r132).nextInt());     // Catch: JSONException -> L30
        L31:
            if (r133 == null) goto L26;
            r131.add(r133);
        L30:
            r133 = null;
            goto L31
        L33:
            List r134 = CollectionsKt.toList(r131);
            int r135 = ac7.b.f2747b;
            r107 = ac7.b.a.a(r134);
            goto L56
        L35:
            if ((r129 instanceof JSONArray) == false) goto L55;
            IntRange r136 = RangesKt.until(0, r128.length());
            ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
            Iterator<Integer> r138 = r136.iterator();
        L38:
            if (r138.hasNext() == false) goto L50;
            JSONArray r139 = JSONArrayProtectorUtils.getJSONArray(r128, ((IntIterator) r138).nextInt());
            IntRange r140 = RangesKt.until(r103, r139.length());
            ArrayList r141 = new ArrayList();
            Iterator<Integer> r142 = r140.iterator();
        L41:
            if (r142.hasNext() == false) goto L49;
            String r143 = JSONArrayProtectorUtils.getString(r139, ((IntIterator) r142).nextInt());     // Catch: JSONException -> L45
        L46:
            if (r143 == null) goto L41;
            r141.add(r143);
        L45:
            r143 = null;
            goto L46
        L49:
            r137.add(CollectionsKt.toList(r141));
            r103 = 0;
            goto L38
        L50:
            List r144 = CollectionsKt.toList(r137);
            int r145 = j.f2756b;
            List r146 = r144;
            ArrayList r147 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r146, 10));
            Iterator r148 = r146.iterator();
        L52:
            if (r148.hasNext() == false) goto L54;
            List r149 = (List) r148.next();
            int r150 = ac7.b.f2747b;
            r147.add(ac7.b.a.a(r149));
            goto L52
        L54:
            r107 = new j(r147);
            goto L56
        L55:
            r107 = ac7.a.f2746a;
            goto L56
        L58:
            throw new IllegalArgumentException("Unknown condition format");
        L59:
            r108 = null;
            goto L60
        L85:
            throw new IllegalArgumentException("Invalid JSON object");
        L86:
            return r100;
        }
    }

    public b(boolean r100, int r101, String r102) {
        this.f269205b = r100;
        this.f269206c = r101;
        this.f269207d = r102;
        this.f269204a = new LinkedHashMap();
    }
}
