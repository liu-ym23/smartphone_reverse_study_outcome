package com.ss.android.lark.compose.foundation.toast;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f417638a = 0;

    static {
    }

    public static Activity a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return a(((ContextWrapper) r100).getBaseContext());
    }
}
