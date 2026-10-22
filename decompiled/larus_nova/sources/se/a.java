package se;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.ec.adapter.impl.converter.c;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import wd.e;
import wd.f;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalViewGroup f541536a;

    public a(IExternalViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "liveViewGroup");
        this.f541536a = r100;
    }

    @Override // wd.f
    public final void a(StartLivePromotionButton r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IExternalViewGroup r101 = this.f541536a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.add(c.C0779c.f42773b.a(r100));
    }

    @Override // wd.f
    public final void addListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IExternalViewGroup r101 = this.f541536a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.addListener((Function3) c.d.f42774b.a(r100));
    }

    @Override // wd.f
    public final void b(StartLivePromotionButton r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IExternalViewGroup r101 = this.f541536a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.remove(c.C0779c.f42773b.b(r100));
    }

    @Override // wd.f
    public final void removeListener(Function3<? super f, ? super e, ? super ECExternalViewGroupAction, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IExternalViewGroup r101 = this.f541536a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.removeListener((Function3) c.d.f42774b.b(r100));
    }
}
