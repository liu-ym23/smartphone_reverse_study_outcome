package com.larksuite.component.card.cardcontainer;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.resources.e;
import com.larksuite.component.card.service.d;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import idb.f;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UniversalCardLynxRender {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f283207g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILarkLynxContainer f283208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larksuite.component.card.cardcontainer.a f283209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.component.card.cardcontainer.b f283210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f283211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JsonObject f283212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f283213f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f283215b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f283214a, r101.f283214a) == true) goto L12;
            return false;
        L12:
            if (this.f283215b == r101.f283215b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f283214a.hashCode() * 31;
            if (this.f283215b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "CardInitData(initData=" + this.f283214a + ", needUpdate=" + this.f283215b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "initData");
            this.f283214a = r100;
            this.f283215b = r101;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<CardData, CardData> f283216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<CardContext, CardContext> f283217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<CardConfig, CardConfig> f283218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Integer> f283219d;

        public c(Function1 r100, Function1 r101) {
            this.f283216a = null;
            this.f283217b = r100;
            this.f283218c = r101;
            this.f283219d = null;
        }
    }

    static {
    }

    public UniversalCardLynxRender(final Lifecycle r100) {
        this.f283209b = new com.larksuite.component.card.cardcontainer.a();
        this.f283210c = new com.larksuite.component.card.cardcontainer.b();
        this.f283211d = LazyKt.lazy(new UniversalCardLynxRender$cardServiceManager$2(r100, this));
    }

    public final void b(c r100) {
        Log.i("UniversalCardLynxRender", "reRender");
        if (this.f283208a != null) goto L6;
        Log.e("UniversalCardLynxRender", "UniversalCardLynxRender is not init please try invoke create");
        return;
    L6:
        Object r101 = ((HashMap) this.f283209b.getBizExtra()).get("card_share_data");
        if ((r101 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L9;
        com.larksuite.component.card.cardcontainer.c r102 = (com.larksuite.component.card.cardcontainer.c) r101;
    L10:
        if (r102 != null) goto L13;
        Log.e("UniversalCardLynxRender", "reRender shareData is null");
        return;
    L13:
        CardData r103 = r102.f283234b;
        CardContext r104 = r102.f283235c;
        CardConfig r105 = r102.f283236d;
        Integer r106 = r102.f283238f;
        if (r100 == null) goto L27;
        Function1<CardData, CardData> r107 = r100.f283216a;
        if (r107 == null) goto L18;
        r103 = r107.invoke(r103);
    L18:
        Function1<CardContext, CardContext> r108 = r100.f283217b;
        if (r108 == null) goto L21;
        r104 = r108.invoke(r104);
    L21:
        Function1<CardConfig, CardConfig> r109 = r100.f283218c;
        if (r109 == null) goto L24;
        r105 = r109.invoke(r105);
    L24:
        Function0<Integer> r110 = r100.f283219d;
        if (r110 == null) goto L27;
        r106 = r110.invoke();
    L27:
        c(r103, r104, r105, r106);
        return;
    L9:
        r102 = null;
        goto L10
    }

    public final void c(CardData r110, CardContext r111, CardConfig r210, Integer r211) {
        Intrinsics.checkNotNullParameter(r110, "cardData");
        Intrinsics.checkNotNullParameter(r111, "cardContext");
        Intrinsics.checkNotNullParameter(r210, "cardConfig");
        if (this.f283208a != null) goto L6;
        Log.e("UniversalCardLynxRender", "UniversalCardLynxRender is not init please try invoke create");
        return;
    L6:
        gz7.c r100 = (gz7.c) ((d) this.f283211d.getValue()).getService(gz7.c.class);
        if (r100 == null) goto L9;
        r100.init();
    L9:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        HashMap<String, AudioInfo> r101 = r110.getCardContent().getAttachment().getAudios();
        if (r101 != null) goto L12;
    L15:
        boolean r102 = true;
    L17:
        if ((!r102) == true) goto L19;
    L23:
        ILarkLynxContainer r103 = this.f283208a;
        if (r103 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r103 = null;
    L26:
        ILarkLynxContainer r112 = r103;
        this.f283213f = r211;
        if (r211 == null) goto L29;
        r112.updateSize(View.MeasureSpec.makeMeasureSpec(r211.intValue(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    L29:
        HashMap<String, Object> r113 = new HashMap();
        com.larksuite.component.card.cardcontainer.c r104 = new com.larksuite.component.card.cardcontainer.c(r112.getLynxView().getContext(), r110, r111, r210, new cz7.a(), r211);
        r113.put("card_share_data", r104);
        com.larksuite.component.card.cardcontainer.a r105 = this.f283209b;
        r105.getClass();
        Intrinsics.checkNotNullParameter("card_share_data", "key");
        Intrinsics.checkNotNullParameter(r104, RuleConditionBean.BIZ_DATA_KEY);
        r105.f283224a.put("card_share_data", r104);
        UniversalCardRuntimeJsLoader.b r106 = new UniversalCardRuntimeJsLoader().a();
        if (r106 == null) goto L34;
        String r107 = r106.f283221a;
        if (r107 == null) goto L34;
        com.larksuite.component.card.cardcontainer.b r108 = this.f283210c;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "templateJsVersion");
        r108.f283230e = r107;
    L34:
        String r109 = ty7.a.a().getDebugUrl();
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L51;
        if (r109 != null) goto L38;
    L41:
        boolean r114 = true;
    L42:
        if (r114 == true) goto L51;
        if (r112.hasRendered() == false) goto L49;
        a r115 = a(this, r110, r210, r111, true);
        Log.d("UniversalCardLynxRender", "has Rendered, updateData, needUpdate=" + r115.f283215b);
        if (r115.f283215b == false) goto L48;
        r112.updateData(r115.f283214a, r113);
        return;
    L48:
        r112.updateShareData(r113);
        return;
    L49:
        Log.d("UniversalCardLynxRender", "first render");
        r112.render(r109, a(this, r110, r210, r111, false).f283214a, r113);
        return;
    L38:
        if (r109.length() == 0) goto L41;
        r114 = false;
    L51:
        if (r112.hasRendered() == false) goto L56;
        Log.i("UniversalCardLynxRender", "has Rendered, updateData");
        a r116 = a(this, r110, r210, r111, true);
        if (r116.f283215b == false) goto L55;
        r112.updateData(r116.f283214a, r113);
        return;
    L55:
        r112.updateShareData(r113);
        return;
    L56:
        if (r106 == null) goto L61;
        Log.i("UniversalCardLynxRender", "before get init data2");
        a r117 = a(this, r110, r210, r111, false);
        if (r106.f283223c == null) goto L60;
        Log.i("UniversalCardLynxRender", "render by bundle");
        r112.render(r106.f283223c, r117.f283214a, r113);
        return;
    L60:
        Log.e("UniversalCardLynxRender", "render error");
        return;
    L61:
        Log.e("UniversalCardLynxRender", "js info error");
        return;
    L19:
        if (f.a().isEnable("universalcard.audio.enable") == false) goto L23;
        e r118 = (e) ((d) this.f283211d.getValue()).getService(e.class);
        if (r118 == null) goto L23;
        r118.g(r110);
        goto L23
    L12:
        if (r101.isEmpty() == true) goto L15;
        r102 = false;
        goto L17
    }

    public static a a(UniversalCardLynxRender r100, CardData r101, CardConfig r110, CardContext r111, boolean r112) {
        r100.getClass();
        TraceEvent.beginSection("UniversalCardLynxRender.getInitData");
        CardDataUtils.f283938a.getClass();
        JsonObject r113 = CardDataUtils.j(r110, r111, r101, r112);
        long r102 = System.currentTimeMillis();
        if (r113.has("__lynx_timing_flag") == false) goto L5;
        JsonElement r103 = r113.remove("__lynx_timing_flag");
    L6:
        JsonElement r104 = r113.getAsJsonObject(PerfLog.PARAM_KEY_CONTEXT_ID).remove("traceID");
        JsonObject r105 = r100.f283212e;
        if (r105 == null) goto L9;
        r105.remove("__lynx_timing_flag");
        r105.getAsJsonObject(PerfLog.PARAM_KEY_CONTEXT_ID).remove("traceID");
    L9:
        boolean r106 = Intrinsics.areEqual(r113, r100.f283212e);
        if (r103 == null) goto L12;
        r113.add("__lynx_timing_flag", r103);
    L12:
        r113.getAsJsonObject(PerfLog.PARAM_KEY_CONTEXT_ID).add("traceID", r104);
        r100.f283212e = r113;
        Log.i("UniversalCardLynxRender", "compare json cost " + (System.currentTimeMillis() - r102));
        if (r106 == false) goto L15;
        Log.i("UniversalCardLynxRender", "isContentSame json same");
        boolean r107 = true;
    L16:
        if (r107 == false) goto L18;
        Log.i("UniversalCardLynxRender", "initData same");
        int r114 = UniversalCardMonitorUtils.f283716a;
        UniversalCardMonitorUtils.b(true, r101.getUniversalCardID(), r111.getRenderTrace());
        a r108 = new a("", false);
    L19:
        TraceEvent.endSection("UniversalCardLynxRender.getInitData");
        return r108;
    L18:
        Log.i("UniversalCardLynxRender", "content not same");
        int r115 = UniversalCardMonitorUtils.f283716a;
        UniversalCardMonitorUtils.b(false, r101.getUniversalCardID(), r111.getRenderTrace());
        r108 = new a(r113.toString(), true);
        goto L19
    L15:
        r107 = false;
        goto L16
    L5:
        r103 = null;
        goto L6
    }
}
