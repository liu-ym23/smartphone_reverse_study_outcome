package t4a;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends c {
    public final int b() {
        Object r100 = this.f544609a.get("code");
        if ((r100 instanceof Number) == true) goto L7;
        return -1;
    L7:
        return ((Number) r100).intValue();
    }

    public a(Map<String, Object> r100) {
        super(r100);
    }
}
