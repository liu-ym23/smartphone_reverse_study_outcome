package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import qsb.i;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements c<ssb.b.C7650b, BaseEmojiViewHolder> {
    public b() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r100, ssb.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        View r102 = new View(r100);
        r102.setLayoutParams(new FlexboxLayoutManager.LayoutParams(-1, i.a(8, r100)));
        return new BaseEmojiViewHolder(r102);
    }
}
