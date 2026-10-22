package kr2;

import com.bytedance.android.livesdk.log.m0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f505703a;

    public b() {
        this.f505703a = new m0();
    }

    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "adExtra");
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        Map<String, String> r104 = this.f505703a.f153381a;
        HashMap r105 = (HashMap) r104;
        r105.put("ad_extra_data", r101.toString());
    }

    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f505703a.c(r100);
    }
}
