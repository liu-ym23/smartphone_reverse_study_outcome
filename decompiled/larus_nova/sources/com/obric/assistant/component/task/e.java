package com.obric.assistant.component.task;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements jl9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f388860a = null;

    static {
        f388860a = new e();
    }

    public e() {
    }

    @Override // jl9.a
    public final View a(jl9.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        return new OngoingTaskItemSingleIconView(r100.getContext(), r101, 6, 0);
    }

    @Override // jl9.a
    public final void b(View r110, jl9.b r111, final kl9.u r112) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "taskBasicInfo");
        if ((r110 instanceof OngoingTaskItemSingleIconView) == false) goto L5;
        final OngoingTaskItemSingleIconView r113 = (OngoingTaskItemSingleIconView) r110;
    L6:
        if (r113 == null) goto L102;
        final Function2<String, Map<String, String>, Unit> r114 = r111.f499558b;
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        TextView r100 = r113.f388803a.f389608e;
        kl9.x r101 = r112.f503987i;
        String r102 = "";
        if (r101 == null) goto L12;
        String r103 = r101.f504011a;
        if (r103 == null) goto L12;
    L13:
        r100.setText(r103);
        kl9.x r104 = r112.f503987i;
        if (r104 == null) goto L19;
        String r105 = r104.f504012b;
        if (r105 == null) goto L19;
        r102 = r105;
    L19:
        r113.f388803a.f389606c.setText(r102);
        Map<String, String> r106 = r112.f503997s;
        if (r106 == null) goto L22;
        String r107 = r106.get(DyVerifyEventConstants.EventParam.BIZ_SCENE);
    L24:
        if (Intrinsics.areEqual(r107, "clarify") == true) goto L33;
        Map<String, String> r108 = r112.f503997s;
        if (r108 == null) goto L28;
        String r109 = r108.get(DyVerifyEventConstants.EventParam.BIZ_SCENE);
    L30:
        if (Intrinsics.areEqual(r109, "call_user") == true) goto L33;
        r113.f388803a.f389606c.setTextColor(v19.c.a(R.attr.larus_neutral_50, r113.getContext(), R.color.larus_neutral_50));
    L34:
        TextView r115 = r113.f388803a.f389606c;
        boolean r116 = o0.d(r102);
        boolean r117 = false;
        if (r116 == false) goto L37;
        int r118 = 0;
    L38:
        r115.setVisibility(r118);
        List<kl9.p> r119 = r112.f503988j;
        if (r119 == null) goto L51;
        Iterator<T> r120 = r119.iterator();
    L42:
        if (r120.hasNext() == false) goto L49;
        Object r121 = r120.next();
        if (((kl9.p) r121) == null) goto L46;
        boolean r122 = true;
    L47:
        if (r122 == false) goto L42;
    L50:
        final kl9.p r123 = (kl9.p) r121;
    L52:
        r113.f388803a.f389607d.setVisibility(0);
        SimpleDraweeView r124 = r113.f388803a.f389607d;
        if (r123 == null) goto L55;
        String r125 = r123.f503958a;
    L56:
        r124.setContentDescription(r125);
        Context r126 = r113.getContext();
        SimpleDraweeView r127 = r113.f388803a.f389607d;
        if (r123 == null) goto L59;
        String r128 = r123.f503959b;
    L60:
        if (r123 == null) goto L62;
        String r129 = r123.f503960c;
    L63:
        Intrinsics.checkNotNullParameter(r126, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r127, "imageView");
        boolean r130 = v19.h.f552477a;
        if (v19.h.b(r126) == false) goto L75;
        if (r129 != null) goto L67;
    L70:
        boolean r131 = true;
    L71:
        if (r131 == true) goto L75;
        r128 = r129;
        goto L75
    L67:
        if (r129.length() == 0) goto L70;
        r131 = false;
    L75:
        if (o0.d(r128) == false) goto L94;
        if (r128 == null) goto L92;
        Uri r132 = UriProtector.parse(r128);
        if (r132 == null) goto L92;
        if (Intrinsics.areEqual(r132.getScheme(), "res") == false) goto L92;
        String r133 = r132.getLastPathSegment();
        if (r133 == null) goto L88;
        Integer r134 = StringsKt.toIntOrNull(r133);
        if (r134 == null) goto L88;
        int r135 = r134.intValue();
    L89:
        if (r135 == 0) goto L92;
        r127.setImageResource(r135);
        r117 = true;
    L88:
        r135 = 0;
    L92:
        if (r117 == true) goto L95;
        ImageLoaderKt.u(r127, r128, "multitask");
    L95:
        e1.d(r113.f388803a.f389607d, new d(r113, r114, r123, r112));
        return;
    L94:
        r127.setImageDrawable(null);
        goto L95
    L62:
        r129 = null;
        goto L63
    L59:
        r128 = null;
        goto L60
    L55:
        r125 = null;
        goto L56
    L46:
        r122 = false;
        goto L47
    L49:
        r121 = null;
        goto L50
    L51:
        r123 = null;
        goto L52
    L37:
        r118 = 8;
        goto L38
    L28:
        r109 = null;
    L33:
        r113.f388803a.f389606c.setTextColor(v19.c.a(R.attr.larus_primary_50, r113.getContext(), R.color.larus_primary_50));
        goto L34
    L22:
        r107 = null;
    L12:
        r103 = "";
        goto L13
    L102:
        return;
    L5:
        r113 = null;
        goto L6
    }
}
