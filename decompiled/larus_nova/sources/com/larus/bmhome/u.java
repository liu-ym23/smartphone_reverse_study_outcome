package com.larus.bmhome;

import android.content.Context;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes25.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314734a = 0;

    static {
    }

    public static String a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return "# " + r100.getString(R.string.larus_credit_genResult_notEnough_title) + '\n' + r100.getString(R.string.larus_credit_genResult_notEnough_desc, new Object[]{r100.getString(R.string.app_name_replace)});
    }
}
