package com.ss.android.ugc.aweme.search.common.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/base/ECSearchBaseModule;", "Lcom/ss/android/ugc/aweme/kiwi/ui/QUIModule;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECSearchBaseModule extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f451482l;

    public ECSearchBaseModule() {
        this(0);
    }

    public abstract View k(ViewGroup r100);

    public ECSearchBaseModule(int r100) {
        super(-1, null);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f451482l == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        this.f451482l = k(r101);
    L8:
        View r103 = this.f451482l;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        return r103;
    L5:
        r102 = false;
        goto L6
    }
}
