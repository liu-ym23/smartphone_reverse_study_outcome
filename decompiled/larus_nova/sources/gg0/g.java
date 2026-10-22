package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPaidViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends b<MultiLinkPaidViewBinder.a> {
    public g() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r100, tf0.e r101) {
        MultiLinkPaidViewBinder.a r102 = (MultiLinkPaidViewBinder.a) r100;
        MultiLinkPaidViewBinder.a r103 = (MultiLinkPaidViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.f75974k.getPaidCount() != r103.f75974k.getPaidCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gg0.b
    public final boolean b(tf0.e r100, tf0.e r101) {
        MultiLinkPaidViewBinder.a r102 = (MultiLinkPaidViewBinder.a) r100;
        MultiLinkPaidViewBinder.a r103 = (MultiLinkPaidViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        return Intrinsics.areEqual(r102.f75974k.getInteractId(), r103.f75974k.getInteractId());
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r100, tf0.e r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter((MultiLinkPaidViewBinder.a) r100, "oldItem");
        Intrinsics.checkNotNullParameter((MultiLinkPaidViewBinder.a) r101, "newItem");
        return new Bundle();
    }
}
