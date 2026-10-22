package com.bytedance.dux.dialog.alert.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.text.DuxTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/dialog/alert/view/DialogMultiTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/dux/text/DuxTextView;", "getContentTextView", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DialogMultiTextView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxTextView f204960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f204961b;

    public DialogMultiTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DialogMultiTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final DuxTextView getContentTextView() {
        return this.f204960a;
    }

    public DialogMultiTextView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_layout_dialog_multi_text, this);
        DuxTextView r103 = (DuxTextView) findViewById(R.id.tv_content);
        this.f204960a = r103;
        Resources r104 = Resources.getSystem();
        r103.setLineHeight(MathKt.roundToInt(TypedValue.applyDimension(2, (float) 19.6d, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))));
        this.f204961b = findViewById(R.id.foreground_view);
    }
}
