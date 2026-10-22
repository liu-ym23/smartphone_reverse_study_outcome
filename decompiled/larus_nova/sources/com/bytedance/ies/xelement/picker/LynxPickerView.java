package com.bytedance.ies.xelement.picker;

import a86.c;
import a86.e;
import a86.f;
import a86.g;
import a86.h;
import a86.i;
import a86.j;
import a86.k;
import a86.l;
import a86.m;
import android.content.Context;
import android.view.View;
import com.alipay.sdk.m.x.d;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.n;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import d86.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"x-picker"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.picker")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0007¨\u0006)"}, d2 = {"Lcom/bytedance/ies/xelement/picker/LynxPickerView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/ui/view/a;", "", "mode", "", "setMode", "", "disabled", "setDisabled", "(Ljava/lang/Boolean;)V", "Lf6a/a;", "value", "setValue", FilterData.FilterOptionItem.Type.RANGE, "setRange", "rangeKey", "setRangeKey", "start", "setStart", "end", "setEnd", SlcCommonAction.KEY_PARAMS, "setFields", "separator", "setSeparator", "confirmString", "setConfirmString", "cancelString", "setCancelString", "confirmColor", "setConfirmColor", "cancelColor", "setCancelColor", "title", d.f25925o, "titleColor", "setTitleColor", "titleFontSize", "setTitleFontSize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-picker_release"}, k = 1, mv = {1, 6, 0})
public final class LynxPickerView extends UISimpleView<com.lynx.tasm.behavior.ui.view.a> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f250211u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f250212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f6a.a f250214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f6a.a f250215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f6a.a f250216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f250217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f250218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f250219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f250220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f250221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f250222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f250223l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f250224m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f250225n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f250226o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f250227p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f250228q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f250229r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f250230s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final y76.a f250231t;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.lynx.tasm.behavior.ui.view.a r101 = new com.lynx.tasm.behavior.ui.view.a(r100);
        r101.setOnClickListener(new a86.a(this, r100));
        return r101;
    }

    @LynxProp(name = "cancel-color")
    public final void setCancelColor(String r100) {
        this.f250224m = r100;
    }

    @LynxProp(name = "cancel-string")
    public final void setCancelString(String r100) {
        this.f250222k = r100;
    }

    @LynxProp(name = "confirm-color")
    public final void setConfirmColor(String r100) {
        this.f250223l = r100;
    }

    @LynxProp(name = "confirm-string")
    public final void setConfirmString(String r100) {
        this.f250221j = r100;
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(Boolean r100) {
        if (r100 == null) goto L5;
        r100.booleanValue();
        this.f250213b = r100.booleanValue();
        return;
    }

    @LynxProp(name = "end")
    public final void setEnd(String r100) {
        this.f250218g = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, ? extends EventsListener> r100) {
        super.setEvents(r100);
        Objects.toString(r100);
        if (r100 == null) goto L6;
        this.f250228q = r100.containsKey("cancel");
        this.f250229r = r100.containsKey("change");
        this.f250230s = r100.containsKey("columnchange");
        return;
    }

    @LynxProp(name = SlcCommonAction.KEY_PARAMS)
    public final void setFields(String r100) {
        this.f250219h = r100;
    }

    @LynxProp(name = "mode")
    public final void setMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f250212a = r100;
    }

    @LynxProp(name = FilterData.FilterOptionItem.Type.RANGE)
    public final void setRange(f6a.a r100) {
        this.f250215d = r100;
    }

    @LynxProp(name = "range-key")
    public final void setRangeKey(f6a.a r100) {
        this.f250216e = r100;
    }

    @LynxProp(name = "separator")
    public final void setSeparator(String r100) {
        this.f250220i = r100;
    }

    @LynxProp(name = "start")
    public final void setStart(String r100) {
        this.f250217f = r100;
    }

    @LynxProp(name = "title")
    public final void setTitle(String r100) {
        this.f250225n = r100;
    }

    @LynxProp(name = "title-color")
    public final void setTitleColor(String r100) {
        this.f250226o = r100;
    }

    @LynxProp(name = "title-font-size")
    public final void setTitleFontSize(String r100) {
        this.f250227p = r100;
    }

    @LynxProp(name = "value")
    public final void setValue(f6a.a r100) {
        this.f250214c = r100;
    }

    public LynxPickerView(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, r101);
    }

    public static void M(final LynxPickerView r110, Context r111) {
        Intrinsics.checkNotNullParameter(r110, "this$0");
        Intrinsics.checkNotNullParameter(r111, "$context");
        if (r110.f250213b == true) goto L346;
        String r100 = r110.f250212a;
        String r101 = null;
        boolean r102 = true;
        switch(r100.hashCode()) {
            case -1364270024: goto L237;
            case 3076014: goto L167;
            case 3560141: goto L86;
            case 1191572447: goto L8;
            default: goto L357;
        };
    L357:
        return;
    L8:
        if (r100.equals("selector") == false) goto L358;
        f6a.a r103 = r110.f250215d;
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.getType() == ReadableType.Array) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L21;
        r103 = null;
    L21:
        if (r103 == null) goto L348;
        ReadableArray r105 = r103.asArray();
        if (r105 != null) goto L25;
        return;
    L25:
        if (r105.size() > 0) goto L27;
    L29:
        boolean r106 = false;
    L30:
        if (r106 == true) goto L33;
        r105 = null;
    L33:
        if (r105 == null) goto L350;
        ArrayList r107 = new ArrayList();
        if (r105.getType(0) != ReadableType.String) goto L41;
        ArrayList<Object> r108 = r105.asArrayList();
        if (r108 == null) goto L40;
        r107.addAll(r108);
    L48:
        f6a.a r109 = r110.f250214c;
        if (r109 == null) goto L51;
        Integer r112 = Integer.valueOf(r109.asInt());
    L52:
        b r113 = new b();
        r113.f467411c = r111;
        if (r110.f250221j == null) goto L55;
    L59:
        y76.a r114 = new m(r110);
    L60:
        r113.f467424p = r114;
        r113.f467421m = new a86.b(r110);
        r113.f467409a = new c(r110);
        List r115 = CollectionsKt.mutableListOf(new List[]{r107});
        if (r115 != null) goto L63;
        r113.f467422n = null;
    L64:
        if (r112 == null) goto L69;
        List r116 = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(r112.intValue())});
        if (r116 != null) goto L68;
        r113.f467423o = null;
        goto L69
    L68:
        r113.f467423o = new ArrayList(r116);
    L69:
        String r117 = r110.f250223l;
        if (r117 == null) goto L72;
        r113.f467413e = ColorUtils.b(r117);
    L72:
        String r118 = r110.f250224m;
        if (r118 == null) goto L75;
        r113.f467414f = ColorUtils.b(r118);
    L75:
        String r119 = r110.f250225n;
        if (r119 == null) goto L78;
        r113.f467412d = r119;
    L78:
        String r120 = r110.f250226o;
        if (r120 == null) goto L81;
        r113.f467415g = ColorUtils.b(r120);
    L81:
        String r121 = r110.f250227p;
        if (r121 == null) goto L84;
        r113.f467416h = (int) n.a(r121, 0.0f);
    L84:
        new com.bytedance.ies.xelement.picker.view.b(r113).h(r110.mView);
        return;
    L63:
        r113.f467422n = new ArrayList(r115);
        goto L64
    L55:
        if (r110.f250222k != null) goto L59;
        r114 = r110.f250231t;
        if (r114 == null) goto L59;
    L51:
        r112 = null;
        goto L52
    L40:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    L41:
        f6a.a r122 = r110.f250216e;
        if (r122 == null) goto L48;
        String r123 = r122.asString();
        if (r123 == null) goto L48;
        int r124 = r105.size();
        int r125 = 0;
    L46:
        if (r125 >= r124) goto L48;
        r107.add(r105.getMap(r125).getString(r123));
        r125 = r125 + 1;
        goto L46
    L350:
        return;
    L27:
        if (r105.isNull(0) == true) goto L29;
        r106 = true;
        goto L30
    L348:
        return;
    L15:
        if (r103.isNull() == true) goto L17;
        r104 = true;
        goto L18
    L358:
        return;
    L86:
        if (r100.equals("time") == false) goto L359;
        String r126 = r110.f250217f;
        String r127 = r110.f250218g;
        f6a.a r128 = r110.f250214c;
        if (r128 == null) goto L91;
        r101 = r128.asString();
    L91:
        String r129 = r110.f250219h;
        String r130 = r110.f250220i;
        c86.c r131 = new c86.c(r111);
        if (r110.f250221j == null) goto L94;
    L98:
        y76.a r132 = new a86.n(r110);
    L99:
        d86.c r133 = r131.f22733a;
        r133.f467431r = r132;
        r133.f467425l = new a86.d(r110);
        r131.b().f467409a = new e(r110);
        if (r130 != null) goto L102;
        r131.f22734b = ":";
    L104:
        if ("hour".equals(r129) == false) goto L107;
        r131.f22733a.f467427n = new boolean[]{true, false, false};
    L113:
        r131.f22736d = r126;
        r131.f22737e = r127;
        r131.f22735c = r101;
        String r134 = r110.f250223l;
        if (r134 == null) goto L116;
        r131.b().f467413e = ColorUtils.b(r134);
    L116:
        String r135 = r110.f250224m;
        if (r135 == null) goto L119;
        r131.b().f467414f = ColorUtils.b(r135);
    L119:
        String r136 = r110.f250225n;
        if (r136 == null) goto L122;
        r131.b().f467412d = r136;
    L122:
        String r137 = r110.f250226o;
        if (r137 == null) goto L125;
        r131.b().f467415g = ColorUtils.b(r137);
    L125:
        String r138 = r110.f250227p;
        if (r138 == null) goto L128;
        r131.b().f467416h = (int) n.a(r138, 0.0f);
    L128:
        r131.f22733a.f467432s = r131.f22734b;
        SimpleDateFormat r139 = new SimpleDateFormat(r131.a(), Locale.getDefault());     // Catch: Exception -> L131
    L141:
        String r140 = r131.f22736d;
        if (r140 != null) goto L330;
    L146:
        d86.c r141 = r131.f22733a;
        if (r141.f467429p != null) goto L149;
        r141.f467429p = Calendar.getInstance();
        r131.f22733a.f467429p.set(2000, 0, 1, 0, 0, 0);
    L149:
        String r142 = r131.f22737e;
        if (r142 != null) goto L324;
    L154:
        d86.c r143 = r131.f22733a;
        if (r143.f467430q != null) goto L157;
        r143.f467430q = Calendar.getInstance();
        r131.f22733a.f467430q.set(2000, 0, 1, 23, 59, 59);
    L157:
        String r144 = r131.f22735c;
        if (r144 != null) goto L328;
    L162:
        d86.c r145 = r131.f22733a;
        if (r145.f467428o != null) goto L165;
        r145.f467428o = Calendar.getInstance();
    L165:
        new com.bytedance.ies.xelement.picker.view.c(r131.f22733a).h(r110.mView);
        return;
    L328:
        Date r146 = r139.parse(r144);     // Catch: ParseException -> L161
        r131.f22733a.f467428o = Calendar.getInstance();     // Catch: ParseException -> L161
        r131.f22733a.f467428o.setTime(r146);     // Catch: ParseException -> L161
        goto L162
    L324:
        Date r147 = r139.parse(r142);     // Catch: ParseException -> L153
        r131.f22733a.f467430q = Calendar.getInstance();     // Catch: ParseException -> L153
        r131.f22733a.f467430q.setTimeInMillis(r147.getTime());     // Catch: ParseException -> L153
        goto L154
    L330:
        Date r148 = r139.parse(r140);     // Catch: ParseException -> L145
        r131.f22733a.f467429p = Calendar.getInstance();     // Catch: ParseException -> L145
        r131.f22733a.f467429p.setTime(r148);     // Catch: ParseException -> L145
    L131:
        String r149 = r131.f22736d;
        if (r149 == null) goto L134;
        r131.f22736d = r149.replace(r131.f22734b, ":");
    L134:
        String r150 = r131.f22737e;
        if (r150 == null) goto L137;
        r131.f22737e = r150.replace(r131.f22734b, ":");
    L137:
        String r151 = r131.f22735c;
        if (r151 == null) goto L140;
        r131.f22735c = r151.replace(r131.f22734b, ":");
    L140:
        r131.f22734b = ":";
        r139 = new SimpleDateFormat(r131.a(), Locale.getDefault());
        goto L141
    L107:
        if ("minute".equals(r129) == false) goto L110;
        r131.f22733a.f467427n = new boolean[]{true, true, false};
        goto L113
    L110:
        if ("second".equals(r129) == false) goto L112;
        r131.f22733a.f467427n = new boolean[]{true, true, true};
        goto L113
    L112:
        r131.f22733a.f467427n = new boolean[]{true, true, false};
        goto L113
    L102:
        r131.f22734b = r130;
        goto L104
    L94:
        if (r110.f250222k != null) goto L98;
        r132 = r110.f250231t;
        if (r132 == null) goto L98;
    L359:
        return;
    L167:
        if (r100.equals("date") == false) goto L360;
        String r152 = r110.f250217f;
        String r153 = r110.f250218g;
        f6a.a r154 = r110.f250214c;
        if (r154 == null) goto L172;
        r101 = r154.asString();
    L172:
        String r155 = r110.f250219h;
        String r156 = r110.f250220i;
        c86.b r157 = new c86.b(r111);
        if (r110.f250221j == null) goto L175;
    L179:
        y76.a r158 = new k(r110);
    L180:
        d86.c r159 = r157.f22728a;
        r159.f467431r = r158;
        r159.f467425l = new f(r110);
        r157.b().f467409a = new g(r110);
        if (r156 != null) goto L183;
        r157.f22729b = "-";
    L185:
        if (BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR.equals(r155) == false) goto L188;
        r157.f22728a.f467426m = new boolean[]{true, false, false};
    L194:
        r157.f22731d = r152;
        r157.f22732e = r153;
        r157.f22730c = r101;
        String r160 = r110.f250223l;
        if (r160 == null) goto L197;
        r157.b().f467413e = ColorUtils.b(r160);
    L197:
        String r161 = r110.f250224m;
        if (r161 == null) goto L200;
        r157.b().f467414f = ColorUtils.b(r161);
    L200:
        String r162 = r110.f250225n;
        if (r162 == null) goto L203;
        r157.b().f467412d = r162;
    L203:
        String r163 = r110.f250226o;
        if (r163 == null) goto L206;
        r157.b().f467415g = ColorUtils.b(r163);
    L206:
        String r164 = r110.f250227p;
        if (r164 == null) goto L209;
        r157.b().f467416h = (int) n.a(r164, 0.0f);
    L209:
        r157.f22728a.f467432s = r157.f22729b;
        SimpleDateFormat r165 = new SimpleDateFormat(r157.a(), Locale.getDefault());     // Catch: Exception -> L212
    L222:
        String r166 = r157.f22731d;
        if (r166 != null) goto L332;
    L227:
        String r167 = r157.f22732e;
        if (r167 != null) goto L326;
    L232:
        String r168 = r157.f22730c;
        if (r168 != null) goto L322;
    L235:
        new com.bytedance.ies.xelement.picker.view.a(r157.f22728a).h(r110.mView);
        return;
    L322:
        Date r169 = r165.parse(r168);     // Catch: ParseException -> L319
        r157.f22728a.f467428o = Calendar.getInstance();     // Catch: ParseException -> L319
        r157.f22728a.f467428o.setTime(r169);     // Catch: ParseException -> L319
        goto L235
    L326:
        Date r170 = r165.parse(r167);     // Catch: ParseException -> L231
        r157.f22728a.f467430q = Calendar.getInstance();     // Catch: ParseException -> L231
        r157.f22728a.f467430q.setTime(r170);     // Catch: ParseException -> L231
        goto L232
    L332:
        Date r171 = r165.parse(r166);     // Catch: ParseException -> L226
        r157.f22728a.f467429p = Calendar.getInstance();     // Catch: ParseException -> L226
        r157.f22728a.f467429p.setTime(r171);     // Catch: ParseException -> L226
    L212:
        String r172 = r157.f22731d;
        if (r172 == null) goto L215;
        r157.f22731d = r172.replace(r157.f22729b, "-");
    L215:
        String r173 = r157.f22732e;
        if (r173 == null) goto L218;
        r157.f22732e = r173.replace(r157.f22729b, "-");
    L218:
        String r174 = r157.f22730c;
        if (r174 == null) goto L221;
        r157.f22730c = r174.replace(r157.f22729b, "-");
    L221:
        r157.f22729b = "-";
        r165 = new SimpleDateFormat(r157.a(), Locale.getDefault());
        goto L222
    L188:
        if (BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH.equals(r155) == false) goto L191;
        r157.f22728a.f467426m = new boolean[]{true, true, false};
        goto L194
    L191:
        if (BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY.equals(r155) == false) goto L193;
        r157.f22728a.f467426m = new boolean[]{true, true, true};
        goto L194
    L193:
        r157.f22728a.f467427n = new boolean[]{true, true, true};
        goto L194
    L183:
        r157.f22729b = r156;
        goto L185
    L175:
        if (r110.f250222k != null) goto L179;
        r158 = r110.f250231t;
        if (r158 == null) goto L179;
    L360:
        return;
    L237:
        if (r100.equals("multiSelector") == false) goto L361;
        f6a.a r175 = r110.f250215d;
        if (r175 != null) goto L242;
        return;
    L242:
        if (r175.getType() == ReadableType.Array) goto L244;
    L246:
        r102 = false;
    L247:
        if (r102 == true) goto L250;
        r175 = null;
    L250:
        if (r175 == null) goto L355;
        ReadableArray r176 = r175.asArray();
        if (r176 == null) goto L356;
        ArrayList r177 = new ArrayList();
        int r178 = r176.size();
        int r179 = 0;
    L254:
        if (r179 >= r178) goto L274;
        ReadableArray r180 = r176.getArray(r179);
        ArrayList r181 = new ArrayList();
        if (r180.isNull(0) == true) goto L273;
        if (r180.getType(0) != ReadableType.String) goto L264;
        ArrayList<Object> r182 = r180.asArrayList();
        if (r182 == null) goto L263;
        r181.addAll(TypeIntrinsics.asMutableList(r182));
        goto L273
    L263:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
    L264:
        f6a.a r183 = r110.f250216e;
        if (r183 == null) goto L273;
        ReadableArray r184 = r183.asArray();
        if (r184 == null) goto L273;
        String r185 = r184.getString(r179);
        if (r185 == null) goto L273;
        int r186 = r180.size();
        int r187 = 0;
    L271:
        if (r187 >= r186) goto L273;
        r181.add(r180.getMap(r187).getString(r185));
        r187 = r187 + 1;
    L273:
        r177.add(r181);
        r179 = r179 + 1;
        goto L254
    L274:
        f6a.a r188 = r110.f250214c;
        if (r188 == null) goto L279;
        ReadableArray r189 = r188.asArray();
        if (r189 == null) goto L279;
        ArrayList<Object> r190 = r189.asArrayList();
    L281:
        if (TypeIntrinsics.isMutableList(r190) == true) goto L284;
        r190 = null;
    L284:
        if (r190 == null) goto L289;
        ArrayList r191 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r190, 10));
        Iterator<T> r192 = r190.iterator();
    L287:
        if (r192.hasNext() == false) goto L290;
        r191.add(Integer.valueOf((int) ((Number) r192.next()).doubleValue()));
    L290:
        b r193 = new b();
        r193.f467411c = r111;
        if (r110.f250221j == null) goto L293;
    L297:
        y76.a r194 = new l(r110);
    L298:
        r193.f467424p = r194;
        r193.f467421m = new h(r110);
        r193.f467420l = new i(r110);
        r193.f467409a = new j(r110);
        r193.f467422n = new ArrayList(r177);
        if (r191 != null) goto L301;
        r193.f467423o = null;
    L302:
        String r195 = r110.f250223l;
        if (r195 == null) goto L305;
        r193.f467413e = ColorUtils.b(r195);
    L305:
        String r196 = r110.f250224m;
        if (r196 == null) goto L308;
        r193.f467414f = ColorUtils.b(r196);
    L308:
        String r197 = r110.f250225n;
        if (r197 == null) goto L311;
        r193.f467412d = r197;
    L311:
        String r198 = r110.f250226o;
        if (r198 == null) goto L314;
        r193.f467415g = ColorUtils.b(r198);
    L314:
        String r199 = r110.f250227p;
        if (r199 == null) goto L317;
        r193.f467416h = (int) n.a(r199, 0.0f);
    L317:
        new com.bytedance.ies.xelement.picker.view.b(r193).h(r110.mView);
        return;
    L301:
        r193.f467423o = new ArrayList(r191);
        goto L302
    L293:
        if (r110.f250222k != null) goto L297;
        r194 = r110.f250231t;
        if (r194 == null) goto L297;
    L289:
        r191 = null;
    L279:
        r190 = null;
        goto L281
    L356:
        return;
    L355:
        return;
    L244:
        if (r175.isNull() == true) goto L246;
    L361:
        return;
    }

    public LynxPickerView(LynxContext r100, y76.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, null);
    }

    public LynxPickerView(LynxContext r100, y76.a r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r102);
        this.f250212a = "selector";
        this.f250231t = r101;
    }
}
