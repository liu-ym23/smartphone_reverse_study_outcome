package wy2;

import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.WeakHashMap;
import ny2.a;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a<C extends ny2.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<LynxView, C> f561861a;

    public a() {
        this.f561861a = new WeakHashMap();
    }

    public final C a(LynxView r100) {
        return (C) ((WeakHashMap) this.f561861a).get(r100);
    }
}
