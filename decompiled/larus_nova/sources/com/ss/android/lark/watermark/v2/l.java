package com.ss.android.lark.watermark.v2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l {
    public static final FileWatermarkStateMediatorLiveData a(MutableLiveData r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(SpeechEngineDefines.RECORDER_TYPE_FILE, "name");
        return new FileWatermarkStateMediatorLiveData(r100, IWatermarkViewModelKt$createFileStateMediatorLiveData$1.INSTANCE, new c(LarkContext.getApplication()), new com.ss.android.lark.watermark.mysterious.a(LarkContext.getApplication(), IWatermarkViewModelKt$createFileStateMediatorLiveData$2.INSTANCE));
    }

    public static final WatermarkStateMediatorLiveData b(MutableLiveData r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "name");
        return new WatermarkStateMediatorLiveData(r101, r100, IWatermarkViewModelKt$createStateMediatorLiveData$3.INSTANCE, new c(LarkContext.getApplication()), new com.ss.android.lark.watermark.mysterious.a(LarkContext.getApplication(), IWatermarkViewModelKt$createStateMediatorLiveData$4.INSTANCE));
    }
}
