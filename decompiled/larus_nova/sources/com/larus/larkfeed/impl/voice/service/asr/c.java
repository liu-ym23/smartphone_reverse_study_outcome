package com.larus.larkfeed.impl.voice.service.asr;

import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
    public c() {
    }

    public static b a(uac.a r100) {
        Intrinsics.checkNotNullParameter(r100, "asrConfig");
        ISettingRepoService r101 = RepoDispatcherDelegate.f307737b.c();
        String r102 = r100.f549297c;
        if (Intrinsics.areEqual(r102, "auto") == false) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L8;
        r102 = r101.S0();
    L8:
        String r103 = r100.f549298d;
        if (r103 != null) goto L11;
        r103 = r101.Z(r102);
    L11:
        String r104 = r101.Q0();
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        return new b(r102, r103, r104, r101.B());
    }
}
