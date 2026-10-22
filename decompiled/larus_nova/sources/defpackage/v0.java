package defpackage;

import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class v0 {
    public static final String a(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return r100;
    L8:
        return MonitorConstants.CONNECT_TYPE_GET + Character.toUpperCase(r100.charAt(0)) + r100.substring(1);
    L5:
        r101 = false;
        goto L6
    }

    public static final String b(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return r100;
    L8:
        return "set" + Character.toUpperCase(r100.charAt(0)) + r100.substring(1);
    L5:
        r101 = false;
        goto L6
    }

    public static final Object c(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPropertyValue");
        Intrinsics.checkNotNullParameter(r101, "propertyName");
        AnimationProperty$FloatProperty[] r102 = AnimationProperty$FloatProperty.values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L20;
        AnimationProperty$FloatProperty r105 = r102[r104];
        r104 = r104 + 1;
        if (Intrinsics.areEqual(r105.getPropertyName(), r101) == false) goto L3;
        switch(u0.f548096a[r105.ordinal()]) {
            case 1: goto L19;
            case 2: goto L71;
            case 3: goto L70;
            case 4: goto L69;
            case 5: goto L68;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L65;
            case 9: goto L64;
            case 10: goto L63;
            default: goto L62;
        };
    L62:
        return Unit.INSTANCE;
    L63:
        return Float.valueOf(r100.getAlpha());
    L64:
        return Float.valueOf(r100.getRotationY());
    L65:
        return Float.valueOf(r100.getRotationX());
    L66:
        return Float.valueOf(r100.getTranslationY());
    L67:
        return Float.valueOf(r100.getTranslationX());
    L68:
        return Float.valueOf(r100.getRotation());
    L69:
        return Float.valueOf(r100.getScaleY());
    L70:
        return Float.valueOf(r100.getScaleX());
    L71:
        return Float.valueOf(r100.getY());
    L19:
        return Float.valueOf(r100.getX());
    L20:
        AnimationProperty$IntProperty[] r106 = AnimationProperty$IntProperty.values();
        int r107 = r106.length;
        int r108 = 0;
    L22:
        if (r108 >= r107) goto L55;
        AnimationProperty$IntProperty r109 = r106[r108];
        r108 = r108 + 1;
        if (Intrinsics.areEqual(r109.getPropertyName(), r101) == false) goto L22;
        switch(u0.f548097b[r109.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L36;
            case 4: goto L31;
            case 5: goto L73;
            case 6: goto L72;
            default: goto L28;
        };
    L31:
        Drawable r110 = r100.getBackground();
        if ((r110 instanceof ShapeDrawable) == false) goto L74;
        Paint r111 = ((ShapeDrawable) r110).getPaint();
        if (r111.getStyle() == Paint.Style.FILL) goto L76;
        return null;
    L76:
        return Integer.valueOf(r111.getColor());
    L74:
        return null;
    L36:
        Drawable r112 = r100.getBackground();
        if ((r112 instanceof ShapeDrawable) == false) goto L77;
        Paint r113 = ((ShapeDrawable) r112).getPaint();
        if (r113.getStyle() == Paint.Style.STROKE) goto L79;
        return null;
    L79:
        return Integer.valueOf(r113.getColor());
    L77:
        return null;
    L44:
        Drawable r114 = r100.getBackground();
        if ((r114 instanceof ColorDrawable) == true) goto L47;
        return null;
    L47:
        return Integer.valueOf(((ColorDrawable) r114).getColor());
    L28:
        throw new NoWhenBranchMatchedException();
    L72:
        return Integer.valueOf(r100.getHeight());
    L73:
        return Integer.valueOf(r100.getWidth());
    L42:
        if ((r100 instanceof TextView) == true) goto L81;
        return null;
    L81:
        return Integer.valueOf(((TextView) r100).getTextColors().getDefaultColor());
    L55:
        String r115 = a(r101);     // Catch: Exception -> L50 NoSuchMethodException -> L52
        return r100.getClass().getMethod(r115, new Class[0]).invoke(r100, new Object[0]);
    L52:
        e = move-exception;
        e.printStackTrace();
    L54:
        return null;
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L54
    }

    public static final void d(View r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$setPropertyValue");
        Intrinsics.checkNotNullParameter(r101, "propertyName");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (Intrinsics.areEqual(r101, "x") == false) goto L8;
        if ((r102 instanceof Float) == false) goto L126;
        r100.setX(((Number) r102).floatValue());
        return;
    L126:
        return;
    L8:
        if (Intrinsics.areEqual(r101, "y") == false) goto L13;
        if ((r102 instanceof Float) == false) goto L128;
        r100.setY(((Number) r102).floatValue());
        return;
    L128:
        return;
    L13:
        if (Intrinsics.areEqual(r101, "alpha") == false) goto L18;
        if ((r102 instanceof Float) == false) goto L130;
        r100.setAlpha(((Number) r102).floatValue());
        return;
    L130:
        return;
    L18:
        if (Intrinsics.areEqual(r101, "rotation") == false) goto L23;
        if ((r102 instanceof Float) == false) goto L132;
        r100.setRotation(((Number) r102).floatValue());
        return;
    L132:
        return;
    L23:
        if (Intrinsics.areEqual(r101, LiveDegradeFpsAnimator.SCALE_X) == false) goto L28;
        if ((r102 instanceof Float) == false) goto L134;
        r100.setScaleX(((Number) r102).floatValue());
        return;
    L134:
        return;
    L28:
        if (Intrinsics.areEqual(r101, LiveDegradeFpsAnimator.SCALE_Y) == false) goto L33;
        if ((r102 instanceof Float) == false) goto L136;
        r100.setScaleY(((Number) r102).floatValue());
        return;
    L136:
        return;
    L33:
        if (Intrinsics.areEqual(r101, LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L38;
        if ((r102 instanceof Float) == false) goto L138;
        r100.setTranslationX(((Number) r102).floatValue());
        return;
    L138:
        return;
    L38:
        if (Intrinsics.areEqual(r101, LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L43;
        if ((r102 instanceof Float) == false) goto L140;
        r100.setTranslationY(((Number) r102).floatValue());
        return;
    L140:
        return;
    L43:
        if (Intrinsics.areEqual(r101, "rotationX") == false) goto L48;
        if ((r102 instanceof Float) == false) goto L142;
        r100.setRotationX(((Number) r102).floatValue());
        return;
    L142:
        return;
    L48:
        if (Intrinsics.areEqual(r101, "rotationY") == false) goto L53;
        if ((r102 instanceof Float) == false) goto L144;
        r100.setRotationY(((Number) r102).floatValue());
        return;
    L144:
        return;
    L53:
        if (Intrinsics.areEqual(r101, "scale") == false) goto L58;
        if ((r102 instanceof Float) == false) goto L146;
        Number r103 = (Number) r102;
        r100.setScaleX(r103.floatValue());
        r100.setScaleY(r103.floatValue());
        return;
    L146:
        return;
    L58:
        if (Intrinsics.areEqual(r101, AnimationProperty$IntProperty.BACKGROUND_COLOR.getPropertyName()) == false) goto L63;
        if ((r102 instanceof Integer) == false) goto L148;
        r100.setBackgroundColor(((Number) r102).intValue());
        return;
    L148:
        return;
    L63:
        if (Intrinsics.areEqual(r101, AnimationProperty$IntProperty.TEXT_COLOR.getPropertyName()) == false) goto L70;
        if ((r100 instanceof TextView) == true) goto L67;
        return;
    L67:
        if ((r102 instanceof Integer) == false) goto L151;
        ((TextView) r100).setTextColor(((Number) r102).intValue());
        return;
    L151:
        return;
    L70:
        if (Intrinsics.areEqual(r101, AnimationProperty$IntProperty.STROKE_COLOR.getPropertyName()) == false) goto L79;
        if ((r102 instanceof Integer) == false) goto L153;
        Drawable r104 = r100.getBackground();
        if ((r104 instanceof ShapeDrawable) == false) goto L154;
        Paint r105 = ((ShapeDrawable) r104).getPaint();
        if (r105.getStyle() != Paint.Style.STROKE) goto L155;
        r105.setColor(((Number) r102).intValue());
        r100.invalidate();
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L79:
        if (Intrinsics.areEqual(r101, AnimationProperty$IntProperty.FILL_COLOR.getPropertyName()) == true) goto L81;
        int r106 = 0;
        if (Intrinsics.areEqual(r101, AnimationProperty$IntProperty.WIDTH.getPropertyName()) == false) goto L98;
        if ((r102 instanceof Integer) == false) goto L161;
        ViewGroup.LayoutParams r107 = r100.getLayoutParams();
        if ((r107 instanceof ViewGroup.LayoutParams) == false) goto L162;
        Number r108 = (Number) r102;
        if (r108.intValue() <= 0) goto L96;
        r106 = r108.intValue();
    L96:
        r107.width = r106;
        r100.setLayoutParams(r107);
        r100.requestLayout();
        return;
    L162:
        return;
    L161:
        return;
    L98:
        if (Intrinsics.areEqual(r101, AnimationProperty$IntProperty.HEIGHT.getPropertyName()) == true) goto L100;
        String r109 = b(r101);     // Catch: Exception -> L119 NoSuchMethodException -> L121
        if ((r102 instanceof Integer) == false) goto L111;
        Class<?> r110 = Integer.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L117:
        r100.getClass().getMethod(r109, new Class[]{r110}).invoke(r100, new Object[]{r102});     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L168:
        return;
    L111:
        if ((r102 instanceof Float) == false) goto L114;
        r110 = Float.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
        goto L117
    L114:
        if ((r102 instanceof Boolean) == false) goto L116;
        r110 = Boolean.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
        goto L117
    L116:
        r110 = r102.getClass();     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L121:
        e = move-exception;
        e.printStackTrace();
        return;
    L119:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        if ((r102 instanceof Integer) == false) goto L164;
        ViewGroup.LayoutParams r111 = r100.getLayoutParams();
        if ((r111 instanceof ViewGroup.LayoutParams) == false) goto L165;
        Number r112 = (Number) r102;
        if (r112.intValue() <= 0) goto L106;
        r106 = r112.intValue();
    L106:
        r111.height = r106;
        r100.setLayoutParams(r111);
        r100.requestLayout();
        return;
    L165:
        return;
    L164:
        return;
    L81:
        if ((r102 instanceof Integer) == false) goto L157;
        Drawable r113 = r100.getBackground();
        if ((r113 instanceof ShapeDrawable) == false) goto L158;
        Paint r114 = ((ShapeDrawable) r113).getPaint();
        if (r114.getStyle() != Paint.Style.FILL) goto L159;
        r114.setColor(((Number) r102).intValue());
        r100.invalidate();
        return;
    L159:
        return;
    L158:
        return;
    }
}
