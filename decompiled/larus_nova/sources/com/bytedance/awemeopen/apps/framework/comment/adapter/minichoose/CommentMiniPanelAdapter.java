package com.bytedance.awemeopen.apps.framework.comment.adapter.minichoose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m44.b;
import m44.d;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/adapter/minichoose/CommentMiniPanelAdapter;", "Lcom/bytedance/awemeopen/apps/framework/comment/adapter/minichoose/EmojiBaseAdapter;", "", "SystemEmojiViewHolder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentMiniPanelAdapter extends EmojiBaseAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f194099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f194100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f194101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Object> f194102d;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/adapter/minichoose/CommentMiniPanelAdapter$SystemEmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class SystemEmojiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoImageView f194103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f194104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f194105c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            b r101 = this.f194105c;
            if (r101 != null) goto L5;
            return;
        L5:
            d r102 = this.f194104b;
            if (r101 == null) goto L8;
            String r103 = r101.f511841c;
        L9:
            r102.a(r103, 2);
            return;
        L8:
            r103 = null;
            goto L9
        }

        public SystemEmojiViewHolder(ViewGroup r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r101, "inputView");
            super(LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_emoji_item_mini_system_emoji, r100, false));
            AoImageView r102 = (AoImageView) this.itemView.findViewById(R.id.emoji_iv);
            this.f194103a = r102;
            this.f194104b = r101;
            r102.setOnClickListener(this);
        }
    }

    public CommentMiniPanelAdapter() {
        this(null, null, 0, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = this.f194102d.size();
        if (this.f194100b != null) goto L5;
        int r101 = 0;
    L7:
        return r100 + r101;
    L5:
        r101 = 1;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f194102d.size() <= r100) goto L17;
        if (r100 >= 0) goto L7;
        return 0;
    L7:
        if (this.f194101c == false) goto L11;
        return 11;
    L11:
        if (this.f194100b != null) goto L14;
        return 10;
    L14:
        if (r100 != this.f194102d.size()) goto L19;
        return 2000;
    L19:
        return 10;
    L17:
        return 0;
    }

    public final void setData(List<Object> r100) {
        this.f194102d.clear();
        List<Object> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        this.f194102d.addAll(r101);
    L11:
        notifyDataSetChanged();
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof SystemEmojiViewHolder) == false) goto L12;
        SystemEmojiViewHolder r102 = (SystemEmojiViewHolder) r100;
        Object r103 = ListProtector.get(this.f194102d, r101);
        if ((r103 instanceof b) == false) goto L7;
        b r104 = (b) r103;
    L8:
        if (r104 != null) goto L10;
        r102.getClass();
        return;
    L10:
        r102.f194105c = r104;
        r102.f194103a.setImageResource(r104.f511839a);
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        d r102 = this.f194099a;
        Intrinsics.checkNotNull(r102);
        return new SystemEmojiViewHolder(r100, r102);
    }

    public CommentMiniPanelAdapter(d r100, View r101, int r102, boolean r103) {
        this.f194099a = r100;
        this.f194100b = r101;
        this.f194101c = r103;
        this.f194102d = new ArrayList();
    }
}
