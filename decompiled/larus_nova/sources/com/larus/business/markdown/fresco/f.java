package com.larus.business.markdown.fresco;

import android.graphics.Rect;
import android.text.Spanned;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.t;
import wsc.j;
import wsc.n;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f320508h;

    @Override // wsc.j, lsc.x
    public final Object a(h r110, t r111) {
        Intrinsics.checkNotNullParameter(r110, "configuration");
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_PROPS);
        String r100 = n.f561168a.b(r111);
        Integer r101 = n.f561171d.a(r111);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        Integer r103 = n.f561172e.a(r111);
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
        TextView r105 = this.f320508h.f320506h;
        com.larus.business.markdown.api.extplugin.image.c r106 = null;
        if (r105 == null) goto L13;
        CharSequence r107 = r105.getText();
    L15:
        if ((r107 instanceof Spanned) == false) goto L17;
        Spanned r108 = (Spanned) r107;
    L18:
        if (r108 != null) goto L23;
        CharSequence r109 = this.f320508h.f320507i;
        if ((r109 instanceof Spanned) == false) goto L22;
        r108 = (Spanned) r109;
        goto L23
    L22:
        r108 = null;
    L23:
        if (r108 == null) goto L41;
        com.larus.business.markdown.api.extplugin.image.c[] r112 = (com.larus.business.markdown.api.extplugin.image.c[]) r108.getSpans(r102, r104, com.larus.business.markdown.api.extplugin.image.c.class);
        if (r112 == null) goto L39;
        int r113 = r112.length;
        int r114 = 0;
    L27:
        if (r114 >= r113) goto L39;
        com.larus.business.markdown.api.extplugin.image.c r115 = r112[r114];
        if (r115.getStartIndex() == r102) goto L31;
    L35:
        boolean r116 = false;
    L36:
        if (r116 == true) goto L37;
        r114 = r114 + 1;
        goto L27
    L37:
        r106 = r115;
        goto L39
    L31:
        if (r115.getEndIndex() != r104) goto L35;
        if (Intrinsics.areEqual(r115.getUrl(), r100) == false) goto L35;
        r116 = true;
    L39:
        if (r106 == null) goto L41;
        return r106;
    L41:
        return super.a(r110, r111);
    L17:
        r108 = null;
        goto L18
    L13:
        r107 = null;
        goto L15
    L9:
        return super.a(r110, r111);
    L5:
        return super.a(r110, r111);
    }

    public f(e r110, Integer r111, int r112, Integer r113, int r114, Rect r115, com.larus.business.markdown.api.extplugin.image.a r116, Map<String, ? extends Object> r117) {
        this.f320508h = r110;
        super(r111, r112, r113, Integer.valueOf(r114), r115, r116, r117);
    }
}
