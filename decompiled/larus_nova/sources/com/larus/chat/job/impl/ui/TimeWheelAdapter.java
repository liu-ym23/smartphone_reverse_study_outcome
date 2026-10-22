package com.larus.chat.job.impl.ui;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class TimeWheelAdapter<T> extends RecyclerView.Adapter<TimeWheelAdapter<T>.WheelViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f325432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f325433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f325434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f325435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f325436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f325437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<T, String> f325438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f325439h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/chat/job/impl/ui/TimeWheelAdapter$WheelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "textView", "Landroid/widget/TextView;", "<init>", "(Lcom/larus/chat/job/impl/ui/TimeWheelAdapter;Landroid/widget/TextView;)V", "getTextView", "()Landroid/widget/TextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WheelViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f325440a;

        public WheelViewHolder(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "textView");
            super(r100);
            this.f325440a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f325433b == false) goto L8;
        if (this.f325432a.size() <= 1) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return this.f325432a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        WheelViewHolder r102 = (WheelViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TextView r103 = r102.f325440a;
        Function1<T, String> r104 = this.f325438g;
        List<T> r105 = this.f325432a;
        r103.setText(r104.invoke((T) ListProtector.get(r105, r101 % r105.size())));
        TextView r106 = r102.f325440a;
        if (r101 != this.f325439h) goto L5;
        int r107 = this.f325436e;
    L6:
        r106.setTextColor(r107);
        return;
    L5:
        r107 = this.f325437f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        TextView r102 = new TextView(r100.getContext());
        r102.setGravity(17);
        r102.setIncludeFontPadding(false);
        r102.setTextSize(0, this.f325435d);
        r102.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f325434c));
        return new WheelViewHolder(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TimeWheelAdapter(List<? extends T> r100, int r101, boolean r102, int r103, float r104, int r105, int r106, Function1<? super T, String> r107) {
        Intrinsics.checkNotNullParameter(r100, "values");
        Intrinsics.checkNotNullParameter(r107, "valueFormatter");
        this.f325432a = r100;
        this.f325433b = r102;
        this.f325434c = r103;
        this.f325435d = r104;
        this.f325436e = r105;
        this.f325437f = r106;
        this.f325438g = r107;
        this.f325439h = r101;
    }
}
