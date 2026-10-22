package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.graphics.drawable.Animatable;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import com.bytedance.android.livesdk.livecommerce.intro.card.presenter.d;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends y.d {
    public final /* synthetic */ IntroCardImageComponent a;

    public final void onFailure(String r1, Throwable r2) {
    }

    public b(IntroCardImageComponent r1) {
        this.a = r1;
    }

    public final void a(String r1, ImageInfo r2, Animatable r3) {
        OptCardUtil.b("image", "call onFinalImageSet");
        OptCardUtil.e = true;
        if (IntroCardLoadOpt.m == true) goto L5;
    L7:
        d r4 = this.a.getPresenter();
        if (r4 == null) goto L11;
        r4.d();
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(IntroCardLoadOpt.o, Boolean.TRUE) == false) goto L7;
        k.a("optCardLoadPicDoFrame = 1");
        OptCardUtil.b(null, "call forceDoFrame");
        ForceDoFrameMessage.a();
        goto L7
    }

    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r2, Animatable r3) {
        a(r1, (ImageInfo) r2, r3);
    }
}
