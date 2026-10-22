package h05;

import android.view.View;
import com.bytedance.ee.bear.contract.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.more.protocol3.a {
    public final /* synthetic */ a a;

    public final View.OnClickListener a() {
        return null;
    }

    public final String b() {
        if (j.a.a.getNetworkState().a() == false) goto L5;
        return "";
    L5:
        return this.a.e(2131887951);
    }

    public final boolean isEnable() {
        return j.a.a.getNetworkState().a();
    }

    public b(a r1) {
        this.a = r1;
    }
}
