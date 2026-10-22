package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000f\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "Lcom/larus/business/markdown/impl/markwon/UnderlineTextView;", "Low8/a;", "Llw8/l;", "content", "", "setMarkdown", "", "getSelectedColor", "d", "I", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markdownWidth", "getMarkdownContent", "()Llw8/l;", "markdownContent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class MarkdownTextView extends UnderlineTextView implements ow8.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f320553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MarkwonContent f320554e;

    public MarkdownTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MarkdownTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // ow8.a
    public int getSelectedColor() {
        return 1719254015;
    }

    @Override // ow8.a
    public final TextView o() {
        return this;
    }

    @Override // ow8.a
    public final boolean q(int r100, int r101) {
        return false;
    }

    @Override // ow8.a
    public lw8.l getMarkdownContent() {
        return this.f320554e;
    }

    @Override // ow8.a
    public int getMarkdownWidth() {
        return this.f320553d;
    }

    public void setMarkdown(lw8.l r100) {
        if (r100 == null) goto L11;
        if ((r100 instanceof MarkwonContent) == true) goto L11;
        com.larus.business.markdown.api.depend.d r101 = IMarkdownLoggerKt.a();
        if (r101 == null) goto L13;
        r101.e("mark_down", "unsupport markdown: " + r100);
    L13:
        MarkwonContent r102 = null;
    L14:
        this.f320554e = r102;
        if (r102 == null) goto L25;
        SpannableStringBuilder r103 = r102.f320556a;
        if (r103 == null) goto L28;
        lw8.h r104 = r102.f320561f;
        if (r104 == null) goto L26;
        lsc.i r105 = r104.a();
        if (r105 == null) goto L27;
        r105.d(this, r103, null);
        return;
    L27:
        return;
    L26:
        return;
    L28:
        return;
    L25:
        return;
    L11:
        if ((r100 instanceof MarkwonContent) == false) goto L13;
        r102 = (MarkwonContent) r100;
        goto L14
    }

    public void setMarkdownWidth(int r100) {
        this.f320553d = r100;
    }

    public MarkdownTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ MarkdownTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
