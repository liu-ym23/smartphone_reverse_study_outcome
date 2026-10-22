package com.volcengine.zeus.download;

import android.app.Activity;
import com.volcengine.zeus.EmptyActivityLifecycleCallbacks;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f462683b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f462684a;

    public class a extends EmptyActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f462685a;

        public a(f r100) {
            this.f462685a = r100;
        }

        @Override // com.volcengine.zeus.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Iterator r101 = ((CopyOnWriteArrayList) this.f462685a.f462684a).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            String r102 = (String) r101.next();
            j.b().a(r102, false);
            goto L4
        }
    }

    public f() {
        this.f462684a = new CopyOnWriteArrayList();
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new a(this));
    }

    public final void a(String r100, boolean r101) {
        if (dqc.d.d(Zeus.getAppApplication()) == true) goto L5;
        return;
    L5:
        if (GlobalParam.getInstance().autoFetch() == false) goto L9;
        j.b().c(r100);
        j.b().a(r100, r101);
        if (((CopyOnWriteArrayList) this.f462684a).contains(r100) == true) goto L12;
        ((CopyOnWriteArrayList) this.f462684a).add(r100);
        return;
    L12:
        return;
    L9:
        j.b().a(r100, r101);
    }
}
