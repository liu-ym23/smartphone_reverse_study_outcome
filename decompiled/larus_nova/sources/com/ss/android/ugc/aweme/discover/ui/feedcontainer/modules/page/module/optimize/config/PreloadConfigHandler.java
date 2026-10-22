package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/PreloadConfigHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadConfigHandler<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<String, Integer, T, CardPreloadConfig> f450687a;

    /* JADX WARN: Multi-variable type inference failed */
    public PreloadConfigHandler(Function3<? super String, ? super Integer, ? super T, CardPreloadConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "cardPreloadConfigs");
        this.f450687a = r100;
    }
}
