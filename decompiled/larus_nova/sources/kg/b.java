package kg;

import android.view.View;
import com.alipay.sdk.m.p.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import qf3.i;
import ti.d;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd.b f503343a;

    @Override // ti.d
    public final View getHybridView() {
        View r100 = this.f503343a.getHybridView();
        if (r100 != null) goto L5;
        Object r101 = "null";
    L6:
        r101.toString();
        return r100;
    L5:
        r101 = r100;
        goto L6
    }

    @Override // ti.d
    public final void release() {
        this.f503343a.release();
    }

    public b(pd.b r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f503343a = r100;
        a.a("ECAnnieComponent");
    }

    @Override // ti.d
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter("H5_visibilityChange", "event");
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f503343a.sendJsEvent("H5_visibilityChange", r100);
    }

    @Override // ti.d
    public final void b(i r100) {
        Intrinsics.checkNotNullParameter("mallEndRefresh", "name");
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        this.f503343a.registerMethod("mallEndRefresh", r100);
    }

    @Override // ti.d
    public final void load(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f503343a.load(r100, r101);
    }
}
