package com.bytedance.ee.bear.bitable.pro.roledetail;

import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.core.usercomponent.b;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.pro.TableRole;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0005j\b\u0012\u0004\u0012\u00020\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0005j\b\u0012\u0004\u0012\u00020\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableRoleTablePermAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/pro/TableRole;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "tableRoleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "convert", "", "helper", "tableRole", "getTablePermDesc", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRoleTablePermAdapter extends BaseQuickAdapter<TableRole, BaseViewHolder> {
    public final ArrayList<TableRole> a;

    public BitableRoleTablePermAdapter(ArrayList<TableRole> r2) {
        Intrinsics.checkNotNullParameter(r2, "tableRoleList");
        super(2131559127, r2);
        this.a = r2;
    }

    public final void convert(BaseViewHolder r3, Object r4) {
        TableRole r5 = (TableRole) r4;
        Intrinsics.checkNotNullParameter(r3, "helper");
        Intrinsics.checkNotNullParameter(r5, "tableRole");
        BaseViewHolder r6 = r3.setText(2131371695, r5.getTableName());
        int r0 = c.a;
        int r1 = n.a;
        if (b.c("ccm.bitable.mobile_advance_new_permission.enable") == false) goto L6;
        String r7 = r5.getPermDescV2(((BaseQuickAdapter) this).mContext);
    L25:
        r6.setText(2131371696, r7);
        return;
    L6:
        if (r5.canEditAllRowAndColumn() == false) goto L9;
        int r8 = 2131886128;
    L24:
        r7 = ((BaseQuickAdapter) this).mContext.getString(r8);
        goto L25
    L9:
        if (r5.canEditAllRow() == false) goto L12;
        r8 = 2131886127;
        goto L24
    L12:
        if (r5.canEditPartAndReadOtherRow() == false) goto L15;
        r8 = 2131886129;
        goto L24
    L15:
        if (r5.canEditPartAndInvisibleOtherRow() == false) goto L18;
        r8 = 2131886130;
        goto L24
    L18:
        if (r5.canReadAllRow() == false) goto L21;
        r8 = 2131886131;
        goto L24
    L21:
        if (r5.canReadPartRow() == false) goto L23;
        r8 = 2131886132;
        goto L24
    L23:
        r8 = 2131886166;
        goto L24
    }
}
