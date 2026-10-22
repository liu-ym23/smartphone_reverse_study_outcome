package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.DragLinearLayout;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public s(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        DragLinearLayout r0 = this.a.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("interactElementContainer");
    L5:
        r0.setDraggable(r4.booleanValue());
    }
}
