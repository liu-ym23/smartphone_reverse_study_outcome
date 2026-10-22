package com.larus.home.impl.main.side_bar.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/ShowAllHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "showAll", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getShowAll", "()Landroid/widget/TextView;", "showAll$delegate", "Lkotlin/Lazy;", "bind", "", "showAllText", "", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowAllHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f344875b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f344876a;

    public ShowAllHolder(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f344876a = LazyKt.lazy(new g(r100));
        x0.c(r100, false);
    }

    public final void T3(String r100, final Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "showAllText");
        ((TextView) this.f344876a.getValue()).setText(r100);
        e1.d(this.itemView, new f(r101));
    }
}
