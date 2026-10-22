package com.bytedance.ee.bear.share.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nm5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 #2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\fH\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J*\u0010\u001d\u001a\u00020\f2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u001c\u0010\u001d\u001a\u00020\f2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/share/view/ShareAdapter$ShareViewHolder;", "<init>", "()V", "uiList", "Lcom/bytedance/ee/bear/share/newshare/ShareUIList;", "viewTypeManager", "Lcom/bytedance/ee/bear/share/view/ShareViewTypeManager;", "container", "Lcom/bytedance/ee/bear/share/newshare/UIShareItem;", "setContainer", "", "setData", WikiFolderPushPlugin.DATA, "setItemContainer", "setItem", "uiItem", "notifyDiffDataSetChange", "olds", "news", "getShareUiList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "onBindViewHolder", "holder", "payloads", "", "", "getItemCount", "Companion", "ShareViewHolder", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareAdapter extends RecyclerView.Adapter<ShareViewHolder> {
    public d0 a;
    public final c b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareAdapter$ShareViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/share/view/ShareAdapter;Landroid/view/View;)V", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ShareViewHolder extends RecyclerView.ViewHolder {
        public ShareViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.a.b.size();
    }

    public ShareAdapter() {
        d0 r0 = d0.d;
        this.a = d0.d;
        this.b = new c();
    }

    public final int getItemViewType(int r3) {
        e0 r4 = this.a.a(r3);
        c r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "item");
        r0.b = r4;
        return r0.a(r4);
    }

    public final void y2(d0 r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        d0 r0 = this.a;
        this.a = r3;
        CollectionUtils.isEmpty(r3.b);
        DiffUtil.calculateDiff(new ShareDiffCallback(r0, r3)).dispatchUpdatesTo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Integer] */
    public final void z2(Object r11) {
        Intrinsics.checkNotNullParameter(r11, "uiItem");
        d0 r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "uiItem");
        Integer r0 = r1.c.get(r11.a);
        if (r0 == null) goto L5;
        ListProtector.set(r1.b, r0.intValue(), r11);
        boolean r2 = true;
    L6:
        d0 r3 = this.a;
        String r4 = r11.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        Integer r5 = r3.c.get(r4);
        if (r5 != null) goto L20;
        Iterator<T> r6 = r3.b.iterator();
        int r7 = 0;
    L10:
        if (r6.hasNext() == false) goto L20;
        int r8 = r7 + 1;
        d0 r9 = ((e0) r6.next()).c();
        if (r9 == null) goto L16;
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        Integer r10 = r9.c.get(r4);
        if (r10 == null) goto L16;
        int r12 = r10.intValue();
        e0 r13 = (e0) CollectionsKt.getOrNull(r9.b, r12);
    L17:
        if (r13 != null) goto L23;
        r7 = r8;
    L23:
        if (r7 < 0) goto L30;
        if (r2 == false) goto L26;
        r11 = 0;
    L26:
        notifyItemChanged(r7, r11);
        return;
    L30:
        return;
    L16:
        r13 = null;
    L20:
        if (r5 == null) goto L22;
        r7 = r5.intValue();
        goto L23
    L22:
        r7 = -1;
        goto L23
    L5:
        r2 = false;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        Intrinsics.checkNotNullParameter((ShareViewHolder) r1, "holder");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        c r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "adapter");
        e0 r1 = r0.b;
        if (r1 != null) goto L5;
    L7:
        Iterator<e0> r2 = this.a.b.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        e0 r3 = r2.next();
        if (r0.a(r3) != r6) goto L9;
        r1 = r3;
    L14:
        return new ShareViewHolder(r1.b(r5));
    L16:
        throw new IllegalStateException("Invalid viewType!");
    L5:
        if (r0.a(r1) != r6) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        ShareViewHolder r5 = (ShareViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        e0 r6 = this.a.a(r3);
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
    L7:
        r4 = null;
    L8:
        r6.a(((RecyclerView.ViewHolder) r5).itemView, r4);
        return;
    L5:
        if (r4.contains(0) == true) goto L7;
        goto L7
    }
}
