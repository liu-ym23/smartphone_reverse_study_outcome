package com.bytedance.applet.model.menu;

import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.applet.aibridge.menu.WidgetMenuItem;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public final Function7<List<WidgetMenuItem>, com.bytedance.applet.aibridge.menu.b, WidgetContainer, String, String, JSONObject, Function2<? super String, ? super String, Unit>, Unit> a;
    public final Function2<Object, Function0<Unit>, Unit> b;
    public final Function2<Object, Function0<Unit>, Unit> c;
    public final Function2<Object, Function0<Unit>, Unit> d;
    public final Map<String, Function2<Object, Function0<Unit>, Unit>> e;
    public final Function0<Unit> f;

    public g() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "WidgetMenuConfig(showMenu=" + this.a + ", deleteAction=" + this.b + ", shareAction=" + this.c + ", reportAction=" + this.d + ", systemActionMap=" + this.e + ", onCollectionChanged=" + this.f + ')';
    }

    public g(a r4, b r5, c r6, d r7, e r8) {
        Map<String, Function2<Object, Function0<Unit>, Unit>> r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(SystemAction.DELETE.getValue(), r5), TuplesKt.to(SystemAction.SHARE.getValue(), r6), TuplesKt.to(SystemAction.REPORT.getValue(), r7)});
        Intrinsics.checkNotNullParameter(r4, "showMenu");
        Intrinsics.checkNotNullParameter(r5, "deleteAction");
        Intrinsics.checkNotNullParameter(r6, "shareAction");
        Intrinsics.checkNotNullParameter(r7, "reportAction");
        Intrinsics.checkNotNullParameter(r0, "systemActionMap");
        Intrinsics.checkNotNullParameter(r8, "onCollectionChanged");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r0;
        this.f = r8;
    }
}
