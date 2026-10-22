package com.bytedance.ee.bear.document.selection;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.plugin.selection.ContextMenuItem;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.suite.lark.emm.impl.SCClipboardProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class p<V extends View> implements View.OnTouchListener, zv4.a, ocb.a {
    public static final /* synthetic */ int L = 0;
    public final boolean A;
    public final boolean B;
    public com.bytedance.ee.bear.document.plugin.selection.d C;
    public final l D;
    public final com.bytedance.ee.bear.document.selection.d E;
    public boolean F;
    public final jdb.g G;
    public final boolean H;
    public final o I;
    public String J;
    public final b K;
    public z4 a;
    public float b;
    public GestureDetector c;
    public int d;
    public ActionMode e;
    public ActionMode.Callback f;
    public ActionMode.Callback g;
    public ValueAnimator h;
    public final List<ContextMenuItem> i;
    public final LinkedHashMap<String, String> j;
    public final LinkedHashMap<String, String> k;
    public final Rect l;
    public final com.bytedance.ee.bear.contract.d m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean s;
    public boolean t;
    public float u;
    public final int[] v;
    public final List<V> w;
    public boolean x;
    public boolean y;
    public boolean z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r3) {
            this.a.x = true;
            return super.onDoubleTap(r3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r6) {
            tt5.a.h("SelectionNewBase", "onLongPress");
            p r0 = this.a;
            r0.x = true;
            float r1 = r6.getX();
            float r7 = r6.getY();
            r0.l.setEmpty();
            r0.k.clear();
            String r2 = String.format(Locale.US, "javascript:window.lark.biz.selection.sheetLongPress", new Object[0]);
            JSONObject r3 = new JSONObject();
            r3.put("x", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r1)));
            r3.put("y", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r7)));
            r0.c(r2, r3, null);
            com.bytedance.ee.util.ui.j.e(r0.K);
            com.bytedance.ee.util.ui.j.d(r0.K, 100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r4) {
            tt5.a.h("SelectionNewBase", "onSingleTapUp");
            p r0 = this.a;
            if (r0.n == true) goto L8;
            if (r0.o == false) goto L8;
            tt5.a.h("SelectionNewBase", "onSingleTapUp onClearSelection");
            p r1 = this.a;
            r1.getClass();
            tt5.a.h("SelectionNewBase", "jsClearSelectionExcludeCursor");
            r1.c("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
            p r2 = this.a;
            r2.getClass();
            tt5.a.h("SelectionNewBase", "onClearSelection");
            r2.closeActionMode();
            r2.t();
            return false;
        L8:
            if (r0.l.isEmpty() == false) goto L10;
            return false;
        L10:
            if (this.a.y == true) goto L16;
            tt5.a.h("SelectionNewBase", "onSingleTapUp finishActionMode");
            this.a.g();
            return false;
        L16:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r3, MotionEvent r4, float r5, float r6) {
            p r0 = this.a;
            if (r0.e == null) goto L10;
            if (r0.B == false) goto L10;
            if (r0.A == false) goto L10;
            r0.j();
        L10:
            return super.onScroll(r3, r4, r5, r6);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ p a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("SelectionNewBase", "onLongPressRunnable");     // Catch: Throwable -> L4
            String r0 = String.format(Locale.US, "javascript:window.lark.biz.selection.onLongPress", new Object[0]);     // Catch: Throwable -> L4
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
            this.a.c(r0, r1, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(p r1) {
            this.a = r1;
        }
    }

    public class c {
        public final LinkedHashMap<String, String> a;
        public final com.bytedance.ee.bear.document.selection.c b;
        public final /* synthetic */ p c;

        public final boolean f() {
            ActionMode r0 = this.c.e;
            if (r0 != null) goto L5;
        L48:
            return false;
        L5:
            if (r0.getMenu() == null) goto L48;
            Menu r1 = this.c.e.getMenu();
            l r2 = this.c.D;
            LinkedHashMap<String, String> r3 = this.a;
            r2.getClass();
            if (l.b(r1, r3, true) == false) goto L47;
            p r4 = this.c;
            int r6 = 6767770;
            if (r4.H == false) goto L39;
            com.bytedance.ee.bear.document.selection.c r5 = this.b;
            boolean r7 = r4.F;
            r5.getClass();
            int r9 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            boolean r10 = SCClipboardProvider.a().L0();
            boolean r11 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).o();
            tt5.a.h(r5.c, "needAdd shouldMenuControlled: " + r10 + " fgExempt: " + r11 + " isExempt: " + r7);
            if (r11 == false) goto L17;
            if (r10 == true) goto L17;
            if (r7 == false) goto L17;
            boolean r8 = true;
        L18:
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed  ret: " + r8);
            r1.removeGroup(6767770);
            r1.removeGroup(6767771);
            if (this.a.containsKey("OPEN_LINK") == false) goto L21;
            r1.clear();
            r6 = 6767771;
        L21:
            Iterator<Map.Entry<String, String>> r12 = this.a.entrySet().iterator();
            int r13 = 0;
        L23:
            if (r12.hasNext() == false) goto L46;
            Map.Entry<String, String> r14 = r12.next();
            String r16 = r14.getKey();
            String r17 = r14.getValue();
            if (TextUtils.equals(r16, "SEARCH_WEB") == false) goto L29;
            if (r8 == false) goto L38;
            r1.add(r6, 0, r13, r17);
        L38:
            r13 = r13 + 1;
            goto L23
        L29:
            if (TextUtils.equals(r16, "SHARE") == false) goto L34;
            this.c.J = r17;
            if (r8 == false) goto L38;
            r1.add(r6, 0, r13, r17);
            goto L38
        L34:
            if (TextUtils.equals(r16, "LARK_SEARCH") == false) goto L37;
            if (r8 == false) goto L38;
            r1.add(r6, 0, r13, r17);
            goto L38
        L37:
            r1.add(r6, 0, r13, r17);
        L46:
            return true;
        L17:
            r8 = false;
            goto L18
        L39:
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed ");
            r1.removeGroup(6767770);
            r1.removeGroup(6767771);
            if (this.a.containsKey("OPEN_LINK") == false) goto L42;
            r1.clear();
            r6 = 6767771;
        L42:
            Iterator<String> r18 = this.a.values().iterator();
            int r19 = 0;
        L44:
            if (r18.hasNext() == false) goto L46;
            r1.add(r6, 0, r19, r18.next());
            r19 = r19 + 1;
            goto L44
        L47:
            tt5.a.h("SelectionNewBase", "need not update menu");
            goto L48
        }

        public c(p r3) {
            this.c = r3;
            this.a = new LinkedHashMap();
            this.b = new com.bytedance.ee.bear.document.selection.c(r3.a.getWebView(), "SelectionNewBase");
        }

        public final void c(ActionMode r3) {
            tt5.a.h("SelectionNewBase", "onDestroyActionMode actionMode " + this.c.e + " mode " + r3);
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L5;
            r0.onDestroyActionMode(r3);
        L5:
            ActionMode r1 = this.c.e;
            if (r1 == null) goto L9;
            if (r1 == r3) goto L9;
            r1.finish();
        L9:
            ((ArrayList) this.c.i).clear();
            this.a.clear();
            this.c.j.clear();
            this.c.e = null;
        }

        public final void e(LinkedHashMap<String, String> r4) {
            if (this.a.equals(r4) == false) goto L6;
            tt5.a.h("SelectionNewBase", "menu not change, return");
            return;
        L6:
            this.a.clear();
            this.a.putAll(r4);
            if (this.c.e == null) goto L9;
        L13:
            p r5 = this.c;
            ActionMode r0 = r5.e;
            if (r0 == null) goto L18;
            l r6 = r5.D;
            Menu r1 = r0.getMenu();
            LinkedHashMap<String, String> r2 = this.a;
            r6.getClass();
            boolean r7 = true;
            if (l.b(r1, r2, true) == false) goto L18;
        L19:
            tt5.a.h("SelectionNewBase", "updateMenuItems, actionMode = " + this.c.e + ", needInvalidate = " + r7);
            if (r7 == false) goto L23;
            this.c.e.invalidate();
            return;
        L23:
            return;
        L18:
            r7 = false;
            goto L19
        L9:
            if (com.larksuite.framework.utils.x.a() == true) goto L13;
            if (this.c.k() == false) goto L13;
            tt5.a.h("SelectionNewBase", "start action mode by hand");
            p r8 = this.c;
            r8.e = r8.a.getWebView().startActionMode(this.c.f);
            goto L13
        }

        public final boolean a(ActionMode r11, MenuItem r12) {
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L5;
            r0.onActionItemClicked(r11, r12);
        L5:
            boolean r1 = false;
            switch(r12.getGroupId()) {
                case 6767770: goto L11;
                case 6767771: goto L11;
                case 6767772: goto L9;
                default: goto L49;
            };
        L11:
            CharSequence r2 = r12.getTitle();
            Iterator<Map.Entry<String, String>> r3 = this.a.entrySet().iterator();
        L13:
            if (r3.hasNext() == false) goto L44;
            Map.Entry<String, String> r4 = r3.next();
            if (r2.equals(r4.getValue()) == false) goto L13;
            String r5 = r4.getKey();
            boolean r6 = "SELECT_ALL".equals(r5);
            p r7 = this.c;
            int r13 = r12.getGroupId();
            r7.getClass();
            tt5.a.h("SelectionNewBase", "jsOnActionModeMenuItemClick:" + r5);
            Iterator r8 = ((ArrayList) r7.i).iterator();
        L18:
            if (r8.hasNext() == false) goto L22;
            ContextMenuItem r9 = (ContextMenuItem) r8.next();
            if (r5.equals(r9.id) == false) goto L18;
        L23:
            String r10 = String.format(Locale.US, "javascript:window.lark.biz.navigation.onContextMenuClick", new Object[0]);
            JSONObject r14 = new JSONObject();
            r14.put("id", r5);
            if (r9 == null) goto L40;
            r14.put("text", r9.text);
            r14.put("data", r9.data);
            String r16 = r9.id;
            tt5.a.h("SelectionNewBase", "report id " + r16);
            if (r13 == 6767771) goto L28;
            HashMap r17 = new HashMap();
            r17.put("menu_id", r16);
            r17.put("enable_intent_menu_item", Boolean.valueOf(r7.t));
            r7.m.v("js_menu_item_clicked", r17);
            goto L40
        L28:
            if (r16.equals("OPEN_LINK") == false) goto L31;
            r7.o("openlink");
            goto L40
        L31:
            if (r16.equals("COPY_LINK") == false) goto L34;
            r7.o("copylink");
            goto L40
        L34:
            if (r16.equals("CUT_LINK") == false) goto L37;
            r7.o("cutlink");
            goto L40
        L37:
            if (r16.equals("COMMENT_LINK") == false) goto L40;
            r7.o("commentlink");
        L40:
            r7.c(r10, r14, null);
            com.bytedance.ee.bear.document.plugin.selection.d r18 = r7.C;
            if (r18 == null) goto L43;
            r18.a(r5);
        L43:
            boolean r19 = true;
            r1 = r6;
        L45:
            this.c.getClass();
            this.c.k.clear();
            this.c.l.setEmpty();
            if (r1 == false) goto L48;
            tt5.a.h("SelectionNewBase", "click item select all");
            final p r20 = this.c;
            com.bytedance.ee.util.ui.j.d(new r(r20), 200);
        L48:
            r1 = r19;
            goto L49
        L22:
            r9 = null;
            goto L23
        L44:
            r19 = false;
        L49:
            r11.finish();
            return r1;
        L9:
            if (this.c.t == false) goto L49;
            r1 = this.b.c(r12).booleanValue();
            this.c.m.v("intent_menu_item_clicked", new HashMap());
            goto L49
        }

        public final void b(ActionMode r4, Menu r5) {
            tt5.a.h("SelectionNewBase", "onCreateActionMode actionMode " + this.c.e + " mode " + r4);
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L5;
            r0.onCreateActionMode(r4, r5);
        L5:
            ActionMode r1 = this.c.e;
            if (r1 == null) goto L9;
            if (r1 == r4) goto L9;
            r1.finish();
        L9:
            r5.clear();
            p r2 = this.c;
            if (r2.H == false) goto L12;
        L16:
            this.c.e = r4;
            return;
        L12:
            if (r2.t == false) goto L16;
            if (r2.z == true) goto L16;
            this.b.d(r5, r2.m, r4, r2.F);
            goto L16
        }

        public final boolean d(ActionMode r4, Menu r5) {
            tt5.a.h("SelectionNewBase", "onPrepareActionMode jsAssignedMenuItems: " + this.c.k.size());
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L6;
            r0.onPrepareActionMode(r4, r5);
        L6:
            if (this.c.k.isEmpty() == true) goto L8;
            this.a.clear();
            this.a.putAll(this.c.k);
        L10:
            if (this.c.H == false) goto L15;
            if (f() == true) goto L19;
        L20:
            return false;
        L19:
            return true;
        L15:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == false) goto L18;
            com.bytedance.ee.bear.document.selection.c r1 = this.b;
            p r2 = this.c;
            r1.d(r5, r2.m, r4, r2.F);
        L18:
            if (f() == false) goto L20;
        L8:
            this.c.v();
            goto L10
        }
    }

    public interface d {
        boolean a();

        void b(LinkedHashMap<String, String> r1);

        ActionMode.Callback c(ActionMode.Callback r1);
    }

    public class e implements View.OnTouchListener {
        public final boolean a;
        public final /* synthetic */ p b;

        public e(p r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r11, MotionEvent r12) {
            int r13 = r12.getAction();
            if (r13 == 0) goto L9;
            if (r13 == 1) goto L8;
            if (r13 == 2) goto L9;
            if (r13 == 3) goto L8;
        L23:
            return false;
        L8:
            this.b.l();
        L9:
            p r14 = this.b;
            boolean r4 = this.a;
            r14.getClass();
            int r5 = r12.getAction();
            r14.a.getWebView().getLocationInWindow(r14.v);
            float r6 = r12.getRawY() - r14.v[1];
            float r16 = r12.getRawX();
            String r7 = String.format(Locale.US, "javascript:window.lark.biz.selection.SelectionHandlerTouchEvent", new Object[0]);
            JSONObject r8 = new JSONObject();
            if (r5 == 0) goto L17;
            if (r5 == 1) goto L16;
            if (r5 == 2) goto L15;
            if (r5 == 3) goto L16;
            String r1 = "";
        L18:
            r8.put("type", r1);
            if (r4 == false) goto L21;
            String r2 = BatterySceneData.OPT_START;
        L22:
            r8.put("target", r2);
            r8.put("clientX", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r16)));
            r8.put("clientY", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r6)));
            r14.c(r7, r8, null);
            goto L23
        L21:
            r2 = BatterySceneData.OPT_END;
            goto L22
        L15:
            r1 = "touchmove";
        L16:
            r1 = "touchend";
            goto L18
        L17:
            r1 = "touchstart";
            goto L18
        }
    }

    public abstract Pair<View, Boolean> d(ViewGroup r1);

    public abstract void f();

    public abstract UserPermissionEntity h(String r1);

    public abstract boolean i();

    public abstract void j();

    public abstract boolean k();

    public abstract boolean p();

    public abstract ActionMode r();

    public abstract void s();

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    @JavascriptInterface
    public void closeActionMode() {
        tt5.a.h("SelectionNewBase", "closeActionMode");
        g();
        this.k.clear();
        this.l.setEmpty();
    }

    public void e() {
        tt5.a.h("SelectionNewBase", "detach");
        com.bytedance.ee.util.ui.j.e(this.K);
        this.a.z(true);
        closeActionMode();
        t();
        s();
    }

    public final void g() {
        if (this.e == null) goto L6;
        tt5.a.h("SelectionNewBase", "finishActionMode");
        this.e.finish();
        this.e = null;
        return;
    }

    public Context getContext() {
        return this.a.getWebView().getContext();
    }

    public final void l() {
        tt5.a.h("SelectionNewBase", "onUpdatedSelection " + this.s + " actionMode " + this.e);
        this.r = 0;
        t();
        this.a.z(true);
        com.bytedance.ee.util.ui.j.e(this.I);
        com.bytedance.ee.util.ui.j.d(this.I, 100);
        if (this.e == null) goto L8;
        if (((d) this.f).a() == false) goto L8;
        tt5.a.h("SelectionNewBase", "onUpdatedSelection actionMode.invalidate actionMode " + this.e);
        this.e.invalidate();
    L8:
        if (this.s == false) goto L11;
        q();
        this.s = false;
        return;
    }

    public final void q() {
        if (this.G.isCurrentEnable("ccm.mobile.docx_selection_bugfix") == false) goto L10;
        ActionMode r0 = this.e;
        if (r0 != null) goto L7;
        this.e = r();
    L11:
        HashMap r1 = new HashMap();
        r1.put("enable_intent_menu_item", Boolean.valueOf(this.t));
        this.m.v("start_action_mode", r1);
        return;
    L7:
        r0.invalidate();
        if (Build.VERSION.SDK_INT < 23) goto L11;
        this.e.invalidateContentRect();
        goto L11
    L10:
        g();
        this.e = r();
        goto L11
    }

    public final void t() {
        ValueAnimator r0 = this.h;
        if (r0 == null) goto L6;
        r0.cancel();
        this.h = null;
        return;
    }

    public final List<ViewGroup> u() {
        ArrayList r1 = new ArrayList();
        WindowManager r3 = (WindowManager) getContext().getSystemService("window");     // Catch: Throwable -> L28
        Class r4 = a();     // Catch: Throwable -> L28
        Object r5 = r4.getMethod("getInstance", new Class[0]).invoke(null, null);     // Catch: Throwable -> L28
        Method r6 = r4.getMethod("getViewRootNames", new Class[0]);     // Catch: Throwable -> L28
        Method r7 = r4.getMethod("getRootView", new Class[]{String.class});     // Catch: Throwable -> L28
        String[] r8 = (String[]) r6.invoke(r5, null);     // Catch: Throwable -> L28
        if (r8 != null) goto L7;
        tt5.a.h("SelectionNewBase", "rootViewNames == null");     // Catch: Throwable -> L28
        return r1;
    L7:
        int r9 = r8.length;     // Catch: Throwable -> L28
        int r10 = 0;
    L8:
        float r11 = 0.0f;
        if (r10 >= r9) goto L22;
        String r12 = r8[r10];     // Catch: Throwable -> L28
        tt5.a.h("SelectionNewBase", "viewName " + r12);     // Catch: Throwable -> L28
        if (r12.startsWith("PopupWindow") == false) goto L21;
        View r13 = (View) r7.invoke(r5, new Object[]{r12});     // Catch: Throwable -> L28
        if ((r13 instanceof ViewGroup) == false) goto L21;
        Pair<View, Boolean> r14 = d((ViewGroup) r13);     // Catch: Throwable -> L28
        if (((Boolean) r14.second).booleanValue() == false) goto L21;
        View r16 = (View) r14.first;     // Catch: Throwable -> L28
        if (this.x == false) goto L20;
        r11 = 1.0f;
    L20:
        r16.setAlpha(r11);     // Catch: Throwable -> L28
        r1.add((ViewGroup) r13);     // Catch: Throwable -> L28
    L21:
        r10 = r10 + 1;     // Catch: Throwable -> L28
        goto L8
    L22:
        tt5.a.d("SelectionNewBase", "SelectionNewVH result " + r1.size());     // Catch: Throwable -> L28
        if (p() == true) goto L25;
    L30:
        return r1;
    L25:
        if (r1.size() != 1) goto L30;
        ((ViewGroup) ListProtector.get(r1, 0)).setVisibility(4);     // Catch: Throwable -> L28
        ((ViewGroup) ListProtector.get(r1, 0)).setAlpha(0.0f);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        tt5.a.e("SelectionNewBase", "SelectionNewVH tryFindPopupViews ", th, false);
        goto L30
    }

    public final void v() {
        tt5.a.h("SelectionNewBase", "jsGetActionModeMenu " + this.k);
        c("javascript:window.lark.biz.navigation.requestCustomContextMenu", null, new n(this));
    }

    static {
    }

    public void b(z4 r3) {
        this.a = r3;
        this.c = new GestureDetector(getContext(), new a(this));
    }

    public final void o(String r3) {
        HashMap r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r3);
        this.m.v("link_menu_item_clicked", r0);
    }

    @JavascriptInterface
    public void onSelectionChanged(boolean r5) {
        tt5.a.h("SelectionNewBase", "onSelectionChanged hasSelectionData: " + r5 + " mHasSelectionData " + this.n + " actionMode " + this.e);
        boolean r0 = i();
        StringBuilder r2 = new StringBuilder("onNewSelection intercept sys drag success?");
        r2.append(r0);
        tt5.a.h("SelectionNewBase", r2.toString());
        if (r0 == true) goto L5;
        tt5.a.k("SelectionNewBase", "Intercept drag handle touch fail !");
    L5:
        boolean r1 = this.n;
        if (r1 == true) goto L9;
        if (r5 == false) goto L9;
        this.s = false;
        v();
    L12:
        this.n = r5;
        this.o = true;
        if (r5 == true) goto L15;
    L17:
        if (r5 == false) goto L34;
        z4 r6 = this.a;
        if (r6 == null) goto L35;
        WebView.HitTestResult r7 = r6.getWebView().getHitTestResult();
        if (r7 == null) goto L36;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult type: " + r7.getType());
        if (r7.getExtra() == null) goto L25;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult getExtra: " + du5.b.g(r7.getExtra()));
    L27:
        if (r7.getType() != 7) goto L29;
    L32:
        tt5.a.h("SelectionNewBase", "callJsFunction getCursorBounds: ");
        c("javascript:window.lark.biz.selection.getCursorBounds", null, new m(this));
        return;
    L29:
        if (r7.getType() == 5) goto L32;
        if (r7.getType() == 8) goto L32;
        return;
    L25:
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult getExtra: null");
        goto L27
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L15:
        if (this.p == false) goto L17;
        this.q = true;
    L9:
        if (r1 == false) goto L12;
        if (r5 == true) goto L12;
        tt5.a.h("SelectionNewBase", "onClearSelection");
        closeActionMode();
        t();
        goto L12
    }

    @Override // zv4.a
    public final ActionMode.Callback prepareActionMode(ActionMode.Callback r2) {
        return ((d) this.f).c(r2);
    }

    @JavascriptInterface
    public void showActionMode(String r4) {
        tt5.a.h("SelectionNewBase", "showActionMode:" + r4);
        n(JSONObjectProtectorUtils.getJSONObject(new org.json.JSONObject(r4), "position"), this.l);     // Catch: Throwable -> L5
        m(r4, this.k);     // Catch: Throwable -> L5
        q();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("SelectionNewBase", "showActionMode exception ", th, false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.document.selection.o] */
    public p(com.bytedance.ee.bear.contract.d r5, DocumentPluginHost r6) {
        this.b = 0.87f;
        this.d = 0;
        this.i = new ArrayList();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.l = new Rect();
        this.t = false;
        this.u = 0.0f;
        this.v = new int[2];
        this.w = new ArrayList();
        new ArrayList();
        this.x = true;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.F = false;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.h("ccm.docx.mobile.new_action_menu_order");
        this.H = r1;
        this.I = new o(this);
        this.J = "";
        this.K = new b(this);
        this.G = ((dn4.a) r6.getUserComponent().a(dn4.a.class)).a();
        this.m = r5;
        this.D = new l();
        this.E = new com.bytedance.ee.bear.document.selection.d();
        this.A = r0.g("ccm.sheet.is_use_docx_in_sheet");
        DocViewModel r7 = r6.a();
        if (r7 == null) goto L5;
        this.B = TextUtils.equals(sbb.e.h.getType(), r7.getBearUrl().a);
    L5:
        tt5.a.h("SelectionNewBase", "mProcessTextFg: " + r1);
    }

    public final LinkedHashMap<String, String> m(String r21, LinkedHashMap<String, String> r22) {
        r22.clear();     // Catch: Throwable -> L36
        JSONObject r7 = JSON.parseObject(r21);     // Catch: Throwable -> L36
        if (r7 != null) goto L8;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r21);     // Catch: Throwable -> L36
        return r22;
    L8:
        ((ArrayList) this.i).clear();     // Catch: Throwable -> L36
        String r0 = r7.getString("srcObjToken");     // Catch: Exception -> L18 Throwable -> L36
        int r10 = r7.getIntValue("srcObjType");     // Catch: Exception -> L18 Throwable -> L36
        String r16 = r7.getString("content");     // Catch: Exception -> L18 Throwable -> L36
        if (((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(new UniBaseEntity(r0, sbb.e.d(r10), BizDomain.FileBizDomainCCM, null, null, null), "CONTENT_COPY"), h(r0)).getAllow() == false) goto L12;
    L15:
        boolean r1 = true;
    L16:
        this.F = r1;     // Catch: Exception -> L18 Throwable -> L36
    L20:
        JSONArray r2 = r7.getJSONArray("items");     // Catch: Throwable -> L36
        if (r2 != null) goto L24;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r21);     // Catch: Throwable -> L36
        return r22;
    L24:
        int r9 = 0;
    L26:
        if (r9 >= r2.size()) goto L37;
        ContextMenuItem r6 = new ContextMenuItem();     // Catch: Throwable -> L36
        JSONObject r8 = r2.getJSONObject(r9);     // Catch: Throwable -> L36
        r6.id = r8.getString("id");     // Catch: Throwable -> L36
        r6.text = r8.getString("text");     // Catch: Throwable -> L36
        if (r8.containsKey("data") == false) goto L31;
        r6.data = r8.getJSONObject("data");     // Catch: Throwable -> L36
    L31:
        if ("PASTE".equals(r6.id) == true) goto L33;
    L34:
        ((ArrayList) this.i).add(r6);     // Catch: Throwable -> L36
        r22.put(r6.id, r6.text);     // Catch: Throwable -> L36
    L35:
        r9 = r9 + 1;
        goto L26
    L33:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).f().booleanValue() == false) goto L35;
    L37:
        return r22;
    L12:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).w(r16) == false) goto L15;
        r1 = false;
    L18:
        e = move-exception;
        tt5.a.d("SelectionNewBase", "permission validate error " + e.getMessage());     // Catch: Throwable -> L36
    L36:
        tt5.a.k("SelectionNewBase", "parseMenus:" + r21);
        goto L37
    }

    public void n(org.json.JSONObject r6, Rect r7) throws JSONException {
        r7.set(com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, CustomHeaderConfig.TitleConfig.Position.LEFT)), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "top")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "right")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "bottom")));
        int r8 = r7.right;
        int r0 = r7.left;
        if ((r8 - r0) >= 10) goto L6;
        r7.right = r0 + 10;
        return;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r6, MotionEvent r7) {
        this.c.onTouchEvent(r7);
        int r8 = r7.getAction();
        if (r8 == 0) goto L37;
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L11;
        if (r8 == 3) goto L34;
    L38:
        return false;
    L11:
        if (this.q == false) goto L38;
        if ((r7.getRawY() - this.u) <= 0.0f) goto L38;
        float r9 = r7.getY();
        this.a.z(false);
        WebView r2 = this.a.getWebView();
        if (r2 == null) goto L29;
        l r3 = this.D;
        float r4 = this.b;
        r3.getClass();
        int r10 = l.a(r2, r9, 0.13f, r4);
        if (r10 != 0) goto L20;
    L25:
        t();
    L26:
        this.r = r10;
        if (this.h == null) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == false) goto L32;
        this.s = true;
    L32:
        this.u = r7.getRawY();
        goto L38
    L20:
        if (this.r == (-r10)) goto L25;
        if (this.h != null) goto L26;
        com.bytedance.ee.bear.document.selection.d.a r5 = new com.bytedance.ee.bear.document.selection.d.a(com.bytedance.ee.util.ui.n.d(4), r10, false);
        this.E.getClass();
        ValueAnimator r12 = com.bytedance.ee.bear.document.selection.d.a(r2, r5, null);
        this.h = r12;
        r12.addListener(new q(this));
        this.h.start();
    L29:
        r11 = false;
    L34:
        if (this.q == false) goto L36;
        l();
    L36:
        this.p = false;
        this.q = false;
        goto L38
    L37:
        t();
        this.p = true;
        this.q = false;
        this.u = r7.getRawY();
        goto L38
    }

    public final void c(String r2, JSONObject r3, ValueCallback<String> r4) {
        ap5.a.a(this.a.getWebView(), r2, r3, r4);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        this.d = r2;
    }
}
