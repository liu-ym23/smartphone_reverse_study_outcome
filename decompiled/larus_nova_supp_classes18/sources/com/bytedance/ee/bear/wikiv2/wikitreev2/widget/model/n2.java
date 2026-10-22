package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetFavoriteRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n2<T, R> implements Function {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ ar5.a b;

    public n2(WikiTreeModel r1, ar5.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        WikiRelation r5 = (WikiRelation) r4;
        Intrinsics.checkNotNullParameter(r5, "relation");
        SpaceUserPerm r0 = r5.user_space_perm;
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        WikiTreeModel r2 = this.a;
        if (r2.favoriteEnable == false) goto L15;
        if (r1 == false) goto L15;
        return new GetFavoriteRelationPuller(r2.netService).c(new GetFavoriteRelationPuller.Params(this.b.a)).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.u()).map(new m2(r5));
    L15:
        return Flowable.just(r5);
    L5:
        if (r0.view_wiki_info == false) goto L9;
        if (r0.view_wiki_collaborator == false) goto L9;
        r1 = true;
        goto L10
    }
}
