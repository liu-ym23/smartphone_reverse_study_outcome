package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.HeadTextBlock;
import com.larus.mainbot.impl.databinding.LarusBlockItemHeadTextBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class v extends AbsBlockView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusBlockItemHeadTextBinding f302574b;

    public v(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r100, Map<String, Object> r101) {
        LarusBlockItemHeadTextBinding r102 = this.f302574b;
        if (r102 == null) goto L16;
        we8.a.b(r102.f358459b, i5.t(), false, null, null, 12);
        TextView r103 = r102.f358459b;
        if (r100 == null) goto L13;
        BlockContent r104 = r100.getContent();
        if (r104 == null) goto L13;
        HeadTextBlock r105 = r104.getHeadTextBlock();
        if (r105 == null) goto L13;
        String r106 = r105.text;
        if (r106 == null) goto L13;
    L14:
        r103.setText(r106);
        return;
    L13:
        r106 = "";
        goto L14
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_block_item_head_text, this, false);
        addView(r102);
        if (r102 == null) goto L7;
        TextView r103 = (TextView) r102;
        this.f302574b = new LarusBlockItemHeadTextBinding(r103, r103);
        return;
    L7:
        throw new NullPointerException("rootView");
    }
}
