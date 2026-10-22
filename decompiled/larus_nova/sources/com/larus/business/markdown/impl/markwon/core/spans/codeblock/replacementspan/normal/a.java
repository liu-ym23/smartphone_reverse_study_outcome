package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import jw8.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DefaultMarkdownCodeView f320650a;

    public a() {
    }

    @Override // jw8.c
    public final void f() {
    }

    @Override // jw8.c
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        DefaultMarkdownCodeView r101 = this.f320650a;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new DefaultMarkdownCodeView(r100, null, 6, 0);
    }

    @Override // jw8.c
    public final Size b(TextView r100, Spanned r101, jw8.b r102, Map r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "span");
        int r106 = 0;
        if (this.f320650a != null) goto L5;
        this.f320650a = new DefaultMarkdownCodeView(r100.getContext(), null, 6, 0);
    L5:
        DefaultMarkdownCodeView r107 = this.f320650a;
        if (r107 == null) goto L14;
        String r108 = r102.getCode();
        if (r108 != null) goto L10;
        r108 = "";
    L10:
        String r109 = r102.getLanguage();
        if (r109 != null) goto L13;
        r109 = "c";
    L13:
        r107.b(r108, r109);
    L14:
        DefaultMarkdownCodeView r110 = this.f320650a;
        if (r110 == null) goto L17;
        r110.measure(0, 0);
    L17:
        DefaultMarkdownCodeView r111 = this.f320650a;
        if (r111 == null) goto L21;
        r106 = r111.getMeasuredHeight();
    L21:
        return new Size(r104, r106);
    }
}
