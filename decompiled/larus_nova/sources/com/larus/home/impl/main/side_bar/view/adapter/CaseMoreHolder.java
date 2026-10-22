package com.larus.home.impl.main.side_bar.view.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.home.impl.databinding.LarusItemSideBarShowAllBinding;
import com.larus.showcase.api.ICaseService;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/CaseMoreHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/home/impl/databinding/LarusItemSideBarShowAllBinding;", "<init>", "(Lcom/larus/home/impl/databinding/LarusItemSideBarShowAllBinding;)V", "bind", "", "showAllText", "", "onClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseMoreHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f344872b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemSideBarShowAllBinding f344873a;

    public CaseMoreHolder(LarusItemSideBarShowAllBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.f344328a);
        this.f344873a = r100;
        if (ICaseService.f369257a.m() == true) goto L6;
        e1.o(r100.f344329b);
        return;
    }
}
