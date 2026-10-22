package kl3;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final SlcRenderContext a;

    public d(SlcRenderContext r1) {
        this.a = r1;
    }

    public final View a(View r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r4 != null) goto L8;
        return null;
    L8:
        if (this.a != null) goto L10;
        return null;
    L10:
        return SlcRenderContext.f(r3, r4);
    }
}
