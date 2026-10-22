package com.bytedance.android.window.shop.search.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.shop.ECWindowSortBarBasePresenter;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchFragmentProductViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowSearchResultOrderTypePresenter extends ECWindowSortBarBasePresenter {
    public static final /* synthetic */ int o = 0;
    public final Lazy j;
    public boolean k;
    public final a l;
    public final b m;
    public final c n;

    public static final class a {
        public final /* synthetic */ WindowSearchResultOrderTypePresenter a;

        public a(WindowSearchResultOrderTypePresenter r1) {
            this.a = r1;
        }
    }

    public static final class b {
        public final /* synthetic */ WindowSearchResultOrderTypePresenter a;

        public b(WindowSearchResultOrderTypePresenter r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public final /* synthetic */ WindowSearchResultOrderTypePresenter a;

        public c(WindowSearchResultOrderTypePresenter r1) {
            this.a = r1;
        }
    }

    public final WindowSearchFragmentProductViewModel e0() {
        return (WindowSearchFragmentProductViewModel) this.j.getValue();
    }

    public WindowSearchResultOrderTypePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.j = LazyKt.lazy(new WindowSearchResultOrderTypePresenter$viewModel$2(this));
        this.l = new a(this);
        this.m = new b(this);
        this.n = new c(this);
    }
}
