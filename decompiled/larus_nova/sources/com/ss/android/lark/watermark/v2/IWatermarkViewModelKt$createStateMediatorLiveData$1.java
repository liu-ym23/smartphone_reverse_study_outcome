package com.ss.android.lark.watermark.v2;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/image/api/IRequestCreator;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IWatermarkViewModelKt$createStateMediatorLiveData$1 extends Lambda implements Function0<IRequestCreator> {
    final /* synthetic */ AndroidViewModel $this_createStateMediatorLiveData;

    public IWatermarkViewModelKt$createStateMediatorLiveData$1(AndroidViewModel r100) {
        this.$this_createStateMediatorLiveData = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IRequestCreator invoke() {
        Application r100 = this.$this_createStateMediatorLiveData.getApplication();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Application");
        return ImageLoader.with(r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ IRequestCreator invoke() {
        return invoke();
    }
}
