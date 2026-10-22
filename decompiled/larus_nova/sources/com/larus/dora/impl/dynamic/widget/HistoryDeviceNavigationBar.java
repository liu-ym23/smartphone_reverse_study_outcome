package com.larus.dora.impl.dynamic.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c59.s;
import c59.u;
import c59.x;
import c59.y;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device_v2.l0;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.util.o;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 G2\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\fJ\u001e\u00101\u001a\u00020\r2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u000102J\u0010\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\u0017J\b\u00106\u001a\u00020\u0007H\u0002J\u0018\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0002J\u001e\u0010:\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\"0<2\b\u0010=\u001a\u0004\u0018\u00010\fJ\u0010\u0010>\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\fJ\u001a\u0010?\u001a\u00020\r2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u001a\u0010A\u001a\u00020\r2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u001a\u0010B\u001a\u00020\r2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ(\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u00072\b\b\u0002\u0010E\u001a\u00020\u00172\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010FR\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00060.R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rightSelectDevice", "Lkotlin/Function1;", "", "", "leftSelectDevice", "didSelectDevice", "recyclerViewWidthCalculator", "Lcom/larus/dora/impl/device_v2/RecyclerViewWidthCalculator;", "getRecyclerViewWidthCalculator", "()Lcom/larus/dora/impl/device_v2/RecyclerViewWidthCalculator;", "setRecyclerViewWidthCalculator", "(Lcom/larus/dora/impl/device_v2/RecyclerViewWidthCalculator;)V", "value", "", "isShowListBar", "()Z", "setShowListBar", "(Z)V", "selectedIndex", "getSelectedIndex", "()I", "actionUrl", "historyDevices", "", "Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "icBack", "Landroid/widget/ImageView;", "titleLabel", "Landroid/widget/TextView;", "centerView", "Landroid/view/View;", "recyclerView", "Lcom/larus/dora/impl/dynamic/widget/CenterSelectedRecyclerView;", "rightButton", "Lcom/facebook/drawee/view/SimpleDraweeView;", "deviceAdapter", "Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter;", com.alipay.sdk.m.x.d.f25925o, "title", "config", "", "", "reloadData", GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, "getItemMaxSize", "updateContentInsetIfNeeded", "selectedCellWidth", "notSelectedCellWidth", "loadStoredHistoryDevices", "historyDevice", "", "mac", "notifyTitleUpdate", "setRightClickListener", "listener", "setLeftClickListener", "setDidSelectDevice", "setRightButtonIcon", "iconResId", "removePadding", "Lkotlin/Function0;", "Companion", "HistoryDeviceAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryDeviceNavigationBar extends ConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f335460n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super String, Unit> f335461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f335462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f335463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0 f335464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f335465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f335466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f335467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<z49.c> f335468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f335469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f335470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CenterSelectedRecyclerView f335471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SimpleDraweeView f335472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HistoryDeviceAdapter f335473m;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\n¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter$ViewHolder;", "Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar;", "<init>", "(Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "getItem", "Lcom/larus/dora/impl/device_v2/entity/HistoryDeviceListInfo;", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class HistoryDeviceAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HistoryDeviceNavigationBar f335474a;

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/larus/dora/impl/dynamic/widget/HistoryDeviceNavigationBar$HistoryDeviceAdapter;Landroid/view/View;)V", "titleText", "Landroid/widget/TextView;", "deviceIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", KtvSubElement.CONTAINER, "bind", "", "title", "", "productId", "", ECPromotion.SKU, "isSelected", "", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final TextView f335475a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final SimpleDraweeView f335476b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final View f335477c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ HistoryDeviceAdapter f335478d;

            public ViewHolder(HistoryDeviceAdapter r100, View r101) {
                Intrinsics.checkNotNullParameter(r101, "view");
                this.f335478d = r100;
                super(r101);
                this.f335475a = (TextView) r101.findViewById(R.id.device_title);
                this.f335476b = (SimpleDraweeView) r101.findViewById(R.id.device_icon);
                this.f335477c = r101.findViewById(R.id.container);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f335474a.f335468h).size();
        }

        public HistoryDeviceAdapter(HistoryDeviceNavigationBar r100) {
            this.f335474a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            if (this.f335474a.getSelectedIndex() != r100) goto L5;
            return 1;
        L5:
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r210) {
            ViewHolder r100 = (ViewHolder) r110;
            Intrinsics.checkNotNullParameter(r100, "holder");
            final z49.c r101 = (z49.c) ListProtector.get(this.f335474a.f335468h, r210);
            int r102 = o.f338149a;
            String r103 = o.b(r101.b(), r101.c());
            Integer r104 = r101.d();
            if (r104 == null) goto L5;
            int r105 = r104.intValue();
        L6:
            Integer r106 = r101.f();
            if (r106 == null) goto L9;
            int r107 = r106.intValue();
        L11:
            if (this.f335474a.getSelectedIndex() != r210) goto L13;
            boolean r108 = true;
        L14:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r103, "title");
            r100.f335475a.setText(r103);
            if (r100.f335478d.getItemCount() >= 2) goto L17;
            e1.o(r100.f335476b);
            r100.f335477c.setBackgroundColor(0);
        L39:
            r100.f335477c.setSelected(r108);
            l0 r109 = r100.f335478d.f335474a.getRecyclerViewWidthCalculator();
            HistoryDeviceNavigationBar r111 = r100.f335478d.f335474a;
            CenterSelectedRecyclerView r112 = r111.f335471k;
            int r113 = r111.getSelectedIndex();
            int r114 = r100.f335478d.getItemCount();
            r109.getClass();
            Intrinsics.checkNotNullParameter(r112, "recyclerView");
            RecyclerView.Adapter r115 = r112.getAdapter();
            if (r115 == null) goto L65;
            View r116 = LayoutInflater.from(r112.getContext()).inflate(R.layout.larus_item_history_device, r112, false);
            if ((r115 instanceof HistoryDeviceAdapter) == false) goto L54;
            z49.c r117 = (z49.c) ListProtector.get(((HistoryDeviceAdapter) r115).f335474a.f335468h, r210);
            TextView r118 = (TextView) r116.findViewById(R.id.device_title);
            SimpleDraweeView r119 = (SimpleDraweeView) r116.findViewById(R.id.device_icon);
            View r120 = r116.findViewById(R.id.container);
            String r121 = o.b(r117.b(), r117.c());
            Integer r122 = r117.f();
            if (r122 == null) goto L46;
            int r123 = r122.intValue();
        L47:
            Integer r124 = r117.d();
            if (r124 == null) goto L50;
            r124.intValue();
        L50:
            if (r113 != r210) goto L52;
            boolean r125 = true;
        L53:
            Intrinsics.checkNotNull(r118);
            Intrinsics.checkNotNull(r119);
            Intrinsics.checkNotNull(r120);
            l0.a(r121, r123, r125, r118, r119, r120, r114);
            goto L54
        L52:
            r125 = false;
            goto L53
        L46:
            r123 = 0;
        L54:
            Intrinsics.checkNotNull(r116);
            r116.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            r100.itemView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (r108 == false) goto L57;
            e1.x(r100.f335475a);
        L58:
            ViewGroup.LayoutParams r126 = r100.itemView.getLayoutParams();
            if (r116.getMeasuredWidth() <= a.C4263a.f335480b) goto L61;
            int r127 = HistoryDeviceNavigationBar.R5(r100.f335478d.f335474a);
        L62:
            r126.width = r127;
            r126.height = a.C4263a.f335479a;
            r100.itemView.setLayoutParams(r126);
            View r128 = r100.itemView;
            final HistoryDeviceNavigationBar r129 = this.f335474a;
            r128.setOnClickListener(new f(r129, r210, r101));
            return;
        L61:
            r127 = r116.getMeasuredWidth();
            goto L62
        L57:
            e1.o(r100.f335475a);
            goto L58
        L65:
            throw new IllegalStateException("Adapter not set");
        L17:
            e1.x(r100.f335476b);
            r100.f335477c.setBackgroundResource(R.drawable.selector_device_item_background);
            r100.f335476b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            if (r105 != ProductNameType.H_FREE_BUDS_PRO_5.f204375id) goto L21;
            r100.f335476b.setImageResource(R.drawable.larus_icon_dora_h_buds_pro);
            goto L39
        L21:
            if (r105 != ProductNameType.H_DOLPHIN.f204375id) goto L24;
            r100.f335476b.setImageResource(R.drawable.larus_icon_dora_h_dolphin);
            goto L39
        L24:
            if (r105 != ProductNameType.H_GUITAR.f204375id) goto L27;
            r100.f335476b.setImageResource(R.drawable.larus_icon_dora_h_guitar);
            goto L39
        L27:
            if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(ProductNameType.H_FREE_CLIP_2.f204375id), Integer.valueOf(ProductNameType.H_FREE_CLIP_2_HE.f204375id)}).contains(Integer.valueOf(r105)) == false) goto L30;
            r100.f335476b.setImageResource(R.drawable.larus_icon_dora_h_buds);
            goto L39
        L30:
            if (o59.a.o(Integer.valueOf(r105)) == false) goto L35;
            StringBuilder r130 = new StringBuilder("larus_");
            DoraImageType r131 = DoraImageType.ICON_DORA_G_DM_BAR;
            int r132 = n1.f335221a;
            DoraSKU r133 = n1.e(DoraSKU.a.b(DoraSKU.Companion, Integer.valueOf(r107)));
            boolean r134 = v19.h.f552477a;
            Context r135 = r100.f335478d.f335474a.getContext();
            if (r135 != null) goto L34;
            r135 = AppHost.f326268a.getApplication();
        L34:
            r130.append(r131.fileNameNoFilExtension(r133, v19.h.b(r135)));
            String r136 = r130.toString();
            SimpleDraweeView r137 = r100.f335476b;
            DoraResourceUtil r138 = DoraResourceUtil.f338111a;
            r137.setImageBitmap(DoraResourceUtil.e(r136));
            goto L39
        L35:
            SimpleDraweeView r139 = r100.f335476b;
            DoraResourceUtil r140 = DoraResourceUtil.f338111a;
            StringBuilder r141 = new StringBuilder("larus_");
            DoraImageType r142 = DoraImageType.ICON_DORA_MANAGE_NAV_BAR;
            int r143 = n1.f335221a;
            DoraSKU r144 = n1.e(DoraSKU.a.b(DoraSKU.Companion, Integer.valueOf(r107)));
            boolean r145 = v19.h.f552477a;
            Context r146 = r100.f335478d.f335474a.getContext();
            if (r146 != null) goto L38;
            r146 = AppHost.f326268a.getApplication();
        L38:
            r141.append(r142.fileName(r144, v19.h.b(r146), Integer.valueOf(r105)));
            r139.setImageBitmap(DoraResourceUtil.e(r141.toString()));
            goto L39
        L13:
            r108 = false;
            goto L14
        L9:
            r107 = 0;
            goto L11
        L5:
            r105 = 1;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_history_device, r100, false);
            Intrinsics.checkNotNull(r102);
            return new ViewHolder(this, r102);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar$a$a, reason: collision with other inner class name */
        public static final class C4263a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f335479a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f335480b = 0;

            static {
                f335479a = c7.b(44);
                c7.b(0);
                f335480b = c7.b(160);
            }
        }
    }

    static {
    }

    public HistoryDeviceNavigationBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HistoryDeviceNavigationBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getItemMaxSize() {
        if (((ArrayList) this.f335468h).isEmpty() == false) goto L7;
        int r100 = a.C4263a.f335479a;
        return a.C4263a.f335480b;
    L7:
        if (((ArrayList) this.f335468h).size() != 1) goto L10;
        int r101 = a.C4263a.f335479a;
        return (a.C4263a.f335480b * 3) / 2;
    L10:
        int r102 = a.C4263a.f335479a;
        return a.C4263a.f335480b;
    }

    public final l0 getRecyclerViewWidthCalculator() {
        return this.f335464d;
    }

    public final int getSelectedIndex() {
        return this.f335466f;
    }

    public static final /* synthetic */ int R5(HistoryDeviceNavigationBar r100) {
        return r100.getItemMaxSize();
    }

    public static void V5(HistoryDeviceNavigationBar r100) {
        List<z49.c> r101 = r100.f335468h;
        if (r101 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L13;
        l0 r102 = r100.f335464d;
        Context r103 = r100.f335471k.getContext();
        CenterSelectedRecyclerView r104 = r100.f335471k;
        HistoryDeviceAdapter r105 = r100.f335473m;
        z49.c r106 = (z49.c) ListProtector.get(r100.f335468h, r100.f335466f);
        int r107 = ((ArrayList) r100.f335468h).size();
        r102.getClass();
        int r108 = l0.b(r103, r104, r105, true, r106, r107).getMeasuredWidth();
        l0 r109 = r100.f335464d;
        Context r110 = r100.f335471k.getContext();
        CenterSelectedRecyclerView r111 = r100.f335471k;
        HistoryDeviceAdapter r112 = r100.f335473m;
        z49.c r113 = (z49.c) ListProtector.get(r100.f335468h, r100.f335466f);
        int r114 = ((ArrayList) r100.f335468h).size();
        r109.getClass();
        l0.b(r110, r111, r112, false, r113, r114).getMeasuredWidth();
        if (r108 <= a.C4263a.f335480b) goto L10;
        r108 = r100.getItemMaxSize();
    L10:
        ((ArrayList) r100.f335468h).size();
        int r115 = (r100.f335471k.getWidth() / 2) - (r108 / 2);
        r100.f335471k.setPadding(r115, 0, r115, 0);
        r100.f335471k.setSelectedIndex(r100.f335466f);
        return;
    }

    public final void S5(Map<String, ? extends Object> r100) {
        System.out.println("HistoryDeviceNavigationBar config model: " + r100);
        Lazy r101 = s.f22521a;
        x r102 = (x) s.c(r100, x.class);
        if (r102 == null) goto L30;
        y r103 = r102.b();
        if (r103 == null) goto L31;
        boolean r104 = v19.h.f552477a;
        boolean r105 = v19.h.b(getContext());
        StringBuilder r106 = new StringBuilder("larus_");
        u r107 = r103.b();
        String r108 = null;
        if (r107 == null) goto L10;
        String r109 = r107.a();
    L11:
        r106.append(r109);
        r106.append('_');
        if (r105 == false) goto L14;
        String r110 = "dark";
    L15:
        r106.append(r110);
        String r111 = r106.toString();
        SimpleDraweeView r112 = this.f335472l;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        if (r111 == null) goto L25;
        Context r113 = r112.getContext();
        if (r113 != null) goto L20;
        r113 = AppHost.f326268a.getApplication();
    L20:
        Resources r114 = r113.getResources();
        if (r114 == null) goto L25;
        int r115 = r114.getIdentifier(r111, "drawable", r113.getPackageName());
        if (r115 == 0) goto L25;
        r112.setImageResource(r115);
    L25:
        c59.b r116 = r103.a();
        if (r116 == null) goto L28;
        r108 = r116.e();
    L28:
        this.f335467g = r108;
        return;
    L14:
        r110 = "light";
        goto L15
    L10:
        r109 = null;
        goto L11
    L31:
        return;
    }

    public final void U5(String r100) {
        Iterator r101 = ((ArrayList) this.f335468h).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((z49.c) r101.next()).b(), r100) == true) goto L10;
        r102 = r102 + 1;
    L10:
        this.f335473m.notifyItemChanged(r102);
        this.f335471k.post(new c(this));
        return;
    L9:
        r102 = -1;
        goto L10
    }

    public final void setDidSelectDevice(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f335463c = r100;
    }

    public final void setLeftClickListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f335462b = r100;
    }

    public final void setRecyclerViewWidthCalculator(l0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f335464d = r100;
    }

    public final void setRightClickListener(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f335461a = r100;
    }

    public final void setShowListBar(boolean r100) {
        this.f335465e = r100;
        if (r100 == false) goto L5;
        this.f335469i.setVisibility(8);
        this.f335470j.setVisibility(0);
        this.f335473m.notifyDataSetChanged();
        return;
    L5:
        this.f335469i.setVisibility(0);
        this.f335470j.setVisibility(8);
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f335469i.setText(r100);
    }

    public final void T5(List<z49.c> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "historyDevice");
        ((ArrayList) this.f335468h).clear();
        ((ArrayList) this.f335468h).addAll(r100);
        this.f335473m.notifyDataSetChanged();
        Iterator<z49.c> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r102.next().b(), r101) == true) goto L10;
        r103 = r103 + 1;
    L10:
        if (r103 == (-1)) goto L17;
        this.f335466f = r103;
        if ((!this.f335468h.isEmpty()) == false) goto L18;
        this.f335471k.post(new e(this));
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r103 = -1;
        goto L10
    }

    public HistoryDeviceNavigationBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f335464d = new l0(r100);
        this.f335468h = new ArrayList();
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_view_history_device_navigation_bar, this, true);
        ImageView r104 = (ImageView) r103.findViewById(R.id.ic_back);
        TextView r105 = (TextView) r103.findViewById(R.id.title_label);
        this.f335469i = r105;
        View r106 = r103.findViewById(R.id.center_view);
        this.f335470j = r106;
        CenterSelectedRecyclerView r107 = (CenterSelectedRecyclerView) r103.findViewById(R.id.recycler_view);
        this.f335471k = r107;
        SimpleDraweeView r108 = (SimpleDraweeView) r103.findViewById(R.id.right_button);
        this.f335472l = r108;
        r105.setTextColor(ContextCompat.getColor(r100, R.color.neutral_100));
        r105.setTextSize(17.0f);
        r105.setTextAlignment(4);
        int r109 = 0;
        r107.setLayoutManager(new LinearLayoutManager(r100, 0, false));
        HistoryDeviceAdapter r110 = new HistoryDeviceAdapter(this);
        this.f335473m = r110;
        r107.setAdapter(r110);
        r104.setOnClickListener(new com.larus.dora.impl.dynamic.widget.a(this));
        r108.setOnClickListener(new b(this));
        if (this.f335465e == false) goto L5;
        int r111 = 8;
    L6:
        r105.setVisibility(r111);
        if (this.f335465e == true) goto L10;
        r109 = 8;
    L10:
        r106.setVisibility(r109);
        return;
    L5:
        r111 = 0;
        goto L6
    }

    public /* synthetic */ HistoryDeviceNavigationBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
