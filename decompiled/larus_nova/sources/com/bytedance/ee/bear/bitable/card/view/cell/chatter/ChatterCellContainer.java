package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool$recycledViewPool$1;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.SafeFlexboxLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 8*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u00018B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001a\u001a\u00020\tH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\u0016\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&J\u000e\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020)H\u0016J\u0015\u00100\u001a\u00020)2\b\u00101\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u00102J\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020,J\u0010\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u000107R\u0014\u0010\f\u001a\u00020\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/ChatterCellContainer;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "flexView", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexView;", "recyclerView", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView;", "getRecyclerView", "()Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView;", "adapter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter;", "getLayoutId", "getChatterAdapter", "value", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;", "delegate", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/IChatterDelegate;)V", "setData", "", "userList", "", "limitVisibleLine", GXTemplateKey.STYLE_FONT_LINES, "", "setDropTriangleVisibility", "visible", "", "setDropTriangleSelected", "selected", "getItemWidthMargin", "getItemWidth", "user", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;)F", "updateWidth", "needFullWidth", "injectClickListener", "listener", "Landroid/view/View$OnClickListener;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatterCellContainer<T extends IChatterEntity> extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f207500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f207501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InnerRecyclerView f207502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlexChatterCellAdapter<T> f207503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e<T> f207504e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatterCellContainer<T> f207505a;

        public a(ChatterCellContainer<T> r100) {
            this.f207505a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public ChatterCellContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatterCellContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public float getItemWidthMargin() {
        return 0.0f;
    }

    public int getLayoutId() {
        return R.layout.bitable_cell_user_container_v2;
    }

    public void setDropTriangleSelected(boolean r100) {
    }

    public void setDropTriangleVisibility(boolean r100) {
    }

    public FlexChatterCellAdapter<T> getChatterAdapter() {
        return new FlexChatterCellAdapter();
    }

    public final FlexChatterCellAdapter<T> getAdapter() {
        return this.f207503d;
    }

    public e<T> getDelegate() {
        return this.f207504e;
    }

    public final InnerRecyclerView getRecyclerView() {
        return this.f207502c;
    }

    public final View getRoot() {
        return this.f207500a;
    }

    public final void setData(List<? extends T> r100) {
        FlexChatterCellAdapter<T> r101 = this.f207501b.f207505a.getAdapter();
        if (r100 == null) goto L5;
        r101.f207518h = r100;
        r101.notifyDataSetChanged();
        return;
    L5:
        r101.getClass();
        r101.f207518h = CollectionsKt.emptyList();
        r101.notifyDataSetChanged();
    }

    public void setDelegate(e<T> r100) {
        this.f207504e = r100;
        this.f207501b.f207505a.getAdapter().f207511a = r100;
        if (r100 == null) goto L12;
        y1 r101 = r100.getMembraneManager();
        if (r101 == null) goto L13;
        AsyncPrefetchAndRecyclePool r102 = r101.f209194a;
        if (r102 == null) goto L14;
        AsyncPrefetchAndRecyclePool$recycledViewPool$1 r103 = r102.f208449d;
        if (r103 == null) goto L15;
        this.f207502c.setRecycledViewPool(r103);
        r103.setMaxRecycledViews(R.layout.bitable_page_cell_chatter_rv_item, 20);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public ChatterCellContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(getLayoutId(), this);
        this.f207500a = r103;
        InnerRecyclerView r104 = (InnerRecyclerView) r103.findViewById(R.id.recycler_view);
        this.f207502c = r104;
        FlexChatterCellAdapter<T> r105 = getChatterAdapter();
        this.f207503d = r105;
        r104.setLayoutManager(new SafeFlexboxLayoutManager(r100));
        r104.setAdapter(r105);
        this.f207501b = new a(this);
    }

    public /* synthetic */ ChatterCellContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
