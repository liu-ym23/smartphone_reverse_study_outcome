package ef5;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.extension.events.CardAdapterActionType;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CardAdapterActionType f472437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f472438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView.ViewHolder f472439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentBean.CommentDetail f472440d;

    public final String toString() {
        return "CardAdapterActionEvent(recyclerView=" + this.f472438b + ", holder=" + this.f472439c + ", item=" + this.f472440d + ')';
    }

    public b(CardAdapterActionType r100, RecyclerView r101, RecyclerView.ViewHolder r102, CommentBean.CommentDetail r103) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        this.f472437a = r100;
        this.f472438b = r101;
        this.f472439c = r102;
        this.f472440d = r103;
    }
}
