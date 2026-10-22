package com.ss.android.ugc.tools.accessibility;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TouchDelegateChildren> f454813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TouchDelegateChildren f454814b;

    public a(View r100) {
        super(new Rect(), r100);
        this.f454813a = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        TouchDelegateChildren r102 = null;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L6;
    L11:
        TouchDelegateChildren r103 = this.f454814b;
        this.f454814b = null;
        r102 = r103;
    L20:
        if (r102 != null) goto L22;
        return false;
    L22:
        if (r102.onTouchEvent(r100) == false) goto L28;
        return true;
    L28:
        return false;
    L6:
        if (r101 != 2) goto L8;
        r102 = this.f454814b;
        goto L20
    L8:
        if (r101 == 3) goto L11;
    L12:
        int r104 = 0;
    L14:
        if (r104 >= ((ArrayList) this.f454813a).size()) goto L20;
        TouchDelegateChildren r105 = (TouchDelegateChildren) ListProtector.get(this.f454813a, r104);
        if (r105.onTouchEvent(r100) == true) goto L17;
        r104 = r104 + 1;
        goto L14
    L17:
        this.f454814b = r105;
        return true;
    }
}
