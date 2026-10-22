package com.bytedance.ee.bear.bitable.homepage.chart.utils;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.docs.icon.entity.IconShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final void a(LarkAvatarView r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bitableUrl");
        tz7.a.C7809a r103 = new tz7.a.C7809a();
        Intrinsics.checkNotNullParameter(r101, "url");
        r103.f548073k = r101;
        IconShape r104 = IconShape.SQUARE;
        Intrinsics.checkNotNullParameter(r104, "shape");
        r103.f548075m = r104;
        Boolean r105 = Boolean.FALSE;
        obb.a r106 = new obb.a(r105, r105, null);
        Intrinsics.checkNotNullParameter(r106, KtvSubElement.CONTAINER);
        r103.f548076n = r106;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        Intrinsics.checkNotNullParameter(r102, "meta");
        r103.f548074l = r102;
        r100.j(new tz7.a(r103));
        r100.setOval(false);
    }
}
