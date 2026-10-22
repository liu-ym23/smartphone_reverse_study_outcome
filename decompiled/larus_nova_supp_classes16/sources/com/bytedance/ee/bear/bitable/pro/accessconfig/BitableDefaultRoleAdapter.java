package com.bytedance.ee.bear.bitable.pro.accessconfig;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.pro.BitableProAdapter;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultRoleAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultRoleViewHolder;", "itemClickListener", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "convert", "helper", "item", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDefaultRoleAdapter extends BaseQuickAdapter<Role, DefaultRoleViewHolder> {
    public final Function1<Role, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public BitableDefaultRoleAdapter(Function1<? super Role, Unit> r2) {
        super(2131558950);
        this.a = r2;
    }

    public final void convert(BaseViewHolder r3, Object r4) {
        DefaultRoleViewHolder r5 = (DefaultRoleViewHolder) r3;
        Role r6 = (Role) r4;
        Intrinsics.checkNotNullParameter(r5, "helper");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.a.setText(r6.getName());
        int r0 = BitableProAdapter.b;
        String r1 = BitableProAdapter.b.a(((BaseQuickAdapter) this).mContext, r6);
        r5.b.setText(r1);
        AppCompatImageView r2 = r5.c;
        if (r6.isDefaultRole() == false) goto L5;
        int r7 = 0;
    L6:
        r2.setVisibility(r7);
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new d(this, r6));
        return;
    L5:
        r7 = 8;
        goto L6
    }
}
