package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface n extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void J2(iq5.o r1);

        void M5();

        void V3();

        void a6(View r1, int r2, td5.e r3);

        void h2();

        void k6();

        void onCancelClick();

        void p();

        void r3();
    }

    void I(List<? extends Document> r1);

    void u1(List<? extends RecentOperationResult.a> r1);
}
