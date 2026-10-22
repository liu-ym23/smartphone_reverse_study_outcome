package kl3;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SlcRenderContext f503848a;

    public d(SlcRenderContext r100) {
        this.f503848a = r100;
    }

    public final View a(View r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 != null) goto L8;
        return null;
    L8:
        if (this.f503848a != null) goto L10;
        return null;
    L10:
        return SlcRenderContext.f(r100, r101);
    }
}
