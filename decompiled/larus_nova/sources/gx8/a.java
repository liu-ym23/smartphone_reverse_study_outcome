package gx8;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f483123a;

    public abstract d b();

    public a() {
        c r100 = new c();
        this.f483123a = new b(r100);
        r100.f483126a = b();
    }

    public final void c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f483123a.c(r100);
    }

    public final void a(e r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extraAttributes");
        b r102 = this.f483123a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extraAttributes");
        Map<String, Long> r103 = r102.f483125b;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        Long r105 = (Long) r104.get(r100.getUniqueKey());
        if (r105 == null) goto L6;
        long r106 = r105.longValue();
        r101.put("duration", System.currentTimeMillis() - r106);
        r101.put("type", r100.getEventType());
        r102.f483124a.a(r100.getUploadName(), r101);
        return;
    }
}
