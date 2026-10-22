package com.bytedance.ee.bear.bitable.common;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h {
    public static final void a(Context r100, String r101, String r102, UDAvatar r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "imageView");
        if (TextUtils.isEmpty(r101) == true) goto L15;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "imageView");
        if ((r100 instanceof Activity) == false) goto L17;
        Activity r104 = (Activity) r100;
        if (r104.isFinishing() == false) goto L9;
    L10:
        tt5.a.d("ImageLoader", "loadImageByUrl error, activity is finished or destroyed");
        return;
    L9:
        if (r104.isDestroyed() == true) goto L10;
    L17:
        Intrinsics.checkNotNull(Glide.with(r100).load(new BearGlideUrl(r101)).placeholder(R.drawable.facade_common_avatar_place_holder).into(r103));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        tt5.a.e("ImageLoader", "loadImageByUrl error ", e, false);
        return;
    L15:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "imageView");
        AvatarImage r105 = AvatarImage.Builder.obtain(r102, "", 20, 20).build();
        ImageLoader.with(r100).load(r105).placeholder(R.drawable.facade_common_avatar_place_holder).into(r103);
    }
}
