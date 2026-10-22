package pz3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        x54.a.a(539);
    }

    public static void a(ViewGroup.MarginLayoutParams r2) {
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r2).gravity = 49;
        return;
    L6:
        if ((r2 instanceof RelativeLayout.LayoutParams) == false) goto L10;
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r2;
        r3.addRule(14, -1);
        r3.addRule(10, -1);
        r3.removeRule(13);
        return;
    }

    public static void b(View r4, ViewGroup.LayoutParams r5) {
        if (r4 == null) goto L24;
        if (r5 == null) goto L26;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r4.getLayoutParams();
        HashMap<String, ArrayList<String>> r2 = c.a;
        c.b("ResetParams, " + r5 + ", " + r1.bottomMargin);
        if ((r1 instanceof FrameLayout.LayoutParams) == false) goto L13;
        if ((r5 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r4.getLayoutParams();
        int r7 = ((FrameLayout.LayoutParams) r5).gravity;
        if (r6.gravity == r7) goto L17;
        r6.gravity = r7;
    L17:
        int r8 = r1.topMargin;
        int r9 = r0.topMargin;
        if (r8 == r9) goto L20;
        r1.topMargin = r9;
    L20:
        int r10 = r1.bottomMargin;
        int r11 = r0.bottomMargin;
        if (r10 == r11) goto L25;
        r1.bottomMargin = r11;
        return;
    L25:
        return;
    L13:
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        if ((r5 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r4.getLayoutParams();
        int[] r13 = ((RelativeLayout.LayoutParams) r5).getRules();
        r12.addRule(13, r13[13]);
        r12.addRule(10, r13[10]);
        goto L17
    L26:
        return;
    }
}
