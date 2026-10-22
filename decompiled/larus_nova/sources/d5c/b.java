package d5c;

import com.baidu.platform.comapi.map.MapController;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<d> f467097a;

    public b() {
        this.f467097a = new LinkedList();
    }

    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f467097a.add(r100);
    }
}
