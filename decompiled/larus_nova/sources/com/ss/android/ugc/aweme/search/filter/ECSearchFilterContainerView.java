package com.ss.android.ugc.aweme.search.filter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterContainerView;", "Landroid/widget/HorizontalScrollView;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterContainerView$OnScrollChangeListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/concurrent/CopyOnWriteArraySet;", "getScrollChangeListeners", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "setScrollChangeListeners", "(Ljava/util/concurrent/CopyOnWriteArraySet;)V", "scrollChangeListeners", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OnScrollChangeListener", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFilterContainerView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArraySet<OnScrollChangeListener> f452819a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterContainerView$OnScrollChangeListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnScrollChangeListener {
        void onScrollChanged();
    }

    public final CopyOnWriteArraySet<OnScrollChangeListener> getScrollChangeListeners() {
        return this.f452819a;
    }

    public ECSearchFilterContainerView(Context r100) {
        this(r100, null);
    }

    public final void setScrollChangeListeners(CopyOnWriteArraySet<OnScrollChangeListener> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f452819a = r100;
    }

    public ECSearchFilterContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f452819a = new CopyOnWriteArraySet();
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        Iterator<T> r104 = this.f452819a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((OnScrollChangeListener) r104.next()).onScrollChanged();
        goto L4
    }
}
