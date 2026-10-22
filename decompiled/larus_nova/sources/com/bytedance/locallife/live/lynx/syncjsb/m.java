package com.bytedance.locallife.live.lynx.syncjsb;

import android.graphics.Paint;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f260606d;

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "splitTextByWidth";
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
        this.f260606d = new Paint();
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        String r100 = w.f(r110, "text");
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Float r102 = w.a(r110, "font_size");
        if (r102 == null) goto L44;
        float r103 = r102.floatValue();
        Float r111 = w.a(r110, "width");
        if (r111 == null) goto L42;
        float r112 = j0.b(r111.floatValue());
        this.f260606d.setTextSize(j0.b(r103) + 0.5f);
        int r104 = r100.length() - 1;
        int r105 = 0;
    L18:
        if ((r104 - r105) <= 1) goto L28;
        int r106 = (r105 + r104) / 2;
        String r107 = r100.substring(0, r106 + 1);
        float r108 = this.f260606d.measureText(r107);
        if (r108 != r112) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == true) goto L40;
        if (r108 < r112) goto L26;
        r104 = r106;
        goto L18
    L26:
        r105 = r106;
    L40:
        return a.d(this, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("split_text", r107)}), 1);
    L22:
        r109 = false;
        goto L23
    L28:
        r107 = r100.substring(0, r105 + 1);
        float r113 = this.f260606d.measureText(r107);
        if (r105 == r104) goto L31;
        String r114 = r100.substring(0, r104 + 1);
        float r115 = this.f260606d.measureText(r114);
    L33:
        if (r115 > r112) goto L36;
        r107 = r114;
        goto L40
    L36:
        if (r113 <= r112) goto L40;
        r107 = "";
        goto L40
    L31:
        r115 = r113;
        r114 = r107;
        goto L33
    L42:
        return a.b("width isNull");
    L44:
        return a.b("font_size isNull");
    L11:
        return a.b("text isNullOrEmpty");
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
