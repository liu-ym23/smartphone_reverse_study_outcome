package android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.compose.material3.MenuKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ViewHelper extends View {
    public ViewHelper(Context r1) {
        super(r1);
    }

    public static void finishInflate(View r0) {
        r0.onFinishInflate();
    }

    public static Object getScrollCache(View r3) {
        Field r0 = View.class.getDeclaredField("mScrollCache");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        Object r4 = r0.get(r3);     // Catch: Exception -> L4
        Field r1 = r4.getClass().getDeclaredField("scrollBar");     // Catch: Exception -> L4
        r1.setAccessible(true);     // Catch: Exception -> L4
        return r1.get(r4);
    L5:
        throw new IllegalStateException("reflect mScrollCache failed");
    }

    public static int getAttrColor(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        int r5 = r4.getColor(0, 0);
        r4.recycle();
        return r5;
    }

    public static ColorStateList getAttrColorStateList(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        ColorStateList r5 = r4.getColorStateList(0);
        r4.recycle();
        return r5;
    }

    public static float getAttrDimen(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        float r5 = r4.getDimension(0, MenuKt.ClosedAlphaTarget);
        r4.recycle();
        return r5;
    }

    public static Drawable getAttrDrawable(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        Drawable r5 = r4.getDrawable(0);
        r4.recycle();
        return r5;
    }

    public static float getAttrFloat(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        float r5 = r4.getFloat(0, MenuKt.ClosedAlphaTarget);
        r4.recycle();
        return r5;
    }

    public static int getAttrResourceId(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        int r5 = r4.getResourceId(0, 0);
        r4.recycle();
        return r5;
    }

    public static String getAttrString(Context r2, int r3) {
        TypedArray r4 = r2.getTheme().obtainStyledAttributes(new int[]{r3});
        String r5 = r4.getString(0);
        r4.recycle();
        return r5;
    }

    public static void setIndeterminateDrawable(ProgressBar r0, Drawable r1) {
        r0.setIndeterminateDrawableTiled(r1);
    }

    public static void setMinHeight(View r0, int r1) {
        ((TextView) r0).setMinHeight(r1);
    }

    public static void setMinWidth(View r0, int r1) {
        ((TextView) r0).setMinWidth(r1);
    }

    public static ViewGroup.MarginLayoutParams getLayoutParam(ViewGroup r1, int r2, int r3) {
        if ((r1 instanceof RelativeLayout) == false) goto L7;
        return new RelativeLayout.LayoutParams(r2, r3);
    L7:
        if ((r1 instanceof LinearLayout) == false) goto L11;
        return new LinearLayout.LayoutParams(r2, r3);
    L11:
        if ((r1 instanceof FrameLayout) == false) goto L15;
        return new FrameLayout.LayoutParams(r2, r3);
    L15:
        if ((r1 instanceof ConstraintLayout) == false) goto L19;
        return new ConstraintLayout.LayoutParams(r2, r3);
    L19:
        return new ViewGroup.MarginLayoutParams(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method getMethod(Class r3, String r4, Class r5) {
        Method r6 = r3.getDeclaredMethod(r4, new Class[]{r5});     // Catch: NoSuchMethodException -> L5
        r6.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        return r6;
    L6:
        throw new IllegalStateException("getMethod failed " + r4);
    }

    public static void invokeOnClick(final Object r1, final String r2, final View r3) throws Exception {
        r3.setOnClickListener(new AnonymousClass1(r1, r2, r3));
    }

    public static void setField(Class r0, String r1, Object r2, Object r3) throws Exception {
        Field r4 = r0.getDeclaredField(r1);
        r4.setAccessible(true);
        r4.set(r2, r3);
    }
}
