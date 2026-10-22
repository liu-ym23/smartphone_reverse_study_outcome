package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/CardChatterCellContainer;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/ChatterCellContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dropTriangle", "Landroid/widget/ImageView;", "setDropTriangleVisibility", "", "visible", "", "setDropTriangleSelected", "selected", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardChatterCellContainer<T extends IChatterEntity> extends ChatterCellContainer<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f207499f;

    public CardChatterCellContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardChatterCellContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.ChatterCellContainer
    public void setDropTriangleSelected(boolean r100) {
        this.f207499f.setSelected(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.ChatterCellContainer
    public void setDropTriangleVisibility(boolean r100) {
        ImageView r101 = this.f207499f;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public CardChatterCellContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f207499f = (ImageView) getRoot().findViewById(R.id.bitable_cell_user_drop_triangle);
    }

    public /* synthetic */ CardChatterCellContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
