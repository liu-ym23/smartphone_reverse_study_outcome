package hlc;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z.b<String, IEffectPlatformBaseListener<?>> f485705a;

    public a() {
        this.f485705a = new z.b(true);
    }

    public final <T> IEffectPlatformBaseListener<T> a(String r100) {
        Object r101 = this.f485705a.get(r100);
        if ((r101 instanceof IEffectPlatformBaseListener) == true) goto L5;
        r101 = null;
    L5:
        IEffectPlatformBaseListener<T> r102 = (IEffectPlatformBaseListener) r101;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102;
    }

    public final void c(String r100) {
        this.f485705a.remove(r100);
    }

    public final <T> void b(String r100, IEffectPlatformBaseListener<T> r101) {
        this.f485705a.put(r100, r101);
    }
}
