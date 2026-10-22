package com.bytedance.locallife.dito.common.experiment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoFluencyOptExperiment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f257342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f257343b = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/dito/common/experiment/DitoFluencyOptExperiment$a;", "", "", "enable", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "", "blackList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("black_list")
        private final List<String> blackList;

        @SerializedName("enable")
        private final Integer enable;

        public a() {
            this.enable = null;
            this.blackList = null;
        }

        public final List<String> a() {
            return this.blackList;
        }

        public final Integer b() {
            return this.enable;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/dito/common/experiment/DitoFluencyOptExperiment$b;", "", "", "itemViewCacheSize", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "gapWorkerPrefetchCount", "b", "", "triggerGapWorkerAfterFmp", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "asyncLoadLynxAfterFmp", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("async_load_lynx_after_fmp")
        private final Boolean asyncLoadLynxAfterFmp;

        @SerializedName("gap_worker_prefetch_count")
        private final Integer gapWorkerPrefetchCount;

        @SerializedName("item_view_cache_size")
        private final Integer itemViewCacheSize;

        @SerializedName("trigger_gap_worker_after_fmp")
        private final Boolean triggerGapWorkerAfterFmp;

        public b() {
            this.itemViewCacheSize = null;
            this.gapWorkerPrefetchCount = null;
            this.triggerGapWorkerAfterFmp = null;
            this.asyncLoadLynxAfterFmp = null;
        }

        public final Boolean a() {
            return this.asyncLoadLynxAfterFmp;
        }

        public final Integer b() {
            return this.gapWorkerPrefetchCount;
        }

        public final Integer c() {
            return this.itemViewCacheSize;
        }

        public final Boolean d() {
            return this.triggerGapWorkerAfterFmp;
        }
    }

    static {
        f257342a = LazyKt.lazy(DitoFluencyOptExperiment$asyncSendEventConfig$2.INSTANCE);
        f257343b = LazyKt.lazy(DitoFluencyOptExperiment$recyclerViewConfig$2.INSTANCE);
    }
}
