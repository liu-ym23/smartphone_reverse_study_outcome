package uc5;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public interface f2 extends com.bytedance.ee.bear.list.list.f<a>, l3 {

    public interface a extends com.bytedance.ee.bear.list.list.f.a, ForbiddenBannerView.a {
        void u0(View r100, int r101, Document r102, boolean r103);
    }

    void f0(ForbiddenBannerView.ForbiddenState r100);

    void j();

    void u(Document r100);

    boolean x();
}
