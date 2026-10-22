package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class ConstraintAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f400367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f400368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AttributeType f400369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f400371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f400372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f400373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f400374h;

    public static final enum AttributeType extends Enum<AttributeType> {
        public static final AttributeType BOOLEAN_TYPE = null;
        public static final AttributeType COLOR_DRAWABLE_TYPE = null;
        public static final AttributeType COLOR_TYPE = null;
        public static final AttributeType DIMENSION_TYPE = null;
        public static final AttributeType FLOAT_TYPE = null;
        public static final AttributeType INT_TYPE = null;
        public static final AttributeType REFERENCE_TYPE = null;
        public static final AttributeType STRING_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AttributeType[] f400375a = null;

        static {
            AttributeType r100 = new AttributeType("INT_TYPE", 0);
            INT_TYPE = r100;
            AttributeType r101 = new AttributeType("FLOAT_TYPE", 1);
            FLOAT_TYPE = r101;
            AttributeType r102 = new AttributeType("COLOR_TYPE", 2);
            COLOR_TYPE = r102;
            AttributeType r103 = new AttributeType("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r103;
            AttributeType r104 = new AttributeType("STRING_TYPE", 4);
            STRING_TYPE = r104;
            AttributeType r105 = new AttributeType("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r105;
            AttributeType r110 = new AttributeType("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r110;
            AttributeType r111 = new AttributeType("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r111;
            f400375a = new AttributeType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static AttributeType[] values() {
            return (AttributeType[]) f400375a.clone();
        }

        public static AttributeType valueOf(String r100) {
            return (AttributeType) r27.a.a(AttributeType.class, r100);
        }

        public AttributeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400376a = null;

        static {
            int[] r100 = new int[AttributeType.values().length];
            f400376a = r100;
            r100[AttributeType.REFERENCE_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f400376a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f400376a[AttributeType.STRING_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f400376a[AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f400376a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f400376a[AttributeType.INT_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f400376a[AttributeType.FLOAT_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f400376a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public final float a() {
        switch(a.f400376a[this.f400369c.ordinal()]) {
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L4;
        };
    L4:
        return Float.NaN;
    L7:
        return this.f400371e;
    L9:
        return this.f400370d;
    L11:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L13:
        throw new RuntimeException("Cannot interpolate String");
    L15:
        if (this.f400373g == false) goto L17;
        return 1.0f;
    L17:
        return 0.0f;
    }

    public final int c() {
        int r100 = a.f400376a[this.f400369c.ordinal()];
        if (r100 != 4) goto L5;
    L8:
        return 4;
    L5:
        if (r100 == 5) goto L8;
        return 1;
    }

    public AttributeType getType() {
        return this.f400369c;
    }

    public final void b(float[] r110) {
        switch(a.f400376a[this.f400369c.ordinal()]) {
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L21;
        };
    L5:
        r110[0] = this.f400371e;
        return;
    L6:
        r110[0] = this.f400371e;
        return;
    L7:
        r110[0] = this.f400370d;
        return;
    L8:
        int r100 = this.f400374h;
        int r101 = (r100 >> 24) & 255;
        float r102 = (float) Math.pow(((r100 >> 16) & 255) / 255.0f, 2.2d);
        float r103 = (float) Math.pow(((r100 >> 8) & 255) / 255.0f, 2.2d);
        float r104 = (float) Math.pow((r100 & 255) / 255.0f, 2.2d);
        r110[0] = r102;
        r110[1] = r103;
        r110[2] = r104;
        r110[3] = r101 / 255.0f;
        return;
    L21:
        return;
    L10:
        throw new RuntimeException("Color does not have a single color to interpolate");
    L12:
        if (this.f400373g == false) goto L14;
        float r105 = 1.0f;
    L15:
        r110[0] = r105;
        return;
    L14:
        r105 = 0.0f;
        goto L15
    }

    public final void f(Object r100) {
        switch(a.f400376a[this.f400369c.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L17;
        };
    L5:
        this.f400371e = ((Float) r100).floatValue();
        return;
    L6:
        this.f400371e = ((Float) r100).floatValue();
        return;
    L7:
        this.f400374h = ((Integer) r100).intValue();
        return;
    L8:
        this.f400372f = (String) r100;
        return;
    L9:
        this.f400373g = ((Boolean) r100).booleanValue();
        return;
    L10:
        this.f400370d = ((Integer) r100).intValue();
        return;
    }

    public ConstraintAttribute(ConstraintAttribute r100, Object r101) {
        this.f400367a = false;
        this.f400368b = r100.f400368b;
        this.f400369c = r100.f400369c;
        f(r101);
    }

    public static void e(View r100, HashMap<String, ConstraintAttribute> r101) {
        Class<?> r102 = r100.getClass();
        Iterator<String> r103 = r101.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L23;
        String r104 = r103.next();
        ConstraintAttribute r105 = r101.get(r104);
        if (r105.f400367a == true) goto L24;
        r104 = "set" + r104;
    L24:
        goto L4
    L9:
        switch(a.f400376a[r105.f400369c.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L4;
        };     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
    L11:
        r102.getMethod(r104, new Class[]{Float.TYPE}).invoke(r100, new Object[]{Float.valueOf(r105.f400371e)});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L12:
        r102.getMethod(r104, new Class[]{Float.TYPE}).invoke(r100, new Object[]{Float.valueOf(r105.f400371e)});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L13:
        r102.getMethod(r104, new Class[]{Integer.TYPE}).invoke(r100, new Object[]{Integer.valueOf(r105.f400370d)});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L14:
        Method r106 = r102.getMethod(r104, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        ColorDrawable r107 = new ColorDrawable();     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        r107.setColor(r105.f400374h);     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        r106.invoke(r100, new Object[]{r107});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L15:
        r102.getMethod(r104, new Class[]{Integer.TYPE}).invoke(r100, new Object[]{Integer.valueOf(r105.f400374h)});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L16:
        r102.getMethod(r104, new Class[]{CharSequence.class}).invoke(r100, new Object[]{r105.f400372f});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L17:
        r102.getMethod(r104, new Class[]{Boolean.TYPE}).invoke(r100, new Object[]{Boolean.valueOf(r105.f400373g)});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    L18:
        r102.getMethod(r104, new Class[]{Integer.TYPE}).invoke(r100, new Object[]{Integer.valueOf(r105.f400370d)});     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L21 NoSuchMethodException -> L22
        goto L4
    }

    public static void d(Context r110, XmlPullParser r111, HashMap<String, ConstraintAttribute> r112) {
        TypedArray r113 = r110.obtainStyledAttributes(Xml.asAttributeSet(r111), new int[]{R.attr.attributeName, R.attr.customBoolean, R.attr.customColorDrawableValue, R.attr.customColorValue, R.attr.customDimension, R.attr.customFloatValue, R.attr.customIntegerValue, R.attr.customPixelDimension, R.attr.customReference, R.attr.customStringValue, R.attr.methodName});
        int r100 = r113.getIndexCount();
        String r101 = null;
        Object r102 = null;
        AttributeType r103 = null;
        int r104 = 0;
        boolean r105 = false;
    L3:
        if (r104 >= r100) goto L45;
        int r106 = r113.getIndex(r104);
        if (r106 != 0) goto L12;
        r101 = r113.getString(r106);
        if (r101 == null) goto L44;
        if (r101.length() <= 0) goto L44;
        r101 = Character.toUpperCase(r101.charAt(0)) + r101.substring(1);
    L44:
        r104 = r104 + 1;
        goto L3
    L12:
        if (r106 != 10) goto L14;
        r101 = r113.getString(r106);
        r105 = true;
        goto L44
    L14:
        if (r106 != 1) goto L17;
        r102 = Boolean.valueOf(r113.getBoolean(r106, false));
        r103 = AttributeType.BOOLEAN_TYPE;
        goto L44
    L17:
        if (r106 != 3) goto L20;
        AttributeType r107 = AttributeType.COLOR_TYPE;
        Object r108 = Integer.valueOf(r113.getColor(r106, 0));
    L43:
        Object r114 = r108;
        r103 = r107;
        r102 = r114;
        goto L44
    L20:
        if (r106 != 2) goto L23;
        r107 = AttributeType.COLOR_DRAWABLE_TYPE;
        r108 = Integer.valueOf(r113.getColor(r106, 0));
        goto L43
    L23:
        if (r106 != 7) goto L26;
        r107 = AttributeType.DIMENSION_TYPE;
        float r109 = r113.getDimension(r106, 0.0f);
        Resources r115 = r110.getResources();
        r108 = Float.valueOf(TypedValue.applyDimension(1, r109, WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics())));
        goto L43
    L26:
        if (r106 != 4) goto L29;
        r107 = AttributeType.DIMENSION_TYPE;
        r108 = Float.valueOf(r113.getDimension(r106, 0.0f));
        goto L43
    L29:
        if (r106 != 5) goto L32;
        r107 = AttributeType.FLOAT_TYPE;
        r108 = Float.valueOf(r113.getFloat(r106, Float.NaN));
        goto L43
    L32:
        if (r106 != 6) goto L35;
        r107 = AttributeType.INT_TYPE;
        r108 = Integer.valueOf(r113.getInteger(r106, -1));
        goto L43
    L35:
        if (r106 != 9) goto L38;
        r107 = AttributeType.STRING_TYPE;
        r108 = r113.getString(r106);
        goto L43
    L38:
        if (r106 != 8) goto L44;
        r107 = AttributeType.REFERENCE_TYPE;
        int r116 = r113.getResourceId(r106, -1);
        if (r116 != (-1)) goto L42;
        r116 = r113.getInt(r106, -1);
    L42:
        r108 = Integer.valueOf(r116);
        goto L43
    L45:
        if (r101 == null) goto L48;
        if (r102 == null) goto L48;
        r112.put(r101, new ConstraintAttribute(r101, r103, r102, r105));
    L48:
        r113.recycle();
    }

    public ConstraintAttribute(String r100, AttributeType r101, Object r102, boolean r103) {
        this.f400367a = false;
        this.f400368b = r100;
        this.f400369c = r101;
        this.f400367a = r103;
        f(r102);
    }
}
