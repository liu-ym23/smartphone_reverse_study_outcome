package com.bytedance.ee.bear.edit.toolbar.toolbar2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class HorizontalOverScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f226239a;

    public interface a {
        void onScrollChanged();
    }

    public HorizontalOverScrollView(Context r100) {
        super(r100);
        this.f226239a = new ArrayList();
    }

    public HorizontalOverScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f226239a = new ArrayList();
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        if (((ArrayList) this.f226239a).size() <= 0) goto L8;
        Iterator r104 = ((ArrayList) this.f226239a).iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        a r105 = (a) r104.next();
        getScrollX();
        getScrollY();
        r105.onScrollChanged();
        goto L6
    L10:
        return;
    }
}
