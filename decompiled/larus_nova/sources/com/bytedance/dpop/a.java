package com.bytedance.dpop;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f204774a = 0;

    static {
    }

    public static String a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        return Base64.encodeToString(r100, 11);
    }
}
