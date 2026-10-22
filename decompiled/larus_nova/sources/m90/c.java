package m90;

import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.depend.prefs.PropertyCache;
import java.util.EnumMap;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap<LiveEffectContextFactoryDelegate$Type, Property<T>> f512569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f512571c;

    @Override // m90.a
    public final T b(LiveEffectContextFactoryType r100) {
        return c((LiveEffectContextFactoryDelegate$Type) ((IMiddlewareEffectService) k.f(IMiddlewareEffectService.class)).convertLiveEffectContextFactoryType(r100));
    }

    public final T c(LiveEffectContextFactoryDelegate$Type r100) {
        if (r100 != null) goto L4;
        r100 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
    L4:
        d(r100);
        Property<T> r101 = this.f512569a.get(r100);
        T r102 = (T) f.b(r101);
        if (r102 != null) goto L8;
        T r103 = (T) PropertyCache.getValue(r101);
        e(r100, r103);
        return r103;
    L8:
        return r102;
    }

    public final void d(LiveEffectContextFactoryDelegate$Type r100) {
        if (this.f512569a.containsKey(r100) == false) goto L8;
        if (this.f512569a.get(r100) == null) goto L8;
        return;
    L8:
        if (r100.getSpName() != null) goto L10;
        this.f512569a.put(r100, new Property(this.f512570b, this.f512571c));
        return;
    L10:
        this.f512569a.put(r100, new Property(r100.getSpName(), this.f512570b, this.f512571c));
    }

    public c(String r100, T r101) {
        this.f512569a = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        this.f512570b = r100;
        this.f512571c = r101;
    }

    @Override // m90.a
    public final void a(LiveEffectContextFactoryType r100, T r101) {
        e((LiveEffectContextFactoryDelegate$Type) ((IMiddlewareEffectService) k.f(IMiddlewareEffectService.class)).convertLiveEffectContextFactoryType(r100), r101);
    }

    public final void e(LiveEffectContextFactoryDelegate$Type r100, T r101) {
        if (r100 != null) goto L4;
        r100 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
    L4:
        d(r100);
        f.d(this.f512569a.get(r100), r101);
    }
}
