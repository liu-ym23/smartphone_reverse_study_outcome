package com.larus.voice_setting.voice.utils;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f377042a = 0;

    static {
    }

    public static boolean a() {
        e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L7;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L7;
        return Intrinsics.areEqual(r101.i0(), Boolean.TRUE);
    L7:
        return false;
    }
}
