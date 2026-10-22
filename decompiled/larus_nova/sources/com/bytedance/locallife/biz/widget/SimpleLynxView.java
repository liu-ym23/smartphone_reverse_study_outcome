package com.bytedance.locallife.biz.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.locallife.common.utils.i;
import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.bytedance.locallife.dito.common.lynx.e;
import com.bytedance.locallife.poi.newdetail.widget.lynx.PoiSimpleLynxView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kp6.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B\u0019\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0016\u0010\u001aB!\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0016\u0010\u001dJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0003H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/biz/widget/SimpleLynxView;", "Landroid/widget/FrameLayout;", "", "", "", "getLynxParams", "Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "getDelegate", "()Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;", "setDelegate", "(Lcom/bytedance/locallife/cube/api/i/IPoiLynxKitDelegate;)V", "delegate", "Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", ce.f26391f, "Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", "getJsEventSubscriber", "()Lcom/bytedance/ies/xbridge/event/JsEventSubscriber;", "jsEventSubscriber", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public class SimpleLynxView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f257017h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPoiLynxKitDelegate f257018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.locallife.biz.widget.a f257019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f257020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CubeInternalSchemaModel f257021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f257022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f257023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f257024g;

    public static final class a {
    }

    public static final class b implements JsEventSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleLynxView f257025a;

        public b(SimpleLynxView r100) {
            this.f257025a = r100;
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            this.f257025a.d(r100);
        }
    }

    static {
    }

    public void d(Js2NativeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
    }

    public void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxUrl");
    }

    public Map<String, Object> getLynxParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = this.f257020c;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put(EventConstant.Key.RAW_DATA, r101);
        com.bytedance.locallife.biz.widget.a r102 = this.f257019b;
        if (r102 == null) goto L8;
        r100.putAll(r102.a());
    L8:
        r100.putAll(this.f257022e);
        return r100;
    }

    public final IPoiLynxKitDelegate getDelegate() {
        return this.f257018a;
    }

    public final JsEventSubscriber getJsEventSubscriber() {
        return this.f257024g;
    }

    public SimpleLynxView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f257022e = new LinkedHashMap();
        this.f257024g = new b(this);
    }

    public final void setDelegate(IPoiLynxKitDelegate r100) {
        this.f257018a = r100;
    }

    public SimpleLynxView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f257022e = new LinkedHashMap();
        this.f257024g = new b(this);
    }

    public static boolean f(PoiSimpleLynxView r100, Map r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "params");
        r100.f257022e.putAll(r101);
        IPoiLynxKitDelegate r102 = r100.f257018a;
        CubeConfig r103 = null;
        if (r102 == null) goto L7;
        CubeContext r104 = r102.getCubeContext();
        if (r104 == null) goto L7;
        DelegateStatus r105 = r104.a();
    L9:
        if (r105 == DelegateStatus.SUCCESS) goto L11;
        return false;
    L11:
        Map<String, Object> r106 = r100.getLynxParams();
        CubeInternalSchemaModel r107 = r100.f257021d;
        if (r107 == null) goto L17;
        c r108 = c.f505514a;
        IPoiLynxKitDelegate r109 = r100.f257018a;
        if (r109 == null) goto L16;
        r103 = r109.getCubeConfig();
    L16:
        r108.getClass();
        JSONObject r110 = c.j(r107, r103);
    L18:
        r106.put("queryItems", r110);
        IPoiLynxKitDelegate r111 = r100.f257018a;
        if (r111 == null) goto L21;
        IPoiLynxKitDelegate.DefaultImpls.updateData$default(r111, r107, r106, null, 4, null);
    L21:
        return true;
    L17:
        r110 = new JSONObject();
    L7:
        r105 = null;
        goto L9
    }

    public SimpleLynxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f257022e = new LinkedHashMap();
        this.f257024g = new b(this);
    }

    public static CubeConfig c(SimpleLynxView r100, Activity r101, final String r110, final Map r111) {
        r100.getClass();
        CubeConfig r102 = new CubeConfig(r101, "cube_poi_detail", null, null, null, 28, null);
        final String r103 = "poi_detail_ng";
        cp6.a.a(r102, new SimpleLynxView$commonPoiCubeConfig$1(r103, r110));
        cp6.a.b(r102, new SimpleLynxView$commonPoiCubeConfig$2(r111));
        return r102;
    }

    public static /* synthetic */ void b(SimpleLynxView r100, String r101, String r102, String r110, Map r111, com.bytedance.locallife.biz.widget.a r112) {
        r100.a(r101, r102, r110, r111, r112, MapsKt.emptyMap());
    }

    public final void a(String r100, String r101, String r102, Map<String, String> r110, com.bytedance.locallife.biz.widget.a r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r112, "initialRuntimeLynxParams");
        if (r100 != null) goto L5;
        return;
    L5:
        this.f257019b = r111;
        this.f257020c = r101;
        ((LinkedHashMap) this.f257022e).clear();
        this.f257022e.putAll(r112);
        String r103 = i.a(r100, r110);
        if (r103 != null) goto L8;
        r103 = r100;
    L8:
        CubeInternalSchemaModel r104 = c.e(c.f505514a, r103);
        this.f257021d = r104;
        View r113 = null;
        if (this.f257018a != null) goto L42;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L35
        Context r106 = getContext();     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L35
        CubeConfig r107 = c(this, (Activity) r106, r102, e.b());     // Catch: Throwable -> L35
        IPoiLynxKitDelegate r108 = Cube.d(r107, r104, 4);     // Catch: Throwable -> L35
        String r109 = r104.getSchema();     // Catch: Throwable -> L35
        if (r109 != null) goto L13;
    L16:
        boolean r114 = true;
    L17:
        if (r114 == true) goto L33;
        if (r108 == null) goto L22;
        CubeContext r115 = r108.getCubeContext();     // Catch: Throwable -> L35
        if (r115 == null) goto L22;
        DelegateStatus r116 = r115.a();     // Catch: Throwable -> L35
    L24:
        if (r116 == DelegateStatus.SUCCESS) goto L33;
        if (r108 == null) goto L29;
        CubeContext r117 = r108.getCubeContext();     // Catch: Throwable -> L35
        if (r117 == null) goto L29;
        DelegateStatus r118 = r117.a();     // Catch: Throwable -> L35
    L31:
        if (r118 == DelegateStatus.INIT) goto L33;
        r108 = Cube.d(r107, null, 6);     // Catch: Throwable -> L35
    L29:
        r118 = null;
    L22:
        r116 = null;
    L33:
        Object r119 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r119) == false) goto L40;
        r119 = null;
    L40:
        this.f257018a = (IPoiLynxKitDelegate) r119;
        goto L42
    L13:
        if (StringsKt.isBlank(r109) == true) goto L16;
        r114 = false;
    L35:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L42:
        if (this.f257018a != null) goto L44;
        return;
    L44:
        e(r100);
        if (this.f257023f == true) goto L50;
        IPoiLynxKitDelegate r121 = this.f257018a;
        if (r121 == null) goto L49;
        r121.addCubeListener(new com.bytedance.locallife.biz.widget.b(this));
    L49:
        this.f257023f = true;
    L50:
        IPoiLynxKitDelegate r122 = this.f257018a;
        if (r122 == null) goto L58;
        LinkedHashMap r123 = new LinkedHashMap();
        r123.put("appTheme", "light");
        com.bytedance.locallife.biz.widget.a r124 = this.f257019b;
        if (r124 == null) goto L57;
        Map<String, Object> r125 = r124.getGlobalProps();
        if (r125 == null) goto L57;
        r123.putAll(r125);
    L57:
        r122.updateGlobalProps(r123, r104);
    L58:
        IPoiLynxKitDelegate r126 = this.f257018a;
        if (r126 == null) goto L63;
        CubeContext r127 = r126.getCubeContext();
        if (r127 == null) goto L63;
        DelegateStatus r128 = r127.a();
    L65:
        if (r128 != DelegateStatus.SUCCESS) goto L78;
        Map<String, Object> r129 = getLynxParams();
        c r130 = c.f505514a;
        IPoiLynxKitDelegate r131 = this.f257018a;
        if (r131 == null) goto L69;
        CubeConfig r132 = r131.getCubeConfig();
    L70:
        r130.getClass();
        r129.put("queryItems", c.j(r104, r132));
        IPoiLynxKitDelegate r133 = this.f257018a;
        if (r133 == null) goto L73;
        IPoiLynxKitDelegate.DefaultImpls.updateData$default(r133, r104, r129, null, 4, null);
    L73:
        IPoiLynxKitDelegate r134 = this.f257018a;
        if (r134 == null) goto L81;
        View r135 = r134.realView();
        if (r135 == null) goto L81;
        r135.setVisibility(4);
    L81:
        IPoiLynxKitDelegate r136 = this.f257018a;
        if (r136 == null) goto L86;
        View r137 = r136.realView();
        if (r137 == null) goto L86;
        ViewParent r138 = r137.getParent();
    L87:
        if (r138 != null) goto L95;
        IPoiLynxKitDelegate r139 = this.f257018a;
        if (r139 == null) goto L91;
        r113 = r139.realView();
    L91:
        addView(r113);
        return;
    L95:
        return;
    L86:
        r138 = null;
        goto L87
    L69:
        r132 = null;
        goto L70
    L78:
        IPoiLynxKitDelegate r140 = this.f257018a;
        if (r140 == null) goto L81;
        r140.load(r104, new SimpleLynxView$loadLynxData$1(this));
    L63:
        r128 = null;
        goto L65
    }
}
