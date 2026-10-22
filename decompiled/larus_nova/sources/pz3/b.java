package pz3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f531076a = 0;

    static {
        x54.a.a(539);
    }

    public static void a(ViewGroup.MarginLayoutParams r100) {
        if ((r100 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r100).gravity = 49;
        return;
    L6:
        if ((r100 instanceof RelativeLayout.LayoutParams) == false) goto L10;
        RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) r100;
        r101.addRule(14, -1);
        r101.addRule(10, -1);
        r101.removeRule(13);
        return;
    }

    public static void b(View r100, ViewGroup.LayoutParams r101) {
        if (r100 == null) goto L24;
        if (r101 == null) goto L26;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        HashMap<String, ArrayList<String>> r104 = c.f531077a;
        c.b("ResetParams, " + r101 + ", " + r103.bottomMargin);
        if ((r103 instanceof FrameLayout.LayoutParams) == false) goto L13;
        if ((r101 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        int r106 = ((FrameLayout.LayoutParams) r101).gravity;
        if (r105.gravity == r106) goto L17;
        r105.gravity = r106;
    L17:
        int r107 = r103.topMargin;
        int r108 = r102.topMargin;
        if (r107 == r108) goto L20;
        r103.topMargin = r108;
    L20:
        int r109 = r103.bottomMargin;
        int r110 = r102.bottomMargin;
        if (r109 == r110) goto L25;
        r103.bottomMargin = r110;
        return;
    L25:
        return;
    L13:
        if ((r103 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        if ((r101 instanceof RelativeLayout.LayoutParams) == false) goto L17;
        RelativeLayout.LayoutParams r111 = (RelativeLayout.LayoutParams) r100.getLayoutParams();
        int[] r112 = ((RelativeLayout.LayoutParams) r101).getRules();
        r111.addRule(13, r112[13]);
        r111.addRule(10, r112[10]);
        goto L17
    L26:
        return;
    }
}
