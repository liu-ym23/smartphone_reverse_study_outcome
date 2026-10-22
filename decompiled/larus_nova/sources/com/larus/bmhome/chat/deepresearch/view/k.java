package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemPlaceholderBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k extends AbsBlockView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusBlockItemPlaceholderBinding f302463b;

    public k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r100, Map<String, Object> r101) {
        LarusBlockItemPlaceholderBinding r102 = this.f302463b;
        if (r102 == null) goto L11;
        FrameLayout r103 = r102.f358480a;
        if (r103 == null) goto L12;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L10;
        r104.height = 0;
        r103.setLayoutParams(r104);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L12:
        return;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_block_item_placeholder, this, false);
        addView(r102);
        if (r102 == null) goto L7;
        this.f302463b = new LarusBlockItemPlaceholderBinding((FrameLayout) r102);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}
