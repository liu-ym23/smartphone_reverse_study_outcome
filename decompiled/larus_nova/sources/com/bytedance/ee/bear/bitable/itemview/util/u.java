package com.bytedance.ee.bear.bitable.itemview.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class u extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f214310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TouchDelegate> f214311b;

    public u(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hostView");
        super(new Rect(), r100);
        this.f214310a = r100;
        this.f214311b = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator<T> r101 = this.f214311b.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((TouchDelegate) r101.next()).onTouchEvent(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
