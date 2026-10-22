package go2;

import android.text.TextUtils;
import com.bytedance.android.livesdk.performance.l0;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements com.bytedance.android.livesdk.performance.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f481906a;

    public i(l0 r100) {
        this.f481906a = r100;
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (this.f481906a == null) goto L37;
        JSONObject r102 = new JSONObject();
        l0 r103 = this.f481906a;     // Catch: Exception -> L22
        boolean r104 = r103.f154678c;     // Catch: Exception -> L22
        Iterator<T> r105 = r103.f154676a.values().iterator();     // Catch: Exception -> L22
    L8:
        if (r105.hasNext() == false) goto L20;
        l0.a r106 = (l0.a) r105.next();     // Catch: Exception -> L22
        r102.put(r106.f154679a, r106.b());     // Catch: Exception -> L22
        if (r104 == false) goto L8;
        if (r106.f154680b.isEmpty() == true) goto L8;
        if (TextUtils.equals(r106.f154680b.get(IPerformanceManager.CPU_RATE_FOR_MODULE_AVAILABLE), "true") == false) goto L8;
        l0 r107 = this.f481906a;     // Catch: Exception -> L22
        String r108 = r106.f154679a;     // Catch: Exception -> L22
        r107.getClass();     // Catch: Exception -> L22
        if (TextUtils.isEmpty(r108) == true) goto L8;
        r107.f154676a.remove(r108);     // Catch: Exception -> L22
    L20:
        HashMap r109 = (HashMap) r100;
        r109.put(IPerformanceManager.Params.modules, r102.toString());
        r109.put(IPerformanceManager.Params.multi_infos, this.f481906a.f154677b.toString());
        return;
    }
}
