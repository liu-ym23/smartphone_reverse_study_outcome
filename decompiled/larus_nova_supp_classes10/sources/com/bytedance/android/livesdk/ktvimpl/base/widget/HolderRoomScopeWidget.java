package com.bytedance.android.livesdk.ktvimpl.base.widget;

import be2.a;
import com.bytedance.android.livesdk.ktvapi.HolderRoomWidget;
import com.bytedance.android.scope.m;
import dn0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/widget/HolderRoomScopeWidget;", "Lcom/bytedance/android/livesdk/ktvapi/HolderRoomWidget;", "Lbe2/a;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class HolderRoomScopeWidget extends HolderRoomWidget implements a {
    public HolderRoomScopeWidget() {
    }

    @Override // be2.a
    public final <T extends b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        bn0.b r0 = ((HolderRoomWidget) this).b;
        b r1 = null;
        if (r0 == null) goto L20;
        m r2 = m.e;
        Intrinsics.checkNotNull(r0);
        b r3 = (b) r2.d(r0, r4);
        if (r3 != null) goto L11;
        Object r5 = ((HolderRoomWidget) this).c.get(r4);
        if ((r5 instanceof b) == true) goto L9;
        r5 = null;
    L9:
        r3 = (b) r5;
    L11:
        if (((HolderRoomWidget) this).c.containsKey(r4) == true) goto L19;
        if ((r3 instanceof b) == false) goto L16;
        r1 = r3;
    L16:
        if (r1 == null) goto L19;
        ((HolderRoomWidget) this).c.put(r4, r1);
    L19:
        return (T) r3;
    L20:
        return null;
    }
}
