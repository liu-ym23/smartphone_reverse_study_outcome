package com.bytedance.ee.bear.wikiv2.home2;

import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.diff.BaseQuickDiffCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/WikiSpaceDiffCallback;", "Lcom/chad/library/adapter/base/diff/BaseQuickDiffCallback;", "Lcom/bytedance/ee/bear/wikiv2/home/api/SpaceBean;", "newList", "", "<init>", "(Ljava/util/List;)V", "areItemsTheSame", "", "old", "new", "areContentsTheSame", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceDiffCallback extends BaseQuickDiffCallback<SpaceBean> {
    public WikiSpaceDiffCallback(List<? extends SpaceBean> r2) {
        Intrinsics.checkNotNullParameter(r2, "newList");
        super(r2);
    }

    public final boolean areContentsTheSame(Object r4, Object r5) {
        SpaceBean r6 = (SpaceBean) r4;
        SpaceBean r7 = (SpaceBean) r5;
        Intrinsics.checkNotNullParameter(r6, "old");
        Intrinsics.checkNotNullParameter(r7, "new");
        if (Intrinsics.areEqual(ListProtector.get(getOldList(), 0), r6) == false) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(ListProtector.get(getNewList(), 0), r7) == false) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(ListProtector.get(getOldList(), CollectionsKt.getLastIndex(getOldList())), r6) == false) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(ListProtector.get(getNewList(), CollectionsKt.getLastIndex(getNewList())), r7) == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r6.space_id, r7.space_id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(r6.space_name, r7.space_name) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r6.space_icon, r7.space_icon) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(r6.description, r7.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r6.tenant_id, r7.tenant_id) == true) goto L23;
        return false;
    L23:
        if (r6.is_star == r7.is_star) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(r6.browse_time, r7.browse_time) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(r6.root_token, r7.root_token) == true) goto L29;
        return false;
    L29:
        if (r6.wiki_scope == r7.wiki_scope) goto L31;
        return false;
    L31:
        if (r6.space_type == r7.space_type) goto L33;
        return false;
    L33:
        if (r6.open_sharing != r7.open_sharing) goto L48;
        return true;
    L48:
        return false;
    }

    public final boolean areItemsTheSame(Object r2, Object r3) {
        SpaceBean r4 = (SpaceBean) r2;
        SpaceBean r5 = (SpaceBean) r3;
        Intrinsics.checkNotNullParameter(r4, "old");
        Intrinsics.checkNotNullParameter(r5, "new");
        return Intrinsics.areEqual(r4.space_id, r5.space_id);
    }
}
