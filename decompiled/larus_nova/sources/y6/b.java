package y6;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.f;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b<T extends f<?, ?>> implements f.b, HybridFragment.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f566287a;

    public b() {
    }

    public abstract f<?, ?> b();

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final f<?, ?> a() {
        f<?, ?> r100 = b();
        if ((r100 instanceof f) == false) goto L5;
        T r101 = (T) r100;
    L6:
        this.f566287a = r101;
        return r100;
    L5:
        r101 = null;
        goto L6
    }
}
