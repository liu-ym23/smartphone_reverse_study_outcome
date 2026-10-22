package com.lynx.tasm.behavior.ui;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f382568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f382569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f382570c;

    public class a implements Comparator<View> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(View r100, View r101) {
            View r102 = r101;
            Integer r103 = UIGroup.getViewZIndex(r100);
            Integer r104 = 0;
            if (r103 != null) goto L5;
            r103 = r104;
        L5:
            Integer r105 = UIGroup.getViewZIndex(r102);
            if (r105 == null) goto L10;
            r104 = r105;
        L10:
            return r103.intValue() - r104.intValue();
        }
    }

    public void update() {
        int r100 = 0;
        this.f382569b = 0;
    L4:
        if (r100 >= this.f382568a.getChildCount()) goto L9;
        if (UIGroup.getViewZIndex(this.f382568a.getChildAt(r100)) == null) goto L8;
        this.f382569b++;
    L8:
        r100 = r100 + 1;
        goto L4
    L9:
        this.f382570c = null;
    }

    public final void a() {
        int r100 = this.f382568a.getChildCount();
        if (this.f382570c != null) goto L10;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r103 >= r100) goto L7;
        r101.add(this.f382568a.getChildAt(r103));
        r103 = r103 + 1;
        goto L5
    L7:
        Collections.sort(r101, new a());
        this.f382570c = new int[r100];
    L8:
        if (r102 >= r100) goto L13;
        View r104 = (View) ListProtector.get(r101, r102);
        this.f382570c[r102] = this.f382568a.indexOfChild(r104);
        r102 = r102 + 1;
        goto L8
    L13:
        return;
    }

    public l(ViewGroup r100) {
        this.f382569b = 0;
        this.f382568a = r100;
    }
}
