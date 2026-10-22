package com.ss.android.ugc.aweme.search.vision.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.chunkstreamprediction.network.a;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchResultSceneKey;
import com.ss.android.ugc.aweme.search.common.mob.ECSearchSaasResultShowEventTracker;
import com.ss.android.ugc.aweme.search.vision.model.repo.IPhotoSearchRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/PhotoSearchSaaSChunkStateMachine;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/chunkstreamprediction/network/a;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoSearchSaaSChunkStateMachine<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IPhotoSearchRepo<T> f453595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECSearchResultSceneKey f453596b;

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onComplete() {
        ECSearchSaasResultShowEventTracker r100 = ECSearchSaasResultShowEventTracker.f451754d;
        ECSearchResultSceneKey r101 = this.f453596b;
        r100.getClass();
        ECSearchSaasResultShowEventTracker.b(r101).e();
        this.f453595a.onComplete();
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onFailed(Throwable r100) {
        this.f453595a.onFailed(r100);
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.a
    public final void onNext(T r100) {
        this.f453595a.onNext(r100);
    }

    public PhotoSearchSaaSChunkStateMachine(IPhotoSearchRepo<T> r100, ECSearchResultSceneKey r101) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        this.f453595a = r100;
        this.f453596b = r101;
    }
}
