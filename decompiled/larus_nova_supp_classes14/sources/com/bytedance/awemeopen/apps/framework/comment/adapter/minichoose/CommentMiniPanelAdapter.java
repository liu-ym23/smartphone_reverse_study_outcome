package com.bytedance.awemeopen.apps.framework.comment.adapter.minichoose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m44.b;
import m44.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/adapter/minichoose/CommentMiniPanelAdapter;", "Lcom/bytedance/awemeopen/apps/framework/comment/adapter/minichoose/EmojiBaseAdapter;", "", "SystemEmojiViewHolder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentMiniPanelAdapter extends EmojiBaseAdapter<Object> {
    public final d a;
    public final View b;
    public final boolean c;
    public final ArrayList<Object> d;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/adapter/minichoose/CommentMiniPanelAdapter$SystemEmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class SystemEmojiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final AoImageView a;
        public final d b;
        public b c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            b r4 = this.c;
            if (r4 != null) goto L5;
            return;
        L5:
            d r0 = this.b;
            if (r4 == null) goto L8;
            String r5 = r4.c;
        L9:
            r0.a(r5, 2);
            return;
        L8:
            r5 = null;
            goto L9
        }

        public SystemEmojiViewHolder(ViewGroup r4, d r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "inputView");
            super(LayoutInflater.from(r4.getContext()).inflate(2131558624, r4, false));
            AoImageView r6 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371533);
            this.a = r6;
            this.b = r5;
            r6.setOnClickListener(this);
        }
    }

    public CommentMiniPanelAdapter() {
        this(null, null, 0, false);
    }

    public final int getItemCount() {
        int r0 = this.d.size();
        if (this.b != null) goto L5;
        int r1 = 0;
    L7:
        return r0 + r1;
    L5:
        r1 = 1;
        goto L7
    }

    public final int getItemViewType(int r3) {
        if (this.d.size() <= r3) goto L17;
        if (r3 >= 0) goto L7;
        return 0;
    L7:
        if (this.c == false) goto L11;
        return 11;
    L11:
        if (this.b != null) goto L14;
        return 10;
    L14:
        if (r3 != this.d.size()) goto L19;
        return ECDraweeView.ROUND;
    L19:
        return 10;
    L17:
        return 0;
    }

    public final void setData(List<Object> r2) {
        this.d.clear();
        List<Object> r3 = r2;
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        this.d.addAll(r3);
    L11:
        notifyDataSetChanged();
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if ((r2 instanceof SystemEmojiViewHolder) == false) goto L12;
        SystemEmojiViewHolder r4 = (SystemEmojiViewHolder) r2;
        Object r5 = ListProtector.get(this.d, r3);
        if ((r5 instanceof b) == false) goto L7;
        b r6 = (b) r5;
    L8:
        if (r6 != null) goto L10;
        r4.getClass();
        return;
    L10:
        r4.c = r6;
        r4.a.setImageResource(r6.a);
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        d r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return new SystemEmojiViewHolder(r2, r0);
    }

    public CommentMiniPanelAdapter(d r1, View r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = new ArrayList();
    }
}
