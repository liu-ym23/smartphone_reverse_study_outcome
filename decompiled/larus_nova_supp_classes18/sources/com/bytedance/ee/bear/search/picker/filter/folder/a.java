package com.bytedance.ee.bear.search.picker.filter.folder;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import du5.b;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import rcb.c;
import td5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePicker.IOnPickNotify {
    public final SearchFolderFragment a;
    public final boolean b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.search.picker.filter.folder.a$a, reason: collision with other inner class name */
    public static final class C0160a {
    }

    static {
    }

    public a(SearchFolderFragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
    }

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
        tt5.a.h("FolderPickerNotifyListener", "onChanged ");
        this.a.f.clear();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        SearchSpaceInfo r5 = (SearchBaseInfo) r4.next();
        if ((r5 instanceof SearchSpaceInfo) == false) goto L4;
        this.a.f.add(r5);
        goto L4
    }

    public final void onSelected(String r12, SearchBaseInfo r13) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r13, "info");
        tt5.a.h("FolderPickerNotifyListener", "onSelected " + b.g(r12));
        if (this.b == true) goto L17;
        SearchFolderFragment r14 = this.a;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "info");
        if ((r13 instanceof SearchSpaceInfo) == false) goto L22;
        SearchSpaceInfo r15 = (SearchSpaceInfo) r13;
        Doc.Type r0 = r15.getDocType();
        if (r0 != null) goto L9;
        int r1 = -1;
    L11:
        if (r1 != 1) goto L15;
        e r2 = new e(0, r15.getId(), r15.getTitle(), r15.getIsShareFolder().booleanValue(), 2, 5, r15.isCrossTenant(), true);
        com.bytedance.ee.bear.wikiv2.searchv2.a r16 = r14.i;
        if (r16 == null) goto L15;
        r16.j7(r2);
    L15:
        c.c(r14.getContext());
        return;
    L9:
        r1 = SearchFolderFragment.b.a[r0.ordinal()];
        goto L11
    L22:
        return;
    L17:
        this.a.f.clear();
        if ((r13 instanceof SearchSpaceInfo) == false) goto L20;
        this.a.f.add(r13);
    L20:
        this.a.W90(false);
    }
}
