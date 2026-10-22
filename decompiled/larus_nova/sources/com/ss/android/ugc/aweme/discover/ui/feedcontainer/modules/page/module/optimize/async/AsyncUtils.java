package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f450643a = 0;

    private AsyncUtils() {
    }

    static {
        new AsyncUtils();
    }

    @JvmStatic
    public static final boolean a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = r100.getTag(2147483393);
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((r101 instanceof Boolean) == true) goto L8;
        return false;
    L8:
        return ((Boolean) r101).booleanValue();
    }
}
