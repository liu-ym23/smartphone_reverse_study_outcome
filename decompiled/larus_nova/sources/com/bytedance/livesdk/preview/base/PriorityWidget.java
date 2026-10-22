package com.bytedance.livesdk.preview.base;

import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/livesdk/preview/base/PriorityWidget;", "Lcom/bytedance/livesdk/preview/base/DynamicWidget;", "<init>", "()V", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PriorityWidget extends DynamicWidget {
    public final void clear() {
        Iterator<T> r100 = this.f256408b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ViewGroup) r100.next()).setLayoutTransition(null);
        goto L4
    L6:
        this.f256408b.clear();
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L11;
        r101.setAlpha(0.0f);
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        r101.setVisibility(0);
        return;
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget
    public final void Iq() {
        clear();
        Intrinsics.throwUninitializedPropertyAccessException("priorityManager");
        throw null;
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget
    public final void Jq() {
        super.Jq();
        clear();
    }

    public PriorityWidget() {
    }
}
