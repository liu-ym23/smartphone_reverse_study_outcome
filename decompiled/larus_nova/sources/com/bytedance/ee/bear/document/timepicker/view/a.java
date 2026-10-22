package com.bytedance.ee.bear.document.timepicker.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f222016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f222017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f222018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f222019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WheelView f222020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f222021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f222022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDButton f222023h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.timepicker.view.a$a, reason: collision with other inner class name */
    public static final class C3170a {
    }

    static {
    }

    public a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        this.f222016a = r100;
    }

    public final void update(int r100, int r101) {
        WheelView r102 = this.f222019d;
        int r103 = -1;
        if (r102 == null) goto L7;
        e18.a<? extends Object> r104 = r102.getAdapter();
        if (r104 == null) goto L7;
        int r105 = r104.getItemsCount();
    L8:
        WheelView r106 = this.f222020e;
        if (r106 == null) goto L13;
        e18.a<? extends Object> r107 = r106.getAdapter();
        if (r107 == null) goto L13;
        r103 = r107.getItemsCount();
    L13:
        if (r105 <= 0) goto L19;
        if (r100 < 0) goto L19;
        if (r100 >= r105) goto L19;
        WheelView r108 = this.f222019d;
        if (r108 == null) goto L19;
        r108.setCurrentItem(r100);
    L19:
        if (r103 <= 0) goto L26;
        if (r101 < 0) goto L27;
        if (r101 >= r103) goto L28;
        WheelView r109 = this.f222020e;
        if (r109 == null) goto L29;
        r109.setCurrentItem(r101);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L7:
        r105 = -1;
        goto L8
    }
}
