package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.card.view.page.RecordCatalogView;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordCatalogBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCatalog;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewHeaderData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordCatalogBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordCatalogBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordCatalog extends LinearLayout implements gv4.b<ItemViewHeaderData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordCatalogBinding f213991a;

    public final BitableItemViewRecordCatalogBinding getBinding() {
        return this.f213991a;
    }

    public ItemViewRecordCatalog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ItemViewRecordCatalog(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_record_catalog, this);
        int r102 = R.id.catalog_view;
        RecordCatalogView r103 = (RecordCatalogView) ViewBindings.findChildViewById(this, R.id.catalog_view);
        if (r103 == null) goto L9;
        r102 = R.id.record_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.record_title);
        if (r104 == null) goto L9;
        this.f213991a = new BitableItemViewRecordCatalogBinding(this, r103, r104);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
