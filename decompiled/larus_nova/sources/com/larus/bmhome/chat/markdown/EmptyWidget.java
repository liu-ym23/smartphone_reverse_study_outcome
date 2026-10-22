package com.larus.bmhome.chat.markdown;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ>\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0000H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/markdown/EmptyWidget;", "Landroid/view/View;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "size", "Landroid/util/Size;", "bindData", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", WsConstants.KEY_PAYLOAD, "", "", "", "asView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyWidget extends View implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Size f306923a;

    public EmptyWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public EmptyWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final View asView() {
        return this;
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final void f() {
    }

    public EmptyWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f306923a = new Size(0, 0);
    }

    public /* synthetic */ EmptyWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // usc.f
    public final Size d(TextView r100, Spanned r101, e r102, int r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "span");
        return this.f306923a;
    }
}
