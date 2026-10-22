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
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
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
import com.lynx.tasm.event.LynxTouchEvent;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f221672J;
    public final b K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z4 f221673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f221674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GestureDetector f221675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f221676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionMode f221677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActionMode.Callback f221678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActionMode.Callback f221679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f221680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ContextMenuItem> f221681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, String> f221682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, String> f221683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f221684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f221685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f221686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f221687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f221688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f221689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f221690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f221691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f221692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f221693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f221694v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<V> f221695w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f221696x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f221697y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f221698z;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f221699a;

        public a(p r100) {
            this.f221699a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            this.f221699a.f221696x = true;
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            tt5.a.h("SelectionNewBase", "onLongPress");
            p r101 = this.f221699a;
            r101.f221696x = true;
            float r102 = r100.getX();
            float r103 = r100.getY();
            r101.f221684l.setEmpty();
            r101.f221683k.clear();
            String r104 = String.format(Locale.US, "javascript:window.lark.biz.selection.sheetLongPress", new Object[0]);
            JSONObject r105 = new JSONObject();
            r105.put2("x", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r102)));
            r105.put2("y", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r103)));
            r101.c(r104, r105, null);
            com.bytedance.ee.util.ui.j.e(r101.K);
            com.bytedance.ee.util.ui.j.d(r101.K, 100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            tt5.a.h("SelectionNewBase", "onSingleTapUp");
            p r101 = this.f221699a;
            if (r101.f221686n == true) goto L8;
            if (r101.f221687o == false) goto L8;
            tt5.a.h("SelectionNewBase", "onSingleTapUp onClearSelection");
            p r102 = this.f221699a;
            r102.getClass();
            tt5.a.h("SelectionNewBase", "jsClearSelectionExcludeCursor");
            r102.c("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
            p r103 = this.f221699a;
            r103.getClass();
            tt5.a.h("SelectionNewBase", "onClearSelection");
            r103.closeActionMode();
            r103.t();
            return false;
        L8:
            if (r101.f221684l.isEmpty() == false) goto L10;
            return false;
        L10:
            if (this.f221699a.f221697y == true) goto L16;
            tt5.a.h("SelectionNewBase", "onSingleTapUp finishActionMode");
            this.f221699a.g();
            return false;
        L16:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            p r104 = this.f221699a;
            if (r104.f221677e == null) goto L10;
            if (r104.B == false) goto L10;
            if (r104.A == false) goto L10;
            r104.j();
        L10:
            return super.onScroll(r100, r101, r102, r103);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f221700a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("SelectionNewBase", "onLongPressRunnable");     // Catch: Throwable -> L4
            String r100 = String.format(Locale.US, "javascript:window.lark.biz.selection.onLongPress", new Object[0]);     // Catch: Throwable -> L4
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
            this.f221700a.c(r100, r101, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(p r100) {
            this.f221700a = r100;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f221701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.ee.bear.document.selection.c f221702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p f221703c;

        public final boolean f() {
            ActionMode r100 = this.f221703c.f221677e;
            if (r100 != null) goto L5;
        L48:
            return false;
        L5:
            if (r100.getMenu() == null) goto L48;
            Menu r101 = this.f221703c.f221677e.getMenu();
            l r102 = this.f221703c.D;
            LinkedHashMap<String, String> r103 = this.f221701a;
            r102.getClass();
            if (l.b(r101, r103, true) == false) goto L47;
            p r104 = this.f221703c;
            int r105 = 6767770;
            if (r104.H == false) goto L39;
            com.bytedance.ee.bear.document.selection.c r106 = this.f221702b;
            boolean r107 = r104.F;
            r106.getClass();
            int r108 = com.suite.lark.emm.impl.a.f460436a;
            com.suite.lark.emm.impl.a.C5524a.a().getClass();
            boolean r109 = SCClipboardProvider.a().L0();
            boolean r110 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).o();
            tt5.a.h(r106.f221590c, "needAdd shouldMenuControlled: " + r109 + " fgExempt: " + r110 + " isExempt: " + r107);
            if (r110 == false) goto L17;
            if (r109 == true) goto L17;
            if (r107 == false) goto L17;
            boolean r111 = true;
        L18:
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed  ret: " + r111);
            r101.removeGroup(6767770);
            r101.removeGroup(6767771);
            if (this.f221701a.containsKey("OPEN_LINK") == false) goto L21;
            r101.clear();
            r105 = 6767771;
        L21:
            Iterator<Map.Entry<String, String>> r112 = this.f221701a.entrySet().iterator();
            int r113 = 0;
        L23:
            if (r112.hasNext() == false) goto L46;
            Map.Entry<String, String> r114 = r112.next();
            String r115 = r114.getKey();
            String r116 = r114.getValue();
            if (TextUtils.equals(r115, "SEARCH_WEB") == false) goto L29;
            if (r111 == false) goto L38;
            r101.add(r105, 0, r113, r116);
        L38:
            r113 = r113 + 1;
            goto L23
        L29:
            if (TextUtils.equals(r115, "SHARE") == false) goto L34;
            this.f221703c.f221672J = r116;
            if (r111 == false) goto L38;
            r101.add(r105, 0, r113, r116);
            goto L38
        L34:
            if (TextUtils.equals(r115, "LARK_SEARCH") == false) goto L37;
            if (r111 == false) goto L38;
            r101.add(r105, 0, r113, r116);
            goto L38
        L37:
            r101.add(r105, 0, r113, r116);
        L46:
            return true;
        L17:
            r111 = false;
            goto L18
        L39:
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed ");
            r101.removeGroup(6767770);
            r101.removeGroup(6767771);
            if (this.f221701a.containsKey("OPEN_LINK") == false) goto L42;
            r101.clear();
            r105 = 6767771;
        L42:
            Iterator<String> r117 = this.f221701a.values().iterator();
            int r118 = 0;
        L44:
            if (r117.hasNext() == false) goto L46;
            r101.add(r105, 0, r118, r117.next());
            r118 = r118 + 1;
            goto L44
        L47:
            tt5.a.h("SelectionNewBase", "need not update menu");
            goto L48
        }

        public c(p r100) {
            this.f221703c = r100;
            this.f221701a = new LinkedHashMap();
            this.f221702b = new com.bytedance.ee.bear.document.selection.c(r100.f221673a.getWebView(), "SelectionNewBase");
        }

        public final void c(ActionMode r100) {
            tt5.a.h("SelectionNewBase", "onDestroyActionMode actionMode " + this.f221703c.f221677e + " mode " + r100);
            ActionMode.Callback r101 = this.f221703c.f221679g;
            if (r101 == null) goto L5;
            r101.onDestroyActionMode(r100);
        L5:
            ActionMode r102 = this.f221703c.f221677e;
            if (r102 == null) goto L9;
            if (r102 == r100) goto L9;
            r102.finish();
        L9:
            ((ArrayList) this.f221703c.f221681i).clear();
            this.f221701a.clear();
            this.f221703c.f221682j.clear();
            this.f221703c.f221677e = null;
        }

        public final void e(LinkedHashMap<String, String> r100) {
            if (this.f221701a.equals(r100) == false) goto L6;
            tt5.a.h("SelectionNewBase", "menu not change, return");
            return;
        L6:
            this.f221701a.clear();
            this.f221701a.putAll(r100);
            if (this.f221703c.f221677e == null) goto L9;
        L13:
            p r101 = this.f221703c;
            ActionMode r102 = r101.f221677e;
            if (r102 == null) goto L18;
            l r103 = r101.D;
            Menu r104 = r102.getMenu();
            LinkedHashMap<String, String> r105 = this.f221701a;
            r103.getClass();
            boolean r106 = true;
            if (l.b(r104, r105, true) == false) goto L18;
        L19:
            tt5.a.h("SelectionNewBase", "updateMenuItems, actionMode = " + this.f221703c.f221677e + ", needInvalidate = " + r106);
            if (r106 == false) goto L23;
            this.f221703c.f221677e.invalidate();
            return;
        L23:
            return;
        L18:
            r106 = false;
            goto L19
        L9:
            if (com.larksuite.framework.utils.x.a() == true) goto L13;
            if (this.f221703c.k() == false) goto L13;
            tt5.a.h("SelectionNewBase", "start action mode by hand");
            p r107 = this.f221703c;
            r107.f221677e = r107.f221673a.getWebView().startActionMode(this.f221703c.f221678f);
            goto L13
        }

        public final boolean a(ActionMode r110, MenuItem r111) {
            ActionMode.Callback r100 = this.f221703c.f221679g;
            if (r100 == null) goto L5;
            r100.onActionItemClicked(r110, r111);
        L5:
            boolean r101 = false;
            switch(r111.getGroupId()) {
                case 6767770: goto L11;
                case 6767771: goto L11;
                case 6767772: goto L9;
                default: goto L49;
            };
        L11:
            CharSequence r102 = r111.getTitle();
            Iterator<Map.Entry<String, String>> r103 = this.f221701a.entrySet().iterator();
        L13:
            if (r103.hasNext() == false) goto L44;
            Map.Entry<String, String> r104 = r103.next();
            if (r102.equals(r104.getValue()) == false) goto L13;
            String r105 = r104.getKey();
            boolean r106 = "SELECT_ALL".equals(r105);
            p r107 = this.f221703c;
            int r112 = r111.getGroupId();
            r107.getClass();
            tt5.a.h("SelectionNewBase", "jsOnActionModeMenuItemClick:" + r105);
            Iterator r108 = ((ArrayList) r107.f221681i).iterator();
        L18:
            if (r108.hasNext() == false) goto L22;
            ContextMenuItem r109 = (ContextMenuItem) r108.next();
            if (r105.equals(r109.f220904id) == false) goto L18;
        L23:
            String r113 = String.format(Locale.US, "javascript:window.lark.biz.navigation.onContextMenuClick", new Object[0]);
            JSONObject r114 = new JSONObject();
            r114.put2("id", r105);
            if (r109 == null) goto L40;
            r114.put2("text", r109.text);
            r114.put2("data", r109.data);
            String r115 = r109.f220904id;
            tt5.a.h("SelectionNewBase", "report id " + r115);
            if (r112 == 6767771) goto L28;
            HashMap r116 = new HashMap();
            r116.put("menu_id", r115);
            r116.put("enable_intent_menu_item", Boolean.valueOf(r107.f221692t));
            r107.f221685m.v("js_menu_item_clicked", r116);
            goto L40
        L28:
            if (r115.equals("OPEN_LINK") == false) goto L31;
            r107.o("openlink");
            goto L40
        L31:
            if (r115.equals("COPY_LINK") == false) goto L34;
            r107.o("copylink");
            goto L40
        L34:
            if (r115.equals("CUT_LINK") == false) goto L37;
            r107.o("cutlink");
            goto L40
        L37:
            if (r115.equals("COMMENT_LINK") == false) goto L40;
            r107.o("commentlink");
        L40:
            r107.c(r113, r114, null);
            com.bytedance.ee.bear.document.plugin.selection.d r117 = r107.C;
            if (r117 == null) goto L43;
            r117.a(r105);
        L43:
            boolean r118 = true;
            r101 = r106;
        L45:
            this.f221703c.getClass();
            this.f221703c.f221683k.clear();
            this.f221703c.f221684l.setEmpty();
            if (r101 == false) goto L48;
            tt5.a.h("SelectionNewBase", "click item select all");
            final p r119 = this.f221703c;
            com.bytedance.ee.util.ui.j.d(new r(r119), 200);
        L48:
            r101 = r118;
            goto L49
        L22:
            r109 = null;
            goto L23
        L44:
            r118 = false;
        L49:
            r110.finish();
            return r101;
        L9:
            if (this.f221703c.f221692t == false) goto L49;
            r101 = this.f221702b.c(r111).booleanValue();
            this.f221703c.f221685m.v("intent_menu_item_clicked", new HashMap());
            goto L49
        }

        public final void b(ActionMode r100, Menu r101) {
            tt5.a.h("SelectionNewBase", "onCreateActionMode actionMode " + this.f221703c.f221677e + " mode " + r100);
            ActionMode.Callback r102 = this.f221703c.f221679g;
            if (r102 == null) goto L5;
            r102.onCreateActionMode(r100, r101);
        L5:
            ActionMode r103 = this.f221703c.f221677e;
            if (r103 == null) goto L9;
            if (r103 == r100) goto L9;
            r103.finish();
        L9:
            r101.clear();
            p r104 = this.f221703c;
            if (r104.H == false) goto L12;
        L16:
            this.f221703c.f221677e = r100;
            return;
        L12:
            if (r104.f221692t == false) goto L16;
            if (r104.f221698z == true) goto L16;
            this.f221702b.d(r101, r104.f221685m, r100, r104.F);
            goto L16
        }

        public final boolean d(ActionMode r100, Menu r101) {
            tt5.a.h("SelectionNewBase", "onPrepareActionMode jsAssignedMenuItems: " + this.f221703c.f221683k.size());
            ActionMode.Callback r102 = this.f221703c.f221679g;
            if (r102 == null) goto L6;
            r102.onPrepareActionMode(r100, r101);
        L6:
            if (this.f221703c.f221683k.isEmpty() == true) goto L8;
            this.f221701a.clear();
            this.f221701a.putAll(this.f221703c.f221683k);
        L10:
            if (this.f221703c.H == false) goto L15;
            if (f() == true) goto L19;
        L20:
            return false;
        L19:
            return true;
        L15:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == false) goto L18;
            com.bytedance.ee.bear.document.selection.c r103 = this.f221702b;
            p r104 = this.f221703c;
            r103.d(r101, r104.f221685m, r100, r104.F);
        L18:
            if (f() == false) goto L20;
        L8:
            this.f221703c.v();
            goto L10
        }
    }

    public interface d {
        boolean a();

        void b(LinkedHashMap<String, String> r100);

        ActionMode.Callback c(ActionMode.Callback r100);
    }

    public class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f221704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f221705b;

        public e(p r100, boolean r101) {
            this.f221705b = r100;
            this.f221704a = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r110, MotionEvent r111) {
            int r112 = r111.getAction();
            if (r112 == 0) goto L9;
            if (r112 == 1) goto L8;
            if (r112 == 2) goto L9;
            if (r112 == 3) goto L8;
        L23:
            return false;
        L8:
            this.f221705b.l();
        L9:
            p r113 = this.f221705b;
            boolean r100 = this.f221704a;
            r113.getClass();
            int r101 = r111.getAction();
            r113.f221673a.getWebView().getLocationInWindow(r113.f221694v);
            float r102 = r111.getRawY() - r113.f221694v[1];
            float r114 = r111.getRawX();
            String r103 = String.format(Locale.US, "javascript:window.lark.biz.selection.SelectionHandlerTouchEvent", new Object[0]);
            JSONObject r104 = new JSONObject();
            if (r101 == 0) goto L17;
            if (r101 == 1) goto L16;
            if (r101 == 2) goto L15;
            if (r101 == 3) goto L16;
            String r105 = "";
        L18:
            r104.put2("type", r105);
            if (r100 == false) goto L21;
            String r106 = "start";
        L22:
            r104.put2(PickerReporterConstants.KEY.TARGET, r106);
            r104.put2("clientX", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r114)));
            r104.put2("clientY", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r102)));
            r113.c(r103, r104, null);
            goto L23
        L21:
            r106 = "end";
            goto L22
        L15:
            r105 = LynxTouchEvent.EVENT_TOUCH_MOVE;
        L16:
            r105 = LynxTouchEvent.EVENT_TOUCH_END;
            goto L18
        L17:
            r105 = LynxTouchEvent.EVENT_TOUCH_START;
            goto L18
        }
    }

    public abstract Pair<View, Boolean> d(ViewGroup r100);

    public abstract void f();

    public abstract UserPermissionEntity h(String r100);

    public abstract boolean i();

    public abstract void j();

    public abstract boolean k();

    public abstract boolean p();

    public abstract ActionMode r();

    public abstract void s();

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
        this.f221683k.clear();
        this.f221684l.setEmpty();
    }

    public void e() {
        tt5.a.h("SelectionNewBase", "detach");
        com.bytedance.ee.util.ui.j.e(this.K);
        this.f221673a.z(true);
        closeActionMode();
        t();
        s();
    }

    public final void g() {
        if (this.f221677e == null) goto L6;
        tt5.a.h("SelectionNewBase", "finishActionMode");
        this.f221677e.finish();
        this.f221677e = null;
        return;
    }

    public Context getContext() {
        return this.f221673a.getWebView().getContext();
    }

    public final void l() {
        tt5.a.h("SelectionNewBase", "onUpdatedSelection " + this.f221691s + " actionMode " + this.f221677e);
        this.f221690r = 0;
        t();
        this.f221673a.z(true);
        com.bytedance.ee.util.ui.j.e(this.I);
        com.bytedance.ee.util.ui.j.d(this.I, 100);
        if (this.f221677e == null) goto L8;
        if (((d) this.f221678f).a() == false) goto L8;
        tt5.a.h("SelectionNewBase", "onUpdatedSelection actionMode.invalidate actionMode " + this.f221677e);
        this.f221677e.invalidate();
    L8:
        if (this.f221691s == false) goto L11;
        q();
        this.f221691s = false;
        return;
    }

    public final void q() {
        if (this.G.isCurrentEnable("ccm.mobile.docx_selection_bugfix") == false) goto L10;
        ActionMode r100 = this.f221677e;
        if (r100 != null) goto L7;
        this.f221677e = r();
    L11:
        HashMap r101 = new HashMap();
        r101.put("enable_intent_menu_item", Boolean.valueOf(this.f221692t));
        this.f221685m.v("start_action_mode", r101);
        return;
    L7:
        r100.invalidate();
        if (Build.VERSION.SDK_INT < 23) goto L11;
        this.f221677e.invalidateContentRect();
        goto L11
    L10:
        g();
        this.f221677e = r();
        goto L11
    }

    public final void t() {
        ValueAnimator r100 = this.f221680h;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f221680h = null;
        return;
    }

    public final List<ViewGroup> u() {
        ArrayList r100 = new ArrayList();
        WindowManager r101 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L28
        Class r102 = a();     // Catch: Throwable -> L28
        Object r103 = r102.getMethod("getInstance", new Class[0]).invoke(null, null);     // Catch: Throwable -> L28
        Method r104 = r102.getMethod("getViewRootNames", new Class[0]);     // Catch: Throwable -> L28
        Method r105 = r102.getMethod("getRootView", new Class[]{String.class});     // Catch: Throwable -> L28
        String[] r106 = (String[]) r104.invoke(r103, null);     // Catch: Throwable -> L28
        if (r106 != null) goto L7;
        tt5.a.h("SelectionNewBase", "rootViewNames == null");     // Catch: Throwable -> L28
        return r100;
    L7:
        int r107 = r106.length;     // Catch: Throwable -> L28
        int r108 = 0;
    L8:
        float r109 = 0.0f;
        if (r108 >= r107) goto L22;
        String r110 = r106[r108];     // Catch: Throwable -> L28
        tt5.a.h("SelectionNewBase", "viewName " + r110);     // Catch: Throwable -> L28
        if (r110.startsWith("PopupWindow") == false) goto L21;
        View r111 = (View) r105.invoke(r103, new Object[]{r110});     // Catch: Throwable -> L28
        if ((r111 instanceof ViewGroup) == false) goto L21;
        Pair<View, Boolean> r112 = d((ViewGroup) r111);     // Catch: Throwable -> L28
        if (((Boolean) r112.second).booleanValue() == false) goto L21;
        View r113 = (View) r112.first;     // Catch: Throwable -> L28
        if (this.f221696x == false) goto L20;
        r109 = 1.0f;
    L20:
        r113.setAlpha(r109);     // Catch: Throwable -> L28
        r100.add((ViewGroup) r111);     // Catch: Throwable -> L28
    L21:
        r108 = r108 + 1;     // Catch: Throwable -> L28
        goto L8
    L22:
        tt5.a.d("SelectionNewBase", "SelectionNewVH result " + r100.size());     // Catch: Throwable -> L28
        if (p() == true) goto L25;
    L30:
        return r100;
    L25:
        if (r100.size() != 1) goto L30;
        ((ViewGroup) ListProtector.get(r100, 0)).setVisibility(4);     // Catch: Throwable -> L28
        ((ViewGroup) ListProtector.get(r100, 0)).setAlpha(0.0f);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        tt5.a.e("SelectionNewBase", "SelectionNewVH tryFindPopupViews ", th, false);
        goto L30
    }

    public final void v() {
        tt5.a.h("SelectionNewBase", "jsGetActionModeMenu " + this.f221683k);
        c("javascript:window.lark.biz.navigation.requestCustomContextMenu", null, new n(this));
    }

    static {
    }

    public void b(z4 r100) {
        this.f221673a = r100;
        this.f221675c = new GestureDetector(getContext(), new a(this));
    }

    public final void o(String r100) {
        HashMap r101 = new HashMap();
        r101.put("action", r100);
        this.f221685m.v("link_menu_item_clicked", r101);
    }

    @JavascriptInterface
    public void onSelectionChanged(boolean r100) {
        tt5.a.h("SelectionNewBase", "onSelectionChanged hasSelectionData: " + r100 + " mHasSelectionData " + this.f221686n + " actionMode " + this.f221677e);
        boolean r101 = i();
        StringBuilder r102 = new StringBuilder("onNewSelection intercept sys drag success?");
        r102.append(r101);
        tt5.a.h("SelectionNewBase", r102.toString());
        if (r101 == true) goto L5;
        tt5.a.k("SelectionNewBase", "Intercept drag handle touch fail !");
    L5:
        boolean r103 = this.f221686n;
        if (r103 == true) goto L9;
        if (r100 == false) goto L9;
        this.f221691s = false;
        v();
    L12:
        this.f221686n = r100;
        this.f221687o = true;
        if (r100 == true) goto L15;
    L17:
        if (r100 == false) goto L34;
        z4 r104 = this.f221673a;
        if (r104 == null) goto L35;
        WebView.HitTestResult r105 = r104.getWebView().getHitTestResult();
        if (r105 == null) goto L36;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult type: " + r105.getType());
        if (r105.getExtra() == null) goto L25;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult getExtra: " + du5.b.g(r105.getExtra()));
    L27:
        if (r105.getType() != 7) goto L29;
    L32:
        tt5.a.h("SelectionNewBase", "callJsFunction getCursorBounds: ");
        c("javascript:window.lark.biz.selection.getCursorBounds", null, new m(this));
        return;
    L29:
        if (r105.getType() == 5) goto L32;
        if (r105.getType() == 8) goto L32;
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
        if (this.f221688p == false) goto L17;
        this.f221689q = true;
    L9:
        if (r103 == false) goto L12;
        if (r100 == true) goto L12;
        tt5.a.h("SelectionNewBase", "onClearSelection");
        closeActionMode();
        t();
        goto L12
    }

    @Override // zv4.a
    public final ActionMode.Callback prepareActionMode(ActionMode.Callback r100) {
        return ((d) this.f221678f).c(r100);
    }

    @JavascriptInterface
    public void showActionMode(String r100) {
        tt5.a.h("SelectionNewBase", "showActionMode:" + r100);
        n(JSONObjectProtectorUtils.getJSONObject(new org.json.JSONObject(r100), "position"), this.f221684l);     // Catch: Throwable -> L5
        m(r100, this.f221683k);     // Catch: Throwable -> L5
        q();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("SelectionNewBase", "showActionMode exception ", th, false);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.bytedance.ee.bear.document.selection.o] */
    public p(com.bytedance.ee.bear.contract.d r100, DocumentPluginHost r101) {
        this.f221674b = 0.87f;
        this.f221676d = 0;
        this.f221681i = new ArrayList();
        this.f221682j = new LinkedHashMap();
        this.f221683k = new LinkedHashMap();
        this.f221684l = new Rect();
        this.f221692t = false;
        this.f221693u = 0.0f;
        this.f221694v = new int[2];
        this.f221695w = new ArrayList();
        new ArrayList();
        this.f221696x = true;
        this.f221697y = false;
        this.f221698z = false;
        this.A = false;
        this.B = false;
        this.F = false;
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        boolean r103 = r102.h("ccm.docx.mobile.new_action_menu_order");
        this.H = r103;
        this.I = new o(this);
        this.f221672J = "";
        this.K = new b(this);
        this.G = ((dn4.a) r101.getUserComponent().a(dn4.a.class)).a();
        this.f221685m = r100;
        this.D = new l();
        this.E = new com.bytedance.ee.bear.document.selection.d();
        this.A = r102.g("ccm.sheet.is_use_docx_in_sheet");
        DocViewModel r104 = r101.a();
        if (r104 == null) goto L5;
        this.B = TextUtils.equals(sbb.e.f541297h.getType(), r104.getBearUrl().f222560a);
    L5:
        tt5.a.h("SelectionNewBase", "mProcessTextFg: " + r103);
    }

    public final LinkedHashMap<String, String> m(String r210, LinkedHashMap<String, String> r211) {
        r211.clear();     // Catch: Throwable -> L36
        JSONObject r100 = JSON.parseObject(r210);     // Catch: Throwable -> L36
        if (r100 != null) goto L8;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r210);     // Catch: Throwable -> L36
        return r211;
    L8:
        ((ArrayList) this.f221681i).clear();     // Catch: Throwable -> L36
        String r101 = r100.getString("srcObjToken");     // Catch: Exception -> L18 Throwable -> L36
        int r110 = r100.getIntValue("srcObjType");     // Catch: Exception -> L18 Throwable -> L36
        String r111 = r100.getString("content");     // Catch: Exception -> L18 Throwable -> L36
        if (((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(new UniBaseEntity(r101, sbb.e.d(r110), BizDomain.FileBizDomainCCM, null, null, null), "CONTENT_COPY"), h(r101)).getAllow() == false) goto L12;
    L15:
        boolean r102 = true;
    L16:
        this.F = r102;     // Catch: Exception -> L18 Throwable -> L36
    L20:
        JSONArray r103 = r100.getJSONArray("items");     // Catch: Throwable -> L36
        if (r103 != null) goto L24;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r210);     // Catch: Throwable -> L36
        return r211;
    L24:
        int r104 = 0;
    L26:
        if (r104 >= r103.size()) goto L37;
        ContextMenuItem r105 = new ContextMenuItem();     // Catch: Throwable -> L36
        JSONObject r106 = r103.getJSONObject(r104);     // Catch: Throwable -> L36
        r105.f220904id = r106.getString("id");     // Catch: Throwable -> L36
        r105.text = r106.getString("text");     // Catch: Throwable -> L36
        if (r106.containsKey("data") == false) goto L31;
        r105.data = r106.getJSONObject("data");     // Catch: Throwable -> L36
    L31:
        if ("PASTE".equals(r105.f220904id) == true) goto L33;
    L34:
        ((ArrayList) this.f221681i).add(r105);     // Catch: Throwable -> L36
        r211.put(r105.f220904id, r105.text);     // Catch: Throwable -> L36
    L35:
        r104 = r104 + 1;
        goto L26
    L33:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).f().booleanValue() == false) goto L35;
    L37:
        return r211;
    L12:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).w(r111) == false) goto L15;
        r102 = false;
    L18:
        e = move-exception;
        tt5.a.d("SelectionNewBase", "permission validate error " + e.getMessage());     // Catch: Throwable -> L36
    L36:
        tt5.a.k("SelectionNewBase", "parseMenus:" + r210);
        goto L37
    }

    public void n(org.json.JSONObject r100, Rect r101) throws JSONException {
        r101.set(com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "left")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "top")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "right")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "bottom")));
        int r102 = r101.right;
        int r103 = r101.left;
        if ((r102 - r103) >= 10) goto L6;
        r101.right = r103 + 10;
        return;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f221675c.onTouchEvent(r101);
        int r102 = r101.getAction();
        if (r102 == 0) goto L37;
        if (r102 == 1) goto L34;
        if (r102 == 2) goto L11;
        if (r102 == 3) goto L34;
    L38:
        return false;
    L11:
        if (this.f221689q == false) goto L38;
        if ((r101.getRawY() - this.f221693u) <= 0.0f) goto L38;
        float r103 = r101.getY();
        this.f221673a.z(false);
        WebView r104 = this.f221673a.getWebView();
        if (r104 == null) goto L29;
        l r105 = this.D;
        float r106 = this.f221674b;
        r105.getClass();
        int r107 = l.a(r104, r103, 0.13f, r106);
        if (r107 != 0) goto L20;
    L25:
        t();
    L26:
        this.f221690r = r107;
        if (this.f221680h == null) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == false) goto L32;
        this.f221691s = true;
    L32:
        this.f221693u = r101.getRawY();
        goto L38
    L20:
        if (this.f221690r == (-r107)) goto L25;
        if (this.f221680h != null) goto L26;
        com.bytedance.ee.bear.document.selection.d.a r109 = new com.bytedance.ee.bear.document.selection.d.a(com.bytedance.ee.util.ui.n.d(4), r107, false);
        this.E.getClass();
        ValueAnimator r110 = com.bytedance.ee.bear.document.selection.d.a(r104, r109, null);
        this.f221680h = r110;
        r110.addListener(new q(this));
        this.f221680h.start();
    L29:
        r108 = false;
    L34:
        if (this.f221689q == false) goto L36;
        l();
    L36:
        this.f221688p = false;
        this.f221689q = false;
        goto L38
    L37:
        t();
        this.f221688p = true;
        this.f221689q = false;
        this.f221693u = r101.getRawY();
        goto L38
    }

    public final void c(String r100, JSONObject r101, ValueCallback<String> r102) {
        ap5.a.a(this.f221673a.getWebView(), r100, r101, r102);
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        this.f221676d = r101;
    }
}
