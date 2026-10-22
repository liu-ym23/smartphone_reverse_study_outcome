package com.ss.android.ugc.aweme.search.vision.result.v1.util;

import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class PhotoSearchParamsUtilKt {
    public static final ECSearchParam a(PhotoEnterModel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toECSearchParams");
        ECSearchParam.Builder r101 = new ECSearchParam.Builder();
        r101.f451524a = 1;
        r101.f451526b = r100.getKeyword();
        String r102 = r100.getEnterFrom();
        if (r102 != null) goto L5;
        r102 = r100.getSearchEnterFrom();
    L5:
        String r103 = "";
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f451530d = r102;
        r101.f451532e = r100.getEnterFromSecond();
        r101.f451538h = r100.getGroupId();
        r101.C = r100.getAuthorId();
        r101.B = r100.getRoomId();
        r101.f451561s0 = r100.getAwemeId();
        r101.f451568w = r100.getSearchChannel();
        r101.f451566v = r100.getExtra();
        r101.f451572y = r100.getClientEngineExtra();
        r101.f451529c0 = r100.getTransEventExtra();
        r101.f451527b0 = r100.getNeedSendCloseMessage();
        r101.f451553o0 = r100.getSourceBtmToken();
        r101.G = r100.getEcomSceneId();
        r101.f451575z0 = r100.getDeliverySessionId();
        r101.f451570x = r100.getEnterMethod();
        String r104 = r100.getEnterMethod();
        if (r104 == null) goto L12;
        r103 = r104;
    L12:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f451536g = r103;
        r101.f451537g0 = r100.getExtraTrackParams();
        Integer r105 = r100.getItemPlayTime();
        if (r105 == null) goto L16;
        r101.f451563t0 = r105.intValue();
    L18:
        ECSearchParam r106 = r101.a();
        r106.setInSplitPage(r100.isSplitMode());
        r106.setSplitWidth(r100.getSplitWidthDp());
        return r106;
    L16:
        if (r100.getVideoPlayTime() < 0) goto L18;
        r101.f451563t0 = r100.getVideoPlayTime();
        goto L18
    }
}
