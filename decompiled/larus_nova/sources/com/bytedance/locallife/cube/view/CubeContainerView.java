package com.bytedance.locallife.cube.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.kit.lynx.api.ThreadStrategyForRendering;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.config.LynxLoadConfig;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.bytedance.locallife.cube.api.i.ICubeListener;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.bytedance.locallife.cube.d;
import com.bytedance.locallife.cube.model.CubeEvent;
import com.bytedance.locallife.cube.model.CubeSchemaData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import fp6.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001'B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0016\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/bytedance/locallife/cube/view/CubeContainerView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "listener", "setOnLynxViewSizeChangedListener", "", "getSessionId", "getContainerID", "Lcom/bytedance/ies/bullet/service/base/d1;", "getResourceInfo", "Lcom/bytedance/locallife/cube/api/model/DelegateStatus;", "getLoadState", "Lcom/bytedance/locallife/cube/api/config/CubeConfig;", "getCubeConfig", "", "c", "J", "getOpenTime", "()J", "setOpenTime", "(J)V", "openTime", "Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "d", "Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "getCubeInst", "()Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "setCubeInst", "(Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;)V", "cubeInst", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CubeContainerView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f257263j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CubeConfig f257264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CubeInternalSchemaModel f257265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f257266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile IPoiLynxKitDelegate f257267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f257268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ICubeListener> f257269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<CubeEvent> f257270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f257271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f257272i;

    public static final class a {
    }

    public static final class b extends ICubeListener.Base {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CubeContainerView f257273a;

        public b(CubeContainerView r100) {
            this.f257273a = r100;
        }

        @Override // com.bytedance.locallife.cube.api.i.ICubeListener.Base, com.bytedance.locallife.cube.api.i.ICubeListener
        public final void onRuntimeReady(CubeContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super.onRuntimeReady(r100);
            CubeInternalSchemaModel r101 = r100.c();
            if (r101 == null) goto L5;
            r101.getSchema();
        L5:
            CubeContainerView r102 = this.f257273a;
            if (r102.f257270g.isEmpty() == true) goto L21;
            CollectionsKt.sortedWith(r102.f257270g, com.bytedance.locallife.cube.view.a.f257275a);
            Iterator<T> r103 = r102.f257270g.iterator();
        L10:
            if (r103.hasNext() == false) goto L14;
            CubeEvent r104 = (CubeEvent) r103.next();
            IPoiLynxKitDelegate r105 = r102.f257267d;
            if (r105 == null) goto L10;
            r105.sendEvent(r104.getName(), r104.getParams());
            goto L10
        L14:
            r102.f257270g.clear();
            return;
        }
    }

    static {
    }

    public CubeContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CubeContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void c() {
        if (this.f257267d != null) goto L6;
        d.b("cube instance is not initialized, you should call init function first!");
        return;
    }

    public final void i() {
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 == null) goto L31;
        String r101 = r100.getCubeContext().f257177p;
        boolean r102 = r100.getCubeContext().f257169h;
        boolean r103 = r100.getCubeContext().f257170i;
        r100.addCubeListener(this.f257272i);
        Function0<Unit> r104 = this.f257268e;
        if (r104 == null) goto L8;
        r100.setOnSizeChangedListener(r104);
    L8:
        if (this.f257271h.isEmpty() == true) goto L15;
        IPoiLynxKitDelegate r105 = this.f257267d;
        if (r105 == null) goto L13;
        r105.updateGlobalProps(this.f257271h, this.f257265b);
    L13:
        this.f257271h.clear();
    L15:
        if (this.f257269f.isEmpty() == true) goto L24;
        Iterator<T> r106 = this.f257269f.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        ICubeListener r107 = (ICubeListener) r106.next();
        IPoiLynxKitDelegate r108 = this.f257267d;
        if (r108 == null) goto L19;
        r108.addCubeListener(r107);
        goto L19
    L23:
        this.f257269f.clear();
    L24:
        removeAllViews();
        addView(r100.realView(), -1, -1);
        return;
    }

    public final void j() {
        kp6.a<ICubeGlobalListener> r100 = Cube.f257155a;
        Cube.k(this.f257267d);
        ((ArrayList) this.f257269f).clear();
        this.f257270g.clear();
        ((LinkedHashMap) this.f257271h).clear();
        this.f257268e = null;
    }

    public final boolean e() {
        c();
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 == null) goto L10;
        CubeContext r101 = r100.getCubeContext();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.f257169h != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean f() {
        c();
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 == null) goto L10;
        CubeContext r101 = r100.getCubeContext();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.f257170i != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final String getContainerID() {
        c();
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContainerID();
    }

    public final DelegateStatus getLoadState() {
        c();
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 == null) goto L9;
        CubeContext r101 = r100.getCubeContext();
        if (r101 == null) goto L9;
        DelegateStatus r102 = r101.a();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return DelegateStatus.INIT;
    }

    public final d1 getResourceInfo() {
        c();
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 == null) goto L7;
        CubeContext r101 = r100.getCubeContext();
        if (r101 == null) goto L7;
        return r101.f257178q;
    L7:
        return null;
    }

    public final String getSessionId() {
        c();
        IPoiLynxKitDelegate r100 = this.f257267d;
        if (r100 == null) goto L7;
        CubeContext r101 = r100.getCubeContext();
        if (r101 == null) goto L7;
        return r101.f257177p;
    L7:
        return null;
    }

    public final Activity k() {
        Context r100 = getContext();
        Activity r101 = null;
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r100;
    L6:
        if (r102 != null) goto L19;
        Context r103 = getContext();
        if ((r103 instanceof ContextThemeWrapper) == false) goto L10;
        ContextThemeWrapper r104 = (ContextThemeWrapper) r103;
    L11:
        if (r104 == null) goto L13;
        Context r105 = r104.getBaseContext();
    L15:
        if ((r105 instanceof Activity) == false) goto L18;
        r101 = (Activity) r105;
    L18:
        return r101;
    L13:
        r105 = null;
        goto L15
    L10:
        r104 = null;
        goto L11
    L19:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final CubeConfig getCubeConfig() {
        return this.f257264a;
    }

    public final IPoiLynxKitDelegate getCubeInst() {
        return this.f257267d;
    }

    public final long getOpenTime() {
        return this.f257266c;
    }

    public final void b(ICubeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IPoiLynxKitDelegate r101 = this.f257267d;
        if (r101 == null) goto L5;
        r101.addCubeListener(r100);
        Unit r102 = Unit.INSTANCE;
    L6:
        if (r102 == null) goto L8;
        return;
    L8:
        if (((ArrayList) this.f257269f).contains(r100) == false) goto L12;
        ((ArrayList) this.f257269f).add(r100);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        c();
        IPoiLynxKitDelegate r101 = this.f257267d;
        if (r101 == null) goto L6;
        r101.measureLynxUI(r100);
        return;
    }

    public final void setCubeInst(IPoiLynxKitDelegate r100) {
        this.f257267d = r100;
    }

    public final void setOnLynxViewSizeChangedListener(Function0<Unit> r100) {
        this.f257268e = r100;
        if (r100 == null) goto L8;
        IPoiLynxKitDelegate r101 = this.f257267d;
        if (r101 == null) goto L9;
        r101.setOnSizeChangedListener(r100);
        return;
    L9:
        return;
    }

    public final void setOpenTime(long r100) {
        this.f257266c = r100;
    }

    public final void g(CubeInternalSchemaModel r110, final Function1<? super LynxLoadConfig, Unit> r111) {
        Function1<CubeInternalSchemaModel, Unit> r100 = new CubeContainerView$load$1(this, r111);
        String r112 = null;
        if (r110 == null) goto L5;
        String r101 = r110.getSchema();
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r110 = this.f257265b;
    L16:
        if (r110 == null) goto L18;
        r112 = r110.getSchema();
    L18:
        if (r112 != null) goto L20;
    L23:
        if (r102 == false) goto L26;
        j r113 = d.f257194a;
        d.b(getContainerID() + " schema cannot be null if you want to load a lynx card");
        return;
    L26:
        if (this.f257267d != null) goto L31;
        Activity r104 = k();
        if (r104 == null) goto L31;
        d(this, new CubeConfig(r104, "Scene_CubeContainerView", null, null, null, 28, null), r110, false, 4);
    L31:
        if (this.f257267d == null) goto L36;
        this.f257265b = r110;
        c();
        r100.invoke(r110);
        return;
    L36:
        return;
    L20:
        if (StringsKt.isBlank(r112) == true) goto L23;
        r102 = false;
        goto L23
    L9:
        if (StringsKt.isBlank(r101) == true) goto L12;
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final void m(CubeInternalSchemaModel r100, Map<String, Object> r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        c();
        IPoiLynxKitDelegate r103 = this.f257267d;
        if (r103 == null) goto L14;
        IPoiLynxKitDelegate.DefaultImpls.updateData$default(r103, r100, r101, null, 4, null);
        return;
    L14:
        return;
    L4:
        if (r101.isEmpty() == true) goto L7;
        r102 = false;
        goto L8
    }

    public CubeContainerView(Context r310, AttributeSet r311, int r312) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r310, r311, r312);
        this.f257266c = System.currentTimeMillis();
        this.f257269f = new ArrayList();
        this.f257270g = new LinkedHashSet();
        this.f257271h = new LinkedHashMap();
        this.f257272i = new b(this);
        if (r311 == null) goto L23;
        TypedArray r100 = r310.obtainStyledAttributes(r311, new int[]{R.attr.cubeEnableCanvas, R.attr.cubeEnableCanvasOptimize, R.attr.cubeEnableDynamicV8, R.attr.cubeEnableSyncFlush, R.attr.cubeEnterFrom, R.attr.cubeFontScale, R.attr.cubeGroupName, R.attr.cubeHeight, R.attr.cubeHeightSpec, R.attr.cubeIdentifierId, R.attr.cubeJsPaths, R.attr.cubePresetSafePoint, R.attr.cubeReadResourceOnMainThread, R.attr.cubeRenderTemplateOnMainThread, R.attr.cubeScene, R.attr.cubeShareGroup, R.attr.cubeThreadStrategy, R.attr.cubeWidth, R.attr.cubeWidthSpec});
        String r101 = r100.getString(14);
        final String r102 = "Scene_CubeContainerView";
        if (r101 != null) goto L7;
        String r103 = "Scene_CubeContainerView";
    L8:
        String r104 = r100.getString(4);
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        final String r105 = r100.getString(9);
        final float r110 = r100.getFloat(5, -999.0f);
        final boolean r111 = r100.getBoolean(3, false);
        final String r112 = r100.getString(6);
        final boolean r113 = r100.getBoolean(15, false);
        final boolean r114 = r100.getBoolean(0, false);
        final boolean r115 = r100.getBoolean(1, false);
        final boolean r116 = r100.getBoolean(2, false);
        int r106 = r100.getResourceId(10, 0);
        if (r106 == 0) goto L15;
        String[] r210 = getResources().getStringArray(r106);
    L16:
        final int r117 = (int) r100.getDimension(17, -999.0f);
        final int r211 = r100.getInt(18, 1);
        final int r107 = (int) r100.getDimension(7, -999.0f);
        final int r212 = r100.getInt(8, 0);
        final boolean r213 = r100.getBoolean(11, true);
        final int r214 = r100.getInt(16, ThreadStrategyForRendering.MULTI_THREADS.id());
        final boolean r108 = r100.getBoolean(12, false);
        final boolean r109 = r100.getBoolean(13, false);
        r100.recycle();
        Activity r118 = k();
        if (r118 == null) goto L24;
        CubeConfig r119 = new CubeConfig(r118, r103, null, null, null, 28, null);
        cp6.a.a(r119, new CubeContainerView$1$config$1(r102, r105));
        final String[] r120 = r210;
        cp6.a.b(r119, new CubeContainerView$1$config$2(r110, r111, r112, r113, r114, r115, r116, r120, r117, r211, r107, r212, r213, r214));
        cp6.a.c(r119, new CubeContainerView$1$config$3(r108, r109));
        Intrinsics.checkNotNullParameter(r119, "config");
        if (this.f257267d != null) goto L25;
        this.f257264a = r119;
        this.f257267d = Cube.d(r119, null, 6);
        i();
        return;
    L25:
        return;
    L24:
        return;
    L15:
        r210 = null;
        goto L16
    L7:
        r103 = r101;
        goto L8
    }

    public static void l(CubeContainerView r100, String r101, JSONObject r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "name");
        IPoiLynxKitDelegate r103 = r100.f257267d;
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.isJsRuntimeReady() != true) goto L7;
    L8:
        if (r104 == false) goto L12;
        IPoiLynxKitDelegate r105 = r100.f257267d;
        if (r105 == null) goto L14;
        r105.sendEvent(r101, r102);
        return;
    L14:
        return;
    L12:
        CubeEvent r106 = new CubeEvent(r101, r102, -1);
        r100.f257270g.add(r106);
        return;
    L7:
        r104 = false;
        goto L8
    }

    public /* synthetic */ CubeContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void a(CubeContainerView r100, CubeInternalSchemaModel r101, Function1 r102, Function1 r103, Function0 r104) {
        r100.c();
        IPoiLynxKitDelegate r105 = r100.f257267d;
        if (r105 == null) goto L7;
        CubeContext r106 = r105.getCubeContext();
        if (r106 == null) goto L7;
        DelegateStatus r107 = r106.a();
    L8:
        boolean r108 = false;
        if (r107 != DelegateStatus.SUCCESS) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == true) goto L21;
        r100.c();
        IPoiLynxKitDelegate r110 = r100.f257267d;
        if (r110 != null) goto L16;
    L18:
        if (r108 == true) goto L21;
        r104.invoke();
        return;
    L16:
        if (r110.isPreloadSuccess() != true) goto L18;
        r108 = true;
    L21:
        r101.getSchema();
        CubeConfig r111 = r100.f257264a;
        if (r111 == null) goto L27;
        LynxLoadConfig r112 = r111.getLynxLoadConfig();
        if (r112 == null) goto L27;
        if (r102 == null) goto L27;
        r102.invoke(r112);
    L27:
        CubeConfig r113 = r100.f257264a;
        if (r113 == null) goto L33;
        LynxLoadConfig r114 = r113.getLynxLoadConfig();
        if (r114 == null) goto L33;
        Map<String, Object> r115 = r114.getInitData();
        if (r115 == null) goto L33;
    L34:
        kp6.c r116 = kp6.c.f505514a;
        CubeConfig r117 = r100.f257264a;
        r116.getClass();
        r115.put("queryItems", kp6.c.j(r101, r117));
        r103.invoke(r115);
        return;
    L33:
        r115 = new LinkedHashMap();
        goto L34
    L11:
        r109 = false;
    L7:
        r107 = null;
        goto L8
    }

    public static void d(CubeContainerView r100, CubeConfig r101, CubeInternalSchemaModel r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        long r105 = r100.f257266c;
    L7:
        if ((r104 & 8) == 0) goto L9;
        r103 = false;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "schemaModel");
        String r106 = r102.getSchema();
        kp6.c.f505514a.getClass();
        CubeSchemaData r107 = kp6.c.m(r106);
        if (r100.f257267d != null) goto L12;
    L14:
        CubeConfig r108 = null;
        r100.f257267d = null;
        r100.f257265b = r102;
        CubeConfig r109 = kp6.c.l(r107, r101);
        r100.f257264a = r109;
        kp6.a<ICubeGlobalListener> r110 = Cube.f257155a;
        if (r109 == null) goto L18;
        r101 = r109;
    L18:
        r100.f257267d = Cube.c(r101, r102, r105);
        if (r103 == false) goto L42;
        CubeConfig r111 = r100.f257264a;
        if (r111 == null) goto L42;
        LynxLoadConfig r112 = r111.getLynxLoadConfig();
        if (r112 == null) goto L42;
        IPoiLynxKitDelegate r113 = r100.f257267d;
        if (r113 == null) goto L31;
        CubeContext r114 = r113.getCubeContext();
        if (r114 == null) goto L31;
        CubeConfig r115 = r114.f257181t;
        if (r115 == null) goto L31;
        LynxLoadConfig r116 = r115.getLynxLoadConfig();
    L33:
        if (Intrinsics.areEqual(r116, r112) == true) goto L42;
        IPoiLynxKitDelegate r117 = r100.f257267d;
        if (r117 == null) goto L39;
        CubeContext r118 = r117.getCubeContext();
        if (r118 == null) goto L39;
        r108 = r118.f257181t;
    L39:
        if (r108 == null) goto L42;
        r108.setLynxLoadConfig(r112);
    L31:
        r116 = null;
    L42:
        r100.f();
        r100.e();
        Objects.toString(r100.f257264a);
        r100.i();
        return;
    L12:
        if (kp6.c.k(r107) == false) goto L14;
        return;
    L5:
        r105 = 0;
        goto L7
    }
}
