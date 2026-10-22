package com.ss.android.ugc.aweme.search.hostapi;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchFrescoService;", "", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public interface ITradeSearchFrescoService {
    void bindImage(SimpleDraweeView r100, String r101);

    boolean isDownloaded(Uri r100);

    void loadBitmapSynchronized(String r100, int r101, int r102, Function1<? super Bitmap, Unit> r103);
}
