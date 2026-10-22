package jq3;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.product.presenter.element.title.ECWindowProductCardTitleElementDefaultPresenter;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends ECWindowProductCardTitleElementDefaultPresenter {
    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void i0(WindowV2ProductItemVO r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        TextView r0 = (TextView) Z().b(2131387407).f();
        if (((i) this).f.c() != WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE) goto L5;
        r0.setMaxLines(1);
        return;
    L5:
        boolean r2 = false;
        if (r5.o == true) goto L23;
        List r1 = r5.n;
        if (r1 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L23;
        List r4 = r5.f();
        if (r4 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L23;
    L38:
        r0.setMaxLines(2);
        return;
    L18:
        if (r4.isEmpty() == true) goto L21;
        r6 = false;
        goto L22
    L10:
        if (r1.isEmpty() == true) goto L13;
        r3 = false;
    L23:
        List r7 = r5.d();
        if (r7 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == false) goto L39;
        List r9 = r5.e();
        if (r9 != null) goto L34;
    L35:
        r2 = true;
    L36:
        if (r2 == true) goto L38;
    L34:
        if (r9.isEmpty() == false) goto L36;
    L39:
        r0.setMaxLines(1);
        return;
    L26:
        if (r7.isEmpty() == true) goto L29;
        r8 = false;
        goto L30
    }
}
