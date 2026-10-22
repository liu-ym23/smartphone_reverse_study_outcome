package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f400075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f400076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f400077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f400078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f400079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RectF f400080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<String, Method> f400081k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f400082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f400083m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f400084n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f400085o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f400086p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f400087q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f400088r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f400089s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f400090t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f400091u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f400092v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f400093w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f400094x;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f400095a = null;

        static {
            SparseIntArray r100 = new SparseIntArray();
            f400095a = r100;
            r100.append(0, 8);
            r100.append(4, 4);
            r100.append(5, 1);
            r100.append(6, 2);
            r100.append(1, 7);
            r100.append(7, 6);
            r100.append(9, 5);
            r100.append(3, 9);
            r100.append(2, 10);
            r100.append(8, 11);
            r100.append(10, 12);
            r100.append(11, 13);
            r100.append(12, 14);
        }
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void a(HashMap<String, vla.d> r100) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void d(HashSet<String> r100) {
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final d b() {
        k r100 = new k();
        super.c(this);
        r100.f400082l = this.f400082l;
        r100.f400083m = this.f400083m;
        r100.f400084n = this.f400084n;
        r100.f400085o = this.f400085o;
        r100.f400086p = this.f400086p;
        r100.f400087q = this.f400087q;
        r100.f400088r = this.f400088r;
        r100.f400075e = this.f400075e;
        r100.f400089s = this.f400089s;
        r100.f400090t = this.f400090t;
        r100.f400091u = this.f400091u;
        r100.f400092v = this.f400092v;
        r100.f400093w = this.f400093w;
        r100.f400094x = this.f400094x;
        r100.f400079i = this.f400079i;
        r100.f400080j = this.f400080j;
        r100.f400081k = this.f400081k;
        return r100;
    }

    public k() {
        this.f400075e = 0.1f;
        this.f400076f = -1;
        this.f400077g = -1;
        this.f400078h = -1;
        this.f400079i = new RectF();
        this.f400080j = new RectF();
        this.f400081k = new HashMap();
        this.f400082l = null;
        this.f400083m = -1;
        this.f400084n = null;
        this.f400085o = null;
        this.f400086p = -1;
        this.f400087q = -1;
        this.f400088r = null;
        this.f400089s = true;
        this.f400090t = true;
        this.f400091u = true;
        this.f400092v = Float.NaN;
        this.f400094x = false;
        this.f400007d = new HashMap();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.d
    public final void e(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.framePosition, R.attr.motionTarget, R.attr.motion_postLayoutCollision, R.attr.motion_triggerOnCollision, R.attr.onCross, R.attr.onNegativeCross, R.attr.onPositiveCross, R.attr.triggerId, R.attr.triggerReceiver, R.attr.triggerSlack, R.attr.viewTransitionOnCross, R.attr.viewTransitionOnNegativeCross, R.attr.viewTransitionOnPositiveCross});
        SparseIntArray r103 = a.f400095a;
        int r104 = r102.getIndexCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L29;
        int r106 = r102.getIndex(r105);
        SparseIntArray r107 = a.f400095a;
        switch(r107.get(r106)) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L6;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            default: goto L6;
        };
    L6:
        Integer.toHexString(r106);
        r107.get(r106);
    L28:
        r105 = r105 + 1;
        goto L3
    L7:
        this.f400077g = r102.getResourceId(r106, this.f400077g);
        goto L28
    L8:
        this.f400076f = r102.getResourceId(r106, this.f400076f);
        goto L28
    L9:
        this.f400078h = r102.getResourceId(r106, this.f400078h);
        goto L28
    L10:
        this.f400083m = r102.getResourceId(r106, this.f400083m);
        goto L28
    L11:
        this.f400094x = r102.getBoolean(r106, this.f400094x);
        goto L28
    L12:
        this.f400087q = r102.getResourceId(r106, this.f400087q);
        goto L28
    L13:
        int r108 = r102.getInteger(r106, this.f400004a);
        this.f400004a = r108;
        this.f400092v = (r108 + 0.5f) / 100.0f;
        goto L28
    L23:
        this.f400086p = r102.getResourceId(r106, this.f400086p);
        goto L28
    L24:
        this.f400075e = r102.getFloat(r106, this.f400075e);
        goto L28
    L25:
        this.f400082l = r102.getString(r106);
        goto L28
    L26:
        this.f400085o = r102.getString(r106);
        goto L28
    L27:
        this.f400084n = r102.getString(r106);
        goto L28
    L15:
        if (MotionLayout.F2 == false) goto L20;
        int r109 = r102.getResourceId(r106, this.f400005b);
        this.f400005b = r109;
        if (r109 != (-1)) goto L28;
        this.f400006c = r102.getString(r106);
        goto L28
    L20:
        if (r102.peekValue(r106).type != 3) goto L22;
        this.f400006c = r102.getString(r106);
        goto L28
    L22:
        this.f400005b = r102.getResourceId(r106, this.f400005b);
        goto L28
    }

    public final void h(float r110, View r111) {
        if (this.f400087q == (-1)) goto L28;
        if (this.f400088r != null) goto L7;
        this.f400088r = ((ViewGroup) r111.getParent()).findViewById(this.f400087q);
    L7:
        j(this.f400079i, this.f400088r, this.f400094x);
        j(this.f400080j, r111, this.f400094x);
        if (this.f400079i.intersect(this.f400080j) == false) goto L19;
        if (this.f400089s == false) goto L12;
        this.f400089s = false;
        boolean r100 = true;
    L14:
        if (this.f400091u == false) goto L16;
        this.f400091u = false;
        boolean r101 = true;
    L17:
        this.f400090t = true;
        boolean r102 = false;
    L60:
        this.f400093w = r110;
        if (r102 == true) goto L64;
        if (r100 == true) goto L64;
        if (r101 == true) goto L64;
    L74:
        if (this.f400083m != (-1)) goto L76;
        View r112 = r111;
    L77:
        if (r102 == false) goto L84;
        String r103 = this.f400084n;
        if (r103 == null) goto L82;
        i(r103, r112);
    L82:
        if (this.f400076f == (-1)) goto L84;
        ((MotionLayout) r111.getParent()).C(this.f400076f, new View[]{r112});
    L84:
        if (r101 == false) goto L91;
        String r104 = this.f400085o;
        if (r104 == null) goto L89;
        i(r104, r112);
    L89:
        if (this.f400077g == (-1)) goto L91;
        ((MotionLayout) r111.getParent()).C(this.f400077g, new View[]{r112});
    L91:
        if (r100 == false) goto L100;
        String r105 = this.f400082l;
        if (r105 == null) goto L96;
        i(r105, r112);
    L96:
        if (this.f400078h == (-1)) goto L101;
        ((MotionLayout) r111.getParent()).C(this.f400078h, new View[]{r112});
        return;
    L101:
        return;
    L100:
        return;
    L76:
        r112 = ((MotionLayout) r111.getParent()).findViewById(this.f400083m);
    L64:
        MotionLayout r113 = (MotionLayout) r111.getParent();
        MotionLayout.i r106 = r113.f399940J;
        if (r106 == null) goto L67;
        r106.a();
    L67:
        CopyOnWriteArrayList<MotionLayout.i> r114 = r113.P0;
        if (r114 == null) goto L74;
        Iterator<MotionLayout.i> r115 = r114.iterator();
    L71:
        if (r115.hasNext() == false) goto L74;
        r115.next().a();
        goto L71
    L16:
        r101 = false;
        goto L17
    L12:
        r100 = false;
        goto L14
    L19:
        if (this.f400089s == true) goto L21;
        this.f400089s = true;
        r100 = true;
    L23:
        if (this.f400090t == false) goto L25;
        this.f400090t = false;
        boolean r107 = true;
    L26:
        this.f400091u = true;
    L58:
        r102 = r107;
    L59:
        r101 = false;
        goto L60
    L25:
        r107 = false;
        goto L26
    L21:
        r100 = false;
        goto L23
    L28:
        if (this.f400089s == false) goto L33;
        float r108 = this.f400092v;
        if (((r110 - r108) * (this.f400093w - r108)) >= 0.0f) goto L35;
        this.f400089s = false;
        r100 = true;
    L37:
        if (this.f400090t == false) goto L44;
        float r109 = this.f400092v;
        float r116 = r110 - r109;
        if (((this.f400093w - r109) * r116) < 0.0f) goto L41;
    L46:
        r102 = false;
    L48:
        if (this.f400091u == false) goto L55;
        float r117 = this.f400092v;
        float r118 = r110 - r117;
        if (((this.f400093w - r117) * r118) >= 0.0f) goto L59;
        if (r118 <= 0.0f) goto L59;
        this.f400091u = false;
        r101 = true;
        goto L60
    L55:
        if (Math.abs(r110 - this.f400092v) <= this.f400075e) goto L57;
        this.f400091u = true;
    L57:
        r107 = r102;
        goto L58
    L41:
        if (r116 >= 0.0f) goto L46;
        this.f400090t = false;
        r102 = true;
        goto L48
    L44:
        if (Math.abs(r110 - this.f400092v) <= this.f400075e) goto L46;
        this.f400090t = true;
    L35:
        r100 = false;
        goto L37
    L33:
        if (Math.abs(r110 - this.f400092v) <= this.f400075e) goto L35;
        this.f400089s = true;
        goto L35
    }

    public final void i(String r110, View r111) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.startsWith(".") == false) goto L40;
        if (r110.length() != 1) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == true) goto L12;
        r110 = r110.substring(1).toLowerCase(Locale.ROOT);
    L12:
        Iterator<String> r101 = this.f400007d.keySet().iterator();
    L14:
        if (r101.hasNext() == false) goto L38;
        String r102 = r101.next();
        String r103 = r102.toLowerCase(Locale.ROOT);
        if (r100 == true) goto L19;
        if (r103.matches(r110) == false) goto L14;
    L19:
        ConstraintAttribute r104 = this.f400007d.get(r102);
        if (r104 == null) goto L14;
        Class<?> r105 = r111.getClass();
        String r106 = r104.f400368b;
        if (r104.f400367a == true) goto L58;
        r106 = "set" + r106;
    L58:
        goto L14
    L25:
        switch(ConstraintAttribute.a.f400376a[r104.f400369c.ordinal()]) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L33;
            case 7: goto L28;
            case 8: goto L27;
            default: goto L14;
        };     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
    L27:
        r105.getMethod(r106, new Class[]{Float.TYPE}).invoke(r111, new Object[]{Float.valueOf(r104.f400371e)});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L28:
        r105.getMethod(r106, new Class[]{Float.TYPE}).invoke(r111, new Object[]{Float.valueOf(r104.f400371e)});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L29:
        Method r107 = r105.getMethod(r106, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        ColorDrawable r108 = new ColorDrawable();     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        r108.setColor(r104.f400374h);     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        r107.invoke(r111, new Object[]{r108});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L30:
        r105.getMethod(r106, new Class[]{Integer.TYPE}).invoke(r111, new Object[]{Integer.valueOf(r104.f400374h)});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L31:
        r105.getMethod(r106, new Class[]{CharSequence.class}).invoke(r111, new Object[]{r104.f400372f});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L32:
        r105.getMethod(r106, new Class[]{Boolean.TYPE}).invoke(r111, new Object[]{Boolean.valueOf(r104.f400373g)});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L33:
        r105.getMethod(r106, new Class[]{Integer.TYPE}).invoke(r111, new Object[]{Integer.valueOf(r104.f400370d)});     // Catch: InvocationTargetException -> L35 IllegalAccessException -> L36 NoSuchMethodException -> L37
        goto L14
    L38:
        return;
    L9:
        r100 = false;
        goto L10
    L40:
        if (this.f400081k.containsKey(r110) == false) goto L44;
        Method r109 = this.f400081k.get(r110);
        if (r109 != null) goto L45;
        return;
    L45:
        if (r109 != null) goto L56;
        r109 = r111.getClass().getMethod(r110, new Class[0]);     // Catch: NoSuchMethodException -> L48
        this.f400081k.put(r110, r109);     // Catch: NoSuchMethodException -> L48
    L48:
        this.f400081k.put(r110, null);
        r111.getClass();
        com.obric.oui.constraintlayout.motion.widget.a.d(r111);
        return;
    L56:
        r109.invoke(r111, new Object[0]);     // Catch: Exception -> L52
        return;
    L52:
        r111.getClass();
        com.obric.oui.constraintlayout.motion.widget.a.d(r111);
        return;
    L44:
        r109 = null;
        goto L45
    }

    public static void j(RectF r100, View r101, boolean r102) {
        r100.top = r101.getTop();
        r100.bottom = r101.getBottom();
        r100.left = r101.getLeft();
        r100.right = r101.getRight();
        if (r102 == false) goto L6;
        r101.getMatrix().mapRect(r100);
        return;
    }
}
