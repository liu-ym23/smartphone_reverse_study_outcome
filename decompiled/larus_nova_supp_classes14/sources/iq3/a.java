package iq3;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.extensions.b;
import kotlin.jvm.internal.Intrinsics;
import yo.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends i<WindowV2ProductItemVO> implements View.OnClickListener {

    /* JADX INFO: renamed from: iq3.a$a, reason: collision with other inner class name */
    public static final class C0137a {
    }

    static {
    }

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void d0(WindowV2ProductItemVO r6) {
        if (r6 == null) goto L22;
        TextView r0 = (TextView) Z().b(2131386244).f();
        int r1 = r6.y;
        if (r1 > 5) goto L20;
        if (r1 == 0) goto L20;
        r0.setVisibility(0);
        r0.setText(String.valueOf(r6.y));
        int r7 = r6.y;
        if (r7 != 1) goto L10;
        int r2 = 2131234747;
    L16:
        if (r7 > 3) goto L18;
        int r8 = b.b(13);
    L19:
        r0.setPadding(r0.getPaddingLeft(), r8, r0.getPaddingRight(), r0.getPaddingBottom());
        r0.setBackgroundResource(r2);
        return;
    L18:
        r8 = b.b(7);
        goto L19
    L10:
        if (r7 == 2) goto L14;
        if (r7 == 3) goto L13;
        r2 = 2131234750;
        goto L16
    L13:
        r2 = 2131234749;
        goto L16
    L14:
        r2 = 2131234748;
    L20:
        r0.setVisibility(8);
        return;
    }
}
