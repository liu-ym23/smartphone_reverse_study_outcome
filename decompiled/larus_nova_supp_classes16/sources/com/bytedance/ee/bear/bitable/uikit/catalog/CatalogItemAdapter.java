package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ.\u0010&\u001a\u00020'2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00020)j\b\u0012\u0004\u0012\u00020\u0002`*2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\tJ\u0018\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0002H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "context", "Landroid/content/Context;", JSEventListener.ACTION, "", "whiteThene", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Z)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getAction", "()Ljava/lang/String;", "getWhiteThene", "()Z", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getActionHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setActionHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "catalogItemTouchCallback", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTouchCallback;", "getCatalogItemTouchCallback", "()Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTouchCallback;", "setCatalogItemTouchCallback", "(Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTouchCallback;)V", "touchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "setTouchHelper", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "setData", "", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "canSort", "convert", "helper", "item", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogItemAdapter extends BaseQuickAdapter<CatalogItemModel, BaseViewHolder> {
    public final Context a;
    public final boolean b;
    public gv4.a c;
    public final CatalogItemTouchCallback d;
    public final ItemTouchHelper e;

    public final Context getContext() {
        return this.a;
    }

    public final void convert(BaseViewHolder r3, Object r4) {
        CatalogItemModel r5 = (CatalogItemModel) r4;
        Intrinsics.checkNotNullParameter(r3, "helper");
        Intrinsics.checkNotNullParameter(r5, "item");
        View r6 = ((RecyclerView.ViewHolder) r3).itemView;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemView");
        CatalogItemView r7 = (CatalogItemView) r6;
        r7.a(r5, this.c, getRecyclerView().getMeasuredWidth());
        if (this.b == false) goto L5;
        r7.getCatalogWrapperFromXml().setBackgroundResource(2131232268);
        return;
    L5:
        r7.getCatalogWrapperFromXml().setBackgroundResource(2131232267);
    }

    public CatalogItemAdapter(Context r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        super(2131558898);
        this.a = r2;
        this.b = r4;
        CatalogItemTouchCallback r5 = new CatalogItemTouchCallback(r2, this, r3);
        this.d = r5;
        this.e = new ItemTouchHelper(r5);
    }
}
