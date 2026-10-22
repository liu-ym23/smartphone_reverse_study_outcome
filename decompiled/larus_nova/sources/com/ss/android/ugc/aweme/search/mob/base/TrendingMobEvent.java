package com.ss.android.ugc.aweme.search.mob.base;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.search.mob.base.TrendingMobEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/TrendingMobEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/mob/base/BaseFilterMobEvent;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TrendingMobEvent<T extends TrendingMobEvent<T>> extends BaseFilterMobEvent<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/TrendingMobEvent$Companion;", "", "()V", "WORDS_BAR", "", "WORDS_PANEL", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public TrendingMobEvent() {
        Intrinsics.checkNotNullParameter("trending_show", "event");
        super("trending_show");
    }

    @Override // com.ss.android.ugc.aweme.search.mob.base.BaseFilterMobEvent
    public final void k(String r100) {
        f("words_position", r100);
    }
}
