package com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter;

import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/UnSelectFieldViewHolder;", "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/SelectFieldViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "holderStateDelegate", "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/UnSelectFieldViewHolder$HolderStateDelegate;", "getHolderStateDelegate", "()Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/UnSelectFieldViewHolder$HolderStateDelegate;", "setHolderStateDelegate", "(Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/adapter/UnSelectFieldViewHolder$HolderStateDelegate;)V", "initStyle", "", "position", "", "HolderStateDelegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnSelectFieldViewHolder extends SelectFieldViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f209241g;

    public interface a {
        boolean a();
    }

    @Override // com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.SelectFieldViewHolder
    public final void T3() {
        AppCompatImageView r100 = this.f209236b;
        a r101 = this.f209241g;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.a() != true) goto L7;
    L8:
        if (r102 == true) goto L10;
        int r103 = R.drawable.bitable_icon_add_disable;
    L11:
        r100.setImageResource(r103);
        this.f209237c.setVisibility(8);
        return;
    L10:
        r103 = R.drawable.bitable_icon_add_blue_500;
    L7:
        r102 = false;
        goto L8
    }

    public UnSelectFieldViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        super(r100);
    }
}
