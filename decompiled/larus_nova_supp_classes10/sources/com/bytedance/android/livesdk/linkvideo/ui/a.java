package com.bytedance.android.livesdk.linkvideo.ui;

import android.widget.Button;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.utils.v6;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import jc1.k;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ LinkVideoDialog a;

    public a(LinkVideoDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        gf2.a r4 = (gf2.a) r3;
        Button r0 = this.a.n;
        if (r0 == null) goto L8;
        if (r4 == null) goto L6;
        int r1 = 0;
    L7:
        r0.setVisibility(r1);
        goto L8
    L6:
        r1 = 8;
    L8:
        MultiTypeAdapter r2 = this.a.z;
        if (r2 == null) goto L11;
        r2.notifyDataSetChanged();
    L11:
        if (r4 == null) goto L18;
        IRoomModuleService r5 = k.f(IRoomModuleService.class);
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.linkvideo.b r6 = r5.getLinkVideoTea();
        if (r6 == null) goto L20;
        r6.a("related_video", v6.a());
        return;
    L20:
        return;
    L19:
        return;
    }
}
