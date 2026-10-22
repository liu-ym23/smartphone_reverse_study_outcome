package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.table.RecordPageCoverAdapter;
import com.bytedance.ee.bear.bitable.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J(\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/table/RecordPageCoverAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/table/IPageCoverDelegate;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/card/view/table/IPageCoverDelegate;)V", "attachmentList", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "getAttachmentList", "()Ljava/util/List;", "setAttachmentList", "(Ljava/util/List;)V", "setData", "", "data", "getAttachmentEntity", "position", "", "getCount", "areAttachmentsEqual", "", "list1", "list2", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordCoverAdapter extends RecordPageCoverAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends AttachmentEntity> f214010e;

    @Override // com.bytedance.ee.bear.bitable.card.view.table.RecordPageCoverAdapter, androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f214010e.size();
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.table.RecordPageCoverAdapter
    public final AttachmentEntity f(int r100) {
        return (AttachmentEntity) m.j(this.f214010e, r100, null);
    }

    public ItemViewRecordCoverAdapter(Context r100, com.bytedance.ee.bear.bitable.card.view.table.m r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "delegate");
        super(r100, r101);
        this.f214010e = new ArrayList();
    }
}
