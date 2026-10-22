package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.ExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1;
import com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define.IListAdapter;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.PullDataActionPayload;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.RenderMeta;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.FooterView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.GroupHeaderData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.GroupHeaderView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.BitableViewTracer;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ct4.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u0000 W*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003:\u0001WB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0015H\u0016J\u001c\u0010)\u001a\u00060*R\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0015H\u0016J\u001c\u0010.\u001a\u00020\u001b2\n\u0010/\u001a\u00060*R\u00020\u00022\u0006\u0010(\u001a\u00020\u0015H\u0016J\u0012\u00100\u001a\u00020\u001b2\n\u0010/\u001a\u00060*R\u00020\u0002J\b\u00101\u001a\u00020\u001bH\u0004J\u0014\u00102\u001a\u00020\u001b2\n\u0010/\u001a\u00060*R\u00020\u0002H\u0014J\u0010\u00103\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0015H\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00106\u001a\u0002052\u0006\u0010+\u001a\u00020,H&J,\u00107\u001a\u00020\u001b2\n\u0010/\u001a\u00060*R\u00020\u00022\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0015H\u0016J,\u0010:\u001a\u00020\u001b2\n\u0010/\u001a\u00060*R\u00020\u00022\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0015H&J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0004J\u0010\u0010<\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0004J\u0010\u0010=\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001fH\u0002J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000?H\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010B\u001a\u00020\u0019H\u0002J\b\u0010C\u001a\u00020\u0015H\u0004J\b\u0010D\u001a\u00020\u0015H\u0002J\u0010\u0010E\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0015H\u0004J\u0006\u0010F\u001a\u00020\u0015J\u0010\u0010G\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0016J\u0018\u0010H\u001a\u0002052\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020\u0015H\u0016J\"\u0010I\u001a\u00020\u001b2\b\u0010J\u001a\u0004\u0018\u0001052\u0006\u0010K\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0016J\b\u0010L\u001a\u00020\u0019H\u0016J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0015H\u0004J\u0010\u0010N\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0014J\b\u0010O\u001a\u00020\u001bH\u0002J\u001c\u0010P\u001a\u00020\u001b2\b\b\u0002\u0010Q\u001a\u00020\u00192\b\b\u0002\u0010R\u001a\u00020\u0019H\u0002J \u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\u0019H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/list/BaseRecordViewAdapterPartial;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IListAdapter;", "Lcom/bytedance/ee/bear/bitable/cardview/widget/StickyItemViewLayout$IStickyAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewContext", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewContext;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewContext;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getViewContext", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewContext;", "setViewContext", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseViewContext;)V", ContainerPosition.FOOTER, "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "uiItemCount", "", "uiCacheMeta", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/RenderMeta;", "delayUpdate", "", "checkData", "", "updateUI", "getCurrentGroupPositions", "", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "scrollToGroupPosition", "scrollGroupPosition", "getIndex", "groupPosition", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)Ljava/lang/Integer;", "setFooter", "getItemCount", "getItemViewType", "position", "onCreateViewHolder", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IListAdapter$BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onRecordShowLoading", "tryUpdateReferMapping", "bindFooter", "preload", "createGroupHeaderView", "Landroid/view/View;", "createRecordView", "bindGroupHeaderData", "itemView", MapController.ITEM_LAYER_TAG, "bindRecordData", "isFirstItemInGroup", "isLastItemInGroup", "isFooter", "getDataProvider", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/define/IBaseDataProvider;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "canUpdate", "findFirstItemPosition", "findLastItemPosition", "positionToGroupPosition", "getStickItemViewType", "isStickyItem", "createStickyItemView", "onBindStickyView", "view", "noScroll", "hasGroup", "updateReferMapping", "needShowStickView", "tryRunDelayUpdate", "updateNowOrDelay", "postRunnable", "forceDelay", "scrollToPositionWithOffset", "index", "offset", "animator", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseRecordViewAdapterPartial<T> extends IListAdapter implements StickyItemViewLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f213326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ct4.b<T> f213327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleItemModel f213328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f213329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RenderMeta f213330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f213331f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f213333a = null;

        static {
            f213333a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.ee.bear.bitable.infoarch.nativeview.b.d("post runnable.", false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public void E2(IListAdapter.BaseViewHolder r100, View r101, GroupPosition r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
    }

    public abstract void F2(IListAdapter.BaseViewHolder r100, View r101, GroupPosition r102, int r103);

    public abstract View I2(ViewGroup r100);

    public boolean M2(int r100) {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.a
    public final /* synthetic */ int U1() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define.IListAdapter
    public final void C2() {
        int r100 = 0;
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.d("startUpdateUI", false);
        RenderMeta r101 = this.f213327b.a().e();
        RenderMeta r102 = this.f213330e;
        if (r102 != null) goto L5;
        r102 = r101;
    L5:
        this.f213330e = r101;
        int r103 = r101.getItemCount();
        int r104 = this.f213329d;
        int r105 = J2();
        GroupPosition r106 = r102.positionToGroupPosition(r105);
        Pair<Integer, GroupPosition> r107 = r102.getReferMapping();
        GroupPosition r108 = r101.consumeTargetGroupPosition();
        int r110 = -2;
        if (r108 == null) goto L9;
        int r109 = r101.ordinalInMeta(r108);
    L15:
        if (r108 != null) goto L17;
        GroupPosition r111 = r106;
    L18:
        int r112 = r109 - 1;
        int r113 = r112 - r105;
        int r114 = (r103 - r112) - (r104 - r105);
        if (r113 <= 0) goto L21;
        notifyItemRangeInserted(0, r113);
        this.f213329d += r113;
        int r115 = r105 + r113;
    L36:
        if (G2() == false) goto L41;
        int r116 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.fix_partial_list_update") == false) goto L40;
        notifyItemRangeChanged(r105, (K2() - J2()) + 3);
        goto L41
    L40:
        notifyItemRangeChanged(r105, 15);
    L41:
        if (r114 <= 0) goto L44;
        r100 = this.f213329d - 1;
        notifyItemRangeInserted(r100, r114);
        this.f213329d += r114;
    L46:
        r101.updateReferMapping(new Pair(Integer.valueOf(r115), r111));
        StringBuilder r117 = new StringBuilder("UpdateUIfirstItemP:");
        r117.append(r105);
        r117.append(", historyMapping:");
        r117.append(r107);
        r117.append(", historyGP:");
        r117.append(r106);
        r117.append(", ");
        if (r108 != null) goto L49;
        String r118 = "use historyGP, ";
    L50:
        r117.append(r118);
        r117.append("oldGroupPositionOrdinal:");
        r117.append(r110);
        r117.append(", ");
        if (r109 != r110) goto L53;
        String r119 = "use historyGPOrdinal, ";
    L54:
        r117.append(r119);
        r117.append("newMetaItemCount:");
        r117.append(r103);
        r117.append(", currentUICount:");
        r117.append(r104);
        r117.append(", ");
        if (r113 <= 0) goto L58;
        String r120 = "left insert " + r113 + " elements, ";
    L61:
        r117.append(r120);
        if (r114 <= 0) goto L64;
        String r121 = "right in" + r100 + " insert " + r114 + " elements,";
    L67:
        r117.append(r121);
        r117.append("canUpdate:");
        r117.append(G2());
        r117.append(", updateUICount:");
        r117.append(this.f213329d);
        r117.append(", finalP:");
        r117.append(r115);
        r117.append(", finalGP:");
        r117.append(r111);
        r117.append(". ");
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.d(r117.toString(), true);
        this.f213327b.getRecyclerView().post(b.f213333a);
        return;
    L64:
        if (r114 >= 0) goto L66;
        r121 = "right in" + r100 + " delete " + (-r114) + " elements, ";
        goto L67
    L66:
        r121 = "right ok。";
        goto L67
    L58:
        if (r113 >= 0) goto L60;
        r120 = "left delete " + (-r113) + " elements, ";
        goto L61
    L60:
        r120 = "left ok。";
        goto L61
    L53:
        r119 = "change ordinal:" + r109 + ", ";
        goto L54
    L49:
        r118 = "change GP:" + r108 + ',';
        goto L50
    L44:
        if (r114 >= 0) goto L46;
        int r122 = Math.abs(r114);
        int r123 = (this.f213329d - 1) - r122;
        notifyItemRangeRemoved(r123, r122);
        this.f213329d -= r122;
        r100 = r123;
        goto L46
    L21:
        if (r113 < 0) goto L23;
    L34:
        r115 = r105;
        goto L36
    L23:
        if (G2() == false) goto L34;
        RecyclerView.ViewHolder r124 = this.f213327b.getRecyclerView().findViewHolderForAdapterPosition(r105);
        if (r124 == null) goto L29;
        View r125 = r124.itemView;
        if (r125 == null) goto L29;
        int r126 = r125.getTop();
    L30:
        int r127 = Math.abs(r113);
        notifyItemRangeRemoved(0, r127);
        notifyItemRangeChanged(0, getItemCount() - r127);
        this.f213329d -= r127;
        int r128 = r105 - r127;
        LinearLayoutManager r129 = L2();
        if (r129 == null) goto L33;
        r129.scrollToPositionWithOffset(r128, r126);
    L33:
        r115 = r128;
    L29:
        r126 = 0;
        goto L30
    L17:
        r111 = r108;
        goto L18
    L9:
        if (r101.hasGroup() == r102.hasGroup()) goto L11;
        r108 = r101.getInitMapping().getSecond();
        r109 = r101.getInitMapping().getFirst().intValue() + 1;
        goto L15
    L11:
        r110 = r101.ordinalInMeta(r106);
        if (r110 >= 0) goto L14;
        r108 = r101.getNearGroupPosition(r106);
        r109 = r101.ordinalInMeta(r108);
        goto L15
    L14:
        r108 = null;
        r109 = r110;
        goto L15
    }

    public final boolean G2() {
        RecyclerView r100 = this.f213327b.getRecyclerView();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !r100.isComputingLayout();
    }

    public final LinearLayoutManager L2() {
        RecyclerView.LayoutManager r100 = this.f213327b.getRecyclerView().getLayoutManager();
        if ((r100 instanceof LinearLayoutManager) == true) goto L7;
        return null;
    L7:
        return (LinearLayoutManager) r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = this.f213329d;
        if (r100 > 0) goto L7;
        return 0;
    L7:
        return r100 + 1;
    }

    @Override // com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.a
    public final boolean h2() {
        RenderMeta r100 = this.f213330e;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.hasGroup() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define.IListAdapter
    public final List<GroupPosition> y2() {
        ArrayList r100 = new ArrayList();
        RenderMeta r101 = this.f213330e;
        if (r101 == null) goto L9;
        int r102 = J2();
        int r103 = K2();
        if (r102 > r103) goto L9;
    L6:
        r100.add(r101.positionToGroupPosition(r102));
        if (r102 == r103) goto L9;
        r102 = r102 + 1;
    L9:
        return r100;
    }

    public final int J2() {
        LinearLayoutManager r100 = L2();
        if (r100 == null) goto L5;
        int r101 = r100.findFirstVisibleItemPosition();
    L7:
        return RangesKt.coerceAtLeast(r101, 0);
    L5:
        r101 = 0;
        goto L7
    }

    public final int K2() {
        LinearLayoutManager r100 = L2();
        if (r100 == null) goto L5;
        int r101 = r100.findLastVisibleItemPosition();
    L7:
        return RangesKt.coerceAtLeast(r101, 0);
    L5:
        r101 = 0;
        goto L7
    }

    public final Context getContext() {
        return this.f213326a;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define.IListAdapter
    public final void A2(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "scrollGroupPosition");
        if (this.f213330e == null) goto L19;
        int r101 = J2();
        Integer r102 = z2(r100);
        if (r102 == null) goto L17;
        int r103 = r102.intValue();
        int r104 = n.d(40);
        if (Math.abs(r103 - r101) >= 30) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L14;
        RecyclerView r106 = this.f213327b.getRecyclerView();
        Intrinsics.checkNotNullParameter(r106, "<this>");
        ExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1 r107 = new ExtensionKt$smoothScrollToPositionWithOffset$linearSmoothScroller$1(r104, r106.getContext());
        r107.setTargetPosition(r103);
        RecyclerView.LayoutManager r108 = r106.getLayoutManager();
        if (r108 == null) goto L17;
        r108.startSmoothScroll(r107);
        goto L17
    L14:
        LinearLayoutManager r109 = L2();
        if (r109 == null) goto L17;
        r109.scrollToPositionWithOffset(r103, r104);
        goto L17
    L9:
        r105 = false;
    L17:
        this.f213331f = true;
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define.IListAdapter
    public final void B2(SimpleItemModel r100) {
        this.f213328c = r100;
    }

    public void D2(IListAdapter.BaseViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        View r101 = r100.itemView;
        String r102 = null;
        if ((r101 instanceof FooterView) == false) goto L5;
        FooterView r103 = (FooterView) r101;
    L6:
        if (r103 == null) goto L8;
        r103.a(this.f213328c, this.f213327b.e());
    L8:
        SimpleItemModel r104 = this.f213328c;
        if (r104 == null) goto L12;
        r102 = r104.getText();
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        this.f213327b.f465348b.f213638c.f213682a.f213672v++;
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public GroupHeaderView H2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        AttributeSet r101 = null;
        GroupHeaderView r102 = new GroupHeaderView(this.f213326a, r101, 6, 0);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, h.f465354a));
        return r102;
    }

    public final GroupPosition P2(int r100) {
        return this.f213327b.a().e().positionToGroupPosition(r100);
    }

    public final void R2(int r100) {
        Pair<Integer, GroupPosition> r101 = this.f213327b.a().e().getReferMapping();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == true) goto L10;
        Pair<Integer, ? extends GroupPosition> r103 = new Pair(Integer.valueOf(r100), P2(r100));
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.b("updateReferMapping", "mapping: " + r103);
        this.f213327b.a().e().updateReferMapping(r103);
        return;
    L10:
        return;
    L5:
        if (r101.getFirst().intValue() != r100) goto L7;
        r102 = true;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.a
    public final boolean T(int r100) {
        if (getItemViewType(r100) != 1001) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        GroupPosition r101 = P2(r100);
        if (r101.isGroupHeader() == false) goto L6;
        return 1001;
    L6:
        if (r101.isRecord() == false) goto L8;
        return 1002;
    L8:
        boolean r102 = true;
        if (r101.getOutOfBoundIndex() == 1) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L14;
        return 1003;
    L14:
        return 1000;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.define.IListAdapter
    public final Integer z2(GroupPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "groupPosition");
        RenderMeta r101 = this.f213330e;
        if (r101 == null) goto L12;
        int r102 = J2();
        GroupPosition r103 = P2(r102);
        int r104 = r101.ordinalInMeta(r103);
        int r105 = r101.ordinalInMeta(r100);
        int r106 = (r105 - r104) + r102;
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.b("scrollToGroupPosition", "referP:" + r102 + ", referGP:" + r103 + ", referOrdinal:" + r103 + ", targetOrdinal:" + r105 + ", targetGP:" + r100 + ", targetP:" + r106 + '.');
        boolean r107 = false;
        if (r106 >= 0) goto L7;
    L9:
        if (r107 == true) goto L11;
        return null;
    L11:
        return Integer.valueOf(r106);
    L7:
        if (r106 >= this.f213329d) goto L9;
        r107 = true;
        goto L9
    L12:
        return null;
    }

    public BaseRecordViewAdapterPartial(Context r100, ct4.b<T> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewContext");
        this.f213326a = r100;
        this.f213327b = r101;
        this.f213329d = 10;
        r101.getRecyclerView().addOnScrollListener(new AnonymousClass1(this));
    }

    public final void O2(IListAdapter.BaseViewHolder r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        GroupPosition r101 = P2(r110);
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.b("onBindViewHolder", "onBind: position:" + r110 + ", GP:" + r101);
        r100.f213302a = r101;
        boolean r102 = false;
        if (r101.isGroupHeader() == false) goto L6;
        E2(r100, r100.itemView, r101, r110);
    L14:
        ArrayList r103 = new ArrayList();
        r103.add(P2(r110));
        PullDataActionPayload r104 = this.f213327b.a().b(r103, false);
        if (r104 == null) goto L17;
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.c("pullData:" + r104.getPullDataActions() + '.', true);
        this.f213327b.e().a(r104);
    L17:
        com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.b r105 = this.f213327b.f465348b.f213638c.f213682a;
        r105.f213656f = Math.max(r105.f213656f, r110);
        RenderMeta r106 = this.f213330e;
        if (r106 != null) goto L20;
    L22:
        if (r102 == false) goto L25;
        R2(J2());
        return;
    L25:
        return;
    L20:
        if (r106.hasGroup() == true) goto L22;
        r102 = true;
        goto L22
    L6:
        if (r101.isRecord() == false) goto L9;
        BitableViewTracer r107 = this.f213327b.f465348b;
        r107.getClass();
        com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.e r108 = r107.f213638c;
        Intrinsics.checkNotNullParameter(r108, "viewLifecycleConsumer");
        System.currentTimeMillis();
        long r109 = System.currentTimeMillis();
        F2(r100, r100.itemView, r101, r110);
        com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.d r111 = new com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.d();
        r111.f213680g = System.currentTimeMillis() - r109;
        r111.f213681h = 1;
        r108.e(r111);
        goto L14
    L9:
        if (r101.getOutOfBoundIndex() != 1) goto L11;
        boolean r112 = true;
    L12:
        if (r112 == false) goto L14;
        D2(r100);
        goto L14
    L11:
        r112 = false;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        O2((IListAdapter.BaseViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        switch(r101) {
            case 1001: goto L7;
            case 1002: goto L6;
            case 1003: goto L5;
            default: goto L4;
        };
    L4:
        View r102 = new View(this.f213326a);
    L8:
        Intrinsics.checkNotNull(r102);
        return new IListAdapter.BaseViewHolder(r102);
    L5:
        r102 = LayoutInflater.from(this.f213326a).inflate(R.layout.bitable_list_footer_layout, r100, false);
        goto L8
    L6:
        r102 = I2(r100);
        goto L8
    L7:
        r102 = H2(r100);
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.a
    public final View s(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        IListAdapter.BaseViewHolder r102 = createViewHolder(r100, 1001);
        O2(r102, r101);
        return r102.itemView;
    }

    public static void Q2(BaseRecordViewAdapterPartial r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if (r100.G2() == false) goto L8;
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.b("updateNowOrDelay", "notifyDataSetChanged");
        r100.notifyDataSetChanged();
        return;
    L8:
        r100.f213331f = true;
        if (r101 == false) goto L13;
        j.d(new e(r100), 500);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.a
    public final void O(View r100, boolean r101, int r102) {
        GroupHeaderView r103 = null;
        if (r101 == false) goto L5;
    L22:
        if (r100 == null) goto L24;
        r100.setVisibility(4);
    L24:
        if (r100 == null) goto L28;
        r100.setBackground(null);
        return;
    L28:
        return;
    L5:
        if (M2(r102) == false) goto L22;
        if (r100 == null) goto L8;
        Drawable r104 = r100.getBackground();
    L9:
        if (r104 != null) goto L19;
        if (r100 == null) goto L12;
        r100.setBackgroundColor(ResourcesCompat.getColor(this.f213326a.getResources(), R.color.bg_body, this.f213326a.getTheme()));
    L12:
        GroupHeaderData r105 = this.f213327b.a().k(P2(r102));
        if (r105 == null) goto L19;
        if ((r100 instanceof GroupHeaderView) == false) goto L17;
        r103 = (GroupHeaderView) r100;
    L17:
        if (r103 == null) goto L19;
        r103.a(r105, this.f213327b.e());
    L19:
        if (r100 == null) goto L21;
        r100.setVisibility(0);
    L21:
        com.bytedance.ee.bear.bitable.infoarch.nativeview.b.b("onBindStickyView", "updateReferMapping onBindStickyView.");
        R2(r102);
        return;
    L8:
        r104 = null;
        goto L9
    }
}
