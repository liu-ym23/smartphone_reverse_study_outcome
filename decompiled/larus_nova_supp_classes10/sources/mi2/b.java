package mi2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements tk.a {
    public final /* synthetic */ gl2.a a;
    public final /* synthetic */ Context b;

    public final View a() {
        return this.a.getView();
    }

    public final void b() {
        String r0 = a.a;
        a.b = true;
        com.bytedance.android.ec.monitor.duration.d r1 = i.a.get(a.a);
        if (r1 == null) goto L5;
        r1.a("initial");
    L5:
        this.a.init(this.b);
        View r2 = this.a.getView();
        r2.setPadding(0, 0, 0, UtilityKotlinExtentionsKt.d(12));
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = r2.getLayoutParams().height + UtilityKotlinExtentionsKt.d(12);
    }

    public final void onUnload() {
        this.a.release();
    }

    public b(d r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
