package t4a;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f544609a;

    public c(Map<String, Object> r100) {
        this.f544609a = r100;
    }

    public final float a(String r100) {
        Object r101 = this.f544609a.get(r100);
        if ((r101 instanceof Number) == true) goto L7;
        return -1.0f;
    L7:
        return ((Number) r101).floatValue();
    }
}
