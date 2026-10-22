package com.larus.dora.impl.noti_v3.overview.ui;

import com.bytedance.router.SmartRouter;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3Binding;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class z implements UrlSpanTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusDoraPageNotiV3Binding f336447a;

    public z(LarusDoraPageNotiV3Binding r100) {
        this.f336447a = r100;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, "pp") == false) goto L6;
        com.bytedance.router.i r101 = SmartRouter.buildRoute(this.f336447a.f333062a.getContext(), "//flow/webview");
        r101.f267554c.putExtra("link_url", "https://www.doubao.com/dora/legal/dora_push/privacy");
        r101.f267555d = R.anim.larus_router_slide_in_right;
        r101.f267556e = R.anim.larus_router_no_anim;
        r101.d();
        return;
    }
}
