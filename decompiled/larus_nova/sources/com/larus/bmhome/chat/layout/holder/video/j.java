package com.larus.bmhome.chat.layout.holder.video;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f304087a = 0;

    static {
    }

    public static AiGenVideoContentData a(String r100) {
        AiGenVideoContentData.Companion.getClass();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L17;
    L15:
        return null;
    L17:
        return (AiGenVideoContentData) GsonProtectorUtils.fromJson(new Gson(), r100, AiGenVideoContentData.class);
    L13:
        e = move-exception;
        FLogger.f375446a.e("VideoGenerateMessageUtil", g2a.d.d(r100) + ' ' + e.getMessage(), e);
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
