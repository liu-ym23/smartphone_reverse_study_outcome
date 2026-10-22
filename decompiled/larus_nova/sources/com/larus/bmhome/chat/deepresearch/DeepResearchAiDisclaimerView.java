package com.larus.bmhome.chat.deepresearch;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/DeepResearchAiDisclaimerView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepResearchAiDisclaimerView extends AppCompatTextView {
    public DeepResearchAiDisclaimerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        RecyclerView.LayoutParams r101 = new RecyclerView.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) r101).topMargin = c7.b(46);
        ((ViewGroup.MarginLayoutParams) r101).bottomMargin = c7.b(10);
        setLayoutParams(r101);
        setGravity(17);
        setText(r100.getString(R.string.larus_Bot_desc_genByAI));
        setTextColor(c.a(R.attr.larus_neutral_50, r100, R.color.larus_neutral_50));
        setTextSize(0, getResources().getDimension(c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12)));
    }
}
