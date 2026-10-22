package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.SingleEmojiView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements c<ssb.b.c, BaseEmojiViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f432945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f432946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f432947c;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r100, ssb.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        SingleEmojiView r102 = new SingleEmojiView(r100);
        r102.b(r101);
        return new BaseEmojiViewHolder(r102);
    }
}
