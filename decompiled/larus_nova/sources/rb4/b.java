package rb4;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f536915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f536916b;

    public final void a() {
        JSONObject r100 = new JSONObject(this.f536915a);     // Catch: Exception -> L29
        JSONObject r101 = r100.optJSONObject("common");     // Catch: Exception -> L29
        int r102 = 0;
        if (r101 == null) goto L9;
        AtomicBoolean r103 = this.f536916b.f536923e;     // Catch: Exception -> L29
        boolean r104 = true;
        if (r101.optInt("use_cache", 0) == 1) goto L8;
        r104 = false;
    L8:
        r103.set(r104);     // Catch: Exception -> L29
    L9:
        c r105 = this.f536916b;     // Catch: Exception -> L29
        if (r105.f536923e.get() == false) goto L12;
        int r106 = 0;
    L13:
        r105.f536925g = r106;     // Catch: Exception -> L29
        JSONArray r107 = r100.optJSONArray("h5_resources");     // Catch: Exception -> L29
        if (r107 != null) goto L16;
    L21:
        ArrayList r108 = null;
    L22:
        if (r108 != null) goto L24;
        return;
    L24:
        if (r108.size() <= 0) goto L37;
    L25:
        if (r102 >= r108.size()) goto L38;
        c.b(this.f536916b, (h) ListProtector.get(r108, r102));     // Catch: Exception -> L29
        r102 = r102 + 1;
        goto L25
    L38:
        return;
    L37:
        return;
    L16:
        if (r107.length() <= 0) goto L21;
        r108 = new ArrayList();     // Catch: Exception -> L29
        int r109 = 0;
    L19:
        if (r109 >= r107.length()) goto L22;
        JSONObject r110 = JSONArrayProtectorUtils.getJSONObject(r107, r109);     // Catch: Exception -> L29
        h r111 = new h();     // Catch: Exception -> L29
        r111.f536933a = r110.optString("name");     // Catch: Exception -> L29
        r111.f536934b = r110.optString("url");     // Catch: Exception -> L29
        r111.f536935c = JSONObjectProtectorUtils.getString(r110, "md5");     // Catch: Exception -> L29
        r108.add(r111);     // Catch: Exception -> L29
        r109 = r109 + 1;     // Catch: Exception -> L29
        goto L19
    L12:
        r106 = 2;
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, String r101) {
        this.f536916b = r100;
        this.f536915a = r101;
    }
}
