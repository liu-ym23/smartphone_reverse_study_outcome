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
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.event.LynxTouchEvent;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChameleonWebView f220962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f220963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GestureDetector f220964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f220965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionMode f220966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActionMode.Callback f220967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ActionMode.Callback f220968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f220969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ContextMenuItem> f220970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap<String, String> f220971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f220972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f220973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f220974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f220975n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f220976o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f220977p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f220978q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f220979r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f220980s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f220981t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f220982u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<V> f220983v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f220984w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.ee.bear.document.plugin.selection.d f220985x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r f220986y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j f220987z;

    public class a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f220988a;

        public a(v r100) {
            this.f220988a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            this.f220988a.f220984w = true;
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            tt5.a.h("SelectionNewBase", "onLongPress");
            v r101 = this.f220988a;
            r101.f220984w = true;
            float r102 = r100.getX();
            float r103 = r100.getY();
            r101.f220972k.setEmpty();
            r101.f220971j.clear();
            String r104 = String.format(Locale.US, "javascript:window.lark.biz.selection.sheetLongPress", new Object[0]);
            JSONObject r105 = new JSONObject();
            r105.put2("x", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r102)));
            r105.put2("y", Float.valueOf(com.bytedance.ee.util.ui.n.E((int) r103)));
            r101.c(r104, r105, null);
            com.bytedance.ee.util.ui.j.e(r101.H);
            com.bytedance.ee.util.ui.j.d(r101.H, 100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            tt5.a.h("SelectionNewBase", "onSingleTapUp");
            v r101 = this.f220988a;
            if (r101.f220974m == true) goto L8;
            if (r101.f220975n == false) goto L8;
            tt5.a.h("SelectionNewBase", "onSingleTapUp onClearSelection");
            v r102 = this.f220988a;
            r102.getClass();
            tt5.a.h("SelectionNewBase", "jsClearSelectionExcludeCursor");
            r102.c("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
            v r103 = this.f220988a;
            r103.getClass();
            tt5.a.h("SelectionNewBase", "onClearSelection");
            r103.closeActionMode();
            r103.r();
        L19:
            return false;
        L8:
            if (r101.f220972k.isEmpty() == true) goto L19;
            this.f220988a.getClass();
            v r104 = this.f220988a;
            if (r104.C > 0) goto L12;
        L14:
            boolean r105 = false;
        L15:
            if (r105 == false) goto L18;
            tt5.a.h("SelectionNewBase", "onSingleTapUp ignored after showActionMode");
            return false;
        L18:
            tt5.a.h("SelectionNewBase", "onSingleTapUp finishActionMode");
            this.f220988a.g();
            goto L19
        L12:
            if ((SystemClock.uptimeMillis() - r104.C) >= 200) goto L14;
            r105 = true;
            goto L15
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f220989a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("SelectionNewBase", "onLongPressRunnable");     // Catch: Throwable -> L4
            String r100 = String.format(Locale.US, "javascript:window.lark.biz.selection.onLongPress", new Object[0]);     // Catch: Throwable -> L4
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
            this.f220989a.c(r100, r101, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(v r100) {
            this.f220989a = r100;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f220990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f220991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f220992c;

        public final boolean f() {
            ActionMode r100 = this.f220992c.f220966e;
            if (r100 != null) goto L5;
        L39:
            return false;
        L5:
            if (r100.getMenu() == null) goto L39;
            Menu r101 = this.f220992c.f220966e.getMenu();
            r r102 = this.f220992c.f220986y;
            LinkedHashMap<String, String> r103 = this.f220990a;
            r102.getClass();
            if (r.a(r101, r103) == false) goto L38;
            int r104 = 6767770;
            if (this.f220992c.D == false) goto L30;
            this.f220991b.getClass();
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed  ret: true");
            r101.removeGroup(6767770);
            r101.removeGroup(6767771);
            if (this.f220990a.containsKey("OPEN_LINK") == false) goto L14;
            r101.clear();
            r104 = 6767771;
        L14:
            Iterator<Map.Entry<String, String>> r105 = this.f220990a.entrySet().iterator();
            int r106 = 0;
        L16:
            if (r105.hasNext() == false) goto L37;
            Map.Entry<String, String> r107 = r105.next();
            String r108 = r107.getKey();
            String r109 = r107.getValue();
            if (TextUtils.equals(r108, "SEARCH_WEB") == false) goto L21;
            r101.add(r104, 0, r106, r109);
        L27:
            r106 = r106 + 1;
            gm5.a r110 = this.f220992c.F;
            if (r110 == null) goto L16;
            r110.getOnSelectionShowCallBack().invoke(r107.getKey().toLowerCase(Locale.ROOT));
            goto L16
        L21:
            if (TextUtils.equals(r108, "SHARE") == false) goto L24;
            this.f220992c.G = r109;
            r101.add(r104, 0, r106, r109);
            goto L27
        L24:
            if (TextUtils.equals(r108, "LARK_SEARCH") == false) goto L26;
            r101.add(r104, 0, r106, r109);
            goto L27
        L26:
            r101.add(r104, 0, r106, r109);
        L37:
            return true;
        L30:
            tt5.a.h("SelectionNewBase", "onPrepareActionMode updateMenuOnNeed ");
            r101.removeGroup(6767770);
            r101.removeGroup(6767771);
            if (this.f220990a.containsKey("OPEN_LINK") == false) goto L33;
            r101.clear();
            r104 = 6767771;
        L33:
            Iterator<String> r111 = this.f220990a.values().iterator();
            int r112 = 0;
        L35:
            if (r111.hasNext() == false) goto L37;
            r101.add(r104, 0, r112, r111.next());
            r112 = r112 + 1;
            goto L35
        L38:
            tt5.a.h("SelectionNewBase", "need not update menu");
            goto L39
        }

        public c(v r100) {
            this.f220992c = r100;
            this.f220990a = new LinkedHashMap();
            this.f220991b = new i(r100.f220962a);
        }

        public final void c(ActionMode r100) {
            tt5.a.h("SelectionNewBase", "onDestroyActionMode actionMode " + this.f220992c.f220966e + " mode " + r100);
            ActionMode.Callback r101 = this.f220992c.f220968g;
            if (r101 == null) goto L5;
            r101.onDestroyActionMode(r100);
        L5:
            ActionMode r102 = this.f220992c.f220966e;
            if (r102 == null) goto L9;
            if (r102 == r100) goto L9;
            r102.finish();
        L9:
            ((ArrayList) this.f220992c.f220970i).clear();
            this.f220990a.clear();
            this.f220992c.f220966e = null;
        }

        public final void e(LinkedHashMap<String, String> r100) {
            if (this.f220990a.equals(r100) == false) goto L6;
            tt5.a.h("SelectionNewBase", "menu not change, return");
            return;
        L6:
            this.f220990a.clear();
            this.f220990a.putAll(r100);
            if (this.f220992c.f220966e == null) goto L9;
        L13:
            v r101 = this.f220992c;
            ActionMode r102 = r101.f220966e;
            if (r102 == null) goto L18;
            r r103 = r101.f220986y;
            Menu r104 = r102.getMenu();
            LinkedHashMap<String, String> r105 = this.f220990a;
            r103.getClass();
            if (r.a(r104, r105) == false) goto L18;
            boolean r106 = true;
        L19:
            tt5.a.h("SelectionNewBase", "updateMenuItems, actionMode = " + this.f220992c.f220966e + ", needInvalidate = " + r106);
            if (r106 == false) goto L23;
            this.f220992c.f220966e.invalidate();
            return;
        L23:
            return;
        L18:
            r106 = false;
            goto L19
        L9:
            if (com.larksuite.framework.utils.x.a() == true) goto L13;
            if (this.f220992c.i() == false) goto L13;
            tt5.a.h("SelectionNewBase", "start action mode by hand");
            v r107 = this.f220992c;
            r107.f220966e = r107.f220962a.u(r107.f220967f, -1);
            goto L13
        }

        public final boolean a(ActionMode r110, MenuItem r111) {
            ActionMode.Callback r100 = this.f220992c.f220968g;
            if (r100 == null) goto L5;
            r100.onActionItemClicked(r110, r111);
        L5:
            boolean r101 = true;
            boolean r102 = false;
            switch(r111.getGroupId()) {
                case 6767770: goto L22;
                case 6767771: goto L22;
                case 6767772: goto L9;
                default: goto L60;
            };
        L22:
            CharSequence r103 = r111.getTitle();
            Iterator<Map.Entry<String, String>> r104 = this.f220990a.entrySet().iterator();
        L24:
            if (r104.hasNext() == false) goto L55;
            Map.Entry<String, String> r105 = r104.next();
            if (r103.equals(r105.getValue()) == false) goto L24;
            String r106 = r105.getKey();
            boolean r107 = "SELECT_ALL".equals(r106);
            v r108 = this.f220992c;
            int r112 = r111.getGroupId();
            r108.getClass();
            tt5.a.h("SelectionNewBase", "jsOnActionModeMenuItemClick:" + r106);
            Iterator r109 = ((ArrayList) r108.f220970i).iterator();
        L29:
            if (r109.hasNext() == false) goto L33;
            ContextMenuItem r113 = (ContextMenuItem) r109.next();
            if (r106.equals(r113.f220904id) == false) goto L29;
        L34:
            String r114 = String.format(Locale.US, "javascript:window.lark.biz.navigation.onContextMenuClick", new Object[0]);
            JSONObject r115 = new JSONObject();
            r115.put2("id", r106);
            if (r113 == null) goto L51;
            r115.put2("text", r113.text);
            r115.put2("data", r113.data);
            String r116 = r113.f220904id;
            tt5.a.h("SelectionNewBase", "report id " + r116);
            if (r112 == 6767771) goto L39;
            HashMap r117 = new HashMap();
            r117.put("menu_id", r116);
            r117.put("enable_intent_menu_item", Boolean.valueOf(r108.f220980s));
            r108.f220973l.v("js_menu_item_clicked", r117);
            goto L51
        L39:
            if (r116.equals("OPEN_LINK") == false) goto L42;
            r108.m("openlink");
            goto L51
        L42:
            if (r116.equals("COPY_LINK") == false) goto L45;
            r108.m("copylink");
            goto L51
        L45:
            if (r116.equals("CUT_LINK") == false) goto L48;
            r108.m("cutlink");
            goto L51
        L48:
            if (r116.equals("COMMENT_LINK") == false) goto L51;
            r108.m("commentlink");
        L51:
            r108.c(r114, r115, null);
            com.bytedance.ee.bear.document.plugin.selection.d r118 = r108.f220985x;
            if (r118 == null) goto L54;
            r118.a(r106);
        L54:
            r102 = r107;
        L56:
            this.f220992c.getClass();
            this.f220992c.f220971j.clear();
            this.f220992c.f220972k.setEmpty();
            if (r102 == false) goto L59;
            tt5.a.h("SelectionNewBase", "click item select all");
            final v r119 = this.f220992c;
            com.bytedance.ee.util.ui.j.d(new x(r119), 200);
        L59:
            r102 = r101;
            goto L60
        L33:
            r113 = null;
            goto L34
        L55:
            r101 = false;
        L60:
            r110.finish();
            return r102;
        L9:
            if (this.f220992c.f220980s == false) goto L60;
            i r120 = this.f220991b;
            tt5.a.b(r120.f220924c, "jsClearSelectionExcludeCursor");
            ap5.a.a(r120.f220922a, "javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
            Intent r121 = r120.f220926e.get(r111);
            if (r121 != null) goto L62;
        L20:
            r101 = false;
        L21:
            r102 = Boolean.valueOf(r101).booleanValue();
            this.f220992c.f220973l.v("intent_menu_item_clicked", new HashMap());
            goto L60
        L62:
        L18:
            e = move-exception;
            iu5.d.a("ProcessTextIntentItemManager", e);
            goto L20
        L13:
            if (r121.getAction().equals("android.intent.action.WEB_SEARCH") == false) goto L15;
            String r122 = "query";
        L16:
            r121.putExtra(r122, r120.f220935g);     // Catch: SecurityException -> L18
            r120.f220922a.getContext().startActivity(r121);     // Catch: SecurityException -> L18
            goto L21
        L15:
            r122 = "android.intent.extra.PROCESS_TEXT";
            goto L16
        }

        public final void b(ActionMode r100, Menu r110) {
            tt5.a.h("SelectionNewBase", "onCreateActionMode actionMode " + this.f220992c.f220966e + " mode " + r100);
            ActionMode.Callback r101 = this.f220992c.f220968g;
            if (r101 == null) goto L5;
            r101.onCreateActionMode(r100, r110);
        L5:
            ActionMode r102 = this.f220992c.f220966e;
            if (r102 == null) goto L9;
            if (r102 == r100) goto L9;
            r102.finish();
        L9:
            r110.clear();
            v r103 = this.f220992c;
            if (r103.D == false) goto L12;
        L17:
            this.f220992c.f220966e = r100;
            return;
        L12:
            if (r103.f220980s == false) goto L17;
            i r104 = this.f220991b;
            com.bytedance.ee.bear.contract.d r105 = r103.f220973l;
            boolean r106 = r103.A;
            if (r100 != null) goto L16;
            r104.getClass();
            goto L17
        L16:
            r104.f220922a.evaluateJavascript("(function(){return window.getSelection().toString()})()", new h(r104, r110, r106, r100, r105));
            goto L17
        }

        public final boolean d(ActionMode r100, Menu r110) {
            tt5.a.h("SelectionNewBase", "onPrepareActionMode jsAssignedMenuItems: " + this.f220992c.f220971j.size());
            ActionMode.Callback r101 = this.f220992c.f220968g;
            if (r101 == null) goto L6;
            r101.onPrepareActionMode(r100, r110);
        L6:
            if (this.f220992c.f220971j.isEmpty() == true) goto L8;
            this.f220990a.clear();
            this.f220990a.putAll(this.f220992c.f220971j);
        L10:
            if (this.f220992c.D == false) goto L15;
            if (f() == true) goto L22;
        L23:
            return false;
        L22:
            return true;
        L15:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == false) goto L21;
            i r102 = this.f220991b;
            v r103 = this.f220992c;
            com.bytedance.ee.bear.contract.d r104 = r103.f220973l;
            boolean r105 = r103.A;
            if (r100 != null) goto L19;
            r102.getClass();
            goto L21
        L19:
            r102.f220922a.evaluateJavascript("(function(){return window.getSelection().toString()})()", new h(r102, r110, r105, r100, r104));
        L21:
            if (f() == false) goto L23;
        L8:
            this.f220992c.t();
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
        public final boolean f220993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f220994b;

        public e(v r100, boolean r101) {
            this.f220994b = r100;
            this.f220993a = r101;
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
            this.f220994b.j();
        L9:
            v r113 = this.f220994b;
            boolean r100 = this.f220993a;
            r113.getClass();
            int r101 = r111.getAction();
            r113.f220962a.getLocationInWindow(r113.f220982u);
            float r102 = r111.getRawY() - r113.f220982u[1];
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

    public abstract boolean h();

    public abstract boolean i();

    public abstract boolean n();

    public abstract ActionMode p();

    public abstract void q();

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
        this.f220971j.clear();
        this.f220972k.setEmpty();
    }

    public void e() {
        tt5.a.h("SelectionNewBase", "detach");
        com.bytedance.ee.util.ui.j.e(this.H);
        this.f220962a.setEnableOverScrollBy(true);
        closeActionMode();
        r();
        q();
    }

    public final void g() {
        if (this.f220966e == null) goto L6;
        tt5.a.h("SelectionNewBase", "finishActionMode");
        this.f220966e.finish();
        this.f220966e = null;
        return;
    }

    public Context getContext() {
        return this.f220962a.getContext();
    }

    public final void j() {
        tt5.a.h("SelectionNewBase", "onUpdatedSelection " + this.f220979r + " actionMode " + this.f220966e);
        this.f220978q = 0;
        r();
        this.f220962a.setEnableOverScrollBy(true);
        com.bytedance.ee.util.ui.j.e(this.E);
        com.bytedance.ee.util.ui.j.d(this.E, 100);
        if (this.f220966e == null) goto L8;
        if (((d) this.f220967f).a() == false) goto L8;
        tt5.a.h("SelectionNewBase", "onUpdatedSelection actionMode.invalidate actionMode " + this.f220966e);
        this.f220966e.invalidate();
    L8:
        if (this.f220979r == false) goto L11;
        o();
        this.f220979r = false;
        return;
    }

    public final void o() {
        if (this.B.isCurrentEnable("ccm.mobile.docx_selection_bugfix") == false) goto L10;
        ActionMode r100 = this.f220966e;
        if (r100 != null) goto L7;
        this.f220966e = p();
    L11:
        HashMap r101 = new HashMap();
        r101.put("enable_intent_menu_item", Boolean.valueOf(this.f220980s));
        this.f220973l.v("start_action_mode", r101);
        return;
    L7:
        r100.invalidate();
        if (Build.VERSION.SDK_INT < 23) goto L11;
        this.f220966e.invalidateContentRect();
        goto L11
    L10:
        g();
        this.f220966e = p();
        goto L11
    }

    public final void r() {
        ValueAnimator r100 = this.f220969h;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f220969h = null;
        return;
    }

    public final List<ViewGroup> s() {
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
        if (this.f220984w == false) goto L20;
        r109 = 1.0f;
    L20:
        r113.setAlpha(r109);     // Catch: Throwable -> L28
        r100.add((ViewGroup) r111);     // Catch: Throwable -> L28
    L21:
        r108 = r108 + 1;     // Catch: Throwable -> L28
        goto L8
    L22:
        tt5.a.d("SelectionNewBase", "SelectionNewVH result " + r100.size());     // Catch: Throwable -> L28
        if (n() == true) goto L25;
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

    public final void t() {
        tt5.a.h("SelectionNewBase", "jsGetActionModeMenu " + this.f220971j);
        c("javascript:window.lark.biz.navigation.requestCustomContextMenu", null, new u(this));
    }

    static {
    }

    public void b(ChameleonWebView r100) {
        this.f220962a = r100;
        this.f220964c = new GestureDetector(getContext(), new a(this));
    }

    public final void m(String r100) {
        HashMap r101 = new HashMap();
        r101.put("action", r100);
        this.f220973l.v("link_menu_item_clicked", r101);
    }

    @JavascriptInterface
    public void onSelectionChanged(boolean r100) {
        tt5.a.h("SelectionNewBase", "onSelectionChanged hasSelectionData: " + r100 + " mHasSelectionData " + this.f220974m + " actionMode " + this.f220966e);
        boolean r101 = h();
        StringBuilder r102 = new StringBuilder("onNewSelection intercept sys drag success?");
        r102.append(r101);
        tt5.a.h("SelectionNewBase", r102.toString());
        if (r101 == true) goto L5;
        tt5.a.k("SelectionNewBase", "Intercept drag handle touch fail !");
    L5:
        boolean r103 = this.f220974m;
        if (r103 == true) goto L9;
        if (r100 == false) goto L9;
        this.f220979r = false;
        t();
    L12:
        this.f220974m = r100;
        this.f220975n = true;
        if (r100 == true) goto L15;
    L17:
        if (r100 == false) goto L34;
        ChameleonWebView r104 = this.f220962a;
        if (r104 == null) goto L35;
        WebView.HitTestResult r105 = r104.getHitTestResult();
        if (r105 == null) goto L36;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult type: " + r105.getType());
        if (r105.getExtra() == null) goto L25;
        tt5.a.h("SelectionNewBase", "WebView.HitTestResult getExtra: " + du5.b.g(r105.getExtra()));
    L27:
        if (r105.getType() != 7) goto L29;
    L32:
        tt5.a.h("SelectionNewBase", "callJsFunction getCursorBounds: ");
        c("javascript:window.lark.biz.selection.getCursorBounds", null, new t(this));
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
        if (this.f220976o == false) goto L17;
        this.f220977p = true;
    L9:
        if (r103 == false) goto L12;
        if (r100 == true) goto L12;
        tt5.a.h("SelectionNewBase", "onClearSelection");
        closeActionMode();
        r();
        goto L12
    }

    @Override // zv4.a
    public final ActionMode.Callback prepareActionMode(ActionMode.Callback r100) {
        return ((d) this.f220967f).c(r100);
    }

    @JavascriptInterface
    public void showActionMode(String r100) {
        tt5.a.h("SelectionNewBase", "showActionMode:" + r100);
        l(JSONObjectProtectorUtils.getJSONObject(new org.json.JSONObject(r100), "position"), this.f220972k);     // Catch: Throwable -> L5
        k(r100, this.f220971j);     // Catch: Throwable -> L5
        this.C = SystemClock.uptimeMillis();     // Catch: Throwable -> L5
        o();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("SelectionNewBase", "showActionMode exception ", th, false);
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.bytedance.ee.bear.document.plugin.selection.s] */
    public v(com.bytedance.ee.bear.contract.d r100, ChameleonPluginHost r101) {
        this.f220963b = 0.87f;
        this.f220965d = 0;
        this.f220970i = new ArrayList();
        this.f220971j = new LinkedHashMap();
        this.f220972k = new Rect();
        this.f220980s = false;
        this.f220981t = 0.0f;
        this.f220982u = new int[2];
        this.f220983v = new ArrayList();
        new ArrayList();
        this.f220984w = true;
        this.A = false;
        this.C = 0;
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.docx.mobile.new_action_menu_order");
        this.D = r102;
        this.E = new s(this);
        this.G = "";
        this.H = new b(this);
        this.B = ((dn4.a) r101.getUserComponent().a(dn4.a.class)).a();
        this.F = (gm5.a) r101.getUserComponent().a(gm5.a.class);
        this.f220973l = r100;
        this.f220986y = new r();
        this.f220987z = new j();
        y3 r103 = ((e4) r101.getHostAbility(e4.class)).getDocumentMetadata();
        if (r103 == null) goto L5;
        TextUtils.equals(sbb.e.f541297h.getType(), r103.getBearUrl().f222560a);
    L5:
        tt5.a.h("SelectionNewBase", "mProcessTextFg: " + r102);
    }

    public final LinkedHashMap<String, String> k(String r100, LinkedHashMap<String, String> r101) {
        r101.clear();     // Catch: Throwable -> L29
        JSONObject r102 = JSON.parseObject(r100);     // Catch: Throwable -> L29
        if (r102 != null) goto L8;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r100);     // Catch: Throwable -> L29
        return r101;
    L8:
        ((ArrayList) this.f220970i).clear();     // Catch: Throwable -> L29
        r102.getString("srcObjToken");     // Catch: Exception -> L11 Throwable -> L29
        r102.getIntValue("srcObjType");     // Catch: Exception -> L11 Throwable -> L29
        r102.getString("content");     // Catch: Exception -> L11 Throwable -> L29
        this.A = true;     // Catch: Exception -> L11 Throwable -> L29
    L13:
        JSONArray r103 = r102.getJSONArray("items");     // Catch: Throwable -> L29
        if (r103 != null) goto L17;
        tt5.a.k("SelectionNewBase", "parseMenus: " + r100);     // Catch: Throwable -> L29
        return r101;
    L17:
        int r104 = 0;
    L19:
        if (r104 >= r103.size()) goto L30;
        ContextMenuItem r105 = new ContextMenuItem();     // Catch: Throwable -> L29
        JSONObject r106 = r103.getJSONObject(r104);     // Catch: Throwable -> L29
        r105.f220904id = r106.getString("id");     // Catch: Throwable -> L29
        r105.text = r106.getString("text");     // Catch: Throwable -> L29
        if (r106.containsKey("data") == false) goto L24;
        r105.data = r106.getJSONObject("data");     // Catch: Throwable -> L29
    L24:
        if ("PASTE".equals(r105.f220904id) == true) goto L26;
    L27:
        ((ArrayList) this.f220970i).add(r105);     // Catch: Throwable -> L29
        r101.put(r105.f220904id, r105.text);     // Catch: Throwable -> L29
    L28:
        r104 = r104 + 1;
        goto L19
    L26:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).f().booleanValue() == false) goto L28;
    L30:
        return r101;
    L11:
        e = move-exception;
        tt5.a.d("SelectionNewBase", "permission validate error " + e.getMessage());     // Catch: Throwable -> L29
    L29:
        tt5.a.k("SelectionNewBase", "parseMenus:" + r100);
        goto L30
    }

    public final void l(org.json.JSONObject r100, Rect r101) throws JSONException {
        r101.set(com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "left")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "top")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "right")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "bottom")));
        int r102 = r101.right;
        int r103 = r101.left;
        if ((r102 - r103) >= 10) goto L6;
        r101.right = r103 + 10;
        return;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r110) {
        this.f220964c.onTouchEvent(r110);
        int r101 = r110.getAction();
        if (r101 == 0) goto L47;
        if (r101 == 1) goto L44;
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L44;
    L48:
        return false;
    L11:
        if (this.f220977p == false) goto L48;
        if ((r110.getRawY() - this.f220981t) <= 0.0f) goto L48;
        float r102 = r110.getY();
        this.f220962a.setEnableOverScrollBy(false);
        ChameleonWebView r103 = this.f220962a;
        if (r103 == null) goto L39;
        r r104 = this.f220986y;
        float r105 = this.f220963b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "webView");
        float r106 = r103.getHeight();
        if (r102 >= (0.13f * r106)) goto L23;
        int r107 = -1;
        if (r103.canScrollVertically(-1) == true) goto L28;
    L27:
        r107 = 0;
    L28:
        if (r107 != 0) goto L30;
    L35:
        r();
    L36:
        this.f220978q = r107;
        if (this.f220969h == null) goto L39;
        boolean r108 = true;
    L40:
        if (r108 == false) goto L42;
        this.f220979r = true;
    L42:
        this.f220981t = r110.getRawY();
        goto L48
    L30:
        if (this.f220978q == (-r107)) goto L35;
        if (this.f220969h != null) goto L36;
        j.a r109 = new j.a(com.bytedance.ee.util.ui.n.d(4), r107);
        this.f220987z.getClass();
        Intrinsics.checkNotNullParameter(r103, "webView");
        Intrinsics.checkNotNullParameter(r109, "params");
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r111.setDuration(Long.MAX_VALUE);
        r111.setInterpolator(new LinearInterpolator());
        r111.addUpdateListener(new k(r109, r103));
        Intrinsics.checkNotNull(r111);
        this.f220969h = r111;
        r111.addListener(new w(this));
        this.f220969h.start();
        goto L36
    L23:
        if (r102 <= (r106 * r105)) goto L27;
        if (r103.canScrollVertically(1) == false) goto L27;
        r107 = 1;
    L39:
        r108 = false;
    L44:
        if (this.f220977p == false) goto L46;
        j();
    L46:
        this.f220976o = false;
        this.f220977p = false;
        goto L48
    L47:
        r();
        this.f220976o = true;
        this.f220977p = false;
        this.f220981t = r110.getRawY();
        goto L48
    }

    public final void c(String r100, JSONObject r101, ValueCallback<String> r102) {
        ap5.a.a(this.f220962a, r100, r101, r102);
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        this.f220965d = r101;
    }
}
