package com.ss.android.ugc.aweme.helper.image;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ECSearchImageCallerContextKt {
    public static final Activity a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r100 instanceof Activity) == false) goto L11;
        return (Activity) r100;
    L11:
        return a(((ContextWrapper) r100).getBaseContext());
    }
}
