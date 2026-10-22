package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements c<ssb.b.d, TitleViewHolder> {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.c
    public final RecyclerView.ViewHolder a(Context r100, ssb.a r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "params");
        ConstraintLayout r101 = new ConstraintLayout(r100);
        FlexboxLayoutManager.LayoutParams r102 = new FlexboxLayoutManager.LayoutParams(-1, -2);
        r102.setMarginStart((r110.f543495a - r110.f543498d) / 2);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((ViewGroup.MarginLayoutParams) r102).topMargin = UIUtils.dp2px(r100, 8.0f);
        r101.setLayoutParams(r102);
        ImageView r111 = new ImageView(r100);
        r111.setId(R.id.icon_iv);
        r111.setVisibility(8);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = UIUtils.dp2px(r100, 22.0f);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(r103, UIUtils.dp2px(r100, 16.0f));
        r104.startToStart = 0;
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r111.setLayoutParams(r104);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r111.setPadding(0, 0, UIUtils.dp2px(r100, 6.0f), 0);
        r111.setVisibility(8);
        r101.addView(r111);
        TextView r112 = new TextView(r100);
        r112.setId(R.id.title_tv);
        r112.setTextSize(12.0f);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r112.setTextColor(UIUtils.getColor(r100, R.color.text_caption));
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(0, -2);
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        r105.endToEnd = 0;
        r105.startToEnd = R.id.icon_iv;
        r112.setLayoutParams(r105);
        r101.addView(r112);
        return new TitleViewHolder(r101);
    }
}
