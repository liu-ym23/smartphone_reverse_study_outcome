package com.larus.chat.job.impl.page.edit;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.databinding.LarusChatJobEditTextItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u1 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusChatJobEditTextItemBinding f325345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ChatJobEditTextKey, q1> f325346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<ChatJobEditTextKey, q1, Unit> f325347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t1 f325348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f325349e;

    public u1(LarusChatJobEditTextItemBinding r100, f r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "selectionProvider");
        Intrinsics.checkNotNullParameter(r102, "onSelectionChanged");
        super(r100.f325047a);
        this.f325345a = r100;
        this.f325346b = r101;
        this.f325347c = r102;
    }
}
