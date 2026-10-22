package vla;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.mapapi.UIMsg;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: vla.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C8017a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f555708a = null;

        static {
            int[] r100 = new int[ConstraintAttribute.AttributeType.values().length];
            f555708a = r100;
            r100[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f555708a[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f555708a[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f555708a[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f555708a[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f555708a[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f555708a[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static int a(int r100) {
        int r101 = (r100 & (~(r100 >> 31))) + UIMsg.m_AppUI.V_WM_ADDLISTUPDATE;
        return (r101 & (r101 >> 31)) + 255;
    }

    public static void b(ConstraintAttribute r110, View r111, float[] r112) {
        Class<?> r100 = r111.getClass();
        String r101 = "set" + r110.f400368b;
        boolean r102 = true;
        switch(C8017a.f555708a[r110.getType().ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L24;
        };     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
    L6:
        r100.getMethod(r101, new Class[]{Float.TYPE}).invoke(r111, new Object[]{Float.valueOf(r112[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        return;
    L7:
        Method r113 = r100.getMethod(r101, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        Object[] r103 = new Object[1];     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        if (r112[0] > 0.5f) goto L11;
        r102 = false;
    L11:
        r103[0] = Boolean.valueOf(r102);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        r113.invoke(r111, r103);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        return;
    L14:
        r100.getMethod(r101, new Class[]{Integer.TYPE}).invoke(r111, new Object[]{Integer.valueOf((((a((int) (r112[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(r112[0], 0.45454545454545453d)) * 255.0f)) << 16)) | (a((int) (((float) Math.pow(r112[1], 0.45454545454545453d)) * 255.0f)) << 8)) | a((int) (((float) Math.pow(r112[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        return;
    L15:
        Method r114 = r100.getMethod(r101, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        int r115 = (((a((int) (r112[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(r112[0], 0.45454545454545453d)) * 255.0f)) << 16)) | (a((int) (((float) Math.pow(r112[1], 0.45454545454545453d)) * 255.0f)) << 8)) | a((int) (((float) Math.pow(r112[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        ColorDrawable r104 = new ColorDrawable();     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        r104.setColor(r115);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        r114.invoke(r111, new Object[]{r104});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        return;
    L16:
        r100.getMethod(r101, new Class[]{Float.TYPE}).invoke(r111, new Object[]{Float.valueOf(r112[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        return;
    L17:
        r100.getMethod(r101, new Class[]{Integer.TYPE}).invoke(r111, new Object[]{Integer.valueOf((int) r112[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
        return;
    L24:
        return;
    L13:
        throw new RuntimeException("unable to interpolate strings " + r110.f400368b);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L20 NoSuchMethodException -> L21
    L20:
        com.obric.oui.constraintlayout.motion.widget.a.d(r111);
        return;
    L21:
        com.obric.oui.constraintlayout.motion.widget.a.d(r111);
        return;
    L19:
        com.obric.oui.constraintlayout.motion.widget.a.d(r111);
    }
}
