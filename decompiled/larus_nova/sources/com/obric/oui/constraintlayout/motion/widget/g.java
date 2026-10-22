package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Constructor<? extends d>> f400044b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, ArrayList<d>> f400045a;

    static {
        HashMap<String, Constructor<? extends d>> r100 = new HashMap();
        f400044b = r100;
        r100.put("KeyAttribute", e.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        r100.put("KeyPosition", h.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        r100.put("KeyCycle", f.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        r100.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        r100.put("KeyTrigger", k.class.getConstructor(new Class[0]));     // Catch: NoSuchMethodException -> L5
        return;
    }

    public g() {
        this.f400045a = new HashMap();
    }

    public final void a(n r100) {
        ArrayList<d> r101 = this.f400045a.get(Integer.valueOf(r100.f400116c));
        if (r101 == null) goto L5;
        r100.f400136w.addAll(r101);
    L5:
        ArrayList<d> r102 = this.f400045a.get(-1);
        if (r102 == null) goto L18;
        Iterator<d> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L24;
        d r104 = r103.next();
        String r105 = ((ConstraintLayout.LayoutParams) r100.f400115b.getLayoutParams()).Y;
        String r106 = r104.f400006c;
        if (r106 == null) goto L15;
        if (r105 == null) goto L15;
        boolean r107 = r105.matches(r106);
    L16:
        if (r107 == false) goto L9;
        r100.a(r104);
    L15:
        r107 = false;
        goto L16
    L24:
        return;
    }

    public final void b(d r100) {
        if (this.f400045a.containsKey(Integer.valueOf(r100.f400005b)) == true) goto L5;
        this.f400045a.put(Integer.valueOf(r100.f400005b), new ArrayList());
    L5:
        ArrayList<d> r101 = this.f400045a.get(Integer.valueOf(r100.f400005b));
        if (r101 == null) goto L9;
        r101.add(r100);
        return;
    }

    public g(Context r100, XmlPullParser r101) {
        this.f400045a = new HashMap();
        int r102 = r101.getEventType();     // Catch: Throwable -> L62
        d r103 = null;
    L5:
        if (r102 == 1) goto L78;
        if (r102 == 2) goto L13;
        if (r102 == 3) goto L11;
    L59:
        r102 = r101.next();     // Catch: Throwable -> L62
        goto L5
    L11:
        if ("KeyFrameSet".equals(r101.getName()) == false) goto L59;
        return;
    L13:
        String r104 = r101.getName();     // Catch: Throwable -> L62
        if (f400044b.containsKey(r104) == false) goto L48;
        switch(r104.hashCode()) {
            case -300573030: goto L31;
            case -298435811: goto L28;
            case 540053991: goto L25;
            case 1153397896: goto L22;
            case 1308496505: goto L19;
            default: goto L33;
        };     // Catch: Throwable -> L62
    L33:
        byte r105 = -1;
    L34:
        if (r105 == 0) goto L45;
        if (r105 == 1) goto L44;
        if (r105 == 2) goto L43;
        if (r105 == 3) goto L42;
        if (r105 != 4) goto L41;
        d r106 = new k();     // Catch: Throwable -> L62
    L46:
        r106.e(r100, Xml.asAttributeSet(r101));     // Catch: Throwable -> L62
        b(r106);     // Catch: Throwable -> L62
        r103 = r106;
        goto L59
    L41:
        throw new NullPointerException("Key " + r104 + " not found");     // Catch: Throwable -> L62
        goto L61
    L42:
        r106 = new j();     // Catch: Throwable -> L62
        goto L46
    L43:
        r106 = new f();     // Catch: Throwable -> L62
        goto L46
    L44:
        r106 = new h();     // Catch: Throwable -> L62
        goto L46
    L45:
        r106 = new e();     // Catch: Throwable -> L62
        goto L46
    L19:
        if (r104.equals("KeyTrigger") == false) goto L33;
        r105 = 4;
        goto L34
    L22:
        if (r104.equals("KeyPosition") == false) goto L33;
        r105 = 1;
        goto L34
    L25:
        if (r104.equals("KeyCycle") == false) goto L33;
        r105 = 2;
        goto L34
    L28:
        if (r104.equals("KeyAttribute") == false) goto L33;
        r105 = 0;
        goto L34
    L31:
        if (r104.equals("KeyTimeCycle") == false) goto L33;
        r105 = 3;
        goto L34
    L48:
        if (r104.equalsIgnoreCase("CustomAttribute") == false) goto L54;
        if (r103 == null) goto L59;
        HashMap<String, ConstraintAttribute> r107 = r103.f400007d;     // Catch: Throwable -> L62
        if (r107 == null) goto L59;
        ConstraintAttribute.d(r100, r101, r107);     // Catch: Throwable -> L62
        goto L59
    L54:
        if (r104.equalsIgnoreCase("CustomMethod") == false) goto L59;
        if (r103 == null) goto L59;
        HashMap<String, ConstraintAttribute> r108 = r103.f400007d;     // Catch: Throwable -> L62
        if (r108 == null) goto L59;
        ConstraintAttribute.d(r100, r101, r108);     // Catch: Throwable -> L62
        goto L59
    L78:
        return;
    }
}
