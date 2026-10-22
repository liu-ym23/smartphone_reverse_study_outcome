package com.bytedance.ee.bear.search.picker.filter.chat;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePicker.IOnPickNotify {
    public final ChatPickerFragment a;

    public a(ChatPickerFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
        this.a.f.clear();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        SearchBaseInfo r5 = (SearchBaseInfo) r4.next();
        this.a.f.add(r5);
        goto L4
    }

    public final void onSelected(String r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "info");
        this.a.f.clear();
        this.a.f.add(r3);
        this.a.U90(r3, false);
    }
}
