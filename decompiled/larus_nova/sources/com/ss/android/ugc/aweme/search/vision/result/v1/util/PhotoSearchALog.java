package com.ss.android.ugc.aweme.search.vision.result.v1.util;

import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/util/PhotoSearchALog;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchALog {
    private PhotoSearchALog() {
    }

    static {
        new PhotoSearchALog();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter("PhotoSearchLog", "tag");
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Logger.b("PhotoSearchLog", r100);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter("PhotoSearchLog", "tag");
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Logger.d("PhotoSearchLog", r100);
    }
}
