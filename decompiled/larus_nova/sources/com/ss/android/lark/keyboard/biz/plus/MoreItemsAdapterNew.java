package com.ss.android.lark.keyboard.biz.plus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ignition.widget.squircle.SquircleImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0018\u0019\u001aB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$ViewHolder;", "Lcom/ss/android/lark/chat/entity/keyboard/IPlusItem;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dependency", "Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$AdapterDependency;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$AdapterDependency;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "renderNormalRoundImage", "entity", "imageView", "Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;", "refreshWhenInterceptorUpdated", "Companion", "ViewHolder", "AdapterDependency", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoreItemsAdapterNew extends LarkRecyclerViewBaseAdapter<ViewHolder, d5b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f428479a = 0;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/plus/MoreItemsAdapterNew$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "iconImageView", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "nameTextView", "Landroid/widget/TextView;", "getNameTextView", "()Landroid/widget/TextView;", "redDotImageView", "getRedDotImageView", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f428480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f428481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f428482c;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f428480a = (ImageView) r100.findViewById(R.id.item_icon);
            this.f428481b = (TextView) r100.findViewById(R.id.item_name);
            this.f428482c = (ImageView) r100.findViewById(R.id.item_icon_red_dot);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        d5b.a r103 = getItem(r101);
        if (r103.isVisible() == false) goto L9;
        r102.itemView.setVisibility(0);
        r102.f428481b.setText(r103.getName());
        ImageView r104 = r102.f428480a;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.larksuite.component.ignition.widget.squircle.SquircleImageView");
        SquircleImageView r105 = (SquircleImageView) r104;
        Intrinsics.checkNotNull(r103);
        r105.setBackgroundColor(UDColorUtils.getColor(null, R.color.imtoken_keyboard_plus_item_background));
        r105.setBackgroundTintList(UDColorUtils.getColorStateList(null, R.color.kb_more_item_bg_color_selector));
        UIHelper.dp2px(52.0f);
        if (r103.getIconId() == (-1)) goto L7;
        r105.setImageResource(r103.getIconId());
        r105.setImageTintList(null);
        r105.setRadius(UIHelper.dp2px(12.0f));
        r105.setBorderWidth(UIHelper.dp2px(0.0f));
        r105.setBorderColor(j08.b.b(ContextCompat.getColor(r105.getContext(), R.color.lkui_N900), 0.1f));
    L8:
        ImageView r106 = r102.f428482c;
        r103.showRedDot();
        r106.setVisibility(8);
        r102.itemView.setOnClickListener(new c(this, r103, r102));
        return;
    L7:
        r103.b();
        r102.itemView.setVisibility(8);
        goto L8
    L9:
        r102.itemView.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(null).inflate(R.layout.kb_keyboard_more_item_layout_assembler, r100, false);
        Intrinsics.checkNotNull(r102);
        return new ViewHolder(r102);
    }
}
