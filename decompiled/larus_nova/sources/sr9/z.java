package sr9;

import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.platform.api.creation.TplType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class z implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f543272a = null;

    static {
        f543272a = new z();
    }

    public z() {
    }

    @Override // sr9.e0
    public final void l0(CommonMenu r100) {
        Intrinsics.checkNotNullParameter(r100, TplType.MENU);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ot8.a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return Unit.INSTANCE;
    }
}
