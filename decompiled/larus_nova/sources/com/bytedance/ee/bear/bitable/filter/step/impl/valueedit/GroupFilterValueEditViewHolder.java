package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.GroupEntity;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class GroupFilterValueEditViewHolder extends ChatterFilterValueEditViewHolder<GroupEntity, GroupListResult> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/GroupFilterValueEditViewHolder$GroupListResult;", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/ChatterFilterValueEditViewHolder$ChatterListResult;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/GroupEntity;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GroupListResult extends ChatterFilterValueEditViewHolder.ChatterListResult<GroupEntity> {
        public GroupListResult() {
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.ChatterFilterValueEditViewHolder
    public final String s() {
        return "getFieldGroupOptions";
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final Object c() {
        if ((!((ArrayList) this.f211923u).isEmpty()) == true) goto L7;
        return null;
    L7:
        return (GroupEntity[]) ((ArrayList) this.f211923u).toArray(new GroupEntity[0]);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.ChatterFilterValueEditViewHolder
    public final Class<GroupListResult> r() {
        return GroupListResult.class;
    }

    public GroupFilterValueEditViewHolder(Context r100, FilterFieldOption r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
    }
}
