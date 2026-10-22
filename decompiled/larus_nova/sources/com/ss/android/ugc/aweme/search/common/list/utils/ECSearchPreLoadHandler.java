package com.ss.android.ugc.aweme.search.common.list.utils;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/list/utils/ECSearchPreLoadHandler;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchPreLoadHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchPreLoadHandler f451697a = null;

    private ECSearchPreLoadHandler() {
    }

    static {
        f451697a = new ECSearchPreLoadHandler();
    }

    public static int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        if (Intrinsics.areEqual(r100, ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L5;
        Logger.a("LoadMoreDebug", "update load more trigger count = 2");
        return 2;
    L5:
        Logger.a("LoadMoreDebug", "update load more trigger count = 1");
        return 1;
    }
}
