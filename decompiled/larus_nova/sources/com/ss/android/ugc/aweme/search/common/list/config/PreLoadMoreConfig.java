package com.ss.android.ugc.aweme.search.common.list.config;

import com.ss.android.ugc.aweme.search.common.ILoadMoreFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/config/PreLoadMoreConfig;", "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreLoadMoreConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILoadMoreFunction f451691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Integer> f451692b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/config/PreLoadMoreConfig$Companion;", "", "()V", "DOUBLE_SPAN_TRIGGER_COUNT", "", "SINGLE_SPAN_TRIGGER_COUNT", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public PreLoadMoreConfig() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreLoadMoreConfig) == false) goto L10;
        PreLoadMoreConfig r101 = (PreLoadMoreConfig) r100;
        if (Intrinsics.areEqual(this.f451691a, r101.f451691a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f451692b, r101.f451692b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ILoadMoreFunction r100 = this.f451691a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<String, Integer> r104 = this.f451692b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PreLoadMoreConfig(loadMoreFunc=" + this.f451691a + ", remainCountFunc=" + this.f451692b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PreLoadMoreConfig(ILoadMoreFunction r100, Function1<? super String, Integer> r101) {
        this.f451691a = r100;
        this.f451692b = r101;
    }
}
