package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.g0;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.editor.input.interceptor.ChatEditorMenuLayoutManager;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class KeyboardMenu implements com.ss.android.lark.keyboard.keyboard2.d, com.ss.android.lark.keyboard.keyboard2.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f429462o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f429463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.ss.android.lark.keyboard.keyboard2.e> f429465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<KeyboardMenuItemKey, b> f429466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f429467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f429468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final KBMenuContainerView f429469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f429470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f429471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f429472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f429473k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f429474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList<Function0<Unit>> f429475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f429476n;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f429477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f429478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f429479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f429480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f429481e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f429482f;

        public b(m r100) {
            Intrinsics.checkNotNullParameter(r100, "menuItem");
            this.f429477a = r100;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429483a = null;

        static {
            int[] r100 = new int[PanelMenuItem.InitialStrategy.values().length];
            r100[PanelMenuItem.InitialStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PanelMenuItem.InitialStrategy.Idle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f429483a = r100;
        }
    }

    public static final class d implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KeyboardMenu f429484a;

        public d(KeyboardMenu r100) {
            this.f429484a = r100;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
        L3:
            if ((!this.f429484a.f429475m.isEmpty()) == false) goto L7;
            Function0<Unit> r100 = this.f429484a.f429475m.pollLast();
            if (r100 == null) goto L3;
            r100.invoke();
            goto L3
        L7:
            this.f429484a.f429474l = false;
            return false;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KeyboardMenu f429485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f429486b;

        public e(KeyboardMenu r100, b r101) {
            this.f429485a = r100;
            this.f429486b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f429485a.v(this.f429486b);
        }
    }

    public static final class f implements i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KeyboardMenu f429487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f429488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppCompatImageView f429489c;

        @Override // com.ss.android.lark.keyboard.keyboard2.i.b
        public final f a() {
            this.f429489c.setOnClickListener(null);
            return this;
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.i.a
        public final void performClick() {
            this.f429487a.v(this.f429488b);
        }

        public f(KeyboardMenu r100, b r101, AppCompatImageView r102) {
            this.f429487a = r100;
            this.f429488b = r101;
            this.f429489c = r102;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        this.f429467e = true;
        Iterator r100 = ((LinkedHashMap) this.f429466d).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        e((b) ((Map.Entry) r100.next()).getValue());
        goto L4
    L6:
        r().z().v(this).d(new KeyboardMenu$bindToKeyboardWrapper$1(this));
        m();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean u(m r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return true;
    }

    public final boolean H() {
        b r100 = this.f429472j;
        if (r100 != null) goto L6;
        return false;
    L6:
        J(r100);
        this.f429472j = null;
        return true;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final boolean h() {
        if (this.f429472j != null) goto L6;
        return false;
    L6:
        return B(false);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        this.f429475m.clear();
        r().z().v(this).clear();
        Iterator r100 = ((LinkedHashMap) this.f429466d).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        l((b) ((Map.Entry) r100.next()).getValue());
        goto L4
    L6:
        this.f429469g.removeAllViews();
        this.f429471i = 0;
        Looper.myQueue().removeIdleHandler(this.f429476n);
        this.f429474l = false;
        this.f429467e = false;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final m k() {
        b r100 = this.f429472j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f429477a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void m() {
        if (this.f429467e == true) goto L5;
        return;
    L5:
        Iterator r100 = ((LinkedHashMap) this.f429466d).values().iterator();
    L6:
        View r101 = null;
        int r102 = 0;
        if (r100.hasNext() == false) goto L46;
        b r103 = (b) r100.next();
        List<com.ss.android.lark.keyboard.keyboard2.e> r104 = this.f429465c;
        m r105 = r103.f429477a;
        ArrayList r106 = (ArrayList) r104;
        Iterator r107 = r106.iterator();
    L9:
        boolean r110 = true;
        if (r107.hasNext() == false) goto L14;
        Object r108 = r107.next();
        if ((!((com.ss.android.lark.keyboard.keyboard2.e) r108).n(r105)) == false) goto L9;
    L15:
        if (r108 != null) goto L17;
        boolean r109 = true;
    L18:
        Iterator r111 = r106.iterator();
    L20:
        if (r111.hasNext() == false) goto L24;
        Object r112 = r111.next();
        if ((!((com.ss.android.lark.keyboard.keyboard2.e) r112).u(r105)) == false) goto L20;
    L25:
        if (r112 == null) goto L29;
        r110 = false;
    L29:
        if (r109 == r103.f429482f) goto L32;
        r105.w(r109);
    L32:
        if (r110 == r103.f429481e) goto L34;
        r105.y(r110);
    L34:
        View r113 = r103.f429478b;
        if (r113 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("iconWrapper");
        r113 = null;
    L38:
        if (r110 == true) goto L41;
        r102 = 8;
    L41:
        r113.setVisibility(r102);
        View r114 = r103.f429479c;
        if (r114 == null) goto L44;
        r101 = r114;
    L45:
        r101.setEnabled(r109);
        r103.f429482f = r109;
        r103.f429481e = r110;
        goto L6
    L44:
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        goto L45
    L24:
        r112 = null;
        goto L25
    L17:
        r109 = false;
        goto L18
    L14:
        r108 = null;
        goto L15
    L46:
        g r115 = this.f429470h;
        Collection r116 = ((LinkedHashMap) this.f429466d).values();
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r118 = r116.iterator();
    L48:
        if (r118.hasNext() == false) goto L50;
        r117.add(((b) r118.next()).f429477a);
        goto L48
    L50:
        List<m> r119 = r115.a(r117);
        Iterator<T> r120 = r119.iterator();
        int r121 = 0;
    L52:
        if (r120.hasNext() == false) goto L55;
        r121 = (r121 * 31) + ((m) r120.next()).g().hashCode();
        goto L52
    L55:
        if (r121 == this.f429471i) goto L72;
        this.f429471i = r121;
        this.f429469g.removeAllViews();
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r119.iterator();
    L58:
        if (r123.hasNext() == false) goto L68;
        m r124 = (m) r123.next();
        b r125 = (b) ((LinkedHashMap) this.f429466d).get(r124.g());
        if (r125 == null) goto L65;
        View r126 = r125.f429478b;
        if (r126 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("iconWrapper");
    L66:
        if (r126 == null) goto L58;
        r122.add(r126);
    L65:
        r126 = null;
        goto L66
    L68:
        Iterator r127 = r122.iterator();
    L70:
        if (r127.hasNext() == false) goto L72;
        this.f429469g.addView((View) r127.next());
    L72:
        ArrayList r128 = new ArrayList();
        int r129 = this.f429469g.getChildCount();
    L73:
        if (r102 >= r129) goto L78;
        View r130 = this.f429469g.getChildAt(r102);
        if (r130.getVisibility() == 8) goto L77;
        Intrinsics.checkNotNull(r130);
        r128.add(r130);
    L77:
        r102 = r102 + 1;
        goto L73
    L78:
        View r131 = (View) CollectionsKt.firstOrNull(r128);
        if (r131 == null) goto L102;
        int r132 = UIUtils.dp2px(r131.getContext(), 9.0f);
        g0.a(r131, r132, UIUtils.dp2px(r131.getContext(), 12.0f), r132, r132);
        return;
    }

    public final com.ss.android.lark.keyboard.b r() {
        com.ss.android.lark.keyboard.b r100 = this.f429464b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    public KeyboardMenu(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f429463a = r100;
        this.f429465c = new ArrayList();
        this.f429466d = new LinkedHashMap();
        View r101 = LayoutInflater.from(r100).inflate(R.layout.kb_keyboard_menu, null, false);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f429468f = r101;
        this.f429469g = (KBMenuContainerView) r101.findViewById(R.id.menu_view);
        g.f429547a.getClass();
        this.f429470h = g.a.f429550c;
        this.f429473k = true;
        this.f429475m = new LinkedList();
        this.f429476n = new d(this);
    }

    public static void J(b r100) {
        m r101 = r100.f429477a;
        if ((r101 instanceof o) == true) goto L6;
        Log.e(ObricActionBarTrackType.KEY_BOARD, "selectItemInner: item is not selectable item, method return.");
        return;
    L6:
        ((o) r101).A(false);
        View r102 = r100.f429479c;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r102 = null;
    L10:
        r102.setSelected(false);
        View r103 = r100.f429480d;
        if (r103 == null) goto L14;
        r103.setVisibility(8);
        return;
    }

    public final boolean B(boolean r100) {
        b r101 = this.f429472j;
        if (r101 != null) goto L7;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "unSelectCurrentItem: current item is empty");
        return false;
    L7:
        if (r101.f429480d == null) goto L19;
        com.ss.android.lark.keyboard.ime.a r102 = r().z();
        if (r100 == false) goto L13;
        if (r102.z() == false) goto L13;
    L17:
        return true;
    L13:
        if (r102.a() == true) goto L17;
        if (r102.B() == true) goto L17;
        H();
        goto L17
    L19:
        return H();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void C(ChatEditorMenuLayoutManager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429469g.setMenuLayoutManager(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void G(m r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (CarUtils.a() == true) goto L5;
    L9:
        b r101 = new b(r100);
        this.f429466d.put(r100.g(), r101);
        com.ss.android.lark.keyboard.b r102 = r();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f429567a = r102;
        if (this.f429467e == true) goto L12;
        return;
    L12:
        e(r101);
        m();
        return;
    L5:
        if (r100.g() != KeyboardMenuItemKey.Photo) goto L9;
        if (((v28.a) ClaymoreServiceLoader.loadFirst(v28.a.class)).enableSendImage() == true) goto L9;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void M(com.ss.android.lark.keyboard.keyboard2.e r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f429465c).add(r100);
    }

    public final void e(final b r100) {
        final m r101 = r100.f429477a;
        com.ss.android.lark.keyboard.b r102 = r();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f429567a = r102;
        Context r103 = this.f429463a;
        int r104 = r101.a();
        int r105 = r101.b();
        AppCompatImageView r106 = com.ss.android.lark.keyboard.utils.h.a(r103, -1, r104);
        if (r105 == (-1)) goto L5;
        r106.setImageTintList(UIUtils.getColorStateList(r103, r105));
        r106.setImageTintMode(PorterDuff.Mode.SRC_ATOP);
    L5:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r100.f429479c = r106;
        Intrinsics.checkNotNull(r106);
        FrameLayout r107 = new FrameLayout(this.f429463a);
        r107.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r107.addView(r106);
        int r108 = UIUtils.dp2px(r106.getContext(), 9.0f);
        g0.a(r106, r108, r108, r108, r108);
        Integer r109 = r101.q();
        if (r109 == null) goto L8;
        int r110 = r109.intValue();
        r107.setTag(R.id.test_monitor_tag, UIUtils.getString(this.f429463a, r110));
    L8:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r100.f429478b = r107;
        if (r101.f429568b == true) goto L12;
        r101.f429568b = true;
        r101.u();
    L12:
        r106.setOnClickListener(new e(this, r100));
        r101.x(new i(r106, new f(this, r100, r106)));
        if ((r101 instanceof PanelMenuItem) == false) goto L25;
        PanelMenuItem r111 = (PanelMenuItem) r101;
        PanelMenuItem.InitialStrategy r112 = r111.C();
        int r113 = c.f429483a[r112.ordinal()];
        if (r113 != 1) goto L17;
        g(r111, r100);
        return;
    L17:
        if (r113 != 2) goto L27;
        Function0<Unit> r114 = new KeyboardMenu$createMenuItem$4(this, r101, r100);
        this.f429475m.add(r114);
        if (this.f429474l == true) goto L28;
        this.f429474l = true;
        Looper.myQueue().addIdleHandler(this.f429476n);
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void f(KeyboardMenuItemKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = (b) ((LinkedHashMap) this.f429466d).get(r100);
        if (r101 != null) goto L7;
        Log.w(ObricActionBarTrackType.KEY_BOARD, "clickMenuItem: could not find menu item " + r100.ordinal());
        return;
    L7:
        if (r101.f429481e == true) goto L9;
    L13:
        Log.w(ObricActionBarTrackType.KEY_BOARD, "clickMenuItem: item is not visible or is not visible, method return.");
        return;
    L9:
        if (r101.f429482f == false) goto L13;
        v(r101);
    }

    public final void l(b r100) {
        m r101 = r100.f429477a;
        if (r101.f429568b == false) goto L6;
        r101.f429568b = false;
        r101.v();
    L6:
        View r102 = r100.f429480d;
        if (r102 == null) goto L10;
        r().z().getPanel().removeView(r102);
        return;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean n(m r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return this.f429473k;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void q(g.a.C5103a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429470h = r100;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429464b = r100;
    }

    public final void v(b r100) {
        m r101 = r100.f429477a;
        if ((r101 instanceof o) == true) goto L7;
        r101.s();
        return;
    L7:
        if (Intrinsics.areEqual(r100, this.f429472j) == false) goto L10;
        B(true);
        return;
    L10:
        y(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final boolean w(KeyboardMenuItemKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = (b) ((LinkedHashMap) this.f429466d).get(r100);
        if (r101 != null) goto L7;
        Log.w(ObricActionBarTrackType.KEY_BOARD, "selectMenuItem: could not find menu item " + r100.ordinal());
        return false;
    L7:
        if (r101.f429481e == true) goto L9;
    L17:
        Log.w(ObricActionBarTrackType.KEY_BOARD, "selectMenuItem: item is not visible or is not visible, method return.");
        return false;
    L9:
        if (r101.f429482f == false) goto L17;
        if (Intrinsics.areEqual(r101, this.f429472j) == false) goto L16;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "selectMenuItem: item is selected , method return");
        return false;
    L16:
        return y(r101);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final void x(AudioKBPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        b r101 = this.f429466d.remove(r100.f429867j);
        if (this.f429467e == true) goto L5;
        return;
    L5:
        if (r101 == null) goto L8;
        l(r101);
        m();
        return;
    }

    public final boolean y(final b r100) {
        Log.i(ObricActionBarTrackType.KEY_BOARD, "selectItem: info is " + r100.f429477a.g());
        m r101 = r100.f429477a;
        if ((r101 instanceof PanelMenuItem) == false) goto L5;
        g((PanelMenuItem) r101, r100);
    L5:
        View r102 = r100.f429480d;
        com.ss.android.lark.keyboard.ime.a r103 = r().z();
        boolean r104 = r103.B();
        if (r102 == null) goto L17;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "selectItem: current item has panel, isPanelShow " + r104);
        H();
        if (r104 == false) goto L11;
        z(r100);
        return true;
    L11:
        Log.i(ObricActionBarTrackType.KEY_BOARD, "selectItem: request show panel");
        if (r103.e() == false) goto L15;
        z(r100);
        return true;
    L15:
        Log.w(ObricActionBarTrackType.KEY_BOARD, "selectItem: request show panel failed");
        return false;
    L17:
        if (r104 == false) goto L24;
        Log.i(ObricActionBarTrackType.KEY_BOARD, "selectItem: current item has no panel, but panel is shown, request show ime.");
        if (r103.z() == true) goto L22;
        Log.w(ObricActionBarTrackType.KEY_BOARD, "show ime failed");
        return false;
    L22:
        final b r105 = this.f429472j;
        com.ss.android.lark.keyboard.ime.c r106 = r103.v(this);
        r106.b(new KeyboardMenu$selectItem$1$1(r100, this));
        r106.d(new KeyboardMenu$selectItem$1$2(r105, this));
        return true;
    L24:
        Log.i(ObricActionBarTrackType.KEY_BOARD, "selectItem: current item has no panel, panel is not shown, select now.");
        H();
        z(r100);
        return true;
    }

    public final void z(b r100) {
        m r101 = r100.f429477a;
        if ((r101 instanceof o) == true) goto L6;
        Log.e(ObricActionBarTrackType.KEY_BOARD, "selectItemInner: item is not selectable item, method return.");
        return;
    L6:
        ((o) r101).A(true);
        this.f429472j = r100;
        View r102 = r100.f429479c;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r102 = null;
    L10:
        r102.setSelected(true);
        View r103 = r100.f429480d;
        if (r103 == null) goto L14;
        r103.setVisibility(0);
        return;
    }

    public final void g(PanelMenuItem r100, b r101) {
        com.ss.android.lark.keyboard.ime.a r102 = r().z();
        ViewGroup r103 = r102.getPanel();
        View r104 = r101.f429480d;
        boolean r105 = true;
        if (r104 != null) goto L5;
    L10:
        View r106 = r100.G(r103);
        if (r102.B() == false) goto L13;
        r106.setVisibility(8);
    L14:
        r101.f429480d = r106;
        if (r103.indexOfChild(r106) != (-1)) goto L18;
        r105 = false;
    L18:
        if (r105 == true) goto L21;
        r103.addView(r106);
        return;
    L21:
        return;
    L13:
        r106.setVisibility(4);
        goto L14
    L5:
        if (r103.indexOfChild(r104) == (-1)) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L10;
        return;
    L7:
        r107 = false;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.d
    public final <T extends m> T i(KeyboardMenuItemKey r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "itemClass");
        b r102 = (b) ((LinkedHashMap) this.f429466d).get(r100);
        if (r102 == null) goto L5;
        m r103 = r102.f429477a;
    L6:
        if (r103 != null) goto L8;
    L11:
        return null;
    L8:
        if (r101.isInstance(r103) == false) goto L11;
        return r101.cast(r103);
    L5:
        r103 = null;
        goto L6
    }
}
