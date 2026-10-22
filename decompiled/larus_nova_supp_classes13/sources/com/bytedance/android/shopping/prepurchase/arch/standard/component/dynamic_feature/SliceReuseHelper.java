package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ecom.arch.slice.style.SlcStyle;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.utils.y;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SliceReuseHelper {
    public final Lazy a;
    public final a b;
    public final LinearLayout c;
    public final Function1<l, Unit> d;

    public final LinkedHashMap<String, g> b() {
        return (LinkedHashMap) this.a.getValue();
    }

    public final View c() {
        g r0 = b().get("std_deal_button");
        if (r0 != null) goto L5;
        return null;
    L5:
        SlcTemplateViewHelper r2 = r0.c;
        if (r2 != null) goto L8;
        return null;
    L8:
        View r3 = (View) ((Map) r0.a.getValue()).get("std_deal_button_cart");
        if (r3 != null) goto L14;
        View r4 = r2.d("cart");
        if (r4 == null) goto L15;
        ((Map) r0.a.getValue()).put("std_deal_button_cart", r4);
        return r4;
    L15:
        return null;
    L14:
        return r3;
    }

    public final void d() {
        Iterator<Map.Entry<String, g>> r0 = b().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().a();
        goto L4
    L6:
        b().clear();
    }

    public final void a(List<? extends com.bytedance.android.ecom.arch.slice.g> r22, Map<String, ? extends Object> r23) {
        Intrinsics.checkNotNullParameter(r22, "slicesToBind");
        LinkedHashMap r2 = new LinkedHashMap();
        this.c.removeAllViewsInLayout();
        Iterator<T> r1 = r22.iterator();
    L4:
        if (r1.hasNext() == false) goto L113;
        com.bytedance.android.ecom.arch.slice.slices.template.d r6 = (com.bytedance.android.ecom.arch.slice.g) r1.next();
        String r3 = r6.getSliceId();
        if (r3 == null) goto L4;
        SlcTemplateViewHelper r4 = (g) b().remove(r3);
        SlcTemplateViewHelper r7 = null;
        boolean r8 = true;
        if (Intrinsics.areEqual(r6.getSliceType(), "Template") == true) goto L10;
        if (Intrinsics.areEqual(r6.getSliceType(), "Lynx") == false) goto L4;
        if ((r6 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L4;
        com.bytedance.android.ecom.arch.slice.slices.template.d r5 = r6;
        com.bytedance.android.ecom.arch.slice.slices.template.c r9 = r5.b();
        if (r9 == null) goto L108;
        String r10 = r9.d();
        if (r10 == null) goto L108;
        String r11 = r5.getSliceId();
        if (r11 == null) goto L108;
        if (Intrinsics.areEqual(r5.getSliceId(), "std_deal_button") == true) goto L52;
        Map r14 = r5.getConfig();
        if (r14 != null) goto L49;
    L51:
        r8 = false;
        goto L52
    L49:
        if (mq.b.c(r14, "disable_append_data", false) != true) goto L51;
    L52:
        if (r8 == true) goto L60;
        Uri.Builder r12 = UriProtector.parse(r10).buildUpon();
        Map r13 = r5.getData();
        if (r13 == null) goto L59;
        Iterator r15 = r13.entrySet().iterator();
    L57:
        if (r15.hasNext() == false) goto L59;
        Map.Entry r16 = (Map.Entry) r15.next();
        r12.appendQueryParameter((String) r16.getKey(), String.valueOf(r16.getValue()));
    L59:
        Unit r17 = Unit.INSTANCE;
        r10 = r12.build().toString();
    L60:
        String r18 = AnchorV4DataManager.d;
        if (r18 == null) goto L63;
        r10 = p0.g(r10, "identifier", r18);
    L63:
        if (r4 == null) goto L65;
        l r19 = r4.d;
    L66:
        if (r19 == null) goto L76;
        l r20 = r4.d;
        if (Intrinsics.areEqual(r11, "std_deal_button") == false) goto L73;
        Map r21 = r5.getData();
        if (r21 == null) goto L72;
        r20.updateData(r21);
    L72:
        this.c.postDelayed(new j(r20, r5, r10), 500);
    L109:
        if (r4 == null) goto L4;
        r2.put(r3, r4);
        View r24 = r4.e;
        if (r24 == null) goto L4;
        this.c.addView(r24, new LinearLayout.LayoutParams(-1, -2));
        goto L4
    L73:
        Map r25 = r5.getData();
        if (r25 == null) goto L109;
        r20.updateData(r25);
        goto L109
    L76:
        if (r4 == null) goto L78;
        r4.a();
    L78:
        FrameLayout r26 = new FrameLayout(this.c.getContext());
        l r27 = this.b.a(this.c.getContext(), r10, r26, r5.getData());
        if (r27 == null) goto L108;
        Function1<l, Unit> r28 = this.d;
        if (r28 == null) goto L84;
        Unit r29 = (Unit) r28.invoke(r27);
    L84:
        SlcStyle r30 = r5.getStyle();
        if (r30 == null) goto L91;
        Map r31 = r30.getAttrs();
        if (r31 == null) goto L91;
        String r32 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r31, "height", null);
        if (r32 == null) goto L91;
        Integer r33 = Integer.valueOf(CastIntegerProtector.parseInt(r32));
    L92:
        SlcStyle r110 = r5.getStyle();
        if (r110 == null) goto L97;
        Map r111 = r110.getAttrs();
        if (r111 == null) goto L97;
        Boolean r34 = Boolean.valueOf(mq.b.c(r111, "wrap_content", false));
    L98:
        if (r33 == null) goto L101;
        r7 = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(r33));
    L103:
        if (r7 == null) goto L107;
        View r35 = r27.getHybridView();
        if (r35 == null) goto L107;
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
        r36.height = r7.intValue();
        Unit r37 = Unit.INSTANCE;
        r35.setLayoutParams(r36);
    L107:
        r7 = new g("Lynx", r5, null, r27, r26, 4);
        goto L108
    L101:
        if (Intrinsics.areEqual(r34, Boolean.TRUE) == false) goto L103;
        r7 = -2;
    L97:
        r34 = null;
    L91:
        r33 = null;
        goto L92
    L65:
        r19 = null;
    L108:
        r4 = r7;
        goto L109
    L10:
        if (r4 == null) goto L12;
        SlcTemplateViewHelper r38 = r4.c;
    L13:
        if (r38 == null) goto L17;
        int r39 = y.a;
        if (y.h(r4.b, r6) == false) goto L17;
    L18:
        if (r8 == false) goto L22;
        if (r4 == null) goto L21;
        r7 = r4.c;
    L21:
        Intrinsics.checkNotNull(r7);
    L25:
        SlcTemplateViewHelper.c(r7, r6, MapsKt.mapOf(TuplesKt.to("native", r23)), 4);
        if (r8 == false) goto L28;
        Intrinsics.checkNotNull(r4);
    L29:
        r2.put(r3, r4);
        View r40 = r4.e;
        if (r40 == null) goto L4;
        this.c.addView(r40, new LinearLayout.LayoutParams(-1, -2));
        goto L4
    L28:
        r4 = new g("Template", r6, r7, null, r7.b, 8);
        goto L29
    L22:
        if (r4 == null) goto L24;
        r4.a();
    L24:
        r7 = this.b.b();
    L17:
        r8 = false;
        goto L18
    L12:
        r38 = null;
        goto L13
    L113:
        Iterator<T> r41 = b().values().iterator();
    L115:
        if (r41.hasNext() == false) goto L117;
        ((g) r41.next()).a();
        goto L115
    L117:
        b().clear();
        b().putAll(r2);
        if (this.c.getChildCount() != 0) goto L141;
        this.c.requestLayout();
        return;
    }

    public final boolean e(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        g r0 = b().get("std_deal_button");
        if (r0 != null) goto L5;
        return false;
    L5:
        l r1 = r0.d;
        if (r1 != null) goto L8;
        return false;
    L8:
        r1.sendJsEvent(r3, r4);
        return true;
    }

    public SliceReuseHelper(a r2, LinearLayout r3, Function1<? super l, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        Intrinsics.checkNotNullParameter(r3, "hostView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(SliceReuseHelper$cacheItemMap$2.INSTANCE);
    }

    public final void f(List<? extends com.bytedance.android.ecom.arch.slice.g> r5, String r6, Map<String, ? extends Object> r7) {
        if (r6 == null) goto L19;
        if (r5 == null) goto L31;
        Iterator<T> r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Object r2 = r8.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.g) r2).getSliceId(), r6) == false) goto L7;
    L12:
        com.bytedance.android.ecom.arch.slice.g r3 = (com.bytedance.android.ecom.arch.slice.g) r2;
        if (r3 == null) goto L44;
        g r9 = b().get(r6);
        if (r9 == null) goto L45;
        SlcTemplateViewHelper r10 = r9.c;
        if (r10 == null) goto L46;
        r10.b(r3, MapsKt.mapOf(TuplesKt.to("native", r7)), null);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L11:
        r2 = null;
        goto L12
    L31:
        return;
    L19:
        if (r5 == null) goto L48;
        Iterator<T> r11 = r5.iterator();
    L22:
        if (r11.hasNext() == false) goto L49;
        com.bytedance.android.ecom.arch.slice.g r12 = (com.bytedance.android.ecom.arch.slice.g) r11.next();
        String r4 = r12.getSliceId();
        if (r4 == null) goto L22;
        g r13 = b().get(r4);
        if (r13 == null) goto L22;
        SlcTemplateViewHelper r14 = r13.c;
        if (r14 == null) goto L22;
        r14.b(r12, MapsKt.mapOf(TuplesKt.to("native", r7)), null);
        goto L22
    L49:
        return;
    }
}
