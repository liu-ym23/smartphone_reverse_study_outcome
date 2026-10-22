package com.bytedance.locallife.pdp.groupondetail.view.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.bytedance.dux.text.DuxTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/baseview/SpaceBetweenText;", "Lcom/bytedance/dux/text/DuxTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SpaceBetweenText extends DuxTextView {
    public SpaceBetweenText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SpaceBetweenText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getText().length() > 1) goto L5;
    L11:
        super.onDraw(r100);
        return;
    L5:
        if (getText().length() > 4) goto L11;
        String r101 = getText().toString();
        float r102 = (((getWidth() - getPaddingStart()) - getPaddingEnd()) - getPaint().measureText(r101)) / (r101.length() - 1);
        float r103 = getPaddingStart();
        int r104 = r101.length();
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L10;
        r100.drawText(String.valueOf(r101.charAt(r105)), r103, getBaseline(), getPaint());
        r103 = r103 + (getPaint().measureText(String.valueOf(r101.charAt(r105))) + r102);
        r105 = r105 + 1;
        goto L8
    }

    public SpaceBetweenText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SpaceBetweenText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
