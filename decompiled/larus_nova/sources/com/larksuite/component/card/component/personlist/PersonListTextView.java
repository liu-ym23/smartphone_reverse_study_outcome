package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", SlcElement.KEY_ATTR, "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "scrollTo", "", "x", "", "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonListTextView extends AppCompatTextView {
    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
    }

    public PersonListTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        TraceEvent.beginSection("PersonListTextView.onDraw");
        super.onDraw(r100);
        TraceEvent.endSection("PersonListTextView.onDraw");
    }

    public PersonListTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TextPaint r102 = getPaint();
        g.f283510a.getClass();
        r102.setTextSize(g.h(null));
        getPaint().setColor(UIHelper.getColor(R.color.text_placeholder));
        getPaint().setAntiAlias(true);
        setHighlightColor(0);
        if (com.larksuite.component.card.component.e.f283366b != null) goto L5;
        com.larksuite.component.card.component.e.f283366b = new com.larksuite.component.card.component.e();
    L5:
        setMovementMethod(com.larksuite.component.card.component.e.f283366b);
    }
}
