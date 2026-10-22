package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z implements jl9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f321212a = null;

    static {
        f321212a = new z();
    }

    public z() {
    }

    @Override // jl9.a
    public final View a(jl9.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        return new OngoingTaskItemSingleIconView(r100.getContext(), r101, 6, 0);
    }

    @Override // jl9.a
    public final void b(View r100, jl9.b r101, final kl9.u r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "taskBasicInfo");
        if ((r100 instanceof OngoingTaskItemSingleIconView) == false) goto L5;
        final OngoingTaskItemSingleIconView r103 = (OngoingTaskItemSingleIconView) r100;
    L6:
        if (r103 == null) goto L55;
        final Function2<String, Map<String, String>, Unit> r104 = r101.f499558b;
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        TextView r105 = r103.f321159a.f320844e;
        kl9.x r106 = r102.f503987i;
        String r107 = "";
        if (r106 == null) goto L12;
        String r108 = r106.f504011a;
        if (r108 == null) goto L12;
    L13:
        r105.setText(r108);
        kl9.x r109 = r102.f503987i;
        if (r109 == null) goto L19;
        String r110 = r109.f504012b;
        if (r110 == null) goto L19;
        r107 = r110;
    L19:
        r103.f321159a.f320842c.setText(r107);
        TextView r111 = r103.f321159a.f320842c;
        if (o0.d(r107) == false) goto L22;
        int r112 = 0;
    L23:
        r111.setVisibility(r112);
        List<kl9.p> r113 = r102.f503988j;
        if (r113 == null) goto L36;
        Iterator<T> r114 = r113.iterator();
    L27:
        if (r114.hasNext() == false) goto L34;
        Object r115 = r114.next();
        if (((kl9.p) r115) == null) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == false) goto L27;
    L35:
        final kl9.p r117 = (kl9.p) r115;
    L37:
        r103.f321159a.f320843d.setVisibility(0);
        SimpleDraweeView r118 = r103.f321159a.f320843d;
        if (r117 == null) goto L40;
        String r119 = r117.f503958a;
    L41:
        r118.setContentDescription(r119);
        Context r120 = r103.getContext();
        SimpleDraweeView r121 = r103.f321159a.f320843d;
        if (r117 == null) goto L44;
        String r122 = r117.f503959b;
    L45:
        if (r117 == null) goto L47;
        String r123 = r117.f503960c;
    L48:
        f.c(r120, r121, r122, r123, null);
        e1.d(r103.f321159a.f320843d, new y(r103, r104, r117, r102));
        return;
    L47:
        r123 = null;
        goto L48
    L44:
        r122 = null;
        goto L45
    L40:
        r119 = null;
        goto L41
    L31:
        r116 = false;
        goto L32
    L34:
        r115 = null;
        goto L35
    L36:
        r117 = null;
        goto L37
    L22:
        r112 = 8;
    L12:
        r108 = "";
        goto L13
    L55:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
