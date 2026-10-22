package com.bytedance.ee.bear.bitable.pro.accessconfig;

import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.pro.BitableProAdapter;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultRoleAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultRoleViewHolder;", "itemClickListener", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "convert", "helper", MapController.ITEM_LAYER_TAG, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDefaultRoleAdapter extends BaseQuickAdapter<Role, DefaultRoleViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Role, Unit> f215112a;

    /* JADX WARN: Multi-variable type inference failed */
    public BitableDefaultRoleAdapter(Function1<? super Role, Unit> r100) {
        super(R.layout.bitable_default_role_item);
        this.f215112a = r100;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Role r101) {
        DefaultRoleViewHolder r102 = (DefaultRoleViewHolder) r100;
        Role r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "helper");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f215115a.setText(r103.getName());
        int r104 = BitableProAdapter.f215048b;
        String r105 = BitableProAdapter.b.a(this.mContext, r103);
        r102.f215116b.setText(r105);
        AppCompatImageView r106 = r102.f215117c;
        if (r103.isDefaultRole() == false) goto L5;
        int r107 = 0;
    L6:
        r106.setVisibility(r107);
        r102.itemView.setOnClickListener(new d(this, r103));
        return;
    L5:
        r107 = 8;
        goto L6
    }
}
