package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes23.dex */
public class DrawableUtils {
    private static final String LOG_TAG = "DrawableUtils";
    private static Method setConstantStateMethod;
    private static boolean setConstantStateMethodFetched;

    private DrawableUtils() {
    }

    public static boolean setContainerConstantState(DrawableContainer r100, Drawable.ConstantState r101) {
        return setContainerConstantStateV9(r100, r101);
    }

    private static boolean setContainerConstantStateV9(DrawableContainer r100, Drawable.ConstantState r101) {
        if (setConstantStateMethodFetched == false) goto L13;
    L6:
        Method r102 = setConstantStateMethod;
        if (r102 != null) goto L15;
    L10:
        return false;
    L15:
        r102.invoke(r100, new Object[]{r101});     // Catch: Exception -> L11
        return true;
    L13:
        Method r103 = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainer.DrawableContainerState.class});     // Catch: NoSuchMethodException -> L12
        setConstantStateMethod = r103;     // Catch: NoSuchMethodException -> L12
        r103.setAccessible(true);     // Catch: NoSuchMethodException -> L12
    L5:
        setConstantStateMethodFetched = true;
        goto L6
    }
}
