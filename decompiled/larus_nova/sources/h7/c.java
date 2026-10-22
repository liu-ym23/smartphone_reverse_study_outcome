package h7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends com.bytedance.android.anniex.base.lifecycle.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.b f483962a;

    public c(h8.c r100) {
        this.f483962a = r100;
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void a(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        if (r101.getKitType() != KitType.LYNX) goto L5;
        IHybridComponent.HybridType r102 = IHybridComponent.HybridType.LYNX;
    L6:
        View r103 = r101.getKitView();
        if (r103 == null) goto L12;
        b7.b r104 = this.f483962a;
        if (r104 == null) goto L13;
        r104.onAttachView(r103, r102, r101.getViewType());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = IHybridComponent.HybridType.H5;
        goto L6
    }

    @Override // com.bytedance.android.anniex.base.lifecycle.a
    public final void h(String r100, ia.c r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        super.h(r100, r101);
        b7.b r102 = this.f483962a;
        if (r102 == null) goto L6;
        r102.onLoadStart(r101.getKitView(), false);
        return;
    }
}
