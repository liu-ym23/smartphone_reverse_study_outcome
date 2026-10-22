package ak2;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.StartLivePromotionButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements com.bytedance.android.livesdk.livecommerce.room.api.a {
    public final Object a;

    public g(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void a(StartLivePromotionButton r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Object r0 = this.a;
        if ((r0 instanceof wd.f) == false) goto L6;
        ((wd.f) r0).a(r3);
        return;
    L6:
        if ((r0 instanceof IExternalViewGroup) == false) goto L10;
        ((IExternalViewGroup) r0).add(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void b(StartLivePromotionButton r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Object r0 = this.a;
        if ((r0 instanceof wd.f) == false) goto L6;
        ((wd.f) r0).b(r3);
        return;
    L6:
        if ((r0 instanceof IExternalViewGroup) == false) goto L10;
        ((IExternalViewGroup) r0).remove(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void c(Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.a;
        if ((r0 instanceof wd.f) == false) goto L6;
        ((wd.f) r0).addListener(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.api.a
    public final void d(Function3<? super wd.f, ? super wd.e, ? super ECExternalViewGroupAction, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Object r0 = this.a;
        if ((r0 instanceof wd.f) == false) goto L6;
        ((wd.f) r0).removeListener(r3);
        return;
    }
}
