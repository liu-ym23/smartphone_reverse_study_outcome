package com.ss.android.ugc.aweme.search.common.saas;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ies.dmt.ui.widget.DmtEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/SearchHintIconStrategy;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHintIconStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f452003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SearchHintIconStrategy f452004b = null;

    private SearchHintIconStrategy() {
    }

    static {
        f452004b = new SearchHintIconStrategy();
        f452003a = CollectionsKt.listOf(new String[]{"hybrid", "icon"});
    }

    public static void a(DmtEditText r100) {
        if (r100 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, "$this$parentView");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L6;
        r101 = null;
    L6:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L20;
        Intrinsics.checkNotNullParameter(r102, "$this$children");
        SearchHintIconStrategy$children$1$iterator$1 r103 = new SearchHintIconStrategy$children$1$iterator$1(new SearchHintIconStrategy$children$1(r102));
    L10:
        if (r103.hasNext() == false) goto L21;
        View r104 = (View) r103.next();
        if (CollectionsKt.contains(f452003a, r104.getTag()) == false) goto L10;
        r104.setVisibility(8);
        goto L10
    L21:
        return;
    L20:
        return;
    }
}
