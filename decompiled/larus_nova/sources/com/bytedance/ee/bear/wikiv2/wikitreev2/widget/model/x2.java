package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x2<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f242156a;

    public x2(String r100) {
        this.f242156a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        yq5.a r101 = WikiDatabase.c().d().h(this.f242156a);
        StringBuilder r102 = new StringBuilder("cacheDataFlowInner, load db result.isEmpty=");
        if (r101 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append('}');
        tt5.a.h("WikiTreeSpaceInfoDataManager", r102.toString());
        if (r101 != null) goto L9;
        int r104 = up5.b.f551047b;
        return up5.b.a.a();
    L9:
        SpaceInfo r105 = new SpaceInfo();
        r105.space_id = r101.f568752a;
        r105.space_name = r101.f568753b;
        r105.space_icon = r101.f568754c;
        r105.tenant_id = r101.f568755d;
        r105.description = r101.f568756e;
        r105.is_star = r101.f568757f;
        SpaceInfo.SpaceCover r106 = new SpaceInfo.SpaceCover();
        r106.origin = r101.f568763l;
        r106.thumbnail = r101.f568764m;
        r106.key = r101.f568765n;
        r106.is_graph_dark = r101.f568766o;
        r106.color_value = r101.f568767p;
        r105.space_cover = r106;
        r105.migrate_status = 0;
        r105.wiki_scope = r101.f568759h;
        r105.space_type = r101.f568758g;
        r105.open_sharing = r101.f568760i;
        r105.owner_perm_type = r101.f568761j;
        r105.create_uid = r101.f568762k;
        r105.display_tag = null;
        return new up5.b(r105);
    L5:
        r103 = false;
        goto L6
    }
}
