package dwa;

import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class k implements a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f470391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f470392b;

    public k(j r100, int r101) {
        this.f470392b = r100;
        this.f470391a = r101;
    }

    @Override // dwa.a.e
    public final void a(View r100, int r101) {
        if (r100 != null) goto L13;
        String r102 = this.f470392b.f470383c.getResourceEntryName(this.f470391a);
        if (TextUtils.isEmpty(r102) == true) goto L20;
        JSONObject r103 = new JSONObject();
        r103.put("preload_failed_layout", r102);     // Catch: JSONException -> L9
        com.ss.android.lark.h.a().sendEvent("preload_xml_failed", r103);     // Catch: JSONException -> L9
    L11:
        Log.w("InflaterHitPoint", "sendPreloadFailEvent:" + r102);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L20:
        return;
    L13:
        ConcurrentLinkedQueue<View> r104 = this.f470392b.f470386f.get(Integer.valueOf(r101));
        Log.d("PreLoadAsyncInflater", "onInflateFinished1:" + r104);
        if (r104 != null) goto L16;
        r104 = new ConcurrentLinkedQueue();
        this.f470392b.f470386f.put(Integer.valueOf(r101), r104);
    L16:
        r104.offer(r100);
    }
}
