package com.ss.android.ugc.aweme.search.utils.extensions;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/extensions/ViewDebounceClickListener;", "Landroid/view/View$OnClickListener;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class ViewDebounceClickListener implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f453424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f453425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f453426c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        long r101 = System.currentTimeMillis();
        if (Math.abs(r101 - this.f453426c) <= this.f453424a) goto L8;
        this.f453426c = r101;
        this.f453425b.invoke();
        return;
    }

    public ViewDebounceClickListener(long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f453424a = r100;
        this.f453425b = r101;
    }
}
