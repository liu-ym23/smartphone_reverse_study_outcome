package com.larus.business.markdown.impl.markwon;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.view.KeyEvent;
import io.noties.markwon.core.spans.v;

/* JADX INFO: loaded from: classes4.dex */
public final class l implements io.noties.markwon.ext.tables.c {
    public l() {
    }

    @Override // io.noties.markwon.ext.tables.c
    public final Drawable a(CharSequence r100, int r101, int r102) {
        if (r100 != null) goto L4;
    L7:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return null;
    L12:
        if ((r100 instanceof Spanned) == false) goto L14;
        KeyEvent.Callback r104 = v.a((Spanned) r100);
    L16:
        if ((r104 instanceof ow8.a) == false) goto L18;
        ow8.a r105 = (ow8.a) r104;
    L19:
        if (r105 != null) goto L22;
        return null;
    L22:
        if (r105.q(r101, r102) == true) goto L24;
        return null;
    L24:
        return new ColorDrawable(r105.getSelectedColor());
    L18:
        r105 = null;
        goto L19
    L14:
        r104 = null;
        goto L16
    L4:
        if (r100.length() == 0) goto L7;
        r103 = false;
        goto L9
    }
}
