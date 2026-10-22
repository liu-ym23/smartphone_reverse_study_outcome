package com.bytedance.ee.bear.search.picker;

import com.bytedance.ee.bear.lark.dependency.f;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePicker.IOnPickNotify {
    public final BaseSearchPickerFragment a;
    public final boolean b;
    public final Map<String, String> c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.search.picker.a$a, reason: collision with other inner class name */
    public static final class C0147a {
    }

    static {
    }

    public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        Intrinsics.checkNotNullParameter(r3, "infoList");
    }

    public a(BaseSearchPickerFragment r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r3;
        this.b = r4;
        this.c = MapsKt.mapOf(new Pair[]{TuplesKt.to("from", "space_search"), TuplesKt.to("ccm_open_type", "space_search")});
    }

    public final void onSelected(String r4, SearchBaseInfo r5) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r5, "info");
        if (this.b == true) goto L7;
        this.a.U90(r5, true);
        return;
    L7:
        if ((r5 instanceof SearchSpaceInfo) == false) goto L17;
        String r6 = av5.c.b(((SearchSpaceInfo) r5).getDocUrl(), this.c, true);
        if (this.a.getActivity() != null) goto L11;
    L15:
        ((h) org.koin.java.a.c(h.class, null, null, 6)).u5(r6);
        return;
    L11:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == false) goto L15;
        sbb.c r7 = sbb.c.a;
        Intrinsics.checkNotNull(r6);
        r7.getClass();
        if (sbb.c.b(r6) == false) goto L15;
        ((f) org.koin.java.a.c(f.class, null, null, 6)).a(this.a.getActivity(), r6, null);
        return;
    L17:
        if ((r5 instanceof SearchWikiInfo) == false) goto L20;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).u5(av5.c.b(((SearchWikiInfo) r5).getUrl(), this.c, true));
        return;
    L20:
        if ((r5 instanceof SearchWikiSpaceInfo) == false) goto L26;
        tp5.a r8 = (tp5.a) org.koin.java.a.c(tp5.a.class, null, null, 6);
        int r0 = fm5.a.a;
        SearchWikiSpaceInfo r9 = (SearchWikiSpaceInfo) r5;
        Intrinsics.checkNotNullParameter(r9, "searchInfo");
        SpaceBean r1 = new SpaceBean();
        r1.space_id = r9.getSpaceId();
        r1.space_name = r9.getSpaceName();
        r1.description = r9.getDescription();
        r8.a(r1);
        return;
    }
}
