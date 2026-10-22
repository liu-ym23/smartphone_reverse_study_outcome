package com.ss.android.lark.coremd.facade.bizext.image;

import android.content.Context;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f419649b = null;

    static {
        f419649b = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.coremd.facade.bizext.image.a
    public final a.b a(int r110, int r111, final o r210) {
        Intrinsics.checkNotNullParameter(r210, "parseContext");
        Context r100 = r210.getContext();
        final j r101 = r210.getTheme();
        IMThemeExtend.a r102 = IMThemeExtend.f419630s;
        final IMImageThemeData r103 = (IMImageThemeData) r102.b(new IMImageSizeInterceptorImpl$obtainMaxImageWidth$themeData$1(r101));
        final Context r104 = r210.getContext();
        final int r105 = ((Number) IMContextExtend.A.b(new IMImageSizeInterceptorImpl$obtainMaxImageWidth$maxImageWidth$1(r210))).intValue();
        int r106 = ((Number) r102.b(new IMImageSizeInterceptorImpl$obtainMaxImageWidth$1(r104, r105, r103, r210))).intValue();
        int r107 = UIUtils.dp2px(r100, 240.0f);
        float r108 = DeviceUtils.getScreenDensity(r100);
        int r109 = (int) (r110 * r108);
        int r112 = (int) (r111 * r108);
        int r113 = UIHelper.dp2px(40.0f);
        if (r109 != 0) goto L5;
        r109 = UIUtils.dp2px(r100, 80.0f);
    L5:
        if (r112 != 0) goto L7;
        int r114 = UIUtils.dp2px(r100, 80.0f);
    L9:
        if (r109 != 0) goto L11;
    L17:
        boolean r115 = false;
    L18:
        Log.i("IMImageSizeCoordinator", "imageWidth:" + r109 + ", imageHeight:" + r114 + ", isLargeImage:" + r115);
        if (r115 == false) goto L21;
        int r116 = UIHelper.dp2px(150.0f);
        int r117 = UIHelper.dp2px(240.0f);
        int r118 = (int) (((r114 * 1.0f) / r109) * r116);
        int r119 = r116;
        int r120 = r119;
    L32:
        return new a.b(r119, r118, r120, r117, r115);
    L21:
        if (r109 > r106) goto L23;
        if (r114 > r107) goto L23;
    L24:
        if (r109 >= r113) goto L26;
        int r121 = r113;
    L27:
        if (r114 < r113) goto L30;
        r113 = r114;
    L30:
        r120 = r121;
        r118 = r114;
        r119 = r109;
        r117 = r113;
        goto L32
    L26:
        r121 = r109;
    L23:
        int[] r122 = ImageUtils.g(r109, r114, r106, r107, 1, 1);
        r109 = r122[0];
        r114 = r122[1];
        goto L24
    L11:
        if ((r114 / r109) < 3) goto L17;
        if (r109 <= UIHelper.dp2px(200.0f)) goto L17;
        if (r106 <= UIHelper.dp2px(150.0f)) goto L17;
        r115 = true;
        goto L18
    L7:
        r114 = r112;
        goto L9
    }
}
