package uc5;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface f2 extends com.bytedance.ee.bear.list.list.f<a>, l3 {

    public interface a extends com.bytedance.ee.bear.list.list.f.a, ForbiddenBannerView.a {
        void u0(View r1, int r2, Document r3, boolean r4);
    }

    void f0(ForbiddenBannerView.ForbiddenState r1);

    void j();

    void u(Document r1);

    boolean x();
}
