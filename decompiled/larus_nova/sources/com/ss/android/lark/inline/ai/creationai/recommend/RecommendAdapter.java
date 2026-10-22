package com.ss.android.lark.inline.ai.creationai.recommend;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.n0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setRecommendIcon", "recommendItem", "Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "RecommendViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MenuItem> f427225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f427226b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MenuItem> f427227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<MenuItem> f427228b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            List<MenuItem> r100 = this.f427228b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            List<MenuItem> r100 = this.f427227a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public DiffCallback(List<MenuItem> r100, List<MenuItem> r101) {
            this.f427227a = r100;
            this.f427228b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            List<MenuItem> r102 = this.f427227a;
            if (r102 == null) goto L11;
            MenuItem r103 = (MenuItem) CollectionsKt.getOrNull(r102, r100);
            if (r103 == null) goto L11;
            List<MenuItem> r104 = this.f427228b;
            if (r104 == null) goto L9;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r104, r100);
        L13:
            return r103.equals(r105);
        L9:
            r105 = null;
        L11:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            List<MenuItem> r102 = this.f427227a;
            String r103 = null;
            if (r102 == null) goto L5;
            MenuItem r104 = (MenuItem) CollectionsKt.getOrNull(r102, r100);
        L6:
            List<MenuItem> r105 = this.f427228b;
            if (r105 == null) goto L9;
            MenuItem r106 = (MenuItem) CollectionsKt.getOrNull(r105, r101);
        L10:
            if (r104 == null) goto L12;
            String r107 = r104.getId();
        L13:
            if (r106 == null) goto L16;
            r103 = r106.getId();
        L16:
            return Intrinsics.areEqual(r107, r103);
        L12:
            r107 = null;
            goto L13
        L9:
            r106 = null;
            goto L10
        L5:
            r104 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            Bundle r102 = new Bundle();
            List<MenuItem> r103 = this.f427227a;
            String r104 = null;
            if (r103 == null) goto L5;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r103, r100);
        L6:
            List<MenuItem> r106 = this.f427228b;
            if (r106 == null) goto L9;
            MenuItem r107 = (MenuItem) CollectionsKt.getOrNull(r106, r100);
        L10:
            if (r105 == null) goto L12;
            String r108 = r105.getText();
        L13:
            if (r107 == null) goto L15;
            String r109 = r107.getText();
        L17:
            if (Intrinsics.areEqual(r108, r109) == true) goto L19;
            r102.putInt("text", 1);
        L19:
            if (r105 == null) goto L21;
            String r110 = r105.getType();
        L22:
            if (r107 == null) goto L24;
            String r111 = r107.getType();
        L26:
            if (Intrinsics.areEqual(r110, r111) == true) goto L28;
            r102.putInt("btnType", 1);
        L28:
            if (r105 == null) goto L30;
            String r112 = r105.getIcon();
        L31:
            if (r107 == null) goto L34;
            r104 = r107.getIcon();
        L34:
            if (Intrinsics.areEqual(r112, r104) == true) goto L36;
            r102.putInt("icon", 1);
        L36:
            return r102;
        L30:
            r112 = null;
            goto L31
        L24:
            r111 = null;
            goto L26
        L21:
            r110 = null;
            goto L22
        L15:
            r109 = null;
            goto L17
        L12:
            r108 = null;
            goto L13
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$RecommendViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemView", "Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "getItemView", "()Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecommendViewHolder extends RecyclerView.ViewHolder {
        public RecommendViewHolder(IconTextItem r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecommendAdapter f427229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MenuItem f427230b;

        public c(RecommendAdapter r100, MenuItem r101) {
            this.f427229a = r100;
            this.f427230b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427229a.f427226b;
            if (r101 == null) goto L6;
            r101.a(this.f427230b);
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<MenuItem> r100 = this.f427225a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public RecommendAdapter() {
    }

    public static void y2(MenuItem r100, IconTextItem r101) {
        String r102 = r100.getIcon();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L14;
        Context r104 = r101.getContext();
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        int r105 = n.n(r104, r102);
        r101.f427221a.setImageResource(r105);
    L17:
        boolean r106 = true;
    L19:
        String r107 = r100.getIcon();
        if (r107 != null) goto L22;
    L27:
        boolean r108 = false;
    L28:
        if (r108 == false) goto L32;
        if (r106 == false) goto L31;
        r101.setLeftIconVisible(true);
        ViewGroup.LayoutParams r109 = r101.getLeftIconView().getLayoutParams();
        r109.height = n0.a(24);
        ViewGroup.LayoutParams r110 = r101.getLeftIconView().getLayoutParams();
        r110.width = n0.a(24);
        r101.setEmojiVisible(false);
        return;
    L31:
        r101.setLeftIconVisible(false);
        r101.setEmojiContent(r100.getIcon());
        r101.setEmojiVisible(true);
        r101.setEmojiSize(16);
        return;
    L32:
        r101.setLeftIconVisible(false);
        return;
    L22:
        if (r107.length() <= 0) goto L24;
        boolean r111 = true;
    L25:
        if (r111 != true) goto L27;
        r108 = true;
        goto L28
    L24:
        r111 = false;
        goto L25
    L14:
        int r112 = n.o(r101.getContext(), r102);
        if (r112 == 0) goto L18;
        r101.f427221a.setImageResource(r112);
        goto L17
    L18:
        r106 = false;
        goto L19
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<MenuItem> r102 = this.f427225a;
        if (r102 == null) goto L9;
        MenuItem r103 = (MenuItem) ListProtector.get(r102, r101);
        if (r103 == null) goto L10;
        View r104 = r100.itemView;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.recommend.IconTextItem");
        IconTextItem r105 = (IconTextItem) r104;
        r105.setLeftLabelVisible(false);
        y2(r103, r105);
        r105.setTextSize(16);
        r105.setText(r103.getText());
        r105.setOnClickListener(new c(this, r103));
        return;
    L10:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new RecommendViewHolder(new IconTextItem(r100.getContext(), null, 6, 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if ((!r102.isEmpty()) == true) goto L5;
    L18:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((ListProtector.get(r102, 0) instanceof Bundle) == false) goto L18;
        List<MenuItem> r103 = this.f427225a;
        if (r103 == null) goto L17;
        MenuItem r104 = (MenuItem) ListProtector.get(r103, r101);
        if (r104 == null) goto L20;
        Object r105 = ListProtector.get(r102, 0);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r106 = (Bundle) r105;
        View r107 = r100.itemView;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.recommend.IconTextItem");
        IconTextItem r108 = (IconTextItem) r107;
        r108.setLeftLabelVisible(false);
        if (r106.getInt("text") != 1) goto L15;
        r108.setText(r104.getText());
    L15:
        if (r106.getInt("icon") != 1) goto L21;
        y2(r104, r108);
        return;
    L21:
        return;
    L20:
        return;
    }
}
