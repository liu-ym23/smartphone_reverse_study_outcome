package com.bytedance.ies.bullet.service.webkit;

import android.webkit.JavascriptInterface;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ies.bullet.core.h;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/InjectData;", "", "", "getGlobalProps", "getGlobalPropsHDT", "getInitialProps", "getInjectInitData", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class InjectData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f248148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f248149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f248150c;

    public InjectData() {
        this(null, 7);
    }

    @Deprecated(message = "use getGlobalProps instead")
    @JavascriptInterface
    public final String getGlobalPropsHDT() {
        if (h.f246501h.f246502a == true) goto L6;
        return "{\"error\":\"only available in debug env, use getGlobalProps instead\"}";
    L6:
        com.bytedance.ies.bullet.service.base.h.R();
        String r100 = this.f248148a;
        if (r100 != null) goto L10;
        return SliceInitService.DEFAULT_SWITCH;
    L10:
        return r100;
    }

    @JavascriptInterface
    public final String getGlobalProps() {
        com.bytedance.ies.bullet.service.base.h.R();
        String r100 = this.f248148a;
        if (r100 != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        return r100;
    }

    @JavascriptInterface
    public final String getInitialProps() {
        com.bytedance.ies.bullet.service.base.h.R();
        String r100 = this.f248149b;
        if (r100 != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        return r100;
    }

    @JavascriptInterface
    public final String getInjectInitData() {
        com.bytedance.ies.bullet.service.base.h.R();
        String r100 = this.f248150c;
        if (r100 != null) goto L6;
        return SliceInitService.DEFAULT_SWITCH;
    L6:
        return r100;
    }

    public /* synthetic */ InjectData(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null, null);
    }

    public InjectData(String r100, String r101, String r102) {
        this.f248148a = r100;
        this.f248149b = r101;
        this.f248150c = r102;
    }
}
