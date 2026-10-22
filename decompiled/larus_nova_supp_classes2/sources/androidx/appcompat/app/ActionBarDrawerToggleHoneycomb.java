package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = null;

    public static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        public SetIndicatorInfo(Activity r7) {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r8 = r7.findViewById(R.id.home);
            if (r8 != null) goto L8;
            return;
        L8:
            ViewGroup r9 = (ViewGroup) r8.getParent();
            if (r9.getChildCount() == 2) goto L11;
            return;
        L11:
            View r0 = r9.getChildAt(0);
            View r10 = r9.getChildAt(1);
            if (r0.getId() != 16908332) goto L15;
            r0 = r10;
        L15:
            if ((r0 instanceof ImageView) == false) goto L20;
            this.upIndicatorView = (ImageView) r0;
            return;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity r1) {
        TypedArray r2 = r1.obtainStyledAttributes(THEME_ATTRS);
        Drawable r0 = r2.getDrawable(0);
        r2.recycle();
        return r0;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo r3, Activity r4, int r5) {
        if (r3 != null) goto L5;
        r3 = new SetIndicatorInfo(r4);
    L5:
        if (r3.setHomeAsUpIndicator != null) goto L9;
    L7:
        return r3;
    L9:
        android.app.ActionBar r6 = r4.getActionBar();     // Catch: Exception -> L8
        r3.setHomeActionContentDescription.invoke(r6, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L8
        goto L7
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity r5, Drawable r6, int r7) {
        SetIndicatorInfo r0 = new SetIndicatorInfo(r5);
        if (r0.setHomeAsUpIndicator != null) goto L11;
        ImageView r8 = r0.upIndicatorView;
        if (r8 == null) goto L9;
        r8.setImageDrawable(r6);
    L9:
        return r0;
    L11:
        android.app.ActionBar r9 = r5.getActionBar();     // Catch: Exception -> L10
        r0.setHomeAsUpIndicator.invoke(r9, new Object[]{r6});     // Catch: Exception -> L10
        r0.setHomeActionContentDescription.invoke(r9, new Object[]{Integer.valueOf(r7)});     // Catch: Exception -> L10
        goto L9
    }
}
