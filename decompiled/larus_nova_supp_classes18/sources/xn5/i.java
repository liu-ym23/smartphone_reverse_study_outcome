package xn5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;
import com.bytedance.ee.bear.templates.banner.TemplateBannerAdapter;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ TemplateCenterViewModel a;
    public final /* synthetic */ g b;

    public i(TemplateCenterViewModel r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        int r4 = ((Number) r3).intValue();
        if (this.a.getCurrentTab().getValue() != Tab2.SYSTEM) goto L11;
        Banner<Void, TemplateBannerAdapter> r0 = this.b.d;
        if (r0 == null) goto L12;
        if (r4 != 0) goto L8;
        int r5 = 0;
    L9:
        r0.setVisibility(r5);
        return;
    L8:
        r5 = 8;
        goto L9
    L12:
        return;
    }
}
