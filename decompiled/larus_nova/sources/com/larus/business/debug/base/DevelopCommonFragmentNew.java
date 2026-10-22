package com.larus.business.debug.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.business.debug.base.adapter.EntranceTabAdapter;
import com.larus.business.debug.base.view.DebugEntrancePageTagListView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/DevelopCommonFragmentNew;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevelopCommonFragmentNew extends Fragment {
    public DevelopCommonFragmentNew() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        EntranceTabAdapter r102 = new EntranceTabAdapter();
        View r103 = r100.findViewById(R.id.debug_entrance_pager);
        DebugEntrancePageTagListView r104 = null;
        if ((r103 instanceof ViewPager) == false) goto L5;
        ViewPager r105 = (ViewPager) r103;
    L6:
        View r106 = r100.findViewById(R.id.debug_entrance_pager_tabs);
        if ((r106 instanceof DebugEntrancePageTagListView) == false) goto L9;
        r104 = (DebugEntrancePageTagListView) r106;
    L9:
        if (r105 == null) goto L11;
        r105.setOffscreenPageLimit(2);
    L11:
        if (r105 == null) goto L13;
        r105.setAdapter(r102);
    L13:
        if (r104 == null) goto L16;
        r104.setupWithViewPager(r105);
        return;
    L16:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_page_release_develop_new, r101, false);
    }
}
