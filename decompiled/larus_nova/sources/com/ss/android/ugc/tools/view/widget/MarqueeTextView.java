package com.ss.android.ugc.tools.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.view.style.StyleTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/MarqueeTextView;", "Lcom/ss/android/ugc/tools/view/style/StyleTextView;", "", "enable", "", "setMarqueeEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class MarqueeTextView extends StyleTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f455041a;

    public MarqueeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f455041a;
    }

    public final void setMarqueeEnable(boolean r100) {
        if (this.f455041a == r100) goto L6;
        this.f455041a = r100;
        onWindowFocusChanged(r100);
        return;
    }

    public MarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ MarqueeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
