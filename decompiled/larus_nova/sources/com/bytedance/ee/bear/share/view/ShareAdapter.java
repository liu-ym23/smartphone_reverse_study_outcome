package com.bytedance.ee.bear.share.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nm5.c;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 #2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\fH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J*\u0010\u001d\u001a\u00020\f2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u001c\u0010\u001d\u001a\u00020\f2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/share/view/ShareAdapter$ShareViewHolder;", "<init>", "()V", "uiList", "Lcom/bytedance/ee/bear/share/newshare/ShareUIList;", "viewTypeManager", "Lcom/bytedance/ee/bear/share/view/ShareViewTypeManager;", KtvSubElement.CONTAINER, "Lcom/bytedance/ee/bear/share/newshare/UIShareItem;", "setContainer", "", "setData", "data", "setItemContainer", "setItem", "uiItem", "notifyDiffDataSetChange", "olds", "news", "getShareUiList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "onBindViewHolder", "holder", "payloads", "", "", "getItemCount", "Companion", "ShareViewHolder", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareAdapter extends RecyclerView.Adapter<ShareViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f237269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f237270b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareAdapter$ShareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/share/view/ShareAdapter;Landroid/view/View;)V", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ShareViewHolder extends RecyclerView.ViewHolder {
        public ShareViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f237269a.f237207b.size();
    }

    public ShareAdapter() {
        d0 r100 = d0.f237205d;
        this.f237269a = d0.f237205d;
        this.f237270b = new c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        e0 r101 = this.f237269a.a(r100);
        c r102 = this.f237270b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r102.f519600b = r101;
        return r102.a(r101);
    }

    public final void y2(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        d0 r101 = this.f237269a;
        this.f237269a = r100;
        CollectionUtils.isEmpty(r100.f237207b);
        DiffUtil.calculateDiff(new ShareDiffCallback(r101, r100)).dispatchUpdatesTo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Integer] */
    public final void z2(Object r110) {
        Intrinsics.checkNotNullParameter(r110, "uiItem");
        d0 r100 = this.f237269a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "uiItem");
        Integer r101 = r100.f237208c.get(r110.f237211a);
        if (r101 == null) goto L5;
        ListProtector.set(r100.f237207b, r101.intValue(), r110);
        boolean r102 = true;
    L6:
        d0 r103 = this.f237269a;
        String r104 = r110.f237211a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "id");
        Integer r105 = r103.f237208c.get(r104);
        if (r105 != null) goto L20;
        Iterator<T> r106 = r103.f237207b.iterator();
        int r107 = 0;
    L10:
        if (r106.hasNext() == false) goto L20;
        int r108 = r107 + 1;
        d0 r109 = ((e0) r106.next()).c();
        if (r109 == null) goto L16;
        Intrinsics.checkNotNullParameter(r104, "id");
        Integer r111 = r109.f237208c.get(r104);
        if (r111 == null) goto L16;
        int r112 = r111.intValue();
        e0 r113 = (e0) CollectionsKt.getOrNull(r109.f237207b, r112);
    L17:
        if (r113 != null) goto L23;
        r107 = r108;
    L23:
        if (r107 < 0) goto L30;
        if (r102 == false) goto L26;
        r110 = 0;
    L26:
        notifyItemChanged(r107, r110);
        return;
    L30:
        return;
    L16:
        r113 = null;
    L20:
        if (r105 == null) goto L22;
        r107 = r105.intValue();
        goto L23
    L22:
        r107 = -1;
        goto L23
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter((ShareViewHolder) r100, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        c r102 = this.f237270b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "adapter");
        e0 r103 = r102.f519600b;
        if (r103 != null) goto L5;
    L7:
        Iterator<e0> r104 = this.f237269a.f237207b.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        e0 r105 = r104.next();
        if (r102.a(r105) != r101) goto L9;
        r103 = r105;
    L14:
        return new ShareViewHolder(r103.b(r100));
    L16:
        throw new IllegalStateException("Invalid viewType!");
    L5:
        if (r102.a(r103) != r101) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        ShareViewHolder r103 = (ShareViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        e0 r104 = this.f237269a.a(r101);
        if (CollectionUtils.isEmpty(r102) == false) goto L5;
    L7:
        r102 = null;
    L8:
        r104.a(r103.itemView, r102);
        return;
    L5:
        if (r102.contains(0) == true) goto L7;
        goto L7
    }
}
