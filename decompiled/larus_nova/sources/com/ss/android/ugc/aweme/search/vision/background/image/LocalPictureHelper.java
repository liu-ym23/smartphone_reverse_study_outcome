package com.ss.android.ugc.aweme.search.vision.background.image;

import android.content.Context;
import android.text.TextUtils;
import bytedance.io.BdFileSystem;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAbility;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/background/image/LocalPictureHelper;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LocalPictureHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalPictureHelper f453472a = null;

    private LocalPictureHelper() {
    }

    static {
        f453472a = new LocalPictureHelper();
    }

    public static String a(String r100) {
        if (b(r100) == true) goto L5;
        return "";
    L5:
        return MSkiaImageRegionDecoder.FILE_PREFIX + r100;
    }

    @JvmStatic
    public static final boolean b(String r100) {
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L7;
        ITradeSearchHostAbility r102 = r101.getITradeSearchHostAbility();
        if (r102 == null) goto L7;
        Context r103 = r102.getApplicationContext();
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
    L15:
        return false;
    L11:
        if (new PolarisFileWrapper(r100).exists() == false) goto L13;
    L14:
        return true;
    L13:
        if (BdFileSystem.isUriExists(r103, UriProtector.parse(r100)) == false) goto L15;
    L7:
        r103 = null;
        goto L9
    }
}
