package d7a;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.m;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public a() {
    }

    public static String b(Context r100, String r101, boolean r102) {
        if ((r100 instanceof LynxContext) == true) goto L5;
        return r101;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L81;
        LynxContext r103 = com.lynx.tasm.utils.a.a(r100);
        if (r103 != null) goto L10;
        LLog.e("ImageUrlRedirectUtils", "redirecting url failed due to no context available");
        return r101;
    L10:
        if (r102 == false) goto L12;
        m r104 = r103.getAsyncImageInterceptor();
    L13:
        if (r104 == null) goto L82;
        String r105 = r103.getTemplateUrl();
        if (TraceEvent.isTracingStarted() == false) goto L17;
        HashMap r106 = new HashMap();
        r106.put("url", r101);
        TraceEvent.beginSection("Interceptor.shouldRedirectImageUrl", r106);
    L17:
        String r107 = null;
        String r108 = r104.shouldRedirectImageUrl(r101);     // Catch: Exception -> L20
    L22:
        TraceEvent.endSection("Interceptor.shouldRedirectImageUrl");
        boolean r109 = false;
        if (r108 == null) goto L26;
    L54:
        r107 = r108;
    L55:
        if (r107 != null) goto L57;
        return r101;
    L57:
        if (r107.startsWith("res:///") == false) goto L74;
        int r110 = 7;
    L60:
        if (r110 >= r107.length()) goto L67;
        char r111 = r107.charAt(r110);
        if (r111 < '0') goto L68;
        if (r111 > '9') goto L68;
        r110 = r110 + 1;
    L68:
        if (r109 == true) goto L74;
        int r112 = r107.indexOf(46);
        if (r112 >= 0) goto L84;
        r112 = r107.length();
    L84:
        return "res:///" + r103.getResources().getIdentifier(r107.substring(7, r112), "drawable", r103.getPackageName());
    L67:
        r109 = true;
    L74:
        return r107;
    L26:
        if (TextUtils.isEmpty(r101) == true) goto L55;
        if (r101.startsWith("./") == false) goto L55;
        if (TextUtils.isEmpty(r105) == true) goto L55;
        int r113 = r105.lastIndexOf(HTTP.URL_DEFAULT);
        if (r113 <= 0) goto L55;
        r107 = r105.substring(0, r113) + r101.substring(1);
        LLog.d("ImageUrlRedirectUtils", "shouldRedirectImageUrl use local image url:" + r107);
        if (r107.startsWith("http") == true) goto L55;
        if (r107.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L55;
        if (r107.startsWith("content://") == true) goto L55;
        if (r107.startsWith("res://") == true) goto L55;
        if (r107.startsWith(fyb.a.KEY_DATA) == true) goto L55;
        if (r107.startsWith("assets:///") == false) goto L48;
        r107 = r107.replace("assets:///", "asset:///");
        goto L55
    L48:
        if (r107.startsWith("assets://") == false) goto L51;
        r107 = r107.replace("assets://", "asset:///");
        goto L55
    L51:
        if (r107.startsWith("asset:///") == true) goto L55;
        r108 = MSkiaImageRegionDecoder.FILE_PREFIX.concat(r107);
    L20:
        e = move-exception;
        LLog.d("ImageUrlRedirectUtils", "shouldRedirectImageUrl occurred with exception: " + e.getMessage());
        r108 = null;
        goto L22
    L82:
        return r101;
    L12:
        r104 = r103.imageInterceptor();
        goto L13
    L81:
        return r101;
    }

    public static void a(Context r100, String r101, float r110, float r111, m.a r112) {
        LynxContext r102 = com.lynx.tasm.utils.a.a(r100);
        if (r102 != null) goto L6;
        LLog.e("ImageUrlRedirectUtils", "load image failed due to no context available");
        return;
    L6:
        m r103 = r102.imageInterceptor();
        if (r103 == null) goto L9;
        r103.loadImage(r102, null, r101, r110, r111, null, r112);
        return;
    L9:
        r112.a(null, null);
    }
}
