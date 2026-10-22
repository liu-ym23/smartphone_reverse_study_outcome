package com.obric.update.impl.activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import eoa.a;
import eoa.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/update/impl/activity/MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/update/impl/activity/MyAdapter$MyViewHolder;", "itemList", "", "Lcom/obric/update/impl/activity/Item;", "contextCompat", "Landroid/content/Context;", "<init>", "(Ljava/util/List;Landroid/content/Context;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "MyViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f404048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f404049b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/update/impl/activity/MyAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemTextView1", "Landroid/widget/TextView;", "getItemTextView1", "()Landroid/widget/TextView;", "itemTextView2", "getItemTextView2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MyViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f404050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f404051b;

        public MyViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f404050a = (TextView) r100.findViewById(R.id.test_1);
            this.f404051b = (TextView) r100.findViewById(R.id.test_2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f404048a.size();
    }

    public MyAdapter(List<a> r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "itemList");
        Intrinsics.checkNotNullParameter(r101, "contextCompat");
        this.f404048a = r100;
        this.f404049b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        final MyViewHolder r102 = (MyViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        a r103 = (a) ListProtector.get(this.f404048a, r101);
        r102.f404050a.setText(r103.f473402a);
        r102.f404051b.setText(r103.f473403b);
        AppHost.Companion r104 = AppHost.f326268a;
        Activity r105 = r104.a().getCurrentActivity();
        if (r105 == null) goto L6;
        r102.f404051b.setBackground(ContextCompat.getDrawable(r105, R.drawable.updated_bg));
        r102.f404051b.setTextColor(ContextCompat.getColor(this.f404049b, R.color.neutral_100));
        r102.f404051b.setAlpha(0.3f);
    L6:
        if (Intrinsics.areEqual(r102.f404051b.getText(), foa.a.f478189c) == false) goto L12;
        Activity r106 = r104.a().getCurrentActivity();
        if (r106 == null) goto L10;
        r102.f404051b.setBackground(ContextCompat.getDrawable(r106, R.drawable.to_update_bg));
        r102.f404051b.setTextColor(ContextCompat.getColor(this.f404049b, R.color.primary_50));
        r102.f404051b.setAlpha(1.0f);
    L10:
        r102.f404051b.setOnClickListener(new b(r102));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.obric_update_item, r100, false);
        Intrinsics.checkNotNull(r102);
        return new MyViewHolder(r102);
    }
}
