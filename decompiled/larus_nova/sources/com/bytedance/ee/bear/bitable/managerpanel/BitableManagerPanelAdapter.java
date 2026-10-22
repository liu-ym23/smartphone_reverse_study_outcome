package com.bytedance.ee.bear.bitable.managerpanel;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.panel.EPanelItemIcon;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.bytedance.ee.bear.widgets.collapse.CollapsibleAdapter;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000223B3\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u001a\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0014J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0007J\u0014\u0010)\u001a\u00020\u00162\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u0010\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\fJ \u0010,\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J \u00100\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u00020.H\u0016R\"\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelAdapter;", "Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "data", "", "mExpandedTableList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/List;Ljava/util/ArrayList;)V", "mOperationCallBack", "Lcom/bytedance/ee/bear/bitable/managerpanel/OperationCallBack;", "lastItemBottomMargin", "", "bottomSafety", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelAdapter$IBottomSafety;", "getBottomSafety", "()Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelAdapter$IBottomSafety;", "setBottomSafety", "(Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelAdapter$IBottomSafety;)V", "onBindViewHolder", "", "holder", "Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter$CollapsibleViewHolder;", "position", "convert", "helper", MapController.ITEM_LAYER_TAG, "updateLastItemMargin", "Lcom/chad/library/adapter/base/BaseViewHolder;", "updateBlockItemHolder", "blockBean", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BlockBean;", "onTableItemWithSubClick", "onTableItemWithoutSubClick", "updateViewItemHolder", "viewBean", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$ViewBean;", "indexOfTable", "tableId", "updateData", "setOperationCallBack", "operationCallBack", BitableAnalytic.LinkSceneClickType.EXPAND, "animate", "", "shouldNotify", "collapse", "notify", "Companion", "IBottomSafety", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableManagerPanelAdapter extends CollapsibleAdapter<MultiItemEntity> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f214648d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f214649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f214650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f214651c;

    public static final class a {
    }

    public interface b {
        boolean a();

        int b();
    }

    static {
    }

    public final void A2(List<? extends MultiItemEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List<T> r101 = this.mData;
        if (r101 != 0) goto L5;
    L22:
        setNewData(r100);
        return;
    L5:
        if (r101.isEmpty() == true) goto L22;
        final List<T> r102 = this.mData;
        final ArrayList r103 = new ArrayList();
        Iterator<? extends MultiItemEntity> r104 = r100.iterator();
    L9:
        if (r104.hasNext() == false) goto L20;
        MultiItemEntity r105 = r104.next();
        r103.add(r105);
        if ((r105 instanceof BitableManagerPanelData.BlockBean) == false) goto L9;
        BitableManagerPanelData.BlockBean r106 = (BitableManagerPanelData.BlockBean) r105;
        if (this.f214649a.contains(r106.getId()) == false) goto L9;
        r106.setExpanded(true);
        List<BitableManagerPanelData.ViewBean> r107 = r106.getSubItems();
        if (r107 == null) goto L9;
        List<BitableManagerPanelData.ViewBean> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L18:
        if (r110.hasNext() == false) goto L9;
        r109.add(Boolean.valueOf(r103.add((BitableManagerPanelData.ViewBean) r110.next())));
        goto L18
    L20:
        DiffUtil.calculateDiff(new BitableManagerPanelAdapter$updateData$diffResult$1(r102, r103)).dispatchUpdatesTo(this);
        this.mData = r103;
    }

    public final int z2(String r100) {
        Iterable r101 = this.mData;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L14;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MultiItemEntity r107 = (MultiItemEntity) r105;
        if ((r107 instanceof BitableManagerPanelData.BlockBean) == false) goto L13;
        if (TextUtils.equals(((BitableManagerPanelData.BlockBean) r107).getId(), r100) == false) goto L13;
        return r104;
    L13:
        r102.add(Unit.INSTANCE);
        r104 = r106;
        goto L4
    L14:
        return -1;
    }

    public BitableManagerPanelAdapter(List<? extends MultiItemEntity> r100, ArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "mExpandedTableList");
        super(r100);
        this.f214649a = r101;
        addItemType(1, R.layout.bitable_manager_panel_block_title_item);
        addItemType(2, R.layout.bitable_manager_panel_view_item);
        registerAdapterDataObserver(new AnonymousClass1(this));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, Object r111) {
        CollapsibleAdapter.CollapsibleViewHolder r100 = (CollapsibleAdapter.CollapsibleViewHolder) r110;
        MultiItemEntity r101 = (MultiItemEntity) r111;
        Intrinsics.checkNotNullParameter(r100, "helper");
        int r102 = r100.getItemViewType();
        ViewGroup.MarginLayoutParams r112 = null;
        boolean r103 = true;
        int r104 = 0;
        if (r102 == 1) goto L82;
        if (r102 != 2) goto L181;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.managerpanel.BitableManagerPanelData.ViewBean");
        BitableManagerPanelData.ViewBean r105 = (BitableManagerPanelData.ViewBean) r101;
        r100.itemView.setSelected(r105.getActive());
        r100.setText(R.id.text_tv, r105.getText());
        Resources r106 = r100.itemView.getResources();
        if (r105.getActive() == false) goto L9;
        int r113 = R.color.primary_fill_default;
    L10:
        r100.setTextColor(R.id.text_tv, r106.getColor(r113));
        TextView r107 = (TextView) r100.getView(R.id.text_tv);
        TextPaint r108 = r107.getPaint();
        if (r105.getActive() == false) goto L13;
        float r114 = 1.0f;
    L14:
        r108.setStrokeWidth(r114);
        TextPaint r109 = r107.getPaint();
        if (r105.getActive() == false) goto L17;
        Paint.Style r115 = Paint.Style.FILL_AND_STROKE;
    L18:
        r109.setStyle(r115);
        View r116 = r100.getView(R.id.tag);
        if (r105.getActive() == false) goto L21;
        int r117 = 0;
    L22:
        r116.setVisibility(r117);
        ImageView r118 = (ImageView) r100.getView(R.id.icon);
        r118.setColorFilter(null);
        if (TextUtils.isEmpty(r105.getIconUrl()) == true) goto L28;
        RequestBuilder<Drawable> r119 = Glide.with(r118.getContext()).load(r105.getIconUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(n.d(2))));
        EPanelItemIcon r120 = EPanelItemIcon.UNKNOWN;
        r119.placeholder(r120.inactiveImageRes).error(r120.inactiveImageRes).into(r118);
        if (r105.getActive() == true) goto L27;
        ColorMatrix r121 = new ColorMatrix();
        r121.setSaturation(0.0f);
        r118.setColorFilter(new ColorMatrixColorFilter(r121));
    L27:
        int r122 = n.d(1);
        r118.setPadding(r122, r122, r122, r122);
    L33:
        RoundFrameLayout r123 = (RoundFrameLayout) r100.getView(R.id.container);
        int r124 = (int) this.mContext.getResources().getDimension(R.dimen.space_kit_len_12);
        ViewGroup.LayoutParams r125 = r100.itemView.getLayoutParams();
        if ((r125 instanceof ViewGroup.MarginLayoutParams) == false) goto L36;
        r112 = (ViewGroup.MarginLayoutParams) r125;
    L36:
        int r126 = r100.getAdapterPosition() + 1;
        if (r126 < getItemCount()) goto L39;
    L45:
        int r127 = (int) this.mContext.getResources().getDimension(R.dimen.space_kit_len_10);
        r123.a(0, 0, r127, r127);
        if (r112 == null) goto L48;
        r112.bottomMargin = r124;
    L48:
        r100.setVisible(R.id.divider, false);
    L49:
        r100.itemView.setLayoutParams(r112);
        if (ku5.c.k(this.mContext) == false) goto L52;
    L54:
        boolean r128 = false;
    L55:
        View r129 = r100.getView(R.id.menu_more);
        if (r128 == true) goto L76;
        String[] r130 = r105.getActions();
        if (r130 != null) goto L60;
    L66:
        boolean r131 = false;
    L67:
        if (r131 == false) goto L76;
        String[] r132 = r105.getActions();
        if (r132 != null) goto L71;
    L73:
        r103 = false;
    L74:
        if (r103 == false) goto L76;
    L77:
        r129.setVisibility(r104);
        r129.setOnClickListener(new d(this, r105));
        ViewGroup.LayoutParams r133 = r100.getView(R.id.right_margin).getLayoutParams();
        if (r100.getView(R.id.menu_more).getVisibility() != 8) goto L80;
        int r134 = n.d(16);
    L81:
        r133.width = r134;
        View r135 = r100.getView(R.id.container);
        r135.setBackgroundTintList(ColorUtils.d(r135.getContext()));
        r100.getView(R.id.container).setOnClickListener(new e(this, r105));
        return;
    L80:
        r134 = n.d(4);
        goto L81
    L71:
        if (ArraysKt.contains(r132, "more") != true) goto L73;
    L60:
        if (r130.length != 0) goto L62;
        boolean r136 = true;
    L64:
        if ((!r136) != true) goto L66;
        r131 = true;
        goto L67
    L62:
        r136 = false;
    L76:
        r104 = 8;
        goto L77
    L52:
        if (this.mContext.getResources().getConfiguration().orientation != 2) goto L54;
        r128 = true;
        goto L55
    L39:
        if ((getItem(r126) instanceof BitableManagerPanelData.BlockBean) == true) goto L45;
        r123.a(0, 0, 0, 0);
        if (r112 == null) goto L44;
        r112.bottomMargin = 0;
    L44:
        r100.setVisible(R.id.divider, true);
        goto L49
    L28:
        r118.setImageResource(EPanelItemIcon.getEPanelItemIconById(r118.getContext(), r105.getType(), r105.getIcon()));
        Resources r137 = r118.getResources();
        if (r105.getActive() == false) goto L31;
        int r138 = R.color.primary_fill_default;
    L32:
        r118.setImageTintList(ColorStateList.valueOf(r137.getColor(r138)));
        r118.setPadding(0, 0, 0, 0);
        goto L33
    L31:
        r138 = R.color.icon_n2;
        goto L32
    L21:
        r117 = 4;
        goto L22
    L17:
        r115 = Paint.Style.FILL;
        goto L18
    L13:
        r114 = 0.0f;
        goto L14
    L9:
        r113 = R.color.text_title;
        goto L10
    L181:
        return;
    L82:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.managerpanel.BitableManagerPanelData.BlockBean");
        BitableManagerPanelData.BlockBean r139 = (BitableManagerPanelData.BlockBean) r101;
        boolean r140 = hasSubItems(r139);
        boolean r141 = r139.isActiveWithoutSubItem();
        if (r140 == false) goto L85;
        boolean r142 = this.f214649a.contains(r139.getId());
    L86:
        r100.itemView.setSelected(r141);
        View r143 = r100.getView(R.id.tag);
        if (r141 == false) goto L89;
        int r144 = 0;
    L90:
        r143.setVisibility(r144);
        SyncIconImageView r145 = (SyncIconImageView) r100.getView(R.id.icon);
        r145.setImageResource(EPanelItemIcon.getEPanelItemIconById(r145.getContext(), r139.getType(), r139.getIcon()));
        Resources r146 = r145.getResources();
        if (r141 == false) goto L93;
        int r147 = R.color.primary_fill_default;
    L94:
        r145.setImageTintList(ColorStateList.valueOf(r146.getColor(r147)));
        r145.setSyncIconVisible(r139.isSync());
        r100.setText(R.id.text_tv, r139.getText());
        Resources r148 = r100.itemView.getResources();
        if (r141 == false) goto L97;
        int r149 = R.color.primary_fill_default;
    L98:
        r100.setTextColor(R.id.text_tv, r148.getColor(r149));
        ((TextView) r100.getView(R.id.text_tv)).getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        ((TextView) r100.getView(R.id.text_tv)).getPaint().setStrokeWidth(1.0f);
        r100.setVisible(R.id.arrow, r140);
        ImageView r150 = (ImageView) r100.getView(R.id.arrow);
        if (r142 == false) goto L101;
        float r151 = 90.0f;
    L102:
        r150.setRotation(r151);
        r100.setVisible(R.id.divider, r142);
        int r152 = (int) this.mContext.getResources().getDimension(R.dimen.space_kit_len_12);
        ViewGroup.LayoutParams r153 = r100.itemView.getLayoutParams();
        if ((r153 instanceof ViewGroup.MarginLayoutParams) == false) goto L105;
        ViewGroup.MarginLayoutParams r154 = (ViewGroup.MarginLayoutParams) r153;
    L106:
        if (r154 != null) goto L108;
    L112:
        if (r154 == null) goto L116;
        if (r142 == false) goto L115;
        r152 = 0;
    L115:
        r154.bottomMargin = r152;
    L116:
        r100.itemView.setLayoutParams(r154);
        RoundFrameLayout r155 = (RoundFrameLayout) r100.getView(R.id.container);
        int r156 = (int) this.mContext.getResources().getDimension(R.dimen.space_kit_len_10);
        if (r142 == false) goto L119;
        int r157 = 0;
    L120:
        r155.a(r156, r156, r157, r157);
        if (ku5.c.k(this.mContext) == false) goto L123;
    L125:
        boolean r158 = false;
    L126:
        View r159 = r100.getView(R.id.menu_add);
        if (r158 == true) goto L136;
        String[] r160 = r139.getActions();
        if (r160 != null) goto L131;
    L133:
        boolean r161 = false;
    L134:
        if (r161 == false) goto L136;
        boolean r162 = true;
    L137:
        if (r162 == false) goto L139;
        int r163 = 0;
    L140:
        r159.setVisibility(r163);
        r159.setOnClickListener(new com.bytedance.ee.bear.bitable.managerpanel.a(this, r139));
        View r164 = r100.getView(R.id.menu_more);
        if (r158 == true) goto L161;
        String[] r165 = r139.getActions();
        if (r165 != null) goto L145;
    L151:
        boolean r166 = false;
    L152:
        if (r166 == false) goto L161;
        String[] r167 = r139.getActions();
        if (r167 != null) goto L156;
    L158:
        r103 = false;
    L159:
        if (r103 == false) goto L161;
        int r168 = 0;
    L162:
        r164.setVisibility(r168);
        r164.setOnClickListener(new com.bytedance.ee.bear.bitable.managerpanel.b(this, r139));
        TextView r169 = (TextView) r100.getView(R.id.text_tv);
        if (r139.getShouldShowWarningIcon() == false) goto L168;
        Drawable r170 = AppCompatResources.getDrawable(r169.getContext(), R.drawable.ud_icon_warning_colorful);
        if (r170 == null) goto L167;
        r170.setBounds(0, 0, n.d(16), n.d(16));
    L167:
        r169.setCompoundDrawablePadding(n.d(6));
        r169.setCompoundDrawables(null, null, r170, null);
    L170:
        if ((r139.getActive() & r139.hasSubItem()) == false) goto L172;
        ImageView r171 = (ImageView) r100.getView(R.id.icon);
        r171.setImageTintList(ColorStateList.valueOf(r171.getResources().getColor(R.color.primary_fill_default)));
        r100.setTextColor(R.id.text_tv, r100.itemView.getResources().getColor(R.color.primary_fill_default));
    L172:
        ViewGroup.LayoutParams r172 = r100.getView(R.id.right_margin).getLayoutParams();
        if (r100.getView(R.id.menu_add).getVisibility() == 8) goto L175;
    L177:
        int r173 = n.d(4);
    L178:
        r172.width = r173;
        View r174 = r100.getView(R.id.container);
        r174.setBackgroundTintList(ColorUtils.d(r174.getContext()));
        r100.getView(R.id.container).setOnClickListener(new c(r140, this, r139));
        return;
    L175:
        if (r100.getView(R.id.menu_more).getVisibility() != 8) goto L177;
        r173 = n.d(16);
        goto L178
    L168:
        r169.setCompoundDrawablePadding(0);
        r169.setCompoundDrawables(null, null, null, null);
        goto L170
    L156:
        if (ArraysKt.contains(r167, "more") != true) goto L158;
    L145:
        if (r165.length != 0) goto L147;
        boolean r175 = true;
    L149:
        if ((!r175) != true) goto L151;
        r166 = true;
        goto L152
    L147:
        r175 = false;
    L161:
        r168 = 8;
        goto L162
    L139:
        r163 = 8;
        goto L140
    L131:
        if (ArraysKt.contains(r160, BitableManagerPanelData.MenuAction.ADD_VIEW) != true) goto L133;
        r161 = true;
    L136:
        r162 = false;
        goto L137
    L123:
        if (this.mContext.getResources().getConfiguration().orientation != 2) goto L125;
        r158 = true;
        goto L126
    L119:
        r157 = r156;
        goto L120
    L108:
        if (this.mData.indexOf(r139) != 0) goto L110;
        int r176 = r152;
    L111:
        r154.topMargin = r176;
        goto L112
    L110:
        r176 = 0;
        goto L111
    L105:
        r154 = null;
        goto L106
    L101:
        r151 = 0.0f;
        goto L102
    L97:
        r149 = R.color.text_title;
        goto L98
    L93:
        r147 = R.color.icon_n2;
        goto L94
    L89:
        r144 = 4;
        goto L90
    L85:
        r142 = false;
        goto L86
    }

    @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleAdapter, com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((CollapsibleAdapter.CollapsibleViewHolder) r100, r101);
    }

    @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleAdapter
    public final void y2(CollapsibleAdapter.CollapsibleViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.y2(r100, r101);
        MultiItemEntity r102 = (MultiItemEntity) getItem(r101);
        boolean r103 = true;
        if ((r102 instanceof BitableManagerPanelData.ViewBean) == false) goto L7;
        if (((BitableManagerPanelData.ViewBean) r102).getActive() == false) goto L7;
    L10:
        int r104 = (getItemCount() - r101) - 1;
        b r105 = this.f214651c;
        if (r105 == null) goto L13;
        int r106 = r105.b() - (r104 * this.mContext.getResources().getDimensionPixelOffset(R.dimen.bitable_manager_panel_item_height));
    L14:
        this.f214650b = r106;
        this.f214650b = RangesKt.coerceAtLeast(r106, this.mContext.getResources().getDimensionPixelOffset(R.dimen.bitable_manager_panel_item_bottom_margin));
    L16:
        if (r101 != (getItemCount() - 1)) goto L27;
        ViewGroup.LayoutParams r107 = r100.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        b r109 = this.f214651c;
        if (r109 != null) goto L20;
    L22:
        r103 = false;
    L23:
        if (r103 == false) goto L25;
        r108.bottomMargin = this.f214650b;
        return;
    L25:
        r108.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.bitable_manager_panel_item_bottom_margin);
        return;
    L20:
        if (r109.a() != true) goto L22;
    L27:
        return;
    L13:
        r106 = 0;
    L7:
        if ((r102 instanceof BitableManagerPanelData.BlockBean) == false) goto L16;
        if (((BitableManagerPanelData.BlockBean) r102).isActiveWithoutSubItem() == false) goto L16;
        goto L10
    }

    @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(BaseViewHolder r100, int r101) {
        y2((CollapsibleAdapter.CollapsibleViewHolder) r100, r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int collapse(int r100, boolean r101, boolean r102) {
        MultiItemEntity r103 = (MultiItemEntity) getItem(r100);
        if ((r103 instanceof BitableManagerPanelData.BlockBean) == false) goto L8;
        BitableManagerPanelData.BlockBean r104 = (BitableManagerPanelData.BlockBean) r103;
        if (this.f214649a.contains(r104.getId()) == false) goto L8;
        this.f214649a.remove(r104.getId());
    L8:
        return super.collapse(r100, r101, r102);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int expand(int r100, boolean r101, boolean r102) {
        MultiItemEntity r103 = (MultiItemEntity) getItem(r100);
        if ((r103 instanceof BitableManagerPanelData.BlockBean) == false) goto L8;
        BitableManagerPanelData.BlockBean r104 = (BitableManagerPanelData.BlockBean) r103;
        if (this.f214649a.contains(r104.getId()) == true) goto L8;
        this.f214649a.add(r104.getId());
    L8:
        return super.expand(r100, r101, r102);
    }
}
