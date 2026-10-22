package com.bytedance.ee.bear.bitable.common;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes15.dex */
public final class g {
    public static final void a(ImageView r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "imageName");
        Intrinsics.checkNotNullParameter(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, "suffix");
        if (r100 == null) goto L33;
        if (ContextsKt.requireActivity(r100.getContext()).isDestroyed() == false) goto L7;
        return;
    L7:
        RequestManager r103 = Glide.with(r100.getContext());
        JSONArray r104 = new JSONArray(((s45.c) e0c.k.a(LarkContext.getApplication(), s45.c.class)).Ba("overload_static_domain_new"));     // Catch: JSONException -> L12
        if (r104.length() <= 0) goto L14;
        String r105 = r104.optString(0, "");     // Catch: JSONException -> L12
    L16:
        if (TextUtils.isEmpty(r105) == false) goto L19;
        tt5.a.d("ImageCDNUtil", "domain is empty.");
    L19:
        if (r102 == true) goto L22;
        String r106 = "https://" + r105 + "/ccm/static_resource/scm_upload/" + r101 + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
    L25:
        r103.load(new BearGlideUrl(r106)).diskCacheStrategy(DiskCacheStrategy.DATA).into(r100);
        return;
    L22:
        if (h18.f.a(LarkContext.getApplication()) == false) goto L24;
        r106 = "https://" + r105 + "/ccm/static_resource/scm_upload/" + r101 + "_dark.png";
        goto L25
    L24:
        r106 = "https://" + r105 + "/ccm/static_resource/scm_upload/" + r101 + "_light.png";
    L14:
        r105 = "lf-package-cn.feishucdn.com/obj/feishu-static";
    L12:
        e = move-exception;
        tt5.a.d("ImageCDNUtil", "getDomain err " + e);
    L26:
        e = move-exception;
        tt5.a.d("ImageCDNUtil", e.getMessage());
        return;
    }
}
