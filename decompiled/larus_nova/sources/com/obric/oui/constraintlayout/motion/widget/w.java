package com.obric.oui.constraintlayout.motion.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f400230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f400233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.obric.oui.constraintlayout.widget.a.C4670a f400234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f400235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f400236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f400237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f400238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f400239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f400240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f400241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Context f400242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f400243p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f400244q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f400245r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f400246s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f400247t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f400248u;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f400249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f400250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n f400251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f400252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final tla.d f400253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final y f400254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Interpolator f400255g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f400256h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f400257i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f400258j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f400259k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Rect f400260l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f400261m;

        public final void b() {
            this.f400256h = true;
            int r100 = this.f400252d;
            if (r100 == (-1)) goto L8;
            if (r100 != 0) goto L6;
            float r101 = Float.MAX_VALUE;
        L7:
            this.f400258j = r101;
            goto L8
        L6:
            r101 = 1.0f / r100;
        L8:
            this.f400254f.f400262a.invalidate();
            this.f400259k = System.nanoTime();
        }

        public final void a() {
            if (this.f400256h == false) goto L24;
            long r100 = System.nanoTime();
            long r101 = r100 - this.f400259k;
            this.f400259k = r100;
            float r102 = this.f400257i - (((float) (r101 * 1.0E-6d)) * this.f400258j);
            this.f400257i = r102;
            if (r102 >= 0.0f) goto L7;
            this.f400257i = 0.0f;
        L7:
            Interpolator r103 = this.f400255g;
            if (r103 != null) goto L10;
            float r104 = this.f400257i;
        L11:
            n r105 = this.f400251c;
            boolean r106 = r105.e(r105.f400115b, r104, r100, this.f400253e);
            if (this.f400257i > 0.0f) goto L21;
            int r107 = this.f400249a;
            if (r107 == (-1)) goto L16;
            this.f400251c.f400115b.setTag(r107, Long.valueOf(System.nanoTime()));
        L16:
            int r108 = this.f400250b;
            if (r108 == (-1)) goto L19;
            this.f400251c.f400115b.setTag(r108, null);
        L19:
            this.f400254f.f400266e.add(this);
        L21:
            if (this.f400257i > 0.0f) goto L23;
            if (r106 == true) goto L23;
            return;
        L23:
            this.f400254f.f400262a.invalidate();
            return;
        L10:
            r104 = r103.getInterpolation(this.f400257i);
            goto L11
        L24:
            long r109 = System.nanoTime();
            long r110 = r109 - this.f400259k;
            this.f400259k = r109;
            float r111 = this.f400257i + (((float) (r110 * 1.0E-6d)) * this.f400258j);
            this.f400257i = r111;
            if (r111 < 1.0f) goto L27;
            this.f400257i = 1.0f;
        L27:
            Interpolator r112 = this.f400255g;
            if (r112 != null) goto L30;
            float r113 = this.f400257i;
        L31:
            n r114 = this.f400251c;
            boolean r115 = r114.e(r114.f400115b, r113, r109, this.f400253e);
            if (this.f400257i < 1.0f) goto L43;
            int r116 = this.f400249a;
            if (r116 == (-1)) goto L36;
            this.f400251c.f400115b.setTag(r116, Long.valueOf(System.nanoTime()));
        L36:
            int r117 = this.f400250b;
            if (r117 == (-1)) goto L40;
            this.f400251c.f400115b.setTag(r117, null);
        L40:
            if (this.f400261m == true) goto L43;
            this.f400254f.f400266e.add(this);
        L43:
            if (this.f400257i < 1.0f) goto L45;
            if (r115 == true) goto L45;
            return;
        L45:
            this.f400254f.f400262a.invalidate();
            return;
        L30:
            r113 = r112.getInterpolation(this.f400257i);
            goto L31
        }

        public a(y r100, n r101, int r102, int r103, int r104, Interpolator r105, int r106, int r110) {
            this.f400253e = new tla.d();
            this.f400256h = false;
            this.f400260l = new Rect();
            this.f400261m = false;
            this.f400254f = r100;
            this.f400251c = r101;
            this.f400252d = r103;
            this.f400259k = System.nanoTime();
            if (r100.f400265d != null) goto L5;
            r100.f400265d = new ArrayList();
        L5:
            r100.f400265d.add(this);
            this.f400255g = r105;
            this.f400249a = r106;
            this.f400250b = r110;
            if (r104 != 3) goto L8;
            this.f400261m = true;
        L8:
            if (r102 != 0) goto L10;
            float r107 = Float.MAX_VALUE;
        L11:
            this.f400258j = r107;
            a();
            return;
        L10:
            r107 = 1.0f / r102;
            goto L11
        }
    }

    public final String toString() {
        return "ViewTransition(" + com.obric.oui.constraintlayout.motion.widget.a.c(this.f400242o, this.f400228a) + ")";
    }

    public final boolean b(View r100) {
        int r101 = this.f400245r;
        if (r101 != (-1)) goto L6;
    L4:
        boolean r102 = true;
    L9:
        int r103 = this.f400246s;
        if (r103 != (-1)) goto L13;
    L11:
        boolean r104 = true;
    L16:
        if (r102 == false) goto L20;
        if (r104 == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L13:
        if (r100.getTag(r103) == null) goto L11;
        r104 = false;
        goto L16
    L6:
        if (r100.getTag(r101) != null) goto L4;
        r102 = false;
        goto L9
    }

    public final boolean c(View r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f400237j != (-1)) goto L11;
        if (this.f400238k != null) goto L11;
        return false;
    L11:
        if (b(r100) == true) goto L14;
        return false;
    L14:
        if (r100.getId() != this.f400237j) goto L17;
        return true;
    L17:
        if (this.f400238k != null) goto L20;
        return false;
    L20:
        if ((r100.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        String r101 = ((ConstraintLayout.LayoutParams) r100.getLayoutParams()).Y;
        if (r101 == null) goto L26;
        if (r101.matches(this.f400238k) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public w(Context r110, XmlPullParser r111) {
        this.f400229b = -1;
        this.f400230c = false;
        this.f400231d = 0;
        this.f400235h = -1;
        this.f400236i = -1;
        this.f400239l = 0;
        this.f400240m = null;
        this.f400241n = -1;
        this.f400243p = -1;
        this.f400244q = -1;
        this.f400245r = -1;
        this.f400246s = -1;
        this.f400247t = -1;
        this.f400248u = -1;
        this.f400242o = r110;
        int r100 = r111.getEventType();     // Catch: Throwable -> L45
    L5:
        if (r100 == 1) goto L57;
        if (r100 == 2) goto L13;
        if (r100 != 3) goto L42;
        if ("ViewTransition".equals(r111.getName()) == false) goto L42;
        return;
    L42:
        r100 = r111.next();     // Catch: Throwable -> L45 Throwable -> L45
        goto L5
    L13:
        String r101 = r111.getName();     // Catch: Throwable -> L45 Throwable -> L45
        switch(r101.hashCode()) {
            case -1962203927: goto L29;
            case -1239391468: goto L26;
            case 61998586: goto L23;
            case 366511058: goto L20;
            case 1791837707: goto L17;
            default: goto L31;
        };     // Catch: Throwable -> L45 Throwable -> L45
    L31:
        byte r102 = -1;
    L32:
        if (r102 == 0) goto L41;
        if (r102 == 1) goto L40;
        if (r102 == 2) goto L39;
        if (r102 == 3) goto L38;
        if (r102 == 4) goto L38;
        com.obric.oui.constraintlayout.motion.widget.a.a();     // Catch: Throwable -> L45 Throwable -> L45
        r111.getLineNumber();     // Catch: Throwable -> L45 Throwable -> L45
    L38:
        ConstraintAttribute.d(r110, r111, this.f400234g.f400492g);     // Catch: Throwable -> L45 Throwable -> L45
        goto L42
    L39:
        this.f400234g = com.obric.oui.constraintlayout.widget.a.d(r110, r111);     // Catch: Throwable -> L45 Throwable -> L45
        goto L42
    L40:
        this.f400233f = new g(r110, r111);     // Catch: Throwable -> L45 Throwable -> L45
        goto L42
    L41:
        d(r110, r111);     // Catch: Throwable -> L45 Throwable -> L45
        goto L42
    L17:
        if (r101.equals("CustomAttribute") == false) goto L31;
        r102 = 3;
        goto L32
    L20:
        if (r101.equals("CustomMethod") == false) goto L31;
        r102 = 4;
        goto L32
    L23:
        if (r101.equals("ViewTransition") == false) goto L31;
        r102 = 0;
        goto L32
    L26:
        if (r101.equals("KeyFrameSet") == false) goto L31;
        r102 = 1;
        goto L32
    L29:
        if (r101.equals("ConstraintOverride") == false) goto L31;
        r102 = 2;
        goto L32
    L57:
        return;
    }

    public final void d(Context r100, XmlPullParser r101) {
        TypedArray r102 = r100.obtainStyledAttributes(Xml.asAttributeSet(r101), new int[]{R.attr.id, com.larus.nova.R.attr.SharedValue, com.larus.nova.R.attr.SharedValueId, com.larus.nova.R.attr.clearsTag, com.larus.nova.R.attr.duration, com.larus.nova.R.attr.ifTagNotSet, com.larus.nova.R.attr.ifTagSet, com.larus.nova.R.attr.motionInterpolator, com.larus.nova.R.attr.motionTarget, com.larus.nova.R.attr.onStateTransition, com.larus.nova.R.attr.pathMotionArc, com.larus.nova.R.attr.setsTag, com.larus.nova.R.attr.transitionDisable, com.larus.nova.R.attr.upDuration, com.larus.nova.R.attr.viewTransitionMode});
        int r103 = r102.getIndexCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L68;
        int r105 = r102.getIndex(r104);
        if (r105 != 0) goto L8;
        this.f400228a = r102.getResourceId(r105, this.f400228a);
    L67:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r105 != 8) goto L19;
        if (MotionLayout.F2 == false) goto L15;
        int r106 = r102.getResourceId(r105, this.f400237j);
        this.f400237j = r106;
        if (r106 != (-1)) goto L67;
        this.f400238k = r102.getString(r105);
        goto L67
    L15:
        if (r102.peekValue(r105).type != 3) goto L17;
        this.f400238k = r102.getString(r105);
        goto L67
    L17:
        this.f400237j = r102.getResourceId(r105, this.f400237j);
        goto L67
    L19:
        if (r105 != 9) goto L22;
        this.f400229b = r102.getInt(r105, this.f400229b);
        goto L67
    L22:
        if (r105 != 12) goto L25;
        this.f400230c = r102.getBoolean(r105, this.f400230c);
        goto L67
    L25:
        if (r105 != 10) goto L28;
        this.f400231d = r102.getInt(r105, this.f400231d);
        goto L67
    L28:
        if (r105 != 4) goto L31;
        this.f400235h = r102.getInt(r105, this.f400235h);
        goto L67
    L31:
        if (r105 != 13) goto L34;
        this.f400236i = r102.getInt(r105, this.f400236i);
        goto L67
    L34:
        if (r105 != 14) goto L37;
        this.f400232e = r102.getInt(r105, this.f400232e);
        goto L67
    L37:
        if (r105 != 7) goto L52;
        int r107 = r102.peekValue(r105).type;
        if (r107 != 1) goto L43;
        int r108 = r102.getResourceId(r105, -1);
        this.f400241n = r108;
        if (r108 == (-1)) goto L67;
        this.f400239l = -2;
        goto L67
    L43:
        if (r107 != 3) goto L50;
        String r109 = r102.getString(r105);
        this.f400240m = r109;
        if (r109 != null) goto L47;
    L49:
        this.f400239l = -1;
        goto L67
    L47:
        if (r109.indexOf(HTTP.URL_DEFAULT) <= 0) goto L49;
        this.f400241n = r102.getResourceId(r105, -1);
        this.f400239l = -2;
        goto L67
    L50:
        this.f400239l = r102.getInteger(r105, this.f400239l);
        goto L67
    L52:
        if (r105 != 11) goto L54;
        this.f400243p = r102.getResourceId(r105, this.f400243p);
        goto L67
    L54:
        if (r105 != 3) goto L57;
        this.f400244q = r102.getResourceId(r105, this.f400244q);
        goto L67
    L57:
        if (r105 != 6) goto L60;
        this.f400245r = r102.getResourceId(r105, this.f400245r);
        goto L67
    L60:
        if (r105 != 5) goto L63;
        this.f400246s = r102.getResourceId(r105, this.f400246s);
        goto L67
    L63:
        if (r105 != 2) goto L65;
        this.f400248u = r102.getResourceId(r105, this.f400248u);
        goto L67
    L65:
        if (r105 != 1) goto L67;
        this.f400247t = r102.getInteger(r105, this.f400247t);
        goto L67
    L68:
        r102.recycle();
    }

    public final void a(y r210, MotionLayout r211, int r212, com.obric.oui.constraintlayout.widget.a r213, final View... r214) {
        if (this.f400230c == false) goto L5;
        return;
    L5:
        int r100 = this.f400232e;
        Interpolator r101 = null;
        int r102 = 0;
        if (r100 != 2) goto L34;
        View r103 = r214[0];
        n r110 = new n(r103);
        p r104 = r110.f400119f;
        r104.f400143c = 0.0f;
        r104.f400144d = 0.0f;
        r110.H = true;
        r104.d(r103.getX(), r103.getY(), r103.getWidth(), r103.getHeight());
        r110.f400120g.d(r103.getX(), r103.getY(), r103.getWidth(), r103.getHeight());
        l r105 = r110.f400121h;
        r105.getClass();
        r103.getX();
        r103.getY();
        r103.getWidth();
        r103.getHeight();
        r105.b(r103);
        l r106 = r110.f400122i;
        r106.getClass();
        r103.getX();
        r103.getY();
        r103.getWidth();
        r103.getHeight();
        r106.b(r103);
        ArrayList<d> r107 = this.f400233f.f400045a.get(-1);
        if (r107 == null) goto L10;
        r110.f400136w.addAll(r107);
    L10:
        r110.h(r211.getWidth(), r211.getHeight(), System.nanoTime());
        int r111 = this.f400235h;
        int r112 = this.f400236i;
        int r108 = this.f400229b;
        Context r109 = r211.getContext();
        int r113 = this.f400239l;
        if (r113 == (-2)) goto L30;
        if (r113 == (-1)) goto L29;
        if (r113 == 0) goto L28;
        if (r113 == 1) goto L27;
        if (r113 != 2) goto L17;
        r101 = new DecelerateInterpolator();
    L31:
        Interpolator r114 = r101;
    L32:
        new a(r210, r110, r111, r112, r108, r114, this.f400243p, this.f400244q);
        return;
    L17:
        if (r113 != 4) goto L19;
        r101 = new BounceInterpolator();
        goto L31
    L19:
        if (r113 != 5) goto L21;
        r101 = new OvershootInterpolator();
        goto L31
    L21:
        if (r113 != 6) goto L31;
        r101 = new AnticipateInterpolator();
        goto L31
    L27:
        r101 = new AccelerateInterpolator();
        goto L31
    L28:
        r101 = new AccelerateDecelerateInterpolator();
        goto L31
    L29:
        r114 = new v(tla.c.c(this.f400240m));
        goto L32
    L30:
        r101 = AnimationUtils.loadInterpolator(r109, this.f400241n);
        goto L31
    L34:
        if (r100 != 1) goto L55;
        int[] r115 = r211.getConstraintSetIds();
        int r116 = 0;
    L37:
        if (r116 >= r115.length) goto L55;
        int r117 = r115[r116];
        if (r117 == r212) goto L54;
        q r118 = r211.f399952q;
        if (r118 != null) goto L44;
        com.obric.oui.constraintlayout.widget.a r119 = null;
    L45:
        int r120 = r214.length;
        int r121 = 0;
    L46:
        if (r121 >= r120) goto L54;
        com.obric.oui.constraintlayout.widget.a.C4670a r122 = r119.i(r214[r121].getId());
        com.obric.oui.constraintlayout.widget.a.C4670a r123 = this.f400234g;
        if (r123 == null) goto L53;
        com.obric.oui.constraintlayout.widget.a.C4670a.C4671a r124 = r123.f400493h;
        if (r124 == null) goto L52;
        r124.e(r122);
    L52:
        r122.f400492g.putAll(this.f400234g.f400492g);
    L53:
        r121 = r121 + 1;
        goto L46
    L44:
        r119 = r118.b(r117);
    L54:
        r116 = r116 + 1;
    L55:
        com.obric.oui.constraintlayout.widget.a r125 = new com.obric.oui.constraintlayout.widget.a();
        r125.f400485g.clear();
        Iterator<Integer> r126 = r213.f400485g.keySet().iterator();
    L57:
        if (r126.hasNext() == false) goto L62;
        Integer r127 = r126.next();
        com.obric.oui.constraintlayout.widget.a.C4670a r128 = r213.f400485g.get(r127);
        if (r128 == null) goto L57;
        r125.f400485g.put(r127, r128.b());
        goto L57
    L62:
        int r129 = r214.length;
        int r130 = 0;
    L63:
        if (r130 >= r129) goto L71;
        com.obric.oui.constraintlayout.widget.a.C4670a r131 = r125.i(r214[r130].getId());
        com.obric.oui.constraintlayout.widget.a.C4670a r132 = this.f400234g;
        if (r132 == null) goto L70;
        com.obric.oui.constraintlayout.widget.a.C4670a.C4671a r133 = r132.f400493h;
        if (r133 == null) goto L69;
        r133.e(r131);
    L69:
        r131.f400492g.putAll(this.f400234g.f400492g);
    L70:
        r130 = r130 + 1;
        goto L63
    L71:
        r211.B(r212, r125);
        r211.B(com.larus.nova.R.id.view_transition, r213);
        r211.x(com.larus.nova.R.id.view_transition, -1, -1);
        q.b r134 = new q.b(r211.f399952q, r212);
        int r135 = r214.length;
    L72:
        if (r102 >= r135) goto L84;
        View r136 = r214[r102];
        int r137 = this.f400235h;
        if (r137 == (-1)) goto L76;
        r134.f400185h = Math.max(r137, 8);
    L76:
        r134.f400193p = this.f400231d;
        int r138 = this.f400239l;
        String r139 = this.f400240m;
        int r140 = this.f400241n;
        r134.f400182e = r138;
        r134.f400183f = r139;
        r134.f400184g = r140;
        int r141 = r136.getId();
        g r142 = this.f400233f;
        if (r142 == null) goto L83;
        ArrayList<d> r143 = r142.f400045a.get(-1);
        g r144 = new g();
        Iterator<d> r145 = r143.iterator();
    L80:
        if (r145.hasNext() == false) goto L82;
        d r146 = r145.next().b();
        r146.f400005b = r141;
        r144.b(r146);
        goto L80
    L82:
        r134.f400188k.add(r144);
    L83:
        r102 = r102 + 1;
        goto L72
    L84:
        r211.setTransition(r134);
        Runnable r147 = new u(this, r214);
        r211.l(1.0f);
        r211.T1 = r147;
    }
}
