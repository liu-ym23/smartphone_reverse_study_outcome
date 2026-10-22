package com.ss.android.ugc.aweme.search.filter.view.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/FilterEmptyView;", "Lcom/ss/android/ugc/aweme/search/filter/view/component/ECSearchBaseSearchFilterViewHolder;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterEmptyView extends ECSearchBaseSearchFilterViewHolder {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f453032n = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/FilterEmptyView$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static FilterEmptyView a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            LinearLayout r101 = new LinearLayout(r100.getContext());
            r101.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            r101.setVisibility(8);
            Unit r102 = Unit.INSTANCE;
            return new FilterEmptyView(r101);
        }
    }

    static {
        f453032n = new Companion(0);
    }

    public FilterEmptyView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
