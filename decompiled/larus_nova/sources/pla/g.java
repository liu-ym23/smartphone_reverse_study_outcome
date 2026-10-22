package pla;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TouchDelegate> f529796a;

    public g(View r100) {
        Rect r101 = new Rect();
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "emptyRect");
        super(r101, r100);
        this.f529796a = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        float r101 = r100.getX();
        float r102 = r100.getY();
        Iterator<T> r103 = this.f529796a.iterator();
    L3:
        boolean r104 = false;
    L5:
        if (r103.hasNext() == false) goto L10;
        TouchDelegate r105 = (TouchDelegate) r103.next();
        r100.setLocation(r101, r102);
        if (r105.onTouchEvent(r100) == true) goto L9;
        if (r104 == false) goto L3;
    L9:
        r104 = true;
        goto L5
    L10:
        return r104;
    }
}
