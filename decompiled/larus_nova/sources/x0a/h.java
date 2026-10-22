package x0a;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<j, Integer, Unit> f562065a;

    public h(com.larus.ugc.feed.impl.quickmenu.doSame.c r100) {
        this.f562065a = r100;
    }

    @Override // x0a.c
    public final void a(j r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f562065a.invoke(r100, Integer.valueOf(r101));
    }
}
