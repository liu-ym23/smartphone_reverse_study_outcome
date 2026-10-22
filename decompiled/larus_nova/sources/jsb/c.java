package jsb;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.ss.android.lark.movable.island.ScrollIsland;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollIsland f500277a;

    public c(ScrollIsland r100) {
        this.f500277a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f500277a.f432679c);
    }
}
