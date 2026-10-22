package hw4;

import android.view.View;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonPanelAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CommonMorePanelItemData a;
    public final /* synthetic */ CommonPanelAdapter b;
    public final /* synthetic */ int c;

    public c(CommonMorePanelItemData r1, CommonPanelAdapter r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        CommonMorePanelItemData r4 = this.a;
        if (r4.f == false) goto L8;
        d r0 = this.b.c;
        if (r0 == null) goto L9;
        r0.a(this.c, r4);
        return;
    L9:
        return;
    }
}
