package t8a;

import com.lynx.tasm.behavior.LynxContext;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements u8a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f545065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, u8a.b> f545066b;

    public c() {
        this.f545066b = new ConcurrentHashMap();
    }

    @Override // u8a.c
    public final u8a.b a(String r100, LynxContext r101) {
        if ("default".equals(r100) == false) goto L10;
        if (this.f545065a != null) goto L8;
        this.f545065a = new a(r101);
    L8:
        return this.f545065a;
    L10:
        return this.f545066b.get(r100);
    }
}
