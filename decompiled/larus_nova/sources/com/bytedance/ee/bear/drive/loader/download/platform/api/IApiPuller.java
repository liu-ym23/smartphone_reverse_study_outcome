package com.bytedance.ee.bear.drive.loader.download.platform.api;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public interface IApiPuller<PARAMS, RESULT> {
    Flowable<RESULT> pull(PARAMS r100);
}
