package com.bytedance.awemeopen.domain.share;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share.e;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.share.serviceapi.AoSharePanelService;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class InternalShareDomain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AoSharePanelService f198468a;

    public InternalShareDomain() {
        this.f198468a = (AoSharePanelService) j64.a.a(AoSharePanelService.class);
    }

    public static void a(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "shareUrl");
        Intrinsics.checkNotNullParameter(r101, "callback");
        AoPool.a(new InternalShareDomain$getShortLinkShare$1(r100, r101));
    }

    public final void b(Activity r110, long r111, String r112, String r113, String r114, String r115, e r210, JSONObject r211, final Function2 r212) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, "shareTitle");
        Intrinsics.checkNotNullParameter(r113, "shareDesc");
        Intrinsics.checkNotNullParameter(r114, "shareUrl");
        Intrinsics.checkNotNullParameter(r210, "shareHelper");
        Intrinsics.checkNotNullParameter(r212, "dismissCallback");
        AoSharePanelService r100 = this.f198468a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.Z1(r110, r112, r113, r114, r115, new a(r210), r211, new InternalShareDomain$showSharePanel$2(r212));
    }
}
