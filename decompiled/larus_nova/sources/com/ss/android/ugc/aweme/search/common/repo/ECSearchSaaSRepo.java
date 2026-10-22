package com.ss.android.ugc.aweme.search.common.repo;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/repo/ECSearchSaaSRepo;", "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchSaaSRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f451823a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f451824b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/repo/ECSearchSaaSRepo$Companion;", "", "", HTTP.HOST, "Ljava/lang/String;", "HOST_MALL", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f451824b = new Companion(0);
        f451823a = LazyKt.lazy(ECSearchSaaSRepo$Companion$ecSearchSaaSMallApi$2.INSTANCE);
    }
}
