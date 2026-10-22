package q10;

import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelType f531265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PanelType f531266b;

    public a(PanelType r100, PanelType r101) {
        Intrinsics.checkNotNullParameter(r100, "fromPanelType");
        Intrinsics.checkNotNullParameter(r101, "toPanelType");
        this.f531265a = r100;
        this.f531266b = r101;
    }
}
