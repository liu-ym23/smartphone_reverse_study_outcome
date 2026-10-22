package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0014\u0010\n\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridViewV2;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "layoutRes", "getLayoutRes", "()I", "init", "", "setShowAddButton", "show", "", "setOnAddClickListener", "listener", "Landroid/view/View$OnClickListener;", "setAddIcon", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentGridViewV2 extends AttachmentGridView {

    public static final class a {
    }

    static {
    }

    public AttachmentGridViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AttachmentGridViewV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public int getLayoutRes() {
        return R.layout.bitable_card_attachment_grid_layout_v2;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public final void a() {
        super.a();
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.mobile.pure_item_view_bigimage_polish") == false) goto L9;
        int r100 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.pure_item_view") == false) goto L9;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.config_item_view") == false) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L17;
        setMAttachmentAdapter(new AttachmentAdapterV2());
        int r102 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.attachment_stable_id_crash_fix_enable") == false) goto L14;
        getMAttachmentAdapter().setHasStableIds(false);
    L15:
        getMRecyclerView().setAdapter(getMAttachmentAdapter());
        getMRecyclerView().setLayoutManager(new GridLayoutManager(getContext(), 3));
        return;
    L14:
        getMAttachmentAdapter().setHasStableIds(true);
        goto L15
    L17:
        return;
    L9:
        r101 = false;
        goto L10
    }

    public final void setAddIcon(Icon r100) {
        AttachmentAdapter r101 = getMAttachmentAdapter();
        if ((r101 instanceof AttachmentAdapterV2) == false) goto L5;
        AttachmentAdapterV2 r102 = (AttachmentAdapterV2) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r102.f207395j, r100) == true) goto L12;
        r102.f207395j = r100;
        r102.notifyDataSetChanged();
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setOnAddClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        AttachmentAdapter r101 = getMAttachmentAdapter();
        if ((r101 instanceof AttachmentAdapterV2) == false) goto L5;
        AttachmentAdapterV2 r102 = (AttachmentAdapterV2) r101;
    L6:
        if (r102 == null) goto L9;
        r102.f207394i = r100;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setShowAddButton(boolean r100) {
        AttachmentAdapter r101 = getMAttachmentAdapter();
        if ((r101 instanceof AttachmentAdapterV2) == false) goto L5;
        AttachmentAdapterV2 r102 = (AttachmentAdapterV2) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.f207393h == r100) goto L12;
        r102.f207393h = r100;
        r102.notifyDataSetChanged();
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public AttachmentGridViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ AttachmentGridViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
