package com.ss.android.lark.flow.feed.utils;

import android.content.Context;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f423632a = 0;

    static {
    }

    public static void a(Context r100, int r101, Integer r102) {
        String r103 = UIHelper.getString(r101);
        Intrinsics.checkNotNullParameter(r103, "content");
        if (r100 == null) goto L8;
        if (r102 != null) goto L6;
        FlowToast.d(r100, r103);
        return;
    L6:
        FlowToast.e(r100, r103, r102.intValue());
        return;
    }
}
