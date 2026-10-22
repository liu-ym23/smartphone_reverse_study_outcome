package yt1;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T extends View> implements f<T> {
    public a() {
    }

    @Override // yt1.f
    public int getType() {
        return 2;
    }

    @Override // yt1.f
    public final <D> void a(b<D, T> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewDelegate");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        int r102 = zt1.a.f573562e;
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        Object r103 = null;
        String r104 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r101, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, null);
        String r105 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r101, "container_name", null);
        String r106 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r101, "component_name", null);
        String r107 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r101, "component_params", null);
        zt1.a r108 = new zt1.a();
        r108.f573563a = r104;
        r108.f573564b = r105;
        r108.f573565c = r106;
        r108.f573566d = r107;
        Object r109 = r100.f569026b;
        if ((r109 instanceof d) == false) goto L6;
        r103 = r109;
    L6:
        d r110 = (d) r103;
        if (r110 == null) goto L10;
        r110.setContainerData(r108);
        return;
    }

    @Override // yt1.f
    public final void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r100, com.bytedance.android.ecom.arch.slice.render.elements.g r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "viewManger");
        Intrinsics.checkNotNullParameter(r101, "childViewManager");
        Intrinsics.checkNotNullParameter(r100, "viewManger");
        Intrinsics.checkNotNullParameter(r101, "childViewManager");
    }
}
