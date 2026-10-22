package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedWakeupItemBinding;
import com.larus.dora.impl.settings.SimplifiedTopic;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter$ViewHolder;", "<init>", "()V", "items", "", "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "updateTopics", "", "newItems", "", "getTopic", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "getItemId", "", "getItemCount", "ViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedWakeupAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SimplifiedTopic> f337217a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedWakeupAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupItemBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedWakeupItemBinding;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/dora/impl/settings/SimplifiedTopic;", "bindText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusDoraHSimplifiedWakeupItemBinding f337218a;

        public ViewHolder(LarusDoraHSimplifiedWakeupItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f332702a);
            this.f337218a = r100;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f337217a).size();
    }

    public DoraHStreamlinedWakeupAdapter() {
        this.f337217a = new ArrayList();
        setHasStableIds(true);
    }

    public final void y2(List<SimplifiedTopic> r100) {
        Intrinsics.checkNotNullParameter(r100, "newItems");
        if (((ArrayList) this.f337217a).size() == r100.size()) goto L6;
        ((ArrayList) this.f337217a).clear();
        ArrayList r101 = (ArrayList) this.f337217a;
        r101.addAll(r100);
        notifyDataSetChanged();
        return;
    L6:
        Iterator<T> r102 = r100.iterator();
        boolean r103 = false;
        int r104 = 0;
    L8:
        if (r102.hasNext() == false) goto L16;
        Object r105 = r102.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        SimplifiedTopic r107 = (SimplifiedTopic) r105;
        if (Intrinsics.areEqual((SimplifiedTopic) CollectionsKt.getOrNull(this.f337217a, r104), r107) == true) goto L15;
        ListProtector.set(this.f337217a, r104, r107);
        notifyItemChanged(r104, "payload_topic_text");
        r103 = true;
    L15:
        r104 = r106;
        goto L8
    L16:
        if (r103 == false) goto L18;
        return;
    L18:
        if (((ArrayList) this.f337217a).isEmpty() == true) goto L20;
        return;
    L20:
        if (r100.isEmpty() == false) goto L28;
        notifyDataSetChanged();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        SimplifiedTopic r103 = (SimplifiedTopic) ListProtector.get(this.f337217a, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        DoraTextView r104 = r102.f337218a.f332704c;
        int r105 = com.larus.utils.j0.f375426a;
        String r106 = r103.getTitleKey();
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        r104.setText(com.larus.utils.j0.e(r106));
        r102.f337218a.f332704c.setAlpha(1.0f);
        r102.f337218a.f332703b.setAlpha(1.0f);
        ViewGroup.LayoutParams r107 = r102.f337218a.f332703b.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r108 = (RecyclerView.LayoutParams) r107;
        ((ViewGroup.MarginLayoutParams) r108).topMargin = c7.b(12);
        ((ViewGroup.MarginLayoutParams) r108).bottomMargin = 0;
        r102.f337218a.f332703b.setLayoutParams(r108);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_dora_h_simplified_wakeup_item, r100, false);
        FrameLayout r103 = (FrameLayout) r102;
        DoraTextView r104 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_onboarding_item_text);
        if (r104 == null) goto L7;
        return new ViewHolder(new LarusDoraHSimplifiedWakeupItemBinding(r103, r103, r104));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.dora_onboarding_item_text)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        ViewHolder r103 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if (r102.contains("payload_topic_text") == false) goto L8;
        SimplifiedTopic r104 = (SimplifiedTopic) ListProtector.get(this.f337217a, r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        DoraTextView r105 = r103.f337218a.f332704c;
        int r106 = com.larus.utils.j0.f375426a;
        String r107 = r104.getTitleKey();
        if (r107 != null) goto L7;
        r107 = "";
    L7:
        r105.setText(com.larus.utils.j0.e(r107));
        return;
    L8:
        super.onBindViewHolder(r103, r101, r102);
    }
}
