package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class f {
    public static final float a(float r100, ns8.b r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == true) goto L9;
    L15:
        return r100;
    L9:
        if (r100 >= 1.0f) goto L15;
        FLogger r103 = FLogger.f375446a;
        if (r103.isDebug() == false) goto L14;
        r103.i("BaseProcessor", "[图片清晰度策略][处理配置] 跳过降采样=是，线上缩放比例=" + r100 + "，生效缩放比例=1.0，编解码参数沿用线上");
    L14:
        return 1.0f;
    L5:
        if (r101.f520357g != true) goto L7;
        r102 = true;
        goto L7
    }
}
