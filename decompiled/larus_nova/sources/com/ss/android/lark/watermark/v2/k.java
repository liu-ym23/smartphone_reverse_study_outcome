package com.ss.android.lark.watermark.v2;

import androidx.lifecycle.LiveData;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import io.reactivex.Single;

/* JADX INFO: loaded from: classes38.dex */
public interface k {
    WatermarkInfo a();

    WatermarkStateMediatorLiveData b();

    WatermarkData c();

    void d(com.ss.android.lark.watermark.a r100);

    WatermarkData e();

    WatermarkStateMediatorLiveData f();

    LiveData<v> g();

    void h(com.ss.android.lark.watermark.a r100);

    WatermarkData i();

    Single<Integer> initialize();

    boolean isInitialized();

    void reset();

    int s();
}
