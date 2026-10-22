package com.bytedance.awemeopen.apps.framework.comment.adapter.minichoose;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import m44.b;
import m44.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MiniEmojiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final class EmojiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final AoImageView a;
        public final d b;
        public b c;

        public EmojiViewHolder(ViewGroup r4) {
            super(LayoutInflater.from(r4.getContext()).inflate(2131558623, r4, false));
            AoImageView r5 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371533);
            this.a = r5;
            this.b = null;
            r5.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            b r4 = this.c;
            if (r4 != null) goto L5;
            return;
        L5:
            this.b.a(r4.c, 2);
        }
    }

    public final int getItemCount() {
        return 0;
    }

    public final int getItemViewType(int r1) {
        return 2131558623;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        if ((r3 instanceof EmojiViewHolder) == false) goto L11;
        EmojiViewHolder r5 = (EmojiViewHolder) r3;
        b r6 = (b) ListProtector.get(null, r4);
        if (r6 != null) goto L7;
        r5.getClass();
        return;
    L7:
        r5.c = r6;
        r5.a.setImageResource(r6.a);
        if (TextUtils.isEmpty(r6.c) == true) goto L13;
        r5.a.setContentDescription(r6.c);
        return;
    L13:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return new EmojiViewHolder(r1);
    }
}
