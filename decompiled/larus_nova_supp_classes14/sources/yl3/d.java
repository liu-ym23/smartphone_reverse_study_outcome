package yl3;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import wl3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List b(View r7) {
        ArrayList r0 = new ArrayList();
        if (r7.getId() == (-1)) goto L6;
        a(r7.getId(), r7.getContext().getResources());
        r0.add(new f("id"));
    L6:
        if (r7.getPaddingLeft() != 0) goto L8;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L17;
    L28:
        int r2 = Build.VERSION.SDK_INT;
        if (r7.getElevation() == 0.0f) goto L32;
        r7.getElevation();
        r0.add(new f("elevation"));
    L32:
        if (r7.getTranslationX() == 0.0f) goto L35;
        r7.getTranslationX();
        r0.add(new f("translationX"));
    L35:
        if (r7.getTranslationY() == 0.0f) goto L38;
        r7.getTranslationY();
        r0.add(new f("translationY"));
    L38:
        if (r7.getTranslationZ() == 0.0f) goto L41;
        r7.getTranslationZ();
        r0.add(new f("translationZ"));
    L41:
        if (r7.getRotation() == 0.0f) goto L44;
        String.valueOf(r7.getRotation());
        r0.add(new f("rotation"));
    L44:
        if (r7.getRotationX() == 0.0f) goto L47;
        String.valueOf(r7.getRotationX());
        r0.add(new f("rotationX"));
    L47:
        if (r7.getRotationY() == 0.0f) goto L50;
        String.valueOf(r7.getRotationY());
        r0.add(new f("rotationY"));
    L50:
        if (r7.getScaleX() == 1.0f) goto L53;
        String.valueOf(r7.getScaleX());
        r0.add(new f("scaleX"));
    L53:
        if (r7.getScaleY() == 1.0f) goto L56;
        String.valueOf(r7.getScaleY());
        r0.add(new f("scaleY"));
    L56:
        if (r7.getAlpha() == 1.0f) goto L59;
        String.valueOf(r7.getAlpha());
        r0.add(new f("alpha"));
    L59:
        if (r2 < 26) goto L64;
        if (r7.getFocusable() == 16) goto L64;
        r0.add(new f("focusable"));
    L64:
        if (r7.isFocusableInTouchMode() == false) goto L67;
        r0.add(new f("focusableInTouchMode"));
    L67:
        if (r7.isClickable() == false) goto L70;
        r0.add(new f("clickable"));
    L70:
        if (r7.getVisibility() == 0) goto L73;
        r7.getVisibility();
        r0.add(new f("visibility"));
    L73:
        if (r7.getFitsSystemWindows() == false) goto L76;
        String.valueOf(r7.getFitsSystemWindows());
        r0.add(new f("fitsSystemWindows"));
    L76:
        if (r7.isEnabled() == true) goto L79;
        r0.add(new f("enabled"));
    L79:
        if ((r7.getBackground() instanceof ColorDrawable) == false) goto L85;
        Object[] r3 = new Object[1];
        Drawable r8 = r7.getBackground();
        if (r8 == null) goto L84;
        r3[0] = Integer.valueOf(((ColorDrawable) r8).getColor());
        String.format("#%02x", Arrays.copyOf(r3, 1));
        r0.add(new f("background"));
        goto L85
    L84:
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L85:
        return r0;
    L17:
        if (r7.getPaddingLeft() == 0) goto L20;
        Map<Integer, String> r4 = c.a;
        c.e(r7.getPaddingLeft());
        r0.add(new f("paddingLeft"));
    L20:
        if (r7.getPaddingTop() == 0) goto L23;
        Map<Integer, String> r5 = c.a;
        c.e(r7.getPaddingTop());
        r0.add(new f("paddingTop"));
    L23:
        if (r7.getPaddingRight() == 0) goto L26;
        Map<Integer, String> r6 = c.a;
        c.e(r7.getPaddingRight());
        r0.add(new f("paddingRight"));
    L26:
        if (r7.getPaddingBottom() == 0) goto L28;
        Map<Integer, String> r9 = c.a;
        c.e(r7.getPaddingBottom());
        r0.add(new f("paddingBottom"));
        goto L28
    L8:
        if (r7.getPaddingLeft() != r7.getPaddingRight()) goto L14;
        if (r7.getPaddingLeft() != r7.getPaddingTop()) goto L14;
        if (r7.getPaddingLeft() != r7.getPaddingBottom()) goto L14;
        Map<Integer, String> r10 = c.a;
        c.e(r7.getPaddingLeft());
        r0.add(new f("padding"));
        r1 = true;
        goto L15
    }

    public static List c(ViewGroup r3) {
        ArrayList r0 = new ArrayList();
        r0.addAll(b(r3));
        if (r3.getClipChildren() == true) goto L6;
        r0.add(new f("clipChildren"));
    L6:
        if (r3.getClipToPadding() == true) goto L8;
        r0.add(new f("clipToPadding"));
    L8:
        return r0;
    }

    public static String a(int r1, Resources r2) {
        return r2.getResourceEntryName(r1);
    L5:
        return "0x" + Integer.toHexString(r1);
    }
}
