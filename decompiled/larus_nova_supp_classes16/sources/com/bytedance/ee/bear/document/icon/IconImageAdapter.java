package com.bytedance.ee.bear.document.icon;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\u0010\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0019H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/icon/IconImageAdapter$ViewHolder;", "<init>", "()V", "iconInfoList", "", "Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;", "iconSelectCallback", "Lkotlin/Function1;", "", "getIconSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setIconSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "noneKeyIconInfo", "selectedIconKey", "", "setIconList", "iconList", "", "setSelectedIcon", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Lcom/bytedance/ee/bear/contract/icon/IconInfo;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconImageAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final List<DocIconNetResult.Icon> a;
    public Function1<? super DocIconNetResult.Icon, Unit> b;
    public final DocIconNetResult.Icon c;
    public String d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconImageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131376302);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public IconImageAdapter() {
        this.a = new ArrayList();
        DocIconNetResult.Icon r0 = new DocIconNetResult.Icon();
        r0.fs_unit = "";
        r0.key = IconPlugin.NONE_ICON_KEY;
        r0.type = 2;
        this.c = r0;
        this.d = IconPlugin.NONE_ICON_KEY;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        ViewHolder r8 = (ViewHolder) r6;
        Intrinsics.checkNotNullParameter(r8, "holder");
        DocIconNetResult.Icon r9 = (DocIconNetResult.Icon) ListProtector.get(this.a, r7);
        ((RecyclerView.ViewHolder) r8).itemView.setTag(r9);
        if (TextUtils.equals(this.c.key, r9.key) == false) goto L5;
        r8.a.setImageResource(2131237798);
    L6:
        ((RecyclerView.ViewHolder) r8).itemView.setSelected(TextUtils.equals(this.d, r9.key));
        return;
    L5:
        ((uz4.a) org.koin.java.a.c(uz4.a.class, null, null, 6)).c(r9.key, r9.fs_unit, 2131237791, r8.a);
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131560083, r3, false);
        Intrinsics.checkNotNull(r5);
        ViewHolder r6 = new ViewHolder(r5);
        r5.setOnClickListener(new b(this));
        return r6;
    }
}
