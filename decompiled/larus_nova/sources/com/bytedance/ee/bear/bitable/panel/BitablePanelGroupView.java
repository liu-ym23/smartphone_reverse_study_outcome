package com.bytedance.ee.bear.bitable.panel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView;
import com.bytedance.ee.bear.bitable.common.widgets.item.CommonItemView;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.util.ui.ColorUtils;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0016J&\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u00100\"R\f0#R\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010$\u001a\u00020\u0002H\u0016J\u0016\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitablePanelGroupView;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView;", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "setLifecycle", "(Landroidx/lifecycle/Lifecycle;)V", "itemCallback", "Lcom/bytedance/ee/bear/bitable/panel/PanelItemCallback;", "getItemCallback", "()Lcom/bytedance/ee/bear/bitable/panel/PanelItemCallback;", "setItemCallback", "(Lcom/bytedance/ee/bear/bitable/panel/PanelItemCallback;)V", "getItemViewType", "position", "data", "onCreateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindContentView", "", "itemViewHolder", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter$ItemViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/MultiItemGroupView$ItemAdapter;", MapController.ITEM_LAYER_TAG, "onBindCommonItem", "view", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitablePanelGroupView extends MultiItemGroupView<BitablePanelItem> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lifecycle f214805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f214806d;

    public BitablePanelGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitablePanelGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final m getItemCallback() {
        return this.f214806d;
    }

    public final Lifecycle getLifecycle() {
        return this.f214805c;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView
    public final int r(GroupMultiItemModel r100) {
        BitablePanelItem r101 = (BitablePanelItem) r100;
        if (r101 == null) goto L7;
        ExtendItemEnum r102 = r101.getExtendItem();
        if (r102 == null) goto L7;
    L9:
        return r102.getViewType();
    L7:
        r102 = ExtendItemEnum.ITEM_COMMON_PANEL_ITEM;
        goto L9
    }

    public final void setItemCallback(m r100) {
        this.f214806d = r100;
    }

    public final void setLifecycle(Lifecycle r100) {
        this.f214805c = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView
    public final void t(MultiItemGroupView<BitablePanelItem>.ItemAdapter.ItemViewHolder r100, GroupMultiItemModel r101) {
        BitablePanelItem r102 = (BitablePanelItem) r101;
        Intrinsics.checkNotNullParameter(r100, "itemViewHolder");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        View r103 = r100.f209969a;
        boolean r104 = false;
        if ((!Intrinsics.areEqual(r102.isHidden(), Boolean.TRUE)) == false) goto L5;
        int r105 = 0;
    L6:
        r103.setVisibility(r105);
        Gson r106 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210019a;
        com.bytedance.ee.bear.bitable.common.widgets.item.l r107 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210023e.get(r102.getExtendItem().getKey());
        if (r107 != null) goto L9;
        return;
    L9:
        if (r102.getExtendItem() != ExtendItemEnum.ITEM_COMMON_PANEL_ITEM) goto L58;
        View r108 = r100.f209970b;
        Intrinsics.checkNotNullParameter(r108, "view");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        ColorStateList r109 = null;
        if ((r108 instanceof CommonItemView) == false) goto L13;
        CommonItemView r110 = (CommonItemView) r108;
    L14:
        if (r110 == null) goto L61;
        Boolean r111 = r102.getEditable();
        if (r111 == null) goto L18;
        boolean r112 = r111.booleanValue();
    L19:
        r110.setEditable(r112);
        Boolean r113 = r102.getEnable();
        if (r113 == null) goto L22;
        r104 = r113.booleanValue();
    L22:
        r110.setClickable(r104);
        CheckboxValue r114 = r102.getCheckbox();
        if (r114 == null) goto L25;
        Boolean r115 = Boolean.valueOf(r114.getValue());
    L26:
        r110.setSelect(r115);
        r110.setLeftText(r102.getLeftText());
        Integer r116 = r102.getMaxLines();
        if (r116 != null) goto L29;
        r116 = null;
    L29:
        r110.setMaxLines(r116);
        r110.setLeftTextColor(e.g(Integer.valueOf(r102.getLeftStyle())));
        r110.setPlaceholder(r102.getPlaceholder());
        Icon r117 = r102.getLeftIcon();
        if (r117 == null) goto L32;
        Integer r118 = r117.getGif();
    L34:
        if (e.p(r118) == false) goto L40;
        ImageView r119 = (ImageView) r110.findViewById(R.id.left_icon);
        Icon r120 = r102.getLeftIcon();
        if (r120 == null) goto L38;
        Integer r121 = r120.getGif();
    L39:
        e.h(r119, r121, r110.getContext(), this.f214805c);
    L42:
        if (r102.getLeftIconStyle() == null) goto L44;
        Integer r122 = r102.getLeftIconStyle();
    L45:
        r110.setLeftIconTint(e.f(r122));
        r110.setLeftIconTag(r102.getLeftIconTag());
        if (r102.getLeftIconStyle() == null) goto L48;
        Integer r123 = r102.getLeftIconStyle();
    L49:
        r110.setLeftIconTagTint(e.f(r123));
        r110.setTagText(r102.getTagText());
        r110.setRightText(r102.getRightText());
        r110.setRightTextColor(e.f(r102.getRightStyle()));
        r110.setRightIcon(r102.getRightIcon());
        if (r102.getRightIconStyle() == null) goto L52;
        Integer r124 = r102.getRightIconStyle();
    L53:
        r110.setRightIconTint(e.f(r124));
        r110.setDesc(r102.getDesc());
        boolean r125 = !r102.showPressStatus();
        RoundFrameLayout r126 = r110.getItemContainerFromXml();
        if (r125 == true) goto L57;
        r109 = ColorUtils.d(r110.getContext());
    L57:
        r126.setBackgroundTintList(r109);
        r110.a(r110.isClickable());
        r110.setCallback(new d(this, r102));
        return;
    L52:
        r124 = r102.getRightStyle();
        goto L53
    L48:
        r123 = Integer.valueOf(r102.getLeftStyle());
        goto L49
    L44:
        r122 = Integer.valueOf(r102.getLeftStyle());
        goto L45
    L38:
        r121 = null;
        goto L39
    L40:
        r110.setLeftIcon(r102.getLeftIcon());
        goto L42
    L32:
        r118 = null;
        goto L34
    L25:
        r115 = null;
        goto L26
    L18:
        r112 = false;
        goto L19
    L61:
        return;
    L13:
        r110 = null;
        goto L14
    L58:
        r107.a(r100.f209970b, r102, this.f214806d);
        return;
    L5:
        r105 = 8;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView
    public final View u(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Gson r102 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210019a;
        ExtendItemEnum.Companion.getClass();
        ExtendItemEnum[] r103 = ExtendItemEnum.values();
        int r104 = r103.length;
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L12;
        ExtendItemEnum r106 = r103[r105];
        if (r106.getViewType() != r101) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L13;
        r105 = r105 + 1;
    L13:
        if (r106 == null) goto L15;
        String r108 = r106.getKey();
    L16:
        com.bytedance.ee.bear.bitable.common.widgets.item.l r109 = com.bytedance.ee.bear.bitable.common.widgets.item.e.f210023e.get(r108);
        if (r109 == null) goto L21;
        View r110 = r109.b(r100);
        if (r110 == null) goto L21;
        return r110;
    L21:
        return new CommonItemView(r100.getContext(), null, 6, 0);
    L15:
        r108 = null;
        goto L16
    L8:
        r107 = false;
        goto L9
    L12:
        r106 = null;
        goto L13
    }

    public BitablePanelGroupView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ BitablePanelGroupView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
