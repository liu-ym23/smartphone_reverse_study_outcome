package yl3;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import wl3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568316a = 0;

    static {
    }

    public static List b(View r100) {
        ArrayList r101 = new ArrayList();
        if (r100.getId() == (-1)) goto L6;
        a(r100.getId(), r100.getContext().getResources());
        r101.add(new f("id"));
    L6:
        if (r100.getPaddingLeft() != 0) goto L8;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
    L28:
        int r103 = Build.VERSION.SDK_INT;
        if (r100.getElevation() == 0.0f) goto L32;
        r100.getElevation();
        r101.add(new f("elevation"));
    L32:
        if (r100.getTranslationX() == 0.0f) goto L35;
        r100.getTranslationX();
        r101.add(new f(LiveDegradeFpsAnimator.TRANSLATION_X));
    L35:
        if (r100.getTranslationY() == 0.0f) goto L38;
        r100.getTranslationY();
        r101.add(new f(LiveDegradeFpsAnimator.TRANSLATION_Y));
    L38:
        if (r100.getTranslationZ() == 0.0f) goto L41;
        r100.getTranslationZ();
        r101.add(new f("translationZ"));
    L41:
        if (r100.getRotation() == 0.0f) goto L44;
        String.valueOf(r100.getRotation());
        r101.add(new f("rotation"));
    L44:
        if (r100.getRotationX() == 0.0f) goto L47;
        String.valueOf(r100.getRotationX());
        r101.add(new f("rotationX"));
    L47:
        if (r100.getRotationY() == 0.0f) goto L50;
        String.valueOf(r100.getRotationY());
        r101.add(new f("rotationY"));
    L50:
        if (r100.getScaleX() == 1.0f) goto L53;
        String.valueOf(r100.getScaleX());
        r101.add(new f(LiveDegradeFpsAnimator.SCALE_X));
    L53:
        if (r100.getScaleY() == 1.0f) goto L56;
        String.valueOf(r100.getScaleY());
        r101.add(new f(LiveDegradeFpsAnimator.SCALE_Y));
    L56:
        if (r100.getAlpha() == 1.0f) goto L59;
        String.valueOf(r100.getAlpha());
        r101.add(new f("alpha"));
    L59:
        if (r103 < 26) goto L64;
        if (r100.getFocusable() == 16) goto L64;
        r101.add(new f("focusable"));
    L64:
        if (r100.isFocusableInTouchMode() == false) goto L67;
        r101.add(new f("focusableInTouchMode"));
    L67:
        if (r100.isClickable() == false) goto L70;
        r101.add(new f("clickable"));
    L70:
        if (r100.getVisibility() == 0) goto L73;
        r100.getVisibility();
        r101.add(new f(RemoteMessageConst.Notification.VISIBILITY));
    L73:
        if (r100.getFitsSystemWindows() == false) goto L76;
        String.valueOf(r100.getFitsSystemWindows());
        r101.add(new f("fitsSystemWindows"));
    L76:
        if (r100.isEnabled() == true) goto L79;
        r101.add(new f("enabled"));
    L79:
        if ((r100.getBackground() instanceof ColorDrawable) == false) goto L85;
        Object[] r104 = new Object[1];
        Drawable r105 = r100.getBackground();
        if (r105 == null) goto L84;
        r104[0] = Integer.valueOf(((ColorDrawable) r105).getColor());
        String.format("#%02x", Arrays.copyOf(r104, 1));
        r101.add(new f("background"));
        goto L85
    L84:
        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L85:
        return r101;
    L17:
        if (r100.getPaddingLeft() == 0) goto L20;
        Map<Integer, String> r106 = c.f568314a;
        c.e(r100.getPaddingLeft());
        r101.add(new f("paddingLeft"));
    L20:
        if (r100.getPaddingTop() == 0) goto L23;
        Map<Integer, String> r107 = c.f568314a;
        c.e(r100.getPaddingTop());
        r101.add(new f("paddingTop"));
    L23:
        if (r100.getPaddingRight() == 0) goto L26;
        Map<Integer, String> r108 = c.f568314a;
        c.e(r100.getPaddingRight());
        r101.add(new f("paddingRight"));
    L26:
        if (r100.getPaddingBottom() == 0) goto L28;
        Map<Integer, String> r109 = c.f568314a;
        c.e(r100.getPaddingBottom());
        r101.add(new f("paddingBottom"));
        goto L28
    L8:
        if (r100.getPaddingLeft() != r100.getPaddingRight()) goto L14;
        if (r100.getPaddingLeft() != r100.getPaddingTop()) goto L14;
        if (r100.getPaddingLeft() != r100.getPaddingBottom()) goto L14;
        Map<Integer, String> r110 = c.f568314a;
        c.e(r100.getPaddingLeft());
        r101.add(new f(GXTemplateKey.FLEXBOX_PADDING));
        r102 = true;
        goto L15
    }

    public static List c(ViewGroup r100) {
        ArrayList r101 = new ArrayList();
        r101.addAll(b(r100));
        if (r100.getClipChildren() == true) goto L6;
        r101.add(new f("clipChildren"));
    L6:
        if (r100.getClipToPadding() == true) goto L8;
        r101.add(new f("clipToPadding"));
    L8:
        return r101;
    }

    public static String a(int r100, Resources r101) {
        return r101.getResourceEntryName(r100);
    L5:
        return "0x" + Integer.toHexString(r100);
    }
}
