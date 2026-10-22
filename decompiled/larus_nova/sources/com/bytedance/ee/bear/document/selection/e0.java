package com.bytedance.ee.bear.document.selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ImageView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 extends zv4.g implements zv4.f {
    public static final int V = 0;
    public ImageView A;
    public final int[] B;
    public ActionMode C;
    public e D;
    public final Point E;
    public final Point F;
    public int G;
    public final com.bytedance.ee.bear.contract.d H;
    public final DocumentPluginHost I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public MotionEvent f221611J;
    public boolean K;
    public final a L;
    public final y M;
    public float N;
    public float O;
    public final int[] P;
    public ValueAnimator Q;
    public boolean R;
    public final Rect S;
    public com.bytedance.ee.bear.document.plugin.selection.d T;
    public final b U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMode.Callback f221612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f221613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f221614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.document.selection.d f221615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f221616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f221617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f221618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f221619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f221620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f221621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zv4.c f221622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f221623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f221624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f221625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f221626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f221627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f221628q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f221629r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f221630s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f221631t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final x f221632u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f221633v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f221634w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public GestureDetector f221635x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f221636y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f221637z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f221638a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f221638a.f221611J == null) goto L9;
            e0.l(new String[]{"cancelDefaultLongPress"});     // Catch: Throwable -> L6
            this.f221638a.i().onTouchEvent(this.f221638a.f221611J);     // Catch: Throwable -> L6
            return;
        }

        public a(e0 r100) {
            this.f221638a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f221639a;

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (Build.VERSION.SDK_INT < 23) goto L11;
            ActionMode r100 = this.f221639a.C;     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            r100.invalidateContentRect();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }

        public b(e0 r100) {
            this.f221639a = r100;
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f221640a;

        public c(e0 r100) {
            this.f221640a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            e0 r101 = this.f221640a;
            if (r101.f221616e == true) goto L5;
            return false;
        L5:
            if (r101.f221620i == false) goto L11;
            e0.l(new String[]{"onDoubleTap"});
            this.f221640a.S.setEmpty();
            this.f221640a.j();
            this.f221640a.i().postDelayed(new f0(this), 100);
            return false;
        L11:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            e0 r101 = this.f221640a;
            if (r101.f221616e == true) goto L5;
            return;
        L5:
            if (r101.f221618g == false) goto L10;
            e0.l(new String[]{"onLongPress"});
            this.f221640a.S.setEmpty();
            this.f221640a.j();
            e0 r102 = this.f221640a;
            r102.getClass();
            e0.l(new String[]{"jsLongPressSelect"});
            String r103 = String.format(Locale.US, "javascript:window.lark.biz.selection.longPressSelect", new Object[0]);
            JSONObject r104 = new JSONObject();
            r104.put2("x", Float.valueOf(com.bytedance.ee.util.ui.n.E(r102.f221623l)));
            r104.put2("y", Float.valueOf(com.bytedance.ee.util.ui.n.E(r102.f221624m)));
            r102.g(r103, r104, null);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            e0 r101 = this.f221640a;
            if (r101.f221616e == true) goto L5;
            return false;
        L5:
            if (r101.f221619h == false) goto L33;
            e0.l(new String[]{"onSingleTapUp"});
            e0 r102 = this.f221640a;
            Point r103 = r102.F;
            int r104 = r103.y;
            Point r105 = r102.E;
            int r106 = r105.y;
            if (r104 > r106) goto L13;
            if (r104 == r106) goto L12;
        L14:
            boolean r107 = false;
        L15:
            if (r107 == false) goto L17;
            r102.getClass();
            e0.l(new String[]{"jsClearSelectionExcludeCursor"});
            r102.g("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
        L17:
            ActionMode r108 = this.f221640a.C;
            if (r108 == null) goto L20;
            r108.finish();
        L20:
            if (r107 == false) goto L31;
            e0 r109 = this.f221640a;
            r109.f221636y.getLocationInWindow(r109.B);
            int[] r110 = r109.B;
            int r111 = r110[1];
            r109.f221637z.getLocationInWindow(r110);
            int r112 = r109.B[1];
            if (r111 > 0) goto L24;
        L26:
            boolean r113 = false;
        L27:
            if (r113 == false) goto L32;
            return true;
        L32:
            return false;
        L24:
            if (r112 >= r109.i().getHeight()) goto L26;
            r113 = true;
            goto L27
        L31:
            return false;
        L12:
            if (r103.x <= r105.x) goto L14;
        L13:
            r107 = true;
            goto L15
        L33:
            return false;
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f221641a;

        public d(e0 r100) {
            this.f221641a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            this.f221641a.Q = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f221641a.Q = null;
        }
    }

    public class e extends ActionMode.Callback2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f221642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashMap<String, String> f221643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ee.bear.document.selection.c f221644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e0 f221645d;

        public e(e0 r100) {
            this.f221645d = r100;
            this.f221642a = new LinkedHashMap();
            this.f221643b = new LinkedHashMap();
            this.f221644c = new com.bytedance.ee.bear.document.selection.c(r100.i(), "SelectionOld");
        }

        public final void a(String r210) throws JSONException {
            this.f221643b.clear();
            org.json.JSONObject r100 = new org.json.JSONObject(r210);
            String r101 = JSONObjectProtectorUtils.getString(r100, "srcObjToken");     // Catch: Exception -> L22
            int r102 = JSONObjectProtectorUtils.getInt(r100, "srcObjType");     // Catch: Exception -> L22
            String r110 = JSONObjectProtectorUtils.getString(r100, "content");     // Catch: Exception -> L22
            UniBaseEntity r111 = new UniBaseEntity(r101, sbb.e.d(r102), BizDomain.FileBizDomainCCM, null, null, null);     // Catch: Exception -> L22
            DocumentPluginHost r103 = this.f221645d.I;     // Catch: Exception -> L22
            if (r103 != null) goto L6;
        L12:
            UserPermissionEntity r104 = null;
        L13:
            boolean r105 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r111, "CONTENT_COPY"), r104).getAllow();     // Catch: Exception -> L22
            e0 r106 = this.f221645d;     // Catch: Exception -> L22
            if (r105 == false) goto L16;
        L19:
            boolean r107 = true;
        L20:
            r106.K = r107;     // Catch: Exception -> L22
        L24:
            JSONArray r108 = JSONObjectProtectorUtils.getJSONArray(r100, "items");
            int r109 = 0;
        L26:
            if (r109 >= r108.length()) goto L29;
            org.json.JSONObject r112 = JSONArrayProtectorUtils.getJSONObject(r108, r109);
            this.f221643b.put(JSONObjectProtectorUtils.getString(r112, "id"), JSONObjectProtectorUtils.getString(r112, "text"));
            r109 = r109 + 1;
            goto L26
        L29:
            if (this.f221643b.containsKey("PASTE") == false) goto L55;
            ClipboardManager r113 = (ClipboardManager) e0.f(this.f221645d).getSystemService(ClipboardManager.class);
            if (r113 == null) goto L52;
            ArrayList r114 = new ArrayList();
            Object[] r115 = new Object[0];
            f06.b r116 = new f06.b();
            g06.a r117 = ApiHookConfig.f245611b.get(101805);
            if (r117 == null) goto L35;
            f06.a[] r118 = r117.f479473i;
        L36:
            f06.a[] r119 = r118;
            int r120 = r119.length;
            int r121 = 0;
        L38:
            if (r121 >= r120) goto L45;
            f06.a r122 = r119[r121];
            int r211 = r121;
            int r212 = r120;
            f06.a[] r213 = r119;
            f06.d r123 = r122.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r113, r115, "boolean", r116);     // Catch: Exception -> L57
            if (r123.f474982a == true) goto L47;
            r114.add(r122);     // Catch: Exception -> L57
        L47:
            if (r123.f474982a == false) goto L49;
            boolean r124 = ((Boolean) r123.f474983b).booleanValue();
        L50:
            if (r124 == true) goto L52;
            boolean r125 = true;
        L53:
            if (r125 == false) goto L55;
            this.f221643b.remove("PASTE");
            goto L55
        L49:
            r124 = r113.hasPrimaryClip();
        L44:
            r121 = r211 + 1;
            r120 = r212;
            r119 = r213;
            goto L38
        L45:
            r123 = new f06.d(false, null);
            goto L47
        L35:
            r118 = ApiHookConfig.f245613d;
        L52:
            r125 = false;
        L55:
            this.f221642a.clear();
            this.f221642a.putAll(this.f221643b);
            return;
        L16:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).w(r110) == false) goto L19;
            r107 = false;
            goto L20
        L6:
            if (r103.a() == null) goto L12;
            if (this.f221645d.I.a().getDocumentInfoData() == null) goto L12;
            if (this.f221645d.I.a().getDocumentInfoData().getDocPermissionByToken(r101) == null) goto L12;
            r104 = new UserPermissionEntity(this.f221645d.I.a().getDocumentInfoData().getDocPermissionByToken(r101), null);     // Catch: Exception -> L22
        L22:
            e = move-exception;
            tt5.a.d("SelectionOld", "permission validate error " + e.getMessage());
            goto L24
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            ActionMode.Callback r101 = this.f221645d.f221612a;
            if (r101 == null) goto L6;
            r101.onDestroyActionMode(r100);
            return;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            ActionMode.Callback r102 = this.f221645d.f221612a;
            if (r102 == null) goto L5;
            r102.onActionItemClicked(r100, r101);
        L5:
            int r103 = r101.getGroupId();
            boolean r104 = false;
            if (r103 != 6767770) goto L8;
            CharSequence r105 = r101.getTitle();
            Iterator<Map.Entry<String, String>> r106 = this.f221642a.entrySet().iterator();
        L15:
            if (r106.hasNext() == false) goto L22;
            Map.Entry<String, String> r107 = r106.next();
            if (r105.equals(r107.getValue()) == false) goto L15;
            String r108 = r107.getKey();
            e0 r109 = this.f221645d;
            r109.getClass();
            e0.l(new String[]{"jsOnActionModeMenuItemClick:" + r108});
            String r110 = String.format(Locale.US, "javascript:window.lark.biz.navigation.onContextMenuClick", new Object[0]);
            JSONObject r111 = new JSONObject();
            r111.put2("id", r108);
            r109.g(r110, r111, null);
            HashMap r112 = new HashMap();
            r112.put("menu_id", r108);
            r112.put("enable_intent_menu_item", Boolean.valueOf(r109.f221630s));
            r109.H.v("js_menu_item_clicked", r112);
            com.bytedance.ee.bear.document.plugin.selection.d r113 = r109.T;
            if (r113 == null) goto L21;
            r113.a(r108);
        L21:
            r104 = true;
        L22:
            r100.finish();
            return r104;
        L8:
            if (r103 != 6767772) goto L22;
            e0 r114 = this.f221645d;
            if (r114.f221630s == false) goto L22;
            r114.H.v("intent_menu_item_clicked", new HashMap());
            r104 = this.f221644c.c(r101).booleanValue();
            goto L22
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            ActionMode.Callback r102 = this.f221645d.f221612a;
            if (r102 == null) goto L5;
            r102.onCreateActionMode(r100, r101);
        L5:
            e0 r103 = this.f221645d;
            if (r103.f221630s == false) goto L8;
            this.f221644c.d(r101, r103.H, r100, r103.K);
        L8:
            this.f221645d.C = r100;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            ActionMode.Callback r102 = this.f221645d.f221612a;
            if (r102 == null) goto L5;
            r102.onPrepareActionMode(r100, r101);
        L5:
            l r103 = this.f221645d.f221614c;
            LinkedHashMap<String, String> r104 = this.f221642a;
            r103.getClass();
            boolean r105 = false;
            if (l.b(r101, r104, false) == false) goto L13;
            r101.removeGroup(6767770);
            this.f221645d.getClass();
            e0.l(new String[]{"menu updated"});
            Iterator<String> r106 = this.f221642a.values().iterator();
            int r107 = 0;
        L9:
            if (r106.hasNext() == false) goto L11;
            r101.add(6767770, 0, r107, r106.next());
            r107 = r107 + 1;
            goto L9
        L11:
            r105 = true;
        L13:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == false) goto L15;
            com.bytedance.ee.bear.document.selection.c r108 = this.f221644c;
            e0 r109 = this.f221645d;
            r108.d(r101, r109.H, r100, r109.K);
        L15:
            return r105;
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
            if (this.f221645d.S.isEmpty() == true) goto L5;
            r102.set(this.f221645d.S);
            r102.offset(0, -this.f221645d.i().getScrollY());
            return;
        L5:
            e0 r103 = this.f221645d;
            Point r104 = r103.E;
            int r105 = r104.x;
            int r106 = r104.y;
            Point r107 = r103.F;
            int r108 = r107.x;
            int r109 = r107.y;
            if (r105 <= r108) goto L8;
            r108 = r105;
            r105 = r108;
        L8:
            if (r106 <= r109) goto L10;
            r106 = r109;
            r109 = r106;
        L10:
            r102.set(r105, r106, r108, r109);
            r102.offset(0, -this.f221645d.i().getScrollY());
            int r110 = r102.top;
            e0 r111 = this.f221645d;
            r102.top = r110 - r111.G;
            r102.bottom += r111.f221637z.getHeight();
        }
    }

    public final void j() {
        o(false);
        ActionMode r100 = this.C;
        if (r100 == null) goto L5;
        r100.finish();
    L5:
        this.E.set(0, 0);
        this.F.set(0, 0);
    }

    static {
        V = ViewConfiguration.getLongPressTimeout() - 100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e() throws ClassNotFoundException {
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

    public static boolean h() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        String[] r101 = {Build.BOARD, Build.PRODUCT, Build.DISPLAY};
        int r102 = 0;
    L6:
        if (r102 >= 3) goto L16;
        String r103 = r101[r102];
        if (TextUtils.isEmpty(r103) == true) goto L14;
        String r104 = r103.toLowerCase();
        if (r104.contains("flyme") == true) goto L13;
        if (r104.contains("meizu") == false) goto L14;
    L13:
        r100 = true;
    L14:
        r102 = r102 + 1;
    L16:
        return !r100;
    }

    @Override // zv4.g, zv4.d
    public final View[] c() {
        this.f221636y = new ImageView(getContext());
        this.f221637z = new ImageView(getContext());
        View.OnTouchListener r100 = new w(this);
        this.f221636y.setOnTouchListener(r100);
        this.f221637z.setOnTouchListener(r100);
        o(false);
        return new View[]{this.f221636y, this.f221637z};
    }

    public final WebView i() {
        return (WebView) this.f221622k.getHostView();
    }

    public final void p() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        tt5.a.h("SelectionOld", "api lower than 23 can not startActionMode");
        return;
    L5:
        i().startActionMode(this.D, 1);
        HashMap r100 = new HashMap();
        r100.put("enable_intent_menu_item", Boolean.valueOf(this.f221630s));
        this.H.v("start_action_mode", r100);
    }

    public final void q() {
        Point r100 = this.E;
        int r101 = r100.x;
        int r102 = r100.y;
        Point r103 = this.F;
        int r104 = r103.x;
        int r105 = r103.y;
        int r106 = (int) (r101 - (this.f221636y.getWidth() * 0.75f));
        int r107 = (int) (r104 - (this.f221636y.getWidth() * 0.25f));
        this.f221636y.setX(r106);
        this.f221636y.setY(r102);
        this.f221637z.setX(r107);
        this.f221637z.setY(r105);
        o(true);
    }

    private Context getContext() {
        return i().getContext();
    }

    @Override // zv4.g, zv4.d
    public final void d() {
        j();
        this.C = null;
        WebView r100 = i();
        r100.removeCallbacks(this.M);
        r100.removeCallbacks(this.L);
    }

    @Override // zv4.g, zv4.d
    public final void onDetachedFromWindow() {
        j();
        this.C = null;
        WebView r100 = i();
        r100.removeCallbacks(this.M);
        r100.removeCallbacks(this.L);
    }

    public static /* synthetic */ Context f(e0 r100) {
        return r100.getContext();
    }

    public static void l(String... r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.append(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        tt5.a.h("SelectionOld", r101.toString());
    }

    @Override // zv4.g, zv4.d
    public final void b(zv4.c r100) {
        this.f221622k = r100;
        this.f221613b = new g0();
        int r101 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f221626o = r101;
        this.f221627p = r101 * r101;
        this.D = new e(this);
        this.f221635x = new GestureDetector(getContext(), new c(this));
    }

    public final void k(boolean r100) {
        l(new String[]{"jsDragFinish"});
        this.R = false;
        String r101 = String.format("javascript:window.lark.biz.selection.dragFinish", new Object[0]);
        JSONObject r102 = new JSONObject();
        r102.put2("isDragCaret", Boolean.valueOf(r100));
        g(r101, r102, null);
    }

    public final void o(boolean r110) {
        int r100 = 0;
        if (this.f221621j == false) goto L27;
        this.f221613b.getClass();
        Context r101 = getContext();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        WindowManager r104 = (WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L19
        Class r105 = g0.a();     // Catch: Throwable -> L19
        Object r106 = r105.getMethod("getInstance", new Class[0]).invoke(null, null);     // Catch: Throwable -> L19
        Method r107 = r105.getMethod("getViewRootNames", new Class[0]);     // Catch: Throwable -> L19
        Method r108 = r105.getMethod("getRootView", new Class[]{String.class});     // Catch: Throwable -> L19
        String[] r109 = (String[]) r107.invoke(r106, null);     // Catch: Throwable -> L19
        if (r109 != null) goto L8;
        tt5.a.h("SelectionOldVH", "rootViewNames == null");     // Catch: Throwable -> L19
        goto L27
    L8:
        int r111 = r109.length;     // Catch: Throwable -> L19
        int r112 = 0;
    L9:
        if (r112 >= r111) goto L22;
        String r113 = r109[r112];     // Catch: Throwable -> L19
        tt5.a.b("SelectionOldVH", "viewName " + r113);     // Catch: Throwable -> L19
        if (r113.startsWith("PopupWindow") == false) goto L18;
        View r114 = (View) r108.invoke(r106, new Object[]{r113});     // Catch: Throwable -> L19
        if ((r114 instanceof ViewGroup) == false) goto L18;
        View r115 = g0.b((ViewGroup) r114);     // Catch: Throwable -> L19
        if (r115 == null) goto L18;
        r102.add((ViewGroup) r114);     // Catch: Throwable -> L19
        r103.add(r115);     // Catch: Throwable -> L19
    L18:
        r112 = r112 + 1;
    L22:
        if (r102.size() != 2) goto L27;
        Iterator r116 = r103.iterator();
    L25:
        if (r116.hasNext() == false) goto L27;
        ((View) r116.next()).setAlpha(0.0f);
    L19:
        th = move-exception;
        tt5.a.e("SelectionOldVH", "SelectionNewVH tryFindPopupViews ", th, false);
    L27:
        if (r110 == true) goto L30;
        r100 = 4;
    L30:
        this.f221636y.setVisibility(r100);
        if (this.f221636y.getDrawable() != null) goto L33;
        this.f221636y.setImageDrawable(zv4.e.a(getContext(), zv4.e.f573692a, R.drawable.text_select_handle_left_material));
    L33:
        this.f221637z.setVisibility(r100);
        if (this.f221637z.getDrawable() != null) goto L44;
        this.f221637z.setImageDrawable(zv4.e.a(getContext(), zv4.e.f573693b, R.drawable.text_select_handle_right_material));
        return;
    }

    @Override // zv4.d
    public final boolean onTouchEvent(MotionEvent r110) {
        if (r110 != this.f221611J) goto L5;
        return false;
    L5:
        int r100 = r110.getAction();
        int r101 = Math.round(r110.getX());
        int r102 = Math.round(r110.getY());
        WebView r103 = i();
        if (r100 != 0) goto L16;
        this.f221623l = r101;
        this.f221624m = r102;
        this.f221625n = r103.getScrollY();
        this.f221629r = false;
        r103.getLocationInWindow(this.P);
        MotionEvent r104 = this.f221611J;
        if (r104 == null) goto L11;
        r104.recycle();
        this.f221611J = null;
    L11:
        if (this.f221616e == false) goto L36;
        if (this.f221618g == false) goto L36;
        MotionEvent r105 = MotionEvent.obtain(r110);
        this.f221611J = r105;
        r105.setAction(3);
        r103.removeCallbacks(this.L);
        r103.postDelayed(this.L, V);
    L36:
        if (this.f221628q == false) goto L39;
        o(false);
        r(r101, r102, false);
    L39:
        if (this.f221628q == true) goto L41;
    L43:
        boolean r106 = false;
    L44:
        if (r106 == false) goto L51;
        if (r100 == 1) goto L49;
        if (r100 == 3) goto L49;
        boolean r107 = false;
    L50:
        n(r102, r107, false);
    L49:
        r107 = true;
    L51:
        if (r100 == 1) goto L53;
        if (r100 == 3) goto L53;
    L60:
        if (this.f221635x.onTouchEvent(r110) == true) goto L62;
        if (r106 == true) goto L62;
        return false;
    L62:
        return true;
    L53:
        MotionEvent r108 = this.f221611J;
        if (r108 == null) goto L57;
        r108.recycle();
        this.f221611J = null;
    L57:
        if (this.f221628q == false) goto L60;
        k(false);
        this.f221628q = false;
        goto L60
    L41:
        if (this.f221629r == false) goto L43;
        r106 = true;
        goto L44
    L16:
        if (r100 != 2) goto L36;
        int r109 = r101 - this.f221623l;
        int r111 = r102 - this.f221624m;
        if (((r109 * r109) + (r111 * r111)) <= this.f221627p) goto L21;
        r103.removeCallbacks(this.L);
    L21:
        if (this.f221616e == false) goto L36;
        if (this.f221617f == false) goto L36;
        if (this.f221628q == true) goto L36;
        if (r103.getScrollY() != this.f221625n) goto L36;
        if (Math.abs(r101 - this.f221623l) <= this.f221626o) goto L36;
        if (Math.abs(r101 - this.f221623l) <= Math.abs(r102 - this.f221624m)) goto L36;
        if (Math.abs(r102 - this.f221624m) >= this.f221626o) goto L36;
        this.S.setEmpty();
        j();
        l(new String[]{"jsClearSelectionExcludeCursor"});
        g("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
        r(this.f221623l, this.f221624m, true);
        this.f221628q = true;
        goto L36
    }

    @Override // zv4.g, zv4.d
    public final ActionMode.Callback prepareActionMode(ActionMode.Callback r110) {
        if (this.f221616e == true) goto L6;
        return null;
    L6:
        if (r110 != this.D) goto L9;
        l(new String[]{"prepare action mode from custom"});
        return this.D;
    L9:
        ArrayList r111 = new ArrayList();
        WindowManager r100 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L26
        Class r101 = e();     // Catch: Throwable -> L26
        Object r102 = r101.getMethod("getInstance", new Class[0]).invoke(null, null);     // Catch: Throwable -> L26
        Method r103 = r101.getMethod("getViewRootNames", new Class[0]);     // Catch: Throwable -> L26
        Method r104 = r101.getMethod("getRootView", new Class[]{String.class});     // Catch: Throwable -> L26
        String[] r105 = (String[]) r103.invoke(r102, null);     // Catch: Throwable -> L26
        if (r105 == null) goto L28;
        int r106 = r105.length;     // Catch: Throwable -> L26
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L28;
        String r112 = r105[r107];     // Catch: Throwable -> L26
        if (r112.startsWith("PopupWindow") == false) goto L25;
        View r113 = (View) r104.invoke(r102, new Object[]{r112});     // Catch: Throwable -> L26
        if ((r113 instanceof ViewGroup) == false) goto L25;
        ViewGroup r114 = (ViewGroup) r113;     // Catch: Throwable -> L26
        if (r114.getChildCount() != 1) goto L25;
        if ("PopupTouchHandleDrawable".equals(r114.getChildAt(0).getClass().getSimpleName()) == false) goto L25;
        r111.add(r114);     // Catch: Throwable -> L26
    L25:
        r107 = r107 + 1;
    L28:
        tt5.a.k("SelectionOld", "prepare action mode from sys,handle size:" + r111.size());
        if (r111.size() != 1) goto L32;
        z r115 = new z(this);
        l(new String[]{"jsGetCursorBounds"});
        g("javascript:window.lark.biz.selection.getCursorBounds", null, new b0(this, r115));
    L38:
        return this.D;
    L32:
        if (r111.size() != 2) goto L38;
        WindowManager r108 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Iterator r116 = r111.iterator();
    L35:
        if (r116.hasNext() == false) goto L38;
        ((ViewGroup) r116.next()).setVisibility(4);
    L26:
        th = move-exception;
        tt5.a.f("SelectionOld", th, false);
        goto L28
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.document.selection.y] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.document.selection.x] */
    public e0(com.bytedance.ee.bear.contract.d r100, DocumentPluginHost r101) {
        this.f221617f = true;
        this.f221618g = true;
        this.f221619h = true;
        this.f221620i = true;
        this.f221621j = false;
        this.f221630s = false;
        this.f221631t = com.bytedance.ee.util.ui.n.d(5);
        this.f221632u = new x(this);
        this.f221633v = 0.2f;
        this.f221634w = 0.8f;
        this.B = new int[2];
        this.E = new Point();
        this.F = new Point();
        this.K = false;
        this.L = new a(this);
        this.M = new y(this);
        this.P = new int[2];
        this.S = new Rect();
        this.U = new b(this);
        this.H = r100;
        this.I = r101;
        this.f221614c = new l();
        this.f221615d = new com.bytedance.ee.bear.document.selection.d();
    }

    public final void m(org.json.JSONObject r100, Rect r101) throws JSONException {
        r101.set(com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "left")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "top")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "right")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r100, "bottom")));
        int r102 = r101.right;
        int r103 = r101.left;
        if ((r102 - r103) >= 10) goto L6;
        r101.right = r103 + 10;
        return;
    }

    public final void g(String r100, JSONObject r101, ValueCallback<String> r102) {
        ap5.a.a(i(), r100, r101, r102);
    }

    public final void n(int r100, boolean r101, boolean r102) {
        WebView r103 = i();
        if (r103 != null) goto L5;
        return;
    L5:
        l r104 = this.f221614c;
        float r105 = this.f221633v;
        float r106 = this.f221634w;
        r104.getClass();
        int r107 = l.a(r103, r100, r105, r106);
        if (r107 == 0) goto L13;
        if (r101 == true) goto L13;
        if (this.Q == null) goto L12;
        return;
    L12:
        com.bytedance.ee.bear.document.selection.d.a r108 = new com.bytedance.ee.bear.document.selection.d.a(com.bytedance.ee.util.ui.n.d(6), r107, r102);
        com.bytedance.ee.bear.document.selection.d r109 = this.f221615d;
        v r110 = new v(this);
        r109.getClass();
        ValueAnimator r111 = com.bytedance.ee.bear.document.selection.d.a(r103, r108, r110);
        this.Q = r111;
        r111.addListener(new d(this));
        this.Q.start();
        return;
    L13:
        ValueAnimator r112 = this.Q;
        if (r112 == null) goto L18;
        r112.cancel();
        return;
    }

    public final void r(int r100, int r101, boolean r102) {
        l(new String[]{"jsUpdateSelection start?" + r102});
        this.R = true;
        JSONObject r103 = new JSONObject();
        r103.put2("x", Float.valueOf(com.bytedance.ee.util.ui.n.E(r100)));
        r103.put2("y", Float.valueOf(com.bytedance.ee.util.ui.n.E(r101)));
        x r104 = null;
        if (r102 == false) goto L5;
        String r105 = String.format(Locale.US, "javascript:window.lark.biz.selection.dragSelectionStart", new Object[0]);
    L8:
        g(r105, r103, r104);
        ActionMode r106 = this.C;
        if (r106 == null) goto L12;
        r106.hide(300);
        this.C.invalidateContentRect();
        return;
    L12:
        return;
    L5:
        r105 = String.format(Locale.US, "javascript:window.lark.biz.selection.dragSelectionEnd", new Object[0]);
        if (this.f221628q == false) goto L8;
        r104 = this.f221632u;
        goto L8
    }

    @Override // zv4.f
    public final void onScrollChange(View r100, int r101, int r102, int r103, int r104) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ActionMode r105 = this.C;
        if (r105 != null) goto L7;
        return;
    L7:
        if (r105.getType() != 1) goto L12;
        this.C.hide(500);
        com.bytedance.ee.util.ui.j.e(this.U);
        com.bytedance.ee.util.ui.j.d(this.U, 200);
        return;
    L12:
        return;
    }
}
