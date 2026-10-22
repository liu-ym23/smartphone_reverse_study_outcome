package uy2;

import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<LynxView, b> f552089a;

    public a() {
        this.f552089a = new WeakHashMap();
    }

    public final b a(LynxView r100) {
        return (b) ((WeakHashMap) this.f552089a).get(r100);
    }
}
