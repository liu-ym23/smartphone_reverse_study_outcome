package com.ss.android.ugc.aweme.base;

import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/base/UrlModelConverter;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlModelConverter {
    private UrlModelConverter() {
    }

    static {
        new UrlModelConverter();
    }

    @JvmStatic
    public static final ImageUrlModel a(UrlModel r100) {
        if (r100 == null) goto L4;
        r100.getUri();
        return new ImageUrlModel(r100.getUrlList());
    L4:
        return new ImageUrlModel(new ArrayList());
    }
}
