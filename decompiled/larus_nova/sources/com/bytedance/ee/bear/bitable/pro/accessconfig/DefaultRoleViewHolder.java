package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultRoleViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "roleName", "Landroid/widget/TextView;", "getRoleName", "()Landroid/widget/TextView;", "roleDesc", "getRoleDesc", "roleSelect", "Landroidx/appcompat/widget/AppCompatImageView;", "getRoleSelect", "()Landroidx/appcompat/widget/AppCompatImageView;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultRoleViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f215115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f215116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f215117c;

    public DefaultRoleViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f215115a = (TextView) r100.findViewById(R.id.role_name);
        this.f215116b = (TextView) r100.findViewById(R.id.role_desc);
        this.f215117c = (AppCompatImageView) r100.findViewById(R.id.role_select);
    }
}
