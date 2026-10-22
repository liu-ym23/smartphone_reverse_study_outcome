package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.larus.nova.R;
import s7b.a;

/* JADX INFO: loaded from: classes35.dex */
public class DelayDisplayProgressbar extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f417128a;

    public DelayDisplayProgressbar(Context r100) {
        super(r100);
        this.f417128a = new a(this);
    }

    public static /* synthetic */ void a(DelayDisplayProgressbar r100) {
        Object r101 = r100.getTag(R.id.delay_progress_visible_tag);
        if (r101 != null) goto L5;
        return;
    L5:
        if (((Boolean) r101).booleanValue() == false) goto L9;
        r100.setVisibility(0);
        return;
    }

    public DelayDisplayProgressbar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f417128a = new a(this);
    }

    public DelayDisplayProgressbar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f417128a = new a(this);
    }
}
