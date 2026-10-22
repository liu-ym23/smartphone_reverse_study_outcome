package eu2;

import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f474057a;

    public c() {
        this.f474057a = new CopyOnWriteArrayList();
    }

    public final boolean a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator<b> r102 = this.f474057a.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        b r103 = r102.next();
        r100.getVisibility();
        if (r103.a(r100, r101) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
