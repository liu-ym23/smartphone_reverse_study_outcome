package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements BaseColumns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f461636a = null;

    static {
        f461636a = UriProtector.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
