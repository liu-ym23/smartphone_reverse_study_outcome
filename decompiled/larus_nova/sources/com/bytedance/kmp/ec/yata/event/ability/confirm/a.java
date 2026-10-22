package com.bytedance.kmp.ec.yata.event.ability.confirm;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f251597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f251598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f251599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f251600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f251601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f251602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f251603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f251604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Float f251605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f251606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f251607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f251608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f251609m;

    public a(Map<String, ? extends Object> r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, SlcCommonAction.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(r101, "onNextSuccess");
        Intrinsics.checkNotNullParameter(r102, "onNextFailed");
        this.f251597a = r100;
        this.f251598b = r101;
        this.f251599c = r102;
        Object r103 = r100.get("title");
        Number r104 = null;
        if ((r103 instanceof String) == false) goto L5;
        String r105 = (String) r103;
    L6:
        this.f251600d = r105;
        Object r106 = r100.get("message");
        if ((r106 instanceof String) == false) goto L9;
        String r107 = (String) r106;
    L10:
        this.f251601e = r107;
        Object r108 = r100.get("primary_btn");
        if ((r108 instanceof String) == false) goto L13;
        String r109 = (String) r108;
    L14:
        this.f251602f = r109;
        Object r110 = r100.get("secondary_btn");
        if ((r110 instanceof String) == false) goto L17;
        String r111 = (String) r110;
    L18:
        this.f251603g = r111;
        Object r112 = r100.get("head_image");
        if ((r112 instanceof String) == false) goto L21;
        String r113 = (String) r112;
    L22:
        this.f251604h = r113;
        Object r114 = r100.get("head_wh_ratio");
        if ((r114 instanceof Number) == false) goto L25;
        Number r115 = (Number) r114;
    L26:
        if (r115 == null) goto L28;
        Float r116 = Float.valueOf(r115.floatValue());
    L29:
        this.f251605i = r116;
        Object r117 = r100.get("icon_image");
        if ((r117 instanceof String) == false) goto L32;
        String r118 = (String) r117;
    L33:
        this.f251606j = r118;
        Object r119 = r100.get("icon_image_round");
        if ((r119 instanceof Boolean) == false) goto L36;
        Boolean r120 = (Boolean) r119;
    L37:
        this.f251607k = r120;
        Object r121 = r100.get("icon_image_radius");
        if ((r121 instanceof Number) == false) goto L40;
        Number r122 = (Number) r121;
    L41:
        if (r122 == null) goto L43;
        float r123 = r122.floatValue();
    L44:
        this.f251608l = r123;
        Object r124 = r100.get("icon_image_edge");
        if ((r124 instanceof Number) == false) goto L47;
        r104 = (Number) r124;
    L47:
        if (r104 == null) goto L49;
        float r125 = r104.floatValue();
    L50:
        this.f251609m = r125;
        return;
    L49:
        r125 = 60.0f;
        goto L50
    L43:
        r123 = 12.0f;
        goto L44
    L40:
        r122 = null;
        goto L41
    L36:
        r120 = null;
        goto L37
    L32:
        r118 = null;
        goto L33
    L28:
        r116 = null;
        goto L29
    L25:
        r115 = null;
        goto L26
    L21:
        r113 = null;
        goto L22
    L17:
        r111 = null;
        goto L18
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
