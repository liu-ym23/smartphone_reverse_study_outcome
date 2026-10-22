package com.ss.android.ugc.aweme.search.hostimpl;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J6\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00040\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/search/hostimpl/ECSearchFrescoService;", "Lcom/ss/android/ugc/aweme/search/hostapi/ITradeSearchFrescoService;", "()V", "bindImage", "", "draweeView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "url", "", "isDownloaded", "", "loadUri", "Landroid/net/Uri;", "loadBitmapSynchronized", "resizeWidth", "", "resizeHeight", "postRunnable", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFrescoService implements ITradeSearchFrescoService {
    public static final ECSearchFrescoService INSTANCE = null;

    private ECSearchFrescoService() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService
    public boolean isDownloaded(Uri r100) {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService
    public void loadBitmapSynchronized(String r100, int r101, int r102, Function1<? super Bitmap, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "postRunnable");
    }

    static {
        INSTANCE = new ECSearchFrescoService();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchFrescoService
    public void bindImage(SimpleDraweeView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "draweeView");
        Intrinsics.checkNotNullParameter(r101, "url");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        ImageRequest r103 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r101)).build();     // Catch: Throwable -> L5
        r100.setController(Fresco.newDraweeControllerBuilder().setOldController(r100.getController()).setImageRequest(r103).build());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
