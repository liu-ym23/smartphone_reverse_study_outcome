package qo9;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.doc.editmodeswitchplugin.IEditModeSwitchViewPlugin;
import com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.nova.R;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.w1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import va8.g0;

/* JADX INFO: loaded from: classes30.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Context> f534299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ChameleonPluginHost> f534300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<t> f534301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<OfficeInputParam> f534302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<com.larus.office.h> f534303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<g45.d> f534304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final so9.g f534305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<String, Unit> f534306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f534307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q f534308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.larus.office.plugins.inputv2.adapter.g f534309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f534310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f534311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FloatChatWindowState f534312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f534313o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f534314p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f534315q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f534316r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f534317s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final p f534318t;

    public static final class a {
    }

    public static final class b extends ContextWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources.Theme f534319a;

        @Override // android.content.ContextWrapper, android.content.Context
        public final Resources.Theme getTheme() {
            return this.f534319a;
        }

        public b(Context r100, int r101) {
            super(r100);
            Resources.Theme r102 = r100.getResources().newTheme();
            r102.setTo(r100.getTheme());
            r102.applyStyle(r101, true);
            this.f534319a = r102;
        }
    }

    static {
    }

    public final Integer f() {
        OfficeInputParam r100 = this.f534302d.invoke();
        Object r101 = null;
        if (r100 == null) goto L22;
        Integer r102 = r100.getHostChatThemeStyleResId();
        if (r102 == null) goto L23;
        int r103 = r102.intValue();
        Context r104 = this.f534299a.invoke();
        if (r104 != null) goto L9;
        return null;
    L9:
        b r105 = new b(r104, r103);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(ContextCompat.getColor(r105, v19.c.b(R.attr.larus_base_1, r105, R.color.larus_base_1))));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r107) == true) goto L19;
        r101 = r107;
    L19:
        return (Integer) r101;
    L12:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    L22:
        return null;
    }

    public final void g() {
        com.larus.office.plugins.inputv2.adapter.g r100 = this.f534309k;
        if (r100 == null) goto L7;
        va8.k r101 = (va8.k) r100.e(va8.k.class);
        if (r101 == null) goto L7;
        r101.eV(null);
    L7:
        com.larus.office.plugins.inputv2.adapter.g r102 = this.f534309k;
        if (r102 == null) goto L16;
        p r103 = this.f534318t;
        Intrinsics.checkNotNullParameter(r103, "observer");
        if (r102.f362683f.remove(r103) == false) goto L16;
        r102.f362679b.Qr(r103);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r102.f362683f.add(r103);
        FLogger.f375446a.e("OfficeChatInputAdapter", "注销窗口状态监听失败", th);
    L16:
        com.larus.office.plugins.inputv2.adapter.g r104 = this.f534309k;
        if (r104 != null) goto L19;
    L25:
        this.f534309k = null;
        return;
    L19:
        if (r104.f362693p == true) goto L25;
        r104.f362679b.ZR(null);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "更新 ChatHostConfig 失败", th);
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [qo9.l] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(ChameleonPluginHost r100) {
        this.f534305g.f(r100, this.f534304f.invoke(), new l(this), this.f534306h);
    }

    public final void c(String r100) {
        this.f534312n = FloatChatWindowState.Collapsed;
        h(false, r100, true);
        e r101 = this.f534307i;
        if (r101.f534274d == false) goto L6;
        r101.f534274d = false;
        r101.a();
    L6:
        i(0);
        FLogger.f375446a.i("OfficeChatWindow", "清理窗口状态, reason=" + r100);
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.office.plugins.inputv2.adapter.g r101 = this.f534309k;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        if (this.f534313o == 2) goto L5;
        return;
    L5:
        if (this.f534312n != FloatChatWindowState.Collapsed) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        FLogger.f375446a.i("OfficeChatWindow", "横屏激活输入框，对话框未收起，自动收起, reason=".concat(r100));
        d(r100);
        return;
    L13:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void i(int r100) {
        int r101 = RangesKt.coerceIn(r100, 0, 100);
        if (this.f534317s != r101) goto L5;
        return;
    L5:
        this.f534317s = r101;
        com.larus.office.h r102 = this.f534303e.invoke();
        if (r102 == null) goto L9;
        r102.T3(r101);
        return;
    }

    public final void a(boolean r100, String r101) {
        if (r100 == false) goto L6;
        Integer r102 = this.f534305g.L();
        if (r102 != null) goto L9;
        r102 = f();
    L9:
        if (r102 == null) goto L25;
        int r103 = r102.intValue();
        if (r100 == true) goto L18;
        OfficeInputParam r104 = this.f534302d.invoke();
        if (r104 == null) goto L15;
        String r105 = r104.getType();
    L17:
        if (Intrinsics.areEqual(r105, "base") == false) goto L18;
    L23:
        FLogger.f375446a.i("OfficeChatWindow", "应用背景, reason=" + r101 + ", folded=" + r100 + ", color=" + r103);
        return;
    L15:
        r105 = null;
    L18:
        com.larus.office.plugins.inputv2.adapter.g r106 = this.f534309k;
        if (r106 == null) goto L23;
        g0 r107 = (g0) r106.e(g0.class);
        if (r107 == null) goto L23;
        r107.gA(new ColorDrawable(r103));
        goto L23
    L25:
        return;
    L6:
        r102 = this.f534305g.F();
        if (r102 != null) goto L9;
        r102 = f();
        goto L9
    }

    public final void h(boolean r100, String r101, boolean r110) {
        View r102 = this.f534310l;
        if (r102 == null) goto L8;
        if (r100 == false) goto L6;
        float r103 = 1.0f;
    L7:
        r102.setAlpha(r103);
        goto L8
    L6:
        r103 = 0.0f;
    L8:
        View r104 = this.f534310l;
        if (r104 == null) goto L14;
        if (r100 == false) goto L12;
        int r105 = 0;
    L13:
        r104.setVisibility(r105);
        goto L14
    L12:
        r105 = 8;
    L14:
        if (r110 == false) goto L16;
    L18:
        this.f534311m = r100;
        e r106 = this.f534307i;
        if (r106.f534273c == r100) goto L23;
        r106.f534273c = r100;
        r106.a();
    L23:
        if (r100 == false) goto L31;
        ChameleonPluginHost r107 = this.f534300b.invoke();
        if (r107 == null) goto L29;
        IEditModeSwitchViewPlugin r108 = (IEditModeSwitchViewPlugin) r107.findPlugin(IEditModeSwitchViewPlugin.class);
        if (r108 == null) goto L29;
        r108.setEditButtonVisibilityFromNative(false);
    L29:
        this.f534314p = false;
    L38:
        boolean r109 = !r100;
        com.larus.office.h r111 = this.f534303e.invoke();
        if (r111 == null) goto L46;
        List<com.larus.office.c> r112 = r111.zk();
        if (r112 == null) goto L46;
        Iterator<T> r113 = r112.iterator();
    L44:
        if (r113.hasNext() == false) goto L46;
        ((com.larus.office.c) r113.next()).onChatListFoldStatusChanger(r109);
    L46:
        Integer r114 = this.f534315q;
        if (r109 == false) goto L50;
        if (r114 != null) goto L50;
    L75:
        if (r110 == false) goto L77;
    L79:
        this.f534316r = Boolean.valueOf(r109);
        com.larus.office.h r115 = this.f534303e.invoke();
        if (r115 == null) goto L82;
        r115.Dd(r109);
    L82:
        a(r109, r101);
        return;
    L77:
        if (Intrinsics.areEqual(this.f534316r, Boolean.valueOf(r109)) == false) goto L79;
    L50:
        ChameleonPluginHost r116 = this.f534300b.invoke();
        if (r116 == null) goto L75;
        ISheetFabPlugin r117 = (ISheetFabPlugin) r116.findPlugin(ISheetFabPlugin.class);
        if (r117 == null) goto L75;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L57
        Object r119 = Result.m9449constructorimpl(this.f534301c.invoke().c(r117));     // Catch: Throwable -> L57
    L59:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L63;
        FLogger.f375446a.e("OfficeChatWindow", "更新 Sheet FAB 显隐失败, visible=" + r109, r120);
    L63:
        if (Result.m9455isFailureimpl(r119) == false) goto L65;
        r119 = null;
    L65:
        ViewGroup r121 = (ViewGroup) r119;
        if (r121 == null) goto L75;
        if (r109 == false) goto L72;
        if (r114 == null) goto L75;
        r121.setVisibility(r114.intValue());
        this.f534315q = null;
        goto L75
    L72:
        if (this.f534315q != null) goto L74;
        this.f534315q = Integer.valueOf(r121.getVisibility());
    L74:
        r121.setVisibility(8);
    L57:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L59
    L31:
        if (this.f534314p == true) goto L38;
        ChameleonPluginHost r123 = this.f534300b.invoke();
        if (r123 == null) goto L37;
        IEditModeSwitchViewPlugin r124 = (IEditModeSwitchViewPlugin) r123.findPlugin(IEditModeSwitchViewPlugin.class);
        if (r124 == null) goto L37;
        r124.setEditButtonVisibilityFromNative(true);
    L37:
        this.f534314p = true;
        goto L38
    L16:
        if (this.f534311m != r100) goto L18;
    }

    public o(w1 r100, com.larus.office.plugins.inputv2.b r101, com.larus.office.plugins.inputv2.c r102, com.larus.office.plugins.inputv2.d r103, com.larus.office.plugins.inputv2.e r104, com.larus.office.plugins.inputv2.f r105, so9.d r106, com.larus.office.plugins.inputv2.g r107) {
        Intrinsics.checkNotNullParameter(r100, "contextProvider");
        Intrinsics.checkNotNullParameter(r101, "hostProvider");
        Intrinsics.checkNotNullParameter(r102, "uiContainerProvider");
        Intrinsics.checkNotNullParameter(r103, "paramsProvider");
        Intrinsics.checkNotNullParameter(r104, "hostAbilityProvider");
        Intrinsics.checkNotNullParameter(r105, "editPanelManagerProvider");
        Intrinsics.checkNotNullParameter(r106, "platform");
        Intrinsics.checkNotNullParameter(r107, "onVisibilityRefreshRequired");
        this.f534299a = r100;
        this.f534300b = r101;
        this.f534301c = r102;
        this.f534302d = r103;
        this.f534303e = r104;
        this.f534304f = r105;
        this.f534305g = r106;
        this.f534306h = r107;
        this.f534307i = new e(r100);
        this.f534308j = new q(this);
        this.f534312n = FloatChatWindowState.Collapsed;
        this.f534314p = true;
        this.f534318t = new p(this);
    }
}
