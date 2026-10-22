package com.bytedance.android.shopping.yata.biz.popup.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements hl3.d {
    public l a;
    public final Lazy b;
    public final Context c;
    public final String d;
    public final hl3.a e;

    @Override // hl3.c
    public final View getView() {
        return (FrameLayout) this.b.getValue();
    }

    @Override // hl3.c
    public final void release() {
        l r0 = this.a;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // hl3.d
    public Context getContext() {
        return this.c;
    }

    @Override // hl3.d
    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter("pageVisibilityChange", "eventName");
        l r0 = this.a;
        if (r0 == null) goto L6;
        r0.sendJsEvent("pageVisibilityChange", r3);
        return;
    }

    @Override // hl3.c
    public final void b(il3.a r13, b r14) {
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r14, "firstCallback");
        r14.run();
        String r15 = UriProtector.getQueryParameter(UriProtector.parse(this.d), "url");
        if (r15 != null) goto L5;
    L7:
        r15 = null;
    L8:
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        Context r0 = getContext();
        l r16 = ECLiveHybridUtil.b(r0, r15, null, (FrameLayout) this.b.getValue(), new d(this), null, null, false, null, null, false, 4068);
        if (r16 == null) goto L16;
        this.a = r16;
        boolean r1 = ((Boolean) r13.a("split_mode", Boolean.FALSE)).booleanValue();
        int r2 = ((Number) r13.a("ec_split_screen_width", 0)).intValue();
        int r17 = ((Number) r13.a("ec_split_screen_height", 0)).intValue();
        if (r1 == false) goto L17;
        r16.updateScreenMetrics(r2, r17);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (k.c(r15) == false) goto L7;
        goto L7
    }

    public e(Context r2, String r3, com.bytedance.android.shopping.yata.biz.popup.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "schema");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.b = LazyKt.lazy(new PopupLiveHybridComponent$parentView$2(this));
    }
}
