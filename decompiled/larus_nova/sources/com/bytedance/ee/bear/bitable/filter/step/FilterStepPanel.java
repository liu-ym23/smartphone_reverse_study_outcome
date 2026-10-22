package com.bytedance.ee.bear.bitable.filter.step;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.filter.step.impl.FilterStepViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class FilterStepPanel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f211891c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f211892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f211893b;

    public static final class a {
    }

    static {
    }

    public final FilterStepViewModel a() {
        return (FilterStepViewModel) this.f211893b.getValue();
    }

    public FilterStepPanel(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        this.f211892a = r100;
        this.f211893b = LazyKt.lazy(new FilterStepPanel$mFilterStepViewModel$2(this));
    }
}
