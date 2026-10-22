package ke1;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f502998a;

    public c(e r100) {
        this.f502998a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r102 = com.bytedance.android.live.core.monitor.trace.e.b.a("live_tb_trace", "live_tb_biz");
        r102.f65012c = "webcast_client_community";
        r102.f65017h = 0;
        r102.f65018i = "";
        e r103 = this.f502998a;
        r102.f65014e = r103.f503009d;
        r102.f65016g = d.f502999b;
        r102.f65015f = r103.f503010e;
        if (r103.f503007b == false) goto L5;
        String r104 = "1";
    L6:
        r102.b("important", r104);
        com.bytedance.android.live.core.monitor.trace.e r105 = r102.a();
        e r106 = this.f502998a;
        r106.getClass();
        JSONObject r107 = new JSONObject();
        JSONArray r108 = new JSONArray();
        Iterator r109 = ((ArrayList) r106.f503006a).iterator();
    L8:
        if (r109.hasNext() == false) goto L21;
        f r110 = (f) r109.next();
        r110.getClass();
        JSONObject r111 = new JSONObject();
        String r112 = r110.f503012b;
        if (r112 == null) goto L12;
        r111.put("info", r112);
    L12:
        Iterator r113 = ((LinkedHashMap) r110.f503013c).entrySet().iterator();
    L14:
        if (r113.hasNext() == false) goto L20;
        Map.Entry r114 = (Map.Entry) r113.next();
        String r115 = (String) r114.getKey();
        Object r116 = r114.getValue();
        if (r116 == null) goto L18;
        String r117 = r116.toString();
    L19:
        r111.put(r115, r117);
        goto L14
    L18:
        r117 = null;
        goto L19
    L20:
        r108.put(r111.toString());
        goto L8
    L21:
        Unit r118 = Unit.INSTANCE;
        r107.put("trace_nodes", r108);
        com.bytedance.android.live.core.monitor.trace.c.b(r105, r107);
        r100.onSuccess(Unit.INSTANCE);
        return;
    L5:
        r104 = "0";
        goto L6
    }
}
