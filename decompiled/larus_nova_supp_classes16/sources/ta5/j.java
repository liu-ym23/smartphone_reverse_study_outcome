package ta5;

import android.view.MotionEvent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends sa5.e implements v {
    public boolean a;
    public final boolean b;
    public List<w> c;

    public j() {
        this.b = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.touch_event_intercept");
        this.c = new ArrayList();
    }

    public j(int r2) {
        this.b = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.touch_event_intercept");
        this.c = new ArrayList();
    }

    @Override // sa5.v
    public final void b(w r2) {
        List<w> r0 = this.c;
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }

    @Override // sa5.v
    public final void c(w r2) {
        if (this.c != null) goto L6;
        this.c = new ArrayList();
    L6:
        if (this.c.contains(r2) == true) goto L9;
        this.c.add(r2);
        return;
    }

    @Override // sa5.e
    public final boolean h(MotionEvent r5) {
        if (r5.getAction() != 0) goto L13;
        this.a = false;
        List<w> r0 = this.c;
        if (r0 == null) goto L16;
        Iterator r1 = ((ArrayList) r0).iterator();
    L8:
        if (r1.hasNext() == false) goto L16;
        if (((w) r1.next()).u70(r5) == false) goto L8;
        this.a = true;
    L16:
        if (this.b == true) goto L18;
    L20:
        return false;
    L18:
        if (this.a == false) goto L20;
        return true;
    L13:
        if (this.a == false) goto L16;
        r5.setAction(3);
        goto L16
    }
}
