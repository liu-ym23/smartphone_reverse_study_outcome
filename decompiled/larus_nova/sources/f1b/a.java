package f1b;

import android.app.Application;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import swb.j;
import swb.p;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends y0b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qpc.a f475090a;

    public a() {
        this.f475090a = (qpc.a) ApiUtils.getApi(qpc.a.class);
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r110) {
        if (r110 == null) goto L5;
        String r100 = UriProtector.getQueryParameter(r110, "key");
    L6:
        if (r110 == null) goto L8;
        String r101 = UriProtector.getQueryParameter(r110, "entityId");
    L9:
        if (r110 == null) goto L11;
        String r111 = UriProtector.getQueryParameter(r110, "size");
    L12:
        boolean r102 = true;
        if (r100 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L40;
        if (r101 != null) goto L22;
    L25:
        boolean r104 = true;
    L26:
        if (r104 == true) goto L41;
        if (r111 != null) goto L29;
    L32:
        if (r102 == true) goto L44;
        p.a r105 = p.f543779a;
        Application r106 = LarkContext.getApplication();
        float r112 = CastFloatProtector.parseFloat(r111);
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r107 = r106.getResources();
        int r108 = (int) ((r112 / WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density) + 0.5f);
        qpc.a r109 = this.f475090a;
        long r113 = CastLongProtector.parseLong(r101);
        Resources r114 = LarkContext.getApplication().getResources();
        Resource r115 = r109.getAvatarImageResource(r113, r100, r108, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()).density, "webp", null);
        if (r115 == null) goto L42;
        String r116 = r115.f461377b;
        if (r116 != null) goto L39;
        return null;
    L39:
        return new WebResourceResponse(j.i(r116), Charset.defaultCharset().name(), VFSFiles.f444819b.k(r116));
    L42:
        return null;
    L44:
        return null;
    L29:
        if (r111.length() == 0) goto L32;
        r102 = false;
        goto L32
    L41:
        return null;
    L22:
        if (r101.length() == 0) goto L25;
        r104 = false;
        goto L26
    L40:
        return null;
    L15:
        if (r100.length() == 0) goto L18;
        r103 = false;
        goto L19
    L11:
        r111 = null;
        goto L12
    L8:
        r101 = null;
        goto L9
    L5:
        r100 = null;
        goto L6
    }
}
