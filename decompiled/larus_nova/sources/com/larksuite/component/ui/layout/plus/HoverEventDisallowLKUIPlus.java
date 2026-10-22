package com.larksuite.component.ui.layout.plus;

import android.view.MotionEvent;
import com.larksuite.component.ui.layout.ILKUILayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/larksuite/component/ui/layout/plus/HoverEventDisallowLKUIPlus;", "Lcom/larksuite/component/ui/layout/plus/BaseInnerPlus;", "layout", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "<init>", "(Lcom/larksuite/component/ui/layout/ILKUILayout;)V", "getPlusType", "Lcom/larksuite/component/ui/layout/plus/InnerPlusType;", "onDelegateInterceptHoverEvent", "", "event", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HoverEventDisallowLKUIPlus extends BaseInnerPlus {
    @Override // com.larksuite.component.ui.layout.plus.BaseInnerPlus
    public InnerPlusType getPlusType() {
        return InnerPlusType.HOVER_EVENT_DISALLOW;
    }

    public HoverEventDisallowLKUIPlus(ILKUILayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        super(r100);
    }

    @Override // com.larksuite.component.ui.layout.plus.a
    public Boolean onDelegateInterceptHoverEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return Boolean.TRUE;
    }
}
