package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198959a = 0;

    static {
    }

    public static Activity a(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return a(((ContextWrapper) r100).getBaseContext());
    }
}
