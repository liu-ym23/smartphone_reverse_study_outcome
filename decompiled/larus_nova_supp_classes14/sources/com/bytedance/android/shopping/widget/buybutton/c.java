package com.bytedance.android.shopping.widget.buybutton;

import android.view.View;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.promotion.ECResultDialogContentVO;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r2, String r3, Integer r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            r2.h(r3, r4);
        }
    }

    void a(SingleClickParam r1, ClickButtonParam r2, com.bytedance.android.btm.api.model.d r3);

    void b(String r1, Map<String, String> r2, Map<String, String> r3);

    void c(com.bytedance.android.shopping.widget.buybutton.a r1);

    void d(ECResultDialogContentVO r1);

    void e(int r1, long r2);

    void f(String r1);

    void g(String r1);

    void h(String r1, Integer r2);

    boolean openMiniApp(String r1);

    void setBuyButtonClickListener(List<? extends View.OnClickListener> r1);

    void setProductAreaVisible(boolean r1);

    void setProductTitleClickListener(View.OnClickListener r1);
}
