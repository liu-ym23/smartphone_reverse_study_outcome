package xn5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.banner.banner.Banner;
import com.bytedance.ee.bear.templates.banner.TemplateBannerAdapter;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateCenterViewModel f564629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f564630b;

    public i(TemplateCenterViewModel r100, g r101) {
        this.f564629a = r100;
        this.f564630b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        int r101 = ((Number) r100).intValue();
        if (this.f564629a.getCurrentTab().getValue() != Tab2.SYSTEM) goto L11;
        Banner<Void, TemplateBannerAdapter> r102 = this.f564630b.f564626d;
        if (r102 == null) goto L12;
        if (r101 != 0) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    L12:
        return;
    }
}
