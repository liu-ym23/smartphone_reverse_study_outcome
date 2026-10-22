package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x2<T, R> implements Function {
    public final /* synthetic */ String a;

    public x2(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        Intrinsics.checkNotNullParameter((String) r5, "it");
        yq5.a r6 = WikiDatabase.c().d().h(this.a);
        StringBuilder r0 = new StringBuilder("cacheDataFlowInner, load db result.isEmpty=");
        if (r6 != null) goto L5;
        boolean r2 = true;
    L6:
        r0.append(r2);
        r0.append('}');
        tt5.a.h("WikiTreeSpaceInfoDataManager", r0.toString());
        if (r6 != null) goto L9;
        int r7 = up5.b.b;
        return up5.b.a.a();
    L9:
        SpaceInfo r1 = new SpaceInfo();
        r1.space_id = r6.a;
        r1.space_name = r6.b;
        r1.space_icon = r6.c;
        r1.tenant_id = r6.d;
        r1.description = r6.e;
        r1.is_star = r6.f;
        SpaceInfo.SpaceCover r3 = new SpaceInfo.SpaceCover();
        r3.origin = r6.l;
        r3.thumbnail = r6.m;
        r3.key = r6.n;
        r3.is_graph_dark = r6.o;
        r3.color_value = r6.p;
        r1.space_cover = r3;
        r1.migrate_status = 0;
        r1.wiki_scope = r6.h;
        r1.space_type = r6.g;
        r1.open_sharing = r6.i;
        r1.owner_perm_type = r6.j;
        r1.create_uid = r6.k;
        r1.display_tag = null;
        return new up5.b(r1);
    L5:
        r2 = false;
        goto L6
    }
}
