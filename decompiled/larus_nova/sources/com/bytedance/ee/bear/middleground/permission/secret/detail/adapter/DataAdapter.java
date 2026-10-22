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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/detail/adapter/DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/permission/secret/detail/adapter/DataAdapter$RecycleViewHold;", "data", "", "Lcom/bytedance/ee/bear/middleground/permission/secret/detail/DataEntity;", "height", "", "isBold", "", "maxLines", "<init>", "(Ljava/util/List;IZI)V", "mHeight", "mIsBold", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "RecycleViewHold", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataAdapter extends RecyclerView.Adapter<RecycleViewHold> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f234047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f234050d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/detail/adapter/DataAdapter$RecycleViewHold;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "linearLayout", "Landroid/widget/LinearLayout;", "getLinearLayout", "()Landroid/widget/LinearLayout;", "setLinearLayout", "(Landroid/widget/LinearLayout;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecycleViewHold extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f234051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f234052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinearLayout f234053c;

        public RecycleViewHold(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f234051a = (ImageView) r100.findViewById(R.id.image_content);
            this.f234052b = (TextView) r100.findViewById(R.id.text_content);
            this.f234053c = (LinearLayout) r100.findViewById(R.id.data_content);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f234047a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        RecycleViewHold r102 = (RecycleViewHold) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        a r103 = (a) ListProtector.get(this.f234047a, r101);
        if (this.f234048b == (-1)) goto L6;
        ViewGroup.LayoutParams r104 = r102.f234053c.getLayoutParams();
        r104.height = this.f234048b;
        r102.f234053c.setLayoutParams(r104);
    L6:
        if (this.f234049c == false) goto L9;
        r102.f234052b.setTypeface(Typeface.defaultFromStyle(1));
    L9:
        if (r103.f234045b == true) goto L11;
        r102.f234052b.setVisibility(0);
        r102.f234052b.setText(((a) ListProtector.get(this.f234047a, r101)).f234044a);
        r102.f234052b.setMaxLines(this.f234050d);
        return;
    L11:
        if (r103.f234046c == false) goto L13;
        r102.f234051a.setImageResource(R.drawable.icon_allow);
    L14:
        r102.f234051a.setVisibility(0);
        r102.f234052b.setVisibility(8);
        return;
    L13:
        r102.f234051a.setImageResource(R.drawable.icon_secret_close);
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new RecycleViewHold(LayoutInflater.from(r100.getContext()).inflate(R.layout.secret_detail_data, r100, false));
    }

    public DataAdapter(List<a> r100, int r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f234047a = r100;
        this.f234048b = r101;
        this.f234049c = r102;
        this.f234050d = r103;
    }
}
