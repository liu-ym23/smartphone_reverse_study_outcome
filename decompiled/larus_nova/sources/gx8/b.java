package gx8;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f483124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f483125b;

    public b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "uploader");
        this.f483124a = r100;
        this.f483125b = new LinkedHashMap();
    }

    public final void c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f483125b.put(r100.getUniqueKey(), Long.valueOf(System.currentTimeMillis()));
    }

    public final void a(e r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extraAttributes");
        Map<String, Long> r102 = this.f483125b;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        Long r104 = (Long) r103.get(r100.getUniqueKey());
        if (r104 == null) goto L6;
        long r105 = r104.longValue();
        r101.put("duration", System.currentTimeMillis() - r105);
        r101.put("type", r100.getEventType());
        this.f483124a.a(r100.getUploadName(), r101);
        Long r106 = this.f483125b.remove(r100.getUniqueKey());
        return;
    }

    public final void b(e r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extraAttributes");
        r101.put("type", r100.getEventType());
        this.f483124a.a(r100.getUploadName(), r101);
    }
}
