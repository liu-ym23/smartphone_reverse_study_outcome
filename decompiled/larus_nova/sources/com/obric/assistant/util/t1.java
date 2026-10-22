package com.obric.assistant.util;

import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;

/* JADX INFO: loaded from: classes33.dex */
public final class t1 implements SpanWatcher, NoCopySpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricMentionHighlightHelper.a f393842a;

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
    }

    public t1(ObricMentionHighlightHelper.a r100) {
        this.f393842a = r100;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
        if (r101 != Selection.SELECTION_START) goto L5;
    L6:
        this.f393842a.a(r100);
        return;
    L5:
        if (r101 == Selection.SELECTION_END) goto L6;
    }
}
