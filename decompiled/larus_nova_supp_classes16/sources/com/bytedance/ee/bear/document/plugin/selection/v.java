package com.bytedance.ee.bear.document.plugin.selection;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
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
import android.view.animation.LinearInterpolator;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class v<V extends View> implements View.OnTouchListener, zv4.a, ocb.a {
    public static final /* synthetic */ int I = 0;
    public boolean A;
    public final jdb.g B;
    public long C;
    public final boolean D;
    public final s E;
    public final gm5.a F;
    public String G;
    public final b H;
    public ChameleonWebView a;
    public float b;
    public GestureDetector c;
    public int d;
    public ActionMode e;
    public ActionMode.Callback f;
    public ActionMode.Callback g;
    public ValueAnimator h;
    public final List<ContextMenuItem> i;
    public final LinkedHashMap<String, String> j;
    public final Rect k;
    public final com.bytedance.ee.bear.contract.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public float t;
    public final int[] u;
    public final List<V> v;
    public boolean w;
    public com.bytedance.ee.bear.document.plugin.selection.d x;
    public final r y;
    public final j z;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r3) {
            this.a.w = true;
            return super.onDoubleTap(r3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r6) {
            tt5.a.h("SelectionNewBase", "onLongPress");
            v r0 = this.a;
            r0.w = true;
            float r1 = r6.getX();
            float r7 = r6.getY();
            r0.k.setEmpty();
            r0.j.clear();
            String r2 = String.format(Locale.US, "javascript:window.lark.biz.selection.sheetLongPress", new Object[0]);
            JSONObject r3 = new JSONObject();
            r3.put("x", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r1)));
            r3.put("y", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r7)));
            r0.c(r2, r3, null);
            com.bytedance.ee.util.ui.j.e(r0.H);
            com.bytedance.ee.util.ui.j.d(r0.H, 100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r8) {
            tt5.a.h("SelectionNewBase", "onSingleTapUp");
            v r0 = this.a;
            if (r0.m == true) goto L8;
            if (r0.n == false) goto L8;
            tt5.a.h("SelectionNewBase", "onSingleTapUp onClearSelection");
            v r1 = this.a;
            r1.getClass();
            tt5.a.h("SelectionNewBase", "jsClearSelectionExcludeCursor");
            r1.c("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
            v r2 = this.a;
            r2.getClass();
            tt5.a.h("SelectionNewBase", "onClearSelection");
            r2.closeActionMode();
            r2.r();
        L19:
            return false;
        L8:
            if (r0.k.isEmpty() == true) goto L19;
            this.a.getClass();
            v r3 = this.a;
            if (r3.C > 0) goto L12;
        L14:
            boolean r4 = false;
        L15:
            if (r4 == false) goto L18;
            tt5.a.h("SelectionNewBase", "onSingleTapUp ignored after showActionMode");
            return false;
        L18:
            tt5.a.h("SelectionNewBase", "onSingleTapUp finishActionMode");
            this.a.g();
            goto L19
        L12:
            if ((SystemClock.uptimeMillis() - r3.C) >= 200) goto L14;
            r4 = true;
            goto L15
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ v a;

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

        public b(v r1) {
            this.a = r1;
        }
    }

    public class c {
        public final LinkedHashMap<String, String> a;
        public final i b;
        public final /* synthetic */ v c;

        public final boolean f() {
            ActionMode r0 = this.c.e;
            if (r0 != null) goto L5;
        L39:
            return false;
        L5:
            if (r0.getMenu() == null) goto L39;
            Menu r1 = this.c.e.getMenu();
            r r2 = this.c.y;
            LinkedHashMap<String, String> r3 = this.a;
            r2.getClass();
            if (r.a(r1, r3) == false) goto L38;
            int r5 = 6767770;
            if (this.c.D == false) goto L30;
            this.b.getClass();
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed  ret: true");
            r1.removeGroup(6767770);
            r1.removeGroup(6767771);
            if (this.a.containsKey("OPEN_LINK") == false) goto L14;
            r1.clear();
            r5 = 6767771;
        L14:
            Iterator<Map.Entry<String, String>> r4 = this.a.entrySet().iterator();
            int r6 = 0;
        L16:
            if (r4.hasNext() == false) goto L37;
            Map.Entry<String, String> r7 = r4.next();
            String r8 = r7.getKey();
            String r9 = r7.getValue();
            if (TextUtils.equals(r8, "SEARCH_WEB") == false) goto L21;
            r1.add(r5, 0, r6, r9);
        L27:
            r6 = r6 + 1;
            gm5.a r10 = this.c.F;
            if (r10 == null) goto L16;
            r10.getOnSelectionShowCallBack().invoke(r7.getKey().toLowerCase(Locale.ROOT));
            goto L16
        L21:
            if (TextUtils.equals(r8, "SHARE") == false) goto L24;
            this.c.G = r9;
            r1.add(r5, 0, r6, r9);
            goto L27
        L24:
            if (TextUtils.equals(r8, "LARK_SEARCH") == false) goto L26;
            r1.add(r5, 0, r6, r9);
            goto L27
        L26:
            r1.add(r5, 0, r6, r9);
        L37:
            return true;
        L30:
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed ");
            r1.removeGroup(6767770);
            r1.removeGroup(6767771);
            if (this.a.containsKey("OPEN_LINK") == false) goto L33;
            r1.clear();
            r5 = 6767771;
        L33:
            Iterator<String> r11 = this.a.values().iterator();
            int r12 = 0;
        L35:
            if (r11.hasNext() == false) goto L37;
            r1.add(r5, 0, r12, r11.next());
            r12 = r12 + 1;
            goto L35
        L38:
            tt5.a.h("SelectionNewBase", "need not update menu");
            goto L39
        }

        public c(v r2) {
            this.c = r2;
            this.a = new LinkedHashMap();
            this.b = new i(r2.a);
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
            this.c.e = null;
        }

        public final void e(LinkedHashMap<String, String> r5) {
            if (this.a.equals(r5) == false) goto L6;
            tt5.a.h("SelectionNewBase", "menu not change, return");
            return;
        L6:
            this.a.clear();
            this.a.putAll(r5);
            if (this.c.e == null) goto L9;
        L13:
            v r6 = this.c;
            ActionMode r0 = r6.e;
            if (r0 == null) goto L18;
            r r7 = r6.y;
            Menu r1 = r0.getMenu();
            LinkedHashMap<String, String> r2 = this.a;
            r7.getClass();
            if (r.a(r1, r2) == false) goto L18;
            boolean r8 = true;
        L19:
            tt5.a.h("SelectionNewBase", "updateMenuItems, actionMode = " + this.c.e + ", needInvalidate = " + r8);
            if (r8 == false) goto L23;
            this.c.e.invalidate();
            return;
        L23:
            return;
        L18:
            r8 = false;
            goto L19
        L9:
            if (com.larksuite.framework.utils.x.a() == true) goto L13;
            if (this.c.i() == false) goto L13;
            tt5.a.h("SelectionNewBase", "start action mode by hand");
            v r9 = this.c;
            r9.e = r9.a.u(r9.f, -1);
            goto L13
        }

        public final boolean a(ActionMode r12, MenuItem r13) {
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L5;
            r0.onActionItemClicked(r12, r13);
        L5:
            boolean r1 = true;
            boolean r3 = false;
            switch(r13.getGroupId()) {
                case 6767770: goto L22;
                case 6767771: goto L22;
                case 6767772: goto L9;
                default: goto L60;
            };
        L22:
            CharSequence r2 = r13.getTitle();
            Iterator<Map.Entry<String, String>> r4 = this.a.entrySet().iterator();
        L24:
            if (r4.hasNext() == false) goto L55;
            Map.Entry<String, String> r5 = r4.next();
            if (r2.equals(r5.getValue()) == false) goto L24;
            String r6 = r5.getKey();
            boolean r7 = "SELECT_ALL".equals(r6);
            v r8 = this.c;
            int r14 = r13.getGroupId();
            r8.getClass();
            tt5.a.h("SelectionNewBase", "jsOnActionModeMenuItemClick:" + r6);
            Iterator r9 = ((ArrayList) r8.i).iterator();
        L29:
            if (r9.hasNext() == false) goto L33;
            ContextMenuItem r10 = (ContextMenuItem) r9.next();
            if (r6.equals(r10.id) == false) goto L29;
        L34:
            String r11 = String.format(Locale.US, "javascript:window.lark.biz.navigation.onContextMenuClick", new Object[0]);
            JSONObject r16 = new JSONObject();
            r16.put("id", r6);
            if (r10 == null) goto L51;
            r16.put("text", r10.text);
            r16.put("data", r10.data);
            String r17 = r10.id;
            tt5.a.h("SelectionNewBase", "report id " + r17);
            if (r14 == 6767771) goto L39;
            HashMap r18 = new HashMap();
            r18.put("menu_id", r17);
            r18.put("enable_intent_menu_item", Boolean.valueOf(r8.s));
            r8.l.v("js_menu_item_clicked", r18);
            goto L51
        L39:
            if (r17.equals("OPEN_LINK") == false) goto L42;
            r8.m("openlink");
            goto L51
        L42:
            if (r17.equals("COPY_LINK") == false) goto L45;
            r8.m("copylink");
            goto L51
        L45:
            if (r17.equals("CUT_LINK") == false) goto L48;
            r8.m("cutlink");
            goto L51
        L48:
            if (r17.equals("COMMENT_LINK") == false) goto L51;
            r8.m("commentlink");
        L51:
            r8.c(r11, r16, null);
            com.bytedance.ee.bear.document.plugin.selection.d r19 = r8.x;
            if (r19 == null) goto L54;
            r19.a(r6);
        L54:
            r3 = r7;
        L56:
            this.c.getClass();
            this.c.j.clear();
            this.c.k.setEmpty();
            if (r3 == false) goto L59;
            tt5.a.h("SelectionNewBase", "click item select all");
            final v r110 = this.c;
            com.bytedance.ee.util.ui.j.d(new x(r110), 200);
        L59:
            r3 = r1;
            goto L60
        L33:
            r10 = null;
            goto L34
        L55:
            r1 = false;
        L60:
            r12.finish();
            return r3;
        L9:
            if (this.c.s == false) goto L60;
            i r20 = this.b;
            tt5.a.b(r20.c, "jsClearSelectionExcludeCursor");
            ap5.a.a(r20.a, "javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
            Intent r111 = r20.e.get(r13);
            if (r111 != null) goto L62;
        L20:
            r1 = false;
        L21:
            r3 = Boolean.valueOf(r1).booleanValue();
            this.c.l.v("intent_menu_item_clicked", new HashMap());
            goto L60
        L62:
        L18:
            e = move-exception;
            iu5.d.a("ProcessTextIntentItemManager", e);
            goto L20
        L13:
            if (r111.getAction().equals("android.intent.action.WEB_SEARCH") == false) goto L15;
            String r21 = "query";
        L16:
            r111.putExtra(r21, r20.g);     // Catch: SecurityException -> L18
            r20.a.getContext().startActivity(r111);     // Catch: SecurityException -> L18
            goto L21
        L15:
            r21 = "android.intent.extra.PROCESS_TEXT";
            goto L16
        }

        public final void b(ActionMode r9, Menu r10) {
            tt5.a.h("SelectionNewBase", "onCreateActionMode actionMode " + this.c.e + " mode " + r9);
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L5;
            r0.onCreateActionMode(r9, r10);
        L5:
            ActionMode r1 = this.c.e;
            if (r1 == null) goto L9;
            if (r1 == r9) goto L9;
            r1.finish();
        L9:
            r10.clear();
            v r2 = this.c;
            if (r2.D == false) goto L12;
        L17:
            this.c.e = r9;
            return;
        L12:
            if (r2.s == false) goto L17;
            i r3 = this.b;
            com.bytedance.ee.bear.contract.d r7 = r2.l;
            boolean r5 = r2.A;
            if (r9 != null) goto L16;
            r3.getClass();
            goto L17
        L16:
            r3.a.evaluateJavascript("(function(){return window.getSelection().toString()})()", new h(r3, r10, r5, r9, r7));
            goto L17
        }

        public final boolean d(ActionMode r9, Menu r10) {
            tt5.a.h("SelectionNewBase", "onPrepareActionMode jsAssignedMenuItems: " + this.c.j.size());
            ActionMode.Callback r0 = this.c.g;
            if (r0 == null) goto L6;
            r0.onPrepareActionMode(r9, r10);
        L6:
            if (this.c.j.isEmpty() == true) goto L8;
            this.a.clear();
            this.a.putAll(this.c.j);
        L10:
            if (this.c.D == false) goto L15;
            if (f() == true) goto L22;
        L23:
            return false;
        L22:
            return true;
        L15:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == false) goto L21;
            i r2 = this.b;
            v r1 = this.c;
            com.bytedance.ee.bear.contract.d r6 = r1.l;
            boolean r4 = r1.A;
            if (r9 != null) goto L19;
            r2.getClass();
            goto L21
        L19:
            r2.a.evaluateJavascript("(function(){return window.getSelection().toString()})()", new h(r2, r10, r4, r9, r6));
        L21:
            if (f() == false) goto L23;
        L8:
            this.c.t();
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
        public final /* synthetic */ v b;

        public e(v r1, boolean r2) {
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
            this.b.j();
        L9:
            v r14 = this.b;
            boolean r4 = this.a;
            r14.getClass();
            int r5 = r12.getAction();
            r14.a.getLocationInWindow(r14.u);
            float r6 = r12.getRawY() - r14.u[1];
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

    public abstract boolean h();

    public abstract boolean i();

    public abstract boolean n();

    public abstract ActionMode p();

    public abstract void q();

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
        this.j.clear();
        this.k.setEmpty();
    }

    public void e() {
        tt5.a.h("SelectionNewBase", "detach");
        com.bytedance.ee.util.ui.j.e(this.H);
        this.a.setEnableOverScrollBy(true);
        closeActionMode();
        r();
        q();
    }

    public final void g() {
        if (this.e == null) goto L6;
        tt5.a.h("SelectionNewBase", "finishActionMode");
        this.e.finish();
        this.e = null;
        return;
    }

    public Context getContext() {
        return this.a.getContext();
    }

    public final void j() {
        tt5.a.h("SelectionNewBase", "onUpdatedSelection " + this.r + " actionMode " + this.e);
        this.q = 0;
        r();
        this.a.setEnableOverScrollBy(true);
        com.bytedance.ee.util.ui.j.e(this.E);
        com.bytedance.ee.util.ui.j.d(this.E, 100);
        if (this.e == null) goto L8;
        if (((d) this.f).a() == false) goto L8;
        tt5.a.h("SelectionNewBase", "onUpdatedSelection actionMode.invalidate actionMode " + this.e);
        this.e.invalidate();
    L8:
        if (this.r == false) goto L11;
        o();
        this.r = false;
        return;
    }

    public final void o() {
        if (this.B.isCurrentEnable("ccm.mobile.docx_selection_bugfix") == false) goto L10;
        ActionMode r0 = this.e;
        if (r0 != null) goto L7;
        this.e = p();
    L11:
        HashMap r1 = new HashMap();
        r1.put("enable_intent_menu_item", Boolean.valueOf(this.s));
        this.l.v("start_action_mode", r1);
        return;
    L7:
        r0.invalidate();
        if (Build.VERSION.SDK_INT < 23) goto L11;
        this.e.invalidateContentRect();
        goto L11
    L10:
        g();
        this.e = p();
        goto L11
    }

    public final void r() {
        ValueAnimator r0 = this.h;
        if (r0 == null) goto L6;
        r0.cancel();
        this.h = null;
        return;
    }

    public final List<ViewGroup> s() {
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
        if (this.w == false) goto L20;
        r11 = 1.0f;
    L20:
        r16.setAlpha(r11);     // Catch: Throwable -> L28
        r1.add((ViewGroup) r13);     // Catch: Throwable -> L28
    L21:
        r10 = r10 + 1;     // Catch: Throwable -> L28
        goto L8
    L22:
        tt5.a.d("SelectionNewBase", "SelectionNewVH result " + r1.size());     // Catch: Throwable -> L28
        if (n() == true) goto L25;
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

    public final void t() {
        tt5.a.h("SelectionNewBase", "jsGetActionModeMenu " + this.j);
        c("javascript:window.lark.biz.navigation.requestCustomContextMenu", null, new u(this));
    }

    static {
    }

    public void b(ChameleonWebView r3) {
        this.a = r3;
        this.c = new GestureDetector(getContext(), new a(this));
    }

    public final void m(String r3) {
        HashMap r0 = new HashMap();
        r0.put(JSEventListener.ACTION, r3);
        this.l.v("link_menu_item_clicked", r0);
    }

    @JavascriptInterface
    public void onSelectionChanged(boolean r5) {
        tt5.a.h("SelectionNewBase", "onSelectionChanged hasSelectionData: " + r5 + " mHasSelectionData " + this.m + " actionMode " + this.e);
        boolean r0 = h();
        StringBuilder r2 = new StringBuilder("onNewSelection intercept sys drag success?");
        r2.append(r0);
        tt5.a.h("SelectionNewBase", r2.toString());
        if (r0 == true) goto L5;
        tt5.a.k("SelectionNewBase", "Intercept drag handle touch fail !");
    L5:
        boolean r1 = this.m;
        if (r1 == true) goto L9;
        if (r5 == false) goto L9;
        this.r = false;
        t();
    L12:
        this.m = r5;
        this.n = true;
        if (r5 == true) goto L15;
    L17:
        if (r5 == false) goto L34;
        ChameleonWebView r6 = this.a;
        if (r6 == null) goto L35;
        WebView.HitTestResult r7 = r6.getHitTestResult();
        if (r7 == null) goto L36;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult type: " + r7.getType());
        if (r7.getExtra() == null) goto L25;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult getExtra: " + du5.b.g(r7.getExtra()));
    L27:
        if (r7.getType() != 7) goto L29;
    L32:
        tt5.a.h("SelectionNewBase", "callJsFunction getCursorBounds: ");
        c("javascript:window.lark.biz.selection.getCursorBounds", null, new t(this));
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
        if (this.o == false) goto L17;
        this.p = true;
    L9:
        if (r1 == false) goto L12;
        if (r5 == true) goto L12;
        tt5.a.h("SelectionNewBase", "onClearSelection");
        closeActionMode();
        r();
        goto L12
    }

    @Override // zv4.a
    public final ActionMode.Callback prepareActionMode(ActionMode.Callback r2) {
        return ((d) this.f).c(r2);
    }

    @JavascriptInterface
    public void showActionMode(String r5) {
        tt5.a.h("SelectionNewBase", "showActionMode:" + r5);
        l(JSONObjectProtectorUtils.getJSONObject(new org.json.JSONObject(r5), "position"), this.k);     // Catch: Throwable -> L5
        k(r5, this.j);     // Catch: Throwable -> L5
        this.C = SystemClock.uptimeMillis();     // Catch: Throwable -> L5
        o();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("SelectionNewBase", "showActionMode exception ", th, false);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.bytedance.ee.bear.document.plugin.selection.s] */
    public v(com.bytedance.ee.bear.contract.d r4, ChameleonPluginHost r5) {
        this.b = 0.87f;
        this.d = 0;
        this.i = new ArrayList();
        this.j = new LinkedHashMap();
        this.k = new Rect();
        this.s = false;
        this.t = 0.0f;
        this.u = new int[2];
        this.v = new ArrayList();
        new ArrayList();
        this.w = true;
        this.A = false;
        this.C = 0;
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.docx.mobile.new_action_menu_order");
        this.D = r0;
        this.E = new s(this);
        this.G = "";
        this.H = new b(this);
        this.B = ((dn4.a) r5.getUserComponent().a(dn4.a.class)).a();
        this.F = (gm5.a) r5.getUserComponent().a(gm5.a.class);
        this.l = r4;
        this.y = new r();
        this.z = new j();
        y3 r6 = ((e4) r5.getHostAbility(e4.class)).getDocumentMetadata();
        if (r6 == null) goto L5;
        TextUtils.equals(sbb.e.h.getType(), r6.getBearUrl().a);
    L5:
        tt5.a.h("SelectionNewBase", "mProcessTextFg: " + r0);
    }

    public final LinkedHashMap<String, String> k(String r8, LinkedHashMap<String, String> r9) {
        r9.clear();     // Catch: Throwable -> L29
        JSONObject r3 = JSON.parseObject(r8);     // Catch: Throwable -> L29
        if (r3 != null) goto L8;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r8);     // Catch: Throwable -> L29
        return r9;
    L8:
        ((ArrayList) this.i).clear();     // Catch: Throwable -> L29
        r3.getString("srcObjToken");     // Catch: Exception -> L11 Throwable -> L29
        r3.getIntValue("srcObjType");     // Catch: Exception -> L11 Throwable -> L29
        r3.getString("content");     // Catch: Exception -> L11 Throwable -> L29
        this.A = true;     // Catch: Exception -> L11 Throwable -> L29
    L13:
        JSONArray r2 = r3.getJSONArray("items");     // Catch: Throwable -> L29
        if (r2 != null) goto L17;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r8);     // Catch: Throwable -> L29
        return r9;
    L17:
        int r4 = 0;
    L19:
        if (r4 >= r2.size()) goto L30;
        ContextMenuItem r5 = new ContextMenuItem();     // Catch: Throwable -> L29
        JSONObject r6 = r2.getJSONObject(r4);     // Catch: Throwable -> L29
        r5.id = r6.getString("id");     // Catch: Throwable -> L29
        r5.text = r6.getString("text");     // Catch: Throwable -> L29
        if (r6.containsKey("data") == false) goto L24;
        r5.data = r6.getJSONObject("data");     // Catch: Throwable -> L29
    L24:
        if ("PASTE".equals(r5.id) == true) goto L26;
    L27:
        ((ArrayList) this.i).add(r5);     // Catch: Throwable -> L29
        r9.put(r5.id, r5.text);     // Catch: Throwable -> L29
    L28:
        r4 = r4 + 1;
        goto L19
    L26:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).f().booleanValue() == false) goto L28;
    L30:
        return r9;
    L11:
        e = move-exception;
        tt5.a.d("SelectionNewBase", "permission validate error " + e.getMessage());     // Catch: Throwable -> L29
    L29:
        tt5.a.k("SelectionNewBase", "parseMenus:" + r8);
        goto L30
    }

    public final void l(org.json.JSONObject r6, Rect r7) throws JSONException {
        r7.set(com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, CustomHeaderConfig.TitleConfig.Position.LEFT)), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "top")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "right")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "bottom")));
        int r8 = r7.right;
        int r0 = r7.left;
        if ((r8 - r0) >= 10) goto L6;
        r7.right = r0 + 10;
        return;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r9, MotionEvent r10) {
        this.c.onTouchEvent(r10);
        int r11 = r10.getAction();
        if (r11 == 0) goto L47;
        if (r11 == 1) goto L44;
        if (r11 == 2) goto L11;
        if (r11 == 3) goto L44;
    L48:
        return false;
    L11:
        if (this.p == false) goto L48;
        if ((r10.getRawY() - this.t) <= 0.0f) goto L48;
        float r12 = r10.getY();
        this.a.setEnableOverScrollBy(false);
        ChameleonWebView r3 = this.a;
        if (r3 == null) goto L39;
        r r4 = this.y;
        float r5 = this.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "webView");
        float r6 = r3.getHeight();
        if (r12 >= (0.13f * r6)) goto L23;
        int r13 = -1;
        if (r3.canScrollVertically(-1) == true) goto L28;
    L27:
        r13 = 0;
    L28:
        if (r13 != 0) goto L30;
    L35:
        r();
    L36:
        this.q = r13;
        if (this.h == null) goto L39;
        boolean r14 = true;
    L40:
        if (r14 == false) goto L42;
        this.r = true;
    L42:
        this.t = r10.getRawY();
        goto L48
    L30:
        if (this.q == (-r13)) goto L35;
        if (this.h != null) goto L36;
        j.a r7 = new j.a(com.bytedance.ee.util.ui.n.d(4), r13);
        this.z.getClass();
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r7, "params");
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.setDuration(Long.MAX_VALUE);
        r2.setInterpolator(new LinearInterpolator());
        r2.addUpdateListener(new k(r7, r3));
        Intrinsics.checkNotNull(r2);
        this.h = r2;
        r2.addListener(new w(this));
        this.h.start();
        goto L36
    L23:
        if (r12 <= (r6 * r5)) goto L27;
        if (r3.canScrollVertically(1) == false) goto L27;
        r13 = 1;
    L39:
        r14 = false;
    L44:
        if (this.p == false) goto L46;
        j();
    L46:
        this.o = false;
        this.p = false;
        goto L48
    L47:
        r();
        this.o = true;
        this.p = false;
        this.t = r10.getRawY();
        goto L48
    }

    public final void c(String r2, JSONObject r3, ValueCallback<String> r4) {
        ap5.a.a(this.a, r2, r3, r4);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        this.d = r2;
    }
}
