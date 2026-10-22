package com.ss.android.ugc.aweme.search.filter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterViewModel;", "Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterBaseViewModel;", "()V", "sendHideFilterBoardAction", "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFilterViewModel extends ECSearchFilterBaseViewModel {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterViewModel$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static ECSearchFilterViewModel a(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            return (ECSearchFilterViewModel) ViewModelProviders.of(r100).get(ECSearchFilterViewModel.class);
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final void sendHideFilterBoardAction() {
    }

    public ECSearchFilterViewModel() {
    }
}
