package com.bytedance.ee.bear.search.picker.filter.permission;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePicker.IOnPickNotify {
    public final ChatterPickerFragment a;

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
    }

    public a(ChatterPickerFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void onSelected(String r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "info");
        if ((r3 instanceof SearchChatterInfo) == false) goto L5;
        SearchChatterInfo r4 = (SearchChatterInfo) r3;
        this.a.i = r4;
    L5:
        this.a.Z90();
    }
}
