package com.lynx.animax.loader;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.util.UriUtil;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import java.util.Map;
import u4a.e;
import u4a.m;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXLoaderRequest implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f380304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimaXLoaderScheme f380305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f380306c;

    public final e a() {
        Map<String, Object> r100 = this.f380306c;
        if (r100 == null) goto L10;
        Object r101 = r100.get("image_width");
        Object r102 = this.f380306c.get("image_height");
        if ((r101 instanceof Integer) == true) goto L7;
        return null;
    L7:
        if ((r102 instanceof Integer) == true) goto L9;
        return null;
    L9:
        return new e(r101, r102);
    L10:
        return null;
    }

    public final String b() {
        String r100 = this.f380304a;
        String r101 = null;
        if (r100 != null) goto L5;
        Uri r102 = null;
    L6:
        if (r102 != null) goto L8;
        String r103 = null;
    L9:
        boolean r104 = true;
        if (UriUtil.LOCAL_ASSET_SCHEME.equals(r103) == true) goto L29;
        if (r102 != null) goto L13;
        String r105 = null;
    L15:
        if ("file".equals(r105) == true) goto L29;
        if (r102 == null) goto L20;
        r101 = r102.getScheme();
    L20:
        if ("https".equals(r101) == false) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == true) goto L29;
        r104 = false;
        goto L29
    L22:
        if ("http".equals(r101) == true) goto L25;
        r106 = false;
        goto L26
    L13:
        r105 = r102.getScheme();
    L29:
        if (r104 == true) goto L41;
        String r107 = this.f380304a;
        AnimaXLoaderScheme r108 = this.f380305b;
        if (r108 != null) goto L34;
        return r107;
    L34:
        if (r108 != AnimaXLoaderScheme.ASSET) goto L37;
        return y4a.e.a(r107);
    L37:
        if (r108 == AnimaXLoaderScheme.FILE) goto L39;
        return r107;
    L39:
        return new Uri.Builder().scheme("file").authority("").path(r107).build().toString();
    L41:
        return this.f380304a;
    L8:
        r103 = r102.getScheme();
        goto L9
    L5:
        r102 = UriProtector.parse(r100);
        goto L6
    }

    public static AnimaXLoaderRequest createRequest(String r100) {
        return new AnimaXLoaderRequest(r100, null);
    }

    public AnimaXLoaderRequest(String r100, Map<String, Object> r101) {
        this.f380304a = r100;
        this.f380306c = r101;
        if (r101 != null) goto L5;
    L7:
        this.f380305b = null;
        return;
    L5:
        if (r101.get("scheme") == null) goto L7;
        this.f380305b = AnimaXLoaderScheme.values()[((Integer) r101.get("scheme")).intValue()];
    }

    public static AnimaXLoaderRequest createRequestWithParams(String r100, JavaOnlyMap r101) {
        return new AnimaXLoaderRequest(r100, r101);
    }
}
