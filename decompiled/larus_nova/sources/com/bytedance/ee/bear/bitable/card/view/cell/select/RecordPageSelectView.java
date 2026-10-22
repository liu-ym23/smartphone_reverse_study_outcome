package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.style.BaseTagSize;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/RecordPageSelectView;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseRecordSelectView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getItemWidthMargin", "", "getLayoutId", "getFlexAdapter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RecordPageSelectView extends BaseRecordSelectView {
    public RecordPageSelectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordPageSelectView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseRecordSelectView
    public float getItemWidthMargin() {
        return com.bytedance.ee.util.ui.n.d(4);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseRecordSelectView
    public int getLayoutId() {
        return R.layout.bitable_page_multiselect_layout;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseRecordSelectView
    public BaseFlexSelectAdapter getFlexAdapter() {
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L6;
        return new FlexPageSelectAdapterV2(BaseTagSize.LARGE);
    L6:
        return new FlexPageSelectAdapter();
    }

    public RecordPageSelectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ RecordPageSelectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
