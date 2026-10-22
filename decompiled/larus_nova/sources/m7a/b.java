package m7a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends com.lynx.tasm.event.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f512365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f512366c;

    @Override // com.lynx.tasm.event.a
    public final Map<String, Object> b() {
        HashMap<String, Object> r100 = this.f512366c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new HashMap();
    }

    @Override // com.lynx.tasm.event.a
    public final String c() {
        String r100 = this.f512365b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "params";
    }

    public b(int r100, String r101) {
        super(r100, r101);
    }
}
