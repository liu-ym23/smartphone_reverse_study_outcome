package tx1;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.elder.LiveElderModeConfig;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f547810a = null;

    public b() {
    }

    static {
        f547810a = new b();
    }

    public static float a() {
        IMiddlewareHostBusiness r100 = (IMiddlewareHostBusiness) k.f(IMiddlewareHostBusiness.class);
        if (r100 == null) goto L35;
        LiveElderModeConfig r101 = r100.elderModeConfig();
        if (r101 != null) goto L8;
        return 1.0f;
    L8:
        if (r101.getEnableElderMode() == true) goto L10;
        return 1.0f;
    L10:
        if (r101.getFontScale() != LiveElderModeConfig.FontScale.FONT_SCALE_BY_RESOURCE) goto L25;
        Application r102 = jc1.a.b();
        if (r102 == null) goto L18;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L18;
        Configuration r104 = r103.getConfiguration();
        if (r104 == null) goto L18;
        float r105 = r104.fontScale;
    L19:
        double r106 = r105;
        if (r106 > 1.0d) goto L23;
        return 1.0f;
    L23:
        if (r106 < 1.25d) goto L33;
    L32:
        return 1.25f;
    L33:
        return 1.15f;
    L18:
        r105 = 1.0f;
        goto L19
    L25:
        LiveElderModeConfig.FontScale r107 = r101.getFontScale();
        Intrinsics.checkNotNullParameter(r107, "$this$adjustFontScale");
        int r108 = a.f547809a[r107.ordinal()];
        if (r108 != 1) goto L28;
        return 1.0f;
    L28:
        if (r108 == 2) goto L33;
        if (r108 == 3) goto L32;
        return 1.0f;
    L35:
        return 1.0f;
    }
}
