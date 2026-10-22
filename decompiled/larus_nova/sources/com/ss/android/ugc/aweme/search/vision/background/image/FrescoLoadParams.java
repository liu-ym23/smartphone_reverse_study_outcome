package com.ss.android.ugc.aweme.search.vision.background.image;

import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/background/image/FrescoLoadParams;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrescoLoadParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UrlModel f453466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseControllerListener<ImageInfo> f453467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f453468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f453469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f453470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f453471f;

    public FrescoLoadParams(SearchPhotoDraweeView r100) {
        this.f453471f = r100;
    }
}
