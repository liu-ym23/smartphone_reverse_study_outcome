package com.ss.android.ugc.aweme.search.mob.base;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.search.mob.base.BaseSearchMobEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchMobEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/mob/base/BaseMobEvent;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseSearchMobEvent<T extends BaseSearchMobEvent<T>> extends BaseMobEvent<T> {
    public BaseSearchMobEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }

    public final void i(Integer r100) {
        f("rank", String.valueOf(r100));
    }
}
