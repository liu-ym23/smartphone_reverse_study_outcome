package com.bytedance.android.livesdk.ktvimpl.base.lyricv2;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyricv2/LyricLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LyricLinearLayoutManager extends LinearLayoutManager {
    public LyricLinearLayoutManager(Context r3) {
        super(r3, 1, false);
        canScrollVertically();
    }
}
