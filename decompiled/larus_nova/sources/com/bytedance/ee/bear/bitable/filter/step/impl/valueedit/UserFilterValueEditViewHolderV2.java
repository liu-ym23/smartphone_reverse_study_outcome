package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class UserFilterValueEditViewHolderV2 extends ChatterFilterValueEditViewHolder<UserEntity, UserListResult> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/UserFilterValueEditViewHolderV2$UserListResult;", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/ChatterFilterValueEditViewHolder$ChatterListResult;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "<init>", "()V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserListResult extends ChatterFilterValueEditViewHolder.ChatterListResult<UserEntity> {
        public UserListResult() {
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.ChatterFilterValueEditViewHolder
    public final String s() {
        return "getFieldUserOptions";
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a
    public final Object c() {
        if ((!((ArrayList) this.f211923u).isEmpty()) == true) goto L7;
        return null;
    L7:
        return (UserEntity[]) ((ArrayList) this.f211923u).toArray(new UserEntity[0]);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.ChatterFilterValueEditViewHolder
    public final Class<UserListResult> r() {
        return UserListResult.class;
    }

    public UserFilterValueEditViewHolderV2(Context r100, FilterFieldOption r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
    }
}
