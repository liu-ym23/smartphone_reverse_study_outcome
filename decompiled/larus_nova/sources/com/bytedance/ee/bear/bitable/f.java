package com.bytedance.ee.bear.bitable;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f211120a;

    public final Context getContext() {
        return this.f211120a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f211120a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L5;
        r100.setColor(ContextCompat.getColor(this.f211120a, R.color.text_caption));
        return;
    }
}
