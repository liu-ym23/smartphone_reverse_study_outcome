package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.plugin.IvyPluginService;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.layout.widget.GestureCardView;
import com.larus.im.bean.message.Message;
import com.larus.ivykit.plugin.TemplateInfo;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class LynxBox extends xc8.h {
    public static final /* synthetic */ int M = 0;
    public Function3<? super View, ? super Fragment, ? super com.larus.bmhome.chat.api.v0, Unit> A;
    public Function0<Unit> B;
    public final List<Runnable> C;
    public final ImageView D;
    public final ImageView E;
    public GestureCardView F;
    public View.OnLongClickListener G;
    public com.larus.bmhome.chat.api.v0 H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f304129J;
    public final Lazy K;
    public final b1 L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TemplateInfo f304130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AttachReceiver f304131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Fragment f304132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e1 f304133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Message f304134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f304135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LynxShowState f304136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public kx7.b f304137w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f304138x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function0<Unit> f304139y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super kx7.b, Unit> f304140z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/LynxBox$LynxShowState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "FAIL", "SUCCESS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LynxShowState extends Enum<LynxShowState> {
        public static final LynxShowState DEFAULT = null;
        public static final LynxShowState FAIL = null;
        public static final LynxShowState LOADING = null;
        public static final LynxShowState SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxShowState[] f304142a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f304143b = null;

        public static EnumEntries<LynxShowState> getEntries() {
            return f304143b;
        }

        static {
            LynxShowState r100 = new LynxShowState("DEFAULT", 0);
            DEFAULT = r100;
            LynxShowState r101 = new LynxShowState("LOADING", 1);
            LOADING = r101;
            LynxShowState r102 = new LynxShowState("FAIL", 2);
            FAIL = r102;
            LynxShowState r103 = new LynxShowState("SUCCESS", 3);
            SUCCESS = r103;
            LynxShowState[] r104 = {r100, r101, r102, r103};
            f304142a = r104;
            f304143b = EnumEntriesKt.enumEntries(r104);
        }

        public static LynxShowState[] values() {
            return (LynxShowState[]) f304142a.clone();
        }

        public static LynxShowState valueOf(String r100) {
            return (LynxShowState) r27.a.a(LynxShowState.class, r100);
        }

        public LynxShowState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f304144a = null;

        static {
            int[] r100 = new int[LynxShowState.values().length];
            r100[LynxShowState.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LynxShowState.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LynxShowState.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f304144a = r100;
        }
    }

    static {
    }

    private final va8.p getChatListAbility() {
        return (va8.p) this.f304129J.getValue();
    }

    private final va8.x getChatTraceAbility() {
        return (va8.x) this.K.getValue();
    }

    public final void x() {
        if (this.f304134t == null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L17;
        com.larus.bmhome.chat.api.v0 r101 = this.H;
        if (r101 != null) goto L13;
        return;
    L13:
        Fragment r102 = getChatFragment();
        if (r102 != null) goto L16;
        return;
    L16:
        WidgetRenderDelegate.f297181a.d(r102, r101);
        return;
    L17:
        kx7.b r103 = this.f304137w;
        if (r103 == null) goto L22;
        r103.a();
        return;
    L22:
        return;
    L5:
        if (this.f304135u == true) goto L8;
        r100 = false;
        goto L9
    }

    private final Fragment getChatFragment() {
        Fragment r100 = ei9.e.b(this);
        if (r100 != null) goto L10;
        va8.p r101 = getChatListAbility();
        if (r101 == null) goto L7;
        r100 = r101.me(this);
    L8:
        if (r100 != null) goto L10;
        r100 = this.f304132r;
        goto L10
    L7:
        r100 = null;
    L10:
        if (r100 != null) goto L12;
        FLogger.f375446a.e("LynxBox", "get chat fragment return null");
        com.larus.platform.service.g.f365738a.ensureNotReachHere("LynxBox: get chat fragment return null");
    L12:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f304133s.f304319i == false) goto L6;
        x();
        return;
    }

    public final View getAppletLynxView() {
        return this.f304138x;
    }

    public final Function3<View, Fragment, com.larus.bmhome.chat.api.v0, Unit> getAppletRenderFinishedCallBack() {
        return this.A;
    }

    public final LynxShowState getCurShowState() {
        return this.f304136v;
    }

    public final e1 getLynxBoxConfig() {
        return this.f304133s;
    }

    public final kx7.b getLynxPluginView() {
        return this.f304137w;
    }

    public final Message getMessage() {
        return this.f304134t;
    }

    public final Function0<Unit> getOnTimingSetupCallback() {
        return this.B;
    }

    public final String getRealTemplateUrl() {
        return this.I;
    }

    public final Function1<kx7.b, Unit> getRenderFinishedCallBack() {
        return this.f304140z;
    }

    public final Function0<Unit> getRetryFetchLynxData() {
        return this.f304139y;
    }

    public final TemplateInfo getTemplateInfo() {
        return this.f304130p;
    }

    public final boolean getUseApplet() {
        return this.f304135u;
    }

    public static final /* synthetic */ Fragment n(LynxBox r100) {
        return r100.getChatFragment();
    }

    public static final /* synthetic */ va8.x o(LynxBox r100) {
        return r100.getChatTraceAbility();
    }

    public static JSONObject u(HashMap r100) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        Object r104 = r100.get(r103);
        if (r104 == null) goto L4;
        r101.put(r103, r104);
        goto L4
    L8:
        return r101;
    }

    public final void q(LynxShowState r100) {
        Intrinsics.checkNotNullParameter(r100, "showState");
        this.f304136v = r100;
        int r101 = b.f304144a[r100.ordinal()];
        if (r101 != 1) goto L5;
        com.larus.utils.e1.x(this.D);
        com.larus.utils.e1.o(this.E);
        View r102 = this.f304138x;
        if (r102 == null) goto L29;
        com.larus.utils.e1.o(r102);
    L29:
        kx7.b r103 = this.f304137w;
        if (r103 == null) goto L39;
        BulletContainerView r104 = r103.c();
        if (r104 == null) goto L40;
        com.larus.utils.e1.o(r104);
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (r101 != 2) goto L7;
        com.larus.utils.e1.x(this.E);
        com.larus.utils.e1.o(this.D);
        View r105 = this.f304138x;
        if (r105 == null) goto L21;
        com.larus.utils.e1.o(r105);
    L21:
        kx7.b r106 = this.f304137w;
        if (r106 == null) goto L36;
        BulletContainerView r107 = r106.c();
        if (r107 == null) goto L37;
        com.larus.utils.e1.o(r107);
        return;
    L37:
        return;
    L36:
        return;
    L7:
        if (r101 != 3) goto L41;
        View r108 = this.f304138x;
        if (r108 == null) goto L12;
        com.larus.utils.e1.x(r108);
    L12:
        kx7.b r109 = this.f304137w;
        if (r109 == null) goto L17;
        BulletContainerView r110 = r109.c();
        if (r110 == null) goto L17;
        com.larus.utils.e1.x(r110);
    L17:
        com.larus.utils.e1.o(this.D);
        com.larus.utils.e1.o(this.E);
        return;
    }

    public final String r(String r110) {
        JSONObject r100 = new JSONObject();
        String r101 = this.f304133s.f304320j;
        if (r101 != null) goto L5;
        r101 = "unknown";
    L5:
        r100.put("applet_id", r101);
        r100.put("widget_id", this.f304133s.f304318h);
        String r102 = this.f304130p.getMixtureCardId();
        if (r102 != null) goto L8;
    L20:
        r100.put("widget_data", r110);
        return r100.toString();
    L8:
        if (StringsKt.isBlank(r102) == true) goto L20;
        Message r103 = this.f304134t;
        if (r103 == null) goto L16;
        String r104 = r103.getMessageId();
        if (r104 == null) goto L16;
        List r105 = StringsKt.split$default(r104, new String[]{"long_screenshot_"}, false, 0, 6, null);
        if (r105 == null) goto L16;
        int r106 = r105.size();
    L17:
        if (r106 <= 1) goto L19;
        r102 = r102 + '_' + r106;
    L19:
        r100.put("mixture_card_id", r102);
    L16:
        r106 = 1;
        goto L17
    }

    public final void setAppletLynxView(View r100) {
        this.f304138x = r100;
    }

    public final void setAppletRenderFinishedCallBack(Function3<? super View, ? super Fragment, ? super com.larus.bmhome.chat.api.v0, Unit> r100) {
        this.A = r100;
    }

    public final void setCurShowState(LynxShowState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f304136v = r100;
    }

    public final void setLynxPluginView(kx7.b r100) {
        this.f304137w = r100;
    }

    public final void setOnTimingSetupCallback(Function0<Unit> r100) {
        this.B = r100;
    }

    public final void setRenderFinishedCallBack(Function1<? super kx7.b, Unit> r100) {
        this.f304140z = r100;
    }

    public final void setRetryFetchLynxData(Function0<Unit> r100) {
        this.f304139y = r100;
    }

    public final void t(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.f304135u == true) goto L5;
        return;
    L5:
        if (this.f304138x != null) goto L24;
        int r101 = com.larus.utils.p0.f375454a;
        JSONObject r102 = com.larus.utils.p0.b(this.f304133s.f304317g);
        JSONObject r103 = r102.optJSONObject("commonProps");
        if (r103 == null) goto L10;
        String r104 = r103.optString("messageId");
    L11:
        String r105 = "";
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        String r106 = this.f304130p.getMixtureCardId();
        if (r106 == null) goto L18;
        r105 = r106;
    L18:
        String r107 = r102.optString(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE);
        va8.x r108 = getChatTraceAbility();
        if (r108 == null) goto L21;
        Intrinsics.checkNotNull(r107);
        r108.Bq(r104, r107, r105);
    L21:
        s(r100, this.f304133s);
        return;
    L10:
        r104 = null;
        goto L11
    }

    public final void w(final View.OnLongClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onLongClickListener");
        this.G = r100;
        GestureCardView r101 = this.F;
        if (r101 == null) goto L6;
        r101.setOnLongClickListener(new u0(this, r100));
        return;
    }

    public final void s(Message r110, e1 r111) {
        Fragment r100 = getChatFragment();
        if (r100 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new LynxBox$initAppletLynxView$1(this, r111, r110, r100, null), 3, null);
    }

    public final void y(String r210, com.ivy.ivykit.api.plugin.d r211) {
        if (this.f304138x == null) goto L24;
        String r100 = r210;
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L19
        r101.put("containerWidth", r211.f278356a);     // Catch: Throwable -> L19
        r101.put("log_data", u(r211.f278357b));     // Catch: Throwable -> L19
        r101.put("commonProps", u(r211.f278358c));     // Catch: Throwable -> L19
        String r102 = r101.toString();     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L19
    L11:
        com.larus.bmhome.chat.api.v0 r103 = this.H;
        if (r103 == null) goto L25;
        Fragment r104 = getChatFragment();
        if (r104 == null) goto L26;
        String r105 = r103.f297269o;
        String r106 = r103.f297255a;
        String r107 = r103.f297256b;
        String r108 = r103.f297257c;
        String r109 = r103.f297258d;
        String r110 = r103.f297259e;
        String r111 = r(r102);
        ic8.x r112 = r103.f297262h;
        int r113 = r103.f297263i;
        int r114 = r103.f297264j;
        Map<String, String> r115 = r103.f297265k;
        boolean r116 = r103.f297267m;
        com.larus.bmhome.chat.api.v0 r117 = new com.larus.bmhome.chat.api.v0(r106, r107, r108, r109, r110, r111, null, r112, r113, r114, r115, r103.f297266l, r116, false, r105, null, null, 106496);
        this.H = r117;
        WidgetRenderDelegate.f297181a.e(r104, r117);
        return;
    L26:
        return;
    L25:
        return;
    L10:
        r102 = r100;
    L9:
        r100 = r210;
        goto L10
    }

    public final void z(final String r100, final String r101, final com.ivy.ivykit.api.plugin.d r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "cardViewData");
        Intrinsics.checkNotNullParameter(r102, "pluginViewExtraData");
        Resources r103 = getResources();
        r102.f278356a = (int) (getMaxWidth() / WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density);
        kx7.b r104 = this.f304137w;
        if (r104 == null) goto L5;
        r104.f506580b = r100;
        r104.d(r101, r102);
    L5:
        View r105 = this.f304138x;
        if (this.f304135u == false) goto L16;
        if (r105 != null) goto L16;
        List<Runnable> r106 = this.C;
        monitor-enter(r106);
        ((ArrayList) this.C).add(new t0(this, r100, r101, r102));     // Catch: Throwable -> L13
        monitor-exit(r106);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        y(r101, r102);
    }

    public LynxBox(Context r110, int r111, TemplateInfo r112, AttachReceiver r113, Fragment r210, e1 r211, Message r212, boolean r213, int r214) {
        View r100 = null;
        if ((r214 & 16) == 0) goto L5;
        Fragment r101 = null;
    L7:
        if ((r214 & 32) == 0) goto L9;
        e1 r102 = new e1(null, 2047);
    L11:
        if ((r214 & 64) == 0) goto L13;
        Message r103 = null;
    L15:
        if ((r214 & 128) == 0) goto L19;
        if (r103 == null) goto L18;
        boolean r104 = true;
    L20:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "templateInfo");
        Intrinsics.checkNotNullParameter(r102, "lynxBoxConfig");
        super(r110);
        this.f304130p = r112;
        this.f304131q = r113;
        this.f304132r = r101;
        this.f304133s = r102;
        this.f304134t = r103;
        this.f304135u = r104;
        this.f304136v = LynxShowState.DEFAULT;
        this.C = new ArrayList();
        ImageView r105 = new ImageView(r110);
        r105.setImageResource(R.drawable.larus_lynx_common_loading_view);
        r105.setScaleType(ImageView.ScaleType.FIT_XY);
        r105.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r105.setVisibility(8);
        this.D = r105;
        ImageView r114 = new ImageView(r110);
        r114.setImageResource(R.drawable.larus_lynx_common_retry_view);
        r114.setScaleType(ImageView.ScaleType.FIT_XY);
        r114.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r114.setVisibility(8);
        r114.setOnClickListener(new v0(this));
        this.E = r114;
        this.f304129J = LazyKt.lazy(new w0(this));
        this.K = LazyKt.lazy(new x0(this));
        this.L = new b1(this);
        setBoxType(r111);
        int r115 = r102.f304311a;
        if (r115 == 0) goto L23;
        setMaxWidth(r115);
    L26:
        addView(r105);
        addView(r114);
        Keva r106 = pg9.i.f529219a;
        String r107 = r112.getTemplateUrl();
        String r116 = "";
        if (r107 != null) goto L29;
        r107 = "";
    L29:
        String r108 = pg9.i.a(r107);
        if (r108.length() <= 0) goto L32;
        boolean r117 = true;
    L33:
        if (r117 == false) goto L88;
        this.I = r108;
        int r118 = com.larus.utils.p0.f375454a;
        JSONObject r119 = com.larus.utils.p0.b(r102.f304317g);
        JSONObject r120 = r119.optJSONObject("commonProps");
        if (r120 == null) goto L37;
        String r121 = r120.optString("messageId");
    L38:
        if (r121 != null) goto L40;
        r121 = "";
    L40:
        String r122 = r112.getMixtureCardId();
        if (r122 == null) goto L44;
        r116 = r122;
    L44:
        String r123 = r119.optString(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE);
        if (r103 == null) goto L50;
        va8.x r109 = getChatTraceAbility();
        if (r109 == null) goto L49;
        Intrinsics.checkNotNull(r123);
        r109.Bq(r121, r123, r116);
    L49:
        s(r103, r102);
        return;
    L50:
        if (r104 == true) goto L90;
        Fragment r124 = getChatFragment();
        if (r124 == null) goto L58;
        LifecycleOwner r125 = r124.getViewLifecycleOwner();
        if (r125 == null) goto L58;
        Lifecycle r126 = r125.getLifecycle();
        if (r126 == null) goto L58;
        r126.addObserver(new AnonymousClass1(this));
    L58:
        va8.x r127 = getChatTraceAbility();
        if (r127 == null) goto L61;
        Intrinsics.checkNotNull(r123);
        r127.Bq(r121, r123, r116);
    L61:
        this.f304137w = IvyPluginService.f278342a.a(r110, r108, new z0(this), new a1(this, r121, r116, r123, r108), r102.f304317g);
        if (r112.getCardType() != 1) goto L64;
    L67:
        float r128 = getResources().getDimension(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
    L68:
        GestureCardView r129 = new GestureCardView(r110, null, 6, 0);
        r129.setLayoutParams(new LinearLayout.LayoutParams(getMaxWidth(), -1));
        if (r102.f304312b == true) goto L71;
        r129.setCardBackgroundColor(ContextCompat.getColor(r110, R.color.larus_base_1));
    L71:
        r129.setRadius(r128);
        r129.setElevation(0.0f);
        if (r102.f304315e == false) goto L77;
        pt8.a r130 = new pt8.a(r110, r128);
        kx7.b r131 = this.f304137w;
        if (r131 == null) goto L76;
        r100 = r131.c();
    L76:
        r130.addView(r100, new ViewGroup.LayoutParams(getMaxWidth(), -1));
        r129.addView(r130, new ViewGroup.LayoutParams(-1, -1));
    L81:
        r129.setStrokeColor(ContextCompat.getColor(r110, R.color.larus_neutral_transparent_2));
        r129.setStrokeWidth(r102.f304316f ? 1 : 0);
        if (r112.getCardType() == 1) goto L84;
    L86:
        this.F = r129;
        addView(r129, new ViewGroup.LayoutParams(-1, -1));
        return;
    L84:
        if (r102.f304312b == true) goto L86;
        View r132 = new View(r110);
        r132.setBackgroundResource(R.drawable.larus_lynx_ruyi_stroke_bg);
        r132.setLayoutParams(new LinearLayout.LayoutParams(getMaxWidth(), -1));
        r129.addView(r132, new FrameLayout.LayoutParams(-1, -1));
        goto L86
    L77:
        kx7.b r133 = this.f304137w;
        if (r133 == null) goto L80;
        r100 = r133.c();
    L80:
        r129.addView(r100, new ViewGroup.LayoutParams(getMaxWidth(), -1));
        goto L81
    L64:
        if (r102.f304314d == true) goto L67;
        r128 = 0.0f;
        goto L68
    L90:
        return;
    L37:
        r121 = null;
        goto L38
    L88:
        return;
    L32:
        r117 = false;
        goto L33
    L23:
        Lazy r134 = com.larus.bmhome.utils.z1.f315157a;
        if (com.larus.bmhome.utils.z1.b(getBoxType(), getImmerseBgColor()) == false) goto L26;
        setMaxWidth(com.larus.bmhome.utils.z1.h(getBoxType(), getImmerseBgColor(), false, false, 28));
        goto L26
    L18:
        r104 = false;
        goto L20
    L19:
        r104 = r213;
        goto L20
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
