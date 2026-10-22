package com.bytedance.ee.bear.search.picker.filter.wiki;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePicker.IOnPickNotify {
    public final SearchWikiSpaceFragment a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.search.picker.filter.wiki.a$a, reason: collision with other inner class name */
    public static final class C0172a {
    }

    static {
    }

    public a(SearchWikiSpaceFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
        tt5.a.h("WikiPickerNotifyListener", "onChanged ");
        this.a.f.clear();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        SearchWikiSpaceInfo r5 = (SearchBaseInfo) r4.next();
        if ((r5 instanceof SearchWikiSpaceInfo) == false) goto L4;
        this.a.f.add(r5);
        goto L4
    }

    public final void onSelected(String r3, SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "info");
        tt5.a.h("WikiPickerNotifyListener", "onSelected " + du5.b.g(r3));
        this.a.f.clear();
        if ((r4 instanceof SearchWikiSpaceInfo) == false) goto L5;
        this.a.f.add(r4);
    L5:
        this.a.W90(false);
    }
}
