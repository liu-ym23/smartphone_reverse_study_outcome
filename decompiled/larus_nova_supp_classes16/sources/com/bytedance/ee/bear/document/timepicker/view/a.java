package com.bytedance.ee.bear.document.timepicker.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final Activity a;
    public AppCompatImageView b;
    public TextView c;
    public WheelView d;
    public WheelView e;
    public View f;
    public View g;
    public UDButton h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.timepicker.view.a$a, reason: collision with other inner class name */
    public static final class C0114a {
    }

    static {
    }

    public a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "mActivity");
        this.a = r2;
    }

    public final void update(int r4, int r5) {
        WheelView r0 = this.d;
        int r1 = -1;
        if (r0 == null) goto L7;
        e18.a r2 = r0.getAdapter();
        if (r2 == null) goto L7;
        int r3 = r2.getItemsCount();
    L8:
        WheelView r6 = this.e;
        if (r6 == null) goto L13;
        e18.a r7 = r6.getAdapter();
        if (r7 == null) goto L13;
        r1 = r7.getItemsCount();
    L13:
        if (r3 <= 0) goto L19;
        if (r4 < 0) goto L19;
        if (r4 >= r3) goto L19;
        WheelView r8 = this.d;
        if (r8 == null) goto L19;
        r8.setCurrentItem(r4);
    L19:
        if (r1 <= 0) goto L26;
        if (r5 < 0) goto L27;
        if (r5 >= r1) goto L28;
        WheelView r9 = this.e;
        if (r9 == null) goto L29;
        r9.setCurrentItem(r5);
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
        r3 = -1;
        goto L8
    }
}
