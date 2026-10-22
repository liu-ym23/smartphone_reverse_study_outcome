package com.ss.android.ugc.tools.view.style;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/tools/view/style/StyleAlwaysMarqueeTextView;", "Lcom/ss/android/ugc/tools/view/style/StyleTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class StyleAlwaysMarqueeTextView extends StyleTextView {
    public StyleAlwaysMarqueeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StyleAlwaysMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        if (r100 == false) goto L5;
        super.onWindowFocusChanged(r100);
        return;
    }

    public StyleAlwaysMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        if (r100 == false) goto L5;
        super.onFocusChanged(r100, r101, r102);
        return;
    }

    public /* synthetic */ StyleAlwaysMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
