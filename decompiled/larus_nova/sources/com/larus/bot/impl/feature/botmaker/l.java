package com.larus.bot.impl.feature.botmaker;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {
    public static final String a(SpeakerVoice r100) {
        if (r100 != null) goto L4;
    L15:
        return null;
    L4:
        if (Intrinsics.areEqual(r100.getId(), "0") == true) goto L15;
        if (Intrinsics.areEqual(r100.getId(), "none") == true) goto L15;
        if (Intrinsics.areEqual(r100.getCreatorId(), AccountService.f365697a.getUserId()) == false) goto L12;
        return "self_created";
    L12:
        if (r100.isUgcVoice() == false) goto L14;
        return "others_created";
    L14:
        return "other_default";
    }
}
