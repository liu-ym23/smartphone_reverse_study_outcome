package com.ss.android.ugc.aweme.search.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes40.dex */
public class PluginHelper {
    public static Activity getActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return getActivity(((ContextWrapper) r100).getBaseContext());
    }
}
