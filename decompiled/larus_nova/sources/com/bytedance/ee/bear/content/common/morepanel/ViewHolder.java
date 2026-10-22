package com.bytedance.ee.bear.content.common.morepanel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/content/common/morepanel/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "setText", "(Landroid/widget/TextView;)V", "rightIcon", "getRightIcon", "setRightIcon", "rightText", "getRightText", "setRightText", ItemStyle.ITEM_STYLE_DIVIDER, "getDivider", "()Landroid/view/View;", "setDivider", "contentmanager-content-widget_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f216791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f216792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f216793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f216794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f216795e;

    public ViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f216791a = (ImageView) r100.findViewById(R.id.icon);
        this.f216792b = (TextView) r100.findViewById(R.id.text);
        this.f216793c = (ImageView) r100.findViewById(R.id.rightIcon);
        this.f216794d = (TextView) r100.findViewById(R.id.rightText);
        this.f216795e = r100.findViewById(R.id.divider);
    }
}
