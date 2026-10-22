package com.bytedance.awemeopen.apps.framework.comment.adapter.minichoose;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import m44.b;
import m44.d;

/* JADX INFO: loaded from: classes14.dex */
public class MiniEmojiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final class EmojiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoImageView f194106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f194107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f194108c;

        public EmojiViewHolder(ViewGroup r100) {
            super(LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_emoji_item_mini_emoji, r100, false));
            AoImageView r101 = (AoImageView) this.itemView.findViewById(R.id.emoji_iv);
            this.f194106a = r101;
            this.f194107b = null;
            r101.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f194108c;
            if (r101 != null) goto L5;
            return;
        L5:
            this.f194107b.a(r101.f511841c, 2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return R.layout.aos_emoji_item_mini_emoji;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof EmojiViewHolder) == false) goto L11;
        EmojiViewHolder r102 = (EmojiViewHolder) r100;
        b r103 = (b) ListProtector.get(null, r101);
        if (r103 != null) goto L7;
        r102.getClass();
        return;
    L7:
        r102.f194108c = r103;
        r102.f194106a.setImageResource(r103.f511839a);
        if (TextUtils.isEmpty(r103.f511841c) == true) goto L13;
        r102.f194106a.setContentDescription(r103.f511841c);
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new EmojiViewHolder(r100);
    }
}
