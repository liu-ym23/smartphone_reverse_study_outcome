package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements b.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Rect f382454p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<UIBody> f382455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f382456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f382457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f382458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f382459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f382461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f382462h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AccessibilityManager f382463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f382464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f382465k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.c f382466l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LynxAccessibilityDelegate f382467m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LynxAccessibilityHelper f382468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f382469o;

    static {
        f382454p = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final boolean e() {
        if (this.f382456b == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f382457c == true) goto L9;
        if (this.f382467m == null) goto L9;
        return true;
    }

    public final boolean f() {
        if (this.f382456b == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f382457c == false) goto L9;
        if (this.f382468n == null) goto L9;
        return true;
    }

    public final UIBody h() {
        WeakReference<UIBody> r100 = this.f382455a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    public final boolean k() {
        if (this.f382463i != null) goto L5;
    L9:
        return false;
    L5:
        if (this.f382461g == false) goto L9;
        if (this.f382462h == false) goto L9;
        return true;
    }

    public final boolean m() {
        if (this.f382460f == true) goto L5;
    L11:
        return false;
    L5:
        if (k() == false) goto L11;
        if (e() == false) goto L9;
    L10:
        return true;
    L9:
        if (f() == false) goto L11;
        goto L10
    }

    public final void d() {
        if (k() == false) goto L5;
    L9:
        UIBody r100 = h();
        if (r100 != null) goto L12;
        return;
    L12:
        if (r100.getBodyView() != null) goto L14;
        return;
    L14:
        if (this.f382457c == true) goto L33;
        if (this.f382456b == true) goto L33;
        if (this.f382466l != null) goto L23;
        this.f382466l = new com.lynx.tasm.behavior.ui.c(r100);
        UIBody.UIBodyView r101 = r100.getBodyView();
        if (r101 == null) goto L23;
        r101.setAccessibilityDelegate(new c(this));
    L23:
        if (this.f382456b == false) goto L25;
    L29:
        boolean r102 = false;
    L30:
        if (r102 == false) goto L45;
        com.lynx.tasm.behavior.ui.c r103 = this.f382466l;
        r103.f382479h = this.f382458d;
        r103.f382480i = this.f382459e;
        return;
    L45:
        return;
    L25:
        if (this.f382457c == true) goto L29;
        if (this.f382466l == null) goto L29;
        r102 = true;
    L33:
        if (this.f382465k != null) goto L36;
        this.f382465k = new a();
    L36:
        if (this.f382457c == false) goto L39;
        j(r100, r100.getBodyView());
        return;
    L39:
        if (this.f382456b == false) goto L48;
        i(r100);
        return;
    L48:
        return;
    L5:
        if (this.f382456b == true) goto L7;
        return;
    L7:
        if (LynxEnv.inst().isPlatformObservabilityEnabled() == true) goto L9;
    }

    public d(UIBody r100) {
        this.f382455a = null;
        boolean r101 = false;
        this.f382456b = false;
        this.f382457c = false;
        this.f382458d = false;
        this.f382459e = false;
        this.f382460f = false;
        this.f382461g = false;
        this.f382462h = false;
        this.f382463i = null;
        this.f382464j = null;
        this.f382465k = null;
        this.f382466l = null;
        this.f382467m = null;
        this.f382468n = null;
        this.f382469o = false;
        if (r100 != null) goto L5;
    L24:
        LLog.e("LynxAccessibilityWrapper", "Construct LynxAccessibilityWrapper with null host");
        return;
    L5:
        if (r100.getBodyView() == null) goto L24;
        this.f382455a = new WeakReference(r100);
        LynxContext r102 = r100.getLynxContext();
        if (r102 == null) goto L16;
        if (r102.isEmbeddedModeOn() == false) goto L12;
    L13:
        r101 = true;
    L14:
        this.f382469o = r101;
        this.f382463i = (AccessibilityManager) r100.getLynxContext().getSystemService("accessibility");
        goto L16
    L12:
        if (LynxEnv.inst().enableLazyInitA11y() == false) goto L14;
    L16:
        if (this.f382469o == false) goto L18;
        this.f382464j = new b(this.f382463i, this);
        return;
    L18:
        LLog.i("LynxAccessibilityWrapper", "Construct LynxAccessibilityNodeProvider and set default delegate.");
        if (this.f382466l != null) goto L27;
        this.f382466l = new com.lynx.tasm.behavior.ui.c(r100);
        UIBody.UIBodyView r103 = r100.getBodyView();
        if (r103 == null) goto L28;
        r103.setAccessibilityDelegate(new c(this));
        return;
    L28:
        return;
    }

    public static void l(LynxBaseUI r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getLynxContext() == null) goto L8;
        JavaOnlyMap r101 = new JavaOnlyMap();
        r101.put("element-id", Integer.valueOf(r100.getSign()));
        r101.put("a11y-id", r100.getAccessibilityId());
        JavaOnlyArray r102 = new JavaOnlyArray();
        r102.pushMap(r101);
        r100.getLynxContext().sendGlobalEvent("activeElement", r102);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.accessibility.b.c
    public final void a(boolean r100) {
        this.f382462h = r100;
        if (this.f382469o == false) goto L6;
        d();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.accessibility.b.c
    public final void b(boolean r100) {
        this.f382461g = r100;
        if (this.f382469o == false) goto L6;
        d();
        return;
    }

    public final void i(UIBody r100) {
        LLog.i("LynxAccessibilityWrapper", "init LynxAccessibilityDelegate with " + this.f382456b + ", " + this.f382457c);
        if (this.f382467m != null) goto L5;
        this.f382467m = new LynxAccessibilityDelegate(r100);
    L5:
        this.f382467m.f382424f = this.f382458d;
        ViewCompat.setAccessibilityDelegate(r100.getBodyView(), this.f382467m);
    }

    public final void c(LynxBaseUI r100, boolean r101) {
        if (f() == true) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
        LynxAccessibilityHelper r102 = this.f382468n;
        r102.getClass();
        int r103 = r100.getSign();
        r102.f382430e.put(Integer.valueOf(r103), new WeakReference(r100));
        return;
    L7:
        LynxAccessibilityHelper r104 = this.f382468n;
        r104.getClass();
        int r105 = r100.getSign();
        HashMap<Integer, WeakReference<LynxBaseUI>> r106 = r104.f382430e;
        if (r106 != null) goto L10;
        return;
    L10:
        if (r106.get(Integer.valueOf(r105)) == null) goto L21;
        LynxBaseUI r107 = r104.f382430e.get(Integer.valueOf(r105)).get();
        if (r107 == null) goto L19;
        if (r107 != r100) goto L20;
        r104.f382430e.remove(Integer.valueOf(r105));
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void j(UIBody r100, UIBody.UIBodyView r101) {
        LLog.i("LynxAccessibilityWrapper", "init LynxAccessibilityHelper with " + this.f382456b + ", " + this.f382457c);
        if (this.f382468n != null) goto L5;
        this.f382468n = new LynxAccessibilityHelper(r100);
    L5:
        this.f382468n.f382427b = this.f382458d;
        ViewCompat.setImportantForAccessibility(r101, 2);
        ViewCompat.setAccessibilityDelegate(r101, null);
    }

    public static void g(LynxBaseUI r100, boolean r101, JavaOnlyArray r102) {
        if (r100 == null) goto L23;
        if (r101 == true) goto L5;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putInt("element-id", r100.getSign());
        r103.putString("a11y-id", r100.getAccessibilityId());
        r102.add(r103);
    L19:
        int r104 = 0;
    L21:
        if (r104 >= r100.getChildren().size()) goto L25;
        g((LynxBaseUI) ListProtector.get(r100.getChildren(), r104), r101, r102);
        r104 = r104 + 1;
        goto L21
    L25:
        return;
    L5:
        String r105 = "";
        if ((r100 instanceof UIText) == false) goto L13;
        CharSequence r106 = ((UIText) r100).getOriginText();
        if (r106 == null) goto L11;
        r105 = r106.toString();
    L11:
        r102.pushString(r105);
        goto L19
    L13:
        if ((r100 instanceof FlattenUIText) == false) goto L19;
        CharSequence r107 = ((FlattenUIText) r100).getOriginText();
        if (r107 == null) goto L18;
        r105 = r107.toString();
    L18:
        r102.pushString(r105);
        goto L19
    }
}
