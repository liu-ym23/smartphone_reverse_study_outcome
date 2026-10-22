package fk4;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
import pk4.i;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f477639a;

    public d() {
        this.f477639a = new Object();
    }

    public static boolean d(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static LinkedHashMap e(String r100) throws Exception {
        LinkedHashMap r101 = new LinkedHashMap();
        i r102 = i.a.f529628a;
        String r103 = r102.f529627a.getString("offline_record_synced_records_" + ek4.a.b(r100), "");
        if (d(r103) == false) goto L18;
        return r101;
    L18:
        JSONArray r104 = new JSONArray(r103);     // Catch: Throwable -> L15
        int r105 = 0;
    L7:
        if (r105 >= r104.length()) goto L14;
        c r106 = a(r104.optJSONObject(r105), r100);     // Catch: Throwable -> L15
        if (r106 == null) goto L13;
        if (d(r106.f477618a) == true) goto L13;
        r101.put(r106.f477618a, r106);     // Catch: Throwable -> L15
    L13:
        r105 = r105 + 1;
        goto L7
    L14:
        return r101;
    L15:
        th = move-exception;
        throw new IllegalStateException("Parse offline record delivery store failed, length=" + r103.length(), th);
    }

    public static c a(JSONObject r210, String r310) {
        if (r210 != null) goto L5;
        return null;
    L5:
        String r100 = r210.optString("online_record_id");
        String r101 = r210.optString("record_id");
        if (d(r100) == false) goto L8;
        String r102 = null;
    L10:
        return new c(r101, r102, r210.optString("local_file_path"), r210.optInt("file_type"), r210.optLong("start_time_ms"), r210.optLong("end_time_ms"), r210.optLong("duration_ms"), r210.optLong("file_size"), r210.optLong(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT), r210.optInt("channels"), r210.optInt("bits", 16), r210.optInt("com_ratio", 8), r210.optInt("frame_size"), r210.optInt("packet_size"), r210.optInt("com_packet_size"), r210.optString("checksum"), r210.optLong("created_at_ms", System.currentTimeMillis()), r310);
    L8:
        r102 = r100;
        goto L10
    }

    public static boolean c(c r100, c r101) {
        if (r100 != null) goto L4;
    L38:
        return false;
    L4:
        if (Objects.equals(r100.f477618a, r101.f477618a) == false) goto L38;
        if (Objects.equals(r100.f477619b, r101.f477619b) == false) goto L38;
        if (Objects.equals(r100.f477620c, r101.f477620c) == false) goto L38;
        if (r100.f477621d != r101.f477621d) goto L38;
        if (r100.f477622e != r101.f477622e) goto L38;
        if (r100.f477623f != r101.f477623f) goto L38;
        if (r100.f477624g != r101.f477624g) goto L38;
        if (r100.f477625h != r101.f477625h) goto L38;
        if (r100.f477626i != r101.f477626i) goto L38;
        if (r100.f477627j != r101.f477627j) goto L38;
        if (r100.f477628k != r101.f477628k) goto L38;
        if (r100.f477629l != r101.f477629l) goto L38;
        if (r100.f477630m != r101.f477630m) goto L38;
        if (r100.f477632o != r101.f477632o) goto L38;
        if (r100.f477633p != r101.f477633p) goto L38;
        if (Objects.equals(r100.f477636s, r101.f477636s) == false) goto L38;
        if (r100.f477637t != r101.f477637t) goto L38;
        return true;
    }

    public static void g(Collection r100, String r101) throws Exception {
        JSONArray r102 = new JSONArray();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        c r104 = (c) r103.next();
        JSONObject r105 = new JSONObject();
        r105.put("record_id", r104.f477618a);
        String r106 = r104.f477619b;
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r105.put("online_record_id", r106);
        r105.put("local_file_path", r104.f477620c);
        r105.put("file_type", r104.f477621d);
        r105.put("start_time_ms", r104.f477622e);
        r105.put("end_time_ms", r104.f477623f);
        r105.put("duration_ms", r104.f477624g);
        r105.put("file_size", r104.f477625h);
        r105.put(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r104.f477626i);
        r105.put("channels", r104.f477627j);
        r105.put("bits", r104.f477628k);
        r105.put("com_ratio", r104.f477629l);
        r105.put("frame_size", r104.f477630m);
        r105.put("packet_size", r104.f477632o);
        r105.put("com_packet_size", r104.f477633p);
        r105.put("checksum", r104.f477636s);
        r105.put("created_at_ms", r104.f477637t);
        r102.put(r105);
        goto L4
    L9:
        i r107 = i.a.f529628a;
        r107.f529627a.storeString("offline_record_synced_records_" + ek4.a.b(r101), r102.toString());
    }

    public final c b(String r100, String r101) {
        if (d(r101) == false) goto L23;
    L21:
        return null;
    L23:
        Object r102 = this.f477639a;     // Catch: Throwable -> L19
        monitor-enter(r102);     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L7:
        if (ek4.a.a(r100) == true) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L16
        return null;
    L10:
        c r103 = (c) e(r100).get(r101);     // Catch: Throwable -> L16
        if (ek4.a.a(r100) == true) goto L14;
        r103 = null;
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return r103;
    L19:
        th = move-exception;
        j.c("OfflineRecordDeliveryStore", "Read offline record delivery failed, recordId=" + r101, th);
        goto L21
    }

    public final boolean f(String r100, String r101) {
        if (d(r101) == true) goto L24;
        Object r102 = this.f477639a;     // Catch: Throwable -> L18
        monitor-enter(r102);     // Catch: Throwable -> L18
        LinkedHashMap r103 = e(r100);     // Catch: Throwable -> L15
        if (r103.remove(r101) != null) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L15
        return true;
    L10:
        g(r103.values(), r100);     // Catch: Throwable -> L15
        boolean r104 = !e(r100).containsKey(r101);     // Catch: Throwable -> L15
        if (r104 == true) goto L13;
        j.b("OfflineRecordDeliveryStore", "Verify offline record delivery removal failed, recordId=" + r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L15
        return r104;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        j.c("OfflineRecordDeliveryStore", "Remove offline record delivery failed, recordId=" + r101, th);
        return false;
    L24:
        return false;
    }
}
