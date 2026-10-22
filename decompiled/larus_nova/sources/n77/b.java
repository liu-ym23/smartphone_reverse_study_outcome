package n77;

import com.bytedance.common.push.BaseJson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends BaseJson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f518206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f518207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Integer> f518208c;

    public final String toString() {
        JSONObject r100 = new JSONObject();
        add(r100, "delay_start_child_process_mode", this.f518206a);
        add(r100, "delay_start_child_process_timeout_in_mill", this.f518207b);
        JSONArray r101 = new JSONArray();
        Iterator<Integer> r102 = this.f518208c.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.put(r102.next());
        goto L4
    L6:
        add(r100, "need_disable_channel", r101);
        return r100.toString();
    }

    public b() {
        this.f518206a = 0;
        this.f518207b = 300000;
        this.f518208c = new ArrayList();
    }

    public b(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L10
        this.f518206a = r101.optInt("delay_start_child_process_mode", 0);     // Catch: Throwable -> L10
        this.f518207b = r101.optLong("delay_start_child_process_timeout_in_mill", 300000);     // Catch: Throwable -> L10
        JSONArray r102 = r101.optJSONArray("need_disable_channel");     // Catch: Throwable -> L10
        this.f518208c = new ArrayList();     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        int r103 = 0;
    L7:
        if (r103 >= r102.length()) goto L17;
        List<Integer> r104 = this.f518208c;     // Catch: Throwable -> L10
        ArrayList r105 = (ArrayList) r104;     // Catch: Throwable -> L10
        r105.add((Integer) r102.get(r103));     // Catch: Throwable -> L10
        r103 = r103 + 1;
        goto L7
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
        this.f518206a = 0;
        this.f518207b = 300000;
        this.f518208c = new ArrayList();
    }
}
