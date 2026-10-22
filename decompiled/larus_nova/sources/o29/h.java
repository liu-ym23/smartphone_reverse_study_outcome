package o29;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<j, Integer, Unit> f521804a;

    public h(com.larus.community.impl.quickmenu.doSame.c r100) {
        this.f521804a = r100;
    }

    @Override // o29.c
    public final void a(j r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f521804a.invoke(r100, Integer.valueOf(r101));
    }
}
