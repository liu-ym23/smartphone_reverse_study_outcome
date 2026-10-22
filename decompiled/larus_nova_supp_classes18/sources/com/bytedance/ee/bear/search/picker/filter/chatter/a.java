package com.bytedance.ee.bear.search.picker.filter.chatter;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePicker.IOnPickNotify {
    public final ChatterPickerFragment a;

    public a(ChatterPickerFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
        this.a.g.clear();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        SearchChatterInfo r5 = (SearchBaseInfo) r4.next();
        if ((r5 instanceof SearchChatterInfo) == false) goto L4;
        this.a.g.add(r5);
        goto L4
    }

    public final void onSelected(String r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "info");
        this.a.g.clear();
        if ((r3 instanceof SearchChatterInfo) == false) goto L5;
        this.a.g.add(r3);
    L5:
        this.a.U90(r3, false);
    }
}
