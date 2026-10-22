package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.popup;

import android.view.View;
import cd4.g;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.container.IJsbService;
import com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t36.d;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends BottomSheetBehavior.b implements com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m16.b f202541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f202542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f202543c;

    @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.b
    public final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
    }

    public a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        this.f202541a = r100;
        this.f202542b = new AtomicBoolean(false);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final String Sn(d r100) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r100, "cj_biz");
    }

    @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.b
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        if (this.f202542b.getAndSet(true) == true) goto L30;
        kd4.a r101 = new kd4.a("cj_anniex_event_popup_frame_change", null, 6);
        m16.b r102 = this.f202541a;
        if (this.f202543c != null) goto L18;
        d r103 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r102, null);
        if (r103 == null) goto L9;
        String r104 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r103, "cj_enable_lifecycle_event");
    L10:
        if (r104 == null) goto L12;
        Boolean r105 = Boolean.valueOf(r104.equals("1"));
    L13:
        if (r105 == null) goto L15;
        boolean r106 = r105.booleanValue();
    L16:
        this.f202543c = Boolean.valueOf(r106);
        goto L18
    L15:
        r106 = false;
        goto L16
    L12:
        r105 = null;
        goto L13
    L9:
        r104 = null;
    L18:
        if (Intrinsics.areEqual(this.f202543c, Boolean.TRUE) == false) goto L31;
        d r107 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r102, null);
        JSONObject r108 = r101.f502721b;
        if (r107 == null) goto L24;
        String r109 = com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.c(r107, "cj_session_id");
        if (r109 == null) goto L24;
        KtSafeMethodExtensionKt.safePut(r108, "session_id", r109);
    L24:
        Intrinsics.checkNotNullParameter(r101, "event");
        IJsbService r110 = (IJsbService) ve4.b.a(IJsbService.class);
        if (r110 == null) goto L32;
        g r111 = r110.getEventHelper();
        if (r111 == null) goto L33;
        r111.c(r101);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a
    public final d U6(m16.b r100, ia.c r101) {
        return com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.base.a.C2930a.e(r100, r101);
    }
}
