package com.bytedance.ee.bear.middleground.permission.secret.detail.adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.permission.secret.detail.a;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/detail/adapter/DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/permission/secret/detail/adapter/DataAdapter$RecycleViewHold;", WikiFolderPushPlugin.DATA, "", "Lcom/bytedance/ee/bear/middleground/permission/secret/detail/DataEntity;", "height", "", "isBold", "", "maxLines", "<init>", "(Ljava/util/List;IZI)V", "mHeight", "mIsBold", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "RecycleViewHold", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataAdapter extends RecyclerView.Adapter<RecycleViewHold> {
    public final List<a> a;
    public final int b;
    public final boolean c;
    public final int d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/detail/adapter/DataAdapter$RecycleViewHold;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "linearLayout", "Landroid/widget/LinearLayout;", "getLinearLayout", "()Landroid/widget/LinearLayout;", "setLinearLayout", "(Landroid/widget/LinearLayout;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecycleViewHold extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;
        public final LinearLayout c;

        public RecycleViewHold(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131374971);
            this.b = (TextView) r2.findViewById(2131388414);
            this.c = (LinearLayout) r2.findViewById(2131368528);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        RecycleViewHold r6 = (RecycleViewHold) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        a r0 = (a) ListProtector.get(this.a, r5);
        if (this.b == (-1)) goto L6;
        ViewGroup.LayoutParams r1 = r6.c.getLayoutParams();
        r1.height = this.b;
        r6.c.setLayoutParams(r1);
    L6:
        if (this.c == false) goto L9;
        r6.b.setTypeface(Typeface.defaultFromStyle(1));
    L9:
        if (r0.b == true) goto L11;
        r6.b.setVisibility(0);
        r6.b.setText(((a) ListProtector.get(this.a, r5)).a);
        r6.b.setMaxLines(this.d);
        return;
    L11:
        if (r0.c == false) goto L13;
        r6.a.setImageResource(2131237710);
    L14:
        r6.a.setVisibility(0);
        r6.b.setVisibility(8);
        return;
    L13:
        r6.a.setImageResource(2131238061);
        goto L14
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new RecycleViewHold(LayoutInflater.from(r3.getContext()).inflate(2131564490, r3, false));
    }

    public DataAdapter(List<a> r2, int r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
