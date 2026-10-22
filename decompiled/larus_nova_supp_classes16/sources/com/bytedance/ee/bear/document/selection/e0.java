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
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public MotionEvent J;
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
    public ActionMode.Callback a;
    public g0 b;
    public final l c;
    public final com.bytedance.ee.bear.document.selection.d d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public zv4.c k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final int t;
    public final x u;
    public final float v;
    public float w;
    public GestureDetector x;
    public ImageView y;
    public ImageView z;

    public class a implements Runnable {
        public final /* synthetic */ e0 a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.J == null) goto L9;
            e0.l(new String[]{"cancelDefaultLongPress"});     // Catch: Throwable -> L6
            this.a.i().onTouchEvent(this.a.J);     // Catch: Throwable -> L6
            return;
        }

        public a(e0 r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ e0 a;

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
            ActionMode r0 = this.a.C;     // Catch: Throwable -> L8
            if (r0 == null) goto L15;
            r0.invalidateContentRect();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }

        public b(e0 r1) {
            this.a = r1;
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ e0 a;

        public c(e0 r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r4) {
            e0 r5 = this.a;
            if (r5.e == true) goto L5;
            return false;
        L5:
            if (r5.i == false) goto L11;
            e0.l(new String[]{"onDoubleTap"});
            this.a.S.setEmpty();
            this.a.j();
            this.a.i().postDelayed(new f0(this), 100);
            return false;
        L11:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r5) {
            e0 r6 = this.a;
            if (r6.e == true) goto L5;
            return;
        L5:
            if (r6.g == false) goto L10;
            e0.l(new String[]{"onLongPress"});
            this.a.S.setEmpty();
            this.a.j();
            e0 r7 = this.a;
            r7.getClass();
            e0.l(new String[]{"jsLongPressSelect"});
            String r0 = String.format(Locale.US, "javascript:window.lark.biz.selection.longPressSelect", new Object[0]);
            JSONObject r1 = new JSONObject();
            r1.put("x", Float.valueOf(com.bytedance.ee.util.ui.n.E(r7.l)));
            r1.put("y", Float.valueOf(com.bytedance.ee.util.ui.n.E(r7.m)));
            r7.g(r0, r1, null);
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r7) {
            e0 r8 = this.a;
            if (r8.e == true) goto L5;
            return false;
        L5:
            if (r8.h == false) goto L33;
            e0.l(new String[]{"onSingleTapUp"});
            e0 r9 = this.a;
            Point r0 = r9.F;
            int r2 = r0.y;
            Point r3 = r9.E;
            int r4 = r3.y;
            if (r2 > r4) goto L13;
            if (r2 == r4) goto L12;
        L14:
            boolean r1 = false;
        L15:
            if (r1 == false) goto L17;
            r9.getClass();
            e0.l(new String[]{"jsClearSelectionExcludeCursor"});
            r9.g("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
        L17:
            ActionMode r10 = this.a.C;
            if (r10 == null) goto L20;
            r10.finish();
        L20:
            if (r1 == false) goto L31;
            e0 r11 = this.a;
            r11.y.getLocationInWindow(r11.B);
            int[] r5 = r11.B;
            int r6 = r5[1];
            r11.z.getLocationInWindow(r5);
            int r12 = r11.B[1];
            if (r6 > 0) goto L24;
        L26:
            boolean r13 = false;
        L27:
            if (r13 == false) goto L32;
            return true;
        L32:
            return false;
        L24:
            if (r12 >= r11.i().getHeight()) goto L26;
            r13 = true;
            goto L27
        L31:
            return false;
        L12:
            if (r0.x <= r3.x) goto L14;
        L13:
            r1 = true;
            goto L15
        L33:
            return false;
        }
    }

    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ e0 a;

        public d(e0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.a.Q = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.Q = null;
        }
    }

    public class e extends ActionMode.Callback2 {
        public final LinkedHashMap<String, String> a;
        public final LinkedHashMap<String, String> b;
        public final com.bytedance.ee.bear.document.selection.c c;
        public final /* synthetic */ e0 d;

        public e(e0 r3) {
            this.d = r3;
            this.a = new LinkedHashMap();
            this.b = new LinkedHashMap();
            this.c = new com.bytedance.ee.bear.document.selection.c(r3.i(), "SelectionOld");
        }

        public final void a(String r24) throws JSONException {
            this.b.clear();
            org.json.JSONObject r2 = new org.json.JSONObject(r24);
            String r0 = JSONObjectProtectorUtils.getString(r2, "srcObjToken");     // Catch: Exception -> L22
            int r6 = JSONObjectProtectorUtils.getInt(r2, "srcObjType");     // Catch: Exception -> L22
            String r13 = JSONObjectProtectorUtils.getString(r2, "content");     // Catch: Exception -> L22
            UniBaseEntity r14 = new UniBaseEntity(r0, sbb.e.d(r6), BizDomain.FileBizDomainCCM, null, null, null);     // Catch: Exception -> L22
            DocumentPluginHost r7 = this.d.I;     // Catch: Exception -> L22
            if (r7 != null) goto L6;
        L12:
            UserPermissionEntity r8 = null;
        L13:
            boolean r1 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r14, "CONTENT_COPY"), r8).getAllow();     // Catch: Exception -> L22
            e0 r9 = this.d;     // Catch: Exception -> L22
            if (r1 == false) goto L16;
        L19:
            boolean r3 = true;
        L20:
            r9.K = r3;     // Catch: Exception -> L22
        L24:
            JSONArray r4 = JSONObjectProtectorUtils.getJSONArray(r2, "items");
            int r5 = 0;
        L26:
            if (r5 >= r4.length()) goto L29;
            org.json.JSONObject r10 = JSONArrayProtectorUtils.getJSONObject(r4, r5);
            this.b.put(JSONObjectProtectorUtils.getString(r10, "id"), JSONObjectProtectorUtils.getString(r10, "text"));
            r5 = r5 + 1;
            goto L26
        L29:
            if (this.b.containsKey("PASTE") == false) goto L55;
            ClipboardManager r11 = (ClipboardManager) e0.f(this.d).getSystemService(ClipboardManager.class);
            if (r11 == null) goto L52;
            ArrayList r16 = new ArrayList();
            Object[] r17 = new Object[0];
            f06.b r18 = new f06.b();
            g06.a r12 = (g06.a) ApiHookConfig.b.get(101805);
            if (r12 == null) goto L35;
            f06.a[] r19 = r12.i;
        L36:
            f06.a[] r110 = r19;
            int r111 = r110.length;
            int r112 = 0;
        L38:
            if (r112 >= r111) goto L45;
            f06.a r113 = r110[r112];
            int r20 = r112;
            int r21 = r111;
            f06.a[] r22 = r110;
            f06.d r23 = r113.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r11, r17, "boolean", r18);     // Catch: Exception -> L57
            if (r23.a == true) goto L47;
            r16.add(r113);     // Catch: Exception -> L57
        L47:
            if (r23.a == false) goto L49;
            boolean r26 = ((Boolean) r23.b).booleanValue();
        L50:
            if (r26 == true) goto L52;
            boolean r27 = true;
        L53:
            if (r27 == false) goto L55;
            this.b.remove("PASTE");
            goto L55
        L49:
            r26 = r11.hasPrimaryClip();
        L44:
            r112 = r20 + 1;
            r111 = r21;
            r110 = r22;
            goto L38
        L45:
            r23 = new f06.d(false, null);
            goto L47
        L35:
            r19 = ApiHookConfig.d;
        L52:
            r27 = false;
        L55:
            this.a.clear();
            this.a.putAll(this.b);
            return;
        L16:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).w(r13) == false) goto L19;
            r3 = false;
            goto L20
        L6:
            if (r7.a() == null) goto L12;
            if (this.d.I.a().getDocumentInfoData() == null) goto L12;
            if (this.d.I.a().getDocumentInfoData().getDocPermissionByToken(r0) == null) goto L12;
            r8 = new UserPermissionEntity(this.d.I.a().getDocumentInfoData().getDocPermissionByToken(r0), null);     // Catch: Exception -> L22
        L22:
            e = move-exception;
            tt5.a.d("SelectionOld", "permission validate error " + e.getMessage());
            goto L24
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            ActionMode.Callback r0 = this.d.a;
            if (r0 == null) goto L6;
            r0.onDestroyActionMode(r2);
            return;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r7, MenuItem r8) {
            ActionMode.Callback r0 = this.d.a;
            if (r0 == null) goto L5;
            r0.onActionItemClicked(r7, r8);
        L5:
            int r1 = r8.getGroupId();
            boolean r2 = false;
            if (r1 != 6767770) goto L8;
            CharSequence r9 = r8.getTitle();
            Iterator<Map.Entry<String, String>> r3 = this.a.entrySet().iterator();
        L15:
            if (r3.hasNext() == false) goto L22;
            Map.Entry<String, String> r4 = r3.next();
            if (r9.equals(r4.getValue()) == false) goto L15;
            String r10 = r4.getKey();
            e0 r5 = this.d;
            r5.getClass();
            e0.l(new String[]{"jsOnActionModeMenuItemClick:" + r10});
            String r6 = String.format(Locale.US, "javascript:window.lark.biz.navigation.onContextMenuClick", new Object[0]);
            JSONObject r11 = new JSONObject();
            r11.put("id", r10);
            r5.g(r6, r11, null);
            HashMap r12 = new HashMap();
            r12.put("menu_id", r10);
            r12.put("enable_intent_menu_item", Boolean.valueOf(r5.s));
            r5.H.v("js_menu_item_clicked", r12);
            com.bytedance.ee.bear.document.plugin.selection.d r13 = r5.T;
            if (r13 == null) goto L21;
            r13.a(r10);
        L21:
            r2 = true;
        L22:
            r7.finish();
            return r2;
        L8:
            if (r1 != 6767772) goto L22;
            e0 r14 = this.d;
            if (r14.s == false) goto L22;
            r14.H.v("intent_menu_item_clicked", new HashMap());
            r2 = this.c.c(r8).booleanValue();
            goto L22
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r4, Menu r5) {
            ActionMode.Callback r0 = this.d.a;
            if (r0 == null) goto L5;
            r0.onCreateActionMode(r4, r5);
        L5:
            e0 r1 = this.d;
            if (r1.s == false) goto L8;
            this.c.d(r5, r1.H, r4, r1.K);
        L8:
            this.d.C = r4;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r7, Menu r8) {
            ActionMode.Callback r0 = this.d.a;
            if (r0 == null) goto L5;
            r0.onPrepareActionMode(r7, r8);
        L5:
            l r1 = this.d.c;
            LinkedHashMap<String, String> r2 = this.a;
            r1.getClass();
            boolean r3 = false;
            if (l.b(r8, r2, false) == false) goto L13;
            r8.removeGroup(6767770);
            this.d.getClass();
            e0.l(new String[]{"menu updated"});
            Iterator<String> r4 = this.a.values().iterator();
            int r5 = 0;
        L9:
            if (r4.hasNext() == false) goto L11;
            r8.add(6767770, 0, r5, r4.next());
            r5 = r5 + 1;
            goto L9
        L11:
            r3 = true;
        L13:
            if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == false) goto L15;
            com.bytedance.ee.bear.document.selection.c r6 = this.c;
            e0 r9 = this.d;
            r6.d(r8, r9.H, r7, r9.K);
        L15:
            return r3;
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r5, View r6, Rect r7) {
            if (this.d.S.isEmpty() == true) goto L5;
            r7.set(this.d.S);
            r7.offset(0, -this.d.i().getScrollY());
            return;
        L5:
            e0 r8 = this.d;
            Point r0 = r8.E;
            int r1 = r0.x;
            int r2 = r0.y;
            Point r9 = r8.F;
            int r3 = r9.x;
            int r10 = r9.y;
            if (r1 <= r3) goto L8;
            r3 = r1;
            r1 = r3;
        L8:
            if (r2 <= r10) goto L10;
            r2 = r10;
            r10 = r2;
        L10:
            r7.set(r1, r2, r3, r10);
            r7.offset(0, -this.d.i().getScrollY());
            int r11 = r7.top;
            e0 r12 = this.d;
            r7.top = r11 - r12.G;
            r7.bottom += r12.z.getHeight();
        }
    }

    public final void j() {
        o(false);
        ActionMode r1 = this.C;
        if (r1 == null) goto L5;
        r1.finish();
    L5:
        this.E.set(0, 0);
        this.F.set(0, 0);
    }

    static {
        V = ViewConfiguration.getLongPressTimeout() - 100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e() throws ClassNotFoundException {
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

    public static boolean h() {
        boolean r2 = false;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        String[] r1 = {Build.BOARD, Build.PRODUCT, Build.DISPLAY};
        int r3 = 0;
    L6:
        if (r3 >= 3) goto L16;
        String r5 = r1[r3];
        if (TextUtils.isEmpty(r5) == true) goto L14;
        String r6 = r5.toLowerCase();
        if (r6.contains("flyme") == true) goto L13;
        if (r6.contains("meizu") == false) goto L14;
    L13:
        r2 = true;
    L14:
        r3 = r3 + 1;
    L16:
        return !r2;
    }

    @Override // zv4.g, zv4.d
    public final View[] c() {
        this.y = new ImageView(getContext());
        this.z = new ImageView(getContext());
        View.OnTouchListener r0 = new w(this);
        this.y.setOnTouchListener(r0);
        this.z.setOnTouchListener(r0);
        o(false);
        return new View[]{this.y, this.z};
    }

    public final WebView i() {
        return (WebView) this.k.getHostView();
    }

    public final void p() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        tt5.a.h("SelectionOld", "api lower than 23 can not startActionMode");
        return;
    L5:
        i().startActionMode(this.D, 1);
        HashMap r0 = new HashMap();
        r0.put("enable_intent_menu_item", Boolean.valueOf(this.s));
        this.H.v("start_action_mode", r0);
    }

    public final void q() {
        Point r0 = this.E;
        int r1 = r0.x;
        int r2 = r0.y;
        Point r3 = this.F;
        int r4 = r3.x;
        int r5 = r3.y;
        int r6 = (int) (r1 - (this.y.getWidth() * 0.75f));
        int r7 = (int) (r4 - (this.y.getWidth() * 0.25f));
        this.y.setX(r6);
        this.y.setY(r2);
        this.z.setX(r7);
        this.z.setY(r5);
        o(true);
    }

    private Context getContext() {
        return i().getContext();
    }

    @Override // zv4.g, zv4.d
    public final void d() {
        j();
        this.C = null;
        WebView r0 = i();
        r0.removeCallbacks(this.M);
        r0.removeCallbacks(this.L);
    }

    @Override // zv4.g, zv4.d
    public final void onDetachedFromWindow() {
        j();
        this.C = null;
        WebView r0 = i();
        r0.removeCallbacks(this.M);
        r0.removeCallbacks(this.L);
    }

    public static /* synthetic */ Context f(e0 r0) {
        return r0.getContext();
    }

    public static void l(String... r4) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.append(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        tt5.a.h("SelectionOld", r0.toString());
    }

    @Override // zv4.g, zv4.d
    public final void b(zv4.c r3) {
        this.k = r3;
        this.b = new g0();
        int r4 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.o = r4;
        this.p = r4 * r4;
        this.D = new e(this);
        this.x = new GestureDetector(getContext(), new c(this));
    }

    public final void k(boolean r4) {
        l(new String[]{"jsDragFinish"});
        this.R = false;
        String r0 = String.format("javascript:window.lark.biz.selection.dragFinish", new Object[0]);
        JSONObject r1 = new JSONObject();
        r1.put("isDragCaret", Boolean.valueOf(r4));
        g(r0, r1, null);
    }

    public final void o(boolean r14) {
        int r1 = 0;
        if (this.j == false) goto L27;
        this.b.getClass();
        Context r0 = getContext();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        WindowManager r2 = (WindowManager) r0.getSystemService("window");     // Catch: Throwable -> L19
        Class r5 = g0.a();     // Catch: Throwable -> L19
        Object r6 = r5.getMethod("getInstance", new Class[0]).invoke(null, null);     // Catch: Throwable -> L19
        Method r7 = r5.getMethod("getViewRootNames", new Class[0]);     // Catch: Throwable -> L19
        Method r8 = r5.getMethod("getRootView", new Class[]{String.class});     // Catch: Throwable -> L19
        String[] r9 = (String[]) r7.invoke(r6, null);     // Catch: Throwable -> L19
        if (r9 != null) goto L8;
        tt5.a.h("SelectionOldVH", "rootViewNames == null");     // Catch: Throwable -> L19
        goto L27
    L8:
        int r10 = r9.length;     // Catch: Throwable -> L19
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L22;
        String r12 = r9[r11];     // Catch: Throwable -> L19
        tt5.a.b("SelectionOldVH", "viewName " + r12);     // Catch: Throwable -> L19
        if (r12.startsWith("PopupWindow") == false) goto L18;
        View r13 = (View) r8.invoke(r6, new Object[]{r12});     // Catch: Throwable -> L19
        if ((r13 instanceof ViewGroup) == false) goto L18;
        View r16 = g0.b((ViewGroup) r13);     // Catch: Throwable -> L19
        if (r16 == null) goto L18;
        r3.add((ViewGroup) r13);     // Catch: Throwable -> L19
        r4.add(r16);     // Catch: Throwable -> L19
    L18:
        r11 = r11 + 1;
    L22:
        if (r3.size() != 2) goto L27;
        Iterator r17 = r4.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        ((View) r17.next()).setAlpha(0.0f);
    L19:
        th = move-exception;
        tt5.a.e("SelectionOldVH", "SelectionNewVH tryFindPopupViews ", th, false);
    L27:
        if (r14 == true) goto L30;
        r1 = 4;
    L30:
        this.y.setVisibility(r1);
        if (this.y.getDrawable() != null) goto L33;
        this.y.setImageDrawable(zv4.e.a(getContext(), zv4.e.a, 2131248388));
    L33:
        this.z.setVisibility(r1);
        if (this.z.getDrawable() != null) goto L44;
        this.z.setImageDrawable(zv4.e.a(getContext(), zv4.e.b, 2131248392));
        return;
    }

    @Override // zv4.d
    public final boolean onTouchEvent(MotionEvent r12) {
        if (r12 != this.J) goto L5;
        return false;
    L5:
        int r0 = r12.getAction();
        int r2 = Math.round(r12.getX());
        int r3 = Math.round(r12.getY());
        WebView r4 = i();
        if (r0 != 0) goto L16;
        this.l = r2;
        this.m = r3;
        this.n = r4.getScrollY();
        this.r = false;
        r4.getLocationInWindow(this.P);
        MotionEvent r8 = this.J;
        if (r8 == null) goto L11;
        r8.recycle();
        this.J = null;
    L11:
        if (this.e == false) goto L36;
        if (this.g == false) goto L36;
        MotionEvent r9 = MotionEvent.obtain(r12);
        this.J = r9;
        r9.setAction(3);
        r4.removeCallbacks(this.L);
        r4.postDelayed(this.L, V);
    L36:
        if (this.q == false) goto L39;
        o(false);
        r(r2, r3, false);
    L39:
        if (this.q == true) goto L41;
    L43:
        boolean r5 = false;
    L44:
        if (r5 == false) goto L51;
        if (r0 == 1) goto L49;
        if (r0 == 3) goto L49;
        boolean r6 = false;
    L50:
        n(r3, r6, false);
    L49:
        r6 = true;
    L51:
        if (r0 == 1) goto L53;
        if (r0 == 3) goto L53;
    L60:
        if (this.x.onTouchEvent(r12) == true) goto L62;
        if (r5 == true) goto L62;
        return false;
    L62:
        return true;
    L53:
        MotionEvent r1 = this.J;
        if (r1 == null) goto L57;
        r1.recycle();
        this.J = null;
    L57:
        if (this.q == false) goto L60;
        k(false);
        this.q = false;
        goto L60
    L41:
        if (this.r == false) goto L43;
        r5 = true;
        goto L44
    L16:
        if (r0 != 2) goto L36;
        int r10 = r2 - this.l;
        int r11 = r3 - this.m;
        if (((r10 * r10) + (r11 * r11)) <= this.p) goto L21;
        r4.removeCallbacks(this.L);
    L21:
        if (this.e == false) goto L36;
        if (this.f == false) goto L36;
        if (this.q == true) goto L36;
        if (r4.getScrollY() != this.n) goto L36;
        if (Math.abs(r2 - this.l) <= this.o) goto L36;
        if (Math.abs(r2 - this.l) <= Math.abs(r3 - this.m)) goto L36;
        if (Math.abs(r3 - this.m) >= this.o) goto L36;
        this.S.setEmpty();
        j();
        l(new String[]{"jsClearSelectionExcludeCursor"});
        g("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
        r(this.l, this.m, true);
        this.q = true;
        goto L36
    }

    @Override // zv4.g, zv4.d
    public final ActionMode.Callback prepareActionMode(ActionMode.Callback r14) {
        if (this.e == true) goto L6;
        return null;
    L6:
        if (r14 != this.D) goto L9;
        l(new String[]{"prepare action mode from custom"});
        return this.D;
    L9:
        ArrayList r16 = new ArrayList();
        WindowManager r5 = (WindowManager) getContext().getSystemService("window");     // Catch: Throwable -> L26
        Class r6 = e();     // Catch: Throwable -> L26
        Object r7 = r6.getMethod("getInstance", new Class[0]).invoke(null, null);     // Catch: Throwable -> L26
        Method r8 = r6.getMethod("getViewRootNames", new Class[0]);     // Catch: Throwable -> L26
        Method r9 = r6.getMethod("getRootView", new Class[]{String.class});     // Catch: Throwable -> L26
        String[] r10 = (String[]) r8.invoke(r7, null);     // Catch: Throwable -> L26
        if (r10 == null) goto L28;
        int r11 = r10.length;     // Catch: Throwable -> L26
        int r12 = 0;
    L14:
        if (r12 >= r11) goto L28;
        String r13 = r10[r12];     // Catch: Throwable -> L26
        if (r13.startsWith("PopupWindow") == false) goto L25;
        View r17 = (View) r9.invoke(r7, new Object[]{r13});     // Catch: Throwable -> L26
        if ((r17 instanceof ViewGroup) == false) goto L25;
        ViewGroup r18 = (ViewGroup) r17;     // Catch: Throwable -> L26
        if (r18.getChildCount() != 1) goto L25;
        if ("PopupTouchHandleDrawable".equals(r18.getChildAt(0).getClass().getSimpleName()) == false) goto L25;
        r16.add(r18);     // Catch: Throwable -> L26
    L25:
        r12 = r12 + 1;
    L28:
        tt5.a.k("SelectionOld", "prepare action mode from sys,handle size:" + r16.size());
        if (r16.size() != 1) goto L32;
        z r19 = new z(this);
        l(new String[]{"jsGetCursorBounds"});
        g("javascript:window.lark.biz.selection.getCursorBounds", null, new b0(this, r19));
    L38:
        return this.D;
    L32:
        if (r16.size() != 2) goto L38;
        WindowManager r0 = (WindowManager) getContext().getSystemService("window");
        Iterator r110 = r16.iterator();
    L35:
        if (r110.hasNext() == false) goto L38;
        ((ViewGroup) r110.next()).setVisibility(4);
    L26:
        th = move-exception;
        tt5.a.f("SelectionOld", th, false);
        goto L28
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.document.selection.y] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.document.selection.x] */
    public e0(com.bytedance.ee.bear.contract.d r4, DocumentPluginHost r5) {
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.s = false;
        this.t = com.bytedance.ee.util.ui.n.d(5);
        this.u = new x(this);
        this.v = 0.2f;
        this.w = 0.8f;
        this.B = new int[2];
        this.E = new Point();
        this.F = new Point();
        this.K = false;
        this.L = new a(this);
        this.M = new y(this);
        this.P = new int[2];
        this.S = new Rect();
        this.U = new b(this);
        this.H = r4;
        this.I = r5;
        this.c = new l();
        this.d = new com.bytedance.ee.bear.document.selection.d();
    }

    public final void m(org.json.JSONObject r6, Rect r7) throws JSONException {
        r7.set(com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, CustomHeaderConfig.TitleConfig.Position.LEFT)), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "top")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "right")), com.bytedance.ee.util.ui.n.c((float) JSONObjectProtectorUtils.getDouble(r6, "bottom")));
        int r8 = r7.right;
        int r0 = r7.left;
        if ((r8 - r0) >= 10) goto L6;
        r7.right = r0 + 10;
        return;
    }

    public final void g(String r2, JSONObject r3, ValueCallback<String> r4) {
        ap5.a.a(i(), r2, r3, r4);
    }

    public final void n(int r5, boolean r6, boolean r7) {
        WebView r0 = i();
        if (r0 != null) goto L5;
        return;
    L5:
        l r1 = this.c;
        float r2 = this.v;
        float r3 = this.w;
        r1.getClass();
        int r8 = l.a(r0, r5, r2, r3);
        if (r8 == 0) goto L13;
        if (r6 == true) goto L13;
        if (this.Q == null) goto L12;
        return;
    L12:
        com.bytedance.ee.bear.document.selection.d.a r4 = new com.bytedance.ee.bear.document.selection.d.a(com.bytedance.ee.util.ui.n.d(6), r8, r7);
        com.bytedance.ee.bear.document.selection.d r9 = this.d;
        v r10 = new v(this);
        r9.getClass();
        ValueAnimator r11 = com.bytedance.ee.bear.document.selection.d.a(r0, r4, r10);
        this.Q = r11;
        r11.addListener(new d(this));
        this.Q.start();
        return;
    L13:
        ValueAnimator r12 = this.Q;
        if (r12 == null) goto L18;
        r12.cancel();
        return;
    }

    public final void r(int r5, int r6, boolean r7) {
        l(new String[]{"jsUpdateSelection start?" + r7});
        this.R = true;
        JSONObject r0 = new JSONObject();
        r0.put("x", Float.valueOf(com.bytedance.ee.util.ui.n.E(r5)));
        r0.put("y", Float.valueOf(com.bytedance.ee.util.ui.n.E(r6)));
        x r8 = null;
        if (r7 == false) goto L5;
        String r9 = String.format(Locale.US, "javascript:window.lark.biz.selection.dragSelectionStart", new Object[0]);
    L8:
        g(r9, r0, r8);
        ActionMode r10 = this.C;
        if (r10 == null) goto L12;
        r10.hide(300);
        this.C.invalidateContentRect();
        return;
    L12:
        return;
    L5:
        r9 = String.format(Locale.US, "javascript:window.lark.biz.selection.dragSelectionEnd", new Object[0]);
        if (this.q == false) goto L8;
        r8 = this.u;
        goto L8
    }

    @Override // zv4.f
    public final void onScrollChange(View r1, int r2, int r3, int r4, int r5) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ActionMode r6 = this.C;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.getType() != 1) goto L12;
        this.C.hide(500);
        com.bytedance.ee.util.ui.j.e(this.U);
        com.bytedance.ee.util.ui.j.d(this.U, 200);
        return;
    L12:
        return;
    }
}
