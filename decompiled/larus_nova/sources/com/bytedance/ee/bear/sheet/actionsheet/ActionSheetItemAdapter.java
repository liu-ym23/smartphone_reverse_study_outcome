package com.bytedance.ee.bear.sheet.actionsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\n2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0014\u0010\u001f\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter$ViewsVH;", "<init>", "()V", "mItemList", "", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onRightIconClickListener", "Lkotlin/Function2;", "Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;", "getOnRightIconClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnRightIconClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateItemList", "list", "", "ViewsVH", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetItemAdapter extends RecyclerView.Adapter<ViewsVH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f237289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super c, Unit> f237290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super c, ? super f, Unit> f237291c;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter$ViewsVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter;Landroid/view/View;)V", KtvSubElement.CONTAINER, "Landroid/widget/RelativeLayout;", "titleTv", "Landroid/widget/TextView;", "leftIconIv", "Landroid/widget/ImageView;", "rightIconsContainer", "Landroid/widget/LinearLayout;", "rightImageSize", "", "rightImageMarginEnd", "bindView", "", "viewItem", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;", "bindContainer", "bindLeftIcon", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindText", "bindRightIcons", "createRightIconIV", "rightIcon", "Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewsVH extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RelativeLayout f237292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f237293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f237294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f237295d;

        public static final class a extends t {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ViewsVH f237296c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ActionSheetItemAdapter f237297d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r100) {
                Object r101 = this.f237296c.f237292a.getTag();
                Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.sheet.actionsheet.ActionSheetItem");
                c r102 = (c) r101;
                Function1<? super c, Unit> r103 = this.f237297d.f237290b;
                if (r103 == null) goto L6;
                r103.invoke(r102);
                return;
            }

            public a(ViewsVH r100, ActionSheetItemAdapter r101) {
                this.f237296c = r100;
                this.f237297d = r101;
            }
        }

        public ViewsVH(ActionSheetItemAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            super(r101);
            RelativeLayout r102 = (RelativeLayout) r101.findViewById(R.id.item_container);
            this.f237292a = r102;
            this.f237293b = (TextView) r101.findViewById(R.id.tv_item_content);
            this.f237294c = (ImageView) r101.findViewById(R.id.iv_left_icon);
            this.f237295d = (LinearLayout) r101.findViewById(R.id.iv_right_icons_layout);
            r101.getContext().getResources().getDimensionPixelOffset(R.dimen.space_kit_len_24);
            r101.getContext().getResources().getDimensionPixelOffset(R.dimen.space_kit_len_16);
            r102.setOnClickListener(new a(this, r100));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f237289a).size();
    }

    public ActionSheetItemAdapter() {
        this.f237289a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewsVH r102 = (ViewsVH) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (r101 >= ((ArrayList) this.f237289a).size()) goto L17;
        c r103 = (c) ListProtector.get(this.f237289a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "viewItem");
        Context r104 = r102.f237292a.getContext();
        r102.f237292a.setTag(r103);
        r102.f237292a.setEnabled(r103.f237303c);
        r102.f237292a.setClickable(r103.f237303c);
        Intrinsics.checkNotNull(r104);
        e r105 = r103.f237305e;
        if (r105 == null) goto L11;
        r102.f237294c.setImageResource(r105.f237299a);
        Integer r106 = r105.f237300b;
        if (r106 == null) goto L10;
        int r107 = r106.intValue();
        r102.f237294c.setImageTintList(ColorStateList.valueOf(r104.getResources().getColor(r107)));
    L10:
        r102.f237294c.setEnabled(r103.f237303c);
        r102.f237294c.setVisibility(0);
    L12:
        r102.f237293b.setText(r103.f237302b);
        Integer r108 = r103.f237304d;
        if (r108 == null) goto L15;
        int r109 = r108.intValue();
        r102.f237293b.setTextColor(ColorStateList.valueOf(r104.getResources().getColor(r109)));
    L15:
        r102.f237293b.setEnabled(r103.f237303c);
        r102.f237295d.removeAllViews();
        return;
    L11:
        r102.f237294c.setVisibility(8);
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewsVH(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.sheets_actionsheet_item, r100, false));
    }
}
