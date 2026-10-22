package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/PageChatterItemView;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/ChatterItemView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getLayoutId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageChatterItemView<T extends IChatterEntity> extends ChatterItemView<T> {
    public PageChatterItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PageChatterItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.ChatterItemView
    public int getLayoutId() {
        return R.layout.bitable_page_user_cell_item;
    }

    public PageChatterItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setBackground(null);
    }

    public /* synthetic */ PageChatterItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
