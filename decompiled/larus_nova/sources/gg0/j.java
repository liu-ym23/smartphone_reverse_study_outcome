package gg0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSelfDisciplineEndViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j extends b<MultiLinkSelfDisciplineEndViewBinder.a> {
    public j() {
    }

    @Override // gg0.b
    public final boolean b(tf0.e r100, tf0.e r101) {
        MultiLinkSelfDisciplineEndViewBinder.a r102 = (MultiLinkSelfDisciplineEndViewBinder.a) r100;
        MultiLinkSelfDisciplineEndViewBinder.a r103 = (MultiLinkSelfDisciplineEndViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (Intrinsics.areEqual(r102.f75980k.getInteractId(), r103.f75980k.getInteractId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r102.f75981l != r103.f75981l) goto L7;
        return true;
    }
}
