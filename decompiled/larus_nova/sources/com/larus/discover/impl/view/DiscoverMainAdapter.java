package com.larus.discover.impl.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bot.api.IBotDiscoverService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/discover/impl/view/DiscoverMainAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "getItemCount", "", "createFragment", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiscoverMainAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f330500a;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 2;
    }

    public DiscoverMainAdapter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f330500a = r100;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment createFragment(int r100) {
        if (r100 != 0) goto L4;
        Object r101 = IBotDiscoverService.f317641a.b();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment r102 = (Fragment) r101;
    L5:
        Bundle r103 = this.f330500a.getArguments();
        if (r103 != null) goto L8;
        r103 = new Bundle();
    L8:
        r102.setArguments(r103);
        return r102;
    L4:
        r102 = new Fragment();
        goto L5
    }
}
