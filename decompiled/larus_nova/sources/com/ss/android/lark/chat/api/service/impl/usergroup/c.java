package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.lynx.tasm.LynxError;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f411684a = 0;

    static {
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Log.i(r100, "[UserGroup] " + r101);
    }

    public static void a(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
        Log.e(r100, "[UserGroup] " + r101, r102);
    }
}
