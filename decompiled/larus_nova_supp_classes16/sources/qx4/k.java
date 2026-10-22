package qx4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.debug.net.RequestDetailFragment;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k extends t {
    public final /* synthetic */ RequestDetailFragment c;

    public k(RequestDetailFragment r1) {
        this.c = r1;
    }

    public final void a(View r1) {
        FragmentActivity r2 = this.c.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }
}
