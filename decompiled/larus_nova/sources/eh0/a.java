package eh0;

import ch0.e;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f472636a;

    public a() {
    }

    @Override // eh0.c
    public abstract h.a a(List<e> r100);

    public final b b() {
        b r100 = this.f472636a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        return r100;
    }

    public final void c() {
        b r100 = this.f472636a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        h.a r101 = a(r100.d());
        if (r101.f76438a == false) goto L12;
        b r102 = this.f472636a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L10:
        r102.m(r101);
        return;
    }
}
