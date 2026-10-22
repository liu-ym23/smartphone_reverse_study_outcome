package gq3;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.window.base.product.presenter.element.addCart.ECWindowProductCardAddCartElementPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.repository.vo.b;
import kotlin.jvm.internal.Intrinsics;
import sq3.h;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends ECWindowProductCardAddCartElementPresenter {
    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void d0(WindowV2ProductItemVO r5) {
        if (r5 == null) goto L4;
        ((i) this).j = r5;
    L4:
        ((View) ((ECWindowProductCardAddCartElementPresenter) this).l.getValue()).setOnClickListener(((i) this).k);
        Boolean r1 = null;
        if ((r5 instanceof h) == true) goto L7;
        r5 = null;
    L7:
        h r6 = (h) r5;
        if (r6 == null) goto L22;
        Long r0 = ((WindowV2ProductItemVO) r6).c;
        if (r0 == null) goto L23;
        long r2 = r0.longValue();
        SourceType.Companion.getClass();
        if (SourceType.a.e(r2) == true) goto L20;
        b r7 = ((WindowV2ProductItemVO) r6).z;
        if (r7 == null) goto L17;
        r1 = r7.a;
    L17:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == true) goto L20;
        ((View) ((ECWindowProductCardAddCartElementPresenter) this).l.getValue()).setVisibility(0);
        return;
    L20:
        ((View) ((ECWindowProductCardAddCartElementPresenter) this).l.getValue()).setVisibility(8);
        return;
    L23:
        return;
    }
}
