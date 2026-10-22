package com.larus.kmp.voice_setting.voice.service;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.larus.kmp.voice_setting.voice.base.api.e;
import com.larus.kmp.voice_setting.voice.feature.i;
import kotlin.jvm.internal.Intrinsics;
import p2a.k;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final i a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (e.a() == false) goto L5;
        String r101 = PriorityModule.SCENE_MULTI;
    L7:
        return new i(r101, r100.f527477a, r100.f527478b, r100.f527480d, r100.f527481e, r100.f527483g.name());
    L5:
        r101 = r100.f527482f;
        goto L7
    }
}
