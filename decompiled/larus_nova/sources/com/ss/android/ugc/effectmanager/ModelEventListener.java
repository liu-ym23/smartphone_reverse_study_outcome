package com.ss.android.ugc.effectmanager;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.model.ModelInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH&J\u001e\u0010\u0015\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H&¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/effectmanager/ModelEventListener;", "", "onFetchModelList", "", "isSuccess", "", "errorMsg", "", "duration", "", "effectSdkVersion", "onModelDownloadError", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "info", "Lcom/ss/android/ugc/effectmanager/model/ModelInfo;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onModelDownloadStart", "onModelDownloadSuccess", "onModelNotFound", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public interface ModelEventListener {
    void onFetchModelList(boolean r100, String r101, long r102, String r103);

    void onModelDownloadError(Effect r100, ModelInfo r101, Exception r102);

    void onModelDownloadStart(Effect r100, ModelInfo r101);

    void onModelDownloadSuccess(Effect r100, ModelInfo r101, long r102);

    void onModelNotFound(Effect r100, Exception r101);
}
