package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements c<ssb.b.a, BaseEmojiViewHolder> {
    public a() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r100, ssb.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        RecentUsedEmojiView r102 = new RecentUsedEmojiView(r100, null, 6, 0);
        r102.setItemParams(r101);
        r102.setLayoutParams(new FlexboxLayoutManager.LayoutParams(r101.f543499e, -2));
        return new BaseEmojiViewHolder(r102);
    }
}
