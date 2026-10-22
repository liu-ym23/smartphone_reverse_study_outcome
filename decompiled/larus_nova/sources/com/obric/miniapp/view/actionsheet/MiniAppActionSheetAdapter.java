package com.obric.miniapp.view.actionsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.selection.OActionSheetButton;
import com.ss.android.lark.utils.statistics.PerfLog;
import fla.a;
import fla.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fJ\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J \u0010\u0014\u001a\u00020\r2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u001c\u0010\u001c\u001a\u00020\r2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter$SheetItemViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "items", "", "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "onItemClickListener", "Lkotlin/Function2;", "", "", "dialogGetter", "Lkotlin/Function0;", "Landroid/app/Dialog;", "setDialogGetter", "setItems", "", "setOnItemClickListener", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "onBindViewHolder", "holder", "getItemCount", "SheetItemViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppActionSheetAdapter extends RecyclerView.Adapter<SheetItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f398637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f398638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super a, ? super Integer, Unit> f398639c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter$SheetItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "<init>", "(Lcom/obric/miniapp/view/actionsheet/MiniAppActionSheetAdapter;Landroid/view/View;I)V", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "titleView", "Landroid/widget/TextView;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SheetItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f398640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f398641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f398642c;

        public SheetItemViewHolder(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f398640a = r101;
            this.f398641b = (ImageView) r100.findViewById(R.id.iv_mini_app_menu_image);
            this.f398642c = (TextView) r100.findViewById(R.id.tv_mini_app_menu_title);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f398638b).size();
    }

    public MiniAppActionSheetAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f398637a = r100;
        this.f398638b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((a) ListProtector.get(this.f398638b, r100)).f477750a.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        SheetItemViewHolder r102 = (SheetItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final a r103 = (a) ListProtector.get(this.f398638b, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        if (r102.f398640a != OActionSheet.Companion.ItemStyle.LIST_ICON_AND_TEXT.ordinal()) goto L13;
        ImageView r104 = r102.f398641b;
        if (r104 == null) goto L7;
        r104.setImageDrawable(r103.f477751b);
    L7:
        TextView r105 = r102.f398642c;
        if (r105 == null) goto L10;
        r105.setText(r103.f477752c);
    L10:
        Integer r106 = r103.f477753d;
        if (r106 == null) goto L16;
        r102.f398642c.setTextColor(r106.intValue());
    L16:
        r102.itemView.setOnClickListener(new b(this, r103, r101));
        return;
    L13:
        View r107 = r102.itemView;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.obric.oui.selection.OActionSheetButton");
        OActionSheetButton r108 = (OActionSheetButton) r107;
        r108.setText(r103.f477752c);
        Integer r109 = r103.f477753d;
        if (r109 == null) goto L16;
        r108.setTextColor(r109.intValue());
        goto L16
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != OActionSheet.Companion.ItemStyle.LIST_ICON_AND_TEXT.ordinal()) goto L6;
        View r102 = LayoutInflater.from(this.f398637a).inflate(R.layout.mini_app_menu_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new SheetItemViewHolder(r102, r101);
    L6:
        return new SheetItemViewHolder(new OActionSheetButton(this.f398637a, null), r101);
    }
}
