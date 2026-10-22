package mq1;

import com.bytedance.android.livesdk.chatroom.vs_base.VSDataCenterScopeUtil;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes8.dex */
public final class i0 {
    public static final h0 a(DataCenter r100, Widget r101) {
        ju2.a r102 = VSDataCenterScopeUtil.b(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (h0) com.bytedance.android.scope.m.f163449e.d(r102, h0.class);
    }
}
