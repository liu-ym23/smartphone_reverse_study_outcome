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
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\n2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0014\u0010\u001f\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter$ViewsVH;", "<init>", "()V", "mItemList", "", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onRightIconClickListener", "Lkotlin/Function2;", "Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;", "getOnRightIconClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnRightIconClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "updateItemList", "list", "", "ViewsVH", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetItemAdapter extends RecyclerView.Adapter<ViewsVH> {
    public final List<c> a;
    public Function1<? super c, Unit> b;
    public Function2<? super c, ? super f, Unit> c;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter$ViewsVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter;Landroid/view/View;)V", "container", "Landroid/widget/RelativeLayout;", "titleTv", "Landroid/widget/TextView;", "leftIconIv", "Landroid/widget/ImageView;", "rightIconsContainer", "Landroid/widget/LinearLayout;", "rightImageSize", "", "rightImageMarginEnd", "bindView", "", "viewItem", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItem;", "bindContainer", "bindLeftIcon", "context", "Landroid/content/Context;", "bindText", "bindRightIcons", "createRightIconIV", "rightIcon", "Lcom/bytedance/ee/bear/sheet/actionsheet/RightIcon;", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewsVH extends RecyclerView.ViewHolder {
        public final RelativeLayout a;
        public final TextView b;
        public final ImageView c;
        public final LinearLayout d;

        public static final class a extends t {
            public final /* synthetic */ ViewsVH c;
            public final /* synthetic */ ActionSheetItemAdapter d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r2) {
                Object r3 = this.c.a.getTag();
                Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.sheet.actionsheet.ActionSheetItem");
                c r4 = (c) r3;
                Function1<? super c, Unit> r0 = this.d.b;
                if (r0 == null) goto L6;
                r0.invoke(r4);
                return;
            }

            public a(ViewsVH r1, ActionSheetItemAdapter r2) {
                this.c = r1;
                this.d = r2;
            }
        }

        public ViewsVH(ActionSheetItemAdapter r4, View r5) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            super(r5);
            RelativeLayout r0 = (RelativeLayout) r5.findViewById(2131375718);
            this.a = r0;
            this.b = (TextView) r5.findViewById(2131390823);
            this.c = (ImageView) r5.findViewById(2131376352);
            this.d = (LinearLayout) r5.findViewById(2131376564);
            r5.getContext().getResources().getDimensionPixelOffset(2131168330);
            r5.getContext().getResources().getDimensionPixelOffset(2131168315);
            r0.setOnClickListener(new a(this, r4));
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public ActionSheetItemAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        ViewsVH r7 = (ViewsVH) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        if (r6 >= ((ArrayList) this.a).size()) goto L17;
        c r8 = (c) ListProtector.get(this.a, r6);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "viewItem");
        Context r0 = r7.a.getContext();
        r7.a.setTag(r8);
        r7.a.setEnabled(r8.c);
        r7.a.setClickable(r8.c);
        Intrinsics.checkNotNull(r0);
        e r1 = r8.e;
        if (r1 == null) goto L11;
        r7.c.setImageResource(r1.a);
        Integer r2 = r1.b;
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
        r7.c.setImageTintList(ColorStateList.valueOf(r0.getResources().getColor(r3)));
    L10:
        r7.c.setEnabled(r8.c);
        r7.c.setVisibility(0);
    L12:
        r7.b.setText(r8.b);
        Integer r4 = r8.d;
        if (r4 == null) goto L15;
        int r9 = r4.intValue();
        r7.b.setTextColor(ColorStateList.valueOf(r0.getResources().getColor(r9)));
    L15:
        r7.b.setEnabled(r8.c);
        r7.d.removeAllViews();
        return;
    L11:
        r7.c.setVisibility(8);
        goto L12
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ViewsVH(this, LayoutInflater.from(r4.getContext()).inflate(2131564592, r4, false));
    }
}
