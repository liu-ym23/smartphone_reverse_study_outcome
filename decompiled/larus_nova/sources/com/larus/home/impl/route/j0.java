package com.larus.home.impl.route;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f346085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f346086b;

    public j0() {
        this.f346085a = CollectionsKt.listOf(new String[]{"//flow/mini_artifact_list_page", "//flow/mini_artifact_template_page", "//flow/mini_artifact_product_page"});
        this.f346086b = "mini_artifact_bottom_animation_router_handled";
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Uri r102 = r100.f267530d;
    L6:
        if (r102 == null) goto L8;
        String r103 = UriProtector.getQueryParameter(r102, this.f346086b);
    L10:
        if (Intrinsics.areEqual(r103, "1") == false) goto L13;
        return false;
    L13:
        int r104 = com.larus.utils.k0.f375428a;
        if (r102 == null) goto L17;
        r101 = r102.toString();
    L17:
        return CollectionsKt.contains(this.f346085a, com.larus.utils.k0.a(r101));
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        if (r100 == null) goto L29;
        if (r101 == null) goto L31;
        Uri r102 = r101.f267530d;
        String r103 = null;
        if (r102 == null) goto L8;
        String r104 = UriProtector.getQueryParameter(r102, "push_from_bottom");
    L9:
        boolean r105 = Intrinsics.areEqual(r104, "1");
        if (r102 == null) goto L16;
        Uri.Builder r106 = r102.buildUpon();
        if (r106 == null) goto L16;
        Uri.Builder r107 = r106.appendQueryParameter(this.f346086b, "1");
        if (r107 == null) goto L16;
        Uri r108 = r107.build();
    L17:
        if (r108 == null) goto L22;
        String r109 = r108.toString();
        if (r109 == null) goto L22;
        r103 = r109;
    L24:
        com.bytedance.router.i r110 = SmartRouter.buildRoute(r100, r103);
        r110.f(r101.f267528b);
        if (r105 == false) goto L27;
        r110.f267555d = R.anim.larus_router_slide_in_bottom;
        r110.f267556e = R.anim.larus_router_no_anim;
    L27:
        r110.d();
        return true;
    L22:
        if (r102 == null) goto L24;
        r103 = r102.toString();
    L16:
        r108 = null;
        goto L17
    L8:
        r104 = null;
        goto L9
    L31:
        return false;
    L29:
        return false;
    }
}
