package ta5;

import android.view.MotionEvent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends sa5.e implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f545182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f545183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<w> f545184c;

    public j() {
        this.f545183b = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.touch_event_intercept");
        this.f545184c = new ArrayList();
    }

    public j(int r100) {
        this.f545183b = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.mobile.touch_event_intercept");
        this.f545184c = new ArrayList();
    }

    @Override // sa5.v
    public final void b(w r100) {
        List<w> r101 = this.f545184c;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    @Override // sa5.v
    public final void c(w r100) {
        if (this.f545184c != null) goto L6;
        this.f545184c = new ArrayList();
    L6:
        if (this.f545184c.contains(r100) == true) goto L9;
        this.f545184c.add(r100);
        return;
    }

    @Override // sa5.e
    public final boolean h(MotionEvent r100) {
        if (r100.getAction() != 0) goto L13;
        this.f545182a = false;
        List<w> r101 = this.f545184c;
        if (r101 == null) goto L16;
        Iterator r102 = ((ArrayList) r101).iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        if (((w) r102.next()).u70(r100) == false) goto L8;
        this.f545182a = true;
    L16:
        if (this.f545183b == true) goto L18;
    L20:
        return false;
    L18:
        if (this.f545182a == false) goto L20;
        return true;
    L13:
        if (this.f545182a == false) goto L16;
        r100.setAction(3);
        goto L16
    }
}
