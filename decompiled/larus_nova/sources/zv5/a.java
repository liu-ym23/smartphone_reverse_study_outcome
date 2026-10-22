package zv5;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f573694c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f573695b;

    static {
        f573694c = new a();
    }

    @Override // zv5.c
    public final ComponentFeature c0(f r100) {
        return this.f573695b.c0(r100);
    }

    public a() {
        pd6.b r100 = pd6.c.f528682a;
        c r101 = (c) pd6.c.a(Reflection.getOrCreateKotlinClass(c.class));
        if (r101 != null) goto L5;
        r101 = new b();
    L5:
        this.f573695b = r101;
    }
}
