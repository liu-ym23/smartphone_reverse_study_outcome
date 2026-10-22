package com.bytedance.ee.bear.bitable;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class p extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f214801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f214802b;

    public final Context getContext() {
        return this.f214801a;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f214802b.invoke(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(ContextCompat.getColor(this.f214801a, R.color.primary_fill_default));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(Context r100, Function1<? super View, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "click");
        this.f214801a = r100;
        this.f214802b = r101;
    }
}
