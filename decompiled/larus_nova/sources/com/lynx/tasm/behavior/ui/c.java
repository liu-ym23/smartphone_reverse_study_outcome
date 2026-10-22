package com.lynx.tasm.behavior.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f382472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UIGroup f382473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<a> f382474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f382475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AccessibilityManager f382476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f382477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f382478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f382479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f382480i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LynxBaseUI f382481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f382482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Rect f382483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f382484d;

        public a(View r100, Rect r101) {
            this.f382481a = null;
            this.f382482b = r100;
            this.f382483c = r101;
        }

        public a(LynxBaseUI r100, Rect r101) {
            this.f382481a = r100;
            this.f382482b = null;
            this.f382483c = r101;
        }
    }

    public c(UIGroup r100) {
        this.f382474c = new ArrayList();
        this.f382478g = false;
        this.f382479h = true;
        this.f382480i = true;
        this.f382473b = r100;
        this.f382475d = r100.getRealParentView();
        this.f382476e = (AccessibilityManager) r100.mContext.getSystemService("accessibility");
        this.f382472a = r100.getLynxContext().getScreenMetrics().heightPixels / 50;
    }

    public static String c(LynxBaseUI r100) {
        CharSequence r101 = r100.getAccessibilityLabel();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return r101.toString();
    }

    public static Rect e(LynxBaseUI r100) {
        Rect r101 = new Rect();
        if ((r100 instanceof LynxUI) == false) goto L11;
        View r102 = ((LynxUI) r100).getView();
        if ((r100 instanceof UIShadowProxy) == false) goto L9;
        LynxBaseUI r103 = ((UIShadowProxy) r100).f382373a;
        if ((r103 instanceof LynxUI) == false) goto L9;
        r102 = ((LynxUI) r103).getView();
    L9:
        f(r102, r101);
        int r104 = r101.left;
        r101.set(r104, r101.top, r100.getWidth() + r104, r101.top + r100.getHeight());
    L22:
        return r101;
    L11:
        if ((r100 instanceof LynxFlattenUI) == false) goto L22;
        LynxBaseUI r105 = r100.getParentBaseUI();
    L13:
        if (r105 == null) goto L17;
        if ((r105 instanceof LynxUI) == true) goto L17;
        r105 = r105.getParentBaseUI();
    L17:
        if (r105 == null) goto L22;
        View r106 = ((LynxUI) r105).getView();
        if ((r105 instanceof UIGroup) == false) goto L21;
        r106 = ((UIGroup) r105).getRealParentView();
    L21:
        f(r106, r101);
        r101.offset(-r106.getScrollX(), -r106.getScrollY());
        r101.offset(r100.getLeft(), r100.getTop());
        int r107 = r101.left;
        r101.set(r107, r101.top, r100.getWidth() + r107, r101.top + r100.getHeight());
        goto L22
    }

    public final void b(View r100) {
        int r101 = 0;
        boolean r102 = true;
        if (r100.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r100.getImportantForAccessibility() != 1) goto L9;
    L14:
        if (r103 == false) goto L18;
        if (r102 == false) goto L18;
        Rect r104 = new Rect();
        f(r100, r104);
        this.f382474c.add(new a(r100, r104));
    L18:
        if ((r100 instanceof ViewGroup) == false) goto L23;
        ViewGroup r105 = (ViewGroup) r100;
    L21:
        if (r101 >= r105.getChildCount()) goto L25;
        b(r105.getChildAt(r101));
        r101 = r101 + 1;
        goto L21
    L25:
        return;
    L23:
        return;
    L9:
        if (r100.getImportantForAccessibility() != 2) goto L11;
    L13:
        r102 = false;
        goto L14
    L11:
        if (TextUtils.isEmpty(r100.getContentDescription()) == true) goto L13;
    L5:
        r103 = false;
        goto L7
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int r110) {
        LLog.i("LynxAccessibilityNodeProvider", "createAccessibilityNodeInfo: " + r110);
        int r100 = 0;
        if (r110 != (-1)) goto L42;
        AccessibilityNodeInfo r111 = AccessibilityNodeInfo.obtain(this.f382475d);
        this.f382474c.clear();
        a(this.f382473b, new ArrayList());
        Collections.sort(this.f382474c, new b(this));
        if (this.f382478g == false) goto L37;
        ArrayList r101 = new ArrayList();
        Iterator<a> r102 = this.f382474c.iterator();
    L8:
        if (r102.hasNext() == false) goto L36;
        a r103 = r102.next();
        LynxBaseUI r104 = r103.f382481a;
        if (r104 == null) goto L35;
        if (r103.f382484d == false) goto L35;
        ArrayList<String> r105 = r104.getAccessibilityElements();
        if (r105 == null) goto L8;
        if (this.f382473b.getLynxContext() == null) goto L8;
        if (this.f382473b.getLynxContext().getLynxUIOwner() == null) goto L8;
        LynxUIOwner r106 = this.f382473b.getLynxContext().getLynxUIOwner();
        Iterator<String> r107 = r105.iterator();
    L21:
        if (r107.hasNext() == false) goto L8;
        LynxBaseUI r108 = r106.findLynxUIByIdSelector(r107.next());
        if (r108 == null) goto L21;
        if ((r108 instanceof LynxUI) == false) goto L30;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r108).getView()) == false) goto L21;
    L30:
        if ((r108 instanceof UIShadowProxy) == false) goto L33;
        r108 = ((UIShadowProxy) r108).f382373a;
    L33:
        if (g(r108) == false) goto L21;
        r101.add(new a(r108, e(r108)));
    L35:
        r101.add(r103);
        goto L8
    L36:
        this.f382474c.clear();
        this.f382474c.addAll(r101);
        this.f382478g = false;
    L37:
        this.f382475d.onInitializeAccessibilityNodeInfo(r111);
    L39:
        if (r100 >= this.f382474c.size()) goto L41;
        r111.addChild(this.f382475d, r100);
        r100 = r100 + 1;
        goto L39
    L41:
        Rect r109 = new Rect();
        f(this.f382475d, r109);
        int r112 = r109.left;
        r109.set(r112, r109.top, this.f382473b.getWidth() + r112, r109.top + this.f382473b.getHeight());
        return r111;
    L42:
        if (r110 >= 0) goto L44;
        return null;
    L44:
        if (r110 >= this.f382474c.size()) goto L105;
        a r113 = (a) ListProtector.get(this.f382474c, r110);
        AccessibilityNodeInfo r114 = AccessibilityNodeInfo.obtain(this.f382475d, r110);
        this.f382475d.onInitializeAccessibilityNodeInfo(r114);
        LynxBaseUI r115 = r113.f382481a;
        if (r115 == null) goto L72;
        Rect r116 = e(r115);
        r113.f382483c = r116;
        r114.setBoundsInScreen(r116);
        r114.setClassName(r113.f382481a.getClass().getName());
        String r117 = d(r113.f382481a);
        r114.setContentDescription(r117);
        r114.setText(r117);
        r114.setScrollable(r113.f382481a.isScrollable());
        r114.setLongClickable(r113.f382481a.isLongClickable());
        r114.setFocusable(r113.f382481a.isFocusable());
        LynxBaseUI r118 = r113.f382481a;
        if (r118 == null) goto L57;
        Map<String, EventsListener> r119 = r118.mEvents;
        if (r119 == null) goto L57;
        if (r119.containsKey("click") == false) goto L55;
    L56:
        boolean r120 = true;
    L58:
        r114.setClickable(r120);
        LLog.i("LynxAccessibilityNodeProvider", "Label for UI: " + r110 + ", " + r117);
        if (r113.f382481a.getAccessibilityEnableTap() == false) goto L77;
        LynxBaseUI r121 = r113.f382481a;
        if (r121 == null) goto L69;
        Map<String, EventsListener> r122 = r121.mEvents;
        if (r122 == null) goto L69;
        if (r122.containsKey("click") == false) goto L67;
    L68:
        boolean r123 = true;
    L70:
        if (r123 == false) goto L77;
        r114.addAction(16);
        goto L77
    L67:
        if (r121.mEvents.containsKey("tap") == true) goto L68;
    L69:
        r123 = false;
    L77:
        r114.setParent(this.f382475d);
        r114.addAction(64);
        r114.setAccessibilityFocused(false);
        r114.setFocused(false);
        r114.addAction(4096);
        r114.addAction(8192);
        r114.setVisibleToUser(true);
        return r114;
    L55:
        if (r118.mEvents.containsKey("tap") == true) goto L56;
    L57:
        r120 = false;
        goto L58
    L72:
        View r124 = r113.f382482b;
        if (r124 == null) goto L77;
        if (ViewCompat.isAttachedToWindow(r124) == false) goto L77;
        r113.f382482b.onInitializeAccessibilityNodeInfo(r114);
        r114.setSource(this.f382475d, r110);
        goto L77
    L105:
        return null;
    }

    public final String d(LynxBaseUI r100) {
        if (g(r100) == true) goto L6;
        return "";
    L6:
        String r101 = c(r100);
        if (TextUtils.isEmpty(r101) == false) goto L13;
        Iterator<LynxBaseUI> r102 = r100.mChildren.iterator();
    L10:
        if (r102.hasNext() == false) goto L13;
        r101 = r101 + c(r102.next());
    L13:
        return r101.toString();
    }

    public final boolean g(LynxBaseUI r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getAccessibilityElementStatus() != (-1)) goto L10;
        return this.f382479h;
    L10:
        if (r100.getAccessibilityElementStatus() != 1) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean h(MotionEvent r100) {
        EventTarget r101 = this.f382473b.hitTest((int) r100.getX(), (int) r100.getY());
        LLog.i("LynxAccessibilityNodeProvider", "onHover with target = " + r101 + " event: [" + ((int) r100.getX()) + ", " + ((int) r100.getY()) + "]");
    L3:
        if (r101 == null) goto L8;
        if ((r101 instanceof LynxBaseUI) == true) goto L8;
        r101 = r101.parent();
    L8:
        if (r101 != null) goto L10;
    L45:
        return false;
    L10:
        if ((r101 instanceof LynxBaseUI) == false) goto L45;
        LynxBaseUI r102 = (LynxBaseUI) r101;
    L14:
        if (g(r102) == true) goto L18;
        r102 = r102.getParentBaseUI();
        if (r102 != null) goto L14;
        return false;
    L18:
        int r103 = this.f382474c.size() - 1;
    L19:
        if (r103 < 0) goto L24;
        if (((a) ListProtector.get(this.f382474c, r103)).f382481a == r102) goto L25;
        r103 = r103 - 1;
    L25:
        Rect r104 = new Rect();
        f(this.f382475d, r104);
        int r105 = ((int) r100.getX()) + r104.left;
        int r106 = ((int) r100.getY()) + r104.top;
        int r107 = this.f382474c.size() - 1;
    L26:
        if (r107 < r103) goto L32;
        if (r107 < 0) goto L32;
        if (((a) ListProtector.get(this.f382474c, r107)).f382483c.contains(r105, r106) == true) goto L30;
        r107 = r107 - 1;
        goto L26
    L30:
        r103 = r107;
    L32:
        if (r103 >= 0) goto L34;
        return false;
    L34:
        LLog.i("LynxAccessibilityNodeProvider", "onHover confirm virtualViewId = " + r103);
        int r108 = r100.getAction();
        if (r108 != 7) goto L37;
        i(r103, r100);
    L44:
        return true;
    L37:
        if (r108 != 9) goto L39;
        r100.setAction(9);
        i(r103, r100);
        goto L44
    L39:
        if (r108 != 10) goto L44;
        i(r103, r100);
        goto L44
    L24:
        r103 = -1;
        goto L25
    }

    public static void f(View r100, Rect r101) {
        r101.set(0, 0, r100.getRight() - r100.getLeft(), r100.getBottom() - r100.getTop());
        int[] r102 = new int[2];
        r100.getLocationOnScreen(r102);
        r101.offset(r102[0], r102[1]);
    }

    public final void a(LynxBaseUI r100, List<Rect> r101) {
        boolean r102 = true;
        if (r100.getAccessibilityElements() == null) goto L6;
        a r103 = new a(r100, e(r100));
        r103.f382484d = true;
        this.f382474c.add(r103);
        this.f382478g = true;
        return;
    L6:
        int r104 = r100.getChildren().size() - 1;
    L7:
        if (r104 < 0) goto L18;
        LynxBaseUI r105 = (LynxBaseUI) ListProtector.get(r100.getChildren(), r104);
        if ((r105 instanceof LynxUI) == false) goto L13;
        if (ViewCompat.isAttachedToWindow(((LynxUI) r105).getView()) == true) goto L13;
    L16:
        r104 = r104 - 1;
    L13:
        if ((r105 instanceof d) == true) goto L16;
        a(r105, r101);
        goto L16
    L18:
        if (r100 != this.f382473b) goto L20;
        return;
    L20:
        if ((r100 instanceof UIShadowProxy) == false) goto L22;
        r100 = ((UIShadowProxy) r100).f382373a;
    L22:
        int r106 = 0;
        if (g(r100) == false) goto L38;
        Rect r107 = e(r100);
        if (this.f382480i == true) goto L36;
        ArrayList r108 = (ArrayList) r101;
        Iterator r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L32;
        if (((Rect) r109.next()).contains(r107) == false) goto L28;
    L33:
        if (r102 == true) goto L35;
        this.f382474c.add(new a(r100, r107));
    L35:
        r108.add(r107);
        goto L38
    L32:
        r102 = false;
        goto L33
    L36:
        this.f382474c.add(new a(r100, r107));
    L38:
        if ((r100 instanceof LynxUI) == true) goto L40;
        return;
    L40:
        if (r100.mChildren.isEmpty() == false) goto L57;
        LynxUI r110 = (LynxUI) r100;
        if ((r110.getView() instanceof ViewGroup) == false) goto L58;
        ViewGroup r111 = (ViewGroup) r110.getView();
    L45:
        if (r106 >= r111.getChildCount()) goto L59;
        b(r111.getChildAt(r106));
        r106 = r106 + 1;
        goto L45
    L59:
        return;
    L58:
        return;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r100, int r101) {
        ArrayList r102 = new ArrayList();
        if (r100 != null) goto L5;
        return r102;
    L5:
        String r103 = r100.toLowerCase();
        if (r101 != (-1)) goto L18;
        int r104 = 0;
    L9:
        if (r104 >= this.f382474c.size()) goto L29;
        if (((a) ListProtector.get(this.f382474c, r104)).f382481a == null) goto L17;
        String r105 = c(((a) ListProtector.get(this.f382474c, r104)).f382481a);
        if (r105 == null) goto L17;
        if (r105.toString().toLowerCase().contains(r103) == false) goto L17;
        r102.add(createAccessibilityNodeInfo(r104));
    L17:
        r104 = r104 + 1;
    L29:
        return r102;
    L18:
        if (r101 <= 0) goto L29;
        if (r101 >= this.f382474c.size()) goto L29;
        LynxBaseUI r106 = ((a) ListProtector.get(this.f382474c, r101)).f382481a;
        if (r106 == null) goto L29;
        String r107 = c(r106);
        if (r107 == null) goto L29;
        if (r107.toString().toLowerCase().contains(r103) == false) goto L29;
        r102.add(createAccessibilityNodeInfo(r101));
        goto L29
    }

    public final void i(int r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (this.f382477f == true) goto L7;
        if (r102 == 9) goto L6;
        if (r102 == 7) goto L6;
    L10:
        if (r102 == 9) goto L14;
        if (r102 != 10) goto L17;
        this.f382475d.setHovered(false);
        return;
    L17:
        return;
    L14:
        this.f382475d.setHovered(true);
        return;
    L6:
        j(r100, 128);
        this.f382477f = true;
        goto L10
    L7:
        if (r102 == 10) goto L9;
        if (r102 != 7) goto L10;
    L9:
        this.f382477f = false;
        j(r100, 256);
        goto L10
    }

    public final void j(int r100, int r101) {
        if (this.f382476e.isTouchExplorationEnabled() == false) goto L18;
        AccessibilityEvent r102 = AccessibilityEvent.obtain(r101);
        if (r100 < 0) goto L19;
        a r103 = (a) ListProtector.get(this.f382474c, r100);
        if (r103.f382481a == null) goto L9;
        r102.setPackageName(this.f382475d.getContext().getPackageName());
        r102.setClassName(r103.f382481a.getClass().getName());
        r102.setEnabled(true);
        r102.setContentDescription(d(r103.f382481a));
    L12:
        r102.setSource(this.f382475d, r100);
        this.f382475d.invalidate();
        if (this.f382475d.getParent() != null) goto L16;
        LLog.e("LynxAccessibilityNodeProvider", "sendAccessibilityEventForLynxUI failed, parent is null.");
        return;
    L16:
        this.f382475d.getParent().requestSendAccessibilityEvent(this.f382475d, r102);
        return;
    L9:
        View r104 = r103.f382482b;
        if (r104 == null) goto L20;
        r104.onInitializeAccessibilityEvent(r102);
        goto L12
    L20:
        return;
    L19:
        return;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int r100, int r110, Bundle r111) {
        LLog.i("LynxAccessibilityNodeProvider", "performAction on virtualViewId " + r100 + " action " + r110);
        if (r100 != (-1)) goto L5;
        return false;
    L5:
        if (r100 >= 0) goto L7;
    L38:
        return false;
    L7:
        if (r100 >= this.f382474c.size()) goto L38;
        if (r110 != 16) goto L12;
        if (r100 < 0) goto L38;
        a r101 = (a) ListProtector.get(this.f382474c, r100);
        LynxBaseUI r112 = r101.f382481a;
        if (r112 == null) goto L38;
        if (r112.getLynxContext() == null) goto L38;
        if (r112.getLynxContext().getEventEmitter() == null) goto L38;
        if (r112.getAccessibilityEnableTap() == false) goto L38;
        Rect r102 = r101.f382483c;
        LynxTouchEvent.a r103 = new LynxTouchEvent.a(r102.centerX(), r102.centerY());
        LynxTouchEvent.a r104 = new LynxTouchEvent.a(r102.centerX() - r102.left, r102.centerY() - r102.top);
        Map<String, EventsListener> r105 = r112.mEvents;
        if (r105 != null) goto L32;
    L37:
        return true;
    L32:
        if (r105.containsKey("tap") == false) goto L35;
        r112.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r112.getSign(), "tap", r104, r104, r103));
        goto L37
    L35:
        if (r112.mEvents.containsKey("click") == false) goto L37;
        r112.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(r112.getSign(), "click", r104, r104, r103));
        goto L37
    L12:
        if (r110 != 64) goto L14;
        j(r100, 32768);
        j(r100, 4);
        return true;
    L14:
        if (r110 != 128) goto L38;
        j(r100, 65536);
        return true;
    }
}
