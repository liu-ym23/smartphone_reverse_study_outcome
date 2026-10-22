package xn7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.manager.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import oo7.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static boolean a(ShareContent r100, un7.c r101) {
        String r102 = ShareStrategy.getStrategyStr(r100.getShareStrategy());
        String r103 = ShareChannelType.getShareItemTypeName(r100.getShareChanelType());
        boolean r104 = h.g.f272345a.h(r103);
        k.e("WXShareSignHelper", "channel = " + r103 + ", switch = " + r104 + ", strategy = " + r102);
        boolean r105 = false;
        if (r100.getShareStrategy() != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r104 == false) goto L12;
        if (r106 == false) goto L12;
        r105 = true;
    L12:
        if (r105 == true) goto L14;
        r101.a(true, "");
    L14:
        return r105;
    L5:
        if (r100.getShareStrategy() == ShareStrategy.NORMAL) goto L8;
        r106 = false;
        goto L9
    }

    public static void b(ShareContent r100, WXWebpageObject r101, WXMediaMessage r102, un7.c r103) {
        if (a(r100, r103) == true) goto L18;
        return;
    L18:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L15
        r104.put("webpageUrl", r101.webpageUrl);     // Catch: Throwable -> L15
        r104.put("title", r102.title);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r102.description) == true) goto L8;
        r104.put("description", r102.description);     // Catch: Throwable -> L15
    L8:
        byte[] r105 = r102.thumbData;     // Catch: Throwable -> L15
        if (r105 != null) goto L11;
    L13:
        eo7.a r106 = eo7.a.b.f473353a;     // Catch: Throwable -> L15
        jo7.c.a(new io7.c(r100, ShareContentType.H5, r104, r103));     // Catch: Throwable -> L15
        return;
    L11:
        if (r105.length <= 0) goto L13;
        String r107 = oo7.e.a(r105);     // Catch: Throwable -> L15
        r102.thumbDataHash = r107;     // Catch: Throwable -> L15
        r104.put("thumbDataHash", r107);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        k.d("WXShareSignHelper", "signH5()...error", th);
    }

    public static void c(ShareContent r100, WXVideoObject r101, WXMediaMessage r102, un7.c r103) {
        if (a(r100, r103) == true) goto L18;
        return;
    L18:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L15
        r104.put("videoUrl", r101.videoUrl);     // Catch: Throwable -> L15
        r104.put("title", r102.title);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r102.description) == true) goto L8;
        r104.put("description", r102.description);     // Catch: Throwable -> L15
    L8:
        byte[] r105 = r102.thumbData;     // Catch: Throwable -> L15
        if (r105 != null) goto L11;
    L13:
        eo7.a r106 = eo7.a.b.f473353a;     // Catch: Throwable -> L15
        jo7.c.a(new io7.c(r100, ShareContentType.VIDEO, r104, r103));     // Catch: Throwable -> L15
        return;
    L11:
        if (r105.length <= 0) goto L13;
        String r107 = oo7.e.a(r105);     // Catch: Throwable -> L15
        r102.thumbDataHash = r107;     // Catch: Throwable -> L15
        r104.put("thumbDataHash", r107);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        k.d("WXShareSignHelper", "signVideo()...error", th);
    }
}
