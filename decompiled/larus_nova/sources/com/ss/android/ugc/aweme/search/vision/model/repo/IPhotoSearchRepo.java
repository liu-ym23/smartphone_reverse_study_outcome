package com.ss.android.ugc.aweme.search.vision.model.repo;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/repo/IPhotoSearchRepo;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPhotoSearchRepo<T> {
    void onComplete();

    void onFailed(Throwable r100);

    void onNext(T r100);
}
