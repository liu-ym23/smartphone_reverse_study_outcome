package com.bytedance.ee.bear.bitable.pro.roledetail;

import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.core.usercomponent.b;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.pro.TableRole;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0005j\b\u0012\u0004\u0012\u00020\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0002H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0005j\b\u0012\u0004\u0012\u00020\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableRoleTablePermAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/pro/TableRole;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "tableRoleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "convert", "", "helper", "tableRole", "getTablePermDesc", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRoleTablePermAdapter extends BaseQuickAdapter<TableRole, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<TableRole> f215243a;

    public BitableRoleTablePermAdapter(ArrayList<TableRole> r100) {
        Intrinsics.checkNotNullParameter(r100, "tableRoleList");
        super(R.layout.bitable_pro_table_perm_item, r100);
        this.f215243a = r100;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, TableRole r101) {
        TableRole r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "helper");
        Intrinsics.checkNotNullParameter(r102, "tableRole");
        BaseViewHolder r103 = r100.setText(R.id.entityName, r102.getTableName());
        int r104 = c.f207079a;
        int r105 = n.f214744a;
        if (b.c("ccm.bitable.mobile_advance_new_permission.enable") == false) goto L6;
        String r106 = r102.getPermDescV2(this.mContext);
    L25:
        r103.setText(R.id.entityPermDesc, r106);
        return;
    L6:
        if (r102.canEditAllRowAndColumn() == false) goto L9;
        int r107 = R.string.Bitable_AdvancedPermission_CanEditFieldAndRecord;
    L24:
        r106 = this.mContext.getString(r107);
        goto L25
    L9:
        if (r102.canEditAllRow() == false) goto L12;
        r107 = R.string.Bitable_AdvancedPermission_CanEditAllRecord;
        goto L24
    L12:
        if (r102.canEditPartAndReadOtherRow() == false) goto L15;
        r107 = R.string.Bitable_AdvancedPermission_CanEditSomeRecordAndViewOthers;
        goto L24
    L15:
        if (r102.canEditPartAndInvisibleOtherRow() == false) goto L18;
        r107 = R.string.Bitable_AdvancedPermission_CanEditSomeRecordOnly;
        goto L24
    L18:
        if (r102.canReadAllRow() == false) goto L21;
        r107 = R.string.Bitable_AdvancedPermission_CanViewAllRecord;
        goto L24
    L21:
        if (r102.canReadPartRow() == false) goto L23;
        r107 = R.string.Bitable_AdvancedPermission_CanViewSomeRecord;
        goto L24
    L23:
        r107 = R.string.Bitable_AdvancedPermission_NoAccess;
        goto L24
    }
}
