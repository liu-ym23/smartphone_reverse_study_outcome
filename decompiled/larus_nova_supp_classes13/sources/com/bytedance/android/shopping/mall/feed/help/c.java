package com.bytedance.android.shopping.mall.feed.help;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ EventExposureTime a;

    public c(EventExposureTime r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        EventExposureTime r4 = this.a;
        r4.b = System.currentTimeMillis();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Iterator<T> r6 = this.a.a.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        BaseViewHolder r0 = (BaseViewHolder) r6.next();
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a.j).get(r0), Boolean.TRUE) == false) goto L4;
        this.a.j.put(r0, Boolean.FALSE);
        ECHybridListItemVO r1 = r0.c;
        if (r1 == null) goto L10;
        r1.N = System.currentTimeMillis();
    L10:
        JSONObject r2 = this.a.i(r0);
        if (r2 == null) goto L4;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r2);
        goto L4
    L13:
        EventExposureTime r7 = this.a;
        r7.l(r7.b, System.currentTimeMillis());
    }
}
