package hw4;

import android.view.View;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonPanelAdapter;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonMorePanelItemData f487414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommonPanelAdapter f487415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f487416c;

    public c(CommonMorePanelItemData r100, CommonPanelAdapter r101, int r102) {
        this.f487414a = r100;
        this.f487415b = r101;
        this.f487416c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CommonMorePanelItemData r101 = this.f487414a;
        if (r101.f216785f == false) goto L8;
        d r102 = this.f487415b.f216790c;
        if (r102 == null) goto L9;
        r102.a(this.f487416c, r101);
        return;
    L9:
        return;
    }
}
