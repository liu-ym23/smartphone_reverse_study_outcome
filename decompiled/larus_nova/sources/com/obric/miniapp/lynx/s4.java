package com.obric.miniapp.lynx;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.button.OButton;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class s4 extends RecyclerView.Adapter<v4> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<t4> f398280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<t4, Integer, Unit> f398281b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f398280a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((t4) ListProtector.get(this.f398280a, r100)).f398291b;
    }

    public s4(List r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f398280a = r100;
        this.f398281b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        v4 r102 = (v4) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final t4 r103 = (t4) ListProtector.get(this.f398280a, r101);
        final Function2<t4, Integer, Unit> r104 = this.f398281b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r104, SendEventContainerMethodParamModel.EventKinds.onClick);
        r102.f398313a.setText(r103.f398290a);
        r102.f398313a.setEnabled(!r103.f398293d);
        OButton r105 = r102.f398313a;
        if (r103.f398293d == false) goto L5;
        float r106 = 0.4f;
    L6:
        r105.setAlpha(r106);
        r102.f398313a.requestLayout();
        r102.f398313a.setOnClickListener(new u4(r104, r103, r101));
        return;
    L5:
        r106 = 1.0f;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new v4((OButton) vma.e.a(r100.getContext(), r101, new q()));
    }
}
