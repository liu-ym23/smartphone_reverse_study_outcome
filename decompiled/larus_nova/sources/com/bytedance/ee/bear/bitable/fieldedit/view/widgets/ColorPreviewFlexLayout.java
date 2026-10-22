package com.bytedance.ee.bear.bitable.fieldedit.view.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.util.ui.n;
import com.google.android.flexbox.FlexboxLayout;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class ColorPreviewFlexLayout extends FlexboxLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f211713r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f211714s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f211715t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f211716u = 0;

    static {
        f211713r = n.d(38);
        f211714s = n.d(49);
        f211715t = n.d(20);
        f211716u = n.d(82);
    }

    public ColorPreviewFlexLayout(Context r100) {
        this(r100, null);
    }

    public void setPreviewList(List<a.e> r100) {
        if (r100 == null) goto L18;
        int r101 = getPaddingStart();
        int r102 = getPaddingEnd();
        int r103 = r100.size();
        if (r103 != 1) goto L6;
        setJustifyContent(2);
    L14:
        removeAllViews();
        Iterator<a.e> r104 = r100.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        a.e r105 = r104.next();
        UDProgress r106 = new UDProgress(getContext());
        FlexboxLayout.LayoutParams r107 = new FlexboxLayout.LayoutParams(-1, -2);
        int r108 = f211716u;
        r107.setMarginStart(r108);
        r107.setMarginEnd(r108);
        r106.setIndicatorCornerRadius(n.d(5));
        r106.setThickness(n.d(10));
        r106.setLayoutParams(r107);
        r106.setTrackColor(getContext().getResources().getColor(R.color.ud_N300));
        r106.setProgress(r105.f211756a);
        r106.setIndicatorColor(r105.f211757b);
        addView(r106);
        goto L16
    L20:
        return;
    L6:
        if (r103 == 2) goto L12;
        if (r103 == 3) goto L11;
        if (r103 != 5) goto L14;
        int r109 = f211715t;
        setPadding(r101, r109, r102, r109);
        setJustifyContent(3);
        goto L14
    L11:
        int r110 = f211713r;
        setPadding(r101, r110, r102, r110);
        setJustifyContent(3);
        goto L14
    L12:
        int r111 = f211714s;
        setPadding(r101, r111, r102, r111);
        setJustifyContent(3);
        goto L14
    }

    public ColorPreviewFlexLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ColorPreviewFlexLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
