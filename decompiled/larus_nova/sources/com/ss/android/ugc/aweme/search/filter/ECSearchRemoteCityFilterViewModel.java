package com.ss.android.ugc.aweme.search.filter;

import androidx.lifecycle.ViewModel;
import com.ss.android.ugc.aweme.discover.model.RemoteCityFilterCardStruct;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchRemoteCityFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "data", "Lcom/ss/android/ugc/aweme/discover/model/RemoteCityFilterCardStruct;", "getData", "()Lcom/ss/android/ugc/aweme/discover/model/RemoteCityFilterCardStruct;", "setData", "(Lcom/ss/android/ugc/aweme/discover/model/RemoteCityFilterCardStruct;)V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchRemoteCityFilterViewModel extends ViewModel {
    public static final Companion Companion = null;
    private RemoteCityFilterCardStruct data;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchRemoteCityFilterViewModel$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ECSearchRemoteCityFilterViewModel() {
    }

    public final RemoteCityFilterCardStruct getData() {
        return this.data;
    }

    public final void setData(RemoteCityFilterCardStruct r100) {
        this.data = r100;
    }
}
